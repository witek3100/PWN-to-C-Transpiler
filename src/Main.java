import antlr.PWNLexer;
import antlr.PWNParser;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.RoundRectangle2D;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;

public class Main implements ActionListener {

    JFileChooser fc;
    JButton loadFileButton, transpileButton;
    JFrame mainFrame;
    JTextArea pwnInputArea, cOutputArea, errorArea;
    JScrollPane scrollPane1, scrollPane2, scrollPane3;

    public static void main(String[] args) {
        new Main();
    }

    public Main() {

        fc = new JFileChooser(new File("examples"));
        fc.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);

        loadFileButton = new JButton("Load pwn file");
        loadFileButton.addActionListener(this);

        transpileButton = new JButton("Transpile");
        transpileButton.addActionListener(this);

        EventQueue.invokeLater(() -> {
            try {
                UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
            }

            mainFrame = new JFrame("Transpiler PWN to C");
            mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            mainFrame.setLayout(new BorderLayout());
            mainFrame.setPreferredSize(new Dimension(1300, 1000));
            mainFrame.add(new Gui());
            mainFrame.pack();
            mainFrame.setLocationRelativeTo(null);
            mainFrame.setVisible(true);
        });
    }

    public class Gui extends JPanel {

        public Gui() {
            setLayout(new GridBagLayout());
            GridBagConstraints gbc = new GridBagConstraints();

            gbc.gridx = 0;
            gbc.gridy = 0;
            gbc.insets = new Insets(2, 2, 2, 2);

            gbc.gridy++;
            add(new JLabel("PWN"), gbc);
            gbc.gridx++;
            add(new JLabel("C"), gbc);

            gbc.gridx = 0;
            gbc.gridy++;
            gbc.fill = GridBagConstraints.HORIZONTAL;
            pwnInputArea = new JTextArea("Put your PWN code here");
            pwnInputArea.setMinimumSize(new Dimension(600, 3000));
            pwnInputArea.setBounds(0, 0, 600, 3000);
            pwnInputArea.setLineWrap(true);
            pwnInputArea.setBorder(new RoundBorder(20));
            pwnInputArea.setWrapStyleWord(true);
            pwnInputArea.setFont(new Font("Consolas", Font.PLAIN, 14));
            scrollPane1 = new JScrollPane(pwnInputArea);
            scrollPane1.setViewportView(pwnInputArea);
            scrollPane1.setPreferredSize(new Dimension(600, 600));
            scrollPane1.setMinimumSize(new Dimension(600, 600));
            scrollPane1.setBounds(0, 0, 600, 600);
            add(scrollPane1, gbc);

            gbc.gridx++;
            cOutputArea= new JTextArea("C output will be shown here");
            cOutputArea.setMinimumSize(new Dimension(600, 3000));
            cOutputArea.setBounds(0, 0, 600, 3000);
            cOutputArea.setEditable(false);
            cOutputArea.setBorder(new RoundBorder(20));
            cOutputArea.setFont(new Font("Consolas", Font.PLAIN, 14));
            scrollPane2 = new JScrollPane(cOutputArea);
            scrollPane2.setViewportView(cOutputArea);
            scrollPane2.setPreferredSize(new Dimension(620, 600));
            scrollPane2.setMinimumSize(new Dimension(620, 600));
            scrollPane2.setBounds(0, 0, 620, 600);
            add(scrollPane2, gbc);

            gbc.gridx = 0;
            gbc.gridy++;
            gbc.fill = GridBagConstraints.NONE;
            gbc.gridwidth = 2;

            errorArea = new JTextArea("Errors will be shown here",8, 40);
            errorArea.setBorder(new RoundBorder(20));
            errorArea.setPreferredSize(new Dimension(800, 200));
            errorArea.setMinimumSize(new Dimension(800, 200));
            errorArea.setBounds(0, 0, 800, 200);
            scrollPane3 = new JScrollPane(errorArea);
            scrollPane3.setViewportView(errorArea);
            scrollPane3.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
            errorArea.setEditable(false);
            errorArea.setFont(new Font("Consolas", Font.PLAIN, 12));
            add(errorArea, gbc);

            gbc.gridy++;
            add(loadFileButton, gbc);

            gbc.gridy++;
            add(transpileButton, gbc);
        }

        public class RoundBorder implements Border {

            private int radius;

            public RoundBorder(int radius) {
                this.radius = radius;
            }

            public int getRadius() {
                return radius;
            }

            @Override
            public void paintBorder(Component c, Graphics g, int x, int y, int width, int height) {
                Graphics2D g2d = (Graphics2D) g.create();
                g2d.draw(new RoundRectangle2D.Double(x, y, width - 1, height - 1, getRadius(), getRadius()));
                g2d.dispose();
            }

            @Override
            public Insets getBorderInsets(Component c) {
                int value = getRadius() / 2;
                return new Insets(value, value, value, value);
            }

            @Override
            public boolean isBorderOpaque() {
                return false;
            }

        }

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == loadFileButton) {
            int returnVal = fc.showOpenDialog(this.mainFrame);
            if (returnVal == JFileChooser.APPROVE_OPTION) {
                File file = fc.getSelectedFile();
                try {
                    pwnInputArea.setText(Files.readString(Path.of(file.getAbsolutePath())));
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
            }
            pwnInputArea.setCaretPosition(pwnInputArea.getDocument().getLength());
        }
        else if (e.getSource() == transpileButton) {
            PWNParser parser;
            try {
                parser = getParser(pwnInputArea.getText());
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }

            ParseTree tree = parser.program();
            if (!PWNErrorListener.errors.isEmpty()) {
                errorArea.setText(String.join("\n", PWNErrorListener.errors));
                cOutputArea.setText("C output will be shown here");
                PWNErrorListener.errors = new ArrayList<>();
                return;
            }
            PWNConverter converter = new PWNConverter();

            String result = converter.visit(tree);
            if (!converter.errors.isEmpty()) {
                errorArea.setText(String.join("\n", converter.errors));
                cOutputArea.setText("C output will be shown here");
                return;
            }

            cOutputArea.setText(result);
            errorArea.setText("Errors will be shown here");
        }
    }

    private static PWNParser getParser(String pwnInput) throws IOException {
        CharStream input = CharStreams.fromString(pwnInput);
        PWNLexer lexer = new PWNLexer(input);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        PWNParser parser = new PWNParser(tokens);
        parser.removeErrorListeners();
        parser.addErrorListener(new PWNErrorListener());
        return parser;
    }
}

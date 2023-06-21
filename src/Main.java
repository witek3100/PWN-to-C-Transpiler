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
            mainFrame.setPreferredSize(new Dimension(1300, 900));
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
            pwnInputArea.setPreferredSize(new Dimension(500, 600));
            pwnInputArea.setMinimumSize(new Dimension(500, 600));
            pwnInputArea.setBounds(0, 0, 500, 600);
            scrollPane1 = new JScrollPane(pwnInputArea);
            scrollPane1.setViewportView(pwnInputArea);
            scrollPane1.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
            pwnInputArea.setLineWrap(true);
            pwnInputArea.setBorder(new RoundBorder(20));
            pwnInputArea.setWrapStyleWord(true);
            pwnInputArea.setFont(new Font("Arial Black", Font.PLAIN, 18));
            add(pwnInputArea, gbc);

            gbc.gridx++;
            cOutputArea= new JTextArea("C output will be shown here",30, 40);
            cOutputArea.setPreferredSize(new Dimension(500, 600));
            cOutputArea.setMinimumSize(new Dimension(500, 600));
            cOutputArea.setBounds(0, 0, 500, 600);
            scrollPane2 = new JScrollPane(cOutputArea);
            scrollPane2.setViewportView(cOutputArea);
            scrollPane2.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
            cOutputArea.setEditable(false);
            cOutputArea.setBorder(new RoundBorder(20));
            cOutputArea.setFont(new Font("Arial Black", Font.PLAIN, 18));
            add(cOutputArea, gbc);

            gbc.gridx = 0;
            gbc.gridy++;
            gbc.fill = GridBagConstraints.NONE;
            gbc.gridwidth = 2;

            errorArea = new JTextArea("...",5, 40);
            errorArea.setBorder(new RoundBorder(20));
            errorArea.setPreferredSize(new Dimension(500, 150));
            errorArea.setMinimumSize(new Dimension(500, 150));
            errorArea.setBounds(0, 0, 500, 150);
            scrollPane3 = new JScrollPane(errorArea);
            scrollPane3.setViewportView(errorArea);
            scrollPane3.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
            errorArea.setEditable(false);
            errorArea.setFont(new Font("Arial Black", Font.PLAIN, 16));
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
            PWNParser parser = null;
            try {
                parser = getParser(pwnInputArea.getText());
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
            ParseTree tree = parser.program();
            PWNConverter converter = new PWNConverter();
            try {
                String result = converter.visit(tree);
                cOutputArea.setText(result);
                errorArea.setText("...");
            }
            catch (Exception ex) {
                errorArea.setText("its not PWN code");
            }
        }
    }

    private static PWNParser getParser(String pwnInput) throws IOException {
        CharStream input = CharStreams.fromString(pwnInput);
        PWNLexer lexer = new PWNLexer(input);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        return new PWNParser(tokens);
    }
}

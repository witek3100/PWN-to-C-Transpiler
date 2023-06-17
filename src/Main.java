import antlr.PWNLexer;
import antlr.PWNParser;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class Main implements ActionListener {

    JFileChooser fc;
    JButton loadFileButton, transpileButton;
    JFrame mainFrame;
    JTextArea pwnInputArea, cOutputArea;


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
            mainFrame.add(new Gui());
            mainFrame.pack();
            mainFrame.setLocationRelativeTo(null);
            mainFrame.setVisible(true);
            mainFrame.setResizable(false);
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
            pwnInputArea = new JTextArea("Put your PWN code here",30, 40);
            pwnInputArea.setLineWrap(true);
            pwnInputArea.setWrapStyleWord(true);
            add(pwnInputArea, gbc);

            gbc.gridx++;
            cOutputArea= new JTextArea("C output will be shown here",30, 40);
            cOutputArea.setEditable(false);
            add(cOutputArea, gbc);

            gbc.gridx = 0;
            gbc.gridy++;
            gbc.fill = GridBagConstraints.NONE;
            gbc.gridwidth = 2;

            add(loadFileButton, gbc);
            gbc.gridy++;
            add(transpileButton, gbc);

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
            }
            catch (Exception ex) {
                cOutputArea.setText("its not PWN code");
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

import javax.swing.*;
import java.awt.*;

public class Gui {

    public Gui() {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
                }

                JFrame frame = new JFrame("Transpiler PWN to C");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setLayout(new BorderLayout());
                frame.add(new GuiPane());
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
                frame.setResizable(false);
            }
        });
    }

    public class GuiPane extends JPanel {

        public GuiPane() {
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
            add(new JTextArea("Put your PWN code here",20, 30), gbc);
            gbc.gridx++;
            add(new JTextArea("C output will be shown here",20, 30), gbc);

            gbc.gridx = 0;
            gbc.gridy++;
            gbc.fill = GridBagConstraints.NONE;
            gbc.gridwidth = 2;

            add(new JButton("Load file"), gbc);
            gbc.gridy++;
            add(new JButton("TRANSPILE"), gbc);

        }

    }

}

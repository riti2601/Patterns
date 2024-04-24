import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.*;

public class PatternGenerator extends JFrame implements ActionListener {
    private JPanel main;
    private JButton butterflyButton;

    public PatternGenerator() {
        setTitle("PatternGenerator");
        setSize(800, 800);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        main = new JPanel();
        main.setLayout(null); // Set layout to null for manual component placement

        butterflyButton = new JButton("Butterfly Pattern");
        butterflyButton.addActionListener(this);
        butterflyButton.setBounds(10, 10, 150, 30); // Set button position and size

        main.add(butterflyButton);

        setContentPane(main);
    }

    public void actionPerformed(ActionEvent e) {
        String patternType = e.getActionCommand();
        if (patternType.equals("Butterfly Pattern")) {
            displayButterflyPattern();
        }
    }

    private void displayButterflyPattern() {
        int n = 5;
        int space = 20;
        int startX = 100;
        int startY = 100;

        Graphics g = main.getGraphics(); // Get graphics context of the main panel

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                g.drawString("x", startX + (j - 1) * space, startY + (i - 1) * space);
            }
            for (int j = 1; j <= space; j++) {
                g.drawString(" ", startX + (i - 1) * space + j * space, startY + (i - 1) * space);
            }
            for (int j = 1; j <= i; j++) {
                g.drawString("x", startX + (i - 1) * space + space + (j - 1) * space, startY + (i - 1) * space);
            }
            startY += space;
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new PatternGenerator();
            }
        });
    }
}

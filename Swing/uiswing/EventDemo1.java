package uiswing;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class EventDemo1 extends JFrame implements ActionListener {
    public EventDemo1() {
        setLayout(new FlowLayout());
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        JButton button = new JButton("Click Me!");
        JButton button2 = new JButton("Do not click Me!");
        button.addActionListener(this);
        button2.addActionListener(this);
        getContentPane().add(button);
        getContentPane().add(button2);

        pack();
    }

    public void actionPerformed(ActionEvent e) {
        JButton button = (JButton) e.getSource();
        JOptionPane.showMessageDialog(this, "Clicked " + button.getText() + "!");
    }

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new EventDemo1().setVisible(true);
            }
        });
    }
}

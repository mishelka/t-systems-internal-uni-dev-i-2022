package uiswing;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class EventDemo2 extends JFrame {
    public EventDemo2() {
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        
        JButton button = new JButton("Click Me!");
        button.addActionListener(new Action());
        getContentPane().add(button);
        
        pack();
    }
    
    private class Action implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            JOptionPane.showMessageDialog(EventDemo2.this, "Clicked!");
        }
    }
    
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new EventDemo2().setVisible(true);
            }
        });
    }
}

package uiswing;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class ClickTest extends JPanel implements MouseListener {
    private Point p;

    public ClickTest() {
        addMouseListener(this);
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.red);
        if (p != null) {
            g.fillOval(p.x - 10, p.y - 10, 20, 20);
        }
    }

    public void mouseReleased(MouseEvent e) {
        p = new Point(e.getX(), e.getY());
        repaint();
    }

    public void mouseExited(MouseEvent e) {
    }

    public void mousePressed(MouseEvent e) {
    }

    public void mouseClicked(MouseEvent e) {
    }

    public void mouseEntered(MouseEvent e) {
    }

    public static void main(String[] args) {
        final JFrame frame = new JFrame("Click me");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(200, 200);
        frame.getContentPane().add(new ClickTest());

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                frame.setVisible(true);
            }
        });
    }
}

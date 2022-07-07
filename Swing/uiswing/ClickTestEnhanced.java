package uiswing;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.util.LinkedList;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class ClickTestEnhanced extends JPanel implements MouseMotionListener {
    private static final int MAX_POINTS = 250;

    private List<Point> points = new LinkedList<Point>();

    public ClickTestEnhanced() {
        addMouseMotionListener(this);
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.red);
        for (Point point : points) {
            g.fillOval(point.x - 10, point.y - 10, 20, 20);
        }
    }

    public void mouseDragged(MouseEvent e) {
    }

    public void mouseMoved(MouseEvent e) {
        points.add(e.getPoint());

        if (points.size() >= MAX_POINTS) {
            points.remove(0);
        }
        repaint();
    }

    public static void main(String[] args) {
        final JFrame frame = new JFrame("Click me");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 400);
        frame.getContentPane().add(new ClickTestEnhanced());

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                frame.setVisible(true);
            }
        });
    }
}

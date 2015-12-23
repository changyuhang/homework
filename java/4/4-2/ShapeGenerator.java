package ntou.cs.java2015.yuhang;

import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class ShapeGenerator{
    public ShapeGenerator(){
        final int WINDOW_WIDTH = 300, WINDOW_HEIGHT = 300;
        JFrame frame = new JFrame();
        DrawPanel panel = new DrawPanel();
        JLabel southLabel = new JLabel(panel.status());
        frame.setLocation(300, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(panel);
        frame.setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        frame.setVisible(true);
        frame.add(southLabel, BorderLayout.SOUTH);
    }

    public static void main(String[] args) {
        new ShapeGenerator();
    }
}

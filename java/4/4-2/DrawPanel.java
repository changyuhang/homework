package ntou.cs.java2015.yuhang;

import java.awt.Color;
import java.awt.Graphics;
import static java.lang.Integer.parseInt;
import java.util.Random;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

class variable{
    int x1,y1,x2,y2;
    Color color;
}

public class DrawPanel extends JPanel{
    private final Random randomNumbers = new Random();
    private final MyLine lines[];
    private final MyOval ovals[];
    private final MyRectangle rectangles[];
    private final int UserNumber;

    private void rand(variable v){
        v.x1 = randomNumbers.nextInt(300);
        v.y1 = randomNumbers.nextInt(300);
        v.x2 = randomNumbers.nextInt(300);
        v.y2 = randomNumbers.nextInt(300);
        v.color = new Color(randomNumbers.nextInt(256),
                randomNumbers.nextInt(256), randomNumbers.nextInt(256));
    }

    public DrawPanel() {
        setBackground(Color.WHITE);
        UserNumber = parseInt(JOptionPane.showInputDialog("請輸入數字："));
        boolean flag = true;
        int[] blackBox = new int[3];
        int sum = 0;
        while (flag) {
            for (int i = 0; i < blackBox.length; i++) {
                blackBox[i] = randomNumbers.nextInt(UserNumber / 2);
                sum += blackBox[i];
            }
            if (sum == UserNumber)
                flag = false;
            sum = 0;
        }
        lines = new MyLine[blackBox[0]];
        ovals = new MyOval[blackBox[1]];
        rectangles = new MyRectangle[blackBox[2]];
        variable v=new variable();
        for (int count = 0; count < lines.length; count++) {
            rand(v);
            lines[count] = new MyLine(v.x1, v.y1, v.x2, v.y2, v.color);
        }
        for (int count = 0; count < ovals.length; count++) {
            rand(v);
            boolean filled = randomNumbers.nextBoolean();
            ovals[count] = new MyOval(v.x1, v.y1, v.x2, v.y2, v.color, filled);
        }
        for (int count = 0; count < rectangles.length; count++) {
            rand(v);
            boolean filled = randomNumbers.nextBoolean();
            rectangles[count] = new MyRectangle(v.x1, v.y1, v.x2, v.y2, v.color, filled);
        }
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        for (MyLine line : lines)
            line.draw(g);
        for (MyOval oval : ovals)
            oval.draw(g);
        for (MyRectangle rectangle : rectangles)
            rectangle.draw(g);
    }

    public String status() {
        return String.format("%s: %d, %s: %d, %s:%d", "lines", lines.length, "ovals", ovals.length, "rectangles", rectangles.length);
    }
}

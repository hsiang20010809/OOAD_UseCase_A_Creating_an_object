import java.awt.Graphics;
import java.awt.Color;

class Oval extends Shape {
    private static final int WIDTH = 100;
    private static final int HEIGHT = 50;

    public Oval(int x, int y) {
        super(x, y, 5);
    }

    @Override
    public void draw(Graphics g, boolean isSelected) {
        // 設定填充顏色為灰色
        g.setColor(Color.GRAY);
        g.fillOval(x, y, WIDTH, HEIGHT);

        // 如果被選取，繪製紅色邊框
        if (isSelected) {
            g.setColor(Color.RED);
            g.drawOval(x, y, WIDTH, HEIGHT);
        }
    }

    @Override
    public boolean contains(int mouseX, int mouseY) {
        double dx = mouseX - (x + WIDTH / 2.0);
        double dy = mouseY - (y + HEIGHT / 2.0);
        return (dx * dx) / (WIDTH * WIDTH / 4.0) + (dy * dy) / (HEIGHT * HEIGHT / 4.0) <= 1.0;
    }
}

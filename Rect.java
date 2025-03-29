import java.awt.Graphics;
import java.awt.Color;

class Rect extends Shape {
    private static final int WIDTH = 100;
    private static final int HEIGHT = 50;

    public Rect(int x, int y) {
        super(x, y, 10); // 設定深度為 10
    }

    @Override
    public void draw(Graphics g, boolean isSelected) {
        g.setColor(Color.GRAY);
        g.fillRect(x, y, WIDTH, HEIGHT);

        if (isSelected) {
            g.setColor(Color.RED);
            g.drawRect(x, y, WIDTH, HEIGHT);
        }
    }

    @Override
    public boolean contains(int mouseX, int mouseY) {
        return mouseX >= x && mouseX <= x + WIDTH && mouseY >= y && mouseY <= y + HEIGHT;
    }
}

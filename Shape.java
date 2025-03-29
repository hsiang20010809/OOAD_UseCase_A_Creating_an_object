import java.awt.Graphics;

abstract class Shape {
    protected int x, y;
    protected int depth; // 深度屬性

    public Shape(int x, int y, int depth) {
        this.x = x;
        this.y = y;
        this.depth = depth;
    }

    public int getDepth() {
        return depth;
    }

    public abstract void draw(Graphics g, boolean isSelected);

    public abstract boolean contains(int mouseX, int mouseY); // 檢查是否點擊到物件
}

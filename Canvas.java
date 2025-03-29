import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

class Canvas extends JPanel {
    private List<Shape> shapes = new ArrayList<>();
    private Shape selectedShape = null;

    public void addShape(Shape shape) {
        shapes.add(shape);
        shapes.sort((s1, s2) -> Integer.compare(s2.getDepth(), s1.getDepth())); // 深度排序（從高到低）
        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        for (Shape shape : shapes) {
            shape.draw(g, shape == selectedShape);
        }
    }

    public void selectShapeAt(int x, int y) {
        selectedShape = null;
        // 根據深度從淺到深檢查（倒序檢查列表）
        for (int i = shapes.size() - 1; i >= 0; i--) {
            Shape shape = shapes.get(i);
            if (shape.contains(x, y)) {
                selectedShape = shape; // 選取最上層的物件
                break; // 找到後立即停止檢查
            }
        }
        repaint();
    }
}

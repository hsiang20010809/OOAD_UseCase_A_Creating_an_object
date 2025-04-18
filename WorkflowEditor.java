import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class WorkflowEditor {
    private Canvas canvas;
    private Mode mode;
    private JButton rectButton;
    private JButton ovalButton;

    public WorkflowEditor() {
        // 初始化畫布與模式
        canvas = new Canvas();
        mode = Mode.SELECT;

        // 建立視窗
        JFrame frame = new JFrame("Workflow Editor");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 600);
        frame.setLayout(new BorderLayout());

        // 加入畫布
        frame.add(canvas, BorderLayout.CENTER);

        // 加入工具列
        JPanel toolbar = new JPanel();
        rectButton = new JButton("Rect");
        ovalButton = new JButton("Oval");
        JButton selectButton = new JButton("Select");

        toolbar.add(rectButton);
        toolbar.add(ovalButton);
        toolbar.add(selectButton);
        frame.add(toolbar, BorderLayout.NORTH);

        // 設定按鈕事件
        rectButton.addActionListener(e -> {
            mode = Mode.RECT;
            updateButtonColors();
            System.out.println("Mode switched to: RECT");
        });

        ovalButton.addActionListener(e -> {
            mode = Mode.OVAL;
            updateButtonColors();
            System.out.println("Mode switched to: OVAL");
        });

        selectButton.addActionListener(e -> {
            mode = Mode.SELECT;
            updateButtonColors();
            System.out.println("Mode switched to: SELECT");
        });

        // 設定滑鼠事件
        canvas.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                if (mode == Mode.RECT) {
                    canvas.addShape(new Rect(e.getX(), e.getY()));
                } else if (mode == Mode.OVAL) {
                    canvas.addShape(new Oval(e.getX(), e.getY()));
                } else if (mode == Mode.SELECT) {
                    canvas.selectShapeAt(e.getX(), e.getY());
                }
            }
        });
        

        // 顯示視窗
        frame.setVisible(true);
    }

    // 更新按鈕顏色，顯示當前模式
    private void updateButtonColors() {
        rectButton.setBackground(mode == Mode.RECT ? Color.BLACK : null);
        rectButton.setForeground(mode == Mode.RECT ? Color.WHITE : Color.BLACK);

        ovalButton.setBackground(mode == Mode.OVAL ? Color.BLACK : null);
        ovalButton.setForeground(mode == Mode.OVAL ? Color.WHITE : Color.BLACK);
    }

    public static void main(String[] args) {
        new WorkflowEditor();
    }
}

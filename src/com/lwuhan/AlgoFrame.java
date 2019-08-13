package com.lwuhan;

import javax.swing.*;
import java.awt.*;


/**
 * @Auther: wuhan
 * @Date: 2019/8/1 23:58
 * @Description: 视图层，负责显示的逻辑
 */
public class AlgoFrame extends JFrame {
    private int canvasWidth;
    private int canvasHeight;
    public int getCanvasWidth() {return canvasWidth;}
    public int getCanvasHeight() {return canvasHeight;}

    public AlgoFrame(String title, int canvasWidth, int canvasHeight){
        super(title); // 调用父类的构造函数


        this.canvasWidth = canvasWidth;
        this.canvasHeight = canvasHeight;

        AlgoCanvas canvas = new AlgoCanvas();
//        canvas.setPreferredSize(new Dimension(canvasWidth,canvasHeight));
        setContentPane(canvas); //设置内容面板
        pack(); // AlogFrame的大小根据canvas的大小自动调整

        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);

    }

    public AlgoFrame(String title){
        this(title, 1024, 768);
    }

    private Circle[] circles;
    public void render(Circle[] circles){
        this.circles = circles;
        repaint(); //将所有空间重新刷新一遍
    }

    private class AlgoCanvas extends JPanel{

        public AlgoCanvas(){
            super(true); //打开双缓存
        }

        @Override
        public void paintComponent(Graphics g){
            super.paintComponent(g);
            Graphics2D g2d = (Graphics2D)g;

            //抗锯齿
            RenderingHints hints = new RenderingHints(
                                            RenderingHints.KEY_ANTIALIASING,
                                            RenderingHints.VALUE_ANTIALIAS_ON);
            g2d.addRenderingHints(hints);



            // 具体绘制
            AlgoVisHelper.setStrokeWidth(g2d,1);
            AlgoVisHelper.setColor(g2d, Color.RED);
            for (Circle circle: circles){
                AlgoVisHelper.strokeCircle(g2d, circle.x,circle.y,circle.getR());
            }

        }

        @Override
        public Dimension getPreferredSize(){
            return new Dimension(canvasWidth, canvasHeight);
        }
    }

}

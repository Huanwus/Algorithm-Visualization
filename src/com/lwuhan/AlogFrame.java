package com.lwuhan;

import javax.annotation.Resource;
import javax.swing.*;
import java.awt.*;

/**
 * @Auther: wuhan
 * @Date: 2019/8/1 23:58
 * @Description:
 */
public class AlogFrame extends JFrame {
    private int canvasWidth;
    private int canvasHeight;


    public AlogFrame(String title, int canvasWidth, int canvasHeight){
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

    public AlogFrame (String title){
        this(title, 1024, 768);
    }
    public int getCanvasWidth() {return canvasWidth;}
    public int getCanvasHeight() {return canvasHeight;}

    private class AlgoCanvas extends JPanel{

        @Override
        public void paintComponent(Graphics g){
            super.paintComponent(g);
            g.drawOval(50,50,300,300);
        }

        @Override
        public Dimension getPreferredSize(){
            return new Dimension(canvasWidth, canvasHeight);
        }
    }

}

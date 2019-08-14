package com.lwuhan;

import java.awt.*;
import java.awt.event.*;

/**
 * @Auther: wuhan
 * @Date: 2019/8/13 23:38
 * @Description: MVC中的控制层,控制数据与视图
 */
public class AlgoVisualizer {
    private Circle[] circles;
    private AlgoFrame frame;
    private boolean isAnimated = true;

    public AlgoVisualizer( int sceneWidth, int sceneHeight, int N ){

        //初始化数据
        circles = new Circle[N];
        int R = 50;
        for (int i = 0; i< N;i++){
            int x = (int)(Math.random()*(sceneWidth - 2*R)) + R;
            int y = (int)(Math.random()*(sceneHeight - 2*R)) + R;
            int vx = (int)(Math.random()*11) - 5;
            int vy = (int)(Math.random()*11) - 5;
            circles[i] = new Circle(x,y,R,vx,vy);

        }

        // 初始化视图；事件队列, 应该快速完成
        EventQueue.invokeLater(() -> {
            frame = new AlgoFrame("Welcome",sceneWidth,sceneHeight);
            frame.addKeyListener(new AlgoKeyListener());
            frame.addMouseListener(new AlgoMouseListener());
            new Thread(() -> {
                run();
            }).start();


//            AlgoFrame frame = new AlgoFrame("welcome");
        });
    }


    private void run(){
        while (true){
            //绘制数据
            frame.render(circles);
            AlgoVisHelper.pause(20);
            //更新数据
            if(isAnimated){
                for (Circle circle: circles){
                    circle.move(0,0,frame.getCanvasWidth(),frame.getCanvasHeight());
                }
            }
        }
    }
    /**
     *
     * 功能描述: 内部类，监听空格，按下空格动画暂停
     *
     * @param:
     * @return:
     * @auther: wuhan
     * @date: 2019/8/13 下午11:49
     */
    private class AlgoKeyListener extends KeyAdapter {
        @Override
        public void keyReleased(KeyEvent event){
            if(event.getKeyChar() == ' '){
                isAnimated = !isAnimated;
            }
        }
    }

    private class AlgoMouseListener extends MouseAdapter{
        @Override
        public void mousePressed(MouseEvent event){
            // 对点击的点的坐标要进行移动， 因为frame把上面的bar计算在内了
            event.translatePoint(0,
                    -(frame.getBounds().height - frame.getCanvasHeight()));

//            System.out.println(event.getPoint());
            for (Circle circle: circles){
                if(circle.contain(event.getPoint()))
                    circle.isFilled = !circle.isFilled;
            }

        }
    }

    public static void main(String[] args) {
        int sceneWidth = 800;
        int sceneHeight = 800;
        int N = 20;
        AlgoVisualizer visualizer = new AlgoVisualizer(sceneWidth,sceneHeight, N);
    }
}

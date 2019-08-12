package com.lwuhan;

import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.util.TreeSet;

/**
 * @Auther: wuhan
 * @Date: 2019/8/11 23:42
 * @Description:
 */
public class AlgoVisHelper {

        private AlgoVisHelper(){} //不被实例化

        public static void setStrokeWidth(Graphics2D g2d, int w){
            int strokeWidth = w;
            g2d.setStroke(new BasicStroke(strokeWidth, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND));

        }

        public static void strokeCircle( Graphics2D g2d,int x, int y, int r){
            Ellipse2D cirle = new Ellipse2D.Double(x-r, y-r,2*r,2*r);
            g2d.draw(cirle);
        }
        public static void fillCircle( Graphics2D g2d,int x, int y, int r){
            Ellipse2D cirle = new Ellipse2D.Double(x-r, y-r,2*r,2*r);
            g2d.fill(cirle);
        }

        public static void setColor(Graphics2D g2d, Color color){
            g2d.setColor(color);
        }

        public static void pause(int t){
            try {
                Thread.sleep(t);
            }
            catch (InterruptedException e){
                System.out.println("Error in sleeping");
            }
        }
}

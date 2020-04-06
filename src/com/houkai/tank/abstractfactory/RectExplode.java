package com.houkai.tank.abstractfactory;

import com.houkai.tank.ResourceMgr;
import com.houkai.tank.TankFrame;

import java.awt.*;

public class RectExplode  extends BaseExplode{
    private int x , y ;
    public static int WIDTH = ResourceMgr.explores[0].getWidth();
    public static int HEIGHT = ResourceMgr.explores[0].getHeight();

    private TankFrame tf ;
    private boolean living=true;
    private int step=0;
    public RectExplode(int x, int y, TankFrame tf) {
        this.x = x;
        this.y = y;
        this.tf = tf;
    }
    @Override
    public void paint(Graphics g) {

        /*g.drawImage(ResourceMgr.explores[step++],x,y,null);
        if (step>=ResourceMgr.explores.length)
            tf.explodes.remove(this);*/
        Color c=g.getColor();
        g.setColor(Color.RED);
        g.fillRect(x,y,10*step, 10*step);
        step++;
        if (step>=15)
            tf.explodes.remove(this);
        g.setColor(c);
    }
}

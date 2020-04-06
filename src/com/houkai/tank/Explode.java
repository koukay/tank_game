package com.houkai.tank;

import com.houkai.tank.abstractfactory.BaseExplode;

import java.awt.*;
import java.util.Random;

/**
 * @author houkai
 *创建坦克类,控制坦克方向及移动速度速度
 */
public class Explode extends BaseExplode {
	private int x , y ;
	public static int WIDTH = ResourceMgr.explores[0].getWidth();
	public static int HEIGHT = ResourceMgr.explores[0].getHeight();

	private TankFrame tf ;
	private boolean living=true;
	private int step=0;
	public Explode(int x, int y, TankFrame tf) {
		this.x = x;
		this.y = y;
		this.tf = tf;
	}
	@Override
	public void paint(Graphics g) {

		g.drawImage(ResourceMgr.explores[step++],x,y,null);

		if (step>=ResourceMgr.explores.length)
			tf.explodes.remove(this);
	}

}

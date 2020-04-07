package com.houkai.tank;

import java.awt.*;

/**
 * @author houkai
 *创建坦克类,控制坦克方向及移动速度速度
 */
public class Explode {
	private int x , y ;
	public static int WIDTH = ResourceMgr.explores[0].getWidth();
	public static int HEIGHT = ResourceMgr.explores[0].getHeight();

	GameModel gm ;
	private boolean living=true;
	private int step=0;
	public Explode(int x, int y, GameModel gm ) {
		this.x = x;
		this.y = y;
		this.gm = gm;
	}

	public void paint(Graphics g) {

		g.drawImage(ResourceMgr.explores[step++],x,y,null);

		if (step>=ResourceMgr.explores.length)
			gm.explodes.remove(this);
	}

}

package com.houkai.tank;

import java.awt.*;

/**
 * @author houkai
 *创建坦克类,控制坦克方向及移动速度速度
 */
public class Explode extends  GameObject{
	private int x , y ;
	public static int WIDTH = ResourceMgr.explores[0].getWidth();
	public static int HEIGHT = ResourceMgr.explores[0].getHeight();

	private boolean living=true;
	private int step=0;
	public Explode(int x, int y) {
		this.x = x;
		this.y = y;
		new Thread(()->new Audio("audio/explode.wav").play()).start();
		System.out.println("--爆头--");
		GameModel.getInstance().add(this);
	}

	public void paint(Graphics g) {

		g.drawImage(ResourceMgr.explores[step++],x,y,null);

		if (step>=ResourceMgr.explores.length)
			GameModel.getInstance().remove(this);
	}

	@Override
	public int getWidth() {
		return WIDTH;
	}

	@Override
	public int getHeight() {
		return HEIGHT;
	}

}

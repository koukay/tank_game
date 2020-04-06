package com.houkai.tank;

public class Main {

	public static void main(String[] args) throws InterruptedException {
		TankFrame tf = new TankFrame();
		int initTankCount= Integer.parseInt(PropertyMgr.get("initTankCount").toString());
		//初始化敌方坦克
		for (int i = 0; i < initTankCount; i++) {
			tf.tanks.add(tf.gf.createTank(50+ i*80, 200, Dir.DOWN,Group.BAD,tf));
		}
//		new Thread(()->new Audio().loop()).start();
		new Thread(()->new Audio("audio/war1.wav").loop()).start();
		//在主线程每隔50毫秒刷新窗口,用repaint方法重新调用paint方法
		while (true) {
			Thread.sleep(50);
			tf.repaint();
		}
	}

}

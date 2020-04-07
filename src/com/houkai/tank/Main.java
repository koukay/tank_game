package com.houkai.tank;

public class Main {

	public static void main(String[] args) throws InterruptedException {
		TankFrame tf = new TankFrame();


		new Thread(()->new Audio("audio/war1.wav").loop()).start();
		//在主线程每隔50毫秒刷新窗口,用repaint方法重新调用paint方法
		while (true) {
			Thread.sleep(50);
			tf.repaint();
		}
	}

}

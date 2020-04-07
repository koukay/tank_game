package com.houkai.tank;

import java.awt.Color;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class TankFrame extends Frame {
	GameModel gm= new GameModel();
	private static final long serialVersionUID = 1L;


	static final int GAME_WIDTH=Integer.parseInt(PropertyMgr.get("gameWidth").toString())
			,GAME_HEIGHT=Integer.parseInt(PropertyMgr.get("gameHeight").toString());

	public TankFrame() {
		setSize(GAME_WIDTH, GAME_HEIGHT);
		setResizable(false);
		setTitle("tank war");
		setVisible(true);
		this.addKeyListener(new MyKeyListener());
		// 窗口监听
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
	}
	Image offScreenImage = null;
	/* 
	 * 解决闪烁问题
	 * 用双缓冲解决闪烁问题
	 */
	@Override
	public void update(Graphics g) {
		if (offScreenImage == null) {
			offScreenImage = this.createImage(GAME_WIDTH, GAME_HEIGHT);
		}
		Graphics gOffScreen = offScreenImage.getGraphics();
		Color c = gOffScreen.getColor();
		gOffScreen.setColor(Color.BLACK);
		gOffScreen.fillRect(0, 0, GAME_WIDTH, GAME_HEIGHT);
		gOffScreen.setColor(c);
		paint(gOffScreen);
		g.drawImage(offScreenImage, 0, 0, null);
	}
	@Override
	public void paint(Graphics g) {
		gm.paint(g);
//		e.paint(g);
	}

	/**
	 * @author houkai 键盘监听
	 */
	class MyKeyListener extends KeyAdapter {
		boolean bl = false;
		boolean bu = false;
		boolean br = false;
		boolean bd = false;
		boolean b_r_u = false;
		boolean b_r_d = false;
		boolean b_l_u = false;
		boolean b_l_d = false;

		/*
		 * 根据箭头的按键状态判断方向
		 */
		@Override
		public void keyPressed(KeyEvent e) {
			int key = e.getKeyCode();
			System.out.println(key);
			switch (key) {
			case KeyEvent.VK_LEFT:
				bl = true;
				break;
			case KeyEvent.VK_UP:
				bu = true;
				break;
			case KeyEvent.VK_RIGHT:
				br = true;
				break;
			case KeyEvent.VK_DOWN:
				bd = true;
				break;
			case KeyEvent.VK_NUMPAD9:
				b_r_u = true;
				break;
			case KeyEvent.VK_NUMPAD3:
				b_r_d = true;
				break;
			case KeyEvent.VK_NUMPAD7:
				b_l_u = true;
				break;
			case KeyEvent.VK_NUMPAD1:
				b_l_d = true;
				break;
			case KeyEvent.VK_SPACE:
				gm.getMainTank().fire();
				break;

			default:
				break;
			}
			setMainTankDir();
		}

		@Override
		public void keyReleased(KeyEvent e) {
			int key = e.getKeyCode();
			switch (key) {
			case KeyEvent.VK_LEFT:
				bl = false;
				break;
			case KeyEvent.VK_UP:
				bu = false;
				break;
			case KeyEvent.VK_RIGHT:
				br = false;
				break;
			case KeyEvent.VK_DOWN:
				bd = false;
				break;
			case KeyEvent.VK_NUMPAD9:
				b_r_u = false;
				break;
			case KeyEvent.VK_NUMPAD3:
				b_r_d = false;
				break;
			case KeyEvent.VK_NUMPAD7:
				b_l_u = false;
				break;
			case KeyEvent.VK_NUMPAD1:
				b_l_d = false;
				break;

			default:
				break;
			}
			setMainTankDir();
		}

		private void setMainTankDir() {
			if (!bl && !bu && !br && !bd && !b_r_u && !b_r_d && !b_l_u && !b_l_d)
				gm.getMainTank().setMoving(false);
			else {
				gm.getMainTank().setMoving(true);
			}
			if (bl)
				gm.getMainTank().setDir(Dir.LEFT);
			if (bu)
				gm.getMainTank().setDir(Dir.UP);
			if (br)
				gm.getMainTank().setDir(Dir.RIGHT);
			if (bd)
				gm.getMainTank().setDir(Dir.DOWN);
			if (b_r_u)
				gm.getMainTank().setDir(Dir.RIGHT_UP);
			if (b_r_d)
				gm.getMainTank().setDir(Dir.RIGHT_DOWN);
			if (b_l_u)
				gm.getMainTank().setDir(Dir.LEFT_UP);
			if (b_l_d)
				gm.getMainTank().setDir(Dir.LEFT_DOWN);
		}
	}
}

package com.houkai.tank;



import java.awt.*;
import java.util.Random;

/**
 * @author houkai
 *创建坦克类,控制坦克方向及移动速度速度
 */
public class Tank {
	public int x , y ;
	public Dir dir = Dir.DOWN;
	//从配置文件中取配置信息
	private static  int SPEED = Integer.parseInt(PropertyMgr.get("tankSpeed").toString());
//	private static final int SPEED = Integer.parseInt(PropertyMgr.get("tankSpeed").toString());

	public static int WIDTH = ResourceMgr.goodTankU.getWidth();
	public static int HEIGHT = ResourceMgr.goodTankU.getHeight();
	private Random random=new Random();
	Rectangle rect=new Rectangle();
	private boolean moving = true;
	private boolean living=true;
	public Group group= Group.BAD;

	GameModel gm;
	FireStrategy fs;
	public Tank(int x, int y, Dir dir, GameModel gm, Group group) {
		this.x = x;
		this.y = y;
		this.dir = dir;
		this.gm = gm;
		this.group = group;

		rect.x=this.x;
		rect.y=this.y;
		rect.width=WIDTH;
		rect.height=HEIGHT;
		// 判断是我方坦克,使用四个方向出子弹策略
		if (group == Group.GOOD) {
			String goodFSName= (String) PropertyMgr.get("goodFS");
			//我方坦克,速度15
			SPEED = Integer.parseInt(PropertyMgr.get("tankSpeedMy").toString());
			try {
				fs= (FireStrategy) Class.forName(goodFSName).newInstance();
			} catch (InstantiationException e) {
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
		}
		//是敌方坦克,就是默认装弹策略
		else {
			String badFSName= (String) PropertyMgr.get("badFS");
			//敌方方坦克,速度15
			SPEED = Integer.parseInt(PropertyMgr.get("tankSpeedOth").toString());
			try {
				fs= (FireStrategy) Class.forName(badFSName).newInstance();
			} catch (InstantiationException e) {
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
		}
	}

	public void paint(Graphics g) {
		if (!living) gm.tanks.remove(this);
		switch (dir){
			case LEFT:
				g.drawImage(this.group==Group.GOOD?ResourceMgr.goodTankL : ResourceMgr.badTankL, x, y, null);
				break;
			case UP:
				g.drawImage(this.group==Group.GOOD?ResourceMgr.goodTankU : ResourceMgr.badTankU, x, y, null);
				break;
			case RIGHT:
				g.drawImage(this.group==Group.GOOD?ResourceMgr.goodTankR : ResourceMgr.badTankR, x, y, null);
				break;
			case DOWN:
				g.drawImage(this.group==Group.GOOD?ResourceMgr.goodTankD : ResourceMgr.badTankD, x, y, null);
				break;
		}

		move();

	}

	private void move() {
		if (!moving)
			return;
		switch (dir) {
		case LEFT:
			System.out.println(dir);
			x -= SPEED;
			break;
		case RIGHT:
			System.out.println(dir);
			x += SPEED;
			break;
		case DOWN:
			y += SPEED;
			break;
		case UP:
			System.out.println(dir);
			y -= SPEED;
			break;
		case LEFT_DOWN:
			System.out.println(dir);
			x -= SPEED;
			y += SPEED;
			break;
		case RIGHT_UP:
			System.out.println(dir);
			x += SPEED;
			y -= SPEED;
			break;
		case RIGHT_DOWN:
			System.out.println(dir);
			x += SPEED;
			y += SPEED;
			break;
		case LEFT_UP:
			System.out.println(dir);
			x -= SPEED;
			y -= SPEED;
			break;
		}
		rect.x=this.x;
		rect.y=this.y;

		if (this.group==Group.BAD && random.nextInt(100)>95) {
			this.fire();
		if (this.group==Group.BAD && random.nextInt(100)>95);
	 		randomDir();
		}
	 	boundsCheck();
		rect.x=this.x;
		rect.y=this.y;
    	}

	private void boundsCheck() {
		if (this.x <0 ) x=2;
		if (this.y<30) y=28;
		if (this.x>TankFrame.GAME_WIDTH-Tank.WIDTH-2) x=TankFrame.GAME_WIDTH-Tank.WIDTH-2;
		if (this.y>TankFrame.GAME_HEIGHT-Tank.HEIGHT-2) y=TankFrame.GAME_HEIGHT-Tank.HEIGHT-2;

	}

	private void randomDir() {
		this.dir=Dir.values()[random.nextInt(4)];
	}

	public boolean isMoving() {
		return moving;
	}

	public void setMoving(boolean moving) {
		this.moving = moving;
	}

	public Dir getDir() {
		return dir;
	}

	public void setDir(Dir dir) {
		this.dir = dir;
	}

	public void fire() {
		fs.fire(this);
	}

	public Group getGroup() {
		return group;
	}

	public void setGroup(Group group) {
		this.group = group;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public void die() {
		this.living=false;
	}
}

package com.houkai.tank.abstractfactory;

import com.houkai.tank.*;

import java.awt.*;

/**
 * @author houkai 定义子弹类,new出一個新的子彈
 */
public class RectBullet extends BaseBullet{
	private static final int SPEED = Integer.parseInt(PropertyMgr.get("bulletSpeed").toString());
	public static int WIDTH = ResourceMgr.bulletD.getWidth();
	public static int HEIGHT = ResourceMgr.bulletD.getHeight();

	Rectangle rect=new Rectangle();

	private int x, y;
	Dir dir;
	//记录子弹状态,飞出画面就死了,打中敌人也会死
	boolean living = true;
	private TankFrame tf=null;
	private Group group=Group.BAD;


	public RectBullet(int x, int y, Dir dir, TankFrame tf, Group group) {
		this.x = x;
		this.y = y;
		this.dir = dir;
		this.tf = tf;
		this.group = group;

		rect.x=this.x;
		rect.y=this.y;
		rect.width=WIDTH;
		rect.height=HEIGHT;

		tf.bullets.add(this);
	}

	public Group getGroup() {
		return group;
	}

	public void setGroup(Group group) {
		this.group = group;
	}
	public void paint(Graphics g) {
		if (!living) {
			tf.bullets.remove(this);
		}
		Color c= g.getColor();
		g.setColor(Color.YELLOW);
		g.fillRect(x,y,20,20);


		move();
	}

	private void move() {
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
		if (x < 0 || y < 0 || x > TankFrame.GAME_WIDTH || y > TankFrame.GAME_HEIGHT)
			living = false;
	}

	public void collidewith(BaseTank tank) {
		if (this.group==tank.getGroup()) return;
//		Rectangle rect1=new Rectangle(this.x, this.y, WIDTH, HEIGHT);
//		Rectangle rect2=new Rectangle(tank.getX(), tank.getY(),Tank.WIDTH, Tank.HEIGHT);
		if (rect.intersects(tank.rect)){
			tank.die();
			this.die();
			int eX = tank.getX() + Tank.WIDTH / 2 - Explode.WIDTH / 2;
			int eY = tank.getY() + Tank.HEIGHT / 2 - Explode.HEIGHT / 2;
//			tf.explodes.add(new Explode(eX, eY, tf));
			tf.explodes.add(tf.gf.createExplode(eX, eY, tf));
		}

	}

	private void die() {
		this.living=false;
	}
}
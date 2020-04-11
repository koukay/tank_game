package com.houkai.tank;


import com.houkai.tank.cor.BulletTankCollider;
import com.houkai.tank.cor.Collider;
import com.houkai.tank.cor.ColliderChain;
import com.houkai.tank.cor.TankTankCollider;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class GameModel {
	Tank myTank = new Tank(200, 400, Dir.DOWN,this,Group.GOOD);
    private static final GameModel INSTANCE= new GameModel();
   /* static {
        INSTANCE.init();
    }*/
//	List<Bullet> bullets = new ArrayList<>();
//	List<Tank> tanks = new ArrayList<>();
//	List<Explode> explodes= new ArrayList<>();
//	Collider collider = new BulletTankCollider();
//	Collider collider2 = new TankTankCollider();
	ColliderChain chain = new ColliderChain();
	private List<GameObject> objects= new ArrayList<>();

    public static GameModel getInstance() {
        return INSTANCE;
    }

    public void add(GameObject go){
		this.objects.add(go);
	}
	public void remove(GameObject go){
		this.objects.remove(go);
	}
	public GameModel() {
		int initTankCount= Integer.parseInt(PropertyMgr.get("initTankCount").toString());
		//初始化敌方坦克
		for (int i = 0; i < initTankCount; i++) {
			add(new Tank(50+ i*80, 200, Dir.DOWN,this,Group.BAD));
		}
	}

	public void paint(Graphics g) {
		Color c = g.getColor();
		g.setColor(Color.white);
//		g.drawString("子弹的数量"+bullets.size(), 10,60);
//		g.drawString("敌人的数量"+tanks.size(), 10,80);
//		g.drawString("explodes"+explodes.size(), 10,100);
		g.setColor(c);
		myTank.paint(g);
		for (int i = 0; i < objects.size(); i++) {
			objects.get(i).paint(g);
		}

		//互相碰撞逻辑
		for (int i = 0; i < objects.size(); i++) {
			for (int j = i+1; j < objects.size() ; j++) {
				GameObject o1=objects.get(i);
				GameObject o2=objects.get(j);
//				collider.collide(o1,o2);
//				collider2.collide(o1,o2);
				chain.collide(o1,o2);
			}
		}
		/*for (int i = 0; i < bullets.size(); i++) {
			for (int j = 0; j < tanks.size(); j++) {
				bullets.get(i).collidewith(tanks.get(j));
			}
		}*/
	}

	public Tank getMainTank() {
		return myTank;
	}
}

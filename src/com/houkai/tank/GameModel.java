package com.houkai.tank;


import com.houkai.tank.cor.ColliderChain;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class GameModel {
//	Tank myTank = new Tank(200, 400, Dir.DOWN,Group.GOOD);
	Tank myTank  ;
    private static final GameModel INSTANCE= new GameModel();
    static {
        INSTANCE.init();
    }

	private void init() {
		myTank = new Tank(200, 400, Dir.DOWN,Group.GOOD);
		int initTankCount= Integer.parseInt(PropertyMgr.get("initTankCount").toString());
		//初始化敌方坦克
		for (int i = 0; i < initTankCount; i++) {
			new Tank(50+ i*80, 200, Dir.DOWN,Group.BAD);
		}
		//初始化墙 x:右,y:下  w:墙宽 h:墙高
		add(new Wall(150,150,200,50));
		add(new Wall(550,150,200,50));
		add(new Wall(400,300,50,150));
		add(new Wall(550,300,50,150));
		add(new Wall(1000,300,50,250));
		add(new Wall(10,300,50,250));
		add(new Wall(300,100,250,50));
		add(new Wall(150,400,250,50));
		add(new Wall(550,400,250,50));
		add(new Wall(350,550,250,50));
	}

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
	}

	public void paint(Graphics g) {
		Color c = g.getColor();
		g.setColor(Color.white);
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

				chain.collide(o1,o2);
			}
		}
	}

	public Tank getMainTank() {
		return myTank;
	}
}

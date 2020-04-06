package com.houkai.tank.abstractfactory;

import com.houkai.tank.Tank;

import java.awt.*;

public abstract class BaseBullet {
	public abstract void paint(Graphics g);

	public abstract void collidewith(BaseTank tank);
}

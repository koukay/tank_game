package com.houkai.tank.cor;

import com.houkai.tank.*;
import com.sun.org.glassfish.gmbal.GmbalException;

public class BulletTankCollider implements Collider {
    @Override
    public boolean collide(GameObject o1, GameObject o2) {
        if (o1 instanceof Bullet && o2 instanceof Tank){
           Bullet b= (Bullet) o1;
           Tank t = (Tank) o2;
            if (b.group==t.getGroup()) return true;
//		Rectangle rect1=new Rectangle(this.x, this.y, WIDTH, HEIGHT);
//		Rectangle rect2=new Rectangle(tank.getX(), tank.getY(),Tank.WIDTH, Tank.HEIGHT);
            if (b.rect.intersects(t.rect)){
                t.die();
                b.die();
                int eX = t.getX() + Tank.WIDTH / 2 - Explode.WIDTH / 2;
                int eY = t.getY() + Tank.HEIGHT / 2 - Explode.HEIGHT / 2;
                new Explode(eX, eY, GameModel.getInstance());

                return false;
            }
        }else if (o1 instanceof Tank  && o2 instanceof Bullet){
            return collide(o2,o1);
        }
        return true;
    }
}

package com.houkai.tank.decorator;

import com.houkai.tank.GameObject;

import java.awt.*;

public class RectDecorator extends GODecorator {

    public RectDecorator(GameObject go) {
        super(go);
    }
    @Override
    public void paint(Graphics g) {
        go.paint(g);
        Color c= g.getColor();
        g.setColor(Color.YELLOW);
        g.drawRect(super.go.x,super.go.y,super.go.getWidth()+2,super.go.getHeight()+2);
        g.setColor(c);
    }

    @Override
    public int getWidth() {
        return super.go.getWidth();
    }

    @Override
    public int getHeight() {
        return super.go.getHeight();
    }
}

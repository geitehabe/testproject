package day1.com.rjxy.bean;

import jdk.nashorn.internal.ir.CatchNode;

import javax.swing.*;
import java.awt.*;

/**
 * Created by lele on 18-1-12.
 */
public class Boom {
    private int x;
    private int y;
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

    private Image boImg1 = new ImageIcon("img/boom1.jpg").getImage();
    private Image boImg2 = new ImageIcon("img/boom2.jpg").getImage();
    private Image boImg3 = new ImageIcon("img/boom3.jpg").getImage();

    public void paint(Graphics g){
        g.drawImage(boImg1, x, y,50,50,null);
    }
}

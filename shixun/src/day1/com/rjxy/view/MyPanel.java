package day1.com.rjxy.view;
import day1.com.rjxy.bean.*;
import day1.com.rjxy.bean.memento.Caretaker;
import day1.com.rjxy.util.DB_Operator;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;

/**
* 全屏界面的扩展面板
* */
public class MyPanel extends JPanel implements MouseMotionListener,Runnable {
    private int screenWidth;
    private int screenHeight;

    private Image bgImg = null;

    private Hero hero = Hero.getInstance();

    private ArrayList<Bullet> bullets = new ArrayList<Bullet>();

    private ArrayList<EnemyPlane> eps = new ArrayList<EnemyPlane>();

    private Boom boom;
    private boolean boomState = false;
    private int index = 0;

    private int epNum = 10;
    private Image goImg = new ImageIcon("img/GameOver.jpg").getImage();
    private Image crossImg = new ImageIcon("img/cross.jpg").getImage();

    private int y;

    private int y1;
    private boolean state = true;
    private String name;
    private int highestGrade;

    private int speed1,speed2,speed3;

    public void move(){
        y--;
        y1--;

        if(y<-screenHeight){
            y = y1+screenHeight;
        }
        if(y1<-screenHeight){
            y1 = y+screenHeight;
        }

    repaint();
    }

    public void initBackGround(){
        int bgNum = hero.getLevel()%5+ 1;
        bgImg = new ImageIcon("img/bg" + bgNum + ".jpg").getImage();


        if(highestGrade <= hero.getScore()){
            highestGrade = hero.getScore();
        }
    }

    public MyPanel(Dimension dim,String name) {
        screenWidth = dim.width;
        screenHeight = dim.height;
        y = 0;
        y1 = screenHeight;
        this.name = name;
        highestGrade = hero.getScore();

        hero.setR(60);
        hero.setX((screenWidth - 2 * hero.getR()) / 2);
        hero.setY((screenHeight - 2 * hero.getR()) / 2);
        hero.setAllBlood(100);
        hero.setBlood(100);
        hero.setScore(0);

        String info = new DB_Operator().grap(name);
        String[] test = info.split(" ");
        hero.setLevel(Integer.valueOf(test[0]));
        hero.setScore(Integer.valueOf(test[1]));

        initBullet();

        initEP();

        boom = new Boom();

        this.addMouseMotionListener(this);

    }


    @Override
    public void paint(Graphics g) {

        initBackGround();
        g.drawImage(bgImg, 0, y, screenWidth, screenHeight, null);
        g.drawImage(bgImg, 0, y1, screenWidth, screenHeight, null);

        for (int i = 0; i < bullets.size(); i++) {//for+alt+/
            bullets.get(i).paint(g);
        }

        hero.paint(g);

        for (int i = 0; i < eps.size(); i++) {
            eps.get(i).paint(g);
        }
        if(boomState){
            boom.paint(g);
            index ++;

            if(index%40 == 0) {
                boomState = false;
            }
        }
        if (hero.getBlood() <= 0 && hero.getLevel()<=1) {
            g.drawImage(goImg, 0, 0, screenWidth, screenHeight, null);
            g.drawString("最高分数："+highestGrade,200,200);
            state = false;

            //备忘录模式添加：
            Caretaker caretaker = new Caretaker();
            caretaker.setMemento(hero.save());
            Memento memento = caretaker.getMemento();
            new DB_Operator().update(name,memento.getLevel(),memento.getGrade(),memento.getTime());

        }
    }


    private void initBullet() {
        Bullet bullet = new Bullet();
        bullet.setX(hero.getX());
        bullet.setY(hero.getY());
        bullet.setR(50);
        bullets.add(bullet);
    }

    public void initEP(){

        speed1 =1;
        speed2 = 5;
        speed3 = 10;
        for (int i = 0; i < epNum; i++) {
            EnemyPlane ep = EnemyPlane.getInstance();
            ep.setX((int) (Math.random() * screenWidth));
            ep.setY((int) (Math.random() * screenHeight));
            ep.setR(30);
            ep.setSpeed(speed1);
            eps.add(ep);
        }


    }

    public boolean isHit (EnemyPlane ep, Hero hero) {
        if ((ep.getX() - hero.getX()) * (ep.getX() - hero.getX()) +
                (ep.getY() - hero.getY()) * (ep.getY() - hero.getY()) <
                (ep.getR() + hero.getR()) * (ep.getR() + hero.getR()))
            return true;
        return false;
    }

    public boolean isHit(EnemyPlane ep, Bullet bullet) {
        if ((ep.getX() - bullet.getX()) * (ep.getX() - bullet.getX()) +
                (ep.getY() - bullet.getY()) * (ep.getY() - bullet.getY()) <
                (ep.getR() + bullet.getR()) * (ep.getR() + bullet.getR()))
            return true;
        return false;
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        // TODO Auto-generated method stub


    }

    @Override
    public void mouseMoved(MouseEvent e) {
        // TODO Auto-generated method stub
        if (hero.getBlood() > 0) {
            hero.setX(e.getX());
            hero.setY(e.getY());
            repaint();
        }else if(hero.getLevel()>0){
                hero.setX(e.getX());
                hero.setY(e.getY());
                repaint();
        }

    }


    @Override
    public void run() {
        // TODO Auto-generated method stub

        int cnt = 0;
        while (state) {
            if (hero.getBlood() > 0 || hero.getLevel()>0) {
                if (cnt % 10 == 0) {
                    initBullet();
                }
                cnt++;

                for (int i = 0; i < bullets.size(); i++) {
                    Bullet bullet = bullets.get(i);
                    if (bullet.getY() < -bullet.getR()) {
                        bullets.remove(i);
                    } else {
                        bullet.setY(bullet.getY() - 10);
                    }

                    for (int j = 0; j < eps.size(); j++) {
                        EnemyPlane ep = eps.get(j);
                        if (isHit(ep, bullet)) {
                            if(ep.getEpNum() == 15){
                                if(hero.getBlood()<hero.getAllBlood()){
                                    int temp = hero.getBlood()+10;
                                    hero.setBlood(temp);
                                }

                            }else {
                                boom.setX(ep.getX());
                                boom.setY(ep.getY());
                                boomState = true;

                                hero.setScore(hero.getScore() + 25);

                                bullets.remove(i);

                                eps.remove(j);
                            }

                            ep.setX((int) (Math.random() * screenWidth));
                            ep.setY(-ep.getR());
                            ep.setSpeed(speed1);
                            ep.changePlane();
                            eps.add(ep);
                        }

                        if(hero.getLevel() == 1){
                            ep.setSpeed(speed1);
                        }else if(hero.getLevel()== 2){
                            ep.setSpeed(speed2);
                        }else if(hero.getLevel() == 3){
                            ep.setSpeed(speed3);
                        }

                    }
                    repaint();

                }
                move();

                    repaint();


                    for (int i = 0; i < eps.size(); i++) {
                        EnemyPlane ep = eps.get(i);
                        if(ep.getY() > screenHeight){
                            eps.remove(i);

                            ep.setX((int)(Math.random()*screenWidth));
                            ep.setY(-ep.getR());
                            ep.setSpeed((int)(Math.random()*5)+1);
                            ep.changePlane();
                            eps.add(ep);
                        }else{
                            ep.setY(ep.getY()+ep.getSpeed());
                        }


                        if(isHit(ep, hero)){
                            if(hero.getBlood()>0) {
                                hero.setBlood(hero.getBlood() - 5);
                            }else{
                                if(hero.getLevel()>1) {
                                    JOptionPane.showMessageDialog(null, "Hero血量较低，降级！");
                                    int temp = hero.getLevel();
                                    hero.setLevel(--temp);
                                }else if(hero.getLevel() == 1){
                                    JOptionPane.showMessageDialog(null,"战机死亡，游戏结束．");
                                }

                            }

                            eps.remove(i);

                            ep.setX((int)(Math.random()*screenWidth));
                            ep.setY(-ep.getR());
                            ep.setSpeed((int)(Math.random()*5)+1);
                            ep.changePlane();
                            eps.add(ep);
                        }
                        repaint();
                    }//end for eps

                }


                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }

            }//end while

        }
}


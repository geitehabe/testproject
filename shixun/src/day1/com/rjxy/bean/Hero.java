package day1.com.rjxy.bean;

import day1.com.rjxy.bean.state.Hero1stState;
import day1.com.rjxy.bean.state.HeroState;

import javax.swing.*;
import java.awt.*;

/**
 * Created by lele on 18-1-8.
 *
 */
public class Hero {
    private int x;
    private int y;
    private int allBlood;
    private int score;
    private int blood;
    private int r;

    private int level = 1;

    private HeroState currentState = new Hero1stState(this);

    private Image heroImg1 = new ImageIcon("img/hero.png").getImage();
    private Image heroImg2 = new ImageIcon("img/hero2.jpg").getImage();
    private Image heroImg3 = new ImageIcon("img/hero3.jpg").getImage();

    private static Hero hero;

    private Hero() {
    }

    public static synchronized Hero getInstance() {
        if (hero == null) {
            hero = new Hero();
        }
        return hero;
    }


    public int getLevel() {
        return level;
    }

    public void setLevel(int level1) {
        level = level1;
    }

    public HeroState getCurrentState() {
        return currentState;
    }

    public void setCurrentState(HeroState currentState) {
        this.currentState = currentState;
    }


    public int getBlood() {
        return blood;
    }

    public void setBlood(int blood) {
        this.blood = blood;
    }

    public int getR() {
        return r;
    }

    public void setR(int r) {
        this.r = r;
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

    public int getAllBlood() {
        return allBlood;
    }

    public void setAllBlood(int allBlood) {
        this.allBlood = allBlood;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
        currentState.check();

    }

    public void paint(Graphics g){
        //����ս��
        if(level == 0){
            g.drawImage(heroImg1, x, y, null);
        }else if(level == 1) {
            g.drawImage(heroImg1, x, y, null);
        }else if(level == 2){
            g.drawImage(heroImg2, x, y, null);
        }else if(level == 3){
            g.drawImage(heroImg3, x, y, null);
        }
        //������Ѫ��
        g.setColor(Color.orange);//������ɫΪ��ɫ
        g.fillRect(20, 20, allBlood, 30);
        //���Ƶ�ǰѪ��
        g.setColor(Color.red);
        g.fillRect(20, 20, blood, 30);
        //���Ʒ���
        g.setFont(new Font("",Font.BOLD,30));
        g.drawString("������"+score,900,50);
        //���Ƶȼ�
        g.drawString("Level:"+level,1200,50);
    }

    public Memento save(){
        return new Memento(level,score);
    }
    public void restoreMemento(Memento user){
        this.setLevel(user.level);
        this.setScore(user.grade);
    }

}

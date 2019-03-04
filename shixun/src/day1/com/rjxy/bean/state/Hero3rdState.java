package day1.com.rjxy.bean.state;

import javax.swing.*;

/**
 * Created by lele on 18-1-11.
 * 具体状态：关卡３
 */
public class Hero3rdState extends HeroState {


    public Hero3rdState(HeroState state){
        hero = state.hero;
        hero.setLevel(3);
    }
    @Override
    public void check() {

            if (hero.getScore() > 5000) {
                JOptionPane.showMessageDialog(null, "游戏通关,重新来过！");
                hero.setLevel(1);
                hero.setScore(0);
                hero.setCurrentState(new Hero1stState(this));

            }

    }
}

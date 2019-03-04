package day1.com.rjxy.bean.state;

import day1.com.rjxy.bean.Hero;

/**
 * Created by lele on 18-1-11.
 * 抽象状态
 */
public abstract class HeroState {
    Hero hero;

    //抽象方法，控制状态的切换
    public abstract void check();
}

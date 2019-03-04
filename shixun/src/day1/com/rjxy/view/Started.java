package day1.com.rjxy.view;

import javax.swing.*;
import java.awt.*;

/**
 * Created by lele on 18-1-8.
 * 全屏界面
 */
public class Started {

        public Started(Dimension dim,String name){

            JFrame frame=new JFrame("飞机大战");//生成全屏窗体对象

            MyPanel panel=new MyPanel(dim,name);//生成自定义面板对象

            frame.add(panel);//将面板添加到窗体上

            Thread thread=new Thread(panel);//生成一个线程对象
            thread.start();//启动线程

            frame.setSize(dim);//设置全屏
            frame.setVisible(true);//设置可见
            frame.setResizable(false);//设置大小不可改变
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//设置关闭方式

        }
}

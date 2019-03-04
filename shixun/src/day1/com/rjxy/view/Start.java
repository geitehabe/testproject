package day1.com.rjxy.view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by lele on 18-1-9.
 * 初始界面
 */
public class Start implements ActionListener {

    JFrame frame;
    JButton button_login,button_zhuce,botton_exit;
    JPanel panel;
    Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();

    public Start() {
        frame = new JFrame("飞机大战－登陆");
        panel = new JPanel();
        button_login = new JButton("用户登陆");
        button_zhuce = new JButton("注册新用户");
        botton_exit = new JButton("退出游戏程序");

        //监听当前对象
        button_login.addActionListener(this);
        button_zhuce.addActionListener(this);
        botton_exit.addActionListener(this);

        panel.add(button_login);
        panel.add(button_zhuce);
        panel.add(botton_exit);

        frame.setLayout(new GridLayout(2,0,20,20));

        frame.add(panel);//面板添加到窗体上

        //使窗口大小为300x400，且位于屏幕中央
        frame.setBounds((dim.width - 300) / 2, (dim.height - 400) / 2, 300, 400);
        //设置窗体为可见
        frame.setVisible(true);
        //设置大小不可改变
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//设置窗体的关闭方式

    }
    @Override
    public void actionPerformed(ActionEvent e) {

        if(e.getSource()==button_login){
            //进入游戏登陆界面
            frame.setVisible(false);
           new StartLogin(dim);
        }
        if(e.getSource()==button_zhuce){
            frame.setVisible(false);
            //进入游戏的注册
            new StartApply(dim);
        }
        if(e.getSource()==botton_exit){
            System.exit(0);
        }
    }
}

package day1.com.rjxy.view;

import day1.com.rjxy.util.DB_Operator;

import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


/**
 * Created by lele on 18-1-8.
 * 初始界面　　可以向全屏界面过渡
 */
public class StartLogin implements ActionListener {
    JFrame frame;
    JButton button_start,button_end;
    JTextField jt1,jt2;
    JLabel jl1,jl2;
    JPanel panel;
    Dimension dim;

    public StartLogin(){

    }
    public StartLogin(Dimension dim) {
        frame = new JFrame("飞机大战－登陆");
        panel = new JPanel();
        button_end = new JButton("关闭");
        button_start = new JButton("登陆");

        jl1 = new JLabel("user");
        jl2 = new JLabel("word");
        jt1 = new JTextField(20);
        jt2 = new JTextField(20);

        //监听当前对象
        button_start.addActionListener(this);
        button_end.addActionListener(this);

        frame.setLayout(new GridLayout(2,0,10,10));

        panel.add(jl1);
        panel.add(jt1);
        panel.add(jl2);
        panel.add(jt2);
        panel.add(button_start);
        panel.add(button_end);
        frame.add(panel);//面板添加到窗体上

        //使窗口大小为300x400，且位于屏幕中央
        frame.setBounds((dim.width - 300) / 2, (dim.height - 400) / 2, 300, 400);
        //设置窗体为可见
        frame.setVisible(true);
        //设置大小不可改变
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//设置窗体的关闭方式

        this.dim = dim;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        if(e.getSource()==button_end){//程序退出
            System.exit(0);
        }
        if(e.getSource()==button_start){
            //判断数据是否匹配
            String name = jt1.getText();
            String password = jt2.getText();
            boolean a = new DB_Operator().exit(name,password);
            if(a) {
                //打开游戏界面
                JOptionPane.showMessageDialog(null,"登陆成功！");
                frame.setVisible(false);
                new StartInfo(dim,name);//匿名对象
            }else{
                JOptionPane.showMessageDialog(null,"用户名或密码错误");
            }
        }



    }


}

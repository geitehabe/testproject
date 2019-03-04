package day1.com.rjxy.view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by lele on 18-1-9.
 * ��ʼ����
 */
public class Start implements ActionListener {

    JFrame frame;
    JButton button_login,button_zhuce,botton_exit;
    JPanel panel;
    Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();

    public Start() {
        frame = new JFrame("�ɻ���ս����½");
        panel = new JPanel();
        button_login = new JButton("�û���½");
        button_zhuce = new JButton("ע�����û�");
        botton_exit = new JButton("�˳���Ϸ����");

        //������ǰ����
        button_login.addActionListener(this);
        button_zhuce.addActionListener(this);
        botton_exit.addActionListener(this);

        panel.add(button_login);
        panel.add(button_zhuce);
        panel.add(botton_exit);

        frame.setLayout(new GridLayout(2,0,20,20));

        frame.add(panel);//�����ӵ�������

        //ʹ���ڴ�СΪ300x400����λ����Ļ����
        frame.setBounds((dim.width - 300) / 2, (dim.height - 400) / 2, 300, 400);
        //���ô���Ϊ�ɼ�
        frame.setVisible(true);
        //���ô�С���ɸı�
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//���ô���Ĺرշ�ʽ

    }
    @Override
    public void actionPerformed(ActionEvent e) {

        if(e.getSource()==button_login){
            //������Ϸ��½����
            frame.setVisible(false);
           new StartLogin(dim);
        }
        if(e.getSource()==button_zhuce){
            frame.setVisible(false);
            //������Ϸ��ע��
            new StartApply(dim);
        }
        if(e.getSource()==botton_exit){
            System.exit(0);
        }
    }
}

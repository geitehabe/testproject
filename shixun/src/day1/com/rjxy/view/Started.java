package day1.com.rjxy.view;

import javax.swing.*;
import java.awt.*;

/**
 * Created by lele on 18-1-8.
 * ȫ������
 */
public class Started {

        public Started(Dimension dim,String name){

            JFrame frame=new JFrame("�ɻ���ս");//����ȫ���������

            MyPanel panel=new MyPanel(dim,name);//�����Զ���������

            frame.add(panel);//�������ӵ�������

            Thread thread=new Thread(panel);//����һ���̶߳���
            thread.start();//�����߳�

            frame.setSize(dim);//����ȫ��
            frame.setVisible(true);//���ÿɼ�
            frame.setResizable(false);//���ô�С���ɸı�
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//���ùرշ�ʽ

        }
}

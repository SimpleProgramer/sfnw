package sfnw.ds.pool;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SFNWDataSource {

    public static void main(String[] args) {
        //初始化一个jframe
        JFrame frame = new JFrame("Hello World!");

        //初始化一个文字区域
        JTextArea textarea = new JTextArea("要显示的文字");

        //初始化一个jlable
        JLabel emptyLable = new JLabel("第一个Java GUI程序的标签");

        //初始化一个菜单栏
        JMenuBar menuBar = new JMenuBar();

        //初始化菜单
        JMenu menu1 = new JMenu("文件");
        JMenu menu2 = new JMenu("编辑");
        JMenu menu3 = new JMenu("资源");

        //初始化一个panel
        JPanel panel = new JPanel();

        //初始化一个容器
        Container container = frame.getContentPane();

        //初始化一个按钮
        JButton startAutoGen = new JButton("开始生成");

        //这个流程可以简化为lambda表达式
        startAutoGen.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.out.println("hello world");
            }
        });

        startAutoGen.addActionListener(event -> System.out.println("button Clicked"));

        //设置布局
        container.setLayout(new FlowLayout());

        //把按钮添加到pannel
        panel.add(textarea);
        panel.add(emptyLable);
        panel.add(startAutoGen);

        //把菜单添加到菜单栏
        menuBar.add(menu1);
        menuBar.add(menu2);
        menuBar.add(menu3);

        //设置菜单栏
        frame.setJMenuBar(menuBar);

        //设置关闭方式
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //把panel添加到容器
        container.add(panel);

        //设置大小
        frame.setSize(600,500);

        //设置位置
        frame.setLocation(100, 100);

        //设置可见性
        frame.setVisible(true);
    }

}

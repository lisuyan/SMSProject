package org.zjz.view;
/**
 * 学生信息管理系统主界面
 * @author liyan
 */
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import org.zjz.entity.Groups;

import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JDesktopPane;
import java.awt.Color;

public class MainFreView extends JFrame {

	private JPanel contentPane;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainFreView frame = new MainFreView();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public MainFreView() {
		super("学生信息管理系统");
		setBackground(Color.GRAY);
		JDesktopPane desktop = new JDesktopPane();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setExtendedState(MAXIMIZED_BOTH);
		//setBounds(100, 100, 648, 427);
		//setExtendedState(MAXIMIZED_BOTH);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 434, 21);
		contentPane.add(menuBar);
		
		JMenu menu = new JMenu("信息管理");
		menuBar.add(menu);
		
		JMenu menu_2 = new JMenu("分组管理");
		menu.add(menu_2);
		
		JMenuItem menuItem = new JMenuItem("添加分组");
		menuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AddGroupView agv = new AddGroupView();
				agv.setVisible(true);
				desktop.add(agv);
				new AddGroupView().setVisible(true);
				//JOptionPane.showMessageDialog(null, "成功");
			}
		});
		menu_2.add(menuItem);
		
		JMenuItem menuItem_1 = new JMenuItem("查询分组");
		menuItem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				OperGroupView ogv = new OperGroupView();
				ogv.setVisible(true);
				desktop.add(ogv);
			}
		});
		menu_2.add(menuItem_1);
		
		JMenu menu_3 = new JMenu("学生管理");
		menu.add(menu_3);
		
		JMenuItem menuItem_2 = new JMenuItem("添加学生");
		menuItem_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AddStuView asv = new AddStuView();
				asv.setVisible(true);
				desktop.add(asv);
				new AddStuView().setVisible(true);
				//JOptionPane.showMessageDialog(null, "成功");
			}
		});
		menu_3.add(menuItem_2);
		
		JMenuItem menuItem_3 = new JMenuItem("查询学生");
		menuItem_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				OperStuView osv = new OperStuView();
				osv.setVisible(true);
				desktop.add(osv);
			}
		});
		menu_3.add(menuItem_3);
		
		JMenu menu_4 = new JMenu("课程管理");
		menu.add(menu_4);
		
		JMenuItem menuItem_5 = new JMenuItem("课程查询");
		menuItem_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					ScheduleView sv = new ScheduleView();
					sv.setVisible(true);
					desktop.add(sv);
			}
		});
		menu_4.add(menuItem_5);
		
		JMenuItem menuItem_7 = new JMenuItem("添加课程");
		menuItem_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ScheduleView sv = new ScheduleView();
				sv.setVisible(true);
				desktop.add(sv);
				new AddStuView().setVisible(true);
			}
		});
		menu_4.add(menuItem_7);
		
		JMenu menu_5 = new JMenu("成绩管理");
		menu.add(menu_5);
		
		JMenuItem menuItem_6 = new JMenuItem("成绩查询");
		menuItem_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ScoreOperView sv = new ScoreOperView();
				sv.setVisible(true);
				desktop.add(sv);
			}
		});
		menu_5.add(menuItem_6);
		
		JMenuItem menuItem_8 = new JMenuItem("添加成绩");
		menuItem_8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AddScoreView agv = new AddScoreView();
				agv.setVisible(true);
				desktop.add(agv);
				new AddStuView().setVisible(true);
			}
		});
		menu_5.add(menuItem_8);
		
		JMenuItem menuItem_4 = new JMenuItem("退出系统");
		menuItem_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		menu.add(menuItem_4);
		
		JMenu menu_1 = new JMenu("关于我们");
		menuBar.add(menu_1);
		
		JMenuItem menuItem_9 = new JMenuItem("更多了解");	 
		menu_1.add(menuItem_9);
		
		desktop.setBounds(9, 32, 1287, 667);
		contentPane.add(desktop);
		setVisible(true);
	}
}

package org.zjz.view;
/**
 * 登录界面
 * @author liyan
 */
import java.awt.EventQueue;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import org.zjz.bussiness.impl.AdminActionImpl;
import org.zjz.entity.Admin;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.Color;

public class LoginView extends JFrame {

	private JPanel contentPane;
	private JTextField tf_name;
	private JPasswordField tf_psw;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginView frame = new LoginView();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	private void tf_pswKeyPressed(KeyEvent e) {
		if(e.getKeyCode() == KeyEvent.VK_ENTER)
		{
			 login(); 
		}
	}
	
	private void login()
	{
		String name = tf_name.getText();
		String psw = tf_psw.getText();
		Admin admin = new Admin(name,psw);
		boolean b = new AdminActionImpl().checkUser(admin);
		if(b) 
		{
			this.dispose();
			new MainFreView().setVisible(true);
			 
		}
		else JOptionPane.showMessageDialog(null, "对不起，登录失败，请检查您的密码或用户名！");
	}
	
	private void reset()
	{
		tf_name.setText("");
		tf_psw.setText("");
	}
	/**
	 * Create the frame.
	 */
	public LoginView() {
		setForeground(new Color(51, 102, 102));
		setBackground(new Color(51, 153, 51));
		setIconImage(Toolkit.getDefaultToolkit().getImage("F:\\资料库\\0526（重要）学生信息管理系统2\\images\\about.png"));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel label = new JLabel("学生信息管理系统");
		label.setBounds(155, 10, 125, 15);
		contentPane.add(label);
		
		JLabel label_1 = new JLabel("用户名");
		label_1.setIcon(new ImageIcon("F:\\资料库\\0526（重要）学生信息管理系统2\\images\\student.png"));
		label_1.setBounds(118, 56, 104, 21);
		contentPane.add(label_1);
		
		JLabel label_2 = new JLabel("     密     码");
		label_2.setIcon(new ImageIcon("F:\\资料库\\0526（重要）学生信息管理系统2\\images\\password.png"));
		label_2.setBounds(118, 111, 105, 21);
		contentPane.add(label_2);
		
		tf_name = new JTextField();
		tf_name.setBounds(246, 53, 93, 21);
		contentPane.add(tf_name);
		tf_name.setColumns(10);
		
		tf_psw = new JPasswordField();
		tf_psw.setBounds(247, 111, 93, 21);
		contentPane.add(tf_psw);
		
		tf_psw.addKeyListener(new java.awt.event.KeyAdapter() {
			public void keyPressed(java.awt.event.KeyEvent evt) {
				tf_pswKeyPressed(evt);
			}
		});
		
		JButton button = new JButton("登录");
		 
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				login();
			}
		});
		button.setIcon(new ImageIcon("F:\\资料库\\0526（重要）学生信息管理系统2\\images\\login.png"));
		button.setBounds(126, 170, 92, 23);
		contentPane.add(button);
		
		JButton button_1 = new JButton("重置");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				reset();
			}
		});
		button_1.setIcon(new ImageIcon("F:\\资料库\\0526（重要）学生信息管理系统2\\images\\reset.png"));
		button_1.setBounds(250, 169, 94, 23);
		contentPane.add(button_1);
	}
}

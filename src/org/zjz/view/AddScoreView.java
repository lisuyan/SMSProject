package org.zjz.view;
/**
 * 添加成绩的界面
 * @author liyan
 */
import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import org.zjz.bussiness.impl.GroupsActionImpl;
import org.zjz.bussiness.impl.ScoreActionImpl;
import org.zjz.bussiness.impl.StuActionImpl;
import org.zjz.entity.Groups;
import org.zjz.entity.Student;
import org.zjz.util.StringUtil;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.SystemColor;

public class AddScoreView extends JInternalFrame {
	private JTextField tf_sid;
	private JTextField tf_cno;
	private JTextField grade;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddScoreView frame = new AddScoreView();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	private void reset()
	{
		tf_sid.setText("");
		tf_cno.setText("");
		grade.setText("");
	}
	/**
	 * Create the frame.
	 */
	public AddScoreView() {
		setForeground(SystemColor.windowBorder);
		setFrameIcon(new ImageIcon("F:\\资料库\\0526（重要）学生信息管理系统2\\images\\grou.PNG"));
		setClosable(true);
		setIconifiable(true);
		setTitle("添加成绩信息");
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(null);
		
		JLabel label = new JLabel("学生学号");
		label.setBounds(124, 63, 54, 15);
		getContentPane().add(label);
		
		tf_sid = new JTextField();
		tf_sid.setBounds(208, 60, 66, 21);
		getContentPane().add(tf_sid);
		tf_sid.setColumns(10);
		
		JLabel lblbh = new JLabel("课程编号");
		lblbh.setBounds(124, 112, 54, 15);
		getContentPane().add(lblbh);
		
		tf_cno = new JTextField();
		tf_cno.setBounds(208, 109, 66, 21);
		getContentPane().add(tf_cno);
		tf_cno.setColumns(10);
		
		JLabel label_2 = new JLabel("分数");
		label_2.setBounds(124, 161, 54, 15);
		getContentPane().add(label_2);
		
		grade = new JTextField();
		grade.setBounds(208, 158, 66, 21);
		getContentPane().add(grade);
		grade.setColumns(10);
		
		JButton button = new JButton("添加成绩");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int sid = Integer.parseInt(tf_sid.getText());
				int cid = Integer.parseInt(tf_cno.getText());
				int score = Integer.parseInt(grade.getText());
				if(StringUtil.isEmpty(sid+"")) 
				{
					JOptionPane.showMessageDialog(null, "对不起，请输入学号！");
					return;
				}
				if(StringUtil.isEmpty(cid+""))
				{
					JOptionPane.showMessageDialog(null, "对不起，请输入课程编号！");
					return;
				} 
				boolean b = new ScoreActionImpl().addScore(sid, cid, score);
				if(b)
				{
					JOptionPane.showMessageDialog(null, "恭喜您，添加成绩成功！");
					reset();
				}
				else JOptionPane.showMessageDialog(null, "对不起，添加失败！");
				
			}
		});
		 
		button.setBounds(90, 212, 93, 23);
		getContentPane().add(button);
		
		JButton button_1 = new JButton("重置");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				reset();
			}
		});
		button_1.setBounds(208, 212, 93, 23);
		getContentPane().add(button_1);

	}

}

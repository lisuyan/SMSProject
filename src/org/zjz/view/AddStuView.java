package org.zjz.view;
/**
 * 添加学生的界面
 * @author liyan
 */
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.MatteBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import org.zjz.bussiness.impl.GroupsActionImpl;
import org.zjz.bussiness.impl.StuActionImpl;
import org.zjz.dao.impl.GroupsDaoImpl;
import org.zjz.entity.Groups;
import org.zjz.entity.Student;
import org.zjz.util.StringUtil;

import javax.swing.JComboBox;
import javax.swing.JRadioButton;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.AbstractButton;
import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import java.awt.SystemColor;

public class AddStuView extends JInternalFrame {
	private static final AbstractButton table = null;
	private JTextField tf_sid;
	private JTextField tf_sname;
	private JTextField tf_sage;
	private JComboBox cbb_group;
	private ButtonGroup bg;
	private JRadioButton rb_man;
	private JRadioButton rb_woman;
	/**
	 * Launch the application.
	 */
	private void fillComboBox() {
		Groups g = new Groups(-1,"请选择...",null);
		cbb_group.addItem(g);
		Vector v = new GroupsDaoImpl().selectGroups(new Groups());
		System.out.println(v.size());
		for (int i = 0; i < v.size(); i++) {
			Vector v1 = (Vector) v.get(i);
			int gid = Integer.parseInt(v1.get(0)+"");
			String gname = (String) v1.get(1);
			String gdesc = (String) v1.get(2);
			Groups group = new Groups(gid, gname, gdesc);
			System.out.println(gname);
			cbb_group.addItem(group);
		}
	}
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddStuView frame = new AddStuView();
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
	public	AddStuView(){
		setForeground(new Color(102, 153, 51));
		setFrameIcon(new ImageIcon("F:\\资料库\\0526（重要）学生信息管理系统2\\images\\add.png"));
		intcont();
		fillComboBox();
	}
	
	public void intcont() {
		setIconifiable(true);
		setClosable(true);
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(null);
		
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)), "\u6DFB\u52A0\u5B66\u751F\u4FE1\u606F", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(0, 0, 434, 270);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel label = new JLabel("学生学号");
		label.setBounds(112, 22, 54, 15);
		panel.add(label);
		
		tf_sid = new JTextField();
		tf_sid.setBounds(210, 19, 121, 21);
		panel.add(tf_sid);
		tf_sid.setColumns(10);
		
		JLabel label_1 = new JLabel("学生姓名");
		label_1.setBounds(112, 52, 54, 15);
		panel.add(label_1);
		
		tf_sname = new JTextField();
		tf_sname.setBounds(210, 50, 121, 21);
		panel.add(tf_sname);
		tf_sname.setColumns(10);
		
		
	
		JLabel label_3 = new JLabel("学生年龄");
		label_3.setBounds(112, 125, 54, 15);
		panel.add(label_3);
		
		tf_sage = new JTextField();
		tf_sage.setBounds(210, 122, 121, 21);
		panel.add(tf_sage);
		tf_sage.setColumns(10);
		
		JLabel label_2 = new JLabel("学生性别");
		label_2.setBounds(112, 91, 54, 15);
		panel.add(label_2);
		
		
		
		rb_woman = new JRadioButton("女");
		rb_woman.setBounds(277, 87, 54, 23);
		panel.add(rb_woman);
		
		rb_man = new JRadioButton("男");
		rb_man.setSelected(true);
		rb_man.setBounds(210, 87, 43, 23);
		panel.add(rb_man);
		
		bg =  new ButtonGroup();
		bg.add(rb_man);
		bg.add(rb_woman);
		
		JLabel label_4 = new JLabel("学生所在组");
		label_4.setBounds(112, 162, 75, 15);
		panel.add(label_4);
		
		cbb_group = new JComboBox();
		cbb_group.setBounds(210, 159, 121, 21);
		
		JButton bt_add = new JButton("添加学生");
		bt_add.addActionListener(new ActionListener() {
			private Groups selectedGroups;

			public void actionPerformed(ActionEvent e) {
				String sid = tf_sid.getText();
				String name = tf_sname.getText();
				String age = tf_sage.getText();
				if(StringUtil.isEmpty(sid)) 
				{
					JOptionPane.showMessageDialog(null, "对不起，请输入您的学号！");
					return;
				}
				if(StringUtil.isEmpty(name))
				{
					JOptionPane.showMessageDialog(null, "对不起，请输入您的姓名！");
					return;
				} 
				 
				Groups selectedGroup = (Groups) cbb_group.getSelectedItem();
				int gid = selectedGroup.getGid();
				String ssex = rb_man.isSelected() ? "男" : "女";
				Student stu = new Student(Integer.parseInt(sid), name, ssex,Integer.parseInt(age),gid);
				boolean b = new StuActionImpl().addStu(stu);
				if(b)
				{
					JOptionPane.showMessageDialog(null, "恭喜您，添加学生成功！");
				}
				else JOptionPane.showMessageDialog(null, "对不起，添加失败！");
				
			} 
		});
		bt_add.setBounds(112, 215, 88, 23);
		panel.add(bt_add);
		
		panel.add(cbb_group);
		JButton bt_reset = new JButton("重置");
		JRadioButton rb_boy = new JRadioButton("男");
		bt_reset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				resetValue();
			}
			private void resetValue()
			{
				tf_sid.setText("");
				tf_sname.setText(""); 
				tf_sage.setText("");
				rb_boy.setSelected(true);
				cbb_group.setSelectedIndex(0);
			}
		});
		bt_reset.setBounds(243, 215, 88, 23);
		panel.add(bt_reset);
		setVisible(true);
	}
}

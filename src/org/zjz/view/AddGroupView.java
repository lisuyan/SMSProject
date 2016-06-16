package org.zjz.view;
/**
 * 添加组的界面
 * @author liyan
 */
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.MatteBorder;
import javax.swing.border.TitledBorder;

import org.zjz.bussiness.impl.GroupsActionImpl;
import org.zjz.entity.Groups;
import org.zjz.util.StringUtil;
import javax.swing.ImageIcon;

public class AddGroupView extends JInternalFrame {
	private JTextField tf_gid;
	private JTextField tf_gname;
	private JTextArea tf_gdesc;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddGroupView frame = new AddGroupView();
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
	private void reset()
	{
		tf_gid.setText("");
		tf_gname.setText("");
		tf_gdesc.setText("");
	}
	public AddGroupView() {
		setForeground(new Color(102, 153, 102));
		setFrameIcon(new ImageIcon("F:\\资料库\\0526（重要）学生信息管理系统2\\images\\add.png"));
		
		setEnabled(false);
		setBackground(new Color(153, 153, 153));
		setIconifiable(true);
		setClosable(true);
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)), "\u6DFB\u52A0\u5206\u7EC4\u4FE1\u606F", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(0, 0, 434, 270);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblid = new JLabel("组id");
		lblid.setBounds(123, 33, 54, 15);
		panel.add(lblid);
		
		JLabel label = new JLabel("分组名称");
		label.setBounds(123, 69, 54, 15);
		panel.add(label);
		
		JLabel label_1 = new JLabel("分组简介");
		label_1.setBounds(123, 112, 54, 15);
		panel.add(label_1);
		
		tf_gid = new JTextField();
		tf_gid.setBounds(214, 30, 119, 21);
		panel.add(tf_gid);
		tf_gid.setColumns(10);
		
		tf_gname = new JTextField();
		tf_gname.setBounds(214, 66, 119, 21);
		panel.add(tf_gname);
		tf_gname.setColumns(10);
		
		tf_gdesc = new JTextArea();
		tf_gdesc.setBounds(214, 108, 118, 61);
		panel.add(tf_gdesc);
		
		JButton bt_add = new JButton("添加分组");
		bt_add.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String gid = tf_gid.getText();
				String gname = tf_gname.getText();
				String gdesc = tf_gdesc.getText();
				if(StringUtil.isEmpty(gid))
				{
					JOptionPane.showMessageDialog(null, "请输入您的分组id");
					return;
				
				}
				if(StringUtil.isEmpty(gname))
				{
					JOptionPane.showMessageDialog(null, "请输入您的分组名称");
					return;
				}
				Groups group = new Groups(Integer.parseInt(gid),gname,gdesc);
				boolean b = new GroupsActionImpl().addGroups(group);
				if(b)
				{
					JOptionPane.showMessageDialog(null, "添加成功！");
					reset();
				}
				else  JOptionPane.showMessageDialog(null, "添加失败！");
			}
		});
		bt_add.setBounds(123, 203, 88, 23);
		panel.add(bt_add);
		
		JButton bt_reset = new JButton("重置");
		bt_reset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				reset();
			}
		});
		
		bt_reset.setBounds(245, 203, 88, 23);
		panel.add(bt_reset);
		setVisible(true);
	}
}

package org.zjz.view;
/**
 * （查询、修改、删除）操作学生信息的界面
 * @author liyan
 */
import java.awt.EventQueue;


import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;
import javax.swing.border.MatteBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import org.zjz.bussiness.impl.GroupsActionImpl;
import org.zjz.bussiness.impl.StuActionImpl;
import org.zjz.dao.impl.GroupsDaoImpl;
import org.zjz.entity.Groups;
import org.zjz.entity.Student;

//import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.util.Vector;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class OperStuView extends JInternalFrame {
	private JTextField tf_sname;
	private JTable jt_group;
	private JComboBox cbb_group;
	private JTextField ts_id;
	private JTextField ts_name;
	private JTextField ts_sex;
	private JTextField ts_age;
	private JTextField ts_gid;
 
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
	private void fillTable(Groups group)
	{
		DefaultTableModel dtm = (DefaultTableModel)cbb_group.getModel();
		Vector v = new GroupsActionImpl().selectGroups(group);
		dtm.setRowCount(0);
		for(int i = 0;i<v.size();i++)
		{
			 dtm.addRow((Vector)v.get(i));
		}
	}
	public OperStuView() {
		// TODO Auto-generated method stub
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)), "\u5B66\u751F\u67E5\u8BE2\u6761\u4EF6", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(10, 10, 414, 83);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		cbb_group = new JComboBox();
		cbb_group.setBounds(110, 55, 87, 21);
		fillComboBox();
		setClosable(true);
		setIconifiable(true);
		setBounds(100, 100, 446, 379);
		getContentPane().setLayout(null);
		
		JLabel label = new JLabel("学生姓名");
		label.setBounds(25, 24, 54, 15);
		panel.add(label);
		
		tf_sname = new JTextField();
		tf_sname.setBounds(110, 21, 66, 21);
		panel.add(tf_sname);
		tf_sname.setColumns(10);
		
		JLabel label_1 = new JLabel("学生所在组");
		label_1.setBounds(25, 58, 66, 15);
		panel.add(label_1);
		panel.add(cbb_group);
		
		JButton button = new JButton("查询");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String sname = tf_sname.getText();
				Groups selectedGroup = (Groups) cbb_group.getSelectedItem();
			    int gid = selectedGroup.getGid();
				Student student = new Student();
				student.setSname(sname);
				student.setGid(gid);
				fillTable(student);
			}
			private void fillTable(Student student) {
				// TODO Auto-generated method stub
				DefaultTableModel dtm = (DefaultTableModel) jt_group.getModel();
				Vector v = new StuActionImpl().selectStu(student);
				dtm.setRowCount(0);
				for (int i = 0; i < v.size(); i++) {
					dtm.addRow((Vector) v.get(i));
				}
			}
		});
		button.setBounds(231, 54, 74, 23);
		panel.add(button);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				
			}
		});
		scrollPane.setBounds(10, 110, 414, 98);
		getContentPane().add(scrollPane);
		
		jt_group = new JTable();
		jt_group.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				int row = jt_group.getSelectedRow();
				String sid = jt_group.getValueAt(row, 0)+"";
				String sname = jt_group.getValueAt(row, 1)+"";
				String sex = jt_group.getValueAt(row, 2)+"";
				String age = jt_group.getValueAt(row, 3)+"";
				String gid = jt_group.getValueAt(row, 4)+"";
				ts_id.setText(sid);
				ts_name.setText(sname);
				ts_sex.setText(sex);
				ts_age.setText(age);
				ts_gid.setText(gid);
			}
		});
		jt_group.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"\u5B66\u751Fid", "\u59D3\u540D", "\u6027\u522B", "\u5E74\u9F84", "\u5B66\u751F\u6240\u5728\u7EC4"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, true, true, true, true
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		scrollPane.setViewportView(jt_group);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(10, 218, 414, 121);
		getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblid_1 = new JLabel("学生id");
		lblid_1.setBounds(10, 10, 54, 15);
		panel_1.add(lblid_1);
		
		ts_id = new JTextField();
		ts_id.setBounds(74, 7, 66, 21);
		panel_1.add(ts_id);
		ts_id.setColumns(10);
		
		JLabel lblid = new JLabel("学生姓名");
		lblid.setBounds(213, 10, 54, 15);
		panel_1.add(lblid);
		
		ts_name = new JTextField();
		ts_name.setBounds(277, 7, 66, 21);
		panel_1.add(ts_name);
		ts_name.setColumns(10);
		
		JButton button_1 = new JButton("修改");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String id = ts_id.getText();
				String name = ts_name.getText();
				String sex = ts_sex.getText();
				String sage = ts_age.getText();
				String gid =ts_gid.getText();
				Student stu = new Student();
				stu.setSid(Integer.parseInt(id));
				stu.setSname(name);
				stu.setSsex(sex);
				stu.setSage(Integer.parseInt(sage));
				stu.setGid(Integer.parseInt(gid));
				boolean b = new StuActionImpl().updateStu(stu);
				if(b)
				{
					JOptionPane.showMessageDialog(null, "修改成功！");
				}
				else
				{
					JOptionPane.showMessageDialog(null, "修改失败！");
				}
			}
		});
		button_1.setBounds(192, 88, 75, 23);
		panel_1.add(button_1);
		
		JButton button_2 = new JButton("删除");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String id = ts_id.getText();
				Student stu = new Student();
				stu.setSid(Integer.parseInt(id));
				boolean b = new StuActionImpl().deleteStu(stu);
				if(b)
				{
					JOptionPane.showMessageDialog(null, "删除成功！");
					return;
				}
				else
				{
					JOptionPane.showMessageDialog(null, "删除失败！");
					return;
				}
			}
		});
		button_2.setBounds(295, 88, 75, 23);
		panel_1.add(button_2);
		
		JLabel label_2 = new JLabel("学生性别");
		label_2.setBounds(10, 48, 54, 15);
		panel_1.add(label_2);
		
		ts_sex = new JTextField();
		ts_sex.setBounds(74, 45, 66, 21);
		panel_1.add(ts_sex);
		ts_sex.setColumns(10);
		
		JLabel label_3 = new JLabel("学生年龄");
		label_3.setBounds(213, 48, 54, 15);
		panel_1.add(label_3);
		
		ts_age = new JTextField();
		ts_age.setBounds(277, 38, 66, 21);
		panel_1.add(ts_age);
		ts_age.setColumns(10);
		
		JLabel label_4 = new JLabel("学生所在组");
		label_4.setBounds(10, 88, 66, 15);
		panel_1.add(label_4);
		
		ts_gid = new JTextField();
		ts_gid.setBounds(74, 89, 66, 21);
		panel_1.add(ts_gid);
		ts_gid.setColumns(10);
	}
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					OperStuView frame = new OperStuView();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public void OperStuView() {
		//fillTable(new Student());
		setEnabled(false);
		setIconifiable(true);
		setClosable(true);
		setBounds(100, 100, 450, 399);
		this.setLocation(100,50);
		fillTable(new Groups());
		setVisible(true);
		
	}
}

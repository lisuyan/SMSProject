package org.zjz.view;
/**
 * （查询、修改、删除）操作组的界面
 * @author liyan
 */
import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;
import javax.swing.border.BevelBorder;
import javax.swing.border.CompoundBorder;
import java.awt.Color;
import javax.swing.border.EtchedBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.Vector;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import org.zjz.bussiness.impl.GroupsActionImpl;
import org.zjz.entity.Groups;

import javax.swing.border.MatteBorder;
import javax.swing.JTextArea;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class OperGroupView extends JInternalFrame {
	private JTextField tf_gname;
	private JTable jt_group;
	private JTextField tf_gid;
	private JTextField tf_name;
	private JTextArea tf_desc;
	
	//注意不要未定义就开始用，不然可能会造成空指针及其他的一些严重错误
	private void initComponents() {
		getContentPane().setLayout(null);
		// TODO Auto-generated method stub
		JPanel panel = new JPanel();
		panel.setBounds(10, 0, 414, 66);
		panel.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null), "\u5206\u7EC4\u67E5\u8BE2\u6761\u4EF6", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel label = new JLabel("分组名称");
		label.setBounds(32, 33, 54, 15);
		panel.add(label);
		
		tf_gname = new JTextField();
		tf_gname.setBounds(127, 30, 93, 21);
		panel.add(tf_gname);
		tf_gname.setColumns(10);
		
		JButton button = new JButton("查询");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String gname = tf_gname.getText();
				Groups group = new Groups();
				group.setGname(gname);
				fillTable(group);
			}
		});
		button.setBounds(279, 29, 93, 23);
		panel.add(button);
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 76, 414, 73);
		getContentPane().add(scrollPane);
		jt_group = new JTable();
		jt_group.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				int row = jt_group.getSelectedRow();
				String gid = jt_group.getValueAt(row, 0)+"";
				String gname = jt_group.getValueAt(row, 1)+"";
				String gdesc = jt_group.getValueAt(row, 2)+"";
				tf_gid.setText(gid);
				tf_name.setText(gname);
				tf_desc.setText(gdesc);
			}
		});
		jt_group.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null},
				{null, null, null},
				{null, null, null},
			},
			new String[] {
				"\u5206\u7EC4id", "\u5206\u7EC4\u540D\u79F0", "\u5206\u7EC4\u7B80\u4ECB"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, true, true
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		scrollPane.setViewportView(jt_group);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)), "\u5206\u7EC4\u4FE1\u606F\u64CD\u4F5C", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_1.setBounds(10, 159, 414, 181);
		getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblid = new JLabel("分组id");
		lblid.setBounds(32, 39, 54, 15);
		panel_1.add(lblid);
		
		tf_gid = new JTextField();
		tf_gid.setBounds(126, 36, 66, 21);
		panel_1.add(tf_gid);
		tf_gid.setColumns(10);
		
		JLabel label_1 = new JLabel("分组名称");
		label_1.setBounds(233, 39, 54, 15);
		panel_1.add(label_1);
		
		tf_name = new JTextField();
		tf_name.setBounds(317, 36, 66, 21);
		panel_1.add(tf_name);
		tf_name.setColumns(10);
		
		JLabel label_2 = new JLabel("分组简介");
		label_2.setBounds(32, 98, 54, 15);
		panel_1.add(label_2);
		
		tf_desc = new JTextArea();
		tf_desc.setBounds(126, 81, 257, 50);
		panel_1.add(tf_desc);
		
		JButton button_1 = new JButton("修改");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String gid = tf_gid.getText();
				String gname = tf_gname.getText();
				String gdesc = tf_desc.getText();
				Groups group = new Groups(Integer.parseInt(gid),gname,gdesc);
				boolean b = new GroupsActionImpl().updateGroups(group);
				if(b)
				{
					JOptionPane.showMessageDialog(null, "修改"+gname+"成功！");
				}
				else
				{
					JOptionPane.showMessageDialog(null, "修改失败！");
					 
				}
					
			}
		});
		button_1.setBounds(126, 141, 72, 23);
		panel_1.add(button_1);
		
		JButton button_2 = new JButton("删除");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String gid = tf_gid.getText();
				String gname = tf_gname.getText();
				Groups group = new Groups();
				group.setGid(Integer.parseInt(gid));
				boolean b = new GroupsActionImpl().deleteGroups(group);
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
		button_2.setBounds(233, 141, 72, 23);
		panel_1.add(button_2);
	}
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					OperGroupView frame = new OperGroupView();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @param group 
	 */
	public OperGroupView() {
		setEnabled(false);
		setIconifiable(true);
		setClosable(true);
		setBounds(100, 100, 450, 399);
		this.setLocation(100,50);
		initComponents();
		fillTable(new Groups());
	}
	
	private void fillTable(Groups group)
	{
		DefaultTableModel dtm = (DefaultTableModel) this.jt_group.getModel();
		Vector v = new GroupsActionImpl().selectGroups(group);
		dtm.setRowCount(0);
		for(int i = 0;i<v.size();i++)
		{
			 dtm.addRow((Vector) v.get(i));
		}
	}
}

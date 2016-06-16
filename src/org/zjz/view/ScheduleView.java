package org.zjz.view;
/**
 * （查询、删除、修改、增加）操作课程信息的界面
 * @author liyan
 */
import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;
import javax.swing.border.MatteBorder;
import java.awt.Color;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import org.zjz.bussiness.impl.ScheduleActionImpl;
import org.zjz.bussiness.impl.StuActionImpl;
import org.zjz.entity.Groups;
import org.zjz.entity.Schedule;
import org.zjz.entity.Student;
import org.zjz.util.StringUtil;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.Vector;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.ImageIcon;

public class ScheduleView extends JInternalFrame {
	private JTable c_table;
	private JTextField tf_name;
	private JTextField tf_cname;
	private JTextField tf_cno;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ScheduleView frame = new ScheduleView();
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
	public ScheduleView() {
		setTitle("课程信息管理");
		setFrameIcon(new ImageIcon("F:\\资料库\\0526（重要）学生信息管理系统2\\images\\add.png"));
		setIconifiable(true);
		setClosable(true);
		setBounds(100, 100, 532, 398);
		getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 10, 496, 106);
		panel.setBorder(new TitledBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)), "\u67E5\u8BE2\u8BFE\u7A0B", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel label = new JLabel("课程名称");
		label.setBounds(47, 46, 54, 15);
		panel.add(label);
		
		tf_name = new JTextField();
		tf_name.setBounds(127, 43, 66, 21);
		panel.add(tf_name);
		tf_name.setColumns(10);
		
		JButton button = new JButton("查询");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String cname = tf_name.getText();
				ListSelectionModel selectSchedule = c_table.getSelectionModel();
				Schedule sche = new Schedule();
				sche.setCname(cname);
				fillTable(sche);
			}
			private void fillTable(Schedule sche) {
				// TODO Auto-generated method stub
				DefaultTableModel dtm = (DefaultTableModel) c_table.getModel();
				Vector v = new ScheduleActionImpl().selectSchedule(sche);
				dtm.setRowCount(0);
				for (int i = 0; i < v.size(); i++) {
					dtm.addRow((Vector) v.get(i));
				}
			}
		});
		button.setBounds(228, 42, 93, 23);
		panel.add(button);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 127, 496, 106);
		getContentPane().add(scrollPane);
		
		c_table = new JTable();
		c_table.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				int row = c_table.getSelectedRow();
				String cno = c_table.getValueAt(row, 0)+"";
				String cname = c_table.getValueAt(row, 1)+"";
				tf_cno.setText(cno);
				tf_cname.setText(cname);
			}
		});
		c_table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"\u8BFE\u7A0B\u7F16\u53F7", "\u8BFE\u7A0B\u540D\u79F0"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, true
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		scrollPane.setViewportView(c_table);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(10, 243, 496, 115);
		getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		JLabel label_1 = new JLabel("课程名称");
		label_1.setBounds(79, 20, 54, 15);
		panel_1.add(label_1);
		
		tf_cname = new JTextField();
		tf_cname.setBounds(143, 17, 66, 21);
		panel_1.add(tf_cname);
		tf_cname.setColumns(10);
		
		JLabel label_2 = new JLabel("课程编号");
		label_2.setBounds(241, 20, 54, 15);
		panel_1.add(label_2);
		
		tf_cno = new JTextField();
		tf_cno.setBounds(312, 17, 66, 21);
		panel_1.add(tf_cno);
		tf_cno.setColumns(10);
		
		JButton btnNewButton_1 = new JButton("修改");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String cname = tf_cname.getText();
				String cno = tf_cno.getText();
				Schedule sche = new Schedule();
				sche.setCno(Integer.parseInt(cno));
				sche.setCname(cname);
				boolean b = new ScheduleActionImpl().updateSchedule(sche);
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
		btnNewButton_1.setBounds(196, 82, 93, 23);
		panel_1.add(btnNewButton_1);
		
		JButton button_1 = new JButton("删除");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String cno = tf_cno.getText();
				String cname = tf_cname.getText();
				Schedule sche = new Schedule();
				sche.setCno(Integer.parseInt(cno));
				sche.setCname(cname);
				boolean b = new ScheduleActionImpl().deleteSchedule(sche);
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
		button_1.setBounds(312, 82, 93, 23);
		panel_1.add(button_1);
		
		JButton button_2 = new JButton("添加课程");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String cno = tf_cno.getText();
				String cname = tf_cname.getText();
				
				if(StringUtil.isEmpty(cno)) 
				{
					JOptionPane.showMessageDialog(null, "对不起，请输入课程编号！");
					return;
				}
				if(StringUtil.isEmpty(cname))
				{
					JOptionPane.showMessageDialog(null, "对不起，请输入课程名字！");
					return;
				} 
				Schedule sche = new Schedule();
				sche.setCname(cname);
				sche.setCno(Integer.parseInt(cno));
				boolean b = new ScheduleActionImpl().addSchedule(sche);
				if(b)
				{
					JOptionPane.showMessageDialog(null, "恭喜您，添加课程成功！");
				}
				else JOptionPane.showMessageDialog(null, "对不起，添加失败！");
				
			} 
		});
		button_2.setBounds(79, 82, 93, 23);
		panel_1.add(button_2);

	}
}

package org.zjz.view;
/**
 * （查询、删除）操作成绩信息的界面
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
import javax.swing.ListSelectionModel;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import org.zjz.bussiness.impl.GroupsActionImpl;
import org.zjz.bussiness.impl.ScheduleActionImpl;
import org.zjz.bussiness.impl.ScoreActionImpl;
import org.zjz.entity.Groups;
import org.zjz.entity.Schedule;
import org.zjz.entity.Student;
import org.zjz.util.StringUtil;

import java.awt.event.ActionListener;
import java.util.Vector;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ScoreOperView extends JInternalFrame {
	private JTable tf_table;
	private JTextField id;
	private JTextField tf_id;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ScoreOperView frame = new ScoreOperView();
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
	public ScoreOperView() {
		setClosable(true);
		setIconifiable(true);
		setBounds(100, 100, 578, 423);
		getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 10, 542, 111);
		panel.setBorder(new TitledBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(64, 64, 64)), "\u6210\u7EE9\u67E5\u8BE2\u6761\u4EF6", TitledBorder.LEADING, TitledBorder.TOP, null, Color.BLACK));
		getContentPane().add(panel);
		panel.setLayout(null);
		
		JButton button = new JButton("查询");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String sidstr = id.getText();
				int sid = Integer.parseInt(sidstr);
				ListSelectionModel selectSchedule = tf_table.getSelectionModel();
				Student stu = new Student();
				stu.setSid(sid);
				fillTable(stu);
			}
			private void fillTable(Student stu) {
				// TODO Auto-generated method stub
				DefaultTableModel dtm = (DefaultTableModel) tf_table.getModel();
				Vector v = new ScoreActionImpl().selectScore(stu);
				dtm.setRowCount(0);
				for (int i = 0; i < v.size(); i++) {
					dtm.addRow((Vector) v.get(i));
				}
			}
		});
		button.setBounds(275, 48, 85, 23);
		panel.add(button);
		
		JLabel label_1 = new JLabel("学生学号");
		label_1.setBounds(44, 52, 54, 15);
		panel.add(label_1);
		
		id = new JTextField();
		id.setBounds(139, 49, 66, 21);
		panel.add(id);
		id.setColumns(10);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 136, 542, 136);
		getContentPane().add(scrollPane);
		
		tf_table = new JTable();
		tf_table.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				int row = tf_table.getSelectedRow();
				int sid = Integer.parseInt(tf_table.getValueAt(row, 1)+""); 
				tf_id.setText(sid+""); 
			}
		});
		tf_table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"\u5B66\u751F\u59D3\u540D", "\u5B66\u751F\u5B66\u53F7", "\u5206\u6570", "\u8BFE\u7A0B\u7F16\u53F7"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, true, true, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		scrollPane.setViewportView(tf_table);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(10, 282, 542, 101);
		getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		JButton button_2 = new JButton("删除");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int id = Integer.parseInt(tf_id.getText());
				Student stu = new Student();
				stu.setSid(id);
				boolean b = new ScoreActionImpl().deleteScore(stu);
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
		button_2.setBounds(230, 34, 93, 23);
		panel_1.add(button_2);
		
		JLabel label = new JLabel("学生学号");
		label.setBounds(31, 38, 54, 15);
		panel_1.add(label);
		
		tf_id = new JTextField();
		tf_id.setBounds(100, 35, 66, 21);
		panel_1.add(tf_id);
		tf_id.setColumns(10);

	}
}

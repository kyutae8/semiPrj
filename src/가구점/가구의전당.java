package ������;

import java.awt.Color;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EtchedBorder;
import javax.swing.table.AbstractTableModel;

public class ���������� extends JFrame{
	JTable table;
	JTextField namef;
	JTextField scoref;
	JLabel l;
	JTextField b;
	JButton b1 = new JButton("�ݱ�");
	�� model;
	
	public ����������() {
		setLocation(700,300);
		setSize(600,300);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		model = new ��();
		JLabel label = new JLabel("���ۻ纰 ����",JLabel.CENTER);
		label.setBorder(new EtchedBorder());
		add(label,"North");
		
		table = new JTable(model);
		//�߰��� ���̺� �ִ°�
		JScrollPane scroll = new JScrollPane(table);
		add(scroll,"Center");
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		
		
	
		
		l = new JLabel("���ۻ� �˻�");
		
		
		
		
		
	
		b = new JTextField(15);
		b.setBackground(Color.WHITE);
		b.addActionListener(e->{
			model.fillTable();

		});
		panel.add(l);
		panel.add(b);
		panel.add(b1);
		b1.setBackground(Color.WHITE);
		b1.addActionListener(e->{
			dispose();
		});
		
		add(panel,"South");
		setVisible(true);
	}
	public static Connection makeConnection() {
		String url = "jdbc:oracle:thin:@localhost:1521:orcl";
		String user = "blue1";
		String password = "123456";
		Connection c = null;
				try {
					Class.forName("oracle.jdbc.driver.OracleDriver");
c = DriverManager.getConnection(url, user, password);
				} catch (Exception e) {
					e.printStackTrace();
				}
				return c;
	}
	 class �� extends AbstractTableModel{
		
		
		
		private String[] columnNames = {"��ȣ","�̸�","���ۻ�","����"};
		private static final int ROWS = 20;
		private static final int COLS = 4;
		Object[][] data = new String[ROWS][COLS];
		@Override
		public int getRowCount() {
			return data.length;
		}
		@Override
		public int getColumnCount() {
			return columnNames.length;
		}

		@Override
		public String getColumnName(int col) {
			
			return columnNames[col].toString();
		}

		public void fillTable()  {
			Connection con = makeConnection();
			try {
				String sql = "SELECT ��ȣ,�̸�,���ۻ�,���� FROM ���� where ���ۻ� = ?";
				PreparedStatement ps = con.prepareStatement(sql);
				ps.setString(1,b.getText());
				ResultSet rs = ps.executeQuery();
				
				int row = 0;
				while(rs.next()) {
					data[row][0] = rs.getString("��ȣ");
					data[row][1] = rs.getString("�̸�");
					data[row][2] = rs.getString("���ۻ�");
					data[row][3] = rs.getString("����");
					row++;
				}
				
				ps.close();
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			fireTableDataChanged();
		}
		

		@Override
		public void setValueAt(Object value,int row, int col) {
			data[row][col] = value;
			fireTableCellUpdated(row, col);
		}

		@Override
		public Object getValueAt(int rowIndex, int columnIndex) {
			
			return data[rowIndex][columnIndex];
		}
		
	}
	
	public static void main(String[] args) {
		new ����������();
	}
}
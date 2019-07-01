package 가구점;

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

public class 가구의전당2 extends JFrame{
	JTable table;
	JTable table2;
	JTextField namef;
	JTextField scoref;
	JLabel l;
	JTextField b;
	JButton b1 = new JButton("닫기");
	모델2  model2;
	
	
	public 가구의전당2() {
		setLocation(800,50);
		setSize(400,300);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		model2 = new 모델2();
		model2.showTable();
		JLabel label = new JLabel("전체가구표",JLabel.CENTER);
		label.setBorder(new EtchedBorder());
		add(label,"North");
		table = new JTable(model2);
		//중간에 테이블 넣는거
		JScrollPane scroll = new JScrollPane(table);
		add(scroll,"Center");
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		l = new JLabel("제작사 검색");
		b = new JTextField(15);
		b.setBackground(Color.WHITE);
		b.addActionListener(e->{
				model2.showTable();
		});
	panel.add(b1);
		b1.setBackground(Color.WHITE);
		b1.addActionListener(e->{
			dispose();
		});
		
		add(panel,"South");
		setLocation(300,300);
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
	 class 모델2 extends AbstractTableModel{
		 private String[] columnNames = {"번호","이름","제작사","가격"};
			private static final int ROWS2 = 20;
			private static final int COLS2 = 4;
			Object[][] data2 = new String[ROWS2][COLS2];
			@Override
			public int getRowCount() {
				return data2.length;
			}
			@Override
			public int getColumnCount() {
				return columnNames.length;
			}

			@Override
			public String getColumnName(int col) {
				
				return columnNames[col].toString();
			}
			@Override
			public void setValueAt(Object value,int row, int col) {
				data2[row][col] = value;
				fireTableCellUpdated(row, col);
			}
			@Override
			public Object getValueAt(int rowIndex, int columnIndex) {
				
				return data2[rowIndex][columnIndex];
			}

			public void showTable()  {
				Connection con = makeConnection();
				try {
					Statement stmt = con.createStatement();
					ResultSet rs = stmt.executeQuery("select * from 가구 order by 번호");
					
					int row = 0;
					while(rs.next()) {
						data2[row][0] = rs.getString("번호");
						data2[row][1] = rs.getString("이름");
						data2[row][2] = rs.getString("제작사");
						data2[row][3] = rs.getString("가격");
						row++;
					}
					
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
				fireTableDataChanged();
			}
			


	 }
	public static void main(String[] args) {
		new 가구의전당2();
	}
}
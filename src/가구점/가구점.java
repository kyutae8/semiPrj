package ������;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Font;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.sound.sampled.FloatControl;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EtchedBorder;
import javax.swing.border.LineBorder;

public class ������ extends JFrame{
	//����Ŭ ����
	Statement s;
	String sql = "select ��ȣ,�̸�,���ۻ�,���� from ���� order by ��ȣ";
	ResultSet rs;
	//ī�巹�̾ƿ�
	CardLayout c = new CardLayout();
	JPanel cp = new  JPanel(c);
	//�̹��� ������
	ImageIcon icon = new ImageIcon("����.jpg");
	ImageIcon icon2 = new ImageIcon("����.jpg");
	ImageIcon icon3 = new ImageIcon("���2.jpg");
	JLabel img3 = new JLabel(icon3);
	JLabel img2 = new JLabel(icon2);
	JLabel img = new JLabel(icon);
	ImageIcon[] icon1 = new ImageIcon[100];
	ImageIcon[] icon4 = new ImageIcon[100];
	//���� �̹���
	ImageIcon ff = new ImageIcon("1.jpg");
	ImageIcon ff2 = new ImageIcon("�Ʒ�.jpg");
	//1������
	JPanel p1 = new JPanel(null);
	JLabel title = new JLabel("������");//1������ ����
	JLabel id = new JLabel("���̵�");
	JTextField idt = new JTextField(15);
	JLabel pass = new JLabel("��й�ȣ");
	JPasswordField passt = new JPasswordField(15);
	JButton log = new JButton("�α���");
	JButton logout = new JButton("�α׾ƿ�");
	JButton join = new JButton("ȸ������");
	JButton close = new JButton("�ݱ�");
	//2������
	JPanel p2 = new JPanel(null);
	JLabel photolocation = new JLabel();
	JLabel photolocation2 = new JLabel(ff2);
	JLabel num = new JLabel("��ȣ");
	JLabel fname = new JLabel("������");
	JLabel made = new JLabel("���ۻ�");
	JLabel price = new JLabel("����");
	JTextField numt = new JTextField();
	JTextField fnamet = new JTextField();
	JTextField madet = new JTextField();
	JTextField pricet = new JTextField();
	JLabel search = new JLabel("������ �˻�");
	JLabel information = new JLabel("������");
	JTextField searcht = new JTextField();
	JTextArea informationt = new JTextArea();
	JScrollPane sc = new JScrollPane(informationt);
	JButton next = new JButton("����");
	JButton previous = new JButton("����");
	JButton madevalue = new JButton("���ۻ纰");
	JButton buy = new JButton("�����Ϸ�����");
	JButton back = new JButton("�ڷ�");
	//3������ 
	JPanel p3 = new JPanel(null);
	JLabel title3 = new JLabel("����");
	JLabel num2 = new JLabel("��ȣ");
	JLabel fname2 = new JLabel("������");
	JLabel made2 = new JLabel("���ۻ�");
	JLabel price2 = new JLabel("����");
	JLabel fnamesearch = new JLabel("������ �˻�");
	JTextField numt2 = new JTextField();
	JTextField fnamet2 = new JTextField();
	JTextField madet2 = new JTextField();
	JTextField pricet2 = new JTextField();
	JTextField fnamesearcht = new JTextField();
	JButton next2 = new JButton("����");
	JButton previous2 = new JButton("����");
	JLabel photo = new JLabel("����������");
	JLabel floc = new JLabel("�����");
	JComboBox floct = new JComboBox(new String[] {"����/���","���ܰ�","����","�հ�~"});
	String location = "";
	JLabel fnum = new JLabel("���� �Է�");
	JTextField fnumt = new JTextField();
	JButton select = new JButton("���");
	JTextField total = new JTextField();
	JButton buy2 = new JButton("����");
	JButton back2 = new JButton("�ڷ�");
	JLabel colorl = new JLabel("����");
	JComboBox color = new JComboBox(new String[] {"����","����","���","�ʷ�","�Ķ�"});
	String colorresult="";
	
	
	//4������
	JPanel p4 = new JPanel(null);
	JLabel title2 = new JLabel("ȸ������");
	JLabel joinid = new JLabel("���̵�");
	JLabel joinpass = new JLabel("��й�ȣ");
	JLabel addr = new JLabel("�ּ�");
	JLabel phonenum = new JLabel("��ȭ��ȣ");
	JTextField joinidt = new JTextField();
	JPasswordField joinpasst = new JPasswordField();
	JTextField addrt = new JTextField();
	JTextField phonenumt = new JTextField();
	JLabel agree = new JLabel("���ǻ���");
	JTextArea agreet = new JTextArea("���ǻ����� \n�����ִٰ� ģ��");
	JScrollPane agreesc = new JScrollPane(agreet);
	JCheckBox agreeb = new JCheckBox("����(�ʼ�)");
	JButton joinb = new JButton("ȸ������");
	JButton close2 = new JButton("�ݱ�");
	
	
	
	
public ������() throws Exception {
	//����Ŭ ����
		Connection c1 = �����Ѵ�();
		s = c1.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
		rs = s.executeQuery(sql);
	setSize(800,600);
	setDefaultLookAndFeelDecorated(true);
	setDefaultCloseOperation(EXIT_ON_CLOSE);
	//1������
	title.setBounds(340,10,200,150);
	title.setFont(new Font("����",Font.BOLD,50));
	id.setBounds(300,400,50,50);
	idt.setBounds(380,410,100,30);
	pass.setBounds(300,450,60,50);
	passt.setBounds(380,460,100,30);
	log.setBounds(200,500,100,30);
	logout.setBounds(300,500,100,30);
	join.setBounds(400,500,100,30);
	close.setBounds(500,500,100,30);
	title.setBackground(new Color(0,0,0,0));
	id.setBackground(new Color(0,0,0,0));
	pass.setBackground(new Color(0,0,0,0));
	log.setBackground(new Color(100,150,100,180));
	logout.setBackground(new Color(100,150,100,180));
	join.setBackground(new Color(100,150,100,180));
	close.setBackground(new Color(100,150,100,180));
	p1.add(title);
	p1.add(id);p1.add(idt);
	p1.add(pass);p1.add(passt);
	img.setBounds(0,0,800,600);
	p1.add(log);p1.add(logout);p1.add(join);p1.add(close);
	p1.add(img);
	//1������ ��ư�� �׼Ǵޱ�
	passt.addActionListener(e->{
		if (idt.getText().equals("")) {
			JOptionPane.showMessageDialog(null,"���̵� ������");
		}
	else if (passt.getText().equals("")) {
			JOptionPane.showMessageDialog(null,"��� ������");
		}
		else {
			
			JOptionPane.showMessageDialog(null,"����");
			c.show(cp,"2������");
		}
	});
	log.addActionListener(e->{
		if (!idt.getText().equals("")||!passt.getText().equals("")) {
			
		try {
			String str = "select ���̵�,��й�ȣ from ȸ�� where ���̵� = ? and ��й�ȣ = ?";
			PreparedStatement ps = c1.prepareStatement(str);
			ps.setString(1,idt.getText());
			ps.setString(2,passt.getText());
			ps.executeUpdate();
			ps.close();
			JOptionPane.showMessageDialog(null,"����");
			c.show(cp,"2������");
		} catch (SQLException e1) {
		}
		}else {
			JOptionPane.showMessageDialog(null,"����");
		}
		
		
		
	});
	logout.addActionListener(e->{
		idt.setText("");
		passt.setText("");
		JOptionPane.showMessageDialog(null,"�α׾ƿ�");
	});
	join.addActionListener(e->{
		joinidt.setText("");
		joinpasst.setText("");
		addrt.setText("");
		phonenumt.setText("");
		
		c.show(cp,"4������");
		});
	close.addActionListener(e->{
		dispose();
	});
	//2������
	photolocation.setBounds(290,20,290,290);
	photolocation2.setBounds(0,-20,800,600);
	num.setBounds(130,310,100,30);
	fname.setBounds(130,360,100,30);
	made.setBounds(130,410,100,30);
	price.setBounds(130,460,100,30);
	numt.setBounds(200,310,120,30);
	fnamet.setBounds(200,360,120,30);
	madet.setBounds(200,410,120,30);
	pricet.setBounds(200,460,120,30);
	search.setBounds(420,310,100,30);
	searcht.setBounds(530,310,120,30);
	information.setBounds(420,410,100,30);
	sc.setBounds(530,360,120,120);
	next.setBounds(530,150,80,30);
	previous.setBounds(170,150,80,30);
	buy.setBounds(330,480,140,30);
	back.setBounds(500, 480,80,30);
	next.setBackground(Color.WHITE);
	madevalue.setBounds(530,260,100,30);
	madevalue.setBackground(Color.WHITE);
	previous.setBackground(Color.WHITE);
	buy.setBackground(Color.WHITE);
	back.setBackground(Color.WHITE);
	num.setBackground(new Color(0,0,0,0));
	fname.setBackground(new Color(0,0,0,0));
	made.setBackground(new Color(0,0,0,0));
	price.setBackground(new Color(0,0,0,0));
	search.setBackground(new Color(0,0,0,0));
	information.setBackground(new Color(0,0,0,0));
	p2.add(num);p2.add(fname);p2.add(made);p2.add(price);p2.add(madevalue);
	p2.add(numt);p2.add(fnamet);p2.add(madet);p2.add(pricet);
	p2.add(search);p2.add(searcht);p2.add(information);p2.add(sc);
	p2.add(next);p2.add(previous);p2.add(buy);p2.add(back);
	p2.add(photolocation);
	p2.add(photolocation2);
	
	//2������ ��ư�� �׼Ǵޱ�
	next.addActionListener(e->{
		try {
			rs.next();
			numt.setText(""+rs.getInt("��ȣ"));
			fnamet.setText(""+rs.getString("�̸�"));
			madet.setText(""+rs.getString("���ۻ�"));
			pricet.setText(""+rs.getInt("����"));
			for (int i = 0; i < icon1.length; i++) {
				icon1[i] = new ImageIcon((i+1)+".jpg");
				if (numt.getText().equals(""+i)) {
					for (int j = 0; j < icon1.length; j++) {
						photolocation.setIcon(icon1[i-1]);
						photolocation.setText("");
						informationt.setText(fnamet.getText()+"�� ���� ����");
					}
				}

				photolocation.setVisible(true);
			}
			
		} catch (SQLException e1) {
			JOptionPane.showMessageDialog(null,"��������");
		}
	});
	previous.addActionListener(e->{
		try {
			rs.previous();
			numt.setText(""+rs.getInt("��ȣ"));
			fnamet.setText(""+rs.getString("�̸�"));
			madet.setText(""+rs.getString("���ۻ�"));
			pricet.setText(""+rs.getInt("����"));
			for (int i = 0; i < icon1.length; i++) {
				icon1[i] = new ImageIcon((i+1)+".jpg");
				if (numt.getText().equals(""+i)) {
					for (int j = 0; j < icon1.length; j++) {
						photolocation.setIcon(icon1[i-1]);
						photolocation.setText("");
						informationt.setText(fnamet.getText()+"�� ���� ����");
					}
				}

				photolocation.setVisible(true);
			}
			
		} catch (SQLException e1) {
			JOptionPane.showMessageDialog(null,"ó����");
		}
	});
	
	searcht.addActionListener(e->{
		String str = "select ��ȣ,�̸�,���ۻ�,���� from ���� where �̸�=?";
		try {
			
			PreparedStatement ps = c1.prepareStatement(str);
			ps.setString(1,searcht.getText());
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				numt.setText(""+rs.getInt("��ȣ"));
				fnamet.setText(""+rs.getString("�̸�"));
				madet.setText(""+rs.getString("���ۻ�"));
				pricet.setText(""+rs.getInt("����"));
				
			}
			ps.executeUpdate();
			ps.close();
			for (int i = 0; i < icon1.length; i++) {
				icon1[i] = new ImageIcon((i+1)+".jpg");
				if (numt.getText().equals(""+i)) {
					for (int j = 0; j < icon1.length; j++) {
						photolocation.setIcon(icon1[i-1]);
						photolocation.setText("");
						informationt.setText(fnamet.getText()+"�� ���� ����");
					}
				}
				photolocation.setVisible(true);
			}

			
		} catch (SQLException e1) {
			JOptionPane.showMessageDialog(null,"�˻������ ����");
		}
	});
	madevalue.addActionListener(e->{
		JOptionPane.getFrameForComponent(new ����������());
		JOptionPane.getFrameForComponent(new ����������2());
	});
	buy.addActionListener(e->{
		c.show(cp,"3������");
	});
	back.addActionListener(e->{
		idt.setText("");
		passt.setText("");
		c.show(cp,"1������");
	});
	//3������ ����
	title3.setBounds(350,10,150,100);
	title3.setFont(new Font("����",Font.BOLD,50));
	p3.add(title3);
	num2.setBounds(30,150,100,30);
	fname2.setBounds(30,200,100,30);
	made2.setBounds(30,250,100,30);
	price2.setBounds(30,300,100,30);
	numt2.setBounds(130,150,120,30);
	fnamet2.setBounds(130,200,120,30);
	madet2.setBounds(130,250,120,30);
	pricet2.setBounds(130,300,120,30);
	floc.setBounds(30,350,100,30);
	floc.setForeground(Color.WHITE);
	floct.setBounds(130,350,120,30);
	fnum.setBounds(30,400,100,30);
	fnumt.setBounds(130,400,120,30);
	fnamesearch.setBounds(30,450,100,30);
	fnamesearcht.setBounds(130,450,120,30);
	photo.setBounds(430,200,220,200);
	select.setBounds(130,500,100,30);
	total.setBounds(240,500,200,30);
	buy2.setBounds(450,500,100,30);
	back2.setBounds(560,500,100,30);
	next2.setBounds(560,150,100,30);
	previous2.setBounds(400,150,100,30);
	select.setBackground(new Color(100,150,100,180));
	buy2.setBackground(new Color(100,150,100,180));
	back2.setBackground(new Color(100,150,100,180));
	next2.setBackground(new Color(100,150,100,180));
	previous2.setBackground(new Color(100,150,100,180));
	colorl.setBackground(Color.BLACK);
	fnamesearch.setBackground(Color.BLACK);
	colorl.setBounds(450,410,100,30);
	color.setBounds(500,410,100,30);
	p3.add(photo);
	p3.add(next2);p3.add(previous2);
	p3.add(num2);p3.add(fname2);p3.add(made2);p3.add(price2);p3.add(floc);p3.add(fnum);p3.add(fnamesearch);
	p3.add(numt2);p3.add(fnamet2);p3.add(madet2);p3.add(pricet2);p3.add(floct);p3.add(fnumt);p3.add(fnamesearcht);
	p3.add(colorl);p3.add(color);
	p3.add(select);p3.add(total);p3.add(buy2);p3.add(back2);
	img3.setBounds(0,0,800,600);
	p3.add(img3);
	//3������ �׼�
	color.addItemListener(e->{
		colorresult = color.getSelectedItem().toString();
			
		
	});
	fnamesearcht.addActionListener(e->{
		String str = "select ��ȣ,�̸�,���ۻ�,���� from ���� where �̸�=?";
		try {
			PreparedStatement ps = c1.prepareStatement(str);
			ps.setString(1,fnamesearcht.getText());
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				numt2.setText(""+rs.getInt("��ȣ"));
				fnamet2.setText(""+rs.getString("�̸�"));
				madet2.setText(""+rs.getString("���ۻ�"));
				pricet2.setText(""+rs.getInt("����"));
			}
			ps.executeUpdate();
			ps.close();
			for (int i = 0; i < icon4.length; i++) {
				icon4[i] = new ImageIcon((i+1)+".jpg");
				if (numt2.getText().equals(""+i)) {
					for (int j = 0; j < icon4.length; j++) {
						photo.setIcon(icon4[i-1]);
						photo.setText("");
					}
				}
				photolocation.setVisible(true);
			}
		} catch (SQLException e1) {
			JOptionPane.showMessageDialog(null,"�˻������ ����");
		}
	});
	next2.addActionListener(e->{
			try {
				rs.next();
				numt2.setText(""+rs.getInt("��ȣ"));
				fnamet2.setText(""+rs.getString("�̸�"));
				madet2.setText(""+rs.getString("���ۻ�"));
				pricet2.setText(""+rs.getInt("����"));
				for (int i = 0; i < icon4.length; i++) {
					icon4[i] = new ImageIcon((i+1)+".jpg");
					if (numt2.getText().equals(""+i)) {
						for (int j = 0; j < icon4.length; j++) {
							photo.setIcon(icon4[i-1]);
							photo.setText("");
						}
					}

					photolocation.setVisible(true);
				}
				
			} catch (SQLException e1) {
				JOptionPane.showMessageDialog(null,"��������");
			}
		
	});
	previous2.addActionListener(e->{
		try {
			rs.previous();
			numt2.setText(""+rs.getInt("��ȣ"));
			fnamet2.setText(""+rs.getString("�̸�"));
			madet2.setText(""+rs.getString("���ۻ�"));
			pricet2.setText(""+rs.getInt("����"));
			for (int i = 0; i < icon4.length; i++) {
				icon4[i] = new ImageIcon((i+1)+".jpg");
				if (numt2.getText().equals(""+i)) {
					for (int j = 0; j < icon4.length; j++) {
						photo.setIcon(icon4[i-1]);
						photo.setText("");
					}
				}

				photolocation.setVisible(true);
			}
			
		} catch (SQLException e1) {
			JOptionPane.showMessageDialog(null,"ó����");
		}
	
	});
	floct.addActionListener(e->{
		
			String number = floct.getSelectedItem().toString();
			if (number.equals("����/���")) {
				location = "3~5��";
			}
			if (number.equals("���ܰ�")) {
				location = "3~7��";
			}
			if (number.equals("����")) {
				location = "5~7��";
			}
			if (number.equals("�հ�~")) {
				location = "7~10�� �̻�";
			}
		});
	select.addActionListener(e->{
		JOptionPane.getFrameForComponent(new �����ϴ�â());
		int a = Integer.parseInt(fnumt.getText());
		int b = Integer.parseInt(pricet2.getText());
		total.setText(fnamet2.getText()+" "+colorresult+" "+ a+"��"+" "+(a*b)+"��");
	});
	buy2.addActionListener(e->{
		String number = color.getSelectedItem().toString();
		String number2 = floct.getSelectedItem().toString();
		
		System.out.println(number);
		if(numt2.getText().equals("")){
			JOptionPane.showMessageDialog(null,"������ �������ּ���");
		}
		else if (fnumt.getText().equals("")) {
			JOptionPane.showMessageDialog(null,"������ �Է��� �ּ���");
		}

		else if (e.getSource()==floct) {
			JOptionPane.showMessageDialog(null,"������ �������ּ���");
		}
	

		else if (e.getSource()==color) {
			JOptionPane.showMessageDialog(null,"������ �������ּ���");
		}
		else if (total.getText().equals("")) {
			 JOptionPane.showMessageDialog(null,"����� �������ּ���");
		 }
		else {
			
		int a = Integer.parseInt(fnumt.getText());
		int b = Integer.parseInt(pricet2.getText());
		JOptionPane.showMessageDialog(null,"������ "+(a*b)+"��"+" "+location+" �ҿ�� ����");
		c.show(cp,"2������");
		}
	});
	back2.addActionListener(e->{
		c.show(cp,"2������");
	});
	//4������ ����
	title2.setBounds(300,10,250,150);
	title2.setBackground(new Color(0,0,0,0));
	title2.setFont(new Font("����",Font.BOLD,50));
	joinid.setBounds(80,300,100,30);
	joinpass.setBounds(80,350,100,30);
	addr.setBounds(80,400,100,30);
	phonenum.setBounds(80,450,100,30);
	joinidt.setBounds(180,300,100,30);
	joinpasst.setBounds(180,350,100,30);
	addrt.setBounds(180,400,100,30);
	phonenumt.setBounds(180,450,100,30);
	agree.setBounds(450,350,100,30);
	agreesc.setBounds(550,300,120,150);
	agreet.setEditable(false);
	agreeb.setBounds(550,450,150,50);
	agreeb.setBackground(new Color(0,0,0,0));
	joinb.setBounds(200,500,100,30);
	close2.setBounds(500,500,100,30);
	joinb.setBackground(new Color(100,150,100,180));
	close2.setBackground(new Color(100,150,100,180));
	img2.setBounds(0,0,800,600);
	p4.add(title2);
	p4.add(joinid);p4.add(joinpass);p4.add(addr);p4.add(phonenum);
	p4.add(joinidt);p4.add(joinpasst);p4.add(addrt);p4.add(phonenumt);
	p4.add(agree);p4.add(agreesc);p4.add(agreeb);
	p4.add(joinb);p4.add(close2);
	p4.add(img2);
	//4������ ��ư�׼Ǵޱ�
	joinb.addActionListener(e->{
		if (joinidt.getText().equals("����")) {
			JOptionPane.showMessageDialog(null,"���̵� �ߺ���");
		}
		if (joinidt.getText().equals("")||joinpasst.getText().equals("")||addrt.getText().equals("")||phonenumt.getText().equals("")) {
			JOptionPane.showMessageDialog(null,"���Զ� �� ä���");
		}
		else if (agreeb.isSelected()) {
			
		String str = "INSERT INTO ȸ�� VALUES (?,?,?,?)";
		try {
			PreparedStatement ps = c1.prepareStatement(str);
			ps.setString(1,joinidt.getText());
			ps.setString(2,joinpasst.getText());
			ps.setString(3,addrt.getText());
			ps.setString(4,phonenumt.getText());
			ps.executeUpdate();
			ps.close();
			JOptionPane.showMessageDialog(null,"ȸ������ �Ϸ�");
			c.show(cp,"1������");
			idt.setText("");
			passt.setText("");
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		
		}
		else {
			JOptionPane.showMessageDialog(null,"���ǻ��� üũ��?");
		}
		agreeb.setSelected(false);
	});
	close2.addActionListener(e->{
		c.show(cp,"1������");
	});

	
	//�гε��� ī�巹�̾ƿ��� �߰��ϱ�
	cp.add(p1,"1������");
	cp.add(p2,"2������");
	cp.add(p3,"3������");
	cp.add(p4,"4������");
	
	add(cp);
	setLocation(500,150);
	setVisible(true);
}
private Connection �����Ѵ�() {
	String url = "jdbc:oracle:thin:192.168.0.48:1521:orcl";
	String user = "blue1";
	String password = "123456";
	Connection c1 = null;
	try {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		c1 = DriverManager.getConnection(url, user, password);
		System.out.println("���� ����");
	} catch (Exception e) {
	}
	return c1;
}
public static void main(String[] args) throws Exception {
	new ������();
}
}

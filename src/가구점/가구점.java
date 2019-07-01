package 가구점;

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

public class 가구점 extends JFrame{
	//오라클 연결
	Statement s;
	String sql = "select 번호,이름,제작사,가격 from 가구 order by 번호";
	ResultSet rs;
	//카드레이아웃
	CardLayout c = new CardLayout();
	JPanel cp = new  JPanel(c);
	//이미지 아이콘
	ImageIcon icon = new ImageIcon("ㅐㅐ.jpg");
	ImageIcon icon2 = new ImageIcon("가입.jpg");
	ImageIcon icon3 = new ImageIcon("배경2.jpg");
	JLabel img3 = new JLabel(icon3);
	JLabel img2 = new JLabel(icon2);
	JLabel img = new JLabel(icon);
	ImageIcon[] icon1 = new ImageIcon[100];
	ImageIcon[] icon4 = new ImageIcon[100];
	//가구 이미지
	ImageIcon ff = new ImageIcon("1.jpg");
	ImageIcon ff2 = new ImageIcon("아래.jpg");
	//1페이지
	JPanel p1 = new JPanel(null);
	JLabel title = new JLabel("가구점");//1페이지 제목
	JLabel id = new JLabel("아이디");
	JTextField idt = new JTextField(15);
	JLabel pass = new JLabel("비밀번호");
	JPasswordField passt = new JPasswordField(15);
	JButton log = new JButton("로그인");
	JButton logout = new JButton("로그아웃");
	JButton join = new JButton("회원가입");
	JButton close = new JButton("닫기");
	//2페이지
	JPanel p2 = new JPanel(null);
	JLabel photolocation = new JLabel();
	JLabel photolocation2 = new JLabel(ff2);
	JLabel num = new JLabel("번호");
	JLabel fname = new JLabel("가구명");
	JLabel made = new JLabel("제작사");
	JLabel price = new JLabel("가격");
	JTextField numt = new JTextField();
	JTextField fnamet = new JTextField();
	JTextField madet = new JTextField();
	JTextField pricet = new JTextField();
	JLabel search = new JLabel("가구명 검색");
	JLabel information = new JLabel("상세정보");
	JTextField searcht = new JTextField();
	JTextArea informationt = new JTextArea();
	JScrollPane sc = new JScrollPane(informationt);
	JButton next = new JButton("다음");
	JButton previous = new JButton("이전");
	JButton madevalue = new JButton("제작사별");
	JButton buy = new JButton("구매하러가기");
	JButton back = new JButton("뒤로");
	//3페이지 
	JPanel p3 = new JPanel(null);
	JLabel title3 = new JLabel("구매");
	JLabel num2 = new JLabel("번호");
	JLabel fname2 = new JLabel("가구명");
	JLabel made2 = new JLabel("제작사");
	JLabel price2 = new JLabel("가격");
	JLabel fnamesearch = new JLabel("가구명 검색");
	JTextField numt2 = new JTextField();
	JTextField fnamet2 = new JTextField();
	JTextField madet2 = new JTextField();
	JTextField pricet2 = new JTextField();
	JTextField fnamesearcht = new JTextField();
	JButton next2 = new JButton("다음");
	JButton previous2 = new JButton("이전");
	JLabel photo = new JLabel("사진나와유");
	JLabel floc = new JLabel("배송지");
	JComboBox floct = new JComboBox(new String[] {"서울/경기","경기외곽","지방","먼곳~"});
	String location = "";
	JLabel fnum = new JLabel("갯수 입력");
	JTextField fnumt = new JTextField();
	JButton select = new JButton("약관");
	JTextField total = new JTextField();
	JButton buy2 = new JButton("구매");
	JButton back2 = new JButton("뒤로");
	JLabel colorl = new JLabel("색상");
	JComboBox color = new JComboBox(new String[] {"원색","빨강","노랑","초록","파랑"});
	String colorresult="";
	
	
	//4페이지
	JPanel p4 = new JPanel(null);
	JLabel title2 = new JLabel("회원가입");
	JLabel joinid = new JLabel("아이디");
	JLabel joinpass = new JLabel("비밀번호");
	JLabel addr = new JLabel("주소");
	JLabel phonenum = new JLabel("전화번호");
	JTextField joinidt = new JTextField();
	JPasswordField joinpasst = new JPasswordField();
	JTextField addrt = new JTextField();
	JTextField phonenumt = new JTextField();
	JLabel agree = new JLabel("동의사항");
	JTextArea agreet = new JTextArea("동의사항이 \n적혀있다고 친다");
	JScrollPane agreesc = new JScrollPane(agreet);
	JCheckBox agreeb = new JCheckBox("동의(필수)");
	JButton joinb = new JButton("회원가입");
	JButton close2 = new JButton("닫기");
	
	
	
	
public 가구점() throws Exception {
	//오라클 연결
		Connection c1 = 연결한당();
		s = c1.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
		rs = s.executeQuery(sql);
	setSize(800,600);
	setDefaultLookAndFeelDecorated(true);
	setDefaultCloseOperation(EXIT_ON_CLOSE);
	//1페이지
	title.setBounds(340,10,200,150);
	title.setFont(new Font("굴림",Font.BOLD,50));
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
	//1페이지 버튼에 액션달기
	passt.addActionListener(e->{
		if (idt.getText().equals("")) {
			JOptionPane.showMessageDialog(null,"아이디 누르셈");
		}
	else if (passt.getText().equals("")) {
			JOptionPane.showMessageDialog(null,"비번 누르셈");
		}
		else {
			
			JOptionPane.showMessageDialog(null,"성공");
			c.show(cp,"2페이지");
		}
	});
	log.addActionListener(e->{
		if (!idt.getText().equals("")||!passt.getText().equals("")) {
			
		try {
			String str = "select 아이디,비밀번호 from 회원 where 아이디 = ? and 비밀번호 = ?";
			PreparedStatement ps = c1.prepareStatement(str);
			ps.setString(1,idt.getText());
			ps.setString(2,passt.getText());
			ps.executeUpdate();
			ps.close();
			JOptionPane.showMessageDialog(null,"성공");
			c.show(cp,"2페이지");
		} catch (SQLException e1) {
		}
		}else {
			JOptionPane.showMessageDialog(null,"실패");
		}
		
		
		
	});
	logout.addActionListener(e->{
		idt.setText("");
		passt.setText("");
		JOptionPane.showMessageDialog(null,"로그아웃");
	});
	join.addActionListener(e->{
		joinidt.setText("");
		joinpasst.setText("");
		addrt.setText("");
		phonenumt.setText("");
		
		c.show(cp,"4페이지");
		});
	close.addActionListener(e->{
		dispose();
	});
	//2페이지
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
	
	//2페이지 버튼에 액션달긔
	next.addActionListener(e->{
		try {
			rs.next();
			numt.setText(""+rs.getInt("번호"));
			fnamet.setText(""+rs.getString("이름"));
			madet.setText(""+rs.getString("제작사"));
			pricet.setText(""+rs.getInt("가격"));
			for (int i = 0; i < icon1.length; i++) {
				icon1[i] = new ImageIcon((i+1)+".jpg");
				if (numt.getText().equals(""+i)) {
					for (int j = 0; j < icon1.length; j++) {
						photolocation.setIcon(icon1[i-1]);
						photolocation.setText("");
						informationt.setText(fnamet.getText()+"에 대한 정보");
					}
				}

				photolocation.setVisible(true);
			}
			
		} catch (SQLException e1) {
			JOptionPane.showMessageDialog(null,"마지막임");
		}
	});
	previous.addActionListener(e->{
		try {
			rs.previous();
			numt.setText(""+rs.getInt("번호"));
			fnamet.setText(""+rs.getString("이름"));
			madet.setText(""+rs.getString("제작사"));
			pricet.setText(""+rs.getInt("가격"));
			for (int i = 0; i < icon1.length; i++) {
				icon1[i] = new ImageIcon((i+1)+".jpg");
				if (numt.getText().equals(""+i)) {
					for (int j = 0; j < icon1.length; j++) {
						photolocation.setIcon(icon1[i-1]);
						photolocation.setText("");
						informationt.setText(fnamet.getText()+"에 대한 정보");
					}
				}

				photolocation.setVisible(true);
			}
			
		} catch (SQLException e1) {
			JOptionPane.showMessageDialog(null,"처음임");
		}
	});
	
	searcht.addActionListener(e->{
		String str = "select 번호,이름,제작사,가격 from 가구 where 이름=?";
		try {
			
			PreparedStatement ps = c1.prepareStatement(str);
			ps.setString(1,searcht.getText());
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				numt.setText(""+rs.getInt("번호"));
				fnamet.setText(""+rs.getString("이름"));
				madet.setText(""+rs.getString("제작사"));
				pricet.setText(""+rs.getInt("가격"));
				
			}
			ps.executeUpdate();
			ps.close();
			for (int i = 0; i < icon1.length; i++) {
				icon1[i] = new ImageIcon((i+1)+".jpg");
				if (numt.getText().equals(""+i)) {
					for (int j = 0; j < icon1.length; j++) {
						photolocation.setIcon(icon1[i-1]);
						photolocation.setText("");
						informationt.setText(fnamet.getText()+"에 대한 정보");
					}
				}
				photolocation.setVisible(true);
			}

			
		} catch (SQLException e1) {
			JOptionPane.showMessageDialog(null,"검색결과가 없음");
		}
	});
	madevalue.addActionListener(e->{
		JOptionPane.getFrameForComponent(new 가구의전당());
		JOptionPane.getFrameForComponent(new 가구의전당2());
	});
	buy.addActionListener(e->{
		c.show(cp,"3페이지");
	});
	back.addActionListener(e->{
		idt.setText("");
		passt.setText("");
		c.show(cp,"1페이지");
	});
	//3페이지 구성
	title3.setBounds(350,10,150,100);
	title3.setFont(new Font("굴림",Font.BOLD,50));
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
	//3페이지 액션
	color.addItemListener(e->{
		colorresult = color.getSelectedItem().toString();
			
		
	});
	fnamesearcht.addActionListener(e->{
		String str = "select 번호,이름,제작사,가격 from 가구 where 이름=?";
		try {
			PreparedStatement ps = c1.prepareStatement(str);
			ps.setString(1,fnamesearcht.getText());
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				numt2.setText(""+rs.getInt("번호"));
				fnamet2.setText(""+rs.getString("이름"));
				madet2.setText(""+rs.getString("제작사"));
				pricet2.setText(""+rs.getInt("가격"));
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
			JOptionPane.showMessageDialog(null,"검색결과가 없음");
		}
	});
	next2.addActionListener(e->{
			try {
				rs.next();
				numt2.setText(""+rs.getInt("번호"));
				fnamet2.setText(""+rs.getString("이름"));
				madet2.setText(""+rs.getString("제작사"));
				pricet2.setText(""+rs.getInt("가격"));
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
				JOptionPane.showMessageDialog(null,"마지막임");
			}
		
	});
	previous2.addActionListener(e->{
		try {
			rs.previous();
			numt2.setText(""+rs.getInt("번호"));
			fnamet2.setText(""+rs.getString("이름"));
			madet2.setText(""+rs.getString("제작사"));
			pricet2.setText(""+rs.getInt("가격"));
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
			JOptionPane.showMessageDialog(null,"처음임");
		}
	
	});
	floct.addActionListener(e->{
		
			String number = floct.getSelectedItem().toString();
			if (number.equals("서울/경기")) {
				location = "3~5일";
			}
			if (number.equals("경기외곽")) {
				location = "3~7일";
			}
			if (number.equals("지방")) {
				location = "5~7일";
			}
			if (number.equals("먼곳~")) {
				location = "7~10일 이상";
			}
		});
	select.addActionListener(e->{
		JOptionPane.getFrameForComponent(new 동의하는창());
		int a = Integer.parseInt(fnumt.getText());
		int b = Integer.parseInt(pricet2.getText());
		total.setText(fnamet2.getText()+" "+colorresult+" "+ a+"개"+" "+(a*b)+"원");
	});
	buy2.addActionListener(e->{
		String number = color.getSelectedItem().toString();
		String number2 = floct.getSelectedItem().toString();
		
		System.out.println(number);
		if(numt2.getText().equals("")){
			JOptionPane.showMessageDialog(null,"가구를 선택해주세요");
		}
		else if (fnumt.getText().equals("")) {
			JOptionPane.showMessageDialog(null,"갯수를 입력해 주세요");
		}

		else if (e.getSource()==floct) {
			JOptionPane.showMessageDialog(null,"지역을 선택해주세요");
		}
	

		else if (e.getSource()==color) {
			JOptionPane.showMessageDialog(null,"색상을 선택해주세요");
		}
		else if (total.getText().equals("")) {
			 JOptionPane.showMessageDialog(null,"약관에 동의해주세요");
		 }
		else {
			
		int a = Integer.parseInt(fnumt.getText());
		int b = Integer.parseInt(pricet2.getText());
		JOptionPane.showMessageDialog(null,"가격은 "+(a*b)+"원"+" "+location+" 소요될 예정");
		c.show(cp,"2페이지");
		}
	});
	back2.addActionListener(e->{
		c.show(cp,"2페이지");
	});
	//4페이지 구성
	title2.setBounds(300,10,250,150);
	title2.setBackground(new Color(0,0,0,0));
	title2.setFont(new Font("굴림",Font.BOLD,50));
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
	//4페이지 버튼액션달기
	joinb.addActionListener(e->{
		if (joinidt.getText().equals("규태")) {
			JOptionPane.showMessageDialog(null,"아이디 중복됨");
		}
		if (joinidt.getText().equals("")||joinpasst.getText().equals("")||addrt.getText().equals("")||phonenumt.getText().equals("")) {
			JOptionPane.showMessageDialog(null,"가입란 다 채우셈");
		}
		else if (agreeb.isSelected()) {
			
		String str = "INSERT INTO 회원 VALUES (?,?,?,?)";
		try {
			PreparedStatement ps = c1.prepareStatement(str);
			ps.setString(1,joinidt.getText());
			ps.setString(2,joinpasst.getText());
			ps.setString(3,addrt.getText());
			ps.setString(4,phonenumt.getText());
			ps.executeUpdate();
			ps.close();
			JOptionPane.showMessageDialog(null,"회원가입 완료");
			c.show(cp,"1페이지");
			idt.setText("");
			passt.setText("");
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		
		}
		else {
			JOptionPane.showMessageDialog(null,"동의사항 체크함?");
		}
		agreeb.setSelected(false);
	});
	close2.addActionListener(e->{
		c.show(cp,"1페이지");
	});

	
	//패널들을 카드레이아웃에 추가하기
	cp.add(p1,"1페이지");
	cp.add(p2,"2페이지");
	cp.add(p3,"3페이지");
	cp.add(p4,"4페이지");
	
	add(cp);
	setLocation(500,150);
	setVisible(true);
}
private Connection 연결한당() {
	String url = "jdbc:oracle:thin:192.168.0.48:1521:orcl";
	String user = "blue1";
	String password = "123456";
	Connection c1 = null;
	try {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		c1 = DriverManager.getConnection(url, user, password);
		System.out.println("연결 성공");
	} catch (Exception e) {
	}
	return c1;
}
public static void main(String[] args) throws Exception {
	new 가구점();
}
}

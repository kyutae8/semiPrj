package 가구점;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ItemEvent;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class 동의하는창 extends JFrame{
	
	//이미지 아이콘
	ImageIcon icon = new ImageIcon("동의.jpg");
	JLabel img = new JLabel(icon);
	//5페이지 구성
	JPanel p5 = new JPanel(null);
	JPanel p5n = new JPanel();
	JLabel title5 = new JLabel("필수동의사항",JLabel.CENTER);
	JPanel p5c = new JPanel();
	JPanel p5cn = new JPanel();
	JPanel p5cc = new JPanel();
	
	String informationstr = "바다건너거나 그러면 배송 안되니까 동의하세요";
	String informationstr2 = "교환,환불이 안되니 동의하세요";
	JLabel information = new JLabel(informationstr);
	JCheckBox agree = new JCheckBox("동의(필수)");
	JLabel information2 = new JLabel(informationstr2);
	JCheckBox agree2 = new JCheckBox("동의(필수)");
	JPanel p5s = new JPanel();
	JButton next5 = new JButton("다음으로 넘어가기");
	JButton close5 = new JButton("닫기");
	int agreeint = 0;
	int agree2int = 0;
	//카드레이아웃 설정
	CardLayout c = new CardLayout();
	JPanel cp = new JPanel(c);
	
	//6페이지 구성
	JPanel p6 = new JPanel();
	
	JTextField t = new JTextField();
	
	
	
	public 동의하는창() {
		title5.setFont(new Font("굴림", Font.BOLD,50));
		agree.setBackground(new Color(0,0,0,0));
		agree2.setBackground(new Color(0,0,0,0));
		next5.setBackground(new Color(100,150,100,180));
		close5.setBackground(new Color(100,150,100,180));
		information.setForeground(Color.BLACK);
		agree.setBackground(Color.white);
		agree2.setBackground(Color.white);
		information2.setForeground(Color.BLACK);
		information.setFont(new Font("고딕", Font.BOLD,15));
		information2.setFont(new Font("고딕", Font.BOLD,15));
	JPanel back5 = new JPanel();
	back5.setBackground(new Color(0,0,0,0));
	back5.setBounds(0,0,500,300);
	back5.setLayout(new GridLayout(0,1));
	p5n.setBackground(new Color(0,0,0,0));
	p5cn.setBackground(new Color(0,0,0,0));
	p5cc.setBackground(new Color(0,0,0,0));
	p5c.setBackground(new Color(0,0,0,0));
	p5s.setBackground(new Color(0,0,0,0));
	p5n.add(title5,"Center");
	p5cn.add(information);p5cn.add(agree);
	p5cn.setLayout(new BoxLayout(p5cn,BoxLayout.Y_AXIS));
	p5cc.add(information2);p5cc.add(agree2);
	p5cc.setLayout(new BoxLayout(p5cc,BoxLayout.Y_AXIS));
	p5c.setLayout(new BoxLayout(p5c,BoxLayout.Y_AXIS));
	p5c.add(p5cn);p5c.add(p5cc);
	p5s.add(next5);p5s.add(close5);
	img.setBounds(0,0,500,300);
	back5.add(p5n,"North");back5.add(p5c,"Center");back5.add(p5s,"South");
	p5.add(back5);
	//5페이지 액션달기
	agree.addItemListener(e->{
		if (e.getStateChange()==ItemEvent.SELECTED) {
			agreeint = 1;
		}else {
			agreeint =0;
		}
	});
	agree2.addItemListener(e->{
		if (e.getStateChange()==ItemEvent.SELECTED) {
			agree2int = 1;
		}else {
			agree2int =0;
		}
	});
	next5.addActionListener(e->{
		if (agreeint+agree2int==2) {
			JOptionPane.showMessageDialog(null,"동의 완료!");
			dispose();
		}
		else {
			JOptionPane.showMessageDialog(null,"동의 실패!");
		}
	});
	close5.addActionListener(e->{
	
		dispose();
	});
	cp.add(p5,"5페이지");
	add(cp);
	setSize(500,300);
	setDefaultCloseOperation(EXIT_ON_CLOSE);
	
	
	p5.add(img);
	setLocation(700,400);
	setVisible(true);
	}
	public static void main(String[] args) {
		new 동의하는창();
	}
}

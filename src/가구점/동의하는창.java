package ������;

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

public class �����ϴ�â extends JFrame{
	
	//�̹��� ������
	ImageIcon icon = new ImageIcon("����.jpg");
	JLabel img = new JLabel(icon);
	//5������ ����
	JPanel p5 = new JPanel(null);
	JPanel p5n = new JPanel();
	JLabel title5 = new JLabel("�ʼ����ǻ���",JLabel.CENTER);
	JPanel p5c = new JPanel();
	JPanel p5cn = new JPanel();
	JPanel p5cc = new JPanel();
	
	String informationstr = "�ٴٰǳʰų� �׷��� ��� �ȵǴϱ� �����ϼ���";
	String informationstr2 = "��ȯ,ȯ���� �ȵǴ� �����ϼ���";
	JLabel information = new JLabel(informationstr);
	JCheckBox agree = new JCheckBox("����(�ʼ�)");
	JLabel information2 = new JLabel(informationstr2);
	JCheckBox agree2 = new JCheckBox("����(�ʼ�)");
	JPanel p5s = new JPanel();
	JButton next5 = new JButton("�������� �Ѿ��");
	JButton close5 = new JButton("�ݱ�");
	int agreeint = 0;
	int agree2int = 0;
	//ī�巹�̾ƿ� ����
	CardLayout c = new CardLayout();
	JPanel cp = new JPanel(c);
	
	//6������ ����
	JPanel p6 = new JPanel();
	
	JTextField t = new JTextField();
	
	
	
	public �����ϴ�â() {
		title5.setFont(new Font("����", Font.BOLD,50));
		agree.setBackground(new Color(0,0,0,0));
		agree2.setBackground(new Color(0,0,0,0));
		next5.setBackground(new Color(100,150,100,180));
		close5.setBackground(new Color(100,150,100,180));
		information.setForeground(Color.BLACK);
		agree.setBackground(Color.white);
		agree2.setBackground(Color.white);
		information2.setForeground(Color.BLACK);
		information.setFont(new Font("���", Font.BOLD,15));
		information2.setFont(new Font("���", Font.BOLD,15));
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
	//5������ �׼Ǵޱ�
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
			JOptionPane.showMessageDialog(null,"���� �Ϸ�!");
			dispose();
		}
		else {
			JOptionPane.showMessageDialog(null,"���� ����!");
		}
	});
	close5.addActionListener(e->{
	
		dispose();
	});
	cp.add(p5,"5������");
	add(cp);
	setSize(500,300);
	setDefaultCloseOperation(EXIT_ON_CLOSE);
	
	
	p5.add(img);
	setLocation(700,400);
	setVisible(true);
	}
	public static void main(String[] args) {
		new �����ϴ�â();
	}
}

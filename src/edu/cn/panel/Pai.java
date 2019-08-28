package edu.cn.panel;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import edu.cn.rulesPanel.PokerPanel;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Container;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;


public class Pai extends JFrame {
	
	private JPanel contentPane;
	PokerPanel panel2 = null;
	private int role = -1;   //��ҽ�ɫ��־
	
	//��Ϸ������
	public Pai(int r) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 0, 5, 0));
		setContentPane(contentPane);
		
		//���ô��ڴ�С��λ�á�����
		this.setSize(780, 670);
		this.setLocation(500,200);
		this.setTitle("21���˿�����Ϸ");
		this.setVisible(true);
		
		//���ô��ڱ���ͼƬ
		ImageIcon bgIcon = new ImageIcon("imgs//bg8.jpeg");
		JLabel bgLabel = new JLabel(bgIcon);
	    this.getLayeredPane().add(bgLabel, new Integer(Integer.MIN_VALUE));
	    getContentPane().setLayout(null);
		bgLabel.setBounds(0, 0, this.getWidth(), this.getHeight());
		((JPanel)this.getContentPane()).setOpaque(false);
		
		role = r;
		//System.out.println("testtesttest"+r);
		
		//��ֵͨ������
		ImageIcon chongIcon = new ImageIcon("imgs//recharge2.jpg");
		if(role == 2) {
			JOptionPane.showMessageDialog(null, "", "�߼���ҳ�ֵͨ��", JOptionPane.YES_NO_OPTION, chongIcon);
		}
		if(role == 3) {
			JOptionPane.showMessageDialog(null, "", "������ҳ�ֵͨ��", JOptionPane.YES_NO_OPTION, chongIcon);
		}
		
		panel2 = new PokerPanel(role); //��Ϸ�����
		JPanel panel = new JPanel();  //��ϷLOGO���
		
		JPanel panel3 = new JPanel();  //��Ϸ�������
		
		panel.setOpaque(false);
		panel3.setOpaque(false);
		
		String urlString = "imgs//bg5.png";  // ��־������
		JLabel label = new JLabel(new ImageIcon(urlString));
		panel2.setLayout(new BorderLayout());	
		
		//��Ϸ���沼��
		this.getContentPane().setLayout(new BorderLayout());
		this.getContentPane().add(panel, BorderLayout.NORTH);
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addComponent(label, GroupLayout.PREFERRED_SIZE, 764, GroupLayout.PREFERRED_SIZE)
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addComponent(label)
		);
		panel.setLayout(gl_panel);
		this.getContentPane().add(panel2, BorderLayout.CENTER);
		this.getContentPane().add(panel3, BorderLayout.SOUTH);
		
		//���ذ�ť
		ImageIcon btnImage = new ImageIcon("imgs//home1.png");
		JButton return_button = new JButton(btnImage);
		return_button.setContentAreaFilled(false);
		return_button.setBorderPainted(false);
		return_button.setFocusPainted(false);
		return_button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		
		//���Ҫ�ư�ť
		JButton faCard = new JButton("���Ҫ��");
		faCard.setFont(new Font("����", Font.PLAIN, 25));
		faCard.setBorderPainted(false);
		faCard.setBackground(new Color(255, 204, 153));
		faCard.setFocusPainted(false);


		faCard.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		
		//���ͣ�ƣ�����������Ϸ����ť
		JButton stopCard = new JButton("���ͣ��");
		stopCard.setFont(new Font("����", Font.PLAIN, 25));
		stopCard.setBorderPainted(false);
		stopCard.setBackground(new Color(255, 204, 153));
		stopCard.setFocusPainted(false);
		
		//��ʼ��Ϸ��ť
		JButton begin_game = new JButton("��ʼ��Ϸ");
		begin_game.setBackground(new Color(255, 204, 153));
		begin_game.setFont(new Font("����", Font.PLAIN, 25));
		begin_game.setBorderPainted(false);
		begin_game.setFocusPainted(false);

		

		begin_game.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		
		GroupLayout gl_panel3 = new GroupLayout(panel3);
		gl_panel3.setHorizontalGroup(
			gl_panel3.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel3.createSequentialGroup()
					.addGap(158)
					.addComponent(faCard, GroupLayout.PREFERRED_SIZE, 146, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(stopCard, GroupLayout.PREFERRED_SIZE, 145, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(begin_game)
					.addGap(56)
					.addComponent(return_button, GroupLayout.PREFERRED_SIZE, 55, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(35, Short.MAX_VALUE))
		);
		gl_panel3.setVerticalGroup(
			gl_panel3.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_panel3.createSequentialGroup()
					.addGap(13)
					.addGroup(gl_panel3.createParallelGroup(Alignment.BASELINE)
						.addComponent(faCard, GroupLayout.PREFERRED_SIZE, 41, GroupLayout.PREFERRED_SIZE)
						.addComponent(stopCard, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
						.addComponent(begin_game, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
					.addGap(13))
				.addGroup(gl_panel3.createSequentialGroup()
					.addContainerGap()
					.addComponent(return_button, GroupLayout.DEFAULT_SIZE, 47, Short.MAX_VALUE)
					.addContainerGap())
		);
		panel3.setLayout(gl_panel3);
		
		faCard.setEnabled(false);
		stopCard.setEnabled(false);
		
		//����¼�
		return_button.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				super.mouseClicked(e);
				ChooseRoles chooseRoles = new ChooseRoles();
				dispose();
			}
		});
		
		faCard.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				if(panel2.getNum1()>=2) {
					int flag = JOptionPane.showConfirmDialog(null,"�Ƿ������ע?");
					if(flag == JOptionPane.YES_OPTION) {
						panel2.setMoney(panel2.getMoney() + Float.parseFloat(JOptionPane.showInputDialog(null,"�����ע��")));
					}
				}
				if(panel2.getNum1()<5 && panel2.isMyLose()==false) {
					if(panel2.getRoles()==1)
						panel2.faCard();
					else if(panel2.getRoles()==2)
						panel2.faCardToHigh();
				}
				if(panel2.isComputerContinue() && panel2.getNum2()<5)
					panel2.faCardToComputer();
				if(panel2.getRoles()==3)
					faCard.setEnabled(false);
			}
		});
		
		stopCard.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				while(panel2.isComputerContinue())
					panel2.faCardToComputer();
				panel2.winOrnot();
				stopCard.setEnabled(false);
			}
		});
		
		begin_game.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				panel2.setMoney(Float.parseFloat(JOptionPane.showInputDialog(null, "������Ͷע�����ʣ�1.5��")));
				panel2.newGame();
				faCard.setEnabled(true);
				stopCard.setEnabled(true);
			}
		});
		
	}
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		Pai pai = new Pai(1);
	}

}

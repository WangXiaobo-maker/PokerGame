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
	private int role = -1;   //玩家角色标志
	
	//游戏主界面
	public Pai(int r) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 0, 5, 0));
		setContentPane(contentPane);
		
		//设置窗口大小、位置、名字
		this.setSize(780, 670);
		this.setLocation(500,200);
		this.setTitle("21点扑克牌游戏");
		this.setVisible(true);
		
		//设置窗口背景图片
		ImageIcon bgIcon = new ImageIcon("imgs//bg8.jpeg");
		JLabel bgLabel = new JLabel(bgIcon);
	    this.getLayeredPane().add(bgLabel, new Integer(Integer.MIN_VALUE));
	    getContentPane().setLayout(null);
		bgLabel.setBounds(0, 0, this.getWidth(), this.getHeight());
		((JPanel)this.getContentPane()).setOpaque(false);
		
		role = r;
		//System.out.println("testtesttest"+r);
		
		//充值通道窗口
		ImageIcon chongIcon = new ImageIcon("imgs//recharge2.jpg");
		if(role == 2) {
			JOptionPane.showMessageDialog(null, "", "高级玩家充值通道", JOptionPane.YES_NO_OPTION, chongIcon);
		}
		if(role == 3) {
			JOptionPane.showMessageDialog(null, "", "超级玩家充值通道", JOptionPane.YES_NO_OPTION, chongIcon);
		}
		
		panel2 = new PokerPanel(role); //游戏主面板
		JPanel panel = new JPanel();  //游戏LOGO面板
		
		JPanel panel3 = new JPanel();  //游戏控制面板
		
		panel.setOpaque(false);
		panel3.setOpaque(false);
		
		String urlString = "imgs//bg5.png";  // 标志牌链接
		JLabel label = new JLabel(new ImageIcon(urlString));
		panel2.setLayout(new BorderLayout());	
		
		//游戏界面布局
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
		
		//返回按钮
		ImageIcon btnImage = new ImageIcon("imgs//home1.png");
		JButton return_button = new JButton(btnImage);
		return_button.setContentAreaFilled(false);
		return_button.setBorderPainted(false);
		return_button.setFocusPainted(false);
		return_button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		
		//玩家要牌按钮
		JButton faCard = new JButton("玩家要牌");
		faCard.setFont(new Font("楷体", Font.PLAIN, 25));
		faCard.setBorderPainted(false);
		faCard.setBackground(new Color(255, 204, 153));
		faCard.setFocusPainted(false);


		faCard.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		
		//玩家停牌（结束本局游戏）按钮
		JButton stopCard = new JButton("玩家停牌");
		stopCard.setFont(new Font("楷体", Font.PLAIN, 25));
		stopCard.setBorderPainted(false);
		stopCard.setBackground(new Color(255, 204, 153));
		stopCard.setFocusPainted(false);
		
		//开始游戏按钮
		JButton begin_game = new JButton("开始游戏");
		begin_game.setBackground(new Color(255, 204, 153));
		begin_game.setFont(new Font("楷体", Font.PLAIN, 25));
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
		
		//鼠标事件
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
					int flag = JOptionPane.showConfirmDialog(null,"是否继续加注?");
					if(flag == JOptionPane.YES_OPTION) {
						panel2.setMoney(panel2.getMoney() + Float.parseFloat(JOptionPane.showInputDialog(null,"输入加注金额：")));
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
				panel2.setMoney(Float.parseFloat(JOptionPane.showInputDialog(null, "请输入投注金额（赔率：1.5）")));
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

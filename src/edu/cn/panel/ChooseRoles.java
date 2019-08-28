package edu.cn.panel;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ChooseRoles extends JFrame {

	private JPanel contentPane;
	private int role;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ChooseRoles frame = new ChooseRoles();
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
	//选择玩家角色页面
	public ChooseRoles() {
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		//普通玩家按钮
		JButton Ordinary_player = new JButton("            ");
		Ordinary_player.setFont(new Font("宋体", Font.PLAIN, 30));
		Ordinary_player.setContentAreaFilled(false);
		Ordinary_player.setBorderPainted(false);
		Ordinary_player.setFocusPainted(false);
		
		//高级玩家按钮
		JButton Advanced_Player = new JButton("            ");
		Advanced_Player.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		Advanced_Player.setFont(new Font("宋体", Font.PLAIN, 30));
		Advanced_Player.setContentAreaFilled(false);
		Advanced_Player.setBorderPainted(false);
		Advanced_Player.setFocusPainted(false);
		
		//超级玩家按钮
		JButton Super_player = new JButton("            ");
		Super_player.setFont(new Font("宋体", Font.PLAIN, 30));
		Super_player.setContentAreaFilled(false);
		Super_player.setBorderPainted(false);
		Super_player.setFocusPainted(false);
		
		//设置窗口大小、位置、名字
		this.setSize(780, 670);
		this.setLocation(500,200);
		this.setTitle("21点扑克牌游戏");
		
		//设置窗口背景图片
		ImageIcon bgIcon = new ImageIcon("imgs//choose.png");
		JLabel bgLabel = new JLabel(bgIcon);
	    this.getLayeredPane().add(bgLabel, new Integer(Integer.MIN_VALUE));
	    getContentPane().setLayout(null);
		bgLabel.setBounds(0, 0, this.getWidth(), this.getHeight());
		((JPanel)this.getContentPane()).setOpaque(false);
		
		//返回按钮
		ImageIcon returnImage = new ImageIcon("imgs//return.png");
		JButton return_button = new JButton(returnImage);
		return_button.setContentAreaFilled(false);
		return_button.setBorderPainted(false);
		return_button.setFocusPainted(false);
		
		return_button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		
		
	
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(103)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(Super_player)
								.addComponent(Advanced_Player)
								.addComponent(Ordinary_player)))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(18)
							.addComponent(return_button, GroupLayout.PREFERRED_SIZE, 82, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(439, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap(318, Short.MAX_VALUE)
					.addComponent(Ordinary_player)
					.addGap(31)
					.addComponent(Advanced_Player)
					.addGap(27)
					.addComponent(Super_player)
					.addGap(41)
					.addComponent(return_button, GroupLayout.PREFERRED_SIZE, 66, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
		);
		contentPane.setLayout(gl_contentPane);
		
		
		//普通玩家按钮响应事件
		Ordinary_player.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				super.mouseClicked(e);
				role = 1;
				Pai pai = new Pai(role);
				dispose();

			}
		});
		
		//高级玩家按钮响应事件
		Advanced_Player.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				super.mouseClicked(e);
				setRole(2);
				Pai pai = new Pai(role);
				dispose();
			}
		});
		
		//超级玩家按钮响应事件
		Super_player.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				super.mouseClicked(e);
				role = 3;
				Pai pai = new Pai(role);
				dispose();
			}
		});
		
		//返回按钮响应事件
		return_button.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				super.mouseClicked(e);
				StartGame start = new StartGame();
				start.setVisible(true);
				dispose();
			}
			
		});
		
	}

	public int getRole() {
		return role;
	}

	public void setRole(int role) {
		this.role = role;
	}
}

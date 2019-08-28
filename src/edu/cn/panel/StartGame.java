package edu.cn.panel;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionEvent;

public class StartGame extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StartGame frame = new StartGame();
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
	//开始游戏界面
	public StartGame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		//设置窗口大小、位置、名字
		this.setSize(780, 670);
		this.setLocation(500,200);
		this.setTitle("21点扑克牌游戏");
		
		//设置窗口背景图片
		ImageIcon bgIcon = new ImageIcon("imgs//Welbg.png");
		JLabel bgLabel = new JLabel(bgIcon);
	    this.getLayeredPane().add(bgLabel, new Integer(Integer.MIN_VALUE));
	    getContentPane().setLayout(null);
		bgLabel.setBounds(0, 0, this.getWidth(), this.getHeight());
		((JPanel)this.getContentPane()).setOpaque(false);
		
		//开始游戏按钮
		JButton begin_game = new JButton("          ");
		begin_game.setFont(new Font("宋体", Font.PLAIN, 30));
		begin_game.setContentAreaFilled(false);
		begin_game.setBorderPainted(false);
		begin_game.setFocusPainted(false);
		
		//游戏规则按钮
		JButton game_rules = new JButton("         ");
		game_rules.setFont(new Font("宋体", Font.PLAIN, 30));
		game_rules.setContentAreaFilled(false);
		game_rules.setBorderPainted(false);
		game_rules.setFocusPainted(false);
		
		//开始游戏按钮事件响应函数
		begin_game.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				super.mouseClicked(e);
				ChooseRoles chooseRoles = new ChooseRoles();
				dispose();
			}
		});
		
		//游戏规则按钮事件响应函数
		game_rules.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				super.mouseClicked(e);
				RulesState rules = new RulesState();
				dispose();
			}
			
		});
		
		
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
					.addGap(249)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addComponent(game_rules, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 218, Short.MAX_VALUE)
						.addComponent(begin_game, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 218, Short.MAX_VALUE))
					.addGap(289))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(314)
					.addComponent(begin_game, GroupLayout.PREFERRED_SIZE, 53, GroupLayout.PREFERRED_SIZE)
					.addGap(31)
					.addComponent(game_rules, GroupLayout.PREFERRED_SIZE, 53, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(172, Short.MAX_VALUE))
		);
		contentPane.setLayout(gl_contentPane);
	}

}

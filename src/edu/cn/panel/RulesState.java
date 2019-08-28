package edu.cn.panel;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;

public class RulesState extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RulesState frame = new RulesState();
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
	//游戏规则讲解页面
	public RulesState() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		setVisible(true);
		
		//设置窗口大小、位置、名字
		this.setSize(780, 670);
		this.setLocation(500,200);
		this.setTitle("21点扑克牌游戏");
		
		//设置窗口背景图片
		ImageIcon bgIcon = new ImageIcon("imgs//rules.png");
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
		
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(Alignment.LEADING, gl_contentPane.createSequentialGroup()
					.addGap(20)
					.addComponent(return_button, GroupLayout.PREFERRED_SIZE, 79, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(655, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(555)
					.addComponent(return_button, GroupLayout.DEFAULT_SIZE, 47, Short.MAX_VALUE)
					.addGap(20))
		);
		contentPane.setLayout(gl_contentPane);
		
	}

}

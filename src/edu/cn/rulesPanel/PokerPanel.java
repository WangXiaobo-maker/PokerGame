package edu.cn.rulesPanel;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.text.BreakIterator;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.plaf.basic.BasicTreeUI.TreeCancelEditingAction;

import edu.cn.panel.ChooseRoles;
import edu.cn.panel.ChooseRoles;
import edu.cn.poker.Card;
import edu.cn.poker.Poker;

public class PokerPanel extends JPanel {

	/**
	 * Create the panel.
	 */
	Poker p = new Poker();
	int role = -1;   //玩家角色标志
	public int getRoles() {
		return role;
	}

	public void setRoles(int role) {
		this.role = role;
	}

	int n = 1;     //牌在一副扑克中的位置
	int num1 = 0;  //玩家手中的牌数量
	int num2 = 0;  //庄家手中的牌数量
	float sumMoney = 1000; //玩家拥有金币
	float money = 0;  //玩家投注金币
	boolean flag = false; //游戏结束标志
	
	
	ArrayList myCards = new ArrayList(); //普通玩家的牌
	ArrayList superMycards = new ArrayList();  //超级玩家的牌
	ArrayList computerCards = new ArrayList(); //庄家的牌
	ArrayList cardsNotShow = new ArrayList();  //用于隐藏庄家牌
	int myScore = 0; //玩家得分
	int computerScore = 0;  //庄家得分
	
	private boolean computerContinue = true;
	protected boolean computerLose = false; //庄家输了的标志
	private boolean myLose = false; //玩家输了的标志
	protected boolean highLevel = false;
	
	//洗牌
	public PokerPanel(int r) {
		//setRoles(new Choose());
		role = r;
		if(role == -1) {
			this.setVisible(false);
			return;
		}
		p.xipai();
		p.show();
		this.setVisible(true);
		repaint();
	}
	
	//给普通玩家发牌
	public void faCard() {
		myCards.add(p.getCard(n)); //普通玩家得到一张牌
		calMyScore();
		n++;
		num1++;
		if(num1>=5) {
			JOptionPane.showMessageDialog(null, "手中牌数已达上限！");
		}
		repaint();
		if(myScore > 21) {
			setMyLose(true);
			JOptionPane.showMessageDialog(null, "抱歉！点数超过21点，您输了。","提示",JOptionPane.ERROR_MESSAGE);
		}
	}
	
	//给高级玩家发牌
	public void faCardToHigh() {
		if(!highLevel) {
			JPasswordField pwd = new JPasswordField();
			Object[] message = {"请输入密码验证身份（充值后可获得密码）",pwd}; 
			pwd.requestFocus();
			String[] option = {"确认","取消"};
			int res = JOptionPane.showOptionDialog(null, message, "高级玩家验证", JOptionPane.OK_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE, null, option, null);
		    String password = new String(pwd.getPassword());
			
			if(password.equals("1433223"))
		    	highLevel = true;
		}
		if(highLevel) {
			highLevel = true;
			ImageIcon nextPaI = new ImageIcon(p.getCard(n).getCardImage());
			JOptionPane.showMessageDialog(null, "尊贵的高级玩家：\n您拥有查看下一张牌的权利，下一张牌如左图所示", "下一张牌", JOptionPane.OK_CANCEL_OPTION, nextPaI);
			int pass = JOptionPane.showConfirmDialog(null, "是否要牌");
			if(pass == JOptionPane.YES_OPTION) {
				myCards.add(p.getCard(n));
				num1++;
			}
			calMyScore();
			n++;
			if(num1>=5) {
				JOptionPane.showMessageDialog(null, "手中牌数已达上限！");
			}
			repaint();
			if(myScore > 21) {
				setMyLose(true);
				JOptionPane.showMessageDialog(null, "抱歉！点数超过21点，您输了。","提示",JOptionPane.ERROR_MESSAGE);
			}
		}else {
			JOptionPane.showMessageDialog(null, "身份验证失败！！请充值后再来！！");
		}
	}
	
	//给超级玩家发牌
	public void faCardToSuper() {
		
		String huaString;  //用于提取超级玩家输入的字符串
		String[] sourceStringsArray;  //用于存储分割后的超级玩家输入的字符串
		ImageIcon huaseIcon = new ImageIcon("imgs//huase.jpg");
		String[] realStrings;
		int cardNumber = 0;
		
		huaString = (String)JOptionPane.showInputDialog(null, "花色选择:\n"
				+ "花色   1：黑桃；2：红桃；3：梅花；4：方块\n"
				+ "大小   A～K：1 ～13;  大王：5-1  小王：5-2\n "
				+ "（牌与牌之间以逗号为分隔符）\n"
				+ "例：红桃5 梅花J 大王  输入  2-5,3-11,5-1", "请超级玩家选择您想要的牌", JOptionPane.YES_NO_CANCEL_OPTION, huaseIcon, null, null);
		
		sourceStringsArray = huaString.split(",");
		
		for(int i=0;i<sourceStringsArray.length;i++) {
			realStrings = sourceStringsArray[i].split("-");
			System.out.println(realStrings[0] + "str" + realStrings[1]);
			
			switch(realStrings[0]) {
			case "1":
				cardNumber = Integer.parseInt(realStrings[1]);
				break;
			case "2":
				cardNumber = 13 + Integer.parseInt(realStrings[1]);
				break;
			case "3":
				cardNumber = 26 + Integer.parseInt(realStrings[1]);
				break;
			case "4":
				cardNumber = 39 + Integer.parseInt(realStrings[1]);
				break;
			case "5":
				cardNumber = 52 + Integer.parseInt(realStrings[1]);
				break;
			}
			System.out.println(cardNumber);
			superMycards.add(p.getCardS(cardNumber));
		}
		repaint();
		if(myScore > 21) {
			setMyLose(true);
			JOptionPane.showMessageDialog(null, "抱歉！您选择的点数超过21点，您输了。","提示",JOptionPane.ERROR_MESSAGE);
		}
	}
	
	//给庄家发牌
	public void faCardToComputer() {
		calComputerScore();
		if(computerScore > 21) {
			JOptionPane.showMessageDialog(null, "恭喜！庄家点数超过21点，您赢了！！","提示",JOptionPane.ERROR_MESSAGE);
			setComputerContinue(false);
			computerLose = true;
		}
		if(computerScore < 17) {
			computerCards.add(p.getCard(n)); //电脑得到一张牌
			cardsNotShow.add(p.getCard(55)); //隐藏电脑得到的牌
			n++;
			num2++;
			repaint();
		}else {
			JOptionPane.showMessageDialog(null, "庄家不再要牌", "提示", JOptionPane.ERROR_MESSAGE);
			setComputerContinue(false);
		}
	}
	
	//计算庄家得分
	public void calComputerScore() {
		computerScore = 0;
		for(int i=0;i<computerCards.size();i++) {
			Card c = (Card) computerCards.get(i);
			computerScore += c.count;
		}
	}
	
	//计算玩家得分
	public void calMyScore() {
		myScore = 0;
		if(role==1 || role==2) {
			for(int i=0;i<myCards.size();i++) {
				Card c = (Card) myCards.get(i);
				myScore += c.count;
	  		}
		}
		else if(role==3) {
			for(int i=0;i<superMycards.size();i++) {
				Card c = (Card) superMycards.get(i);
				myScore += c.count;
	  		}
		}
		
	}
	
	//计算两家的得分，判断输赢
	public void winOrnot() {
		calComputerScore();
		calMyScore();
		JOptionPane.showMessageDialog(null, "庄家分数："+computerScore+"\n玩家分数"+myScore);
		if(computerLose == true)
			JOptionPane.showMessageDialog(null, "庄家输了", "提示", JOptionPane.ERROR_MESSAGE);
		else if(isMyLose() == true)
			JOptionPane.showMessageDialog(null, "玩家输了", "提示", JOptionPane.ERROR_MESSAGE);
		else if(myScore > computerScore) {
			computerLose = true;
			JOptionPane.showMessageDialog(null, "玩家分数大于庄家，玩家赢了", "提示", JOptionPane.ERROR_MESSAGE);
		}
		else {
			setMyLose(true);
			JOptionPane.showMessageDialog(null, "玩家分数小于庄家，庄家赢了", "提示", JOptionPane.ERROR_MESSAGE);
		}
		
		if(isMyLose()==true) {
			sumMoney -= money*1.5;
			System.out.println(money+"and"+sumMoney);
		}else{
			sumMoney += money*1.5;
			System.out.println(money+"and"+sumMoney);
		}
		flag = true;
		repaint();
		JOptionPane.showMessageDialog(null, "您的金币余额为"+sumMoney, "结算", JOptionPane.OK_OPTION);
		
	}
	
	//游戏绘图
	public void paint(Graphics g) {
		g.setFont(new Font("华文仿宋", Font.BOLD, 22));;
		g.setColor(Color.white);
		g.clearRect(0, 0, this.getWidth(), this.getHeight());
		
		ImageIcon bgImage = new ImageIcon("imgs//bg6.jpg");
		g.drawImage(bgImage.getImage(), 0, 0, getSize().width, getSize().height, this);
		
		Toolkit moneyToolkit = getToolkit();
		Image moneyImage = moneyToolkit.getImage("imgs//money.png"); //添加金币图片
		g.drawImage(moneyImage, 530, 320, this);
		
		Toolkit girlToolkit = getToolkit();
		Image girlImage = girlToolkit.getImage("imgs//girl.png");
		g.drawImage(girlImage, 620, 40, this);
		
		System.out.println(sumMoney);
		String s = "余额：" + String.valueOf(sumMoney);
		String s2 = "您已下注：" + String.valueOf(money);
		g.drawString(s, 530,307);
		g.drawString(s2, 530, 334);
		g.drawString("庄家牌", 540, 150);
		g.drawString("玩家牌", 550, 280);
		
		if(role==1 || role==2) {
			
			for(int i=0;i<myCards.size();i++) {
				Card card = (Card) myCards.get(i);
				card.setPosition(55*i+52, 250);
				card.print();
				card.paint(g, this);
			}
			System.out.println();
			
			for(int i=0;i<cardsNotShow.size();i++) {
				Card card = (Card) cardsNotShow.get(i);
				card.setPosition(55*i+52, 50);
				card.print();
				card.paint(g, this);
			}
			
			for(int i=0;i<computerCards.size();i++) {
				Card card = (Card) computerCards.get(i);
				card.setPosition(55*i+52, 50);
				if (flag == true) {
					card.print();
					card.paint(g, this);
				}
			}
		}
		else if(role==3) {
			for(int i=0;i<superMycards.size();i++) {
				Card card = (Card) superMycards.get(i);
				card.setPosition(55*i+52, 250);
				card.print();
				card.paint(g, this);
			}
			System.out.println();
			
			for(int i=0;i<computerCards.size();i++) {
				Card card = (Card) computerCards.get(i);
				card.setPosition(55*i+52, 50);
				card.print();
				card.paint(g, this);
			}
		}
	}
	
	//开始新游戏
	public void newGame() {
		myCards.clear();
		superMycards.clear();
		computerCards.clear();
		cardsNotShow.clear();
		myScore = 0;
		computerScore = 0;
		setComputerContinue(true);
		computerLose = false;
		setMyLose(false);
		flag = false;
		num1 = 0;
		num2 = 0;
		
		if(role==3) {
			faCardToSuper();
			
		}
		for(int i=1;i<=2;i++) {
			if(role==1)
				faCard();
			else if(role==2)
				faCardToHigh();
			faCardToComputer();
			repaint();
		}
	}

	public int getNum1() {
		return num1;
	}

	public void setNum1(int num1) {
		this.num1 = num1;
	}

	public int getNum2() {
		return num2;
	}

	public void setNum2(int num2) {
		this.num2 = num2;
	}

	public float getMoney() {
		return money;
	}

	public void setMoney(float money) {
		this.money = money;
	}

	public boolean isMyLose() {
		return myLose;
	}

	public void setMyLose(boolean myLose) {
		this.myLose = myLose;
	}

	public boolean isComputerContinue() {
		return computerContinue;
	}

	public void setComputerContinue(boolean computerContinue) {
		this.computerContinue = computerContinue;
	}
	
	
}

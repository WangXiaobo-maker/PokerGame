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
	int role = -1;   //��ҽ�ɫ��־
	public int getRoles() {
		return role;
	}

	public void setRoles(int role) {
		this.role = role;
	}

	int n = 1;     //����һ���˿��е�λ��
	int num1 = 0;  //������е�������
	int num2 = 0;  //ׯ�����е�������
	float sumMoney = 1000; //���ӵ�н��
	float money = 0;  //���Ͷע���
	boolean flag = false; //��Ϸ������־
	
	
	ArrayList myCards = new ArrayList(); //��ͨ��ҵ���
	ArrayList superMycards = new ArrayList();  //������ҵ���
	ArrayList computerCards = new ArrayList(); //ׯ�ҵ���
	ArrayList cardsNotShow = new ArrayList();  //��������ׯ����
	int myScore = 0; //��ҵ÷�
	int computerScore = 0;  //ׯ�ҵ÷�
	
	private boolean computerContinue = true;
	protected boolean computerLose = false; //ׯ�����˵ı�־
	private boolean myLose = false; //������˵ı�־
	protected boolean highLevel = false;
	
	//ϴ��
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
	
	//����ͨ��ҷ���
	public void faCard() {
		myCards.add(p.getCard(n)); //��ͨ��ҵõ�һ����
		calMyScore();
		n++;
		num1++;
		if(num1>=5) {
			JOptionPane.showMessageDialog(null, "���������Ѵ����ޣ�");
		}
		repaint();
		if(myScore > 21) {
			setMyLose(true);
			JOptionPane.showMessageDialog(null, "��Ǹ����������21�㣬�����ˡ�","��ʾ",JOptionPane.ERROR_MESSAGE);
		}
	}
	
	//���߼���ҷ���
	public void faCardToHigh() {
		if(!highLevel) {
			JPasswordField pwd = new JPasswordField();
			Object[] message = {"������������֤��ݣ���ֵ��ɻ�����룩",pwd}; 
			pwd.requestFocus();
			String[] option = {"ȷ��","ȡ��"};
			int res = JOptionPane.showOptionDialog(null, message, "�߼������֤", JOptionPane.OK_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE, null, option, null);
		    String password = new String(pwd.getPassword());
			
			if(password.equals("1433223"))
		    	highLevel = true;
		}
		if(highLevel) {
			highLevel = true;
			ImageIcon nextPaI = new ImageIcon(p.getCard(n).getCardImage());
			JOptionPane.showMessageDialog(null, "���ĸ߼���ң�\n��ӵ�в鿴��һ���Ƶ�Ȩ������һ��������ͼ��ʾ", "��һ����", JOptionPane.OK_CANCEL_OPTION, nextPaI);
			int pass = JOptionPane.showConfirmDialog(null, "�Ƿ�Ҫ��");
			if(pass == JOptionPane.YES_OPTION) {
				myCards.add(p.getCard(n));
				num1++;
			}
			calMyScore();
			n++;
			if(num1>=5) {
				JOptionPane.showMessageDialog(null, "���������Ѵ����ޣ�");
			}
			repaint();
			if(myScore > 21) {
				setMyLose(true);
				JOptionPane.showMessageDialog(null, "��Ǹ����������21�㣬�����ˡ�","��ʾ",JOptionPane.ERROR_MESSAGE);
			}
		}else {
			JOptionPane.showMessageDialog(null, "�����֤ʧ�ܣ������ֵ����������");
		}
	}
	
	//��������ҷ���
	public void faCardToSuper() {
		
		String huaString;  //������ȡ�������������ַ���
		String[] sourceStringsArray;  //���ڴ洢�ָ��ĳ������������ַ���
		ImageIcon huaseIcon = new ImageIcon("imgs//huase.jpg");
		String[] realStrings;
		int cardNumber = 0;
		
		huaString = (String)JOptionPane.showInputDialog(null, "��ɫѡ��:\n"
				+ "��ɫ   1�����ң�2�����ң�3��÷����4������\n"
				+ "��С   A��K��1 ��13;  ������5-1  С����5-2\n "
				+ "��������֮���Զ���Ϊ�ָ�����\n"
				+ "��������5 ÷��J ����  ����  2-5,3-11,5-1", "�볬�����ѡ������Ҫ����", JOptionPane.YES_NO_CANCEL_OPTION, huaseIcon, null, null);
		
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
			JOptionPane.showMessageDialog(null, "��Ǹ����ѡ��ĵ�������21�㣬�����ˡ�","��ʾ",JOptionPane.ERROR_MESSAGE);
		}
	}
	
	//��ׯ�ҷ���
	public void faCardToComputer() {
		calComputerScore();
		if(computerScore > 21) {
			JOptionPane.showMessageDialog(null, "��ϲ��ׯ�ҵ�������21�㣬��Ӯ�ˣ���","��ʾ",JOptionPane.ERROR_MESSAGE);
			setComputerContinue(false);
			computerLose = true;
		}
		if(computerScore < 17) {
			computerCards.add(p.getCard(n)); //���Եõ�һ����
			cardsNotShow.add(p.getCard(55)); //���ص��Եõ�����
			n++;
			num2++;
			repaint();
		}else {
			JOptionPane.showMessageDialog(null, "ׯ�Ҳ���Ҫ��", "��ʾ", JOptionPane.ERROR_MESSAGE);
			setComputerContinue(false);
		}
	}
	
	//����ׯ�ҵ÷�
	public void calComputerScore() {
		computerScore = 0;
		for(int i=0;i<computerCards.size();i++) {
			Card c = (Card) computerCards.get(i);
			computerScore += c.count;
		}
	}
	
	//������ҵ÷�
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
	
	//�������ҵĵ÷֣��ж���Ӯ
	public void winOrnot() {
		calComputerScore();
		calMyScore();
		JOptionPane.showMessageDialog(null, "ׯ�ҷ�����"+computerScore+"\n��ҷ���"+myScore);
		if(computerLose == true)
			JOptionPane.showMessageDialog(null, "ׯ������", "��ʾ", JOptionPane.ERROR_MESSAGE);
		else if(isMyLose() == true)
			JOptionPane.showMessageDialog(null, "�������", "��ʾ", JOptionPane.ERROR_MESSAGE);
		else if(myScore > computerScore) {
			computerLose = true;
			JOptionPane.showMessageDialog(null, "��ҷ�������ׯ�ң����Ӯ��", "��ʾ", JOptionPane.ERROR_MESSAGE);
		}
		else {
			setMyLose(true);
			JOptionPane.showMessageDialog(null, "��ҷ���С��ׯ�ң�ׯ��Ӯ��", "��ʾ", JOptionPane.ERROR_MESSAGE);
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
		JOptionPane.showMessageDialog(null, "���Ľ�����Ϊ"+sumMoney, "����", JOptionPane.OK_OPTION);
		
	}
	
	//��Ϸ��ͼ
	public void paint(Graphics g) {
		g.setFont(new Font("���ķ���", Font.BOLD, 22));;
		g.setColor(Color.white);
		g.clearRect(0, 0, this.getWidth(), this.getHeight());
		
		ImageIcon bgImage = new ImageIcon("imgs//bg6.jpg");
		g.drawImage(bgImage.getImage(), 0, 0, getSize().width, getSize().height, this);
		
		Toolkit moneyToolkit = getToolkit();
		Image moneyImage = moneyToolkit.getImage("imgs//money.png"); //��ӽ��ͼƬ
		g.drawImage(moneyImage, 530, 320, this);
		
		Toolkit girlToolkit = getToolkit();
		Image girlImage = girlToolkit.getImage("imgs//girl.png");
		g.drawImage(girlImage, 620, 40, this);
		
		System.out.println(sumMoney);
		String s = "��" + String.valueOf(sumMoney);
		String s2 = "������ע��" + String.valueOf(money);
		g.drawString(s, 530,307);
		g.drawString(s2, 530, 334);
		g.drawString("ׯ����", 540, 150);
		g.drawString("�����", 550, 280);
		
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
	
	//��ʼ����Ϸ
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

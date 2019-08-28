package edu.cn.poker;

import java.awt.Image;
import java.awt.Toolkit;

import javax.tools.Tool;

public class Poker {
	static Card[] cards = new Card[55];
	static Card[] supCards = new Card[54];  //�������ר����
	static String[] colors = {"����","����","÷��","����"};
	static String values[] = {"A","2","3","4","5","6","7","8","9","10","J","Q","K"};
	private Image pic[] = null; //�˿���ͼƬ����
	
	//����ͼƬ
	public void getPic() {
		pic = new Image[55];
		for(int i=0;i<4;i++) {
			for(int j=0;j<13;j++) {
				pic[i*13+j] = Toolkit.getDefaultToolkit().getImage("imgs//img"+(i+1)+"-"+(j+1)+".jpg");
			}
		}
		pic[52] = Toolkit.getDefaultToolkit().getImage("imgs//s2.jpg"); //С��
		pic[53] = Toolkit.getDefaultToolkit().getImage("imgs//s1.jpg"); //����
		pic[54] = Toolkit.getDefaultToolkit().getImage("imgs//bg.jpg"); //����
	}
	
	//��ʼ���˿�
	public Poker() {
		getPic();
		for(int i=0;i<colors.length;i++) {
			for(int j=0;j<values.length;j++) {
				cards[i*13 + j] = new Card(colors[i], values[j],pic[i*13+j]);	
			}
		}
		cards[52] = new Card("С��", pic[52]);
		cards[53] = new Card("����", pic[53]);
		cards[54] = new Card("����", pic[54]);
		
		//��ʼ���������ר����
		for(int i=0;i<colors.length;i++) {
			for(int j=0;j<values.length;j++) {
				supCards[i*13 + j] = new Card(colors[i], values[j],pic[i*13+j]);	
			}
		}
		supCards[52] = new Card("С��", pic[52]);
		supCards[53] = new Card("����", pic[53]);
	}
	
	
	//��ȡ������
	public Card[] getCard() {
		return Poker.cards;
	}
	
	//��ȡһ����
	public Card getCard(int n) {
		return Poker.cards[n-1];
	}
	
	//��ȡһ���Ƶ�ͼƬ
	public Image getCardImage(int n) {
		return Poker.cards[n-1].getCardImage();
	}
	
	//������һ�ȡһ����
	public Card getCardS(int n) {
		return Poker.supCards[n-1];
	}
	
	//��ʾһ���µ��˿���
	public void show() {
		for(int i=0;i<54;i++) {
			cards[i].print();
		}
		System.out.println();
	}
	
	//ϴ��
	public void xipai() {
		int i, j;
		Card tCard;
		for(int k=1;k<=500;k++) {
			i = (int) (Math.random()*54);
			j = (int) (Math.random()*54);
			tCard = cards[i];
			cards[i] = cards[j];
			cards[j] = tCard;
		}
	}
	
}

package edu.cn.poker;

import java.awt.Image;
import java.awt.Toolkit;

import javax.tools.Tool;

public class Poker {
	static Card[] cards = new Card[55];
	static Card[] supCards = new Card[54];  //超级玩家专用牌
	static String[] colors = {"黑桃","红桃","梅花","方块"};
	static String values[] = {"A","2","3","4","5","6","7","8","9","10","J","Q","K"};
	private Image pic[] = null; //扑克牌图片数组
	
	//载入图片
	public void getPic() {
		pic = new Image[55];
		for(int i=0;i<4;i++) {
			for(int j=0;j<13;j++) {
				pic[i*13+j] = Toolkit.getDefaultToolkit().getImage("imgs//img"+(i+1)+"-"+(j+1)+".jpg");
			}
		}
		pic[52] = Toolkit.getDefaultToolkit().getImage("imgs//s2.jpg"); //小王
		pic[53] = Toolkit.getDefaultToolkit().getImage("imgs//s1.jpg"); //大王
		pic[54] = Toolkit.getDefaultToolkit().getImage("imgs//bg.jpg"); //背面
	}
	
	//初始化扑克
	public Poker() {
		getPic();
		for(int i=0;i<colors.length;i++) {
			for(int j=0;j<values.length;j++) {
				cards[i*13 + j] = new Card(colors[i], values[j],pic[i*13+j]);	
			}
		}
		cards[52] = new Card("小王", pic[52]);
		cards[53] = new Card("大王", pic[53]);
		cards[54] = new Card("背面", pic[54]);
		
		//初始化超级玩家专用牌
		for(int i=0;i<colors.length;i++) {
			for(int j=0;j<values.length;j++) {
				supCards[i*13 + j] = new Card(colors[i], values[j],pic[i*13+j]);	
			}
		}
		supCards[52] = new Card("小王", pic[52]);
		supCards[53] = new Card("大王", pic[53]);
	}
	
	
	//获取所有牌
	public Card[] getCard() {
		return Poker.cards;
	}
	
	//获取一张牌
	public Card getCard(int n) {
		return Poker.cards[n-1];
	}
	
	//获取一张牌的图片
	public Image getCardImage(int n) {
		return Poker.cards[n-1].getCardImage();
	}
	
	//超级玩家获取一张牌
	public Card getCardS(int n) {
		return Poker.supCards[n-1];
	}
	
	//显示一副新的扑克牌
	public void show() {
		for(int i=0;i<54;i++) {
			cards[i].print();
		}
		System.out.println();
	}
	
	//洗牌
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

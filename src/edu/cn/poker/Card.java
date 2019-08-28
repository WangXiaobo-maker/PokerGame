package edu.cn.poker;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.ImageObserver;

import javax.swing.JPanel;

public class Card {
	private String color; //四种花色
	private String value; //牌面大小（A~K）
	private Image cardImage; //图片
	
	public int count; //点数
	private int x=100,y=100; //牌所在位置
	
	//初始化点数
	public Card(String color, String value, Image bmpcard){
		this.color = color;
		this.value = value;
		this.cardImage = bmpcard;
		
		if(value=="J" || value=="Q" ||value=="K") 
			this.count = 10;
		else if(value=="A")
			this.count = 1;
		else
			this.count=Integer.parseInt(value);
	}
	
	//初始化大、小王
	public Card(String value, Image bmpcard) {
		this.color = "王";
		this.value = value;
		this.cardImage = bmpcard;
		this.count = 0;    //大小王点数为零
	}
	
	//设置牌要显示的位置
	public void setPosition(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	//画牌面
	public void paint(Graphics g) {
		g.drawImage(cardImage, x, y, null);
	}
	
	//在指定的面板上画牌面
	public void paint(Graphics g, JPanel i) {
		g.drawImage(cardImage, x, y, (ImageObserver)i);
	}
	
	//取一张牌的花色
	public String getcolor() {
		return color;
	}
	//取一张牌的大小
	public String getvalue() {
		return value;
	}
	
	//取一张牌的图片
	public Image getCardImage() {
		return cardImage;
	}
	
	//显示花色大小
	public void print() {
		System.out.print(color);
		System.out.print(value);
	}
	
}

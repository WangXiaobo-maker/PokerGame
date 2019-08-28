package edu.cn.poker;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.ImageObserver;

import javax.swing.JPanel;

public class Card {
	private String color; //���ֻ�ɫ
	private String value; //�����С��A~K��
	private Image cardImage; //ͼƬ
	
	public int count; //����
	private int x=100,y=100; //������λ��
	
	//��ʼ������
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
	
	//��ʼ����С��
	public Card(String value, Image bmpcard) {
		this.color = "��";
		this.value = value;
		this.cardImage = bmpcard;
		this.count = 0;    //��С������Ϊ��
	}
	
	//������Ҫ��ʾ��λ��
	public void setPosition(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	//������
	public void paint(Graphics g) {
		g.drawImage(cardImage, x, y, null);
	}
	
	//��ָ��������ϻ�����
	public void paint(Graphics g, JPanel i) {
		g.drawImage(cardImage, x, y, (ImageObserver)i);
	}
	
	//ȡһ���ƵĻ�ɫ
	public String getcolor() {
		return color;
	}
	//ȡһ���ƵĴ�С
	public String getvalue() {
		return value;
	}
	
	//ȡһ���Ƶ�ͼƬ
	public Image getCardImage() {
		return cardImage;
	}
	
	//��ʾ��ɫ��С
	public void print() {
		System.out.print(color);
		System.out.print(value);
	}
	
}

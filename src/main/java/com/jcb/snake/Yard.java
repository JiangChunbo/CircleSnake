package com.jcb.snake;

import static com.jcb.snake.Common.NodeSize;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;

@SuppressWarnings("serial")
public class Yard extends JFrame {
	
	/* 活动区域的每个边上的像素块的数量 */
	public final static int NodeCount = 30;
	
	/* 活动区域的每个边的长度 */
	public final static int AreaSize = NodeSize * NodeCount;
	
	/* 活动区域的位置坐标 x */
	public final static int x = AreaSize / 2;
	
	/* 活动区域的位置坐标  y */
	public final static int y = AreaSize / 2;
	
	/* Snake */
	private Snake snake = new Snake();
	
	private Image offScreenImage;
	
	public static void main(String[] args) {
		new Yard();
	}
	
	Yard() {
		this.setSize(2 * AreaSize, 2 * AreaSize);
		this.setVisible(true);
		this.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
		
		while(true) {
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			this.repaint();
		}
	}
	
	@Override
	public void paint(Graphics g) {
		super.paint(g);
		g.setColor(Color.WHITE);
		g.fillRect(0, 0, AreaSize, AreaSize);
		g.setColor(Color.BLACK);
		for(int i = 0, x2 = x + AreaSize, y2 = y + AreaSize;
				i <= NodeCount; i++) {
			int offset = NodeSize * i;
			g.drawLine(x, y + offset, x2, y + offset);
			g.drawLine(x + offset, y, x + offset, y2);
		}
		snake.paint(g);
		snake.move();
	}
	
	
	@Override
	public void update(Graphics g) {
		if(offScreenImage == null) {
			offScreenImage = this.createImage(AreaSize, AreaSize);
		}
		Graphics gOff = offScreenImage.getGraphics();
		paint(gOff);
		g.drawImage(offScreenImage, 0, 0, null);
	}
}

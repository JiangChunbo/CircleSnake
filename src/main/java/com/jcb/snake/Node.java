package com.jcb.snake;

import java.awt.Color;
import java.awt.Graphics;


public class Node {
	
	int row;
	
	int col;
	
	int x;
	
	int y;
	
	Node prev;
	/*ajsakjas*/
	Node next;
	
	Node(int row, int col) {
		this.row = row;
		this.col = col;
	}
	
	public void paint(Graphics g, Color c) {
		x = Yard.x + (row - 1) * Common.NodeSize;
		y = Yard.y + (col - 1) * Common.NodeSize;
		g.setColor(c);
		g.fillRect(x, y, Common.NodeSize, Common.NodeSize);
	}
}

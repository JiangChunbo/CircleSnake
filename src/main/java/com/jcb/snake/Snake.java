package com.jcb.snake;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Iterator;

public class Snake {
	Node head;
	Node tail;
	static int i = 0;
	Direction d = Direction.RIGHT;
	
	ArrayList<Node> body;
	Snake() {
		head = new Node(20, 1);
		body = new ArrayList<Node>(19);
		Node p = head;
		Node n = null;
		for(int i = 0; i < 19; i++) {
			n = new Node(19 - i, 1);
			p.next = n;
			n.prev = p;
			p = n;
			body.add(n);
		}
		tail = n;
		tail.next = head;
		head.prev = tail;
		
	}
	
	public void paint(Graphics g) {
		head.paint(g, Color.RED);
		Node n = head.next;
		do {
			n.paint(g, Color.BLACK);
			n = n.next;
		} while (n != tail.next);
	}
	
	public void move() {
		if(d == Direction.RIGHT && head.row >= 30) {
			d = Direction.DOWN;
		} else if(d == Direction.DOWN && head.col >= 30) {
			d = Direction.LEFT;
		} else if(d == Direction.LEFT && head.row <= 1) {
			d = Direction.UP;
		} else if(d == Direction.UP && head.col <= 1) {
			d = Direction.RIGHT;
		}
		head = tail;
		tail = tail.prev;
		switch(d) {
		case UP:
			head.row = head.next.row;
			head.col = head.next.col - 1;
			break;
		case RIGHT:
			head.col = head.next.col;
			head.row = head.next.row + 1;
			break;
		case DOWN:
			head.row = head.next.row;
			head.col = head.next.col + 1;
			break;
		case LEFT:
			head.col = head.next.col;
			head.row = head.next.row - 1;
			break;
		}



			
	}
}

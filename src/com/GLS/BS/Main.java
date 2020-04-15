package com.GLS.BS;

import java.awt.Canvas;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JFrame;

public class Main extends Canvas implements Runnable, MouseListener {

	private static final long serialVersionUID = -8184655824492569768L;
	
	boolean running;
	Thread thread;

	public static void main(String[] args) {
		new Main();
	}
	
	public Main() {
		init();
		onUserCreate();
		start();
	}
	
	public void init() {
		JFrame frame = new JFrame();
		frame.setTitle("Bit Switch Beta 0.1");
		frame.setSize(1000,800);
		frame.setResizable(false);
		frame.add(this);
		frame.addMouseListener(this);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
	
	public void onUserCreate() {
		//Program Init
	}
	
	public void start() {
		thread = new Thread(this);
		thread.start();
		running = true;
	}

	public void run() {
		long lastTime = System.nanoTime();
		double amountOfTicks = 120.0;
		double ns = 1000000000 / amountOfTicks;
		double delta = 0;
		long timer = System.currentTimeMillis();
		while(running){
			long now = System.nanoTime();
			delta += (now - lastTime) / ns;
			lastTime = now;
			while(delta >= 1){
				delta--;
				tick();
			}
			render();
			if(System.currentTimeMillis() - timer > 1000){
				timer += 1000;
			}
		}
		stop();
	}

	public synchronized void stop(){
		try{
			thread.join();
			running = false;
		}catch(Exception e){
			e.printStackTrace();
		}
	}

	private void render() {
		// TODO Auto-generated method stub
		
	}

	private void tick() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

}

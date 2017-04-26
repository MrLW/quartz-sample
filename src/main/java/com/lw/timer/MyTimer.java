package com.lw.timer;

import java.util.Date;

/**
 *  �Զ���һ����ʱ��
 * @author lw
 */
public class MyTimer extends Thread{

	private Long time ;
	
	public MyTimer(Long time) {
		this.time = time;
	}

	@Override
	public void run() {
		while(true){
			try {
				Thread.sleep(time);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			send();
		}
	}
	/**
	 *  ��ʼִ������
	 */
	public void execute(){
		this.start();
	}
	
	/**
	 *  ��ʱ����
	 */
	private void send() {
		System.out.println("����ִ����:" + new Date());
	}
	
	public static void main(String[] args) {
		MyTimer myTimer = new MyTimer(2000L) ;
		myTimer.execute();
	}
	
}

package com.lw.timer;

import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

public class TimerTest {

	public static void main(String[] args) {
		Timer timer = new Timer();
		// 5s��ִ��
		// timer.schedule(new MyTask(), 5000);
		// ����ִ������,ÿ��1000ִ��һ��
		timer.scheduleAtFixedRate(new MyTask(), new Date(), 1000);
	}

}

// ��ʱ����,����һ���߳�
class MyTask extends TimerTask {
	@Override
	public void run() {
		System.out.println("task execute ");
	}
}

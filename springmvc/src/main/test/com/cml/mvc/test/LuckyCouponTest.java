package com.cml.mvc.test;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class LuckyCouponTest {

	public static void main(String[] args) {
		final CyclicBarrier barrier = new CyclicBarrier(5);
		for (int i = 0; i < 5; i++) {
			new Thread() {
				public void run() {
//					System.out.println("execute before:"+Thread.currentThread().getId());
					try {
						Thread.sleep(1000);
						barrier.await();
					} catch (InterruptedException e) {
						e.printStackTrace();
					} catch (BrokenBarrierException e) {
						e.printStackTrace();
					}
					System.out.println("execute after:"+Thread.currentThread().getId());
				};
			}.start();
		}
		System.out.println("test");
	}

}

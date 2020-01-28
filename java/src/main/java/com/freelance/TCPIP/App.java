package com.freelance.TCPIP;

import java.io.IOException;
import java.net.ServerSocket;
import java.util.concurrent.CountDownLatch;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) throws IOException {
		CountDownLatch cdl = new CountDownLatch(1);
		ServerSocket server = new ServerSocket(9000);
		new Thread(new ServerApp(cdl, server.accept())).start();
		try {
			cdl.await();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}finally {
			server.close();
			System.out.println("---server closed---");
		}
	}
}

package com.freelance.TCPIP;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.ServerSocketChannel;
import java.util.concurrent.CountDownLatch;

public class NioApp {

	public static void main(String[] args) {
		CountDownLatch cdl = new CountDownLatch(1);
		ServerSocketChannel server = null;
		try {
			server = ServerSocketChannel.open();
			server.socket().bind(new InetSocketAddress(9000));
			new Thread(new NioServerApp(cdl, server.accept())).start();
			cdl.await();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			try {
				server.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}

}

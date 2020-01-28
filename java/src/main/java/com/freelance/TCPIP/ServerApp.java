package com.freelance.TCPIP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.concurrent.CountDownLatch;

public class ServerApp implements Runnable {
	private Socket client;
	private CountDownLatch countdown;

	public ServerApp(CountDownLatch countdown, Socket client) {
		this.countdown = countdown;
		this.client = client;
	}

	@Override
	public void run() {
		try {
			BufferedReader reader = new BufferedReader(new InputStreamReader(client.getInputStream()));
			PrintWriter writer = new PrintWriter(client.getOutputStream());
			String line = null;
			while (!":q!".equals(line = reader.readLine())) {
				StringBuilder sb = new StringBuilder("reply: ");
				sb.append(line);
				writer.println(sb.toString());
				writer.flush();
			}
			writer.println("--end--");
			writer.flush();
			writer.close();
			reader.close();
			client.close();
			countdown.countDown();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}

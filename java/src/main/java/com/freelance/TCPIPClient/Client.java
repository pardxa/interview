package com.freelance.TCPIPClient;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Client {
	private Socket clientSocket;
	private BufferedReader reader;
	private PrintWriter writer;
	public void startConnection(String host,int port) throws IOException {
		this.clientSocket=new Socket(host,port);
		this.reader=new BufferedReader(new InputStreamReader(this.clientSocket.getInputStream()));
		this.writer=new PrintWriter(this.clientSocket.getOutputStream());
	}
	public void send(String msg) {
		writer.println(msg);
		writer.flush();
	}
	public String receive() throws IOException {
		return this.reader.readLine();
	}
	public void stop() throws IOException {
		this.writer.close();
		this.reader.close();
		this.clientSocket.close();		
	}
}

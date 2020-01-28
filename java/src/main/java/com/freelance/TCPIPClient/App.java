package com.freelance.TCPIPClient;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
        Client client=new Client();
        try {
			client.startConnection("127.0.0.1",9000);
			String rev;
			do {
				String str=reader.readLine();
				client.send(str);
				rev=client.receive();
				System.out.println(rev);
			}while(!"--end--".equals(rev));
			client.stop();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
}

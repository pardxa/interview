package com.freelance.TCPIP;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.CountDownLatch;

public class NioServerApp implements Runnable {
	private SocketChannel socket;
	private CountDownLatch countdown;

	public NioServerApp(CountDownLatch countdown, SocketChannel socket) {
		this.countdown = countdown;
		this.socket = socket;
	}

	@Override
	public void run() {
		try {
			Selector selector = Selector.open();
			socket.configureBlocking(false);
			socket.register(selector, SelectionKey.OP_READ);
			while (true) {
				// Selects a set of keys whose corresponding channels are ready for I/O
				// operations.
				selector.select();
				Set<SelectionKey> keys = selector.selectedKeys();
				Iterator<SelectionKey> itor = keys.iterator();
				boolean shouldBreak = false;
				while (itor.hasNext()) {
					SelectionKey key = (SelectionKey) itor.next();
					if (key.isReadable()) {
						shouldBreak = read(key);
					}
					//
					itor.remove();
				}
				if (shouldBreak)
					break;
			}
			socket.close();

		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			countdown.countDown();
		}

	}

	private boolean read(SelectionKey key) throws IOException {
		boolean shouldBreak = true;
		ByteBuffer buffer = ByteBuffer.allocate(2048);
		SocketChannel inChannel = (SocketChannel) key.channel();
		inChannel.read(buffer);
		String line = new String(buffer.array(), "UTF-8");
		StringBuilder sb = new StringBuilder("reply: ");
		sb.append(line);
		//

		if (!line.contains(":q!")) {
			buffer = ByteBuffer.wrap(sb.toString().getBytes());
			shouldBreak = false;
		} else {
			buffer= ByteBuffer.wrap(new String("--end--").getBytes());
		}
		//buffer.flip();
		inChannel.write(buffer);
		return shouldBreak;
	}
}

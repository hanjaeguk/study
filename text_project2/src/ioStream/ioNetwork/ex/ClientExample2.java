package ioStream.ioNetwork.ex;

import java.io.*;
import java.net.*;

public class ClientExample2 {

	public static void main(String[] args) {
		Socket socket = null;

		byte[] sendBytes = new byte[100];
		byte[] receiveBytes = new byte[100];
		String sendMessage = null;
		String receiveMessage = null;
		int readByteCount = 0;
		InputStream is;
		OutputStream os;

		try {
			socket = new Socket();
			System.out.println("연결 요청");
			socket.connect(new InetSocketAddress("localhost", 5001));
			System.out.println("연결 성공");
			is = socket.getInputStream();
			os = socket.getOutputStream();

			while (true) {
				// receive message
				if (is.available() != 0) {
					readByteCount = is.read(receiveBytes);
					receiveMessage = new String(receiveBytes, 0, readByteCount, "UTF-8");
					System.out.println("Server Message: " + receiveMessage);
				}

				// send message
				if (System.in.available() != 0) {

					int length = System.in.read(sendBytes);
					
					if (length != -1 && length != 0) {
						sendMessage = new String(sendBytes, 0, length);
						os.write(sendMessage.getBytes("UTF-8"));
						os.flush();
						System.out.println("message 전송");
					}
				}
			}
		} catch (Exception e1) {
		}

		if (!socket.isClosed()) {
			try {
				socket.close();
			} catch (IOException e2) {
				e2.printStackTrace();
			}
		}
	}

}

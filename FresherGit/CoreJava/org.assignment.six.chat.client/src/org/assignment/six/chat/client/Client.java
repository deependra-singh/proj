package org.assignment.six.chat.client;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;

/**
 * @author Deependra Singh
 * @purpose Create a chat application using client and server
 *
 */
public class Client {
	public static void main(String[] args) throws Exception {
		Socket clientSocket = new Socket("127.1.1.1", 3000);

		// read text from console
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// to send data to the server
		OutputStream ostream = clientSocket.getOutputStream();
		PrintWriter pwrite = new PrintWriter(ostream, true);

		// receive message from the server
		InputStream istream = clientSocket.getInputStream();
		BufferedReader receiveRead = new BufferedReader(new InputStreamReader(
				istream));

		System.out.println("Type and press enter");

		String receiveMessage, sendMessage;
		while (true) {
			// message to be sent to the server to be taken from console
			sendMessage = br.readLine();

			// write that message to the server
			pwrite.println(sendMessage);

			// flush the data
			pwrite.flush();

			// if received message has next line and is not null
			if ((receiveMessage = receiveRead.readLine()) != null) {
				// display the message
				System.out.println(receiveMessage);

			}
		}

	}

}

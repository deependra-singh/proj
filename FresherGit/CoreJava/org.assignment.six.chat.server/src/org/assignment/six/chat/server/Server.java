package org.assignment.six.chat.server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author Deependra Singh
 * @purpose Create a chat application using client and server
 *
 */

public class Server {
	public static void main(String[] args) {
		try {
			// create socket server
			ServerSocket server = new ServerSocket(3000);

			// create socket as accept method returns socket
			Socket socket = server.accept();

			// read text from console
			BufferedReader br = new BufferedReader(new InputStreamReader(
					System.in));

			OutputStream ostream = socket.getOutputStream();
			PrintWriter pwrite = new PrintWriter(ostream, true);

			InputStream istream = socket.getInputStream();
			BufferedReader receiveRead = new BufferedReader(
					new InputStreamReader(istream));

			String receiveMessage, sendMessage;
			// loop
			while (true) {
				// check whether received message has a new line if yes then
				// print that message
				if ((receiveMessage = receiveRead.readLine()) != null) {
					System.out.println(receiveMessage);
				}

				// read message from console to send it to the client
				sendMessage = br.readLine();

				// write it to client
				pwrite.println(sendMessage);
				pwrite.flush();
			}

		} catch (IOException e) {

		}

	}

}

package ua.main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.Writer;
import java.net.Socket;

public class Client {
	private static final int LOOP_COUNT = 100;
	private static final int SLEEP_TIME = 500;
	private static final int PORT = 9876;

	public static void main(String args[]) throws IOException,
			InterruptedException {
		for (int i = 0; i < LOOP_COUNT; i++) {
			Socket socket = new Socket("localhost", PORT);
			InputStream is = socket.getInputStream();
			OutputStream os = socket.getOutputStream();
			Writer writer = new OutputStreamWriter(os, "US-ASCII");
			PrintWriter out = new PrintWriter(writer, true);
			out.println("Hello, World");
			BufferedReader in = new BufferedReader(new InputStreamReader(is,
					"US-ASCII"));
			String line;
			while ((line = in.readLine()) != null) {
				System.out.println(i + ": " + line);
			}
			socket.close();
			Thread.sleep(SLEEP_TIME);
		}
	}
}

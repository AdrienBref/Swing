package org.Bref.Tcp;

import org.Bref.coms.TcpComs;

import java.io.*;
import java.net.Socket;

public class Tcp implements TcpComs {

    private String serverIP = "";
    private int serverPort = 0;
    private Socket clientSocket;
    private PrintWriter out;
    private BufferedReader in;

    @Override
    public void connect(String ip, int port) {
        try {
            clientSocket = new Socket(serverIP, serverPort);
            OutputStream outputStream = clientSocket.getOutputStream();
            out = new PrintWriter(outputStream, true);
            InputStream inputStream = clientSocket.getInputStream();
            in = new BufferedReader(new InputStreamReader(inputStream));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void disconnect() {
        try {
            out.close();
            in.close();
            clientSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void read() {

    }

    @Override
    public void write(String message) {
        out.write(message);
        System.out.println("<< " + message);
    }
}

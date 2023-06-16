package org.Bref.Tcp;

import java.net.*;
import java.io.*;

public class TcpClient {

    private String serverIP = "";
    private int serverPort = 0;
    private Socket clientSocket;
    private PrintWriter out;
    private BufferedReader in;

    /**
     * Connect with Tcp/ip server at specified Ip & Port
     */
    public void connect(String serverIP, int serverPort) {
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

    public void clientRead() {
        Thread readThread = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    String serverResponse;
                    while((serverResponse = in.readLine()) != null) {
                        System.out.println(">> " + serverResponse);
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
        readThread.start();
    }

    public void clientWrite(String clientMessage) {
        out.write(clientMessage);
        System.out.println("<< " + clientMessage);
    }

    public void disconnect() {
        try {
            out.close();
            in.close();
            clientSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

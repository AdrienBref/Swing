package org.Bref;

import org.Bref.Client.Client;
import org.Bref.Tcp.TcpClient;
import org.Bref.Tcp.TcpServer;

public class App
{
    public static void main( String[] args )
    {
        TcpClient client1 = new TcpClient();
        client1.connect("1270.0.0.1", 9600);

    }
}




package org.Bref.coms;

public interface TcpComs {
    public void connect(String ip, int port);
    public void disconnect();
    public void read();
    public void write(String message);
}

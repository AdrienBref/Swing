package org.Bref.Graphics;

import javax.swing.*;

public class MyFrame extends JFrame {

    public MyFrame(String pointName) {
        setVisible(true);
        setSize(500,300);
        setLocation(400, 200);
        setTitle(pointName);
        LayOut layOut = new LayOut();
        add(layOut);
    }
}

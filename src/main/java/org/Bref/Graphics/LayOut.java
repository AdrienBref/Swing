package org.Bref.Graphics;

import javax.swing.*;
import java.awt.*;

class LayOut extends JPanel {

    public void paintComponent(Graphics g){
        super.paintComponent(g);
        g.drawRect(50,50,200,200);
        g.drawArc(50,100,100,200,120,150);
    }
}
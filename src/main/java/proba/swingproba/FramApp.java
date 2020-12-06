//: FramApp.java
// Demonstrating the FramApp

// <applet code=FramApp.class width=200 height=100></applet>

//: FramApp.java
// An application and an applet
import java.awt.*;
import java.awt.event.*; // Must add this
import java.applet.*;

public class FramApp extends Applet
{
  Button b1 = new Button("Button 1") ;
  Button b2 = new Button("Button 2") ;

  TextField t = new TextField(20);

  public void init()
  {
    b1.addActionListener(new B1());
    b2.addActionListener(new B2());
    add(b1);
    add(b2);
    add(t);
  }

  class B1 implements ActionListener
  {
    public void actionPerformed(ActionEvent e)
    {
      t.setText("Button 1");
    }
  }

  class B2 implements ActionListener
  {
    public void actionPerformed(ActionEvent e)
    {
      t.setText("Button 2");
    }
  }

  // To close the application:
  static class WL extends WindowAdapter
  {
    public void windowClosing(WindowEvent e)
    {
      System.exit(0);
    }
  }

  // A main() for the application:
  public static void main(String[] args)
  {
    FramApp applet = new FramApp();
    Frame aFrame = new Frame("FramApp");

    aFrame.addWindowListener(new WL());
    aFrame.add(applet, BorderLayout.CENTER);
    aFrame.setSize(300,200);
    applet.init();
    applet.start();
    aFrame.setVisible(true);
  }
} ///:~
//: BorderLayout1.java
// Demonstrating the BorderLayout

// <applet code=BorderLayout1.class width=200 height=100></applet>

import java.awt.*;
import java.applet.*;

public class BorderLayout1 extends Applet
{
  public void init()
  {
    int i = 0;
    setLayout(new BorderLayout());
    add("North", new Button("Button " + i++));
    add("South", new Button("Button " + i++));
    add("East", new Button("Button " + i++));
    add("West", new Button("Button " + i++));
    add("Center", new Button("Button " + i++));
  }
} ///:~
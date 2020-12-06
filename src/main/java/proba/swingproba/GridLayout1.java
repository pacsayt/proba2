//: GridLayout1.java
// Demonstrating the FlowLayout

// <applet code=GridLayout1.class width=400 height=200></applet>

import java.awt.*;
import java.applet.*;
public class GridLayout1 extends Applet {
public void init() {
setLayout(new GridLayout(7,3));
for(int i = 0; i < 20; i++)
add(new Button("Button " + i));
}
} ///:~
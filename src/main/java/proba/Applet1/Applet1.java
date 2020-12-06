//: Applet1.java
// Very simple applet
// package c13;

// <applet code=Applet1.class width=200 height=100></applet>
package proba.Applet1;

import java.awt.*;
import java.applet.*;

public class Applet1 extends Applet
{
  String s0 ;
  int    inits  = 0;
  int    starts = 0;
  int    stops  = 0;
  int    paints = 0 ;

  Button    b1 = new Button("Get Text") ;
  Button    b2 = new Button("Set Text") ;
  TextField t  = new TextField("Starting text", 30) ;

  String    s  = new String() ;

  public void start()
  {
    starts++;
  }

  public void init()
  {
    inits++;

    add( b1) ;
    add( b2) ;
    add(  t) ;
  }

  public boolean action(Event evt, Object arg)
  {
    // if(arg.equals("Button 1")) <- ez mostmar nem mukodik !
    if(evt.target.equals(b1))
    {
      // Applet.showStatus() is letezik
      // getAppletContext().showStatus(evt + "" ) ;
      // getAppletContext().showStatus("Button 1");

      getAppletContext().showStatus(t.getText()) ;
 
      s = t.getSelectedText() ;
 
      if( s.length() == 0 )
      {
        s = t.getText() ;
      }

      t.setEditable(true) ;
    }
    else
    {
      if( evt.target.equals( b2) )
      {
        // getAppletContext().showStatus("Button 2");
        t.setText( "Inserted by Button 2: " + s) ;
        t.setEditable( false) ;
      }
      else
      {
        // Let the base class handle it:
        return super.action(evt, arg);
      }
    }

    return true; // We've handled it here
  }

  public void paint(Graphics g)
  {
    paints++ ;

    g.drawString( "First applet", 10, 50) ;
    s0 = "inits: " + inits + ", starts: " + starts + ", paints: " + paints + ", stops: " + stops ;

    g.drawString( s0, 10, 70) ;
  }

  public void stop()
  {
    stops++ ;
  }

} ///:~
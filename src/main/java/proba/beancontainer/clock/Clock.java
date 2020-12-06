/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package proba.beancontainer.clock;

import java.applet.*;
import java.awt.*;
import java.awt.event.*;
import java.beans.*;
import java.io.*;
import java.util.*;
import javax.swing.*;
import javax.swing.border.*;

public class Clock extends JButton implements Customizer, Externalizable, Runnable
{

  protected PropertyChangeSupport m_helper;
  protected boolean m_digital = false;
  protected Calendar m_calendar;
  protected Dimension m_preffSize;

  public Clock()
  {
    m_calendar = Calendar.getInstance();
    m_helper = new PropertyChangeSupport(this);
    Border br1 = new EtchedBorder(EtchedBorder.RAISED, Color.white, new Color(128, 0, 0));
    Border br2 = new MatteBorder(4, 4, 4, 4, Color.red);
    setBorder(new CompoundBorder(br1, br2));
    setBackground(Color.white);
    setForeground(Color.black);
    (new Thread(this)).start();
  }

  public void writeExternal(ObjectOutput out)
    throws IOException
  {
    out.writeBoolean(m_digital);
    out.writeObject(getBackground());
    out.writeObject(getForeground());
    out.writeObject(getPreferredSize());
  }

  public void readExternal(ObjectInput in)
    throws IOException, ClassNotFoundException
  {
    setDigital(in.readBoolean());
    setBackground(( Color ) in.readObject());
    setForeground(( Color ) in.readObject());
    setPreferredSize(( Dimension ) in.readObject());
  }

  public Dimension getPreferredSize()
  {
    if ( m_preffSize != null )
    {
      return m_preffSize;
    }
    else
    {
      return new Dimension(50, 50);
    }
  }

  public void setPreferredSize(Dimension preffSize)
  {
    m_preffSize = preffSize;
  }

  public Dimension getMinimumSize()
  {
    return getPreferredSize();
  }

  public Dimension getMaximumSize()
  {
    return getPreferredSize();
  }

  public void setDigital(boolean digital)
  {
    m_helper.firePropertyChange("digital",
      new Boolean(m_digital),
      new Boolean(digital));
    m_digital = digital;
    repaint();
  }

  public boolean getDigital()
  {
    return m_digital;
  }

  public void addPropertyChangeListener(
    PropertyChangeListener lst)
  {
    if ( m_helper != null )
    {
      m_helper.addPropertyChangeListener(lst);
    }
  }

  public void removePropertyChangeListener(
    PropertyChangeListener lst)
  {
    if ( m_helper != null )
    {
      m_helper.removePropertyChangeListener(lst);
    }
  }

  public void setObject(Object bean)
  {
  }

  public void paintComponent(Graphics g)
  {
    super.paintComponent(g);

    g.setColor(getBackground());
    g.fillRect(0, 0, getWidth(), getHeight());
    getBorder().paintBorder(this, g, 0, 0, getWidth(), getHeight());
    m_calendar.setTime(new Date()); // Get current time
    int hrs = m_calendar.get(Calendar.HOUR_OF_DAY);
    int min = m_calendar.get(Calendar.MINUTE);
    g.setColor(getForeground());

    if ( m_digital )
    {
      String time = "" + hrs + ":" + min;
      g.setFont(getFont());
      FontMetrics fm = g.getFontMetrics();
      int y = (getHeight() + fm.getAscent()) / 2;
      int x = (getWidth() - fm.stringWidth(time)) / 2;
      g.drawString(time, x, y);
    }
    else
    {
      int x = getWidth() / 2;
      int y = getHeight() / 2;
      int rh = getHeight() / 4;
      int rm = getHeight() / 3;
      double ah = (( double ) hrs + min / 60.0) / 6.0 * Math.PI;
      double am = min / 30.0 * Math.PI;
      g.drawLine(x, y, ( int ) (x + rh * Math.sin(ah)),
        ( int ) (y - rh * Math.cos(ah)));
      g.drawLine(x, y, ( int ) (x + rm * Math.sin(am)),
        ( int ) (y - rm * Math.cos(am)));
    }
  }

  public void run()
  {
    while ( true )
    {
      repaint();
      try
      {
        Thread.sleep(30 * 1000);
      }
      catch ( InterruptedException ex )
      {
        break;
      }
    }
  }
}
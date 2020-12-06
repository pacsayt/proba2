/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package proba.beancontainer.beancontainer;

import proba.beancontainer.dialoglayout.DialogLayout;

import java.awt.*;
import java.awt.event.*;
import java.io.*;
import javax.swing.*;


public class BeanContainer extends JFrame implements FocusListener
{

  protected File m_currentDir = new File(".");
  protected Component m_activeBean;
  protected String m_className = "clock.Clock";
  protected JFileChooser m_chooser = new JFileChooser();

  public BeanContainer()
  {
    super("Simple Bean Container");
    getContentPane().setLayout(new FlowLayout());
    setSize(300, 300);
    
    // Kulonben az aktiv beant jelolo keretet a legordult menure rajzolja
    // Mindket esetben a legordulo menuk leradirozzak a kijelolo keret tetejet ... pt++
    JPopupMenu.setDefaultLightWeightPopupEnabled(false);
    JMenuBar menuBar = createMenuBar();
    setJMenuBar(menuBar);

    try
    {
      m_currentDir = (new File(".")).getCanonicalFile();
    }
    catch ( IOException ex )
    {
    }

    setDefaultCloseOperation(EXIT_ON_CLOSE);
    setVisible(true);
  }

  protected JMenuBar createMenuBar()
  {
    JMenuBar menuBar = new JMenuBar();
    JMenu mFile = new JMenu("File");
    JMenuItem mItem = new JMenuItem("New...");
    ActionListener lst = new ActionListener()
    {

      public void actionPerformed(ActionEvent e)
      {
        Thread newthread = new Thread()
        {

          public void run()
          {
            String result = ( String ) JOptionPane.showInputDialog(
              BeanContainer.this,
              "Please enter class name to create a new bean",
              "Input", JOptionPane.INFORMATION_MESSAGE, null,
              null, m_className);
            repaint();
            if ( result == null )
            {
              return;
            }
            try
            {
              m_className = result;
              Class cls = Class.forName(result);
              Object obj = cls.newInstance();
              if ( obj instanceof Component )
              {
                m_activeBean = ( Component ) obj;
                m_activeBean.addFocusListener(
                  BeanContainer.this);
                m_activeBean.requestFocus();
                getContentPane().add(m_activeBean);
              }
              validate();
            }
            catch ( Exception ex )
            {
              ex.printStackTrace();
              JOptionPane.showMessageDialog(
                BeanContainer.this, "Error: " + ex.toString(),
                "Warning", JOptionPane.WARNING_MESSAGE);
            }
          }
        };
        newthread.start();
      }
    };
    mItem.addActionListener(lst);
    mFile.add(mItem);
    mItem = new JMenuItem("Load...");
    lst = new ActionListener()
    {

      public void actionPerformed(ActionEvent e)
      {
        Thread newthread = new Thread()
        {

          public void run()
          {
            m_chooser.setCurrentDirectory(m_currentDir);
            m_chooser.setDialogTitle(
              "Please select file with serialized bean");
            int result = m_chooser.showOpenDialog(
              BeanContainer.this);
            repaint();
            if ( result != JFileChooser.APPROVE_OPTION )
            {
              return;
            }
            m_currentDir = m_chooser.getCurrentDirectory();
            File fChoosen = m_chooser.getSelectedFile();
            try
            {
              FileInputStream fStream =
                new FileInputStream(fChoosen);
              ObjectInput stream =
                new ObjectInputStream(fStream);
              Object obj = stream.readObject();
              if ( obj instanceof Component )
              {
                m_activeBean = ( Component ) obj;
                m_activeBean.addFocusListener(
                  BeanContainer.this);
                m_activeBean.requestFocus();
                getContentPane().add(m_activeBean);
              }
              stream.close();
              fStream.close();
              validate();
            }
            catch ( Exception ex )
            {
              ex.printStackTrace();
              JOptionPane.showMessageDialog(
                BeanContainer.this, "Error: " + ex.toString(),
                "Warning", JOptionPane.WARNING_MESSAGE);
            }
            repaint();
          }
        };
        newthread.start();
      }
    };
    mItem.addActionListener(lst);
    mFile.add(mItem);
    mItem = new JMenuItem("Save...");
    lst = new ActionListener()
    {

      public void actionPerformed(ActionEvent e)
      {
        Thread newthread = new Thread()
        {

          public void run()
          {
            if ( m_activeBean == null )
            {
              return;
            }
            m_chooser.setDialogTitle(
              "Please choose file to serialize bean");
            m_chooser.setCurrentDirectory(m_currentDir);
            int result = m_chooser.showSaveDialog(
              BeanContainer.this);
            repaint();
            if ( result != JFileChooser.APPROVE_OPTION )
            {
              return;
            }
            m_currentDir = m_chooser.getCurrentDirectory();
            File fChoosen = m_chooser.getSelectedFile();
            try
            {
              FileOutputStream fStream =
                new FileOutputStream(fChoosen);
              ObjectOutput stream =
                new ObjectOutputStream(fStream);
              stream.writeObject(m_activeBean);
              stream.close();
              fStream.close();
            }
            catch ( Exception ex )
            {
              ex.printStackTrace();
              JOptionPane.showMessageDialog(
                BeanContainer.this, "Error: " + ex.toString(),
                "Warning", JOptionPane.WARNING_MESSAGE);
            }
          }
        };
        newthread.start();
      }
    };
    mItem.addActionListener(lst);
    mFile.add(mItem);
    mFile.addSeparator();
    mItem = new JMenuItem("Exit");
    lst = new ActionListener()
    {

      public void actionPerformed(ActionEvent e)
      {
        System.exit(0);
      }
    };
    mItem.addActionListener(lst);
    mFile.add(mItem);
    menuBar.add(mFile);
    JMenu mEdit = new JMenu("Edit");
    mItem = new JMenuItem("Delete");
    lst = new ActionListener()
    {

      public void actionPerformed(ActionEvent e)
      {
        if ( m_activeBean == null )
        {
          return;
        }
        getContentPane().remove(m_activeBean);
        m_activeBean = null;
        validate();
        repaint();
      }
    };
    mItem.addActionListener(lst);
    mEdit.add(mItem);
    menuBar.add(mEdit);
    JMenu mLayout = new JMenu("Layout");
    ButtonGroup group = new ButtonGroup();
    mItem = new JRadioButtonMenuItem("FlowLayout");
    mItem.setSelected(true);
    lst = new ActionListener()
    {

      public void actionPerformed(ActionEvent e)
      {
        getContentPane().setLayout(new FlowLayout());
        validate();
        repaint();
      }
    };
    mItem.addActionListener(lst);
    group.add(mItem);
    mLayout.add(mItem);
    mItem = new JRadioButtonMenuItem("GridLayout");
    lst = new ActionListener()
    {

      public void actionPerformed(ActionEvent e)
      {
        int col = 3;
        int row = ( int ) Math.ceil(getContentPane().
          getComponentCount() / ( double ) col);
        getContentPane().setLayout(new GridLayout(row, col, 10, 10));
        validate();
        repaint();
      }
    };
    mItem.addActionListener(lst);
    group.add(mItem);
    mLayout.add(mItem);
    mItem = new JRadioButtonMenuItem("BoxLayout - X");
    lst = new ActionListener()
    {

      public void actionPerformed(ActionEvent e)
      {
        getContentPane().setLayout(new BoxLayout(
          getContentPane(), BoxLayout.X_AXIS));
        validate();
        repaint();
      }
    };
    mItem.addActionListener(lst);
    group.add(mItem);
    mLayout.add(mItem);
    mItem = new JRadioButtonMenuItem("BoxLayout - Y");
    lst = new ActionListener()
    {

      public void actionPerformed(ActionEvent e)
      {
        getContentPane().setLayout(new BoxLayout(
          getContentPane(), BoxLayout.Y_AXIS));
        validate();
        repaint();
      }
    };
    mItem.addActionListener(lst);
    group.add(mItem);
    mLayout.add(mItem);
    mItem = new JRadioButtonMenuItem("DialogLayout");
    lst = new ActionListener()
    {

      public void actionPerformed(ActionEvent e)
      {
        getContentPane().setLayout(new DialogLayout());
        validate();
        repaint();
      }
    };
    mItem.addActionListener(lst);
    group.add(mItem);
    mLayout.add(mItem);
    menuBar.add(mLayout);
    return menuBar;
  }

  public void focusGained(FocusEvent e)
  {
    m_activeBean = e.getComponent();
    repaint();
  }

  public void focusLost(FocusEvent e)
  {
  }
// This is a heavyweight component so we override paint
// instead of paintComponent. super.paint(g) will
// paint all child components first, and then we
// simply draw over top of them.

  public void paint(Graphics g)
  {
    super.paint(g);
    if ( m_activeBean == null )
    {
      return;
    }
    Point pt = getLocationOnScreen();
    Point pt1 = m_activeBean.getLocationOnScreen();
    int x = pt1.x - pt.x - 2;
    int y = pt1.y - pt.y - 2;
    int w = m_activeBean.getWidth() + 2;
    int h = m_activeBean.getHeight() + 2;
    g.setColor(Color.black);
    g.drawRect(x, y, w, h);
  }

  public static void main(String argv[])
  {
    new BeanContainer();
  }
}

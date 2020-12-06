/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package commonlayouts;

import java.awt.*;
// import java.awt.event.*;
// import java.util.*;
import javax.swing.* ;
// import javax.swing.border.*;
// import javax.swing.event.*;

public class CommonLayouts extends JFrame 
{
  public Integer LAYOUT_FRAME_LAYER = new Integer(1) ;

  public CommonLayouts()
  {
    super("Common Layout Managers");
    setSize( 600, 600);
    
    JDesktopPane desktop = new JDesktopPane();

    getContentPane().add(desktop);

    JInternalFrame fr1 = new JInternalFrame("FlowLayout", true, true);

    fr1.setBounds(10, 10, 150, 150); // ez pozicionalja es meretezi a gyerekablakot

    Container c = fr1.getContentPane();
    c.setLayout(new FlowLayout());
    c.add(new JButton("1"));
    c.add(new JButton("2"));
    c.add(new JButton("3"));
    c.add(new JButton("4"));
    
    desktop.add(fr1, 0);
    fr1.show();
    
    JInternalFrame fr2 = new JInternalFrame("GridLayout", true, true);
    fr2.setBounds(170, 10, 150, 150);
    c = fr2.getContentPane();
    c.setLayout(new GridLayout(2, 2));
    c.add(new JButton("1"));
    c.add(new JButton("2"));
    c.add(new JButton("3"));
    c.add(new JButton("4"));
    desktop.add(fr2, 0);
    fr2.show();

    JInternalFrame fr3 = new JInternalFrame("BorderLayout", true, true);
    fr3.setBounds(330, 10, 150, 150);
    c = fr3.getContentPane();
    c.add(new JButton("1"), BorderLayout.NORTH);
    c.add(new JButton("2"), BorderLayout.EAST);
    c.add(new JButton("3"), BorderLayout.SOUTH);
    c.add(new JButton("4"), BorderLayout.WEST);
    desktop.add(fr3, 0);
    fr3.show();

    JInternalFrame fr4 = new JInternalFrame("BoxLayout - X", true, true);
    fr4.setBounds(10, 170, 250, 80);
    c = fr4.getContentPane();
    c.setLayout(new BoxLayout(c, BoxLayout.X_AXIS));
    c.add(new JButton("1"));
    c.add(Box.createHorizontalStrut(12));
    c.add(new JButton("2"));
    c.add(Box.createGlue());
    c.add(new JButton("3"));
    c.add(Box.createHorizontalGlue());
    c.add(new JButton("4"));
    desktop.add(fr4, 0);
    fr4.show();

    JInternalFrame fr5 = new JInternalFrame( "BoxLayout - Y", true, true);
    fr5.setBounds(330, 170, 150, 200);
    c = fr5.getContentPane();
    c.setLayout(new BoxLayout(c, BoxLayout.Y_AXIS));
    c.add(new JButton("1"));
    c.add(Box.createVerticalStrut(10));
    c.add(new JButton("2"));
    c.add(Box.createGlue());
    c.add(new JButton("3"));
    c.add(Box.createVerticalGlue());
    c.add(new JButton("4"));
    desktop.add(fr5, 0);
    fr5.show();

    // A SpringLayout layout managernel mindegyik kontrol marad a helyen, akarhogy meretezik
    // a tartalmazo ablakot
    JInternalFrame fr6 = new JInternalFrame( "SpringLayout", true, true) ;
    fr6.setBounds(10, 260, 250, 170);
    c = fr6.getContentPane();
    c.setLayout(new SpringLayout());
    c.add(new JButton("1"), new SpringLayout.Constraints( Spring.constant(10),   // bal felso x -> novexik
                                                          Spring.constant(10),   // bal felso y \|/ novexik
                                                          Spring.constant(120),  // szelesseg
                                                          Spring.constant(70))); // magassag

    c.add(new JButton("2"), new SpringLayout.Constraints( Spring.constant(135),
                                                          Spring.constant(10),
                                                          Spring.constant(70),
                                                          Spring.constant(30)));

    c.add(new JButton("3"), new SpringLayout.Constraints( Spring.constant(135),
                                                          Spring.constant(50),
                                                          Spring.constant(70),
                                                          Spring.constant(30)));

    c.add(new JButton("4"), new SpringLayout.Constraints( Spring.constant(10),
                                                          Spring.constant(85),
                                                          Spring.constant(50),
                                                          Spring.constant(40)));

    c.add(new JButton("5"), new SpringLayout.Constraints( Spring.constant(120),
                                                          Spring.constant(90),
                                                          Spring.constant(50),
                                                          Spring.constant(40)));
    desktop.add(fr6, 0);
    fr6.show();

    // GridBagLayout
    // a kontrolok mindig ugyanugy egyutt maradnak, meretezesnel az ablak kozepere kerulnek
    GridBagConstraints cGridBagConstraints = null ;
    JInternalFrame cJInternalFrame7 = new JInternalFrame("GridBagLayout Example 2", true, true) ;
    cJInternalFrame7.setBounds( 50, 400, 270, 140) ;
    Container cContainer = cJInternalFrame7.getContentPane() ;
    cContainer.setLayout( new GridBagLayout()) ;
    cGridBagConstraints = new GridBagConstraints() ;
    cGridBagConstraints.insets = new Insets( 0, 1, 2, 2) ;
    cGridBagConstraints.gridx = 0 ; // Column 0
    cGridBagConstraints.gridy = 0 ; // Row 0
    cGridBagConstraints.gridheight = 2; // Span across 2 rows - ha csak ezt allitom, elfedi az "of" gombot (weight nelkul)
    cGridBagConstraints.weightx = 1.0; // mindegyik komponens kozt (mivel kesobb nem valtoztatom) egyenletesen ossza szet a helyet
    cGridBagConstraints.weighty = 1.0;
    cGridBagConstraints.ipadx = 5 ; // Increases component width by 10 pixels
    cGridBagConstraints.ipady = 5 ; // Increases component height by 10 pixels
    //cGridBagConstraints.anchor = GridBagConstraints.NORTH;
    cGridBagConstraints.fill = GridBagConstraints.BOTH;
    cContainer.add( new JButton( "Wonderful" ), cGridBagConstraints) ;

    cGridBagConstraints.gridx = 1 ; // Column 1
    cGridBagConstraints.ipadx = 0 ; // Reset the padding to 0
    cGridBagConstraints.ipady = 0 ;

    //cGridBagConstraints.anchor = GridBagConstraints.SOUTHWEST;
    cGridBagConstraints.fill = GridBagConstraints.HORIZONTAL;
    cContainer.add( new JButton( "World" ), cGridBagConstraints) ;

    cGridBagConstraints.gridx = 0 ; // Column 0
    cGridBagConstraints.gridy = 1 ; // Row 1
    cGridBagConstraints.fill = GridBagConstraints.NONE ;
    cContainer.add( new JButton( "Of"), cGridBagConstraints) ;

    cGridBagConstraints.gridx = 1 ; // Column 1
    cContainer.add( new JButton( "Swing !!!" ), cGridBagConstraints) ;
    desktop.add( cJInternalFrame7, 0 );
    cJInternalFrame7.show();

    desktop.setSelectedFrame(fr6);
}
public static void main(String argv[]) {
CommonLayouts frame = new CommonLayouts();
frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
frame.setVisible(true);
}
}
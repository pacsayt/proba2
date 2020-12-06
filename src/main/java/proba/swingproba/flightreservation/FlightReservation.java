/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package flightreservation;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;
import javax.swing.event.*;

public class FlightReservation extends JFrame {

    public FlightReservation() {
        super("Flight Reservation Dialog");
        setSize(400, 300);
        JPanel p1 = new JPanel();
        p1.setLayout(new BoxLayout(p1, BoxLayout.X_AXIS));
        JPanel p1r = new JPanel();
        p1r.setBorder(new EmptyBorder(10, 10, 10, 10));
// Variant 1
        p1r.setLayout(new GridLayout(3, 2, 5, 5));
        
        p1r.add(new JLabel("Date:"));
        p1r.add(new JTextField());
        
        p1r.add(new JLabel("From:"));
        JComboBox cb1 = new JComboBox();
        cb1.addItem("New York");
        p1r.add(cb1);
        
        p1r.add(new JLabel("To:"));
        JComboBox cb2 = new JComboBox();
        cb2.addItem("London");
        p1r.add(cb2);
        p1.add(p1r);

///////////////
// Variant 2 //
///////////////
// p11.setLayout(new BoxLayout(p11, BoxLayout.Y_AXIS));
//
// JPanel p12 = new JPanel();
// p12.setLayout(new BoxLayout(p12, BoxLayout.Y_AXIS));
//
// p11.add(new JLabel("Date:"));
// p12.add(new JTextField());
//
// p11.add(new JLabel("From:"));
// JComboBox cb1 = new JComboBox();
// cb1.addItem("New York");

//Constructor positions all necessary GUI components North panel with EmptyBorder for
//spacing 3 by 2 grid Put 3 labeled components in grid (labels too wide) Second variant,
//using two vertical BoxLayouts (labels and components not aligned)

// p12.add(cb1);
//
// p11.add(new JLabel("To:"));
// JComboBox cb2 = new JComboBox();
// cb2.addItem("London");
// p12.add(cb2);
//
// p1.add(p11);
// p1.add(Box.createHorizontalStrut(10));
// p1.add(p12);
///////////////
// Variant 3 //
///////////////
// JPanel p11 = new JPanel();
// p11.setLayout(new GridLayout(3, 1, 5, 5));
//
// JPanel p12 = new JPanel();
// p12.setLayout(new GridLayout(3, 1, 5, 5));
//
// p11.add(new JLabel("Date:"));
// p12.add(new JTextField());
//
// p11.add(new JLabel("From:"));
// JComboBox cb1 = new JComboBox();
// cb1.addItem("New York");
// p12.add(cb1);
//
// p11.add(new JLabel("To:"));
// JComboBox cb2 = new JComboBox();
// cb2.addItem("London");
// p12.add(cb2);
//
// p1r.setLayout(new BorderLayout());
// p1r.add(p11, BorderLayout.WEST);
// p1r.add(p12, BorderLayout.CENTER);
// p1.add(p1r);
        JPanel p3 = new JPanel();
        p3.setLayout(new BoxLayout(p3, BoxLayout.Y_AXIS));
        p3.setBorder(new TitledBorder(new EtchedBorder(), "Options"));
        ButtonGroup group = new ButtonGroup();
        JRadioButton r1 = new JRadioButton("First class");
        group.add(r1);
        p3.add(r1);
        JRadioButton r2 = new JRadioButton("Business");
        group.add(r2);
        p3.add(r2);

//Third variant, using two 3 by 1 grids (arranged correctly, but complex)
//Vertical BoxLayout for radio buttons, on East side of frame

        JRadioButton r3 = new JRadioButton("Coach");
        group.add(r3);
        p3.add(r3);
        p1.add(p3);
        getContentPane().add(p1, BorderLayout.NORTH);
        JPanel p2 = new JPanel(new BorderLayout());
        p2.setBorder(new TitledBorder(new EtchedBorder(), "Available Flights"));
        JList list = new JList();
        JScrollPane ps = new JScrollPane(list);
        p2.add(ps, BorderLayout.CENTER);
        getContentPane().add(p2, BorderLayout.CENTER);
        JPanel p4 = new JPanel();
        JPanel p4c = new JPanel();
        p4c.setLayout(new GridLayout(1, 3, 5, 5));
        JButton b1 = new JButton("Search");
        p4c.add(b1);
        JButton b2 = new JButton("Purchase");
        p4c.add(b2);
        JButton b3 = new JButton("Exit");
        p4c.add(b3);
        p4.add(p4c);
        getContentPane().add(p4, BorderLayout.SOUTH);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }

    public static void main(String argv[]) {
        new FlightReservation();
    }
}
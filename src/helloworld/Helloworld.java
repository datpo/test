/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package helloworld;

import javax.swing.JOptionPane;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.JPanel;

/**
 *
 * @author datpo_000
 */

public class Helloworld {

    /**
     * @param args the command line arguments
     */
    // every line of code that runs must be inside a class
   // tao lop hien thi
   private static class Display extends JPanel{
       public void paintComponent(Graphics g){
           super.paintComponent(g);
           g.drawString("hello po", 20, 30);
       }            
   }
   private static class ButtonHandl implements ActionListener{
       public void actionPerformed(ActionEvent e){
           Display d2 = new Display();
           JFrame w2 = new JFrame();
           w2.setContentPane(d2);
           w2.setSize(100, 100);
           w2.setLocation(100, 100);
           w2.setVisible(true);
           
       }
   }
    public static void main(String[] args) {
        // TODO code application logic here
        //int b = 2000, a = 1000, c = 5000;
        // tien la mot doi tuong
//       ChuanHoaHoTen c = new ChuanHoaHoTen();
//    
//       System.out.println(c.ChuanHoa());
//       Animal a = new Dog();            
//       a.TiengKeu();
//       System.out.println(a.So());
//      Dog d = new Dog();
//      //System.out.println(d.So());
//      d.TiengKeu();
//      Meo m = new Meo();
//      m.TiengKeu();
        
        //
        Display dis = new Display();
        JButton b = new JButton("next");
        ButtonHandl listener = new ButtonHandl();
        b.addActionListener(listener);
        //
        JPanel jp = new JPanel();
        jp.setLayout(new BorderLayout());
        jp.add(dis, BorderLayout.CENTER);
        jp.add(b, BorderLayout.SOUTH);
        //
        JFrame w1 = new JFrame("test");
        w1.setContentPane(jp);
       w1.setSize(200, 100);
       w1.setLocation(100, 100);
        w1.setVisible(true);
        //JOptionPane.showMessageDialog(null, "hello po");

    }

   
    }
    

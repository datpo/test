/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package gamecaro;

import com.sun.java.accessibility.util.AWTEventMonitor;
import sun.security.krb5.JavaxSecurityAuthKerberosAccess;
import java.awt.event.*;
import java.awt.*;
import java.util.ArrayList;
import javax.swing.*;
import java.util.List;

/**
 *
 * @author datpo_000
 */
public class QuanCo extends JPanel {
    
    public static void main(String[] args){
        JFrame window = new JFrame();
        QuanCo q = new QuanCo();
       // q.handlWin();
        window.setContentPane(q);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setSize(400, 400);
        window.setVisible(true);
    }
    // variable
    // List<chessPlayer> Player;
    boolean win = false;
    Player1 P1;
    Player2 P2;
    // Player1
    
    
    //private boolean drawing;
    QuanCo(){
//        this.Player = new ArrayList<chessPlayer>();
//            Player.add();
//            Player.add(new chessPlayer("po", 2));
//        P1 = new Player1("dat", 1);
//        P2 = new Player2("po", 2);
        doiNguoiChoi();
        addMouseListener(new MouseAdapter() {
             public void mousePressed(MouseEvent e){
        int x = e.getX()/50;
        int y = e.getY()/50;
        Const.rowX = x;
        Const.colY = y;
       
        Graphics g = getGraphics();
        if(Const.drawing[x][y] == 1|| Const.drawing[x][y] == 2) return;
        if(e.isMetaDown()){
            Const.drawing[x][y] = 1; // 1 is X
            g.setColor(Color.white);
            g.drawString("X", x*50+25, y*50+25);
            
        }
        else{
            Const.drawing[x][y] = 2;
             g.setColor(Color.green);
            g.drawString("O", x*50+25, y*50+25);
        }
       // bat su kien tai chinh thoi diem click
        //win vertical
        endVertical();
        // Win horizanal
        endHorizanal();
        //Win diagonal
        Winmain();
        // Win exttra
        winExtra();
        
       
    }
    
});
    }
    //
    public void doiNguoiChoi(){
        
    }
    //
    
   public void paintComponent(Graphics g){
        for(int i = 0; i < 8; i++)
            for(int j = 0; j < 8; j++){
                if((i%2) == (j%2)) g.setColor(Color.red);
                else g.setColor(Color.black);
                g.fillRect(i*50, j*50, 50, 50);
                Const.drawing[i][j] = 0;
                Const.rowX = i;
                Const.colY = j;
            }
        JPanel j2 = new JPanel();
        
        add(j2,BorderLayout.SOUTH);
        
    }
   //
   // Win horizontal
   public void endHorizanal(){
               
        int countX = 1;
        int countO = 1;
        //Win horizontal
        if(Const.drawing[Const.rowX][Const.colY]==1){
            for(int i = Const.rowX; i >= 0; i--){
                if(Const.drawing[i][Const.colY] == 1) countX++;
                else if(Const.drawing[i][Const.colY] == 2) break;
                if(countX == 5) {
                    win = true;
                    break;
                }
            }
            for(int j = Const.rowX+1; j< 8; j++){
                if(Const.drawing[j][Const.colY] == 1) countX++;
                else if(Const.drawing[j][Const.colY] == 2) break;
                if(countX == 5){
                    win = true;
                    break;
                }
               
            }
            
        }
        //
        if(Const.drawing[Const.rowX][Const.colY]==2){
            for(int i = Const.rowX; i >= 0; i--){
                if(Const.drawing[i][Const.colY] == 2) countO++;
               else if(Const.drawing[i][Const.colY] == 1) break;
                if(countO == 5) {
                    win = true;
                    break;
                }
            }
            for(int j = Const.rowX+1; j< 8; j++){
                if(Const.drawing[j][Const.colY] == 2) countO++;
                else if(Const.drawing[j][Const.colY] == 1) break;
                if(countO == 5) {
                    win = true;
                    break;
                }
            }
            
        }
        if(win) thongBao();
           

   }
   //
   public void Winmain(){
       int countX = 1;
       int countO = 1;
       int x = Const.rowX;
       int y = Const.colY;
       if(Const.drawing[x][y] == 1){
           for(int i = 0; i <= x; i++){
               if(y-i < 0 || x-i < 0) break;
               if(Const.drawing[x-i][y-i] == 1) countX++;
               else break;
               if(countX == 5){
                   win = true;
                   break;
               }
           }
           for(int i = 1; i<8-x; i++){
               if(y+i >= 8 || x+i >= 8) break;
               if(Const.drawing[x+i][y+i] == 1) countX++;
               else break;
               if(countX == 5){
                   win = true;
                   break;
               }
           }
       }
       // O
       if(Const.drawing[x][y] == 2){
           for(int i = 0; i <= x; i++){
               if(y-i < 0 || x-i < 0) break;
               if(Const.drawing[x-i][y-i] == 2) countO++;
               else break;
               if(countO == 5){
                   win = true;
                   break;
               }
           }
           for(int i = 1; i<8-x; i++){
               if(y+i >= 8 || x+i >= 8) break;
               if(Const.drawing[x+i][y+i] == 2) countO++;
               else break;
               if(countO == 5){
                   win = true;
                   break;
               }
           }
       }
       if(win) thongBao();
   }
    public void winExtra(){
       int countX = 1;
       int countO = 1;
       int x = Const.rowX;
       int y = Const.colY;
       if(Const.drawing[x][y] == 1){
           for(int i = 0; i <= x; i++){
               if(y+i >= 8 || x-i < 0) break;
               if(Const.drawing[x-i][y+i] == 1) countX++;
               else break;
               if(countX == 5){
                   win = true;
                   break;
               }
           }
           for(int i = 1; i<8-x; i++){
               if(y-i < 0 || x+i >= 8) break;
               if(Const.drawing[x+i][y-i] == 1) countX++;
               else break;
               if(countX == 5){
                   win = true;
                   break;
               }
           }
       }
       // O
       if(Const.drawing[x][y] == 2){
           for(int i = 0; i <= x; i++){
               if(y+i >= 8 || x-i < 0) break;
               if(Const.drawing[x-i][y+i] == 2) countO++;
               else break;
               if(countO == 5){
                   win = true;
                   break;
               }
           }
           for(int i = 1; i<8-x; i++){
               if(x+i >= 8 || y-i < 0) break;
               if(Const.drawing[x+i][y-i] == 2) countO++;
               else break;
               if(countO == 5){
                   win = true;
                   break;
               }
           }
       }
       if(win) thongBao();
   }
    public void endVertical(){
         int countx = 1;
        int counto = 1;
        int x = Const.rowX;
        int y = Const.colY;

        // Win vertical
        if(Const.drawing[x][y] == 1){
            for(int i = y; i >= 0; i--){
                if(Const.drawing[x][i] == 1) countx++;
                else break;
                if(countx == 5){
                    win = true;
                    break;
                }
                
            }
            for(int j = y+1; j < 8; j++){
                if(Const.drawing[x][j] == 1) countx++;
                else break;
                if(countx == 5){
                    win = true;
                    break;
                }
            }
            
        }
        //
        if(Const.drawing[x][y] == 2){
            for(int i = y; i >= 0; i--){
                if(Const.drawing[x][i] == 2) counto++;
                else break;
                if(counto==5){
                    win = true;
                    break;
                }
            }
            for(int i = y+1; i < 8; i++){
                if(Const.drawing[x][i] == 2) counto++;
                else break;
                if(counto == 5){
                    win = true;
                    break;
                }
            }
            
        }
        if(win) thongBao();
    }

   private void thongBao(){
       JFrame w2 = new JFrame();
       JPanel j = new JPanel(){
           public void paintComponent(Graphics g){
               g.drawString("ket thuc game", 20, 30);
           }
       };
       win = false;
       w2.setSize(400, 400);
       w2.setContentPane(j);
       w2.setVisible(true);
       
   }
}

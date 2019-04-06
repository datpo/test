/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package helloworld;

/**
 *
 * @author datpo_000
 */
public class ChuanHoaHoTen {
    String S = " daT   pO yEU   eM ";
    String Kq = "";
    String ChuanHoa()
    {
        String First = " ";
        int t = 0;
        for(int i = 0; i < S.length();i++)
        {
         
         char[] E = S.toCharArray();
         char e = E[i];
         if(" ".equals(First))
         {
          if(e == ' ') continue;
             Kq += String.valueOf(e).toUpperCase();
          
         }
         else  {

             Kq += String.valueOf(e).toLowerCase();}
         
         First = String.valueOf(e);
        }
     return Kq;
    }
    
    
}

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
public class Tien {
    int[] MenhGia={1000, 2000, 5000};
    int Count = 0;
    int Dem()
   {
    for(int i = 0; i <= 10; i++)
        for(int j = 0; j <= 5; j++)
            for(int k = 0; k <= 2; k++)
            {
             if(i*MenhGia[0]+j*MenhGia[1]+k*MenhGia[2] == 10000) Count++;
            }
    return Count;
   }
    
}



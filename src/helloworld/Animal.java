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
abstract class Animal {
   public int Id;
   
   abstract int So();
   
   
    
    void TiengKeu(){
        
    }
}
class Dog extends Animal{
    
    int So(){
        Id = 1;
        return Id;
    }
    void TiengKeu(){
    System.out.println("gau gau");
}
}
class Meo extends Animal{
    int So(){
        return Id = 2;
    }
    void TiengKeu(){
        System.out.println("meo meo");
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.mum.cs545;

/**
 *
 * @author moham
 */
public class RadioState {
    public boolean radioJSPCool=false;
    public boolean JSFwayCool=false;
    public boolean moonCheese=false;
    
    public boolean radioJSPCool1=false;
    public boolean JSFwayCool1=false;
    public boolean moonCheese1=false;
    
    private static RadioState single_instance = null; 

    // static method to create instance of Singleton class 
    public static RadioState getInstance() 
    { 
        if (single_instance == null) 
            single_instance = new RadioState(); 
  
        return single_instance; 
    } 

    public boolean getRadioJSPCool() {
        return radioJSPCool;
    }

    public boolean getJSFwayCool() {
        return JSFwayCool;
    }

    public boolean getMoonCheese() {
        return moonCheese;
    }

    public void setRadioJSPCool(String radioJSPCool) {
        if (radioJSPCool != null)
        {
            this.radioJSPCool = (Integer.parseInt(radioJSPCool)==1);
            this.radioJSPCool1 = !this.radioJSPCool;
        }
    }

    public void setJSFwayCool(String JSFwayCool) {
        if (JSFwayCool != null) {
            this.JSFwayCool = (Integer.parseInt(JSFwayCool)==1);
            this.JSFwayCool1 = !this.JSFwayCool;
        }
    }

    public void setMoonCheese(String moonCheese) {
        if (moonCheese != null) {
            this.moonCheese = (Integer.parseInt(moonCheese)==1);
            this.moonCheese1 = !this.moonCheese;
        }
    }
    
}

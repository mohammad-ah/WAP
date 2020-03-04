/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mum.cs472;

/**
 *
 * @author moham
 */
public class CorrectAnswers {
    
    public int correct = 0;
    public String error = "";
    public int tries = 0;
    public int age = 0;

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getTries() {
        return tries;
    }

    public void setTries(int tries) {
        this.tries = tries;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }
    
    private static CorrectAnswers single_instance = null; 
    
    public static CorrectAnswers getInstance() 
    { 
        if (single_instance == null) 
            single_instance = new CorrectAnswers(); 
  
        return single_instance; 
    } 

    public void setCorrect(int correct) {
        this.correct = correct;
    }

    public int getCorrect() {
        return correct;
    }
    
}

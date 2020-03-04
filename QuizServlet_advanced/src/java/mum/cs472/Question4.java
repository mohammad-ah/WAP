/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mum.cs472;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author moham
 */
public class Question4 extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */


    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
String answer = request.getParameter("answer");
        int answer1=0;
                
        try
        {
            answer1 = Integer.parseInt(answer.trim());
            
        } catch (Exception e) {
        }
        
        if (answer1 == 13)
        {
            int c = CorrectAnswers.getInstance().correct;
            if(CorrectAnswers.getInstance().tries == 0)
            {
            c+=10;
            }
            else if(CorrectAnswers.getInstance().tries == 1)
            {
                c+=5;
            }
            else {
                c+=2;
            }
            CorrectAnswers.getInstance().setCorrect(c);
        }
        else {
            
            PrintWriter out = response.getWriter();
   System.out.println("test" + CorrectAnswers.getInstance().tries);
   
            CorrectAnswers.getInstance().setTries(++CorrectAnswers.getInstance().tries);
            if(CorrectAnswers.getInstance().tries != 3) {
                    RequestDispatcher dispatcher =
                request.getRequestDispatcher("Question4.jsp");
                 dispatcher.forward(request, response);
            }
            else {
               
                    request.setAttribute("correctAnswer", "the answer to the previous questions is 13");
                
            }
        }
        
        RequestDispatcher dispatcher = request.getRequestDispatcher("Question5.jsp");
     dispatcher.forward(request, response);
     
      CorrectAnswers.getInstance().setTries(0);

      
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        request.setAttribute("status", "Think of Prime");

        RequestDispatcher dispatcher =
request.getRequestDispatcher("Question4.jsp");
 dispatcher.forward(request, response); 
 

    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}

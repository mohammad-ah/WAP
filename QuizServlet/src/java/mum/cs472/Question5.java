/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mum.cs472;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author moham
 */
public class Question5 extends HttpServlet {

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
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
String answer = request.getParameter("answer");
        int answer1=0;
        
        String corrects = request.getParameter("correct");
        int correct = Integer.parseInt(corrects.trim());;
        
        try
        {
            answer1 = Integer.parseInt(answer.trim());
            
        } catch (Exception e) {
        }
        
        if (answer1 == 32)
        {
            correct++;
        }
        
        PrintWriter out = response.getWriter();
        out.print("<html><head><title>Test</title></head><body>");
        
         out.print("<h1>The number Quiz</h1>\n" +
"        <p>your current score is " + Integer.toString(correct) + "</p>\n" +
"            <p>You have completed the Number Quiz, with a score of " + Integer.toString(correct) + " out of 5</p>\n");           
            
        
        out.print("</body></html>"); 
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
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
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

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.mum.cs545;

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
public class ChooseServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */

 protected void doGet(HttpServletRequest request, HttpServletResponse
response)
 throws ServletException, IOException
 {
 RequestDispatcher dispatch = request.getRequestDispatcher("Choose.jsp");
 dispatch.forward(request, response);
 }

 protected void doPost(HttpServletRequest request, HttpServletResponse
response)
 throws ServletException, IOException
 {
 String choice = request.getParameter("radioJSPCool");
 String choice2 = request.getParameter("JSFwayCool");
 String choice3 = request.getParameter("moonCheese");
 
 if (choice != null)
 System.out.println ("choice= "+ choice);
 else
 System.out.println("No choice made");
 RadioState st = RadioState.getInstance();
 st.setRadioJSPCool(choice);
 st.setJSFwayCool(choice2);
 st.setMoonCheese(choice3);
 
 
     RequestDispatcher dispatch = request.getRequestDispatcher("Choose.jsp");
 dispatch.forward(request, response);
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

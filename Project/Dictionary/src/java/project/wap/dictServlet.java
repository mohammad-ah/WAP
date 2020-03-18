/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project.wap;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;
//import java.util.ArrayList;
//import java.util.List;
import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;
//import java.sql.Connection;
//import java.sql.DriverManager;

//import java.sql.ResultSet;



/**
 *
 * @author moham
 */
public class dictServlet extends HttpServlet {

    @Resource(name="jdbc/entries") // For Tomcat, define as <Resource> in context.xml and declare as <resource-ref> in web.xml.
    private DataSource dataSource;
    private SearchItem words;

    @Override
    public void init() {
        words = new SearchItem(dataSource);
        
    }
    
    private JsonObject processRequest(String word)
            throws ServletException, IOException {
                JsonObject lists = new JsonObject();
        try {
            lists = words.list(word);
        } catch (SQLException e) {
            System.out.println("Cannot obtain word from DB");
            throw new ServletException("Cannot obtain word from DB", e);
        }
        return lists;
    }
    
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
            
        String searchWord = request.getParameter("q");

        if (searchWord != null) {
            
            JsonObject  e = processRequest(searchWord);
            String entryJson = new Gson().toJson(e);
            JsonParser parse = new JsonParser(); 

            PrintWriter out = response.getWriter();

            out.print(entryJson);
            out.flush();
        }
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

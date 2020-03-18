/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project.wap;

//import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
//import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
//import javax.naming.Context;
//import javax.naming.InitialContext;
import javax.sql.DataSource;

/**
 *
 * @author moham
 */
public class SearchItem {

    private DataSource dataSource;

    public SearchItem(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public JsonObject list(String word) throws SQLException {
        List products = new ArrayList<>();
        JsonObject jObjDevice = new JsonObject();
        String connectionURL = "jdbc:mysql://localhost:3306/entries";


        Map <String, List> wordEntry = null;
        try {

            Connection connection = null;

            Class.forName("com.mysql.jdbc.Driver");

            System.out.println("inside list after driver");

            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/entries", "root", "toor");

            PreparedStatement statement = connection.prepareStatement("SELECT * FROM ENTRIES WHERE word LIKE '" + word + "%'");;
            ResultSet resultSet = statement.executeQuery();

            System.out.println("statement executed");

            HashMap<String, JsonArray> definitions = new HashMap<>();

            JsonArray jArray = new JsonArray();

            while (resultSet.next()) {
                System.out.println(resultSet.getString("definition"));
                String type = resultSet.getString("wordtype");
                String def = resultSet.getString("definition");
                String wordCol = resultSet.getString("word");

                JsonObject jObj = new JsonObject();
                jObj.addProperty("wordtype", type);
                jObj.addProperty("definition", def);

                if(definitions.containsKey(wordCol))
                {
                    definitions.get(wordCol).add(jObj);
                } else {
                    definitions.put(wordCol, new JsonArray());
                    definitions.get(wordCol).add(jObj);
                }

            }


            for (String key : definitions.keySet()) {
                jObjDevice.add(key, definitions.get(key));
            }

            resultSet.close();
        }catch(Exception e){

            System.out.println("Exception is ;"+e);

        }

        return jObjDevice;
    }

}
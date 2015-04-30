/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tubes;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author R16
 */
public class DBase {
     private String dbuser="root";
    private String password="";
    private java.sql.Statement statement;
    private java.sql.Connection connection;
    private java.sql.ResultSet resultSet;
    private String dburl = "jdbc:mysql://localhost:3306/dbtubespbo";
    public  void connect() throws SQLException{
        connection =DriverManager.getConnection(dburl,dbuser,password);
        statement = connection.createStatement();
    }
    public ResultSet getData(String query) throws SQLException{
        return statement.executeQuery(query);
    }
    public void execute(String query) {
        try {
            statement.executeUpdate(query);
        } catch (SQLException ex) {
        }
    }
}

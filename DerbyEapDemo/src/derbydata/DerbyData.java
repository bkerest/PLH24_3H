/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package derbydata;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author vker
 */
public class DerbyData {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        createTableAndData();
    }
    
    private static void createTableAndData(){

        try {
            Connection connection = connect();
            String creatTableSQL = "CREATE TABLE D_USER"
                +"(ID INTEGER NOT NULL PRIMARY KEY,"
                +"USERNAME VARCHAR(20),"
                +"PASSWORD VARCHAR(20))";
            Statement statement;
            statement = connection.createStatement();
            statement.executeUpdate(creatTableSQL);
            statement.close();
            connection.close();
        } catch (SQLException ex) {
            Logger.getLogger(DerbyData.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
                

        
    }
    
    private static Connection connect(){
        String connectionString = "jdbc:derby:derbyeap:create=true";
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(connectionString);
        } catch (SQLException ex) {
            Logger.getLogger(DerbyData.class.getName()).log(Level.SEVERE, null, ex);
        }
        return connection;        
    }
    
}

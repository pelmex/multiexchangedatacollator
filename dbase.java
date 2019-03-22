/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package xerxis;

/**
 *
 * @author ZEUS
 */
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class dbase {
    public String dbasepath ;    
    private final String password;
    private final String username;
    private Connection connect;
    public Statement queries;
    public String sqlstrings;
    public ResultSet queryresult;
    
    

    public dbase() {
        this.password = "abc123";
        this.dbasepath = null;
        this.username = "pelmex";       
        this.connect = null;
        this.sqlstrings = null;
        this.queryresult = null;
        
    }
    public ResultSet connectsqlite(String query){
        this.sqlstrings = query;
        this.dbasepath = "jdbc:sqlite:xerxes.db";
        try {
            connect = DriverManager.getConnection(dbasepath);
            queries = connect.createStatement();
            queryresult = queries.executeQuery(sqlstrings);
        } catch (SQLException ex) {
            Logger.getLogger(dbase.class.getName()).log(Level.SEVERE, null, ex);
            System.err.println(ex);
        }
        return queryresult;
        
    }
    public ResultSet connectmysql(String query){
        this.sqlstrings = query;
        this.dbasepath = "jdbc:mysql://localhost:3306/xerxes";
        try {
            connect = DriverManager.getConnection(dbasepath,username,password);
            queries = connect.createStatement();
            queryresult = queries.executeQuery(sqlstrings);
        } catch (SQLException ex) {
            Logger.getLogger(dbase.class.getName()).log(Level.SEVERE, null, ex);
            System.err.println(ex);
        }
        return queryresult;
        
    }
    public ResultSet connectmsftsql(String query){
        this.sqlstrings = query;
        this.dbasepath = "jdbc:sqlserver://localhost:1433;databaseName=Assets";
        try {
            connect = DriverManager.getConnection(dbasepath,username,password);
            queries = connect.createStatement();
            queryresult = queries.executeQuery(sqlstrings);
        } catch (SQLException ex) {
            Logger.getLogger(dbase.class.getName()).log(Level.SEVERE, null, ex);
            System.err.println(ex);
        }
        return queryresult;
    }
}   
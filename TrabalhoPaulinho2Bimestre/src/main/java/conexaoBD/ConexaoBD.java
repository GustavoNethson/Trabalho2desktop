/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package conexaoBD;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Gustavo Henrique
 *         João Marcos
 */

public class ConexaoBD {
    
    private static final String DRIVER = "org.postgresql.Driver";
    private static final String URL = "jdbc:postgresql://localhost:5432/VendaBD";
    private static final String USER = "postgres";
    private static final String PASSWORD = "unipar";
    
    //Abrindo a conexão com o banco de dados    
    public static Connection getConection(){
        
        try {
            
            Class.forName(DRIVER);
            
            return DriverManager.getConnection(URL, USER, PASSWORD);
            
        } catch (ClassNotFoundException ex) {
            
            Logger.getLogger(ConexaoBD.class.getName()).log(Level.SEVERE, null, ex);
            
        } catch (SQLException ex) {
            
            Logger.getLogger(ConexaoBD.class.getName()).log(Level.SEVERE, null, ex);
        
        }

        return null;
        
    }
    
    //Fechando a conexão com o banco de dados
    public static void closeConnection(Connection conn){
        if(conn != null){
            
            try{
                
                conn.close();
                
            } catch (SQLException ex){
                
                Logger.getLogger(ConexaoBD.class.getName()).log(Level.SEVERE, null, ex);
                
            }
            
        }
    }
    
    
    //Fechando a transação da tabela
    public static void closeTransaction(Connection Conn, PreparedStatement ps){
        
        if (ps != null){
            
            try{
                
                ps.close();
                
            } catch (SQLExcsption ex){
                
                Logger.getLogger(ConexaoBD.class.getName()).log(Level.SEVERE, null, ex);
            
            } 
            
            
            
        }
    }

    public static Connection getConecion() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}

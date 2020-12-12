/*
 * Classe reponsável pela conexão
 */

package com.sisgaming.DAL;

import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;

/**
 * SisGaming / DAL / ConnectionFactory
 * @author MrX
 */

public class ConnectionFactory {
    
    private static Connection con = null;
    
    public static Connection requestConnection(){
        try
        {
            Class.forName("org.sqlite.JDBC");
            String strConn = "jdbc:sqlite:" + System.getProperty("user.home") + "\\Documents\\Sisgaming Docs\\database\\db_sisgaming.sqlite";
            con = DriverManager.getConnection(strConn);
            
            return con;
            
        } catch(Exception e)
        {
            JOptionPane.showMessageDialog(null, "Impossivel conectar-se à base de dados!"
                                    ,"Erro de conexão", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
            return null;
        }
    }
}

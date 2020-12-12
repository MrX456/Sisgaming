/*
 * Classe reponsável pela validação para inserção de dados
 */

package com.sisgaming.Controller;

import javax.swing.JOptionPane;

/**
 * SisGaming / Controller / Validate
 * @author MrX
 */

public class Validate {
    
    public static boolean validarGame(String titulo) {
        
        if(titulo.trim().isEmpty() || titulo.trim().length() > 100) {
            
            JOptionPane.showMessageDialog(null, "Impossível cadastrar este game!!"
                                    ,"Erro de cadastro", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        
        return true;
    }
}

/*
 * Classe reponsável por encapsular algumas intruções sql
 */
package com.sisgaming.Controller;

/**
 * SisGaming / Controller / SqlCommand
 * @author MrX
 */

public class SqlCommand {
    
    private static final String cadastrarGame = "INSERT INTO tbl_games(nome_game, plataforma_game, "
            + "screenshot) VALUES (?, ?, ?)";
    
    private static final String atualizarGame = "UPDATE tbl_games SET nome_game = ?, plataforma_game = ?,"
            + "screenshot = ? WHERE id = ?";
    
    private static final String deletarGame = "DELETE FROM tbl_games WHERE id = ?";

    public static String getCadastrarGame() {
        return cadastrarGame;
    }

    public static String getAtualizarGame() {
        return atualizarGame;
    }

    public static String getDeletarGame() {
        return deletarGame;
    }
    
    
    
}

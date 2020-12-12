/*
 * Classe reponsável pela instância de Games
 */

package com.sisgaming.Tools;

/**
 * SisGaming / Tools / Game
 * @author MrX
 */

public class Game {
    
    private int id;
    
    private String titulo;
    
    private String plataforma;
    
    private String screenshotPath;

    public Game(int id, String titulo, String plataforma, String screenshotPath) {
        this.id = id;
        this.titulo = titulo;
        this.plataforma = plataforma;
        this.screenshotPath = screenshotPath;
    }

    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getPlataforma() {
        return plataforma;
    }

    public void setPlataforma(String plataforma) {
        this.plataforma = plataforma;
    }

    public String getScreenshotPath() {
        return screenshotPath;
    }

    public void setScreenshotPath(String screenshotPath) {
        this.screenshotPath = screenshotPath;
    }
    
    
}

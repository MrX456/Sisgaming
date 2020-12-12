/*
 * Classe reponsável por filtrar a seleção de arquivos do jFileChooser
 */

package com.sisgaming.Tools;

import java.io.File;
import javax.swing.filechooser.FileFilter;

/**
 * SisGaming / Tools / FileTypeFilter
 * @author MrX
 */

public class FileTypeFilter extends FileFilter {

    private final String extension;
    private final String description;
    
    //Construtor
    public FileTypeFilter(String extension, String description){
        this.extension = extension;
        this.description = description;
    }
    
    @Override
    public boolean accept(File file) {
        
        if(file.isDirectory()){
            return true;
        }
        return file.getName().endsWith(extension);
        
    }

    @Override
    public String getDescription() {
        
         return description + String.format(" (*%S)", extension);
         
    }
}

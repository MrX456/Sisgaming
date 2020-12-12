/*
 * Classe reponsável por métodos diversos
 */

package com.sisgaming.Tools;

import java.awt.Desktop;
import java.awt.Image;
import java.awt.Toolkit;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

/**
 * SisGaming / Tools / Misc
 * @author MrX
 */

public class Misc {
    
        
    public static ImageIcon resizeSelectedImage(String path) {
        
        ImageIcon image = new ImageIcon(path);
        Image img = image.getImage();
        // Tamanho da label
        Image resize = img.getScaledInstance(210, 130, Image.SCALE_SMOOTH);
        ImageIcon i = new ImageIcon(resize);
        return i;
        
    }
    
    public static String chooseImage(String imgPath) {
        
        JFileChooser choose = new JFileChooser("home.user");
        
        choose.setFileFilter(new FileTypeFilter("png", "Image"));
        choose.setFileFilter(new FileTypeFilter("jpg", "Image"));
        
        
        int result = choose.showSaveDialog(null);
        
        if(result == JFileChooser.APPROVE_OPTION) {
            
            File selectedFile = choose.getSelectedFile();
            String path = selectedFile.getAbsolutePath();
            
            imgPath = path;
        }
        
        return imgPath;
        
    }
    
    public static byte[] lerArquivo(String imgPath) {
        
        
        ByteArrayOutputStream bos = null;
        
        try {
            
            File file = new File(imgPath);
            FileInputStream fis = new FileInputStream(file);
            byte[] buffer = new byte[1024];
            bos = new ByteArrayOutputStream();
            
            try {
                for(int len; (len = fis.read(buffer)) != -1;)
                    bos.write(buffer, 0, len);
            } catch (IOException ex) {
                ex.printStackTrace();
            }
            
           return bos != null ? bos.toByteArray() : null;
            
            
        } catch (FileNotFoundException  e) {
            
            e.printStackTrace();
            return null;
            
        } 
    }
    
     public static ImageIcon createIcon() {
        
        return new ImageIcon(Toolkit.getDefaultToolkit().getClass().getResource("/com/sisgaming/icons/icon.png"));
    }
     
     public static void abriDocumentacao() {
        if(Desktop.isDesktopSupported()) {
            
            try {
                
               
                final String path = System.getProperty("user.home") + "\\Documents\\Sisgaming Docs\\SisGaming_Documentação.pdf";
                File doc = new File(path);
                Desktop.getDesktop().open(doc);
            
                
            } catch (Exception e) {
                
                e.printStackTrace();
                JOptionPane.showMessageDialog(null, "Documentação não encontrada!"
                                    ,"Erro", JOptionPane.ERROR_MESSAGE);
                 
            }
            
        }
    }
    
}

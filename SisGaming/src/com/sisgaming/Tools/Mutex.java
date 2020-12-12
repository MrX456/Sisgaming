/*
 * Classe responsável por validar instância unica da aplicação
 */

package com.sisgaming.Tools;

import java.io.File;
import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;
import javax.swing.JOptionPane;

/**
 * SisGaming / Tools / Mutex
 * @author MrX
 */

public class Mutex {
    
    private static File file;
    private static FileChannel channel;
    private static FileLock lock;
    
     //File lock
    public static void setMutex(String messageError, String title) {
        
        String msg = messageError;
        String tit = title;
        
        try {
            
            file = new File(System.getProperty("user.home") + "\\Documents\\Sisgaming Docs\\lockdown");
            
            if(file.exists())
                file.delete();
            
            channel = new RandomAccessFile(file, "rw").getChannel();
            lock = channel.tryLock();
            
            //Aplicação em execução
            if(lock == null) {
                channel.close();
                JOptionPane.showMessageDialog(null, msg, 
                        tit,JOptionPane.ERROR_MESSAGE);
                throw new RuntimeException(msg);
            }
            
            //Encerrando Thread
            Thread shutdown = new Thread(new Runnable() {

                @Override
                public void run() {
                    release();
                }
            });
            
            Runtime.getRuntime().addShutdownHook(shutdown);
            
            
        } catch (Exception e) {
            throw new RuntimeException(msg);
        }
        
    }
    
    private static void release() {
        
        try {
            
            lock.release();
            channel.close();
            file.delete();
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
}

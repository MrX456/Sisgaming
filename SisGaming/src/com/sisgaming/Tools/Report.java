/*
 * Classe responsável pela geração do relatório
 */

package com.sisgaming.Tools;

import com.sisgaming.DAL.ConnectionFactory;
import java.sql.Connection;
import javax.swing.JOptionPane;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.view.JasperViewer;

/**
 * SisGaming / Tools / Report
 * @author MrX
 */

public class Report {
    
    private Connection conn = ConnectionFactory.requestConnection();
    
    public void gamesReport() {
        
        int confirm = JOptionPane.showConfirmDialog(null, "Deseja ver este relatório?",
                        "Ver relatório", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        
        if(confirm == 0) {
            
            try {
                
                
                final String reportPath = System.getProperty("user.home") + "\\Documents\\Sisgaming Docs\\reports template\\report_games.jasper";
                JasperPrint print = JasperFillManager.fillReport(reportPath, null, conn);
                
                // Report view
                JasperViewer.viewReport(print, false);
                
            } catch (Exception e) {
                
                e.printStackTrace();
                JOptionPane.showMessageDialog(null, "Impossivel imprimir relatório!!"
                       ,"Erro de relatório", JOptionPane.ERROR_MESSAGE);
            
            }
        }
    }
    
}

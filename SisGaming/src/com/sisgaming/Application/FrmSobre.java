/*
 *jFrame responsável pelas informações da aplicação
 */

package com.sisgaming.Application;

import com.sisgaming.Audio.Song;
import com.sisgaming.Tools.Misc;
import java.awt.Desktop;
import java.net.URL;

/**
 * SisGaming / Application / Sobre
 * @author MrX
 */

public class FrmSobre extends javax.swing.JDialog {

    /**
     * Creates new form FrmSobre
     */
    public FrmSobre(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        this.setIconImage(Misc.createIcon().getImage());
    }

    private void abrirRepositorio() {
        
        try {
            
            String url = "https://github.com/MrX456/Art-Factory.java/tree/master/03-Sisgaming";
            Desktop.getDesktop().browse(new URL(url).toURI());
            
        } catch (Exception e) {
            
            e.printStackTrace();
        }
        
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblTitle = new javax.swing.JLabel();
        lblLine1 = new javax.swing.JLabel();
        lblLine2 = new javax.swing.JLabel();
        lblLine3 = new javax.swing.JLabel();
        lblLine4 = new javax.swing.JLabel();
        lblDev = new javax.swing.JLabel();
        lblLic = new javax.swing.JLabel();
        lblLogo = new javax.swing.JLabel();
        lblFooter = new javax.swing.JLabel();
        lblWp = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Sobre o SisGaming");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        lblTitle.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lblTitle.setText("SisGaming 1.0.0");

        lblLine1.setText("O Sisgaming é uma simples aplicação que permite");

        lblLine2.setText("registrar sua coleção ou seus games favoritos.");

        lblLine3.setText("      O repositório pode ser econtrado em :");

        lblLine4.setForeground(new java.awt.Color(102, 0, 153));
        lblLine4.setText("   https://github.com/MrX456/Art-Factory.java/tree/master/03-Sisgaming");
        lblLine4.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblLine4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblLine4MouseClicked(evt);
            }
        });

        lblDev.setText("Desenvolvido por :  MRX");

        lblLic.setText("Sob licença  GPL ");

        lblLogo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/sisgaming/icons/GNU_Logo.png"))); // NOI18N

        lblFooter.setFont(new java.awt.Font("Dialog", 1, 10)); // NOI18N
        lblFooter.setText("Track Name: 8 Bit Menu by  FesliyanStudios Background Music");

        lblWp.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/sisgaming/icons/wp3.jpg"))); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(70, 70, 70)
                .addComponent(lblLine1))
            .addGroup(layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(lblLine2))
            .addGroup(layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(lblLine4))
            .addGroup(layout.createSequentialGroup()
                .addGap(190, 190, 190)
                .addComponent(lblLogo, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addComponent(lblFooter, javax.swing.GroupLayout.PREFERRED_SIZE, 320, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addComponent(lblLic))
            .addGroup(layout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addComponent(lblDev))
            .addGroup(layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addComponent(lblLine3, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(130, 130, 130)
                .addComponent(lblTitle))
            .addComponent(lblWp)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addComponent(lblLine1)
                .addGap(4, 4, 4)
                .addComponent(lblLine2)
                .addGap(24, 24, 24)
                .addComponent(lblLine4, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(90, 90, 90)
                .addComponent(lblLogo, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(280, 280, 280)
                .addComponent(lblFooter))
            .addGroup(layout.createSequentialGroup()
                .addGap(192, 192, 192)
                .addComponent(lblLic))
            .addGroup(layout.createSequentialGroup()
                .addGap(164, 164, 164)
                .addComponent(lblDev))
            .addGroup(layout.createSequentialGroup()
                .addGap(90, 90, 90)
                .addComponent(lblLine3))
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(lblTitle))
            .addComponent(lblWp)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void lblLine4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblLine4MouseClicked
        this.abrirRepositorio();
    }//GEN-LAST:event_lblLine4MouseClicked

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        Song s = new Song();
        s.playSong();
    }//GEN-LAST:event_formWindowOpened

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FrmSobre.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmSobre.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmSobre.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmSobre.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                FrmSobre dialog = new FrmSobre(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel lblDev;
    private javax.swing.JLabel lblFooter;
    private javax.swing.JLabel lblLic;
    private javax.swing.JLabel lblLine1;
    private javax.swing.JLabel lblLine2;
    private javax.swing.JLabel lblLine3;
    private javax.swing.JLabel lblLine4;
    private javax.swing.JLabel lblLogo;
    private javax.swing.JLabel lblTitle;
    private javax.swing.JLabel lblWp;
    // End of variables declaration//GEN-END:variables
}

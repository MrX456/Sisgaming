/*
 * JFrame responsável por novos cadastros
 */

package com.sisgaming.Application;

import com.sisgaming.Controller.Games;
import com.sisgaming.Controller.Validate;
import com.sisgaming.Tools.Game;
import com.sisgaming.Tools.Misc;
import java.awt.Color;
import javax.swing.ImageIcon;

/**
 * SisGaming / Application / Cadastrar
 * @author MrX
 */

public class FrmCadastro extends javax.swing.JInternalFrame {

    private String imgPath = null;
    /**
     * Creates new form FrmCadastro
     */
    public FrmCadastro() {
        initComponents();
        btnCadastrar.setBackground(new Color(64, 134, 245));
        btnCadastrar.setBorder(null);
    }

    private Game setGame(int id, String titulo, String plataforma, String img) {
        
        Game g = new Game(id, titulo, plataforma, img);
        return g;
        
    }
     
    private void setDefaultState() {
        
        txtNome.setText("");
        cboPlataforma.setSelectedIndex(0);
        lblScreenshot.setIcon(new ImageIcon(getClass().getResource("/com/sisgaming/icons/default-image.jpg")));
        
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblNome = new javax.swing.JLabel();
        txtNome = new javax.swing.JTextField();
        lblTitle = new javax.swing.JLabel();
        lblPlataforma = new javax.swing.JLabel();
        cboPlataforma = new javax.swing.JComboBox();
        btnCadastrar = new javax.swing.JButton();
        lblScreenshot = new javax.swing.JLabel();
        btnAbrir = new javax.swing.JButton();
        lblFundo = new javax.swing.JLabel();

        setClosable(true);
        setIconifiable(true);
        setResizable(true);
        setTitle("Cadastrar Game");
        getContentPane().setLayout(null);

        lblNome.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblNome.setForeground(new java.awt.Color(255, 255, 255));
        lblNome.setText("Titulo do game:");
        getContentPane().add(lblNome);
        lblNome.setBounds(60, 180, 130, 17);

        txtNome.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtNome.setToolTipText("Título do game");
        getContentPane().add(txtNome);
        txtNome.setBounds(60, 200, 270, 30);

        lblTitle.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblTitle.setForeground(new java.awt.Color(255, 255, 255));
        lblTitle.setText("Screenshot :");
        getContentPane().add(lblTitle);
        lblTitle.setBounds(110, 20, 100, 17);

        lblPlataforma.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblPlataforma.setForeground(new java.awt.Color(255, 255, 255));
        lblPlataforma.setText("Plataforma :");
        getContentPane().add(lblPlataforma);
        lblPlataforma.setBounds(60, 250, 130, 17);

        cboPlataforma.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        cboPlataforma.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "PC", "Playstation 4", "Playstation 3", "Playstation 2", "Playstation", "Playstarion Vita", "Playstation Portable", "Xbox One", "Xbox 360", "Xbox", "Switch", "Wii U", "Wii", "Gamecube", "Nintendo 64", "SNES", "NES", "3DS", "DS", "Gameboy Advance", "Gameboy Color", "Gameboy", "Dreamcast", "Saturn", "Mega Drive", "Master System", "Game Gear", "Atari Jaguar", "Atari 7800", "Atari 5200", "Atari 2600", "Atari Lynx", "Neo Geo CD", "Neo Geo", "Neo Geo Pocket", "Gizmondo", "Wonderswan" }));
        cboPlataforma.setToolTipText("Selecione a plataforma");
        cboPlataforma.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        getContentPane().add(cboPlataforma);
        cboPlataforma.setBounds(60, 270, 240, 30);

        btnCadastrar.setBackground(new java.awt.Color(255, 255, 255));
        btnCadastrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/sisgaming/icons/add.png"))); // NOI18N
        btnCadastrar.setToolTipText("Cadastrar game");
        btnCadastrar.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        btnCadastrar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnCadastrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCadastrarActionPerformed(evt);
            }
        });
        getContentPane().add(btnCadastrar);
        btnCadastrar.setBounds(340, 100, 60, 70);

        lblScreenshot.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/sisgaming/icons/default-image.jpg"))); // NOI18N
        getContentPane().add(lblScreenshot);
        lblScreenshot.setBounds(110, 40, 210, 130);

        btnAbrir.setText("abrir");
        btnAbrir.setToolTipText("Selecione uma screenshot");
        btnAbrir.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnAbrir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAbrirActionPerformed(evt);
            }
        });
        getContentPane().add(btnAbrir);
        btnAbrir.setBounds(330, 50, 73, 32);

        lblFundo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/sisgaming/icons/wallpaper1.jpg"))); // NOI18N
        getContentPane().add(lblFundo);
        lblFundo.setBounds(0, -10, 534, 440);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAbrirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAbrirActionPerformed
        imgPath = Misc.chooseImage(imgPath);
        lblScreenshot.setIcon(Misc.resizeSelectedImage(imgPath));
    }//GEN-LAST:event_btnAbrirActionPerformed

    private void btnCadastrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCadastrarActionPerformed
        if(Validate.validarGame(txtNome.getText())){
            Game g = this.setGame(0, txtNome.getText(), cboPlataforma.getSelectedItem().toString(), imgPath);
            Games gs = new Games();
            gs.cadastrar(g);
            
            this.setDefaultState();
        }
    }//GEN-LAST:event_btnCadastrarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAbrir;
    private javax.swing.JButton btnCadastrar;
    private javax.swing.JComboBox cboPlataforma;
    private javax.swing.JLabel lblFundo;
    private javax.swing.JLabel lblNome;
    private javax.swing.JLabel lblPlataforma;
    public static javax.swing.JLabel lblScreenshot;
    private javax.swing.JLabel lblTitle;
    private javax.swing.JTextField txtNome;
    // End of variables declaration//GEN-END:variables
}

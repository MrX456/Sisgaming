/*
 *jFrame responsável por atualizar e deletar dados
 */

package com.sisgaming.Application;

import com.sisgaming.Controller.Games;
import com.sisgaming.Controller.Validate;
import com.sisgaming.Tools.Game;
import com.sisgaming.Tools.Misc;
import javax.swing.ImageIcon;
import javax.swing.table.DefaultTableModel;
import net.proteanit.sql.DbUtils;

/**
 * SisGaming / Application / Update
 * @author MrX
 */

public class FrmUpdate extends javax.swing.JInternalFrame {

    private String imgPath = System.getProperty("user.home") + "\\Documents\\Sisgaming Docs\\img\\img.jpg";
    
    /**
     * Creates new form FrmUpdate
     */
    public FrmUpdate() {
        initComponents();
        cboPlataforma.requestFocus();
    }

    private void setCampos() {
        
        int puts = dgvGames.getSelectedRow();
        
        txtId.setText(dgvGames.getModel().getValueAt(puts, 0).toString());
        txtNome.setText(dgvGames.getModel().getValueAt(puts, 1).toString());
        cboPlataforma.setSelectedItem(dgvGames.getModel().getValueAt(puts, 2));
        
        // Retornar foto se cadastrado
        Games gs = new Games();
        gs.buscarFoto(txtId.getText());
        
        btnAtualizar.setEnabled(true);
        btnDeletar.setEnabled(true);
    }
    
    private Game setGame(int id, String titulo, String plataforma, String img) {
        
        Game g = new Game(id, titulo, plataforma, img);
        return g;
        
    }
    
    private void setDefaultState() {
        
        ((DefaultTableModel)dgvGames.getModel()).setRowCount(0);
        txtPesq.setText("");
        txtId.setText("");
        txtNome.setText("");
        cboPlataforma.setSelectedIndex(0);
        lblScreenshot.setIcon(new ImageIcon(getClass().getResource("/com/sisgaming/icons/default-image.jpg")));
        
        btnAtualizar.setEnabled(false);
        btnDeletar.setEnabled(false);
        
    }
      
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblPesq = new javax.swing.JLabel();
        txtPesq = new javax.swing.JTextField();
        lblSr = new javax.swing.JLabel();
        lblPlataforma = new javax.swing.JLabel();
        cboPlataforma = new javax.swing.JComboBox();
        lblScreenshot = new javax.swing.JLabel();
        btnAbrir = new javax.swing.JButton();
        btnRemover = new javax.swing.JButton();
        btnAtualizar = new javax.swing.JButton();
        btnDeletar = new javax.swing.JButton();
        txtNome = new javax.swing.JTextField();
        lblNome = new javax.swing.JLabel();
        lblID = new javax.swing.JLabel();
        txtId = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        dgvGames = new javax.swing.JTable();
        lblWallpaper = new javax.swing.JLabel();

        setClosable(true);
        setIconifiable(true);
        setResizable(true);
        setTitle("Pesquisar Game");
        getContentPane().setLayout(null);

        lblPesq.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblPesq.setForeground(new java.awt.Color(255, 255, 255));
        lblPesq.setText("Titulo :");
        getContentPane().add(lblPesq);
        lblPesq.setBounds(100, 30, 50, 15);

        txtPesq.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txtPesq.setToolTipText("Digite um titulo para pesquisar");
        txtPesq.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtPesqKeyReleased(evt);
            }
        });
        getContentPane().add(txtPesq);
        txtPesq.setBounds(150, 23, 270, 30);

        lblSr.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/sisgaming/icons/search.png"))); // NOI18N
        getContentPane().add(lblSr);
        lblSr.setBounds(420, 30, 20, 16);

        lblPlataforma.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblPlataforma.setForeground(new java.awt.Color(0, 0, 204));
        lblPlataforma.setText("Plataforma :");
        getContentPane().add(lblPlataforma);
        lblPlataforma.setBounds(30, 230, 130, 17);

        cboPlataforma.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        cboPlataforma.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "PC", "Playstation 4", "Playstation 3", "Playstation 2", "Playstation", "Playstarion Vita", "Playstation Portable", "Xbox One", "Xbox 360", "Xbox", "Switch", "Wii U", "Wii", "Gamecube", "Nintendo 64", "SNES", "NES", "3DS", "DS", "Gameboy Advance", "Gameboy Color", "Gameboy", "Dreamcast", "Saturn", "Mega Drive", "Master System", "Game Gear", "Atari Jaguar", "Atari 7800", "Atari 5200", "Atari 2600", "Atari Lynx", "Neo Geo CD", "Neo Geo", "Neo Geo Pocket", "Gizmondo", "Wonderswan" }));
        cboPlataforma.setToolTipText("Selecione a plataforma");
        cboPlataforma.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        cboPlataforma.setFocusable(false);
        getContentPane().add(cboPlataforma);
        cboPlataforma.setBounds(30, 250, 240, 30);

        lblScreenshot.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/sisgaming/icons/default-image.jpg"))); // NOI18N
        getContentPane().add(lblScreenshot);
        lblScreenshot.setBounds(320, 210, 210, 130);

        btnAbrir.setText("atualizar");
        btnAbrir.setToolTipText("Atualizar screenshot");
        btnAbrir.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnAbrir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAbrirActionPerformed(evt);
            }
        });
        getContentPane().add(btnAbrir);
        btnAbrir.setBounds(330, 350, 80, 32);

        btnRemover.setText("remover");
        btnRemover.setToolTipText("Remover screenshot da base de dados");
        btnRemover.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnRemover.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRemoverActionPerformed(evt);
            }
        });
        getContentPane().add(btnRemover);
        btnRemover.setBounds(430, 350, 80, 32);

        btnAtualizar.setBackground(new java.awt.Color(255, 255, 255));
        btnAtualizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/sisgaming/icons/64x64.png"))); // NOI18N
        btnAtualizar.setToolTipText("Atualizar game");
        btnAtualizar.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        btnAtualizar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnAtualizar.setEnabled(false);
        btnAtualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAtualizarActionPerformed(evt);
            }
        });
        getContentPane().add(btnAtualizar);
        btnAtualizar.setBounds(30, 310, 70, 70);

        btnDeletar.setBackground(new java.awt.Color(255, 255, 255));
        btnDeletar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/sisgaming/icons/93550_237013_delete.png"))); // NOI18N
        btnDeletar.setToolTipText("Deletar game");
        btnDeletar.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        btnDeletar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnDeletar.setEnabled(false);
        btnDeletar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeletarActionPerformed(evt);
            }
        });
        getContentPane().add(btnDeletar);
        btnDeletar.setBounds(120, 310, 70, 70);

        txtNome.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtNome.setToolTipText("Título do game");
        getContentPane().add(txtNome);
        txtNome.setBounds(30, 200, 270, 30);

        lblNome.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblNome.setForeground(new java.awt.Color(0, 0, 204));
        lblNome.setText("Titulo do game:");
        getContentPane().add(lblNome);
        lblNome.setBounds(30, 180, 130, 17);

        lblID.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblID.setForeground(new java.awt.Color(0, 0, 204));
        lblID.setText("ID:");
        getContentPane().add(lblID);
        lblID.setBounds(370, 150, 22, 17);

        txtId.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtId.setToolTipText("");
        txtId.setEnabled(false);
        getContentPane().add(txtId);
        txtId.setBounds(370, 170, 100, 30);

        dgvGames.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "id", "titulo", "plataforma"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        dgvGames.setToolTipText("Clique em uma linha para selecionar");
        dgvGames.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                dgvGamesMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(dgvGames);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(40, 70, 453, 80);

        lblWallpaper.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/sisgaming/icons/wp2276152.jpg"))); // NOI18N
        getContentPane().add(lblWallpaper);
        lblWallpaper.setBounds(0, 0, 548, 413);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnRemoverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRemoverActionPerformed
        imgPath = null;
        lblScreenshot.setIcon(new ImageIcon(getClass().getResource("/com/sisgaming/icons/default-image.jpg")));
    }//GEN-LAST:event_btnRemoverActionPerformed

    private void btnAtualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAtualizarActionPerformed
        if(Validate.validarGame(txtNome.getText())){
            Game g = this.setGame(Integer.parseInt(txtId.getText()), txtNome.getText(), cboPlataforma.getSelectedItem().toString(), imgPath);
            Games gs = new Games();
            gs.atualizar(g);

            this.setDefaultState();
        }
    }//GEN-LAST:event_btnAtualizarActionPerformed

    private void btnDeletarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeletarActionPerformed
        Games gs = new Games();
        gs.deletar(txtId.getText());
        this.setDefaultState();
    }//GEN-LAST:event_btnDeletarActionPerformed

    private void dgvGamesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_dgvGamesMouseClicked
        this.setCampos();
    }//GEN-LAST:event_dgvGamesMouseClicked

    private void btnAbrirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAbrirActionPerformed
        imgPath = Misc.chooseImage(imgPath);
        lblScreenshot.setIcon(Misc.resizeSelectedImage(imgPath));
    }//GEN-LAST:event_btnAbrirActionPerformed

    private void txtPesqKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPesqKeyReleased
        Games gs = new Games();
        dgvGames.setModel(DbUtils.resultSetToTableModel(gs.pesquisar(txtPesq.getText())));
        dgvGames.getColumnModel().getColumn(0).setPreferredWidth(2);
        dgvGames.getTableHeader().repaint();
    }//GEN-LAST:event_txtPesqKeyReleased


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAbrir;
    private javax.swing.JButton btnAtualizar;
    private javax.swing.JButton btnDeletar;
    private javax.swing.JButton btnRemover;
    private javax.swing.JComboBox cboPlataforma;
    private javax.swing.JTable dgvGames;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblID;
    private javax.swing.JLabel lblNome;
    private javax.swing.JLabel lblPesq;
    private javax.swing.JLabel lblPlataforma;
    public static javax.swing.JLabel lblScreenshot;
    private javax.swing.JLabel lblSr;
    private javax.swing.JLabel lblWallpaper;
    private javax.swing.JTextField txtId;
    private javax.swing.JTextField txtNome;
    private javax.swing.JTextField txtPesq;
    // End of variables declaration//GEN-END:variables
}

/*
 * Classe reponsável pela implementação dos métodos CRUD da tabela games
 */

package com.sisgaming.Controller;

import com.sisgaming.Application.FrmUpdate;
import com.sisgaming.DAL.ConnectionFactory;
import com.sisgaming.Tools.Game;
import com.sisgaming.Tools.Misc;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 * SisGaming / Controller / Games
 * @author MrX
 */

public class Games implements IGames {

    private Connection conexao = null;
    private PreparedStatement pst = null;
    private ResultSet rs = null;

    @Override
    public void cadastrar(Game g) {

        conexao = ConnectionFactory.requestConnection();

        String sql = SqlCommand.getCadastrarGame();

        try {

            pst = conexao.prepareStatement(sql);
            //Inserindo o valor de cada txtbox no banco de dados
            pst.setString(1, g.getTitulo());
            pst.setString(2, g.getPlataforma());

            if (g.getScreenshotPath() == null) {
                pst.setNull(3, java.sql.Types.BLOB);
            } else {
                pst.setBytes(3, Misc.lerArquivo(g.getScreenshotPath()));
            }

            int adicionado = pst.executeUpdate();

            //Se usuario pode ser adicionado
            if (adicionado > 0) {

                JOptionPane.showMessageDialog(null, "Game cadastrado com sucesso! ",
                        "Cadastro confirmado", JOptionPane.INFORMATION_MESSAGE);

            }

        } catch (Exception e) {
            
            e.printStackTrace();
             JOptionPane.showMessageDialog(null, "Não foi possivel cadastrar game!"
                                    ,"Erro de conexão", JOptionPane.ERROR_MESSAGE);
             
        } finally {
            try {
                conexao.close();
            } catch (SQLException ex) {
            }
        }
    }

    @Override
    public ResultSet pesquisar(String gameLike) {

        conexao = ConnectionFactory.requestConnection();

        String sql = "SELECT id, nome_game, plataforma_game FROM tbl_games WHERE nome_game LIKE '" + gameLike + "%'";
        try {
            pst = conexao.prepareStatement(sql);
            rs = pst.executeQuery();

            return rs;
        } catch (Exception e) {
            
            e.printStackTrace(); 
            JOptionPane.showMessageDialog(null, "Não foi possivel pesquisar game!!"
                                    ,"Erro de conexão", JOptionPane.ERROR_MESSAGE);
            return null;
            
        }

    }

    @Override
    public void buscarFoto(String gameID) {

        conexao = ConnectionFactory.requestConnection();
        FileOutputStream fos = null;

        String sql = "SELECT screenshot FROM tbl_games WHERE id = " + gameID;

        try {

            pst = conexao.prepareStatement(sql);
            rs = pst.executeQuery();

            if (rs.getString(1) == null) {

                FrmUpdate.lblScreenshot.setIcon(new ImageIcon(getClass().getResource("/com/sisgaming/icons/default-image.jpg")));

            } else {

                String filePath = System.getProperty("user.home") + "\\Documents\\Sisgaming Docs\\img\\img.jpg";
                File file = new File(filePath);
                fos = new FileOutputStream(file);

                while (rs.next()) {
                    InputStream input = rs.getBinaryStream("screenshot");//Column name
                    byte[] buffer = new byte[1024];
                    while (input.read(buffer) > 0) {
                        fos.write(buffer);
                    }
                }

                FrmUpdate.lblScreenshot.setIcon(Misc.resizeSelectedImage(filePath));

            }

        } catch (Exception e) {
            
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Não foi possivel carregar screenshot do game!"
                                    ,"Erro de conexão", JOptionPane.ERROR_MESSAGE);
            
        } finally {
            try {
                conexao.close();
            } catch (SQLException ex) {
            }
        }
    }

    @Override
    public void atualizar(Game g) {

        conexao = ConnectionFactory.requestConnection();

        String sql = SqlCommand.getAtualizarGame();

        try {

            pst = conexao.prepareStatement(sql);
            //Inserindo o valor de cada txtbox no banco de dados
            pst.setString(1, g.getTitulo());
            pst.setString(2, g.getPlataforma());

            if (g.getScreenshotPath() == null) {
                pst.setNull(3, java.sql.Types.BLOB);
            } else {
                pst.setBytes(3, Misc.lerArquivo(g.getScreenshotPath()));
            }

            pst.setInt(4, g.getId());

            int adicionado = pst.executeUpdate();

            if (adicionado > 0) {

                JOptionPane.showMessageDialog(null, "Game atualizado com sucesso! ",
                        "Atualização confirmada", JOptionPane.INFORMATION_MESSAGE);

            }

        } catch (Exception e) {
            
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Não foi possivel atualizar game!"
                                    ,"Erro de conexão", JOptionPane.ERROR_MESSAGE);
            
        } finally {
            try {
                conexao.close();
            } catch (SQLException ex) {
            }
        }
    }

    @Override
    public void deletar(String gameID) {

        //Precisamos confrmar a remoção do usuário
        int confirma = JOptionPane.showConfirmDialog(null, "Deseja remover este game?",
                "Remover game", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
        //Se for confirmada
        if (confirma == 0) {
            conexao = ConnectionFactory.requestConnection();

            String sql = SqlCommand.getDeletarGame();

            try {
                pst = conexao.prepareStatement(sql);
                pst.setString(1, gameID);

                pst.executeUpdate();

                JOptionPane.showMessageDialog(null, "Game removido com sucesso!",
                        "Remoção concluida", JOptionPane.WARNING_MESSAGE);

            } catch (Exception e) {
                
                e.printStackTrace();
                JOptionPane.showMessageDialog(null, "Não foi possivel remover game!",
                        "Erro na remoção", JOptionPane.ERROR_MESSAGE);
                
            }finally {
                try {
                    conexao.close();
                } catch (SQLException ex) {
                }
            }
        }
    }

}

/*
 * Interface reponsável pela declaração dos métodos da tabela games
 */

package com.sisgaming.Controller;

import com.sisgaming.Tools.Game;
import java.sql.ResultSet;

/**
 * SisGaming / Controller / IGames
 * @author MrX
 */

public interface IGames {
    
    public abstract void cadastrar(Game g);
    
    public abstract ResultSet pesquisar(String gameLike);
    
    public abstract void buscarFoto(String gameID);
    
    public abstract void atualizar(Game g);
    
    public abstract void deletar(String gameID);
    
}

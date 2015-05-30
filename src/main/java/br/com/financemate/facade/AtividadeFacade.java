/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.financemate.facade;

import br.com.financemate.dao.AtividadesDao;
import br.com.financemate.model.Atividades;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Kamila
 */
public class AtividadeFacade {
    
    AtividadesDao atividadesDao;
    
    public Atividades salvar(Atividades atividades) throws SQLException{
        atividadesDao = new AtividadesDao();
        return atividadesDao.salvar(atividades);
    }
    
    public Atividades consultar(int idAtividades) throws SQLException{
        atividadesDao = new AtividadesDao();
        return atividadesDao.consultar(idAtividades);
    }
    
    public List<Atividades> listar(String sql) throws SQLException{
        atividadesDao = new AtividadesDao();
        return atividadesDao.listar(sql);
    }
    
}

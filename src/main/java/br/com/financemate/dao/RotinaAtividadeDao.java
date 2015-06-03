/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.financemate.dao;

import br.com.financemate.connection.ConectionFactory;
import br.com.financemate.model.Atividades;
import br.com.financemate.model.Rotinaatividade;
import java.sql.SQLException;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 *
 * @author Wolverine
 */
public class RotinaAtividadeDao {
    
    
    public Rotinaatividade salvar(Rotinaatividade rotinaatividade) throws SQLException{
        EntityManager manager = ConectionFactory.getConnection();
        manager.getTransaction().begin();
        rotinaatividade = manager.merge(rotinaatividade);
        manager.getTransaction().commit();
        return rotinaatividade;
    }
    
    public List<Rotinaatividade> listar(String sql)throws SQLException{
        EntityManager manager = ConectionFactory.getConnection();
        manager.getTransaction().begin();
        Query q = manager.createQuery(sql);
        List<Rotinaatividade> lista = q.getResultList();
        manager.getTransaction().commit();
        return lista;
    }
    
    public void excluir(Rotinaatividade rotinaatividade) throws SQLException{
        EntityManager manager = ConectionFactory.getConnection();
        manager.getTransaction().begin();
        rotinaatividade = manager.find(Rotinaatividade.class, rotinaatividade.getIdrotinaatividade());
        manager.remove(rotinaatividade);
        manager.getTransaction().commit();
    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.financemate.dao;

import br.com.financemate.connection.ConectionFactory;
import br.com.financemate.model.Membros;
import br.com.financemate.model.Raci;
import java.sql.SQLException;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 *
 * @author Julio
 */
public class RaciDao {
    
    public Raci salvar(Raci raci) throws SQLException{
        EntityManager manager = ConectionFactory.getConnection();
        //abrindo uma transação
        manager.getTransaction().begin();
        raci = manager.merge(raci);
        //fechando uma transação
        manager.getTransaction().commit();
        return raci;
    }
    
    public List<Raci> listar(String sql) throws SQLException{
        EntityManager manager = ConectionFactory.getConnection();
        manager.getTransaction().begin();
        Query q = manager.createQuery(sql);
        List<Raci> lista = q.getResultList();
        manager.getTransaction().commit();
        return lista;
    }
    
    public void excluir(int idRaci) throws SQLException {
        EntityManager manager = ConectionFactory.getConnection();
        manager.getTransaction().begin();
        Query q = manager.createQuery("Select r from Raci r where r.idraci=" + idRaci);
        if (q.getResultList().size()>0){
            Raci raci = (Raci) q.getResultList().get(0);
            manager.remove(raci);
        }
        manager.getTransaction().commit();
    }
}

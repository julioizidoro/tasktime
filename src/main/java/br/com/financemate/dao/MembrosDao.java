/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.financemate.dao;

import br.com.financemate.connection.ConectionFactory;
import br.com.financemate.model.Membros;
import java.sql.SQLException;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 *
 * @author Julio
 */
public class MembrosDao {
    
     public Membros salvar(Membros membros) throws SQLException{
        EntityManager manager = ConectionFactory.getConnection();
        //abrindo uma transação
        manager.getTransaction().begin();
        membros = manager.merge(membros);
        //fechando uma transação
        manager.getTransaction().commit();
        return membros;
    }
    
    
    public List<Membros> listar(String nome) throws SQLException{
        EntityManager manager = ConectionFactory.getConnection();
        manager.getTransaction().begin();
        Query q = manager.createQuery("select c from Membros c where c.nomefantasia like '%" +nome+ "%' order by c.nomefantasia");
        List<Membros> lista = q.getResultList();
        manager.getTransaction().commit();
        return lista;
    }
}

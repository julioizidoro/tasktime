package br.com.financemate.dao;

import br.com.financemate.connection.ConectionFactory;
import br.com.financemate.model.Membros;
import java.sql.SQLException;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;


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
    
    
    public List<Membros> listar(String sql) throws SQLException{
        EntityManager manager = ConectionFactory.getConnection();
        manager.getTransaction().begin();
        Query q = manager.createQuery(sql);
        List<Membros> lista = q.getResultList();
        manager.getTransaction().commit();
        return lista;
    }
    
    public void excluir(int idUsuario) throws SQLException {
        EntityManager manager = ConectionFactory.getConnection();
        manager.getTransaction().begin();
        Query q = manager.createQuery("Select m from Membros m where m.usuario.idusuario=" + idUsuario);
        if (q.getResultList().size()>0){
            Membros membros = (Membros) q.getResultList().get(0);
            manager.remove(membros);
        }
        manager.getTransaction().commit();
    }
}

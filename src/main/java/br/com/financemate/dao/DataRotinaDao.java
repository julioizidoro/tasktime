package br.com.financemate.dao;

import br.com.financemate.connection.ConectionFactory;
import br.com.financemate.model.Datarotina;
import java.sql.SQLException;
import javax.persistence.EntityManager;

public class DataRotinaDao {
    
    
    public Datarotina salvar(Datarotina datarotina) throws SQLException{
        EntityManager manager = ConectionFactory.getConnection();
        manager.getTransaction().begin();
        datarotina = manager.merge(datarotina);
        manager.getTransaction().commit();
        return datarotina;
    }
    
    
}

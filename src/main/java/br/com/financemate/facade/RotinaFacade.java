package br.com.financemate.facade;

import br.com.financemate.dao.RotinaDao;
import br.com.financemate.model.Rotina;
import java.sql.SQLException;
import java.util.List;
/**
 *
 * @author Kamila
 */
public class RotinaFacade {
    
    RotinaDao rotinaDao;
    
    public Rotina salvar(Rotina rotina) throws SQLException{
        rotinaDao = new RotinaDao();
        return rotinaDao.salvar(rotina);
    }
    
    public Rotina consultar(int idRotina) throws SQLException{
        rotinaDao = new RotinaDao();
        return rotinaDao.consultar(idRotina);
    }
    
    public List<Rotina> listar(String nome) throws SQLException{
        rotinaDao = new RotinaDao();
        return rotinaDao.listar(nome);
    }
}

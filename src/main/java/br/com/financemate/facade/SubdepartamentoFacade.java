package br.com.financemate.facade;

import br.com.financemate.dao.SubdepartamentoDao;
import br.com.financemate.model.Subdepartamento;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Kamila
 */
public class SubdepartamentoFacade {
    SubdepartamentoDao subdepartamentoDao;
    
    public Subdepartamento salvar(Subdepartamento subdepartamento) throws SQLException{
        subdepartamentoDao = new SubdepartamentoDao();
        return subdepartamentoDao.salvar(subdepartamento);
    }
    
    public Subdepartamento consultar(int idSubdepartamento) throws SQLException{
        subdepartamentoDao = new SubdepartamentoDao();
        return subdepartamentoDao.consultar(idSubdepartamento);
    }
    
    public List<Subdepartamento> listar(String nome) throws SQLException{
        subdepartamentoDao = new SubdepartamentoDao();
        return subdepartamentoDao.listar(nome);
    }
}

package br.com.financemate.facade;

import br.com.financemate.dao.DepartamentoDao;
import br.com.financemate.model.Departamento;
import java.sql.SQLException;
import java.util.List;
/**
 *
 * @author Kamila
 */
public class DepartamentoFacade {
    
    DepartamentoDao departamentoDao;
    
    public Departamento salvar(Departamento departamento) throws SQLException{
        departamentoDao = new DepartamentoDao();
        return departamentoDao.salvar(departamento);
    }
    
    public Departamento consultar(int idDepartamento) throws SQLException{
        departamentoDao = new DepartamentoDao();
        return departamentoDao.consultar(idDepartamento);
    }
    
    public List<Departamento> listar(String nome) throws SQLException{
        departamentoDao = new DepartamentoDao();
        return departamentoDao.listar(nome);
    }
}

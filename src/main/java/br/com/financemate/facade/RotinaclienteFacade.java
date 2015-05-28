package br.com.financemate.facade;

import br.com.financemate.dao.RotinaclienteDao;
import br.com.financemate.model.Rotinacliente;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Kamila
 */
public class RotinaclienteFacade {
    
    RotinaclienteDao rotinaclienteDao;
    
     public Rotinacliente salvar(Rotinacliente rotinacliente) throws SQLException{
        rotinaclienteDao = new RotinaclienteDao();
        return rotinaclienteDao.salvar(rotinacliente);
    }
     
     public Rotinacliente consultar(int idRotinacliente) throws SQLException{
        rotinaclienteDao = new RotinaclienteDao();
        return rotinaclienteDao.consultar(idRotinacliente);
    }
    
    public List<Rotinacliente> listar(String nomeCliente) throws SQLException{
        rotinaclienteDao = new RotinaclienteDao();
        return rotinaclienteDao.listar(nomeCliente);
    }
}

package br.com.financemate.facade;

import br.com.financemate.dao.ClienteDao;
import br.com.financemate.model.Cliente;
import java.sql.SQLException;
import java.util.List;


public class ClienteFacade {
    
    ClienteDao clienteDao;
    
    public Cliente salvar(Cliente cliente) throws SQLException{
        clienteDao = new ClienteDao();
        return clienteDao.salvar(cliente);
    }
    
    public Cliente consultar(int idCliente) throws SQLException{
        clienteDao = new ClienteDao();
        return clienteDao.consultar(idCliente);
    }
    
    public List<Cliente> listar(String nome) throws SQLException{
        clienteDao = new ClienteDao();
        return clienteDao.listar(nome);
    }
}

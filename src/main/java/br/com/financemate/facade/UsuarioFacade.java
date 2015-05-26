package br.com.financemate.facade;

import br.com.financemate.dao.UsuarioDao;
import br.com.financemate.model.Usuario;
import java.sql.SQLException;
import java.util.List;


public class UsuarioFacade {
    
    UsuarioDao usuarioDao;
    
    public Usuario salvar(Usuario usuario) throws SQLException{
        usuarioDao = new UsuarioDao();
        return usuarioDao.salvar(usuario);
    }
    
    public Usuario consultar(String login, String senha) throws SQLException{
        usuarioDao = new UsuarioDao();
        return usuarioDao.consultar(login, senha);
    }
    
    public List<Usuario> listar(String nome) throws SQLException{
        usuarioDao = new UsuarioDao();
        return usuarioDao.listar(nome);
    }
    
    public Usuario consultar(int idUsuario) throws SQLException{
        usuarioDao = new UsuarioDao();
        return usuarioDao.consultar(idUsuario);
    }
    
}

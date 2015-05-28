package br.com.financemate.facade;

import br.com.financemate.dao.PerfilDao;
import br.com.financemate.model.Perfil;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Kamila
 */
public class PerfilFacade {
    
    PerfilDao perfilDao;
    
    public Perfil salvar(Perfil perfil) throws SQLException{
        perfilDao = new PerfilDao();
        return perfilDao.salvar(perfil);
    }
    
    public Perfil consultar(int idPerfil) throws SQLException{
        perfilDao = new PerfilDao();
        return perfilDao.consultar(idPerfil);
    }
    
    public List<Perfil> listar(String nomeTipoacesso) throws SQLException{
        perfilDao = new PerfilDao();
        return perfilDao.listar(nomeTipoacesso);
    }
}

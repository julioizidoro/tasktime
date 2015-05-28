package br.com.financemante.controller;


import br.com.financemate.facade.PerfilFacade;
import br.com.financemate.model.Perfil;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Kamila
 */
public class PerfilController {
    
    PerfilFacade perfilFacade;
    
    public Perfil salvar(Perfil perfil) {
        perfilFacade = new PerfilFacade();
        try {
            return perfilFacade.salvar(perfil);
        } catch (SQLException ex) {
            Logger.getLogger(PerfilController.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Erro Salvar Perfil "+ ex);
            return null;
        }
    }
    
    public Perfil consultar(int idPerfil) {
        perfilFacade = new PerfilFacade();
        try {
            return perfilFacade.consultar(idPerfil);
       } catch (SQLException ex) {
            Logger.getLogger(PerfilController.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Erro Consultar Perfil "+ ex);
            return null;
        }
    }
    
    public List<Perfil> listar(String nomeTipoacesso) {
        perfilFacade = new PerfilFacade();
        try {
            return perfilFacade.listar(nomeTipoacesso);
       } catch (SQLException ex) {
            Logger.getLogger(PerfilController.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Erro Listar Departamento "+ ex);
            return null;
        }
    }
}

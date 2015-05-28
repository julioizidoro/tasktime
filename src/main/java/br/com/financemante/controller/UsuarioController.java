package br.com.financemante.controller;

import br.com.financemate.facade.UsuarioFacade;
import br.com.financemate.model.Usuario;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;



public class UsuarioController {
    
    UsuarioFacade usuarioFacade;
    
    public Usuario salvar(Usuario usuario) {
        usuarioFacade = new UsuarioFacade();
        try {
            return usuarioFacade.salvar(usuario);
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioController.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Erro Salvar Usuário " + ex);
            return null;
        }
    }
    
    public Usuario consultar(String login, String senha) {
        usuarioFacade = new UsuarioFacade();
        try {
            return usuarioFacade.consultar(login, senha);
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioController.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Erro Consultar Usuário " + ex);
            return null;
        }
    }
    
    public List<Usuario> listar(String nomeUsuario) {
        usuarioFacade = new UsuarioFacade();
        try {
            return usuarioFacade.listar(nomeUsuario);
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioController.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Erro Listar Usuário " + ex);
            return null;
        }
    }
    
    public Usuario consultar(int idUsuario) {
        usuarioFacade = new UsuarioFacade();
        try {
            return usuarioFacade.consultar(idUsuario);
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioController.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Erro Consultar Usuário " + ex);
            return null;
        }
    }
    
}

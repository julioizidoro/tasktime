package br.com.financemante.controller;

import br.com.financemate.facade.AtividadeFacade;
import br.com.financemate.model.Atividades;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Kamila
 */
public class AtividadesController {
    
    AtividadeFacade atividadeFacade;
    
    public Atividades salvar(Atividades atividades) {
        atividadeFacade = new AtividadeFacade();
        try {
            return atividadeFacade.salvar(atividades);
        } catch (SQLException ex) {
            Logger.getLogger(AtividadesController.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Erro Salvar Atividades "+ ex);
            return null;
        }
    }
    
    public Atividades consultar(int idAtividades) {
        atividadeFacade = new AtividadeFacade();
        try {
            return atividadeFacade.consultar(idAtividades);
       } catch (SQLException ex) {
            Logger.getLogger(AtividadesController.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Erro Consultar Atividades "+ ex);
            return null;
        }
    }
    
    public List<Atividades> listar(String nome) {
        atividadeFacade = new AtividadeFacade();
        try {
            return atividadeFacade.listar(nome);
       } catch (SQLException ex) {
            Logger.getLogger(AtividadesController.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Erro Listar Atividades "+ ex);
            return null;
        }
    }
    
}

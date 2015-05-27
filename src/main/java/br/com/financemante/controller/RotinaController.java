package br.com.financemante.controller;

import br.com.financemate.facade.RotinaFacade;
import br.com.financemate.model.Rotina;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
/**
 *
 * @author Kamila
 */
public class RotinaController {
    
    RotinaFacade rotinaFacade;
    
    public Rotina salvar(Rotina rotina) {
        rotinaFacade = new RotinaFacade();
        try {
            return rotinaFacade.salvar(rotina);
        } catch (SQLException ex) {
            Logger.getLogger(RotinaController.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Erro Salvar Rotina "+ ex);
            return null;
        }
    }
    
    public Rotina consultar(int idRotina) {
        rotinaFacade = new RotinaFacade();
        try {
            return rotinaFacade.consultar(idRotina);
       } catch (SQLException ex) {
            Logger.getLogger(RotinaController.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Erro Consultar Rotina "+ ex);
            return null;
        }
    }
    
    public List<Rotina> listar(String nome) {
        rotinaFacade = new RotinaFacade();
        try {
            return rotinaFacade.listar(nome);
       } catch (SQLException ex) {
            Logger.getLogger(RotinaController.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Erro Listar Rotina "+ ex);
            return null;
        }
    }
    
}

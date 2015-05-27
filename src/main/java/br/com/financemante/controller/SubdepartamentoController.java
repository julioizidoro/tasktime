package br.com.financemante.controller;

import br.com.financemate.facade.SubdepartamentoFacade;
import br.com.financemate.model.Subdepartamento;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Kamila
 */
public class SubdepartamentoController {
    SubdepartamentoFacade subdepartamentoFacade;
    
    public Subdepartamento salvar(Subdepartamento subdepartamento) {
        subdepartamentoFacade = new SubdepartamentoFacade();
        try {
            return subdepartamentoFacade.salvar(subdepartamento);
        } catch (SQLException ex) {
            Logger.getLogger(SubdepartamentoController.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Erro Salvar Subdepartamento "+ ex);
            return null;
        }
    }
    public Subdepartamento consultar(int idSubdepartamento) {
        subdepartamentoFacade = new SubdepartamentoFacade();
        try {
            return subdepartamentoFacade.consultar(idSubdepartamento);
       } catch (SQLException ex) {
            Logger.getLogger(SubdepartamentoController.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Erro Consultar Subdepartamento "+ ex);
            return null;
        }
    }
    
    public List<Subdepartamento> listar(String nome) {
        subdepartamentoFacade = new SubdepartamentoFacade();
        try {
            return subdepartamentoFacade.listar(nome);
       } catch (SQLException ex) {
            Logger.getLogger(SubdepartamentoController.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Erro Listar Subdepartamento "+ ex);
            return null;
        }
    }
}

package br.com.financemante.controller;

import br.com.financemate.facade.DepartamentoFacade;
import br.com.financemate.model.Departamento;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Kamila
 */
public class DepartamentoController {
    
    DepartamentoFacade departamentoFacade;
    
    public Departamento salvar(Departamento departamento) {
        departamentoFacade = new DepartamentoFacade();
        try {
            return departamentoFacade.salvar(departamento);
        } catch (SQLException ex) {
            Logger.getLogger(DepartamentoController.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Erro Salvar Departamento "+ ex);
            return null;
        }
    }
    
    public Departamento consultar(int idDepartamento) {
        departamentoFacade = new DepartamentoFacade();
        try {
            return departamentoFacade.consultar(idDepartamento);
       } catch (SQLException ex) {
            Logger.getLogger(DepartamentoController.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Erro Consultar Departamento "+ ex);
            return null;
        }
    }
    
    public List<Departamento> listar(String nome) {
        departamentoFacade = new DepartamentoFacade();
        try {
            return departamentoFacade.listar(nome);
       } catch (SQLException ex) {
            Logger.getLogger(DepartamentoController.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Erro Listar Departamento "+ ex);
            return null;
        }
    }
    
}

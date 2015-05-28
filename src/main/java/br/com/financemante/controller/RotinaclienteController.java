package br.com.financemante.controller;


import br.com.financemate.facade.RotinaclienteFacade;
import br.com.financemate.model.Rotinacliente;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Kamila
 */
public class RotinaclienteController {
    
    RotinaclienteFacade rotinaclienteFacade;
    
     public Rotinacliente salvar(Rotinacliente rotinacliente) {
        rotinaclienteFacade = new RotinaclienteFacade();
        try {
            return rotinaclienteFacade.salvar(rotinacliente);
        } catch (SQLException ex) {
            Logger.getLogger(RotinaclienteController.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Erro Salvar Rotina cliente "+ ex);
            return null;
        }
    }
    
     public Rotinacliente consultar(int idRotinacliente) {
        rotinaclienteFacade = new RotinaclienteFacade();
        try {
            return rotinaclienteFacade.consultar(idRotinacliente);
       } catch (SQLException ex) {
            Logger.getLogger(RotinaclienteController.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Erro Consultar Rotina cliente "+ ex);
            return null;
        }
    }
     
     public List<Rotinacliente> listar(String nomeCliente) {
        rotinaclienteFacade = new RotinaclienteFacade();
        try {
            return rotinaclienteFacade.listar(nomeCliente);
       } catch (SQLException ex) {
            Logger.getLogger(RotinaclienteController.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Erro Listar Rotina cliente"+ ex);
            return null;
        }
    }
}

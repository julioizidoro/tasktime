/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.financemate.facade;

import br.com.financemate.dao.MembrosDao;
import br.com.financemate.model.Membros;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Julio
 */
public class MembrosFacade {
    MembrosDao membrosDao;
    
    
    public Membros salvar(Membros membros) {
        membrosDao = new MembrosDao();
        try {
            return membrosDao.salvar(membros);
        } catch (SQLException ex) {
            Logger.getLogger(MembrosFacade.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
    
    
    public List<Membros> listar(String nome) {
        membrosDao = new MembrosDao();
        try {
            return membrosDao.listar(nome);
        } catch (SQLException ex) {
            Logger.getLogger(MembrosFacade.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
}

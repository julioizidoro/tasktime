/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.financemate.manageBean;

import br.com.financemate.facade.DepartamentoFacade;
import br.com.financemate.model.Departamento;
import br.com.financemate.model.Processo;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

/**
 *
 * @author Wolverine
 */
@Named
@ViewScoped
public class ProcessoMB {
    
    private Processo processo;
    private List<Processo> listaProcesso;
    private List<Departamento> listaDepartamento;

    public Processo getProcesso() {
        return processo;
    }

    public void setProcesso(Processo processo) {
        this.processo = processo;
    }

    public List<Processo> getListaProcesso() {
        return listaProcesso;
    }

    public void setListaProcesso(List<Processo> listaProcesso) {
        this.listaProcesso = listaProcesso;
    }

    public List<Departamento> getListaDepartamento() {
        return listaDepartamento;
    }

    public void setListaDepartamento(List<Departamento> listaDepartamento) {
        this.listaDepartamento = listaDepartamento;
    }
    
    
    
    
     public void gerarListaDepartamento() throws SQLException{
        DepartamentoFacade departamentoFacade = new DepartamentoFacade();
        listaDepartamento = departamentoFacade.listar("");
        if (listaDepartamento==null){
            listaDepartamento = new ArrayList<Departamento>();
        }
    }
    
     
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.financemate.manageBean;

import br.com.financemate.model.Processorotina;
import java.io.Serializable;

/**
 *
 * @author Wolverine
 */
public class ProcessoRotinaMB implements Serializable{
    
    private Processorotina processorotina;

    public Processorotina getProcessorotina() {
        return processorotina;
    }

    public void setProcessorotina(Processorotina processorotina) {
        this.processorotina = processorotina;
    }
    
    
    
}

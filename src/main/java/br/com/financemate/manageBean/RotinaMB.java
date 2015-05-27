/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.financemate.manageBean;

import br.com.financemante.controller.RotinaController;
import br.com.financemate.model.Rotina;
import java.io.Serializable;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author Kamila
 */
@Named("RotinaMB")
@SessionScoped
public class RotinaMB  implements Serializable{
    
    @Inject
    private UsuarioLogadoBean usuarioLogadoBean;
    private Rotina rotina;
    private String nomeRotina;
    private List<Rotina> listaRotina;
    
    public RotinaMB() {
        rotina = new Rotina();
    }

    public UsuarioLogadoBean getUsuarioLogadoBean() {
        return usuarioLogadoBean;
    }

    public void setUsuarioLogadoBean(UsuarioLogadoBean usuarioLogadoBean) {
        this.usuarioLogadoBean = usuarioLogadoBean;
    }

    public Rotina getRotina() {
        return rotina;
    }

    public void setRotina(Rotina rotina) {
        this.rotina = rotina;
    }

    public String getNomeRotina() {
        return nomeRotina;
    }

    public void setNomeRotina(String nomeRotina) {
        this.nomeRotina = nomeRotina;
    }

    public List<Rotina> getListaRotina() {
        if (listaRotina==null){
            gerarListaRotina();
        }
        return listaRotina;
    }

    public void setListaRotina(List<Rotina> listaRotina) {
        this.listaRotina = listaRotina;
    }
    public void gerarListaRotina() {
        if (nomeRotina == null) {
            nomeRotina = "";
        }
        RotinaController rotinaController = new RotinaController();
        listaRotina = rotinaController.listar(nomeRotina);
        if (listaRotina == null) {
            listaRotina = new ArrayList<Rotina>();
        }
    }
    
    public String pesquisarNome(){
        gerarListaRotina();
        return "consRotina";
    }
    
    public String novo(){
            rotina = new Rotina();
            return "cadRotina";
    }
    
    public String salvar() throws SQLException{
        RotinaController rotinaController = new RotinaController();
        rotinaController.salvar(rotina);
        rotina = new Rotina();
        return "consRotina";
    }
    
    public String editar() throws SQLException{
            if (listaRotina!=null){
            for(int i=0;i<listaRotina.size();i++){
                if (listaRotina.get(i).isSelecionado()){
                    rotina = listaRotina.get(i);
                    listaRotina.get(i).setSelecionado(false);
                    i=100000;
                    return "cadRotina";
                }
            }
        }
        return  "";
    }
}

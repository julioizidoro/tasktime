package br.com.financemate.manageBean;

import br.com.financemate.facade.ModuloFacade;
import br.com.financemate.facade.RaciFacade;
import br.com.financemate.model.Atividademodulo;
import br.com.financemate.model.Modulos;
import br.com.financemate.model.Projeto;
import br.com.financemate.model.Raci;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import javax.servlet.http.HttpSession;

@Named
@ViewScoped
public class RaciMB implements Serializable{
    
    private Raci raci;
    private List<Raci> listaRaci;
    private Atividademodulo atividademodulo;
    
    
    @PostConstruct
    public void init(){
        FacesContext fc = FacesContext.getCurrentInstance();
        HttpSession session = (HttpSession) fc.getExternalContext().getSession(false);
        atividademodulo = (Atividademodulo) session.getAttribute("atividademodulo");
        session.removeAttribute("atividademodulo");
        if (raci==null){
            raci = new Raci();
            raci.setAtividademodulo(atividademodulo);
        }
        if (atividademodulo!=null){
            gerarListaRaci();
        }else{
            listaRaci = new ArrayList<Raci>();
        }
    }

    public List<Raci> getListaRaci() {
        if (listaRaci==null){
            gerarListaRaci();
        }
        return listaRaci;
    }

    public void setListaRaci(List<Raci> listaRaci) {
        this.listaRaci = listaRaci;
    }

    public Atividademodulo getAtividademodulo() {
        return atividademodulo;
    }

    public void setAtividademodulo(Atividademodulo atividademodulo) {
        this.atividademodulo = atividademodulo;
    }

    public Raci getRaci() {
        return raci;
    }

    public void setRaci(Raci raci) {
        this.raci = raci;
    }

    
    
    
    private void gerarListaRaci() {
        String sql = "Select r from Raci r where r.atividademodulo.idatividademodulo=" + atividademodulo.getIdatividademodulo();
        RaciFacade raciFacade = new RaciFacade();
        listaRaci = raciFacade.listar(sql);
        if (listaRaci == null) {
            listaRaci = new ArrayList<Raci>();
         }
    }
    
    public String salvar(Modulos modulos){
        RaciFacade raciFacade = new RaciFacade();  
        raciFacade.salvar(raci);
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage("Cadastrado com Sucesso", ""));
        modulos = atividademodulo.getModulos();
        FacesContext fc = FacesContext.getCurrentInstance();
        HttpSession session = (HttpSession) fc.getExternalContext().getSession(false);
        session.setAttribute("modulos", modulos);
        return "consAtividadeModulo";
    }
    
}

package br.com.financemate.manageBean;

import br.com.financemate.facade.MembrosFacade;
import br.com.financemate.facade.ModuloFacade;
import br.com.financemate.facade.RaciFacade;
import br.com.financemate.model.Atividademodulo;
import br.com.financemate.model.Membros;
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
    private List<Membros> listaMembros;
    private Membros membros;
    
    
    @PostConstruct
    public void init(){
        FacesContext fc = FacesContext.getCurrentInstance();
        HttpSession session = (HttpSession) fc.getExternalContext().getSession(false);
        atividademodulo = (Atividademodulo) session.getAttribute("atividademodulo");
        session.removeAttribute("atividademodulo");
        gerarListaMembros();
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

    public List<Membros> getListaMembros() {
        return listaMembros;
    }

    public void setListaMembros(List<Membros> listaMembros) {
        this.listaMembros = listaMembros;
    }

    public Membros getMembros() {
        return membros;
    }

    public void setMembros(Membros membros) {
        this.membros = membros;
    }

    

    
    
    
    private void gerarListaRaci() {
        String sql = "Select r from Raci r where r.atividademodulo.idatividademodulo=" + atividademodulo.getIdatividademodulo();
        RaciFacade raciFacade = new RaciFacade();
        listaRaci = raciFacade.listar(sql);
        if (listaRaci == null) {
            listaRaci = new ArrayList<Raci>();
         }
    }
    
    public void salvarRaci(Modulos modulos){
        RaciFacade raciFacade = new RaciFacade(); 
        raci.setMembros(membros);
        raciFacade.salvar(raci);
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage("Cadastrado com Sucesso", ""));
        modulos = atividademodulo.getModulos();
        FacesContext fc = FacesContext.getCurrentInstance();
        HttpSession session = (HttpSession) fc.getExternalContext().getSession(false);
        session.setAttribute("modulos", modulos);
        gerarListaRaci();
    }
    
    public void gerarListaMembros() {
        String sql = "Select m from Membros m where m.projeto.idprojeto=" + atividademodulo.getModulos().getProjeto().getIdprojeto();
        MembrosFacade MembrosFacade = new MembrosFacade();
        listaMembros = MembrosFacade.listar(sql);
        if (listaMembros == null) {
            listaMembros = new ArrayList<Membros>();
         }
    }
}

package br.com.financemate.manageBean;

import br.com.financemate.facade.ModuloFacade;
import br.com.financemate.model.Modulos;
import br.com.financemate.model.Projeto;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import javax.servlet.http.HttpSession;
import org.primefaces.context.RequestContext;

@Named
@ViewScoped
public class ModuloMB implements Serializable{
    
    
    private Modulos modulos;
    private List<Modulos> listaModulos;
    private Projeto projeto;
    
    @PostConstruct
    public void init(){
        FacesContext fc = FacesContext.getCurrentInstance();
        HttpSession session = (HttpSession) fc.getExternalContext().getSession(false);
        projeto = (Projeto) session.getAttribute("projeto");
        session.removeAttribute("projeto");
        modulos = new Modulos();
        if (projeto!=null){
            gerarListaModulos();
        }else{
            listaModulos = new ArrayList<Modulos>();
        }
    }

    public Modulos getModulos() {
        return modulos;
    }

    public void setModulos(Modulos modulos) {
        this.modulos = modulos;
    }

    public List<Modulos> getListaModulos() {
        return listaModulos;
    }

    public void setListaModulos(List<Modulos> listaModulos) {
        this.listaModulos = listaModulos;
    }
    
    
    public void gerarListaModulos(){
        String sql = "Select m from Modulos m where m.projeto.idprojeto=" + projeto.getIdprojeto();
        ModuloFacade moduloFacade = new ModuloFacade();
        listaModulos = moduloFacade.listar(sql);
        if (listaModulos==null){
            listaModulos = new ArrayList<Modulos>();
        }
    }
    
    public String novo(){
        FacesContext fc = FacesContext.getCurrentInstance();
        HttpSession session = (HttpSession) fc.getExternalContext().getSession(false);
        session.setAttribute("projeto", projeto);
        return "cadModulo";
    }
    
    
     public String salvar(){
        ModuloFacade moduloFacade = new ModuloFacade();  
        moduloFacade.salvar(modulos);
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage("Cadastrado com Sucesso", ""));
        modulos = new Modulos();
        return "consModulo";
    }
     
      public String cancelar(){
        return "consModulo";
    }
     
}

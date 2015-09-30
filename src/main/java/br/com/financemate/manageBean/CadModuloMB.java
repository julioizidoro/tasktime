package br.com.financemate.manageBean;

import br.com.financemate.facade.ModuloFacade;
import br.com.financemate.model.Modulos;
import br.com.financemate.model.Projeto;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import javax.servlet.http.HttpSession;
import org.primefaces.context.RequestContext;


@Named
@ViewScoped
public class CadModuloMB implements Serializable{
    
    private Modulos modulos;
    
     public CadModuloMB() {
        FacesContext fc = FacesContext.getCurrentInstance();
        HttpSession session = (HttpSession) fc.getExternalContext().getSession(false);
        Projeto projeto = (Projeto) session.getAttribute("projeto");
        modulos = (Modulos) session.getAttribute("modulos");
        session.removeAttribute("modulos");
        if (modulos==null){
            modulos = new Modulos();
            modulos.setProjeto(projeto);
            session.removeAttribute("projeto");
        }
    }

    public Modulos getModulos() {
        return modulos;
    }

    public void setModulos(Modulos modulos) {
        this.modulos = modulos;
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

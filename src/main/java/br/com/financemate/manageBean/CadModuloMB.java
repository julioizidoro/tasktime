package br.com.financemate.manageBean;

import br.com.financemate.facade.ModuloFacade;
import br.com.financemate.model.Modulos;
import br.com.financemate.model.Projeto;
import java.io.Serializable;
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
        session.removeAttribute("projeto");
        session.removeAttribute("modulos");
        if (modulos==null){
            modulos = new Modulos();
            modulos.setProjeto(projeto);
        }
    }

    public Modulos getModulos() {
        return modulos;
    }

    public void setModulos(Modulos modulos) {
        this.modulos = modulos;
    }
    
    public String salvar(){
        FacesContext fc = FacesContext.getCurrentInstance();
        HttpSession session = (HttpSession) fc.getExternalContext().getSession(false);
        Projeto projeto = (Projeto) session.getAttribute("projeto");
        modulos.setProjeto(projeto);
        ModuloFacade moduloFacade = new ModuloFacade();  
        moduloFacade.salvar(modulos);
        return "consModulo";
    }
    
    public String cancelar(){
        return "consModulo";
    }
    
}

package br.com.financemate.manageBean;

import br.com.financemate.facade.AtividadeModuloFacade;
import br.com.financemate.model.Atividademodulo;
import br.com.financemate.model.Modulos;
import br.com.financemate.model.Projeto;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import javax.servlet.http.HttpSession;
import org.primefaces.context.RequestContext;

@Named
@ViewScoped
public class AtividadeModuloMB implements Serializable{
    
    private Atividademodulo atividademodulo;
    private List<Atividademodulo> listaAtividadesModulo;
    private Modulos modulos;
    
    
    @PostConstruct
    public void init(){
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
        if (modulos!=null){
            gerarListaAtividades();
        }else{
            listaAtividadesModulo = new ArrayList<Atividademodulo>();
        }
    }

    public Atividademodulo getAtividademodulo() {
        return atividademodulo;
    }

    public void setAtividademodulo(Atividademodulo atividademodulo) {
        this.atividademodulo = atividademodulo;
    }

    public List<Atividademodulo> getListaAtividadesModulo() {
        return listaAtividadesModulo;
    }

    public void setListaAtividadesModulo(List<Atividademodulo> listaAtividadesModulo) {
        this.listaAtividadesModulo = listaAtividadesModulo;
    }

    public Modulos getModulos() {
        return modulos;
    }

    public void setModulos(Modulos modulos) {
        this.modulos = modulos;
    }
    
    public String novo(){
        atividademodulo = new Atividademodulo();
        AtividadeModuloFacade atividadeModuloFacade = new AtividadeModuloFacade();
        atividademodulo.setDataInicio(new Date());
        atividademodulo.setSituacao("Ativo");
        atividadeModuloFacade.salvar(atividademodulo);
        return "consAtividade";
    }
    
    public void gerarListaAtividades(){
        String sql = "Select a from Atividademodulo a where a.modulos.idmodulos=" + modulos.getIdmodulos();
        AtividadeModuloFacade atividadeModuloFacade = new AtividadeModuloFacade();
        listaAtividadesModulo = atividadeModuloFacade.lista(sql);
        if (listaAtividadesModulo==null){
            listaAtividadesModulo = new ArrayList<Atividademodulo>();
        }
    }
    
    
    public String raci(){
        RequestContext.getCurrentInstance().openDialog("RACI");
        return "";
        
    }
    
}

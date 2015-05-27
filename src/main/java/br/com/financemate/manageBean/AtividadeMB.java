package br.com.financemate.manageBean;

import br.com.financemante.controller.AtividadesController;
import br.com.financemate.facade.AtividadeFacade;
import br.com.financemate.model.Atividades;
import java.io.Serializable;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author Kamila
 */
@Named("AtividadeMB")
@SessionScoped
public class AtividadeMB implements Serializable{
    
     @Inject
    private UsuarioLogadoBean usuarioLogadoBean;
    private Atividades atividades;

    public UsuarioLogadoBean getUsuarioLogadoBean() {
        return usuarioLogadoBean;
    }

    public void setUsuarioLogadoBean(UsuarioLogadoBean usuarioLogadoBean) {
        this.usuarioLogadoBean = usuarioLogadoBean;
    }

    public Atividades getAtividades() {
        return atividades;
    }

    public void setAtividades(Atividades departamento) {
        this.atividades = departamento;
    }
    
    public String novo(){
        atividades = new Atividades();
        return "";
    }
    
    public String salvar(){
        AtividadesController atividadesController = new AtividadesController();
        atividadesController.salvar(atividades);
        atividades = new Atividades();
        return "";
    }
}

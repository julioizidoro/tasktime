package br.com.financemate.manageBean;

import br.com.financemate.facade.PerfilFacade;
import br.com.financemate.model.Perfil;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

@Named("PerfilMB")
@SessionScoped
public class PerfilMB implements Serializable{
   
    
    @Inject
    private UsuarioLogadoBean usuarioLogadoBean;
    private Perfil perfil;
    private List<Perfil> listaPerfil;

    
    public UsuarioLogadoBean getUsuarioLogadoBean() {
        return usuarioLogadoBean;
    }

    public void setUsuarioLogadoBean(UsuarioLogadoBean usuarioLogadoBean) {
        this.usuarioLogadoBean = usuarioLogadoBean;
    }

    public Perfil getPerfil() {
        return perfil;
    }

    public void setPerfil(Perfil perfil) {
        this.perfil = perfil;
    }

    public List<Perfil> getListaPerfil() {
        if(listaPerfil==null){
            gerarListaPerfil("");
        }
        return listaPerfil;
    }

    public void setListaPerfil(List<Perfil> listaPerfil) {
        this.listaPerfil = listaPerfil;
    }
    
    public void gerarListaPerfil(String nomeTipoAcesso) {
        PerfilFacade perfilFacade = new PerfilFacade();
        listaPerfil = perfilFacade.listar(nomeTipoAcesso);
        if (listaPerfil == null) {
            listaPerfil = new ArrayList<Perfil>();
        }
    }
    
    public String novo(){
        perfil = new Perfil();
        return "cadPerfil";
    }
    
    public String salvar(){
        PerfilFacade perfilFacade = new PerfilFacade();
        perfilFacade.salvar(perfil);
        perfil = new Perfil();
        gerarListaPerfil("");
        return "consPerfil";
    }
    
    public String editar(){
        FacesContext fc = FacesContext.getCurrentInstance();
        Map<String,String> params = fc.getExternalContext().getRequestParameterMap();
        int idPerfil =  Integer.parseInt(params.get("id_perfil"));
        if (idPerfil>0){
            PerfilFacade perfilFacade = new PerfilFacade();
            perfil = perfilFacade.consultar(idPerfil);
             if (perfil!=null){
                 gerarListaPerfil("");
                return "cadPerfil";
            }
        }
        return null;
    }
}

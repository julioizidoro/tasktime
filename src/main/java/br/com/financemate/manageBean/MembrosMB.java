package br.com.financemate.manageBean;

import br.com.financemate.facade.MembrosFacade;
import br.com.financemate.facade.UsuarioFacade;
import br.com.financemate.model.Membros;
import br.com.financemate.model.Usuario;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import org.primefaces.context.RequestContext;

@Named
@ViewScoped
public class MembrosMB implements Serializable{
    
    private List<Membros> listaMembros;
    private Membros membros;
    private List<Usuario> listaUsuario;
    private int idUsuario;

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }
    
  
    
    public List<Membros> getListaMembros() {
        if (listaMembros==null){
            gerarListaMembros();
        }
        return listaMembros;
    }

    public void setListaM(List<Membros> listaMembros) {
        this.listaMembros = listaMembros;
    }

    public List<Usuario> getListaUsuario() {
        if (listaUsuario==null){
            gerarListaUsuario();
        }
        return listaUsuario;
    }

    public void setListaUsuario(List<Usuario> listaUsuario) {
        this.listaUsuario = listaUsuario;
    }

    public Membros getMembros() {
        return membros;
    }

    public void setMembros(Membros membros) {
        this.membros = membros;
    }
    
    
    
    
    public void gerarListaUsuario() {
        UsuarioFacade usuarioFacade = new UsuarioFacade();
        listaUsuario = usuarioFacade.listarAtivos();
        if (listaUsuario == null) {
            listaUsuario = new ArrayList<Usuario>();
        }
    }
    
    public void gerarListaMembros() {
        String sql = "Select m from Membros m order by m.idmembros";
        MembrosFacade MembrosFacade = new MembrosFacade();
        listaMembros = MembrosFacade.listar(sql);
        if (listaMembros == null) {
            listaMembros = new ArrayList<Membros>();
         }
    }
    
    public String salvar(){
        
        RequestContext.getCurrentInstance().closeDialog(null);
        return "";
    }
    
    public void adicionarMembro(){
        UsuarioFacade usuarioFacade = new UsuarioFacade();
        Usuario usuario = usuarioFacade.consultar(idUsuario);
        membros.setUsuario(usuario);
        MembrosFacade membrosFacade = new MembrosFacade();
        membrosFacade.salvar(membros);
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage("Membro Adicionado", ""));
        membros = new Membros();
    }
}
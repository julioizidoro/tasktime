package br.com.financemate.manageBean;

import br.com.financemate.facade.MembrosFacade;
import br.com.financemate.model.Membros;
import br.com.financemate.model.Usuario;
import java.sql.SQLException;
import java.util.List;
import java.util.ArrayList;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;


public class MembrosMB {    
    private List<Membros> listaMembros;
    private String nomeMembro;
    private Usuario usuario;
    
    
    
    public String salvar() throws SQLException{
            MembrosFacade membrosFacade = new MembrosFacade();
            
            if (usuario.isSelecionado()){
               gerarListaMembros();
             FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage(null, new FacesMessage("Vinculado com Sucesso", ""));
            
            return "vincularMembros";
        } 
        return null;
    }
    /**
     *
     * @return
     */
    public List<Membros> getListaMembros() {
        if (listaMembros==null){
            gerarListaMembros();
        }
        return listaMembros;
    }

    public void setListaM(List<Membros> listaMembros) {
        this.listaMembros = listaMembros;
    }

    private void gerarListaMembros() {
        if (nomeMembro == null) {
            nomeMembro = "";
        }
        MembrosFacade MembrosFacade = new MembrosFacade();
        listaMembros = MembrosFacade.listar(nomeMembro);
        if (listaMembros == null) {
            listaMembros = new ArrayList<Membros>();
    }
    
    }
    
    
}

package br.com.financemate.manageBean;

import br.com.financemante.controller.SubdepartamentoController;
import br.com.financemate.facade.SubdepartamentoFacade;
import br.com.financemate.model.Subdepartamento;
import java.io.Serializable;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author Kamila
 */
@Named("SubdepartamentoMB")
@SessionScoped
public class SubdepartamentoMB implements Serializable{
    
    @Inject
    private UsuarioLogadoBean usuarioLogadoBean;
    private Subdepartamento subdepartamento;
    private List<Subdepartamento> listaSubdepartamento;

    public UsuarioLogadoBean getUsuarioLogadoBean() {
        return usuarioLogadoBean;
    }

    public void setUsuarioLogadoBean(UsuarioLogadoBean usuarioLogadoBean) {
        this.usuarioLogadoBean = usuarioLogadoBean;
    }

    public Subdepartamento getSubdepartamento() {
        return subdepartamento;
    }

    public void setSubdepartamento(Subdepartamento subdepartamento) {
        this.subdepartamento = subdepartamento;
    }

    public List<Subdepartamento> getListaSubdepartamento() {
        if (listaSubdepartamento==null){
            gerarListaSubdepartamento("");
        }
        return listaSubdepartamento;
    }

    public void setListaSubdepartamento(List<Subdepartamento> listaSubdepartamento) {
        this.listaSubdepartamento = listaSubdepartamento;
    }
    public void gerarListaSubdepartamento(String nome) {
        SubdepartamentoController subdepartamentoController = new SubdepartamentoController();
        listaSubdepartamento = subdepartamentoController.listar(nome);
        if (listaSubdepartamento == null) {
            listaSubdepartamento = new ArrayList<Subdepartamento>();
        }
    }
    
    public String novo(){
            subdepartamento = new Subdepartamento();
            return "cadSubdepartamento";
    }
    
    public String salvar() throws SQLException{
        SubdepartamentoFacade subdepartamentoFacade = new SubdepartamentoFacade();
        subdepartamentoFacade.salvar(subdepartamento);
        subdepartamento = new Subdepartamento();
        return "consSubdepartamento";
    }
    
    public String editar() throws SQLException{
            if (listaSubdepartamento!=null){
            for(int i=0;i<listaSubdepartamento.size();i++){
                if (listaSubdepartamento.get(i).isSelecionado()){
                    subdepartamento = listaSubdepartamento.get(i);
                    listaSubdepartamento.get(i).setSelecionado(false);
                    i=100000;
                    return "cadSubdepartamento";
                }
            }
        }
        return  "";
    }
}

package br.com.financemate.manageBean;

import br.com.financemante.controller.DepartamentoController;
import br.com.financemante.controller.UsuarioController;
import br.com.financemate.facade.DepartamentoFacade;
import br.com.financemate.facade.UsuarioFacade;
import br.com.financemate.model.Departamento;
import br.com.financemate.model.Usuario;
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
@Named("DepartamentoMB")
@SessionScoped
public class DepartamentoMB implements Serializable{
    
    @Inject
    private UsuarioLogadoBean usuarioLogadoBean;
    private Departamento departamento;
     private List<Usuario> listaUsuario;
    private List<Departamento> listaDepartamento;
    private String idUsuario="0";


    
    public UsuarioLogadoBean getUsuarioLogadoBean() {
        return usuarioLogadoBean;
    }

    public void setUsuarioLogadoBean(UsuarioLogadoBean usuarioLogadoBean) {
        this.usuarioLogadoBean = usuarioLogadoBean;
    }

    public Departamento getDepartamento() {
        return departamento;
    }

    public void setDepartamento(Departamento Departamento) {
        this.departamento = Departamento;
    }

    public List<Departamento> getListaDepartamento() {
        if (listaDepartamento==null){
            gerarListaDepartamento("");
        }
        return listaDepartamento;
    }

    public void setListaDepartamento(List<Departamento> listaDepartamento) {
        this.listaDepartamento = listaDepartamento;
    }

    public String getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(String idUsuario) {
        this.idUsuario = idUsuario;
    }

    public List<Usuario> getListaUsuario() throws SQLException {
        if(listaUsuario==null){
            gerarListaUsuario();
        }
        return listaUsuario;
    }

    public void setListaUsuario(List<Usuario> listaUsuario) {
        this.listaUsuario = listaUsuario;
    }
    
    public void gerarListaDepartamento(String nome) {
        DepartamentoController departamentoController = new DepartamentoController();
        listaDepartamento = departamentoController.listar(nome);
        if (listaDepartamento == null) {
            listaDepartamento = new ArrayList<Departamento>();
        }
    }
    
    public String novo() throws SQLException{
            departamento = new Departamento();
            gerarListaUsuario();
            return "cadDepartamento";
    }
    
    public String salvar() throws SQLException{
        DepartamentoFacade departamentoFacade = new DepartamentoFacade();
        UsuarioFacade usuarioFacade = new UsuarioFacade();
        Usuario usuario = usuarioFacade.consultar(Integer.parseInt(idUsuario));
        departamento.setUsuario(usuario);
        departamentoFacade.salvar(departamento);
        departamento = new Departamento();
        gerarListaDepartamento("");
        return "consDepartamento";
    }
    
    public String editar() throws SQLException{
            if (listaDepartamento!=null){
            for(int i=0;i<listaDepartamento.size();i++){
                if (listaDepartamento.get(i).isSelecionado()){
                    departamento = listaDepartamento.get(i);
                    listaDepartamento.get(i).setSelecionado(false);
                    i=100000;
                    return "cadDepartamento";
                }
            }
        }
        return  "";
    }
    
    public void gerarListaUsuario() throws SQLException{
        UsuarioFacade usuarioFacade = new UsuarioFacade();
        listaUsuario = usuarioFacade.listar("");
        if (listaUsuario==null){
            listaUsuario = new ArrayList<Usuario>();
        }
    }
}

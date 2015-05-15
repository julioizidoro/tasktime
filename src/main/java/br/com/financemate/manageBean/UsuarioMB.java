/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.financemate.manageBean;

import br.com.financemate.facade.DepartamentoFacade;
import br.com.financemate.facade.PerfilFacade;
import br.com.financemate.facade.SubdepartamentoFacade;
import br.com.financemate.facade.UsuarioFacade;
import br.com.financemate.model.Departamento;
import br.com.financemate.model.Perfil;
import br.com.financemate.model.Subdepartamento;
import br.com.financemate.model.Usuario;
import java.io.Serializable;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author Kamila
 */
@Named("UsuarioMB")
@SessionScoped
public class UsuarioMB implements Serializable{
    
    @Inject
    private UsuarioLogadoBean usuarioLogadoBean;
    private Usuario usuario;
    private List<Usuario> listaUsuario;
    private String nomeUsuario;
    private List<Departamento> listaDepartamento;
    private List<Perfil> listaPerfil;
    private List<Subdepartamento> listaSubdepartamento;
    private String idSubdepartamento;
    private String idPerfil;
    private String idDepartamento;

    public UsuarioLogadoBean getUsuarioLogadoBean() {
        return usuarioLogadoBean;
    }

    public void setUsuarioLogadoBean(UsuarioLogadoBean usuarioLogadoBean) {
        this.usuarioLogadoBean = usuarioLogadoBean;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public String getIdPerfil() {
        return idPerfil;
    }

    public void setIdPerfil(String idPerfil) {
        this.idPerfil = idPerfil;
    }

    public String getIdDepartamento() {
        return idDepartamento;
    }

    public void setIdDepartamento(String idDepartamento) {
        this.idDepartamento = idDepartamento;
    }
    

    public List<Usuario> getListaUsuario() {
        if (listaUsuario==null){
            gerarListaUsuarios("");
        }
        return listaUsuario;
    }

    public void setListaUsuario(List<Usuario> listaUsuario) {
        this.listaUsuario = listaUsuario;
    }

    public String getNomeUsuario() {
        return nomeUsuario;
    }

    public void setNomeUsuario(String nomeUsuario) {
        this.nomeUsuario = nomeUsuario;
    }

    public List<Departamento> getListaDepartamento() throws SQLException {
        if(listaDepartamento==null){
            gerarListaDepartamento();
        }
        return listaDepartamento;
    }

    public void setListaDepartamento(List<Departamento> listaDepartamento) {
        this.listaDepartamento = listaDepartamento;
    }

    public List<Subdepartamento> getListaSubdepartamento() throws SQLException {
        return listaSubdepartamento;
    }

    public void setListaSubdepartamento(List<Subdepartamento> listaSubdepartamento) {
        this.listaSubdepartamento = listaSubdepartamento;
    }

    public List<Perfil> getListaPerfil() {
        return listaPerfil;
    }

    public void setListaPerfil(List<Perfil> listaPerfil) {
        this.listaPerfil = listaPerfil;
    }
    

    public String getIdSubdepartamento() {
        return idSubdepartamento;
    }

    public void setIdSubdepartamento(String idSubdepartamento) {
        this.idSubdepartamento = idSubdepartamento;
    }
    
    
    public void gerarListaUsuarios(String nome) {
        UsuarioFacade usuarioFacade = new UsuarioFacade();
        listaUsuario = usuarioFacade.listar(nome);
        if (listaUsuario == null) {
            listaUsuario = new ArrayList<Usuario>();
        }
    }
    
    public String novo() throws SQLException{
            usuario = new Usuario();
            gerarListaSubdepartamento();
            gerarListaPerfil("");
            return "cadUsuario";
    }
    
    public String salvar() throws SQLException{
        UsuarioFacade usuarioFacade = new UsuarioFacade();
        SubdepartamentoFacade subdepartamentoFacade = new SubdepartamentoFacade();
        Subdepartamento subddepartamento = subdepartamentoFacade.consultar(Integer.parseInt(idSubdepartamento));
        usuario.setSubdepartamento(subddepartamento);
        PerfilFacade perfilFacade = new PerfilFacade();
        Perfil perfil = perfilFacade.consultar(Integer.parseInt(idPerfil));
        usuario.setPerfil(perfil);
        usuarioFacade.salvar(usuario);
        usuario = new Usuario();
        gerarListaUsuarios("");
        return "consUsuario";
    }
    
    public String editar() throws SQLException{
        FacesContext fc = FacesContext.getCurrentInstance();
        Map<String,String> params = fc.getExternalContext().getRequestParameterMap();
        int idUsuario =  Integer.parseInt(params.get("id_usuario"));
        if (idUsuario>0){
            UsuarioFacade usuarioFacade = new UsuarioFacade();
            usuario = usuarioFacade.consultar(idUsuario);
             if (usuario!=null){
                 gerarListaPerfil("");
                return "cadUsuario";
            }
        }
        return null;
    }
    
    public void gerarListaDepartamento() throws SQLException{
        DepartamentoFacade departamentoFacade = new DepartamentoFacade();
        listaDepartamento = departamentoFacade.listar("");
        if (listaDepartamento==null){
            listaDepartamento = new ArrayList<Departamento>();
        }
    }
    
    public void gerarListaSubdepartamento() throws SQLException {
        if (idDepartamento != null) {
            SubdepartamentoFacade subdepartamentoFacade = new SubdepartamentoFacade();
            listaSubdepartamento = subdepartamentoFacade.listar("", Integer.parseInt(idDepartamento));
            if (listaSubdepartamento == null) {
                listaSubdepartamento = new ArrayList<Subdepartamento>();
            }
        }
    }
    
    public void gerarListaPerfil(String nomeTipoacesso) throws SQLException{
        PerfilFacade perfilFacade = new PerfilFacade();
        listaPerfil = perfilFacade.listar(nomeTipoacesso);
        if (listaPerfil==null){
            listaPerfil = new ArrayList<Perfil>();
        }
    }

}

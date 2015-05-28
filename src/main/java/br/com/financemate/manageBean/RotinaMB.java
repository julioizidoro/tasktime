/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.financemate.manageBean;

import br.com.financemante.controller.RotinaController;
import br.com.financemante.controller.RotinaclienteController;
import br.com.financemate.facade.ClienteFacade;
import br.com.financemate.facade.DepartamentoFacade;
import br.com.financemate.facade.SubdepartamentoFacade;
import br.com.financemate.facade.UsuarioFacade;
import br.com.financemate.model.Cliente;
import br.com.financemate.model.Departamento;
import br.com.financemate.model.Perfil;
import br.com.financemate.model.Rotina;
import br.com.financemate.model.Rotinacliente;
import br.com.financemate.model.Subdepartamento;
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
@Named("RotinaMB")
@SessionScoped
public class RotinaMB  implements Serializable{
    
    @Inject
    private UsuarioLogadoBean usuarioLogadoBean;
    private Rotina rotina;
    private String nomeCliente;
    private List<Rotinacliente> listaRotinacliente;
    private Rotinacliente rotinacliente;
    private List<Departamento> listaDepartamento;
    private List<Subdepartamento> listaSubdepartamento;
    private List<Cliente> listaCliente;
    private String idDepartamento;
    private String idCliente;
    private String idSubdepartamento;
    private List<Usuario> listaUsuario;
     private String idUsuario="0";
    
    public RotinaMB() throws SQLException {
        rotina = new Rotina();
        gerarListaDepartamento();
        gerarListaCliente();
        gerarListaDepartamento();
        gerarListaUsuario();
        gerarListaSubdepartamento();
    }

    public UsuarioLogadoBean getUsuarioLogadoBean() {
        return usuarioLogadoBean;
    }

    public void setUsuarioLogadoBean(UsuarioLogadoBean usuarioLogadoBean) {
        this.usuarioLogadoBean = usuarioLogadoBean;
    }

    public Rotina getRotina() {
        return rotina;
    }

    public void setRotina(Rotina rotina) {
        this.rotina = rotina;
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

    public String getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(String idUsuario) {
        this.idUsuario = idUsuario;
    }
    
    public String getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(String idCliente) {
        this.idCliente = idCliente;
    }
    
    public String getNomeCliente() {
        return nomeCliente;
    }

    public void setNomeCliente(String nomeCliente) {
        this.nomeCliente = nomeCliente;
    }

    public List<Cliente> getListaCliente() throws SQLException {
          if(listaCliente==null){
            gerarListaCliente();
          }
        return listaCliente;
    }

    public void setListaCliente(List<Cliente> listaCliente) {
        this.listaCliente = listaCliente;
    }

    

    public List<Rotinacliente> getListaRotinacliente() {
        if(listaRotinacliente==null){
            gerarListaRotinacliente();
            
        }
        return listaRotinacliente;
    }

    public void setListaRotinacliente(List<Rotinacliente> listaRotinacliente) {
        this.listaRotinacliente = listaRotinacliente;
    }

    public Rotinacliente getRotinacliente() {
        return rotinacliente;
    }

    public void setRotinacliente(Rotinacliente rotinacliente) {
        this.rotinacliente = rotinacliente;
    }

    public List<Departamento> getListaDepartamento() {
        return listaDepartamento;
    }

    public void setListaDepartamento(List<Departamento> listaDepartamento) {
        this.listaDepartamento = listaDepartamento;
    }

    public List<Subdepartamento> getListaSubdepartamento() {
        return listaSubdepartamento;
    }

    public void setListaSubdepartamento(List<Subdepartamento> listaSubdepartamento) {
        this.listaSubdepartamento = listaSubdepartamento;
    }

    public String getIdDepartamento() {
        return idDepartamento;
    }

    public void setIdDepartamento(String idDepartamento) {
        this.idDepartamento = idDepartamento;
    }

    public String getIdSubdepartamento() {
        return idSubdepartamento;
    }

    public void setIdSubdepartamento(String idSubdepartamento) {
        this.idSubdepartamento = idSubdepartamento;
    }
    
    public void gerarListaRotinacliente() {
        if (nomeCliente == null) {
            nomeCliente = "";
        }
        RotinaclienteController rotinaclienteController = new RotinaclienteController();
        listaRotinacliente = rotinaclienteController.listar(nomeCliente);
        if (listaRotinacliente == null) {
            listaRotinacliente = new ArrayList<Rotinacliente>();
        }
    }
    
    public String pesquisarNome(){
        gerarListaRotinacliente();
        return "consRotina";
    }
    
    public String novo() throws SQLException{
        rotina = new Rotina();
        gerarListaDepartamento();
        gerarListaCliente();
        gerarListaDepartamento();
        gerarListaUsuario();
        gerarListaSubdepartamento();
        return "cadRotina";
    }
    
    public String salvar() throws SQLException{
        RotinaController rotinaController = new RotinaController();
        rotinaController.salvar(rotina);
        rotina = new Rotina();
        return "consRotina";
    }
    
    public String editar() throws SQLException{
            if (listaRotinacliente!=null){
            for(int i=0;i<listaRotinacliente.size();i++){
                if (listaRotinacliente.get(i).isSelecionado()){
                    rotinacliente = listaRotinacliente.get(i);
                    listaRotinacliente.get(i).setSelecionado(false);
                    i=100000;
                    return "cadRotina";
                }
            }
        }
        return  "";
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
            listaSubdepartamento = subdepartamentoFacade.listar(idDepartamento);
            if (listaSubdepartamento == null) {
                listaSubdepartamento = new ArrayList<Subdepartamento>();
            }
        }
    }
    
    public void gerarListaCliente() throws SQLException{
        ClienteFacade clienteFacade = new ClienteFacade();
        listaCliente = clienteFacade.listar("");
        if (listaCliente==null){
            listaCliente = new ArrayList<Cliente>();
        }
    }
    
    public void gerarListaUsuario() throws SQLException{
        UsuarioFacade usuarioFacade = new UsuarioFacade();
        listaUsuario = usuarioFacade.listar("");
        if (listaUsuario==null){
            listaUsuario = new ArrayList<Usuario>();
        }
    }
}

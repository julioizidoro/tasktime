/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.financemate.manageBean;

import br.com.financemante.controller.RotinaController;
import br.com.financemante.controller.RotinaclienteController;
import br.com.financemate.bean.RotinaBean;
import br.com.financemate.facade.ClienteFacade;
import br.com.financemate.facade.DepartamentoFacade;
import br.com.financemate.facade.SubdepartamentoFacade;
import br.com.financemate.facade.UsuarioFacade;
import br.com.financemate.model.Cliente;
import br.com.financemate.model.Departamento;
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
    private List<Subdepartamento> listaSubdepartamento;
     private String idSubdepartamento;
    private List<Usuario> listaUsuario;
    private String idUsuario="0";
    private List<RotinaBean> listaRotinabean;
    
    public RotinaMB() throws SQLException {
        rotina = new Rotina();
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

    public List<RotinaBean> getListaRotinabean() throws SQLException {
        if(listaRotinabean==null){
            gerarListaRotinaBean();
        }
        return listaRotinabean;
    }

    public void setListaRotinabean(List<RotinaBean> listaRotinabean) {
        this.listaRotinabean = listaRotinabean;
    }
    

    public String getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(String idUsuario) {
        this.idUsuario = idUsuario;
    }
    
    
    public String getNomeCliente() {
        return nomeCliente;
    }

    public void setNomeCliente(String nomeCliente) {
        this.nomeCliente = nomeCliente;
    }

    

    public List<Rotinacliente> getListaRotinacliente() {
        if(listaRotinacliente==null){
            gerarListaRotinacliente("");
            
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


    public List<Subdepartamento> getListaSubdepartamento() throws SQLException {
        if(listaSubdepartamento==null){
            gerarListaSubdepartamento();
        }
        return listaSubdepartamento;
    }

    public void setListaSubdepartamento(List<Subdepartamento> listaSubdepartamento) {
        this.listaSubdepartamento = listaSubdepartamento;
    }

  
    public String getIdSubdepartamento() {
        return idSubdepartamento;
    }

    public void setIdSubdepartamento(String idSubdepartamento) {
        this.idSubdepartamento = idSubdepartamento;
    }
    
    public void gerarListaRotinacliente(String nomeCliente) {
        RotinaclienteController rotinaclienteController = new RotinaclienteController();
        listaRotinacliente = rotinaclienteController.listar(nomeCliente);
        if (listaRotinacliente == null) {
            listaRotinacliente = new ArrayList<Rotinacliente>();
        }
    }
    
    public void gerarListaRotinaBean() throws SQLException{
        listaRotinabean = new ArrayList<RotinaBean>();
        List<Cliente> listaCliente = gerarListaCliente();
        if(listaCliente!=null){
          for(int i=0;i<listaCliente.size();i++){
              RotinaBean rb = new RotinaBean();
              rb.setCliente(listaCliente.get(i));
              rb.setRotinacliente(new Rotinacliente());
              listaRotinabean.add(rb);
          }
        }
    }
    
    public String pesquisarNome(){
        gerarListaRotinacliente("");
        return "consRotina";
    }
    
    public String novo() throws SQLException{
        rotina = new Rotina();
        gerarListaSubdepartamento();
        gerarListaRotinaBean();
        gerarListaUsuario();
        return "cadRotina";
    }
    
    public String salvar() throws SQLException{
        RotinaController rotinaController = new RotinaController();
        RotinaclienteController rotinaclienteController = new RotinaclienteController();
        SubdepartamentoFacade subdepartamentoFacade = new SubdepartamentoFacade();
        Subdepartamento subddepartamento = subdepartamentoFacade.consultar(Integer.parseInt(idSubdepartamento));
        rotina.setSubdepartamento(subddepartamento);
        rotina = rotinaController.salvar(rotina);
        for (int i=0;i<listaRotinabean.size();i++){
            if (listaRotinabean.get(i).isSelecionado()){
                Rotinacliente rc = new Rotinacliente();
                rc = listaRotinabean.get(i).getRotinacliente();
                rc.setCliente(listaRotinabean.get(i).getCliente());
                rc.setRotina(rotina);
                rotinaclienteController.salvar(rotinacliente);
            }
        }
        rotina = new Rotina();
        gerarListaRotinacliente("");
        return "consRotina";
    }
    
    public String editar() throws SQLException{
            if (listaRotinacliente!=null){
            for(int i=0;i<listaRotinacliente.size();i++){
                if (listaRotinacliente.get(i).isSelecionado()){
                    rotinacliente = listaRotinacliente.get(i);
                    listaRotinacliente.get(i).setSelecionado(false);
                    i=100000;
                    gerarListaSubdepartamento();
                    gerarListaRotinaBean();
                    gerarListaUsuario();
                    return "cadRotina";
                }
            }
        }
        return  "";
    }
    
    public void gerarListaSubdepartamento() throws SQLException {
            SubdepartamentoFacade subdepartamentoFacade = new SubdepartamentoFacade();
            listaSubdepartamento = subdepartamentoFacade.listar("");
            if (listaSubdepartamento == null) {
                listaSubdepartamento = new ArrayList<Subdepartamento>();
            }
    }
    
    public List<Cliente> gerarListaCliente() throws SQLException{
        ClienteFacade clienteFacade = new ClienteFacade();
        List<Cliente> listaCliente = clienteFacade.listar("");
        if (listaCliente==null){
            listaCliente = new ArrayList<Cliente>();
        }
        return listaCliente;
    }
    
    public void gerarListaUsuario() throws SQLException{
        UsuarioFacade usuarioFacade = new UsuarioFacade();
        listaUsuario = usuarioFacade.listar("");
        if (listaUsuario==null){
            listaUsuario = new ArrayList<Usuario>();
        }
    }
    
    public void gravarusuario(String linha) throws SQLException{
        UsuarioFacade usuarioFacade = new UsuarioFacade();
        Usuario usuario = usuarioFacade.consultar(Integer.parseInt(idUsuario));
        listaRotinabean.get(Integer.parseInt(linha)).getRotinacliente().setUsuario(usuario);
        
    }
}

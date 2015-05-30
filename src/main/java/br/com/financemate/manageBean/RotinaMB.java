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
    private RotinaBean rotinabean;
    private Rotina rotina;
    private String nomeRotina;
    private List<Subdepartamento> listaSubdepartamento;
    private String idSubdepartamento;
    private List<Usuario> listaUsuario;
    private String idUsuario="0";
    private List<RotinaBean> listaRotinabean;
    private List<Rotina> listaRotina;
    private String idRotina;
    
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

    public RotinaBean getRotinabean() {
        return rotinabean;
    }

    public void setRotinabean(RotinaBean rotinabean) {
        this.rotinabean = rotinabean;
    }
    
    
    
    public String getNomeRotina() {
        return nomeRotina;
    }

    public void setNomeRotina(String nomeRotina) {
        this.nomeRotina = nomeRotina;
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

    public List<Rotina> getListaRotina() {
        if(listaRotina==null){
            gerarListaRotina();
        }
        return listaRotina;
    }

    public void setListaRotina(List<Rotina> listaRotina) {
        this.listaRotina = listaRotina;
    }

    public String getIdRotina() {
        return idRotina;
    }

    public void setIdRotina(String idRotina) {
        this.idRotina = idRotina;
    }
    
    public void gerarListaRotina() {
        if (nomeRotina == null) {
            nomeRotina = "";
        }
        RotinaController rotinaController = new RotinaController();
        listaRotina = rotinaController.listar(nomeRotina);
        if (listaRotina == null) {
            listaRotina = new ArrayList<Rotina>();
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
        gerarListaRotina();
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
                rotinaclienteController.salvar(rc);
            }
        }
        rotina = new Rotina();
        gerarListaRotina();
        return "consRotina";
    }
    
    public String editar() throws SQLException{
            if (listaRotinabean!=null){
            for(int i=0;i<listaRotinabean.size();i++){
                if (listaRotinabean.get(i).isSelecionado()){
                    rotinabean = listaRotinabean.get(i);
                    listaRotinabean.get(i).setSelecionado(false);
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

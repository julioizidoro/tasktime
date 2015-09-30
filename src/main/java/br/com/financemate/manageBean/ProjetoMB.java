package br.com.financemate.manageBean;

import br.com.financemate.facade.ClienteFacade;
import br.com.financemate.facade.ProjetoFacade;
import br.com.financemate.model.Cliente;
import br.com.financemate.model.Projeto;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import javax.servlet.http.HttpSession;
import org.primefaces.context.RequestContext;

@Named
@ViewScoped
public class ProjetoMB implements Serializable{
    
  private Projeto projeto;
  private List<Projeto> listaProjeto;
  private int idCliente;
  private List<Cliente> listaCliente;
  
  
  @PostConstruct
    public void init(){
        FacesContext fc = FacesContext.getCurrentInstance();
        HttpSession session = (HttpSession) fc.getExternalContext().getSession(false);
        projeto = (Projeto) session.getAttribute("projeto");
        session.removeAttribute("projeto");
        gerarListaProjeto();
        projeto = new Projeto();
    }

    public Projeto getProjeto() {
        return projeto;
    }

    public void setProjeto(Projeto projeto) {
        this.projeto = projeto;
    }

    public List<Projeto> getListaProjeto() {
        if(listaProjeto==null){
            gerarListaProjeto();
        }
        return listaProjeto;
    }

    public void setListaProjeto(List<Projeto> listaProjeto) {
        this.listaProjeto = listaProjeto;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public List<Cliente> getListaCliente() {
        if(listaCliente==null){
            gerarListaCliente();
        }
        return listaCliente;
    }

    public void setListaCliente(List<Cliente> listaCliente) {
        this.listaCliente = listaCliente;
    }

    
    
    
    public String novo(){
        projeto = new Projeto();
        gerarListaCliente();
        return "cadProjeto";
    }
  
    public String salvar() {
        ClienteFacade clienteFacade = new ClienteFacade();
        Cliente cliente = clienteFacade.consultar(idCliente);
        projeto.setCliente(cliente);
        projeto.setSituacao("Ativo");
        ProjetoFacade projetoFacade = new ProjetoFacade();
        projetoFacade.salvar(projeto);
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage("Cadastrado com Sucesso", ""));
        projeto = new Projeto();
        return "consProjeto";
    }
    
    public void gerarListaCliente(){
        ClienteFacade clienteFacade = new ClienteFacade();
        listaCliente = clienteFacade.listar("");
        if (listaCliente==null){
            listaCliente = new ArrayList<Cliente>();
        }
    }
    
    public void gerarListaProjeto() {
        ProjetoFacade projetoFacade = new ProjetoFacade();
        listaProjeto = projetoFacade.listar("");
        if (listaProjeto == null) {
            listaProjeto = new ArrayList<Projeto>();
        }
    }
    
    
    public String editar(){
        if (this.projeto!=null){
            FacesContext fc = FacesContext.getCurrentInstance();
            HttpSession session = (HttpSession) fc.getExternalContext().getSession(false);
            session.setAttribute("projeto", projeto);       
            return "cadProjeto";
        }
        return "";
    }
    
    public String modulo(Projeto projeto){
        FacesContext fc = FacesContext.getCurrentInstance();
        HttpSession session = (HttpSession) fc.getExternalContext().getSession(false);
        session.setAttribute("projeto", projeto);
        return "consModulo";
    }
    
    
    public String vincularMembros(){
        RequestContext.getCurrentInstance().openDialog("vincularMembros");
        return "";
    }
}

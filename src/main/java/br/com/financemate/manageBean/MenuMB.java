package br.com.financemate.manageBean;

import java.io.Serializable;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

@Named("MenuMB")
@SessionScoped
public class MenuMB implements Serializable{
    
    @Inject
    UsuarioLogadoBean usuarioLogadoBean;

    public UsuarioLogadoBean getUsuarioLogadoBean() {
        return usuarioLogadoBean;
    }

    public void setUsuarioLogadoBean(UsuarioLogadoBean usuarioLogadoBean) {
        this.usuarioLogadoBean = usuarioLogadoBean;
    }
    
    
    
    public String cliente(){
        if(usuarioLogadoBean.getUsuario().getPerfil().getCadcliente()){
            return"consCliente";    
        }else{
            FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage(null, new FacesMessage("Erro!", "Acesso Negado"));
        }
        return "";
    }
    
    public String departamento(){
        if(usuarioLogadoBean.getUsuario().getPerfil().getCaddepartamento()){
            return"consDepartamento";
        }else{
            FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage(null, new FacesMessage("Erro!", "Acesso Negado"));
        }
        return "";
    }
    
    
     public String subdepartamento(){
         if(usuarioLogadoBean.getUsuario().getPerfil().getCadsubdepartamento()){
            return"consSubdepartamento";
         }else{
            FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage(null, new FacesMessage("Erro!", "Acesso Negado"));
        }
        return "";
    }
     
      public String rotina(){
        if(usuarioLogadoBean.getUsuario().getPerfil().getCadrotina()){  
          return"consRotina";
        }else{
            FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage(null, new FacesMessage("Erro!", "Acesso Negado"));
        }
        return "";
    }
    
      public String situacao(){
        return"consSituacao";
    }
      
    public String financeiro(){
      return"gestaoFinanceira";  
    }
    
    public String contabilidade(){
      return"contabilidade";  
    }
    
    public String tercerizacao(){
      return"tercerizacao";  
    }
    
    public String usuario(){
        if(usuarioLogadoBean.getUsuario().getPerfil().getCadusuario()){
            return"consUsuario";
        }else{
            FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage(null, new FacesMessage("Erro!", "Acesso Negado"));
        }
        return "";
    }
    
     public String perfil(){
         if(usuarioLogadoBean.getUsuario().getPerfil().getCadperfil()){
            return"consPerfil";
         }else{
            FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage(null, new FacesMessage("Erro!", "Acesso Negado"));
        }
        return "";
    }
     public String informacao(){
       return "informacoes";
     }
 }

package br.com.financemate.manageBean;

import java.io.Serializable;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

@Named("MenuMB")
@SessionScoped
public class MenuMB implements Serializable{
    
    public String cliente(){
        return"consCliente";
    }
    public String cadcliente(){
        return"cadCliente";
    }
    public String departamento(){
        return"consDepartamento";
    }
    public String caddepartamento(){
        return"cadDepartamento";
    }
     public String subdepartamento(){
        return"consSubdepartamento";
    }
     public String cadsubdepartamento(){
        return"cadSubdepartamento";
    }
      public String rotina(){
        return"consRotina";
    }
      public String cadrotina(){
        return"cadRotina";
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
        return"consUsuario";
    }
}

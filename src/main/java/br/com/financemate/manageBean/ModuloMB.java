package br.com.financemate.manageBean;

import br.com.financemate.model.Modulos;
import java.io.Serializable;
import java.util.List;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

@Named
@ViewScoped
public class ModuloMB implements Serializable{
    
    private Modulos modulos;
    private List<Modulos> listaModulos;

    public Modulos getModulos() {
        return modulos;
    }

    public void setModulos(Modulos modulos) {
        this.modulos = modulos;
    }

    public List<Modulos> getListaModulos() {
        return listaModulos;
    }

    public void setListaModulos(List<Modulos> listaModulos) {
        this.listaModulos = listaModulos;
    }
    
    
    public String novo(){
        return "cadModulo";
    }
    
    
}

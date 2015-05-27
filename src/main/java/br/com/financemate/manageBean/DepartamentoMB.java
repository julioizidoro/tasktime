package br.com.financemate.manageBean;

import br.com.financemante.controller.DepartamentoController;
import br.com.financemate.model.Departamento;
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
    private List<Departamento> listaDepartamento;

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
            gerarListaRotina();
        }
        return listaDepartamento;
    }

    public void setListaDepartamento(List<Departamento> listaDepartamento) {
        this.listaDepartamento = listaDepartamento;
    }
    
    public void gerarListaRotina() {
        DepartamentoController departamentoController = new DepartamentoController();
        listaDepartamento = departamentoController.listar();
        if (listaDepartamento == null) {
            listaDepartamento = new ArrayList<Departamento>();
        }
    }
    
    public String novo(){
            departamento = new Departamento();
            return "cadDepartamento";
    }
    
    public String salvar() throws SQLException{
        DepartamentoController departamentoController = new DepartamentoController();
        departamentoController.salvar(departamento);
        departamento = new Departamento();
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
}

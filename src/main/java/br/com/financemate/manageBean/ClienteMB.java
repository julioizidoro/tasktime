package br.com.financemate.manageBean;


import br.com.financemate.facade.ClienteFacade;
import br.com.financemate.facade.DepartamentoFacade;
import br.com.financemate.model.Cliente;
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
@Named("ClienteMB")
@SessionScoped
public class ClienteMB implements Serializable{
    
    @Inject
    private UsuarioLogadoBean usuarioLogadoBean;
    private Cliente cliente;
    private String nomeCliente;
    private List<Cliente> listaClientes;

    public ClienteMB() {
        cliente = new Cliente();
        gerarListaClientes();
    }
    public UsuarioLogadoBean getUsuarioLogadoBean() {
        return usuarioLogadoBean;
    }

    public void setUsuarioLogadoBean(UsuarioLogadoBean usuarioLogadoBean) {
        this.usuarioLogadoBean = usuarioLogadoBean;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public String getNomeCliente() {
        return nomeCliente;
    }

    public void setNomeCliente(String nomeCliente) {
        this.nomeCliente = nomeCliente;
    }

    public List<Cliente> getListaClientes() {
        if (listaClientes==null){
            gerarListaClientes();
        }
        return listaClientes;
    }

    public void setListaClientes(List<Cliente> listaClientes) {
        this.listaClientes = listaClientes;
    }
    
    
    public void gerarListaClientes() {
        if (nomeCliente == null) {
            nomeCliente = "";
        }
        ClienteFacade clienteFacade = new ClienteFacade();
        listaClientes = clienteFacade.listar(nomeCliente);
        if (listaClientes == null) {
            listaClientes = new ArrayList<Cliente>();
        }
    }
    public String pesquisarNome(){
        gerarListaClientes();
        return "consCliente";
    
    } 
    public String novo(){
            cliente = new Cliente();
            return "cadCliente";
    }
    public String salvar() throws SQLException{
        ClienteFacade clienteFacade = new ClienteFacade();
        clienteFacade.salvar(cliente);
        cliente = new Cliente();
        gerarListaClientes();
        return "consCliente";
    }
    public String editar() throws SQLException{
        FacesContext fc = FacesContext.getCurrentInstance();
        Map<String,String> params = fc.getExternalContext().getRequestParameterMap();
        int idCliente =  Integer.parseInt(params.get("id_cliente"));
        if (idCliente>0){
            ClienteFacade clienteFacade = new ClienteFacade();
            cliente = clienteFacade.consultar(idCliente);
             if (cliente!=null){
                return "cadCliente";
            }
        }
        return null;
    }
}

package br.com.financemate.manageBean;

import br.com.financemate.facade.UsuarioFacade;
import br.com.financemate.model.Cliente;
import br.com.financemate.model.Usuario;
import java.io.Serializable;
import java.sql.SQLException;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.http.HttpSession;
/**
 *
 * @author Kamila
 */
@Named("UsuarioLogadoBean")
@SessionScoped
public class UsuarioLogadoBean implements Serializable{
    
    @Inject AtividadeMB atividadeMB;
    private Usuario usuario;
    private Cliente cliente;
    private String novaSenha;
    private String confirmaNovaSenha;
    private String nomeCliente;
    
    public UsuarioLogadoBean() {
        this.usuario = usuario;
    }
    
    public Usuario getUsuario() {
        if (usuario==null){
            usuario = new Usuario();
        }
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public AtividadeMB getAtividadeMB() {
        return atividadeMB;
    }

    public void setAtividadeMB(AtividadeMB atividadeMB) {
        this.atividadeMB = atividadeMB;
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

    public String getNovaSenha() {
        return novaSenha;
    }
    public void setNovaSenha(String novaSenha) {
        this.novaSenha = novaSenha;
    }

    public String getConfirmaNovaSenha() {
        return confirmaNovaSenha;
    }

    public void setConfirmaNovaSenha(String confirmaNovaSenha) {
        this.confirmaNovaSenha = confirmaNovaSenha;
    }
    public String validarUsuario() throws SQLException{
        if ((usuario.getLogin()!=null) && (usuario.getSenha()==null)){
             FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro!", "Login Invalido."));
        }else{
                UsuarioFacade  usuarioFacade = new UsuarioFacade();
            usuario = usuarioFacade.consultar(usuario.getLogin(), usuario.getSenha());
            if (usuario==null){
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error!", "Acesso Negado."));
            }else {
                atividadeMB.listarAtividadesDia();
                atividadeMB.listarAtividadesAtrasadas();
                atividadeMB.listarAtividadesDepartamento(usuario.getSubdepartamento().getDepartamento().getIddepartamento());
                atividadeMB.listarAtividadesSemana();
                atividadeMB.listarAtividadesAmanha();
                atividadeMB.listarAtividadesDois();
                atividadeMB.listarAtividadesTres();
                atividadeMB.listarAtividadesQuatro();
                atividadeMB.listarAtividadesCinco();
                atividadeMB.listarAtividadesSeis();
                atividadeMB.listarAtividadesSete();
                atividadeMB.listarTodasAtividades();
                return "inicial";
            }
        }
        usuario = new Usuario();
        return "";
    }
    public void erroLogin(String mensagem) {
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage(mensagem, ""));
    }
    
    public void validarTrocarSenha(){
        if ((usuario.getLogin()!=null) && (usuario.getSenha()==null)){
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro!", "Login Invalido."));
        }else{
            UsuarioFacade  usuarioFacade = new UsuarioFacade();
            usuario = usuarioFacade.consultar(usuario.getLogin(), usuario.getSenha());
            if (usuario==null){
               FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error!", "Acesso Negado."));
            }
        }
    }
    
    public String confirmaNovaSenha() {
        if ((novaSenha.length() > 0) && (confirmaNovaSenha.length() > 0)) {
            if (novaSenha.equalsIgnoreCase(confirmaNovaSenha)) {
                UsuarioFacade usuarioFacade = new UsuarioFacade();
                usuario.setSenha(novaSenha);
                usuario = usuarioFacade.salvar(usuario);
                novaSenha = "";
                confirmaNovaSenha = "";
                return "inicial";
            } else {
                novaSenha = "";
                confirmaNovaSenha = "";
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error!", "Acesso Negado."));
            }

        } else {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error!", "Acesso Negado."));
        }
        return "";
    }
    public String cancelarTrocaSenha(){
        usuario = new Usuario();
        novaSenha="";
        confirmaNovaSenha="";
        return "index";
    }
    public String deslogar(){
        usuario.setIdusuario(null);
        FacesContext fc = FacesContext.getCurrentInstance();  
        HttpSession session = (HttpSession)fc.getExternalContext().getSession(false);  
        session.invalidate(); 
        return "index";
    }
}

package br.com.financemate.manageBean;

import br.com.financemante.controller.AtividadesController;
import br.com.financemate.bean.Formatacao;
import br.com.financemate.facade.AtividadeFacade;
import br.com.financemate.facade.ClienteFacade;
import br.com.financemate.facade.DepartamentoFacade;
import br.com.financemate.facade.SubdepartamentoFacade;
import br.com.financemate.facade.UsuarioFacade;
import br.com.financemate.model.Atividades;
import br.com.financemate.model.Cliente;
import br.com.financemate.model.Departamento;
import br.com.financemate.model.Subdepartamento;
import br.com.financemate.model.Usuario;
import java.io.Serializable;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author Kamila
 */
@Named("AtividadeMB")
@SessionScoped
public class AtividadeMB implements Serializable{
    
     @Inject
    private UsuarioLogadoBean usuarioLogadoBean;
    private Atividades atividades;
    private List<Departamento> listaDepartamento;
    private List<Subdepartamento> listaSubdepartamento;
    private List<Cliente> listaCliente;
    private String idDepartamento;
    private String idCliente;
    private String idSubdepartamento;
    private List<Usuario> listaUsuario;
    private String idUsuario="0";
    private List<Atividades> listaAtividadedia;
    private List<Atividades> listaAtividadeSemana;
    private List<Atividades> listaAtividadeAtrasada;
    private List<Atividades> listaAtividadesDepartamento;
    private List<Atividades> listaAtividadesGeral;

    public AtividadeMB() {
        atividades = new Atividades();
    }

    public List<Atividades> getListaAtividadedia() {
        return listaAtividadedia;
    }

    public void setListaAtividadedia(List<Atividades> listaAtividadedia) {
        this.listaAtividadedia = listaAtividadedia;
    }

    public List<Atividades> getListaAtividadeSemana() {
        return listaAtividadeSemana;
    }

    public void setListaAtividadeSemana(List<Atividades> listaAtividadeSemana) {
        this.listaAtividadeSemana = listaAtividadeSemana;
    }

    public List<Atividades> getListaAtividadeAtrasada() {
        return listaAtividadeAtrasada;
    }

    public void setListaAtividadeAtrasada(List<Atividades> listaAtividadeAtrasada) {
        this.listaAtividadeAtrasada = listaAtividadeAtrasada;
    }

    public List<Atividades> getListaAtividadesDepartamento() {
        return listaAtividadesDepartamento;
    }

    public void setListaAtividadesDepartamento(List<Atividades> listaAtividadesDepartamento) {
        this.listaAtividadesDepartamento = listaAtividadesDepartamento;
    }

     
    public UsuarioLogadoBean getUsuarioLogadoBean() {
        return usuarioLogadoBean;
    }

    public void setUsuarioLogadoBean(UsuarioLogadoBean usuarioLogadoBean) {
        this.usuarioLogadoBean = usuarioLogadoBean;
    }

    public Atividades getAtividades() {
        return atividades;
    }

    public void setAtividades(Atividades departamento) {
        this.atividades = departamento;
    }

    public List<Departamento> getListaDepartamento() throws SQLException {
        if(listaDepartamento==null){
            gerarListaDepartamento();
        }
        return listaDepartamento;
    }

    public void setListaDepartamento(List<Departamento> listaDepartamento) {
        this.listaDepartamento = listaDepartamento;
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

    public List<Cliente> getListaCliente() throws SQLException {
          if(listaCliente==null){
            gerarListaCliente();
          }
        return listaCliente;
    }

    public void setListaCliente(List<Cliente> listaCliente) {
        this.listaCliente = listaCliente;
    }

    public String getIdDepartamento() {
        return idDepartamento;
    }

    public void setIdDepartamento(String idDepartamento) {
        this.idDepartamento = idDepartamento;
    }

    public String getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(String idCliente) {
        this.idCliente = idCliente;
    }

    public String getIdSubdepartamento() {
        return idSubdepartamento;
    }

    public void setIdSubdepartamento(String idSubdepartamento) {
        this.idSubdepartamento = idSubdepartamento;
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
    
    
    
    
    public String novo(){
        atividades = new Atividades();
        return "";
    }
    
    public String salvar() throws SQLException{
        AtividadesController atividadesController = new AtividadesController();
        SubdepartamentoFacade subdepartamentoFacade = new SubdepartamentoFacade();
        Subdepartamento subddepartamento = subdepartamentoFacade.consultar(Integer.parseInt(idSubdepartamento));
        atividades.setSubdepartamento(subddepartamento);
        UsuarioFacade usuarioFacade = new UsuarioFacade();
        Usuario usuario = usuarioFacade.consultar(Integer.parseInt(idUsuario));
        atividades.setUsuario(usuario);
        atividadesController.salvar(atividades);
        atividades = new Atividades();
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage("Cadastrado com Sucesso", ""));
        return "";
    }
    
    public void gerarListaCliente() throws SQLException{
        ClienteFacade clienteFacade = new ClienteFacade();
        listaCliente = clienteFacade.listar("");
        if (listaCliente==null){
            listaCliente = new ArrayList<Cliente>();
        }
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
            listaSubdepartamento = subdepartamentoFacade.listar("");
            if (listaSubdepartamento == null) {
                listaSubdepartamento = new ArrayList<Subdepartamento>();
            }
        }
    }
    
    public void gerarListaUsuario() throws SQLException{
        UsuarioFacade usuarioFacade = new UsuarioFacade();
        listaUsuario = usuarioFacade.listar("");
        if (listaUsuario==null){
            listaUsuario = new ArrayList<Usuario>();
        }
    }
    
    public String confirmarUsuario() throws SQLException{
        UsuarioFacade usuarioFacade = new UsuarioFacade();
        Usuario usuario = usuarioFacade.consultar(Integer.parseInt(idUsuario));
        atividades.setUsuario(usuario);
        return "";
    }
    
    public  void listarAtividadesDia() throws SQLException {
        AtividadeFacade atividadesFacade = new AtividadeFacade();
        String sql = "Select a from Atividades a where a.prazo=" + Formatacao.ConvercaoDataSql(new Date()) + 
                " and a.concluida='Não' order by a.prioridade, a.nome";
        listaAtividadedia = atividadesFacade.listar(sql);
    }
    
    public  void listarAtividadesSemana() throws SQLException {
        AtividadeFacade atividadesFacade = new AtividadeFacade();
        Date data = Formatacao.SomarDiasData(new Date(), 7);
        String sql = "Select a from Atividades a where a.prazo>" + Formatacao.ConvercaoDataSql(new Date()) + 
                " and a.prazo<=" + Formatacao.ConvercaoDataSql(data) + "  and a.concluida='Não' order by a.prioridade, a.nome";
        listaAtividadeSemana = atividadesFacade.listar(sql);
    }
    
    public  void listarAtividadesAtrasadas() throws SQLException {
        AtividadeFacade atividadesFacade = new AtividadeFacade();
        String sql = "Select a from Atividades a where a.prazo<" + Formatacao.ConvercaoDataSql(new Date()) + 
                 " and a.concluida='Não' order by a.prioridade, a.nome";
        listaAtividadeAtrasada = atividadesFacade.listar(sql);
    }
    
    public  void listarAtividadesDepartamento() throws SQLException {
        AtividadeFacade atividadesFacade = new AtividadeFacade();
        String sql = "Select a from Atividades a where a.subdepartamento.departamento.iddepartamento=" + 
                usuarioLogadoBean.getUsuario().getSubdepartamento().getDepartamento().getIddepartamento() +
                "  and a.concluida='Não' order by a.prioridade, a.nome";
        listaAtividadeSemana = atividadesFacade.listar(sql);
    }
    
}

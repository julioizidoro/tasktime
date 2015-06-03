package br.com.financemate.manageBean;


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
import static java.lang.Boolean.TRUE;
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
    private String atividadeMenu="dia";
    private String ndia;
    private String nsemana;
    private String natrasada;
    private String ndepartamento;
    private String titulo="Tarefas de Hoje";
    private String linha;
    private boolean checkConcluidas=false;

    public AtividadeMB()  {
        atividades = new Atividades();
    }

    public List<Atividades> getListaAtividadesGeral()  {
        if (listaAtividadesGeral==null){
            listarAtividadesDia();
            listaAtividadesGeral= listaAtividadedia;
        }
        return listaAtividadesGeral;
    }

    public void setListaAtividadesGeral(List<Atividades> listaAtividadesGeral) {
        this.listaAtividadesGeral = listaAtividadesGeral;
    }

    public List<Atividades> getListaAtividadedia()  {
        if (listaAtividadedia==null){
            listarAtividadesDia();
        }
        return listaAtividadedia;
    }

    public void setListaAtividadedia(List<Atividades> listaAtividadedia) {
        this.listaAtividadedia = listaAtividadedia;
    }

    public List<Atividades> getListaAtividadeSemana()  {
        if (listaAtividadeSemana==null){
            listarAtividadesSemana();
        }
        return listaAtividadeSemana;
    }

    public boolean isCheckConcluidas() {
        return checkConcluidas;
    }

    public void setCheckConcluidas(boolean checkConcluidas) {
        this.checkConcluidas = checkConcluidas;
    }

    public void setListaAtividadeSemana(List<Atividades> listaAtividadeSemana) {
        this.listaAtividadeSemana = listaAtividadeSemana;
    }

    public List<Atividades> getListaAtividadeAtrasada()  {
        if (listaAtividadeAtrasada==null){
            listarAtividadesAtrasadas();
        }
        return listaAtividadeAtrasada;
    }

    public void setListaAtividadeAtrasada(List<Atividades> listaAtividadeAtrasada) {
        this.listaAtividadeAtrasada = listaAtividadeAtrasada;
    }

    public List<Atividades> getListaAtividadesDepartamento()  {
        if (listaAtividadesDepartamento==null){
            listarAtividadesDepartamento(0);
        }
        return listaAtividadesDepartamento;
    }

    public void setListaAtividadesDepartamento(List<Atividades> listaAtividadesDepartamento) {
        this.listaAtividadesDepartamento = listaAtividadesDepartamento;
    }

    public String getAtividadeMenu() {
        return atividadeMenu;
    }

    public void setAtividadeMenu(String atividadeMenu) {
        this.atividadeMenu = atividadeMenu;
    }

    public String getNdia() {
        return ndia;
    }

    public void setNdia(String ndia) {
        this.ndia = ndia;
    }

    public String getNsemana() {
        return nsemana;
    }

    public void setNsemana(String nsemana) {
        this.nsemana = nsemana;
    }

    public String getNatrasada() {
        return natrasada;
    }

    public void setNatrasada(String natrasada) {
        this.natrasada = natrasada;
    }

    public String getNdepartamento() {
        return ndepartamento;
    }

    public void setNdepartamento(String ndepartamento) {
        this.ndepartamento = ndepartamento;
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

    public List<Departamento> getListaDepartamento()  {
        if(listaDepartamento==null){
            gerarListaDepartamento();
        }
        return listaDepartamento;
    }

    public void setListaDepartamento(List<Departamento> listaDepartamento) {
        this.listaDepartamento = listaDepartamento;
    }

    public List<Subdepartamento> getListaSubdepartamento()  {
        if(listaSubdepartamento==null){
            gerarListaSubdepartamento();
        }
        return listaSubdepartamento;
    }

    public void setListaSubdepartamento(List<Subdepartamento> listaSubdepartamento) {
        this.listaSubdepartamento = listaSubdepartamento;
    }

    public List<Cliente> getListaCliente()  {
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

    public List<Usuario> getListaUsuario()  {
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

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
    
    
    
    
    public String novo(){
        atividades = new Atividades();
        return "";
    }
    
    public String salvar() {
        AtividadeFacade atividadeFacade = new AtividadeFacade();
        SubdepartamentoFacade subdepartamentoFacade = new SubdepartamentoFacade();
        Subdepartamento subddepartamento = subdepartamentoFacade.consultar(Integer.parseInt(idSubdepartamento));
        atividades.setSubdepartamento(subddepartamento);
        UsuarioFacade usuarioFacade = new UsuarioFacade();
        Usuario usuario = usuarioFacade.consultar(Integer.parseInt(idUsuario));
        atividades.setUsuario(usuario);
        atividades = atividadeFacade.salvar(atividades);
        if (atividades.getPrazo().equals(new Date())){
            listarAtividadesDia();
        }else {
            if (atividades.getPrazo().before(new Date())) {
                listarAtividadesAtrasadas();
            }else {
                if (atividades.getPrazo().after(new Date())){
                    listarAtividadesSemana();
                }
            }
        }
        if (atividades.getUsuario().getSubdepartamento().getDepartamento().equals(usuarioLogadoBean.getUsuario().getSubdepartamento().getDepartamento())){
            listarAtividadesDepartamento(0);
        }
        carregarListaGeral();
        atividades = new Atividades();
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage("Cadastrado com Sucesso", ""));
        return "inicial";
    }
    
    public void gerarListaCliente() {
        ClienteFacade clienteFacade = new ClienteFacade();
        listaCliente = clienteFacade.listar("");
        if (listaCliente==null){
            listaCliente = new ArrayList<Cliente>();
        }
    }
    
    public void gerarListaDepartamento() {
        DepartamentoFacade departamentoFacade = new DepartamentoFacade();
        listaDepartamento = departamentoFacade.listar("");
        if (listaDepartamento==null){
            listaDepartamento = new ArrayList<Departamento>();
        }
    }
    
    public void gerarListaSubdepartamento()  {
        if (idDepartamento != null) {
            SubdepartamentoFacade subdepartamentoFacade = new SubdepartamentoFacade();
            listaSubdepartamento = subdepartamentoFacade.listar("");
            if (listaSubdepartamento == null) {
                listaSubdepartamento = new ArrayList<Subdepartamento>();
            }
        }
    }
    
    public void gerarListaUsuario() {
        UsuarioFacade usuarioFacade = new UsuarioFacade();
        listaUsuario = usuarioFacade.listar("");
        if (listaUsuario==null){
            listaUsuario = new ArrayList<Usuario>();
        }
    }
    
    public String confirmarUsuario() {
        UsuarioFacade usuarioFacade = new UsuarioFacade();
        Usuario usuario = usuarioFacade.consultar(Integer.parseInt(idUsuario));
        atividades.setUsuario(usuario);
        return "";
    }
    
    public  void listarAtividadesDia()  {
        AtividadeFacade atividadesFacade = new AtividadeFacade();
        String sql = "Select a from Atividades a where a.prazo='" + Formatacao.ConvercaoDataSql(new Date()) + 
                "' and a.concluida=" + isCheckConcluidas() + " order by a.prioridade, a.nome";
        listaAtividadedia = atividadesFacade.listar(sql);
        if (listaAtividadedia==null){
            listaAtividadedia = new ArrayList<Atividades>();
        }
        if (listaAtividadedia.size()<10){
            ndia = "Hoje (0" + String.valueOf(listaAtividadedia.size()) + ")";
        }else ndia = String.valueOf(listaAtividadedia.size());
        
    }
    
    public  void listarAtividadesSemana()  {
        AtividadeFacade atividadesFacade = new AtividadeFacade();
        Date data = Formatacao.SomarDiasData(new Date(), 7);
        String sql = "Select a from Atividades a where a.prazo>'" + Formatacao.ConvercaoDataSql(new Date()) + 
                "' and a.prazo<='" + Formatacao.ConvercaoDataSql(data) + "'  and a.concluida=" + isCheckConcluidas() + " order by a.prioridade, a.nome";
        listaAtividadeSemana = atividadesFacade.listar(sql);
        if (listaAtividadeSemana==null){
            listaAtividadeSemana = new ArrayList<Atividades>();
        }
        if (listaAtividadeSemana.size()<10){
            nsemana= "Semana (0" + String.valueOf(listaAtividadeSemana.size()) + ")";
        }else nsemana = "Semana (" + String.valueOf(listaAtividadeSemana.size()) + ")";
    }
    
    public  void listarAtividadesAtrasadas()  {
        AtividadeFacade atividadesFacade = new AtividadeFacade();
        String sql = "Select a from Atividades a where a.prazo<'" + Formatacao.ConvercaoDataSql(new Date()) + 
                 "' and a.concluida=FALSE  order by a.prioridade, a.nome";
        listaAtividadeAtrasada = atividadesFacade.listar(sql);
        if (listaAtividadeAtrasada==null){
            listaAtividadeAtrasada = new ArrayList<Atividades>();
        }
        if (listaAtividadeAtrasada.size()<10){
            natrasada = "Atrasadas (0" + String.valueOf(listaAtividadeAtrasada.size())+")";
        }else natrasada = "Atrasadas (" + String.valueOf(listaAtividadeAtrasada.size())+")";
    }
    
    public void listarAtividadesDepartamento(int iddepartamento)  {
        if (usuarioLogadoBean != null) {
            iddepartamento = usuarioLogadoBean.getUsuario().getSubdepartamento().getDepartamento().getIddepartamento();
        }
        AtividadeFacade atividadesFacade = new AtividadeFacade();
        String sql = "Select a from Atividades a where a.subdepartamento.departamento.iddepartamento="
                + usuarioLogadoBean.getUsuario().getSubdepartamento().getDepartamento().getIddepartamento()
                + "  and a.concluida=FALSE order by a.prioridade, a.nome";
        listaAtividadeSemana = atividadesFacade.listar(sql);
        if (listaAtividadesDepartamento==null){
            listaAtividadesDepartamento = new ArrayList<Atividades>();
        }
        if (listaAtividadesDepartamento.size() < 10) {
            ndepartamento = "Atividades (0" + String.valueOf(listaAtividadesDepartamento.size()) + ")";
        } else {
            ndepartamento = "Atividades (" + String.valueOf(listaAtividadesDepartamento.size()) + ")";
        }

    }
    
    public String mostarAtividadesDia(){
        listaAtividadesGeral = listaAtividadedia;
        atividadeMenu="dia";
        titulo="Taferas de Hoje";
        return "inicial";
    }
    
    public String mostarAtividadesSemana(){
        listaAtividadesGeral = listaAtividadeSemana;
        atividadeMenu="semana";
        titulo="Taferas da Semana";
        return "inicial";
    }
    
    public String mostarAtividadesAtrasadas(){
        listaAtividadesGeral = listaAtividadeAtrasada;
        atividadeMenu="atrasada";
         titulo="Taferas Atrasadas";
        return "inicial";
    }
    
    public String mostarAtividadesDepartamento(){
        listaAtividadesGeral = listaAtividadesDepartamento;
        atividadeMenu="departamento";
        titulo="Taferas do Departamento";
        return "inicial";
    }
    
    public void carregarListaGeral(){
        if (atividadeMenu.equalsIgnoreCase("dia")){
            listaAtividadesGeral = listaAtividadedia;
        }else if (atividadeMenu.equalsIgnoreCase("semana")){
            listaAtividadesGeral = listaAtividadeSemana;
        }else if (atividadeMenu.equalsIgnoreCase("atrasada")){
            listaAtividadesGeral = listaAtividadeAtrasada;
        }else listaAtividadesGeral = listaAtividadesDepartamento;
    }
    
    public String imagem(Atividades atividade) {
        if (atividade.getPrioridade().equalsIgnoreCase("alta")) {
            return "resources/img/bolaVermelha.png";
        } else if (atividade.getPrioridade().equalsIgnoreCase("media")) {
            return "resources/img/bolaAmarela.png";
        } else {
            return "resources/img/bolaVerde.png";
        }
    }
    
    public void pegarLinha(String linha){
        this.linha = linha;
    }
    
    public String salvarAtividadeConcluida(){
        int iLinha = Integer.parseInt(linha);
        atividades = listaAtividadesGeral.get(iLinha);
        atividades.setConcluida(TRUE);
        AtividadeFacade atividadeFacade = new AtividadeFacade();
        atividadeFacade.salvar(atividades);
         if (atividadeMenu.equalsIgnoreCase("dia")){
            listarAtividadesDia();
        }else if (atividadeMenu.equalsIgnoreCase("semana")){
            listarAtividadesSemana();
        }else if (atividadeMenu.equalsIgnoreCase("atrasada")){
            listarAtividadesAtrasadas();
        }else listarAtividadesDepartamento(usuarioLogadoBean.getUsuario().getSubdepartamento().getDepartamento().getIddepartamento());
        carregarListaGeral();
        return "inicial";
    }
    
    public String filtarConcluidas(){
        listarAtividadesDia();
        listarAtividadesSemana();
        carregarListaGeral();
        return "inicial";
    }
}

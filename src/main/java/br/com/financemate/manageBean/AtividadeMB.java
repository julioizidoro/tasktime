package br.com.financemate.manageBean;


import br.com.financemate.bean.Formatacao;
import br.com.financemate.facade.AtividadeFacade;
import br.com.financemate.facade.ClienteFacade;
import br.com.financemate.facade.ComentariosFacade;
import br.com.financemate.facade.DepartamentoFacade;
import br.com.financemate.facade.SubdepartamentoFacade;
import br.com.financemate.facade.UsuarioFacade;
import br.com.financemate.model.Atividades;
import br.com.financemate.model.Cliente;
import br.com.financemate.model.Comentarios;
import br.com.financemate.model.Departamento;
import br.com.financemate.model.Subdepartamento;
import br.com.financemate.model.Usuario;
import java.io.Serializable;
import static java.lang.Boolean.FALSE;
import java.math.BigInteger;
import java.sql.SQLException;
import java.sql.Time;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
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
    private String idDepartamento="0";
    private String idCliente;
    private String idSubdepartamento="0";
    private List<Usuario> listaUsuario;
    private String idUsuario="0";
    private List<Atividades> listaAtividadedia;
    private List<Atividades> listaAtividadeSemana;
    private List<Atividades> listaAtividadeAtrasada;
    private List<Atividades> listaTodasAtividade;
    private List<Atividades> listaAtividadesDepartamento;
    private List<Atividades> listaAtividadesGeral;
    private List<Atividades> listaAtividadesAmanha;
    private List<Atividades> listaAtividadesDois;
    private List<Atividades> listaAtividadesTres;
    private List<Atividades> listaAtividadesQuatro;
    private List<Atividades> listaAtividadesCinco;
    private List<Atividades> listaAtividadesSeis;
    private List<Atividades> listaAtividadesSete;
    private String atividadeMenu="dia";
    private String ndia;
    private String nsemana;
    private String natrasada;
    private String ndepartamento;
    private String namanha;
    private String dois;
    private String tres;
    private String quatro;
    private String cinco;
    private String seis;
    private String sete;
    private String titulo="Tarefas de Hoje";
    private String linha;
    private String todas;
    private boolean checkConcluidas=false;
    private Comentarios comentarios;
    private String nomeAtividades;
    private String visualizar;
    

    public AtividadeMB()  {
         atividadeMenu="dia";
        atividades = new Atividades();
        comentarios = new Comentarios();
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

    public String getVisualizar() {
        return visualizar;
    }

    public void setVisualizar(String visualizar) {
        this.visualizar = visualizar;
    }

    public List<Atividades> getListaAtividadeSemana()  {
        if (listaAtividadeSemana==null){
            listarAtividadesAmanha();
        }
        return listaAtividadeSemana;
    }

    public List<Atividades> getListaTodasAtividade() {
         if (listaTodasAtividade==null){
           listarTodasAtividades();
        }
        return listaTodasAtividade;
    }

    public void setListaTodasAtividade(List<Atividades> listaTodasAtividade) {
        this.listaTodasAtividade = listaTodasAtividade;
    }

    public List<Atividades> getListaAtividadesAmanha() {
        if(listaAtividadesAmanha==null){
            listarAtividadesAmanha();
        }
        return listaAtividadesAmanha;
    }

    public void setListaAtividadesAmanha(List<Atividades> listaAtividadesAmanha) {
        this.listaAtividadesAmanha = listaAtividadesAmanha;
    }

    public List<Atividades> getListaAtividadesDois() {
        if(listaAtividadesDois==null){
            listarAtividadesDois();
        }
        return listaAtividadesDois;
    }

    public void setListaAtividadesDois(List<Atividades> listaAtividadesDois) {
        this.listaAtividadesDois = listaAtividadesDois;
    }

    public List<Atividades> getListaAtividadesTres() {
        if(listaAtividadesTres==null){
            listarAtividadesTres();
        }
        return listaAtividadesTres;
    }

    public void setListaAtividadesTres(List<Atividades> listaAtividadesTres) {
        this.listaAtividadesTres = listaAtividadesTres;
    }

    public List<Atividades> getListaAtividadesQuatro() {
        if(listaAtividadesQuatro==null){
            listarAtividadesQuatro();
        }
        return listaAtividadesQuatro;
    }

    public void setListaAtividadesQuatro(List<Atividades> listaAtividadesQuatro) {
        this.listaAtividadesQuatro = listaAtividadesQuatro;
    }

    public List<Atividades> getListaAtividadesCinco() {
        if(listaAtividadesCinco==null){
            listarAtividadesCinco();
        }
        return listaAtividadesCinco;
    }

    public void setListaAtividadesCinco(List<Atividades> listaAtividadesCinco) {
        this.listaAtividadesCinco = listaAtividadesCinco;
    }

    public Comentarios getComentarios() {
        return comentarios;
    }

    public void setComentarios(Comentarios comentarios) {
        this.comentarios = comentarios;
    }
    
    

    public List<Atividades> getListaAtividadesSeis() {
        if(listaAtividadesSeis==null){
            listarAtividadesSeis();
        }
        return listaAtividadesSeis;
    }

    public void setListaAtividadesSeis(List<Atividades> listaAtividadesSeis) {
        this.listaAtividadesSeis = listaAtividadesSeis;
    }

    public List<Atividades> getListaAtividadesSete() {
        if(listaAtividadesSete==null){
            listarAtividadesSete();
        }
        return listaAtividadesSete;
    }

    public void setListaAtividadesSete(List<Atividades> listaAtividadesSete) {
        this.listaAtividadesSete = listaAtividadesSete;
    }

    public String getNamanha() {
        return namanha;
    }

    public void setNamanha(String namanha) {
        this.namanha = namanha;
    }

    public String getTodas() {
        return todas;
    }

    public void setTodas(String todas) {
        this.todas = todas;
    }
    

    public String getDois() {
        return dois;
    }

    public void setDois(String dois) {
        this.dois = dois;
    }

    public String getTres() {
        return tres;
    }

    public void setTres(String tres) {
        this.tres = tres;
    }

    public String getQuatro() {
        return quatro;
    }

    public void setQuatro(String quatro) {
        this.quatro = quatro;
    }

    public String getCinco() {
        return cinco;
    }

    public void setCinco(String cinco) {
        this.cinco = cinco;
    }

    public String getSeis() {
        return seis;
    }

    public void setSeis(String seis) {
        this.seis = seis;
    }

    public String getSete() {
        return sete;
    }

    public void setSete(String sete) {
        this.sete = sete;
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

    public String getNomeAtividades() {
        return nomeAtividades;
    }

    public void setNomeAtividades(String nomeAtividades) {
        this.nomeAtividades = nomeAtividades;
    }
    
    
    
    
    
    public String novo(){
        atividades = new Atividades();
        atividades.setTempo(0);
        atividades.setEstado("Play");
        idUsuario = String.valueOf(usuarioLogadoBean.getUsuario().getIdusuario());
        idCliente = "4";
        idDepartamento = String.valueOf(usuarioLogadoBean.getUsuario().getSubdepartamento().getDepartamento().getIddepartamento());
        gerarListaSubdepartamento();
        idSubdepartamento = String.valueOf(usuarioLogadoBean.getUsuario().getSubdepartamento().getIdsubdepartamento());
        atividades.setPrazo(new Date());
        atividades.setPrioridade("normal");
        return "";
    }
    
    public String salvar() {
        AtividadeFacade atividadeFacade = new AtividadeFacade();
        SubdepartamentoFacade subdepartamentoFacade = new SubdepartamentoFacade();
        Subdepartamento subddepartamento = subdepartamentoFacade.consultar(Integer.parseInt(idSubdepartamento));
        atividades.setSubdepartamento(subddepartamento);
        atividades.setConcluida(FALSE);
        ClienteFacade clienteFacade = new ClienteFacade();
        Cliente cliente = clienteFacade.consultar(Integer.parseInt(idCliente));
        atividades.setCliente(cliente);
        atividades.setTipo("A");
        UsuarioFacade usuarioFacade = new UsuarioFacade();
        Usuario usuario = usuarioFacade.consultar(Integer.parseInt(idUsuario));
        atividades.setUsuario(usuario);
        atividades = atividadeFacade.salvar(atividades);
        atividadeMenu="dia";
        listarAtividadesAtrasadas();
        listarAtividadesDia();
        listarAtividadesSemana();
        listarTodasAtividades();
        listarAtividadesAmanha();
        listarAtividadesDois();
        listarAtividadesTres();
        listarAtividadesQuatro();
        listarAtividadesCinco();
        listarAtividadesSeis();
        listarAtividadesSete();
        if (atividades.getUsuario().getSubdepartamento().getDepartamento().equals(usuarioLogadoBean.getUsuario().getSubdepartamento().getDepartamento())){
            listarAtividadesDepartamento(0);
        }
        carregarListaGeral();
        atividades = new Atividades();
        idCliente="0";
        idUsuario="0";
        idDepartamento="0";
        idSubdepartamento="0";
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage("Cadastrado com Sucesso", ""));
        atividadeMenu="dia";
        return "inicial";
    }
    
    public void gerarListaCliente() {
        ClienteFacade clienteFacade = new ClienteFacade();
        listaCliente = clienteFacade.listar("", "Ativo");
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
        if (!idDepartamento.equalsIgnoreCase("0")) {
            SubdepartamentoFacade subdepartamentoFacade = new SubdepartamentoFacade();
            listaSubdepartamento = subdepartamentoFacade.listar("", Integer.parseInt(idDepartamento));
            if (listaSubdepartamento == null) {
                listaSubdepartamento = new ArrayList<Subdepartamento>();
            }
        }else {
            listaSubdepartamento = new ArrayList<Subdepartamento>();
        }
    }
    
    public void gerarListaUsuario() {
        UsuarioFacade usuarioFacade = new UsuarioFacade();
        listaUsuario = usuarioFacade.listar("");
        if (listaUsuario==null){
            listaUsuario = new ArrayList<Usuario>();
        }
    }
    
    public void confirmarUsuario() {
        UsuarioFacade usuarioFacade = new UsuarioFacade();
        Usuario usuario = usuarioFacade.consultar(Integer.parseInt(idUsuario));
        atividades.setUsuario(usuario);
    }
    
    public  void listarAtividadesDia()  {
        AtividadeFacade atividadesFacade = new AtividadeFacade();
        String sql = "Select a from Atividades a where  a.prazo<='" + Formatacao.ConvercaoDataSql(new Date()) + 
                "' and a.concluida=" + isCheckConcluidas() + " and a.usuario.idusuario=" + usuarioLogadoBean.getUsuario().getIdusuario() +
                " order by a.prazo, a.prioridade, a.nome";
        listaAtividadedia = atividadesFacade.listar(sql);
        if (listaAtividadedia==null){
            listaAtividadedia = new ArrayList<Atividades>();
        }
        if (listaAtividadedia.size()<10){
            ndia = "Hoje (0" + String.valueOf(listaAtividadedia.size()) + ")";
        }else ndia = "Hoje (" + String.valueOf(listaAtividadedia.size()) +")";
        
    }
    public  void listarTodasAtividades()  {
        if (nomeAtividades == null) {
            nomeAtividades = "";
        }
        AtividadeFacade atividadesFacade = new AtividadeFacade();
        String sql = "Select a from Atividades a where a.usuario.idusuario=" + usuarioLogadoBean.getUsuario().getIdusuario() +
                " order by a.prazo, a.prioridade, a.nome";
        listaTodasAtividade = atividadesFacade.listar(nomeAtividades + sql);
        if (listaTodasAtividade==null){
            listaTodasAtividade = new ArrayList<Atividades>();
        }
        if (listaTodasAtividade.size()<10){
            todas = "Todas (0" + String.valueOf(listaTodasAtividade.size()) + ")";
        }else todas = "Todas (" + String.valueOf(listaTodasAtividade.size()) +")";
        
    }
    
    public  void listarAtividadesSemana()  {
        AtividadeFacade atividadesFacade = new AtividadeFacade();
        Date data = Formatacao.SomarDiasData(new Date(), 7);
        String sql = "Select a from Atividades a where a.prazo>'" + Formatacao.ConvercaoDataSql(new Date()) + 
                "' and a.prazo<='" + Formatacao.ConvercaoDataSql(data) + "'  and a.concluida=" + isCheckConcluidas() + 
                " and a.usuario.idusuario=" + usuarioLogadoBean.getUsuario().getIdusuario()  +
                " order by a.prazo, a.prioridade, a.nome";
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
                 "' and a.concluida=FALSE  and a.usuario.idusuario=" + usuarioLogadoBean.getUsuario().getIdusuario() +
                " order by a.prazo, a.prioridade, a.nome";
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
        String sql = "Select a from Atividades a where a.concluida=FALSE  order by a.prazo, a.prioridade, a.nome";
        listaAtividadesDepartamento = atividadesFacade.listar(sql);
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
        return "tarefasAtrasadas";
    }
    
    public String mostarTodasAtividades(){
        listaAtividadesGeral = listaTodasAtividade;
        atividadeMenu="todas";
         titulo="Todas as Taferas";
        return "tarefasTodas";
    }
    
    public String mostarAtividadesDepartamento(){
        listaAtividadesGeral = listaAtividadesDepartamento;
        atividadeMenu="departamento";
        titulo="Taferas do Departamento";
        return "tarefaDepartamento";
    }
    
    public void carregarListaGeral(){
        listaAtividadesGeral = new ArrayList<Atividades>();
        if (atividadeMenu.equalsIgnoreCase("dia")){
            listaAtividadesGeral = listaAtividadedia;
        }else if (atividadeMenu.equalsIgnoreCase("semana")){
            listaAtividadesGeral = listaAtividadeSemana;
        }else if (atividadeMenu.equalsIgnoreCase("atrasada")){
            listaAtividadesGeral = listaAtividadeAtrasada;
        }else if (atividadeMenu.equalsIgnoreCase("amanha")) {
                listarAtividadesAmanha();
            }else if (atividadeMenu.equalsIgnoreCase("dois")) {
                listarAtividadesDois();
            }else if (atividadeMenu.equalsIgnoreCase("tres")) {
                listarAtividadesTres();
            }else if (atividadeMenu.equalsIgnoreCase("quatro")) {
                listarAtividadesQuatro();
            }else if (atividadeMenu.equalsIgnoreCase("cinco")) {
                listarAtividadesCinco();
            }else if (atividadeMenu.equalsIgnoreCase("seis")) {
                listarAtividadesSeis();
            }else if (atividadeMenu.equalsIgnoreCase("sete")) {
                listarAtividadesSete();
            }else listaAtividadesGeral = listaAtividadesDepartamento;
    }
    
    public String imagem(Atividades atividade) {
        if (atividade.getPrioridade().equalsIgnoreCase("urgente")) {
            return "/resources/img/bandeira-vermelho.png";
        } else if (atividade.getPrioridade().equalsIgnoreCase("alta")) {
            return "/resources/img/bandeira_amarela.png";
        } else {
            return "/resources/img/bandeira_verde.png";
        }
    }
    
   
    
    public void salvarAtividadeConcluida(String linha) {
        int iLinha = Integer.parseInt(linha);
        atividades = listaAtividadesGeral.get(iLinha);
        if (atividades.getEstado().equalsIgnoreCase("Pause")){
            Long termino = new Date().getTime();
            BigInteger valorInicio = atividades.getInicio();
            Long inicio = valorInicio.longValue();
            Long resultado = termino - inicio;
            resultado = resultado/1000;
            resultado = resultado/60;
            int tempo = resultado.intValue();
            tempo = tempo + atividades.getTempo();
            atividades.setTempo(tempo);
            atividades.setEstado("Pause");
        }
        if (usuarioLogadoBean.getUsuario().getIdusuario() == atividades.getUsuario().getIdusuario()) {
            AtividadeFacade atividadeFacade = new AtividadeFacade();
            atividadeFacade.salvar(atividades);
            if (atividadeMenu.equalsIgnoreCase("dia")) {
                listarAtividadesDia();
            } else if (atividadeMenu.equalsIgnoreCase("semana")) {
                listarAtividadesSemana();
            } else if (atividadeMenu.equalsIgnoreCase("atrasada")) {
                listarAtividadesAtrasadas();
            } else if (atividadeMenu.equalsIgnoreCase("amanha")) {
                listarAtividadesAmanha();
            }else if (atividadeMenu.equalsIgnoreCase("dois")) {
                listarAtividadesDois();
            }else if (atividadeMenu.equalsIgnoreCase("tres")) {
                listarAtividadesTres();
            }else if (atividadeMenu.equalsIgnoreCase("quatro")) {
                listarAtividadesQuatro();
            }else if (atividadeMenu.equalsIgnoreCase("cinco")) {
                listarAtividadesCinco();
            }else if (atividadeMenu.equalsIgnoreCase("seis")) {
                listarAtividadesSeis();
            }else if (atividadeMenu.equalsIgnoreCase("sete")) {
                listarAtividadesSete();
            }else {
                listarAtividadesDepartamento(usuarioLogadoBean.getUsuario().getSubdepartamento().getDepartamento().getIddepartamento());
            }
            carregarListaGeral();
        }else {
            FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage(null, new FacesMessage("Atividade de outro usuário", ""));
            if (listaAtividadesGeral.get(iLinha).isSelecionado()){
                listaAtividadesGeral.get(iLinha).setSelecionado(false);
            }else listaAtividadesGeral.get(iLinha).setSelecionado(true);
        }
    }
    
    public String filtarConcluidas(){
        listarAtividadesDia();
        listarAtividadesSemana();
        carregarListaGeral();
        listarAtividadesAmanha();
        listarAtividadesDois();
        listarAtividadesTres();
        listarAtividadesQuatro();
        listarAtividadesCinco();
        listarAtividadesSeis();
        listarAtividadesSete();
        return "inicial";
    }
    
    public void listarAtividadesAmanha(){
        AtividadeFacade atividadeFacade = new AtividadeFacade();
        Date data = new Date();
        data = Formatacao.SomarDiasData(data, 1);
        String sql = "Select a from Atividades a where a.prazo='" + Formatacao.ConvercaoDataSql(data) + "' and a.concluida=" + isCheckConcluidas() + 
                " and a.usuario.idusuario=" + usuarioLogadoBean.getUsuario().getIdusuario() +
                " order by a.prazo, a.prioridade, a.nome";
        listaAtividadesAmanha = atividadeFacade.listar(sql);
        if(listaAtividadesAmanha==null){
            listaAtividadesAmanha = new ArrayList<Atividades>();
        }
        if (listaAtividadesAmanha.size()<10){
            namanha= Formatacao.diaSemanaEscrito(data) + " (0" + String.valueOf(listaAtividadesAmanha.size()) + ")";
        }else namanha = Formatacao.diaSemanaEscrito(data) + " (" + String.valueOf(listaAtividadesAmanha.size()) + ")";
    }
    
    public String mostarAtividadesAmanha(){
        listaAtividadesGeral = listaAtividadesAmanha;
        atividadeMenu="amanha";
        titulo="Tarefas de Amanhã";
        return "inicial";
    }
    
    public void listarAtividadesDois(){
        AtividadeFacade atividadeFacade = new AtividadeFacade();
        Date data = new Date();
        data = Formatacao.SomarDiasData(data, 2);
        String sql = "Select a from Atividades a where a.prazo='" + Formatacao.ConvercaoDataSql(data) + "' and a.concluida=" + isCheckConcluidas() + 
                " and a.usuario.idusuario=" + usuarioLogadoBean.getUsuario().getIdusuario() +
                " order by a.prazo, a.prioridade, a.nome";
        listaAtividadesDois = atividadeFacade.listar(sql);
        if(listaAtividadesDois==null){
            listaAtividadesDois = new ArrayList<Atividades>();
        }
        if (listaAtividadesDois.size()<10){
            dois= Formatacao.diaSemanaEscrito(data) + "  (0" + String.valueOf(listaAtividadesDois.size()) + ")";
        }else dois = Formatacao.diaSemanaEscrito(data) + " (" + String.valueOf(listaAtividadesDois.size()) + ")";
    }
    
    public String mostarAtividadesDois(){
        listaAtividadesGeral = listaAtividadesDois;
        Date data = new Date();
        data = Formatacao.SomarDiasData(data, 2);
        atividadeMenu="dois";
        titulo="Tarefas de " + Formatacao.diaSemanaEscrito(data);
        return "inicial";
    }
    
    public void listarAtividadesTres(){
        AtividadeFacade atividadeFacade = new AtividadeFacade();
        Date data = new Date();
        data = Formatacao.SomarDiasData(data, 3);
        String sql = "Select a from Atividades a where a.prazo='" + Formatacao.ConvercaoDataSql(data) + "' and a.concluida=" + isCheckConcluidas() + 
                " and a.usuario.idusuario=" + usuarioLogadoBean.getUsuario().getIdusuario() +
                " order by a.prazo, a.prioridade, a.nome";
        listaAtividadesTres = atividadeFacade.listar(sql);
        if(listaAtividadesTres==null){
            listaAtividadesTres = new ArrayList<Atividades>();
        }
        if (listaAtividadesTres.size()<10){
            tres= Formatacao.diaSemanaEscrito(data) + "  (0" + String.valueOf(listaAtividadesTres.size()) + ")";
        }else tres = Formatacao.diaSemanaEscrito(data) + " (" + String.valueOf(listaAtividadesTres.size()) + ")";
    }
    
    public String mostarAtividadesTres(){
        listaAtividadesGeral = listaAtividadesTres;
        Date data = new Date();
        data = Formatacao.SomarDiasData(data, 3);
        atividadeMenu="tres";
        titulo="Tarefas de " + Formatacao.diaSemanaEscrito(data);
        return "inicial";
    }
    
    public void listarAtividadesQuatro(){
        AtividadeFacade atividadeFacade = new AtividadeFacade();
        Date data = new Date();
        data = Formatacao.SomarDiasData(data, 4);
        String sql = "Select a from Atividades a where a.prazo='" + Formatacao.ConvercaoDataSql(data) + "' and a.concluida=" + isCheckConcluidas() + 
                " and a.usuario.idusuario=" + usuarioLogadoBean.getUsuario().getIdusuario() +
                " order by a.prazo, a.prioridade, a.nome";
        listaAtividadesQuatro = atividadeFacade.listar(sql);
        if(listaAtividadesQuatro==null){
            listaAtividadesQuatro = new ArrayList<Atividades>();
        }
        if (listaAtividadesQuatro.size()<10){
            quatro= Formatacao.diaSemanaEscrito(data) + "  (0" + String.valueOf(listaAtividadesQuatro.size()) + ")";
        }else quatro = Formatacao.diaSemanaEscrito(data) + " (" + String.valueOf(listaAtividadesQuatro.size()) + ")";
    }
    
    public String mostarAtividadesQuatro(){
        listaAtividadesGeral = listaAtividadesQuatro;
        Date data = new Date();
        data = Formatacao.SomarDiasData(data, 4);
        atividadeMenu="quatro";
        titulo="Tarefas de " + Formatacao.diaSemanaEscrito(data);
        return "inicial";
    }
    
    public void listarAtividadesCinco(){
        AtividadeFacade atividadeFacade = new AtividadeFacade();
        Date data = new Date();
        data = Formatacao.SomarDiasData(data, 5);
        String sql = "Select a from Atividades a where a.prazo='" + Formatacao.ConvercaoDataSql(data) + "' and a.concluida=" + isCheckConcluidas() + 
                " and a.usuario.idusuario=" + usuarioLogadoBean.getUsuario().getIdusuario() +
                " order by a.prazo, a.prioridade, a.nome";
        listaAtividadesCinco = atividadeFacade.listar(sql);
        if(listaAtividadesCinco==null){
            listaAtividadesCinco = new ArrayList<Atividades>();
        }
        if (listaAtividadesCinco.size()<10){
            cinco= Formatacao.diaSemanaEscrito(data) + "  (0" + String.valueOf(listaAtividadesCinco.size()) + ")";
        }else cinco = Formatacao.diaSemanaEscrito(data) + " (" + String.valueOf(listaAtividadesCinco.size()) + ")";
    }
    
    public String mostarAtividadesCinco(){
        listaAtividadesGeral = listaAtividadesCinco;
        Date data = new Date();
        data = Formatacao.SomarDiasData(data, 5);
        atividadeMenu="cinco";
        titulo="Tarefas de " + Formatacao.diaSemanaEscrito(data);
        return "inicial";
    }
    
    public void listarAtividadesSeis(){
        AtividadeFacade atividadeFacade = new AtividadeFacade();
        Date data = new Date();
        data = Formatacao.SomarDiasData(data, 6);
        String sql = "Select a from Atividades a where a.prazo='" + Formatacao.ConvercaoDataSql(data) + "' and a.concluida=" + isCheckConcluidas() + 
                " and a.usuario.idusuario=" + usuarioLogadoBean.getUsuario().getIdusuario() +
                " order by a.prazo, a.prioridade, a.nome";
        listaAtividadesSeis = atividadeFacade.listar(sql);
        if(listaAtividadesSeis==null){
            listaAtividadesSeis = new ArrayList<Atividades>();
        }
        if (listaAtividadesSeis.size()<10){
            seis= Formatacao.diaSemanaEscrito(data) + "  (0" + String.valueOf(listaAtividadesSeis.size()) + ")";
        }else seis = Formatacao.diaSemanaEscrito(data) + " (" + String.valueOf(listaAtividadesSeis.size()) + ")";
    }
    
    public String mostarAtividadesSeis(){
        listaAtividadesGeral = listaAtividadesSeis;
        Date data = new Date();
        data = Formatacao.SomarDiasData(data, 6);
        atividadeMenu="seis";
        titulo="Tarefas de " + Formatacao.diaSemanaEscrito(data);
        return "inicial";
    }
    
     public void listarAtividadesSete(){
        AtividadeFacade atividadeFacade = new AtividadeFacade();
        Date data = new Date();
        data = Formatacao.SomarDiasData(data, 7);
        String sql = "Select a from Atividades a where a.prazo='" + Formatacao.ConvercaoDataSql(data) + "' and a.concluida=" + isCheckConcluidas() + 
                " and a.usuario.idusuario=" + usuarioLogadoBean.getUsuario().getIdusuario() +
                " order by a.prazo, a.prioridade, a.nome";
        listaAtividadesSete = atividadeFacade.listar(sql);
        if(listaAtividadesSete==null){
            listaAtividadesSete = new ArrayList<Atividades>();
        }
        if (listaAtividadesSete.size()<10){
            sete= Formatacao.diaSemanaEscrito(data) + "  (0" + String.valueOf(listaAtividadesSete.size()) + ")";
        }else sete = Formatacao.diaSemanaEscrito(data) + " (" + String.valueOf(listaAtividadesSete.size()) + ")";
    }
    
    public String mostarAtividadesSete(){
        listaAtividadesGeral = listaAtividadesSete;
        Date data = new Date();
        data = Formatacao.SomarDiasData(data, 7);
        atividadeMenu="sete";
        titulo="Tarefas de " + Formatacao.diaSemanaEscrito(data);
        return "inicial";
    }
    
    public String verComentarios(){
        FacesContext fc = FacesContext.getCurrentInstance();
        Map<String,String> params = fc.getExternalContext().getRequestParameterMap();
        int idAtividade =  Integer.parseInt(params.get("id_atividades"));
        if (idAtividade>0){
            for (int i=0;i<listaAtividadesGeral.size();i++){
                if (idAtividade==listaAtividadesGeral.get(i).getIdatividades()){
                    linha = String.valueOf(i);
                    atividades = listaAtividadesGeral.get(i);
                    return null;
                }
            }
        }
        return null;
    }
    
    public String salvarComentario() throws SQLException{
        ComentariosFacade comentariosFacade = new ComentariosFacade();
        comentarios.setUsuario(getUsuarioLogadoBean().getUsuario());
        comentarios.setAtividades(atividades);
        comentarios.setData(new Date());
        comentarios.setHora(Formatacao.foramtarHoraString());
        comentariosFacade.salvar(comentarios);
        comentarios = new Comentarios();
        int nLinha = Integer.parseInt(linha);
        List<Comentarios> lista = comentariosFacade.listar(atividades.getIdatividades());
         if (atividadeMenu.equalsIgnoreCase("dia")){
            listaAtividadedia.get(nLinha).setComentariosList(lista);
        }else if (atividadeMenu.equalsIgnoreCase("semana")){
            listaAtividadeSemana.get(nLinha).setComentariosList(lista);
        }else if (atividadeMenu.equalsIgnoreCase("atrasada")){
            listaAtividadeAtrasada.get(nLinha).setComentariosList(lista);
        }else {
            listaAtividadesDepartamento.get(nLinha).setComentariosList(lista);
        }
         linha="0";
         atividades = new Atividades();
        carregarListaGeral();
        return null;
    }
    
    public void pegarLinha(String linha){
        this.linha = linha;
    }
    
    public String editar(){
        int nLinha= Integer.parseInt(linha);
        
        AtividadeFacade atividadeFacade = new AtividadeFacade();
        atividades = atividadeFacade.consultar(listaAtividadesGeral.get(nLinha).getIdatividades());
        idCliente = String.valueOf(atividades.getCliente().getIdcliente());
        idDepartamento = String.valueOf(listaAtividadesGeral.get(nLinha).getUsuario().getSubdepartamento().getDepartamento().getIddepartamento());
        gerarListaSubdepartamento();
        idSubdepartamento = String.valueOf(listaAtividadesGeral.get(nLinha).getUsuario().getSubdepartamento().getIdsubdepartamento());
        idUsuario = String.valueOf(listaAtividadesGeral.get(nLinha).getUsuario().getIdusuario());
        return "";
    }
    
    public String pesquisarNome(){
        listarTodasAtividades();
        return "tarefasTodas";
    
    } 
    public void quantidadeComentarios(){
        
    }
    
    public void iniciarAtividade(String linha){
        this.linha = linha;
        int nlinha = Integer.parseInt(linha);
        AtividadeFacade atividadeFacade = new AtividadeFacade();
        if (listaAtividadesGeral.get(nlinha).getEstado().equalsIgnoreCase("Play")){
            //Play
            Long inicio = new Date().getTime();
            listaAtividadesGeral.get(nlinha).setInicio(BigInteger.valueOf(inicio));
            listaAtividadesGeral.get(nlinha).setEstado("Pause");
            atividadeFacade.salvar(listaAtividadesGeral.get(nlinha));
        }else {
            //Pause
            Long termino = new Date().getTime();
            BigInteger valorInicio = listaAtividadesGeral.get(nlinha).getInicio();
            Long inicio = valorInicio.longValue();
            Long resultado = termino - inicio;
            resultado = resultado/1000;
            resultado = resultado/60;
            int tempo = resultado.intValue();
            int tempoAtual = listaAtividadesGeral.get(nlinha).getTempo();
            tempo = tempo + tempoAtual;
            listaAtividadesGeral.get(nlinha).setTempo(tempo);
            listaAtividadesGeral.get(nlinha).setEstado("Play");
            atividadeFacade.salvar(listaAtividadesGeral.get(nlinha));
        }
    }
    
    public String filtrarTarefasDepartamento(){
        String sql = "Select a From Atividades a where a.concluida=" + checkConcluidas;
        if (visualizar.equalsIgnoreCase("proxsete")){
            Date data7 = Formatacao.SomarDiasData(new Date(), 7);
            sql = sql + " and a.prazo>='" + Formatacao.ConvercaoDataSql(new Date()) + "' and a.prazo<='" 
                    + Formatacao.ConvercaoDataSql(data7) + "' ";
        }
        if (visualizar.equalsIgnoreCase("hoje")){
            sql = sql + " and a.prazo='" + Formatacao.ConvercaoDataSql(new Date()) + "' ";
        }
        if (visualizar.equalsIgnoreCase("atrasadas")){
            sql = sql + " and a.prazo<'" + Formatacao.ConvercaoDataSql(new Date()) + "' ";
        }
        if (!idDepartamento.equalsIgnoreCase("0")){
            sql = sql + " and a.subdepartamento.departamento.iddepartamento=" + Integer.parseInt(idDepartamento);
        }
        if (!idSubdepartamento.equalsIgnoreCase("0")){
            sql = sql + " and a.subdepartamento.idsubdepartamento=" + Integer.parseInt(idSubdepartamento);
        }
        if (!idCliente.equalsIgnoreCase("0")){
            sql = sql + " and a.cliente.idcliente=" + Integer.parseInt(idCliente);
        }
        if (!idUsuario.equalsIgnoreCase("0")){
            sql = sql + " and a.usuario.idusuario=" + Integer.parseInt(idUsuario);
        }
        sql = sql + " order by a.prazo, a.prioridade, a.nome";
        AtividadeFacade atividadeFacade = new AtividadeFacade();
        listaAtividadesDepartamento = atividadeFacade.listar(sql);
        listaAtividadesGeral = listaAtividadesDepartamento;
        if (listaAtividadesDepartamento.size() < 10) {
            ndepartamento = "Atividades (0" + String.valueOf(listaAtividadesDepartamento.size()) + ")";
        } else {
            ndepartamento = "Atividades (" + String.valueOf(listaAtividadesDepartamento.size()) + ")";
        }
        return "inicial";
    }
    public String carregarIcon(Atividades atividade){
        if (atividade.getEstado().equalsIgnoreCase("Play")) {
            return "ui-icon-play";
        }  else {
            return "ui-icon-pause";
        }
    }
    public String atrasadas(Atividades atividade) {
        Date data = new Date();
        String sData = Formatacao.ConvercaoDataPadrao(data);
        data = Formatacao.ConvercaoStringDataBrasil(sData);
        boolean bdata = atividade.getPrazo().before(data);
        if (bdata) {
            return "atrasado";
        } else {
            return "normal";
        }
    }
}

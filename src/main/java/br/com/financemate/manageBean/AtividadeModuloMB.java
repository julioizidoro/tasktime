package br.com.financemate.manageBean;

import br.com.financemate.facade.AtividadeFacade;
import br.com.financemate.facade.AtividadeModuloFacade;
import br.com.financemate.facade.AtividadeUsuarioFacade;
import br.com.financemate.facade.RotinaFacade;
import br.com.financemate.facade.RotinaclienteFacade;
import br.com.financemate.facade.SubdepartamentoFacade;
import br.com.financemate.model.Atividademodulo;
import br.com.financemate.model.Atividades;
import br.com.financemate.model.Atividadeusuario;
import br.com.financemate.model.Modulos;
import br.com.financemate.model.Projeto;
import br.com.financemate.model.Raci;
import br.com.financemate.model.Subdepartamento;
import java.io.Serializable;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.http.HttpSession;
import org.primefaces.context.RequestContext;
import org.primefaces.event.CellEditEvent;

@Named
@ViewScoped
public class AtividadeModuloMB implements Serializable{
    
    @Inject
    private UsuarioLogadoBean usuarioLogadoBean;
    @Inject
    private AtividadeMB atividadeMB;
    private Atividademodulo atividademodulo;
    private List<Atividademodulo> listaAtividadesModulo;
    private Modulos modulos;
    
    
    
    @PostConstruct
    public void init(){
        FacesContext fc = FacesContext.getCurrentInstance();
        HttpSession session = (HttpSession) fc.getExternalContext().getSession(false);
        modulos = (Modulos) session.getAttribute("modulos");
        session.removeAttribute("modulos");
        if (atividademodulo==null){
            atividademodulo = new Atividademodulo();
            atividademodulo.setModulos(modulos);
        }
        if (modulos!=null){
            gerarListaAtividades();
        }else{
            listaAtividadesModulo = new ArrayList<Atividademodulo>();
        }
    }

    public Atividademodulo getAtividademodulo() {
        return atividademodulo;
    }

    public void setAtividademodulo(Atividademodulo atividademodulo) {
        this.atividademodulo = atividademodulo;
    }

    public List<Atividademodulo> getListaAtividadesModulo() {
        return listaAtividadesModulo;
    }

    public void setListaAtividadesModulo(List<Atividademodulo> listaAtividadesModulo) {
        this.listaAtividadesModulo = listaAtividadesModulo;
    }

    public Modulos getModulos() {
        return modulos;
    }

    public void setModulos(Modulos modulos) {
        this.modulos = modulos;
    }

    public UsuarioLogadoBean getUsuarioLogadoBean() {
        return usuarioLogadoBean;
    }

    public void setUsuarioLogadoBean(UsuarioLogadoBean usuarioLogadoBean) {
        this.usuarioLogadoBean = usuarioLogadoBean;
    }

    public AtividadeMB getAtividadeMB() {
        return atividadeMB;
    }

    public void setAtividadeMB(AtividadeMB atividadeMB) {
        this.atividadeMB = atividadeMB;
    }
    
    
    
    
    public String novo(Modulos modulos){
        atividademodulo = new Atividademodulo();
        AtividadeModuloFacade atividadeModuloFacade = new AtividadeModuloFacade();
        atividademodulo.setDescricao("");
        atividademodulo.setDatafinal(new Date());
        atividademodulo.setDataInicio(new Date());
        atividademodulo.setSituacao("Ativo");
        atividademodulo.setModulos(modulos);
        atividadeModuloFacade.salvar(atividademodulo);
        modulos = atividademodulo.getModulos();
        FacesContext fc = FacesContext.getCurrentInstance();
        HttpSession session = (HttpSession) fc.getExternalContext().getSession(false);
        session.setAttribute("modulos", modulos);
        return "consAtividadeModulo";
    }
    
    public void gerarListaAtividades(){
        String sql = "Select a from Atividademodulo a where a.modulos.idmodulos=" + modulos.getIdmodulos();
        AtividadeModuloFacade atividadeModuloFacade = new AtividadeModuloFacade();
        listaAtividadesModulo = atividadeModuloFacade.lista(sql);
        if (listaAtividadesModulo==null){
            listaAtividadesModulo = new ArrayList<Atividademodulo>();
        }
    }
    
    
    public String raci(Atividademodulo atividadesmodulo){
        FacesContext fc = FacesContext.getCurrentInstance();
        HttpSession session = (HttpSession) fc.getExternalContext().getSession(false);
        session.setAttribute("atividademodulo", atividadesmodulo);
        RequestContext.getCurrentInstance().openDialog("RACI");
        return "";
        
    }
    
    public String voltar(Projeto projeto){
        projeto = modulos.getProjeto();
        FacesContext fc = FacesContext.getCurrentInstance();
        HttpSession session = (HttpSession) fc.getExternalContext().getSession(false);
        session.setAttribute("projeto", projeto);
        return "consModulo";
    }
    
    public void salvarAtividade(CellEditEvent event, Atividademodulo atividademodulos){
        AtividadeFacade atividadeFacade = new AtividadeFacade();
        Projeto projeto = new Projeto();
        projeto = atividademodulos.getModulos().getProjeto();
        Atividades atividades = new Atividades();
        atividades.setCliente(projeto.getCliente());
        atividades.setNome(atividademodulos.getDescricao());
        atividades.setPrioridade("normal");
        atividades.setTipo("R");
        atividades.setEstado("Play");
        atividades.setInicio(BigInteger.valueOf(0));
        atividades.setTempo(0);
        atividades.setMostratempo("00:00");
        atividades.setPrazo(atividademodulos.getDatafinal());
        Atividadeusuario atividadeusuario = new Atividadeusuario();
        atividadeusuario.setAtividades(atividades);
        atividadeusuario.setParticipacao("Executor");
        atividadeusuario.setSituacao(false);
        for(int i=0;i<atividademodulos.getRaciList().size();i++){
            if(atividademodulos.getRaciList().get(i).getR()){
                atividadeusuario.setUsuario(atividademodulos.getRaciList().get(i).getMembros().getUsuario());
                atividades.setSubdepartamento(atividademodulos.getRaciList().get(i).getMembros().getUsuario().getSubdepartamento());
            }
            if(atividademodulos.getRaciList().get(i).getR()==Boolean.FALSE){
                atividadeusuario.setUsuario(usuarioLogadoBean.getUsuario());
                atividades.setSubdepartamento(usuarioLogadoBean.getUsuario().getSubdepartamento());
            }
        }
        if(atividademodulos.getRaciList().size()==0){
            atividadeusuario.setUsuario(usuarioLogadoBean.getUsuario());
            atividades.setSubdepartamento(usuarioLogadoBean.getUsuario().getSubdepartamento());
        }
        AtividadeUsuarioFacade atiUsuarioFacade = new AtividadeUsuarioFacade();
        atiUsuarioFacade.salvar(atividadeusuario);
        atividades = atividadeFacade.salvar(atividades);
        AtividadeModuloFacade atividadeModuloFacade = new AtividadeModuloFacade();
        atividadeModuloFacade.salvar(atividademodulos);
        atividadeMB.listarAtividadesDia();
        atividadeMB.listarAtividadesAtrasadas();
        atividadeMB.listarAtividadesDepartamento();
        atividadeMB.listarAtividadesSemana();
        atividadeMB.listarAtividadesAmanha();
        atividadeMB.listarAtividadesDois();
        atividadeMB.listarAtividadesTres();
        atividadeMB.listarAtividadesQuatro();
        atividadeMB.listarAtividadesCinco();
        atividadeMB.listarAtividadesSeis();
        atividadeMB.listarAtividadesSete();
        atividadeMB.listarTodasAtividades();
        atividademodulo = new Atividademodulo();
    }
    
}

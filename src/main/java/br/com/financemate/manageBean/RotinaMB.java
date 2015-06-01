/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.financemate.manageBean;

import br.com.financemate.bean.Formatacao;
import br.com.financemate.bean.RotinaBean;
import br.com.financemate.facade.AtividadeFacade;
import br.com.financemate.facade.ClienteFacade;
import br.com.financemate.facade.RotinaFacade;
import br.com.financemate.facade.RotinaclienteFacade;
import br.com.financemate.facade.SubdepartamentoFacade;
import br.com.financemate.facade.UsuarioFacade;
import br.com.financemate.model.Atividades;
import br.com.financemate.model.Cliente;
import br.com.financemate.model.Rotina;
import br.com.financemate.model.Rotinacliente;
import br.com.financemate.model.Subdepartamento;
import br.com.financemate.model.Usuario;
import java.io.Serializable;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author Kamila
 */
@Named("RotinaMB")
@SessionScoped
public class RotinaMB  implements Serializable{
    
    @Inject
    private UsuarioLogadoBean usuarioLogadoBean;
    private RotinaBean rotinabean;
    private Rotina rotina;
    private String nomeRotina;
    private List<Subdepartamento> listaSubdepartamento;
    private String idSubdepartamento;
    private List<Usuario> listaUsuario;
    private String idUsuario="0";
    private List<RotinaBean> listaRotinabean;
    private List<Rotina> listaRotina;
    private String idRotina;
    
    public RotinaMB()  {
        rotina = new Rotina();
        gerarListaSubdepartamento();
    }

    public UsuarioLogadoBean getUsuarioLogadoBean() {
        return usuarioLogadoBean;
    }

    public void setUsuarioLogadoBean(UsuarioLogadoBean usuarioLogadoBean) {
        this.usuarioLogadoBean = usuarioLogadoBean;
    }

    public Rotina getRotina() {
        return rotina;
    }

    public void setRotina(Rotina rotina) {
        this.rotina = rotina;
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

    public List<RotinaBean> getListaRotinabean()  {
        if(listaRotinabean==null){
            gerarListaRotinaBean();
        }
        return listaRotinabean;
    }

    public void setListaRotinabean(List<RotinaBean> listaRotinabean) {
        this.listaRotinabean = listaRotinabean;
    }
    

    public String getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(String idUsuario) {
        this.idUsuario = idUsuario;
    }

    public RotinaBean getRotinabean() {
        return rotinabean;
    }

    public void setRotinabean(RotinaBean rotinabean) {
        this.rotinabean = rotinabean;
    }
    
    
    
    public String getNomeRotina() {
        return nomeRotina;
    }

    public void setNomeRotina(String nomeRotina) {
        this.nomeRotina = nomeRotina;
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

  
    public String getIdSubdepartamento() {
        return idSubdepartamento;
    }

    public void setIdSubdepartamento(String idSubdepartamento) {
        this.idSubdepartamento = idSubdepartamento;
    }

    public List<Rotina> getListaRotina() {
        if(listaRotina==null){
            gerarListaRotina();
        }
        return listaRotina;
    }

    public void setListaRotina(List<Rotina> listaRotina) {
        this.listaRotina = listaRotina;
    }

    public String getIdRotina() {
        return idRotina;
    }

    public void setIdRotina(String idRotina) {
        this.idRotina = idRotina;
    }
    
    public void gerarListaRotina()  {
        if (nomeRotina == null) {
            nomeRotina = "";
        }
        RotinaFacade rotinaFacade = new RotinaFacade();
        listaRotina = rotinaFacade.listar(nomeRotina);
        if (listaRotina == null) {
            listaRotina = new ArrayList<Rotina>();
        }
    }
    
    
    public void gerarListaRotinaBean() {
        listaRotinabean = new ArrayList<RotinaBean>();
        List<Cliente> listaCliente = gerarListaCliente();
        if(listaCliente!=null){
          for(int i=0;i<listaCliente.size();i++){
              RotinaBean rb = new RotinaBean();
              rb.setCliente(listaCliente.get(i));
              rb.setRotinacliente(new Rotinacliente());
              rb.setRotinafixa(new Rotinacliente());
              listaRotinabean.add(rb);
          }
        }
    }
    
    public void gerarListaRotinaBeanEditar(){
        listaRotinabean = new ArrayList<RotinaBean>();
        List<Cliente> listaCliente = gerarListaCliente();
        RotinaclienteFacade rotinaclienteFacade = new RotinaclienteFacade();
        if(listaCliente!=null){
          for(int i=0;i<listaCliente.size();i++){
              RotinaBean rb = new RotinaBean();
              rb.setCliente(listaCliente.get(i));
              Rotinacliente rc = rotinaclienteFacade.getRotinaCliente(listaCliente.get(i).getIdcliente(), rotina.getIdrotina());
              if (rc!=null){
                  rb.setRotinacliente(rc);
                  rb.setRotinafixa(rc);
              }else {
                  rb.setRotinacliente(new Rotinacliente());
                  rb.setRotinafixa(new Rotinacliente());
              }
              rb.setRotinacliente(new Rotinacliente());
              listaRotinabean.add(rb);
          }
        }
    }
    
    public String pesquisarNome(){
        gerarListaRotina();
        return "consRotina";
    }
    
    public String novo() {
        rotina = new Rotina();
        gerarListaSubdepartamento();
        gerarListaRotinaBean();
        gerarListaUsuario();
        return "cadRotina";
    }
    
    
    public String salvar() {
        if (rotina.getIdrotina()==null){
            salvarNovaRotina();
        }else salvarEditarRotina();
        rotina = new Rotina();
        gerarListaRotina();
        return "consRotina";
    }
    
    public void salvarEditarRotina()  {
        RotinaFacade rotinaFacade = new RotinaFacade();
        RotinaclienteFacade rotinaclienteFacade = new RotinaclienteFacade();
        SubdepartamentoFacade subdepartamentoFacade = new SubdepartamentoFacade();
        Subdepartamento subddepartamento = subdepartamentoFacade.consultar(Integer.parseInt(idSubdepartamento));
        rotina.setSubdepartamento(subddepartamento);
        rotina = rotinaFacade.salvar(rotina);
        for (int i = 0; i < listaRotinabean.size(); i++) {
            boolean alterado = false;
            Rotinacliente rc = new Rotinacliente();
            Rotinacliente fixa = listaRotinabean.get(i).getRotinafixa();
            if (rc.getIdrotinacliente() != null) {
                if (listaRotinabean.get(i).isSelecionado()) {
                    rc = listaRotinabean.get(i).getRotinacliente();
                    if (!rc.getData().equals(fixa.getData())) {
                        alterado = true;
                    }
                    if (!rc.getPeriodicidade().equalsIgnoreCase(fixa.getPeriodicidade())) {
                        alterado = true;
                    }
                    if (alterado) {
                        AtividadeFacade atividadesFacade = new AtividadeFacade();
                        String sql = "Select a from Atividades a where a.prazo>" + Formatacao.ConvercaoDataSql(new Date())
                                + "  and a.concluida=FALSE and a.idrotina=" + rotina.getIdrotina() + " and a.cliente.idcliente=" + rc.getCliente().getIdcliente()
                                + " order by a.prioridade, a.nome";
                        List<Atividades> listaAtividade = atividadesFacade.listar(sql);
                        if (listaAtividade != null) {
                            for (int n = 0; n < listaAtividade.size(); i++) {
                                atividadesFacade.Excluir(listaAtividade.get(n).getIdatividades());
                            }
                        }
                        if (rc.getPeriodicidade().equalsIgnoreCase("diaria")) {
                            rc.setData(criarAtividadesDiaria(rotinabean));
                        } else if (rc.getPeriodicidade().equalsIgnoreCase("semanal")) {
                            rc.setData(criarAtividadesSemanal(rotinabean));
                        } else {
                            criarAtividadeMensalTrimestralAnual(rotinabean);
                        }
                    }
                    rc.setCliente(listaRotinabean.get(i).getCliente());
                    rc.setRotina(rotina);
                    rotinaclienteFacade.salvar(rc);
                } else {
                    AtividadeFacade atividadesFacade = new AtividadeFacade();
                    String sql = "Select a from Atividades a where a.prazo>" + Formatacao.ConvercaoDataSql(new Date())
                            + "  and a.concluida=FALSE and a.idrotina=" + rotina.getIdrotina() + " and a.cliente.idcliente=" + rc.getCliente().getIdcliente()
                            + " order by a.prioridade, a.nome";
                    List<Atividades> listaAtividade = atividadesFacade.listar(sql);
                    if (listaAtividade != null) {
                        for (int n = 0; n < listaAtividade.size(); i++) {
                            atividadesFacade.Excluir(listaAtividade.get(n).getIdatividades());
                        }
                    }
                }
            }else {
                if (listaRotinabean.get(i).isSelecionado()) {
                    rc = listaRotinabean.get(i).getRotinacliente();
                    rc.setCliente(listaRotinabean.get(i).getCliente());
                    rc.setRotina(rotina);
                    if (rc.getPeriodicidade().equalsIgnoreCase("diaria")) {
                        rc.setData(criarAtividadesDiaria(rotinabean));
                    } else if (rc.getPeriodicidade().equalsIgnoreCase("semanal")) {
                        rc.setData(criarAtividadesSemanal(rotinabean));
                    } else  {
                        criarAtividadeMensalTrimestralAnual(rotinabean);
                    } 
                    rotinaclienteFacade.salvar(rc);
                }
            }
        }
    }

    public void salvarNovaRotina() {
        RotinaFacade rotinaFacade = new RotinaFacade();
        RotinaclienteFacade rotinaclienteFacade = new RotinaclienteFacade();
        SubdepartamentoFacade subdepartamentoFacade = new SubdepartamentoFacade();
        Subdepartamento subddepartamento = subdepartamentoFacade.consultar(Integer.parseInt(idSubdepartamento));
        rotina.setSubdepartamento(subddepartamento);
        rotina = rotinaFacade.salvar(rotina);
        for (int i=0;i<listaRotinabean.size();i++){
            if (listaRotinabean.get(i).isSelecionado()){
                Rotinacliente rc = new Rotinacliente();
                rc = listaRotinabean.get(i).getRotinacliente();
                rc.setCliente(listaRotinabean.get(i).getCliente());
                rc.setRotina(rotina);
                if (rc.getPeriodicidade().equalsIgnoreCase("diaria")) {
                    rc.setData(criarAtividadesDiaria(listaRotinabean.get(i)));
                } else if (rc.getPeriodicidade().equalsIgnoreCase("semanal")) {
                    rc.setData(criarAtividadesSemanal(listaRotinabean.get(i)));
                } else {
                    criarAtividadeMensalTrimestralAnual(listaRotinabean.get(i));
                } 
                rotinaclienteFacade.salvar(rc);
            }
        }
    }
    
    public String editar()  {
        gerarListaSubdepartamento();
        gerarListaRotinaBean();
        gerarListaUsuario();
        return "cadRotina";
    }
    
    public void gerarListaSubdepartamento()  {
            SubdepartamentoFacade subdepartamentoFacade = new SubdepartamentoFacade();
            listaSubdepartamento = subdepartamentoFacade.listar("");
            if (listaSubdepartamento == null) {
                listaSubdepartamento = new ArrayList<Subdepartamento>();
            }
    }
    
    public List<Cliente> gerarListaCliente() {
        ClienteFacade clienteFacade = new ClienteFacade();
        List<Cliente> listaCliente = clienteFacade.listar("");
        if (listaCliente==null){
            listaCliente = new ArrayList<Cliente>();
        }
        return listaCliente;
    }
    
    public void gerarListaUsuario() {
        UsuarioFacade usuarioFacade = new UsuarioFacade();
        listaUsuario = usuarioFacade.listar("");
        if (listaUsuario==null){
            listaUsuario = new ArrayList<Usuario>();
        }
    }
    
    public void gravarusuario(String linha){
        UsuarioFacade usuarioFacade = new UsuarioFacade();
        Usuario usuario = usuarioFacade.consultar(Integer.parseInt(idUsuario));
        listaRotinabean.get(Integer.parseInt(linha)).getRotinacliente().setUsuario(usuario);
        
    }
    
    public Date criarAtividadesDiaria(RotinaBean rotinaBean) {
        AtividadeFacade atividadeFacade = new AtividadeFacade();
        Date data = rotinaBean.getRotinacliente().getData();
        for (int i=0;i<7;i++){
            Atividades atividades = new Atividades();
            atividades.setCliente(rotinaBean.getCliente());
            atividades.setConcluida(false);
            atividades.setIdrotina(rotina.getIdrotina());
            atividades.setNome(rotina.getNome());
            atividades.setPrioridade("Normal");
            atividades.setSubdepartamento(rotina.getSubdepartamento());
            atividades.setUsuario(rotinaBean.getRotinacliente().getUsuario());
            atividades.setPrazo(data);
            data = Formatacao.SomarDiasData(data, 1);
            int diaSemana = Formatacao.diaSemana(data);
            if (diaSemana==0){
                data = Formatacao.SomarDiasData(data, 1);
            }else if (diaSemana==6){
                data = Formatacao.SomarDiasData(data, 2);
            }
            atividadeFacade.salvar(atividades);
        }
        return data;
    }
    
    public Date criarAtividadesSemanal(RotinaBean rotinaBean) {
        AtividadeFacade atividadeFacade = new AtividadeFacade();
        Date data = rotinaBean.getRotinacliente().getData();
        int diaSemana = Formatacao.diaSemana(data);    
        for (int i=0;i<3;i++){
            Atividades atividades = new Atividades();
            atividades.setCliente(rotinaBean.getCliente());
            atividades.setConcluida(false);
            atividades.setIdrotina(rotina.getIdrotina());
            atividades.setNome(rotina.getNome());
            atividades.setPrioridade("Normal");
            atividades.setSubdepartamento(rotina.getSubdepartamento());
            atividades.setUsuario(rotinaBean.getRotinacliente().getUsuario());
            atividades.setPrazo(data);
            atividadeFacade.salvar(atividades);
            int novoDiaSemana = -1;
            while (diaSemana!=novoDiaSemana){
                data = Formatacao.SomarDiasData(data, 1);
                novoDiaSemana = Formatacao.diaSemana(data);
            }
        }
        return data;
    }
    
    
    
    public void criarAtividadeMensalTrimestralAnual(RotinaBean rotinaBean) {
        AtividadeFacade atividadeFacade = new AtividadeFacade();
        Atividades atividades = new Atividades();
        atividades.setCliente(rotinaBean.getCliente());
        atividades.setConcluida(false);
        atividades.setIdrotina(rotina.getIdrotina());
        atividades.setNome(rotina.getNome());
        atividades.setPrioridade("Normal");
        atividades.setSubdepartamento(rotina.getSubdepartamento());
        atividades.setUsuario(rotinaBean.getRotinacliente().getUsuario());
        atividades.setPrazo(rotinaBean.getRotinacliente().getData());
        atividadeFacade.salvar(atividades);
    }
}

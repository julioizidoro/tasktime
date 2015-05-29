package br.com.financemate.bean;

import br.com.financemate.model.Cliente;
import br.com.financemate.model.Rotinacliente;

/**
 *
 * @author Kamila
 */
public class RotinaBean {
    
    private Cliente cliente;
    private Rotinacliente rotinacliente;

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Rotinacliente getRotinacliente() {
        return rotinacliente;
    }

    public void setRotinacliente(Rotinacliente rotinacliente) {
        this.rotinacliente = rotinacliente;
    }
    
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.financemate.converter;

import br.com.financemate.model.Subdepartamento;
import java.util.Iterator;
import java.util.List;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

/**
 *
 * @author Wolverine
 */
@FacesConverter(value="subDepartamentoConverter")
public class SubDepartamentoConverter implements Converter{

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        List<Subdepartamento> subdepartamentos = (List<Subdepartamento>) component.getAttributes().get("listaSubDepartamento");
        for (Iterator<Subdepartamento> iterator = subdepartamentos.iterator(); iterator.hasNext();) {
            Subdepartamento sub = (Subdepartamento) iterator.next();
            if (sub.getNome().equals(value)) {
                return sub;
            }
        }
        return null;

    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        Subdepartamento subdepartamento = (Subdepartamento) value;
        return subdepartamento.getNome();

    }

}

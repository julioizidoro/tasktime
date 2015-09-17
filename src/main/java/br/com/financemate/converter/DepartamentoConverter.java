/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.financemate.converter;

import br.com.financemate.model.Departamento;
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
@FacesConverter(value="departamentoConverter")
public class DepartamentoConverter implements Converter{

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        List<Departamento> departamentos = (List<Departamento>) component.getAttributes().get("listaDepartamento");
        for (Iterator<Departamento> iterator = departamentos.iterator(); iterator.hasNext();) {
            Departamento sub = (Departamento) iterator.next();
            if (sub.getNome().equals(value)) {
                return sub;
            }
        }
        return null;

    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        Departamento departamento = (Departamento) value;
        return departamento.getNome();

    }

}

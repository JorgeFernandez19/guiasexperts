package com.guiasexperts.uth.data.entity;

import java.util.List;

import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRField;

public class ClientesReport implements JRDataSource{
	
	private List<Clientes> datos;
	private int counter = -1;
	private int maxCounter = 0;
	
	public void setData(List<Clientes> datos) {
		this.datos = datos;
		this.maxCounter = this.datos.size() -1;
		
	}



	public List<Clientes> getDatos() {
		return datos;
	}



	public void setDatos(List<Clientes> datos) {
		this.datos = datos;
	}



	public int getCounter() {
		return counter;
	}



	public void setCounter(int counter) {
		this.counter = counter;
	}



	public int getMaxCounter() {
		return maxCounter;
	}



	public void setMaxCounter(int maxCounter) {
		this.maxCounter = maxCounter;
	}



	@Override
	public boolean next() throws JRException {
		if(counter < maxCounter) {
			counter++;
			return true;
		}
		


		
		return false;
	}



	@Override
	public Object getFieldValue(JRField jrField) throws JRException {
		if("NOMBRE".equals(jrField.getName())){
			return datos.get(counter).getNombre().toString();
		}else if("EDAD".equals(jrField.getName())) {
			return datos.get(counter).getEdad().toString();
		}else if("TELEFONO".equals(jrField.getName())) {
			return datos.get(counter).getTelefono().toString();
		}else if("DIRECCION".equals(jrField.getName())) {
			return datos.get(counter).getDireccion().toString();
		
			
		}
	
		return "";
}
}

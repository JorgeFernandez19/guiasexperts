package com.guiasexperts.uth.data.cotroller;

import java.io.IOException;

import com.guiasexperts.uth.data.entity.SamplePerson;
import com.guiasexperts.uth.data.service.guiasexpertsRepositoryImpl;
import com.guiasexperts.uth.views.registro.registroViewModel;



public class SamplePersonInteractorImpl implements SamplePersonInteractor {
	private guiasexpertsRepositoryImpl modelo;
	private registroViewModel vista;

	
//	public SamplePersonInteractorImpl (regitroViewModel vista) {
//		super ();
//		this.modelo = guiasexpertsRepositoryImpl.getInstance("https://apex.oracle.com", 600000L);
//	    this.vista = vista;
//	
//	}


@Override
public void crearNuevoClientes(SamplePerson nuevo) {
	try {
		boolean respuesta = this.modelo.CreateCustomerSP(nuevo);
		this.vista.mostrarMesajeCreacion(respuesta);
			
		

	}catch (IOException e) {
	e.printStackTrace();
	}
	
	
}


		
	}









		
	


	
		

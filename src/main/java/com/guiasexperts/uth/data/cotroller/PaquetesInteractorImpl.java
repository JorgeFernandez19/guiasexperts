package com.guiasexperts.uth.data.cotroller;

import java.io.IOException;

import com.guiasexperts.uth.data.entity.ResponseCustomer;
import com.guiasexperts.uth.data.service.guiasexpertsRepositoryImpl;
import com.guiasexperts.uth.views.paqueteshn.paquetesViewModel;


	public class PaquetesInteractorImpl implements CustomerInteractor {
		
	private guiasexpertsRepositoryImpl modelo;
    private paquetesViewModel vista;
	
	public PaquetesInteractorImpl (paquetesViewModel vista) {
		super ();
		this.modelo = guiasexpertsRepositoryImpl.getInstance("https://apex.oracle.com", 600000L);
	this.vista = vista;
	
	}

	
	
	

	@Override
	public void consultarPaquetes() {
		try {
			ResponseCustomer respuesta = this.modelo.getCustomer();
			//this.vista.refrescarGridPaquetes(respuesta.getCount());
			
			

		}catch (IOException e) {
		e.printStackTrace();
		
		
			
		
		
	
	

	}

		}





	@Override
	public void consultarClientes() {
		// TODO Auto-generated method stub
		
	}


	}


	
		

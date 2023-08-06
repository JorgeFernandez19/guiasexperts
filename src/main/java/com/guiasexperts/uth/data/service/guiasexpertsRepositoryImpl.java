package com.guiasexperts.uth.data.service;

import java.io.IOException;

import com.guiasexperts.uth.data.entity.Clientes;
import com.guiasexperts.uth.data.entity.ResponseCustomer;
import com.guiasexperts.uth.data.entity.ResponsePaquetes;
import com.guiasexperts.uth.data.entity.SamplePerson;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Response;



public class guiasexpertsRepositoryImpl {
	
	
	private static guiasexpertsRepositoryImpl instance;
	private RepositoryClient client;
	
	private guiasexpertsRepositoryImpl (String url, Long timeout) {
		this.client = new RepositoryClient (url, timeout);
		
		
	}
	//IMPLEMENTANDO PATRÓN SINGLETON
	public static guiasexpertsRepositoryImpl getInstance(String url, Long timeout) {
		
		if(instance == null) {
			synchronized (guiasexpertsRepositoryImpl.class) {
			if(instance == null) {
				instance = new guiasexpertsRepositoryImpl (url, timeout);
					
			}
		}
	}
return instance;
	
}


public ResponseCustomer getCustomer () throws IOException {
	
	Call<ResponseCustomer> call = client.getDatabaseService().obtenerClientes();
	Response<ResponseCustomer> response = call.execute(); //aqui donde se consulta a la URL DE LA BASE DE DATOS
	
	if(response.isSuccessful()) {
		return response.body();
	}else {
		return null;

	
	}
	

}
public ResponsePaquetes getPaquetes () throws IOException {
	
	Call<ResponsePaquetes> call = client.getDatabaseService().obtenerPaquetes();
	Response<ResponsePaquetes> response =  call.execute();                           //aqui donde se consulta a la URL DE LA BASE DE DATOS
	
	if(response.isSuccessful()) {
		return response.body();
	}else {
		return null;


	}
}
public boolean CreateCustomer (Clientes nuevo) throws IOException {
	
	Call<ResponseBody> call = client.getDatabaseService().CrearClientes(nuevo);
	Response<ResponseBody> response = call.execute(); //aqui donde se consulta a la URL DE LA BASE DE DATOS
	
		return response.isSuccessful();

	
	}
	
public boolean CreateCustomerSP (SamplePerson nuevo) throws IOException {
	
	Call<ResponseBody> call = client.getDatabaseService().CrearClientesSP(nuevo);
	Response<ResponseBody> response = call.execute(); //aqui donde se consulta a la URL DE LA BASE DE DATOS
	

		return response.isSuccessful();

	
	}

}



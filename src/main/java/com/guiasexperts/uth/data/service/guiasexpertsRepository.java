package com.guiasexperts.uth.data.service;


import com.guiasexperts.uth.data.entity.Clientes;
import com.guiasexperts.uth.data.entity.ResponseCustomer;
import com.guiasexperts.uth.data.entity.ResponsePaquetes;
import com.guiasexperts.uth.data.entity.SamplePerson;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.POST;

public interface guiasexpertsRepository {
	
	@Headers({
	    "Content-Type: application/json",
	    "Accept-Charset:utf-8",
	    "User-Agent: Retrofit-Sample-App"
	})
	
	@GET("/pls/apex/jorgefernandez_pv2_2023/guiasexperts/clientes/")
	Call<ResponseCustomer> obtenerClientes();
	
	
	//https://apex.oracle.com/pls/apex/jorgefernandez_pv2_2023/guiasexperts/clientes/
	//https://apex.oracle.com/pls/apex/jorgefernandez_pv2_2023/guiasexperts/clientes/
	//https://apex.oracle.com/pls/apex/jorgefernandez_pv2_2023/guiasexperts/clientes/
		@Headers({
		    "Content-Type: application/json",
		    "Accept-Charset:utf-8",
		    "User-Agent: Retrofit-Sample-App"
		})
		
		@POST("/pls/apex/jorgefernandez_pv2_2023/guiasexperts/clientes/")
		Call<ResponseBody> CrearClientes(@Body Clientes nuevo);
		
		@Headers({
		    "Content-Type: application/json",
		    "Accept-Charset:utf-8",
		    "User-Agent: Retrofit-Sample-App"
		})
		
	
		@POST("/pls/apex/jorgefernandez_pv2_2023/guiasexperts/clientes/")
		Call<ResponseBody> CrearClientesSP(@Body SamplePerson nuevo);
	
	@Headers({
	    "Content-Type: application/json",
	    "Accept-Charset:utf-8",
	    "User-Agent: Retrofit-Sample-App"
	})
	
	@GET("/pls/apex/jorgefernandez_pv2_2023/guiasexperts/paquetes/")
	Call<ResponsePaquetes> obtenerPaquetes();


	
	
	


}

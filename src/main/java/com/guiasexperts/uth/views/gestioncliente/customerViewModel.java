package com.guiasexperts.uth.views.gestioncliente;

import java.util.List;

import com.guiasexperts.uth.data.entity.Clientes;

public interface customerViewModel {
	
	void refrescarGridClientes(List<Clientes> clientes);
	void mostrarMesajeCreacion(boolean exito );

}
//void refrescarGridEmpleados(List<Clientes>clientes);
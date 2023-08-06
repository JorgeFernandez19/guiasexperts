package com.guiasexperts.uth.views.registro;

import java.util.List;


import com.guiasexperts.uth.data.entity.SamplePerson;

public interface registroViewModel {
	
	void refrescarGridClientes(List<SamplePerson> SamplePerson);
	void mostrarMesajeCreacion(boolean exito );


}
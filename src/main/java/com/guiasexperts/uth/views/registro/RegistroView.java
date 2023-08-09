package com.guiasexperts.uth.views.registro;


import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.orm.ObjectOptimisticLockingFailureException;


import com.guiasexperts.uth.data.cotroller.SamplePersonInteractor;
import com.guiasexperts.uth.data.cotroller.SamplePersonInteractorImpl;
import com.guiasexperts.uth.data.entity.Clientes;
import com.guiasexperts.uth.data.entity.SamplePerson;

import com.guiasexperts.uth.data.service.SamplePersonService;
import com.guiasexperts.uth.views.MainLayout;
import com.guiasexperts.uth.views.gestioncliente.GestionClienteView;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.dependency.Uses;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.H3;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.notification.NotificationVariant;
import com.vaadin.flow.component.notification.Notification.Position;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.BeforeEnterEvent;
import com.vaadin.flow.router.BeforeEnterObserver;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.router.RouteAlias;
import com.vaadin.flow.server.auth.AnonymousAllowed;

@PageTitle("Registro")
@Route(value = "person-form", layout = MainLayout.class)
@RouteAlias(value = "", layout = MainLayout.class)
@AnonymousAllowed
@Uses(Icon.class)

public class RegistroView extends Div implements BeforeEnterObserver,registroViewModel {

    private TextField nombre = new TextField("Nombre");
    private TextField edad = new TextField("Edad");
    private TextField telefono = new TextField("Telefono");
    private TextField direccion = new TextField("Direccion");
    private List<Clientes> datos;

    private Button cancel = new Button("Cancelar");
    private Button save = new Button("Guardar");

//    private Binder<SamplePerson> binder = new Binder<>(SamplePerson.class);
	private SamplePerson samplePerson;
	   private  SamplePersonService SamplePersonService;
	    private SamplePersonInteractor controlador;

    public RegistroView(SamplePersonService personService) {
    
         this.datos = new ArrayList<>();
        addClassName("registro-view");
  

        add(createTitle());
        add(createFormLayout());
        add(createButtonLayout());

//        binder.bindInstanceFields(this);
//        clearForm();

//        cancel.addClickListener(e -> clearForm());
        save.addClickListener(e -> {
        	 try {

        	     if (this.samplePerson == null) {
                     
                     this.samplePerson = new SamplePerson();
                     this.samplePerson.setNombre(nombre.getValue());
                     this.samplePerson.setEdad(edad.getValue());
                     this.samplePerson.setTelefono(telefono.getValue());
                     this.samplePerson.setDireccion(direccion.getValue());
                     
                     
                    this.controlador.crearNuevoClientes(samplePerson);
               }
                 
                 
                // binder.writeBean(this.clientes);
               //  clientesService.update(this.clientes);
          
//                 clearForm();
//                 refreshGrid();
                 Notification.show("Data updated");
                 UI.getCurrent().navigate(GestionClienteView.class);
             } catch (ObjectOptimisticLockingFailureException exception) {
                 Notification n = Notification.show(  "Error updating the data. Somebody else has updated the record while you were making changes.");
                 n.setPosition(Position.MIDDLE);
                 n.addThemeVariants(NotificationVariant.LUMO_ERROR);
               
             }
               });
         
    }

  /*  private void clearForm() {
        binder.setBean(new SamplePerson());
    }
*/
    private Component createTitle() {
        return new H3("Informacion Personal");
    }

    private Component createFormLayout() {
        FormLayout formLayout = new FormLayout();
//        email.setErrorMessage("Please enter a valid email address");
        formLayout.add(nombre,edad,telefono,direccion);
        return formLayout;
    }

    private Component createButtonLayout() {
        HorizontalLayout buttonLayout = new HorizontalLayout();
        buttonLayout.addClassName("button-layout");
        save.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
        buttonLayout.add(save);
        buttonLayout.add(cancel);
        return buttonLayout;
    }
    
	
	@Override
	public void beforeEnter(BeforeEnterEvent event) {
		// TODO Auto-generated method stub
		
	}
    public void mostrarMesajeCreacion(boolean exito) {
	String mensajeMostrar = "Cliente creado exitosamente!";
	
	if(!exito) {
		mensajeMostrar = "Cliente no pudo ser creado :(!";
	}
	Notification.show(mensajeMostrar);
		
	}

		
	}

	

	

	
	



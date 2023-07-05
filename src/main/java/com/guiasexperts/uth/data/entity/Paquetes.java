package com.guiasexperts.uth.data.entity;

import jakarta.persistence.Entity;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
public class Paquetes extends AbstractEntity {

    private String destino;
    private LocalDate duracion;
    private LocalDateTime alojamiento;
    private Integer precio;

    public String getDestino() {
        return destino;
    }
    public void setDestino(String destino) {
        this.destino = destino;
    }
    public LocalDate getDuracion() {
        return duracion;
    }
    public void setDuracion(LocalDate duracion) {
        this.duracion = duracion;
    }
    public LocalDateTime getAlojamiento() {
        return alojamiento;
    }
    public void setAlojamiento(LocalDateTime alojamiento) {
        this.alojamiento = alojamiento;
    }
    public Integer getPrecio() {
        return precio;
    }
    public void setPrecio(Integer precio) {
        this.precio = precio;
    }

}

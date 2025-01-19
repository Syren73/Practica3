package main.java.edu.ucam.domain;

import edu.ucam.constantes.TipoHabilidad;

public class Habilidad {
public Habilidad(String nombre, int daño, TipoHabilidad tipo) {
		super();
		this.nombre = nombre;
		this.daño = daño;
		this.tipo = tipo;
	}

String nombre;
int daño;
TipoHabilidad tipo;
public String getNombre() {
	return nombre;
}
public void setNombre(String nombre) {
	this.nombre = nombre;
}
public int getDaño() {
	return daño;
}
public void setDaño(int daño) {
	this.daño = daño;
}
public TipoHabilidad getTipo() {
	return tipo;
}
public void setTipo(TipoHabilidad tipo) {
	this.tipo = tipo;
}

public void aplicar(Campeon campeonSeleccionado) {
	if(this.tipo == TipoHabilidad.DAÑO) {
	campeonSeleccionado.recibir_daño(this.getDaño());
	}else {
	if(this.tipo == TipoHabilidad.CURACION) {
		if((campeonSeleccionado.getHp_actual() + this.getDaño()) > campeonSeleccionado.getHp()) {			
		campeonSeleccionado.setHp_actual(campeonSeleccionado.getHp());
		}else {
		campeonSeleccionado.setHp_actual(campeonSeleccionado.getHp_actual() + this.getDaño());}
	}else {
		if(this.tipo == TipoHabilidad.BUFF) {
		campeonSeleccionado.setDaño(campeonSeleccionado.getDaño() + this.getDaño());
		}
	}
	
}}

	}

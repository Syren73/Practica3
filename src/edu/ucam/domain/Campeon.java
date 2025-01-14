package edu.ucam.domain;

import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Random;

import org.junit.Test;

import edu.ucam.constantes.Rol;
import edu.ucam.constantes.TipoHabilidad;

public class Campeon {
public Campeon(String nombre, Rol rol, int hp, int daño, int defensa,ArrayList<Habilidad> habilidades) {
		super();
		this.nombre = nombre;
		this.rol = rol;
		this.hp = hp;
		this.hp_actual = hp;
		this.daño = daño;
		this.habilidades = habilidades;
		this.defensa = defensa;
	}
String nombre;
Rol rol;
int hp;
int hp_actual;
int daño;
int defensa;
ArrayList<Habilidad> habilidades;
public void mostrarDatos() {
    System.out.println("Nombre: " + nombre);
    System.out.println("Rol: " + rol);
    System.out.println("HP Máximo: " + hp);
    System.out.println("HP Actual: " + hp_actual);
    System.out.println("Daño: " + daño);
    System.out.println("Defensa: " + defensa);
    System.out.println("Habilidades: " + habilidades.size());
}

public String getNombre() {
	return nombre;
}
public void setNombre(String nombre) {
	this.nombre = nombre;
}
public Rol getRol() {
	return rol;
}
public void setRol(Rol rol) {
	this.rol = rol;
}
public int getHp() {
	return hp;
}
public int getDefensa() {
	return defensa;
}
public void setHp(int hp) {
	this.hp = hp;
}

public boolean isAlive() {
	if(this.getHp_actual() <= 0) {
		return false;
	}else {
		return true;
	}
}

public void setDefensa(int defensa) {
	this.defensa = defensa;
}
public int getDaño() {
	return daño;
}
public void setDaño(int daño) {
	this.daño = daño;
}
public ArrayList<Habilidad> getHabilidades() {
	return habilidades;
}
public void setHabilidades(ArrayList<Habilidad> habilidades) {
	this.habilidades = habilidades;
}

public void atacar(Campeon enemigoSeleccionado) {
	enemigoSeleccionado.recibir_daño(this.getDaño());
}

//Usar habilidad tiene que modificarse para que su ejecucion cambie segun el tipo
//que sea
public void usar_habilidad(Campeon enemigoSeleccionado, Habilidad habilidadSeleccionada) {
	if(habilidadSeleccionada.tipo == TipoHabilidad.DAÑO) {
	habilidadSeleccionada.aplicar(enemigoSeleccionado);}else {
		if(habilidadSeleccionada.tipo == TipoHabilidad.CURACION  || habilidadSeleccionada.tipo == TipoHabilidad.BUFF) {
	habilidadSeleccionada.aplicar(this);
		}
	}
}

//La defensa actua como reduccion plana de daño, en caso de que no se pase el minimo 
//de defensa se pone el daño realizado a 1
public void recibir_daño(int daño) {	
	if(daño <= defensa) {
		if((this.getHp_actual() - 1) <= 0) {
			this.setHp_actual(0);
		}else {
	this.setHp_actual(this.getHp_actual() - 1);}
	}else {
		if((this.getHp_actual() - (daño - defensa)) <= 0) {
			this.setHp_actual(0);	
		}else {
		this.setHp_actual(this.getHp_actual() - (daño - defensa) );
	}}
}
public int getHp_actual() {
	return hp_actual;
}
public void setHp_actual(int hp_actual) {
	this.hp_actual = hp_actual;
}





	




}

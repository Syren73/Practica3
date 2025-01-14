package edu.ucam.pruebas;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Random;

import org.junit.Test;

import edu.ucam.constantes.Rol;
import edu.ucam.constantes.TipoHabilidad;
import edu.ucam.domain.Campeon;
import edu.ucam.domain.Combate;
import edu.ucam.domain.Habilidad;

public class PruebasCombate {

	@Test
	public void testIniciar() {
		Combate combate = new Combate();
		ArrayList<Habilidad> camp1Habilidades = new ArrayList<>();
		ArrayList<Habilidad> camp2Habilidades= new ArrayList<>();
		for(int i = 0 ; i < 4; i++) {
			camp1Habilidades.add(new Habilidad("habilidad"+(i+1),(new Random()).nextInt(25,70), TipoHabilidad.DAÑO));
			camp2Habilidades.add(new Habilidad("habilidad"+(i+1),(new Random()).nextInt(15,40), TipoHabilidad.DAÑO));
		}
		combate.setCampeon1(new Campeon("camp1",Rol.ASESINO,400, 30,10 ,camp1Habilidades));
		combate.setCampeon2(new Campeon("camp2",Rol.TANQUE,600,20,20,camp2Habilidades));
	    combate.iniciar();
	}
	
	@Test
	public void testDetener() {
		Combate combate = new Combate();
		ArrayList<Habilidad> camp1Habilidades = new ArrayList<>();
		ArrayList<Habilidad> camp2Habilidades= new ArrayList<>();
		combate.setCampeon1(new Campeon("camp1",Rol.ASESINO,400, 30,10 ,camp1Habilidades));
		combate.setCampeon2(new Campeon("camp2",Rol.TANQUE,1,20,20,camp2Habilidades));
	    combate.getCampeon1().atacar(combate.getCampeon2());
	    assertTrue(combate.detener());
	}
	
	@Test
	public void testGanador() {
		Combate combate = new Combate();
		ArrayList<Habilidad> camp1Habilidades = new ArrayList<>();
		ArrayList<Habilidad> camp2Habilidades= new ArrayList<>();
		combate.setCampeon1(new Campeon("camp1",Rol.ASESINO,400, 30,10 ,camp1Habilidades));
		combate.setCampeon2(new Campeon("camp2",Rol.TANQUE,1,20,20,camp2Habilidades));
	    combate.getCampeon1().atacar(combate.getCampeon2());
	    combate.detener();
	    System.out.println("Combate getGanador(): "+ combate.getGanador());
	    assertEquals(combate.getGanador(),"camp1");
	}
}

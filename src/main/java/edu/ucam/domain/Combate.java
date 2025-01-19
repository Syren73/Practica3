package edu.ucam.domain;

import java.util.ArrayList;
import java.util.Random;

import edu.ucam.constantes.Rol;
import edu.ucam.constantes.TipoHabilidad;

public class Combate {
public Campeon campeon1;
public Campeon campeon2;
public String ganador;
public void iniciar() {
	for(;;) {
	int random1 = (new Random()).nextInt(3);
	int random2 = (new Random()).nextInt(3);
	campeon1.atacar(campeon2);
	System.out.println("Campeon1 ataca a Campeon2, daño -> "+ campeon1.daño + "\n Vida restante: Campeon1: " + campeon1.getHp_actual()+ " Campeon2: " + campeon2.getHp_actual());
	if(detener()) 
	break;
	campeon2.atacar(campeon1);
	System.out.println("Campeon2 ataca a Campeon1, daño -> "+ campeon2.daño + "\n Vida restante: Campeon1: " + campeon1.getHp_actual()+ " Campeon2: " + campeon2.getHp_actual());
	if(detener()) 
	break;
	campeon1.usar_habilidad(campeon2, campeon1.getHabilidades().get(random1));
	System.out.println("Campeon1 usa "+campeon1.getHabilidades().get(random1).getNombre() +" en Campeon2, daño -> "+ campeon2.getHabilidades().get(random2).getDaño() + "\n Vida restante: Campeon1: " + campeon1.getHp_actual()+ " Campeon2: " + campeon2.getHp_actual());
	if(detener()) 
	break;
	campeon2.usar_habilidad(campeon1, campeon2.getHabilidades().get(random2));
	System.out.println("Campeon2 usa "+campeon2.getHabilidades().get(random2).getNombre() +" en Campeon1, daño -> "+ campeon2.getHabilidades().get(random2).getDaño() + "\n Vida restante: Campeon1: " + campeon1.getHp_actual()+ " Campeon2: " + campeon2.getHp_actual());
	if(detener()) 
	break;
	}	
}

public void setGanador(String ganador) {
	this.ganador = ganador;
	
}


public boolean detener() {
	if((!campeon1.isAlive() && campeon2.isAlive()) || (!campeon2.isAlive() && campeon1.isAlive())) {
		if(!campeon1.isAlive()) {
		setGanador(this.getCampeon2().getNombre());}else {
		setGanador(this.getCampeon1().getNombre());	}
		return true;
	}else {
		return false;
	}
	
}

	
	
	public static void main(String[] args) {
		System.out.println("Hello world!");
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
	System.out.println(combate.getGanador());
	}

	public Campeon getCampeon1() {
		return campeon1;
	}

	public void setCampeon1(Campeon campeon1) {
		this.campeon1 = campeon1;
	}

	public Campeon getCampeon2() {
		return campeon2;
	}

	public void setCampeon2(Campeon campeon2) {
		this.campeon2 = campeon2;
	}

	public String getGanador() {
		return ganador;
	}

}

package test;
import static org.junit.Assert.assertTrue;


import java.util.ArrayList;
import java.util.Random;

import org.junit.Test;
import edu.ucam.constantes.Rol;
import edu.ucam.constantes.TipoHabilidad;
import edu.ucam.domain.Campeon;
import edu.ucam.domain.Habilidad;

public class PruebasCampeonTest {

	@Test
	public void testPostCreate() {
		ArrayList<Habilidad> camp1Habilidades = new ArrayList<>();
		for(int i = 0 ; i < 4; i++) {
			camp1Habilidades.add(new Habilidad("habilidad"+(i+1),(new Random()).nextInt(25,70), TipoHabilidad.DAÑO));}
	Campeon temp =	new Campeon("camp1",Rol.ASESINO,400, 30,10 ,camp1Habilidades);
	assertTrue(temp.getDefensa() == 10 && temp.getDaño() == 30 && temp.getHabilidades().size() == 4 && temp.getRol()== Rol.ASESINO && temp.getHp() == 400 && temp.getNombre().equals("camp1"));}

	@Test
	public void testAtaqueBasico() {
		Campeon temp =	new Campeon("camp1",Rol.ASESINO,400, 30,10 ,null);
		Campeon temp1 =new Campeon("camp2",Rol.TANQUE,600,20,20,null);
	temp.atacar(temp1);
	assertTrue(temp1.getHp_actual() != temp1.getHp());
	}
	
    @Test
	public void testAplicacionDefensa1() {
		Campeon temp =	new Campeon("camp1",Rol.ASESINO,400, 30,10 ,null);
		Campeon temp1 =new Campeon("camp2",Rol.TANQUE,600,20,20,null);
	temp.atacar(temp1);
	if(temp1.getDefensa() < temp.getDaño()) {
	assertTrue(temp1.getHp_actual() == (temp1.getHp()- (temp.getDaño() - temp1.getDefensa())));
	}else {
	assertTrue(temp1.getHp_actual() == (temp1.getHp()-1));
	}}
    
    @Test
	public void testAplicacionDefensa2() {
		Campeon temp =	new Campeon("camp1",Rol.ASESINO,400, 30,10 ,null);
		Campeon temp1 =new Campeon("camp2",Rol.TANQUE,600,20,30,null);
	temp.atacar(temp1);
	if(temp1.getDefensa() < temp.getDaño()) {
	assertTrue(temp1.getHp_actual() == (temp1.getHp()- (temp.getDaño() - temp1.getDefensa())));
	}else {
	assertTrue(temp1.getHp_actual() == (temp1.getHp()-1));
	}}
    
    @Test
	public void testIsAlive() {
		Campeon temp =new Campeon("camp2",Rol.TANQUE,600,610,30,null);
		Campeon temp1 =	new Campeon("camp1",Rol.ASESINO,400, 30,10 ,null);
	    temp.atacar(temp1);
	assertTrue(!temp1.isAlive());
	}

	
	public static void main(String[] args) {
	}

}

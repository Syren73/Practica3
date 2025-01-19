package test.java;

import static org.junit.Assert.assertTrue;
import java.util.ArrayList;
import org.junit.Test;

import edu.ucam.constantes.Rol;
import edu.ucam.constantes.TipoHabilidad;
import edu.ucam.domain.Campeon;
import edu.ucam.domain.Habilidad;

public class PruebasHabilidadTest {
	@Test
	public void testAplicacionHabilidad() {
	ArrayList<Habilidad> camp1Habilidades = new ArrayList<Habilidad>();
	camp1Habilidades.add(new Habilidad("habilidad",60, TipoHabilidad.DAÑO));
	Campeon temp =	new Campeon("camp1",Rol.ASESINO,400, 30,10 ,camp1Habilidades);
	Campeon temp1 =new Campeon("camp2",Rol.TANQUE,600,20,20,null);
	temp.usar_habilidad(temp1,temp.getHabilidades().get(0));
	assertTrue(temp1.getHp_actual() == 560);
	assertTrue(temp1.getHp_actual() == (temp1.getHp() -(60 - 20)));}
	
	@Test
	public void testAplicacionCura1() {
	ArrayList<Habilidad> camp1Habilidades = new ArrayList<Habilidad>();
	camp1Habilidades.add(new Habilidad("habilidad",60, TipoHabilidad.CURACION));
	Campeon temp =	new Campeon("camp1",Rol.ASESINO,400, 30,10 ,camp1Habilidades);
	Campeon temp1 =new Campeon("camp2",Rol.TANQUE,600,20,20,null);
	temp1.atacar(temp);
	temp.usar_habilidad(temp1,temp.getHabilidades().get(0));
	assertTrue(temp.getHp_actual() == temp.getHp());}
	
	@Test
	public void testAplicacionCura2() {
	ArrayList<Habilidad> camp1Habilidades = new ArrayList<Habilidad>();
	camp1Habilidades.add(new Habilidad("habilidad",60, TipoHabilidad.CURACION));
	Campeon temp =	new Campeon("camp1",Rol.ASESINO,400, 30,10 ,camp1Habilidades);
	Campeon temp1 =new Campeon("camp2",Rol.TANQUE,600,100,20,null);
	temp1.atacar(temp);
	temp.usar_habilidad(temp1,temp.getHabilidades().get(0));
	assertTrue(temp.getHp_actual() == 370);
	assertTrue(temp.getHp_actual() == (temp.getHp() - (100-10) + 60)  );}	
	

@Test
public void testAplicacicionBuffo() {
	ArrayList<Habilidad> camp1Habilidades = new ArrayList<Habilidad>();
	camp1Habilidades.add(new Habilidad("habilidad",60, TipoHabilidad.BUFF));
	Campeon temp =	new Campeon("camp1",Rol.ASESINO,400, 30,10 ,camp1Habilidades);
	Campeon temp1 =new Campeon("camp2",Rol.TANQUE,600,100,20,null);
	temp.usar_habilidad(temp1,temp.getHabilidades().get(0));
	temp.atacar(temp1);
	assertTrue(temp.getDaño() == 90);
	assertTrue(temp1.getHp_actual() == (temp1.getHp() - (90-20)));}	
}





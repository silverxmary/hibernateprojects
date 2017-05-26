package ar.com.eduit.beans;

public class Pluviometro implements Instrumento {

	@Override
	public void medir() {
	   System.out.println("mide el agua caída");	
	}
}

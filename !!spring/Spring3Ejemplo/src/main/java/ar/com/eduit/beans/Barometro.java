package ar.com.eduit.beans;

public class Barometro implements Instrumento {

	@Override
	public void medir() {
	   System.out.println("mide la presión atmosférica");	
	}

}

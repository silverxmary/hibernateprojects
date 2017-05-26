package ar.com.eduit.beans;

public class Termometro implements Instrumento {

	@Override
	public void medir() {
	   System.out.println("mide la temeperatura");	
	}

}

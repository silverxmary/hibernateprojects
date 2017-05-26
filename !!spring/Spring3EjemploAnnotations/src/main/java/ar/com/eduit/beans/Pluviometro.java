package ar.com.eduit.beans;

import org.springframework.stereotype.Component;

@Component("pluviometro")
public class Pluviometro implements Instrumento {

	@Override
	public void medir() {
	   System.out.println("mide el agua caida");	
	}
}

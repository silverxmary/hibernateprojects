package ar.com.eduit.beans;

import org.springframework.stereotype.Component;

@Component("barometro")
public class Barometro implements Instrumento {

	@Override
	public void medir() {
	   System.out.println("mide la presiin atmosferica");	
	}

}

package ar.com.eduit.beans;

import org.springframework.stereotype.Component;

@Component("termometro")
public class Termometro implements Instrumento {

	@Override
	public void medir() {
	   System.out.println("mide la temeperatura");	
	}

}

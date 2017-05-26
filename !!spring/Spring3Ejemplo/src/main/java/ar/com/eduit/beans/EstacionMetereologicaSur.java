package ar.com.eduit.beans;

public class EstacionMetereologicaSur implements EstacionMetereologica{
	
	private Instrumento instrumento;
	
	public EstacionMetereologicaSur() {
		super();
	}

	public Instrumento getInstrumento() {
		return instrumento;
	}

	public void setInstrumento(Instrumento instrumento) {
		this.instrumento = instrumento;
	}
	
	@Override
	public void tomarMedicion() {
		instrumento.medir();
	}

}

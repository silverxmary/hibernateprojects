package ar.com.eduit.beans;

public class EstacionMetereologicaNorte implements EstacionMetereologica{

	private Instrumento instrumento;

	public EstacionMetereologicaNorte(Instrumento instrumento) {
		super();
		this.instrumento = instrumento;
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

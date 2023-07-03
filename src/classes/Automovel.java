package classes;
public abstract class Automovel {
	
    private String placa;
    private boolean dentro;
    private int tipo;//0 nenhum, 1 carro, 2 moto
    
    public Automovel(String plac, int tip, boolean dent){
    	setPlaca(plac);
    	setTipo(tip);
    	setDentro(dent);
    }
    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public int getTipo() {
		return tipo;
	}

	public void setTipo(int modelo) {
		this.tipo = modelo;
	}

	public boolean isDentro() {
		return dentro;
	}

	public void setDentro(boolean dentro) {
		this.dentro = dentro;
	}
	


}

package classes;
public class Carro extends Automovel {
    public Carro(String placa, boolean dent) {
    	super(placa, 1, dent);
    
    }
    @Override
    public void setPlaca(String placa) {
    	this.placa = placa;
    }
}

package classes;
public class Moto extends Automovel {
    public Moto(String plac , boolean dent) {
               super(plac, 2, dent);
    }
    @Override
    public void setPlaca(String placa) {
    	this.placa = placa;
    }
}

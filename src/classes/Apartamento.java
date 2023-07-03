package classes;

import java.util.ArrayList;



class Exception1 extends Exception {
	public Exception1(String mensagem) {
		super(mensagem);
	}
}

class Exception2 extends Exception {
	public Exception2(String mensagem) {
		super(mensagem);
	}
}

public class Apartamento {
	private int vagaTotalCarro = 2;
	private int vagaTotalMoto = 1;
	boolean ocupado = false;
	private String apartamentoNo;
	private int vagaAtualCarro; // eses n�meros ser�o incrementados ou decrementados conforme o cadastro.
	private int vagaAtualMoto; // esses n�meros ser�o incrementados ou decrementados conforme o cadastro.
	private int vagaAtualEstacionadaCarro;
	private int vagaAtualEstacionadaMoto;
	private ArrayList<Automovel> automoveis;

	public Apartamento(String numero) {
		setAutomoveis(new ArrayList<Automovel>());
		setApartamentoNo(numero);
		setVagaAtualCarro(0);
		setVagaAtualMoto(0);

		setVagaAtualEstacionadaCarro(0);// !< numero de carros estacionados
		setVagaAtualEstacionadaMoto(0);// !< numero de motos estacionados
		this.ocupado = true;
	}

	public boolean existe(String placa) {

		for (Automovel automovel : getAutomoveis()) {
			if (placa.equals(automovel.getPlaca())) {
				return false;
			}

		}
		return true;

	}

	public void addCarro(String placa, boolean d) {
		boolean existe = existe(placa);
		try {

			if (placa.indexOf('#') != -1) {
				if (getVagaAtualEstacionadaCarro() == getVagaTotalCarro()) {
					throw new Exception1("Numero maximo estacionado");

				} 
				else {

					Automovel carro = new Carro(placa, true);
					getAutomoveis().add(carro);
					setVagaAtualEstacionadaCarro(getVagaAtualEstacionadaCarro() + 1);
				}
			} else {

				if (existe == false) {
					throw new Exception1("Placa existe");
				}
				if (vagaAtualCarro == getVagaTotalCarro()) {
					throw new Exception2("Numero maximo");
				}

				if (vagaAtualCarro < getVagaTotalCarro() && getVagaAtualEstacionadaCarro() < getVagaTotalCarro()
						&& existe) {
					Automovel carro = new Carro(placa, d);
					getAutomoveis().add(carro);
					setVagaAtualCarro(getVagaAtualCarro() + 1);
					if (d) {
						setVagaAtualEstacionadaCarro(getVagaAtualEstacionadaCarro() + 1);

					}

				} else {
					throw new Exception();

				}

			}

			// transformar a função em tipo e string e retornar erro caso n seja possível
		} catch (Exception e) {
			System.out.println("Excedeu o limite de carros por apartamento.");
		}
	}

	public void addMoto(String placa, boolean d) {
		boolean existe = existe(placa);
		try {

			if (placa.indexOf('#') != -1) {
				if (getVagaAtualEstacionadaMoto() == getVagaTotalMoto()) {
					throw new Exception1("Numero maximo estacionado");

				} 
				else {

					Automovel moto = new Moto(placa, true);
					getAutomoveis().add(moto);
					setVagaAtualEstacionadaMoto(getVagaAtualEstacionadaMoto() + 1);
				}
			} else {

				if (existe == false) {
					throw new Exception1("Placa existe");
				}
				if (vagaAtualMoto == getVagaTotalMoto()) {
					throw new Exception2("Numero maximo");
				}

				if (vagaAtualMoto < getVagaTotalMoto() 
						&& getVagaAtualEstacionadaMoto() < getVagaTotalMoto()
						&& existe) {
					Automovel moto = new Moto(placa, d);
					getAutomoveis().add(moto);
					setVagaAtualMoto(getVagaAtualMoto() + 1);
					if (d) {
						setVagaAtualEstacionadaMoto(getVagaAtualEstacionadaMoto() + 1);

					}

				} else {
					throw new Exception();

				}

			}

			// transformar a função em tipo e string e retornar erro caso n seja possível
		} catch (Exception e) {
			System.out.println("Excedeu o limite de motos por apartamento.");
		}
		
		
		
		
		
		
		

	}

	public String getApartamentoNo() {
		return apartamentoNo;
	}

	public void setApartamentoNo(String apartamentoNo) {
		this.apartamentoNo = apartamentoNo;
	}

	public int getVagaAtualCarro() {
		return vagaAtualCarro;
	}

	public void setVagaAtualCarro(int vagaAtualCarroi) {
		this.vagaAtualCarro = vagaAtualCarroi;
	}

	public int getVagaAtualMoto() {
		return vagaAtualMoto;
	}

	public void setVagaAtualMoto(int vagaAtualMoto) {
		this.vagaAtualMoto = vagaAtualMoto;
	}

	public int getVagaTotalCarro() {
		return vagaTotalCarro;
	}

	public void setVagaTotalCarro(int vagaTotalCarroi) {
		this.vagaTotalCarro = vagaTotalCarroi;
	}

	public int getVagaTotalMoto() {
		return vagaTotalMoto;
	}

	public void setVagaTotallMoto(int vagaTotalMoto) {
		this.vagaTotalMoto = vagaTotalMoto;
	}

	public ArrayList<String> getAutomovelEst(boolean est) {
		ArrayList<String> lista = new ArrayList<>();
		for (Automovel automovel : getAutomoveis()) {
			if (automovel.isDentro() == est) {
				lista.add(automovel.getPlaca());

			}
		}
		return lista;

	}

	public void mudarEstado(String placa) {
		for (Automovel automovel : automoveis) {
			if (placa.equals(automovel.getPlaca())) {

				/*
				 * se o automovel estiver fora, verifica se o número dentro é menor que o máximo
				 * se não for, dar erro. se for,estaciona
				 * 
				 * se o autovel estiver dentro dá continuidade, se o automovel dentro tiver #,
				 * exclui ele
				 * 
				 */

				if (!automovel.isDentro()) {
					try {
						if (automovel.getTipo() == 1 && getVagaAtualEstacionadaCarro() < getVagaTotalCarro()) {
							automovel.setDentro(!automovel.isDentro());

						} else if (automovel.getTipo() == 2 && getVagaAtualEstacionadaMoto() < getVagaTotalMoto()) {
							automovel.setDentro(!automovel.isDentro());

						}

						else {
							throw new Exception();
						}
					} catch (Exception e) {
						System.out.println("Todas as vagas já estão estacionadas");
					}
				} else {

					automovel.setDentro(!automovel.isDentro());

				}

				if (!automovel.isDentro()) {
					if (automovel.getTipo() == 1) {
						setVagaAtualEstacionadaCarro(getVagaAtualEstacionadaCarro() - 1);
					}
					if (automovel.getTipo() == 2) {
						setVagaAtualEstacionadaMoto(getVagaAtualEstacionadaMoto() - 1);
					}

				} else {
					if (automovel.getTipo() == 1) {
						setVagaAtualEstacionadaCarro(getVagaAtualEstacionadaCarro() + 1);
					}
					if (automovel.getTipo() == 2) {
						setVagaAtualEstacionadaMoto(getVagaAtualEstacionadaMoto() + 1);
					}

				} // <! Altera o número de estados
			}

		}

	}

	public void removerVeiculo(String placa) {
		for (int i = 0; i < getAutomoveis().size(); i++) {
			if (placa.equals(getAutomoveis().get(i).getPlaca())) {
				if (getAutomoveis().get(i).getTipo() == 1) {
					setVagaAtualEstacionadaCarro(getVagaAtualEstacionadaCarro() - 1);
				}
				if (getAutomoveis().get(i).getTipo() == 2) {
					setVagaAtualEstacionadaMoto(getVagaAtualEstacionadaMoto() - 1);
				}

				getAutomoveis().remove(i);

			}

		}
	}

	public ArrayList<Automovel> getAutomoveis() {
		return automoveis;
	}

	public void setAutomoveis(ArrayList<Automovel> automoveis) {
		this.automoveis = automoveis;
	}

	public int getVagaAtualEstacionadaCarro() {
		return vagaAtualEstacionadaCarro;
	}

	public void setVagaAtualEstacionadaCarro(int vagaAtualEstacionadaCarro) {
		this.vagaAtualEstacionadaCarro = vagaAtualEstacionadaCarro;
	}

	public int getVagaAtualEstacionadaMoto() {
		return vagaAtualEstacionadaMoto;
	}

	public void setVagaAtualEstacionadaMoto(int vagaAtualEstacionadaMoto) {
		this.vagaAtualEstacionadaMoto = vagaAtualEstacionadaMoto;
	}

}

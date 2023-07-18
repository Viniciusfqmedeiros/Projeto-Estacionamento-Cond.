package classes;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;



public class TelaExecucao  extends JFrame implements ActionListener{
	
	
	private JFrame nFunc = new JFrame("Menu add funcionário");  
	private Container tt = nFunc.getContentPane();
	 
	 private JFrame nMovel = new JFrame("Menu add automovel");  
	 private Container td = nMovel.getContentPane();
   

	private Undo und = new Undo();
	
	private String entrada;
	private static boolean close = false;	private boolean ger;
	private boolean[] op = new boolean[12];//cada boolean é uma opção
	
	private Garagem gar;
	private String usr;
	private String psswd;
	
	private Font f = new Font("Courier", Font.PLAIN, 12);
	

	
	
	private JLabel lentry = new JLabel("Entrada: ");
	private JTextField tentry = new JTextField(); 
	
	private JLabel lapt = new JLabel("Apt: ");
	private JTextField tapt = new JTextField(); 
	
	private JLabel lplaca = new JLabel("Placa: ");
	private JTextField tplaca = new JTextField(); 
	
	private JLabel ltypeA = new JLabel("Tipo[C/M]: ");;
	private JTextField ttypeA = new JTextField(); 
	
	private JLabel ldent = new JLabel("Dentro ");;
	private JCheckBox cdent = new JCheckBox(); 

	
	private int pos_at = 0;//posição atual do loop principal na incrementação
	
	private JLabel ltypeB = new JLabel("Tipo[F/G]: ");
	private JTextField ttypeB = new JTextField(); 
	
	private JLabel lnome = new JLabel("Nome: ");
	private JTextField tnome = new JTextField(); 
	
	private JLabel lcpf = new JLabel("CPF: ");
	private JTextField tcpf = new JTextField(); 
	
	private JLabel lid = new JLabel("ID: ");;
	private JTextField tid = new JTextField(); 
	
	private JLabel lsenha = new JLabel("Senha: ");;
	private JTextField tsenha = new JTextField(); 
	
	
	
	
	private JButton sendBox = new JButton("->");//<-
	private JButton sendBox1 = new JButton("->");//<-
	private JButton send = new JButton("->");//<-
	
	private JButton exit = new JButton("*Modo texto");//<-
	private JButton op0 = new JButton("*Retornar a alguma ação anterior");
	private JButton op1 = new JButton("*Cadastrar apartamento");//<-
	private JButton op2 = new JButton("*Remover apartamento");//<-
	private JButton op3 = new JButton("*Cadastrar novo veiculo");
	private JButton op4 = new JButton("*Remover veiculo");//<-
	private JButton op5 = new JButton("*Placa que saiu/voltou"); //<-
	private JButton op6 = new JButton("*Visitante");
	private JButton op8 = new JButton("*Adicionar funcionário/gerente");
	private JButton op9 = new JButton("*Remover funcionário/gerente");
	private JButton op10 = new JButton("*Consultar funcionário/gerente");//<-
	private JButton inf = new JButton("*Informações apt");//<-
	private JButton save = new JButton("*SAVE");//<-
	//Tabela informações:
	private DefaultTableModel model = new DefaultTableModel();
	JTable jt=new JTable(model);
	
	
	public TelaExecucao(Garagem garagem, String usr, String psswd) {
		setUsr(usr);
		setPsswd(psswd);
	
		setGar(garagem);
		Container ct = this.getContentPane();
		ct.setLayout(null);
		
		
		
		
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		pack();
		setSize(screenSize.width,screenSize.height);
		
		int h = 20;
		int w = 300;
		//lveicE.setBounds(0, 0, w, h);
		//lveicF.setBounds((screenSize.width/2)-w/2, (screenSize.height/2)-h/2, w, h);
		
		
		
		exit.setBounds((screenSize.width/2)-w/2, (screenSize.height/2)-h/2-h, w, h);
		
		
		op0.setBounds((screenSize.width/2)-w/2, (screenSize.height/2)-h/2, w, h);
		op1.setBounds((screenSize.width/2)-w/2,(screenSize.height/2)-h/2+h, w, h);
		inf.setBounds((screenSize.width/2)-w/2,(screenSize.height/2)-h/2+2*h, w, h);
		op2.setBounds((screenSize.width/2)-w/2, (screenSize.height/2)-h/2+3*h, w, h);
		op3.setBounds((screenSize.width/2)-w/2, (screenSize.height/2)-h/2+4*h, w, h);
		op4.setBounds((screenSize.width/2)-w/2, (screenSize.height/2)-h/2+5*h, w, h);
		op5.setBounds((screenSize.width/2)-w/2, (screenSize.height/2)-h/2+6*h, w, h);
		op6.setBounds((screenSize.width/2)-w/2, (screenSize.height/2)-h/2+7*h, w, h);
		save.setBounds((screenSize.width/2)-w/2, (screenSize.height/2)-h/2+8*h, w, h);
		op8.setBounds((screenSize.width/2)-w/2, (screenSize.height/2)-h/2+9*h, w, h);
		op9.setBounds((screenSize.width/2)-w/2, (screenSize.height/2)-h/2+10*h, w, h);
		op10.setBounds((screenSize.width/2)-w/2, (screenSize.height/2)-h/2+11*h, w, h);
		
		
		
		
		exit.setFont(f);
		op0.setFont(f);
		op1.setFont(f);
		inf.setFont(f);
		op2.setFont(f);
		op3.setFont(f);
		op4.setFont(f);
		op5.setFont(f);
		op6.setFont(f);
		
		op8.setFont(f);
		op9.setFont(f);
		op10.setFont(f);
		save.setFont(f);
		
		ct.add(exit);
		ct.add(op0);
		ct.add(op1);
		ct.add(inf);
		ct.add(op2);
		ct.add(op3);
		ct.add(op4);
		ct.add(op5);
		ct.add(op6);
		ct.add(save);
		
	
		tabelaAutomoveis();
		setTitle("Controle Garagem");
		setResizable(true);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		exit.addActionListener(this);
		inf.addActionListener(this);
		op0.addActionListener(this);
		op1.addActionListener(this);
		op2.addActionListener(this);
		op3.addActionListener(this);
		op4.addActionListener(this);
		op5.addActionListener(this);
		op6.addActionListener(this);
		op8.addActionListener(this);
		op9.addActionListener(this);
		op10.addActionListener(this);
		
		save.addActionListener(this);
		


	}
	
	@Override
	public void actionPerformed(ActionEvent evento) {
		
		if (evento.getSource() == exit) {
				this.setClose(true);
				dispose();
    		
    		
    	}
		
		//undothis. tt.add(sendBox);
		if(evento.getSource() == op0) {op[0] = true; addEntry();
		
		}
		if(evento.getSource() == inf) {op[11] = true; addEntry();}
		
		if(evento.getSource() == op1) {op[1] = true;addEntry();}
		
		
		if(evento.getSource() == op2) {op[2] = true;addEntry();}
		
		if(evento.getSource() == op3) {op[3] = true;this.nAutomovel();}
		
		if(evento.getSource() == op4) {op[4] = true;addEntry();}
		
		if(evento.getSource() == op5) {op[5] = true;addEntry();}
		
		if(evento.getSource() == op6) {op[6] = true;cdent.setVisible(false);
		this.nAutomovel();
		}
		
		if(evento.getSource() == save) {gar.gravarDados(); gar.gravarLogins();
			pos_at = pos_at+1;
			und.inserir(pos_at, "Você salvou o estado no modo gráfico");
		}
		
		
		//op6
		//op7
		if(evento.getSource() == op8) {op[8] = true;this.nFuncionario();}
		

		if(evento.getSource() == op9) {op[9] = true;addEntry();}
		if(evento.getSource() == op10) {op[10] = true;addEntry();}
		
		
		if(evento.getSource() == send || evento.getSource() == sendBox  || evento.getSource() == sendBox1) {
			if(op[1]) {
				op[1] = !op[1];
				gar.NovoApt(tentry.getText() , 1);
				pos_at = pos_at+1;
				und.inserir(pos_at, "Você tentou/inseriu o apartamento: " + tentry.getText());
				
			}
			else if(op[2]) {
				op[2] = !op[2];
				gar.removerApartamento(tentry.getText());
				pos_at = pos_at+1;
				und.inserir(pos_at, "Você tentou/removeu o apartamento: " + tentry.getText());
			}
			else if(op[3]) {
				op[3] = !op[3];
				this.nAutomovel();
				this.gar.NovoAutomovel(tapt.getText(), tplaca.getText(), ttypeA.getText(),cdent.isSelected() );
				this.nMovel.dispose();
				pos_at = pos_at+1;
				und.inserir(pos_at, "Você tentou/cadastrou o veiculo: " + tplaca.getText());
			}
			else if(op[4]) {
				op[4] = !op[4];
				gar.removerAutomovel(tentry.getText());
				pos_at = pos_at+1;
				und.inserir(pos_at, "Você tentou/removeu  o veiculo: " + tentry.getText());
			}
			else if(op[5]) {
				op[5] = !op[5];
				
			 	if(tentry.getText().indexOf('#') != -1){
			  		gar.removerAutomovel(tentry.getText());
			  
			 	}
			 	else {
			 		

			 		gar.mudarEstado(tentry.getText());
			 	}
			 	pos_at = pos_at+1;
			 	und.inserir(pos_at, "Você tentou/mudou o estado da placa: " + tentry.getText());
			  }
			else if(op[6]) {
					op[6] = !op[6];
					this.gar.visitante(tapt.getText(), tplaca.getText(), ttypeA.getText());
					cdent.setVisible(true);
					pos_at = pos_at+1;
					und.inserir(pos_at, "Você tentou/adicionou o visitante: " + tplaca.getText());
			 	
			}
			else if(op[8]) {
				op[8] = !op[8];
				this.gar.addPess(this.ttypeB.getText(), this.tnome.getText(), this.tcpf.getText(), this.tid.getText(), this.tsenha.getText());
				cdent.setVisible(true);
				this.nFunc.dispose();
				pos_at = pos_at+1;
				und.inserir(pos_at, "Você tentou/adicionou a pessoa: " + tnome.getText());

		 	
			}
			else if(op[9]) {
				op[9] = !op[9];
				gar.remPess(tentry.getText(), this.getUsr(), this.getPsswd());
				und.inserir(pos_at + 1, "Você tentou/removeu a pessoa: " + tentry.getText());
				
			}
			else if(op[10]) {
				op[10] = !op[10];
				this.mostrarPess(tentry.getText());
				pos_at = pos_at+1;
				und.inserir(pos_at, "Você tentou/consultou a pessoa: " + tentry.getText());
				
			}
			else if(op[11]) {
				op[11] = !op[11];
				this.infoApt(tentry.getText());
				pos_at = pos_at+1;
				und.inserir(pos_at, "Você tentou/consultou o apartamento: " + tentry.getText());
				
			}
			else if(op[0]) {
				op[0] = !op[0];
				und.recuperar(pos_at,  Integer.valueOf(tentry.getText()));
				pos_at = pos_at+1;
				und.inserir(pos_at, "Você conferiu a ação: " + tentry.getText());
				
			}
			
			this.send.setVisible(false);
			tentry.setVisible(false);
			this.remove(send);
			this.remove(tentry);
			
		
		} 
		
		
		
	
	}
	

	
	public void addEntry() {
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		pack();
		setSize(screenSize.width,screenSize.height);
		int h = 20;
		int w = 300;
		tentry.setBounds(0, screenSize.height-h-10, screenSize.width-50, h+10);
		send.setBounds(screenSize.width-50, screenSize.height-h-10, 50, h+10);
		
		this.add(tentry);
		this.add(send);
		send.setVisible(true);
		tentry.setVisible(true);
		send.addActionListener(this);
		
	}
	public String getEntrada() {
		return entrada;
	}

	public void setEntrada(String entrada) {
		this.entrada = entrada;
	}

	public static boolean isClose() {
		return close;
	}

	public void setClose(boolean close) {
		this.close = close;
	}

	public boolean isGer() {
		return ger;
	}

	public void setGer(boolean ger) {
		this.ger = ger;
		if(ger) {
			this.add(op8);
			this.add(op9);
			this.add(op10);
		}
		
	}

	public Garagem getGar() {
		return gar;
	}

	public void setGar(Garagem gar) {
		this.gar = gar;
	}

	public boolean[] getOp() {
		return op;
	}

	public void setOp(boolean[] op) {
		this.op = op;
	}
	
	public void tabelaAutomoveis() {
		for(int i = 0; i < 30; i++) {
            this.model.addRow(new Object[]{"", ""}); // Adicione uma linha em branco com as células vazias

		}
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		pack();
		setSize(screenSize.width,screenSize.height);
		
		this.model.addColumn("ESTACIONADOS");
		this.model.addColumn("FORA");
		
	
		
		
		JScrollPane scrollPane = new JScrollPane(this.jt);
		scrollPane.setBounds(0, 0,screenSize.width, screenSize.height/2-40);
		this.jt.setEnabled(false);
		this.jt.setFillsViewportHeight(true);
		this.add(scrollPane);    
		this.setVisible(true);   
	}
	
   public void updateTable() {
	    
	 
	   for (int i =  model.getRowCount() - 1; i >= 0; i--) {
	       model.removeRow(i);
	   }
		
	   int j = 0;
	   for (String automovel : gar.getEstacionados(true)) {
	       model.addRow(new Object[] { automovel, null });
	       j++;
	   }

	   j = 0;

	   for (String automovel : gar.getEstacionados(false)) {
	       model.setValueAt(automovel, j, 1);
	       j++;
	   }
		

   }

public String getUsr() {
	return usr;
}

public void setUsr(String usr) {
	this.usr = usr;
}

public String getPsswd() {
	return psswd;
}

public void setPsswd(String psswd) {
	this.psswd = psswd;
}

public void nAutomovel(){ 

	td.setLayout(null);
	nMovel.setSize(280, 220);
	nMovel.setTitle("Cadastrar Automovel");
	nMovel.setResizable(false);
	JLabel end = new JLabel("");
	end.setBounds(10, 180, 100, 30);


	this.lapt.setBounds(10, 10, 100, 30);
	this.tapt.setBounds(66, 10, 200, 25);
	
	this.lplaca.setBounds(10, 40, 100, 30);
	this.tplaca.setBounds(66, 40, 200, 25);
	
	
	this.ltypeA.setBounds(10, 70, 100, 30);
	this.ttypeA.setBounds(66, 70, 200, 25);
	
	
	this.ldent.setBounds(10, 100, 100, 30);
	this.cdent.setBounds(66, 100, 100, 30);
	
	this.sendBox.setBounds(10, 140, 100, 30);
	
	
	
	this.td.add(lapt);
	this.td.add(tapt);
	
	
	
	this.td.add(lplaca);
	this.td.add(tplaca);
	
	this.td.add(ltypeA);
	this.td.add(ttypeA);
	
	this.td.add(ldent);
	this.td.add(cdent);
	this.td.add(sendBox);
	

	this. td.add(end);
	
	nMovel.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	nMovel.setAlwaysOnTop( true );
	nMovel.setVisible(true);
	sendBox.addActionListener(this);


}  

public void nFuncionario(){

	tt.setLayout(null);
	nFunc.setSize(280, 220);
	nFunc.setTitle("Cadastrar Funcionario");
	nFunc.setResizable(false);
	JLabel end = new JLabel("");
	end.setBounds(10, 180, 100, 30);
	
	
	ltypeB.setBounds(10, 10, 100, 30);
	ttypeB.setBounds(66, 10, 200, 25);
	
	
	lnome.setBounds(10, 40, 100, 30);
	tnome.setBounds(66, 40, 200, 25);
	
	
	lcpf.setBounds(10, 70, 100, 30);
	tcpf.setBounds(66, 70, 200, 25);
	
	
	lid.setBounds(10, 100, 100, 30);
	tid.setBounds(66, 100, 100, 30);
	
	lsenha.setBounds(10, 130, 100, 30);
	tsenha.setBounds(66, 130, 100, 30);
	
	sendBox1.setBounds(10, 170, 100, 30);
	
	
	
	tt.add(ltypeB);
	tt.add(ttypeB);
	
	
	
	tt.add(lnome);
	tt.add(tnome);
	
	tt.add(lcpf);
	tt.add(tcpf);
	
	tt.add(lid);
	tt.add(tid);
	
	tt.add(lsenha);
	tt.add(tsenha);
	
    tt.add(sendBox1);
	tt.add(end);
	
    nFunc.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    nFunc.setAlwaysOnTop( true );
    nFunc.setVisible(true);
	sendBox1.addActionListener(this);
}


public void mostrarPess(String cpf) {
	JFrame pess = new JFrame("Conferir pessoa");  
	pess.setVisible(true);
	pess.setResizable(false);
	pess.setAlwaysOnTop(true);
	pess.setSize(280, 220);
	JLabel end = new JLabel("");
	
	boolean find = false;
	for(Pessoa pessoa : gar.getPessoas()) {
		if(pessoa.getCpf().equals(cpf)) {
			find = !find;
			
			JLabel nome = new JLabel("Nome: "  + pessoa.getNome());
			nome.setBounds(10, 10, 100, 30);
			pess.add(nome);
			
			JLabel cPf = new JLabel("cpf: "  + pessoa.getCpf());
			cPf.setBounds(10, 40, 100, 30);
			pess.add(cPf);
			
			if(pessoa.getTipo() == 0) {
				Funcionario funca = (Funcionario) pessoa;
			
				JLabel typeF = new JLabel("tipo: funcionário");
				typeF.setBounds(10, 70, 100, 30);
				pess.add(typeF);
				JLabel idF = new JLabel("Id: " + funca.getId());
				idF.setBounds(10, 100, 100, 30);
				pess.add(idF);
				JLabel senhaF = new JLabel("Senha: " + funca.getSenha());
				senhaF.setBounds(10, 130, 100, 30);
				pess.add(senhaF);
			 
			
				end.setBounds(10, 160, 100, 30);
				pess.add(end);
				
			}
			else if(pessoa.getTipo() == 1) {
				Gerente ger = (Gerente) pessoa;
				
				JLabel typeG = new JLabel("tipo: Gerente");
				typeG.setBounds(10, 70, 100, 30);
				pess.add(typeG);
				JLabel idG = new JLabel("Id: " + ger.getId());
				idG.setBounds(10, 100, 100, 30);
				pess.add(idG);
				JLabel senhaG = new JLabel("Senha: " + ger.getSenha());
				senhaG.setBounds(10, 130, 100, 30);
				pess.add(senhaG);
				
				
				end.setBounds(10, 160, 100, 30);
				pess.add(end);
				
			
			}
			
		}
		
	}
	try {
	if(!find) {
		throw new Exception();
	}
	}
	catch(Exception e) {
		JLabel nEncontrado = new JLabel("Usuário com cpf informado não encontrado.");
		nEncontrado.setBounds(10, 10, 100, 30);
		pess.add(nEncontrado);
		
	}
	
	pess.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	
	
	
}


public void infoApt(String entr) {
	ArrayList <String> info = gar.InfoApt(entr, true);
	
	JFrame  inf = new JFrame();  
	inf.setTitle("Informações Apt");
	inf.setLayout(null);
    inf.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	
    
	inf.setVisible(true);
	
	inf.setResizable(false);
	inf.setAlwaysOnTop(true);
	inf.setSize(500, 220);
	
	if(info.get(0).equals("INEXISTENTE")) {
		JLabel show = new JLabel();
		show.setText(info.get(0));
		show.setBounds(10, 10, 500, 30);
		JLabel end = new JLabel("");
		end.setBounds(10, 10, 100, 30);
		show.setVisible(true);
		inf.add(show);
		inf.add(end);
	}
	else {
		JLabel nMotos = new JLabel("Numero de motos: "  + info.get(0));
		JLabel nCar = new JLabel("Numero de carros: "  + info.get(1));
		JLabel nMotosE = new JLabel("Numero de motos estacionadas: "  + info.get(2));
		JLabel nCarE = new JLabel("Numero de carros estacionados: "  + info.get(3));
		
		nMotos.setBounds(10, 10, 500, 30);
		nCar.setBounds(10, 40, 500, 30);
		nMotosE.setBounds(10, 70, 500, 30);
		nCarE.setBounds(10, 100, 500, 30);
		JLabel end = new JLabel("");
		end.setBounds(10, 140, 100, 30);
		nMotos.setVisible(true);
		nCar.setVisible(true);
		nMotosE.setVisible(true);
		nCarE.setVisible(true);
		inf.add(nMotos);
		inf.add(nCar);
		inf.add(nMotosE);
		inf.add(nCarE);
		inf.add(end);
		
		
	}
	
	
	
	
}


public void undoMode(String entr) {
	JFrame undo = new JFrame();  
	undo.setTitle("Ação anterior");
	undo.setLayout(null);
    undo.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	
	undo.setVisible(true);
	
	undo.setResizable(false);
	undo.setAlwaysOnTop(true);
	undo.setSize(500, 220);
	
	System.out.println(Integer.parseInt(entr));
	System.out.println(pos_at);
	JLabel show = new JLabel();
	
	show.setText(und.recuperar(pos_at,  Integer.parseInt(entr) ));
	show.setBounds(10, 10, 500, 30);
	JLabel end = new JLabel("");
	end.setBounds(10, 10, 100, 30);
	show.setVisible(true);
	undo.add(show);
	undo.add(end);
	
	
	
}




public Undo getUnd() {
	return und;
}

public void setUnd(Undo und) {
	this.und = und;
}



}

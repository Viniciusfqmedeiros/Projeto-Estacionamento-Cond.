package classes;

import javax.swing.*;
import java.awt.*;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
public class TelaLogin extends JFrame implements ActionListener {
	private String usr;
	private String psswd;
	private boolean close = true;
	
	
	
	
	
	private Font f = new Font("Courier", Font.PLAIN, 12);
	
	private JLabel lusr = new JLabel("Usuario: ");;
	private JTextField tusr = new JTextField(); 
	
	
	private JLabel lpsswd = new JLabel("Senha: ");;
	private JPasswordField tpsswd = new JPasswordField(); 
	
	
	
	private JButton b1 = new JButton("LOGIN");
	
	
    public TelaLogin() {
    	Container ct = this.getContentPane();
    	ct.setLayout(null);
    	
    	
    	lusr.setBounds(10, 10, 100, 30);
    	tusr.setBounds(66, 10, 200, 25);
    	
    	lpsswd.setBounds(10, 40, 100, 30);
    	tpsswd.setBounds(66, 40, 200, 25);
    	
    	b1.setBounds(10, 140, 100, 30);
    	
    	ct.add(lusr);
    	ct.add(tusr);
    	
    	ct.add(lpsswd);
    	ct.add(tpsswd);
    	
    	
    	
    	ct.add(b1);
    	
    	setSize(280, 220);
    	setTitle("Login");
    	setResizable(false);
    	
    	b1.addActionListener(this);
    	setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    	
 
       
    }
  
    
	@Override
    public void actionPerformed(ActionEvent evento) {
    	if (evento.getSource() == b1) {
    		
    		
    		setUsr(tusr.getText());
    		setPsswd(tpsswd.getText());
    	
    		
    	
        	
    		
    		
    		
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


	public boolean isClose() {
		return close;
		
	}


	public void setClose(boolean close) {
		this.close = close;
		if(!isClose()) {
			dispose();
    	}
	}
    

    
    
    
}
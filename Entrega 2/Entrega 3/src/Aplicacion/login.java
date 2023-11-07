package Aplicacion;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JPanel;


import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;



@SuppressWarnings("serial")
public class login extends JFrame {
	
	public login() 
	{
		setTitle("Bienvenid@s");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(300,150);
				
		setLayout (new BorderLayout());
		
        JPanel centro = new JPanel();
        
        centro.setBackground(new Color(176, 196, 222));
        JButton nuevo = new JButton("Iniciar sesion");
        
        nuevo.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
    
                dispose();
                
                new InicioSesion(null).setVisible(true);
            }
        });
        
        JButton reiniciar = new JButton("Registrarse si es nuevo cliente");
        
        reiniciar.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
    
                dispose();
                //FALTA CONECTAR EL DE REGISTRAR CLIENTE
                
               
            }
        });
        

        JButton top = new JButton("Salir del sistema");
        top.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        
        centro.add(nuevo);
        centro.add(reiniciar);
        centro.add(top);
		add(centro, BorderLayout.CENTER);

        setVisible(true);
	}
	
	public static void main(String[] args)
	{
		
		new login();
			
	}

}

package Aplicacion;

import javax.swing.JFrame;


import javax.swing.JButton;
import javax.swing.JPanel;


import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;



@SuppressWarnings("serial")
public class OpcionEmpleado extends JFrame {
	
	public OpcionEmpleado() 
	{
		setTitle("Opciones de Empleado");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(500,250);
		setLayout (new BorderLayout());
		
		
        JPanel centro = new JPanel(new GridLayout(2, 2));
        centro.setBackground(new Color(176, 196, 222));
        
        JButton alquiler = new JButton("Generar alquiler");
        
        alquiler.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	
            	alquiler alquiventana;
				try {
					alquiventana = new alquiler();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			    dispose();
            }
        });
        
        JButton conductor = new JButton("Registrar conductores adicionales");
        
        conductor.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	
            	//CONECTAR REGISTRAR CONDUCTOS ADICIONAL
            }
        });
        
        JButton actualizar = new JButton("Actualizar estado vehiculo");
        
        conductor.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	
            	//CONECTAR ACTUALIZAR ESTADO VEHICULO
            }
        });
        
        JButton salir = new JButton("Salir del sistema");
        salir.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(0); 
            }
        });
        
		centro.add(alquiler);
        centro.add(conductor);
        centro.add(actualizar);
        centro.add(salir);
        
		add(centro, BorderLayout.CENTER);
		
        setVisible(true);
	}
	
	public static void main(String[] args)
	{

		new OpcionEmpleado();
			
	}
}

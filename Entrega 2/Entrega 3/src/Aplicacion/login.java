package Aplicacion;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
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
                @Override
                public void actionPerformed(ActionEvent e) {
                    // Crear una nueva ventana de registro de cliente
                    JFrame nuevaVentana = new JFrame("Registro Cliente");
                    nuevaVentana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                    nuevaVentana.setSize(800, 600);

                    // Crear un panel para organizar los elementos
                    JPanel panelRegistroCliente = new JPanel();
                    panelRegistroCliente.setLayout(new GridLayout(0, 2, 10, 10));

                    // Agregar etiquetas y campos de texto
                    String[] etiquetas = {
                        "Nombre del Usuario:",
                        "Nombre dentro del Sistema:",
                        "Contraseña:",
                        "Fecha de Nacimiento:",
                        "Teléfono:",
                        "Nacionalidad:",
                        "Número Identificación:",
                        "Número de Licencia:",
                        "País Expedición:",
                        "Fecha de Licencia:",
                        "Tipo de Pago:",
                        "Número de Medio de Pago:",
                        "Fecha de Vencimiento de Medio de Pago:"
                    };

                    for (String etiqueta : etiquetas) {
                        JLabel label = new JLabel(etiqueta);
                        JTextField textField = new JTextField(20);
                        panelRegistroCliente.add(label);
                        panelRegistroCliente.add(textField);
                    }
			JButton registrarButton = new JButton("Registrar");
                    panelRegistroCliente.add(registrarButton);

                    nuevaVentana.add(panelRegistroCliente);
                    nuevaVentana.setVisible(true);

                    // Cerrar la ventana actual
                    dispose();
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

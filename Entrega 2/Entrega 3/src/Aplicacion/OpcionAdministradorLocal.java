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
public class OpcionAdministradorLocal extends JFrame {
	
	public OpcionAdministradorLocal() 
	{
		setTitle("Opciones de Administrador local");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(500,250);
		setLayout (new BorderLayout());
		

		
        JPanel centro = new JPanel(new GridLayout(3, 2));
        centro.setBackground(new Color(176, 196, 222));
        
        JButton registroEmpleado = new JButton("Registrar empleado");
        registroEmpleado.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	
            	JFrame nuevaVentana = new JFrame("Registrar Administrador Local");
                nuevaVentana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                nuevaVentana.setSize(400, 200);

                // Crear un panel para organizar los elementos
                JPanel panelRegistroAdminLocal = new JPanel();
                panelRegistroAdminLocal.setLayout(new GridLayout(0, 2, 10, 10));

                // Agregar etiquetas y campos de texto para los datos del administrador local
                String[] etiquetasRegistroAdminLocal = {
                    "Nombre:",
                    "Nombre de Usuario:",
                    "Contraseña:",
                    "Rol:",
                    "Sede:"
                };

                JTextField[] camposTextoRegistroAdminLocal = new JTextField[etiquetasRegistroAdminLocal.length];

                for (int i = 0; i < etiquetasRegistroAdminLocal.length; i++) {
                    JLabel label = new JLabel(etiquetasRegistroAdminLocal[i]);
                    camposTextoRegistroAdminLocal[i] = new JTextField(20);
                    panelRegistroAdminLocal.add(label);
                    panelRegistroAdminLocal.add(camposTextoRegistroAdminLocal[i]);
                }
                JButton registrarButton = new JButton("Registrar");
                panelRegistroAdminLocal.add(registrarButton);
                nuevaVentana.add(panelRegistroAdminLocal);
                nuevaVentana.add(panelRegistroAdminLocal);
                nuevaVentana.setVisible(true);
            	dispose();
            }
        });
        
        JButton infoEmpleado = new JButton("Mostrar informacion empleado");
        
        infoEmpleado.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	MostrarInfoEmpleado infoEmpleadoVentana = new MostrarInfoEmpleado(null);
            	infoEmpleadoVentana.setVisible(true);
			    dispose();
            }
        });
        
        JButton registroCliente = new JButton("Registrar cliente");
        
        registroCliente.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
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
        
        JButton infoCliente = new JButton("Mostrar informacion cliente");
        infoCliente.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	MostrarInfoCliente infoClienteVentana = new MostrarInfoCliente(null);
            	infoClienteVentana.setVisible(true);
			    dispose();
            }
        });
        
        JButton seguro = new JButton("Creacion de Seguro");
            seguro.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    // Crear una nueva ventana de Creación de Seguro
                    JFrame nuevaVentana = new JFrame("Creación de Seguro");
                    nuevaVentana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                    nuevaVentana.setSize(400, 300);

                    // Crear un panel para organizar los elementos
                    JPanel panelCreacionSeguro = new JPanel();
                    panelCreacionSeguro.setLayout(new GridLayout(0, 2, 10, 10));

                    // Agregar etiquetas y campos de texto
                    String[] etiquetas = {
                        "Tipo de Seguro:",
                        "Costo del Seguro ($):"
                    };

                    for (String etiqueta : etiquetas) {
                        JLabel label = new JLabel(etiqueta);
                        JTextField textField = new JTextField(20);
                        // Predeterminar el campo "Costo del Seguro" con un signo $
                        if (etiqueta.equals("Costo del Seguro ($):")) {
                            textField.setText("$");
                        }
                        panelCreacionSeguro.add(label);
                        panelCreacionSeguro.add(textField);
                    }

                    nuevaVentana.add(panelCreacionSeguro);
                    nuevaVentana.setVisible(true);

                    // Cerrar la ventana actual
                    dispose();
                }
            });
        
        JButton salir = new JButton("Salir del sistema");
        salir.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(0); 
            }
        });
        
		centro.add(registroEmpleado);
        centro.add(infoEmpleado);
        centro.add(registroCliente);
        centro.add(infoCliente);
        centro.add(seguro);
        centro.add(salir);
        
		add(centro, BorderLayout.CENTER);






		
        setVisible(true);
	}
	
	public static void main(String[] args) 
	{
		new OpcionAdministradorLocal();
	
	}
}

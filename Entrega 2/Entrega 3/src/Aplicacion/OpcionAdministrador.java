package Aplicacion;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;



@SuppressWarnings("serial")
public class OpcionAdministrador extends JFrame {
	
	public OpcionAdministrador() 
	{
		setTitle("Opciones de Administracion");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(300,250);
		setLayout (new BorderLayout());
		
		
        JPanel centro = new JPanel(new GridLayout(3, 2));
        centro.setBackground(new Color(176, 196, 222));
        
JButton sede = new JButton("Gestionar sedes");


sede.addActionListener(new ActionListener() {
    public void actionPerformed(ActionEvent e) {
    	
        JFrame nuevaVentana = new JFrame("Gestionar Sedes");
        nuevaVentana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        nuevaVentana.setSize(400, 300);

        // Crear un panel para organizar los elementos
        JPanel panelGestionSede = new JPanel();
        panelGestionSede.setLayout(new GridLayout(0, 2, 10, 10));

        // Agregar etiquetas y campos de texto
        String[] etiquetas = {
            "Nombre de la Sede:",
            "Ubicación:",
            "Horario de Atención:",
            "Nombre Administrador Local:"
        };

        for (String etiqueta : etiquetas) {
            JLabel label = new JLabel(etiqueta);
            JTextField textField = new JTextField(20);
            panelGestionSede.add(label);
            panelGestionSede.add(textField);
        }

        // Agregar el botón "Buscar" que abre una nueva ventana
        JButton buscarButton = new JButton("Buscar");
        buscarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Crear una nueva ventana para la visualización (aquí deberías agregar tu gráfico)
                JFrame ventanaVisualizacion = new JFrame("Visualización de disponibilidad de vehículos");
                ventanaVisualizacion.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                ventanaVisualizacion.setSize(800, 600);

                buscarButton.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        // Crear una nueva ventana para la visualización
                        JFrame ventanaVisualizacion = new JFrame("Visualización de disponibilidad de vehículos");
                        ventanaVisualizacion.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                        ventanaVisualizacion.setSize(800, 600);

                        // Crear un panel con GridLayout para organizar los cuadritos
                        JPanel panelCuadritos = new JPanel(new GridLayout(7, 12));

                        // Agregar cuadritos al panel (puedes personalizar esto según tus necesidades)
                        for (int i = 0; i < 7 * 12; i++) {
                            JPanel cuadrito = new JPanel();
                            cuadrito.setBorder(BorderFactory.createLineBorder(Color.BLACK)); // Borde para visualización
                            panelCuadritos.add(cuadrito);
                        }

                        // Agregar el panel de cuadritos a la ventana
                        ventanaVisualizacion.add(panelCuadritos);

                        // Hacer la ventana de visualización visible
                        ventanaVisualizacion.setVisible(true);
                    }
                });

                // Agregar el botón a un panel
                JPanel panelGestionSedes = new JPanel();
                panelGestionSedes.add(buscarButton);

                // Agregar el panel a la ventana principal
                nuevaVentana.add(panelGestionSedes);

                // Hacer la ventana principal visible
                nuevaVentana.setVisible(true);

                ventanaVisualizacion.setVisible(true);
            }
        });

        panelGestionSede.add(buscarButton);

        nuevaVentana.add(panelGestionSede);
        nuevaVentana.setVisible(true);
    	dispose();
    }
});

JButton vehiculo = new JButton("Gestionar vehiculo");
vehiculo.addActionListener(new ActionListener() {
    public void actionPerformed(ActionEvent e) {
        JFrame nuevaVentana = new JFrame("Gestión Vehículo");
        nuevaVentana.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        nuevaVentana.setSize(400, 300);

        JPanel panelNuevaVentana = new JPanel();
        panelNuevaVentana.setLayout((LayoutManager) new FlowLayout(FlowLayout.CENTER, 10, 10));
        
        JButton agregarVehiculo = new JButton("Agregar Vehículo");
        JButton trasladoVehiculo = new JButton("Traslado Vehículo");
        JButton eliminarVehiculo = new JButton("Eliminar Vehículo");

        Dimension buttonSize = new Dimension(300, 50);
        agregarVehiculo.setPreferredSize(buttonSize);
        trasladoVehiculo.setPreferredSize(buttonSize);
        eliminarVehiculo.setPreferredSize(buttonSize);
        
        panelNuevaVentana.add(agregarVehiculo);
        panelNuevaVentana.add(trasladoVehiculo);
        panelNuevaVentana.add(eliminarVehiculo);
        
        agregarVehiculo.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    // Crear una nueva ventana de "Gestionar Vehículo"
                    JFrame nuevaVentana = new JFrame("Agregar Vehículo");
                    nuevaVentana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                    nuevaVentana.setSize(400, 400);

                    // Crear un panel para organizar los elementos
                    JPanel panelGestionVehiculo = new JPanel();
                    panelGestionVehiculo.setLayout(new GridLayout(0, 2, 10, 10));

                    // Agregar etiquetas y campos de texto para los datos del vehículo
                    String[] etiquetas = {
                        "Placa:",
                        "Marca:",
                        "Modelo:",
                        "Color:",
                        "Transmisión:",
                        "Capacidad:",
                        "Categoría:",
                        "Estado:",
                        "Sede Actual:",
                        "Fecha Disponible:"
                    };

                    JTextField[] camposTexto = new JTextField[etiquetas.length];

                    for (int i = 0; i < etiquetas.length; i++) {
                        JLabel label = new JLabel(etiquetas[i]);
                        camposTexto[i] = new JTextField(20);
                        panelGestionVehiculo.add(label);
                        panelGestionVehiculo.add(camposTexto[i]);
                    }

                    nuevaVentana.add(panelGestionVehiculo);
                    nuevaVentana.setVisible(true);
                }
            });

          trasladoVehiculo.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    // Crear una nueva ventana de "Traslado Vehículo"
                    JFrame nuevaVentana = new JFrame("Traslado Vehículo");
                    nuevaVentana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                    nuevaVentana.setSize(400, 200);

                    // Crear un panel para organizar los elementos
                    JPanel panelTrasladoVehiculo = new JPanel();
                    panelTrasladoVehiculo.setLayout(new GridLayout(0, 2, 10, 10));

                    // Agregar etiquetas y campos de texto para "Sede Actual" y "Nueva Sede"
                    String[] etiquetasTraslado = {
                        "Sede Actual:",
                        "Nueva Sede:"
                    };

                    JTextField[] camposTextoTraslado = new JTextField[etiquetasTraslado.length];

                    for (int i = 0; i < etiquetasTraslado.length; i++) {
                        JLabel label = new JLabel(etiquetasTraslado[i]);
                        camposTextoTraslado[i] = new JTextField(20);
                        panelTrasladoVehiculo.add(label);
                        panelTrasladoVehiculo.add(camposTextoTraslado[i]);
                    }

                    nuevaVentana.add(panelTrasladoVehiculo);
                    nuevaVentana.setVisible(true);
                }
            });

        

        eliminarVehiculo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Crear una nueva ventana de "Eliminar Vehículo"
                JFrame nuevaVentanaEliminar = new JFrame("Eliminar Vehículo");
                nuevaVentanaEliminar.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                nuevaVentanaEliminar.setSize(400, 200);

                // Crear un panel para organizar los elementos
                JPanel panelEliminarVehiculo = new JPanel();
                panelEliminarVehiculo.setLayout(new GridLayout(0, 2, 10, 10));

                // Agregar etiquetas y campos de texto para "Placa," "Marca," y "Modelo"
                String[] etiquetasEliminar = {
                    "Placa:",
                    "Marca:",
                    "Modelo:"
                };

                JTextField[] camposTextoEliminar = new JTextField[etiquetasEliminar.length];

                for (int i = 0; i < etiquetasEliminar.length; i++) {
                    JLabel label = new JLabel(etiquetasEliminar[i]);
                    camposTextoEliminar[i] = new JTextField(20);
                    panelEliminarVehiculo.add(label);
                    panelEliminarVehiculo.add(camposTextoEliminar[i]);
                }

                nuevaVentanaEliminar.add(panelEliminarVehiculo);
                nuevaVentanaEliminar.setVisible(true);
            }
        });

        nuevaVentana.add(panelNuevaVentana);
        nuevaVentana.setVisible(true);
    }
});

JButton seguro = new JButton("Creacion seguro");
seguro.addActionListener(new ActionListener() {
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
    	dispose();
    }
});



        JButton categoria = new JButton("Registrar Categoria");
        
        categoria.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	
            	RegistrarCategoria registroCategoria = new RegistrarCategoria(null);
            	registroCategoria.setVisible(true);
			    dispose();
            }
        });
        
        JButton actualizar = new JButton("Actualizar Categoria");
    
        actualizar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	
            	try {
					CrearCategoria ventana = new CrearCategoria ();
					ventana.setVisible(true);
					dispose();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
            }
        });
        
        JButton salir = new JButton("Salir del sistema");
        salir.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(0); 
            }
        });
   
		centro.add(sede);
        centro.add(vehiculo);
        centro.add(seguro);
        centro.add(categoria);
        centro.add(actualizar);
        centro.add(salir);
        
		add(centro, BorderLayout.CENTER);

        setVisible(true);
	}
	
	public static void main(String[] args)
	{
		
		new OpcionAdministrador();
			
	}

}

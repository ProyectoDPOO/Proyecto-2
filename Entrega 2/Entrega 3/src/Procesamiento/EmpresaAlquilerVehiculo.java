package Procesamiento;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

import Modelo.Alquiler;
import Modelo.CategoriaVehiculo;
import Modelo.Cliente;
import Modelo.ConductorAdicional;
import Modelo.Empleado;
import Modelo.Sede;
import Modelo.Usuario;
import Modelo.Vehiculo;
import Modelo.Seguro;
import Modelo.EstadoVehiculo;
import Modelo.Reserva;

public class EmpresaAlquilerVehiculo {
	
	private Map<String, Usuario> usuarios;
	private Map<String, Vehiculo> inventario;
	private Map<String, Sede> sedes;
	private Map<String, Empleado> empleados;
	private Map<String, Seguro> seguros;
	private Map<String, Cliente> clientes;
	private Map<String, ConductorAdicional> conductorAdicional;
	private Map<String, CategoriaVehiculo> categorias;
	private Map<Integer, Alquiler> alquileres;
	private Map<Integer, Reserva> reservas;
	
	public EmpresaAlquilerVehiculo() 
	{
		usuarios = new HashMap<>();
		this.inventario = new HashMap<>();
		sedes = new HashMap<>();
		empleados = new HashMap<>();
		seguros = new HashMap<>();
		clientes = new HashMap<>();
		conductorAdicional = new HashMap<>();
		categorias = new HashMap<>();
		alquileres = new HashMap<>();
		reservas = new HashMap<>();
		

	}
	
	 public boolean verificarUsuario(String usuario)
	 {
		return usuarios.containsKey(usuario);
	 }
	 
		public void registrarUsuario(String usuario, String contrasena, String rol)
		{
			{
				boolean continuar = true;
				while (continuar)
				{
				try
				{
					if(!verificarUsuario(usuario)) 
					{
						Usuario nuevoUsuario = new Usuario(usuario, contrasena, rol);
		                usuarios.put(usuario, nuevoUsuario);
					}
					else 
					{
						System.out.println("El nombre del usuario ya existe");
							System.out.println("Saliendo de la aplicación ...");
							continuar = false;
							
					}
				}

				catch (NumberFormatException e)
				{
					System.out.println("Debe seleccionar uno de los números de las opciones.");
				}
				}
			}    
		}
	 
	 public Usuario inicioSesion(String usuario, String contrasena) 
		 {
		 
			 if(usuarios.containsKey(usuario)) {
				 
				 Usuario user = usuarios.get(usuario);
				 
				 if( user.getContraseña().equals(contrasena))
				 {
					 return user;
				 }
			 }
			 
			 return null;
		 }
		

	
	public void registrarVehiculo(String placa, String marca, String modelo, String color, String transmision, 
			int capacidad, String categoria, String estado, String sedeActual, String fechadisponible) 
	{
		  Vehiculo newVehiculo = new Vehiculo(placa, marca, modelo,color,transmision,capacidad,categoria,estado, sedeActual, fechadisponible);
		  inventario.put(placa, newVehiculo);
		  
	}
	
	public void eliminarVehiculo(String placa) 
	{
	    if (inventario.containsKey(placa)) {
	        inventario.remove(placa);
	    }
	}
	
	public void trasladarVehiculo(String placa, String destino) {

	    Vehiculo vehiculo = null;
	    for (Vehiculo carro : inventario.values()) {
	        if (carro.getPlaca().equals(placa)) {
	            vehiculo = carro;
	            break;
	        }
	    }
	    if (vehiculo != null) 
	    {
	        EstadoVehiculo estadoVehiculo = vehiculo.getEstado();
	        if (estadoVehiculo != null) 
	        {
	           String sedeActual = estadoVehiculo.getsedeActual();
	            if (!sedeActual.equals(destino)) 
	            {
	                estadoVehiculo.setSedeActual(destino);
	            } 
	            else
	            {
	                System.out.println("Traslado extitoso.");
	            }
	        } 
	    } 
	    else 
	    {
	       System.out.println("No se encontró vehículo");
	    }
	}
	
	public void registrarConductorAdicional(String nombre,String identificacion, String telefono, String correo, String numeroLicencia,String paisExpedicion, String fechaLicencia, String imgLicencia)
	{
		ConductorAdicional nuevoConductorAdicional = new ConductorAdicional( nombre, identificacion,  telefono,  correo,  numeroLicencia, paisExpedicion,  fechaLicencia,  imgLicencia);
		conductorAdicional.put(identificacion, nuevoConductorAdicional);
	}
	
	public void generarReserva(String cliente, String categoriaVehiculo, String sedeRecogida, 
			String sedeEntrega, String fechaRecogida, String fechaEntrega, String rangoHorasRecogida, String rangoHorasEntrega)
	{	
		Reserva newReserva = new Reserva( cliente, categoriaVehiculo, sedeRecogida, sedeEntrega,fechaRecogida,fechaEntrega,rangoHorasRecogida,rangoHorasEntrega);
		int precio = newReserva.getprecioPagoAnticipado(categoriaVehiculo);
		int numero = newReserva.generarNumeroReserva();
		
		System.out.println("El precio anticipado es" + precio);
		reservas.put(numero, newReserva);
				
	}

	
	public void generarAlquiler(String vehiculo, String cliente, String fechaRecogida, String rangoHorasRecogida, String sedeRecogida, String fechaEntrega, String rangoHorasEntrega, String sedeEntrega, String seguros2, String conductores)
	{
		Alquiler newAlquiler = new Alquiler(vehiculo,  cliente,  fechaRecogida,  rangoHorasRecogida,  sedeRecogida,  fechaEntrega,  rangoHorasEntrega,  sedeEntrega,  seguros2,  conductores);
		int numero = newAlquiler.generarNumeroAlquiler();
		int precio = newAlquiler.generarPrecioFinal(vehiculo);
		System.out.println("El precio final de alquiler es:" + precio);
		alquileres.put(numero, newAlquiler);		
		
	}
	
	public void actualizarEstado(String placa, String estadoNuevo)
	{
		Vehiculo vehiculo = inventario.get(placa);
		if (vehiculo != null)
		{
			EstadoVehiculo estadoVehiculo = vehiculo.getEstado();
			if(estadoVehiculo != null)
			{
				estadoVehiculo.actualizarEstado(estadoNuevo);
			}
		}
		else 
		{
			System.out.println("Vehículo no existe");
		}
	}

	
	public void crearSeguro(String nombre, int costo)
	{
		Seguro newSeguro = new Seguro(nombre, costo);
		seguros.put(nombre, newSeguro);	
	}
	

	public void registrarEmpleado(String nombre,String nombreUsuario, String contrasena, String rol, String sede)
	{
		if (!empleados.containsKey(nombre)) {
	        Empleado nuevoEmpleado = new Empleado(nombre, nombreUsuario, contrasena, rol, sede);
	        empleados.put(nombreUsuario, nuevoEmpleado);
	     
	    } else {
	        System.out.println("Ya existe");
	    }
	}
	
	public Empleado mostrarEmpleado(String nombre) 
	{
		Empleado empleado = empleados.get(nombre);
		
		if (empleado != null) 
		{
		ArrayList<String> resumen = empleado.resumenEmpleado();
		System.out.println("\nInformación del empleado:\n");
			for (String detalle: resumen) 
			{
				System.out.println(detalle);
			}
			}
		else{
			System.out.println("No se encontro");
		}
		return empleado;
	}
	
	public void registrarCliente(String nombre, String nombreUsuario, String contrasena,String fechaDeNacimiento, String telefono,
			String nacionalidad, String imgDocidentidad, String identificacion,String numeroLicencia,
			String paisExpedicion, String fechaLicencia, String imgLicencia,String tipoPago, 
			String numeroMedioPago, String fechaVencimientoMedioPago)
	{
		if (!clientes.containsKey(nombre)) {
		Cliente newCliente = new Cliente( nombre,nombreUsuario,  contrasena,  fechaDeNacimiento,  telefono,
				 nacionalidad,  imgDocidentidad,  identificacion, numeroLicencia,
				 paisExpedicion,  fechaLicencia,  imgLicencia, tipoPago, 
				 numeroMedioPago, fechaVencimientoMedioPago);
		clientes.put(nombreUsuario, newCliente);
		}else {
	        System.out.println("Ya existe");
	    }
	}
	
	public Cliente mostrarCliente(String nombre) 
	{
		Cliente cliente = clientes.get(nombre);
		
		if (cliente != null) 
		{
		ArrayList<String> resumen = cliente.resumenCliente();
		System.out.println("\nInformación del cliente:\n");
			for (String detalle: resumen) 
			{
				System.out.println(detalle);
			}
			}
		else{
			System.out.println("No se encontro");
		}
		return cliente;
	}
		
	public void gestionSede(String nombreSede, String ubicacion, int horarioAtencion, String adminLocal2) {
		
		Empleado adminLocal = empleados.get(adminLocal2);

		Sede newSede = new Sede(nombreSede, ubicacion, horarioAtencion, adminLocal);
		sedes.put(nombreSede, newSede);
	}
	
	public void registrarCategoria(String nombreCategoria, int tarifaTemporadaAlta, int tarifaTemporadaBaja, int tarifaConductorAdicional, int tarifaEntregarOtraSede, boolean temporadaAlta) {
	    CategoriaVehiculo categoria = new CategoriaVehiculo(nombreCategoria, tarifaTemporadaAlta, tarifaTemporadaBaja, tarifaConductorAdicional, tarifaEntregarOtraSede, temporadaAlta);
	    categorias.put(nombreCategoria, categoria);
	}
	
	public void actualizarCategoria(String nombreCategoria, int tarifaTemporadaAlta, int tarifaTemporadaBaja, int tarifaConductorAdicional, int tarifaEntregarOtraSede, boolean temporadaAlta) {
	    if (categorias.containsKey(nombreCategoria)) {
	        CategoriaVehiculo categoria = categorias.get(nombreCategoria);
	        categoria.setTarifaTemporadaAlta(tarifaTemporadaAlta);
	        categoria.setTarifaTemporadaBaja(tarifaTemporadaBaja);
	        categoria.setTarifaConductorAdicional(tarifaConductorAdicional);
	        categoria.setTarifaOtraSede(tarifaEntregarOtraSede);      
	        categoria.setTemporadaAlta(temporadaAlta);
	    } else {
	        System.out.println("La categoría especificada no existe.");
	    }
	}
	public String input(String mensaje)
	{
		try
		{
			System.out.print(mensaje + ": ");
			BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
			return reader.readLine();
		}
		catch (IOException e)
		{
			System.out.println("Error leyendo de la consola");
			e.printStackTrace();
		}
		return null;
	}


}

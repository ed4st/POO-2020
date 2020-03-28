package boundary;

import control.*;
import entities.*;
import java.util.Calendar;
import java.util.Scanner;

public class PantallaDespacho {

	public static void main(String[] args) {
		
		/*ControlDespachos despacho = new ControlDespachos();
		Producto arroz = new Producto(4324231, "Arroz", 1800, "Tienda Geminis");
		Producto lenteja = new Producto(3215432, "Lenteja", 1900, "D1");
		Cliente ricardo = new Cliente(8908023, "Ricardo Arjona", 4342343, "sfdsfsd");
		//testeando punto 10
		despacho.reservarPedido(ricardo.getCedula(), 1113, arroz);
		despacho.reservarPedido(ricardo.getCedula(), 1114, lenteja);
		//testeando punto 11
		despacho.ModificarDatosDeUnPedido(1113);//va en minúscula
		//testeando punto 12
		despacho.eliminarReservaDeUnPedido (1113);
		//testeando punto 13
		despacho.VerListadoDePedidosExistentes();//minúscula
		//testeando punto 14
		despacho.listadoPedidos (1114, new GregorianCalendar(2020,3,30));*/
		
		//Testeando dinámicamente
		Scanner sc = new Scanner(System.in);
		System.out.println("Bienvenido al sistema de despacho de productos. \n "
				+ "Podra realizar las siguientes acciones: \n");
		
		int respuesta;
		do {
			System.out.println( "1. Ver listado de Productos disponibles \n"
					+ "2. Insertar Productos \n"
					+ "3. Modificar Productos \n"
					+ "4. Eliminar Productos \n"
					+ "5. Ver listado de Clientes registrados en el sistema \n"+
					"6. Insertar Cliente\n" + 
					"7. Modificar datos de Cliente\n" + 
					"8. Eliminar un Cliente\n" + 
					"9. Realizar el Pedido de un Producto\n" + 
					"10. Modificar un Pedido de un Producto\n" + 
					"11. Eliminar un Pedido de un Producto\n" + 
					"12. Ver listado de Pedidos existentes\n" + 
					"13. Ver listado de Pedidos existentes para un Producto y posterior a una fecha específica\n" + 
					"14. Salir \n"
					);
			
			respuesta = sc.nextInt();
			
			switch (respuesta) {
			case 1:
				despacho.imprimirProductos();
				break;
			case 2:
				
				System.out.println("Ingrese codigo producto:[7 digitos] ");
				long pid = sc.nextLong();
				
				System.out.println("Ingrese nombre del producto: ");
				String nombreComercial = sc.next();
				
				System.out.println("Ingrese precio del producto: ");
				double precio = sc.nextDouble();
				
				System.out.println("Ingrese tienda");
				String tienda = sc.next();
				
				despacho.insertar_un_producto(pid, nombreComercial, precio, tienda);
				break;
			case 3:
				long pid1;
				do {
					System.out.println("Ingrese el id del producto a modificar: ");
					pid1 = sc.nextLong()	
				} while (!despacho.modificar_un_producto(pid1));
				
				;
				break;
			case 4:
				long pid2;
				do {
					System.out.println("Ingrese el id del producto a eliminar: ");
					pid2 = sc.nextLong();				
				} while (despacho.eliminar_un_producto(pid2));
				
				
				break;
			case 5:
				despacho.verClientes();
				break;
			case 6:	
				System.out.println("Ingrese la cedula del cliente: ");
				long cedula = sc.nextLong();
				
				System.out.println("Ingrese la nombre del cliente: ");
				String nombreCompleto = sc.next();
				
				System.out.println("Ingrese el telefono del cliente: ");
				long telefonoContacto = sc.nextLong();

				System.out.println("Ingrese la direccion del cliente: ");
				String direccion = sc.next();
				
				Cliente ClienteAIngresar = new Cliente(cedula, nombreCompleto, telefonoContacto, direccion);
				despacho.insertarCliente(clienteAIngresar);
				break;
			case 7:
				long id1;
				do {
					System.out.println("Ingrese el id del producto a modificar: ");
					id1 = sc.nextLong();	
				} while (!despacho.modificarCliente(id1));
				
				break;
			case 8:
				long id2;
				do {
					System.out.println("Ingrese el id del producto a modificar: ");
					id2 = sc.nextLong();	
				} while (!despacho.eliminarCliente(id2));
				break;
			case 9:
				System.out.println("----------------------Datos del producto---------------");
				System.out.println("Ingrese codigo producto:[7 digitos] ");
				long pid3 = sc.nextLong();
				
				System.out.println("Ingrese nombre del producto: ");
				String nombreComercial3 = sc.next();
				
				System.out.println("Ingrese precio del producto: ");
				double precio3 = sc.nextDouble();
				
				System.out.println("Ingrese tienda");
				String tienda3 = sc.next();
				Producto productoPedido = new Producto(pid3, nombreComercial3,precio3,tienda3);
				System.out.println("----------------------Datos del Cliente---------------");
				System.out.println("Ingrese la cedula del cliente: ");
				long cedula2 = sc.nextLong();
				
				System.out.println("Ingrese la nombre del cliente: ");
				String nombreCompleto2 = sc.next();
				
				System.out.println("Ingrese el telefono del cliente: ");
				long telefonoContacto2 = sc.nextLong();

				System.out.println("Ingrese la direccion del cliente: ");
				String direccion2 = sc.next();
				
				Cliente clientePedido= new Cliente(cedula, nombreCompleto, telefonoContacto, direccion);
				System.out.println("Ingrese el id del pedido: ");
				long id_pedido = sc.nextLong();
				despacho.reservarPedido(clientePedido.getCedula(), id_pedido, productoPedido);
				break;
			case 10:
				System.out.println("Ingrese el id del pedido a modificar: ");
				long id_pedido2 = sc.nextLong();
				despacho.ModificarDatosDeUnPedido(id_pedido2);//va en minúscula
				break;
			case 11:
				System.out.println("Ingrese el id del pedido a eliminar: ");
				long id_pedido3 = sc.nextLong();
				despacho.eliminarReservaDeUnPedido (id_pedido3);
				break;
			case 12:
				despacho.VerListadoDePedidosExistentes();
				break;
			case 13:
				System.out.println("Ingrese el codigo del producto: ");
				long pid4 = sc.nextLong();
				despacho.listadoPedidos (pid4, new GregorianCalendar(2020,3,30));
				break;
			case 14:
				System.out.println("Gracias por usar el sistema de despacho");
				break;
			default:
				break;
			}
			
		} while (respuesta != 14);
		
		
		
		
	}
}

/*
Buenas tardes a todos,

Por favor nadie toque este espacio en su rama, este espacio solo es
modificable en la rama master, es decir, la rama final de todo el proyecto.

Julian,

*/

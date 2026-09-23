import java.util.Scanner;

/**
 * Clase ejecutora (contiene el método main)
 * Sistema básico de registro y control de productos por consola
 * para una microempresa.
 */
public class GestionProductos {

    // Capacidad máxima de productos que puede manejar el sistema
    static final int MAX_PRODUCTOS = 50;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Arreglo de objetos Producto y contador de productos registrados
        Producto[] productos = new Producto[MAX_PRODUCTOS];
        int contadorProductos = 0;

        int opcion;

        // Estructura repetitiva: do-while para mantener el menú activo hasta que el usuario elija salir
        do {
            System.out.println("\n===== SISTEMA DE REGISTRO DE PRODUCTOS =====");
            System.out.println("1. Registrar producto");
            System.out.println("2. Listar todos los productos");
            System.out.println("3. Buscar producto por código");
            System.out.println("4. Registrar venta (reducir stock)");
            System.out.println("5. Registrar ingreso de mercadería (aumentar stock)");
            System.out.println("6. Ver valor total del inventario");
            System.out.println("0. Salir");
            System.out.print("Elija una opción: ");

            opcion = leerEntero(sc);

            // Estructura selectiva múltiple: switch
            switch (opcion) {

                case 1:
                    if (contadorProductos >= MAX_PRODUCTOS) {
                        System.out.println("Ya se alcanzó el máximo de productos permitidos.");
                    } else {
                        System.out.print("Código del producto: ");
                        String codigo = sc.nextLine();

                        System.out.print("Nombre del producto: ");
                        String nombre = sc.nextLine();

                        System.out.print("Precio: ");
                        double precio = leerDecimal(sc);

                        System.out.print("Stock inicial: ");
                        int stockActual = leerEntero(sc);

                        System.out.print("Stock mínimo permitido: ");
                        int stockMinimo = leerEntero(sc);

                        // Se crea el objeto usando el constructor con parámetros
                        Producto nuevo = new Producto(codigo, nombre, precio, stockActual, stockMinimo);
                        productos[contadorProductos] = nuevo;
                        contadorProductos++; // acumulador de productos registrados

                        System.out.println("Producto registrado correctamente.");
                    }
                    break;

                case 2:
                    if (contadorProductos == 0) {
                        System.out.println("Aún no hay productos registrados.");
                    } else {
                        // Estructura repetitiva: for, recorre todos los productos registrados
                        for (int i = 0; i < contadorProductos; i++) {
                            productos[i].mostrarInformacion();
                        }
                    }
                    break;

                case 3:
                    System.out.print("Ingrese el código a buscar: ");
                    String codigoBuscado = sc.nextLine();
                    int posicion = buscarProductoPorCodigo(productos, contadorProductos, codigoBuscado);

                    if (posicion == -1) {
                        System.out.println("No se encontró un producto con ese código.");
                    } else {
                        productos[posicion].mostrarInformacion();
                    }
                    break;

                case 4:
                    System.out.print("Código del producto a vender: ");
                    String codigoVenta = sc.nextLine();
                    int posVenta = buscarProductoPorCodigo(productos, contadorProductos, codigoVenta);

                    if (posVenta == -1) {
                        System.out.println("No se encontró un producto con ese código.");
                    } else {
                        System.out.print("Cantidad vendida: ");
                        int cantidadVenta = leerEntero(sc);
                        boolean exito = productos[posVenta].reducirStock(cantidadVenta);
                        if (exito) {
                            System.out.println("Venta registrada correctamente.");
                        }
                    }
                    break;

                case 5:
                    System.out.print("Código del producto a reabastecer: ");
                    String codigoIngreso = sc.nextLine();
                    int posIngreso = buscarProductoPorCodigo(productos, contadorProductos, codigoIngreso);

                    if (posIngreso == -1) {
                        System.out.println("No se encontró un producto con ese código.");
                    } else {
                        System.out.print("Cantidad a ingresar: ");
                        int cantidadIngreso = leerEntero(sc);
                        productos[posIngreso].aumentarStock(cantidadIngreso);
                    }
                    break;

                case 6:
                    // Acumulador para el valor total del inventario
                    double valorTotal = 0.0;
                    for (int i = 0; i < contadorProductos; i++) {
                        valorTotal = valorTotal + productos[i].calcularValorInventario();
                    }
                    System.out.println("Valor total del inventario: S/ " + valorTotal);
                    break;

                case 0:
                    System.out.println("Saliendo del sistema...");
                    break;

                default:
                    System.out.println("Opción no válida. Intente nuevamente.");
            }

        } while (opcion != 0);

        System.out.println("Total de productos creados durante la ejecución: "
                + Producto.getTotalProductosCreados());

        sc.close();
    }

    // Método auxiliar que devuelve valor: busca un producto por código y devuelve su posición (o -1 si no existe)
    public static int buscarProductoPorCodigo(Producto[] productos, int contador, String codigo) {
        for (int i = 0; i < contador; i++) {
            if (productos[i].getCodigo().equalsIgnoreCase(codigo)) {
                return i;
            }
        }
        return -1;
    }

    // Método auxiliar para leer un entero de forma segura y limpiar el buffer del Scanner
    public static int leerEntero(Scanner sc) {
        int valor = sc.nextInt();
        sc.nextLine(); // limpia el salto de línea pendiente
        return valor;
    }

    // Método auxiliar para leer un decimal de forma segura y limpiar el buffer del Scanner
    public static double leerDecimal(Scanner sc) {
        double valor = sc.nextDouble();
        sc.nextLine(); // limpia el salto de línea pendiente
        return valor;
    }
}

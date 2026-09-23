public class Producto {

    // ----- Atributos de instancia -----
    private String codigo;
    private String nombre;
    private double precio;
    private int stockActual;
    private int stockMinimo;

    // Cuenta cuántos productos se han creado en total (compartido por todos los objetos)
    private static int totalProductosCreados = 0;

    // ----- Constructor sin parámetros -----
    public Producto() {
        this.codigo = "SIN-CODIGO";
        this.nombre = "SIN-NOMBRE";
        this.precio = 0.0;
        this.stockActual = 0;
        this.stockMinimo = 0;
        totalProductosCreados++;
    }

    // ----- Constructor con parámetros -----
    public Producto(String codigo, String nombre, double precio, int stockActual, int stockMinimo) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.precio = precio;
        this.stockActual = stockActual;
        this.stockMinimo = stockMinimo;
        totalProductosCreados++;
    }

    // ----- Getters -----
    public String getCodigo() {
        return codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public int getStockActual() {
        return stockActual;
    }

    public int getStockMinimo() {
        return stockMinimo;
    }

    public static int getTotalProductosCreados() {
        return totalProductosCreados;
    }

    // ----- Setters -----
    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public void setStockMinimo(int stockMinimo) {
        this.stockMinimo = stockMinimo;
    }

    // ----- Método que no devuelve valor: muestra la información del producto -----
    public void mostrarInformacion() {
        System.out.println("----------------------------------------");
        System.out.println("Código      : " + codigo);
        System.out.println("Nombre      : " + nombre);
        System.out.println("Precio      : S/ " + precio);
        System.out.println("Stock actual: " + stockActual);
        System.out.println("Stock mínimo: " + stockMinimo);
        if (validarStock()) {
            System.out.println("Estado      : STOCK OK");
        } else {
            System.out.println("Estado      : STOCK BAJO (reponer)");
        }
        System.out.println("----------------------------------------");
    }

    // ----- Método que devuelve valor: valida si el stock actual está por encima del mínimo -----
    public boolean validarStock() {
        if (stockActual >= stockMinimo) {
            return true;
        } else {
            return false;
        }
    }

    // ----- Método que devuelve valor: calcula el valor total en soles del stock de este producto -----
    public double calcularValorInventario() {
        return precio * stockActual;
    }

    // ----- Método que no devuelve valor: aumenta el stock (ingreso de mercadería) -----
    public void aumentarStock(int cantidad) {
        if (cantidad > 0) {
            stockActual = stockActual + cantidad;
            System.out.println("Se aumentó el stock en " + cantidad + " unidades.");
        } else {
            System.out.println("La cantidad a aumentar debe ser mayor a 0.");
        }
    }

    // ----- Método que devuelve valor: reduce el stock (venta) y valida que no sea negativo -----
    public boolean reducirStock(int cantidad) {
        if (cantidad <= 0) {
            System.out.println("La cantidad a reducir debe ser mayor a 0.");
            return false;
        } else if (cantidad > stockActual) {
            System.out.println("No hay stock suficiente para reducir esa cantidad.");
            return false;
        } else {
            stockActual = stockActual - cantidad;
            return true;
        }
    }
}

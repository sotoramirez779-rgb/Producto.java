# PA1 — Sistema de Registro y Control de Productos (POO)

## Descripción breve del trabajo
Sistema en Java, ejecutado por consola, que permite a una microempresa registrar
productos, mostrar su información, validar su stock y ejecutar operaciones
básicas de control (ventas e ingresos de mercadería) a través de un menú.

El proyecto está compuesto por dos clases:
- **`Producto.java`**: modela un producto (código, nombre, precio, stock actual,
  stock mínimo), con constructores, métodos que devuelven valor (validar stock,
  calcular valor de inventario, reducir stock) y métodos que no devuelven valor
  (mostrar información, aumentar stock).
- **`GestionProductos.java`**: clase ejecutora con el método `main`, contiene el
  menú por consola (estructura `do-while` + `switch`) y usa un arreglo de
  objetos `Producto` con un contador/acumulador para llevar el registro.

## Integrantes
1. ronald yamil soto ramirez
2. ____________________
3. ____________________
4. ____________________

## Instrucciones mínimas de ejecución (IntelliJ IDEA)
1. Abrir IntelliJ IDEA → **New Project** → tipo **Java** (elegir un JDK 11+ instalado).
2. Dentro de la carpeta `src` del proyecto, copiar `Producto.java` y
   `GestionProductos.java` (o usar *File → Open* apuntando a esta carpeta si
   ya la clonaron con Git dentro de IntelliJ vía *Git → Clone*).
3. Click derecho sobre `GestionProductos.java` → **Run 'GestionProductos.main()'**
   (o el ícono ▶ verde al lado del método `main`).
4. Usar el menú numérico que aparece en la consola de ejecución de IntelliJ
   (panel inferior) para registrar productos, listar, buscar, vender,
   reabastecer y ver el valor total del inventario.

### Alternativa por terminal (opcional)
```
javac Producto.java GestionProductos.java
java GestionProductos
```

## Decisiones de diseño (para completar en el video / sustentación)
- Se separó el **modelo de datos** (`Producto`) de la **lógica de ejecución/menú**
  (`GestionProductos`) para mantener el código ordenado y coherente con POO.
- Se usó un **arreglo de tamaño fijo** (`Producto[MAX_PRODUCTOS]`) en lugar de
  colecciones (`ArrayList`, etc.) porque el sílabo hasta la semana 4 solo cubre
  fundamentos, clases, constructores/métodos y estructuras de control.
- Se validó el stock con un método propio (`validarStock()`) y se evitó dejar
  stock negativo en `reducirStock()`, cuidando la integridad de los datos.
- *(Agregar aquí cualquier otra decisión que el equipo tome al adaptar el
  código, por ejemplo si cambian atributos, agregan categorías, etc.)*

## Video de exposición
Enlace al video de YouTube: ____________________

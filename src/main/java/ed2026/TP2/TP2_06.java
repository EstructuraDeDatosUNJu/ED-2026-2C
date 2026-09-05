import java.util.Scanner;

/**
 Se desea cargar, en una matriz de dos dimensiones, las ventas realizadas por varios vendedores a lo largo de
varios días del mes. Se debe solicitar al usuario el número de vendedores (filas) y el número de días
(columnas). A continuación, ingresar los montos de las ventas para cada vendedor en cada día. Una vez cargada la matriz, el programa debe:
* a) Calcular y mostrar el total de ventas acumuladas por cada vendedor.
b) Calcular y mostrar el promedio de ventas de cada día.
c) Encontrar y mostrar la venta de mayor monto y la de menor monto de toda la matriz, indicando qué
vendedor y en qué día se produjo (índices de fila y columna).
d) Obtener la cantidad de vendedores que superan un monto objetivo de ventas en la totalidad de los días
(objetivo ingresado por el usuario).
e) Obtener la cantidad de ventas que superaron el promedio general diario en un día específico ingresado
por el usuario.
f) Crear un arreglo que contenga el promedio de ventas de cada vendedor.
*
*/

public class TP2_06 {

  
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in); // inicializa el objeto scanner

        int cantidadVendedores = Ventas.leerEnteroPositivo( scanner,"Ingrese la cantidad de vendedores: "); //fn que lee lo que ingresa el usuario y envia un msj

        int cantidadDias = Ventas.leerEnteroPositivo(scanner,"Ingrese la cantidad de días: "); //fn que lee lo que ingresa el usuario y envia un msj

        double[][] ventas = new double[cantidadVendedores][cantidadDias]; // crea un arreglo de dos dimenciones con los dias y vendedores
        //fn 
        Ventas.cargarVentas(scanner, ventas); 
        Ventas.mostrarTotalesPorVendedor(ventas);
        Ventas.mostrarPromediosPorDia(ventas);
        Ventas.mostrarVentaMayorYMenor(ventas);

        double objetivo = Ventas.leerMontoNoNegativo(scanner,"\nIngrese el monto objetivo de ventas: ");

        int vendedoresQueSuperanObjetivo =Ventas.contarVendedoresQueSuperanObjetivo(ventas,objetivo);

        System.out.println("Cantidad de vendedores que superan $" +objetivo + ": " +vendedoresQueSuperanObjetivo);

        int diaIngresado = Ventas.leerDiaValido(scanner,ventas[0].length);

        int cantidadQueSuperaPromedio =Ventas.contarVentasSobrePromedioDelDia(ventas,diaIngresado - 1);

        System.out.println("Cantidad de ventas que superaron el promedio del día "+ diaIngresado + ": "+ cantidadQueSuperaPromedio);

        double[] promedios =Ventas.obtenerPromediosPorVendedor(ventas);

        System.out.println("\nPromedio de ventas por vendedor:");

        for (int vendedor = 0;vendedor < promedios.length;vendedor++) {

            System.out.println("Vendedor " + (vendedor + 1)+ ": $" + promedios[vendedor]);
        }

        scanner.close();
    }
}
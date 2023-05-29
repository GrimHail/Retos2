//Importamos la clase Scanner de la libreria Scanner
import java.util.Scanner;
public class RetoII {
    public static void main(String args[]){
        //Creamos el objeto dela clase Scanner
        Scanner sc = new Scanner(System.in);

        //Declaramos las variables necesarias
        float  lista[], m, tiempoCompetidor[], tiempoSegundos;
        int cantidadCompetidores,  num = 0,  tiempo;
        String nombreCompetidor[], nombre;

        //Mensaje para el usuario
        //Pedimos la cantidad de competidores
        System.out.println("Bienvenido al Programa para conocer cual es el jugador con el menor tiempo.");
        System.out.print("Digita la cantidad de competidores que compitieron en la natacion: ");
        //Declaramos la cantidad de los arrays
        tiempoCompetidor = new float [cantidadCompetidores = sc.nextInt()];
        nombreCompetidor = new String [cantidadCompetidores];
        lista = new float[cantidadCompetidores];

        //Hacemos que el usuario digite los nombres con sus tiempos de los competidores
        //Usando un for para que la posicion donde se guardan los datos cambie
        for (int i = 0; i < nombreCompetidor.length; i+=1){
            //Solicitamos al usuario que digite el nombre del competidor
            System.out.print("Digita el nombre del competidor N°"+ (i+1)+" : ");
            //Almacenamos el nombre y lo ubicamos dentro de array
            nombreCompetidor[i] = (nombre = sc.next());
            //Solicitamos al usuario que digite el tiempo del competidor en minutos
            System.out.print("Digita el tiempo en el que recorrio el competidor N°"+ (i+1)+" en minutos: ");
            //Almacenamos el tiempo y lo ubicamos dentro de array
            tiempoCompetidor[i] = (tiempo = sc.nextInt());
            lista[i] = tiempo;
            //Solicitamos al usuario que digite el tiempo del competidor en segundos
            System.out.print("Digita el tiempo en el que recorrio el competidor N°"+ (i+1)+" en segundos: ");
            //Almacenamos el tiempo y lo ubicamos dentro de array y dividimos
            //Se divide en 60 para obteber el equivalente de segundos a minutos
            tiempoSegundos = sc.nextFloat() / 60;
            //Sumamos ese equivalente a los minutos
            tiempoCompetidor[i] = tiempoCompetidor[i] + tiempoSegundos;

        }

        //Mostramos los encabezados de la tabla de resultados
        System.out.println("Tabla de Competidores");
        System.out.println("|           Nombre Compedidor             |         Tiempo Competidor (min)        |");
        // Mostramos los competidores y sus tiempos segun su orden de ingreso en el programa
        //Con el ciclo de for hacemos que la posicion cambie y muestre todos los registros en el array
        for (int i = 0; i < tiempoCompetidor.length; i+=1){
            System.out.println("| "+ (i+1) +"      "+nombreCompetidor[i]+ "          |      " + tiempoCompetidor[i] + "       |");
        }

        //Extraemos el mejor tiempo de los ingresados
        //Con este ciclo for vamos a ejecutar el codigo de "depuración" para organizar los tiempos
        for (int j = 0; j < tiempoCompetidor.length-1; j+=1){
            //Condicional para saber que numero es menor y luego cambiar de posiciones
            if (lista[j] > lista[j+1]) {
                m = lista[j];
                lista[j] = lista[j+1];
                lista[j+1] = m;

            }
        }

        //Ciclo for para ubicar cual es el mejor tiempo y cual fue el nombre del competidor con mejor
        for (int i = 0; i < lista.length; i+=1){
            //Ubicar la posicion del nombre
            if (lista[0] == tiempoCompetidor[i]){
                num = i;
            }
        }

        //Mostramos el resultado del jugador con el mejor tiempo
        System.out.println("El ganador del primer puesto en la competencia es:");
        System.out.println("Ganador " +nombreCompetidor[num] + " con el mejor tiempo de " + tiempoCompetidor[num] + " minutos");
        //Cerramos el buffer
        sc.close();
    }
}

//Importamos la clase Scanner de la libreria Scanner
import java.util.Scanner;
public class RetoI {
    public static void main(String args[]){
        //Creamos el objeto dela clase Scanner
        Scanner sc = new Scanner(System.in);

        //Declaramos las variables
        int cantidadCompetidores, tiempoCompetidor[], tiempo, num = 0, lista[], m;
        String nombreCompetidor[], nombre;

        //Pedimos la cantidad de competidores
        System.out.println("Bienvenido al Programa para conocer cual es el jugador con el menor tiempo.");
        System.out.print("Digita la cantidad de competidores que compitieron en la natacion: ");
        tiempoCompetidor = new int [cantidadCompetidores = sc.nextInt()];
        nombreCompetidor = new String [cantidadCompetidores];
        lista = new int[cantidadCompetidores];

        //Hacemos que el usuario digite los nombres con sus tiempos de los competidores
        for (int i = 0; i < nombreCompetidor.length; i+=1){
            System.out.print("Digita el nombre del comptidor N°"+ (i+1)+" : ");
            nombreCompetidor[i] = (nombre = sc.next());
            System.out.print("Digita el tiempo en el que recorrio el competidor N°"+ (i+1)+" en minutos: ");
            tiempoCompetidor[i] = (tiempo = sc.nextInt());
            lista[i] = tiempo;
        }

        System.out.println("Tabla de Competidores");
        System.out.println("|           Nombre Compedidor             |         Tiempo Competidor (min)        |");
        // Mostramos los competidores y sus tiempos
        for (int i = 0; i < tiempoCompetidor.length; i+=1){
            System.out.println("| "+ (i+1) +"      "+nombreCompetidor[i]+ "          |      " + tiempoCompetidor[i] + "       |");
        }

        //Extraemos el mejor tiempo
        for (int i = 0; i < tiempoCompetidor.length; i+=1){
            for (int j = 0; j < tiempoCompetidor.length-1; j+=1){
                if (lista[j] > lista[j+1]) {
                    m = lista[j];
                    lista[j] = lista[j+1];
                    lista[j+1] = m;

                }
            }
        }

        for (int i = 0; i < lista.length; i+=1){
            if (lista[0] == tiempoCompetidor[i]){
                num = i;
            }
        }

        System.out.println("El ganador del primer puesto en la competencia es:");
        System.out.println("Ganador " +nombreCompetidor[num] + " con el mejor tiempo de " + tiempoCompetidor[num] + " minutos");
        sc.close();
    }
}

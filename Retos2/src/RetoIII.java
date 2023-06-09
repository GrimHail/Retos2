//Importamos la clase de Scanner que se encuentra en la libreria de Scanner
import java.util.Scanner;
public class RetoIII {
    public static void main(String args []) {
        //Declaramos Variables
        float  notas[], valorNota, sumaNotas = 0, nota, promedioNotas;
        int cantidadNotas;

        //Creamos el objeto de la clase Scanner
        Scanner sc = new Scanner(System.in);

        //Mensajes de guia para el usuario
        System.out.println("Bienvenido al Programa para las notas de la Asignatura JAVA");
        System.out.print("Digita la cantidad de notas para sacar el promedio:");
        //Definimos el tamaño del array
        notas = new float [cantidadNotas = sc.nextInt()];

        //Capturamos las notas dentro del array
        //Ciclo for
        for (int i = 0; i < notas.length; i +=1){
            System.out.print("Digita la nota N°"+ (i+1) + " de la asignatura de JAVA: ");
            notas [i] = (valorNota = sc.nextFloat());
        }

        //Sumamos los valores dentro de una variable
        //Ciclo for
        for (int i = 0; i < notas.length; i +=1){
            nota = notas[i];
            sumaNotas = sumaNotas + nota;
        }

        promedioNotas = sumaNotas / notas.length;

        System.out.println("Tu nota final fue de "+ promedioNotas + ". Este es el promedio de tus notas.");

        if (promedioNotas < 3) {
            System.out.println("Es una pena, reprobaste la asignatura de JAVA.");
        } else if (promedioNotas >= 3 && promedioNotas <= 4){
            System.out.println("Se te informa que pasaste la asignatura de JAVA RASPANDO.");
        } else if (promedioNotas > 4){
            System.out.println("Bien Hecho, Aprobaste con buenos resultados la asignatura de JAVA.");
        }
        sc.close();
    }
}

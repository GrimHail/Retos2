//Importamos la clase de Scanner del paquete
import java.util.Scanner;

public class RetoIV {
    public static void main(String[] args) {
        //Declaramos variebles e Inicializamos las matrices
        String [][] nombreProducto = new String[4][4];
        int [][] precioProducto = new int[4][4];
        String letra, letraMaquina = null;
        int i ,j;

        //Creamos el objeto de la clase Scanner
        Scanner sc = new Scanner(System.in);

        //Llenamos los matrices
        //Nombres de los Productos
        nombreProducto [0][0] = "Papas Margarita";
        nombreProducto [0][1] = "Galletas Waffer";
        nombreProducto [0][2] = "Chocolatinas Jet";
        nombreProducto [0][3] = "Chiclets Adams";
        nombreProducto [1][0] = "Manimoto";
        nombreProducto [1][1] = "Chocorramo";
        nombreProducto [1][2] = "Agua Cristal";
        nombreProducto [1][3] = "Coca Cola";
        nombreProducto [2][0] = "Jugo Hit";
        nombreProducto [2][1] = "Trocipollos";
        nombreProducto [2][2] = "Pinguinos";
        nombreProducto [2][3] = "Gol";
        nombreProducto [3][0] = "Burbuja Jet";
        nombreProducto [3][1] = "Gomitas";
        nombreProducto [3][2] = "Mentas Chao";
        nombreProducto [3][3] = "Bom Bom Bum";

        //Precio de los Productos
        precioProducto [0][0] = 1500;
        precioProducto [0][1] = 800;
        precioProducto [0][2] = 1000;
        precioProducto [0][3] = 600;
        precioProducto [1][0] = 800;
        precioProducto [1][1] = 1300;
        precioProducto [1][2] = 1500;
        precioProducto [1][3] = 1700;
        precioProducto [2][0] = 1200;
        precioProducto [2][1] = 900;
        precioProducto [2][2] = 2500;
        precioProducto [2][3] = 1500;
        precioProducto [3][0] = 700;
        precioProducto [3][1] = 2000;
        precioProducto [3][2] = 1500;
        precioProducto [3][3] = 400;

        System.out.println("Maquina Expendedora");

        //Generamos letras necesarias para mostrar cordenadas al usaurio
        for (i = 0; i < 4; i+=1){
            switch (i){
                case 0:
                    letraMaquina = "A";
                    break;
                case 1:
                    letraMaquina = "B";
                    break;
                case 2:
                    letraMaquina = "C";
                    break;
                case 3:
                    letraMaquina = "D";
                    break;
            }

            //Con el ciclo de for mostramos las opciones disponibles
            System.out.println("\n____________________________________________________________________________________________________________________________________________________\n");
            for (j = 0; j <4; j+=1){
                System.out.print("|      COD " + letraMaquina + (j+1) + "  " + nombreProducto[i][j] + "  $" + precioProducto[i][j] + "   |");
            }
            System.out.println("\n____________________________________________________________________________________________________________________________________________________\n");

        }

        //Solicitamos el codigo de la posicion al usuario
        System.out.println("\nDigita  el codigo del producto que quieres (ej: A1, D4): ");
        System.out.print("Letra: ");
        letra = sc.next().toLowerCase();
        System.out.print("Numero: ");
        j = sc.nextInt()-1;

        //Segun la letra que ingrese el usuario seleccionamos la posicion de la fila
        switch (letra){
            //Mostramos en cada case el resultado obtenido
            case "a":
                i = 0;
                System.out.println("____________________");
                System.out.println("|       " + letraMaquina + (j+1) );
                System.out.println("|  " + nombreProducto[i][j]); 
                System.out.println("|   $" + precioProducto[i][j]);
                System.out.println("____________________");
                break;
            case "b":
                i = 1;
                System.out.println("____________________");
                System.out.println("|       " + letraMaquina + (j+1));
                System.out.println("|  " + nombreProducto[i][j]); 
                System.out.println("|   $" + precioProducto[i][j]);
                System.out.println("____________________");
                break;
            case "c":
                i = 2;
                System.out.println("____________________");
                System.out.println("|       " + letraMaquina + (j+1));
                System.out.println("|  " + nombreProducto[i][j]); 
                System.out.println("|   $" + precioProducto[i][j]);
                System.out.println("____________________");
                break;
            case "d":
                i = 3;
                System.out.println("____________________");
                System.out.println("|       " + letraMaquina + (j+1));
                System.out.println("|  " + nombreProducto[i][j]); 
                System.out.println("|   $" + precioProducto[i][j]);
                System.out.println("____________________");
                break;
            default:
                System.out.println("Ingresaste un valor NO VALIDO");
        }
    }
}

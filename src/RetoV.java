//Importamos la clase Scanner del package Scanner
import java.util.Scanner;
public class RetoV {
    public static void main(String[] args) {
        //Creamos el objeto de la clase Scanner
        Scanner sc = new Scanner(System.in);

        //Declaramos las variables y la Matriz
        String[][] juego = new String[3][4];
        String  preg, a = null;
        int columna, fila, pregFila = 0, pregColumna = 0, m = 0, n = 0, inte = 0;
        String [] compr = new String[2];
        String[][] vista = new String[3][4];
        int [] posiciones = new int[4];

        //Preguntar si el usuario quiere jugar
        System.out.print("¿Quieres jugar concentrese? si o no : ");
        preg = sc.next().toLowerCase();

        //Ciclo while para repetir el codigo cuantas veces quiera el usuario
        while (preg.equalsIgnoreCase("si")) {
            for (int i = 0; i < 3; i +=1){
                for (int j = 0; j < 4;j +=1){
                    juego[i][j] = null;
                }
            }

            for (int i = 0; i < 3; i +=1) {
                for (int j = 0; j < 4; j += 1) {
                    vista[i][j] = null;
                }
            }

            for (int i = 0; i < 6; i +=1){
                switch (i){
                    case 0:
                        a = "♦";
                        break;
                    case 1:
                        a = "☻";
                        break;
                    case 2:
                        a = "♥";
                        break;
                    case 3:
                        a = "♣";
                        break;
                    case 4:
                        a = "♠";
                        break;
                    case 5:
                        a = "☼";
                        break;
                    default:

                }
                for (int j = 0; j < 2;){
                    columna = (int)(Math.random()*4);
                    fila = (int)(Math.random()*3);
                    if (juego [fila][columna] == null) {
                        juego [fila][columna] = a;
                        j+=1;
                    }
                }

            }

            while (m < 12){
                while (inte < 3) {
                    for (int j = 0; j < 3; j +=1) {
                        System.out.println("\n");
                        for (int k = 0; k < 4; k += 1) {
                            System.out.print(vista[j][k] + " |");
                        }
                    }

                    /*
                    for (int j = 0; j < 3; j +=1) {
                        System.out.println("\n");
                        for (int k = 0; k < 4; k += 1) {
                            System.out.print(juego[j][k] + " |");
                        }
                    }*/

                    for (int j = 0; j < 2; j+=1){
                        //Preguntar cuales quiere comparar
                        System.out.print("\n\n¿Cual fila vas a comprobar del intento "+ (inte+1) +" ?: ");
                        pregFila = sc.nextInt()-1;
                        posiciones[j+j] = pregFila;
                        System.out.print("¿Cual columna vas a comprobar del intento "+ (inte+1) +" ?: ");
                        pregColumna = sc.nextInt()-1;
                        posiciones[j+j+1] = pregColumna;

                        compr[j] = juego [pregFila][pregColumna];

                        System.out.println("Seleccionaste el simbolo " + compr[j]);
                    }

                    //Comprobamos si los signos si coinciden
                    if (compr[0] != null && compr[1] != null && compr[0].equalsIgnoreCase(compr[1]) && juego [pregFila][pregColumna] != null && posiciones[0] != posiciones[2] && posiciones[1] != posiciones[3]) {
                        System.out.println("Felicidades acertaste.");

                        //Cambiamos ponemos esos simbolos dentro de lo que va a ver el usuario para que sepa cuales a descubierto
                        for (int j = 0; j < 2; j+=1){
                            vista[posiciones[j+j]][posiciones[j+j+1]] = juego [pregFila][pregColumna];
                            juego[posiciones[j+j]][posiciones[j+j+1]] = null;
                        }


                        //Verificamos si ha terminado de encontrar las parejas
                        m = 0;
                        for (int j = 0; j < 3; j +=1) {
                            for (int k = 0; k < 4; k += 1) {
                                if (vista[j][k] != null){
                                    m+=1;
                                }
                            }
                        }
                        //SI termino de encontrar las parejas acabamos con los intentos
                        if(m == 12){
                            inte = 3;
                            n = 1;
                        }
                        System.out.println(inte);

                    } else if (juego [pregFila][pregColumna] == null) {
                        System.out.println("La casilla que seleccionaste, ya habias encontrado su pareja");
                    } else if (posiciones[0] == posiciones[2] && posiciones[1] == posiciones[3]) {
                        System.out.println("Intentaste hacer trampa, fuiste castigado y pierdes un intento");
                        inte +=1;
                        n = 2;
                    } else{
                        System.out.println("Fallaste, este fue tu intento numero " + (inte+1));
                        inte +=1;
                        n = 2;
                    }

                }

            }


            switch (n){
                case 1:
                    System.out.println("Felicidades, terminaste");
                    m = 0;
                    inte = 0;
                    break;
                case 2:
                    System.out.println("Has perdido y acabaste con el numero de intentos permitidos");
                    break;
            }


            System.out.print("\n¿Quieres jugar concentrese? si o no :");
            preg = sc.next().toLowerCase();
        }
        sc.close();
    }
}



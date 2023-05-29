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

            //Con el ciclo for llenamos el array de juego con valores de null
            //para luego verificar y no guardar dos pares desimbolos iguales
            //for para la posicion de filas
            for (int i = 0; i < 3; i +=1){
                //for para la posicion de columnas
                for (int j = 0; j < 4;j +=1){
                    juego[i][j] = null;
                }
            }

            //Con el ciclo for llenamos el array de vista con valores de null
            //for para la posicion de filas
            for (int i = 0; i < 3; i +=1) {
                //for para la posicion de columnas
                for (int j = 0; j < 4; j += 1) {
                    vista[i][j] = null;
                }
            }

            //Ciclo for para seleccionar que simbolo va a ser usado y que numero de parejas
            for (int i = 0; i < 6; i +=1){
                //Switch para asignar un  valor a la variable a
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

                }
                //for para llenar una pareja dentro del array juego
                for (int j = 0; j < 2;){
                    //Asignamos posiciones random
                    columna = (int)(Math.random()*4);
                    fila = (int)(Math.random()*3);
                    //Condicional para saber si la poscion elegida se encuentra ocupada
                    if (juego [fila][columna] == null) {
                        //LLenamos esa posicion con el simbolo
                        juego [fila][columna] = a;
                        //Sumamos para asignar la posicion al mismo simbolo pero en otra posicion
                        j+=1;
                    }
                }

            }

            //Ciclo while para verificar si el usuario completo el juego correctamente
            while (m < 12){
                //Ciclo while para no pasar el numero de intentos
                while (inte < 3) {

                    //Ciclo for para imprimir el progreso del usuario
                    for (int j = 0; j < 3; j +=1) {
                        System.out.println("\n");
                        for (int k = 0; k < 4; k += 1) {
                            System.out.print(vista[j][k] + " |");
                        }
                    }

                    //For para saber si funciona y mostrar las posiciones de los simbolos
                    /*
                    for (int j = 0; j < 3; j +=1) {
                        System.out.println("\n");
                        for (int k = 0; k < 4; k += 1) {
                            System.out.print(juego[j][k] + " |");
                        }
                    }*/

                    //Ciclo for para seleccionar los dos simbolos, poner sus posiciones
                    for (int j = 0; j < 2; j+=1){
                        //Preguntar cual fila del simbolo
                        System.out.print("\n\n¿Cual fila vas a comprobar del intento "+ (inte+1) +" ?: ");
                        pregFila = sc.nextInt()-1;
                        //Almacenamos esa fila en un array para una verificacnion futura
                        posiciones[j+j] = pregFila;
                        //Preguntar cual columna del simbolo
                        System.out.print("¿Cual columna vas a comprobar del intento "+ (inte+1) +" ?: ");
                        pregColumna = sc.nextInt()-1;
                        //Almacenamos esa columna en un array para una verificacnion futura
                        posiciones[j+j+1] = pregColumna;

                        //Almacenamos el simbolo elegido para ser comparado luego
                        compr[j] = juego [pregFila][pregColumna];

                        //Mostramos el simbolo que fue elegido
                        System.out.println("Seleccionaste el simbolo " + compr[j]);
                    }

                    //Comprobamos si los signos si coinciden, no fueron previamente seleccionados y si ingrso las mismas cordenadas dos veces
                    if (compr[0] != null && compr[1] != null && compr[0].equalsIgnoreCase(compr[1]) && juego [pregFila][pregColumna] != null && posiciones[0] != posiciones[2] && posiciones[1] != posiciones[3]) {
                        System.out.println("Felicidades acertaste.");

                        //Cambiamos ponemos esos simbolos dentro de lo que va a ver el usuario para que sepa cuales a descubierto
                        for (int j = 0; j < 2; j+=1){
                            vista[posiciones[j+j]][posiciones[j+j+1]] = juego [pregFila][pregColumna];
                            juego[posiciones[j+j]][posiciones[j+j+1]] = null;
                        }


                        //Verificamos si ha terminado de encontrar las parejas
                        //Limpiador de la variables
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
                            //Variable para luego saber si termino el juego exitosamente
                            n = 1;
                        }
                    //Condicional para saber si la casilla seleccionada ya fue seleccionada
                    } else if (juego [pregFila][pregColumna] == null) {
                        System.out.println("La casilla que seleccionaste, ya habias encontrado su pareja");
                    //Condicional para saber si el usuario ingreso la misma cordenada para validar
                    } else if (posiciones[0] == posiciones[2] && posiciones[1] == posiciones[3]) {
                        System.out.println("Intentaste hacer trampa, fuiste castigado y pierdes un intento");
                        inte +=1;
                        n = 2;
                    } else{
                        //Condicional para cuando el usaurio fallo
                        System.out.println("Fallaste, este fue tu intento numero " + (inte+1));
                        //Aumentamos el numero de intentos
                        inte +=1;
                        //Variable n par verificar si el usaurio fallo
                        n = 2;
                    }
                }

            }

            //Validacion de lqa variable n  y saber si el usuario fallo o no
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


            //Preguntar si el usuario quiere jugar de nuevo
            System.out.print("\n¿Quieres jugar concentrese? si o no :");
            preg = sc.next().toLowerCase();
        }
        //Cerramos el buffer
        sc.close();
    }
}



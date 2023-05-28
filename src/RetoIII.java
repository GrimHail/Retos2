//Importar la libreria de Scanner
import java.util.Scanner;
public class RetoIII {
    public static void main(String[] args) {
        //Declaramos las variables y si es necesario les asignamos un valor
        String pregunta, pal, letra, palabra []  = null, vista[] = null, compr[], palab = null;
        int inte = 0, num = 0, num_1 = 0, l , m, a;

        //Creamos la clase scanner para poder capturar datos
        Scanner sc = new Scanner(System.in);

        //Imprimimos las opciones del Usuario
        System.out.println("=========================================================================================");
        System.out.println("|                                                                                       |");
        System.out.println("|                              « Video Juego de Ahoracado »                             |");
        System.out.println("|                                                                                       |");
        System.out.println("=========================================================================================");
        //Preguntamos si el usuario queria jugar
        System.out.println("|                                                                                       |");
        System.out.println("|                              « ¿Quieres Jugar? »                                      |");
        System.out.println("|                              Responde 'Si' o 'No'                                     |");
        //Capturamos el dato y con el metodo de toLowerCase(); se vueleve minucula
        pregunta = sc.next().toLowerCase();
        System.out.println("|                                                                                       |");
        System.out.println("=========================================================================================");

        //Condicion multiple para comparar si quiere jugar
        switch (pregunta){
            case "si":
                System.out.println("=========================================================================================");
                System.out.println("|                                                                                       |");
                System.out.println("|                      « ¿Cuantas letras tiene tu palabra? »                            |");
                //Cuantas letras va a tener la palabra
                palabra = new String[num = sc.nextInt()];
                vista = new String[num];
                compr = new String[num];
                System.out.println("|                                                                                       |");
                System.out.println("=========================================================================================");

                //Ciclo for para pedir y capturar las letras de la palabra
                //Usamos length para contar el numero de espacios para el array
                for (int i = 0; i < palabra.length; i++){
                    System.out.print("Ingresa la letra N°"+(i+1)+" de tu palabra: ");
                    palabra[i] = (pal = sc.next().toLowerCase());
                    compr[i] = pal;
                    vista[i] = "_";
                }

                while (num_1 < palabra.length){
                    //Ciclo for para que el jugador ingrese el numero de letras segun el numero de espacios dentro del array
                    while(inte < 3){
                        a=0;
                        //Ciclo while para el numero maximo de intentos de adivinar
                        for(int i = 0; i < palabra.length;){
                            System.out.println("\n");

                            for (int j = 0; j < vista.length; j+=1){
                                System.out.print(vista[j]);
                            }

                            System.out.println("\n\nEste es tu intento numero: " + (inte+1));
                            System.out.print("Digite la letra N°" + (i+1) + " : ");
                            letra = sc.next().toLowerCase();


                            m = 0;
                            num_1 = 0;
                            l = 0;
                            for (int j = 0; j < palabra.length; j+=1){
                                if (compr[j].equalsIgnoreCase(letra) && palabra[j] != null){
                                    i+=1;
                                    vista[j] = palabra[j];
                                    palabra[j] = null;
                                    break;
                                } else if (palabra[j] == null && compr[j].equalsIgnoreCase(letra)) {
                                    palab = vista[j];
                                    l=1;
                                } else {
                                    m+=1;
                                }
                            }

                            if (l != 0){
                                System.out.println("Esta letra ya no se repite");
                                if (a == 0){
                                    l = 0;
                                }
                            }

                            for (int j = 0; j< palabra.length; j+=1){
                                if (palabra[j] == null){
                                    num_1+=1;
                                }
                            }

                            if (m == palabra.length){
                                System.out.println("La letra ingresada es incorrecta");
                                inte+=1;
                            }


                            if (num_1 == palabra.length){
                                inte = 4;
                                break;
                            }

                        }
                    }
                }
                break;

            case "no":
                //Mustra en caso de que no quiera jugar
                System.out.println("Regresa a jugar cuando quieras");
                break;
            //Muestra en caso de que ingrese un dato no valido
            default :
                System.out.println("ERROR: El mensaje recibido no es valido.Vuelve a intentar");
        }

        //Condicional para saber si se acerto correctamente todas las letras
        if(num_1 == palabra.length){
            System.out.println("FELICIDADES, Ganaste. La palabra es:");
            //Ciclo para mostrar la palabra guardada
            for (int i = 0; i < palabra.length; i++){
                System.out.print(vista[i]);
            }
            //Mensaje para saber si gasto todos sus golpes
        }else if(inte == 3){
            System.out.println("Excediste el numero de intentos");
        }

        sc.close();
    }
}

/*
*
*
* //Condicional if-else para comparar la letra ingresada por el usuario con la letra segun la posicion
                        if (palabra[j].equalsIgnoreCase(letra)) {
                            System.out.println("Bien. La letra N°" + j + " es " + letra + "\n");
                            //Contador para saber si hizo correctamente todo
                            num_1 += 1;
                            //Si acerto la letra el break hace que rompa el ciclo while y se diriga al for para que pueda avanzar a la siguiente posicion del array
                            break;
                            //Else para mostraar si la letra que ingreso no es la misma
                        } else {
                            System.out.println("Erroneo. La letra ingresada es incorrecta");
                            //Aumentador de intentos
                            inte += 1;
                        }*/
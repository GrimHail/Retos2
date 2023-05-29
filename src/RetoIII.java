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
                //Capturamos cual es la cantidad de espacios en el array
                //Array para guardar la palabra que asigna el usuario
                palabra = new String[num = sc.nextInt()];
                //Array que va a observar el usuario
                vista = new String[num];
                //Array para realizar a comparacion de las elecciones del usuario
                compr = new String[num];
                System.out.println("|                                                                                       |");
                System.out.println("=========================================================================================");

                //Ciclo for para pedir y capturar las letras de la palabra
                //Usamos length para contar el numero de espacios para el array
                for (int i = 0; i < palabra.length; i++){
                    System.out.print("Ingresa la letra N°"+(i+1)+" de tu palabra: ");
                    palabra[i] = (pal = sc.next().toLowerCase());
                    //Guradamos los mismos valores en los mismos espacios del array que va a observar el usuario
                    compr[i] = pal;
                    //Guardamos los valores que va a ver el creador del juego en primera instancia
                    vista[i] = "_";
                }

                // Ciclo while para que el codigo se ejecute el numero de veces del tamaño del array.
                //Este array es usado para que cuaando el usuario gane, termine el juego
                while (num_1 < palabra.length){
                    //Ciclo while para condicionar que no se excedan el numero de intentos permitidos
                    while(inte < 3){
                        //Contador para saber si seguir mostrando un mensaje
                        a=0;
                        // Ciclo for para que  se vayan comparando diferentes posiciones de las letras
                        for(int i = 0; i < palabra.length;){
                            System.out.println("\n");

                            //Ciclo for para mostrar el progreso en mostrar las parejas que se han encontrado
                            for (int j = 0; j < vista.length; j+=1){
                                System.out.print(vista[j]);
                            }

                            //Mensajes para mostrar el numero de intentos que llevan y solicitar la letra
                            System.out.println("\n\nEste es tu intento numero: " + (inte+1));
                            System.out.print("Digite la letra N°" + (i+1) + " : ");
                            letra = sc.next().toLowerCase();


                            //Contadores/Limpiadores
                            //Contador cuenta las veces que la letra fue comparada y no estaba dentro del array.Limpiador
                            m = 0;
                            //Contador para saber si ya no hay mas letras que comparar. Limpiador
                            num_1 = 0;
                            //Contador para saber si seguir mostrando un mensaje.Limpiador
                            l = 0;

                            //Ciclo for para comparar si la letra que se ingreso es correcta
                            for (int j = 0; j < palabra.length; j+=1){
                                //Condicional para saber si es correcta la palabra y que esta no se haya ingresado antes
                                if (compr[j].equalsIgnoreCase(letra) && palabra[j] != null){
                                    //Contador para mostrar que ya se puede seguir a la siguiente letra
                                    i+=1;
                                    //Guardamos la letra que selecciono el usuario para mostrarla y mostrar el progreso
                                    vista[j] = palabra[j];
                                    //Guardamos un null dentro del array palabra para que no se compare esa posicion
                                    palabra[j] = null;
                                    //Rompemos el ciclo para que siga con la siguiente palabra
                                    break;

                                //Condicional en caso de que el usuario ingreso una letra que ya fue verificada
                                } else if (palabra[j] == null && compr[j].equalsIgnoreCase(letra)) {
                                    //Guardamos la letra que el usuario ingreso
                                    palab = vista[j];
                                    //Variable para luego mostrar al usuario que esa letra ya no se repite
                                    l=1;

                                } else {
                                    //Contador que va sumando las veces que la letra fue comparada y no estaba dentro del array
                                    m+=1;
                                }
                            }

                            //Condicional para saber si mostrar un mensaje
                            if (l != 0){
                                //Mensaje de que la palabra ingresada ya fue registrada
                                System.out.println("Esta letra "+palab+" ya no se repite");
                                //Condicional para saber si seguir mostrando elm
                                if (a == 0){
                                    l = 0;
                                }
                            }

                            //Ciclo for para comparar si ya se termino de encontrar todas las letras
                            for (int j = 0; j< palabra.length; j+=1){
                                //Comparar si la posicion hay un null
                                if (palabra[j] == null){
                                    //Contador para ir sumando el numero de veces que hay null dentro del array
                                    num_1+=1;
                                }
                            }

                            //Condicional para saber si mostrar si la letra ingresada es incorrecta
                            if (m == palabra.length){
                                System.out.println("La letra ingresada es incorrecta");
                                //Contador para ir sumando cada vez que se equivoca el usuario
                                inte+=1;
                            }


                            //Condicional para acabar con el juego si el usuario acerto todas las oportunidades
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

        //Condicional para saber si se acerto correctamente todas las letras y mostrar mensaje de Felicitacion
        if(num_1 == palabra.length){
            System.out.println("FELICIDADES, Ganaste. La palabra es:");
            //Ciclo para mostrar la palabra guardada
            for (int i = 0; i < palabra.length; i++){
                System.out.print(vista[i]);
            }
        //Mensaje para saber si gasto todos sus intentos
        }else if(inte == 3){
            System.out.println("Excediste el numero de intentos");
        }

        //Cerramos el buffer
        sc.close();
    }
}
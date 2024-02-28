package cr.ac.una.tutoria1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author USUARIO PZ UNA
 */
public class Tutoria1 {

    public static void main(String[] args) {
        //los metodos se llaman igual que en c++

//        datosPrimitivos();
//        datosCompuestos();
//        createPerson();
//        condicionales(7);
//        System.out.println(condicionalesString(8));
        /*funcionTryCath(5);
        funcionTryCath(2);
        funcionTryCath(7);
        funcionTryCath(3);*/
    }

    public static void datosPrimitivos() {
        int numeroEntero = 1;
        float numeroFlotante = 1.1f;
        double numeroDouble = 1.1d;
        boolean variableBooleana = true;
        char letra = 's';

        int vectorNumeros[] = new int[10]; //Declarar un vector de tamaño 10
        vectorNumeros[0] = 5;

        int vectorNumeros2[] = {1, 2, 3, 4}; //Declarar un vector de tamaño 5 con valores predefinidos

        double vectorDoubles[] = new double[15]; //vector de double
        boolean vectorBooleanos[] = new boolean[10]; //vector de booleanos

        int[][] matrizNumeros = new int[5][5]; //matriz de enteros
        // Definir la matriz de 4x4 con valores predefinidos
        int[][] matriz = {
            {1, 2, 3, 4},
            {5, 6, 7, 8},
            {9, 10, 11, 12},
            {13, 14, 15, 16}
        };

        Arrays.sort(vectorNumeros); //forma de ordenar un vector simple

        System.out.println(numeroEntero + " - " + numeroDouble); //imprimir en consola
        System.out.println(letra);
    }

    public static void datosCompuestos() {
        Integer numeroEntero = 1;

        Double numeroDouble = 1.1d;
        numeroDouble.intValue(); //obtener solo el valor entero de una variable double
        System.out.println(numeroDouble);
        System.out.println(numeroDouble.intValue()); //imprimir solo el valor entero

        Boolean variableBooleana = true;
        String variableTexto = "Juan";

        //declarar una lista, la lista no tine un tamaño fijo
        //se pueden agfregar los datos que se desee
        List<Integer> listaEnteros = new ArrayList<>();
        listaEnteros.add(4); //agregar un solo valor a la lista
        listaEnteros.add(7);
        listaEnteros.addAll(List.of(1, 2, 3, 4, 5)); //agregar varios valores a la vez en la lista

        listaEnteros.clear(); //elimina todos los valores de la lista
        listaEnteros.isEmpty(); //devuelve true si la lista esta vacia
        listaEnteros.size(); //devuelve el tamaño de la lista
        Collections.sort(listaEnteros); //ordenar una lista
        Collections.shuffle(listaEnteros); //ordenar aleatoriamente una lista

        List<Integer> listaEnteros2 = List.of(1, 2, 3, 4); //declarar una lista con valores por defecto
        List<Double> listaDoubles = new ArrayList<>();

        List<List<Integer>> matrizInteger = new ArrayList<>(); //una lista de listas o "matriz"
        matrizInteger.add(listaEnteros); //a la matriz se le agrega una lista

        System.out.println(listaEnteros); //imprimir la lista entera..
    }

    public static void ciclos() {

        for (int i = 0; i < 10; i++) { //for igual a c++
        }
        
        boolean salir = false;
        while (!salir) {                //while igual a c++
        }

        do {                            //do-while igual a c++
        } while (!salir);

        //for-each
//        for (tipoDato nombreVariable : colección-Lista) {
//            // Cuerpo del bucle
//        }

        List<Integer> listaEnteros2 = List.of(1, 2, 3, 4);

        for (Integer valor : listaEnteros2) {
            System.out.println(valor);
        }
    }

    public static void condicionales(int numero) {
        //if-else igual a c++
        if (numero % 2 == 0) {
            System.out.println("El numero es par");
        } else {
            System.out.println("El numero es impar");
        }
        
        //utilizando el simbolo ternario ?
        String resultado = (numero % 2 == 0) ? "El numero es par" : "El numero es impar";
        System.out.println(resultado);
    }

    public static String condicionalesString(int numero) {
        return (numero % 2 == 0) ? "El numero es par" : "El numero es impar";
    }

    public static void manejoSwitch(int numero) {
        //switch igual a c++
        switch (numero) {
            case 1:
                break;
            case 2:
                break;
            case 3:
                break;
            case 4:
                break;
            default:
                throw new AssertionError();
        }
    }

    public static void manejoSwitch(String valor) {
        //en java se pueden utilizar switch con Strings
        switch (valor) {
            case "Luis":
                System.out.println("Me llamo Luis");
                break;
            case "Juan":
                System.out.println("Me llamo Juan");
                break;
            case "Andres":
                break;
            case "Maria":
                break;
            default:
                throw new AssertionError();
        }
    }

    public static void manejoSwitchLambda(int numero) {
        //en java se maneja el switch con el simbolo lambda (->)
        switch (numero) {
            case 1, 3 -> {
                System.out.println("Numero menor a 5 impar");
            }
            case 2, 4 -> {
                System.out.println("Numero menor a 5 par");
            }
            case 7, 9 -> {
                System.out.println("Numero mayor a 5 impar");
            }
            case 6, 8 -> {
                System.out.println("Numero mayor a 5 par");
            }
            default ->
                throw new AssertionError();
        }
    }

    public static void funcionTryCath(int number) { //funcion try-catch
        int vectorNumeros[] = {1, 2, 3, 4};
        try {
            int valor = vectorNumeros[number]; // La posición 5 no existe en este array
            System.out.println("El valor en la posición es: " + valor);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Se intentó acceder a una posición inválida del array.");
        }
    }
}

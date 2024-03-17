import java.util.Scanner;

public class App {
    public int sumaNumerosPares (int number) {
        int result = 0;
        for (int i = 0; i <= number; i+=2) {
            result += i;
        }
        return result;
    }

    public void tablaMultiplicar (int number, int limit) {
        System.out.println("----------Tabla del " + number + "----------");
        for (int i = 1; i <= limit; i++) {
            if (i%number==0) {
                System.out.println(number + "x" + i/5 + " = " + i);
            }
        }
    }

    public int calcularFactorial (int number) {
        int result = number;
        for (int i = number-1; i > 0; i--) {
            result*=i;
        }
        return result;
    }

    public void esPrimo(int number) {
        int contPrimo = 0;
        for (int i = number; i > 0; i--) {
            if (number%i==0) {
                contPrimo++;
            }
        }
        if (contPrimo==2){
            System.out.println("El numero " + number + " es un numero primo");
        }else{
            System.out.println("El numero " + number + " no es un numero primo");
        }
    }

    public String invertirNumero (int numero) {
        String numInvertidoString = numero + "";
        String numInvertido = "";
        for (int i = numInvertidoString.length()-1; i >= 0 ; i--) {
            String temp = numInvertidoString.substring(i,i+1);
            numInvertido += temp;
        }
        return numInvertido;
    }

    public int calcularPotencia (int numero, int potencia) {
        int result = 1;
        for (int i = 0; i < potencia; i++) {
            result*=numero;
        }
        return result;
    } 

    public int contarVocales (String cadena) {
        String cadenalow = cadena.toLowerCase();
        char[] vocales = {'a', 'e', 'i', 'o', 'u'};
        char[] abecedario = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 
                             'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', ' '};
        int contVocales = 0;
        for (int i = 0; i < cadena.length(); i++) {
            String temp = cadenalow.substring(i, i+1);
            for (int j = 0; j < vocales.length; j++) {
                if (temp.equals(vocales[j]+"")) {
                    contVocales++;
                }
            }
        }
        return contVocales;
    }
    public static void main(String[] args) throws Exception {
        Scanner lScanner = new Scanner(System.in);

        App app = new App();

        int op = 1;
        while (op!=0) {
            System.out.println("----------Menú principal----------");
            System.out.println("----------Marque 1 para sumar pares----------");
            System.out.println("----------Marque 2 para mostrar la tabla de multiplicar----------");
            System.out.println("----------Marque 3 para calcular factorial----------");
            System.out.println("----------Marque 4 para saber si un numero es primo----------");
            System.out.println("----------Marque 5 para invertir numero----------");
            System.out.println("----------Marque 6 para calcular potencia de un numero----------");
            System.out.println("----------Marque 7 para contar vocales----------");
            System.out.println("----------Marque 8 para sumar pares----------");
            System.out.println("----------Marque 9 para sumar pares----------");
            System.out.println("----------Marque 10 para sumar pares----------");
            System.out.println("----------Marque 0 para salir---------");
            op = lScanner.nextInt();
            switch (op) {
                case 1:
                System.out.println("Ingrese su numero limite");
                int number = lScanner.nextInt();
                System.out.println(app.sumaNumerosPares(number));

                case 2:
                System.out.println("Ingrese numero a mostrar tabla");
                int multiplo = lScanner.nextInt();
                System.out.println("Ingrese numero limite");
                int limit = lScanner.nextInt();
                app.tablaMultiplicar(multiplo, limit);

                case 3:
                System.out.println("Ingrese numero a calcular factorial");
                int numFactorial = lScanner.nextInt();
                System.out.println(app.calcularFactorial(numFactorial));

                case 4:
                System.out.println("Ingrese numero a verificar");
                int verificarPrimo = lScanner.nextInt();
                app.esPrimo(verificarPrimo);
            
                case 5:
                System.out.println("Ingrese numero a invertir");
                int numeroInvertir = lScanner.nextInt();
                System.out.println(app.invertirNumero(numeroInvertir));

                case 6:
                System.out.println("Ingrese un numero ");
                int numeroBase = lScanner.nextInt();
                System.out.print("Elevado a : ");
                int potencia = lScanner.nextInt();
                System.out.println(app.calcularPotencia(numeroBase, potencia));

                case 7:
                System.out.println("Ingrese la cadena");
                String cadena = lScanner.next();
                System.out.println("La palabra " + cadena + " contiene " + app.contarVocales(cadena) + " vocales");
                default:
                    break;
            }
        }
    }
}

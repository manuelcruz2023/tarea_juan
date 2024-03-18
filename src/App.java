import java.text.Normalizer;
import java.util.Scanner;
import java.util.regex.Pattern;

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
    public String deAccent(String str) {
      String nfdNormalizedString = Normalizer.normalize(str,  Normalizer.Form.NFD); 
      Pattern pattern = Pattern.compile("\\p{InCombiningDiacriticalMarks}+");
      return pattern.matcher(nfdNormalizedString).replaceAll("");
    }
    public int contarVocales (String cadena) {
        String cadenalow = cadena.toLowerCase();
        char[] vocales = {'a', 'e', 'i', 'o', 'u', 'á', 'é', 'í', 'ó', 'ú'};
        int contVocales = 0;
        for (int i = 0; i < cadena.length(); i++) {
            String temp = deAccent(cadenalow.substring(i, i+1));
            for (int j = 0; j < vocales.length; j++) {
                if (temp.equals(vocales[j]+"")) {
                    contVocales++;
                }
            }
        }
        return contVocales;
    }

    public void adivinarNumero () {
        Scanner lectura = new Scanner(System.in);
        int random = (int)(Math.random()*10+1);
        System.out.println("---------Bienvendio al juego de adivinar numeros---------");
        System.out.println("---------El numero secreto esta entre 1 y 10---------");
        System.out.println("---------Tienes 7 oportunidades, si se te acaban perderas---------");
        int jugar = 0;
        int contPistas = 7;
        while (jugar==0) {
            int condicion = 0;
            while (condicion!=random) {
                condicion = (int)(Math.random()*10+1);
            }
            System.out.println("tu numero menos el infinito despierto es = " + (condicion-8));
            System.out.println("Ingresa el numero");
            int rta = lectura.nextInt();
            if (rta==random) {
                System.out.println("Felicidades, ganaste");
                jugar++;
            }else{
                contPistas--;
                System.out.println("te quedan " + contPistas + " oportunidades");
            }
            if (contPistas==0) {
                System.out.println("Perdiste");
                jugar++;
            }
        }
    }

    public void masaCorporal (int peso, int estatura) {
        int imc = peso/(estatura*estatura);
        System.out.println("su IMC es = " + imc);
        if (imc<18.5) {
            System.out.println("Bajo peso");
        }
        if (18.5<=imc && imc<25) {
            System.out.println("peso normal");
        }
        if (25<=imc && imc <30) {
            System.out.println("sobrepeso");
        }
        if (imc<=30) {
            System.out.println("obesidad");
        }
    }

    public int calcularDescuento (int precio) {
        int precioFinal = precio;
        if (precio>50000 && precio<70000) {
            precioFinal = precio - ((precio*20)/100);
        }
        if (precio>70000&& precio<200000) {
            precioFinal = precio - ((precio*30)/100);
        }
        if (precio>200000) {
            precioFinal = precio - ((precio*50)/100);
        }
        return precioFinal;
    }
    public static void main(String[] args) throws Exception {
        Scanner lScanner = new Scanner(System.in);

        App app = new App();

        int jugar = 1;
        while (jugar!=0) {
            System.out.println("----------Menú principal----------");
            System.out.println("----------Marque 1 para sumar pares----------");
            System.out.println("----------Marque 2 para mostrar la tabla de multiplicar----------");
            System.out.println("----------Marque 3 para calcular factorial----------");
            System.out.println("----------Marque 4 para saber si un numero es primo----------");
            System.out.println("----------Marque 5 para invertir numero----------");
            System.out.println("----------Marque 6 para calcular potencia de un numero----------");
            System.out.println("----------Marque 7 para contar vocales----------");
            System.out.println("----------Marque 8 para adivinar un numero----------");
            System.out.println("----------Marque 9 para calcular IMC----------");
            System.out.println("----------Marque 10 para aplicar descuento----------");
            System.out.println("----------Marque 0 para salir---------");
            int op = lScanner.nextInt();
            switch (op) {
                case 0: 
                break;
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
                System.out.println("La palabra " + " contiene " + app.contarVocales(cadena) + " vocales");

                case 8:
                app.adivinarNumero();

                case 9:
                System.out.println("ingrese su peso en kg");
                int peso = lScanner.nextInt();
                System.out.println("ingrese su altura en metros");
                int altura = lScanner.nextInt();
                app.masaCorporal(peso, altura);

                case 10: 
                System.out.println("ingrese el precio de su producto");
                int precio = lScanner.nextInt();
                System.out.println(app.calcularDescuento(precio));
                default:
                    break;
            }
        }
    }
}

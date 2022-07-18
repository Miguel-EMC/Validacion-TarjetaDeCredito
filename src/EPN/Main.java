package EPN;

import java.util.Scanner;

public class Main {
    public static String validcard(long cardN){
        int contador = 0;
        long digitos = cardN;
        while (digitos > 0)
        {
            digitos = digitos/10;
            contador++;
        }

        if ((contador != 13) && (contador != 15) && (contador != 16))
        {
            return "INVALIDO.";
        }
        long [] numero =  new long[contador];

        for (int i = 0; i < contador; i++)
        {
            numero[i] = cardN % 10;
            cardN = cardN / 10;
        }

        long [] numero_original = new long[contador];
        for (int i = 1; i < contador; i++)
        {
            numero_original[i] = numero[i];
        }

        for (int i = 1; i < contador; i+=2)
        {
            numero[i] = numero[i] * 2;
        }

        long v = 0;
        long temp;

        if (contador == 13)
        {
            for (int i = 0; i < contador; i++)
            {
                temp = (numero[i] % 10) + (numero[i]/10 % 10);
                v = v + temp;
            }
            if (numero_original[12] == 4 && v % 10 == 0)
            {
                return "VISA.";
            }
            else
            {
                return "INVALIDO.";
            }
        }

        if (contador == 16)
        {
            for (int i = 0; i < contador; i++)
            {
                temp = (numero[i] % 10) + (numero[i]/10 % 10);
                v = v + temp;
            }
            if (numero_original[15] == 4 && v % 10 == 0)
            {
                return "MASTERCARD.";
            }
            else
            {
                return "VISA";
            }
        }
        return "INVALIDO.";

    }

        public static void main(String[] args) {

            long numerotarjeta = 0;
            Scanner entrada = new Scanner(System.in);

                System.out.println("Ingrese su numero de tarjeta: ");
                numerotarjeta = entrada.nextLong();
                System.out.println("Su numero de tarjeta es "+validcard(numerotarjeta));
    }
}


import java.util.Scanner;

public class Programa {
    public static void main(String[] args) {

        try (Scanner sc = new Scanner(System.in)){

            int n = sc.nextInt();
            if (n < 1) {
                throw new NegativoException();
            }

            int k = sc.nextInt();
            if (k < 0) {
                throw new NegativoException();
            }
            int[] array = new int[n];
            for (int x=0; x < array.length; x++) {
                array[x] = sc.nextInt();
                if (array[x] < 0) {
                    throw new NegativoException();
                }
            }

            int resultado = verificarQuantidadeDePares(k, array);

            System.out.println(resultado);

        } catch (NegativoException e) {
            System.err.println(e.getMessage());
        } catch (Exception e) {
            System.err.println("Error: Nao e numero valido.");
        }
    }

    private static int verificarQuantidadeDePares(int k, int[] array) {
        int contador = 0;
        int aux = 0;
        for (int x = 0; x < array.length; x++) {
            if (x == 0) {
                aux = array[x];
            } else {
                int soma = Math.abs(array[x] - aux);
                if (soma == k) {
                    contador++;
                }
                aux = array[x];
            }
        }
        return contador;
    }
}

class NegativoException extends RuntimeException {
    public NegativoException() {
        super("Error: Numero Negativo");
    }
}
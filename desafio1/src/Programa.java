import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Programa {
    public static void main(String[] args) {

        try (Scanner sc = new Scanner(System.in)){

            int num = sc.nextInt();
            int[] lista = new int[num];

            for (int i = 0; i < num; i++) {
                lista[i] = sc.nextInt();
                if (lista[i] < 0) {
                    throw new Exception(String.valueOf(lista[i]));
                }
            }

            List<Integer> resultado = organizarLista(lista);

            for (int n : resultado) {
                System.out.println(n);
            }

            sc.close();
        } catch (Exception e) {
            System.err.println(e.getMessage() + " - Numero Invalido!!!");
        }
    }

    //metodo recebe lista e organiza a soluçao
    private static List<Integer> organizarLista(int[] lista){
        List<Integer> pares = new ArrayList<>();
        List<Integer> impares = new ArrayList<>();
        List<Integer> resultado = new ArrayList<>();

        //for para criar lista de pares e lista de impares
        for (int i=0; i < lista.length; i++) {
            if (lista[i] % 2 == 0) {
                pares.add(lista[i]);
            } else {
                impares.add(lista[i]);
            }
        }

        //usando collections para ordenar as listas
        Collections.sort(pares);
        Collections.sort(impares, Collections.reverseOrder());

        //concatenando as listas com stream
        return Stream.concat(pares.stream(), impares.stream()).collect(Collectors.toList());
    }
}
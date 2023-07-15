import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.*;

public class Programa {

    public static void main(String[] args) {
        Locale.setDefault(Locale.US);

        try (Scanner sc = new Scanner(System.in)) {

            String numRecebido = sc.next();
            BigDecimal dinheiro = new BigDecimal(numRecebido).setScale(2, RoundingMode.HALF_EVEN);

           calcularCedulasMoedas(dinheiro);

        } catch (Exception e) {
            System.err.println("Valor invalido!!!");
        }

    }

    private static void calcularCedulasMoedas(BigDecimal dinheiro) {

        int cedulas = dinheiro.intValue();
        BigDecimal centavos = dinheiro.subtract(new BigDecimal(String.valueOf(cedulas)));
        int moedas = (int) (centavos.doubleValue() * 100);

        Map<Integer, Integer> totalCedulas = new LinkedHashMap<>();
        Map<Double, Integer> totalMoedas = new LinkedHashMap<>();

        int cedula100 = cedulas / 100;
        cedulas -= cedula100 * 100;
        totalCedulas.put(100, cedula100);

        int cedula50 = cedulas / 50;
        cedulas -= cedula50 * 50;
        totalCedulas.put(50, cedula50);

        int cedula20 = cedulas / 20;
        cedulas -= cedula20 * 20;
        totalCedulas.put(20, cedula20);

        int cedula10 = cedulas / 10;
        cedulas -= cedula10 * 10;
        totalCedulas.put(10, cedula10);

        int cedula5 = cedulas / 5;
        cedulas -= cedula5 * 5;
        totalCedulas.put(5, cedula5);

        int cedula2 = cedulas / 2;
        cedulas -= cedula2 * 2;
        totalCedulas.put(2, cedula2);

        int moeda1 = cedulas;
        totalMoedas.put(1.00, moeda1);

        int moeda50 = moedas / 50;
        moedas -= moeda50 * 50;
        totalMoedas.put(0.50, moeda50);

        int moeda25 = moedas / 25;
        moedas -= moeda25 * 25;
        totalMoedas.put(0.25, moeda25);

        int moeda10 = moedas / 10;
        moedas -= moeda10 * 10;
        totalMoedas.put(0.10, moeda10);

        int moeda05 = moedas / 5;
        moedas -= moeda05 * 5;
        totalMoedas.put(0.05, moeda05);

        int moeda01 = moedas;
        totalMoedas.put(0.01, moeda01);

        imprimirResultado(totalCedulas, totalMoedas);
    }

    private static void imprimirResultado(Map<Integer, Integer> totalCedulas, Map<Double, Integer> totalMoedas) {

        DecimalFormat formatador = new DecimalFormat("R$ #,##0.00");

        System.out.println("NOTAS:");
        for(Map.Entry<Integer, Integer> cedula : totalCedulas.entrySet()) {
            System.out.println(cedula.getValue() + " notas(s) de " + formatador.format(cedula.getKey().doubleValue()));
        }

        System.out.println("MOEDAS");
        for(Map.Entry<Double, Integer> moeda : totalMoedas.entrySet()) {
            System.out.println(moeda.getValue() + " notas(s) de " + moeda.getKey());
        }
    }
}
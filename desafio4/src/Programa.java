import java.util.*;

public class Programa {
    public static void main(String[] args) {

        try (Scanner sc = new Scanner(System.in)) {

            int linhas = sc.nextInt();
            sc.nextLine();

            List<String> documento = new ArrayList<>();

            for (int x=0; x < linhas; x++) {
                documento.add(sc.nextLine().trim().toUpperCase());
            }

            List<String> docFinalizado = configurarImpressora(documento);

            docFinalizado.forEach(System.out :: println);

        } catch (Exception e) {
            System.err.println("Error");
        }
    }

    private static List<String> configurarImpressora(List<String> documento) {
        List<String> documentoAjustado = new ArrayList<>();
        for (String linha : documento) {
            int metadeLinha = linha.length() / 2;
            String parteEsq = linha.substring(0, metadeLinha);
            String parteDir = linha.substring(metadeLinha);

            parteEsq = new StringBuilder(parteEsq).reverse().toString();
            parteDir = new StringBuilder(parteDir).reverse().toString();

            documentoAjustado.add(parteEsq.concat(parteDir));
        }
        return documentoAjustado;
    }

}
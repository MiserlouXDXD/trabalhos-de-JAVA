import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class megaSenaB {

    public static void main(String[] args) throws IOException {
        File csvFile = new File("d:\\mega.csv"); // Substitua pelo caminho correto para o seu arquivo "mega.csv"
        Scanner scanner = new Scanner(csvFile);

        // Ignorar a primeira linha (cabeçalho)
        if (scanner.hasNextLine()) {
            scanner.nextLine(); // Pular a primeira linha
        }

        Scanner userInput = new Scanner(System.in);
        System.out.println("Digite 6 números para verificar se foram sorteados no passado:");
        int[] jogoUsuario = new int[6];

        for (int i = 0; i < 6; i++) {
            System.out.print("Número " + (i + 1) + ": ");
            jogoUsuario[i] = userInput.nextInt();
        }

        int contagem = 0;

        while (scanner.hasNext()) {
            String[] line = scanner.nextLine().split(";");
            if (line.length >= 7) { // Verifica se há pelo menos 7 colunas

                int[] numerosSorteados = new int[6];
                for (int i = 0; i < 6; i++) {
                    try {
                        numerosSorteados[i] = Integer.parseInt(line[i + 2].trim());
                    } catch (NumberFormatException e) {
                        // Ignora valores que não podem ser convertidos em inteiros
                    }
                }

                if (saoIguais(jogoUsuario, numerosSorteados)) {
                    contagem++;
                    String dataSorteio = line[1];
                    System.out.println("Seu jogo foi sorteado no dia: " + dataSorteio);
                }
            }
        }

        if (contagem > 0) {
            System.out.println("O seu jogo foi sorteado no passado em " + contagem + " ocasiões.");
        } else {
            System.out.println("O seu jogo não foi sorteado no passado.");
        }
    }

    public static boolean saoIguais(int[] jogo1, int[] jogo2) {
        if (jogo1.length != jogo2.length) {
            return false;
        }

        for (int i = 0; i < jogo1.length; i++) {
            if (jogo1[i] != jogo2[i]) {
                return false;
            }
        }

        return true;
    }
}

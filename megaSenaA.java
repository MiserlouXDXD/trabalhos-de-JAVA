import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class megaSenaA {

    public static void main(String[] args) throws IOException {
        File csvFile = new File("d:\\mega.csv");
        Scanner scanner = new Scanner(csvFile);

        // Ignorar o cabeçalho
        if (scanner.hasNextLine()) {
            scanner.nextLine();
        }
        // le e separa em arrays o arquivo
        Scanner userInput = new Scanner(System.in);
        System.out.print("Digite o número que deseja verificar: ");
        int numeroSelecionado = userInput.nextInt();

        int contagem = 0;

        while (scanner.hasNext()) {
            String[] line = scanner.nextLine().split(";");
            if (line.length >= 7) {

                for (int i = 2; i < line.length; i++) {
                    int numeroSorteado;
                    try {
                        numeroSorteado = Integer.parseInt(line[i].trim());
                        if (numeroSorteado == numeroSelecionado) {
                            contagem++;
                        }
                    } catch (NumberFormatException e) {
                    }
                }
            }
        }

        if (contagem > 0) {
            System.out.println("O número " + numeroSelecionado + " foi sorteado " + contagem + " vezes.");
        } else {
            System.out.println("O número " + numeroSelecionado + " não foi sorteado no arquivo.");
        }
    }
}

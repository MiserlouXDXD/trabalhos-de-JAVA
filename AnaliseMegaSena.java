import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class AnaliseMegaSena {

    public static void main(String[] args) throws IOException {
        File csvFile = new File("d:\\mega.csv");
        Scanner scanner = new Scanner(csvFile);
        scanner.nextLine();

        Scanner userInput = new Scanner(System.in);

        int escolha;
        do {
            System.out.println("Escolha uma opção:");
            System.out.println("1 - Quantidade de vezes que cada número foi sorteado (Parte 'a')");
            System.out.println("2 - Verificar se o seu jogo foi sorteado (Parte 'b')");
            System.out.println("0 - Sair");
            System.out.print("Opção: ");
            escolha = userInput.nextInt();
            userInput.nextLine();

            switch (escolha) {
                case 1:
                    int[] contagemNumeros = new int[60];
                    while (scanner.hasNext()) {
                        String[] line = scanner.nextLine().split(";");
                        if (line.length >= 7) {
                            int[] numerosSorteados = new int[6];
                            for (int i = 0; i < 6; i++) {
                                try {
                                    numerosSorteados[i] = Integer.parseInt(line[i + 2].trim());
                                } catch (NumberFormatException e) {
                                    // Ignora valores que não podem ser convertidos em inteiros
                                }
                            }
                            for (int numeroSorteado : numerosSorteados) {
                                contagemNumeros[numeroSorteado - 1]++;
                            }
                        }
                    }
                    System.out.print("Digite o numero que deseja: ");
                    int numeroSelecionado = userInput.nextInt();
                    int contagemNumeroSelecionado = contagemNumeros[numeroSelecionado - 1];
                    System.out.println("O número " + numeroSelecionado + " foi sorteado " + contagemNumeroSelecionado + " vezes.");
                    break;
                case 2:
                    System.out.println("Digite 6 números para verificar se foram sorteados(juntos) no passado: ");
                    int[] jogoUsuario = new int[6];
                    for (int i = 0; i < 6; i++) {
                        System.out.print("Número " + (i + 1) + ": ");
                        jogoUsuario[i] = userInput.nextInt();
                    }
                    int contagemJogoUsuario = 0;
                    scanner = new Scanner(new File("d:\\mega.csv"));
                    if (scanner.hasNextLine()) {
                        scanner.nextLine();
                    }
                    while (scanner.hasNext()) {
                        String[] line = scanner.nextLine().split(";");
                        if (line.length >= 7) {
                            int[] numerosSorteados = new int[6];
                            for (int i = 0; i < 6; i++) {
                                try {
                                    numerosSorteados[i] = Integer.parseInt(line[i + 2].trim());
                                } catch (NumberFormatException e) {
                                    // Ignora valores que não podem ser convertidos em inteiros
                                }
                            }
                            if (saoIguais(jogoUsuario, numerosSorteados)) {
                                contagemJogoUsuario++;
                                String dataSorteio = line[1];
                                System.out.println("Seus numeros foram sorteados(juntos) no dia: " + dataSorteio);
                            }
                        }
                    }
                    if (contagemJogoUsuario > 0) {
                        System.out.println("numero de vezes que ocorreu esse sorteio:"+contagemJogoUsuario);
                    } else {
                        System.out.println("Nunca forma sorteados(juntos)!!");
                    }
                    break;
                case 0:
                    System.out.println("* * * FIM * * *");
                    break;
                default:
                    System.out.println("Digite uma opcao valida!!");
                    break;
            }
        } while (escolha != 0);
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

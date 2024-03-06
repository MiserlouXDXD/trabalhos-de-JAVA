import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class MensagensHora {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite uma mensagem: ");
        String novaMensagem = scanner.nextLine();

        SimpleDateFormat hora = new SimpleDateFormat("HH:mm:ss");
        String HoraAtual = hora.format(new Date());

        try {
            RandomAccessFile file = new RandomAccessFile("mensagens.txt", "rw");

            file.seek(file.length());

            file.writeBytes(HoraAtual + ": " + novaMensagem + "\n");

            file.close();

            exibirMensagens();
        } catch (IOException e) {
            System.err.println("Erro ao escrever no arquivo: " + e.getMessage());
        }
    }

    public static void exibirMensagens() {
        try {
            RandomAccessFile arq = new RandomAccessFile("mensagens.txt", "r");

            String linha;
            System.out.println("Mensagens armazenadas:");
            while ((linha = arq.readLine()) != null) {
                System.out.println(linha);
            }
            arq.close();
        } catch (IOException e) {
            System.out.println("Erro ao ler o arquivo: " + e.getMessage());
        }
    }
}

import java.io.RandomAccessFile;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class BuscaPalavraChave {

    public static void main(String[] args) {

        String palavraChave = JOptionPane.showInputDialog("Informe a palavra-chave a ser procurada:");

        try {
            RandomAccessFile arq = new RandomAccessFile("d:\\aaa.txt", "r");
            String linha;
            int cont = 1;
            List<Integer> linhasEncontradas = new ArrayList<>();

            while ((linha = arq.readLine()) != null) {
                if (linha.contains(palavraChave)) {
                    linhasEncontradas.add(cont);
                }
                cont++;
            }

            arq.close();

            if (!linhasEncontradas.isEmpty()) {
                System.out.println("A palavra buscada '" + palavraChave + "' foi encontrada na linha:");
                for (int linhaEncontrada : linhasEncontradas) {
                    System.out.print(" " + linhaEncontrada);
                }
                System.out.println();
            } else {
                System.out.println("A palavra-chave não foi encontrada no arquivo.");
            }
        } catch (IOException e) {
            System.out.println("Erro ao abrir o arquivo: " + e.getMessage());
        }
    }
}

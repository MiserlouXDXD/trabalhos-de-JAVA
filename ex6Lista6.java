import java.util.Random;
import java.util.Scanner;

class Matriz {
    int[][] matriz;
    int num;

    Matriz(int x, int y) {
        num = x;
        matriz = new int[x][y];
    }

    public void preencher() {
        Random random = new Random();

        for (int i = 0; i < num; i++) {
            for (int j = 0; j < matriz[0].length; j++) {
                int valor = random.nextInt(10) + 1;
                matriz[i][j] = valor;
            }
        }
    }

    public boolean quadrada() {
        return matriz.length == matriz[0].length;
    }

    public int soma() {
        int soma = 0;
        for (int i = 0; i < num; i++) {
            for (int j = 0; j < matriz[0].length; j++) {
                soma += matriz[i][j];
            }
        }
        return soma;
    }

    public int encontrarLinha(int x) {
        int linhaEncontrada = -1;

        for (int i = 0; i < num; i++) {
            for (int j = 0; j < matriz[0].length; j++) {
                if (matriz[i][j] == x) {
                    linhaEncontrada = i;
                    System.out.println("Valor " + x + " foi encontrado primeiro na linha " + linhaEncontrada);
                    return linhaEncontrada;
                }
            }
        }
        return linhaEncontrada;
    }

    public void exibir() {
        for (int i = 0; i < num; i++) {
            for (int j = 0; j < matriz[0].length; j++) {
                System.out.print(matriz[i][j] + " ");
            }
            System.out.println();
        }
    }

}

public class ex6Lista6 {
    public static void main(String[] args) {
        Scanner leitor = new Scanner(System.in);

        System.out.print("Digite o número de linhas: ");
        int linhas = leitor.nextInt();
        System.out.print("Digite o número de colunas: ");
        int colunas = leitor.nextInt();

        Matriz matriz = new Matriz(linhas, colunas);

        matriz.preencher();
        matriz.exibir();

        System.out.println("É quadrada? " + matriz.quadrada());
        System.out.println("Total: " + matriz.soma());

        System.out.println("Digite um valor para encontrar a linha: ");
        int x = leitor.nextInt();
        matriz.encontrarLinha(x);

        }
    }


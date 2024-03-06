import java.util.Scanner;

    class Vetor {
        String[] Atual;
        String[] Aux;
        int tamanhoAtual;
        int tamanhoInicial = 5;

        Vetor() {
            Atual = new String[tamanhoInicial];
            tamanhoAtual = 0;
        }

        public void inserir(String elemento) {
            if (tamanhoAtual == Atual.length) {
                // Se o vetor atual estiver cheio, redimensiona
                redimensionar();
            }

            Atual[tamanhoAtual] = elemento;
            tamanhoAtual++;
        }

        // retorna elemento na posição
        public String get(int posicao) {
            if (posicao >= 0 && posicao < tamanhoAtual) {
                return Atual[posicao];
            } else {
                return null;
            }
        }

        // retorna último elemento
        public String getUltimo() {
            if (tamanhoAtual > 0) {
                return Atual[tamanhoAtual - 1];
            } else {
                return null; // Valor que indica que o vetor está vazio
            }
        }

        // mostra o tamanho atual
        public int size() {
            return tamanhoAtual;
        }

        //se passa do tamanho atual, atual recebe o aux que tem o dobro do tam
        public void redimensionar() {
            Aux = new String[Atual.length * 2];

            // Copia os elementos do vetor atual para o vetor auxiliar
            for (int i = 0; i < tamanhoAtual; i++) {
                Aux[i] = Atual[i];
            }

            Atual = Aux;
        }

    }
    public class ex7Lista6 {

    public static void main(String[] args) {
        Vetor meuVetor = new Vetor();
        Scanner scanner = new Scanner(System.in);

        for (int i = 0; i < 10; i++) { //alterar o i < "X" para o vet ficar "dinamico".
            System.out.print("Digite uma string para inserir: ");
            String input = scanner.nextLine();
            meuVetor.inserir(input);
        }

        System.out.print("Digite a posição para obter a string: ");
        int posicao = scanner.nextInt();
        String resultado = meuVetor.get(posicao-1);

        if (resultado != null) {
            System.out.println("Elemento na posição " + posicao + ": " + resultado);
        } else {
            System.out.println("A posição " + posicao + " não está ocupada ou ultrapassou o tamanho do vetor.");
        }
        System.out.println("Último elemento inserido: " + meuVetor.getUltimo());
        System.out.println("Tamanho do vetor: " + meuVetor.size());
    }
}

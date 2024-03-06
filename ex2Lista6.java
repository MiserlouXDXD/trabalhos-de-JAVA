import java.util.Scanner;

class Elevador {
    private int andar = 0;
    private int totalAndares;
    private int capPessoa;
    private int pessoa = 0;

    public Elevador() {
        totalAndares = 10; // Inicializa com 10 andares
        capPessoa = 10;    // Inicializa com capacidade para 10 pessoas
    }

    public int entrar(int n) {
        if (pessoa + n <= capPessoa) {
            pessoa = pessoa + n;
        } else {
            System.out.println("CAPACIDADE NO MÁXIMO!!!");
        }

        return pessoa;
    }

    public int sair(int n) {
        if (pessoa - n >= 0) {
            pessoa = pessoa - n;
        } else {
            System.out.println("ELEVADOR VAZIO!!!");
        }
        return pessoa;
    }

    public int subir(int n) {
        if (getAndar() + n <= getTotalAndares()) {
            setAndar(getAndar() + n);
        } else {
            System.out.println("NAO EXISTE ANDAR MAIOR QUE "+totalAndares+"!!!");
        }
        return getAndar();
    }

    public int descer(int n) {
        if (getAndar() - n >= 0) {
            setAndar(getAndar() - n);
        } else {
            System.out.println("TÉRREO ALCANÇADO!!!");
        }
        return getAndar();
    }



    // Métodos getter e setter para encapsulamento
    public int getAndar() {
        return andar;
    }

    public void setAndar(int novoAndar) {
        andar = novoAndar;
    }

    public int getTotalAndares() {
        return totalAndares;
    }

    public void setTotalAndares(int novoTotalAndares) {
        totalAndares = novoTotalAndares;
    }

    public int getCapPessoa() {
        return capPessoa;
    }

    public void setCapPessoa(int novoCapPessoa) {
        capPessoa = novoCapPessoa;
    }

    public int getPessoa() {
        return pessoa;
    }
}

public class ex2Lista6 {
    public static void menu() {
        System.out.println("* * * ELEVADOR * * *");
        System.out.println("[1] Entrar no elevador");
        System.out.println("[2] Sair do elevador");
        System.out.println("[3] Subir");
        System.out.println("[4] Descer");
        System.out.println("[5] Mudar Opções do elevador");
        System.out.println("[6] Mostrar Andar Atual");
        System.out.println("[7] Finalizar");
    }

    public static void opcoes() {
        System.out.println("O que deseja mudar?");
        System.out.println("[1] Número máximo de andares");
        System.out.println("[2] Número máximo de pessoas");
        System.out.println("[3] Para voltar");
    }

    public static void main(String[] args) {
        Elevador elev = new Elevador();

        int op, n;
        Scanner leitor = new Scanner(System.in);
        menu();
        op = leitor.nextInt();
        while (op < 7) {
            switch (op) {
                case 1:
                    System.out.println("Quantas pessoas entram no elevador?");
                    n = leitor.nextInt();
                    elev.entrar(n);
                    System.out.println(elev.getPessoa());
                    break;
                case 2:
                    System.out.println("Quantas pessoas vão sair?");
                    n = leitor.nextInt();
                    elev.sair(n);
                    break;
                case 3:
                    System.out.println("Quantos andares subir?");
                    n = leitor.nextInt();
                    elev.subir(n);
                    break;
                case 4:
                    System.out.println("Quantos andares descer?");
                    n = leitor.nextInt();
                    elev.descer(n);
                    break;
                case 5:
                    opcoes();
                    op = leitor.nextInt();
                    while (op < 4) {
                        switch (op) {
                            case 1:
                                System.out.println("Qtde atual: " + elev.getTotalAndares());
                                System.out.println("Qual a nova qtde de andares?");
                                n = leitor.nextInt();
                                elev.setTotalAndares(n);
                                break;
                            case 2:
                                System.out.println("Qtde atual: " + elev.getCapPessoa());
                                System.out.println("Qual a nova qtde máxima de pessoas?");
                                n = leitor.nextInt();
                                elev.setCapPessoa(n);
                                break;
                            case 3:
                                System.out.println("Voltando...");
                                menu();
                                op = leitor.nextInt();
                                break;
                        }
                        opcoes();
                        op = leitor.nextInt();
                    }
                    break;
                case 6:
                    System.out.println("Andar Atual: " + elev.getAndar());
                    break;
            }
            menu();
            op = leitor.nextInt();
        }
    }
}
import java.util.Scanner;

class MaquinaCafe {
    // Atributos
    private float precoCafe;
    private float totalVendido;
    private float credito;
    private int qtdeCafesVendidos;

    // Métodos
    public void setPrecoCafe(float preco) {
        if (preco>0)
            precoCafe = preco;
    }
    public float getPrecoCafe() {
        return precoCafe;
    }
    public float getCredito() {
        return credito;
    }
    public float getQtdeCafesVendidos() {
        return qtdeCafesVendidos;
    }
    public float getTotalVendido() {
        return totalVendido;
    }

    public void iniciarVendas() {
        totalVendido = 0;
        credito = 0;
        qtdeCafesVendidos = 0;
    }
    public void colocarMoeda(float valMoeda) {
        credito += valMoeda;
    }
    public boolean retirarUmCafe() {
        if (credito >= precoCafe) {
            qtdeCafesVendidos++;
            totalVendido+= precoCafe;
            credito -= precoCafe;
            return true;
        }
        return false;
    }

    public float devolverTroco() {
        float temp = credito;
        credito = 0;
        return temp;
    }

    public void finalizarVendas() {
        totalVendido += credito;
        credito = 0;
    }
}


public class Main {
    public static void exibirMenuOpcoes() {
        System.out.println("\n1 - Colocar moeda");
        System.out.println("2 - Retirar Café");
        System.out.println("3 - Receber Troco");
        System.out.println("4 - Ver crédito");
        System.out.println("5 - Finalizar vendas");
        System.out.println("6 - Sair");
    }
    public static void main(String[] args) {

        MaquinaCafe mc = new MaquinaCafe();
        mc.setPrecoCafe(2.0f);
        mc.iniciarVendas();

        exibirMenuOpcoes();
        Scanner leitura = new Scanner(System.in);
        System.out.print("Digite a opção: ");
        int op = leitura.nextInt();
        while (op != 6) {
            switch (op) {
                case 1: {
                    System.out.print("Valor da moeda: ");
                    float valMoeda = leitura.nextFloat();
                    mc.colocarMoeda(valMoeda);
                    System.out.println(" Crédito: "+mc.getCredito());
                    break;
                }
                case 2: {
                    if (mc.retirarUmCafe()) {
                        System.out.println("Retire seu café. Bom proveito!");
                        System.out.println(" Crédito: "+mc.getCredito());
                    }
                    else {
                        System.out.println("Crédito insuficiente!");
                    }
                    break;
                }
                case 3: {
                    System.out.println("Seu troco é de: "+mc.devolverTroco());
                    break;
                }
                case 4: {
                    System.out.println(" Crédito: "+mc.getCredito());
                    break;
                }
                case 5: {
                    mc.finalizarVendas();
                    System.out.println("----------------------------------");
                    System.out.println("Qtde total de cafés vendidos: "+ mc.getQtdeCafesVendidos());
                    System.out.printf("Valor soma vendido pela máquina: R$ %3.2f \n", mc.getTotalVendido());
                    mc.iniciarVendas();
                    break;
                }
            }

            exibirMenuOpcoes();
            System.out.print("Digite a opção: ");
            op = leitura.nextInt();
        }

    }
}
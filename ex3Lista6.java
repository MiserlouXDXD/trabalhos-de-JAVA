import java.util.Scanner;

class calculadora{
    double a,b,result;
    char op;

    public double calcular(double a, double b,char op){
        if (op=='+'){
            result = a + b;
            return result;
        } else if (op=='-') {
            result = a - b;
            return result;
        } else if (op=='*') {
            result = a * b;
            return result;
        } else if (op=='/') {
            result = a / b;
            return result;
        } else
            System.out.println("Digite um operador validor");

        return result;
    }

}
public class ex3Lista6 {

    public static void main(String[] args) {
        calculadora calc = new calculadora();
        Scanner leitor = new Scanner(System.in);

        System.out.println("Digite o valor de A:");
        calc.a = leitor.nextDouble();

        System.out.println("Digite o valor de B:");
        calc.b = leitor.nextDouble();

        System.out.println("Digite o Sinal da operação:");
        calc.op = leitor.next().charAt(0);

        calc.calcular(calc.a, calc.b, calc.op) ;
        System.out.println("resultado: "+calc.result);
    }

}



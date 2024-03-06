class Circulo {
    private int centroX, centroY, raio;

    public Circulo(int x, int y, int z) {
        centroX = x;
        centroY = y;
        raio = z;
    }

    public boolean comparaCirculo(Circulo c2) {
        return c2.getCentroX() == centroX && c2.getCentroY() == centroY && c2.getRaio() == raio;
    }

    public void move(int novoCentroX, int novoCentroY) {
        setCentroX(novoCentroX);
        setCentroY(novoCentroY);
    }

    public double area() {

        return Math.PI * getRaio() * getRaio();
    }

    public double perimetro() {

        return 2 * Math.PI * getRaio();
    }

    // Métodos getter e setter para encapsulamento
    public int getCentroX() {

        return centroX;
    }

    public void setCentroX(int novoCentroX) {

        centroX = novoCentroX;
    }

    public int getCentroY() {

        return centroY;
    }

    public void setCentroY(int novoCentroY) {

        centroY = novoCentroY;
    }

    public int getRaio() {

        return raio;
    }

    public void setRaio(int novoRaio) {

        raio = novoRaio;
    }
}

public class ex1Lista6 {
    public static void main(String arg[]) {
        Circulo c1 = new Circulo(1, 2, 100);
        Circulo c2 = new Circulo(20, 22, 99);
        Circulo c3 = new Circulo(1, 2, 100);

        if (c1.comparaCirculo(c2)) {
            System.out.println("c1 igual a c2");
        } else if (c1.comparaCirculo(c3)) {
            System.out.println("c1 igual a c3");
        }

        c1.move(5, 10);
        System.out.println("Nova posição do c1: (" + c1.getCentroX() + ", " + c1.getCentroY() + ")");

        System.out.println("Área do c1: " + c1.area());
        System.out.println("Área do c2: " + c2.area());
        System.out.println("Área do c3: " + c3.area());

        System.out.println("Perímetro do c1: " + c1.perimetro());
        System.out.println("Perímetro do c2: " + c2.perimetro());
        System.out.println("Perímetro do c3: " + c3.perimetro());
    }
}

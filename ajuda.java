


//metodos get/set
// public int/char/float/ect GETexemplo () { return exemplo; }
// public void SETexemplo (int/float/char/ect novoExemplo) { exemplo = novoExemplo; }


public class ajuda {
    public static void main(String[] args) {
        int a, b, c;

        a = b = 2;         // a=2, b=2
        c = ++a;           // a=3, c=3
        c = a + b++;       // a=3, b=3 (depois do uso em b++), c=6
        a *= 3;            // a=9, c=6
        c += a % (b++);    // b=4 (depois do uso em b++), c=19 (c += 9 % 4 = 19)
        c = ++a + a + a++; // a=12, c= 12 + 11 + 11 = 34

        System.out.println("a = " + a);
        System.out.println("b = " + b);
        System.out.println("c = " + c);
    }
}

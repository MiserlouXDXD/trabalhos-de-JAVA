import java.util.Random;

class Bingo{
    int[] vet;
    int numero;

}
public class ex5Lista6 {

    public static void main(String[] args){
        Bingo bingo = new Bingo();

        bingo.vet = new int[4];
        Random r = new Random();

        for(int i=0; i<4; i++){
            bingo.numero = r.nextInt(99) + 1;
            for(int j=0; j<4; j++){
                if(bingo.numero == bingo.vet[j] && j != i){
                    bingo.numero = r.nextInt(99) + 1;
                }else{
                    bingo.vet[i] = bingo.numero;
                }
            }
        }

        for(int i=0; i<4; i++){
            System.out.print("Numero "+(i+1)+" sorteado: "+bingo.vet[i]+"\n");
        }
    }
}


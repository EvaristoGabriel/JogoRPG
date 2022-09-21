package jogorpg;

import java.util.Random;

public class Inimigo extends Personagem{

    public Inimigo(int level) {
        this.setHp(level*10);
        this.setAtaque(level*5);
        this.setDefesa((int)(level * (4.5f)));
        this.setSpeed((int)(level*1.5f));
        this.setLevel(level);
    }
    
    public int Ataque(){
        Random gerador = new Random();
        int ataque = gerador.nextInt(5);
        return ataque;
    }

    @Override
    public String toString() {
        return " Inimigo"+super.toString();
    }
    
}

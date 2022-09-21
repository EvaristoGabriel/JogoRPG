package jogorpg;

import java.util.Random;

public class Boss extends Personagem{

    public Boss(int level) {
        this.setHp(level * 17);
        this.setAtaque(level * 10);
        this.setDefesa(level * 9);
        this.setSpeed(level * 3);
        this.setLevel(level);
    }

    public int Ataque(){
        Random gerador = new Random();
        int ataque = gerador.nextInt(6);
        return ataque;
    }
}

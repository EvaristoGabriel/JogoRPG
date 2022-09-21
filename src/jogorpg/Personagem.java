package jogorpg;
public class Personagem{
    private int hp,ataque,defesa,speed,level;
    private String nome;

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public int getAtaque() {
        return ataque;
    }

    public void setAtaque(int ataque) {
        this.ataque = ataque;
    }

    public int getDefesa() {
        return defesa;
    }

    public void setDefesa(int defesa) {
        this.defesa = defesa;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    @Override
    public String toString() {
        return "Personagem:\nNome = " + nome +"\nLevel = " + level+ "\nHP = " + hp + "\nAtaque = " + ataque + "\nDefesa = "
                + defesa + "\nSpeed = " + speed;
    }

    
    
}

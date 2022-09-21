package jogorpg;

import java.util.Scanner;

public class Usuario extends Personagem {

    private int experiencia, exptotal,quantsoco,quantchute,quantcombo,quantespecial;
    
    public Usuario(String nome) {
        this.setNome(nome);
        this.setHp(150);
        this.setAtaque(10);
        this.setDefesa(10);
        this.setSpeed(5);
        this.setLevel(1);
        this.experiencia = 0;
        this.setQuantsoco(10);
        this.setQuantchute(10);
        this.setQuantcombo(6);
        this.setQuantespecial(5);
        this.setExptotal(20);
    }

    public int getExperiencia() {
        return experiencia;
    }

    public void setExperiencia(int experiencia) {
        this.experiencia = experiencia;
    }

    public int getExptotal() {
        return exptotal;
    }

    public void setExptotal(int exptotal) {
        this.exptotal = exptotal;
    }


    public void ganharXP(int xp){
        this.setExperiencia(this.getExperiencia()+xp);
        while(this.getExperiencia()>=this.getExptotal()){
            if(this.getExperiencia() >= this.getExptotal()){
                this.setExperiencia(this.getExperiencia()-this.getExptotal());
                this.setLevel(this.getLevel()+1);
                this.setExptotal(this.getLevel()*100);
                this.setHp(150 + this.getLevel()*50);
                this.setAtaque(this.getAtaque()+5);
                this.setDefesa(this.getDefesa()+5);
                this.setSpeed(this.getSpeed()+(int)(this.getLevel()%2));
                this.setQuantsoco(10+(this.getLevel()/5));
                this.setQuantchute(10+(this.getLevel()/5));
                this.setQuantcombo(6+(this.getLevel()/5));
                this.setQuantespecial(5+(this.getLevel()/5));
                System.out.println("Subiu de Nivel! Novos Status:");
                System.out.println("Level: "+this.getLevel());
                System.out.println("HP: "+this.getHp());
                System.out.println("Ataque: "+this.getAtaque());
                System.out.println("Defesa: "+this.getDefesa());
                System.out.println("Speed: "+this.getSpeed());
                System.out.println("Quantidade de socos: "+this.getQuantsoco());
                System.out.println("Quantidade de chutes: "+this.getQuantchute());
                System.out.println("Quantidade de combos: "+this.getQuantcombo());
                System.out.println("Quantidade de especiais: "+this.getQuantespecial());
            }
        }
    }
    
    public void ganharXP(int xp,String Boss){
        this.setExperiencia(this.getExperiencia()+xp);
        while(this.getExperiencia()>=this.getExptotal()){
            if(this.getExperiencia() >= this.getExptotal()){
                this.setExperiencia(this.getExperiencia()-this.getExptotal());
                this.setLevel(this.getLevel()+1);
                this.setExptotal(this.getLevel()*100);
                this.setHp(150 + this.getLevel()*100);
                this.setAtaque(this.getAtaque()+15);
                this.setDefesa(this.getDefesa()+15);
                this.setSpeed(this.getSpeed()+this.getLevel()*2);
                this.setQuantsoco(10+(this.getLevel()/2));
                this.setQuantchute(10+(this.getLevel()/2));
                this.setQuantcombo(6+(this.getLevel()/2));
                this.setQuantespecial(5+(this.getLevel()/2));
                System.out.println("Subiu de Nivel! Novos Status:");
                System.out.println("Level: "+this.getLevel());
                System.out.println("HP: "+this.getHp());
                System.out.println("Ataque: "+this.getAtaque());
                System.out.println("Defesa: "+this.getDefesa());
                System.out.println("Speed: "+this.getSpeed());
                System.out.println("Quantidade de socos: "+this.getQuantsoco());
                System.out.println("Quantidade de chutes: "+this.getQuantchute());
                System.out.println("Quantidade de combos: "+this.getQuantcombo());
                System.out.println("Quantidade de especiais: "+this.getQuantespecial());
            }
        }
    }
    
    public int Ataque(){
        System.out.println("Qual ataque você quer usar: ");
        System.out.println("(1) Soco");
        System.out.println("(2) Chute");
        System.out.println("(3) Combo");
        System.out.println("(4) Especial");
        Scanner leitor = new Scanner(System.in);
        int ataque = leitor.nextInt();
        return ataque;
    }
    
    public void Recuperar(){
        System.out.println("HP recuperado");
        this.setHp(150 + this.getLevel()*50);
    }
    
    @Override
    public String toString() {
        return "" + super.toString() +  "\nexperiencia = "+experiencia;
    }    

    public int getQuantsoco() {
        return quantsoco;
    }

    public void setQuantsoco(int quantsoco) {
        this.quantsoco = quantsoco;
    }

    public int getQuantchute() {
        return quantchute;
    }

    public void setQuantchute(int quantchute) {
        this.quantchute = quantchute;
    }

    public int getQuantcombo() {
        return quantcombo;
    }

    public void setQuantcombo(int quantcombo) {
        this.quantcombo = quantcombo;
    }

    public int getQuantespecial() {
        return quantespecial;
    }

    public void setQuantespecial(int quantespecial) {
        this.quantespecial = quantespecial;
    }
    
}

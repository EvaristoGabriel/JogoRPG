package jogorpg;

import java.util.Random;
import java.util.Scanner;

public final class Batalha {
    private Usuario user;
    private Inimigo inim;
    private Boss boss;


    public Batalha(Usuario thePlayer, Inimigo theEnemy){
        user = thePlayer;
        inim = theEnemy;
        batalhar();
    }
    public void batalhar(){
        System.out.println("=========================");
        System.out.println(this.user.getNome()+" VS Inimigo");
        while(this.user.getHp() > 0 && this.inim.getHp() > 0){
            if(this.user.getSpeed() > this.inim.getSpeed()){
                System.out.println("------ SUA VEZ ------");
                int ata = this.user.Ataque();
                Random ger = new Random();
                int errar = ger.nextInt(3);
                if(errar == 0){
                    System.out.println("VOCÊ ERROU");
                }
                else{
                    Scanner leitor = new Scanner(System.in);
                    if(ata == 1 && this.user.getQuantsoco()<=0){
                        System.out.println("Você não tem mais socos!");
                        System.out.println("(2) Chute\n(3) Combo\n(4) Especial");
                        ata = leitor.nextInt();
                    }
                    else if(ata == 2 && this.user.getQuantchute()<=0){
                        System.out.println("Você não tem mais chutes!");
                        System.out.println("(1) Soco\n(3) Combo\n(4) Especial");
                        ata = leitor.nextInt();
                    }
                    else if(ata == 3 && this.user.getQuantcombo()<=0){
                        System.out.println("Você não tem mais combos!");
                        System.out.println("(1) Soco\n(2) Chute\n(4) Especial");
                        ata = leitor.nextInt();
                    }
                    else if(ata == 4 && this.user.getQuantespecial()<=0){
                        System.out.println("Você não tem mais especiais!");
                        System.out.println("(1) Soco\n(2) Chute\n(3) Combo");
                        ata = leitor.nextInt();
                    }
                    switch(ata){
                        case 1:
                            System.out.println("Você deu um soco");
                            System.out.println("Causou "+this.user.getAtaque()/2+" de dano");
                            this.inim.setHp(this.inim.getHp()-this.user.getAtaque()/2);
                            this.user.setQuantsoco(this.user.getQuantsoco()-1);
                            System.out.println("----Você tem "+this.user.getQuantsoco()+" socos----");
                            break;
                        case 2:
                            System.out.println("Você deu um chute");
                            System.out.println("Causou "+(int)(this.user.getAtaque()/1.75f)+" de dano");  
                            this.inim.setHp(this.inim.getHp()- (int)(this.user.getAtaque()/1.75f));
                            this.user.setQuantchute(this.user.getQuantchute()-1);
                            System.out.println("----Você tem "+this.user.getQuantchute()+" chutes----");
                            break;
                        case 3:
                            System.out.println("Você deu um combo");
                            System.out.println("Causou "+(int)(this.user.getAtaque()/1.5f)+" de dano");
                            this.inim.setHp(this.inim.getHp()-(int)(this.user.getAtaque()/1.5f));
                            this.user.setQuantcombo(this.user.getQuantcombo()-1);
                            System.out.println("----Você tem "+this.user.getQuantcombo()+" combos----");
                            break;
                        case 4:
                            System.out.println("Você deu um especial");
                            System.out.println("Causou "+this.user.getAtaque()+" de dano");
                            this.inim.setHp(this.inim.getHp()-this.user.getAtaque());
                            this.user.setQuantespecial(this.user.getQuantespecial()-1);
                            System.out.println("----Você tem "+this.user.getQuantespecial()+" especial----");
                            break;
                    }
                }
                int vidainim = this.inim.getHp();
                if(vidainim <= 0)
                    vidainim = 0;
                if(vidainim == 0){
                    System.out.println("Você Ganhou");
                    System.out.println("Sua vida: "+this.user.getHp());
                    System.out.println("Vida Inimigo: "+vidainim);
                    this.user.ganharXP(this.inim.getLevel()*10);
                    System.out.println("Você Ganhou "+this.inim.getLevel()*10+" de xp");
                    System.out.println("Faltam "+(this.user.getExptotal()-this.user.getExperiencia())
                                        +" de xp");
                    System.out.println("=========================");
                    break;
                }

                System.out.println("------ VEZ DO INIMIGO ------");
                ata = this.inim.Ataque();
                if(ata == 0){
                    System.out.println("O INIMIGO ERROU");
                }
                else{
                    switch(ata){
                        case 1:System.out.println("Inimigo deu um soco");
                            System.out.println("Causou "+this.inim.getAtaque()/2+" de dano");
                            this.user.setHp(this.user.getHp()-this.inim.getAtaque()/2);
                            break;
                        case 2:System.out.println("Inimigo deu um chute");
                            System.out.println("Causou "+(int)(this.user.getAtaque()/1.75f)+" de dano");
                            this.user.setHp(this.user.getHp()-(int)(this.user.getAtaque()/1.75f));
                            break;
                        case 3:System.out.println("Inimigo deu um combo");
                            System.out.println("Causou "+(int)(this.user.getAtaque()/1.5f)+" de dano");
                            this.user.setHp(this.user.getHp()-(int)(this.user.getAtaque()/1.5f));
                            break;
                        case 4:System.out.println("Inimigo deu um especial");
                            System.out.println("Causou "+this.inim.getAtaque()+" de dano");
                            this.user.setHp(this.user.getHp()-this.inim.getAtaque());
                            break;
                    }
                }
                int vidauser = this.user.getHp();
                if(vidauser <= 0)
                    vidauser = 0;
                System.out.println("Sua vida: "+vidauser);
                System.out.println("Vida Inimigo: "+this.inim.getHp());
                if(vidauser == 0){
                System.out.println("Você perdeu");
                } 
                System.out.println("=========================");
            }
            else{
                System.out.println("------ VEZ DO INIMIGO ------");
                int ata = this.inim.Ataque();
                if(ata == 0){
                    System.out.println("O INIMIGO ERROU");
                }
                else{
                    switch(ata){
                        case 1:System.out.println("Inimigo deu um soco");
                            System.out.println("Causou "+this.inim.getAtaque()/2+" de dano");
                            this.user.setHp(this.user.getHp()-this.inim.getAtaque()/2);
                            break;
                        case 2:System.out.println("Inimigo deu um chute");
                            System.out.println("Causou "+(int)(this.user.getAtaque()/1.75f)+" de dano");
                            this.user.setHp(this.user.getHp()-(int)(this.user.getAtaque()/1.75f));
                            break;
                        case 3:System.out.println("Inimigo deu um combo");
                            System.out.println("Causou "+(int)(this.user.getAtaque()/1.5f)+" de dano");
                            this.user.setHp(this.user.getHp()-(int)(this.user.getAtaque()/1.5f));
                            break;
                        case 4:System.out.println("Inimigo deu um especial");
                            System.out.println("Causou "+this.inim.getAtaque()+" de dano");
                            this.user.setHp(this.user.getHp()-this.inim.getAtaque());
                            break;
                    }
                }
                int vidauser = this.user.getHp();
                if(vidauser <= 0)
                    vidauser = 0;
                
                if(vidauser == 0){
                System.out.println("Você perdeu");
                System.out.println("Sua vida: "+vidauser);
                System.out.println("Vida Inimigo: "+this.inim.getHp());
                System.out.println("=========================");
                break;
                } 
                Random ger = new Random();
                int errar = ger.nextInt(3);
                System.out.println("------ SUA VEZ ------");
                ata = this.user.Ataque();
                errar = ger.nextInt(3);
                if(errar == 0){
                    System.out.println("VOCÊ ERROU");
                }
                else{
                    Scanner leitor = new Scanner(System.in);
                    if(ata == 1 && this.user.getQuantsoco()<=0){
                        System.out.println("Você não tem mais socos!");
                        System.out.println("(2) Chute\n(3) Combo\n(4) Especial");
                        ata = leitor.nextInt();
                    }
                    else if(ata == 2 && this.user.getQuantchute()<=0){
                        System.out.println("Você não tem mais chutes!");
                        System.out.println("(1) Soco\n(3) Combo\n(4) Especial");
                        ata = leitor.nextInt();
                    }
                    else if(ata == 3 && this.user.getQuantcombo()<=0){
                        System.out.println("Você não tem mais combos!");
                        System.out.println("(1) Soco\n(2) Chute\n(4) Especial");
                        ata = leitor.nextInt();
                    }
                    else if(ata == 4 && this.user.getQuantespecial()<=0){
                        System.out.println("Você não tem mais especiais!");
                        System.out.println("(1) Soco\n(2) Chute\n(3) Combo");
                        ata = leitor.nextInt();
                    }
                    switch(ata){
                        case 1:
                            System.out.println("Você deu um soco");
                            System.out.println("Causou "+this.user.getAtaque()/2+" de dano");
                            this.inim.setHp(this.inim.getHp()-this.user.getAtaque()/2);
                            this.user.setQuantsoco(this.user.getQuantsoco()-1);
                            System.out.println("----Você tem "+this.user.getQuantsoco()+" socos----");
                            break;
                        case 2:System.out.println("Você deu um chute");
                            System.out.println("Causou "+(int)(this.user.getAtaque()/1.75f)+" de dano");  
                            this.inim.setHp(this.inim.getHp()- (int)(this.user.getAtaque()/1.75f));
                            this.user.setQuantchute(this.user.getQuantchute()-1);
                            System.out.println("----Você tem "+this.user.getQuantchute()+" chutes----");
                            break;
                        case 3:System.out.println("Você deu um combo");
                            System.out.println("Causou "+(int)(this.user.getAtaque()/1.5f)+" de dano");
                            this.inim.setHp(this.inim.getHp()-(int)(this.user.getAtaque()/1.5f));
                            this.user.setQuantcombo(this.user.getQuantcombo()-1);
                            System.out.println("----Você tem "+this.user.getQuantcombo()+" combos----");
                            break;
                        case 4:System.out.println("Você deu um especial");
                            System.out.println("Causou "+(this.user.getAtaque())+" de dano");
                            this.inim.setHp(this.inim.getHp()-this.user.getAtaque());
                            this.user.setQuantespecial(this.user.getQuantespecial()-1);
                            System.out.println("----Você tem "+this.user.getQuantespecial()+" especial----");
                            break;
                    }
                }
                int vidainim = this.inim.getHp();
                if(vidainim <= 0)
                    vidainim = 0;
                if(vidainim == 0){
                    System.out.println("Você Ganhou");
                    System.out.println("Sua vida: "+this.user.getHp());
                    System.out.println("Vida Inimigo: "+vidainim);
                    this.user.ganharXP(this.inim.getLevel()*10);
                    System.out.println("Você Ganhou "+this.inim.getLevel()*10+" de xp");
                    System.out.println("Faltam "+(this.user.getExptotal()-this.user.getExperiencia())
                                        +" de xp");
                    System.out.println("=========================");
                    break;
                }
                System.out.println("Sua vida: "+this.user.getHp());
                System.out.println("Vida Inimigo: "+vidainim);
            }
        }
    }
    public Batalha(Usuario thePlayer, Boss theEnemy){
        user = thePlayer;
        boss = theEnemy;
        battle();
    }
    public void battle(){
        System.out.println("=========================");
        System.out.println(this.user.getNome()+" VS BOSS");
        while(this.user.getHp() > 0 && this.boss.getHp() > 0){
            if(this.user.getSpeed() > this.boss.getSpeed()){
                int ata = this.user.Ataque();
                Random ger = new Random();
                int errar = ger.nextInt(3);
                System.out.println("------ SUA VEZ ------");
                if(errar == 100){
                    System.out.println("VOCÊ ERROU");
                }
                else{
                    Scanner leitor = new Scanner(System.in);
                    if(ata == 1 && this.user.getQuantsoco()<=0){
                        System.out.println("Você não tem mais socos!");
                        System.out.println("(2) Chute\n(3) Combo\n(4) Especial");
                        ata = leitor.nextInt();
                    }
                    else if(ata == 2 && this.user.getQuantchute()<=0){
                        System.out.println("Você não tem mais chutes!");
                        System.out.println("(1) Soco\n(3) Combo\n(4) Especial");
                        ata = leitor.nextInt();
                    }
                    else if(ata == 3 && this.user.getQuantcombo()<=0){
                        System.out.println("Você não tem mais combos!");
                        System.out.println("(1) Soco\n(2) Chute\n(4) Especial");
                        ata = leitor.nextInt();
                    }
                    else if(ata == 4 && this.user.getQuantespecial()<=0){
                        System.out.println("Você não tem mais especiais!");
                        System.out.println("(1) Soco\n(2) Chute\n(3) Combo");
                        ata = leitor.nextInt();
                    }
                    switch(ata){
                        case 1:
                            System.out.println("Você deu um soco");
                            System.out.println("Causou "+this.user.getAtaque()/2+" de dano");
                            this.boss.setHp(this.boss.getHp()-this.user.getAtaque()/2);
                            this.user.setQuantsoco(this.user.getQuantsoco()-1);
                            System.out.println("----Você tem "+this.user.getQuantsoco()+" socos----");
                            break;
                        case 2:
                            System.out.println("Você deu um chute");
                            System.out.println("Causou "+(int)(this.user.getAtaque()/1.75f)+" de dano");  
                            this.boss.setHp(this.boss.getHp()- (int)(this.user.getAtaque()/1.75f));
                            this.user.setQuantchute(this.user.getQuantchute()-1);
                            System.out.println("----Você tem "+this.user.getQuantchute()+" chutes----");
                            break;
                        case 3:
                            System.out.println("Você deu um combo");
                            System.out.println("Causou "+(int)(this.user.getAtaque()/1.5f)+" de dano");
                            this.boss.setHp(this.boss.getHp()-(int)(this.user.getAtaque()/1.5f));
                            this.user.setQuantcombo(this.user.getQuantcombo()-1);
                            System.out.println("----Você tem "+this.user.getQuantcombo()+" combos----");
                            break;
                        case 4:
                            System.out.println("Você deu um especial");
                            System.out.println("Causou "+this.user.getAtaque()+" de dano");
                            this.boss.setHp(this.boss.getHp()-this.user.getAtaque());
                            this.user.setQuantespecial(this.user.getQuantespecial()-1);
                            System.out.println("----Você tem "+this.user.getQuantespecial()+" especial----");
                            break;
                    }
                }
                int vidainim = this.boss.getHp();
                if(vidainim <= 0)
                    vidainim = 0;
                if(vidainim == 0){
                    System.out.println("Você Ganhou");
                    System.out.println("Sua vida: "+this.user.getHp());
                    System.out.println("Vida Inimigo: "+vidainim);
                    this.user.ganharXP(this.boss.getLevel()*30,"Boss");
                    System.out.println("Você Ganhou "+this.boss.getLevel()*30+" de xp");
                    System.out.println("Faltam "+(this.user.getExptotal()-this.user.getExperiencia())
                                        +" de xp");
                    System.out.println("=========================");
                    break;
                }

                System.out.println("------ VEZ DO BOSS ------");
                ata = this.inim.Ataque();
                if(ata == 0 || ata == 5){
                    System.out.println("O BOSS ERROU");
                }
                else{
                    switch(ata){
                        case 1:System.out.println("Boss deu um soco");
                            System.out.println("Causou "+this.boss.getAtaque()/2+" de dano");
                            this.user.setHp(this.user.getHp()-this.boss.getAtaque()/2);
                            break;
                        case 2:System.out.println("Boss deu um chute");
                            System.out.println("Causou "+(int)(this.user.getAtaque()/1.75f)+" de dano");
                            this.user.setHp(this.user.getHp()-(int)(this.boss.getAtaque()/1.75f));
                            break;
                        case 3:System.out.println("Boss deu um combo");
                            System.out.println("Causou "+(int)(this.user.getAtaque()/1.5f)+" de dano");
                            this.user.setHp(this.user.getHp()-(int)(this.boss.getAtaque()/1.5f));
                            break;
                        case 4:System.out.println("Boss deu um especial");
                            System.out.println("Causou "+this.inim.getAtaque()+" de dano");
                            this.user.setHp(this.user.getHp()-this.boss.getAtaque());
                            break;
                    }
                }
                int vidauser = this.user.getHp();
                if(vidauser <= 0)
                    vidauser = 0;
                System.out.println("Sua vida: "+vidauser);
                System.out.println("Vida Inimigo: "+this.boss.getHp());
                if(vidauser == 0){
                System.out.println("Você perdeu");
                } 
                System.out.println("=========================");
            }
            else{
                
                Random ger = new Random();
                int errar = ger.nextInt(3);
                System.out.println("------ VEZ DO BOSS ------");
                int ata = this.boss.Ataque();
                if(ata == 0 || ata == 5){
                    System.out.println("O BOSS ERROU");
                }
                else{
                    switch(ata){
                        case 1:System.out.println("Boss deu um soco");
                            System.out.println("Causou "+this.boss.getAtaque()/2+" de dano");
                            this.user.setHp(this.user.getHp()-this.boss.getAtaque()/2);
                            break;
                        case 2:System.out.println("Boss deu um chute");
                            System.out.println("Causou "+(int)(this.boss.getAtaque()/1.75f)+" de dano");
                            this.user.setHp(this.user.getHp()-(int)(this.boss.getAtaque()/1.75f));
                            break;
                        case 3:System.out.println("Boss deu um combo");
                            System.out.println("Causou "+(int)(this.boss.getAtaque()/1.5f)+" de dano");
                            this.user.setHp(this.user.getHp()-(int)(this.boss.getAtaque()/1.5f));
                            break;
                        case 4:System.out.println("Boss deu um especial");
                            System.out.println("Causou "+this.boss.getAtaque()+" de dano");
                            this.user.setHp(this.user.getHp()-this.boss.getAtaque());
                            break;
                    }
                }
                int vidauser = this.user.getHp();
                if(vidauser <= 0)
                    vidauser = 0;
                
                if(vidauser == 0){
                System.out.println("Sua vida: "+vidauser);
                System.out.println("Vida Inimigo: "+this.boss.getHp());
                System.out.println("---- VOCÊ PERDEU ----");
                System.out.println("=========================");
                break;
                } 
                
                System.out.println("------ SUA VEZ ------");
                ata = this.user.Ataque();
                if(errar == 455){
                    System.out.println("---- VOCÊ ERROU ----");
                }
                else{
                    Scanner leitor = new Scanner(System.in);
                    if(ata == 1 && this.user.getQuantsoco()<=0){
                        System.out.println("Você não tem mais socos!");
                        System.out.println("(2) Chute\n(3) Combo\n(4) Especial");
                        ata = leitor.nextInt();
                    }
                    else if(ata == 2 && this.user.getQuantchute()<=0){
                        System.out.println("Você não tem mais chutes!");
                        System.out.println("(1) Soco\n(3) Combo\n(4) Especial");
                        ata = leitor.nextInt();
                    }
                    else if(ata == 3 && this.user.getQuantcombo()<=0){
                        System.out.println("Você não tem mais combos!");
                        System.out.println("(1) Soco\n(2) Chute\n(4) Especial");
                        ata = leitor.nextInt();
                    }
                    else if(ata == 4 && this.user.getQuantespecial()<=0){
                        System.out.println("Você não tem mais especiais!");
                        System.out.println("(1) Soco\n(2) Chute\n(3) Combo");
                        ata = leitor.nextInt();
                    }
                    switch(ata){
                        case 1:
                            System.out.println("Você deu um soco");
                            System.out.println("Causou "+this.user.getAtaque()/2+" de dano");
                            this.boss.setHp(this.boss.getHp()-this.user.getAtaque()/2);
                            this.user.setQuantsoco(this.user.getQuantsoco()-1);
                            System.out.println("----Você tem "+this.user.getQuantsoco()+" socos----");
                            break;
                        case 2:System.out.println("Você deu um chute");
                            System.out.println("Causou "+(int)(this.user.getAtaque()/1.75f)+" de dano");  
                            this.boss.setHp(this.boss.getHp()- (int)(this.user.getAtaque()/1.75f));
                            this.user.setQuantchute(this.user.getQuantchute()-1);
                            System.out.println("----Você tem "+this.user.getQuantchute()+" chutes----");
                            break;
                        case 3:System.out.println("Você deu um combo");
                            System.out.println("Causou "+(int)(this.user.getAtaque()/1.5f)+" de dano");
                            this.boss.setHp(this.boss.getHp()-(int)(this.user.getAtaque()/1.5f));
                            this.user.setQuantcombo(this.user.getQuantcombo()-1);
                            System.out.println("----Você tem "+this.user.getQuantcombo()+" combos----");
                            break;
                        case 4:System.out.println("Você deu um especial");
                            System.out.println("Causou "+(this.user.getAtaque())+" de dano");
                            this.boss.setHp(this.boss.getHp()-this.user.getAtaque());
                            this.user.setQuantespecial(this.user.getQuantespecial()-1);
                            System.out.println("----Você tem "+this.user.getQuantespecial()+" especial----");
                            break;
                    }
                    System.out.println("Sua vida: "+vidauser);
                    System.out.println("Vida Inimigo: "+this.boss.getHp());
                    int vidainim = this.boss.getHp();
                    if(vidainim <= 0)
                        vidainim = 0;
                    if(vidainim == 0){
                    System.out.println("---- VOCÊ GANHOU ----");
                    System.out.println("Sua vida: "+this.user.getHp());
                    System.out.println("Vida Inimigo: "+vidainim);
                    System.out.println("Você Ganhou "+this.boss.getLevel()*30+" de xp");
                    this.user.ganharXP(this.boss.getLevel()*30,"Boss");
                    System.out.println("Faltam "+(this.user.getExptotal()-this.user.getExperiencia())
                                        +" de xp");
                    System.out.println("=========================");
                    break;
                }
                }
            }
        }
    }
}

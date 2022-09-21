package jogorpg;

import java.util.Scanner;

public class JogoRPG {
    public static void main(String[] args) {
         Scanner leitor = new Scanner(System.in);
         System.out.print("Qual o nome do seu personagem: ");
         String nome = leitor.nextLine();
        
         Usuario user = new Usuario(nome);
         
//         System.out.println("=========================");         
//         System.out.println(.toString());
//         System.out.println("=========================");
         int leveli = 1;
         while(user.getHp()>0){
             
             
             System.out.println("--------- LEVEL "+leveli+" ---------");
             
             if(leveli%5==0){
                 System.out.println("----- RECUPERANDO SUA VIDA-----\n-----BATALHA COM O CHEFE-----");
                 user.Recuperar();
                 Boss boss = new Boss(leveli);
                 Batalha batalha = new Batalha(user,boss);
             }
             else{
                Inimigo inimigo = new Inimigo(leveli);
                Batalha batalha = new Batalha(user,inimigo);
             }
             System.out.println("Deseja ver os Status do personagem? [s] [n]");
             String r = leitor.nextLine();
             if("s".equals(r)){
                 System.out.println("=========================");         
                 System.out.println(user.toString());
                 System.out.println("=========================");
             }             
             else {
                 ;
             }
             leveli++;    
         }
        }        
}
    

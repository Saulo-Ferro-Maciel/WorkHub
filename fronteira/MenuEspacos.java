package fronteira;

import controle.AdministradorSistema;
import java.util.Scanner;

public class MenuEspacos {
  private AdministradorSistema administrador;
   private Scanner scanner;

  public MenuEspacos(AdministradorSistema administrador, Scanner scanner) {
     this.administrador = administrador;
    this.scanner = scanner;
  }

   public void exibir() {
    boolean continuar = true;
     while (continuar) {
      System.out.println("\n=== MENU ESPACOS ===");
       System.out.println("1. Criar Espaco");
      System.out.println("2. Voltar ao Menu Principal");
       System.out.print("Escolha uma opcao: ");
      
       int opcao = scanner.nextInt();
      scanner.nextLine();
       
      switch (opcao) {
         case 1:
          criarEspaco();
           break;
        case 2:
           continuar = false;
          break;
         default:
          System.out.println("Opcao invalida!");
       }
    }
  }

   private void criarEspaco() {
    System.out.println("Tipos de espaco:");
     System.out.println("1. EstacaoTrabalho");
    System.out.println("2. SalaPrivada");
     System.out.println("3. SalaReuniao");
    System.out.println("4. Auditorio");
     System.out.print("Escolha o tipo: ");
    
     int tipoOpcao = scanner.nextInt();
    scanner.nextLine();
     
    String tipo = "";
     switch (tipoOpcao) {
      case 1: tipo = "EstacaoTrabalho"; break;
       case 2: tipo = "SalaPrivada"; break;
      case 3: tipo = "SalaReuniao"; break;
       case 4: tipo = "Auditorio"; break;
      default: 
         System.out.println("Tipo invalido!");
        return;
     }
    
     System.out.print("Digite o ID do espaco: ");
    String id = scanner.nextLine();
     System.out.print("Digite o nome do espaco: ");
    String nome = scanner.nextLine();
     System.out.print("Digite o valor por hora: ");
    double valorHora = scanner.nextDouble();
     
    try {
       administrador.criarEspaco(tipo, id, nome, valorHora);
      System.out.println("Espaco criado com sucesso!");
     } catch (Exception e) {
      System.out.println("Erro ao criar espaco: " + e.getMessage());
     }
  }
}

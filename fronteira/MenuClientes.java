package fronteira;

import controle.AdministradorSistema;
import java.util.Scanner;

public class MenuClientes {
  private AdministradorSistema administrador;
   private Scanner scanner;

  public MenuClientes(AdministradorSistema administrador, Scanner scanner) {
     this.administrador = administrador;
    this.scanner = scanner;
  }

   public void exibir() {
    boolean continuar = true;
     while (continuar) {
      System.out.println("\n=== MENU CLIENTES ===");
       System.out.println("1. Cadastrar Cliente");
      System.out.println("2. Voltar ao Menu Principal");
       System.out.print("Escolha uma opcao: ");
      
       int opcao = scanner.nextInt();
      scanner.nextLine();
       
      switch (opcao) {
         case 1:
          cadastrarCliente();
           break;
        case 2:
           continuar = false;
          break;
         default:
          System.out.println("Opcao invalida!");
       }
    }
  }

   private void cadastrarCliente() {
    System.out.print("Digite o CPF do cliente: ");
     String cpf = scanner.nextLine();
    System.out.print("Digite o nome do cliente: ");
     String nome = scanner.nextLine();
    System.out.print("Digite o email do cliente: ");
     String email = scanner.nextLine();
    System.out.print("Digite o telefone do cliente: ");
     String telefone = scanner.nextLine();
    
     try {
      administrador.cadastrarCliente(cpf, nome, email, telefone);
       System.out.println("Cliente cadastrado com sucesso!");
    } catch (Exception e) {
       System.out.println("Erro ao cadastrar cliente: " + e.getMessage());
    }
  }
}

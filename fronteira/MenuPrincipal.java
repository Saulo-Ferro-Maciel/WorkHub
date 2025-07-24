package fronteira;

import controle.AdministradorSistema;
import java.util.Scanner;

public class MenuPrincipal {
  private AdministradorSistema administrador;
   private Scanner scanner;
  private MenuClientes menuClientes;
   private MenuEspacos menuEspacos;
  private MenuReservas menuReservas;
   private MenuRelatorios menuRelatorios;

  public MenuPrincipal() {
     this.administrador = new AdministradorSistema();
    this.scanner = new Scanner(System.in);
     this.menuClientes = new MenuClientes(administrador, scanner);
    this.menuEspacos = new MenuEspacos(administrador, scanner);
     this.menuReservas = new MenuReservas(administrador, scanner);
    this.menuRelatorios = new MenuRelatorios(administrador, scanner);
  }

   public void exibir() {
    administrador.carregarDados();
     boolean continuar = true;
    while (continuar) {
       System.out.println("\n=== WORKHUB - SISTEMA DE COWORKING ===");
      System.out.println("1. Gerenciar Clientes");
       System.out.println("2. Gerenciar Espacos");
      System.out.println("3. Gerenciar Reservas");
       System.out.println("4. Relatorios");
      System.out.println("5. Sair");
       System.out.print("Escolha uma opcao: ");
      
       int opcao = scanner.nextInt();
      scanner.nextLine();
       
      switch (opcao) {
         case 1:
          menuClientes.exibir();
           break;
        case 2:
           menuEspacos.exibir();
          break;
         case 3:
          menuReservas.exibir();
           break;
        case 4:
           menuRelatorios.exibir();
          break;
         case 5:
          administrador.salvarDados();
           System.out.println("Dados salvos. Encerrando sistema...");
          continuar = false;
           break;
        default:
           System.out.println("Opcao invalida!");
      }
    }
   }
}

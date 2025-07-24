package fronteira;

import controle.AdministradorSistema;
import java.util.Scanner;

public class MenuRelatorios {
  private AdministradorSistema administrador;
   private Scanner scanner;

  public MenuRelatorios(AdministradorSistema administrador, Scanner scanner) {
     this.administrador = administrador;
    this.scanner = scanner;
  }

   public void exibir() {
    boolean continuar = true;
     while (continuar) {
      System.out.println("\n=== MENU RELATORIOS ===");
       System.out.println("1. Relatorio de Reservas por Cliente");
      System.out.println("2. Relatorio de Utilizacao de Espacos");
       System.out.println("3. Relatorio de Faturamento");
      System.out.println("4. Relatorio de Servicos Adicionais");
       System.out.println("5. Voltar ao Menu Principal");
      System.out.print("Escolha uma opcao: ");
       
      int opcao = scanner.nextInt();
       scanner.nextLine();
      
       switch (opcao) {
        case 1:
           relatorioReservasCliente();
          break;
         case 2:
          administrador.gerarRelatorioUtilizacaoEspacos();
           break;
        case 3:
           administrador.gerarRelatorioFaturamento();
          break;
         case 4:
          administrador.gerarRelatorioServicosAdicionais();
           break;
        case 5:
           continuar = false;
          break;
         default:
          System.out.println("Opcao invalida!");
       }
    }
  }

   private void relatorioReservasCliente() {
    System.out.print("Digite o CPF do cliente: ");
     String cpf = scanner.nextLine();
    administrador.gerarRelatorioReservasCliente(cpf);
  }
}

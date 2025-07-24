package fronteira;

import controle.AdministradorSistema;
import entidades.*;
import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.time.LocalDate;
import java.time.LocalTime;

public class MenuReservas {
  private AdministradorSistema administrador;
   private Scanner scanner;

  public MenuReservas(AdministradorSistema administrador, Scanner scanner) {
     this.administrador = administrador;
    this.scanner = scanner;
  }

   public void exibir() {
    boolean continuar = true;
     while (continuar) {
      System.out.println("\n=== MENU RESERVAS ===");
       System.out.println("1. Realizar Reserva");
      System.out.println("2. Cancelar Reserva");
       System.out.println("3. Verificar Disponibilidade");
      System.out.println("4. Voltar ao Menu Principal");
       System.out.print("Escolha uma opcao: ");
      
       int opcao = scanner.nextInt();
      scanner.nextLine();
       
      switch (opcao) {
         case 1:
          realizarReserva();
           break;
        case 2:
           cancelarReserva();
          break;
         case 3:
          verificarDisponibilidade();
           break;
        case 4:
           continuar = false;
          break;
         default:
          System.out.println("Opcao invalida!");
       }
    }
  }

   private void realizarReserva() {
    System.out.print("Digite o CPF do cliente: ");
     String cpf = scanner.nextLine();
    System.out.print("Digite o ID do espaco: ");
     String idEspaco = scanner.nextLine();
    System.out.print("Digite a data da reserva (YYYY-MM-DD): ");
     String dataStr = scanner.nextLine();
    System.out.print("Digite a hora de inicio (HH:MM): ");
     String horaInicioStr = scanner.nextLine();
    System.out.print("Digite a hora de fim (HH:MM): ");
     String horaFimStr = scanner.nextLine();
    
     try {
      LocalDate data = LocalDate.parse(dataStr);
       LocalTime horaInicio = LocalTime.parse(horaInicioStr);
      LocalTime horaFim = LocalTime.parse(horaFimStr);
       
      List<ServicoAdicional> servicos = new ArrayList<>();
       System.out.print("Deseja adicionar servicos? (s/n): ");
      String resp = scanner.nextLine();
       
      if (resp.equalsIgnoreCase("s")) {
         servicos = adicionarServicos();
      }
       
      administrador.realizarReserva(cpf, idEspaco, data, horaInicio, horaFim, servicos);
       System.out.println("Reserva realizada com sucesso!");
    } catch (Exception e) {
       System.out.println("Erro ao realizar reserva: " + e.getMessage());
    }
  }

   private List<ServicoAdicional> adicionarServicos() {
    List<ServicoAdicional> servicos = new ArrayList<>();
     boolean continuar = true;
    
     while (continuar) {
      System.out.println("Servicos disponveis:");
       System.out.println("1. Cafe Premium");
      System.out.println("2. Locker");
       System.out.println("3. Estacionamento");
      System.out.println("4. Recebimento de Correspondencia");
       System.out.println("5. Finalizar");
      System.out.print("Escolha um servico: ");
       
      int opcao = scanner.nextInt();
       scanner.nextLine();
      
       switch (opcao) {
        case 1:
           System.out.print("Quantidade: ");
          int qtdCafe = scanner.nextInt();
           servicos.add(new CafePremium(15.0, qtdCafe));
          break;
         case 2:
          System.out.print("Quantidade: ");
           int qtdLocker = scanner.nextInt();
          servicos.add(new Locker(10.0, qtdLocker));
           break;
        case 3:
           System.out.print("Duracao em horas: ");
          double duracao = scanner.nextDouble();
           servicos.add(new Estacionamento(duracao));
          break;
         case 4:
          servicos.add(new RecebimentoCorrespondencia(20.0));
           break;
        case 5:
           continuar = false;
          break;
         default:
          System.out.println("Opcao invalida!");
       }
    }
     return servicos;
  }

   private void cancelarReserva() {
    System.out.print("Digite o ID da reserva: ");
     int id = scanner.nextInt();
    
     try {
      administrador.cancelarReserva(id);
       System.out.println("Reserva cancelada com sucesso!");
    } catch (Exception e) {
       System.out.println("Erro ao cancelar reserva: " + e.getMessage());
    }
  }

   private void verificarDisponibilidade() {
    System.out.print("Digite o ID do espaco: ");
     String idEspaco = scanner.nextLine();
    System.out.print("Digite a data (YYYY-MM-DD): ");
     String dataStr = scanner.nextLine();
    System.out.print("Digite a hora (HH:MM): ");
     String horaStr = scanner.nextLine();
    
     try {
      LocalDate data = LocalDate.parse(dataStr);
       LocalTime hora = LocalTime.parse(horaStr);
      administrador.verificarDisponibilidade(idEspaco, data, hora);
     } catch (Exception e) {
      System.out.println("Erro ao verificar disponibilidade: " + e.getMessage());
     }
  }
}

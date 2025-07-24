package controle;

import entidades.*;
import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.List;
import java.time.LocalDate;
import java.time.LocalTime;
import java.io.*;

public class AdministradorSistema {
  private RepositorioClientes repositorioClientes;
   private RepositorioEspacos repositorioEspacos;
  private RepositorioReservas repositorioReservas;

  public AdministradorSistema() {
     this.repositorioClientes = new RepositorioClientes();
    this.repositorioEspacos = new RepositorioEspacos();
   this.repositorioReservas = new RepositorioReservas();
  }

   public void cadastrarCliente(String cpf, String nome, String email, String telefone) {
    Cliente cliente = new Cliente(cpf, nome, email, telefone, LocalDate.now());
     repositorioClientes.inserir(cliente);
  }

   public void criarEspaco(String tipo, String id, String nome, double valorHora) {
    Espaco espaco = null;
     if (tipo.equals("EstacaoTrabalho")) {
      espaco = new EstacaoTrabalho(id, nome, valorHora, true);
     } else if (tipo.equals("SalaPrivada")) {
      espaco = new SalaPrivada(id, nome, valorHora, true);
     } else if (tipo.equals("SalaReuniao")) {
      espaco = new SalaReuniao(id, nome, valorHora, true);
     } else if (tipo.equals("Auditorio")) {
      espaco = new Auditorio(id, nome, valorHora, true);
     }
    if (espaco != null) {
       repositorioEspacos.inserir(espaco);
    }
  }

   public void realizarReserva(String cpfCliente, String idEspaco, LocalDate dataReserva, LocalTime horaInicio, LocalTime horaFim, List<ServicoAdicional> servicos) {
    Cliente cliente = repositorioClientes.buscar(cpfCliente);
     Espaco espaco = repositorioEspacos.buscar(idEspaco);
    
     if (cliente != null && espaco != null && espaco.isDisponivel()) {
      double valorTotal = calcularValorTotal(espaco, horaInicio, horaFim, servicos);
       int id = repositorioReservas.obterProximoId();
      Reserva reserva = new Reserva(id, cliente, espaco, dataReserva, horaInicio, horaFim, valorTotal, servicos);
       repositorioReservas.inserir(reserva);
      espaco.setDisponivel(false);
     }
  }

   public void cancelarReserva(int idReserva) {
    Reserva reserva = repositorioReservas.buscar(idReserva);
     if (reserva != null) {
      reserva.getEspaco().setDisponivel(true);
       repositorioReservas.remover(idReserva);
    }
  }

   public void verificarDisponibilidade(String idEspaco, LocalDate data, LocalTime hora) {
    Espaco espaco = repositorioEspacos.buscar(idEspaco);
     if (espaco != null) {
      System.out.println("Espaco " + espaco.getNome() + " - Disponivel: " + espaco.isDisponivel());
     }
  }

   public void adicionarServicoReserva(int idReserva, ServicoAdicional servico) {
    Reserva reserva = repositorioReservas.buscar(idReserva);
     if (reserva != null) {
      reserva.getServicosAdicionais().add(servico);
       double novoValor = calcularValorTotal(reserva.getEspaco(), reserva.getHoraInicio(), reserva.getHoraFim(), reserva.getServicosAdicionais());
      reserva.setValorTotal(novoValor);
     }
  }

   public double calcularValorTotal(Espaco espaco, LocalTime horaInicio, LocalTime horaFim, List<ServicoAdicional> servicos) {
    double horasDuracao = horaFim.getHour() - horaInicio.getHour();
     double valorEspaco = espaco.getValorHora() * horasDuracao;
    double valorServicos = 0.0;
     for (ServicoAdicional servico : servicos) {
      valorServicos += servico.getValorTotal();
     }
    return valorEspaco + valorServicos;
  }

   public void gerarRelatorioReservasCliente(String cpfCliente) {
    List<Reserva> reservas = repositorioReservas.listarTodos();
     System.out.println("Relatorio de Reservas - Cliente: " + cpfCliente);
    for (Reserva reserva : reservas) {
       if (reserva.getCliente().getCpf().equals(cpfCliente)) {
        System.out.println("Reserva ID: " + reserva.getId() + " - Espaco: " + reserva.getEspaco().getNome());
       }
    }
  }

   public void gerarRelatorioUtilizacaoEspacos() {
    List<Espaco> espacos = repositorioEspacos.listarTodos();
     List<Reserva> reservas = repositorioReservas.listarTodos();
    System.out.println("Relatorio de Utilizacao de Espacos:");
     for (Espaco espaco : espacos) {
      int contador = 0;
       for (Reserva reserva : reservas) {
        if (reserva.getEspaco().getId().equals(espaco.getId())) {
           contador++;
        }
       }
      System.out.println("Espaco: " + espaco.getNome() + " - Reservas: " + contador);
     }
  }

   public void gerarRelatorioFaturamento() {
    List<Reserva> reservas = repositorioReservas.listarTodos();
     double totalFaturamento = 0.0;
    System.out.println("Relatorio de Faturamento:");
     for (Reserva reserva : reservas) {
      totalFaturamento += reserva.getValorTotal();
     }
    System.out.println("Total Faturado: R$ " + totalFaturamento);
  }

   public void gerarRelatorioServicosAdicionais() {
    List<Reserva> reservas = repositorioReservas.listarTodos();
     Map<String, Integer> contadorServicos = new HashMap<>();
    System.out.println("Relatorio de Servicos Adicionais:");
     for (Reserva reserva : reservas) {
      for (ServicoAdicional servico : reserva.getServicosAdicionais()) {
         String descricao = servico.getDescricao();
        contadorServicos.put(descricao, contadorServicos.getOrDefault(descricao, 0) + 1);
       }
    }
     for (Map.Entry<String, Integer> entry : contadorServicos.entrySet()) {
      System.out.println("Servico: " + entry.getKey() + " - Quantidade: " + entry.getValue());
     }
  }

   public void salvarDados() {
    try {
       repositorioClientes.salvarArquivo("clientes.dat");
      repositorioEspacos.salvarArquivo("espacos.dat");
       repositorioReservas.salvarArquivo("reservas.dat");
    } catch (Exception e) {
       System.out.println("Erro ao salvar dados: " + e.getMessage());
    }
  }

   public void carregarDados() {
    try {
       repositorioClientes.carregarArquivo("clientes.dat");
      repositorioEspacos.carregarArquivo("espacos.dat");
       repositorioReservas.carregarArquivo("reservas.dat");
    } catch (Exception e) {
       System.out.println("Erro ao carregar dados: " + e.getMessage());
    }
  }
}

package entidades;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

public class Reserva {
  private int id;
   private Cliente cliente;
  private Espaco espaco;
   private LocalDate dataReserva;
  private LocalTime horaInicio;
   private LocalTime horaFim;
  private double valorTotal;
   private List<ServicoAdicional> servicosAdicionais;

  public Reserva(int id, Cliente cliente, Espaco espaco, LocalDate dataReserva, LocalTime horaInicio, LocalTime horaFim, double valorTotal, List<ServicoAdicional> servicosAdicionais) {
     this.id = id;
    this.cliente = cliente;
   this.espaco = espaco;
    this.dataReserva = dataReserva;
     this.horaInicio = horaInicio;
    this.horaFim = horaFim;
   this.valorTotal = valorTotal;
    this.servicosAdicionais = servicosAdicionais;
  }

   public int getId() {
    return id;
   }

  public void setId(int id) {
     this.id = id;
  }

   public Cliente getCliente() {
    return cliente;
   }

  public void setCliente(Cliente cliente) {
     this.cliente = cliente;
  }

   public Espaco getEspaco() {
    return espaco;
   }

  public void setEspaco(Espaco espaco) {
     this.espaco = espaco;
  }

   public LocalDate getDataReserva() {
    return dataReserva;
   }

  public void setDataReserva(LocalDate dataReserva) {
     this.dataReserva = dataReserva;
  }

   public LocalTime getHoraInicio() {
    return horaInicio;
   }

  public void setHoraInicio(LocalTime horaInicio) {
     this.horaInicio = horaInicio;
  }

   public LocalTime getHoraFim() {
    return horaFim;
   }

  public void setHoraFim(LocalTime horaFim) {
     this.horaFim = horaFim;
  }

   public double getValorTotal() {
    return valorTotal;
   }

  public void setValorTotal(double valorTotal) {
     this.valorTotal = valorTotal;
  }

   public List<ServicoAdicional> getServicosAdicionais() {
    return servicosAdicionais;
   }

  public void setServicosAdicionais(List<ServicoAdicional> servicosAdicionais) {
     this.servicosAdicionais = servicosAdicionais;
  }
}

package entidades;

public class Estacionamento implements ServicoAdicional {
  private double duracaoHoras;

  public Estacionamento(double duracaoHoras) {
     this.duracaoHoras = duracaoHoras;
  }

   @Override
  public String getDescricao() {
     return "Estacionamento";
  }

   @Override
  public double getValorTotal() {
     return duracaoHoras * 5.0;
  }

   public double getDuracaoHoras() {
    return duracaoHoras;
   }

  public void setDuracaoHoras(double duracaoHoras) {
     this.duracaoHoras = duracaoHoras;
  }
}

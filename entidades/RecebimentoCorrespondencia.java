package entidades;

public class RecebimentoCorrespondencia implements ServicoAdicional {
  private double valorFixo;

  public RecebimentoCorrespondencia(double valorFixo) {
     this.valorFixo = valorFixo;
  }

   @Override
  public String getDescricao() {
     return "Recebimento de Correspondencia";
  }

   @Override
  public double getValorTotal() {
     return valorFixo;
  }

   public double getValorFixo() {
    return valorFixo;
   }

  public void setValorFixo(double valorFixo) {
     this.valorFixo = valorFixo;
  }
}

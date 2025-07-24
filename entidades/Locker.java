package entidades;

public class Locker implements ServicoAdicional {
  private double valorUnitario;
   private int quantidade;

  public Locker(double valorUnitario, int quantidade) {
     this.valorUnitario = valorUnitario;
    this.quantidade = quantidade;
  }

   @Override
  public String getDescricao() {
     return "Locker";
  }

   @Override
  public double getValorTotal() {
     return valorUnitario * quantidade;
  }

   public double getValorUnitario() {
    return valorUnitario;
   }

  public void setValorUnitario(double valorUnitario) {
     this.valorUnitario = valorUnitario;
  }

   public int getQuantidade() {
    return quantidade;
   }

  public void setQuantidade(int quantidade) {
     this.quantidade = quantidade;
  }
}

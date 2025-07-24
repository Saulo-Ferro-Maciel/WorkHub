package entidades;

public class CafePremium implements ServicoAdicional {
  private double valorUnitario;
   private int quantidade;

  public CafePremium(double valorUnitario, int quantidade) {
     this.valorUnitario = valorUnitario;
    this.quantidade = quantidade;
  }

   @Override
  public String getDescricao() {
     return "Cafe Premium";
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

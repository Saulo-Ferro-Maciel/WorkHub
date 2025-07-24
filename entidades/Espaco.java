package entidades;

public abstract class Espaco {
  protected String id;
   protected String nome;
  protected double valorHora;
   protected boolean disponivel;

  public Espaco(String id, String nome, double valorHora, boolean disponivel) {
     this.id = id;
    this.nome = nome;
   this.valorHora = valorHora;
    this.disponivel = disponivel;
  }

   public String getId() {
    return id;
   }

  public void setId(String id) {
     this.id = id;
  }

   public String getNome() {
    return nome;
   }

  public void setNome(String nome) {
     this.nome = nome;
  }

   public double getValorHora() {
    return valorHora;
   }

  public void setValorHora(double valorHora) {
     this.valorHora = valorHora;
  }

   public boolean isDisponivel() {
    return disponivel;
   }

  public void setDisponivel(boolean disponivel) {
     this.disponivel = disponivel;
  }

   public abstract String getTipo();
  public abstract String getDescricaoCompleta();
}

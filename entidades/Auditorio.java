package entidades;

public class Auditorio extends Espaco {

  public Auditorio(String id, String nome, double valorHora, boolean disponivel) {
     super(id, nome, valorHora, disponivel);
  }

   @Override
  public String getTipo() {
     return "Auditorio";
  }

   @Override
  public String getDescricaoCompleta() {
     return "Auditorio - " + nome + " (ID: " + id + ")";
  }
}

package entidades;

public class SalaPrivada extends Espaco {

  public SalaPrivada(String id, String nome, double valorHora, boolean disponivel) {
     super(id, nome, valorHora, disponivel);
  }

   @Override
  public String getTipo() {
     return "Sala Privada";
  }

   @Override
  public String getDescricaoCompleta() {
     return "Sala Privada - " + nome + " (ID: " + id + ")";
  }
}

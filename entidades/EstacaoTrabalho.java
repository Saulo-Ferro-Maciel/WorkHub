package entidades;

public class EstacaoTrabalho extends Espaco {

  public EstacaoTrabalho(String id, String nome, double valorHora, boolean disponivel) {
     super(id, nome, valorHora, disponivel);
  }

   @Override
  public String getTipo() {
     return "Estacao de Trabalho";
  }

   @Override
  public String getDescricaoCompleta() {
     return "Estacao de Trabalho - " + nome + " (ID: " + id + ")";
  }
}

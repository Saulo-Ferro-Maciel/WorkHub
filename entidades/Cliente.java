package entidades;

import java.time.LocalDate;

public class Cliente {
 private String cpf;
  private String nome;
   private String email;
  private String telefone;
   private LocalDate dataCadastro;

  public Cliente(String cpf, String nome, String email, String telefone, LocalDate dataCadastro) {
    this.cpf = cpf;
     this.nome = nome;
    this.email = email;
     this.telefone = telefone;
      this.dataCadastro = dataCadastro;
  }

   public String getCpf() {
    return cpf;
   }

  public void setCpf(String cpf) {
   this.cpf = cpf;
  }

   public String getNome() {
     return nome;
   }

  public void setNome(String nome) {
    this.nome = nome;
  }

   public String getEmail() {
    return email;
   }

  public void setEmail(String email) {
     this.email = email;
  }

   public String getTelefone() {
    return telefone;
   }

  public void setTelefone(String telefone) {
     this.telefone = telefone;
  }

   public LocalDate getDataCadastro() {
    return dataCadastro;
   }

  public void setDataCadastro(LocalDate dataCadastro) {
     this.dataCadastro = dataCadastro;
  }
}

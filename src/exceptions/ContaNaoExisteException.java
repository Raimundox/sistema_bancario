package exceptions;

public class ContaNaoExisteException extends Exception {

  private String numeroInexistente;

  public ContaNaoExisteException(String num) {
    super("A conta de numero " + num + " nao existe");
    this.numeroInexistente = num;
  }

  public String getNumeroInexistente() {
    return numeroInexistente;
  }

}

package exceptions;

public class ContaJaExisteException extends Exception {

  private String numero;

  public ContaJaExisteException(String num) {
    super("A conta de numero " + num + " ja existe");
    this.numero = num;
  }

  public String getNumero() {
    return numero;
  }

  public void fazNada() {
    System.out.println("teste");
  }

}

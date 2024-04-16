package gui;

import exceptions.ContaJaExisteException;
import negocio.BancoFachada;
import negocio.beans.Conta;

public class TelaMobile {

  public TelaMobile() {
  }

  public void pintarTela() {
    // Usando a instancia da Fachada
    String num = "1234-5"; // N�mero deve vir da tela
    double saldo = 50.0; // N�mero deve vir da tela
    Conta c = new Conta(num, saldo);
    try {
      BancoFachada.getInstance().cadastrarConta(c);
    } catch (ContaJaExisteException e) {
      // Tratamento de exce��o deve mostrar alguma mensagem para o us�rio
      System.out.println(e.getMessage());
    }
  }

}

package gui;

import javax.swing.JFrame;

import exceptions.ContaJaExisteException;
import negocio.BancoFachada;
import negocio.beans.Conta;

public class TelaDesktopSwing extends JFrame {

  public TelaDesktopSwing() throws ContaJaExisteException {
    super("Meu frame de cadastro de clientes");

    Conta c = new Conta("1234-5", 100);
    BancoFachada.getInstance().cadastrarConta(c);

  }

}

package negocio;

import exceptions.ContaJaExisteException;
import exceptions.ContaNaoExisteException;
import exceptions.SaldoInsuficienteException;
import negocio.beans.Conta;

public interface IBanco {

  void cadastrarCliente();

  void efetuarLogin();

  void cadastrarConta(Conta c) throws ContaJaExisteException;

  void removerConta(String num) throws ContaNaoExisteException;

  Conta procurarConta(String num) throws ContaNaoExisteException;

  void transferir(String numOrigem, String numDestino, double valor)
      throws ContaNaoExisteException, SaldoInsuficienteException;

}
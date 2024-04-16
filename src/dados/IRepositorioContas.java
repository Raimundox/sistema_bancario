package dados;

import exceptions.ContaNaoExisteException;
import negocio.beans.Conta;

public interface IRepositorioContas {

  void cadastrar(Conta c);


  void cadastrar(String numero, double saldoInicial);


  Conta procurar(String num) throws ContaNaoExisteException;

  boolean existe(String numConta);


  void remover(String num) throws ContaNaoExisteException;

  void renderJuros(String num) throws ContaNaoExisteException;


  Conta[] retornaContasVIP();


  void salvarArquivo();

}
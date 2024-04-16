package negocio;

import dados.RepositorioContasArray;
import exceptions.ContaJaExisteException;
import exceptions.ContaNaoExisteException;
import exceptions.SaldoInsuficienteException;
import negocio.beans.Conta;

public class BancoFachada implements IBanco {

  private CadastroClientes clientes;
  private CadastroContas contas;
  private CadastroLogins logins;

  private static IBanco instance;

  private BancoFachada() {
    this.contas = new CadastroContas(RepositorioContasArray.getInstance());
    this.clientes = new CadastroClientes();
    this.logins = new CadastroLogins();
  }

  public static IBanco getInstance() {
    if (instance == null) {
      instance = new BancoFachada();
    }
    return instance;
  }

  public void imprimirInstancia() {
    System.out.println(instance);
  }

  /*
   * (non-Javadoc)
   * 
   * @see negocio.IFachada#cadastrarCliente()
   */
  public void cadastrarCliente() {
    this.clientes.cadastrar();
  }

  /*
   * (non-Javadoc)
   * 
   * @see negocio.IFachada#cadastrarConta(br.ufrpe.
   * sistema_bancario.negocio.beans.Conta)
   */
  public void cadastrarConta(Conta c) throws ContaJaExisteException {
    this.contas.cadastrar(c);
  }

  /*
   * (non-Javadoc)
   * 
   * @see
   * negocio.IFachada#procurarConta(java.lang.String)
   */
  public Conta procurarConta(String num) throws ContaNaoExisteException {
    return this.contas.procurar(num);
  }

  /*
   * (non-Javadoc)
   * 
   * @see
   * negocio.IFachada#transferir(java.lang.String,
   * java.lang.String, double)
   */
  public void transferir(String numOrigem, String numDestino, double valor)
      throws ContaNaoExisteException, SaldoInsuficienteException {
    contas.transferir(numOrigem, numDestino, valor);
  }

  /*
   * (non-Javadoc)
   * 
   * @see
   * negocio.IFachada#removerConta(java.lang.String)
   */
  public void removerConta(String num) throws ContaNaoExisteException {
    this.contas.remover(num);
  }

  /*
   * (non-Javadoc)
   * 
   * @see negocio.IFachada#efetuarLogin()
   */
  public void efetuarLogin() {
    this.logins.efetuarLogin();
  }

}

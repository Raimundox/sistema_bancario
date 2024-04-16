package negocio;

import dados.IRepositorioContas;
import exceptions.ContaJaExisteException;
import exceptions.ContaNaoExisteException;
import exceptions.SaldoInsuficienteException;
import negocio.beans.Conta;
import negocio.beans.Poupanca;

public class CadastroContas {

    private IRepositorioContas repositorio;

    public CadastroContas(IRepositorioContas instanciaRepositorio) {
        this.repositorio = instanciaRepositorio;
    }

    public void cadastrar(Conta c) throws ContaJaExisteException {
        if (c == null) {
            throw new IllegalArgumentException("Parametro invalido");
        } else {
            if (!this.existe(c.getNumero())) {
                this.repositorio.cadastrar(c);
                this.repositorio.salvarArquivo();
            } else {
                throw new ContaJaExisteException(c.getNumero());
            }
        }
    }

    public void descadastrar(String numConta) throws ContaNaoExisteException {
        Conta c = this.repositorio.procurar(numConta);
        if (c != null && c.getSaldo() == 0) {
            this.repositorio.remover(numConta);
            this.repositorio.salvarArquivo();
        } else {
            throw new ContaNaoExisteException(numConta);
        }
    }

    public Conta procurar(String num) throws ContaNaoExisteException {
        return this.repositorio.procurar(num);
    }

    public boolean existe(String numConta) {
        return this.repositorio.existe(numConta);
    }

    public void remover(String num) throws ContaNaoExisteException {
        this.repositorio.remover(num);
        this.repositorio.salvarArquivo();
    }

    public void creditar(String num, double valor)
            throws ContaNaoExisteException {
        Conta contaCredito = this.repositorio.procurar(num);
        if (contaCredito != null) {
            contaCredito.creditar(valor);
            this.repositorio.salvarArquivo();
        }
    }

    public void debitar(String num, double valor)
            throws ContaNaoExisteException, SaldoInsuficienteException {
        Conta contaDebito = this.repositorio.procurar(num);
        if (contaDebito != null) {
            contaDebito.debitar(valor);
            this.repositorio.salvarArquivo();
        }
    }


    public void transferir(String numOrigem, String numDestino, double valor)
            throws ContaNaoExisteException, SaldoInsuficienteException {
        Conta origem = this.repositorio.procurar(numOrigem);
        Conta destino = this.repositorio.procurar(numDestino);
        if (origem != null && destino != null && origem.getSaldo() >= valor) {
            origem.debitar(valor);
            destino.creditar(valor);
            this.repositorio.salvarArquivo();
        }
    }

    public double getSaldo(String num) throws ContaNaoExisteException {
        Conta c = this.repositorio.procurar(num);
        return c.getSaldo();
    }

    public static final double TAXA_JUROS = 0.01;

    public void renderJuros(String num) throws ContaNaoExisteException {
        Conta c = this.repositorio.procurar(num);
        if (c instanceof Poupanca) {
            ((Poupanca) c).renderJuros(TAXA_JUROS);
            this.repositorio.salvarArquivo();
        } else {
            throw new ContaNaoExisteException(num);
        }
    }
}

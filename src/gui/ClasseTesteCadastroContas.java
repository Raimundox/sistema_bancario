package gui;

import dados.IRepositorioContas;
import dados.RepositorioContasArray;
import exceptions.ContaJaExisteException;
import exceptions.ContaNaoExisteException;
import exceptions.SaldoInsuficienteException;
import negocio.CadastroContas;
import negocio.beans.Conta;
import negocio.beans.Poupanca;

public class ClasseTesteCadastroContas {
    public static void main(String[] args) {
        IRepositorioContas instanciaRepositorio = RepositorioContasArray.getInstance();
        CadastroContas bancoDoBrasil = new CadastroContas(instanciaRepositorio);
        
        try {
            bancoDoBrasil.cadastrar(new Conta("222-1", 500.0));
            bancoDoBrasil.cadastrar(new Poupanca("555-2"));
            bancoDoBrasil.creditar("222-1", 152.30);
            bancoDoBrasil.creditar("555-2", 43.50);            
            bancoDoBrasil.transferir("222-1", "555-2", 56.50);
            bancoDoBrasil.transferir("666-7", "555-2", 23.50);
            
            double saldoTotal = bancoDoBrasil.getSaldo("222-1");
            bancoDoBrasil.debitar("222-1", saldoTotal);
        } catch (SaldoInsuficienteException sie) {
            System.out.println(sie.getMessage());
            System.out.println("Conta/Saldo: " + sie.getNumero() + "/" + sie.getSaldo());
        } catch (ContaNaoExisteException cne) {
            cne.printStackTrace();
        } catch (ContaJaExisteException cje) {
            cje.printStackTrace();
        }
    } 
}

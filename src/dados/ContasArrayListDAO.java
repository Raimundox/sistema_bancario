package dados;

import java.util.ArrayList;
import java.util.List;

import negocio.beans.Conta;

public class ContasArrayListDAO extends AbstractArrayListDAO<Conta> {
    
    public ContasArrayListDAO() {
        super();
        
        // Exemplo de chamada de c�digo da super classe com tipo definido
        Conta newObj = new Conta ("8976-8", 200.50);
        this.create(newObj);
    }
    
    public List<Conta> listarContasIndadimplentes() {
        List<Conta> sublista = new ArrayList<>();
        for (Conta conta : this.elements) {
            if (conta.getSaldo() < 0) {
                sublista.add(conta);
            }
        }
        
        return sublista;
    }
}

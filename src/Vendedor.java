import java.util.ArrayList;

public class Vendedor {
    public Vendedor(String nome, String cpf){
        this.nome = nome;
        this.cpf = cpf;
    }

    public void addVenda(Venda venda){
        this.vendas.add(venda);
    }

    public String nome;
    public String cpf;
    public ArrayList<Venda> vendas = new ArrayList<>();

}
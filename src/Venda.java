import javax.swing.*;
import java.util.ArrayList;

public class Venda {

    public Venda(Vendedor vendedor){
        vendedor.addVenda(this);
    }
    public void addProduto(Produto produto){
        this.produtos.add(produto);
        this.setValorTotal();
    }

    public void addProduto(Produto produto, int quantidade){
        for(int i = 0; i < quantidade; i++){
            this.produtos.add(produto);

        }
        this.setValorTotal();
    }

    public double finalizarVenda(){
        this.fazerPagamento("Valor total R$" + this.valorTotal);
        while(this.pagamento < this.valorTotal){
            this.fazerPagamento("Valor faltante R$"+ ( this.valorTotal -this.pagamento ));
        }
        this.troco = this.pagamento - this.valorTotal;
        this.vendaConcluida = true;
        return this.troco;
    }

    private void fazerPagamento(String msg){

        try {
            String novoPagamento = JOptionPane.showInputDialog(null, msg);

            if(novoPagamento == null){
                System.exit(0);
            }
            this.pagamento += Double.parseDouble(novoPagamento);

        }catch (Exception error){
            JOptionPane.showMessageDialog(null,"Erro ao pagar, informe um valor valido");
            fazerPagamento(msg);
        }
    }

    private void setValorTotal(){
        this.valorTotal = 0;
        for (int i = 0; i < this.produtos.size(); i++) {
            this.valorTotal += this.produtos.get(i).valor;
        }
    }



    public boolean vendaConcluida = false;
    public double valorTotal;
    public double troco;
    public double pagamento;
    public ArrayList<Produto> produtos = new ArrayList<>();
}
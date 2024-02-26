import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        Vendedor Lais = new Vendedor("Lais", "123.721.629-00");

        Produto feijao = new Produto("Feijao", 6.50);
        Produto arroz = new Produto("Arroz", 7.50);


        Venda venda = new Venda(Lais);

        venda.addProduto(feijao, 2);
        venda.addProduto(arroz);

        double troco = venda.finalizarVenda();

        JOptionPane.showMessageDialog(null, "Venda conluida! " + (troco > 0 ? "\r\nTroco R$"+troco : ""));
    }
}
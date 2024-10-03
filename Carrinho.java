import java.util.HashMap;
import java.util.Map;

public class Carrinho {
    private Map<Integer, ItemCarrinho> produtos;

    public Carrinho() {
        produtos = new HashMap<>();
    }

    public void adicionarProduto(Produto produto, int quantidade) {
        if (quantidade <= 0) return;

        if (produtos.containsKey(produto.getId())) {
            produtos.get(produto.getId()).adicionarQuantidade(quantidade);
        } else {
            produtos.put(produto.getId(), new ItemCarrinho(produto, quantidade));
        }
    }

    public void removerProduto(int produtoId) {
        produtos.remove(produtoId);
    }

    public void atualizarQuantidade(int produtoId, int quantidade) {
        if (produtos.containsKey(produtoId)) {
            if (quantidade <= 0) {
                removerProduto(produtoId);
            } else {
                produtos.get(produtoId).setQuantidade(quantidade);
            }
        }
    }

    public double calcularTotal() {
        return produtos.values().stream()
                .mapToDouble(ItemCarrinho::calcularPrecoTotal)
                .sum();
    }

    public void listarProdutos() {
        if (produtos.isEmpty()) {
            System.out.println("Carrinho vazio.");
            return;
        }
        produtos.values().forEach(System.out::println);
        System.out.println("Total a pagar: R$" + String.format("%.2f", calcularTotal()));
    }
}

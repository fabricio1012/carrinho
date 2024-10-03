public class Main {
    public static void main(String[] args) {
        Produto p1 = new Produto(1, "Camiseta", 29.90);
        Produto p2 = new Produto(2, "Calça", 79.90);
        Produto p3 = new Produto(3, "Tênis", 199.90);

        Cliente mateus = new Cliente("Mateus");
        
        // Adicionando produtos ao carrinho
        mateus.adicionarAoCarrinho(p1, 2);  // Adiciona 2 camisetas
        mateus.adicionarAoCarrinho(p2, 1);  // Adiciona 1 calça
        mateus.visualizarCarrinho();

        // Atualizando quantidade
        mateus.atualizarQuantidadeCarrinho(1, 1);  // Atualiza a quantidade da camiseta para 1
        System.out.println("\nApós atualizar a quantidade:");
        mateus.visualizarCarrinho();

        // Removendo produto
        mateus.removerDoCarrinho(2);  // Remove a calça
        System.out.println("\nApós remover a calça:");
        mateus.visualizarCarrinho();
    }
}

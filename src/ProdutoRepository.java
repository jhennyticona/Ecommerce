import java.util.ArrayList;
import java.util.List;

public class ProdutoRepository {
    private static List<Produto> produtos=new ArrayList<>();

    public static void adicionar(Produto produto){
        produtos.add(produto);
    }

    public static List<Produto> listar(){
        return produtos;
    }

    public static void atualizarProduto(int id, Produto produtoAtualizado) {
        for (int i = 0; i < produtos.size(); i++) {
            if (produtos.get(i).getId()==id) {
                produtos.set(i, produtoAtualizado);
                return;
            }
        }
    }

    public static Produto buscarPorId(int id) {
        for(Produto p:produtos){
            if(p.getId()==id){
                return p;
            }

        }
        return null;
    }
}

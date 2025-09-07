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
}

import java.util.ArrayList;
import java.util.List;

public class PedidoRepository {
    private static List<Pedido> pedidos = new ArrayList<>();

    public static void adicionar(Pedido pedido) {
        pedidos.add(pedido);
    }

    public static List<Pedido> listar() {
        return pedidos;
    }
}

import java.util.ArrayList;
import java.util.List;

public class ClienteRepository {
    private static List<Cliente> clientes=new ArrayList<>();
    public static void adicionar(Cliente cliente) {
        clientes.add(cliente);
    }
}

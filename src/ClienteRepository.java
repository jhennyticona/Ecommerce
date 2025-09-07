import java.util.ArrayList;
import java.util.List;

public class ClienteRepository {
    private static List<Cliente> clientes = new ArrayList<>();

    public static void adicionar(Cliente cliente) {
        clientes.add(cliente);
    }

    public static List<Cliente> listar() {
        return clientes;
    }

    public static Cliente buscarPorCPF(String cpf) {
        for (Cliente c : clientes) {
            if (c.getCpf().equals(cpf)) {
                return c;
            }
        }
        return null;
    }

    public static void atualizarCliente(String cpf, Cliente clienteAtualizado) {
        for (int i = 0; i < clientes.size(); i++) {
            if (clientes.get(i).getCpf().equals(cpf)) {
                clientes.set(i, clienteAtualizado);
                return;
            }
        }
    }
}

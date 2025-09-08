import java.util.List;
import java.util.Scanner;

public class Main {
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int opcao;
        boolean menu = true;
        while (menu) {
            System.out.println("*****************************************************");
            System.out.println("                                                     ");
            System.out.println("                     Ecommerce                       ");
            System.out.println("                                                     ");
            System.out.println("*****************************************************");
            System.out.println("                                                     ");
            System.out.println("            1 - Cadastrar Cliente                    ");
            System.out.println("            2 - Listar todos os clientes             ");
            System.out.println("            3 - Atualiza Cliente                     ");
            System.out.println("            4 - Cadastrar Produto                    ");
            System.out.println("            5 - Listar Produtos                      ");
            System.out.println("            6 - Atualizar Produtos                   ");
            System.out.println("            7 - Criar Venda                          ");
            System.out.println("            8 - Sair                                 ");
            System.out.println("                                                     ");
            System.out.println("*****************************************************");
            System.out.println("Entre com a opção desejada:                          ");
            opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    cadastrarCliente();
                    break;
                case 2:
                    listarCliente();
                    break;
                case 3:
                    atualizarCliente();
                    break;
                case 4:
                    cadastrarProduto();
                    break;
                case 5:
                    listarProdutos();
                    break;
                case 6:
                    atualizarProduto();
                    break;
                case 7:
                    criarPedido();
                    break;
                case 8:
                    System.out.println("Saindo do sistema...");
                    menu = false;
                    break;
                default:
                    System.out.println("Opção inválida");
                    break;
            }
        }
    }

    private static void cadastrarCliente() {
        System.out.println("Nome: ");
        String nome = scanner.nextLine();
        System.out.println("CPF: ");
        String cpf = scanner.nextLine();
        System.out.println("Celular: ");
        String celular = scanner.nextLine();
        System.out.println("Email: ");
        String email=scanner.nextLine();
        Cliente cliente = new Cliente(cpf, nome, celular,email);
        ClienteRepository.adicionar(cliente);
        System.out.println("Cliente cadastrado com sucesso!");
    }

    private static void listarCliente() {
        for (Cliente c : ClienteRepository.listar()) {
            System.out.println(c.toString());
        }
    }

    private static void atualizarCliente() {
        listarCliente();
        System.out.println("Digite o CPF do Cliente para atualizar");
        String cpf = scanner.nextLine();
        Cliente clienteAtualizar = ClienteRepository.buscarPorCPF(cpf);
        if (clienteAtualizar != null) {
            System.out.println("Nome: ");
            String novoNome = scanner.nextLine();
            System.out.println("Celular: ");
            String novoCelular = scanner.nextLine();
            System.out.println("Email: ");
            String novoEmail=scanner.nextLine();
            Cliente clienteAtualizado = new Cliente(clienteAtualizar.getCpf(), novoNome, novoCelular,novoEmail);
            ClienteRepository.atualizarCliente(cpf, clienteAtualizado);
            System.out.println("Cliente atualizado com sucesso!");
        } else {
            System.out.println("Cliente com CPF " + cpf + " não encontrado");
        }
    }

    private static void cadastrarProduto() {
        System.out.println("Nome do produto: ");
        String nome = scanner.nextLine();
        System.out.println("Preço: ");
        double preco = scanner.nextDouble();
        Produto produto = new Produto(ProdutoRepository.listar().size() + 1, nome, preco);
        ProdutoRepository.adicionar(produto);
        System.out.println("Produto cadastrado!");
    }

    private static void listarProdutos() {
        for (Produto p : ProdutoRepository.listar()) {
            System.out.println(p.toString());
        }
    }

    private static void atualizarProduto() {
        listarProdutos();
        System.out.println("Digite o ID do produto para atualizar");
        int id = scanner.nextInt();
        scanner.nextLine();
        Produto produtoAtualizar = ProdutoRepository.buscarPorId(id);
        if (produtoAtualizar != null) {
            System.out.println("Nome: ");
            String novoNome = scanner.nextLine();
            System.out.println("Preço: ");
            double novoPreco = scanner.nextDouble();
            Produto produtoAtualizado = new Produto(id, novoNome, novoPreco);
            ProdutoRepository.atualizarProduto(id, produtoAtualizado);
            System.out.println("Produto atualizado com sucesso!");
        } else {
            System.out.println("Produto com ID  " + id + " não encontrado");
        }
    }

    private static void criarPedido() {
        listarCliente();
        System.out.println("Digite CPF do Cliente: ");
        String cpfCliente = scanner.nextLine();
        Cliente cliente = ClienteRepository.buscarPorCPF(cpfCliente);
        if (cliente == null) {
            System.out.println("Cliente não encontrado!");
            return;
        }
        Pedido pedido = new Pedido(PedidoRepository.listar().size() + 1, cliente);
        boolean opcao = true;
        while (opcao) {
            System.out.println("\n1 - Adicionar item");
            System.out.println("2 - Remover item");
            System.out.println("3 - Finalizar pedido");
            System.out.println("4 - Listar pedido");
            System.out.println("5 - Pagar pedido");
            System.out.println("6 - Entregar pedido");
            System.out.println("7 - Sair da venda");
            int opc = scanner.nextInt();
            scanner.nextLine();
            switch (opc) {
                case 1 -> {
                    listarProdutos();
                    System.out.print("ID do produto: ");
                    int idProd = scanner.nextInt();
                    System.out.print("Quantidade: ");
                    int qtd = scanner.nextInt();
                    System.out.print("Valor de venda: ");
                    double valorVenda = scanner.nextDouble();
                    scanner.nextLine();
                    Produto prod = ProdutoRepository.buscarPorId(idProd);
                    if (prod != null) {
                        pedido.adicionarItem(new ItemPedido(prod, qtd, valorVenda));
                        System.out.println("Item adicionado!");
                    }
                }
                case 2 -> {
                    listarItens(pedido);
                    System.out.print("Índice do item para remover: ");
                    int idx = scanner.nextInt();
                    pedido.removerItem(idx);
                }
                case 3 -> pedido.finalizarPedido();
                case 4 -> pedido.listarPedido();
                case 5 -> pedido.pagar();
                case 6 -> pedido.entregar();
                case 7 -> opcao = false;
            }
        }
        PedidoRepository.adicionar(pedido);
    }

    private static void listarItens(Pedido pedido) {
        List<ItemPedido> itens=pedido.getItens();
        if(itens.isEmpty()){
            System.out.println("Nenhum item adicionado ao pedido");
            return;
        }
        for(int i=0;i<itens.size();i++){
            System.out.println(i+" - "+itens.get(i));
        }
    }
}
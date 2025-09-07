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

                    break;
                case 3:

                    break;
                case 4:

                    break;
                case 5:

                    break;
                case 6:

                    break;
                case 7:

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
        String cpf=scanner.nextLine();
        System.out.println("Celular: ");
        String celular= scanner.nextLine();
        Cliente cliente=new Cliente(cpf,nome,celular);
        ClienteRepository.adicionar(cliente);
        System.out.println("Cliente cadastrado com sucesso!");
    }
}
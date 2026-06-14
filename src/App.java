import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class App {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int opcao;

        do {
            System.out.println("\n=== Atividade - Filas em Java ===");
            System.out.println("1 - Fila com valores fixos");
            System.out.println("2 - Fila de nomes");
            System.out.println("3 - Remover 10 numeros da fila");
            System.out.println("4 - Fila de atendimento");
            System.out.println("5 - Fila de impressao");
            System.out.println("0 - Sair");
            System.out.print("Escolha uma opcao: ");

            opcao = lerInteiro(scanner);

            switch (opcao) {
                case 1:
                    exercicio01();
                    break;
                case 2:
                    exercicio02();
                    break;
                case 3:
                    exercicio03();
                    break;
                case 4:
                    menuFilaAtendimento(scanner);
                    break;
                case 5:
                    menuFilaImpressao(scanner);
                    break;
                case 0:
                    System.out.println("Programa encerrado.");
                    break;
                default:
                    System.out.println("Opcao invalida.");
            }
        } while (opcao != 0);
    }

    // Exercicio 01
    public static Queue<Integer> criarFilaValoresFixos() {
        Queue<Integer> fila = new LinkedList<>();
        fila.offer(10);
        fila.offer(20);
        fila.offer(30);
        fila.offer(40);
        fila.offer(50);
        return fila;
    }

    private static void exercicio01() {
        Queue<Integer> fila = criarFilaValoresFixos();

        System.out.println("Fila completa: " + fila);

        Integer removido = fila.poll();
        System.out.println("Elemento removido: " + removido);

        System.out.println("Fila apos remocao: " + fila);
    }

    // Exercicio 02
    public static Queue<String> criarFilaNomes() {
        Queue<String> fila = new LinkedList<>();
        fila.offer("Ana");
        fila.offer("Carlos");
        fila.offer("Pedro");
        fila.offer("Juliana");
        return fila;
    }

    private static void exercicio02() {
        Queue<String> fila = criarFilaNomes();

        System.out.println("Primeiro elemento da fila: " + fila.peek());
        System.out.println("Quantidade de elementos: " + fila.size());
    }

    // Exercicio 03
    public static List<Integer> removerTodosElementos(Queue<Integer> fila) {
        List<Integer> removidos = new ArrayList<>();

        while (fila != null && !fila.isEmpty()) {
            removidos.add(fila.poll());
        }

        return removidos;
    }

    private static void exercicio03() {
        Queue<Integer> fila = new LinkedList<>();

        for (int i = 1; i <= 10; i++) {
            fila.offer(i);
        }

        System.out.println("Fila inicial: " + fila);
        System.out.println("Elementos removidos:");

        List<Integer> removidos = removerTodosElementos(fila);
        for (Integer numero : removidos) {
            System.out.println(numero);
        }

        System.out.println("Fila final: " + fila);
    }

    // Exercicio 04
    public static List<String> atenderClientes(Queue<String> fila) {
        List<String> clientesAtendidos = new ArrayList<>();

        while (fila != null && !fila.isEmpty()) {
            clientesAtendidos.add(fila.poll());
        }

        return clientesAtendidos;
    }

    private static void menuFilaAtendimento(Scanner scanner) {
        Queue<String> fila = new LinkedList<>();
        int opcao;

        do {
            System.out.println("\n=== Fila de Atendimento ===");
            System.out.println("1 - Cadastrar cliente");
            System.out.println("2 - Atender primeiro cliente");
            System.out.println("3 - Mostrar proximo cliente");
            System.out.println("4 - Exibir fila completa");
            System.out.println("5 - Sair");
            System.out.print("Escolha uma opcao: ");

            opcao = lerInteiro(scanner);
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    System.out.print("Digite o nome do cliente: ");
                    String cliente = scanner.nextLine();
                    fila.offer(cliente);
                    System.out.println("Cliente cadastrado: " + cliente);
                    break;
                case 2:
                    if (fila.isEmpty()) {
                        System.out.println("Nao ha clientes na fila.");
                    } else {
                        System.out.println("Cliente atendido: " + fila.poll());
                    }
                    break;
                case 3:
                    if (fila.isEmpty()) {
                        System.out.println("Nao ha proximo cliente.");
                    } else {
                        System.out.println("Proximo cliente: " + fila.peek());
                    }
                    break;
                case 4:
                    System.out.println("Fila completa: " + fila);
                    break;
                case 5:
                    System.out.println("Voltando ao menu principal.");
                    break;
                default:
                    System.out.println("Opcao invalida.");
            }
        } while (opcao != 5);
    }

    // Exercicio 05
    public static void adicionarDocumento(Queue<String> fila, String documento) {
        if (fila != null && documento != null) {
            fila.offer(documento);
        }
    }

    public static String imprimirDocumento(Queue<String> fila) {
        if (fila == null || fila.isEmpty()) {
            return null;
        }
        return fila.poll();
    }

    public static String proximoDocumento(Queue<String> fila) {
        if (fila == null || fila.isEmpty()) {
            return null;
        }
        return fila.peek();
    }

    private static void menuFilaImpressao(Scanner scanner) {
        Queue<String> fila = new LinkedList<>();
        int opcao;

        do {
            System.out.println("\n=== Fila de Impressao ===");
            System.out.println("1 - Adicionar documento");
            System.out.println("2 - Imprimir primeiro documento");
            System.out.println("3 - Mostrar proximo documento");
            System.out.println("4 - Exibir documentos pendentes");
            System.out.println("5 - Sair");
            System.out.print("Escolha uma opcao: ");

            opcao = lerInteiro(scanner);
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    System.out.print("Digite o nome do documento: ");
                    String documento = scanner.nextLine();
                    adicionarDocumento(fila, documento);
                    System.out.println("Documento adicionado: " + documento);
                    break;
                case 2:
                    String impresso = imprimirDocumento(fila);
                    if (impresso == null) {
                        System.out.println("Nao ha documentos para imprimir.");
                    } else {
                        System.out.println("Documento impresso: " + impresso);
                    }
                    break;
                case 3:
                    String proximo = proximoDocumento(fila);
                    if (proximo == null) {
                        System.out.println("Nao ha proximo documento.");
                    } else {
                        System.out.println("Proximo documento: " + proximo);
                    }
                    break;
                case 4:
                    System.out.println("Documentos pendentes: " + fila);
                    break;
                case 5:
                    System.out.println("Voltando ao menu principal.");
                    break;
                default:
                    System.out.println("Opcao invalida.");
            }
        } while (opcao != 5);
    }

    private static int lerInteiro(Scanner scanner) {
        while (!scanner.hasNextInt()) {
            System.out.println("Entrada invalida. Digite um numero inteiro.");
            System.out.print("Escolha uma opcao: ");
            scanner.next();
        }
        return scanner.nextInt();
    }
}

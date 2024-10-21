
import java.util.Scanner;

public class atv2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[][] cadastro = new String[10][3]; // Matriz para armazenar até 10 pessoas (ID, Nome, Data de nascimento)
        int opcao;
        do {
            System.out.println("\n1. Inserir pessoa");
            System.out.println("2. Alterar dados da pessoa");
            System.out.println("3. Consultar dados da pessoa");
            System.out.println("4. Excluir pessoa");
            System.out.println("5. Sair");
            System.out.print("Escolha uma opção: ");
            opcao = sc.nextInt();
            sc.nextLine(); // Limpa o buffer

            switch (opcao) {
                case 1: // Inserir pessoa
                    for (int i = 0; i < cadastro.length; i++) {
                        if (cadastro[i][0] == null) { // Procura a primeira posição vazia
                            System.out.print("Digite o ID: ");
                            cadastro[i][0] = sc.nextLine();
                            System.out.print("Digite o nome: ");
                            cadastro[i][1] = sc.nextLine();
                            System.out.print("Digite a data de nascimento: ");
                            cadastro[i][2] = sc.nextLine();
                            System.out.println("Pessoa cadastrada com sucesso!");
                            break;
                        }
                    }
                    break;
                case 2: // Alterar dados da pessoa
                    System.out.print("Digite o ID da pessoa a ser alterada: ");
                    String idAlterar = sc.nextLine();
                    for (int i = 0; i < cadastro.length; i++) {
                        if (idAlterar.equals(cadastro[i][0])) {
                            System.out.print("Digite o novo nome: ");
                            cadastro[i][1] = sc.nextLine();
                            System.out.print("Digite a nova data de nascimento: ");
                            cadastro[i][2] = sc.nextLine();
                            System.out.println("Dados alterados com sucesso!");
                            break;
                        }
                    }
                    break;
                case 3: // Consultar dados da pessoa
                    System.out.print("Digite o ID da pessoa para consulta: ");
                    String idConsulta = sc.nextLine();
                    for (int i = 0; i < cadastro.length; i++) {
                        if (idConsulta.equals(cadastro[i][0])) {
                            System.out.println("ID: " + cadastro[i][0]);
                            System.out.println("Nome: " + cadastro[i][1]);
                            System.out.println("Data de nascimento: " + cadastro[i][2]);
                            break;
                        }
                    }
                    break;
                case 4: // Excluir pessoa
                    System.out.print("Digite o ID da pessoa a ser excluída: ");
                    String idExcluir = sc.nextLine();
                    for (int i = 0; i < cadastro.length; i++) {
                        if (idExcluir.equals(cadastro[i][0])) {
                            cadastro[i][0] = null; // Remove os dados
                            cadastro[i][1] = null;
                            cadastro[i][2] = null;
                            System.out.println("Pessoa excluída com sucesso!");
                            break;
                        }
                    }
                    break;
                case 5:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida!");
                    break;
            }
        } while (opcao != 5);

        sc.close();
    }
}

import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArvoreAVL queenBeeAVL = new ArvoreAVL();
        ArvoreAVL axionAVL = new ArvoreAVL();
        ArvoreAVL titaniumAVL = new ArvoreAVL();

        int opcao, ID;
        String nome, dataN, dataC, dep, cargo;
        double salario;
        boolean continua = true;

        do {
            System.out.print("Escolha entre as opções a seguir:\n");
            System.out.print("1. Inserir dados de funcionários na empresa Axion\n");
            System.out.print("2. Exibir lista de dados dos funcionários de Axion ordenados pelo Nome Completo\n");
            System.out.print("3. Inserir dados de funcionários na empresa Titanium\n");
            System.out.print("4. Exibir lista de dados dos funcionários de Titanium ordenados pelo Nome Completo\n");
            System.out.print("5. Unificar dados de Axion e Titanium na empresa QueenBee\n");
            System.out.print("6. Inserir dados de novo funcionário em QueenBee\n");
            System.out.print("7. Exibir lista de dados dos funcionários de QueenBee ordenados pelo Nome Completo\n");
            System.out.print("8. Exibir a lista de funcionários de QueenBee cujos nomes completos começam pela letra LETRA, onde LETRA é dada pelo usuário do programa.\n");
            System.out.print("9. Buscar os dados de um funcionário a partir de seu Nome Completo\n");
            System.out.print("10. Exibir a relação dos funcionários com os n salários mais altos em QueenBee em ordem decrescente de salário, com n digitado pelo usuário.\n");
            System.out.print("11. Sair\n");
            System.out.print("escolha: ");
            opcao = sc.nextInt();
            sc.nextLine(); // limpa buffer

            switch(opcao) {
                case 1:
                    System.out.print("\n--- Inserir dados de funcionários na empresa Axion ---\n");
                    System.out.print("Nome completo: ");
                    nome = sc.nextLine();
                    System.out.print("Data de nascimento: ");
                    dataN = sc.nextLine();
                    System.out.print("Data de contratação: ");
                    dataC = sc.nextLine();
                    System.out.print("Departamento: ");
                    dep = sc.nextLine();
                    System.out.print("Cargo: ");
                    cargo = sc.nextLine();
                    System.out.print("Salário: ");
                    salario = sc.nextDouble();
                    sc.nextLine();

                    axionAVL.inserir(0, nome, dataN, dataC, dep, cargo, salario);
                    System.out.println("Funcionário inserido com sucesso em Axion!\n");
                    break;

                case 2:
                    System.out.print("\n--- Lista de funcionários da Axion ---\n");
                    axionAVL.exibirEmOrdem();
                    break;

                case 3:
                    System.out.print("\n--- Inserir dados de funcionários na empresa Titanium ---\n");
                    System.out.print("ID: ");
                    ID = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Nome completo: ");
                    nome = sc.nextLine();
                    System.out.print("Data de nascimento: ");
                    dataN = sc.nextLine();
                    System.out.print("Data de contratação: ");
                    dataC = sc.nextLine();
                    System.out.print("Departamento: ");
                    dep = sc.nextLine();
                    System.out.print("Cargo: ");
                    cargo = sc.nextLine();
                    System.out.print("Salário: ");
                    salario = sc.nextDouble();
                    sc.nextLine();

                    titaniumAVL.inserir(ID, nome, dataN, dataC, dep, cargo, salario);
                    System.out.println("Funcionário inserido com sucesso em Titanium!\n");
                    break;

                case 4:
                    System.out.print("\n--- Lista de funcionários da Titanium ---\n");
                    titaniumAVL.exibirEmOrdem();
                    break;

               

                case 5:
                    System.out.println("\n--- Unificando Axion + Titanium em QueenBee ---");

                    queenBeeAVL.excluirArvore();

                    java.util.ArrayList<No> listaA = axionAVL.coletarEmLista();
                    java.util.ArrayList<No> listaT = titaniumAVL.coletarEmLista();

                    int novoID = 1;

                    // AXION → cria novos nós
                    for (No f : listaA) {
                        queenBeeAVL.inserir(
                            novoID++,
                            f.nome,
                            f.dataN,
                            f.dataC,
                            f.dep,
                            f.cargo,
                            f.salario
                        );
                    }

                    // TITANIUM → cria novos nós
                    for (No f : listaT) {
                        queenBeeAVL.inserir(
                            novoID++,
                            f.nome,
                            f.dataN,
                            f.dataC,
                            f.dep,
                            f.cargo,
                            f.salario
                        );
                    }

                    System.out.println("Unificação concluída!\n");
                    break;

                case 6:
                    System.out.print("\n--- Inserir novo funcionário em QueenBee ---\n");
                    System.out.print("Nome completo: ");
                    nome = sc.nextLine();
                    System.out.print("Data de nascimento: ");
                    dataN = sc.nextLine();
                    System.out.print("Data de contratação: ");
                    dataC = sc.nextLine();
                    System.out.print("Departamento: ");
                    dep = sc.nextLine();
                    System.out.print("Cargo: ");
                    cargo = sc.nextLine();
                    System.out.print("Salário: ");
                    salario = sc.nextDouble();
                    sc.nextLine();

                    int proxID = queenBeeAVL.coletarEmLista().size() + 1;

                    queenBeeAVL.inserir(proxID, nome, dataN, dataC, dep, cargo, salario);

                    System.out.println("Funcionário inserido com sucesso em QueenBee!\n");
                    break;

                case 7:
                    System.out.print("\n--- Funcionários de QueenBee ---\n");
                    queenBeeAVL.exibirEmOrdem();
                    break;

                case 8:
                    System.out.print("Digite a letra inicial: ");
                    char letra = sc.nextLine().charAt(0);

                    System.out.println("\n--- Funcionários que começam com '" + letra + "' ---");
                    queenBeeAVL.listarPorLetra(letra);
                    break;

                case 9:
                    System.out.print("\nNome completo para busca: ");
                    nome = sc.nextLine();

                    java.util.ArrayList<No> lista = queenBeeAVL.buscarTodosPorNome(nome);

                    if (lista.isEmpty()) {
                        System.out.println("Nenhum funcionário encontrado.");
                    } else {
                        for (No f : lista) {
                            System.out.println(f.toString());
                        }
                    }
                    break;

                case 10:
                    System.out.print("Quantos funcionários deseja listar? ");
                    int nSal = sc.nextInt();
                    sc.nextLine();

                    System.out.println("\n--- Top " + nSal + " salários da QueenBee ---");
                    queenBeeAVL.topNSalarios(nSal);
                    break;

                case 11:
                    System.out.print("\n~~ Programa finalizado ~~\n");
                    continua = false;
                    break;

                default:
                    System.out.print("Digite um valor válido dentre as opções!\n");
                    break;
            }

        } while(continua);

        sc.close();
    }
}

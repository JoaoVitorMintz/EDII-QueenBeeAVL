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

            switch(opcao) {
                case 1:
                    System.out.print("Inserir dados de funcionários na empresa Axion:\n");
                    break;
                case 2:
                    System.out.print("Exibir lista de dados dos funcionários de Axion ordenados pelo Nome Completo\n");
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
                    break;
                case 9:
                    break;
                case 10:
                    break;
                case 11:
                    System.out.print("\n~~Programa finalizado~~\n");
                    continua = false;
                    break;
                default:
                    System.out.print("Digite um valor válido detre as opções!\n")
            }

        } while(continua);
    }
}
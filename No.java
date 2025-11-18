public class No {
    String nome;
    int ID;
    String dataN;
    String dataC;
    String dep;
    String cargo;
    double salario;
    No esq;
    No dir;
    int altura;

    public No(int ID, String nome, String dataN, String dataC, String dep, String cargo, double salario) {
        this.ID = ID;
        this.nome = nome;
        this.dataN = dataN;
        this.dataC = dataC;
        this.dep = dep;
        this.cargo = cargo;
        this.salario = salario;
        this.altura = 0;
        this.esq = null;
        this.dir = null;
    }

    // construtor alternativo usado para Axion (sem ID)
    public No(String nome, String dataN, String dataC, String dep, String cargo, double salario) {
        this.nome = nome;
        this.dataN = dataN;
        this.dataC = dataC;
        this.dep = dep;
        this.cargo = cargo;
        this.salario = salario;
        this.altura = 0;
        this.esq = null;
        this.dir = null;
        this.ID = 0; // ID padrão para Axion
    }

    // Método auxiliar para exibir dados
    @Override
    public String toString() {
        return "Nome: " + nome +
               " | ID: " + ID +
               " | Nascimento: " + dataN +
               " | Contratação: " + dataC +
               " | Departamento: " + dep +
               " | Cargo: " + cargo +
               " | Salário: R$" + salario;
    }
}

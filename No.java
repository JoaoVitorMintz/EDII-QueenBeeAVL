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

    public No (int ID, String nome, String dataN, String dataC, String dep, String cargo, double salario) {
        this.ID = ID;
        this.nome = nome;
        this.dataN = dataN;
        this.dataC = dataC;
        this.dep = dep;
        this.cargo = cargo;
        this.salario = salario;
        altura = 0;
    }
    
}

public class ArvoreAVL {
    public No raiz;

    public void excluirArvore() {
        this.raiz = null;
    }

    public int max(int a, int b) {
        return (a > b) ? a : b;
    }

    // Receber o valor da altura das sub-árvores
    public int getAlturaNo(No no) {
        return (no == null) ? -1 : no.altura;
    }

    public No rotacionarDireita(No no) {
        No aux = no.esq;
        no.esq = aux.dir;
        aux.dir = no;
        no.altura = max(getAlturaNo(no.esq), getAlturaNo(no.dir)) + 1;
        aux.altura = max(getAlturaNo(aux.esq), getAlturaNo(aux.dir)) + 1;
        return aux;
    }

    public No rotacionarEsquerda(No no) {
        No aux = no.dir;
        no.dir = aux.esq;
        aux.esq = no;
        no.altura = max(getAlturaNo(no.esq), getAlturaNo(no.dir)) + 1;
        aux.altura = max(getAlturaNo(aux.esq), getAlturaNo(aux.dir)) + 1;
        return aux;
    }

    public No rotacionarEsquerdaDireita(No no) {
        no.esq = rotacionarEsquerda(no.esq);
        return rotacionarDireita(no);
    }

    public No rotacionarDireitaEsquerda(No no) {
        no.dir = rotacionarDireita(no.dir);
        return rotacionarEsquerda(no);
    }

    // Para proteção dos dados a serem armazenados
    public void inserir(int ID, String nome, String dataN, String dataC, String dep, String cargo, double salario) {
        this.raiz = inserir(this.raiz, ID, nome, dataN, dataC, dep, cargo, salario);
    }

    // Código para armazenar todas as variáveis
    private No inserir(No raiz, int ID, String nome, String dataN, String dataC, String dep, String cargo, double salario) {
        if (raiz == null) {
            // Aqui todas as variáveis estão disponíveis
            return new No(ID, nome, dataN, dataC, dep, cargo, salario);
        }

        // comparação por nome
        if (nome.compareToIgnoreCase(raiz.nome) < 0) {
            raiz.esq = inserir(raiz.esq, ID, nome, dataN, dataC, dep, cargo, salario);

            if (getAlturaNo(raiz.esq) - getAlturaNo(raiz.dir) == 2) {
                if (nome.compareToIgnoreCase(raiz.esq.nome) < 0)
                    raiz = rotacionarDireita(raiz);
                else
                    raiz = rotacionarEsquerdaDireita(raiz);
            }
        } 
        else if (nome.compareToIgnoreCase(raiz.nome) > 0) {
            raiz.dir = inserir(raiz.dir, ID, nome, dataN, dataC, dep, cargo, salario);

            if (getAlturaNo(raiz.dir) - getAlturaNo(raiz.esq) == 2) {
                if (nome.compareToIgnoreCase(raiz.dir.nome) > 0)
                    raiz = rotacionarEsquerda(raiz);
                else
                    raiz = rotacionarDireitaEsquerda(raiz);
            }
        } 
        else {
            // nomes duplicados vão para a direita
            raiz.dir = inserir(raiz.dir, ID, nome, dataN, dataC, dep, cargo, salario);
        }

        raiz.altura = max(getAlturaNo(raiz.esq), getAlturaNo(raiz.dir)) + 1;
        return raiz;
    }

    // Exibir em ordem
    public void exibirEmOrdem() {
        exibirEmOrdem(this.raiz);
        System.out.println();
    }

    private void exibirEmOrdem(No no) {
        if (no != null) {
            exibirEmOrdem(no.esq);
            System.out.println(no.toString());
            exibirEmOrdem(no.dir);
        }
    }
}

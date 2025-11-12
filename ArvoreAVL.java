public class ArvoreAVL {
    public No raiz;

    public void excluirArvore() {
        this.raiz = null;
    }

    // Realizar comparativo entre alturas (verificar necessidade de rotacionar árvore)
    public int max(int altura_no1, int altura_no2) {
        return (altura_no1 > altura_no2) ? altura_no1 : altura_no2;
    }
    
    // Receber o valor da altura das sub-árvores
    public int getAlturaNo(No no) {
        return (no == null) ? -1 : no.altura;
    }

    public No rotacionarDireita(No no) {
        No aux;
        aux = no.esq;
        no.esq = aux.dir;
        aux.dir = no;
        no.altura = this.max(this.getAlturaNo(no.dir), this.getAlturaNo(no.esq)) + 1;
        aux.altura = this.max(this.getAlturaNo(aux.esq), no.altura) + 1;
        return aux;
    }

    public No rotacionarEsquerda(No no) {
        No aux;
        aux = no.dir;
        no.dir = aux.esq;
        aux.esq = no;
        no.altura = this.max(this.getAlturaNo(no.dir), this.getAlturaNo(no.esq))+1;
        aux.altura = this.max(this.getAlturaNo(aux.dir), no.altura)+1;
        return aux;
    }

    public No rotacionarEsquerdaDireita(No no) {
        no.esq = this.rotacionarEsquerda(no.esq);
        return this.rotacionarDireita(no);
    }

    public No rotacionarDireitaEsquerda(No no) {
        no.dir = this.rotacionarDireita(no.dir);
        return this.rotacionarEsquerda(no);
    }

    // Para proteção dos dados a serem armazenados
    public void inserir(int ID, String nome, String dataN, String dataC, String dep, String cargo, double salario) {
        this.raiz = this.inserir(raiz, ID, nome, dataN, dataC, dep, cargo, salario);
    }

    // Desenvolver código para armazenar todas as variáveis
    private No inserir(No raiz, int ID, String nome, String dataN, String dataC, String dep, String cargo, double salario) {
        if(raiz == null) {
            return (new No(ID, nome, dataN, dataC, dep, cargo, salario));
        }
        // if(valor <= raiz.valor) {
        //     raiz.esquerda = inserir(raiz.esquerda, valor);
        //     if((getAlturaNo(raiz.esquerda) - getAlturaNo(raiz.direita)) == 2)
        //         if(valor <= raiz.esquerda.valor)
        //             raiz = rotacionarDireita(raiz);
        //         else
        //             raiz = rotacionarEsquerdaDireita(raiz);
        // }
        // else 
        //     if(valor > raiz.valor) {
        //       raiz.direita = inserir(raiz.direita, valor);
        //       if((getAlturaNo(raiz.direita)-getAlturaNo(raiz.esquerda)) == 2)
        //           if(valor > raiz.direita.valor)
        //               raiz = rotacionarEsquerda(raiz);
        //           else
        //               raiz = rotacionarDireitaEsquerda(raiz);
        //     }
        // raiz.altura = max(getAlturaNo(raiz.esquerda), getAlturaNo(raiz.direita))+1;
        return raiz;
    }

    public void remover(int ID, String nome, String dataN, String dataC, String dep, String cargo, double salario) {
        this.raiz = remover(this.raiz, ID, nome, dataN, dataC, dep, cargo, salario);
    }

    // Desenvolver código para remover todas as variáveis
    private No remover(No no, int ID, String nome, String dataN, String dataC, String dep, String cargo, double salario) {
        if(no == null) {
            return no;
        }

        // if(valor < no.valor) {
        //     no.esquerda = remover(no.esquerda, valor );
        // } else {
        //    if( valor > no.valor ) {
        //         no.direita = remover(no.direita, valor);
        //    } else {
        //         if(no.esquerda != null && no.direita != null ) { // Nó possuio dois filhos 
        //             no = sucessor(no.valor);
        //             no.direita = remover(no.direita, no.valor);
        //         } else {
        //             no = ( no.esquerda != null ) ? no.esquerda : no.direita;
        //         }
        //    }     
        // } 
        return no;
    }

    // TODO: VERIFICAR ESSE CÓDIGO, ESTÁ ERRADO E DEVO CORRIGIR DEPOIS!
    public void buscarLetra(char LETRA) {
        No no = raiz;
        System.out.print("LISTA DE FUNCIONÁRIOS DA QUEENBEE COM A INICIAL INDICADA:\n\n");
        while (no != null) {
            char[] caracteres = no.nome.toCharArray();
            if (caracteres[0] == LETRA) {
                System.out.println("- " + no.nome + "\n");
                no = no.dir;
                no = no.esq;
            }
            no = no.dir;
            no = no.esq;
        }
    }
    
}

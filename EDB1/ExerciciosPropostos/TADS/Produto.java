package TADS;

public class Produto {
    private int id;
    private String nome;
    private double preco;
    private int quantidade;

    public Produto(String nome, double
            preco, int quantidade, int id) {
        this.nome=nome;
        this.preco=preco;
        this.quantidade=quantidade;
        this.id = id;
    }

    public double getPreco(){
        return preco;

    }
    public void reporEstoque(int quantidade){
        if (quantidade > 0){
            this.quantidade+=quantidade;
        }
    }
    public int consultarEstoque(int id){
        return  this.quantidade;
    }

    public void venderProduto(int quantidade) {
        if (quantidade < this.quantidade){
            this.quantidade-=quantidade;
        }
        }
    }
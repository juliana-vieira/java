package gui_grade;

public class Pessoa {
    private String nome;
    private String telefone;
    
    public String obterNome(){
        return nome;
    }
    
    public String obterTelefone(){
        return telefone;
    }
    
    public void atualizarNome(String nome){
        this.nome = nome;
    }
    
    public void atualizarTelefone(String telefone){
        this.telefone = telefone;
    }  
}

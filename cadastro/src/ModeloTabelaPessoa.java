package gui_grade;

import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

public class ModeloTabelaPessoa extends AbstractTableModel {
    private static final int COLUNA_NOME = 0;
    private static final int COLUNA_TELEFONE = 1;
    
    private String colunas[] = new String[]{"Nome", "Telefone"};
    private ArrayList<Pessoa> pessoas;
    
    public ModeloTabelaPessoa(ArrayList<Pessoa> pessoas){
        this.pessoas = new ArrayList<Pessoa>(pessoas);
    }
    
    @Override
    public int getColumnCount(){
        return colunas.length;
    }
    @Override
    public int getRowCount(){
        return pessoas.size();
    }
    @Override
    public String getColumnName(int indiceColuna){
        return colunas[indiceColuna];
    }
    @Override
    public boolean isCellEditable(int indiceLinha, int indiceColuna){
        return false;
    }
    @Override
    public Object getValueAt(int indiceLinha, int indiceColuna){
        Pessoa pessoa = pessoas.get(indiceLinha);
        switch(indiceColuna){
            case COLUNA_NOME:
                    return pessoa.obterNome();
            case COLUNA_TELEFONE:
                    return pessoa.obterTelefone();
        }
        return "";
    }
    @Override
    public void setValueAt(Object valor, int indiceLinha, int indiceColuna){
        Pessoa pessoa = pessoas.get(indiceLinha);
        switch(indiceColuna){
            case COLUNA_NOME:
                pessoa.atualizarNome(valor.toString());
                break;
            case COLUNA_TELEFONE:
                pessoa.atualizarTelefone(valor.toString());
                break;
        }
    }
    
    public Pessoa obterPessoa(int indice){
        return pessoas.get(indice);
    }
    
    public void incluirPessoa(Pessoa pessoa){
        pessoas.add(pessoa);
        int ultimo = getRowCount()-1;
        fireTableRowsInserted(ultimo, ultimo);
    }
    
    public void atualizarPessoa(int indice, Pessoa pessoa){
        pessoas.set(indice, pessoa);
        fireTableRowsUpdated(indice, indice);
    }
    
    public void excluirPessoa(int indice){
        pessoas.remove(indice);
        fireTableRowsDeleted(indice, indice);
    }

}

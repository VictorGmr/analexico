
package analexico;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Stack;
import javafx.print.Collation;
import javax.swing.JOptionPane;





/**
 *
 * @author CCSST
 */
public class Automato {
    
    
    ArrayList<Integer> vertice = new ArrayList<>();
    
    ArrayList<Transicoes> transicao = new ArrayList<>();
    
    private int estado_Final;

    ArrayList<Integer> verticesDe;
    
    ArrayList<Transicoes> transicaoFinal;
    
    static ArrayList<Integer> estFinAfd = new ArrayList<>();
    
    
    public ArrayList<Integer> getEstFinAfd(){
        return estFinAfd;
    }
   
    int get_vertice_cont() {
	return vertice.size();
    }
   
    public void set_vertice(int no_vertice) {
	for(int i = 0; i < no_vertice; i++) {
            vertice.add(i);
	}
    }

    public void imprimir(Automato a){
    
    Transicoes new_trans = null;
   
    
    String texto = "Transições: \n";
    
    verticesDe = new ArrayList<>();
    
            for(int i = 0; i < a.transicao.size(); i++){
                
                new_trans = a.transicao.get(i);
                texto += "q" + new_trans.vertice_de + " --> q" + new_trans.vertice_para + " : simbolo = " + new_trans.simbolo_trans+"\n";
                verticesDe.add(new_trans.vertice_de);
                
            }
            estado_Final = a.getEstado_Final();
            texto += "Estado Final: q" + a.getEstado_Final();
            
            //JOptionPane.showMessageDialog(null,texto);
            
            transicaoFinal = a.transicao;
            
}
  
    void set_transition(int vertice_de, int vertice_para, char simbolo_trans) {
       
        Transicoes nova_trans = new Transicoes();
        nova_trans.vertice_de = vertice_de;
        nova_trans.vertice_para = vertice_para;
        nova_trans.simbolo_trans = simbolo_trans;
        transicao.add(nova_trans);
        
    }
   
    public int getEstado_Final() {
        return estado_Final;
    }

    public void setEstado_Final(int estado) {
        estado_Final = estado;
    }

    

    public Automato concat(Automato a, Automato b) {
	
        Automato result = new Automato();
	result.set_vertice(a.get_vertice_cont() + b.get_vertice_cont());
        
	int i;
	Transicoes new_trans;

	for(i = 0; i < a.transicao.size(); i++) {
		new_trans = a.transicao.get(i);
		result.set_transition(new_trans.vertice_de, new_trans.vertice_para, new_trans.simbolo_trans);
	}

	result.set_transition(a.getEstado_Final(), a.get_vertice_cont(), 'ε');

	for(i = 0; i < b.transicao.size(); i++) {
		new_trans = b.transicao.get(i);
		result.set_transition(new_trans.vertice_de + a.get_vertice_cont(), new_trans.vertice_para + a.get_vertice_cont(), new_trans.simbolo_trans);
	}

	result.setEstado_Final(a.get_vertice_cont() + b.get_vertice_cont() - 1);

	return result;
}


    public Automato kleene(Automato a) {
    
	Automato result = new Automato();
	int i;
	Transicoes new_trans;
	
	result.set_vertice(a.get_vertice_cont() + 2);

	result.set_transition(0, 1, 'ε');

	for(i = 0; i < a.transicao.size(); i++) {
		new_trans = a.transicao.get(i);
		result.set_transition(new_trans.vertice_de + 1, new_trans.vertice_para + 1, new_trans.simbolo_trans);
	}

	result.set_transition(a.get_vertice_cont(), a.get_vertice_cont() + 1, 'ε');
	result.set_transition(a.get_vertice_cont(), 1, 'ε');
	result.set_transition(0, a.get_vertice_cont() + 1, 'ε');

	result.setEstado_Final(a.get_vertice_cont() + 1);

	return result;
}


    public Automato uniao(Automato a, Automato b) {
    
	Automato result = new Automato();
        result.set_vertice(a.get_vertice_cont() + b.get_vertice_cont() + 2);
        int i;
        Transicoes new_trans;
        
        result.set_transition(0, 1, 'ε');

        for(i = 0; i < a.transicao.size(); i++) {
		new_trans = a.transicao.get(i);
		result.set_transition(new_trans.vertice_de + 1, new_trans.vertice_para + 1, new_trans.simbolo_trans);
	}
        
        result.set_transition(0, a.get_vertice_cont() + 1 , 'ε');
        
        for(i = 0; i < b.transicao.size(); i++) {
		new_trans = b.transicao.get(i);
		result.set_transition(new_trans.vertice_de + a.get_vertice_cont() + 1, new_trans.vertice_para + a.get_vertice_cont() + 1, new_trans.simbolo_trans);
	}
        
        result.set_transition(a.get_vertice_cont(), result.get_vertice_cont() - 1, 'ε');
        
        result.set_transition(b.get_vertice_cont() + a.get_vertice_cont(), result.get_vertice_cont() - 1, 'ε');
        
        result.setEstado_Final(a.get_vertice_cont() + b.get_vertice_cont() + 1);
        

	return result;
}


    
    
    
    public boolean isOperador(Character a){
    
        boolean isOperador = false;
        
        if(a == '*' || a == '.' || a == '+' || a == '(' || a == ')')
            isOperador = true;
        
        return isOperador;
        
}
     

    
    
    public void er_para_afn(String re) {
    
        char simbolo;
    
        Stack<Automato> pilha = new Stack<>();
        Automato novo;

        for(int i = 0; i < re.length(); i++){
            simbolo = re.charAt(i);

            if(!isOperador(simbolo)){
                novo = new Automato();
                novo.set_vertice(2);
                novo.set_transition(0, 1, simbolo);
                novo.setEstado_Final(1);
                pilha.push(novo);
            }else{
                Automato op1;
                if(simbolo == '*'){
                    op1 = pilha.pop();
                    pilha.push(kleene(op1));
                }
                else{
                    Automato op2;
                    op2 = pilha.pop();
                    if(pilha.peek() != null){
                        op1 = pilha.pop();
                        if(simbolo == '.'){
                            pilha.push(concat(op1, op2));    
                        }else if(simbolo == '+'){
                            pilha.push(uniao(op1, op2));
                        }
                    }
                }
            }
        }
        
        Automato afn = pilha.pop();
        
        if(pilha.empty()){
            
            imprimir(afn);
        }
        
    
    }
    
    //ArrayList<ArrayList<Integer>> fechoE = new ArrayList<>();
    
    public ArrayList<Integer> unirEstados(ArrayList<Integer> lista1, ArrayList<Integer> lista2){
        
        if(lista1.isEmpty()){
            return lista2;
        }
        if(lista2.isEmpty()){
            return lista1;
        }
        
        
        for(int i = 0; i < lista1.size(); i++){
            
            if(!(lista2.contains(lista1.get(i)))){
                lista2.add(lista1.get(i));
            }
            
            
        }
        
        return lista2;
    }
    
    public boolean contem (ArrayList<ArrayList<Integer>> lista1, ArrayList<Integer> lista2){
        
        for(int i = 0; i < lista1.size(); i++){
            
            Collections.sort(lista1.get(i));
            
        }
        
        Collections.sort(lista2);
        
        if(lista1.contains(lista2)){
            return true;
        }
        
        return false;
        
    }
    
    
    
    public ArrayList fecho(ArrayList<ArrayList<ArrayList<Integer>>> matriz, int estadoAtual, ArrayList estadosVisitados, int colunas){
        
        if(estadosVisitados.contains(estadoAtual)){
            
            return null;
            
        }
        
        if(!(estadosVisitados.isEmpty())){
            
            estadosVisitados.add(estadoAtual);
            
        }
        
        ArrayList<Integer> saida = new ArrayList<>();
        
        saida.add(estadoAtual); 
        
        if(!(matriz.get(estadoAtual).get(colunas - 1).isEmpty())){
            
            for(int i = 0; i < (matriz.get(estadoAtual).get(colunas - 1)).size(); i++){
                
                saida.addAll(fecho(matriz, matriz.get(estadoAtual).get(colunas - 1).get(i), estadosVisitados, colunas));
                
            }
            
        }
        
        return saida;
        
    }
    
    
    public ArrayList afn_para_afd(ArrayList<ArrayList<ArrayList<Integer>>> matriz){
        
        ArrayList<Integer> estadosFecho = new ArrayList<>();
        
        ArrayList<ArrayList<Integer>> estadosVisitados = new ArrayList<>();
        
        ArrayList<ArrayList<ArrayList<Integer>>> matrizAfd = new ArrayList<>();
        
        matrizAfd.add(new ArrayList<>());
        
        for(int j = 0; j < matriz.get(0).size() - 1; j++){
            matrizAfd.get(0).add(new ArrayList<>());
        }
        
        matrizAfd.get(0).get(0).addAll(fecho(matriz, 0, estadosFecho, matriz.get(0).size()));
        
        estadosVisitados.add(matrizAfd.get(0).get(0));
        
        
        int var = 1;
        ArrayList<Integer> save = new ArrayList<>();
        
        for(int i = 0; i < var; i++){
            
            for(int j = 1; j < matriz.get(0).size()-1; j++){
                for(int k = 0; k < matrizAfd.get(i).get(0).size(); k++){
                     
                    for(int l = 0; l < matriz.get(matrizAfd.get(i).get(0).get(k)).get(j).size(); l++){
                        
                        save.clear();
                        
                        
                        
                        for(int p = 0; p < unirEstados(fecho(matriz, matriz.get(matrizAfd.get(i).get(0).get(k)).get(j).get(l), estadosFecho, matriz.get(0).size()), matrizAfd.get(i).get(j)).size(); p++){
                            
                            save.add(unirEstados(fecho(matriz, matriz.get(matrizAfd.get(i).get(0).get(k)).get(j).get(l), estadosFecho, matriz.get(0).size()), matrizAfd.get(i).get(j)).get(p));
                            
                        }
                        
                        matrizAfd.get(i).get(j).clear();
                        matrizAfd.get(i).get(j).addAll(save);
                        
                        estadosFecho.clear();
                        
                    }
                    
                    
                }
                
                //System.out.println("Matriz a ser colocada novo estado" + matrizAfd.get(i).get(j));
                if(!(matrizAfd.get(i).get(j).isEmpty())){
                    //if(!(estadosVisitados.contains(matrizAfd.get(i).get(j)))){
                    if(!(contem(estadosVisitados, matrizAfd.get(i).get(j)))){
                        
                            estadosVisitados.add(matrizAfd.get(i).get(j));
                            matrizAfd.add(new ArrayList<>());
                            matrizAfd.get(matrizAfd.size() - 1).add(matrizAfd.get(i).get(j));
                            for(int x = 0; x < matriz.get(0).size() - 1; x++){
                                matrizAfd.get(matrizAfd.size() - 1).add(new ArrayList<>());
                            }

                            var++;

                    }
                }
                
            }
              
        }
         
        
        for(int i = 0; i < matrizAfd.size(); i++){
        
            if(matrizAfd.get(i).get(0).contains(matriz.size() - 1)){
                estFinAfd.add(i);
            }
            
        }
        
        
        return matrizAfd;
        
        
    }
    
    public void clearEstFinAfd(){
        
        estFinAfd.clear();
        
    }
    
    public ArrayList renomeiaMatriz(ArrayList<ArrayList<ArrayList<Integer>>> matrizAfd){
        
        ArrayList<ArrayList<ArrayList<Integer>>> matrizRenamed = new ArrayList<>();
        
        
        for(int i = 0; i < matrizAfd.size(); i++){
            matrizRenamed.add(new ArrayList<>());
            for(int j = 0; j < matrizAfd.get(0).size(); j++){
                matrizRenamed.get(i).add(new ArrayList<>());
                for(int k = 0; k < matrizAfd.get(i).get(j).size(); k++){
                    
                    matrizRenamed.get(i).get(j).add(matrizAfd.get(i).get(j).get(k));
                    
                }
                
            }
        }
        
        ArrayList<ArrayList<Integer>> estadosVisitados = new ArrayList<>();
        
        ArrayList<Integer> nomes = new ArrayList<>();
        
        int nome = 0;
        
        for(int i = 0; i < matrizAfd.size(); i++){
            for(int j = 0; j < matrizAfd.get(0).size(); j++){
                
                if(!(estadosVisitados.contains(matrizAfd.get(i).get(j)))){
                    if(!(matrizAfd.get(i).get(j).isEmpty())){
                        estadosVisitados.add(matrizAfd.get(i).get(j));
                        nomes.add(nome);
                        nome++;
                    }
                }
                
            }
        }
        
        
        for(int i = 0; i < matrizAfd.size(); i++){
            for(int j = 0; j < matrizAfd.get(0).size(); j++){
                
                if(estadosVisitados.indexOf(matrizAfd.get(i).get(j)) != -1){
                    
                    matrizRenamed.get(i).get(j).clear(); 
                    
                    matrizRenamed.get(i).get(j).add(nomes.get(estadosVisitados.indexOf(matrizAfd.get(i).get(j))));
                    
                }
            }
        }
        
        int primerVazio = 0;
        
        for(int i = 0; i < matrizAfd.size(); i++){
            for(int j = 0; j < matrizAfd.get(0).size(); j++){
                
                if(matrizRenamed.get(i).get(j).isEmpty()){
                    
                    if(primerVazio == 0){
                        matrizRenamed.add(new ArrayList<>());
                        for(int x = 0; x < matrizAfd.get(0).size(); x++){
                            matrizRenamed.get(matrizRenamed.size() - 1).add(new ArrayList<>());
                            matrizRenamed.get(matrizRenamed.size() - 1).get(x).add(nome);
                        }
                    }
                    primerVazio = 1;
                    
                    matrizRenamed.get(i).get(j).add(nome);
                    
                }
            }
        }
        
        
        
        
        
        
        
        return matrizRenamed;
        
    }

}

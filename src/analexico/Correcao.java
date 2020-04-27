
package analexico;

import java.util.ArrayList;


public class Correcao {
    
    public boolean isLetra(char c){
        
        if((c != '+')&&(c != '.')&&(c != '*')&&(c != '(')&&(c != ')')){
                    
            return true;
                    
        }else{
            
            return false;
            
        }
        
    }
    
    public String verificarPontos(String exp){
        
        int x = exp.length();
        
        if(exp.length() > 1){
        for(int i = 0; i < x; i++){
         
            if(i == 0){
                
                if(isLetra(exp.charAt(i))){
                    
                    
                    if(((exp.charAt(i + 1)) == '(') || isLetra(exp.charAt(i + 1))){
                    
                        //add pontos, caso foi: a.(   ou  a.b
                        exp = addPontosDepois(exp, i);
                        x++;
                        
                    
                    }
                    
                    
                }
                
            }else if(i == x - 1){
                
                if(isLetra(exp.charAt(i))){
                    if(((exp.charAt(i - 1)) == ')') || isLetra(exp.charAt(i - 1)) || (exp.charAt(i - 1) == '*')){
                    
                        //add pontos, caso foi: ).a   ou  b.a ou *.a
                        exp = addPontosAntes(exp, i);
                        
                        break;
                    
                    }
                    
                    
                }
                
                
                
            }else{
                
                if(isLetra(exp.charAt(i))){
                    
                    if(((exp.charAt(i + 1)) == '(') || isLetra(exp.charAt(i + 1))){
                    
                        //add pontos, caso foi: a.(   ou  a.b
                        exp = addPontosDepois(exp, i);
                        x++;
                        
                    
                    }
                    
                    
                    if(((exp.charAt(i - 1)) == ')') || isLetra(exp.charAt(i - 1)) || (exp.charAt(i - 1) == '*')){
                    
                        //add pontos, caso foi: ).a   ou  b.a ou *.a
                        exp = addPontosAntes(exp, i);
                        x++;
                        
                    
                    }
                    
                    
                    
                }else if(exp.charAt(i) == ')'){
                    
                    if(((exp.charAt(i + 1)) == '(') || isLetra(exp.charAt(i + 1))){
                    
                        //add pontos, caso foi: a.(   ou  a.b
                        exp = addPontosDepois(exp, i);
                        x++;
                        
                    
                    }
                    
                
                    
                    
                    
                }else if(exp.charAt(i) == '('){
                    
                        if((exp.charAt(i - 1)) == '*'){
                    
                        //add pontos, caso foi: a.(   ou  a.b
                        exp = addPontosAntes(exp, i);
                        x++;
                        
                    
                    }
                        
                    
                }
                
                
                
                
            }
            
            
            
          
            
        }
        
        
        
        
        }
        
        return exp;
    }
    
    public String addPontosAntes(String exp, int i){
       
        exp = new StringBuilder(exp).insert(i, '.').toString();
        
        return exp;
    }
    
    public String addPontosDepois(String exp, int i){
        
        exp = new StringBuilder(exp).insert(i + 1, '.').toString();
        
        return exp;
    }
    
    
    
    public boolean checarBinario(String s){
        
        for(int i = 0; i < s.length(); i++){
            
            if(i == 0){
                if((s.charAt(i) != '+')&&(s.charAt(i) != '.')&&(s.charAt(i) != '*')&&(s.charAt(i) != ')')){
                    
                }else {
                    
                    return false;
                }
                
            }else if(i == s.length() - 1){
                
                if((s.charAt(i) != '+')&&(s.charAt(i) != '.')&&(s.charAt(i) != '(')){
                    
                }else {
                    
                    return false;
                }
                
                
            }else{
                
                if((s.charAt(i) == '+' || s.charAt(i) == '.')){
                    
                    
                    
                        if(((s.charAt(i - 1) != '+')&&(s.charAt(i - 1) != '.')&&(s.charAt(i - 1) != '('))  &&  (s.charAt(i + 1) != '+')&&(s.charAt(i + 1) != '.')&&(s.charAt(i + 1) != '*')&&(s.charAt(i + 1) != ')')){

                            

                        }else{
                            
                            return false;
                        }
                    
                        
                
                    
                    
                }    
                    
                    
            }    
                
                
                
                
            
        }
            return true;
            
            
            
        
    
    
    
    }
        
        
    
    
    }


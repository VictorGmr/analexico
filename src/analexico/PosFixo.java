
package analexico;
import java.util.*;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class PosFixo extends javax.swing.JFrame {

    ArrayList<Character> posfix;
    static ArrayList<Character> alfabeto;
    int iGeral = 0;
    static ArrayList<ArrayList<ArrayList<Integer>>> matriz = new ArrayList<>();
    
    public PosFixo() {
        
        initComponents();
        
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTextField1 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton4 = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jButton5 = new javax.swing.JButton();

        setTitle("Analisador Léxico - VICTOR GUIMARÃES");
        setBackground(new java.awt.Color(255, 255, 255));
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setResizable(false);

        jTextField1.setEditable(false);
        jTextField1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });

        jButton1.setText("Infixa > Posfixa");
        jButton1.setBorderPainted(false);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel2.setText("INFIXA: ");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel3.setText("POSFIXA:");

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel4.setText("ANALISADOR LÉXICO - VICTOR GUIMARÃES 2018");

        jButton3.setText("Exibir AFN-Vazio");
        jButton3.setBorderPainted(false);
        jButton3.setEnabled(false);
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jScrollPane2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jTable1.setAutoCreateRowSorter(true);
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane2.setViewportView(jTable1);

        jButton4.setText("Fechos-ε do AFN-ε");
        jButton4.setBorderPainted(false);
        jButton4.setEnabled(false);
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel5.setText("Autômato: ");

        jButton5.setText("Exibir AFD");
        jButton5.setBorderPainted(false);
        jButton5.setEnabled(false);
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jLabel7)
                        .addGap(26, 26, 26)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(6, 6, 6)
                                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 751, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addGap(6, 6, 6)
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 747, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel5))
                        .addGap(14, 14, 14)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(36, 36, 36)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 968, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jLabel4)))
                .addGap(36, 36, 36))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(11, 11, 11)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(5, 5, 5)
                                        .addComponent(jLabel2))
                                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(22, 22, 22)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(6, 6, 6)
                                        .addComponent(jLabel3))
                                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(34, 34, 34)
                                .addComponent(jLabel5))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jButton1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton3)
                                .addGap(6, 6, 6)
                                .addComponent(jButton4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton5)))))
                .addGap(6, 6, 6)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 91, Short.MAX_VALUE)
                .addComponent(jLabel4)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        
        
        matriz.clear();
        
        jButton3.setEnabled(true);
        jButton4.setEnabled(false);
        jButton5.setEnabled(false);
        
        DefaultTableModel nullModel = new DefaultTableModel();
        
        nullModel.setRowCount(0);
        nullModel.setColumnCount(0);
        
        jTable1.setModel(nullModel);
        
        Stack<Character> s = new Stack<>();
        
        String exp = jTextField1.getText();
        
        String posfixa;
        
        posfix = new ArrayList<>();
        
        int paren = 0;
        
        int i = 0;
        
        
        Correcao c = new Correcao();
        exp = c.verificarPontos(exp);
        
        int expSize = exp.length();
        
        
        if(c.checarBinario(exp)){
        while(i < expSize){    
            
            
            
            if((exp.charAt(i) != '+')&&(exp.charAt(i) != '.')&&(exp.charAt(i) != '*')&&(exp.charAt(i) != '(')&&(exp.charAt(i) != ')')){
                posfix.add(exp.charAt(i));
                        
                
            
                
                
            }else{
                
                if(s.isEmpty() == false){
                       
                    if('+' == s.lastElement()){
                        
                        if(exp.charAt(i) == '+'){
                            
                            posfix.add(s.pop());
                            
                            i--;
                            
                        }else if(exp.charAt(i) == '.'){
                            
                            s.push(exp.charAt(i));
                        }else if(exp.charAt(i) == '*'){
                            s.push(exp.charAt(i));
                        }
                        else if(exp.charAt(i) == '('){
                            
                                s.push(exp.charAt(i));
                                paren++;
                                
                        }else if(exp.charAt(i) == ')'){
                            
                                if(paren == 0){
                                
                                    
                                    JOptionPane.showMessageDialog(null, "ERRO, FECHAMENTO DE PARENTESES QUE NUNCA FORAM ABERTOS");
                                    jLabel1.setText("");
                                    jTextField1.setText("");
                                    break;
                                }else{
                                
                                while(s.lastElement()!='('){
                                    posfix.add(s.pop());
                                    
                                }
                                s.pop();
                                paren--;
                            }
                                
                        }
                        
                    }else if('.' == s.lastElement()){
                        
                        if(exp.charAt(i) == '+'){
                            
                            posfix.add(s.pop());
                           
                            i--;
                            
                           
                        }else if(exp.charAt(i) == '.'){
                            
                            posfix.add(s.pop());
                            
                            i--;
                        
                          
                        }else if(exp.charAt(i) == '*'){
                            
                            s.push(exp.charAt(i));
                        }else if(exp.charAt(i) == '('){
                            
                                s.push(exp.charAt(i));
                                paren++;
                                
                        }else if(exp.charAt(i) == ')'){
                            
                                if(paren == 0){
                                
                                    JOptionPane.showMessageDialog(null, "ERRO, FECHAMENTO DE PARENTESES QUE NUNCA FORAM ABERTOS");
                                    jLabel1.setText("");
                                    jTextField1.setText("");
                                    break;
                                }else{
                                
                                while(s.lastElement()!='('){
                                    posfix.add(s.pop());
                                   
                                }
                                s.pop();
                                paren--;
                            }
                                
                        }
                    }else if('*' == s.lastElement()){
                        if(exp.charAt(i) == '+'){
                            posfix.add(s.pop());
                          
                            i--;
                           
                           
                        }else if(exp.charAt(i) == '.'){
                            posfix.add(s.pop());
                      
                            i--;
                            
                          
                        }else if(exp.charAt(i) == '*'){
                            posfix.add(s.pop());
                        
                            i--;
                           
                          
                        }else if(exp.charAt(i) == '('){
                            
                                s.push(exp.charAt(i));
                                paren++;
                                
                        }else if(exp.charAt(i) == ')'){
                            
                                if(paren == 0){
                                
                                    JOptionPane.showMessageDialog(null, "ERRO, FECHAMENTO DE PARENTESES QUE NUNCA FORAM ABERTOS");
                                    jLabel1.setText("");
                                    jTextField1.setText("");
                                    break;
                                }else{
                                
                                while(s.lastElement()!='('){
                                    posfix.add(s.pop());
                               
                                }
                                s.pop();
                                paren--;
                            }
                                
                        }
                    }else if(('(' == s.lastElement())||(')' == s.lastElement())){
                        if(exp.charAt(i) == '+'){
                            s.push(exp.charAt(i));
                        }else if(exp.charAt(i) == '.'){
                            s.push(exp.charAt(i));
                        }else if(exp.charAt(i) == '*'){
                            s.push(exp.charAt(i));
                        }else if(exp.charAt(i) == '('){
                            
                                s.push(exp.charAt(i));
                                paren++;
                                
                        }else if(exp.charAt(i) == ')'){
                            
                                if(paren == 0){
                                
                                    JOptionPane.showMessageDialog(null, "ERRO, FECHAMENTO DE PARENTESES QUE NUNCA FORAM ABERTOS");
                                    jLabel1.setText("");
                                    jTextField1.setText("");
                                    break;
                                }else{
                                
                                while(s.lastElement()!='('){
                                    posfix.add(s.pop());
                                   
                                }
                                s.pop();
                                paren--;
                            }
                                
                        }
                    }
                    
                    
                    
                    
                }else{
                    
                    
                    
                    if(exp.charAt(i) == ')'){
                            
                                if(paren == 0){
                                
                                    JOptionPane.showMessageDialog(null, "ERRO, FECHAMENTO DE PARENTESES QUE NUNCA FORAM ABERTOS");
                                    jLabel1.setText("");
                                    jTextField1.setText("");
                                    break;
                                }else{
                                
                                while(s.lastElement()!='('){
                                    posfix.add(s.pop());
                                    
                                }
                                s.pop();
                                paren--;
                            }
                                
                        }else{
                            s.push(exp.charAt(i));
                            if(exp.charAt(i) == '('){
                                
                                paren++;
                                
                            }
                        }
                    
                }
                
                
            }
            
            
            
            
            
            i++;
        }
        }else{
            JOptionPane.showMessageDialog(null, "ERRO DE SINTAXE!");
            jTextField1.setText("");
            jLabel1.setText("");
        }
        if(c.checarBinario(exp)){
        if(paren == 0){
            while(s.isEmpty() == false){

                    posfix.add(s.pop());
                    
            }
            
           
            
           
            posfixa = "";
        
            for(int a = 0; a < posfix.size(); a++){
                posfixa = posfixa.concat(String.valueOf(posfix.get(a)));
            
            }
            
            
            
            alfabeto = new ArrayList<>();
            
            
            for(int a = 0; a < posfix.size(); a++){
            
                if(c.isLetra(posfix.get(a))){
                    if(alfabeto.indexOf(posfix.get(a)) == -1){
                        alfabeto.add(posfix.get(a));
                    }
                }
            }
            
            
            alfabeto.add('ε');
            
            jLabel1.setText(posfixa);
            
            
            
            
            
            
            
            
        }else{
            
            if(paren > 0){
                
                JOptionPane.showMessageDialog(null, "ERRO, EXISTEM PARENTESES QUE FORAM ABERTOS E NAO FORAM FECHADOS.");
                jLabel1.setText("");
                jTextField1.setText("");
                
                
            }
                
            
        }
          
        }
        
        
        
    }//GEN-LAST:event_jButton1ActionPerformed

    
    public String infixa_para_posfixa(String infixaEntrada){
        
        matriz.clear();
        
        jButton3.setEnabled(true);
        jButton4.setEnabled(false);
        jButton5.setEnabled(false);
        
        DefaultTableModel nullModel = new DefaultTableModel();
        
        nullModel.setRowCount(0);
        nullModel.setColumnCount(0);
        
        jTable1.setModel(nullModel);
        
        Stack<Character> s = new Stack<>();
        
        String exp = infixaEntrada;
        
        String posfixa = "";
        
        posfix = new ArrayList<>();
        
        int paren = 0;
        
        int i = 0;
        
        
        Correcao c = new Correcao();
        exp = c.verificarPontos(exp);
        
        int expSize = exp.length();
        
        
        if(c.checarBinario(exp)){
        while(i < expSize){    
            
            
            
            if((exp.charAt(i) != '+')&&(exp.charAt(i) != '.')&&(exp.charAt(i) != '*')&&(exp.charAt(i) != '(')&&(exp.charAt(i) != ')')){
                posfix.add(exp.charAt(i));
                        
                
            
                
                
            }else{
                
                if(s.isEmpty() == false){
                       
                    if('+' == s.lastElement()){
                        
                        if(exp.charAt(i) == '+'){
                            
                            posfix.add(s.pop());
                            
                            i--;
                            
                        }else if(exp.charAt(i) == '.'){
                            
                            s.push(exp.charAt(i));
                        }else if(exp.charAt(i) == '*'){
                            s.push(exp.charAt(i));
                        }
                        else if(exp.charAt(i) == '('){
                            
                                s.push(exp.charAt(i));
                                paren++;
                                
                        }else if(exp.charAt(i) == ')'){
                            
                                if(paren == 0){
                                
                                    
                                    JOptionPane.showMessageDialog(null, "ERRO, FECHAMENTO DE PARENTESES QUE NUNCA FORAM ABERTOS");
                                    jLabel1.setText("");
                                    jTextField1.setText("");
                                    break;
                                }else{
                                
                                while(s.lastElement()!='('){
                                    posfix.add(s.pop());
                                    
                                }
                                s.pop();
                                paren--;
                            }
                                
                        }
                        
                    }else if('.' == s.lastElement()){
                        
                        if(exp.charAt(i) == '+'){
                            
                            posfix.add(s.pop());
                           
                            i--;
                            
                           
                        }else if(exp.charAt(i) == '.'){
                            
                            posfix.add(s.pop());
                            
                            i--;
                        
                          
                        }else if(exp.charAt(i) == '*'){
                            
                            s.push(exp.charAt(i));
                        }else if(exp.charAt(i) == '('){
                            
                                s.push(exp.charAt(i));
                                paren++;
                                
                        }else if(exp.charAt(i) == ')'){
                            
                                if(paren == 0){
                                
                                    JOptionPane.showMessageDialog(null, "ERRO, FECHAMENTO DE PARENTESES QUE NUNCA FORAM ABERTOS");
                                    jLabel1.setText("");
                                    jTextField1.setText("");
                                    break;
                                }else{
                                
                                while(s.lastElement()!='('){
                                    posfix.add(s.pop());
                                   
                                }
                                s.pop();
                                paren--;
                            }
                                
                        }
                    }else if('*' == s.lastElement()){
                        if(exp.charAt(i) == '+'){
                            posfix.add(s.pop());
                          
                            i--;
                           
                           
                        }else if(exp.charAt(i) == '.'){
                            posfix.add(s.pop());
                      
                            i--;
                            
                          
                        }else if(exp.charAt(i) == '*'){
                            posfix.add(s.pop());
                        
                            i--;
                           
                          
                        }else if(exp.charAt(i) == '('){
                            
                                s.push(exp.charAt(i));
                                paren++;
                                
                        }else if(exp.charAt(i) == ')'){
                            
                                if(paren == 0){
                                
                                    JOptionPane.showMessageDialog(null, "ERRO, FECHAMENTO DE PARENTESES QUE NUNCA FORAM ABERTOS");
                                    jLabel1.setText("");
                                    jTextField1.setText("");
                                    break;
                                }else{
                                
                                while(s.lastElement()!='('){
                                    posfix.add(s.pop());
                               
                                }
                                s.pop();
                                paren--;
                            }
                                
                        }
                    }else if(('(' == s.lastElement())||(')' == s.lastElement())){
                        if(exp.charAt(i) == '+'){
                            s.push(exp.charAt(i));
                        }else if(exp.charAt(i) == '.'){
                            s.push(exp.charAt(i));
                        }else if(exp.charAt(i) == '*'){
                            s.push(exp.charAt(i));
                        }else if(exp.charAt(i) == '('){
                            
                                s.push(exp.charAt(i));
                                paren++;
                                
                        }else if(exp.charAt(i) == ')'){
                            
                                if(paren == 0){
                                
                                    JOptionPane.showMessageDialog(null, "ERRO, FECHAMENTO DE PARENTESES QUE NUNCA FORAM ABERTOS");
                                    jLabel1.setText("");
                                    jTextField1.setText("");
                                    break;
                                }else{
                                
                                while(s.lastElement()!='('){
                                    posfix.add(s.pop());
                                   
                                }
                                s.pop();
                                paren--;
                            }
                                
                        }
                    }
                    
                    
                    
                    
                }else{
                    
                    
                    
                    if(exp.charAt(i) == ')'){
                            
                                if(paren == 0){
                                
                                    JOptionPane.showMessageDialog(null, "ERRO, FECHAMENTO DE PARENTESES QUE NUNCA FORAM ABERTOS");
                                    jLabel1.setText("");
                                    jTextField1.setText("");
                                    break;
                                }else{
                                
                                while(s.lastElement()!='('){
                                    posfix.add(s.pop());
                                    
                                }
                                s.pop();
                                paren--;
                            }
                                
                        }else{
                            s.push(exp.charAt(i));
                            if(exp.charAt(i) == '('){
                                
                                paren++;
                                
                            }
                        }
                    
                }
                
                
            }
            
            
            
            
            
            i++;
        }
        }else{
            JOptionPane.showMessageDialog(null, "ERRO DE SINTAXE!");
            jTextField1.setText("");
            jLabel1.setText("");
        }
        if(c.checarBinario(exp)){
        if(paren == 0){
            while(s.isEmpty() == false){

                    posfix.add(s.pop());
                    
            }
            
           
            
           
            posfixa = " ";
        
            for(int a = 0; a < posfix.size(); a++){
                posfixa = posfixa.concat(String.valueOf(posfix.get(a)));
            
            }
            
            
            
            alfabeto = new ArrayList<>();
            
            
            for(int a = 0; a < posfix.size(); a++){
            
                if(c.isLetra(posfix.get(a))){
                    if(alfabeto.indexOf(posfix.get(a)) == -1){
                        alfabeto.add(posfix.get(a));
                    }
                }
            }
            
            
            alfabeto.add('ε');
            
            jLabel1.setText(posfixa);
            
            
            return posfixa;
            
            
            
            
            
        }else{
            
            if(paren > 0){
                
                JOptionPane.showMessageDialog(null, "ERRO, EXISTEM PARENTESES QUE FORAM ABERTOS E NAO FORAM FECHADOS.");
                jLabel1.setText("");
                jTextField1.setText("");
                
                
            }
                
            
        }
          
        }
        
        
        return posfixa;
    }
    
    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1ActionPerformed

    public ArrayList criarMatrizAfn(Automato a){
        
        ArrayList<Character> identColuna = new ArrayList<>();
        identColuna.addAll(alfabeto);
        identColuna.add(0, ' ');
        
        
        ArrayList<Integer> linhas = new ArrayList<>();
        
        
        
        for(int i = 0; i < a.verticesDe.size(); i++){
            if(linhas.indexOf(a.verticesDe.get(i)) == -1){
                linhas.add(a.verticesDe.get(i));
            }
        }
        
        linhas.add(a.getEstado_Final());
        
        for(int i = 0; i < linhas.size(); i++){
                matriz.add(new ArrayList<>());
            for(int j = 0; j < identColuna.size(); j++){
                
                matriz.get(i).add(new ArrayList<>());
                
            }
        }
        
        
        
        
        for(int i = 0; i < a.transicaoFinal.size(); i++){
            for(int j = 0; j < identColuna.size(); j++){
                
                if(a.transicaoFinal.get(i).simbolo_trans == identColuna.get(j)){
                    
                        matriz.get(a.transicaoFinal.get(i).vertice_de).get(j).add(a.transicaoFinal.get(i).vertice_para);
                        
                }
                
            }
            
            
        }
        
        
        for(int i = 0; i < matriz.size(); i++){
            
            matriz.get(i).get(0).add(i);
            
        }
        
        return matriz;
    }
    
    public void setarTextos(String inf){
        jTextField1.setText(inf);
    }
    
    public static void gerarTabela(Automato a, JTable jTable1){
        
        ArrayList<Character> identColuna = new ArrayList<>();
        identColuna.addAll(alfabeto);
        identColuna.add(0, ' ');
        
        
        
        ArrayList<Integer> linhas = new ArrayList<>();
        
        
        for(int i = 0; i < a.verticesDe.size(); i++){
            if(linhas.indexOf(a.verticesDe.get(i)) == -1){
                linhas.add(a.verticesDe.get(i));
            }
        }
        
        linhas.add(a.getEstado_Final());
        
        for(int i = 0; i < linhas.size(); i++){
                matriz.add(new ArrayList<>());
            for(int j = 0; j < identColuna.size(); j++){
                
                matriz.get(i).add(new ArrayList<>());
                
            }
        }
        
        
        
        
        for(int i = 0; i < a.transicaoFinal.size(); i++){
            for(int j = 0; j < identColuna.size(); j++){
                
                if(a.transicaoFinal.get(i).simbolo_trans == identColuna.get(j)){
                    
                        matriz.get(a.transicaoFinal.get(i).vertice_de).get(j).add(a.transicaoFinal.get(i).vertice_para);
                        
                }
                
            }
            
            
        }
        
        
        DefaultTableModel model = new DefaultTableModel();
        
        model.setColumnIdentifiers(identColuna.toArray());
        model.setRowCount(linhas.size());
        
        for(int i = 0; i < matriz.size(); i++){
            
            matriz.get(i).get(0).add(i);
            
        }
        
        for(int i = 0; i < linhas.size(); i++){
            for(int j = 0; j < identColuna.size(); j++){
                
                if(!(matriz.get(i).get(j).isEmpty()))
                    model.setValueAt(matriz.get(i).get(j), i, j);
                
            }
        }
        
        
        
        for(int i = 0; i < linhas.size(); i++){
            
            
            
            
            if(i == a.getEstado_Final()){
                model.setValueAt("*q" + i, i, 0);
            }else{
                
                if(i == 0){
                    model.setValueAt("->q" + i, i, 0);
                }else{
                    model.setValueAt("q" + i, i, 0);
                }
            }
        }
        
        jTable1.setModel(model);
        
    }
    
    public ArrayList criarMatrizAfd(ArrayList<ArrayList<ArrayList<Integer>>> matriz){
        
        Automato a = new Automato();
        
        
        
        alfabeto.remove(alfabeto.size() - 1);
        alfabeto.add(0, ' ');
        
        
        
        for(int i = 0; i < matriz.size(); i++){
            for(int j = 0; j < alfabeto.size(); j++){
                
                
                if((a.getEstFinAfd().contains(i)) && (j == 0)){
                    
                    if((i == 0) && (j == 0)){
                        if(!(matriz.get(i).get(j).isEmpty()))
                            matriz.get(i).get(j).add(-1); // Indica que é final
                    
                    }else{
                        if(!(matriz.get(i).get(j).isEmpty()))
                            matriz.get(i).get(j).add(-1);
                    }
                }else{
                    if((i == 0) && (j == 0)){
                        if(!(matriz.get(i).get(j).isEmpty())){
                            //estado Inicial
                        }
                    
                    }else{
                        if(!(matriz.get(i).get(j).isEmpty())){
                            //estado comum
                        }
                    }
                }
                
                
                
                
            }
        }
        
        a.clearEstFinAfd();
        
        alfabeto.remove(0);
        alfabeto.add('ε');
        
        
        return matriz;
        
    }
    
    public void gerarTabela(ArrayList<ArrayList<ArrayList<Integer>>> matriz, JTable jTable1){
        
        Automato a = new Automato();
        
        DefaultTableModel model = new DefaultTableModel();
        
        
        alfabeto.remove(alfabeto.size() - 1);
        alfabeto.add(0, ' ');
        
        
        model.setColumnIdentifiers(alfabeto.toArray());
        model.setRowCount(matriz.size());
        
        
        for(int i = 0; i < matriz.size(); i++){
            for(int j = 0; j < alfabeto.size(); j++){
                
                
                if((a.getEstFinAfd().contains(i)) && (j == 0)){
                    
                    if((i == 0) && (j == 0)){
                        if(!(matriz.get(i).get(j).isEmpty()))
                            model.setValueAt("->*q" + matriz.get(i).get(j).get(0), i, j);
                    
                    }else{
                        if(!(matriz.get(i).get(j).isEmpty()))
                            model.setValueAt("*q" + matriz.get(i).get(j).get(0), i, j);
                    }
                }else{
                    if((i == 0) && (j == 0)){
                        if(!(matriz.get(i).get(j).isEmpty()))
                            model.setValueAt("->q" + matriz.get(i).get(j).get(0), i, j);
                    
                    }else{
                        if(!(matriz.get(i).get(j).isEmpty()))
                            model.setValueAt("q" + matriz.get(i).get(j).get(0), i, j);
                    }
                }
                
                
                
                
            }
        }
        
        jTable1.setModel(model);
        
        a.clearEstFinAfd();
        
        alfabeto.remove(0);
        alfabeto.add('ε');
        
    }
    
    
    
    
    
    
    
    
    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        
        
        jButton3.setEnabled(false);
        jButton4.setEnabled(true);
        jButton5.setEnabled(true);
        
        Automato a = new Automato(); 
        
        String posfixa = "";
        
        for(int i = 0; i < posfix.size(); i++){
            posfixa = posfixa.concat(String.valueOf(posfix.get(i)));
            
        }
        
        a.er_para_afn(posfixa);
        
        gerarTabela(a, jTable1);
        
        
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
    
        
        
        ArrayList<Integer> estadosVisitados = new ArrayList<>();
        
        Automato a = new Automato();
        
        for(int i = 0; i < matriz.size(); i++){
            
            JOptionPane.showMessageDialog(null, "Fecho-ε(" + i + ") = " + a.fecho(matriz, i, estadosVisitados, matriz.get(0).size()));
            
        }
        
        
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        
        jButton5.setEnabled(false);
        
        Automato a = new Automato();
        
        
        gerarTabela(a.renomeiaMatriz(a.afn_para_afd(matriz)), jTable1);
        //gerarTabela(a.afn_para_afd(matriz), jTable1);
    }//GEN-LAST:event_jButton5ActionPerformed

    /**
     * @param args the command line arguments
     */
   

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables
}

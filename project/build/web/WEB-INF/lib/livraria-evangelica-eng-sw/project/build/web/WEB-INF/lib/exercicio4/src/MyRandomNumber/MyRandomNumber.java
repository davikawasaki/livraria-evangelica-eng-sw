/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MyRandomNumber;

/**
 *
 * @author eryc
 */
public class MyRandomNumber {
    Random random = new Random();
    int anteior = -1;
    
    public int nextRandomNumber(int begin, int end) throws IntervaloInvalidoException{
        verificaExcecoes(begin, end);
        int atual = gerarEntre(end, begin);
        if(atual == anterior){
            atual++;
            if(atual > end){
                atual = begin;
            }
        }
        anterior = atual;
        return atual;
    }
    
    public int gerarEntre(int end, int begin){
        int diff = end - begin +1;
        int ret = begin + random.nextInt(diff);
        return ret;
    }
    
    private void verificarExcecoes( int begin, int end) throws IntervaloInvalidoException {
        if(begin < 0 || end <0){
            throw new IntervaloInvalidoException("begin eh menor que zero");
        }
        
        if(begin >= end){
            throw new IntervaloInvalidoException("begin eh menor que zero");
        }
    } 
    
}

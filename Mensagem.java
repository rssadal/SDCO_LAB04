/**
  * Laboratorio 4  
  * Autores: Vítor Augusto Ozanick e Adalberto Teixeira Guedes
  * Ultima atualizacao: 10/10/2023
 */

import java.io.Serializable;

public class Mensagem implements Serializable {
    
	String mensagem;
	
	//Cliente -> Servidor
    public Mensagem(String mensagem, String opcao){    	
                
        setMensagem(mensagem,opcao);
        
    }
    //Servidor -> Cliente
    public Mensagem(String mensagem){
    	this.mensagem = new String(mensagem);
    }
    public String getMensagem(){
    	return this.mensagem;
    }
    public void setMensagem(String fortune, String opcao){
    	String mensagem="";
    	
    	switch(opcao){
    	case "1": {
        		
    		mensagem += "LEITURA JSON NAO PRONTA";

			break;
		}
    	case "2": {
    		                		
        		mensagem +="ESCRITA JSON NAO PRONTA";    
    			break;
    		}
    	}//fim switch
    	this.mensagem = mensagem;
    }
    
}

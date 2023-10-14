/**
  * Laboratorio 4  
  * Autores: Vítor Augusto Ozanick e Adalberto Teixeira Guedes
  * Ultima atualizacao: 10/10/2023
 */
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.*;
import java.util.List;
import java.util.Scanner;


public class ClienteRMI {
	
	public static void read (IMensagem meio_envio) {
		try {
			Mensagem resposta = meio_envio.enviar(new Mensagem("", "1"));
			System.out.println(resposta.getMensagem());
		} 
		catch (RemoteException e) {
            e.printStackTrace();
        }
	}
	
	public static void write (IMensagem meio_envio, String fortune) {
        try {
            Mensagem resposta = meio_envio.enviar(new Mensagem(fortune, "2"));
            System.out.println(resposta.getMensagem());
        } catch (RemoteException e) {
            e.printStackTrace();
        }
	}
	
    public static void main(String[] args) {
                
    	//TODO: Obter a Lista de pares disponiveis do arquivo Peer.java
    	List<Peer> listaPeers = new ArrayList<Peer>(EnumSet.allOf(Peer.class));

		System.out.println(listaPeers.get(0));
		
        try {
                        
            Registry registro = LocateRegistry.getRegistry("127.0.0.1", 1099);
            
        	//Escolhe um peer aleatorio da lista de peers para conectar
            SecureRandom sr = new SecureRandom();
    		
            IMensagem stub = null;
            Peer peer = null;
            
    		boolean conectou=false;
    		while(!conectou){
    			peer = listaPeers.get(sr.nextInt(listaPeers.size()));
    			try{    				
    				stub = (IMensagem) registro.lookup(peer.getNome());
    				conectou=true;
    			} catch(java.rmi.ConnectException e){
    				System.out.println(peer.getNome() + " indisponivel. ConnectException. Tentanto o proximo...");
    			} catch(java.rmi.NotBoundException e){
    				System.out.println(peer.getNome() + " indisponivel. NotBoundException. Tentanto o proximo...");
    			}
    		}
            System.out.println("Conectado no peer: " + peer.getNome());            
    		               		
            String opcao="";
            Scanner leitura = new Scanner(System.in);
            do {
            	System.out.println("1) Read");
            	System.out.println("2) Write");
            	System.out.println("x) Exit");
            	System.out.print(">> ");
            	opcao = leitura.next();
            	switch(opcao){
	            	case "1": {
	            		read(stub);
	            		break;
	            	}
	            	case "2": {
	            		System.out.print("Add fortune: ");
	            		String fortune = leitura.next();
	            		
	            		write(stub, fortune);
	            		break;
	            	}
            	}
            } while(!opcao.equals("x"));
            leitura.close();        
        } catch(Exception e) {
            e.printStackTrace();
        }
        
    }
    
}

/**
  * Laboratorio 4  
  * Autores: Vítor Augusto Ozanick e Adalberto Teixeira Guedes
  * Ultima atualizacao: 10/10/2023
 */
import java.rmi.Remote;
import java.rmi.RemoteException;


public interface IMensagem extends Remote {
    
    public Mensagem enviar(Mensagem mensagem) throws RemoteException;
    
}

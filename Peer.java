/**
  * Laboratorio 4  
  * Autores: Vítor Augusto Ozanick e Adalberto Teixeira Guedes
  * Ultima atualizacao: 10/10/2023
 */
public enum Peer {
    
    PEER1 {
        @Override
        public String getNome() {
            return "PEER1";
        }        
    },
    PEER2 {
        public String getNome() {
            return "PEER2";
        }        
    },
    PEER3 {
        public String getNome() {
            return "PEER3";
        }        
    };
    public String getNome(){
        return "NULO";
    }    
}

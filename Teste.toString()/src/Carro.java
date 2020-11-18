public class Carro{
        
        //Atributos
        boolean porta;
        boolean roda;
        boolean vidro;
        float velocidade;
        
        //Métodos
        public void acelera(int num){
            velocidade += num;
        }
        
        public void freia(int num){
            velocidade -= num;
        }
        
        public void buzina(){
            System.out.println("Beep Beep");
        }
        
        public Carro(){
            porta = true;
            roda = true;
            vidro = true;
            velocidade = 0;
        }
        
    
    public static void main(String[] args) {
        Carro etios = new Carro();
        Carro fusion = new Carro();
        
        System.out.println(etios.velocidade);
        
        etios.acelera(50);
        
        System.out.println(fusion.velocidade);
    }
    
}
public class Avion extends Thread{
    String nom;
    Aeroport a;
    public Avion(String s)
    {
        nom=s;
    }
    public void run()
    {
        a=Aeroport.getInstance(true);
        System.out.println("Je suis avion "+nom+" sur aeroport "+a);
    }
}

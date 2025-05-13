public class Aeroport {
    private static Aeroport instance;
    boolean piste_libre;
    private Aeroport(boolean value)
    {
        piste_libre=value;
    }
    public static Aeroport getInstance(boolean value)
    {
        if (instance == null) {
            instance = new Aeroport(value);
        }
        return instance;
    }
}

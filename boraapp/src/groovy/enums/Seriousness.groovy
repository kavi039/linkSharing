package enums

/**
 * Created by kavita on 16/2/15.
 */
public enum Seriousness {
   SERIOUS("serious"),
    VERYSERIOUS("veryserious"),
    CASUAL("casual")
    String id;
    Seriousness(String id)
    {
        this.id=id;
    }
}
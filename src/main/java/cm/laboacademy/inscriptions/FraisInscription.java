package cm.laboacademy.inscriptions;

/**
 * Calcule les frais d'inscription d'un étudiant (en FCFA).
 *
 * Règles métier :
 *  - L1, L2, L3 : 50 000 FCFA ;
 *  - M1, M2     : 75 000 FCFA ;
 *  - un boursier paie la moitié ;
 *  - tout autre niveau lève une IllegalArgumentException.
 */
public class FraisInscription {

    static final int FRAIS_LICENCE = 50_000;
    static final int FRAIS_MASTER = 75_000;

    public int calculer(String niveau, boolean boursier) {
        if (niveau == null) {
            throw new IllegalArgumentException("Le niveau est obligatoire");
        }
        int base = switch (niveau) {
            case "L1", "L2", "L3" -> FRAIS_LICENCE;
            case "M1", "M2" -> FRAIS_MASTER;
            default -> throw new IllegalArgumentException("Niveau inconnu : " + niveau);
        };
        return boursier ? base / 2 : base;
    }
}

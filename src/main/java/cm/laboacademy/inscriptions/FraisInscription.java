package cm.laboacademy.inscriptions;

import java.time.LocalDate;

/**
 * Calcule les frais d'inscription d'un étudiant (en FCFA).
 *
 * Règles métier :
 *  - L1, L2, L3 : 50 000 FCFA ;
 *  - M1, M2     : 75 000 FCFA ;
 *  - un boursier paie la moitié ;
 *  - tout autre niveau lève une IllegalArgumentException ;
 *  - 10 % de réduction si l'inscription a lieu au plus tard à la date limite.
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

    /**
     * Variante avec réduction de 10 % pour une inscription anticipée
     * (dateInscription <= dateLimite). Le résultat est un entier en FCFA.
     */
    public int calculer(String niveau, boolean boursier, LocalDate dateInscription, LocalDate dateLimite) {
        if (dateInscription == null || dateLimite == null) {
            throw new IllegalArgumentException("Les dates d'inscription et limite sont obligatoires");
        }
        int montant = calculer(niveau, boursier);
        return dateInscription.isAfter(dateLimite) ? montant : montant * 90 / 100;
    }
}

package cm.laboacademy.inscriptions;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import static org.junit.jupiter.api.Assertions.*;

class FraisInscriptionTest {

    private final FraisInscription frais = new FraisInscription();

    @Test
    void licenceNonBoursier() {
        assertEquals(50000, frais.calculer("L2", false));
    }

    @Test
    void masterNonBoursier() {
        assertEquals(75000, frais.calculer("M1", false));
    }

    @Test
    void boursierPayeLaMoitie() {
        assertEquals(25000, frais.calculer("L1", true));
    }

    @Test
    void niveauInconnuLeveUneException() {
        assertThrows(IllegalArgumentException.class,
                () -> frais.calculer("X9", false));
    }

    // --- Extension : 10 % de réduction pour une inscription avant la date limite ---

    private static final LocalDate LIMITE = LocalDate.of(2026, 10, 31);

    @Test
    void reductionDixPourCentAvantLaDateLimite() {
        assertEquals(45000, frais.calculer("L2", false, LocalDate.of(2026, 10, 15), LIMITE));
    }

    @Test
    void reductionApplicableLeJourMemeDeLaDateLimite() {
        assertEquals(67500, frais.calculer("M1", false, LIMITE, LIMITE));
    }

    @Test
    void pasDeReductionApresLaDateLimite() {
        assertEquals(50000, frais.calculer("L2", false, LocalDate.of(2026, 11, 1), LIMITE));
    }

    @Test
    void reductionCumuleeAvecLaBourse() {
        assertEquals(22500, frais.calculer("L1", true, LocalDate.of(2026, 10, 1), LIMITE));
    }

    @Test
    void datesObligatoires() {
        assertThrows(IllegalArgumentException.class,
                () -> frais.calculer("L1", false, null, LIMITE));
    }
}

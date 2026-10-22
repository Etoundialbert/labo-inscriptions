# Labo Academy Inscriptions

Fil rouge du cours **Initiation au CI/CD** (Automatisation et usine logicielle).
API Java / Spring Boot qui calcule les frais d'inscription des étudiants.

## Prérequis
JDK 17+, Maven 3.9+, Git.

## Commandes
```bash
mvn clean test       # compile et lance les tests
mvn clean package    # compile, teste, produit target/labo-inscriptions-0.0.1-SNAPSHOT.jar
```

## Règles métier
| Niveau | Frais de base (FCFA) |
|--------|----------------------|
| L1, L2, L3 | 50 000 |
| M1, M2 | 75 000 |

- Un étudiant boursier paie la moitié.
- Tout autre niveau lève une `IllegalArgumentException`.
- Extension : 10 % de réduction pour une inscription effectuée au plus tard à la date limite.

## Workflow Git
GitHub Flow : `main` protégée, une branche par fonctionnalité (`feature/...`), Pull Request relue puis fusionnée.
Messages de commit au format Conventional Commits (`feat:`, `fix:`, `test:`, `docs:`, `chore:`).

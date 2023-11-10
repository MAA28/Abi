# Ein Café
## Simpleste Lösung
$S \rightarrow kP$
$P \rightarrow \{kP | mP | zP | \epsilon\}$
# Vollständigere Lösung
$S \rightarrow kP$
$P \rightarrow \{kP | mP | zP | \epsilon\}$


# Mehrere Cafés
$S_1 \rightarrow (K_1$
$K_1 \rightarrow kP_1$
$P_1 \rightarrow \{kP_1|mP_1|zP_1|kE_1|mE_1|zE_1\}$
$E_1 \rightarrow \{)S_2|)\epsilon\}$
$S_2\rightarrow (K_2$
$K_2\rightarrow kP_2$
$P_2 \rightarrow \{kP_2|mP_2|zP_2|kE_2|mE_2|zE_2\}$
$E_2 \rightarrow \{S_1|)\epsilon\}$
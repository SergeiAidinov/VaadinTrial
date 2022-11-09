package ru.yandex.incoming34.VaadinTrial.ui;

import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class FrenchLettersUtils {

    private static final Character _A_ACCENT_GRAVE = 'à';
    private static final Character _E_ACCENT_GRAVE = 'è';
    private static final Character _U_ACCENT_GRAVE = 'ù';
    private static final Character _A_ACCENT_CIRCONFLEXE = 'â';
    private static final Character _E_ACCENT_CIRCONFLEXE = 'ê';
    private static final Character _I_ACCENT_CIRCONFLEXE = 'î';
    private static final Character _O_ACCENT_CIRCONFLEXE = 'ô';
    private static final Character _U_ACCENT_CIRCONFLEXE = 'û';
    private static final Character _CEDILLE = 'ç';
    private static final Character _E_TREMA = 'ë';
    private static final Character _I_TREMA = 'ï';
    private static final Character _U_TREMA = 'ü';
    private static final Character _Y_TREMA = 'ÿ';
    private static final Character _AE_LIGATURA = 'æ';
    private static final Character _OE_LIGATURA = 'œ';

    public enum Letters {

        A_ACCENT_GRAVE(_A_ACCENT_GRAVE),
        E_ACCENT_GRAVE(_E_ACCENT_GRAVE),
        U_ACCENT_GRAVE(_U_ACCENT_GRAVE),
        A_ACCENT_CIRCONFLEXE(_A_ACCENT_CIRCONFLEXE),
        E_ACCENT_CIRCONFLEXE(_E_ACCENT_CIRCONFLEXE),
        I_ACCENT_CIRCONFLEXE(_I_ACCENT_CIRCONFLEXE),
        O_ACCENT_CIRCONFLEXE(_O_ACCENT_CIRCONFLEXE),
        U_ACCENT_CIRCONFLEXE(_U_ACCENT_CIRCONFLEXE),
        CEDILLE(_CEDILLE),
        E_TREMA(_E_TREMA),
        I_TREMA(_I_TREMA),
        U_TREMA(_U_TREMA),
        Y_TREMA(_Y_TREMA),
        AE_LIGATURA(_AE_LIGATURA),
        OE_LIGATURA(_OE_LIGATURA);

        public final Character symbol;

        Letters(Character symbol) {
            this.symbol = symbol;
        }

        public Character getSymbol() {
            return symbol;
        }

    };

    public List<Letters> getAllLetters() {
        return Arrays.stream(Letters.values()).collect(Collectors.toList());

    }

}

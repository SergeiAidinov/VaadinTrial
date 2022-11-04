package ru.yandex.incoming34.VaadinTrial.ui;

import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class FrenchLettersUtils {

    enum letters {
        A_ACCENT_GRAVE,
        E_ACCENT_GRAVE,
        U_ACCENT_GRAVE,
        A_ACCENT_CIRCONFLEXE,
        E_ACCENT_CIRCONFLEXE,
        I_ACCENT_CIRCONFLEXE,
        O_ACCENT_CIRCONFLEXE,
        U_ACCENT_CIRCONFLEXE,
        CEDILLE,
        E_TREMA,
        I_TREMA,
        U_TREMA,
        Y_TREMA,
        AE_LIGATURA,
        OE_LIGATURA

    };
    
    public List<letters> getAllLetters(){
        return Arrays.stream(letters.values()).collect(Collectors.toList());
        
    }
    
    
    public String getSymbol(letters letter) {
        switch (letter) {
            case A_ACCENT_GRAVE :
                return "à";
            case E_ACCENT_GRAVE :
                return "è";
            case U_ACCENT_GRAVE :
                return "ù";
            case A_ACCENT_CIRCONFLEXE :
                return "â";
            case E_ACCENT_CIRCONFLEXE :
                return "ê";
            case I_ACCENT_CIRCONFLEXE :
                return "î";
            case O_ACCENT_CIRCONFLEXE :
                return "ô";
            case U_ACCENT_CIRCONFLEXE :
                return "û";
            case CEDILLE :
                return "ç";
            case E_TREMA :
                return "ë";
            case I_TREMA :
                return "ï";
            case U_TREMA :
                return "ü";
            case Y_TREMA :
                return "ÿ";
            case AE_LIGATURA :
                return "æ";
            case OE_LIGATURA :
                return "œ";
            default:
                throw new IllegalArgumentException(String.valueOf(letter));
        }


    }
}

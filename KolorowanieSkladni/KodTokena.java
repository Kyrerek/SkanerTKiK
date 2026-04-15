package KolorowanieSkladni;

import java.awt.*;

public enum KodTokena {
    NUM(new Color(9, 134, 88)),
    STR(new Color(163, 21, 21)),
    BOOL(new Color(0, 0, 255)),
    ID(new Color(38, 127, 153)),
    PLUS(Color.BLACK),
    MINUS(Color.BLACK),
    MULT(Color.BLACK),
    DIV(Color.BLACK),
    LBRACKET(Color.BLACK),
    RBRACKET(Color.BLACK),
    ASSIGN(Color.BLACK),
    VAR(new Color(0, 0, 255)),
    EQUAL(Color.BLACK),
    LESS(Color.BLACK),
    GREATER(Color.BLACK),
    ELESS(Color.BLACK),
    EGREATER(Color.BLACK),
    NEQUAL(Color.BLACK),
    FOR(new Color(175, 0, 219)),
    IF(new Color(175, 0, 219)),
    ELSE(new Color(175, 0, 219)),
    INC(new Color(175, 0, 219)),
    PRINT(new Color(175, 0, 219)),
    ERR(new Color(255, 0, 0)),
    EOF(Color.GRAY);

    public final Color color;

    KodTokena(Color color) {
        this.color = color;
    }
}
import java.util.function.Predicate;

enum KodTokena {
    NUM(Character::isDigit),
    ID(Character::isLetter),
    PLUS(c -> c == '+'),
    MINUS(c -> c == '-'),
    MULT(c -> c == '*'),
    DIV(c -> c == '/'),
    LBRACKET(c -> c == '('),
    RBRACKET(c -> c == ')'),
    EOF(c -> c == '\n'),
    ERR(c -> false);

    private final Predicate<Character> matcher;

    KodTokena(Predicate<Character> matcher) {
        this.matcher = matcher;
    }

    public boolean matches(char c) {
        return matcher.test(c);
    }

    public static KodTokena fromChar(char c) {
        for (KodTokena token : values()) {
            if (token.matches(c)) {
                return token;
            }
        }
        return ERR;
    }
}
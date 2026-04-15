package KolorowanieSkladni;

public class Skaner {
//    enum KodTokena {
//        NUM, STR, BOOL, ID, PLUS, MINUS, MULT, DIV, LBRACKET, RBRACKET, ASSIGN, VAR, EQUAL, LESS, GREATER, ELESS, EGREATER, NEQUAL, FOR, IF, ELSE, ERR, EOF
//    }

    private String ciag;
    private int i;

    public void init(String ciag) {
        this.ciag = ciag;
        this.i = 0;
    }

    public boolean hasNext() {
        return i < ciag.length();
    }

    public Token skaner() {
        StringBuilder kodBuilder = new StringBuilder();
        kodBuilder.append(ciag.charAt(i));

        KodTokena kodTokena = switch (ciag.charAt(i)){
            case '+' -> {
                i++;
                yield KodTokena.PLUS;
            }
            case '-' -> {
                i++;
                yield KodTokena.MINUS;
            }
            case '*' -> {
                i++;
                yield KodTokena.MULT;
            }
            case '/' -> {
                i++;
                yield KodTokena.DIV;
            }
            case '(' -> {
                i++;
                yield KodTokena.LBRACKET;
            }
            case ')' -> {
                i++;
                yield KodTokena.RBRACKET;
            }
            default -> {
                if (Character.isLetter(ciag.charAt(i))) {
                    pullIds(kodBuilder);
                    i++;
                    yield KodTokena.ID;
                }

                if (Character.isDigit(ciag.charAt(i))) {
                    pullNums(kodBuilder);
                    i++;
                    yield KodTokena.NUM;
                }

                kodBuilder.append(", na pozycji ").append(i);
                yield KodTokena.ERR;
            }
        };
//        System.out.println(kodTokena + ": " + kodBuilder);
        return new Token(kodTokena, kodBuilder.toString());
    }

    private void pullNums(StringBuilder kodBuilder) {
        i++;
        while (i < ciag.length() && Character.isDigit(ciag.charAt(i))) {
            kodBuilder.append(ciag.charAt(i++));
        }
    }

    private void pullIds(StringBuilder kodBuilder) {
        i++;
        while (i < ciag.length() && (Character.isLetter(ciag.charAt(i)) || Character.isDigit(ciag.charAt(i)))) {
            kodBuilder.append(ciag.charAt(i++));
        }
    }

}
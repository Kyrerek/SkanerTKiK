package Scanner;

public class Skaner {
    enum KodTokena {
        NUM, ID, PLUS, MINUS, MULT, DIV, LBRACKET, RBRACKET, ERR, EOF
    }

    public int skaner(String ciag, int i) {
        StringBuilder kodBuilder = new StringBuilder();
        kodBuilder.append(ciag.charAt(i));

        KodTokena kodTokena = switch (ciag.charAt(i)){
            case '+' -> KodTokena.PLUS;
            case '-' -> KodTokena.MINUS;
            case '*' -> KodTokena.MULT;
            case '/' -> KodTokena.DIV;
            case '(' -> KodTokena.LBRACKET;
            case ')' -> KodTokena.RBRACKET;
            default -> {
                if (Character.isLetter(ciag.charAt(i))) {
                    i = pullIds(ciag,i,kodBuilder);
                    yield KodTokena.ID;
                }

                if (Character.isDigit(ciag.charAt(i))) {
                    i = pullNums(ciag,i,kodBuilder);
                    yield KodTokena.NUM;
                }

                kodBuilder.append(", na pozycji ").append(i);
                yield KodTokena.ERR;
            }
        };
        System.out.println(kodTokena + ": " + kodBuilder);
        return ++i;
    }

    private int pullNums(String ciag, int i, StringBuilder kodBuilder) {
        i++;
        while (i < ciag.length()) {
            if (Character.isDigit(ciag.charAt(i))) {
                kodBuilder.append(ciag.charAt(i));
                i++;
            } else {
                i--;
                break;
            }
        }
        return i;
    }

    private int pullIds(String ciag, int i, StringBuilder kodBuilder) {
        i++;
        while (i < ciag.length()) {
            if (Character.isLetter(ciag.charAt(i)) || Character.isDigit(ciag.charAt(i))) {
                kodBuilder.append(ciag.charAt(i));
                i++;
            } else {
                i--;
                break;
            }
        }
        return i;
    }

}
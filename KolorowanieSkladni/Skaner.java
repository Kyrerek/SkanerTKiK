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

        KodTokena kodTokena = switch (ciag.charAt(i)) {
            case '+' -> {
                i++;
                if (i < ciag.length() && ciag.charAt(i) == '+') {
                    kodBuilder.append('+');
                    i++;
                    yield KodTokena.INC;
                }
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
            case '=' -> {
                i++;
                if (i < ciag.length() && ciag.charAt(i) == '=') {
                    kodBuilder.append('=');
                    i++;
                    yield KodTokena.EQUAL;
                }
                yield KodTokena.ASSIGN;
            }
            case '\"' ->{
                pullStrings(kodBuilder);
                i++;
                kodBuilder.append('\"');
                yield KodTokena.STR;
            }
            case '<' ->{
                i++;
                if (i < ciag.length() && ciag.charAt(i) == '=') {
                    kodBuilder.append('=');
                    i++;
                    yield KodTokena.ELESS;
                }
                yield KodTokena.LESS;
            }
            case '>' ->{
                i++;
                if (i < ciag.length() && ciag.charAt(i) == '=') {
                    kodBuilder.append('=');
                    i++;
                    yield KodTokena.GREATER;
                }
                yield KodTokena.GREATER;
            }
            case '!' ->{
                i++;
                if (i < ciag.length() && ciag.charAt(i) == '=') {
                    kodBuilder.append('=');
                    i++;
                    yield KodTokena.NEQUAL;
                }
                yield KodTokena.ERR;
            }

            default -> {
                if (Character.isLetter(ciag.charAt(i))) {
                    pullIds(kodBuilder);
                    if (kodBuilder.toString().equals("var")) {
                        yield KodTokena.VAR;
                    }
                    if (kodBuilder.toString().equals("true") || kodBuilder.toString().equals("false")) {
                        yield KodTokena.BOOL;
                    }

                    if  (kodBuilder.toString().equals("if")) {
                        yield KodTokena.IF;
                    }

                    if  (kodBuilder.toString().equals("else")) {
                        yield KodTokena.ELSE;
                    }

                    if  (kodBuilder.toString().equals("for")) {
                        yield KodTokena.FOR;
                    }

                    if (kodBuilder.toString().equals("print")) {
                        yield KodTokena.PRINT;
                    }

                    yield KodTokena.ID;
                }

                if (Character.isDigit(ciag.charAt(i))) {
                    pullNums(kodBuilder);
                    yield KodTokena.NUM;
                }

//                kodBuilder.append(", na pozycji ").append(i);
                i++;
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
            if (kodBuilder.toString().equals("var")) {
                break;
            }
        }
    }

    private void pullStrings(StringBuilder kodBuilder) {
        i++;
        while (i < ciag.length() && ciag.charAt(i) != '\"') {
            kodBuilder.append(ciag.charAt(i++));
        }
    }

}
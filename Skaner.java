public class Skaner {
    enum KodTokena {
        NUM, ID, PLUS, MINUS, MULT, DIV, LBRACKET, RBRACKET, ERR, EOF
    }

    public int skaner(String ciag, int i) {
        String kod = Character.toString(ciag.charAt(i));
        if (Character.isLetter(ciag.charAt(i))) {
            i++;
            System.out.println(ciag.length());
            while (i < ciag.length()) {
                if (Character.isLetter(ciag.charAt(i)) || Character.isDigit(ciag.charAt(i))) {
                    kod += Character.toString(ciag.charAt(i));
                    i++;
                } else {
                    i--;
                    break;
                }
            }
            System.out.println(KodTokena.ID + ": " + kod);
        } else if (Character.isDigit(ciag.charAt(i))) {
            i++;
            while (i < ciag.length()) {
                if (Character.isDigit(ciag.charAt(i))) {
                    kod += Character.toString(ciag.charAt(i));
                    i++;
                } else {
                    i--;
                    break;
                }
            }
            System.out.println(KodTokena.NUM + ": " + kod);
        } else if (ciag.charAt(i) == '+') {
            System.out.println(KodTokena.PLUS + ": " + kod);
        } else if (ciag.charAt(i) == '-') {
            System.out.println(KodTokena.MINUS + ": " + kod);
        }  else if (ciag.charAt(i) == '*') {
            System.out.println(KodTokena.MULT + ": " + kod);
        }  else if (ciag.charAt(i) == '/') {
            System.out.println(KodTokena.DIV + ": " + kod);
        } else if (ciag.charAt(i) == '(') {
            System.out.println(KodTokena.LBRACKET + ": " + kod);
        } else if (ciag.charAt(i) == ')') {
            System.out.println(KodTokena.RBRACKET + ": " + kod);
        } else{
            System.out.println(KodTokena.ERR + ": "+ kod+", na pozycji "+i);
        }
        return ++i;
    }

}
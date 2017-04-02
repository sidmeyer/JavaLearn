package sidmeyer.asciicharsequence;

/**
 * Created by stas on 02.04.17.
 */
public class Main {
    public static void main(String[] args) {
        String s = "Abcdefg";
        char[] c = s.toCharArray();
        byte[] b = new byte[c.length];
        for(int i=0; i<c.length; i++) {
            b[i] = (byte) c[i];
        }

        AsciiCharSequence acs = new AsciiCharSequence(b);
        System.out.println(acs.charAt(0));
        System.out.println(acs.toString());
        System.out.println(acs.length());
        System.out.println(acs.subSequence(2,5));
    }
}

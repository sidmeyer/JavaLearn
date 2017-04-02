package sidmeyer.asciicharsequence;

/**
 * Created by stas on 02.04.17.
 */
public class AsciiCharSequence implements CharSequence{

    byte[] bytes;

    public AsciiCharSequence(byte[] bytes) {
        this.bytes = bytes;
    }

    @Override
    public int length() {
        return bytes.length;
    }

    @Override
    public char charAt(int index) {
        return (char) bytes[index];
    }

    @Override
    public CharSequence subSequence(int start, int end) {
        byte[] subBytes = new byte[end - start];
        for(int i = 0; i < end - start; i++) {
            subBytes[i] = bytes[i + start];
        }
        return new AsciiCharSequence(subBytes);
    }

    @Override
    public String toString() {
        char[] c = new char[bytes.length];
        for (int i=0; i<bytes.length; i++) {
            c[i] = (char) bytes[i];
        }
        return String.valueOf(c);
    }

}

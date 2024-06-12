public class Caesarcipher {
    public String alphabets;

    public Caesarcipher() {
        this.alphabets = "abcdefghijklmnopqrstuvwxyz";
    }

    public String encrypt(String plaintext, int key) {
        StringBuilder cipher = new StringBuilder();
        plaintext = plaintext.toLowerCase();
        for (int i = 0; i < plaintext.length(); i++) {
            char currentChar = plaintext.charAt(i);
            if (this.alphabets.indexOf(currentChar) != -1) {
                int pindex = this.alphabets.indexOf(currentChar);
                int cindex = (pindex + key) % 26;
                cipher.append(this.alphabets.charAt(cindex));
            } else {
                cipher.append(currentChar);
            }
        }
        return cipher.toString();
    }

    public String decrypt(String ciphertext, int key) {
        StringBuilder plain = new StringBuilder();
        ciphertext = ciphertext.toLowerCase();
        for (int i = 0; i < ciphertext.length(); i++) {
            char currentChar = ciphertext.charAt(i);
            if (this.alphabets.indexOf(currentChar) != -1) {
                int cindex = this.alphabets.indexOf(currentChar);
                int pindex = (cindex - key + 26) % 26;
                plain.append(this.alphabets.charAt(pindex));
            } else {
                plain.append(currentChar);
            }
        }
        return plain.toString();
    }

    public static void main(String[] args) {
        Caesar caesar = new Caesar();
        String plaintext = "hello world";
        int key = 3;

        String encrypted = caesar.encrypt(plaintext, key);
        System.out.println("Encrypted: " + encrypted);

        String decrypted = caesar.decrypt(encrypted, key);
        System.out.println("Decrypted: " + decrypted);
    }
}

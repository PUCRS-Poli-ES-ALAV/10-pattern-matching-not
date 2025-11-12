public class RabinKarpin {
    public static void main(String[] args) {
        String txt = "ababcababc";
        String pat = "abc";
        RabinKarpin rk = new RabinKarpin();
        int index = rk.search(pat, txt);
        if (index < txt.length()) {
            System.out.println("Pattern found at index: " + index);
        } else {
            System.out.println("Pattern not found");
        }
    }

    private int search(String pat, String txt) {
        int M = pat.length();
        int N = txt.length();
        long patHash = hash(pat, M);

        for (int i = 0; i <= N - M; i++) {
            long txtHash = hash(txt.substring(i, i + M), M);
            if (patHash == txtHash)
                return i;
        }
        return N;
    }

    private long hash(String s, int end) {
        long h = 0;
        for (int i = 0; i < end; i++) {
            h = (h * 256 + s.charAt(i)) % 101;
        }
        return h;
    }
}
public class RabinKarpin {
    public static void main(String[] args) {
        // Test case requested: texto com 500_000 caracteres
        int N = 500_000;
        int M = 3; // padrão curto para que a execução seja prática

        String txt = repeatChar('a', N);
        String pat = repeatChar('b', M); // diferente do texto para garantir 'não encontrado'

        RabinKarpin rk = new RabinKarpin();

        long start = System.nanoTime();
        int index = rk.search(pat, txt);
        long elapsedMs = (System.nanoTime() - start) / 1_000_000;

        System.out.println("Test: N=" + N + " M=" + M);
        if (index < txt.length()) {
            System.out.println("Pattern found at index: " + index);
        } else {
            System.out.println("Pattern not found");
        }
        System.out.println("Time (ms): " + elapsedMs);
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

    // helper para construir strings repetidas
    private static String repeatChar(char c, int count) {
        char[] arr = new char[count];
        for (int i = 0; i < count; i++)
            arr[i] = c;
        return new String(arr);
    }
}
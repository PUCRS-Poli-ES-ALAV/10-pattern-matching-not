public static void main(String[] args) {
    String s1 = "ABCDCBDCBDACBDABDCBADF";
    String s2 = "ADF";
    System.out.println(subsString(s1,s2));
}

public static int subsString(String s1, String s2){
    for(int i = 0; i <= s1.length() - s2.length(); i++ ){
        int j;
        for(j = 0; j < s2.length(); j++){
            if(s1.charAt(i + j) != s2.charAt(j)){
                break;
            }
        }
        if(j ==s2.length())
            return i;

    }
    return -1;
}
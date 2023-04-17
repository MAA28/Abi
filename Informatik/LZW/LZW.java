import java.util.ArrayList;

class LZW {
    public static void main(String[] args) {
        String s = args[0];
        String o = compress(s);
        System.out.println("Compressed string: " + o);
    }
    
    public static String compress(String s) {
        ArrayList<String> dictionary = new ArrayList<String>();
        String o = "";
        int N = 0;
        while (s.length() != 0) {
            for (int j = Math.min(10, s.length()); j >= 1; j--) {
                String word = s.substring(0, j);
                boolean is_contained = false;
                for (String entry : dictionary) if (entry.equals(word)) {
                    is_contained = true;
                    break;
                }
                if (is_contained || j == 1) {
                    String new_word = (j < s.length() ? s.substring(0, j + 1) :  "-");
                    dictionary.add(new_word);
                           
                    s = s.substring(j);
                    o += (is_contained ? String.format("[%04d]", dictionary.indexOf(word)) : word);
                    N++;
                    System.out.println("\"" + word + "\" \t| " +  String.format("[%04d]", dictionary.size() - 1) + " --> \"" + new_word + "\"");
                    // System.out.println(word + " \t| " + (dictionary.size() - 1) + " --> " + new_word + " \t| " + s + " \t| " + o);
                    break;
                }
           }
        }

        System.out.println("Total # of letters: " + N);
        return o;
    }
}
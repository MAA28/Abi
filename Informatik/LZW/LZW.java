import java.util.ArrayList;

class LZW {
    public static void main(String[] args) {
        String s = args[0];
        ArrayList<String> dictionary = new ArrayList<String>();
        String o = "";
        
        while (s.length() != 0) {
            for (int j = s.length(); j >= 1; j--) {
                String word = s.substring(0, j);
                
                if (dictionary.contains(word) || j == 1) {
                    String new_word = (j < s.length() ? s.substring(0,j+1) : "-");
                    dictionary.add(new_word);
                                        
                    s = s.substring(j);
                    o += (dictionary.contains(word) ? "[" + dictionary.indexOf(word) + "]" : word);
                    System.out.println(word + " \t| " + (dictionary.size() - 1) + " --> " + new_word + " \t| " + s + " \t| " + o);
                    break;
                }
           }
        }
    }
}
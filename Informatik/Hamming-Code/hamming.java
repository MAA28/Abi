import java.lang.Math;

class hamming {
    public static void main(String[] args) {
            int data = toBinary("1111");
            System.out.println(data);

            
            System.out.println(encode(data));
    }
    public static int toBinary(String data) {
        int acc = 0;

        for(int i = 0; i < data.length(); i++) if (data.charAt(data.length() - 1 - i) == '1') {
            acc += Math.pow(2, i);
        }

        return acc;
    }
    public static String encode (int data) {
        String data = Integer.toBinaryString(data);
        
                
        
        return hamming;
    }
    
}
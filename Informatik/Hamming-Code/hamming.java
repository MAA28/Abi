import java.lang.Math;

class hamming {
    public static void main(String[] args) {
            String data = args[0];
            System.out.println("DATA:    \t" + data);

            String hamming_code = encode(data);
            System.out.println("HAMMING CODE:\t" + hamming_code);

            int error = Integer.parseInt(args[1]);
            System.out.println("ERROR SET AT:\t" + error);
            
            String erronious_code = flip_bit(hamming_code, error);
            System.out.println("ERRONIOUS CODE:\t" + erronious_code);
            
            int error_position = findError(erronious_code);
            System.out.println("ERROR DETECTED:\t" + error_position);

            String fixed_code = flip_bit(erronious_code, error_position);
            System.out.println("FIXED CODE:\t" + fixed_code);

            String recovered_data = decode(fixed_code);
            System.out.println("RECOVERED DATA:\t" + recovered_data);
    }

    public static String decode(String code) {
        String data = "";
        int power_of_two = 0;
        for (int i = 0; i < code.length(); i++) {
            if ((int) Math.pow(2, power_of_two) == i + 1) {
                power_of_two++;
            } else {
                data += code.charAt(i);
            }
        }    
        return data;
    }
    
    public static String flip_bit(String code, int i) {
        if (i >= 0 && i < code.length()) {
            String flipped_bit = "0";
            
            if (code.charAt(i - 1) == '0') {
                flipped_bit = "1";
            } else {
                flipped_bit = "0";
            }
            
            return code.substring(0, i - 1) + flipped_bit + code.substring(i, code.length());
        } else {
            return code;
        }
    }
    
    public static String encode (String data) {
        // fuege 0 an den 2^n stellen wenn man die liste null-indexed behandelt ein
        int powers_of_two = 0;
        int n = data.length();
        for (int i = 0; i < (n + powers_of_two); i++) {
            int val = (int) Math.pow(2, powers_of_two);
            if (i + 1 == val) {
                data = data.substring(0, i) + "0" + data.substring(i, data.length());
                powers_of_two++;
            }
        } 

        // berechne die paritaet der gruppen
        int parity = 0;
        for (int i = 0; i < data.length(); i++) {
            if (data.charAt(i) == '1') {
                parity = parity ^ (i + 1);
            }
        }
        
        // Schreibe die paritaet in die entsprechenden bits
        String parity_str = Integer.toBinaryString(parity);
        for (int i = 0; i < powers_of_two; i++) {
            int index = (int) Math.pow(2, i);
            char parity_bit = '0';
            if (i < parity_str.length()) {
                parity_bit = parity_str.charAt(parity_str.length() - i - 1);
            }
            
            
            data = data.substring(0,index - 1) + parity_bit + data.substring(index, data.length()); 
        }
        
        return data;
    }

    public static int findError(String hamming) {
        int parity = 0;
        for (int i = 0; i < hamming.length(); i++) {
            if (hamming.charAt(i) == '1') {
                parity = parity ^ (i + 1);
            }
        }
        return parity;
    }
}
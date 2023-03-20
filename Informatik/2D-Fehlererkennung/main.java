class Main {
    public static void main(String[] args) {
        System.out.println("Hello World --------------");
        short[][] code = {
            {0,0,0,0},
            {1,0,1,0},
            {0,1,0,1},
            {1,1,1,1}
        };

        short[][] data = {
            {code[0][0], code[0][1], code[0][2]},
            {code[1][0], code[1][1], code[1][2]},
            {code[2][0], code[2][1], code[2][2]}
        };

        short[][] reconstructed_code = encode(data);

        short[] error_position = find_error(code, reconstructed_code);

        System.out.println("X: " + error_position[0] + " Y: " + error_position[1]);
    }

    static short[] find_error(short[][] code, short[][] reconstructed_code) {
        short[][] xor = new short[][]{
            {
                (short) ((code[0][3] + reconstructed_code[0][3]) % 2),
                (short) ((code[1][3] + reconstructed_code[1][3]) % 2),
                (short) ((code[2][3] + reconstructed_code[2][3]) % 2),
                (short) ((code[3][3] + reconstructed_code[3][3]) % 2)
            },
            {
                (short) ((code[3][0] + reconstructed_code[3][0]) % 2),
                (short) ((code[3][1] + reconstructed_code[3][1]) % 2),
                (short) ((code[3][2] + reconstructed_code[3][2]) % 2),
                (short) ((code[3][3] + reconstructed_code[3][3]) % 2)
            },
        };

        
                
        
       return new short[]{
            (short) (xor[0][0] * 1 + xor[0][1] * 2 + xor[0][2] * 3 + xor[0][3] * 4 - 1),
            (short) (xor[1][0] * 1 + xor[1][1] * 2 + xor[1][2] * 3 + xor[1][3] * 4 - 1),
        };
    }

    static short[][] encode(short[][] data) {
        
        short[][] code = {
            {data[0][0], data[0][1], data[0][2], parity(new short[]{data[0][0], data[0][1], data[0][2]})},
            {data[1][0], data[1][1], data[1][2], parity(new short[]{data[1][0], data[1][1], data[1][2]})},
            {data[2][0], data[2][1], data[2][2], parity(new short[]{data[2][0], data[2][1], data[2][2]})},
            {parity(new short[]{data[0][0], data[1][0], data[2][0]}), parity(new short[]{data[0][1], data[1][1], data[2][1]}), parity(new short[]{data[0][2], data[1][2], data[2][2]}), parity(new short[]{data[0][0], data[1][0], data[2][0], data[0][1], data[1][1], data[2][1], data[0][2], data[1][2], data[2][2]})}
        };

        return code;
    }

    static short parity(short[] s) {
        short parity = 0;
        for (int i = 0; i < s.length; i++) {
            parity = (short) ((s[i] + parity) % 2);
        }
        return parity;
    }
}
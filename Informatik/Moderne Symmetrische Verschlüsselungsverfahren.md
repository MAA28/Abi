| Klartext | ASCII | Binär    |
| -------- | ----- | -------- |
| G        | 71    | 01000111 |
| E        | 69    | 01000101 |
| L        | 76    | 01001100 |
| D        | 68    | 01000100 |

| Klartext | Binär             | Vertauscht                | XOR (mit 00010111 00010110) | ASCII | Verschlüsselt |
| -------- | ----------------- | ------------------------- | --------------------------- | ----- | ------------- |
| GE       | 01000111 01000101 | 0100**0101** 0100**0111** | 1010010 01010001            | 82 81 | RQ            |
| LD       | 01001100 01000100 | 0100**0100** 0100**1100** | 1010011 01011010            | 83 90 | SZ            |


Da XOR und die Vertauschung eindeutig umkehrbar sind muss man das Ergebnis "RQSZ":
1. In ASCII umwandeln
2. In Binär umwandeln
3. XOR mit 00010111 00010110 nochmal anwenden
4. Den zweiten Block an vier Bits mit dem letzten tauschen
5. Die 4 Bytes umwandeln als wären sie ein ASCII-Code
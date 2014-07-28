package puzzels.binary;

// solves http://codegolf.stackexchange.com/questions/35096/convert-a-string-of-binary-characters-to-the-ascii-equivalents

p={it.split(" ").collect{Integer.parseInt(it,2) as char}.join("")}


println p("1001000 1100101 1101100 1101100 1101111 100000 1010111 1101111 1110010 1101100 1100100")
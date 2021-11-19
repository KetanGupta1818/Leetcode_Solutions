	public static int hammingDistance(int x, int y) {
		int count = 0;
        String sx = Integer.toBinaryString(x);
        String sy = Integer.toBinaryString(y);
        if(x == y) return 0;
        String adder = new String();
        if(x>y) {
        	for(int i=0;i<sx.length()-sy.length();i++) {
        		adder = adder + "0";
        	}
        	sy = adder+sy;
        }
        else {
        	for(int i=0;i<sy.length()-sx.length();i++) {
        		adder = adder + "0";
        	}
        	sx = adder + sx;
        }
        for(int i=0;i<sy.length();i++) {
        	char sxc = sx.charAt(i);
        	char syc = sy.charAt(i);
        	if(syc!=sxc) count++;
        }
        return count;
    }

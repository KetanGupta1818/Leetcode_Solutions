public static char slowestKey(int[] releaseTimes, String keysPressed) {
        StringBuffer str = new StringBuffer(keysPressed.charAt(0));
        int max_dif = releaseTimes[0];
        for(int i=0;i<releaseTimes.length-1;i++){
            int cur_dif = releaseTimes[i+1]-releaseTimes[i];
            if(cur_dif>max_dif){
                max_dif = cur_dif;
                str.delete(0,str.length());
                str.append(keysPressed.charAt(i+1));
            }
            else if(cur_dif == max_dif) str.append(keysPressed.charAt(i+1));
            else continue;
        }
        System.out.println(str);
        if(str.length() == 1) return str.charAt(0); 
        String s = new String();
        s = str.toString();
        char temp[] = s.toCharArray();
        Arrays.sort(temp);
        s = new String(temp);
        if(s.length()==0) return '\0';
        try {
        	return s.charAt(s.length()-1);
        }
        catch(StringIndexOutOfBoundsException e) {
             System.out.println("The length of string s is: " + s.length());
             return 'e';
        }
    }	

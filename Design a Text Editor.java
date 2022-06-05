class TextEditor {
    StringBuilder sb;
    int cursor;
     public TextEditor() {
        sb = new StringBuilder();
        cursor = 0;
     }

     public void addText(String text) {
        sb.insert(cursor,text);
        cursor += text.length();
     }

     public int deleteText(int k) {
        int ad = Math.min(k,cursor);
        cursor = cursor - ad;
        sb = new StringBuilder(sb.substring(0, cursor) + sb.substring(cursor + ad));
        return ad;
     }

     public String cursorLeft(int k) {
        cursor = cursor - Math.min(k,cursor);
        if(cursor <= 10) return sb.substring(0,cursor);
        return sb.substring(cursor-10,cursor);
     }

     public String cursorRight(int k) {
        cursor = cursor + Math.min(sb.length()-cursor,k);
         if(cursor <= 10) return sb.substring(0,cursor);
         return sb.substring(cursor-10,cursor);
     }
 }

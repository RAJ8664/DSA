class TextEditor {
    private StringBuffer current_text;
    private int current_cursor;
    public TextEditor() {
        current_text = new StringBuffer();
        current_cursor = 0;
    }
    
    public void addText(String text) {
        current_text.insert(current_cursor, text);
        current_cursor += text.length();
    }
    
    public int deleteText(int k) {
        int prev_cursor = current_cursor;
        current_text.delete(Math.max(0, current_cursor - k) , current_cursor);
        current_cursor = Math.max(0, current_cursor - k);
        return prev_cursor - current_cursor;
    }
    
    public String cursorLeft(int k) {
        current_cursor = Math.max(0, current_cursor - k);
        return getCharacters();
    }
    
    public String cursorRight(int k) {
        current_cursor = Math.min(current_text.length() , current_cursor + k);
        return getCharacters();
    }

    private String getCharacters() {
        return current_text.substring(Math.max(0, current_cursor - 10), current_cursor);
    }
}

/**
 * Your TextEditor object will be instantiated and called as such:
 * TextEditor obj = new TextEditor();
 * obj.addText(text);
 * int param_2 = obj.deleteText(k);
 * String param_3 = obj.cursorLeft(k);
 * String param_4 = obj.cursorRight(k);
 */
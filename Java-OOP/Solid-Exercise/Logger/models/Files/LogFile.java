package Logger.models.Files;

import Logger.interfaces.File;

public class LogFile implements File {

    private int size;
    private StringBuilder content;


    public LogFile() {
        this.content = new StringBuilder();
    }

    @Override
    public int getSize() {
        return this.size;
    }

    @Override
    public void write(String text) {
        this.content.append(text);
        this.size += getTextSize(text);
    }

    private int getTextSize(String text) {
        return text.chars()
                .filter(ch -> Character.isAlphabetic(ch))
                .sum();
    }

}

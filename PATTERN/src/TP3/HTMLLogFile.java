package TP3;

public class HTMLLogFile implements LogFile{
    public HTMLLogFile(String string) {
		// TODO Auto-generated constructor stub
	}

	@Override
    public LogFormatter getFormatter() {
        return new HTMLLogFormatter();
    }

}

package TP3;

public class TextLogFile implements LogFile {
	public TextLogFile(String string) {
		// TODO Auto-generated constructor stub
	}

	@Override
	public LogFormatter getFormatter() {
		return new TextLogFormatter();
	}

}

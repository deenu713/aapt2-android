package com.android.tools.aapt2;

public interface Aapt2JniDiagnostics {
	
	// logLevel 1 = NOTE
	// LogLevel 2 = WARN
	// LogLevel 3 = ERROR
	public void log(int logLevel, String path, long line, String message);
    
}

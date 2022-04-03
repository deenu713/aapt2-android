package com.rohitop.tools.aapt2;

import java.util.List;

public class Aapt2Jni {
	
	public static native void ping();
	public static native int compile(List<String> arguments, Aapt2JniDiagnostics diagnostics);
	public static native int link(List<String> arguments, Aapt2JniDiagnostics diagnostics);
	public static native int convert(List<String> arguments);
	
	private static boolean libLoaded = false;
	private static final String LIB_NAME = "aapt2_jni";

    static {
		initLib();
	}

	private Aapt2Jni() {}

    private static synchronized void initLib() {
		if (libLoaded) {
			return;
		}

		System.loadLibrary(LIB_NAME);
		libLoaded = true;
	}
}

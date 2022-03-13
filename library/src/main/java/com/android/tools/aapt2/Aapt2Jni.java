package com.android.tools.aapt2;

import java.util.List;

public class Aapt2Jni {

	public static native int ping();
	public static native int nativeCompile(List<String> arguments, Aapt2JniDiagnostics diagnostics);
	public static native int nativeLink(List<String> arguments, Aapt2JniDiagnostics diagnostics);
	
	private static boolean libLoaded = false;
	private static final String LIB_NAME = "aapt2";

    static {
		initLib();
	}

	private Aapt2Jni() {}

    public static synchronized void initLib() {
		if (libLoaded) {
			return;
		}

		System.loadLibrary(LIB_NAME);
		libLoaded = true;
	}
}

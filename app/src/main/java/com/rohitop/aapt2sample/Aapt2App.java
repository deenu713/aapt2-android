package com.rohitop.aapt2sample;

import android.app.Application;

import cat.ereza.customactivityoncrash.config.CaocConfig;

public class Aapt2App extends Application {

	@Override
	public void onCreate() {
		super.onCreate();
		
		CaocConfig.Builder.create()
			.backgroundMode(CaocConfig.BACKGROUND_MODE_SHOW_CUSTOM)
			.enabled(true)
			.showErrorDetails(true)
			.showRestartButton(true)
			.logErrorOnRestart(true) 
			.trackActivities(true)
			.minTimeBetweenCrashesMs(2000)
			.apply();
	}
}

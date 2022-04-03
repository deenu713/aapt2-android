package com.rohitop.aapt2sample.ui;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Button;
import android.view.View.OnClickListener;
import android.view.View;
import java.util.ArrayList;
import java.util.List;
import android.widget.Toast;
import java.util.Arrays;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;

import com.rohitop.aapt2sample.R;

import com.rohitop.tools.aapt2.Aapt2Jni;
import com.rohitop.tools.aapt2.Aapt2JniDiagnostics;
import androidx.core.app.ActivityCompat;
import android.Manifest;

public class MainActivity extends AppCompatActivity {
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		ActivityCompat.requestPermissions(
			this,
			new String[]{
				Manifest.permission.READ_EXTERNAL_STORAGE,
				Manifest.permission.MANAGE_EXTERNAL_STORAGE
			},
			1
		);
		
		Button run = findViewById(R.id.run);
		run.setOnClickListener(new OnClickListener() {
				@Override
				public void onClick(View p1) {
					List<String> args = new ArrayList<>();
					args.add("--output-format");
					args.add("proto");
					args.add("-o");
					args.add("/storage/emulated/0/.TestFiles/base.zip");
					args.add("/storage/emulated/0/.TestFiles/base.apk");
					int code = Aapt2Jni.convert(args);
					if (code > 0) {
						Log.e(MainActivity.class.getSimpleName(), "error when converting");
					}
				}
			});
    }
}

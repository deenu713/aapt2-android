package com.rohitop.toolssample.ui;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Button;
import android.view.View.OnClickListener;
import android.view.View;
import java.util.ArrayList;
import java.util.List;
import android.widget.Toast;
import java.util.Arrays;

import androidx.appcompat.app.AppCompatActivity;

import com.rohitop.toolssample.R;

import com.android.tools.aapt2.Aapt2Jni;
import com.android.tools.aapt2.Aapt2JniDiagnostics;

public class MainActivity extends AppCompatActivity {
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		Button run = findViewById(R.id.run);
		run.setOnClickListener(new OnClickListener() {
				@Override
				public void onClick(View p1) {
				  String[] args = {"--version"};
				
					Aapt2Jni.nativeCompile(Arrays.asList(args), new Aapt2JniDiagnostics() {
							@Override
							public void log(int logLevel, String path, long line, String message) {
							    Toast.makeText(getApplicationContext(), message, Toast.LENGTH_LONG).show();
							}
						});
				}
			});
    }
}

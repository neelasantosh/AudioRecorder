package com.example.audiorecorder;

import java.io.File;

import android.app.Activity;
import android.media.MediaRecorder;
import android.media.MediaRecorder.AudioEncoder;
import android.media.MediaRecorder.AudioSource;
import android.media.MediaRecorder.OutputFormat;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class HomeActivity extends Activity
{
	Button buttonRecord,buttonStop;
	MediaRecorder recorder;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.home);
		buttonRecord = (Button) findViewById(R.id.button1);
		buttonStop = (Button) findViewById(R.id.button2);
		
		buttonRecord.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				
				recorder = new MediaRecorder();
				recorder.setAudioSource(AudioSource.MIC);
				recorder.setOutputFormat(OutputFormat.MPEG_4);
				recorder.setAudioEncoder(AudioEncoder.DEFAULT);
				//create path for output file sdcard
			
				File sdCard = Environment.getExternalStorageDirectory();
				String path = sdCard.getAbsolutePath() + "/voice.mp4";
				recorder.setOutputFile(path);
				try{
					recorder.prepare();
					recorder.start();
					
					
				
				}catch(Exception ex){
					ex.printStackTrace();
				}
				}
			
		});
		
		buttonStop.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				recorder.stop();
				recorder.reset();
				recorder.release();
			}
		});
		
		
	}
}

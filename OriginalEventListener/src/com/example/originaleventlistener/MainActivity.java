package com.example.originaleventlistener;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends Activity {

	private SampleNotification sn = null ;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		EditText ed = (EditText)findViewById(R.id.edit) ;
		//通知用のクラスのインスタンス化
		sn = new SampleNotification(ed) ;
		//通知用クラスに通知先のインスタンスを付与
		sn.setListener(new SampleEventClass()) ;
		
		Button bt = (Button)findViewById(R.id.button) ;
		bt.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				sn.checkText() ;
			}
		}) ;
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	
	private class SampleEventClass implements SampleListenerInterFace{

		@Override
		public void noInputText() {
			Toast.makeText(MainActivity.this, "文字が入力されていません", Toast.LENGTH_SHORT).show() ;
		}

		@Override
		public void inPutText(String inpuText) {
			Toast.makeText(MainActivity.this, "入力されている文字は"+inpuText+"です", Toast.LENGTH_SHORT).show() ;
		}
		
	}

}

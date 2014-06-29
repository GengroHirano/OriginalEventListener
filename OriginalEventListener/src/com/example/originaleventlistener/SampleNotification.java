package com.example.originaleventlistener;

import android.widget.EditText;

public class SampleNotification {

	private EditText ed = null ;
	private SampleListenerInterFace lInterFace = null ;
	
	public SampleNotification(EditText ed) {
		this.ed = ed ;
	}
	
	/**
	 * EditTextに文字が入力されているか判定する
	 */
	public void checkText(){
		if( lInterFace != null ){
			if(ed.getText().toString().equals("")){
				lInterFace.noInputText() ;
			}
			else {
				lInterFace.inPutText(ed.getText().toString()) ;
			}
		}
	}
	
	/**
	 * リスナの登録
	 * @param lInterFace
	 */
	public void setListener(SampleListenerInterFace lInterFace){
		this.lInterFace = lInterFace ;
	}
	
	/**
	 * リスナの削除
	 */
	public void removeListener(){
		this.lInterFace = null ;
	}
	
}

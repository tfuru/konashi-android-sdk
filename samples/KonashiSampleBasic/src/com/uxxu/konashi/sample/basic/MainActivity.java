package com.uxxu.konashi.sample.basic;

import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import com.uxxu.konashi.lib.Konashi;
import com.uxxu.konashi.lib.KonashiActivity;
import com.uxxu.konashi.lib.KonashiObserver;

public class MainActivity extends KonashiActivity {
    private static final String TAG = "KonashiSample";
    
    private LinearLayout mContainer;
    private Button mFindButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        // ボタン全体のコンテナ
        mContainer = (LinearLayout)findViewById(R.id.container);
        mContainer.setVisibility(View.GONE);
        
        // 一番上に表示されるボタン。konashiにつないだり、切断したり
        mFindButton = (Button)findViewById(R.id.find_button);
        mFindButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!getKonashiManager().isReady()){
                    // konashiを探して接続。konashi選択ダイアログがでます
                    getKonashiManager().find(MainActivity.this);
                    
                    // konashiを明示的に指定して、選択ダイアログを出さない 
                    //mKonashiManager.findWithName(MainActivity.this, "konashi#4-0452");           
                } else {
                    // konashiバイバイ
                    getKonashiManager().disconnect();
                    
                    mFindButton.setText(getText(R.string.find_button));
                    mContainer.setVisibility(View.GONE);
                }
            }
        });
        
        // ボタンの動作を定義
        setButtonAction(R.id.led2_button, Konashi.LED2);
        setButtonAction(R.id.led3_button, Konashi.LED3);
        setButtonAction(R.id.led4_button, Konashi.LED4);
        setButtonAction(R.id.led5_button, Konashi.LED5);

        //UART 送信テスト
        Button uart_button = (Button)findViewById(R.id.uart_button);
        uart_button.setOnClickListener(clickUartButton);
        
        // konashiのイベントハンドラを設定。定義は下の方にあります
        getKonashiManager().addObserver(mKonashiObserver);
    }
    
    /**
     * ボタンの動作を定義する。ボタンに触るとLEDがON, ボタンから離すとLEDがOFF
     * @param resId Resource ID
     * @param pin ボタンを押した時に反応するポート
     */
    private void setButtonAction(int resId, final int pin){
        Button button = (Button)findViewById(resId);
        button.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {                
                switch(event.getAction()){
                case MotionEvent.ACTION_DOWN:
                    // 触った時
                    getKonashiManager().digitalWrite(pin, Konashi.HIGH);  // HIGHでLEDが点灯
                    break;
                    
                case MotionEvent.ACTION_UP:
                    // 離した時
                    getKonashiManager().digitalWrite(pin, Konashi.LOW);  // LOWでLEDが消灯
                    break;
                }
                return false;
            }
        });
    }

    /**
     * konashiのイベントハンドラ
     */
    private final KonashiObserver mKonashiObserver = new KonashiObserver(MainActivity.this) {
        @Override
        public void onReady(){
            Log.d(TAG, "onReady");
            
            // findボタンのテキストをdisconnectに
            mFindButton.setText(getText(R.string.disconnect_button));
            // ボタンを表示する
            mContainer.setVisibility(View.VISIBLE);

            // konashiのポートの定義。LED2〜5を出力に設定。
            getKonashiManager().pinMode(Konashi.LED2, Konashi.OUTPUT);
            getKonashiManager().pinMode(Konashi.LED3, Konashi.OUTPUT);
            getKonashiManager().pinMode(Konashi.LED4, Konashi.OUTPUT);
            getKonashiManager().pinMode(Konashi.LED5, Konashi.OUTPUT);
            
            //UARTを有効に設定
            getKonashiManager().uartBaudrate(Konashi.UART_RATE_9K6);
            getKonashiManager().uartMode(Konashi.UART_ENABLE);
        }
        
        /**
         * UARTのRxからデータを受信した時
         */
        @Override
        public void onCompleteUartRx(byte[] data){
        	Log.d(TAG, "onCompleteUartRx data.length:"+data.length);
        	 for(byte d:data){
			    Log.d(TAG, "d:"+String.format("%02x", d));
        	 }
        	getKonashiManager().uartWrite(data);
        }
    };
    
    private final View.OnClickListener clickUartButton = new View.OnClickListener(){

		@Override
		public void onClick(View v) {
			try{
				byte[] data = "ABCDEF\n".getBytes("UTF-8");
				getKonashiManager().uartWrite(data);
				
				/*
				Log.d(TAG, "data.length:"+data.length);
			    for(byte d:data){
			    	Log.d(TAG, "d:"+String.format("%02x", d));
			    	
					//UARTで1バイトづつ送信	
					getKonashiManager().uartWrite(d);
				}
				*/				
			}
			catch(Exception e){
				
			}
		}
    };
}

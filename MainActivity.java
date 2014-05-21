package com.example.cctv;


import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.NetworkInfo.State;
import android.net.wifi.WifiManager;
import android.net.wifi.p2p.WifiP2pManager;
import android.net.wifi.p2p.WifiP2pManager.Channel;
import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class MainActivity extends Activity {
	
	WifiP2pManager wifi ;//= (WifiP2pManager) getSystemService(Context.WIFI_SERVICE);
	Channel cnl;
	EditText username;
	EditText password;
	Button enter;
	TextView state;
	
	/*public static boolean checkNetworkState(Context context) {
	    ConnectivityManager conMgr = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
	    NetworkInfo infos[] = conMgr.getAllNetworkInfo();
	    for (NetworkInfo info : infos) {
	        if (info.getState() == State.CONNECTED)
	            return true;
	    }
	    return false;
	}
	*/
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        wifi=(WifiP2pManager) getSystemService(Context.WIFI_P2P_SERVICE);
        state=(TextView)findViewById(R.id.state);
      
       // Toast.makeText(getApplicationContext(), "wifi is disabled..making it enabled", 
       //         Toast.LENGTH_LONG).show();
        
      //  wifi. setWifiEnabled(true);// set wifi enable
       // boolean condition=wifi.isWifiEnabled();
       // if(condition)
       // 	state.setText("wifi is ok");
      //  else 
      //  	state.setText("wifi is not ok");
        	
        			
        //	state.setText("wifi started");
        //else
        //	state.setText("cant start");
        
        
        /////////////////
        enter=(Button)findViewById(R.id.enter);
        username=(EditText)findViewById(R.id.username);
        password=(EditText)findViewById(R.id.password);
        
        enter.setOnClickListener(new View.OnClickListener() {
			
             	
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				//state.setText("sana");
			
				if((username.getText().toString().equals("samith"))&(password.getText().toString().equals("gowentgone"))){
					state.setText("LOGIN");
					//wifi. setWifiEnabled(false);
					
				}
				else
					state.setText("Faild to log");
				
				
			}
		});
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    
}

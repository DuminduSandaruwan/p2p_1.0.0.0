package com.example.p2p_v_1_0_0_0;


import java.util.ArrayList;
import java.util.List;

import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.NetworkInfo.State;
import android.net.wifi.WifiManager;
import android.net.wifi.p2p.WifiP2pConfig;
import android.net.wifi.p2p.WifiP2pDevice;
import android.net.wifi.p2p.WifiP2pDeviceList;
import android.net.wifi.p2p.WifiP2pManager;
import android.net.wifi.p2p.WifiP2pManager.Channel;
import android.net.wifi.p2p.WifiP2pManager.PeerListListener;
import android.os.Bundle;
import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.util.Log;
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
	List peers = new ArrayList();
	PeerListListener peerListListener;
	BroadcastReceiver receiver;
	WifiP2pDevice device;
	WifiP2pConfig config = new WifiP2pConfig();
	IntentFilter intentFilter = new IntentFilter();
	//WiFiBroadcastReceiver receiver;
	Intent intent;
	/////
	
	
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
        cnl=wifi.initialize(this, getMainLooper(), null);
        receiver=new WiFiBroadcastReceiver(wifi,cnl,this);
        
        state=(TextView)findViewById(R.id.state);
        
        intentFilter.addAction(WifiP2pManager.WIFI_P2P_STATE_CHANGED_ACTION);
        intentFilter.addAction(WifiP2pManager.WIFI_P2P_PEERS_CHANGED_ACTION);
        intentFilter.addAction(WifiP2pManager.WIFI_P2P_CONNECTION_CHANGED_ACTION);
        intentFilter.addAction(WifiP2pManager.WIFI_P2P_THIS_DEVICE_CHANGED_ACTION);
        
        
        
                
        
        //wifi.requestPeers(cnl,peerListListener);
       
        //go through here
        wifi.discoverPeers(cnl, new WifiP2pManager.ActionListener() {
        	 
            @Override
            public void onSuccess() {
            	Object peerlistsize=peers.size();
                state.setText("find it"+""+peerlistsize);//not came to here
                
                
            }

            @Override
            public void onFailure(int reasonCode) {
              //  state.setText("cant find");
            	//came to here
            }
        });
        
        
      
       
        
        peerListListener = new PeerListListener() {
            @Override
            public void onPeersAvailable(WifiP2pDeviceList peerList) {
                Log.d("wifi", "here");
                  state.setText("here have wifi");
                  //not came here
                 // Out with the old, in with the new.
                peers.clear();
                peers.addAll(peerList.getDeviceList());
                if (peers.size() == 0) {
                	 //not came here
                    Log.d("wifi", "No devices found");
                    state.setText("cant find wifi");
                    return;
                }
            }
        };
        
        
        
       /* config.deviceAddress = device.deviceAddress;
        
        wifi.connect(cnl, config, new ActionListener(){
        	
        	@Override
        	public void onSuccess(){
        		
        		}
        	@Override
        	public void onFailure(int reason){
        		
        		
        	}
        });      */  
        
        
    
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
        //came here
        
      /*  enter.setOnClickListener(new View.OnClickListener() {
			
             	
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
		});*/
        Object s =peers.size();
        int a=Integer.parseInt(s+"");
        state.setText(a+"");
        
       
    }
    
   
    
    @Override
    public void onResume() {
        super.onResume();
        //came here
        //receiver.onReceive(context, intent)
        registerReceiver(receiver, intentFilter);
    }
    
    @Override
    public void onPause() {
        super.onPause();
        //not came here
        unregisterReceiver(receiver);
    }
    
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
	public void setIsWifiP2pEnabled(boolean b) {
		// TODO Auto-generated method stub
		
		
	}

	public void resetData() {
		// TODO Auto-generated method stub
		
	}

	public PeerListListener getfDevList() {
		// TODO Auto-generated method stub
		return null;
	}
    
	
   
    
}




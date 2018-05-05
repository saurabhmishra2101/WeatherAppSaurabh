package com.tw.weatherapp.weatherappsaurabh.detail.network;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.NetworkInfo.State;

public class NetworkUtility {

		

	public static boolean checkConnectivity(Context context){
		boolean isConnected = false;
		try{
			ConnectivityManager connService = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
			NetworkInfo network = connService.getActiveNetworkInfo();
			if(network != null) {
				State state = network.getState();

			
				if(network.isConnected()){
					isConnected = true;	
					
				}

			}else{
				isConnected = false;

			}			
		}catch (Exception e) {
			e.printStackTrace();

		}
		return isConnected;
	}
	
	
}

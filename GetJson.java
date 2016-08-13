package net.biospherecorp.umorse;

import android.app.Activity;
import android.widget.Toast;

import org.apache.commons.io.IOUtils;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class GetJSON {

	private JSONObject _resultJSONobject;
	private Map<String, String> _resultHashMap = new HashMap<>();

	private int tryCounter = 0;
	private static final int TRY_MAX_COUNT = 10;


	private void _getObjectFromAssets(Activity activity, String fileName){

		try {
			InputStream is = activity.getAssets().open(fileName);
			String json = IOUtils.toString(is);
			_resultJSONobject = new JSONObject(json);

		} catch (IOException | JSONException ex) {
			ex.printStackTrace();
		}
	}
	
	private void _getObjectFromUrl(String url){
		
		try {
			InputStream is = new URL(url).openStream();
			String json = IOUtils.toString(is);
			_resultJSONobject = new JSONObject(json);

		} catch (IOException | JSONException ex) {
			ex.printStackTrace();
		}
	}
	
	private Map<String, String> _returnHashMap(Activity activity){
		
		if (_resultJSONobject != null){

			Iterator<String> keys = _resultJSONobject.keys();
			while(keys.hasNext()){

				final String currentKey = keys.next();
				String currentValue = "";

				try {
					currentValue = (String) _resultJSONobject.get(currentKey);
				} catch (JSONException e1) {
					e1.printStackTrace();
				}
				_resultHashMap.put(currentKey, currentValue);
			}

		}else{
			Toast.makeText(activity, R.string.error_no_json_toast, Toast.LENGTH_SHORT).show();
		}
		
		return _resultHashMap;
	}

	public Map<String, String> getHashMapFromAssets(Activity activity, String fileName) {

		// to handle the possibility of some problems accessing the JSON file
		// we try x times to get the file and display a toast if it fails

		tryCounter = 0;
		
		while(tryCounter <= TRY_MAX_COUNT
				&& _resultJSONobject == null){

			tryCounter++;
			_getObjectFromAssets(activity, fileName);
		}

		return _returnHashMap(activity);
	}
	
	
	// Not tested yet !!
	//
	public Map<String, String> getHashMapFromUrl(Activity activity, String url) {

		// to handle the possibility of some problems accessing the JSON file
		// we try x times to get the file and display a toast if it fails

		tryCounter = 0;
		
		while(tryCounter <= TRY_MAX_COUNT
				&& _resultJSONobject == null){

			tryCounter++;
			_getObjectFromUrl(url);
		}

		return _returnHashMap(activity);
	}
}

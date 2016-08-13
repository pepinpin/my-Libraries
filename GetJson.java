import android.app.Activity;
import android.widget.Toast;

import org.apache.commons.io.IOUtils;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

class GetJSON {

	private JSONObject _resultJSONobject;
	private Map<String, String> _resultHashMap = new HashMap<>();

	private int tryCounter = 0;
	private static final int TRY_MAX_COUNT = 10;


	private void getObjectFromAssets(Activity activity, String fileName){

		try {
			InputStream is = activity.getAssets().open(fileName);
			String json = IOUtils.toString(is);
			_resultJSONobject = new JSONObject(json);

		} catch (IOException | JSONException ex) {
			ex.printStackTrace();
		}
	}

	Map<String, String> getHashMapFromAssets(Activity activity, String fileName) {

		// to handle the possibility of some problems accessing the JSON file
		// we try x times to get the file and display a toast if it fails

		while(tryCounter <= TRY_MAX_COUNT
				&& _resultJSONobject == null){

			tryCounter++;
			getObjectFromAssets(activity, fileName);
		}

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

		tryCounter = 0;
		return _resultHashMap;
	}
}

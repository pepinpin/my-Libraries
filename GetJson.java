import android.app.Activity;
import org.json.JSONException;
import org.json.JSONObject;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class GetJSON {

	private JSONObject _resultJSONobject;
	private Map<String, String> _resultHashMap = new HashMap<>();


	private void getObjectFromAssets(Activity activity, String fileName){

		String json = "";
		try {
			InputStream is = activity.getAssets().open(fileName);
			int size = is.available();
			byte[] buffer = new byte[size];
			is.read(buffer);
			is.close();
			json = new String(buffer, "UTF-8");
		} catch (IOException ex) {
			ex.printStackTrace();
		}

		try {
		_resultJSONobject = new JSONObject(json);
		} catch (JSONException e) {
			e.printStackTrace();
		}
	}

	public Map<String, String> getHashMapFromAssets(Activity activity, String fileName) {

		getObjectFromAssets(activity, fileName);

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

		return _resultHashMap;
	}

	public JSONObject getJSONobjectFromAssets(Activity activity, String fileName) {

		getObjectFromAssets(activity, fileName);
		return _resultJSONobject;
	}

	public void getHashMapFromHttp() throws RuntimeException{

		// todo : finish this method
		throw new RuntimeException();
	}

	public void getJSONobjectFromHttp() throws RuntimeException{

		// todo : finish this method
		throw new RuntimeException();
	}
}

# myLibraries
homemade Android/Java Libraries


## L.java
Android class to "better" handle the console / monitor logs and Toast in Android Studio

The whole point of this is to be able to easily activate/deactivate the logs 

when moving to production/release : just change the boolean IS_ACTIVATED

Only static methods

> Exemples : 
>> L.m("test message") --> default message (in console)

>> L.s(view, "test message") --> default SnackBar

>> L.t(context, "test message") --> default Toast

>> L.w("simple warning message") --> a warning message

>> L.debug(TAG, "simple debug message with a tag") --> a debug message with a tag (just like the normal Log.d method)

>> L.red("simple message in RED") --> a simple message written in red


<br>
## GetJSON
Android class that handles retrieving and parsing JSON

 from a file  in the Assets folder or from an url (http://...)

Can return a plain JSONObject or a HashMap\<String,String>


> Exemples with a file : 
>> JSONObject result = new GetJSON()
				.getJSONObjectFromAssets(activity, "some_file.json");
				
>> HashMap\<String,String> result = new GetJSON()
				.getHashMapFromAssets(activity, "some_file.json");
				
> Exemples with an url : 
>> JSONObject result = new GetJSON()
				.getJSONObjectFromUrl("http://some_url.net");
				
>> HashMap\<String,String> result = new GetJSON()
				.getHashMapFromUrl(activity, "http://some_url.net");
				
<br>
## SimpleCamera
Android Class to easily get a camera object and
use the Flashlight


> Exemples : 
>> 
>> SimpleCamera camera = new SimpleCamera(context);

>> FlashLight flashLight = camera.new FlashLight();

>> camera.initCamera();

>> flashLight.lightOn();

>> flashLight.lightOff();

>>camera.releaseCamera();

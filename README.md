# myLibraries
homemade Android/Java Libraries


## L.java
Android class to "better" handle the console / monitor logs in Android Studio

The whole point of this is to be able to easily activate/deactivate the logs 

when moving to production/release : just change the boolean IS_ACTIVATED



Only static methods

> Exemples : 
>> L.m("test message") --> default message

>> L.t(context, "test message") --> default toast

>> L.w("simple warning message") --> a warning message

>> L.debug(TAG, "simple debug message with a tag") --> a debug message with a tag (just like the normal Log.d method)

>> L.red("simple message in RED") --> a simple message written in red

<br>

## GetJSON
Android class that handles retrieving and parsing JSON

 from a file  in the Assets folder (and soon from http)

Can return a plain JSONObject or a HashMap\<String,String>


> Exemples : 
>> HashMap\<String,String> result = new GetJSON()
				.getHashMapFromAssets(activity, "some_file.json")
				
>> JSONObject result = new GetJSON()
				.getJSONobjectFromAssets(activity, "some_file.json")

# myLibraries
homemade Android/Java Libraries


## L.java
Android class to "better" handle the console / monitor logs in Android Studio

The whole point of this is to be able to easily activate/deactivate the logs 

when moving to production/release : just change the boolean IS_ACTIVATED

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

# myLibraries
homemade Android/Java Libraries


## L.java
Android class to "better" handle the console / monitor logs in Android Studio

The whole point of this is to be able to easily activate/deactivate the logs 

when moving to production/release : just change the boolean IS_ACTIVATED



Only static methods

> Exemple : 
>> L.m("test message") --> default message

>> L.t(context, "test message") --> default toast

>> L.w("simple warning message") --> a warning message

>> L.debug(TAG, "simple debug message with a tag") --> a debug message with a tag (just like the normal Log.d method)

>> L.red("simple message in RED") --> a simple message written in red

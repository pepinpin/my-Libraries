// In manifest, you need to ask for the following permissions :
//
// <uses-permission android:name="android.permission.CAMERA" />
// <uses-feature android:name="android.hardware.camera" />


import android.content.DialogInterface;
import android.content.pm.PackageManager;
import android.hardware.Camera;
import android.support.v7.app.AlertDialog;
import android.util.Log;

// Get a camera and/or flashlight object
// to easily use the light torch or other
// features from the camera
class SimpleCamera {

	private MainActivity _main;

	// Camera is deprecated but still the best way
	// to get the camera as Camera2 is only available
	// from API 21
	private Camera _camera;
	private Camera.Parameters _parameters;

	private boolean isFlashOn = false;

	private static final String TAG = "mCamera";

	mCamera(MainActivity activity){
		_main = activity;
	}


	// checks to make sure the device has a flash,
	// displays an AlertDialog and quit the app if not
	private void _checkIfCameraHasFlash(){
		boolean hasFlash = _main.getApplicationContext()
				.getPackageManager()
				.hasSystemFeature(PackageManager.FEATURE_CAMERA_FLASH);

		if(!hasFlash){
			AlertDialog alertDialog = new AlertDialog.Builder(_main).create();
			alertDialog.setTitle("Error");
			alertDialog.setMessage("Your device doesn't support FlashLight");
			alertDialog.setButton(DialogInterface.BUTTON_POSITIVE, "Dismiss", new DialogInterface.OnClickListener() {
				@Override
				public void onClick(DialogInterface dialogInterface, int i) {
					// close the app gracefully
					_main.finish();
				}
			});

			alertDialog.show();

			_main.getTtmFragment().cancelSending();
		}
	}

	// get the camera device and the parameters
	private void _getCamera(){
		if (_camera == null){
			try {
				_camera = Camera.open();
			}catch (RuntimeException e){
				e.printStackTrace();
				L.e(TAG, "Camera Error : Couldn't get the camera, it may be used by another app !");
				L.e(TAG, "Camera Error : " + e.getMessage());
			}
		}
	}

	// checks for flash and gets the camera device
	//
	// usefull in an onCreate, onCreateView or onResume methods
	void initCamera(){
		_checkIfCameraHasFlash();
		_getCamera();
	}

	// releases the camera and resets the
	// camera & parameters fields to null
	//
	// usefull in an onPause or onStop methods
	void releaseCamera(){
		if (_camera != null){
			_camera.release();
			_camera = null;
			_parameters = null;
		}
	}

	// inner class representing just the light torch
	class FlashLight{

		// turn the light ON
		void lightOn(){

			// if light is off and there is a camera object
			if(!isFlashOn && _camera != null){

				_parameters = _camera.getParameters();
				_parameters.setFlashMode(Camera.Parameters.FLASH_MODE_TORCH);

				_camera.setParameters(_parameters);
				_camera.startPreview();

				isFlashOn = true;
			}
		}


		// turn the light OFF
		void lightOff(){

			// if light is on and there is a camera object
			if (isFlashOn && _camera != null){

				_parameters = _camera.getParameters();
				_parameters.setFlashMode(Camera.Parameters.FLASH_MODE_OFF);

				_camera.setParameters(_parameters);
				_camera.stopPreview();

				isFlashOn = false;
			}
		}
	}
}

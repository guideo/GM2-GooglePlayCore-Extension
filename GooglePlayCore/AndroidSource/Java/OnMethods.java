/**
* Thanks to Glim888 for providing the base for this class
* Check it out on his GIT https://github.com/Glim888/ActivityEvents
*/
package ${YYAndroidPackageName};

import ${YYAndroidPackageName}.RunnerActivity;
import com.yoyogames.runner.RunnerJNILib;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.content.Intent;
import android.content.res.Configuration;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.app.Dialog;
import android.view.MotionEvent;

public class OnMethods implements IExtensionBase {

    public void onRestart() {
        // Do Nothing
    }

    public void onStart() {
        // Do Nothing
    }

    public void onResume() {
        // Do Nothing
    }

    public void onPause() {
        // Do Nothing
    }

    public void onStop() {
        // Do Nothing
    }

    public void onDestroy() {
       // Do Nothing
    }

    public void onConfigurationChanged(Configuration newConfig) {
        // Do Nothing
    }

    public void onRequestPermissionsResult(int requestCode, String permissions[], int[] grantResults) {
        // Do Nothing
    }

    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        // Do Nothing
    }

    public boolean onKeyLongPress(int keyCode, KeyEvent event) {
        return false;
    }

    public void onWindowFocusChanged(boolean hasFocus) {
        // Do Nothing
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        return false;
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        return false;
    }

    public boolean onKeyDown(int keyCode, KeyEvent event) {
        return false;
    }

    public boolean onKeyUp(int keyCode, KeyEvent event) {
        return false;
    }

    public Dialog onCreateDialog(int id) {
        return null;
    }

    public boolean onTouchEvent(final MotionEvent event) {
        return false;
    }

    public boolean onGenericMotionEvent(MotionEvent event) {
        return false;
    }

    public boolean dispatchGenericMotionEvent(MotionEvent event) {
        return false;
    }

    public boolean dispatchKeyEvent(KeyEvent event) {
        return false;
    }

}
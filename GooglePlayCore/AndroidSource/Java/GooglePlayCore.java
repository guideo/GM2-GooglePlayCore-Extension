package ${YYAndroidPackageName};

//Import Game Maker classes
import ${YYAndroidPackageName}.RunnerActivity;
import com.yoyogames.runner.RunnerJNILib;

import ${YYAndroidPackageName}.R;


// App Update
import com.google.android.play.core.appupdate.AppUpdateManager;
import com.google.android.play.core.appupdate.AppUpdateManagerFactory;
import com.google.android.play.core.appupdate.AppUpdateInfo;
import com.google.android.play.core.install.model.UpdateAvailability;
import com.google.android.play.core.install.model.AppUpdateType;
import com.google.android.play.core.tasks.OnSuccessListener;
import com.google.android.play.core.tasks.Task;
import android.content.IntentSender;

// App Review
import com.google.android.play.core.review.ReviewInfo;
import com.google.android.play.core.review.ReviewManager;
import com.google.android.play.core.review.ReviewManagerFactory;
import com.google.android.play.core.tasks.OnCompleteListener;


import android.util.Log;

public class GooglePlayCore extends OnMethods {
    
    private static final int GooglePlayCore_AsyncEvent = 7001;
    private static final int APP_IMMEDIATE_UPDATE_REQUEST_CODE = 6001;
    private static final int APP_FLEXIBLE_UPDATE_REQUEST_CODE = 6002;
    private static final AppUpdateManager appUpdateManager = AppUpdateManagerFactory.create(RunnerActivity.CurrentActivity.getApplicationContext());
    private AppUpdateInfo mAppImmediateUpdateInfo = null;
    private AppUpdateInfo mAppFlexibleUpdateInfo = null;
    
    private static final ReviewManager reviewManager = ReviewManagerFactory.create(RunnerActivity.CurrentActivity.getApplicationContext());
    private ReviewInfo mReviewInfo = null;
    
    private static final int EVENT_OTHER_SOCIAL = 70;
    
    public void playcore_check_for_update() {
        //Log.d("yoyo_playcore_update_extension", "playcore_check_for_update");
        Task<AppUpdateInfo> appUpdateInfoTask = appUpdateManager.getAppUpdateInfo();

        appUpdateInfoTask.addOnSuccessListener(new OnSuccessListener<AppUpdateInfo>() {
            @Override
            public void onSuccess(AppUpdateInfo appUpdateInfo) {
                if (appUpdateInfo.updateAvailability() == UpdateAvailability.DEVELOPER_TRIGGERED_UPDATE_IN_PROGRESS) {
                    // If update started before, and is now in progress, resume it
                    mAppImmediateUpdateInfo = appUpdateInfo;
                    requestImmediateUpdate();
                }
                if (appUpdateInfo.updateAvailability() == UpdateAvailability.UPDATE_AVAILABLE 
                    && appUpdateInfo.isUpdateTypeAllowed(AppUpdateType.IMMEDIATE)) {
                        mAppImmediateUpdateInfo = appUpdateInfo;
                }
                if (appUpdateInfo.updateAvailability() == UpdateAvailability.UPDATE_AVAILABLE 
                    && appUpdateInfo.isUpdateTypeAllowed(AppUpdateType.FLEXIBLE)) {
                        mAppFlexibleUpdateInfo = appUpdateInfo;
                }
                if (appUpdateInfo.updateAvailability() == UpdateAvailability.UPDATE_AVAILABLE) {
                    onUpdateAvailable();
                }
            }
        });
    }
    
    public void playcore_show_update_prompt() {
        //Log.d("yoyo_playcore_update_extension", "playcore_show_update_prompt");
        // TODO Adapt to either call immediate or flexible update.
        //  Only immediate update is supported now
        requestImmediateUpdate();
	}
    
    public void playcore_check_for_review() {
        Task<ReviewInfo> request = reviewManager.requestReviewFlow();
        request.addOnCompleteListener(new OnCompleteListener<ReviewInfo>() {
            @Override
            public void onComplete(Task<ReviewInfo> task) {
                if (task.isSuccessful()) {
                    mReviewInfo = task.getResult();
                    onReviewAvailable();
                }
            }
        });
    }
    
    public void playcore_show_review_prompt() {
        Task<Void> flow = reviewManager.launchReviewFlow(RunnerActivity.CurrentActivity, mReviewInfo);
        flow.addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(Task<Void> task) {
                // The flow has finished. The API does not indicate whether the user
                // reviewed or not, or even whether the review dialog was shown. Thus, no
                // matter the result, we continue our app flow.
                onReviewCompleted();
            }
        });
    }
    
    public void onUpdateAvailable() {
        //Log.d("yoyo_playcore_update_extension", "onUpdateAvailable");
        int dsMapIndex = RunnerJNILib.jCreateDsMap(null, null, null);
        RunnerJNILib.DsMapAddString(dsMapIndex, "type", "update_available");
        if (mAppImmediateUpdateInfo != null) {
            RunnerJNILib.DsMapAddString(dsMapIndex, "immediate_update", "true");
        }
        if (mAppFlexibleUpdateInfo != null) {
            RunnerJNILib.DsMapAddString(dsMapIndex, "flexible_update", "true");
        }
        RunnerJNILib.DsMapAddDouble(dsMapIndex, "id", GooglePlayCore_AsyncEvent);
        RunnerJNILib.CreateAsynEventWithDSMap(dsMapIndex, EVENT_OTHER_SOCIAL);
    }
    
    public void requestImmediateUpdate() {
        //Log.d("yoyo_playcore_update_extension", "requestImmediateUpdate");
        try {
            appUpdateManager.startUpdateFlowForResult(mAppImmediateUpdateInfo,
                                                      AppUpdateType.IMMEDIATE,
                                                      RunnerActivity.CurrentActivity,
                                                      APP_IMMEDIATE_UPDATE_REQUEST_CODE);
        } catch (IntentSender.SendIntentException e) {
            Log.e("yoyo_playcore_update_extension", "Failed to start immediate update flow");
            e.printStackTrace();
        }
    }
    
    public void requestFlexibleUpdate() {
        // TODO This is not properly implemented
        //  Still need to handle the update progress and installation properly,
        //  according to https://developer.android.com/guide/playcore/in-app-updates#flexible_flow
        //Log.d("yoyo_playcore_update_extension", "requestImmediateUpdate");
        try {
            appUpdateManager.startUpdateFlowForResult(mAppFlexibleUpdateInfo,
                                                      AppUpdateType.FLEXIBLE,
                                                      RunnerActivity.CurrentActivity,
                                                      APP_FLEXIBLE_UPDATE_REQUEST_CODE);
        } catch (IntentSender.SendIntentException e) {
            Log.e("yoyo_playcore_update_extension", "Failed to start flexible update flow");
            e.printStackTrace();
        }
    }
    
    public void onReviewAvailable() {
        int dsMapIndex = RunnerJNILib.jCreateDsMap(null, null, null);
        RunnerJNILib.DsMapAddString(dsMapIndex, "type", "review_available");
        RunnerJNILib.DsMapAddDouble(dsMapIndex, "id", GooglePlayCore_AsyncEvent);
        RunnerJNILib.CreateAsynEventWithDSMap(dsMapIndex, EVENT_OTHER_SOCIAL);
    }
    
    public void onReviewCompleted() {
        int dsMapIndex = RunnerJNILib.jCreateDsMap(null, null, null);
        RunnerJNILib.DsMapAddString(dsMapIndex, "type", "review_completed");
        RunnerJNILib.DsMapAddDouble(dsMapIndex, "id", GooglePlayCore_AsyncEvent);
        RunnerJNILib.CreateAsynEventWithDSMap(dsMapIndex, EVENT_OTHER_SOCIAL);
    }
    
    @Override
    public void onResume() {
        //Log.d("yoyo_playcore_update_extension", "onResume");
        playcore_check_for_update();
    }
    
}
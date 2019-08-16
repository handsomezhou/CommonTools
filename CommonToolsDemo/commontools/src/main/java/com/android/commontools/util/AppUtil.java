package com.android.commontools.util;

import android.annotation.TargetApi;
import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.net.Uri;
import android.os.Build;
import android.provider.Settings;
import android.text.TextUtils;

import java.util.List;

/**
 * Created by zhoujq.
 */

public class AppUtil {
	private static final String TAG = "AppUtil";
	/**
	 * Return true when start app success,otherwise return false.
	 * @param context
	 * @param packageName
	 * @return
	 */
	public static boolean startApp(Context context,String packageName){
		boolean startAppSuccess=false;
		do{
			if((null==context)||TextUtils.isEmpty(packageName)){
				break;
			}
			
			PackageManager pm=context.getPackageManager();
			Intent intent=pm.getLaunchIntentForPackage(packageName);
			
			if(null!=intent){
				context.startActivity(intent);
				startAppSuccess=true;
			}
		}while(false);
		
		
		return startAppSuccess;
	}

	/**
	 * @param context
	 * @param packageName
	 * @param cls
	 * @return
	 */

	public static boolean startApp(Context context, String packageName, String cls) {
		boolean startAppSuccess = false;
		do {
			if ((null == context) || TextUtils.isEmpty(packageName)) {
				break;
			}
			ComponentName componet = new ComponentName(packageName, cls);
			Intent intent = createLaunchIntent(componet);
			if (context.getPackageManager().getLaunchIntentForPackage(
					packageName) != null) {
				context.startActivity(intent);
				startAppSuccess = true;
			}
			else {
				System.out.println("app not found");
			}
		} while (false);

		return startAppSuccess;
	}

	/**
	 * whether app can Launch the main activity.
	 * Return true when can Launch,otherwise return false.
	 * @param context
	 * @param packageName
	 * @return
	 */
	public static boolean appCanLaunchTheMainActivity(Context context,String packageName){
		boolean canLaunchTheMainActivity=false;
		do{
			if((null==context)||TextUtils.isEmpty(packageName)){
				break;
			}
			
			PackageManager pm=context.getPackageManager();
			Intent intent=pm.getLaunchIntentForPackage(packageName);
			canLaunchTheMainActivity=(null==intent)?(false):(true);
		}while(false);
		
		return canLaunchTheMainActivity;
	} 
	
	/**
	 * uninstall app via package name
	 * @param context
	 * @param packageName
	 */
	public static void uninstallApp(Context context,String packageName){
		Uri packageUri = Uri.parse("package:" + packageName);  
		Intent intent = new Intent();  
		intent.setAction(Intent.ACTION_DELETE);  
		intent.setData(packageUri);  
		context.startActivity(intent);  
	}

	/**
	 * get version name
	 *
	 * @param context
	 * @return
     */
	public static String getVersionName(Context context){
		String versionName=null;
		do{
			if(null==context){
				break;
			}

			versionName=getVersionName(context,context.getPackageName());
		}while (false);
		return versionName;
	}

	/**
	 * get version name via package name
	 * @param context
	 * @param packageName
	 * @return
	 */
	public static String getVersionName(Context context,String packageName){
		String versionName=null;
		do{
			if((null==context)||TextUtils.isEmpty(packageName)){
				break;
			}
			PackageManager pm=context.getPackageManager();
			try {
				PackageInfo pi=pm.getPackageInfo(packageName, 0);
				versionName=pi.versionName;
			} catch (NameNotFoundException e) {
				
				e.printStackTrace();
				break;
			}
			
			
		}while(false);
		
		return versionName;
	}

	/**
	 *  get version code
	 * @param context
	 * @return
     */
	public static int getVersionCode(Context context){
		int versionCode=0;

		do{
			if(null==context){
				break;
			}

			versionCode=getVersionCode(context,context.getPackageName());

		}while (false);

		return versionCode;
	}

	/**
	 * get version code via package name
	 * @param context
	 * @param packageName
     * @return
     */
	public static int getVersionCode(Context context,String packageName){
		int versionCode=0;
		do{
			if((null==context)||TextUtils.isEmpty(packageName)){
				break;
			}
			PackageManager pm=context.getPackageManager();
			try {
				PackageInfo pi=pm.getPackageInfo(packageName, 0);
				versionCode=pi.versionCode;
			} catch (NameNotFoundException e) {

				e.printStackTrace();
				break;
			}


		}while(false);

		return versionCode;
	}
	
	/**
	 * 
	 * @param context
	 * @param packageName
	 * @return app exist return true,otherwise return false.
	 */
	public static boolean isAppExist(Context context,String packageName) {
		boolean appExist=false;
		do{
			if(TextUtils.isEmpty(packageName)){
				break;
			}
			
			PackageManager pm = context.getPackageManager();
			List<PackageInfo> packageInfos = pm.getInstalledPackages(0);
			for (PackageInfo pi : packageInfos) {
				if (packageName.equalsIgnoreCase(pi.packageName)){
					appExist=true;
					break;
				}
			}
			
		}while(false);
		
		return  appExist;
	}

	public static ApplicationInfo getApplicationInfo(Context context,String packageName){
		ApplicationInfo applicationInfo=null;

		PackageInfo packageInfo=AppUtil.getPackageInfo(context,packageName);
		if(null!=packageInfo){
			applicationInfo=packageInfo.applicationInfo;
		}

		return applicationInfo;
	}

	public static PackageInfo getPackageInfo(Context context,String packageName){
		PackageInfo packageInfo=null;

		do{
			if(null==context){
				break;
			}

			if(CommonUtil.isEmpty(packageName)){
				break;
			}

			PackageManager pm = context.getPackageManager();
			List<PackageInfo> packageInfos = pm.getInstalledPackages(0);
			for (PackageInfo pi : packageInfos) {
				if (packageName.equalsIgnoreCase(pi.packageName)){
					packageInfo=pi;
					break;
				}
			}

		}while (false);

		return packageInfo;
	}

	/**
	 *
	 * @param context
	 * @param packageName
	 * @return
	 */
	public static String getAppName(Context context,String packageName){
		String appName=null;
		do{
			PackageInfo packageInfo=AppUtil.getPackageInfo(context,packageName);
			if(null==packageInfo){
				break;
			}

			PackageManager pm = context.getPackageManager();
			appName = String.valueOf(pm.getApplicationLabel(packageInfo.applicationInfo));
			if(false==CommonUtil.isEmpty(appName)){
				break;
			}

			appName = packageInfo.packageName;

		}while (false);

		return appName;
	}

	public static Intent createLaunchIntent(ComponentName componentName) {
		Intent intent = new Intent(Intent.ACTION_MAIN);
		intent.addCategory(Intent.CATEGORY_LAUNCHER);
		intent.setComponent(componentName);
		intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK
				| Intent.FLAG_ACTIVITY_RESET_TASK_IF_NEEDED);
		return intent;
	}

	@TargetApi(Build.VERSION_CODES.GINGERBREAD)
	public static void viewApp(Context context, String packageName) {
		Intent intent = new Intent();
		intent.setAction(Settings.ACTION_APPLICATION_DETAILS_SETTINGS);
		intent.setData(Uri.parse("package:" + packageName));
		intent.putExtra("cmp", "com.android.settings/.applications.InstalledAppDetails");
		intent.addCategory("android.intent.category.DEFAULT");
		context.startActivity(intent);
	}

	 /**
	  * 
	  * @param context
	  * @return
	  */
	 public static boolean isBackground(Context context) {  
	        ActivityManager activityManager = (ActivityManager) context.getSystemService(Context.ACTIVITY_SERVICE);  
	        List<RunningAppProcessInfo> appProcesses = activityManager.getRunningAppProcesses();
	        for (RunningAppProcessInfo appProcess : appProcesses) {  
	            if (appProcess.processName.equals(context.getPackageName())) {  
	                /* 
	                BACKGROUND=400 EMPTY=500 FOREGROUND=100 
	                GONE=1000 PERCEPTIBLE=130 SERVICE=300 ISIBLE=200 
	                 */  
	               /* Log.i(context.getPackageName(), "此appimportace ="  
	                        + appProcess.importance  
	                        + ",context.getClass().getName()="  
	                        + context.getClass().getName());  */
	                if (appProcess.importance != RunningAppProcessInfo.IMPORTANCE_FOREGROUND) {  
	                    //Log.i(context.getPackageName(), "处于后台"   + appProcess.processName);  
	                    return true;  
	                } else {  
	                    //Log.i(context.getPackageName(), "处于前台"  + appProcess.processName);  
	                    return false;  
	                }

	            }  
	        }  
	        return false;  
	    }



}

package com.cboadz.app.cboardzsuperadmin.Utils;

import android.app.Activity;
import android.app.Dialog;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.os.Parcelable;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;

import com.cboadz.app.cboardzsuperadmin.R;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AlertUtility {

	public static void exit(final Activity activity)
	{
		final Dialog openDialog = new Dialog(activity);
		openDialog.setContentView(R.layout.customdialogue);
		openDialog.setTitle("Alert");
		TextView dialogTextContent = (TextView)openDialog.findViewById(R.id.msg);
		dialogTextContent.setText("Do you want to close the app ?");
		Button pstveButton = (Button)openDialog.findViewById(R.id.yes);
		Button ngtvButton = (Button)openDialog.findViewById(R.id.no);
		ngtvButton.setOnClickListener(new View.OnClickListener(){
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				openDialog.dismiss();
			}
		});
		pstveButton.setOnClickListener(new View.OnClickListener(){
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				activity.finish();
			}
		});
		WindowManager.LayoutParams lp = new WindowManager.LayoutParams();
		lp.copyFrom(openDialog.getWindow().getAttributes());
		lp.width = WindowManager.LayoutParams.MATCH_PARENT;
		lp.height = WindowManager.LayoutParams.WRAP_CONTENT;
		openDialog.show();
		openDialog.getWindow().setAttributes(lp);
	}
	public static boolean isValidEmail(String email) {
		boolean isValid = false;
		String ex = "^([a-zA-Z0-9_\\.\\-])+([+_a-zA-Z0-9])+\\@(([a-zA-Z0-9\\-])+\\.)([a-zA-Z0-9]{2,3})([a-zA-Z0-9.]{3})?$";
		CharSequence inputStr = email;

		Pattern pattern = Pattern.compile(ex, Pattern.CASE_INSENSITIVE);
		Matcher matcher = pattern.matcher(inputStr);
		if (matcher.matches()) {
			isValid = true;
		}
		if (email.contains(".com.com") || email.contains("com.co")||email.contains(".com.com.com")) {
			isValid = false;
		}
		return isValid;

	}

	public static boolean isValidPassword(String pass) {
        if (pass != null && pass.length() > 3) {
            return true;
        }
        return false;
    }

	/* IMAGE SHARING ALL  APPLICATIONS */
	public static void sharingAll(Context mMontext, ArrayList<String> packages, String setType, String subject, String body, String text, String sharingapp) {
		if(packages==null || packages.size()==0) {
			Intent sharingIntent = new Intent(android.content.Intent.ACTION_SEND);
			sharingIntent.setType(setType);
			sharingIntent.putExtra(android.content.Intent.EXTRA_SUBJECT,subject ); //subject Here
			sharingIntent.putExtra(android.content.Intent.EXTRA_TEXT, body);
			mMontext.startActivity(Intent.createChooser(sharingIntent, sharingapp)); //Share via
		}else
		{
			List<Intent> targetShareIntents = new ArrayList<Intent>();
			Intent shareIntent = new Intent();
			shareIntent.setAction(Intent.ACTION_SEND);
			shareIntent.setType(setType);
			List<ResolveInfo> resInfos = mMontext.getPackageManager().queryIntentActivities(shareIntent, 0);
			if (!resInfos.isEmpty()) {
				for (ResolveInfo resInfo : resInfos) {
					String packageName = resInfo.activityInfo.packageName;
					for (int i=0;i<packages.size();i++)
					{
						if (packages.get(i).contains(packageName)) {
							Intent intent = new Intent();
							intent.setComponent(new ComponentName(packageName, resInfo.activityInfo.name));
							intent.setAction(Intent.ACTION_SEND);
							intent.setType(setType);
							intent.putExtra(Intent.EXTRA_TEXT, text);
							intent.putExtra(Intent.EXTRA_SUBJECT, subject);
							intent.setPackage(packageName);
							targetShareIntents.add(intent);
						}
					}

				}
				if (!targetShareIntents.isEmpty()) {
					Intent chooserIntent = Intent.createChooser(targetShareIntents.remove(0),sharingapp );//Share via Choose app to share
					chooserIntent.putExtra(Intent.EXTRA_INITIAL_INTENTS, targetShareIntents.toArray(new Parcelable[]{}));
					mMontext.startActivity(chooserIntent);
				} else {

				}
			}
		}

	}
}

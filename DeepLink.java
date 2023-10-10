package com.apphelper.DeepLink;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.app.Activity;
import com.google.appinventor.components.runtime.ComponentContainer;
import com.google.appinventor.components.annotations.SimpleObject;
import com.google.appinventor.components.annotations.androidmanifest.DataElement;
import com.google.appinventor.components.annotations.androidmanifest.CategoryElement;
import com.google.appinventor.components.annotations.androidmanifest.ActionElement;
import com.google.appinventor.components.annotations.androidmanifest.IntentFilterElement;
import com.google.appinventor.components.annotations.androidmanifest.ActivityElement;
import com.google.appinventor.components.annotations.UsesActivities;
import com.google.appinventor.components.common.ComponentCategory;
import com.google.appinventor.components.annotations.DesignerComponent;
import com.google.appinventor.components.runtime.AndroidNonvisibleComponent;

@DesignerComponent(version = 2, description = "You can add deeplink system in you app.<br><br><b>What's New In V2</b><br>Fixed DeepLink Crashing Problem Of Some Devices.<br><br><a href = \"https://www.youtube.com/channel/UC28bZDjE9qnc_8Yz1gN1MJw\" target = \"_blank\">App Helper Youtube Channel</a>", category = ComponentCategory.EXTENSION, nonVisible = true, iconName = "https://yt3.ggpht.com/ytc/AKedOLQL9YZihdn71lieTeqiZnMYFHECKhuKBnseov9t=s88-c-k-c0x00ffffff-no-rj")
@UsesActivities(activities = { @ActivityElement(intentFilters = { @IntentFilterElement(actionElements = { @ActionElement(name = "android.intent.action.VIEW") }, categoryElements = { @CategoryElement(name = "android.intent.category.DEFAULT"), @CategoryElement(name = "android.intent.category.BROWSABLE") }, dataElements = { @DataElement(scheme = "https", host = "yourwebsitelink.com"), @DataElement(scheme = "https", host = "www.yourwebsitelink.com"), @DataElement(scheme = "http", host = "yourwebsitelink.com"), @DataElement(scheme = "http", host = "www.yourwebsitelink.com") }) }, name = "com.apphelper.DeepLink.DeepLink$DeepLinkActivity") })
@SimpleObject(external = true)
public final class DeepLink extends AndroidNonvisibleComponent
{
    public DeepLink(final ComponentContainer componentContainer) {
        super(componentContainer.$form());
    }
    
    public static class DeepLinkActivity extends Activity
    {
        protected void onCreate(final Bundle bundle) {
            super.onCreate(bundle);
            final Uri data = this.getIntent().getData();
            if (data != null && data.toString() != null) {
                final Intent launchIntentForPackage = this.getPackageManager().getLaunchIntentForPackage(this.getPackageName());
                launchIntentForPackage.putExtra("APP_INVENTOR_START", '\"' + data.toString() + '\"');
                this.startActivity(launchIntentForPackage);
                this.finish();
            }
        }
    }
}

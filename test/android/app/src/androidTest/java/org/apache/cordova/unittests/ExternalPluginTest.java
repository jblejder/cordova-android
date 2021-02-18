/*
       Licensed to the Apache Software Foundation (ASF) under one
       or more contributor license agreements.  See the NOTICE file
       distributed with this work for additional information
       regarding copyright ownership.  The ASF licenses this file
       to you under the Apache License, Version 2.0 (the
       "License"); you may not use this file except in compliance
       with the License.  You may obtain a copy of the License at

         http://www.apache.org/licenses/LICENSE-2.0

       Unless required by applicable law or agreed to in writing,
       software distributed under the License is distributed on an
       "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
       KIND, either express or implied.  See the License for the
       specific language governing permissions and limitations
       under the License.
*/

package org.apache.cordova.unittests;

import android.content.Intent;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.view.View;

import org.apache.cordova.engine.SystemWebView;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static junit.framework.Assert.assertEquals;

@RunWith(AndroidJUnit4.class)
public class ExternalPluginTest {

    private static final String FALSE_URI = "http://www.google.com";

    @Rule
    public ActivityTestRule mActivityRule = new ActivityTestRule<>(
            ExternalPluginActivity.class, true, false
    );

    @Before
    public void launchApplicationWithIntent() {
        Intent intent = new Intent();
        mActivityRule.launchActivity(intent);
    }


    @Test
    public void webViewCheck() {
        ExternalPluginActivity activity = (ExternalPluginActivity) mActivityRule.getActivity();
        //Fish the webview out of the mostly locked down Activity using the Android SDK
        View view = activity.getWindow().getCurrentFocus();
        assertEquals(SystemWebView.class, view.getClass());
    }

}

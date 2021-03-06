package com.honeywell.hch.airtouch.ui.emotion.manager;

import android.os.Bundle;

import com.honeywell.hch.airtouch.library.http.model.IActivityReceive;
import com.honeywell.hch.airtouch.library.http.model.RequestID;
import com.honeywell.hch.airtouch.library.http.model.ResponseResult;
import com.honeywell.hch.airtouch.plateform.http.MockWebService;
import com.honeywell.hch.airtouch.plateform.http.model.authorize.model.response.GetAuthMessagesResponse;
import com.honeywell.hch.airtouch.plateform.http.model.user.response.EmotionBottleResponse;
import com.honeywell.hch.airtouch.ui.authorize.manager.BaseManagerFunctionTest;

import junit.framework.Assert;

/**
 * Created by Vincent on 11/11/16.
 */
public class GetPmLevelFromServerTest extends BaseManagerFunctionTest {

    private EmotionManager mEmotionManager;
    private EmotionUiManager mEmotionUiManager;
    private MockWebService mWebService;


    private RequestID mRequestId;
    private boolean mResult;
    private int mResponseCode;

    private ResponseResult mResponseResult;
    private Bundle mBundle;

    public GetPmLevelFromServerTest(EmotionUiManager emotionUiManager, MockWebService webService, EmotionManager emotionManager) {
        mEmotionUiManager = emotionUiManager;
        mWebService = webService;
        mEmotionManager = emotionManager;
    }

    public void testSuccessGetPmLevelFromServer() {

        mResult = true;
        mResponseCode = 200;
        mRequestId = RequestID.CONTROL_DEVICE;
        mResponseResult = new ResponseResult(mResult, mResponseCode, "", mRequestId);
        mBundle = new Bundle();
        mBundle.putInt(EmotionBottleResponse.EMOTION_RESP_DATA, mResponseCode);
        mResponseResult.setResponseData(mBundle);

        //test login success
        setReloginSuccess();
        mEmotionManager.mResponse = new IActivityReceive() {
            @Override
            public void onReceive(ResponseResult responseResult) {
                Assert.assertEquals(mRequestId, responseResult.getRequestId());
                Assert.assertEquals(mResult, responseResult.isResult());
                Assert.assertEquals(mResponseCode, responseResult.getResponseCode());
            }
        };
        mWebService.setResponseResult(mResponseResult);
        if (mEmotionUiManager != null) {
            mEmotionUiManager.getPMLevelFromServer(123);
        } else {
            mEmotionManager.getPMLevelFromServer(2323, 123);
        }
    }


    public void testFailGetPmLevelFromServer() {

        mResult = false;
        mResponseCode = 200;
        mRequestId = RequestID.CONTROL_DEVICE;
        ResponseResult responseResult = new ResponseResult(mResult, mResponseCode, "", mRequestId);

        //test login success
        setReloginSuccess();
        mEmotionManager.mResponse = new IActivityReceive() {
            @Override
            public void onReceive(ResponseResult responseResult) {
                Assert.assertEquals(false, responseResult.isResult());
            }
        };
        mWebService.setResponseResult(responseResult);
        if (mEmotionUiManager != null) {
            mEmotionUiManager.getPMLevelFromServer(123);
        } else {
            mEmotionManager.getPMLevelFromServer(2323, 123);
        }

    }

    public void testLoginFailWhenGetPmLevelFromServer() {

        ResponseResult responseResult = new ResponseResult(mResult, mResponseCode, "", mRequestId);

        //test login success
        setReloginFail();
        mEmotionManager.mResponse = new IActivityReceive() {
            @Override
            public void onReceive(ResponseResult responseResult) {
                Assert.assertEquals(false, responseResult.isResult());

            }
        };
        mWebService.setResponseResult(responseResult);
        if (mEmotionUiManager != null) {
            mEmotionUiManager.getPMLevelFromServer(123);
        } else {
            mEmotionManager.getPMLevelFromServer(2323, 123);
        }

    }

}

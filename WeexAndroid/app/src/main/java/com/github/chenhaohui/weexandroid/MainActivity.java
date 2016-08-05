package com.github.chenhaohui.weexandroid;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;

import com.taobao.weex.IWXRenderListener;
import com.taobao.weex.WXSDKInstance;
import com.taobao.weex.common.WXRenderStrategy;

public class MainActivity extends AppCompatActivity {

    private WXSDKInstance wxsdkInstance;
    private final String JsPath = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        wxsdkInstance = new WXSDKInstance(this);
        wxsdkInstance.registerRenderListener(new RenderListener());

        wxsdkInstance.renderByUrl("index",JsPath,null,null,-1,-1, WXRenderStrategy.APPEND_ASYNC);
    }

    @Override
    protected void onResume() {
        super.onResume();
        if (null != wxsdkInstance){
            wxsdkInstance.onActivityResume();
        }
    }

    @Override
    protected void onPause() {
        super.onPause();
        if (null != wxsdkInstance){
            wxsdkInstance.onActivityPause();
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (null != wxsdkInstance){
            wxsdkInstance.onActivityDestroy();
        }
    }

    @Override
    protected void onStart() {
        super.onStart();
        if (null != wxsdkInstance){
            wxsdkInstance.onActivityStart();
        }
    }

    @Override
    protected void onStop() {
        super.onStop();
        if (null != wxsdkInstance){
            wxsdkInstance.onActivityStop();
        }
    }

    class RenderListener implements IWXRenderListener{
        @Override
        public void onViewCreated(WXSDKInstance instance, View view) {
            //添加到视图中
            ((FrameLayout)MainActivity.this.findViewById(R.id.root)).addView(view);
        }

        @Override
        public void onRenderSuccess(WXSDKInstance instance, int width, int height) {

        }

        @Override
        public void onRefreshSuccess(WXSDKInstance instance, int width, int height) {

        }

        @Override
        public void onException(WXSDKInstance instance, String errCode, String msg) {

        }
    }
}

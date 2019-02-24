package soexample.bigfly.com.myweekdemo.mvp.moudle;

import com.google.gson.Gson;

import soexample.bigfly.com.myweekdemo.mvp.mycallback.MyCallBack;
import soexample.bigfly.com.myweekdemo.utils.Retrofits;
import soexample.bigfly.com.myweekdemo.utils.RetrofitUtils;

/**
 * <p>文件描述：<p>
 * <p>作者：${吕飞}<p>
 * <p>创建时间：2019/2/23   18:17<p>
 * <p>更改时间：2019/2/23   18:17<p>
 * <p>版本号：1<p>
 */

public class MyMoudleImpl implements MyMoudle {
    @Override
    public void startRequest(String url, final Class clazz, final MyCallBack myCallBack) {

        RetrofitUtils.getInstance().get(url, new RetrofitUtils.setHttpListener() {
            @Override
            public void success(Object data) {
                Gson gson = new Gson();
                Object o = gson.fromJson((String) data, clazz);
                myCallBack.setData(o);
            }

            @Override
            public void error(Object error) {
                myCallBack.setError(error);
            }
        });


    }

    @Override
    public void startOk(String url, final Class clazz, final MyCallBack myCallBack) {
        Retrofits.getInstance().get(url, new Retrofits.setHttpListener() {
            @Override
            public void success(Object data) {
                Gson gson = new Gson();
                Object o = gson.fromJson((String) data, clazz);
                myCallBack.setData(o);
            }

            @Override
            public void error(Object error) {
                myCallBack.setError(error);
            }
        });
    }

}

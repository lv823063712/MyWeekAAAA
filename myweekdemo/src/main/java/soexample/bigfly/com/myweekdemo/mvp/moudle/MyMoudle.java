package soexample.bigfly.com.myweekdemo.mvp.moudle;

import soexample.bigfly.com.myweekdemo.mvp.mycallback.MyCallBack;

/**
 * <p>文件描述：<p>
 * <p>作者：${吕飞}<p>
 * <p>创建时间：2019/2/23   18:13<p>
 * <p>更改时间：2019/2/23   18:13<p>
 * <p>版本号：1<p>
 */

public interface MyMoudle {
    void startRequest(String url, Class clazz, MyCallBack myCallBack);
    void startOk(String url,Class clazz,  MyCallBack myCallBack);
}

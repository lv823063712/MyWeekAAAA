package soexample.bigfly.com.myweekdemo.mvp.ipresenter;

import soexample.bigfly.com.myweekdemo.mvp.iview.IView;
import soexample.bigfly.com.myweekdemo.mvp.moudle.MyMoudle;
import soexample.bigfly.com.myweekdemo.mvp.moudle.MyMoudleImpl;
import soexample.bigfly.com.myweekdemo.mvp.mycallback.MyCallBack;

/**
 * <p>文件描述：<p>
 * <p>作者：${吕飞}<p>
 * <p>创建时间：2019/2/23   18:21<p>
 * <p>更改时间：2019/2/23   18:21<p>
 * <p>版本号：1<p>
 */

public class IPresenterImpl implements IPresenter {
    private IView iView;
    private MyMoudleImpl myMoudle;

    public IPresenterImpl(IView iView) {
        this.iView = iView;
        myMoudle = new MyMoudleImpl();
    }

    @Override
    public void startRequest(String url, Class clazz) {
        myMoudle.startRequest(url, clazz, new MyCallBack() {
            @Override
            public void setData(Object data) {
                iView.success(data);
            }

            @Override
            public void setError(Object error) {
                iView.error(error);
            }
        });
    }

    @Override
    public void startOk(String url,Class clazz) {
        myMoudle.startOk(url,clazz, new MyCallBack() {
            @Override
            public void setData(Object data) {
                iView.success(data);
            }

            @Override
            public void setError(Object error) {
                iView.error(error);
            }
        });
    }

    //防止内存泄漏
    public void onDatach() {
        if (myMoudle != null) {
            myMoudle = null;
        }
        if (iView != null) {
            iView = null;
        }
    }
}

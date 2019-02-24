package soexample.bigfly.com.myweekdemo.mvp.mycallback;

/**
 * <p>文件描述：<p>
 * <p>作者：${吕飞}<p>
 * <p>创建时间：2019/2/23   18:14<p>
 * <p>更改时间：2019/2/23   18:14<p>
 * <p>版本号：1<p>
 */

public interface MyCallBack<T> {
    void setData(T data);

    void setError(T error);
}

package soexample.bigfly.com.myweekdemo.utils;

import android.util.Log;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.ResponseBody;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;
import soexample.bigfly.com.myweekdemo.utils.api.ApiService;
import soexample.bigfly.com.myweekdemo.utils.api.Constans;

/**
 * <p>文件描述：<p>
 * <p>作者：${吕飞}<p>
 * <p>创建时间：2019/2/23   17:25<p>
 * <p>更改时间：2019/2/23   17:25<p>
 * <p>版本号：1<p>
 */

public class Retrofits {

    private final ApiService apiService;

    private Retrofits() {
        HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor();
        loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .readTimeout(20, TimeUnit.SECONDS)
                .writeTimeout(20, TimeUnit.SECONDS)
                .connectTimeout(20, TimeUnit.SECONDS)
                .retryOnConnectionFailure(true)
                .build();

        retrofit2.Retrofit retrofit = new retrofit2.Retrofit.Builder()
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(Constans.BASE)
                .build();
        apiService = retrofit.create(ApiService.class);
    }

    //静态内部类
    //静态内部类
    public static Retrofits getInstance() {
        return ViewHolder.RETROFIT_UTILS;
    }

    private static class ViewHolder {
        private static final Retrofits RETROFIT_UTILS = new Retrofits();
    }

    //封装get
    public void get(String url, final setHttpListener httpListener) {
        apiService.get(url).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<ResponseBody>() {
                    @Override
                    public void onCompleted() {
                        Log.e("onCompleted", "get_onCompleted");
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.e("onError", "get_onError" + e.getMessage());
                        if (httpListener != null) {
                            httpListener.error(e.getMessage());
                        }
                    }

                    @Override
                    public void onNext(ResponseBody responseBody) {
                        // Log.d("onNext", "get_onNext");
                        if (httpListener != null) {
                            try {
                                httpListener.success(responseBody.string());
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                });
    }

    //接口回调
    public interface setHttpListener<T> {
        void success(T data);

        void error(T error);
    }

}

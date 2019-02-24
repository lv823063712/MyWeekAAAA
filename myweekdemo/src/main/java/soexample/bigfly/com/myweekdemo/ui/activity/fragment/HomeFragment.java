package soexample.bigfly.com.myweekdemo.ui.activity.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.stx.xhb.xbanner.XBanner;
import com.stx.xhb.xbanner.transformers.Transformer;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import soexample.bigfly.com.myweekdemo.MyAdapter;
import soexample.bigfly.com.myweekdemo.R;
import soexample.bigfly.com.myweekdemo.bean.CommodityListBean;
import soexample.bigfly.com.myweekdemo.bean.MyBannerData;
import soexample.bigfly.com.myweekdemo.bean.MyConData;
import soexample.bigfly.com.myweekdemo.bean.MyContentData;
import soexample.bigfly.com.myweekdemo.mvp.ipresenter.IPresenterImpl;
import soexample.bigfly.com.myweekdemo.mvp.iview.IView;
import soexample.bigfly.com.myweekdemo.ui.adapter.MyTestAdapter;
import soexample.bigfly.com.myweekdemo.utils.api.Constans;

/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment implements IView {

    @BindView(R.id.xbanner)
    XBanner xbanner;
    @BindView(R.id.MyRecy)
    RecyclerView MyRecy;
    Unbinder unbinder;
    @BindView(R.id.MyRexiao)
    RecyclerView MyRexiao;
    private IPresenterImpl iPresenter;
    private ArrayList<String> datas = new ArrayList<>();
    private List<MyContentData.ResultsBean> lists = new ArrayList<>();
    private ArrayList<CommodityListBean> da = new ArrayList<>();
    private MyAdapter myAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View inflate = inflater.inflate(R.layout.fragment_home, null);
        unbinder = ButterKnife.bind(this, inflate);

        iPresenter = new IPresenterImpl(this);
        iPresenter.startRequest(Constans.TOUTENG, MyBannerData.class);
        iPresenter.startOk(Constans.HAHAHA, MyContentData.class);
        iPresenter.startRequest(Constans.LOGIN, MyConData.class);
        GridLayoutManager manager = new GridLayoutManager(getActivity(), 3);
        MyRecy.setLayoutManager(manager);

        return inflate;
    }


    @Override
    public void success(Object data) {
        if (data instanceof MyBannerData) {
            final MyBannerData myBanner = (MyBannerData) data;
            //此处需要加判空,否则轮播图不出来
            List<MyBannerData.ResultBean> result = myBanner.getResult();
            for (int i = 0; i < myBanner.getResult().size(); i++) {
                datas.add(myBanner.getResult().get(i).getImageUrl());
            }
            if (!datas.isEmpty()) {
                xbanner.setData(myBanner.getResult(), null);
                xbanner.loadImage(new XBanner.XBannerAdapter() {
                    @Override
                    public void loadBanner(XBanner banner, Object model, View view, int position) {
                        Glide.with(getActivity()).load(myBanner.getResult().get(position).getImageUrl()).into((ImageView) view);
                    }
                });
                //设置样式，里面有很多种样式可以自己都看看效果
                xbanner.setPageTransformer(Transformer.Default);//横向移动
                xbanner.setPageTransformer(Transformer.Alpha); //渐变，效果不明显
                xbanner.setPageTransformer(Transformer.ZoomFade); // 缩小本页，同时放大另一页
                xbanner.setPageTransformer(Transformer.ZoomCenter); //本页缩小一点，另一页就放大
                xbanner.setPageTransformer(Transformer.ZoomStack); // 本页和下页同事缩小和放大
                xbanner.setPageTransformer(Transformer.Stack);  //本页和下页同时左移
                xbanner.setPageTransformer(Transformer.Depth);  //本页左移，下页从后面出来
                xbanner.setPageTransformer(Transformer.Zoom);  //本页刚左移，下页就在后面
                //  设置xbanner求换页面的时间
                xbanner.setPageChangeDuration(1000);
            }
        } else if (data instanceof MyContentData) {
            lists.clear();
            MyContentData myContentData = (MyContentData) data;
            lists.addAll(myContentData.getResults());

            myAdapter = new MyAdapter(lists, getActivity());
            MyRecy.setAdapter(myAdapter);
        }else if(data instanceof MyConData){
            MyConData myConData = (MyConData) data;
            da.addAll(myConData.getResult().getRxxp().get(0).getCommodityList());
            LinearLayoutManager manager = new LinearLayoutManager(getActivity());
            MyRexiao.setLayoutManager(manager);
            MyTestAdapter myTestAdapter = new MyTestAdapter(da,getActivity());
            MyRexiao.setAdapter(myTestAdapter);
        }
    }

    @Override
    public void error(Object error) {
        Log.e("九宫格失败", "error: " + error);
    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}

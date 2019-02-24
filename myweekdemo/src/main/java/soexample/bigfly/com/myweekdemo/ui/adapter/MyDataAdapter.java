package soexample.bigfly.com.myweekdemo.ui.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.ArrayList;

import soexample.bigfly.com.myweekdemo.R;
import soexample.bigfly.com.myweekdemo.bean.ShoppingData;

/**
 * <p>文件描述：<p>
 * <p>作者：${吕飞}<p>
 * <p>创建时间：2019/2/24   18:19<p>
 * <p>更改时间：2019/2/24   18:19<p>
 * <p>版本号：1<p>
 */

public class MyDataAdapter extends RecyclerView.Adapter<MyDataAdapter.ViewHolder> {
    private ArrayList<ShoppingData.DataBean> datas;
    private Context context;


    public MyDataAdapter(ArrayList<ShoppingData.DataBean> datas, Context context) {
        this.datas = datas;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        this.context = viewGroup.getContext();
        View inflate = LayoutInflater.from(context).inflate(R.layout.item666, viewGroup, false);
        return new ViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        viewHolder.MerchantName.setText(datas.get(i).getSellerName());
        LinearLayoutManager manager = new LinearLayoutManager(context);
        viewHolder.MyGoods.setLayoutManager(manager);
        MyShoppingAdapter shoppingAdapter = new MyShoppingAdapter(R.layout.shoppingcar_item,datas);
        viewHolder.MyGoods.setAdapter(shoppingAdapter);
    }

    @Override
    public int getItemCount() {
        return datas.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private CheckBox MerchantCK;
        private TextView MerchantName;
        private RecyclerView MyGoods;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            MerchantCK = itemView.findViewById(R.id.MerchantCK);
            MerchantName = itemView.findViewById(R.id.MerchantName);
            MyGoods = itemView.findViewById(R.id.MyGoods);
        }
    }
}
/*
        BaseQuickAdapter<ShoppingData.DataBean,BaseViewHolder> {

public MyDataAdapter(int layoutResId, @Nullable List<ShoppingData.DataBean> data) {
        super(layoutResId, data);
        }

@Override
protected void convert(BaseViewHolder helper, ShoppingData.DataBean item) {
        for (int i = 0; i <item.getList().size() ; i++) {
        helper.setText(R.id.MerchantName,item.getSellerName());
        RecyclerView view = helper.getView(R.id.MyGoods);


        }
        }*/

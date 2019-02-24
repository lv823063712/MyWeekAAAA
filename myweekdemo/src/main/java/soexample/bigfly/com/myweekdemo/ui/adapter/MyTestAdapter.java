package soexample.bigfly.com.myweekdemo.ui.adapter;

import android.content.Context;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import soexample.bigfly.com.myweekdemo.MyAdapter;
import soexample.bigfly.com.myweekdemo.R;
import soexample.bigfly.com.myweekdemo.bean.CommodityListBean;

/**
 * <p>文件描述：<p>
 * <p>作者：${吕飞}<p>
 * <p>创建时间：2019/2/24   13:49<p>
 * <p>更改时间：2019/2/24   13:49<p>
 * <p>版本号：1<p>
 */

public class MyTestAdapter extends RecyclerView.Adapter<MyTestAdapter.ViewHolder> {
    private ArrayList<CommodityListBean> datas;
    private Context context;
    private View inflate;
    private final int Item_One = 0;
    private final int Item_Two = 1;
    private final int Item_Three = 2;

    public MyTestAdapter(ArrayList<CommodityListBean> datas, Context context) {
        this.datas = datas;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        this.context = viewGroup.getContext();
        int type = getItemViewType(i);
        if (type == Item_One) {
            inflate = LayoutInflater.from(context).inflate(R.layout.hot_item, viewGroup, false);

        } else if (type == Item_Two) {
            inflate = LayoutInflater.from(context).inflate(R.layout.pzss_item, viewGroup, false);

        } else if (type == Item_Three) {
            inflate = LayoutInflater.from(context).inflate(R.layout.mlss_item, viewGroup, false);
        }
        return new ViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {

        int type = getItemViewType(i);
        if (type == Item_One) {
            viewHolder.My_Hot_title.setText(datas.get(i).getCommodityName());
            viewHolder.My_Hot_Price.setText("¥" + datas.get(i).getPrice());
            String masterPic = datas.get(i).getMasterPic() + "";
            Uri parse = Uri.parse(masterPic);
            viewHolder.My_Hot_Img.setImageURI(parse);
        } else if (type == Item_Two) {
            viewHolder.My_pzss_title.setText(datas.get(i).getCommodityName());
            viewHolder.My_pzss_Price.setText("¥" + datas.get(i).getPrice());
            String masterPic = datas.get(i).getMasterPic() + "";
            Uri parse = Uri.parse(masterPic);
            viewHolder.My_pzss_Img.setImageURI(parse);
        } else if (type == Item_Three) {
            viewHolder.My_mlss_title.setText(datas.get(i).getCommodityName());
            viewHolder.My_mlss_Price.setText("¥" + datas.get(i).getPrice());
            String masterPic = datas.get(i).getMasterPic() + "";
            Uri parse = Uri.parse(masterPic);
            viewHolder.My_mlss_Img.setImageURI(parse);
        }


    }

    @Override
    public int getItemCount() {
        return datas.size();
    }

    @Override
    public int getItemViewType(int i) {
        if (i % 3 == 0) {
            return Item_One;
        } else if (i % 3 == 1) {
            return Item_Two;
        } else {
            return Item_Three;
        }
    }


    public class ViewHolder extends RecyclerView.ViewHolder {
        private ImageView My_Hot_Img;
        private TextView My_Hot_title;
        private TextView My_Hot_Price;

        private ImageView My_pzss_Img;
        private TextView My_pzss_title;
        private TextView My_pzss_Price;

        private ImageView My_mlss_Img;
        private TextView My_mlss_title;
        private TextView My_mlss_Price;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            My_Hot_Img = itemView.findViewById(R.id.My_Hot_Img);
            My_Hot_title = itemView.findViewById(R.id.My_Hot_title);
            My_Hot_Price = itemView.findViewById(R.id.My_Hot_Price);
            My_pzss_Img = itemView.findViewById(R.id.My_pzss_Img);
            My_pzss_title = itemView.findViewById(R.id.My_pzss_title);
            My_pzss_Price = itemView.findViewById(R.id.My_pzss_Price);
            My_mlss_Img = itemView.findViewById(R.id.My_mlss_Img);
            My_mlss_title = itemView.findViewById(R.id.My_mlss_title);
            My_mlss_Price = itemView.findViewById(R.id.My_mlss_Price);
        }
    }
}

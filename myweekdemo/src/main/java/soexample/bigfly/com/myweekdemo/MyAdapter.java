package soexample.bigfly.com.myweekdemo;

import android.content.Context;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.facebook.drawee.view.SimpleDraweeView;

import java.util.ArrayList;
import java.util.List;

import soexample.bigfly.com.myweekdemo.bean.MyContentData;

/**
 * <p>文件描述：<p>
 * <p>作者：${吕飞}<p>
 * <p>创建时间：2019/2/23   23:54<p>
 * <p>更改时间：2019/2/23   23:54<p>
 * <p>版本号：1<p>
 */

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {
    private List<MyContentData.ResultsBean> datas;
    private Context context;


    public MyAdapter(List<MyContentData.ResultsBean> datas, Context context) {
        this.datas = datas;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        this.context = viewGroup.getContext();
        View inflate = LayoutInflater.from(context).inflate(R.layout.item_layout, viewGroup, false);
        return new ViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        viewHolder.MyTitle.setText(datas.get(i).getType());
        String url = datas.get(i).getUrl();
        Uri parse = Uri.parse(url);
        viewHolder.MySimp.setImageURI(parse);
    }

    @Override
    public int getItemCount() {
        return datas.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private SimpleDraweeView MySimp;
        private TextView MyTitle;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            MySimp=itemView.findViewById(R.id.MySimp);
            MyTitle=itemView.findViewById(R.id.MyTitle);
        }
    }
}

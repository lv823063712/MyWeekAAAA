package soexample.bigfly.com.myweekdemo.ui.adapter;

import android.net.Uri;
import android.support.annotation.Nullable;
import android.widget.ImageView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.List;

import soexample.bigfly.com.myweekdemo.R;
import soexample.bigfly.com.myweekdemo.bean.ShoppingData;

/**
 * <p>文件描述：<p>
 * <p>作者：${吕飞}<p>
 * <p>创建时间：2019/2/24   15:39<p>
 * <p>更改时间：2019/2/24   15:39<p>
 * <p>版本号：1<p>
 */

public class MyShoppingAdapter extends BaseQuickAdapter<ShoppingData.DataBean,BaseViewHolder> {
    public MyShoppingAdapter(int layoutResId, @Nullable List<ShoppingData.DataBean> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, ShoppingData.DataBean item) {
        ImageView view = helper.getView(R.id.ShoppingCar_head);
        for (int i = 0; i < item.getList().size(); i++) {
            helper.setText(R.id.ShoppingCar_title,item.getList().get(i).getTitle());
            helper.setText(R.id.ShoppingCar_price,"¥"+item.getList().get(i).getPrice());
            String images = item.getList().get(i).getImages();
            if (!images.isEmpty()) {
                String[] split = images.split("\\|");
                if (split != null) {
                    for (int j = 0; j < split.length; j++) {
                        String replace = split[j].replace("https", "http");
                        Uri parse = Uri.parse(replace);
                        view.setImageURI(parse);
                    }
                } else {
                    String replace = images.replace("https", "http");
                    Uri parse = Uri.parse(replace);
                    view.setImageURI(parse);
                }
            }


        }

    }
}

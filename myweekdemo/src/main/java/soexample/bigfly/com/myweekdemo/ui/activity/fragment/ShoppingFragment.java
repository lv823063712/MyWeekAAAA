package soexample.bigfly.com.myweekdemo.ui.activity.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;

import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import soexample.bigfly.com.myweekdemo.R;
import soexample.bigfly.com.myweekdemo.bean.ShoppingData;
import soexample.bigfly.com.myweekdemo.ui.adapter.MyDataAdapter;
import soexample.bigfly.com.myweekdemo.ui.adapter.MyShoppingAdapter;

/**
 * A simple {@link Fragment} subclass.
 */
public class ShoppingFragment extends Fragment {
    InputStreamReader inputStreamReader;
    @BindView(R.id.My_Shopping_Car)
    RecyclerView MyShoppingCar;
    @BindView(R.id.My_Select_All)
    CheckBox MySelectAll;
    @BindView(R.id.My_All_Price)
    TextView MyAllPrice;
    @BindView(R.id.Settle_Accounts)
    TextView SettleAccounts;
    Unbinder unbinder;
    private String stringB;
    private ArrayList<ShoppingData.DataBean> datas = new ArrayList<>();
    private MyShoppingAdapter shoppingAdapter;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View inflate = inflater.inflate(R.layout.fragment_shopping, null);
        unbinder = ButterKnife.bind(this, inflate);


        initData();



        return inflate;
    }

    private void initData() {

                try {
                    inputStreamReader = new InputStreamReader(getResources().getAssets().open("cart.json"), "UTF-8");
                    BufferedReader bufferedReader = new BufferedReader(
                            inputStreamReader);
                    String line;
                    StringBuilder stringBuilder = new StringBuilder();
                    while ((line = bufferedReader.readLine()) != null) {
                        stringBuilder.append(line);
                    }
                    inputStreamReader.close();
                    bufferedReader.close();
                    stringB = stringBuilder.toString();

                    ShoppingData shoppingData = new Gson().fromJson(stringB, ShoppingData.class);
                    datas.addAll(shoppingData.getData());
                    LinearLayoutManager manager = new LinearLayoutManager(getActivity());
                    MyShoppingCar.setLayoutManager(manager);
                    MyDataAdapter myDataAdapter = new MyDataAdapter(datas,getActivity());
                    MyShoppingCar.setAdapter(myDataAdapter);
                    //shoppingAdapter = new MyShoppingAdapter(R.layout.shoppingcar_item, datas);
                    //MyShoppingCar.setAdapter(shoppingAdapter);

                } catch (IOException e) {
                    e.printStackTrace();
                }
            }




    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

}

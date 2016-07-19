package com.weibo.cjfire.weibo2android.Home.View;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.weibo.cjfire.weibo2android.Base.Controller.ReqService;
import com.weibo.cjfire.weibo2android.Base.View.BaseFragment;
import com.weibo.cjfire.weibo2android.Home.Adapter.HomeAdapter;
import com.weibo.cjfire.weibo2android.Home.Model.StatueList;
import com.weibo.cjfire.weibo2android.Home.Model.Statues;
import com.weibo.cjfire.weibo2android.Main.Controller.MainActivity;
import com.weibo.cjfire.weibo2android.Me.Model.AuthItem;
import com.weibo.cjfire.weibo2android.R;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

/**
 * Created by cjfire on 16/7/10.
 */
public class HomeFragment extends BaseFragment {

    private View mView;
    private ListView mStatusList;
    private HomeAdapter mHomeAdapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        mView = View.inflate(mActivity, R.layout.fragment_home, null);

        init();

        return mView;
    }

    private void init() {

        final Context context = this.getActivity();

        MainActivity mainActivity = (MainActivity) this.getActivity();
        Retrofit retrofit = mainActivity.getmRetrofit();
        ReqService service = retrofit.create(ReqService.class);
        AuthItem authItem = new AuthItem(context);

        Call<StatueList> statues = service.listStatues(authItem.getAccessToken());

        statues.enqueue(new Callback<StatueList>() {
            @Override
            public void onResponse(Call<StatueList> call, Response<StatueList> response) {

                if (response.body() != null) {
                    List<Statues> statueList = response.body().getStatuses();
                    mHomeAdapter = new HomeAdapter(context, R.layout.cell_home ,statueList);
                    mStatusList.setAdapter(mHomeAdapter);
                    mHomeAdapter.notifyDataSetChanged();
                }
            }

            @Override
            public void onFailure(Call<StatueList> call, Throwable t) {
                Log.i("test_error", t.getMessage());
            }
        });


        mStatusList = (ListView) mView.findViewById(R.id.statusList);
        mStatusList.setAdapter(mHomeAdapter);
    }
}

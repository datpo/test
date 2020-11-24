package com.cyber.cybersignum.ui.slideshow;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.widget.NestedScrollView;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.cyber.cybersignum.R;
import com.cyber.cybersignum.adapter.MainAdapter;
import com.cyber.cybersignum.object.MainData;
import com.cyber.cybersignum.object.MainInterface;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.scalars.ScalarsConverterFactory;

public class SlideshowFragment extends Fragment {

    private SlideshowViewModel slideshowViewModel;
    NestedScrollView netNestedScrollView;
    RecyclerView recyclerView;
    ProgressBar progressBar;
    ArrayList<MainData> dataArrayList = new ArrayList<MainData>();
    MainAdapter adapter;
    int page = 1, limit = 10;
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        slideshowViewModel =
                new ViewModelProvider(this).get(SlideshowViewModel.class);
        View root = inflater.inflate(R.layout.fragment_slideshow, container, false);
        /*final TextView textView = root.findViewById(R.id.text_slideshow);
        slideshowViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });*/
        netNestedScrollView = root.findViewById(R.id.scroll_view);
        recyclerView = root.findViewById(R.id.recycler_view);
        progressBar = root.findViewById(R.id.progress_bar);


        adapter = new MainAdapter(getActivity(),dataArrayList);

        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(adapter);

        getData(page,limit);
        netNestedScrollView.setOnScrollChangeListener(new NestedScrollView.OnScrollChangeListener() {
            @Override
            public void onScrollChange(NestedScrollView v, int scrollX, int scrollY, int oldScrollX, int oldScrollY) {
                if(scrollY == v.getChildAt(0).getMeasuredHeight()-v.getMeasuredHeight()){
                    page++;

                    progressBar.setVisibility(View.VISIBLE);
                    getData(page,limit);
                }
            }
        });
        return root;
    }

    private void getData(int page, int limit) {
        Retrofit retrofit = new Retrofit.Builder().baseUrl("https://picsum.photos/")
                .addConverterFactory(ScalarsConverterFactory.create()).build();

        MainInterface mainInterface = retrofit.create(MainInterface.class);
        Call<String> call = mainInterface.STRING_CALL(page,limit);
        call.enqueue(new Callback<String>() {
            @Override
            public void onResponse(Call<String> call, Response<String> response) {
                if(response.isSuccessful() && response.body() != null){
                    progressBar.setVisibility(View.GONE);
                    try {
                        JSONArray jsonArray = new JSONArray(response.body());
                        parseResult(jsonArray);
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
            }

            @Override
            public void onFailure(Call<String> call, Throwable t) {

            }
        });
    }

    private void parseResult(JSONArray jsonArray) throws JSONException {
        for(int i= 0;i < jsonArray.length(); i++ ){
            JSONObject jsonObject = jsonArray.getJSONObject(i);
            MainData data = new MainData();
            data.setImage(jsonObject.getString("download_url"));
            data.setName(jsonObject.getString("author"));

            dataArrayList.add(data);
        }
        adapter = new MainAdapter(getActivity(),dataArrayList);
        recyclerView.setAdapter(adapter);
    }
}
package com.selimhatipoglu.movieapp.ui.dashboard;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.RecyclerView;

import com.selimhatipoglu.movieapp.R;
import com.selimhatipoglu.movieapp.RecylerAdapter;
import com.selimhatipoglu.movieapp.RecylerModel;
import com.selimhatipoglu.movieapp.databinding.FragmentDashboardBinding;

import android.app.VoiceInteractor;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.JsonRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import com.facebook.drawee.backends.pipeline.Fresco;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.w3c.dom.ls.LSOutput;

import java.io.DataOutput;
import java.io.IOException;

import java.io.IOException;
import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.ArrayList;

public class DashboardFragment extends Fragment {

    private FragmentDashboardBinding binding;
    RecyclerView recyclerView;
    ArrayList<RecylerModel> recylerModels;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        DashboardViewModel dashboardViewModel =
                new ViewModelProvider(this).get(DashboardViewModel.class);

        binding = FragmentDashboardBinding.inflate(inflater, container, false);
        View root = binding.getRoot();
        recyclerView = root.findViewById(R.id.recylerView);
        recylerModels = new ArrayList<>();
        Fresco.initialize(getActivity());

       // dashboardViewModel.getText().observe(getViewLifecycleOwner(), textView::setText);

        RequestQueue requestQueue= Volley.newRequestQueue(getContext());

        String url ="https://api.themoviedb.org/3/trending/movie/day?api_key=bb8587fb863b7c09ce6de029bfc16d01";






        JsonObjectRequest jsonObjectRequest= new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                System.out.println("12345" +response);


                try {
                    JSONArray jsonArray = response.getJSONArray("results");

                    System.out.println("0123" + jsonArray);


                    for (int i=0;i<jsonArray.length();i++){

                        JSONObject jsonObject = jsonArray.getJSONObject(i);
                        System.out.println("1234" + jsonObject);



                        String title=jsonObject.getString("title");
                        String star=jsonObject.getString("vote_average");
                        String times = jsonObject.getString("release_date");


                        String topic ="";
                        //  String topic= respons.getString("tagline");
                        //   String uri=jsonObject.getString("img");
                        //  String replaced=uri.replace("\\\\","");
                        String images =jsonObject.getString("poster_path");

                        String image = "https://image.tmdb.org/t/p/w500" + images;
                        System.out.println("1234" + image);

                        recylerModels.add(new RecylerModel(image,title,topic,star,times));
                        System.out.println("999" + recylerModels.size());

                    }


                    RecylerAdapter recyclerAdapter=new RecylerAdapter(recylerModels);
                    recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
                    recyclerView.setAdapter(recyclerAdapter);
                    recyclerView.setHasFixedSize(true);


                } catch (JSONException e) {
                    e.printStackTrace();
                    //  Toast.makeText(getApplicationContext(),"OLMADI",Toast.LENGTH_LONG).show();

                }


            }

        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                error.printStackTrace();

            }

        });


        requestQueue.add(jsonObjectRequest);

        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}
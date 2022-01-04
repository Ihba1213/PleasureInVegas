package com.example.pleasureinvegas.network;



import android.content.Context;
import android.util.Log;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

class RetrofitCalls {
    static Response response;
    private static Retrofit  retrofitToken;
    private static RetrofitCalls retrofit = null;
    public static String BASE_URL = "https://pleasureinvegas.com/api/";


    public static Retrofit getRetrofitInstance(Context mContext) {

        OkHttpClient httpClient = new OkHttpClient.Builder()
                //here we can add Interceptor for dynamical adding headers
              /*  .addInterceptor(new ChuckInterceptor(mContext))*/
                .addInterceptor(new Interceptor() {
                    @Override
                    public Response intercept(Chain chain) throws IOException {
                        Request original = chain.request();

                        Request request = original.newBuilder()
                                .addHeader("authorization", "Bearer" + " " + "")
                                .addHeader("Content-Type","application/josn")
                                .build();

                        return response;
                    }
                })
                .build();
        if (retrofitToken == null) {
            Log.d("api", "API" + BASE_URL);
            retrofitToken = new retrofit2.Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .client(httpClient.newBuilder().build())
                    .build();
        }
        return retrofitToken;
    }


}

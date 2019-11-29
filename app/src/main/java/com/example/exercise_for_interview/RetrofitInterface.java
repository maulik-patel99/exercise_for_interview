package com.example.exercise_for_interview;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

interface RetrofitInterface
{
    @GET("/posts")
    Call<List<Hero>> getGsonData();
}

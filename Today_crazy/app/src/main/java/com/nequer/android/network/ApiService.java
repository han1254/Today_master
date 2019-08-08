package com.nequer.android.network;


import com.nequer.android.business.account.model.request.LoginReqModel;
import com.nequer.android.business.account.model.request.RegisterReqModel;
import com.nequer.android.business.account.model.response.LoginResponseModel;
import com.nequer.android.business.account.model.response.LoginRspModel;
import com.nequer.android.business.detail.mvp.model.DetailCommentModel;
import com.nequer.android.business.detail.mvp.model.DetailModel;
import com.nequer.android.business.manage.mvp.model.MyCreateModel;
import com.nequer.android.business.manage.mvp.model.ToCreateCalendarModel;
import com.nequer.android.business.square.mvp.model.SquareItem;
import com.nequer.android.business.subscribe.mvp.model.CalendarModel;
import com.neuqer.android.network.response.ApiResponse;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface ApiService {

    @POST("user/register")
    Call<ApiResponse<Long>> register (@Body RegisterReqModel registerReqModel);

    @POST("user/login")
    Call<LoginResponseModel> login (@Body LoginReqModel loginReqModel);

    //获得自己订阅的黄历
    @GET("calendar/subscribed")
    Call<ApiResponse<List<CalendarModel>>> getSubscribed();

    //获得今日推荐的黄历
    @GET("piazza/most-subscribed")
    Call<ApiResponse<List<SquareItem>>> getRecommend();

    //获得黄历广场的所有黄历
    @GET("piazza/all")
    Call<ApiResponse<List<SquareItem>>> getSquare(@Query("page")int page);

    //获得黄历的详细信息
    @GET("calendar/{calendarId}/detail")
    Call<ApiResponse<DetailModel>> getCalendarDetail(@Path("calendarId") int calendarId);

    //获得黄历的评论
    @GET("calendar/{calendarId}/comment")
    Call<ApiResponse<List<DetailCommentModel>>> getCalendarComment(@Path("calendarId") int calendar,@Query("page") int page);

    //订阅黄历
    @GET("calendar/{calendarId}/subscribe")
    Call<ApiResponse<Void>> subscribeCalendar(@Path("calendarId")int calendarId);

    //取消订阅
    @GET("calendar/{calendarId}/unsubscribe")
    Call<ApiResponse<Void>> unSubscribeCalendar(@Path("calendarId")int calendarId);

    //发送评论
    @POST("calendar/{calendarId}/comment")
    Call<ApiResponse<Void>> sendComment(@Path("calendarId")int calendarId, @Body DetailCommentModel model);

    //获得自己创建的黄历
    @GET("custom/created")
    Call<ApiResponse<List<MyCreateModel>>>getMyCreateCalendar();

    //获取七牛图片token
    @GET("custom/upload/token")
    Call<ApiResponse<String>> getPicsToken();

    @POST("custom/new")
    Call<ApiResponse<Long>> toCreateCalendar(@Body ToCreateCalendarModel model);


    //删除
    @DELETE("custom/{calendarId}")
    Call<ApiResponse<Long>> deleteCalendar(@Path("calendarId") int calendarId);
}

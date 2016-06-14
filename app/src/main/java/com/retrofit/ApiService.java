package com.retrofit;

import com.model.BaseModel;
import com.squareup.okhttp.RequestBody;

import java.util.Map;

import retrofit.http.Body;
import retrofit.http.Field;
import retrofit.http.GET;
import retrofit.http.Header;
import retrofit.http.Headers;
import retrofit.http.Multipart;
import retrofit.http.POST;
import retrofit.http.Part;
import retrofit.http.PartMap;
import retrofit.http.Path;
import retrofit.http.Query;
import retrofit.http.QueryMap;
import rx.Observable;

/**
 * Created by Administrator on 2016/6/6.
 * application 对apiservice 初始化
 * retrofit 网络请求
 * api 接口
 */
public interface ApiService {

    /**
     * get 请求
     * 请求返回数据 model
     * Query 查询参数调用方法ApiService.getDemoDate("',"","")
     * QueryMap 调用方法ApiService.getDemoDate(Collections.singletonMap("",""))
     *
     */
    @GET("/some/endpoint/{thing}")
    @Headers("Accept-Encoding: application/json")   //固定头
    Observable<BaseModel<String>> getDemoDate(
            @Header("device") String device,  //放公共参数
            @Query("name") String name, //请求参数
            @Query("uid") String uid,
            @QueryMap Map<String, String> dynamic,   //请求参数 map
            @Path("thing") String thing     //路径替换
    );

    @GET("/some/endpoint/{thing}")
    Observable<BaseModel<String>> getDemoDate2(
            @Header("device") String device,  //放公共参数
            @Body String body,      //String 可以是model 及一个对象
            @Query("name") String name, //请求参数
            @Query("uid") String uid,
            @QueryMap Map<String, String> dynamic,   //请求参数 map
            @Path("thing") String thing     //路径替换
    );

    /**
     * 表单的方式传递键值对@FormUrlEncoded
     * @param device
     * @param username
     * @param userpass
     * @return
     */
    @POST("/some/endpoint")
    Observable<BaseModel<String>> getLogin(
            @Header("device") String device,  //放公共参数
            @Field("username") String username,
            @Field("userpass") String userpass
    );


    /**
     *  单文件上传@Multipart
     * @param device
     * @param username
     * @param userpass
     * @return
     */
    @Multipart
    @POST("/some/photo")
    Observable<BaseModel<String>> getPhoto(
            @Header("device") String device,  //放公共参数
//            @Part Multi photo,
            @Part("username") String username,
            @Part("userpass") String userpass
    );

    /**
     * 多文件上传@PartMap
     * @param device
     * @param username
     * @param userpass
     * @return
     * eg.
     * File file = new File(Environment.getExternalStorageDirectory(), "messenger_01.png");
    RequestBody photo = RequestBody.create(MediaType.parse("image/png", file);
    Map<String,RequestBody> photos = new HashMap<>();
    photos.put("photos\"; filename=\"icon.png", photo);
    photos.put("username",  RequestBody.create(null, "abc"));
     * 调用方法 ApiService.getPhoto2(photos,RequestBody.create(null,"1123"))
     */
    @Multipart
    @POST("/some/photo")
    Observable<BaseModel<String>> getPhoto2(
            @Header("device") String device,  //放公共参数
            @PartMap Map<String,RequestBody> parms,
            @Part("username") RequestBody username,
            @Part("userpass") RequestBody userpass
    );
}

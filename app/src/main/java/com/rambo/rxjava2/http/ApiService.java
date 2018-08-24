package com.rambo.rxjava2.http;


import com.rambo.rxjava2.ui.entity.NovelBean;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.GET;

/**
 * file explain
 *
 * @author rambo
 * @version 1.0 2018-08-23
 * @since JDK 1.8
 */
public interface ApiService {

    @GET("https://www.apiopen.top/novelApi")
    Observable<BaseDataResult<List<NovelBean>>> getNovelList();

}

package com.moon.composedemo.http

import com.moon.composedemo.model.Feed
import retrofit2.http.GET
import retrofit2.http.Query

interface IApiInterface {

    /**
     * 查询帖子列表
     * @param feedId 帖子的id, 分页时传列表最后一个帖子的id
     * @param feedType 查询的帖子的类型，all：全部类型，pics:仅图片类型，video:仅视频类型，text:仅文本类型
     * @param pageCount 分页的数量
     * @param userId 当前登陆者的id
     */
    @GET("feeds/queryHotFeedsList")
    suspend fun getFeeds(
        @Query("feedId") feedId: Long = 0,
        @Query("feedType") feedType: String = "all",
        @Query("pageCount") pageCount: Int = 10,
        @Query("userId") userId: Long = 0
    ): ApiResult<List<Feed>>

}
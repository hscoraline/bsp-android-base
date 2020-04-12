package com.bsp.base.api;

import com.bsp.base.data.response.SampleResponse;

import io.reactivex.Single;
import retrofit2.http.GET;

public interface ClientInterface {

    @GET(APIConstant.DUMMY_USERS_URL)
    Single<SampleResponse> getListUser();
}

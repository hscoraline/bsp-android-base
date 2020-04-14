package com.bsp.base.features.somefeature.samplescreenlistuser;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.bsp.base.api.APIService;
import com.bsp.base.api.ClientInterface;
import com.bsp.base.data.model.SampleUser;
import com.bsp.base.data.response.SampleResponse;
import com.bsp.base.features.base.BaseViewModel;
import com.bsp.base.util.DisposableManager;

import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

@SuppressWarnings("UnstableApiUsage")
public class ListUserViewModel extends BaseViewModel {

    private MutableLiveData<List<SampleUser>> mListUser = new MutableLiveData<>();

    private ClientInterface mClient;

    public ListUserViewModel(@NonNull Application application) {
        super(application);
        mClient = APIService.getClient();
    }

    public void getUsers() {
        DisposableManager.add(mClient.getListUser()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .doOnSubscribe(d -> showLoading())
                .doOnTerminate(this::hideLoading)
                .subscribe(this::handleResponse, this::handleException));
    }

    private void handleException(Throwable throwable) {
        showError("loi ket noi");
    }

    private void handleResponse(SampleResponse response) {
        mListUser.setValue(response.getData());
    }

    public LiveData<List<SampleUser>> usersData() {
        return mListUser;
    }
}

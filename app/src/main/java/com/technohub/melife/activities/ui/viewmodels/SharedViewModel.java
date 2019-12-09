package com.technohub.melife.activities.ui.viewmodels;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class SharedViewModel extends ViewModel {
    private MutableLiveData<String> mText;
    String data;
    public SharedViewModel() {
        mText = new MutableLiveData<>();

    }

    public void setmText(MutableLiveData<String> mText) {
        this.mText = mText;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public LiveData<String> getText() {
        return mText;
    }
}

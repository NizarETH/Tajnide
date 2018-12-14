package com.secret.box.tajnide;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.ViewModel;
import android.support.annotation.NonNull;

public class DataViewModel extends AndroidViewModel {

    public int dataIndex;

    public DataViewModel(@NonNull Application application) {
        super(application);
    }

    public int getDataIndex() {
        return dataIndex;
    }

    public void setDataIndex(int dataIndex) {
        this.dataIndex = dataIndex;
    }
}

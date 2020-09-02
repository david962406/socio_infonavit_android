package com.skimy.infonavit.data.ui.benevits;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.skimy.infonavit.data.models.walletClass;
import com.skimy.infonavit.data.network.dataRepository;

import java.util.ArrayList;

public class walletViewModel extends ViewModel {
    private dataRepository repositorio=new dataRepository();
    private MutableLiveData <ArrayList<walletClass>> wallets= new MutableLiveData<ArrayList<walletClass>>();

    public LiveData<ArrayList<walletClass> >getWallets(){

        wallets.setValue(repositorio.getWallets());
        return wallets;
    }


}//intento para implementación view model

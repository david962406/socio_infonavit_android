package com.skimy.infonavit.data.ui.benevits;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.skimy.infonavit.data.models.walletClass;
import com.skimy.infonavit.data.network.dataRepository;

import java.util.ArrayList;

public class benevitViewModel extends ViewModel {
    private dataRepository repositorio;
   private MutableLiveData <ArrayList<String>> benevits;
    private MutableLiveData <ArrayList<String>> wallets;
   public benevitViewModel(){
       benevits=new MutableLiveData<>();
       //benevits.setValue();
   }



}//intento para implementación view model

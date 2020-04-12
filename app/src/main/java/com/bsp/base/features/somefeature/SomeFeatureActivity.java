package com.bsp.base.features.somefeature;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProvider;

import com.bsp.base.R;
import com.bsp.base.databinding.ActivitySomeFeatureBinding;
import com.bsp.base.features.base.BaseActivity;

public class SomeFeatureActivity extends BaseActivity {

    private SomeFeatureViewModel viewModel;
    private ActivitySomeFeatureBinding binding;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_some_feature);
        viewModel = new ViewModelProvider(this).get(SomeFeatureViewModel.class);
        binding.setViewModel(viewModel);
        binding.setLifecycleOwner(this);
        viewModel.setSomeData("DUMMY");
    }
}

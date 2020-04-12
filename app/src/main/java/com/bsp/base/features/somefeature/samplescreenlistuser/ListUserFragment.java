package com.bsp.base.features.somefeature.samplescreenlistuser;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.bsp.base.data.model.SampleUser;
import com.bsp.base.databinding.FragmentListUserBinding;
import com.bsp.base.features.base.BaseFragment;
import com.bsp.base.features.somefeature.SomeFeatureViewModel;
import com.bsp.base.features.somefeature.samplescreenlistuser.listener.ListUserHandler;

import java.util.List;

public class ListUserFragment extends BaseFragment implements ListUserHandler {

    private FragmentListUserBinding binding;
    private ListUserViewModel viewModel;
    private SomeFeatureViewModel activityViewModel;

    private ListUserAdapter adapter;

    //Use activity viewModel to pass data between child fragments
    private String someData;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityViewModel = new ViewModelProvider(requireActivity()).get(SomeFeatureViewModel.class);
        viewModel = new ViewModelProvider(this).get(ListUserViewModel.class);

        someData = activityViewModel.getSomeData();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = FragmentListUserBinding.inflate(inflater);
        binding.setViewModel(viewModel);
        binding.setHandler(this);
        binding.setLifecycleOwner(getViewLifecycleOwner());
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initControls();
        initListener();
    }

    private void initControls() {
        adapter = new ListUserAdapter(getContext(), new UserDiffCallback());
        binding.rvUser.setLayoutManager(new LinearLayoutManager(getContext()));
        binding.rvUser.setAdapter(adapter);
    }

    private void initListener() {
        viewModel.onLoadingEvent().observe(getViewLifecycleOwner(), this::handleLoading);
        viewModel.usersData().observe(getViewLifecycleOwner(), this::handleUserData);
    }

    private void handleUserData(List<SampleUser> sampleUsers) {
        adapter.submitList(sampleUsers);
    }

    @Override
    public void getData() {
        viewModel.getUsers();
    }
}

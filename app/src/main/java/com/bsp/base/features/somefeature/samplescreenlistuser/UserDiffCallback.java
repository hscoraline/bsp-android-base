package com.bsp.base.features.somefeature.samplescreenlistuser;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;

import com.bsp.base.data.model.SampleUser;

public class UserDiffCallback extends DiffUtil.ItemCallback<SampleUser> {
    @Override
    public boolean areItemsTheSame(@NonNull SampleUser oldItem, @NonNull SampleUser newItem) {
        return oldItem.getEmployeeName().equals(newItem.getEmployeeName());
    }

    @Override
    public boolean areContentsTheSame(@NonNull SampleUser oldItem, @NonNull SampleUser newItem) {
        return oldItem.getEmployeeName().equals(newItem.getEmployeeName());
    }
}

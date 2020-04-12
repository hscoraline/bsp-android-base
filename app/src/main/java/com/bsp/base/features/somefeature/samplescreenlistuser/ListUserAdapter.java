package com.bsp.base.features.somefeature.samplescreenlistuser;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;

import com.bsp.base.data.model.SampleUser;
import com.bsp.base.databinding.ItemSampleUserBinding;

public class ListUserAdapter extends ListAdapter<SampleUser, ListUserAdapter.UserVH> {

    private Context mContext;

    ListUserAdapter(Context context, @NonNull DiffUtil.ItemCallback<SampleUser> diffCallback) {
        super(diffCallback);
        this.mContext = context;
    }

    @NonNull
    @Override
    public UserVH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(mContext);
        ItemSampleUserBinding binding = ItemSampleUserBinding.inflate(inflater, parent, false);
        return new UserVH(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull UserVH holder, int position) {
        holder.bind(getItem(position));
    }

    class UserVH extends RecyclerView.ViewHolder {

        private ItemSampleUserBinding binding;

        UserVH(@NonNull ItemSampleUserBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        void bind(SampleUser user) {
            binding.setUser(user);
        }
    }
}

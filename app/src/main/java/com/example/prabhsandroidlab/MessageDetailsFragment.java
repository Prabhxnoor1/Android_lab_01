package com.example.prabhsandroidlab;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.prabhsandroidlab.databinding.DetailsLayoutBinding;

public class MessageDetailsFragment extends Fragment {

    ChatMessage selected;

    public MessageDetailsFragment() {
    }
    public MessageDetailsFragment(ChatMessage m) {
        this.selected = m;
    }
    public  void displayMessage(ChatMessage newValue){}
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        DetailsLayoutBinding binding = DetailsLayoutBinding.inflate(inflater);
        binding.messageTextt.setText(selected.message);
        binding.timeTextt.setText(selected.timeSent);
        binding.databaseText.setText("Id = "+selected.id);
        return binding.getRoot();
    }
}

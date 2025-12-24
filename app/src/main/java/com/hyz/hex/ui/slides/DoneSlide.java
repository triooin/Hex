package com.hyz.hex.ui.slides;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.hyz.hex.R;
import com.hyz.hex.ui.intro.SlideFragment;

public class DoneSlide extends SlideFragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_done_slide, container, false);
    }
}

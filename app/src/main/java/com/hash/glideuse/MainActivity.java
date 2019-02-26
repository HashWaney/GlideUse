package com.hash.glideuse;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.Priority;
import com.bumptech.glide.RequestBuilder;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.RequestOptions;

import static com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions.withCrossFade;

public class MainActivity extends AppCompatActivity {

    private ImageView ivImg;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ivImg = (ImageView) findViewById(R.id.imageView2);
        findViewById(R.id.click).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RequestOptions requestOptions = new RequestOptions()
                        //设置图片加载的优先级
                        .diskCacheStrategy(DiskCacheStrategy.NONE)
                        //缓存策略,跳过内存缓存【此处应该设置为false，否则列表刷新时会闪一下】
                        .skipMemoryCache(false)
                        //设置图片加载的优先级
                        .priority(Priority.HIGH)
                        //圆角
                        .circleCrop();
                Glide.with(MainActivity.this)
                        .load("http://www.pptbz.com/pptpic/uploadfiles_6909/201203/2012031220134655.jpg")
                        .apply(requestOptions)
                        .into(ivImg)
                ;

            }
        });


        //用法1. 加载本地图片

    }
}

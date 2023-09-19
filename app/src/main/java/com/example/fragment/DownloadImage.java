package com.example.fragment;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Log;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.loader.content.AsyncTaskLoader;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class DownloadImage extends AsyncTaskLoader<Bitmap> {
    private ImageView imageView;
    private String imageUrl;

    public DownloadImage(@NonNull Context context, String imageUrl) {
        super(context);
        this.imageUrl = imageUrl;
    }

    public DownloadImage(@NonNull Context context, ImageView imageView, String imageUrl) {
        super(context);
        this.imageView = imageView;
        this.imageUrl = imageUrl;
    }

    @Nullable
    @Override
    public Bitmap loadInBackground() {
        try {
            URL url = new URL(imageUrl);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setDoInput(true);
            connection.connect();
            InputStream inputStream = connection.getInputStream();
            return BitmapFactory.decodeStream(inputStream);
        } catch (IOException e) {
            Log.e("ImageLoader", "Error downloading image: " + e.getMessage());
            return null;
        }

    }

    @Override
    public void deliverResult(@Nullable Bitmap data) {
        super.deliverResult(data);
        imageView.setImageBitmap(data);
    }

    @Override
    protected void onStartLoading() {
        super.onStartLoading();
        forceLoad();
    }
}
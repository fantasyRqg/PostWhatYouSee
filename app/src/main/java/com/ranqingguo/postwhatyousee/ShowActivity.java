package com.ranqingguo.postwhatyousee;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.ranqingguo.postwhatyousee.common.ClassHolder;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import butterknife.Bind;
import butterknife.ButterKnife;
import uk.co.senab.photoview.PhotoView;

/**
 * @Created by ranqingguo on 21/7/15.
 */
public class ShowActivity extends Activity {

    @Bind(R.id.image)
    PhotoView mImage;
    @Bind(R.id.share)
    Button mShare;
    Bitmap bitmap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show);
        ButterKnife.bind(this);


        if (ClassHolder.bitmap != null) {
            mImage.setImageBitmap(ClassHolder.bitmap);
            bitmap = ClassHolder.bitmap;
            ClassHolder.bitmap = null;
        } else {
            System.out.println("load image fail");
        }

        mShare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (bitmap == null) {
                    return;
                }
                File path = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES);
                File imageFile = new File(path, "" + System.currentTimeMillis() + ".png");
                FileOutputStream fileOutPutStream = null;

                try {
                    System.out.println(imageFile.getAbsolutePath());
                    fileOutPutStream = new FileOutputStream(imageFile);
                    bitmap.compress(Bitmap.CompressFormat.PNG, 100, fileOutPutStream);

                    fileOutPutStream.flush();
                    fileOutPutStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                    Toast.makeText(ShowActivity.this, "分享图片失败", Toast.LENGTH_SHORT).show();
                    return;
                }

                Uri share = Uri.parse("file://" + imageFile.getAbsolutePath());

                Intent shareIntent = new Intent();
                shareIntent.setAction(Intent.ACTION_SEND);
                shareIntent.putExtra(Intent.EXTRA_STREAM, share);
                shareIntent.setType("image/PNG");
                shareIntent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);
                startActivity(Intent.createChooser(shareIntent, "send"));
            }
        });

    }
}

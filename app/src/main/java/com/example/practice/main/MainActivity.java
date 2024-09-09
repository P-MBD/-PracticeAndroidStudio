package com.example.practice.main;

import android.content.res.AssetFileDescriptor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.util.Log;
import androidx.appcompat.app.AppCompatActivity;

import com.example.practice.R;

import org.tensorflow.lite.Interpreter;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.channels.FileChannel;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";
    private Interpreter tflite;
    private static final int INPUT_SIZE = 224;
    private static final int NUM_CLASSES = 1000; // تعداد کلاس‌ها در مدل MobileNetV2

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        try {
            tflite = new Interpreter(loadModelFile());
        } catch (IOException e) {
            e.printStackTrace();
            Log.e(TAG, "Model loading failed.");
            return;
        }

        if (tflite == null) {
            Log.e(TAG, "Failed to initialize TensorFlow Lite model.");
            return;
        }

        // بارگذاری و پردازش تصویر
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.test_image);
        Bitmap resizedBitmap = Bitmap.createScaledBitmap(bitmap, INPUT_SIZE, INPUT_SIZE, true);
        float[] input = convertBitmapToFloatArray(resizedBitmap);

        // اجرای مدل
        float[] output = new float[NUM_CLASSES];
        try {
            tflite.run(input, output);
        } catch (Exception e) {
            e.printStackTrace();
            Log.e(TAG, "Model inference failed.");
        }

        // پردازش نتایج
        processOutput(output);
    }

    private ByteBuffer loadModelFile() throws IOException {
        AssetFileDescriptor fileDescriptor = getAssets().openFd("1.tflite");
        FileInputStream inputStream = new FileInputStream(fileDescriptor.getFileDescriptor());
        FileChannel fileChannel = inputStream.getChannel();
        long startOffset = fileDescriptor.getStartOffset();
        long declaredLength = fileDescriptor.getDeclaredLength();
        ByteBuffer byteBuffer = fileChannel.map(FileChannel.MapMode.READ_ONLY, startOffset, declaredLength);
        byteBuffer.order(ByteOrder.nativeOrder());
        return byteBuffer;
    }

    private float[] convertBitmapToFloatArray(Bitmap bitmap) {
        int[] intValues = new int[INPUT_SIZE * INPUT_SIZE];
        bitmap.getPixels(intValues, 0, INPUT_SIZE, 0, 0, INPUT_SIZE, INPUT_SIZE);

        float[] floatValues = new float[INPUT_SIZE * INPUT_SIZE * 3];
        for (int i = 0; i < intValues.length; ++i) {
            int val = intValues[i];
            floatValues[i * 3] = ((val >> 16) & 0xFF) / 255.0f;
            floatValues[i * 3 + 1] = ((val >> 8) & 0xFF) / 255.0f;
            floatValues[i * 3 + 2] = (val & 0xFF) / 255.0f;
        }
        return floatValues;
    }

    private void processOutput(float[] output) {
        // پردازش نتایج خروجی مدل
        // به عنوان مثال، چاپ نتایج در لاگ
        Log.d(TAG, "Output: " + Arrays.toString(output));
    }
}

package com.example.robothand;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.speech.RecognizerIntent;
import android.speech.tts.TextToSpeech;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {
    BluetoothSupport bluetoothSupport;
    ProgressBar progressBar;
    TextView tvTrangthai;
    ImageView imgSpeech;
    Button btnList, btnCre, btnDis, btnKeo, btnChao, btnBua, btnBao, btnNamtay, btnOK, btnHiphop, btnTro;
    public static int Request_open_bluetooth = 101;
    TextToSpeech toSpeech;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        progressBar = findViewById(R.id.progressBar);
        tvTrangthai = findViewById(R.id.tvTrangthai);
        btnList = findViewById(R.id.btnList);
        btnCre = findViewById(R.id.btnCre);
        btnDis = findViewById(R.id.btnDis);
        btnKeo = findViewById(R.id.btnKeo);
        btnChao = findViewById(R.id.btnChao);
        btnBua = findViewById(R.id.btnBua);
        btnBao = findViewById(R.id.btnBao);
        btnNamtay = findViewById(R.id.btnNamtay);
        btnOK = findViewById(R.id.btnOK);
        btnHiphop = findViewById(R.id.btnHiphop);
        btnTro = findViewById(R.id.btnTro);
        bluetoothSupport = new BluetoothSupport(this);
        progressBar.setVisibility(View.INVISIBLE);
        imgSpeech = findViewById(R.id.imgSpeech);
        btnList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ListbluetoothActivity.class);
                startActivityForResult(intent, Request_open_bluetooth);

            }
        });

        btnCre.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder dialog = new AlertDialog.Builder(MainActivity.this);
                dialog.setTitle("Thông tin tác giả");
                dialog.setMessage("Tuấn Đoàn \n" + "Cơ điện tử K61 \n" + "Ngày tạo : 04/05/2019 ");
                dialog.setNegativeButton("Ừ", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });
                dialog.create();
                dialog.show();

            }
        });

        imgSpeech.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getSpeechInput();

            }
        });

        btnNamtay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!bluetoothSupport.isConnect()){
                    Toast.makeText(MainActivity.this,"Connect bluetooth",Toast.LENGTH_LONG).show();
                }else{
                        bluetoothSupport.write("n!");

                }
            }
        });

        btnChao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!bluetoothSupport.isConnect()){
                    Toast.makeText(MainActivity.this,"Connect bluetooth",Toast.LENGTH_LONG).show();
                }else {
                    bluetoothSupport.write("c!");
                }
            }
        });

        btnKeo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!bluetoothSupport.isConnect()){
                    Toast.makeText(MainActivity.this,"Connect bluetooth",Toast.LENGTH_LONG).show();
                }else {
                    bluetoothSupport.write("c!");
                }
            }
        });

        btnBua.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!bluetoothSupport.isConnect()){
                    Toast.makeText(MainActivity.this,"Connect bluetooth",Toast.LENGTH_LONG).show();
                }else{
                    bluetoothSupport.write("n!");

                }
            }
        });

        btnHiphop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!bluetoothSupport.isConnect()){
                    Toast.makeText(MainActivity.this,"Connect bluetooth",Toast.LENGTH_LONG).show();
                }else {
                    bluetoothSupport.write("h!");
                }
            }
        });

        btnTro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!bluetoothSupport.isConnect()){
                    Toast.makeText(MainActivity.this,"Connect bluetooth",Toast.LENGTH_LONG).show();
                }else {
                    bluetoothSupport.write("d!");
                }
            }
        });

        btnOK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!bluetoothSupport.isConnect()) {
                    Toast.makeText(MainActivity.this, "Connect bluetooth", Toast.LENGTH_LONG).show();
                } else {
                    bluetoothSupport.write("o!");
                }
            }
        });

        btnBao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!bluetoothSupport.isConnect()) {
                    Toast.makeText(MainActivity.this, "Connect bluetooth", Toast.LENGTH_LONG).show();
                } else {
                    bluetoothSupport.write("d!");
                }
            }
        });



        btnDis.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!bluetoothSupport.isConnect()){
                    Toast.makeText(MainActivity.this,"Connect bluetooth",Toast.LENGTH_LONG).show();
                }else {
                    bluetoothSupport.disConnect();
                    tvTrangthai.setText("DISCONNECT");
                }
            }
        });

        bluetoothSupport.setOnConnectListener(new BluetoothSupport.OnConnect() {
            @Override
            public void connected() {
                bluetoothSupport.isConnect();
                tvTrangthai.setText("CONNECTED");
                tvTrangthai.setTextColor(Color.GREEN);
                progressBar.setVisibility(View.INVISIBLE);
                //imageView.setImageResource(R.drawable.ic_bluetooth_black_24dp);
            }

            @Override
            public void error() {
                tvTrangthai.setText("DISCONNECT");
                tvTrangthai.setTextColor(Color.RED);
                progressBar.setVisibility(View.INVISIBLE);
                //imageView.setImageResource(R.drawable.ic_bluetooth_disabled_black_24dp);

            }
        });


    }
    public void getSpeechInput() {

        if(bluetoothSupport.isConnect()){
            Intent intent = new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
            intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL,RecognizerIntent.LANGUAGE_MODEL_FREE_FORM);
            intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE, Locale.getDefault());
            if(intent.resolveActivity(getPackageManager()) != null) {
                startActivityForResult(intent, 10);
            } else {
                Toast.makeText(this, "aaaa", Toast.LENGTH_LONG);
            }
        } else Toast.makeText(this, "Connect bluetooth", Toast.LENGTH_SHORT).show();

    }

    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==Request_open_bluetooth&&resultCode==RESULT_CANCELED){
            Toast.makeText(MainActivity.this,"Ban nen mo",Toast.LENGTH_LONG).show();
        }
        else if(requestCode==Request_open_bluetooth&&resultCode==RESULT_OK){
            String diachi = data.getStringExtra("addr");
            String ten = data.getStringExtra("ten");
            bluetoothSupport.connect(diachi);
            progressBar.setVisibility(View.VISIBLE);
            tvTrangthai.setText("Connecting ...");
            tvTrangthai.setTextColor(Color.BLUE);

        }
        switch (requestCode){
            case  10:
                if(resultCode == RESULT_OK &&  data !=null){
                    final ArrayList<String> result = data.getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS);
                    //tvResult.setText(result.get(0));
                    toSpeech= new TextToSpeech(MainActivity.this, new TextToSpeech.OnInitListener() {
                        @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
                        @Override
                        public void onInit(int status) {
                            toSpeech.setLanguage(Locale.forLanguageTag(RecognizerIntent.EXTRA_LANGUAGE_MODEL));
                            toSpeech.speak( result.get(0),TextToSpeech.QUEUE_FLUSH,null);
                        }
                    });
                    bluetoothSupport.write(result.get(0)+"!");
                }

                break;
        }
    }
}


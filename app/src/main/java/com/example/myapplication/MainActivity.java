package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;


import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.text.NumberFormat;

public class MainActivity extends AppCompatActivity {
    EditText h;                //宣告全域變數
    EditText w;                //宣告全域變數
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        h = (EditText)findViewById(R.id.et1);                           // 取得身高物件
        w = (EditText)findViewById(R.id.et2);                           // 取得體重物件
        Button submit = (Button)findViewById(R.id.button4);             // 取得按鈕物件 如果ID有誤請回到res->Layout查看預設Button是多少

        // 按下按鈕 觸發事件
        submit.setOnClickListener(new Button.OnClickListener() {
            public void onClick(View arg0) {
                //判斷條件 身高 跟 體重 都有輸入值才執行
                if ( !("".equals(h.getText().toString())
                        || "".equals(w.getText().toString())) )
                {
                    float fh = Float.parseFloat(h.getEditableText().toString());      // 取得 身高輸入值
                    float fw = Float.parseFloat(w.getEditableText().toString());     // 取得 體重輸入值
                    float fresult;// BMI值 計算結果
                    float ideal; //理想體重
                    float normal; //正常體重
                    TextView result = (TextView)findViewById(R.id.tv3);// 取得 顯示結果 物件
                    TextView nor = (TextView)findViewById(R.id.textView4);
                    TextView nor1 = (TextView)findViewById(R.id.textView8);
                    TextView idea = (TextView)findViewById(R.id.textView12);
                    fh = fh/100; // 計算BMI
                    fh = fh*fh;  // 計算BMI

                    NumberFormat nf = NumberFormat.getInstance();   // 數字格式
                    nf.setMaximumFractionDigits(2);                 // 限制小數第二位
                    fresult = fw/fh;                                // 計算BMI
                    result.setText(nf.format(fw/fh) +"");           // 顯示BMI計算結果
                    TextView dia = (TextView)findViewById((R.id.tv4));// 取得 顯示診斷 物件
                    nor.setText(nf.format(fh*22-fh*22*1/10) +"     ~");
                    nor1.setText(nf.format(fh*22+fh*22*1/10) +"");
                    idea.setText(nf.format(fh*22) +"");
                    // 診斷結果 顯示

                    if (fresult<18.5)
                        dia.setText("體重過輕");
                    else if (18.5 <= fresult && fresult< 24)
                        dia.setText("正常範圍");
                    else if (24 <=fresult && fresult < 27)
                        dia.setText("過    重");
                    else if (27 <=fresult && fresult < 30)
                        dia.setText("輕度肥胖");
                    else if (30 <= fresult && fresult < 35)
                        dia.setText("中度肥胖");
                    else if (fresult >= 35)
                        dia.setText("重度肥胖");
                }
            }
        });
    }
}
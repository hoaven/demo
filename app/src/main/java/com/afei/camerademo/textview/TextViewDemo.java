package com.afei.camerademo.textview;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.text.Html;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.widget.TextView;

import com.afei.camerademo.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * author : wangyya
 * date   : 2019/3/15
 */

    /*
    Spanned.SPAN_INCLUSIVE_EXCLUSIVE 从起始下标到终了下标，包括起始下标
    Spanned.SPAN_INCLUSIVE_INCLUSIVE 从起始下标到终了下标，同时包括起始下标和终了下标
    Spanned.SPAN_EXCLUSIVE_EXCLUSIVE 从起始下标到终了下标，但都不包括起始下标和终了下标
     Spanned.SPAN_EXCLUSIVE_INCLUSIVE 从起始下标到终了下标，包括终了下标

     SpannableString的setSpan()方法可以同时使用多个，实现多种效果叠加。
     */
public class TextViewDemo extends Activity {
//    @BindView(R.id.tv_txt)
    private TextView tvTxt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_textview);

//        //绑定初始化ButterKnife
//        ButterKnife.bind(this);

        tvTxt = findViewById(R.id.tv_txt);
//        SpannableString spannableString = new SpannableString("设置文字的前景色为淡蓝色");
//        ForegroundColorSpan colorSpan = new ForegroundColorSpan(Color.parseColor("#0099EE"));
//        spannableString.setSpan(colorSpan, 9, spannableString.length(), Spanned.SPAN_INCLUSIVE_EXCLUSIVE);
//        tvTxt.setText(spannableString);


//        String str = "200.00";
//        String htmlString = "<font color='#6495ED'>颜色</font><br/>" + "<a>链接</a><>br/>" + "<big>大字体</big><br/>"+ "<small>小字体</small><br/>"+ "<b>加粗</b><br/>"+
//                "<i>斜体</i><br/>" + "<h1>标题一</h1>" + "<h2>标题二</h2>" + "<imgsrc='ic_launcher'/>" +
//                "<blockquote>引用</blockquote>" + "<div>块</div>" + "<u>下划线</u><br/>" + "<sup>上标</sup>正常字体<sub>下标</sub><br/>" +
//                "<u><b><font color='@holo_blue_light'><sup><sup>组</sup>合</sup><big>样式</big><sub>字<sub>体</sub></sub></font></b></u>";

        String htmlString = "需要支付"+"<font color = \"#F07600\">"+"变色"+"</font>的字体<br/>"+"需要<b>加粗</b>的字体<br/>"+
                "需要<small>变小</small>的字体<br/>"+"需要<u>下划线</u>的字体<br/>"+"需要<sup>上标</sup>的字体<br/>"+"需要<sub>下标</sub>的字体<br/>";

        tvTxt.setText(Html.fromHtml(htmlString));
    }


}

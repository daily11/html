package com.swust.html;

import android.app.AlertDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.JavascriptInterface;
import android.webkit.WebView;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private int index;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.tiao).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, MuiActivity.class));
            }
        });

//        final WebView webView = findViewById(R.id.wv_http);
//        //开启JavaScript支持
//        webView.getSettings().setJavaScriptEnabled(true);
//        //放在assets的html需加上android_asset/  也可以用网络上的文件
//        webView.loadUrl("file:///android_asset/demo.html");
//
//        Button btn = (Button) findViewById(R.id.btn_http);
//        btn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                String color1 = "#FF8C00";
//                String color2 = "#8DEEEE";
//                if (index == 0) {
//                    webView.loadUrl("javascript: changeColor('" + color1 + "')");
//                    index++;
//                } else {
//                    webView.loadUrl("javascript: changeColor('" + color2 + "')");
//                    index--;
//                }
//            }
//        });
//
//        // 添加一个对象, 让JS可以访问该对象的方法, 该对象中可以调用JS中的方法
//        webView.addJavascriptInterface(new JSInterface1(), "baobao");
    }

    //创建一个内部类
    class JSInterface1 {
        //JavaScript调用此方法
        @JavascriptInterface
        public void showDialog(int a, float b, String c, boolean d) {
            if (d) {
                String strMessage = "a+b+c=" + a + b + c;
                new AlertDialog.Builder(MainActivity.this)
                        .setTitle(c).setMessage(strMessage).show();
            }
        }
    }
}

//<html>
//<head>
//<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
//
//<script type="text/javascript">
//        document.write("Hello World!")
//
//        function changeColor(color){
//        document.body.style.background = color;
//        alert('页面颜色已更改');
//        }
//</script>
//</head>
//
//<body>
//<hr>
//<hr>
//<hr>
//<a onClick="baobao.showDialog(100,100,'标题',true)">点击弹出系统toast</a>
//</body>
//
//</html>

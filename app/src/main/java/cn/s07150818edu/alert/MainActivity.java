package cn.s07150818edu.alert;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;



public class MainActivity extends AppCompatActivity {
    private TextView tv1;
    private AlertDialog.Builder builder;
    private AlertDialog dialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv1= (TextView) findViewById(R.id.textView2);
        Button button1= (Button) this.findViewById(R.id.button1);
        Button button2= (Button) this.findViewById(R.id.button2);
        Button button3= (Button) this.findViewById(R.id.button3);
        Button button4= (Button) this.findViewById(R.id.button4);
        Button button5= (Button) this.findViewById(R.id.button5);
        Button button6= (Button) this.findViewById(R.id.button6);
        Button button7= (Button) this.findViewById(R.id.button7);

        View.OnClickListener listener=new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                switch (view.getId()){
                    case R.id.button1:
                        dialog1();
                        break;
                    case R.id.button2:
                        dialog2();
                        break;
                    case R.id.button3:
                        dialog3();
                        break;
                    case R.id.button4:
                        dialog4();
                        break;
                    case R.id.button5:
                        dialog5();
                        break;
                    case R.id.button6:
                        dialog6();
                        break;
                    case R.id.button7:
                        dialog7();
                        break;
                }
            }
        };
        button1.setOnClickListener(listener);
        button2.setOnClickListener(listener);
        button3.setOnClickListener(listener);
        button4.setOnClickListener(listener);
        button5.setOnClickListener(listener);
        button6.setOnClickListener(listener);
        button7.setOnClickListener(listener);

    }
    public void dialog1(){
        dialog=new AlertDialog.Builder(this).create();
        dialog.setTitle("提示");
        dialog.setMessage("确定退出吗？");
        dialog.setIcon(android.R.drawable.ic_dialog_alert);
        DialogInterface.OnClickListener listener= new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                if(i==DialogInterface.BUTTON_POSITIVE){
                    dialog.dismiss();
                }else if(i==DialogInterface.BUTTON_NEGATIVE){
                    dialog.dismiss();
                }
            }
        };
        dialog.setButton(DialogInterface.BUTTON_POSITIVE,"确定",listener);
        dialog.setButton(DialogInterface.BUTTON_NEGATIVE,"取消",listener);
        dialog.show();
    }
    public void dialog2(){
        dialog=new AlertDialog.Builder(this).create();
        dialog.setTitle("调查");
        dialog.setMessage("你平时忙吗？");
        dialog.setIcon(android.R.drawable.ic_dialog_alert);
        DialogInterface.OnClickListener listener= new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                String str="";
                switch (i){
                    case DialogInterface.BUTTON_POSITIVE:

                        str="平时狠忙";
                        break;
                    case DialogInterface.BUTTON_NEUTRAL:
                        str="平时一般";
                        break;
                    case DialogInterface.BUTTON_NEGATIVE:
                        str="平时轻松";
                        break;
                }
                tv1.setText(str);
            }
        };
        dialog.setButton(DialogInterface.BUTTON_POSITIVE,"忙碌",listener);
        dialog.setButton(DialogInterface.BUTTON_NEGATIVE,"不忙",listener);
        dialog.setButton(DialogInterface.BUTTON_NEUTRAL,"一般",listener);
        dialog.show();
    }

    public void dialog3(){
        dialog=new AlertDialog.Builder(this).create();
        dialog.setTitle("请输入");
        dialog.setMessage("你平时忙吗？");
        dialog.setIcon(android.R.drawable.ic_dialog_info);
        final EditText tEdit=new EditText(this);
        dialog.setView(tEdit);
        DialogInterface.OnClickListener listener= new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                tv1.setText("输入的是:"+tEdit.getText().toString());
            }
        };
        dialog.setButton(DialogInterface.BUTTON_POSITIVE,"确定",listener);

        dialog.show();
    }
    public void dialog4(){
        final String item[]=new String[]{"北京","上海","广州"};
        final boolean bSelect[]=new boolean[item.length];
        DialogInterface.OnMultiChoiceClickListener mList= new DialogInterface.OnMultiChoiceClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i, boolean b) {
                bSelect[i]=b;
            }
        };
        builder=new AlertDialog.Builder(this);
        builder.setMultiChoiceItems(item,null,mList);
        dialog=builder.create();
        dialog.setTitle("复选框");
        DialogInterface.OnClickListener listener= new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                String str="你选择了";
                for (int a=0;a<bSelect.length;a++){
                    if (bSelect[a]){
                        str=str+"\n"+item[a];
                    }
                }
                tv1.setText(str);
            }
        };
        dialog.setButton(DialogInterface.BUTTON_POSITIVE,"确定",listener);
        dialog.show();
    }
    private void dialog5() {
        final String item[]=new String[]{"北京","上海","广州"};
        final boolean bSelect[]=new boolean[item.length];
        DialogInterface.OnClickListener sLis=new DialogInterface.OnClickListener(){

            @Override
            public void onClick(DialogInterface dialog, int which) {
                bSelect[which]=true;
            }
        };
        builder=new AlertDialog.Builder(this);
        builder.setSingleChoiceItems(item,-1,sLis);
        dialog=builder.create();
        dialog.setTitle("单选框");
        DialogInterface.OnClickListener lis1=new DialogInterface.OnClickListener(){

            @Override
            public void onClick(DialogInterface dialog, int which) {
                String str="你选择了:";
                for (int i=0;i<bSelect.length;i++){
                    if(bSelect[i]){
                        str=str+"\n"+item[i];
                    }
                }
                tv1.setText(str);
            }
        };
        dialog.setButton(DialogInterface.BUTTON_POSITIVE,"确定",lis1);
        dialog.show();
    }
    private void dialog6() {
        final String item[]=new String[]{"北京","上海","广州"};
        final boolean bSelect[]=new boolean[item.length];
        DialogInterface.OnClickListener sLis=new DialogInterface.OnClickListener(){

            @Override
            public void onClick(DialogInterface dialog, int which) {
                String str="你选择了:"+item[which];
                tv1.setText(str);
            }
        };
        builder=new AlertDialog.Builder(this);
        builder.setItems(item,sLis);
        dialog=builder.create();
        dialog.setTitle("列表框");
        DialogInterface.OnClickListener lis1=new DialogInterface.OnClickListener(){

            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        };
        dialog.setButton(DialogInterface.BUTTON_NEGATIVE,"取消",lis1);
        dialog.show();
    }
    private void dialog7() {
        LayoutInflater inflater=getLayoutInflater();
        View layout=inflater.inflate(R.layout.diydialog,null);
        final EditText tEdit=(EditText)layout.findViewById(R.id.editText1);
        dialog=new AlertDialog.Builder(this).create();
        dialog.setTitle("自定义布局");
        dialog.setView(layout);
        DialogInterface.OnClickListener lis1=new DialogInterface.OnClickListener(){

            @Override
            public void onClick(DialogInterface dialog, int which) {
                tv1.setText("输入的是:"+tEdit.getText().toString());
            }
        };
        dialog.setButton(DialogInterface.BUTTON_POSITIVE,"确定",lis1);
        dialog.setButton(DialogInterface.BUTTON_NEGATIVE,"取消",lis1);
        dialog.show();
    }
}

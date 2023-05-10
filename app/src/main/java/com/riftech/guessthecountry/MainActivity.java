package com.riftech.guessthecountry;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    String[] countries = new String[]{ "Afghanistan","land Islands","Albania","Algeria","American Samoa","AndorrA","Angola","Anguilla","Antarctica","Antigua and Barbuda","Argentina","Armenia","Aruba","Australia","Austria","Azerbaijan","Bahamas","Bahrain","Bangladesh","Barbados","Belarus","Belgium","Belize","Benin","Bermuda","Bhutan","Bolivia","Bosnia and Herzegovina","Botswana","Bouvet Island","Brazil","British Indian Ocean Territory","Brunei Darussalam","Bulgaria","Burkina Faso","Burundi","Cambodia","Cameroon","Canada","Cape Verde","Cayman Islands","Central African Republic","Chad","Chile","China","Christmas Island","Cocos (Keeling) Islands","Colombia","Comoros","Congo","The Democratic Republic of the Congo","Cook Islands","Costa Rica","Ivory Coast","Croatia","Cuba","Cyprus","Czech Republic","Denmark","Djibouti","Dominica","Dominican Republic","Ecuador","Egypt","El Salvador","Equatorial Guinea","Eritrea","Estonia","Ethiopia","Falkland Islands (Malvinas)","Faroe Islands","Fiji","Finland","France","French Guiana","French Polynesia","French Southern Territories","Gabon","Gambia","Georgia","Germany","Ghana","Gibraltar","Greece","Greenland","Grenada","Guadeloupe","Guam","Guatemala","Guernsey","Guinea","Guinea-Bissau","Guyana","Haiti","Heard Island and Mcdonald Islands","Holy See (Vatican City State)","Honduras","Hong Kong","Hungary","Iceland","India","Indonesia","Islamic Republic Of Iran","Iraq","Ireland","Isle of Man","Israel","Italy","Jamaica","Japan","Jersey","Jordan","Kazakhstan","Kenya","Kiribati", "Democratic People's Republic of Korea","Republic of Korea","Kuwait","Kyrgyzstan","Lao People's Democratic Republic","Latvia","Lebanon","Lesotho","Liberia","Libyan Arab Jamahiriya","Liechtenstein","Lithuania","Luxembourg","Macao","Macedonia, The Former Yugoslav Republic of","Madagascar","Malawi","Malaysia","Maldives","Mali","Malta","Marshall Islands","Martinique","Mauritania","Mauritius","Mayotte","Mexico","Micronesia,Federated States of","Moldova,Republic of","Monaco","Mongolia","Montenegro", "Montserrat","Morocco","Mozambique","Myanmar","Namibia","Nauru","Nepal","Netherlands","New Caledonia","New Zealand","Nicaragua","Niger","Nigeria","Niue","Norfolk Island","Northern Mariana Islands","Norway","Oman","Pakistan","Palau","Palestinian Territory, Occupied","Panama","Papua New Guinea","Paraguay","Peru","Philippines","Pitcairn","Poland","Portugal","Puerto Rico","Qatar","Reunion","Romania","Russian Federation","RWANDA","Saint Helena","Saint Kitts and Nevis","Saint Lucia","Saint Pierre and Miquelon","Saint Vincent and the Grenadines","Samoa","San Marino","Sao Tome and Principe","Saudi Arabia","Senegal","Serbia","Seychelles","Sierra Leone","Singapore","Slovakia","Slovenia","Solomon Islands","Somalia","South Africa","South Georgia and the South Sandwich Islands","Spain","Sri Lanka","Sudan","Suriname","Svalbard and Jan Mayen","Swaziland","Sweden","Switzerland","Syrian Arab Republic","Taiwan, Province of China","Tajikistan","Tanzania, United Republic of","Thailand","Timor-Leste","Togo","Tokelau","Tonga","Trinidad and Tobago","Tunisia","Turkey","Turkmenistan","Turks and Caicos Islands","Tuvalu","Uganda","Ukraine","United Arab Emirates","United Kingdom","United States","United States Minor Outlying Islands","Uruguay","Uzbekistan","Vanuatu","Venezuela","Viet Nam","Virgin Islands, British","Virgin Islands, U.S.","Wallis and Futuna","Western Sahara","Yemen","Zambia","Zimbabwe"};
    int[] codes = new int[]{R.drawable.af,R.drawable.ax,R.drawable.al,R.drawable.dz,R.drawable.as,R.drawable.ad,R.drawable.ao,R.drawable.ai,R.drawable.aq,R.drawable.ag,R.drawable.ar,R.drawable.am,R.drawable.aw,R.drawable.au,R.drawable.at,R.drawable.az,R.drawable.bs,R.drawable.bh,R.drawable.bd,R.drawable.bb,R.drawable.by,R.drawable.be,R.drawable.bz,R.drawable.bj,R.drawable.bm,R.drawable.bt,R.drawable.bo,R.drawable.ba,R.drawable.bw,R.drawable.bv,R.drawable.br,R.drawable.io,R.drawable.bn,R.drawable.bg,R.drawable.bf,R.drawable.bi,R.drawable.kh,R.drawable.cm,R.drawable.ca,R.drawable.cv,R.drawable.ky,R.drawable.cf,R.drawable.td,R.drawable.cl,R.drawable.cn,R.drawable.cx,R.drawable.cc,R.drawable.co,R.drawable.km,R.drawable.cg,R.drawable.cd,R.drawable.ck,R.drawable.cr,R.drawable.ci,R.drawable.hr,R.drawable.cu,R.drawable.cy,R.drawable.cz,R.drawable.dk,R.drawable.dj,R.drawable.dm,R.drawable.dom,R.drawable.ec,R.drawable.eg,R.drawable.sv,R.drawable.gq,R.drawable.er,R.drawable.ee,R.drawable.et,R.drawable.fk,R.drawable.fo,R.drawable.fj,R.drawable.fi,R.drawable.fr,R.drawable.gf,R.drawable.pf,R.drawable.tf,R.drawable.ga,R.drawable.gm,R.drawable.ge,R.drawable.de,R.drawable.gh,R.drawable.gi,R.drawable.gr,R.drawable.gl,R.drawable.gd,R.drawable.gp,R.drawable.gu,R.drawable.gt,R.drawable.gg,R.drawable.gn,R.drawable.gw,R.drawable.gy,R.drawable.ht,R.drawable.hm,R.drawable.va,R.drawable.hn,R.drawable.hk,R.drawable.hu,R.drawable.is,R.drawable.in,R.drawable.id,R.drawable.ir,R.drawable.iq,R.drawable.ie,R.drawable.im,R.drawable.il,R.drawable.it,R.drawable.jm,R.drawable.jp,R.drawable.je,R.drawable.jo,R.drawable.kz,R.drawable.ke,R.drawable.ki,R.drawable.kp,R.drawable.kr,R.drawable.kw,R.drawable.kg,R.drawable.la,R.drawable.lv,R.drawable.lb,R.drawable.ls,R.drawable.lr,R.drawable.ly,R.drawable.li,R.drawable.lt,R.drawable.lu,R.drawable.mo,R.drawable.mk,R.drawable.mg,R.drawable.mw,R.drawable.my,R.drawable.mv,R.drawable.ml,R.drawable.mt,R.drawable.mh,R.drawable.mq,R.drawable.mr,R.drawable.mu,R.drawable.yt,R.drawable.mx,R.drawable.fm,R.drawable.md,R.drawable.mc,R.drawable.mn,R.drawable.me,R.drawable.ms,R.drawable.ma,R.drawable.mz,R.drawable.mm,R.drawable.na,R.drawable.nr,R.drawable.np,R.drawable.nl,R.drawable.nc,R.drawable.nz,R.drawable.ni,R.drawable.ne,R.drawable.ng,R.drawable.nu,R.drawable.nf,R.drawable.mp,R.drawable.no,R.drawable.om,R.drawable.pk,R.drawable.pw,R.drawable.ps,R.drawable.pa,R.drawable.pg,R.drawable.py,R.drawable.pe,R.drawable.ph,R.drawable.pn,R.drawable.pl,R.drawable.pt,R.drawable.pr,R.drawable.qa,R.drawable.re,R.drawable.ro,R.drawable.ru,R.drawable.rw,R.drawable.sh,R.drawable.kn,R.drawable.lc,R.drawable.pm,R.drawable.vc,R.drawable.ws,R.drawable.sm,R.drawable.st,R.drawable.sa,R.drawable.sn,R.drawable.rs,R.drawable.sc,R.drawable.sl,R.drawable.sg,R.drawable.sk,R.drawable.si,R.drawable.sb,R.drawable.so,R.drawable.za,R.drawable.gs,R.drawable.es,R.drawable.lk,R.drawable.sd,R.drawable.sr,R.drawable.sj,R.drawable.sz,R.drawable.se,R.drawable.ch,R.drawable.sy,R.drawable.tw,R.drawable.tj,R.drawable.tz,R.drawable.th,R.drawable.tl,R.drawable.tg,R.drawable.tk,R.drawable.to,R.drawable.tt,R.drawable.tn,R.drawable.tr,R.drawable.tm,R.drawable.tc,R.drawable.tv,R.drawable.ug,R.drawable.ua,R.drawable.ae,R.drawable.gb,R.drawable.us,R.drawable.um,R.drawable.uy,R.drawable.uz,R.drawable.vu,R.drawable.ve,R.drawable.vn,R.drawable.vg,R.drawable.vi,R.drawable.wf,R.drawable.eh,R.drawable.ye,R.drawable.zm,R.drawable.zw};

    ImageView img;
TextView txt;
    Handler handler;
    Runnable runnable;
    Boolean st_n,st_n2=false;
    MediaPlayer music,music2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btn=(Button) findViewById(R.id.button);
        img=(ImageView) findViewById(R.id.imageView);
        txt=(TextView) findViewById(R.id.textView);
        music = MediaPlayer.create(MainActivity.this, R.raw.s2);
        music.setLooping(true);

        //music2 = MediaPlayer.create(MainActivity.this, R.raw.co);
        //music2.setLooping(true);


        btn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                txt.setText("");
                st_n=true;
                if(!st_n2){
                    startImageTimer();
                }




            }
        });
    }

    private int currentIndex = 0;

    // Call this method to start changing the image every 5 seconds
    private void startImageTimer() {
st_n2=true;
        music.start();
       handler = new Handler();
       runnable = new Runnable() {
            @Override
            public void run() {
                // Change the image
                Random random=new Random();
                int a=random.nextInt(150 - 0 + 1) + 0;

                //Toast toast = Toast.makeText(getApplicationContext(),a+","+countries[a], Toast.LENGTH_SHORT);
                //toast.show();
                img.setImageResource(codes[a]);


                // Increment the index
                currentIndex++;
              if (currentIndex == 15) {
                    currentIndex = 0;
                    //handler.removeCallbacks(runnable);
                    st_n=false;
                  st_n2=false;
                  music.pause();
                    showtext(a);
                    //txt.setText(countries[a]);

                }else{
                    handler.postDelayed(this, 100);
                }

                // Call this method again after 5 seconds

            }
        };
        handler.postDelayed(runnable, 100);
    }
    private int count = 10;
    // Call this method to stop changing the image
    private void showtext(int a) {

        //music2.seekTo(0);
        //music2.start();
        handler = new Handler();
        runnable = new Runnable() {
            @Override
            public void run() {



                //Toast toast = Toast.makeText(getApplicationContext(),a+","+countries[a], Toast.LENGTH_SHORT);
                //toast.show();



                // Increment the index
                count--;
                if(st_n){
                    //music2.pause();
                    count = 10;
                }
                else if (count < 0) {
                    count = 10;
                    //music2.pause();
                    txt.setText(countries[a]);

                } else{
                    txt.setText(""+count);
                    handler.postDelayed(this, 1000);
                }

                // Call this method again after 5 seconds

            }
        };
        handler.postDelayed(runnable, 1000);
    }

    private void stophandler(){
        handler.removeCallbacksAndMessages(runnable);
    }

}
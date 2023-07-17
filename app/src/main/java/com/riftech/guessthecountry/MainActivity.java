package com.riftech.guessthecountry;

import static android.content.ContentValues.TAG;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.ads.AdError;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.FullScreenContentCallback;
import com.google.android.gms.ads.LoadAdError;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;
import com.google.android.gms.ads.interstitial.InterstitialAd;
import com.google.android.gms.ads.interstitial.InterstitialAdLoadCallback;
import com.google.android.ump.ConsentDebugSettings;
import com.google.android.ump.ConsentForm;
import com.google.android.ump.ConsentInformation;
import com.google.android.ump.ConsentRequestParameters;
import com.google.android.ump.FormError;
import com.google.android.ump.UserMessagingPlatform;

import java.io.IOException;
import java.util.Locale;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    //String[] countries = new String[]{ "Afghanistan","land Islands","Albania","Algeria","American Samoa","AndorrA","Angola","Anguilla","Antarctica","Antigua and Barbuda","Argentina","Armenia","Aruba","Australia","Austria","Azerbaijan","Bahamas","Bahrain","Bangladesh","Barbados","Belarus","Belgium","Belize","Benin","Bermuda","Bhutan","Bolivia","Bosnia and Herzegovina","Botswana","Bouvet Island","Brazil","British Indian Ocean Territory","Brunei Darussalam","Bulgaria","Burkina Faso","Burundi","Cambodia","Cameroon","Canada","Cape Verde","Cayman Islands","Central African Republic","Chad","Chile","China","Christmas Island","Cocos (Keeling) Islands","Colombia","Comoros","Congo","The Democratic Republic of the Congo","Cook Islands","Costa Rica","Ivory Coast","Croatia","Cuba","Cyprus","Czech Republic","Denmark","Djibouti","Dominica","Dominican Republic","Ecuador","Egypt","El Salvador","Equatorial Guinea","Eritrea","Estonia","Ethiopia","Falkland Islands (Malvinas)","Faroe Islands","Fiji","Finland","France","French Guiana","French Polynesia","French Southern Territories","Gabon","Gambia","Georgia","Germany","Ghana","Gibraltar","Greece","Greenland","Grenada","Guadeloupe","Guam","Guatemala","Guernsey","Guinea","Guinea-Bissau","Guyana","Haiti","Heard Island and Mcdonald Islands","Holy See (Vatican City State)","Honduras","Hong Kong","Hungary","Iceland","India","Indonesia","Islamic Republic Of Iran","Iraq","Ireland","Isle of Man","Israel","Italy","Jamaica","Japan","Jersey","Jordan","Kazakhstan","Kenya","Kiribati", "Democratic People's Republic of Korea","Republic of Korea","Kuwait","Kyrgyzstan","Lao People's Democratic Republic","Latvia","Lebanon","Lesotho","Liberia","Libyan Arab Jamahiriya","Liechtenstein","Lithuania","Luxembourg","Macao","Macedonia, The Former Yugoslav Republic of","Madagascar","Malawi","Malaysia","Maldives","Mali","Malta","Marshall Islands","Martinique","Mauritania","Mauritius","Mayotte","Mexico","Micronesia,Federated States of","Moldova,Republic of","Monaco","Mongolia","Montenegro", "Montserrat","Morocco","Mozambique","Myanmar","Namibia","Nauru","Nepal","Netherlands","New Caledonia","New Zealand","Nicaragua","Niger","Nigeria","Niue","Norfolk Island","Northern Mariana Islands","Norway","Oman","Pakistan","Palau","Palestinian Territory, Occupied","Panama","Papua New Guinea","Paraguay","Peru","Philippines","Pitcairn","Poland","Portugal","Puerto Rico","Qatar","Reunion","Romania","Russian Federation","RWANDA","Saint Helena","Saint Kitts and Nevis","Saint Lucia","Saint Pierre and Miquelon","Saint Vincent and the Grenadines","Samoa","San Marino","Sao Tome and Principe","Saudi Arabia","Senegal","Serbia","Seychelles","Sierra Leone","Singapore","Slovakia","Slovenia","Solomon Islands","Somalia","South Africa","South Georgia and the South Sandwich Islands","Spain","Sri Lanka","Sudan","Suriname","Svalbard and Jan Mayen","Swaziland","Sweden","Switzerland","Syrian Arab Republic","Taiwan, Province of China","Tajikistan","Tanzania, United Republic of","Thailand","Timor-Leste","Togo","Tokelau","Tonga","Trinidad and Tobago","Tunisia","Turkey","Turkmenistan","Turks and Caicos Islands","Tuvalu","Uganda","Ukraine","United Arab Emirates","United Kingdom","United States","United States Minor Outlying Islands","Uruguay","Uzbekistan","Vanuatu","Venezuela","Viet Nam","Virgin Islands, British","Virgin Islands, U.S.","Wallis and Futuna","Western Sahara","Yemen","Zambia","Zimbabwe"};

    int[] codes = new int[]{R.drawable.af,R.drawable.ax,R.drawable.al,R.drawable.dz,R.drawable.as,R.drawable.ad,R.drawable.ao,R.drawable.ai,R.drawable.aq,R.drawable.ag,R.drawable.ar,R.drawable.am,R.drawable.aw,R.drawable.au,R.drawable.at,R.drawable.az,R.drawable.bs,R.drawable.bh,R.drawable.bd,R.drawable.bb,R.drawable.by,R.drawable.be,R.drawable.bz,R.drawable.bj,R.drawable.bm,R.drawable.bt,R.drawable.bo,R.drawable.ba,R.drawable.bw,R.drawable.bv,R.drawable.br,R.drawable.io,R.drawable.bn,R.drawable.bg,R.drawable.bf,R.drawable.bi,R.drawable.kh,R.drawable.cm,R.drawable.ca,R.drawable.cv,R.drawable.ky,R.drawable.cf,R.drawable.td,R.drawable.cl,R.drawable.cn,R.drawable.cx,R.drawable.cc,R.drawable.co,R.drawable.km,R.drawable.cg,R.drawable.cd,R.drawable.ck,R.drawable.cr,R.drawable.ci,R.drawable.hr,R.drawable.cu,R.drawable.cy,R.drawable.cz,R.drawable.dk,R.drawable.dj,R.drawable.dm,R.drawable.dom,R.drawable.ec,R.drawable.eg,R.drawable.sv,R.drawable.gq,R.drawable.er,R.drawable.ee,R.drawable.et,R.drawable.fk,R.drawable.fo,R.drawable.fj,R.drawable.fi,R.drawable.fr,R.drawable.gf,R.drawable.pf,R.drawable.tf,R.drawable.ga,R.drawable.gm,R.drawable.ge,R.drawable.de,R.drawable.gh,R.drawable.gi,R.drawable.gr,R.drawable.gl,R.drawable.gd,R.drawable.gp,R.drawable.gu,R.drawable.gt,R.drawable.gg,R.drawable.gn,R.drawable.gw,R.drawable.gy,R.drawable.ht,R.drawable.hm,R.drawable.va,R.drawable.hn,R.drawable.hk,R.drawable.hu,R.drawable.is,R.drawable.in,R.drawable.id,R.drawable.ir,R.drawable.iq,R.drawable.ie,R.drawable.im,R.drawable.il,R.drawable.it,R.drawable.jm,R.drawable.jp,R.drawable.je,R.drawable.jo,R.drawable.kz,R.drawable.ke,R.drawable.ki,R.drawable.kp,R.drawable.kr,R.drawable.kw,R.drawable.kg,R.drawable.la,R.drawable.lv,R.drawable.lb,R.drawable.ls,R.drawable.lr,R.drawable.ly,R.drawable.li,R.drawable.lt,R.drawable.lu,R.drawable.mo,R.drawable.mk,R.drawable.mg,R.drawable.mw,R.drawable.my,R.drawable.mv,R.drawable.ml,R.drawable.mt,R.drawable.mh,R.drawable.mq,R.drawable.mr,R.drawable.mu,R.drawable.yt,R.drawable.mx,R.drawable.fm,R.drawable.md,R.drawable.mc,R.drawable.mn,R.drawable.me,R.drawable.ms,R.drawable.ma,R.drawable.mz,R.drawable.mm,R.drawable.na,R.drawable.nr,R.drawable.np,R.drawable.nl,R.drawable.nc,R.drawable.nz,R.drawable.ni,R.drawable.ne,R.drawable.ng,R.drawable.nu,R.drawable.nf,R.drawable.mp,R.drawable.no,R.drawable.om,R.drawable.pk,R.drawable.pw,R.drawable.ps,R.drawable.pa,R.drawable.pg,R.drawable.py,R.drawable.pe,R.drawable.ph,R.drawable.pn,R.drawable.pl,R.drawable.pt,R.drawable.pr,R.drawable.qa,R.drawable.re,R.drawable.ro,R.drawable.ru,R.drawable.rw,R.drawable.sh,R.drawable.kn,R.drawable.lc,R.drawable.pm,R.drawable.vc,R.drawable.ws,R.drawable.sm,R.drawable.st,R.drawable.sa,R.drawable.sn,R.drawable.rs,R.drawable.sc,R.drawable.sl,R.drawable.sg,R.drawable.sk,R.drawable.si,R.drawable.sb,R.drawable.so,R.drawable.za,R.drawable.gs,R.drawable.es,R.drawable.lk,R.drawable.sd,R.drawable.sr,R.drawable.sj,R.drawable.sz,R.drawable.se,R.drawable.ch,R.drawable.sy,R.drawable.tw,R.drawable.tj,R.drawable.tz,R.drawable.th,R.drawable.tl,R.drawable.tg,R.drawable.tk,R.drawable.to,R.drawable.tt,R.drawable.tn,R.drawable.tr,R.drawable.tm,R.drawable.tc,R.drawable.tv,R.drawable.ug,R.drawable.ua,R.drawable.ae,R.drawable.gb,R.drawable.us,R.drawable.um,R.drawable.uy,R.drawable.uz,R.drawable.vu,R.drawable.ve,R.drawable.vn,R.drawable.vg,R.drawable.vi,R.drawable.wf,R.drawable.eh,R.drawable.ye,R.drawable.zm,R.drawable.zw};
    private InterstitialAd mInterstitialAd;
    ImageView img;
TextView txt;
    Handler handler;
    Runnable runnable;
    Boolean st_n,st_n2=false;
    MediaPlayer music,music2;
    private AdView mAdView;
    AlertDialog.Builder builder;
    AlertDialog customAlertDialog;
    SharedPreferences sharedPreferences;
    String selected_lang,st;
    String[] countries;
    int selected_index;
    Button btn;
    private ConsentInformation consentInformation;
    private ConsentForm consentForm;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        ConsentDebugSettings debugSettings = new ConsentDebugSettings.Builder(this)
//                .setDebugGeography(ConsentDebugSettings.DebugGeography.DEBUG_GEOGRAPHY_EEA)
//                .addTestDeviceHashedId("C0C3585D7681D1732E0C5A43C804A1C6")
//                .build();
//
//
//        ConsentRequestParameters params = new ConsentRequestParameters
//                .Builder()
//                .setConsentDebugSettings(debugSettings)
//                .build();



        // Set tag for under age of consent. false means users are not under
        // age.
        ConsentRequestParameters params = new ConsentRequestParameters
                .Builder()
                .setTagForUnderAgeOfConsent(false)
                .build();

        consentInformation = UserMessagingPlatform.getConsentInformation(this);
        consentInformation.requestConsentInfoUpdate(
                this,
                params,
                new ConsentInformation.OnConsentInfoUpdateSuccessListener() {
                    @Override
                    public void onConsentInfoUpdateSuccess() {
                        // The consent information state was updated.
                        // You are now ready to check if a form is available.

                        if (consentInformation.isConsentFormAvailable()) {

                            loadForm();
                        }
                    }
                },
                new ConsentInformation.OnConsentInfoUpdateFailureListener() {
                    @Override
                    public void onConsentInfoUpdateFailure(FormError formError) {
                        // Handle the error.
                   }
                });




        // Storing data into SharedPreferences
         sharedPreferences = getSharedPreferences("MySharedPref",MODE_PRIVATE);
        if(!sharedPreferences.contains("index")) {
// Creating an Editor object to edit(write to the file)
            SharedPreferences.Editor myEdit = sharedPreferences.edit();

// Storing the key and its value as the data fetched from edittext
            myEdit.putInt("index",0);

// Once the changes have been made, we need to commit to apply those changes made,
// otherwise, it will throw an error
            myEdit.apply();
        }


//if(selected_index==1){
//    Locale locale = Locale.forLanguageTag("es");
//    Locale.setDefault(locale);
//    Configuration config = getBaseContext().getResources().getConfiguration();
//    config.locale = locale;
//    getBaseContext().getResources().updateConfiguration(config,
//            getBaseContext().getResources().getDisplayMetrics());
//
//} else if (selected_index==2) {
//    Locale locale = Locale.forLanguageTag("fr");
//    Locale.setDefault(locale);
//    Configuration config = getBaseContext().getResources().getConfiguration();
//    config.locale = locale;
//    getBaseContext().getResources().updateConfiguration(config,
//            getBaseContext().getResources().getDisplayMetrics());
//}


        MobileAds.initialize(this, new OnInitializationCompleteListener() {
            @Override
            public void onInitializationComplete(InitializationStatus initializationStatus) {
            }
        });



        mAdView = findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);

        loadAd();

        btn=(Button) findViewById(R.id.button);

        img=(ImageView) findViewById(R.id.imageView);
        txt=(TextView) findViewById(R.id.textView);
        music = MediaPlayer.create(MainActivity.this, R.raw.s2);
        music.setLooping(true);

        //music2 = MediaPlayer.create(MainActivity.this, R.raw.co);
        //music2.setLooping(true);



        changelang();







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
                    showInterstitial();

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

    public void loadAd() {
        AdRequest adRequest2 = new AdRequest.Builder().build();
//ca-app-pub-3940256099942544/1033173712
//ca-app-pub-7831928589958637/6704201737
        InterstitialAd.load(this,getString(R.string.interestial), adRequest2,
                new InterstitialAdLoadCallback() {
                    @Override
                    public void onAdLoaded(@NonNull InterstitialAd interstitialAd) {
                        // The mInterstitialAd reference will be null until
                        // an ad is loaded.
                        mInterstitialAd = interstitialAd;
                        Log.i(TAG, "onAdLoaded");
                        //Toast.makeText(MainActivity.this, "onAdLoaded()", Toast.LENGTH_SHORT).show();
                        interstitialAd.setFullScreenContentCallback(
                                new FullScreenContentCallback() {
                                    @Override
                                    public void onAdDismissedFullScreenContent() {
                                        // Called when fullscreen content is dismissed.
                                        // Make sure to set your reference to null so you don't
                                        // show it a second time.
                                        MainActivity.this.mInterstitialAd = null;
                                        Log.d("TAG", "The ad was dismissed.");

                                        //gotoActivity(intent);
                                        //dismissed();

                                    }

                                    @Override
                                    public void onAdFailedToShowFullScreenContent(AdError adError) {
                                        // Called when fullscreen content failed to show.
                                        // Make sure to set your reference to null so you don't
                                        // show it a second time.
                                        MainActivity.this.mInterstitialAd = null;
                                        Log.d("TAG", "The ad failed to show.");
                                    }

                                    @Override
                                    public void onAdShowedFullScreenContent() {
                                        // Called when fullscreen content is shown.
                                        Log.d("TAG", "The ad was shown.");
                                    }
                                });
                    }

                    @Override
                    public void onAdFailedToLoad(@NonNull LoadAdError loadAdError) {
                        // Handle the error
                        Log.i(TAG, loadAdError.getMessage());
                        mInterstitialAd = null;
                       /* String error =
                                String.format(
                                        "domain: %s, code: %d, message: %s",
                                        loadAdError.getDomain(), loadAdError.getCode(), loadAdError.getMessage());
                        Toast.makeText(
                                MainActivity.this, "onAdFailedToLoad() with error: " + error, Toast.LENGTH_SHORT)
                                .show();*/
                    }

                });
    }

    private void showInterstitial() {
        // Show the ad if it's ready. Otherwise toast and restart the game.
        if (mInterstitialAd != null) {
            mInterstitialAd.show(this);


        }

        else {
            //Toast.makeText(this, "Ad did not load", Toast.LENGTH_SHORT).show();
            loadAd();

            //startGame();
        }
    }

    // create an action bar button
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // R.menu.mymenu is a reference to an xml file named mymenu.xml which should be inside your res/menu directory.
        // If you don't have res/menu, just create a directory named "menu" inside res
        getMenuInflater().inflate(R.menu.change, menu);
        return super.onCreateOptionsMenu(menu);
    }

    // handle button activities
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.action_favorite) {
            // do something here
            // single item array instance to store which element is selected by user initially
            // it should be set to zero meaning none of the element is selected by default
            selected_index = sharedPreferences.getInt("index", 0);
            final int[] checkedItem = {selected_index};

            // AlertDialog builder instance to build the alert dialog
            builder = new AlertDialog.Builder(MainActivity.this);

            // set the custom icon to the alert dialog
            builder.setIcon(R.drawable.change);

            // title of the alert dialog
            builder.setTitle("Change Language:");

            // list of the items to be displayed to the user in the
            // form of list so that user can select the item from
            final String[] listItems = new String[]{"English", "Español", "Français", "Italiano","Deutsch","Português","Русский"};


            // the function setSingleChoiceItems is the function which
            // builds the alert dialog with the single item selection
            builder.setSingleChoiceItems(listItems, checkedItem[0], (dialog, which) -> {
                // update the selected item which is selected by the user so that it should be selected
                // when user opens the dialog next time and pass the instance to setSingleChoiceItems method
                checkedItem[0] = which;

                // now also update the TextView which previews the selected item
                //tvSelectedItemPreview.setText("Selected Item is : " + listItems[which]);




                SharedPreferences.Editor myEdit = sharedPreferences.edit();

// Storing the key and its value as the data fetched from edittext
                myEdit.putInt("index",which);

// Once the changes have been made, we need to commit to apply those changes made,
// otherwise, it will throw an error
                myEdit.apply();

                changelang();
                // when selected an item the dialog should be closed with the dismiss method
                dialog.dismiss();


            });

            // set the negative button if the user is not interested to select or change already selected item
            builder.setNegativeButton("Cancel", (dialog, which) -> {

            });

            // create and build the AlertDialog instance with the AlertDialog builder instance
            customAlertDialog = builder.create();

            // show the alert dialog when the button is clicked
            customAlertDialog.show();
        }
        return super.onOptionsItemSelected(item);
    }

    public void changelang() {
        selected_index = sharedPreferences.getInt("index", 0);
        switch (selected_index){
            case 0:
                st=getString(R.string.country);
                countries = st.split(",");
                btn.setText(getText(R.string.btn));
                this.setTitle(getString(R.string.app_name));
                break;
            case 1:
                st=getString(R.string.country_es);
                countries = st.split(",");
                btn.setText(getText(R.string.btn_es));
                this.setTitle(getString(R.string.app_name_es));
                break;
            case 2:
                st=getString(R.string.country_fr);
                countries = st.split(",");
                btn.setText(getText(R.string.btn_fr));
                this.setTitle(getString(R.string.app_name_fr));
                break;
            case 3:
                st=getString(R.string.country_it);
                countries = st.split(",");
                btn.setText(getText(R.string.btn_it));
                this.setTitle(getString(R.string.app_name_it));
                break;
            case 4:
                st=getString(R.string.country_de);
                countries = st.split(",");
                btn.setText(getText(R.string.btn_de));
                this.setTitle(getString(R.string.app_name_de));
                break;
            case 5:
                st=getString(R.string.country_pt);
                countries = st.split(",");
                btn.setText(getText(R.string.btn_pt));
                this.setTitle(getString(R.string.app_name_pt));
                break;
            case 6:
                st=getString(R.string.country_ru);
                countries = st.split(",");
                btn.setText(getText(R.string.btn_ru));
                this.setTitle(getString(R.string.app_name_ru));
                break;
            default:
                st=getString(R.string.country);
                countries = st.split(",");
                btn.setText(getText(R.string.btn));
                this.setTitle(getString(R.string.app_name));
                break;
        }

    }

    public void loadForm() {
        // Loads a consent form. Must be called on the main thread.
        UserMessagingPlatform.loadConsentForm(
                this,
                new UserMessagingPlatform.OnConsentFormLoadSuccessListener() {
                    @Override
                    public void onConsentFormLoadSuccess(ConsentForm consentForm) {
                        MainActivity.this.consentForm = consentForm;
                        if (consentInformation.getConsentStatus() == ConsentInformation.ConsentStatus.REQUIRED) {
                            consentForm.show(
                                    MainActivity.this,
                                    new ConsentForm.OnConsentFormDismissedListener() {
                                        @Override
                                        public void onConsentFormDismissed(@Nullable FormError formError) {
                                            if (consentInformation.getConsentStatus() == ConsentInformation.ConsentStatus.OBTAINED) {
                                                // App can start requesting ads.
                                            }

                                            // Handle dismissal by reloading form.
                                            loadForm();
                                        }
                                    });
                        }
                    }
                },
                new UserMessagingPlatform.OnConsentFormLoadFailureListener() {
                    @Override
                    public void onConsentFormLoadFailure(FormError formError) {
                        // Handle the error.
                 }
                }
        );
    }

}
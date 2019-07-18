package com.example.picasodemo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private final String novel_urls[] = {

            "https://jamesclear.com/wp-content/uploads/2017/04/All-the-Light-We-Cannot-See-by-Anthony-Doerr-466x700.jpg",
            "https://images-na.ssl-images-amazon.com/images/I/81bNQ0lAIRL.jpg",
            "https://i.pinimg.com/originals/b1/df/46/b1df46c3eea2b06765b17fb21129a3a2.png",
            "https://images.gr-assets.com/books/1370290524l/18029845.jpg",
            "https://i.pinimg.com/originals/94/d0/99/94d0999a8f1ab2f53322fa25388c4377.jpg",
            "https://prodimage.images-bn.com/pimages/9789380028293_p0_v1_s550x406.jpg",
            "https://images-na.ssl-images-amazon.com/images/I/41tdMBpLpML._SX322_BO1,204,203,200_.jpg",
            "https://images-na.ssl-images-amazon.com/images/I/81bsw6fnUiL.jpg",
            "https://images-na.ssl-images-amazon.com/images/I/81phwRtlzCL.jpg",
            "https://images-eu.ssl-images-amazon.com/images/I/51OMjRQmt8L.jpg",
    };
    private final String android_image_urls1[] = {
            "http://andhraboxoffice.com/uploads/Review/D98774416.JPG",
            "https://m.media-amazon.com/images/M/MV5BMTU3MTQyNjQwM15BMl5BanBnXkFtZTgwNDgxNDczNTM@._V1_.jpg",
            "https://i.pinimg.com/originals/bc/bb/eb/bcbbebfd00bfcbc5466558ea6ea5987b.jpg",
            "http://t0.gstatic.com/images?q=tbn:ANd9GcSfuUa1hClKn0inW8MAwEs1iPR8mu79_pFsk1I3Cr0ciV-XeoCO",
            "https://www.washingtonpost.com/graphics/2019/entertainment/oscar-nominees-movie-poster-design/img/black-panther-web.jpg",
            "https://cinema.mu/wp-content/uploads/2018/05/parmanu-eng.jpg",
            "https://ib3.hulu.com/user/v3/artwork/ac4e0d94-5b00-4c3c-8375-0e4a919ba6a7?base_image_bucket_name=image_manager&base_image=ae50c7b0-19ce-40ad-ba78-f5ca447fbc69&size=400x600&format=jpeg",
            "https://peopledotcom.files.wordpress.com/2019/03/avengers-endgame.jpg",
            "https://www.filmibeat.com/ph-big/2018/04/raazi-poster_15232698420.jpg",
            "https://m.media-amazon.com/images/M/MV5BN2VlY2E2ZGMtNjRiMy00OWUwLWJmZmItYzIwNjcyODE2MDliXkEyXkFqcGdeQXVyNjE1OTQ0NjA@._V1_.jpg",

    };
    private final String android_image_urls2[] = {
            "https://usercontent2.hubstatic.com/13303645_f520.jpg",
            "https://sharmajiinfinity.com/wp-content/uploads/2019/04/Webp.net-compress-image-2-1.jpg",
            "https://www.easons.com/globalassets/dvds/jansale/got1.jpg",
            "https://usercontent2.hubstatic.com/13303647_f520.jpg",
            "https://static1.tvfplay.com/cpp%2Fs3fs-public%2Ftvf%2Fseries%2F3%2Foriginal%2Fa3%2Fen%2Fa3_xl_large%2Fba600a4c5887c519a23a163b1d112e10_PR%25201080x1920.jpg",

            "http://www.gstatic.com/tv/thumb/tvbanners/15720821/p15720821_b_v8_ab.jpg",

            "https://images-na.ssl-images-amazon.com/images/I/91kN9Bba8fL._SY550_.jpg",
            "http://www.gstatic.com/tv/thumb/tvbanners/15844533/p15844533_b_v12_ad.jpg",
            "http://www.coverwhiz.com/content/Prison-Break-Season-3.jpg",
    };
    View ChildView,ChildView1,ChildView2 ;
    int RecyclerViewItemPosition,RecyclerViewItemPosition1,RecyclerViewItemPosition2 ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initViews();
    }

    private void initViews(){
        final RecyclerView recyclerView = (RecyclerView)findViewById(R.id.recycler);
        RecyclerView recyclerView1 = (RecyclerView)findViewById(R.id.recycler1);
        RecyclerView recyclerView2 = (RecyclerView)findViewById(R.id.recycler2);

        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.HORIZONTAL, false));
        ArrayList androidVersions = prepareData();
        DataAdapter adapter = new DataAdapter(getApplicationContext(),androidVersions);
        recyclerView.setAdapter(adapter);

        recyclerView1.setLayoutManager(new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.HORIZONTAL, false));
        ArrayList androidVersions1 = prepareData1
                ();
        DataAdapter adapter1 = new DataAdapter(getApplicationContext(),androidVersions1);
        recyclerView1.setAdapter(adapter1);

        recyclerView2.setLayoutManager(new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.HORIZONTAL, false));
        ArrayList androidVersions2 = prepareData2();
        DataAdapter adapter2 = new DataAdapter(getApplicationContext(),androidVersions2);
        recyclerView2.setAdapter(adapter2);

        recyclerView2.addOnItemTouchListener(new RecyclerView.OnItemTouchListener() {
            GestureDetector gestureDetector = new GestureDetector(MainActivity.this, new GestureDetector.SimpleOnGestureListener() {
                @Override public boolean onSingleTapUp(MotionEvent motionEvent) {
                    return true;
                }
            });
            @Override
            public boolean onInterceptTouchEvent(RecyclerView Recyclerview, MotionEvent motionEvent) {
                ChildView = Recyclerview.findChildViewUnder(motionEvent.getX(), motionEvent.getY());
                if(ChildView != null && gestureDetector.onTouchEvent(motionEvent)) {
                    RecyclerViewItemPosition = Recyclerview.getChildAdapterPosition(ChildView);
           //         Toast.makeText(MainActivity.this, String.valueOf(RecyclerViewItemPosition), Toast.LENGTH_SHORT).show();
                seriesurl(RecyclerViewItemPosition);
                }
                return false;
            }

            @Override
            public void onTouchEvent(RecyclerView Recyclerview, MotionEvent motionEvent) {
            }

            @Override
            public void onRequestDisallowInterceptTouchEvent(boolean disallowIntercept) {
            }
        });

        recyclerView1.addOnItemTouchListener(new RecyclerView.OnItemTouchListener() {
            GestureDetector gestureDetector = new GestureDetector(MainActivity.this, new GestureDetector.SimpleOnGestureListener() {
                @Override public boolean onSingleTapUp(MotionEvent motionEvent) {
                    return true;
                }
            });
            @Override
            public boolean onInterceptTouchEvent(RecyclerView Recyclerview, MotionEvent motionEvent) {
                ChildView = Recyclerview.findChildViewUnder(motionEvent.getX(), motionEvent.getY());
                if(ChildView != null && gestureDetector.onTouchEvent(motionEvent)) {
                    RecyclerViewItemPosition = Recyclerview.getChildAdapterPosition(ChildView);
         //           Toast.makeText(MainActivity.this, String.valueOf(RecyclerViewItemPosition), Toast.LENGTH_LONG).show();
                moviesurl(RecyclerViewItemPosition);
                }
                return false;
            }

            @Override
            public void onTouchEvent(RecyclerView Recyclerview, MotionEvent motionEvent) {
            }

            @Override
            public void onRequestDisallowInterceptTouchEvent(boolean disallowIntercept) {
            }
        });

        recyclerView.addOnItemTouchListener(new RecyclerView.OnItemTouchListener() {
            GestureDetector gestureDetector = new GestureDetector(MainActivity.this, new GestureDetector.SimpleOnGestureListener() {
                @Override public boolean onSingleTapUp(MotionEvent motionEvent) {
                    return true;
                }
            });
            @Override
            public boolean onInterceptTouchEvent(RecyclerView Recyclerview, MotionEvent motionEvent) {
                ChildView = Recyclerview.findChildViewUnder(motionEvent.getX(), motionEvent.getY());
                if(ChildView != null && gestureDetector.onTouchEvent(motionEvent)) {
                    RecyclerViewItemPosition = Recyclerview.getChildAdapterPosition(ChildView);
           //         Toast.makeText(MainActivity.this, String.valueOf(RecyclerViewItemPosition), Toast.LENGTH_LONG).show();
                    booksurl(RecyclerViewItemPosition);

                }
                return false;
            }

            @Override
            public void onTouchEvent(RecyclerView Recyclerview, MotionEvent motionEvent) {
            }

            @Override
            public void onRequestDisallowInterceptTouchEvent(boolean disallowIntercept) {
            }
        });



    }

    private void seriesurl(int recyclerViewItemPosition) {
        int pos=recyclerViewItemPosition;
        if(pos==0){
            Intent intent=new Intent(this,Main2Activity.class);
            intent.putExtra("url","https://www.imdb.com/title/tt0108778/reviews");
            startActivity(intent);
        }if(pos==1){
            Intent intent=new Intent(this,Main2Activity.class);
            intent.putExtra("url","https://www.imdb.com/title/tt9095260/reviews");
            startActivity(intent);
        }if(pos==2){
            Intent intent=new Intent(this,Main2Activity.class);
            intent.putExtra("url","https://www.imdb.com/title/tt0944947/reviews");
            startActivity(intent);
        }if(pos==3){
            Intent intent=new Intent(this,Main2Activity.class);
            intent.putExtra("url","https://www.imdb.com/title/tt0460649/reviews");
            startActivity(intent);
        }if(pos==4){
            Intent intent=new Intent(this,Main2Activity.class);
            intent.putExtra("url","https://www.imdb.com/title/tt4156586/reviews");
            startActivity(intent);
        }if(pos==5){
            Intent intent=new Intent(this,Main2Activity.class);
            intent.putExtra("url","https://www.imdb.com/title/tt0898266/reviews");
            startActivity(intent);}
        if(pos==6){
            Intent intent=new Intent(this,Main2Activity.class);
            intent.putExtra("url","https://www.imdb.com/title/tt6077448/reviews");
            startActivity(intent);
        }if(pos==7){
            Intent intent=new Intent(this,Main2Activity.class);
            intent.putExtra("url","https://www.imdb.com/title/tt1520211/reviews");
            startActivity(intent);
        }if(pos==8){
            Intent intent=new Intent(this,Main2Activity.class);
            intent.putExtra("url","https://www.imdb.com/title/tt0455275/reviews");
            startActivity(intent);
        }
    }
    private void moviesurl(int recyclerViewItemPosition) {
        int pos=recyclerViewItemPosition;
        if(pos==0){
            Intent intent=new Intent(this,Main2Activity.class);
            intent.putExtra("url","https://www.imdb.com/title/tt2088847/reviews");
            startActivity(intent);

        }if(pos==1){
            Intent intent=new Intent(this,Main2Activity.class);
            intent.putExtra("url","https://www.imdb.com/title/tt1270797/reviews");
            startActivity(intent);

        }if(pos==2){
            Intent intent=new Intent(this,Main2Activity.class);
            intent.putExtra("url","https://www.imdb.com/title/tt8291224/reviews");
            startActivity(intent);

        }if(pos==3){
            Intent intent=new Intent(this,Main2Activity.class);
            intent.putExtra("url","https://www.imdb.com/title/tt8550208/reviews");
            startActivity(intent);

        }if(pos==4){
            Intent intent=new Intent(this,Main2Activity.class);
            intent.putExtra("url","https://www.imdb.com/title/tt1825683/reviews");
            startActivity(intent);

        }if(pos==5){
            Intent intent=new Intent(this,Main2Activity.class);
            intent.putExtra("url","https://www.imdb.com/title/tt6826438/reviews");
            startActivity(intent);

        }if(pos==6){
            Intent intent=new Intent(this,Main2Activity.class);
            intent.putExtra("url","https://www.imdb.com/title/tt1155076/reviews");
            startActivity(intent);

        }if(pos==7){
            Intent intent=new Intent(this,Main2Activity.class);
            intent.putExtra("url","https://www.imdb.com/title/tt4154796/reviews");
            startActivity(intent);

        }if(pos==8){
            Intent intent=new Intent(this,Main2Activity.class);
            intent.putExtra("url","https://www.imdb.com/title/tt7098658/reviews");
            startActivity(intent);

        }if(pos==9){
            Intent intent=new Intent(this,Main2Activity.class);
            intent.putExtra("url","https://www.imdb.com/title/tt6264938/reviews");
            startActivity(intent);

        }

    }

    private void booksurl(int recyclerViewItemPosition) {
    int pos=recyclerViewItemPosition;
    if(pos==0){
        Intent intent=new Intent(this,Main2Activity.class);
        //intent.putExtra("url","https://www.goodreads.com/book/show/18143977-all-the-light-we-cannot-see");
        intent.putExtra("pdf","http://ahhssummerreading.weebly.com/uploads/1/0/3/7/103700016/all_the_light_we_cannot_see.pdf" );
        startActivity(intent);
    }
        if(pos==1){
            Intent intent=new Intent(this,Main2Activity.class);
        //    intent.putExtra("url","https://www.goodreads.com/book/show/3320520-the-3-mistakes-of-my-life");
         intent.putExtra("pdf","https://hpaba.com/pages/en/3-mistake-of-my-life.pdf");

            startActivity(intent);
        }
        else if(pos==2){
            Intent intent=new Intent(this,Main2Activity.class);
         //   intent.putExtra("url","https://www.goodreads.com/book/show/31557698-one-indian-girl");
           intent.putExtra("pdf","https://storiesofalifetimeweb.files.wordpress.com/2017/03/oneindiangirlstoriesofalifetime.pdf");
            startActivity(intent);
        }
       else if(pos==3){
            Intent intent=new Intent(this,Main2Activity.class);
            intent.putExtra("pdf","https://storiesofalifetimeweb.files.wordpress.com/2017/04/it-started-with-a-friend-request.pdf");

            //intent.putExtra("url","https://www.goodreads.com/book/show/40658082-friend-request");
            startActivity(intent);
        }
       else if(pos==4){
            Intent intent=new Intent(this,Main2Activity.class);
            intent.putExtra("pdf","http://mindguruindia.com/wp-content/uploads/2014/06/MP078_Wings-of-fire-by-Abdul-Kalam.pdf");
            startActivity(intent);
        }else if(pos==5){
            Intent intent=new Intent(this,Main2Activity.class);
intent.putExtra("pdf","http://cbseacademic.nic.in/web_material/doc/novels/2_The%20Invisible%20Man,%20by%20H.%20G%20-%20Class%20-%20XII.pdf");
            startActivity(intent);
        }else if(pos==6){
            Intent intent=new Intent(this,Main2Activity.class);
            intent.putExtra("pdf","https://www.apnamba.com/Ebooks-pdf/The%20Monk%20who%20sold%20his%20ferrari%20-%20Robin%20Sharma%20(PDF)%20%5BQwerty80%5D.pdf");
            startActivity(intent);
        }else if(pos==7){
            Intent intent=new Intent(this,Main2Activity.class);
           // intent.putExtra("url","https://www.goodreads.com/book/show/69571.Rich_Dad_Poor_Dad");
            intent.putExtra("pdf","http://www.lequydonhanoi.edu.vn/upload_images/S%C3%A1ch%20ngo%E1%BA%A1i%20ng%E1%BB%AF/Rich%20Dad%20Poor%20Dad.pdf" );
            startActivity(intent);
        }else if(pos==8){
            Intent intent=new Intent(this,Main2Activity.class);
            intent.putExtra("pdf","https://storiesofalifetimeweb.files.wordpress.com/2017/01/i-too-had-a-luv-story.pdf");
            startActivity(intent);
        }else if(pos==9){
            Intent intent=new Intent(this,Main2Activity.class);
            intent.putExtra("pdf","https://storiesofalifetimeweb.files.wordpress.com/2017/01/can-love-happen-twice.pdf");
            startActivity(intent);
        }
    }

    private ArrayList prepareData(){

        ArrayList android_version = new ArrayList<>();
        for(int i=0;i<novel_urls.length;i++){
            AndroidVersion androidVersion = new AndroidVersion();
            androidVersion.setAndroid_image_url(novel_urls[i]);
            android_version.add(androidVersion);
        }
        return android_version;
    }

    private ArrayList prepareData1(){

        ArrayList android_version = new ArrayList<>();
        for(int i=0;i<android_image_urls1.length;i++){
            AndroidVersion androidVersion = new AndroidVersion();
            androidVersion.setAndroid_image_url(android_image_urls1[i]);
            android_version.add(androidVersion);
        }
        return android_version;
    }

    private ArrayList prepareData2(){

        ArrayList android_version = new ArrayList<>();
        for(int i=0;i<android_image_urls2.length;i++){
            AndroidVersion androidVersion = new AndroidVersion();
            androidVersion.setAndroid_image_url(android_image_urls2[i]);
            android_version.add(androidVersion);
        }
        return android_version;

    }


    }


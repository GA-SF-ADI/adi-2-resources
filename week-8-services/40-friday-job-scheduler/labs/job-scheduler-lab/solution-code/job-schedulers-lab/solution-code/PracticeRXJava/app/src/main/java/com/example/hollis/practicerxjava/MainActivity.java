package com.example.hollis.practicerxjava;

import android.support.annotation.MainThread;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.util.Pair;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.jakewharton.rxbinding.view.RxView;

import org.w3c.dom.Text;

import java.util.concurrent.TimeUnit;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.Observable;
import rx.Scheduler;
import rx.android.MainThreadSubscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.functions.Func1;
import rx.functions.Func2;
import rx.internal.schedulers.SchedulerLifecycle;
import rx.schedulers.Schedulers;

public class MainActivity extends AppCompatActivity {
    Button refreshButton, refresh1Button;
    TextView textView1, textView2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        refreshButton = (Button) findViewById(R.id.activity_main_refresh_button);
        refresh1Button = (Button) findViewById(R.id.refresh_1_button);
        textView1 = (TextView) findViewById(R.id.text_1);
        textView2 = (TextView) findViewById(R.id.text_2);
        Retrofit retrofit = new Retrofit.Builder().baseUrl("https://api.github.com/").addCallAdapterFactory(RxJavaCallAdapterFactory.create()).addConverterFactory(GsonConverterFactory.create()).build();
        final GithubService githubService = retrofit.create(GithubService.class);
        Observable<User[]> inputStream = githubService.getResults(0).subscribeOn(Schedulers.io());
        Observable<User[]> clickStream = RxView.clicks(refreshButton)
                 .flatMap(new Func1<Void, Observable<User[]>>() {
            @Override
            public Observable<User[]> call(Void aVoid) {
                int randOffset = (int) (Math.random()*500);
                Log.d("Main activity", "offset is + " + randOffset);
                return githubService.getResults(randOffset).subscribeOn(Schedulers.io());
            }
        });

        Observable<User> refresh1Stream = RxView.clicks(refresh1Button).map(new Func1<Void, User>() {
            @Override
            public User call(Void aVoid) {
                return null;
            }
        });
        final Observable<User> mergeStream = Observable.merge(inputStream, clickStream)
                .observeOn(AndroidSchedulers.mainThread())
                .onErrorReturn(new Func1<Throwable, User[]>() {
                    @Override
                    public User[] call(Throwable throwable) {
                        throwable.printStackTrace();
                        return new User[0];
                    }
                }).flatMap(new Func1<User[], Observable<User>>() {
                    @Override
                    public Observable<User> call(User[] users) {
                        return Observable.from(users);
                    }
                });
        Observable<User> suggestion1Stream = Observable.combineLatest
                (refresh1Stream.startWith(new User()),
                        mergeStream, new Func2<User, User, User>() {
                            @Override
                            public User call(User user, User mergeUser) {
                                Log.d("TAG", mergeUser.getLogin());
                                return mergeUser;
                            }
                        }).mergeWith(clickStream.map(new Func1<User[], User>() {
            @Override
            public User call(User[] users) {
                return null;
            }
        }));
        suggestion1Stream.onErrorReturn(new Func1<Throwable, User>() {
            @Override
            public User call(Throwable throwable) {
                throwable.printStackTrace();
                return null;
            }
        }).observeOn(AndroidSchedulers.mainThread()).subscribe(new Action1<User>() {
            @Override
            public void call(User user) {
                if(user==null){
                    textView1.setText("");
                }else{
                    textView1.setText(user.getLogin());
                }
            }
        });
       }
    }


package com.happy.valueanim1;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private Button b_start;
    private TextView tv;
    private AnimatorSet set;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //获得控件

        b_start = (Button) findViewById(R.id.b_start);
        tv = (TextView) findViewById(R.id.tv);


        //创建各种属性动画
        final ObjectAnimator alpha = ObjectAnimator.ofFloat(tv, "alpha", 1f, 0f, 1f);
        final ObjectAnimator rotation = ObjectAnimator.ofFloat(tv, "rotation", 0f,360f);

        //得到坐标
        float y = tv.getTranslationY();
        //移动动画
        final ObjectAnimator translationY = ObjectAnimator.ofFloat(tv, "translationY", y,-800,y);

        final ObjectAnimator scaleY = ObjectAnimator.ofFloat(tv, "scaleY", 1f,3f,1f);
//        alpha.setDuration(5000);
//        rotation.setDuration(5000);
//        translationY.setDuration(5000);
//        scaleY.setDuration(5000);

        //创建集合动画
        set = new AnimatorSet();
        set.play(alpha).with(rotation).with(scaleY).after(translationY);
        set.setDuration(5000);

        set.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animator) {

            }

            @Override
            public void onAnimationEnd(Animator animator) {

                set.start();
            }

            @Override
            public void onAnimationCancel(Animator animator) {

            }

            @Override
            public void onAnimationRepeat(Animator animator) {

            }
        });

        //按钮监听

        b_start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //alpha.start();
                //rotation.start();
                //translationY.start();
               // scaleY.start();

                set.start();
            }
        });
    }

    @Override
    protected void onPause() {
        super.onPause();
        set.end();
    }
}

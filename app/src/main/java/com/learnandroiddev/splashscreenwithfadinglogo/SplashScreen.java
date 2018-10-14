package com.learnandroiddev.splashscreenwithfadinglogo;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.ImageView;

public class SplashScreen extends AppCompatActivity {

    // TODO Step 6 - Create an ImageView and call it "logo"
    ImageView logo;

    // TODO Step 7 - Create variable SPLASH_DISPLAY_LENGTH and assign it the length you prefer. It is measured in milliseconds
    /** Duration of wait **/
    private final int SPLASH_DISPLAY_LENGTH = 1000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        // TODO Step 8 - Hook up your ImageView variable to your UI
        logo = findViewById(R.id.splash_img_logo);

        // TODO Step 10 - Call the method you just created and pass in your logo ImageView
        fadeOutAndHideImage(logo);



    }
    // TODO Step 9 - Create a method called fadeOutAndHideImage that takes in an ImageView
    private void fadeOutAndHideImage(final ImageView img)
    {
        // Fade Animation code
        Animation fadeOut = new AlphaAnimation(1, 0);
        fadeOut.setInterpolator(new AccelerateInterpolator());
        fadeOut.setDuration(1000); // How long it takes for the animation to complete in milliseconds

        fadeOut.setAnimationListener(new Animation.AnimationListener()
        {
            // Once the animation is done, set the visibility of the logo to GONE and navigate to
            // the MainActivity after the set amount of time.
            public void onAnimationEnd(Animation animation)
            {
                img.setVisibility(View.GONE);

                /* New Handler to start the Menu-Activity
                 * and close this Splash-Screen after some seconds.*/
                new Handler().postDelayed(new Runnable(){
                    @Override
                    public void run() {
                        /* Create an Intent that will start the Menu-Activity. */
                        startActivity(new Intent(getApplicationContext(), MainActivity.class));
                        finish();

                    }
                }, SPLASH_DISPLAY_LENGTH);
            }
            public void onAnimationRepeat(Animation animation) {}
            public void onAnimationStart(Animation animation) {}
        });

        img.startAnimation(fadeOut);
    }
}

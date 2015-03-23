package com.example.aj.ribbit;

import android.app.Application;

import com.parse.Parse;
import com.parse.ParseObject;

/**
 * Created by aj on 3/22/15.
 */
public class RibbitApplication extends Application{

    @Override
    public void onCreate(){
        super.onCreate();
        Parse.enableLocalDatastore(this);
        Parse.initialize(this, "x7WV9Aerbc4V2jVEU5RViXLRAHO2OuJvM3epp9TY", "OjOBeYzGl36e2rq8lFR99iR5JtSODzMBBKEHQaK0");

        }
}

package deploy.android.lozanofit.es.lozanofitroutinemixer;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.VideoView;
import android.content.Context;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



    }


    public void goToActivity2 (View view){
        Intent intent = new Intent (this, Activity2.class);
        startActivity(intent);
    }


}

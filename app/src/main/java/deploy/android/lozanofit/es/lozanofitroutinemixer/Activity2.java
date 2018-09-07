package deploy.android.lozanofit.es.lozanofitroutinemixer;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class Activity2 extends AppCompatActivity {

    public int counter = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);

        ImageView image = findViewById(R.id.imageView);
        Picasso
                .with(this)
                .load("https://lh3.googleusercontent.com/ahXRXJx0q7sVYKN4mTecvr1odkRjNhDI4PT9VUOHpMbo9Zpm6L_X_juYRxcyoaWU1J7kMKUh3-gT5X3c3Y6g_EKDx3I8y3tHtvcXjrPgptYUTiSBxk0V6FR_iiOiYNOcQYu0NemOx2lcq8EVBT5wryhwhowLBgN3g1IawBkVfSLDAyj_e1G0UnkZmRiuG3Dhp0Ien6O0lCt06w3WFXTiVFQwISLpjRsHYJWUvrK0QjZp0qQF8Tg6g0cjtagNk5kHjUWRGjjd9PUN3VqKHgTzDoMfm4x8Jruw9ut5xBIiYTmtCbE16U6zHI794-5DKsTVx7-whmidPGVfN03AaNY_91_yLY7-veXl7JgeII4RS8KvprJ__2Hyu2UdeUrFU-f6baLQ0XQoypz1Ktckl2tDRDKxnMLEcvSXMZxU_QzsULeMh0h5eip1LVy5aCSFusdPLVJcsKdKllolStCgDwiVjQ2OUT_GAKTiOwJ7FlV0DFBR0v3CQTrfIOK_Q7-kOZWAjklWBWmLJH54EIsTQrAPcj9eFStVvLUYwAwTb_T-yriuLDAalkk66WkNkICmMwKY-OjElwYyuHsmQR6p2Ke4-InR9WDiEaOEQffpBvUuVSFb3feccrm5OYqwtugLKUFSeIN7dftjLis1TUDn3U_jvZtgcxKO_hm1jP0dB-MxTZHDAkOsSvMxVH5X=w712-h632-no")
                .resize(539,479)
                .into(image);


    }


    public void goToMainActivity (View view){
        Intent intent = new Intent (this, MainActivity.class);
        startActivity(intent);
    }

    public void nextExercise (View view){
        TextView text = findViewById(R.id.textView4);
        ImageView image = findViewById(R.id.imageView);
        if (counter<3) {
            counter++;
            switch (counter) {
                case 0:

                    break;
                case 1:
                    text.setText("Curl");
                    Picasso
                            .with(this)
                            .load("https://lh3.googleusercontent.com/9dX8q0rdbHl06S0zybhrOHjLBKqcQUSX9WhsulQwYXj67ZBi4Y28XEaP3UWvBjXt8fJu61ghRRYwO0i71bvzbNvc8j8RJ4B8dK2iXnddoyXOg0-hrG86i-TPSzbDS1TIwKyV4nMcMg9uDADyRYA5eRoko3ZyxZP2zB7rGJrxlKw-dVgevkmNSU23l_nGYXgIbOlwVh9qif-Fbugslj6Ueezq4FnpPTBwN12e8nFLjjlnvz0km681FY8iRRZ8tq41buxY5HWirmkaq6iA5nkiuCzAWcYb-9hywHRJpbgzdpzSoajYMQ9JQHSdFl35v-Z7a7rGbD5uiT11XFVWTqr0IxLET3zyI7v9bEp5CdGuS3QePSNn4cnmykqnNyPPPP_YYtCXX06i5qhkN6yqA-Eb6ItMGQetWIVxtfxBnGiKkdKC4i4mxKg-MMzbpT67RFlNtx6CJssLx9AktH8y1OWpsJWizX_8hAhCa79ym9zbWe7frrZptGBnPMg9ZMFZSGMWUl1E4fJ_yg4I8zypV6AifPdVl1haNPDEPuZNL5Dg4cEhPY2WiA6yPMg_vGHVzAPb6SgcvzLbTElY5x5QEv-9p6DVv8fF2jCQXpKnVk3pPcbGxWBW8syFeWmx1ctjTVfc9qfHWgcSmUnGaFJxGE_OFCRLaFOpOLW-JY8Gmacp-Vy0ML_MAURzuLAR=w711-h632-no")
                            .resize(539,479)
                            .into(image);
                    break;
                case 2:
                    text.setText("Concentration Curl");
                    Picasso
                            .with(this)
                            .load("https://lh3.googleusercontent.com/lzAS7j1jzb76P1iit8soZ3jkC8aM3CBlfspwBmRKLTXyfDM4iAUB0Ex3He67u99cPKhc-zx04xbdahxGcoWQOXTckfVBoKYCrvXGj_6y8SykG4mnnIn76qqlZTh5Dpo_cGG5aKWKtxkiIMEy7fyfUnJs8yAXi9Dpgh7ILLRqzGFSFUq_UKsPECmvxTsGqBgsEFzXE99J5lEJEd0Wf8E9yo8GteNSS4A0CC7ihh-cfNhKswTLlFilxyNkdIxdUFLeGt9wKY5LgYGf4WNoFjNuFklJirSTNynjFwGcxVOrAH1sf2rYg7Pcye3plGKAixTC8bM6zv2wnWRVkD2xzNnFy4Y2dMmvJiWfSPVgU2L010KOH4ij6lUsVzIuuPrkC4agB43Kq9c4CtYVLZdYHzZDKl1PCkgSoxuVsitaWpul47gy736LNqVWtshk6Dvy6LeP7MyHJzUAJeenDuk_J3nVdte3Igf0TRh8C91egYhsgB0kFViSgg5CYvLX4TSenV_vtm140wjrcqHFYwumOLmccnf1Cp-QEYJrf3_txpGk5o9Mxo0ggEoCByMMukqE43_RmWl73fgF0MRTKPeRWNnCExlRzOMNchof70Wod-_fjTG6XWrx21_tXXV85u6D3q6WnEWlLCutYb3-m5FCP5Wum-usW6R2hszQ5y5VtMpSRBBxLUrzGDp9Gzz5=w713-h632-no")
                            .resize(539,479)
                            .into(image);
                    break;
                case 3:
                    text.setText("Hammer Curl");
                    Picasso
                            .with(this)
                            .load("https://lh3.googleusercontent.com/-GhEB-qYcj_5hNPnDJDE2yd5gssUYbj8PzRp6IvkYEesl65qepfNTQnXTDwH_wJpXzCbis-1IIfSw_Sd3OvTkaVMYLtSpm0s7p_JTbLu1f2RmKv_myRPTI3qHlVfr6TAv5hCJxDTPBbzB3fDUKSyySTcAn_9ceyLMk1MWRY9hzhWbsfNipsQYI4CnPgOvuXUqnxWwR3vr6UjtWHrgYnc_DeJoM1uvyaEPqxa4G7PJbH3ih8GfW3RrO1Mw6PDlzP_Scinm0pZXnVBAXrvEaI6D0T3h5jg7VKvD-tUIhtQW4K-UYh70uYEmt0Q-DWxsnTQUUtq3d1y2NtpY8FDDNmrp1xm1FCYciqfdeBqdPuBYZRNfrX_NNX_D6R2HmTV-cDn5CmcLlcJbxJAdFKKLn2rZWC5TpcjDp6sZebgDvgg96rrjXXnEqazMK21FuhjGMYTLiH3kaSXF77csKpyh0_1YvcKzjwEtkageXrqtiz9xzVzIWdIeEZb0VxIOcXtVtbixOzDUu3sIJ_bGPwXYVtRlaHSHXtqWBoO3RjSAJF8_qBK5AMyl1DiaCAgpUKeHuKhwh67sCtcdN0DbrsQk0R5pc_FPSNTdhqtaQtTQbbD321jnjSnaL2_KXf2WBkLE53w04-LAXUhOvm9VVlOoZs4__eDcStt1ekbpCnYVquRRI9T0pu8keQcfC91=w711-h632-no")
                            .resize(539,479)
                            .into(image);
                    break;
            }
        }
    }

    public void previousExercise (View view){
        TextView text = findViewById(R.id.textView4);
        ImageView image = findViewById(R.id.imageView);
        if (counter!=0) {
            counter--;
            switch (counter) {
                case 0:
                    text.setText("Scott Dumbbell Curl");
                    Picasso
                            .with(this)
                            .load("https://lh3.googleusercontent.com/ahXRXJx0q7sVYKN4mTecvr1odkRjNhDI4PT9VUOHpMbo9Zpm6L_X_juYRxcyoaWU1J7kMKUh3-gT5X3c3Y6g_EKDx3I8y3tHtvcXjrPgptYUTiSBxk0V6FR_iiOiYNOcQYu0NemOx2lcq8EVBT5wryhwhowLBgN3g1IawBkVfSLDAyj_e1G0UnkZmRiuG3Dhp0Ien6O0lCt06w3WFXTiVFQwISLpjRsHYJWUvrK0QjZp0qQF8Tg6g0cjtagNk5kHjUWRGjjd9PUN3VqKHgTzDoMfm4x8Jruw9ut5xBIiYTmtCbE16U6zHI794-5DKsTVx7-whmidPGVfN03AaNY_91_yLY7-veXl7JgeII4RS8KvprJ__2Hyu2UdeUrFU-f6baLQ0XQoypz1Ktckl2tDRDKxnMLEcvSXMZxU_QzsULeMh0h5eip1LVy5aCSFusdPLVJcsKdKllolStCgDwiVjQ2OUT_GAKTiOwJ7FlV0DFBR0v3CQTrfIOK_Q7-kOZWAjklWBWmLJH54EIsTQrAPcj9eFStVvLUYwAwTb_T-yriuLDAalkk66WkNkICmMwKY-OjElwYyuHsmQR6p2Ke4-InR9WDiEaOEQffpBvUuVSFb3feccrm5OYqwtugLKUFSeIN7dftjLis1TUDn3U_jvZtgcxKO_hm1jP0dB-MxTZHDAkOsSvMxVH5X=w712-h632-no")
                            .resize(539,479)
                            .into(image);
                    break;
                case 1:
                    text.setText("Curl");
                    Picasso
                            .with(this)
                            .load("https://lh3.googleusercontent.com/9dX8q0rdbHl06S0zybhrOHjLBKqcQUSX9WhsulQwYXj67ZBi4Y28XEaP3UWvBjXt8fJu61ghRRYwO0i71bvzbNvc8j8RJ4B8dK2iXnddoyXOg0-hrG86i-TPSzbDS1TIwKyV4nMcMg9uDADyRYA5eRoko3ZyxZP2zB7rGJrxlKw-dVgevkmNSU23l_nGYXgIbOlwVh9qif-Fbugslj6Ueezq4FnpPTBwN12e8nFLjjlnvz0km681FY8iRRZ8tq41buxY5HWirmkaq6iA5nkiuCzAWcYb-9hywHRJpbgzdpzSoajYMQ9JQHSdFl35v-Z7a7rGbD5uiT11XFVWTqr0IxLET3zyI7v9bEp5CdGuS3QePSNn4cnmykqnNyPPPP_YYtCXX06i5qhkN6yqA-Eb6ItMGQetWIVxtfxBnGiKkdKC4i4mxKg-MMzbpT67RFlNtx6CJssLx9AktH8y1OWpsJWizX_8hAhCa79ym9zbWe7frrZptGBnPMg9ZMFZSGMWUl1E4fJ_yg4I8zypV6AifPdVl1haNPDEPuZNL5Dg4cEhPY2WiA6yPMg_vGHVzAPb6SgcvzLbTElY5x5QEv-9p6DVv8fF2jCQXpKnVk3pPcbGxWBW8syFeWmx1ctjTVfc9qfHWgcSmUnGaFJxGE_OFCRLaFOpOLW-JY8Gmacp-Vy0ML_MAURzuLAR=w711-h632-no")
                            .resize(539,479)
                            .into(image);
                    break;
                case 2:
                    text.setText("Concentration Curl");
                    Picasso
                            .with(this)
                            .load("https://lh3.googleusercontent.com/lzAS7j1jzb76P1iit8soZ3jkC8aM3CBlfspwBmRKLTXyfDM4iAUB0Ex3He67u99cPKhc-zx04xbdahxGcoWQOXTckfVBoKYCrvXGj_6y8SykG4mnnIn76qqlZTh5Dpo_cGG5aKWKtxkiIMEy7fyfUnJs8yAXi9Dpgh7ILLRqzGFSFUq_UKsPECmvxTsGqBgsEFzXE99J5lEJEd0Wf8E9yo8GteNSS4A0CC7ihh-cfNhKswTLlFilxyNkdIxdUFLeGt9wKY5LgYGf4WNoFjNuFklJirSTNynjFwGcxVOrAH1sf2rYg7Pcye3plGKAixTC8bM6zv2wnWRVkD2xzNnFy4Y2dMmvJiWfSPVgU2L010KOH4ij6lUsVzIuuPrkC4agB43Kq9c4CtYVLZdYHzZDKl1PCkgSoxuVsitaWpul47gy736LNqVWtshk6Dvy6LeP7MyHJzUAJeenDuk_J3nVdte3Igf0TRh8C91egYhsgB0kFViSgg5CYvLX4TSenV_vtm140wjrcqHFYwumOLmccnf1Cp-QEYJrf3_txpGk5o9Mxo0ggEoCByMMukqE43_RmWl73fgF0MRTKPeRWNnCExlRzOMNchof70Wod-_fjTG6XWrx21_tXXV85u6D3q6WnEWlLCutYb3-m5FCP5Wum-usW6R2hszQ5y5VtMpSRBBxLUrzGDp9Gzz5=w713-h632-no")
                            .resize(539,479)
                            .into(image);
                    break;
                case 3:

                    break;
            }
        }

    }


}

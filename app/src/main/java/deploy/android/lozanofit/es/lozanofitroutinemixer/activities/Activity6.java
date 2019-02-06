package deploy.android.lozanofit.es.lozanofitroutinemixer.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

import deploy.android.lozanofit.es.lozanofitroutinemixer.R;
import deploy.android.lozanofit.es.lozanofitroutinemixer.classes.Exercise;

public class Activity6 extends AppCompatActivity {

    public ArrayList<Exercise> exercisesList = new ArrayList<Exercise>();
    public ArrayList<String> musclesSelected = new ArrayList<String>();
    public int counter = 0;
    public String levelstring = "";
    public String objectivestring = "";
    public String timestring = "";
    public String bodystring = "";
    public String chronoCont = "";
    public String muscleNow = "";
    public boolean fromAct2 = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_6);


        fromAct2 = getIntent().getBooleanExtra("fromAct2", false);

        if(fromAct2){
            //from activity2
            // parcelable
            exercisesList = getIntent().getParcelableArrayListExtra("key");
            //get level selected and objective
            levelstring = getIntent().getStringExtra("selectedLevel");
            objectivestring = getIntent().getStringExtra("selectedObjective");
            counter = getIntent().getIntExtra("exerciseCounter", 0);
            //chrono
            chronoCont = getIntent().getStringExtra("chronoText");

            muscleNow = getIntent().getStringExtra("muscleNow");
        }else{
            levelstring = getIntent().getStringExtra("selectedLevel");
            objectivestring = getIntent().getStringExtra("selectedObjective");
            timestring = getIntent().getStringExtra("selectedTime");
            bodystring = getIntent().getStringExtra("selectedBodyPart");
            musclesSelected = getIntent().getStringArrayListExtra("musclesSelected");
            muscleNow = getIntent().getStringExtra("muscleNow");

        }


        //from act5 (if else)


        final ImageView gifview;
        gifview = (ImageView)findViewById(R.id.gifview6);

        TextView title = findViewById(R.id.textView17);
        title.setText(muscleNow);

        switch(muscleNow){
            case "BICEPS":
                Glide
                        .with(this) // replace with 'this' if it's in activity
                        .load("https://lh3.googleusercontent.com/Y0D1-FpXbI45IKKMIe-wpY8bUu2V1TpibikVTbgpIyCApTMxiNu12utBa8Jl9AGpNud5xNhEaUJ_-YyNpot7s7VBepOKUp_2rBuuiafzJ2kqxhi8wDiVYdTK4qMreDhFLFgfkTKijHEt9w7BPD3q2eU0pVleIH8hlbMUk_vtmL50G3LgyWfPgxaAjT-ENP63p01gJksniMqAYooz-lvsRfWgCC1FHW3SRDw2hlgCvyFs4cqLv_jQ31gSstBLaFCBrERtPdwetHM6CcWER-KVk8QCU6-reANG_VaZcBaaE0mH_FJ-hdBLIiazucMU8BjrbkNNXm1LlKPCMrXM8xnVDc-wuJSh8_Vgm8KAYglVLgZQjP_l7EiO8mete-XLaQIHDUGMo3OUmJkoK6iBjC7GRd6p4nK1QXZhk0nO_Vi2IJkEJw9WvQyL9OlD0Y4bczib9mJ9gHw0r22KFcGv99jOOOWfCXe3jMzicTryO1p6u1wK0Ge0T6n1byrjVhacuzF4W-FCdkB4BVlONMUQGUGus4D6mZAN50dH096faN2Le49jRZ13N-mUAo3YvuLn0KGzu97QmJCgj1hIJhod2x7JyuK0By-OhvBvUcV-rl_mDGIran6Kz7_U9CxHMJZgt3r_KgLve0Atlmb0BWz1Sx3RGrZJ1SwzLoE=w711-h632-no")
                        .into(gifview);
                break;
            case "ABS":
                Glide
                        .with(this) // replace with 'this' if it's in activity
                        .load("https://lh3.googleusercontent.com/oYpQrJoUE-IEFJGuao4mqzYP2XornUIcfXLmd7A5StQtMEaIxH9Jbr2WZK8Fj5DPHiDIQpWPXt5N3hJHZbka690xdtyDySURXPljotBnfvJuxN8HCUSpnsz9GE8bSiKMaApv2HSw7WnYle5-tdgTZ3TBvwH4lTEGcSuLbQQxivPrrWaE9M5ZDUzN2lzab13kYqB3vEQI7Cj1led03x6plbRe1rErvWqa466QOIFm1PkhUWiM7gOy_JcxeR7q7swhruK1-JFjf30lfQeU_iujH-hCj0pwFpT3bQHHuL0DGGKx6HZ27KTPWCq7jfRt5ALCyDqut9vprnxjgEFD7U7kV72aRjW51O20X93XdW9rkk7_uTi2Pr1qeC2OI52SAveSzY6NPq3Ztxof6KKprKHCgS76ARDAHoYE7AZSBPVLInGj1iPmJLx0YHLn_OmRO7IKj8U-t0Ja_kOs5CYdpxBGcQWy7M8td9TvIRvTaE5Ous4JelU92SXYcqEg1nb3K7cOsv19vqBC35RyvJbZggOz4ycp9YHbONp4nIe00ERW7vZ-a235ow05oVan3-lE7NXdMOsmSMb9w0eswpmWu5fYnvniI5UvrMVD2oW5Wt-rOayG-mZDDup0TqCZdDoomBJ-P8Tm3jY6AX7YIIY1BfvHKlmb3tc5HjM=w711-h632-no")
                        .into(gifview);
                break;
            case "ANTEBR.":
                Glide
                        .with(this) // replace with 'this' if it's in activity
                        .load("https://lh3.googleusercontent.com/i1U98oIHFJvvgbAUwQS3gNvoktMPvfuEzzE5sjP7PJue-RogaZNw_NuXhZyAmCCy-Om-ecHYRE0MaW3ttDxwJnRqLU-QNOLQyPX56_GUo0SXibi3aRUO1lKnA2h6IBXEoGCQx2W0r1uz1_Ti7q-ARzBgj1pIMQNoNCeKE1MLpj4InbC7C380nF1GR4p9Ug75DkeyN9oDGVHmJbOldLmGi_qD_OYvDnMvuUBRHzM4MNrCUt-emW7nkQo2e_PzynEHAI9-Jxi-roMMDHYcJ17H-cl6lWx8ueeqpM-hwjg6bZiML3DOpGsF6MIgOji5ffnTSxPyueD5DrStVvzibVaKemKsjc6RqIpwjVEo0OmV5ALie4QRfVziOHa3Q6JEJxllHrL6PMEFkRLRjEWIbYee3gBCTKrImG_PzAlT54hn5PEi75bn3RtVD7xbBvOXJROjtjkHpWYmzakkHbdBauXDktwD8x0QhTWyR-aG8OxWWrVNQC6BobZaLRYZK0TS4mf2LvdMipFfuIGWEKimfMG091Y2nSB5dTErpHI3tnRLe45yuNZR4nq3a1oRCpEIFPcysblGX1O3OrH1S9YNq-G1q1i9tCv1u7WzDGyFLyNrrq7VlKNlhXChFx39H-sgwTzpYVlJweboC1DZYfx2-gMjSYl14pbB5EA=w711-h632-no")
                        .into(gifview);
                break;
            case "PECHO":
                Glide
                        .with(this) // replace with 'this' if it's in activity
                        .load("https://lh3.googleusercontent.com/B5giysEU5CRbzZZmON5t3u-4XIiJO4gVe34SUlgOy5MKxHX0np_0ImmbduvDuEhrmuDck8Uteq90chOBiHT7avUcyvExMewC1odr2wdWrv9tsnZKuIIDFvIDyC3PRnZqghuQgTIv2tX7mvuHIo1_v_wXzq6Vvli75sjLfWJGvomqvsRCKLU0Nb3dPpAWzSvAhl_3SNUs5u6WJbOnB3n7EfWM3_V-geLA_7H5GB-FtQq0GYROnhCZ_juTlnwQmU5gwCu3uA5l_japzLbr9peveAYv95z8tb9oVBs4Ff0oPHhexoiPZIYRirTkM-dnJpR7MWAyNScUk2e7F-gyYGSCXIxInWBekSq_sseMLjp3Hq6U6LECaT9bfU0lx9QNBq6722LK57KP5GcTlWKBnt8OWXWzqLL88On50qoB0Aen2GjBN0Ac79Gns5DWBT1hwj3u3Ff_pHKacqUyKmx9MVlll4b69IGGGksm2stKFlJ78xrnKHjVF70750JAsp1Vv9kauv3mUNGIAIEyvYudDiKkRzSPFgXdNGyHWVjm0lyPmOdn4J95Vx1zKmEs-cbC_c6EjKB1fIe-6F-gRfPGPxA3iSymKMOZ8D1zVspPpXd1bO0AXuaTQD8C-HzFHGmCxOrKhSpFlAMWHXUlEP0MU_OJVTYzae3cwwc=w711-h632-no")
                        .into(gifview);
                break;
            case "HOMBRO":
                Glide
                        .with(this) // replace with 'this' if it's in activity
                        .load("https://lh3.googleusercontent.com/O9Nsxoi09Rpqksu4CjLFcSwg60u_VOawLaAoSzWISh1zAuh462F6UcZlIEgMIXDBo7se5uAqbfhIyZjYjP_8jN1Au6pmHzHu90Lw8uMlnt6fcbKXk9qb6V8ryLGVUqZZaR_v0jP5dz9StAdebZf4p2vrZhgACgFepvtt1FB1H5oiCk79ZywBIx6WVlw79dkd-QzOAnIL4hH4e_UuWR9Ls3LLQmMm73K6tbrGfjH6N5p7V3MwEjJRY2dtZ_8XMU6qsl-dRlt_Y88qR3AYL7-ToxMK0pa_v2yAJAbyt1LuHqt4SxDeMS3oxKmmv87MAgiwn4S2MdzbomBGc8PtXWDPDF7dV682IpeYvrFAj_jQbCt1wwvcNKY4hempO68ekgXQi66JS7TZtaTO184vyNB8Rd2vlbKTUfvm7Y7noPb2apywcP4jUZQMwNhyExrvQ736NLrEl5aMHkPzxsZ6Q7XVxiqjHT7cW8n_l-3i6Dq4K-MgMep5FEswqskfqLdcNaCGK2H8jAkZLVgxOPSRzh-z5VyxGByQ4WiuKsHw4wjNEp3cSC_4ZiYktf-mFcFOJKB4o1NT_5Os1gKwTtkIMEYNqYNWs10mk-JV5ApTp90eWkQiCjYwjQyAkWLkwfE5djGzRhyyS-PO3zWPORepufS63YPIWu4qyWQ=w711-h632-no")
                        .into(gifview);
                break;
            case "GEMELO":
                Glide
                        .with(this) // replace with 'this' if it's in activity
                        .load("https://lh3.googleusercontent.com/dXfLtZrO4jAl6B8cfBQlOHczV33m7q2MH8U87iaR7YCYiK25RZ4H7lGewSAmGpSmzk2Dkbcq_Gb2TiMDQxAbeBe0c4TybTR7AZbUNszAxUto_Z4GVnpyTpTovEeMc_iR3Ib3df_dMCc06kRcRoyj-OvOVpFd-mdyyeHs4guRcsZ7cMsS4We266FC_qZh4V7w6vgv_Ndmx1jfXN9KbF84GwSQDhVhBhxIVdxPc-Sl338W50VR1DZ5dtlgWl337xYRejjQObY9Bl3svw77jql6Ag_RCD6ri9EcFchQsGu8mYHBYyHIaaRXy7g_2o6zZ2dD3w7OjDaYDgN3YpByR4t6n0IdknaI3j2SQ9wgenBjwSKZek_GEYdniBdpHK4YSEYpPWf27_J36TymOO1ZIVvpxHP2yJUCTPshbGRE6dS6BmMW4wYQV4BXJRx9QbrNEYi9cu48Gc1apIMQw8w9J8suyFksdX7jLKgxTMzozZCYfinMFh8noGNQpWNmwAmzkA_47RF49vXJtc1UDo19-7W7QMyMsPlXc0T_rBYUa03h3ujkXu9NwgEWy8T7SCXXo-Er8ZJ6jsK9Pb_xJp6vqXi7Z1bAEU6JQ5g-i8A-7myPZ3yVVnzNr5EjtQHG0ycCwapCE3O8xVGYTJKuj67DzEhe75YfimP6p7Y=w711-h632-no")
                        .into(gifview);
                break;
            case "GLUTEO":
                Glide
                        .with(this) // replace with 'this' if it's in activity
                        .load("https://lh3.googleusercontent.com/2lqWpa09L7RXE5uNIe8-27E_UnbTia2ajYz5yYuHlsBdSx3xGvBYH28mfu5dv5VbRtXV7GIWrlFnQBt2KXOW4flTxcFqkwLreiQOh_EMHomgWUvCWvW2VtHpOMnrDS-KnHGwPUGGJgnXCH1uDIVjvyVcHENO_ccEmoxfru5NfgqF9Jlt6Rpw2ycTP2duZ2qnhpvw-SZasLA1cGIlBKzunedAycq6qRP-lgznDhhqnuJ5MWBSoN20BssreikytjT5sytAiZTLeSKzxaZmf2NfZmLPpwXRs3P1WayO2_uT0ipev5HzKTTxUicwIMwTqCLtQVbnqnQaygWa3ChVPW82qDRHckH-cWHkiDSLGSNIUfoSASx2-GBON5ZGDOuad8c_xDx0VCzm6c4CQisioOoLXhx-Rgxr9UCWOXgG7On-H8buMi-R6X1v3gw_jtQCXri88tOOoma5Ho2V0tj1sL3b4jI6R_frdwDqpwUyKOO5pYLjlwjujAdgIAY_z9a1TAfRoOFt6wVqRD1fGtA9LybmUNGS_cCAhhMQ1p8lfxe-QIkcfXLT_XAbOGwtgjTyxdZXvpp4i-K0zem2QvXmYj8guZQUr3Fm_Mejdxfgz23nUtm7KhgnzoPvd8zX_xlT8s2amvEtXWOFG1BQMudZGL9sKRjt_I4VBdQ=w711-h632-no")
                        .into(gifview);
                break;
            case "ESP.MED.":
                Glide
                        .with(this) // replace with 'this' if it's in activity
                        .load("https://lh3.googleusercontent.com/rsM6Q4U1lfrx1SFHlBjCyQzLsx4D-1gprh1Yt4-NG5lVDF_weXqEPfjoBEmK9SQX9TsLskjA4Ee_D2LfnXdHLkZelkK9YdTcW38lSECzT7ta1ZA-Fuzi1UKXO6s0XJSk6Sk9_EhLhZvz4kUOvF2zWATiFqVxhPfqu4Qdz_m06qhugLUV2kXZtqT_k5MEz1NGdHEHnk26IiLE8reTHqOwRlnuR2lbQwJ-CcJWivy6mLO9JAoBlV9rNl96lVX6HGdxxbmhVe3FJ9n4jNDg6oRyw7dXYXWeQO9x2LwI4sfh9im118kT5IzTr5xzSJyrZfBO9uw-7mHZqLvC0nEZE1Y9jw_YFQKCilr3AgC895K7XZKxekimFHHYNphfg7s0c8Q3p7azXe_OgdP95IQ5sdDVybBxgLf79NGNv4Gos0AINgqxQWQgXzc6nIyzP29iMNVa0s8aE-RCFR5gdJahGWUEZ0sCpMHkEHexmvUB3uofRxd4qiiPGZtPS5Oyjvq5TVP2kFlLVVcvmdk9FCjlRpfxxu-_2d_LqOvNm499n3fIzaDxqrrU8WUK4H4Q98mbpj8ynp69FwKWKiqIWrYoJcJpr4fPQVFzCCZSU72UTFO01pT29c7kDxQIqJAVb1z0cMIzNuKsxTHZTkXyXvj4tkf93qr8P0wR6vI=w711-h632-no")
                        .into(gifview);
                break;
            case "LUMBAR":
                Glide
                        .with(this) // replace with 'this' if it's in activity
                        .load("https://lh3.googleusercontent.com/G6UA0FLhR0FY9l3igIsFvaZnXpGf2bH2-AQGtIKJ79COP_5o4kn76qUz_lwm4B56PMsfw6m9DXuDz-BGNjfGibp4n30l00LtqywRvgPmGKvM-9MmGJ_a3sbaowKQqKcBwPyAKF23-OzncfyIDkSr2M92cymwS86kTMSHBsfZ-0Mtal2ZSAI_mPGwsRTbgrvQ3Vvpnq8LG_k4V3Ake1xNHCyk1RFl4EtGISrrLgAwBEYOXn-mH2s9vkq84uBwXYbpxQ9BgaRiqQh8x3PmteAHoHt8SOfAuSxcmBu6AYoCxXXzpiO_a1byy_2gqG26veYQBs4cbmUmbb5sOoxt4-8xbr1DKUoOEVrrgQzVRttVhL40wnhv1QDa0Zgiqv1RumDO6UnBLpmM7OeHi15qCKF5XeHIzWXG4Ie_vDBSQ8OS-iyKEvv-b43_E5Nnzrwa2DtKv0yqnXQu0yYAkn7YLEdzrZ-KUbY6bVelu-DFArnkwr_JAMtsoR1A4IghEDPomt5eQVuWxWUEPBPRx_vtU8SPjiZldq4U_kKdcdJFOGJzPItWlPGcShCaK9gESHXcs0r7eTRd51kVaUNojBtYSX6jVxVkiFTloeH50aX4T4JOPepGetg9VTIzxUm88dM8F8AItw1IWlinzOqll7lhUIKBDkRHM3HiYao=w711-h632-no")
                        .into(gifview);
                break;
            case "MUSLO":
                Glide
                        .with(this) // replace with 'this' if it's in activity
                        .load("https://lh3.googleusercontent.com/iGVEWGrjncwdKYTEx08RDUDMsF7Aj9w3RYAcBCMxJ4F26RZQDrchvAs2OhRxnvDKoA0l7ot1VuKz6yXprmQ-7k4b3SSvIOWBVSOX4RrB9NUtLtIAwmwnwgiQBH9wF31HI_T3uhgqEKcRAs5rMDWdTIZFHmlbEdc6XrB40_cSO3GOllceU2xKDxmSNnfVZ0Jy_iv8KaOgcEdXxz43LCIIV9V8udOi10_IuJQLmos3MtTECQneEilCtYX3a678p3bRgHXGoeA971JaOGFT8RoEdtvAtABq5iyVCCxm5lpF9dJU04ZX0p2Tkv8zKXLE1NGv-rNLGXSEcUT7btXHaASnOzBkbp96NBsIE4-qWZBVMJiYxwMs3_zO9JbOlHyOc7c9GtnChiAc0771MOjJdFgVFzjAOGzhWoe0behRsezqEgaG8_2Me_xui8jf3mZfC6Z2OVPxVg6Y8TDHMcZSTeaG4M9PbhR-lCNmPWKN8D02WHWwoWc0UKyDscfol6xy-RaQjmuRy9BbAvWm4HuaBYfuwEKtV5brbDdH7BZMImcim5DiA5y6vW_1Qt9dG_1hwVDd5Azs1iJwHkA2qI2JfZPzwIVcoAqojPY-ajmOT6lyuIhiYTUPy_tPGaRvy77TfDw0LbXg0xhB_WfwhN6HrHr3edTyigGB7QQ=w711-h632-no")
                        .into(gifview);
                break;
            case "TRICEPS":
                Glide
                        .with(this) // replace with 'this' if it's in activity
                        .load("https://lh3.googleusercontent.com/MIe-ApUnaF8y7LBRoKG_Zx89Btld8OyBTiQrVpXx7_vAo-0PRZYRv2ug2uxm3gFEk8yELEt1b43KNysNRCX_5zT2BNCwGfXGoDDhFrIjPII_0yUtusNmsKvDzWWQ12pyRllCIIelEszBZeBzYaH59yiiEetsLvf2gCIsrLt5dG9WP1dUhJFiTKvkYtxM8ty3RXAoIAbl0qT4l8tLec20FTnDLkbVKwmkcEVDP7PTss6TpXhVugowymstwkjiSVxjYbs2c7zf6aNlWMH63bRrlp3VMix-w2vTfyo1fnm3LFA6F6aybOoGjmO3Bf8hSG9tbbsEuJ2x7AUPT1MSLs_YpLuAUUtZ3ovH9d3UrGPiRPJsDTZE-yrQ3Ns4e6RpmjNqJ8CKz2ueEqvFZMHXSbvX8eaM2YUBY4mAcEgI-riWZ3fJABY-ssh5xAexkVF8IbMOvfsf5BVLo7fUp1quNORto2g9vuELySd444w7xpI5QQWptXt9JAWrWC7N25FJ1NlwgBNBnIelfdsp-DuY9iTq-pJ2dyyl7qwclpRv3x8hazZehIkDwfIRZR-E1f6JhAF5CQG-_AFEzXrJYIJ_ly6MAXNJqtLcEduUFrMaTWr5t_UsNX_6r4UdZ9eCQRQAjzc4gAjSi5_Kfp31XRx7g0yHPZg_3M8xblc=w711-h632-no")
                        .into(gifview);
                break;
            case "ESP.SUP.":
                Glide
                        .with(this) // replace with 'this' if it's in activity
                        .load("https://lh3.googleusercontent.com/ZjucoA9kIbGRzaCNNzDnijNjQ_peeSB-ADMvu3c0mLJHpv33ODXPfzOyFTLaEVUD3E0ik95vAwHam6q1SeEAD_FgPuIHZ5P72rIzlnQ4T2TCsl-jF3enHgHJWqXPmgQ0ZTHaOjmgBZZi0VWcj2NXDY2Y3Z3tAE5PFvJyOgRiX4BERnxUAI4-xP-_uslPaoNdbsVE0UQimtjGhcZkYnTqiQOGCoDRaAMHUtl1N5-pW_OgvuFUoYcIZvdeZKaY4-1FZKzc9AjbKm6bzvaIv8JnEeKAaq9K-aaFByGJzWxJbgUhJvAcaYgZ86L9Qgf1L3o8xrZzGcrCH4suzug-JlCLDo9mfA_Axaw2spEX-XKJlUjFLIno97ahJ5ZAp9wkG3t6Sm9Qylg-kj1dhET7bJrzedPlOdmdzpb9OSYqSFR4f_AdrwnyVJmLpnaZkBo7T-ytYS_vrBgQzrDsl_QVwn0xYWR6umtoXLRg8tnCBdJ1uH5Fy3URDHqeTrukQHNLgfztBp8HLpSsjr7BLAwNLhruQ8MikbNOVoOeaIsEP9dUzy16zMmJoRabQGQj1YA4NRBjXqaqm3uFY-Fn5m-qVl_3vqMBRMMwfQpTEp_7qqDuYdy4J-dGHTYNNgvn1tpcmJPxqqNbZViOcNJFTot42N-JdERZMVDC-sY=w711-h632-no")
                        .into(gifview);
                break;
        }






    }

    public void goToAct2 (View view){

        if(fromAct2){
            Intent intent = new Intent (this, Activity2.class);
            intent.putExtra("exerciseCounter", counter);
            //parcelable
            intent.putParcelableArrayListExtra("key", exercisesList);
            intent.putExtra("listCreated", true);

            //TextView simpleChrono = findViewById(R.id.chrono3);
            //String chronotext = (String) simpleChrono.getText();

            intent.putExtra("chronoText", chronoCont);
            intent.putExtra("selectedLevel", levelstring);
            intent.putExtra("selectedObjective", objectivestring);
            startActivity(intent);
        //go to activity5
        }else{
            Intent intent = new Intent (this, Activity5.class);
            intent.putExtra("selectedTime", timestring);
            intent.putExtra("selectedLevel", levelstring);
            intent.putExtra("selectedBodyPart", bodystring);
            intent.putExtra("selectedObjective", objectivestring);
            intent.putExtra("musclesSelected", musclesSelected);
            startActivity(intent);
        }



    }


}

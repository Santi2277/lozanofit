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
    int profileid = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_6);


        fromAct2 = getIntent().getBooleanExtra("fromAct2", false);
        profileid = getIntent().getIntExtra("profileid", 0);

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

        final ImageView gifview2;
        gifview2 = (ImageView)findViewById(R.id.gifview70);



        TextView title = findViewById(R.id.textView17);
        title.setText(muscleNow);

        switch(muscleNow){
            case "BICEPS":
                Glide
                        .with(this) // replace with 'this' if it's in activity
                        .load("https://lh3.googleusercontent.com/pwvlEKRJuY_ed9ejS9wNaFBopjxdvsqqEDuRaWbFu_O0e-bScqjv_Hs6icW5YBYvEePM5I0w7wo6NYYFmUy_7F_GWDdg5GWVuokkHEuDOtSI66QITRvyST_8fY0TpOgWAzHNK0hoCHo1DYBKwOkf80LfH5Vu_QhoevyqAYjVGtV80v3Imip6TLnVFbDKBxKxJ8Iv3kqp8CEWVJ-zQjp9y-rFS8TQf_i4NKenNBhLeW61mezTIAO-2E9Kb415Mzt8qlYtoGT0nNujG8eKJ2U7wwkLVbqCh2mFJ7V5tUFrTdvxgWarfuD5crjCdcyCelAyiCszdh0zsPYVD9YQogIsm0qSVlqk6Ks3feXXCeWVLWPdrafsMqRABIJErpnTqxsvHHanjdy6JdbL8nSsARbwjsc3My7s-lW4OpiPX63HjzCHSmo4ryTqc8Ln9EiOPuOlZXuwixct_BQcgXe7RXTq81rXEFObQYqCD4MVIstBb21hMFdLVDqMcwU2ZmPf_jqEjrlw2Wr5tGAoZ-VSywVqMW8GUe1FoKuXLUUIo8bdZI-AeN7RBKrPH5PyzFcdxjF35t9igf1HCjBpASUKPpJmSJe9ceR4t6CQHXuzd_-J5sc7x9qaCDM428VIcHS1AVjmbelO7Ep-vei9ypLqQn7Yz6jlKXpz6OM=w711-h632-no")
                        .into(gifview);
                Glide
                        .with(this) // replace with 'this' if it's in activity
                        .load("https://lh3.googleusercontent.com/pS7qVFuNO-oEpwNM_cftmRYDSmM52rga41b-A5bzDnvB2768arnkpfiUXko9tPV3ortvu_NXZKFrB-G9dqJhBiHzxgCTirRfsoE01tLFXNE9a22c57uJ1ATtAwcMyZH_w-F_BuFBb2eGyKl8hGShh4H9_1KPJbyv6LVjCkg7yuIz17UeZhWkh1rAD-NNCEGglpwastHs117AYH5rsdN4twDuh0vHsIDwA_nLeyZcasVXQNQ3KQE0x-n8c5cygz__WYZwvllIlXKsKUK2hl2Q8HO0vzc5PCoLOW-GcvYDts2dCkVFSa3xE0rnR9Zg_8PqDdCux4JSVDPzgYM-SoaW_7VSqBfa5GhLwnwZaxBCNFCXfa9NhnX6bZUg1yLGmuuw1DFBeR2JlK2g9r-mN1bIo8HQ206eMPwMdIL3YisGaA6Iid76UL58h1OsLwSKPeHkHcBMgzNjcop1CcQePw1t1q0AqO1y3vPujqr_W3zXslcKva6zJ6w9ihlLdXJZSJZGSwDF5LwDl73QnRdLEG5koDUKq5d9_VQFrUy4HsbXrJYMrV68_ulZIZ898hADjrcVhvLLr_fxqKgN00qMhqmiaiHQxJCig-U4c88yEVDNGqMOMJmMlpoPcUQM5tzep7p3ts59eeQR6M2wfkMZ3YXgvIxixSMCBIk=w427-h257-no")
                        .into(gifview2);
                break;
            case "ABS":
                Glide
                        .with(this) // replace with 'this' if it's in activity
                        .load("https://lh3.googleusercontent.com/Kq2tFKWMl5wvyUCfzjrIqL2yoTrjqLg6RF9JuxkhTPLhLpuV4kQiOVVcHlwtBUadziP-NaH8v2bjm7uFDd0gXwmYckVzaYSQJBISCfj5KS9zI_mFBpW2nk7E-8KyzJHSd7K8jYS-49tLsjeBTbWdB3sVcylLOHpfRoS8DWAb9L-1XVAru2LrNJE7ubnzwLu-t4nQPExKECEuCaD5YL6Pi2oiafD9LgiE0TbonP5WcxDWGv1qA15qVexM21YdzMQJA-llRCjCVOqgtLNEPIXXeURqsrmo6VpLHWB1aGCxokwFqQZGRW46xXCpToR2BVhEnas16uOEOqQ-2I_lzzO47jxw8ykT5OwJxmhsnGp4m9wClcmVKcsJg-gItZjTAxFUufOUWnMKNyrQ96UPTX9DQ205K01mjRDKlKM8m5k0U1_opfFl-9p62rgDBu4ZcF-b5uebR3MhMaQ2W3qnYz5zIB2XqqtL8XG8umIuCo-FqD5OemosszlkmvRBGFALjeIycLARG5dM39LUXZSe8GeGNJ9OBxAA3EtZtiqeoVMYXO3te-ghfseOCyl3rCGu3EgB3woXxYfAFrITwj1HeQJnRAdUlb1pTaA3CMNXzFl6jE9Q7o96O9WVv8XWZAUEB3qg1Awtj5e4r5bQtfzdl8Zf5xg4dL9O3oQ=w711-h632-no")
                        .into(gifview);
                Glide
                        .with(this) // replace with 'this' if it's in activity
                        .load("https://lh3.googleusercontent.com/xrVIHptwExi8u4fvHHRnzTyEVRCfNPJWEBNHzW12X2fsN3BxrA0OnMcVvq0IBpHdUCcIMaOH_6opa-5rySO5dcjUzUtkTWqlWYpng2PzxZFfhacB35sG9Np39oEQzlmGiTsQSyoiGlS4vAcDZNq5DO8DLMIQQ5Y6jzc7sTAZROa0LrS9X3EmaJnaC4jewWuIbu7YePOTxl6tuMzngXOSD_ExlWFNxAo1j-JdDT1zrp3V_AwGVfpOGTwLTyqH5pZIz9NTNKCHoxuiFbNw7ZaD4wUqXGqF3xMCPqmfwx6aL76nQOW25jg-IJidktggHmevVj_9UiLucPanMA1IZA9Ww0xHb9WQ3ljEC4wL6B0WYE97iZ--HAHyXGmCXokG477Y293J7pji4VpBAhdpCrpzudaTdP60_AENGfm8RlV3wrGH_NCUYCbTnke74HCUzMr-2M-ZDJIiHKA9Mu3nilahocJNtyE7oTseCKd4Azxws9KYMDugI1hQHXm2YF_baiAh-FHePRo3gAijV42XoTgHDprtrAbwbAqeiGvqqen9bB_ezJzlrHMJ20KCQEf9GiCo8HQYoBD8HGq6ZAwAmuXJNeaLL4edqV83_8HqrCuy7F4Pa5S8McGi902I3CsFQWbM8gF6899i5Dyldev_RR_GwdutZuw7qls=w427-h257-no")
                        .into(gifview2);
                title.setText("ABDOMINALES");
                break;
            case "ANTEBR.":
                Glide
                        .with(this) // replace with 'this' if it's in activity
                        .load("https://lh3.googleusercontent.com/cZ5dASncB_v0vK9ufpO1V4Zy6prn6rPc3iwIVt_neNCsyaEYCGngNO47fkkRVmc77o0HAlhoHP7SWY7ttvQqa9GpIw6QDzGTMNHmOlwPCebXoo6Vy6dWxUhzWrygsesUSa3wAnLCQeCSflDEd00FTLz4eisLxA95RckdQwjkYDIT0XjUYQWtduEYvl68GCNiOFzGwt_38hVjSgLGELxRlT3aGrY3nToWFSwQQjLuVZxXFalHBeXcQKZDVqZDAkEenGJ8kD5PrfLCWstAk8Kg8ChT-xTCoeyHE96AY7i3Z8LuOcWvznUBl5BqXhh9NhDxoJssJkLO8HAjAFTu2Sf9FLd_l6Ja_FtnX_kO_M6MuSX7FJs2QbD6JB-aH2l-XS48k7cWPfiA4JUFasC6QOerkI_0x4N6oL_eps7dOwUsrvNDnfHctlRui9Hop-hER1TP07JtFgtc761qG1M47kXMmq5NG7T_f7-feeGhE-52mlldyi3MUI0d-p88p4fxRcPSD5yH6jFBdFUdJNkb71GxkErpOuID9zRKn_fdzHPR3BIehxoRhwiGL_xWIMQGSq-Ph-iZM330XT8CeGivBia9e0Yt7GFyrXFV2oCoxrgLX8FpNVGYmg2zllE03z8Oavhgk60k4sTRUZ9AadnyMeAA0VhIIa6UljY=w711-h632-no")
                        .into(gifview);
                Glide
                        .with(this) // replace with 'this' if it's in activity
                        .load("https://lh3.googleusercontent.com/lM-CefA_HvbSbo5zOejORJrW2fKwVWxzEsiZ6kOOR6TV-90qaMBEV6UxmOrjfLedSkc3-s3u3Sd3H-2GRoPDkb4k80aZjQB9PCgv1SrbXE5gx9Mxq2GH9KhCPX4pV4za1xpK5Qxoe7ijQ3QzWFtkxjSfRDS2woI7iudwnzsXIuPqq9UuG6HPPUchlG01JygCTfdQ4eWjSsMGZzVQhyeck4_1QDftbduAQMf0bLFDuxhu4yRiEWFwbI4H86bgHyp5_eJKn7OrjorBAJG5LOPpJQNfnruF2gtQn6L5iL0i1gdaXMrsr3NxcXjBJ6X1hluF00KHmN9562XDHjqEjOxa6uJwwnjqnciIZqvqG_MMEYVhR71FMzV8N9-dasTVV-z4RRcjOJ-7nBNNGqDfRuoewzKeg8a42OMP3NBrQRVN_jsDHlYJ4yQF4eS1lrV5lDjfdIrrkmvi-JDiKCz2zgR56t521jD06Q3ieNNUJp8GTIaS9h8O94rqMT0Xdo5lNHB58joneNyMyVpdbaaCacYdDIkQhca-SIbhNlKOG3sILKHlAUImLeZ-LTXJcTijN8x3xHBIgtwyKDd4SxP46n-L7SPsz7FH0UX-FiRba5PG-6ZpizDv_vy573rd_s0zbrqnUqQDbC7gym4QDx4DnpxWB298ycCVNi0=w427-h257-no")
                        .into(gifview2);
                title.setText("ANTEBRAZO");
                break;
            case "PECHO":
                Glide
                        .with(this) // replace with 'this' if it's in activity
                        .load("https://lh3.googleusercontent.com/Z28WsXZ86_difdHGRuLSoVlEot4ekUBkm9AJECtm-BnXCdSGKLSSKudPWgINPXH_8DJVKT9gCD7m0yrJ8Valjb_ZFXxFohIxpb-H9BULRkbBBjG68DnKdc_pXVoo9HvByxU48_8guT_Qhmf-YN8F89Te8VMrPEIQYxc4VYT_vVK5mKAcL8nSzsWvTNXR7SlUFKNdttcFHaV4eZXKOgLRq_Um9Y6O-zztu9SW6_Z994P3cgCBISDWnd8euIcBQr6HJ4OO_EvW3xX_F4JRNWJ0xKfqQrkndk2rYTFc60MfaNwxEeFwsrzlGoQpQouJoSd6WXFAteTcKBrwmbU0jQ5hvTPppenqLZXxjBcXG6lYQRoeqxOCnIpNBVdJAjsL8APMgMdLhB7DdpKb9MBZiX8dpG2michc-Ce6ztedIuMhuy7Lxw0SSe51MSVvpzyQmGUJpTa1ZynB-6ucZTJfH41YHPRMoQekqASVoQl6QvM7qmuIev9krTphDc7T8wrlsdGDo72b1yKnC7fyyyTZBWNKOoNrZwryk2epA8Yc2FxGQ0Qh-lPxjsQsP5DJmjqHGJWhNRkAdq2AoYTttbE1jkG4z9joaZzsE7HxXL28xWJRpQoQjhD009J9OZvxPST4mi0z6oZ9Rz8u2911tWuAsBpiBt48wjjKzas=w711-h632-no")
                        .into(gifview);
                Glide
                        .with(this) // replace with 'this' if it's in activity
                        .load("https://lh3.googleusercontent.com/_rk9JsFUkoARLTIbgfdUi78KOzr2o9zxB9OBbpxXFKW9ppQxqHMQo7Z8rzn49Va9c3a6i9hBCPr3Qh5AFDLuiR8g2a4Si7g6prGLqVEdHcoYg8eYhOXYn0RA2H5P9tcsZJdDG9pwO1KuSwd_Lj2QkPBaAfTABEmasba0S6vRTVWD81mONOYI_D8kcC_R5HdOr2ctz6rtqC4_3_1r2GqtqoqGP9gDm7MoNgxlYhmA4kepCvi3_n9cu_V6z4QP7MIi5Qhd9ciL_fow-U1JrzjUkjuAwcbZdYgwNhrREevCFWCERIMfR7IoWCDn6AZ8QiILphujLxQTg_R6t8j3y_-ZoAhUy9-K6nDHM5egUU4zTl5F6km5zppkBBUDwRKm5jbRP8ffY6G19U2WHaK2EkWcTA0niRTmxaD_3o1VyQ4nwpFm_8PYy18LFDntJ4GekmYvXtlKZGuAHHMMptaDI-MpkIJioR-cXUYr_5x4-UnqnOl9UGYcQQ4X7Eh6uHahkfwS77YjHc1hqhkcIIlYur3XJjTqZdRi1oD3Z_8yQ3rxP497HCB4fS_mnHrfG-bAJt5PnApM6B97_wOXfHk_HCwT3ZDQ5svz7GftLgeLgAg6ipDv7R6Yqgkxvp-couJGWIeubrIzPhYwJ5_abi-FnrnjA_-o-U8UUCI=w427-h257-no")
                        .into(gifview2);
                break;
            case "HOMBRO":
                Glide
                        .with(this) // replace with 'this' if it's in activity
                        .load("https://lh3.googleusercontent.com/bcySU4CUACRCq4vHVzPAbHfy2EyIbdgPuUkqn4blq9KGBPIOvUpdIG5QUCh4sXkt2-1ZFyAhHd4N0BOQ1PfBY06fyBnXGRdzchRO_a-6fF_Yz6gAvauggeFL9PkuQC0f30n04PcSLFbGc04cHl726sLqGNd4y9bQqjixDwVDk1xrCGhuK-DMN3FD9Aa9sNJ03bP-K-PkLvOesJkbLfpNrmXj7qY-qUA1aiKIflhzhocpi9QhTiAhbNS_XqDjXBwX5OMO4sHbqcp7ab4vj_ESYjWYus2hvV_XR2kb1ykt60uB_-nCu6Q9pwrFFVrBSUCkbyOs5KxSTRY-5cayucarBEpwurKWIlR7Sep6ijWGc68bozDqdMQ5Pi2xLz1-ouYyUYVDhwC-uiCPSxl9c50dvZ0o7_E5B0P_OCVrxXO_KnvM_FStsdi3zMeaZD0pmYvebpa3hS0f6D8HbcSkRssnLj2JdQbzaJmHU6Eq-QEg_na3y7V_f7SK5DX3jogz0df_GT2EYosfUj5WCWduYcZX1HpqfKgn6uel28-clOcFHZRNxwePlZ5ez8OrzhgqBIB5TY1q6vdqkNXM6P_E_OdEpkLWnYn5OsiBUMXkcpfmxe-qe4ux-60WV4V48XuJ29gv2gqHFd5Tjc4w5KyOi6otfK8KxbHlqoY=w711-h632-no")
                        .into(gifview);
                Glide
                        .with(this) // replace with 'this' if it's in activity
                        .load("https://lh3.googleusercontent.com/2w-EHTznHdhMZB0ValjQ1gt2UqJU3JLLo9P8wRnBZnq3hEYjPj9ncSVRy83CproJ7LEJTGEsjfim-5NDh7re5px4lu7pZPd43EvLUjq0XuKAUq98tBPiCXevhbgaKQK6DsThMOtY6QQGCzfbvP7IMgE4di8YolSdpF8kS_zTqU2nfUM_G7LDu_mC9H2bEqq0Gh7h3uiWW8qJOIftjByG6ev-qHVQvgj90qpW5rJXX4gHYOTEpylfgx1VdOUNMrsJaNiVA6RFkanyS-tAZtwhhI8awWJWpTy4O52N_Wn5bJx_mXzMkMr1pz29WrkPVGeKahh0hofRTJe0-aiUL99QVEd38HYaVx6-DIg3EN3y1g92iraPHhTlcbmw1Lpp7OWVCeseMoOToBM3GPqMJ8uK7cpupnds4WO-uGBpij3dRCvPAJHjqLNGJfZeZIeGGvlUYu_4Y6YIip3rEMmlHJ0au0gM5-pZYtpXKpoGwyCyNr2CdDRau0Q3GsYPN-I2LRnZEk9UAHx1PlzUd3NxYoM2tkWX2AACpDCZk65_A_2Jz1qYf_eLnWTN2zXXklSkMWyKoaYMzkge6xSdU3_xKxb4VLpqyTlAsyoGzAu_hf-bAH_ZQaSRkR_-bSQoy4hXvQr_vJzkHHGT2VsU60IMGHe8Mf7L9P6HFbk=w427-h257-no")
                        .into(gifview2);
                break;
            case "GEMELO":
                Glide
                        .with(this) // replace with 'this' if it's in activity
                        .load("https://lh3.googleusercontent.com/thxrcuk-wnXd_EXgUfnYgu1t7v0EqNnVxfpo004NeABRjCtZhUBxSHX9geupZ32arFX8K8zdIJGDuA-l1TgqXe71viCTBZmC_lcOWiVx9IQcJYjBTJYcU0617td5oFkqUqq_vJBmKR-0-nNi5mk3a-43v7NqrP4I5c8ZfDnrjE01Ef-0wIb25zg8R0w6FbPhl96RetB90Iz89o9GkPxQzMzGfznuWSPCd6ofjVjxJf6lVsLipzNOVcDH1f7GF7SW9YjuHFA7LmARjJ0lf5QesHghkJ-eZzHzGDrAxPOca6xaltO-chaQ055-eewAc6sCBA4ruoML0hsBGw5ZK_0PhneLRbWYp9pmL-5DlSRBzv23FIofYmMNUPrT_bYLqv7zx6RG4WFDfxw7uvQligJEu0ntBfKxaPNRTzt6HFzDRCDnkLvxDQXBdEa3yQ4thCRHB9llk-BmD2yHd8vj5d58ghkZ4wjR5ERu_e-C4mhvpoEamIMiH1ZZqSkku_rZSs8lcRfqvJhxfqvAv6U5dJnr3Hby70LBwW-Jzr19_3jh8Jp1umylMTmWWXTBZm2swmTYvQbS0P2WYriwRYG4npBEgSPUcjkDReFmoDM0gOog_wWoXoqBitw7agT9p9FChv7__CbSeMX7At8o59FdW-_mjUFGsJ1QKtU=w711-h632-no")
                        .into(gifview);
                Glide
                        .with(this) // replace with 'this' if it's in activity
                        .load("https://lh3.googleusercontent.com/Kt_4zOtXNnawqFAintVBmen1zHmW2WPfxN2CTTDhPfeXHPdlyyFHBcmOOgbm1oBg5aN6Tfmu8Te1n4rn1QWgj8Bh5hhoAuFe5GiZ0qdmYgKjdNHAWezUHolw9UFjCPmA6UIlAzcXvxSrE37y27DVEt4SxN-XG51LvTN7s6yqV1G-LExDRvhmFO8GiPGbwkXcEzGPqZ-eS9b341s7HaEDtzUK9SJCZdgrLE9cbFwIE9fPulUOC7URw8Jx-mT_2UrnVi-F5iEqL5vfpO0HNtpEBoiJDkW87kFau8JYm6-BnokkzXyf2Qt5Xnl7UEbBtHeV--B5USJRGyIoVu-MxdMlnlEqOtquV6zeEYeJjeddPTMwHxx_sVNY_bDqQ6s-ONk2BKFMwqsNLSatvPMWD0CZaanXXJjHnJnY3YwjOZtsSmaWO4m4dzrkqdSC0adcaz5pUTXZSRR7zYOAAsbYe964wDoHCbUqlBic4brRJ4Hiy5NsC91xReJRNb7vUhWfQnsTAvKiOmKgRfBGukpYtAcLvtksy7BINJeUa-TcgmTs9ShQ6wwEXhZmVP2zfXJz6CuOIP6X-LQaxaJ6KhmFlb3fsX19mO-5CU61Q-nvukzrfuS8J79nusQBVS96SKPq0tX4HUNnHbvnXL-zV-mXQh3_Yq--BQx9hS0=w427-h257-no")
                        .into(gifview2);
                break;
            case "GLUTEO":
                Glide
                        .with(this) // replace with 'this' if it's in activity
                        .load("https://lh3.googleusercontent.com/mW4v_oRmMfRjDIOdPmf-Bam733xXpSN2DTYlwssOJPoQX87pQ_feW-ndd8qU2ITy8syBe-BoxIV2yiaqg7FzVzhZph8DA8T_KLSuE58M939H385KyWmm-5kv49j6_vmVsgCh7lqWtyNMRwPAFazvAvW4vk_wDaOvgyWaEFXBDxTrXVPbSWkmMGFt2dAxc31sa77bCiI1g8IEyl6LIT_uFLNBbB1HlBv0HeBstmMkPZpKgTOqFwUOc1sz3e2p5h7aSwojDsACGINjHyENM5zN86tfXKQmZ2GGhERioO8Zaehb8Qbh6PNiEgGL6ihQXCwKNTRFLXbTg-xeKo3_oJT4JyXUfWjYYqvv4-zmkkg4qThhM7ZVJZG7Yse0IgflSn1YXWPYXMBmQydxJk6KkTzq5MfRc3bLr3kJX-GTTOtABFx_4IpdN5LbFJLlqABIwAFi2PlU7pb8MZQkVyAi-RJRS76SYc4D4qFdfLMcmoTB3e2tLcLy_07uXkP31PXO29RcR8_BGeue5c054gukJFPwOyeDk1HMRGzclo5qAJ3qzt3j6uDwHZfpYLF4FSrLa4tiJX_4SnNWhg_FfOlslnL-MoVyKRJEjPeFMtW0rfo8L4uiYZAPutl_sOp-Z313HkpjDYG94hDNepjn0WKrN6k7XHgnic0F55s=w711-h632-no")
                        .into(gifview);
                Glide
                        .with(this) // replace with 'this' if it's in activity
                        .load("https://lh3.googleusercontent.com/jYnr7WFVWsUcm-tUA0tw1R4v-ON8GWhWFUvk8AC4EKNVDnIty5AkOz7Z-mAF3Ca3askgArnwgA9ZdWs4fbFB9YUFdFR5Fa-0NpldNcyRYvSbOKHwBnbOs0gz6vL2Yls-rQpk6gvQD1R6qPpF4EergnhRYbjonEksMJWuu3myUSopgJZD-DPiMt1PRa0FRApcJfxk8WJKHRbwjMdg00bctyiNP_hV4PeGgw4hWZJ1z69eNfxiigKjrTktEfRn5wQUlCKFqpE_tzQBpfwkjfJMEl0MD-z7xxTHQo7ApZJR5bhmH_h4j_wIHMyAL87LB5AKU3b7dSqx1bbwsKLwkx4_k0dr6UjLUtIjmO9nAvXrEr9oEbJ8AmMGZFxtj6AY3Vs6Sq0KiQIYBQKQ_LkCWJzeU35LkQ0RERoleH2kD3GlpTIPFwgdj0ICvlS-7dmcIRCHIJ6OBgmhEimQ_G3w_9jiSjWC1tW69OWQvl55uTYyFe8Lx93v32vF6ir4ZLuQT1wZzVUJGpl1Mzh474PSn89g2IoNlBufxNyIb4PRt4399xk90LJbDgBNUGDwdaVBxpChbWVe-rinCru60VA8_dvPNjHqRNPHihsfdJhrinz-C4cUEAe8oPcCetbb6EhP1pBkbBEx0EJ6LYCaJeFKsn146WLObrUxYHo=w427-h257-no")
                        .into(gifview2);
                break;
            case "ESP.MED.":
                Glide
                        .with(this) // replace with 'this' if it's in activity
                        .load("https://lh3.googleusercontent.com/vteQeSg2dbPlGvcXe9py-ppgEJxEIr1PGJNDa2jwtLzsbv9zUnhx33OhuhrPlqAQRRnLzoEzZlphtqpXMh7nn76AVHjUpBzzzrrbs-Lf0NvqyQF6D_Ekptn3Y8CJ4KxY3TPGUhzc_vLOnwsFAc_H-3byX2QDfovKh-Rn2YlF8Z72b1nsTgMwxUws-zUzIvTlEVHnz5Q5vzF15XdaOBSEqX0pcCcDpisRpTMU8I3crtJMUPdA9Y-0ubeMGoVDByR7AwtCDAlCPe9QN-66vviJsV8E0Jy73Pa348ajp54sazz5R0TCQbhOlO0jjOJO9HLhYwOf34snv7utXOq8DffYjxRyjKY0zDZxnoCpvrmE7vY5RME8ENFR_fdBkktbyHgcC0GQ95JpQQncas_eOVoOB-Yvu0vqUY32iebEtIg4ovdpRiDUtOpyVV50hSCuvipb-kueUu5wd-jCxSG98sCwVoeDRb9ey3acCKgWMEOuc9vOy_qUfrPAgYqZp4zD6KHgJv347jkWhud6o5bXLq2Sr7oD2QnlPf9LpOcCF79kOBiDjY18hAZaVtQzq14EzsL-qMOZXi_d8jDXz5z3v_e2NQUjzU7dbWbHdBHV2UNMIxqsFJ5q71eqspcCx_jodrWjedDMr5YZQ2TE12j7m_S35YNNaealejc=w711-h632-no")
                        .into(gifview);
                Glide
                        .with(this) // replace with 'this' if it's in activity
                        .load("https://lh3.googleusercontent.com/xTdAmVh3JEwarv9Ll0-u390qud2wsaIA2BXn3G2JoUAJd5IKRfMXb77qhbz2qsqxPV5PM3uhoTR92gW5lgwQEYb7CCKPCRiLiot3QKlRiontiYpQHoIKGPJee7GNXne8XHpF72p_04Y9C0LFirSo5AZqYT2ex4bjJfigO0SlKycww5YxinsimVvaojHWPGsCTCnpyWRqxaxkH3l3L1bu0QioDgDwhnUQjtWL1f7dQnMHDl-JU82_qKtU3bVgnv2MQ2xUdKRmcfJZnybC_ppd___Sipn-Y78giJL1TlmCvR3eknMMuYNIMwtUSRvprpDDUL6ZiCVoIfS0loXFpL7qv0xC1bJH6SX0yUhUcVlwQsgQvnAKw3I-PZTO7hycgqK9o5cZYHbf4NTIzfwBaoTg6Ooei5tP4qRbwsu2ypXjtb0aHprpVH4tyq_D7MkBvxL-gHBtK1EJUYAl19DS9-NQhZ9RQU4YpEprtS-vjtFZnkVDBmMyMrgE8PLMlMSVZU9a8AkQkcyXRbOt6zR78xCgf-xKJKxpbrd18dEEQgSk5UCoTyuyD2A2qqGPBhQjdgwbcWwjRu9P7j5un37YY5MDtOEPxU5IJhCjvr0srxR2MLXPoGcBlT_CHV48eOJVT992sbeIDM_qye6ILrC6RYcDBXn9EUWHKxI=w427-h257-no")
                        .into(gifview2);
                title.setText("ESPALDA MEDIA");
                break;
            case "LUMBAR":
                Glide
                        .with(this) // replace with 'this' if it's in activity
                        .load("https://lh3.googleusercontent.com/wDMnq4ViNxw45akQWh-7lv_lWnFPRXj4ruvo7EDtWDbOnTML64KzL1Br3J-gDnb4AZFNbUQtOZE9JA41vJh8qrFUfPQrto3zfuAkL1hh_As0K5m9xbJ5UpkWzaWT5-FKAGwys0S4DRwvcyEc1HEDhCd4AZCLeXeOzI22mh2a7tfHwltaZtSAQ9BZr99qk0YjdVRfWzU2MvcqpDg-u1QLylfew00xD3lwwA13aTxlwUSrCB6P4QGgcIPzUdhqOpPpKrSQDHGw5TfWbSDWyynad1NfTYLQvTi78__Fo9SFWsKy5h2797BUTcUXuFJtEgN2XQemhln9L1NuYVaphpKOcMriSgvlc0-edn7OXIdhNNUrHY8v-TSMXckfrwh2jh2G-N8Ugjf4vT2iXEzB2ltyx0aMtrvANFeGmFI1AKKj0S-bODXJpazNA27eMm6i-escjZWf08XH5cKCQiw96_SglISRo_0-iLvXlYDEfjfSeEfV-WrgF3x85QXZUjq3WPuUO1UJTzKqc2EHW7qoopvV8IM0CCaiNzc_OdIwV8MDyKwcLsZP90kmmkRPkj8y2I6aneAvG7Srhj7J_Zs7PChe0vQ6D16RdN6OYdb4Cvl7qndbcWTZrei6wCyUvScgJ0H6JnTm5ZB1zaZz__MNERzJbYQJ7UOmdr8=w711-h632-no")
                        .into(gifview);
                Glide
                        .with(this) // replace with 'this' if it's in activity
                        .load("https://lh3.googleusercontent.com/yHrwztGlu6N1jyHkLBZgfpF1fsoyhPJKBSdWrGH0FFlajVqy9kwWn5HSH1-dSoEPX1UQzxwqbRMh58_cI9XX1qPfmtcWWl6e-tiVZhkGAbkXCLEk4pR1BKiB9vUvDQeZJnPqvbBe4tUd9Ezr1nmz-Yyb7KWXUiqKED_BqnzBqrmMOIE6zW_9OWmremvBYgE0XJxhD04w6bNrTtlyuVRQHmuYVKJGcf1eJ0bb9A2yh9AuneJmlG6FOsU2ytUh-Jd3yP_4mDe5ZH7AHx--QsH5-whY2Fazxvy12gURY3Wk2K-kDGE7Uzo4iHfvfLFUwLY7Sy6gGSwkiWtFNG49TxbfsB7P4z-Dg2SrfMruEuSlnBWVydNELKx7BjxWS9WbX-xGR_JHQurvktYXL2X7H5TyVPgdqi2TQF-FQ6vA_y6p59CvqO0QBft1ZoLaXLWgw1VK_KiU-9ASXZF63ME2DH3AiRBhBfllkOZnrF_yMGyzmvgkmwHoZRG6bHE_OvXais-ih42YwLYOtOgZMnu798hz2ruHKVCuWpBLz8V8MQ7Axra6iZrwm470nMnD9YykLy_uqaBMh9dr8I02MWQtv2v-P8zg07wT-bNABi1GOQlqC2TGbk4F0Wg5cvlK_LACEtNcVi19ajJ444Cg_cTUvyRiNthBg_vCJEA=w427-h257-no")
                        .into(gifview2);
                break;
            case "MUSLO":
                Glide
                        .with(this) // replace with 'this' if it's in activity
                        .load("https://lh3.googleusercontent.com/wPgZnJNrJhOX4kon695NxGfGlEt579sEwVI0g9xzl5IL1lqpu4uXwW1uJUhqwfMgQFRwjVMZnicmSxO93_t5vxaLvPSeKxWsAaCAQ9LRjckaGSq4I4ql1b1QGjD5E7qBLk9bYyfQU9UB948a2ArP6WhTLYnhQ7WFgLTyWbvj9r3Lq9t4tCruVOGFG_exRoTfCf58-NYWyVlbN3Zl08vLa3h7TV_WeXY_G4itMFKmx-UY4hcg2Mbeu8OOxyWBKwzKgGSp0T2MPo9VirkmbWnS4lSmymmQq5M07K5FcDj0QggT0bRmdTSZAa2Wa1rYKYfqLXG0Ks8wxTxzyufK5s-u-O-pYX4RvHsVISixaL9iZqkCfmOiZX_USu0nJw_LWsCbcGsYIkADqNkdSlpW6DLoHKK-9nJeiiyH7tXzbNncBU80IgxBXLdmSCobBUo5ARLcQbzqvHImtAkEthYh94hmt9VhVDCWMN5ViDlnJIyc0vzyZxSlM0Amvw5TTRj_8LHm0ttB0MBKov2TtPgBFTfyk5GM7F-MamnMeJojfjL_PunAuq5LdxFUshl3R5EpNpQ9eppA3MBf1w7ixK-2ZLnaGeqeWuOLk5VP9twQkfDlc4nnNWJnm3mXVlT7Fp-T45OkHTOt2VZFGFDx4EUmIQXhendY2wFRrug=w711-h632-no")
                        .into(gifview);
                Glide
                        .with(this) // replace with 'this' if it's in activity
                        .load("https://lh3.googleusercontent.com/OOzXw7gIFNEI4go2Bg_2NMakgzPProMEgdd-hl9nQg0YhaL9nobhjVgdE0kgvoEwhVLPryZ1mQD0BBbubLdiwAU--4KMChdglnXjiFVL3Jzu6lwp9OFO6GrSYx9PPyawtgJsxYij5KjBbVPKjl6VNYHACD9F1u6ryvfkeluWgDqc5geBE79m35l0z8V41dLPZGFo858k5FJskZMC5n189EIqrsF6A5-xLI5XenlV_7mqoz4tCaGN9zonNtsivnDariVb7nJM28IXZVrVcwNCA5usF0061atqR72nZkf6UrilcXUXZBv_9RG6yYfkS-g8cdrUFUE7ZhAeXeQmwRho61bfXa6qS1tcOuGIVSV1VOYd7Y2pSEZRKlgmxcrupxL4sGu7gqkQqAYYJgMaKtfU7l66J08i7QlV6NpYtTd3k0Vx_hoqP8RCnhhzgRBi6_WuVb2P6ZKr7GdfRCxeb8Kpu0BNSxgplqfnnkYqt05lAWYLqNt3p4RTxlJsWGspkdMcfgLDeNQUaIzfgON8j-AD5GALTiHLk6ic0Bebf1Hr6d3MIFQiV71jykGWPfytITKD-Kg916ztLvz8_A-vcW0vhpPrcgVaxEIxlWOr1eelcFAbXvEAucDkt-EobhxDN0zBHFS19-XVbYYIf-jEtvbe3BWdtnu7A0g=w427-h257-no")
                        .into(gifview2);
                break;
            case "TRICEPS":
                Glide
                        .with(this) // replace with 'this' if it's in activity
                        .load("https://lh3.googleusercontent.com/k7j7Vxdu6nXdVShtic8eHrjCCd7__BF7y2yS336jWQRvaubWloFbFWvyvNIMGhLEpWUvOQmwASnO7Qlzqv-isiKEU65hgI4S5yAlB9Rm395lNnWverg8x5Wrrzaoc98js86VNI7z_C3tjOcTwLP-xygwfIcZyJLZfcUz0Wxy9iOUkvXzPnT3SYSDwdXI7svBaNQSQiG3Y0rOWbXpRGY4ed_LGFcuYye8QTya3IPGWQDp8JtxylvmUp_j9n96I4O34xtj5EBxibn1F9aapj8dTEJl1Mj9__LUb14zXRFPMq6lK346T9RtHuermQmLYxG8EudUqO9IZYQ4zWDk7Q18cqaBH4-R2IjsdH8TYnh8qrfr_iDK0RLJq_ktKmxdWhmYKL5SXEv-Mwb4YZcgUltPcKGFVafpiQ4Vx8JUyH9FSAQaypG_xnkBBIw5H-oJcUHUjbHVScFfLI5_7pIKkrR6QgTPwx2VkiWb594i_WMTcQtLAEfezrnDR7-DBJmLOg1FADKQ9wB977C37RTLbVgVB4DaaMA661wY-mbtsDFN5X_nyv3l6KYfOPKy1iSSb9lZtY4itdCGjU57O09FHTPthaKXy4zOhKOJDbSAPOFl0w7AwOOdlzj-Kg8U_9dU8D1agrwObZqQEbT8XLfJAdRLyA6gXqypiC0=w711-h632-no")
                        .into(gifview);
                Glide
                        .with(this) // replace with 'this' if it's in activity
                        .load("https://lh3.googleusercontent.com/EaavHZ0tCcCvvhbZkWfZVckkuE-d45FKMryNqstGW6H1g-0cIYZW2g1o2hQhtds0iz-fsB1uolH2MGaqP9eAXlguGlWYoy_05cSaBtdSgVrKQCiz74kouWQVglX2R-ozE65dD6nRn2C0r4ycUXL0eB4bJjN7zdaNDF1BcRPOfVL7XR7dfJw6WHb_9SbCRZNw4hH1f6JPAG9hiM-oj-XYfxoNjxuJAtXvgdfFto4tRM2PIhx_BnPk8SF1scswrSFq8Ekpmf-xUMyL89uJyFdBs_HWP3TCx5r8vuFz2Z5a24Eysh1WOnKVISE6V0ETKx8uTOlEEcKzPjPOlLdIRjQGeIkS-BUiyV0ZNLySt20nlcup3ouRgwhZwNE1TDY8M2d5PWab2dZfWf24d-bbF82tfhuQBtwWiU1MEqIH_jEAZBphxnogrYC4Dfudw1OzuTrEZqVBKDrIxwVyOzKS1TrzwgngN1F3sLI3qLtoDIN3P40sOFoy_P8mhi_YES0W1K5osQf8oiIMqF1NC078RNyL_mPggqHuxVmptSPrfdbWuYxMeKX7_gj2sCxGK2fxRYpXuYaWv7TGXu2pLDdbDfmzZB9HsnSKdk8nhfcPiu4FTvmf2AOqL6kSK82lyNT0iiE2U7xJluPMlAFWKN9DLUAifoT1clHX2Nk=w427-h257-no")
                        .into(gifview2);
                break;
            case "ESP.SUP.":
                Glide
                        .with(this) // replace with 'this' if it's in activity
                        .load("https://lh3.googleusercontent.com/VhR_kz3XjH8JvynK9LvBryNiJLW-AokyTxLQ75yS4cP0su2cpnMPM1zajikchURO91oBwEccuovF1EsJAjdMQRwltVqqoUDTPXpKts0bvzBQg5Lxj4uAowVEZ5KET8BCl8555O_2QxxPTZLKQ6RLIomCZ1GQqMoF930cn4wamyfmEDCdA7np53q3J4qp5iGSLrYbiZTg8AfK9xkiTLM7pgmXBdVjeZEbEWphHHi7tzGVwT4CMNRX1zZvrgOLESIXDq7oR64vG4hAp9jFTvwbgvVEnz86--hK0QBcXADFSP2-lLiROJAX2BM7wNNWJIArzpOaqmNaVuddTFKpite2Pd35X2FPCjbljsaZhQsz9e2GlbOuaxjBoF9wzeioqZabloYS231F31031zNee9W5QAWZgjE-SLf4r1StDk3DnwQE-1ymARAXiOaQmJISiZDJFku4WU4Dg6rMk68ddnhZKWKCNMEZiBkI6WM_dFWQciHGJqLTX6eV5H65HPijqy5IHwm8vwgcqn-m4KLR42j0YHdJJWJyIV_We_Ve88SdsCeDExM5zzX1fT9pNYduMSZ6ee9nZ-AXf0UDIZM6XZX-PEvyD7oUSqZQv5MRMca7z3l2qsA3JQIm8sDSdwhbKWYUcsRjlsBy0yh9D3uQDl9pL8NOGWmK_CQ=w711-h632-no")
                        .into(gifview);
                Glide
                        .with(this) // replace with 'this' if it's in activity
                        .load("https://lh3.googleusercontent.com/6tk1XGqTV_k_ISshvi7BtVt_zzbw3g-ra1acZVmqUBDJIL1dvXSvLJWdX6OHiS4FcSu1t4Z7wg_9hAw_24VbDGq_kE4MJCj6X6zOt4efMmRxBrjKW5kXURAjSoRlYZ7EoY25wXL4Ah5m4Kk2W-_LM1WE2hzrq8FtzBRQipYB3mCo1N9cso3t0sD0wzVFKIOSTCe26Ng9val8Gks44ORdeqZB1G6JghKZgurVfIPMeO9W698sO2NqUOh3Hjq3_IH29e27iAxyefQE28B7Jqk9Qd74Zby3a9TFMCID4WM3jRij_xOgq-S5PZZryve4F94Wr1pxaE_7-Oj9zy5JQhjG1We71KtODn2PrazBnlnV9EW0f4N9PbCdxWoEYM0cKa2XemdU15pzq1MrHfqJ7xiKyT5se8HfTqXxR66invZperDB4T8caFCTqlaAeUFwIZB8OpsKyRRbyUzXRAw3YSJFsqOT-7-xufIc9zm4bu0kcOQnA79CqLm3W08tukCwPt9N3Pbmsu1Y9X2fGpWDw_xt3ov2hQ9LtvdqUMbHYZUpgiQYCgEWkVtPeDVzlJua_de_-FkB4672SC63hUFtzemjzBK5b2Pb6IYK53Ek30KppstBaXWs88U1T4e2BDrum3fHs5FH14mVfit58jvEud3iXjuacYmiIow=w427-h257-no")
                        .into(gifview2);
                title.setText("ESPALDA SUPERIOR");
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
            intent.putExtra("profileid", profileid);
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

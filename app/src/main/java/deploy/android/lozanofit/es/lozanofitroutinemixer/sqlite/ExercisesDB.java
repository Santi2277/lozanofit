package deploy.android.lozanofit.es.lozanofitroutinemixer.sqlite;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteDatabase.CursorFactory;

public class ExercisesDB extends SQLiteOpenHelper {

    //create database SQL sentence
    String sqlCreate = "CREATE TABLE Exercises (id INTEGER, name TEXT, photo_path TEXT, video_path TEXT, description TEXT, muscle_zone TEXT)";


    public ExercisesDB(Context context, String name, CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL("DROP TABLE IF EXISTS Exercises");
        db.execSQL(sqlCreate);

        //if db is opened correctly (COPIED FROM ONCREATE METHOD ABOVE MUST BE THE SAME!!!)
        if (db != null) {
            //Insert 103 exercises
            for (int i = 1; i <= 103; i++) {
                //Create data
                int id = i;
                String name = "";
                String photo_path = "";
                String video_path = "";
                String description = "";
                String muscle_zone = "";

                switch (i) {
                    case 1:
                        name = "Curl Banco Scott";
                        photo_path = "https://lh3.googleusercontent.com/qXOn76A0V3vvjW_BNApwrN6UQ7wWtFhxTA_NAzC0b8EhA1QQBUMhlfwewS1jSm_u6MwmqRL72NgMcHmBSCgz36DndbTyjCuBHTLhxn_qT06yISnO0EKGxSukGNhcKiUkRJZokLuPIWDaeLuG-XiyWwXLabYxGrPMRs3EtzhNJc-vSiTwa9eWIDV0T7ocCcE91iHejJvspuqBCNMvBxPlEvu5HimGf8tW7I03KrhKOmVKU9P0xUl58TpMfUKfbXwtF1iHJ-Q5iuzbe-opm1fLJozz_zsfV5aOxJA70jNsL_N8CAO_2ldea_YUBoxsmAtjmjCe9mLEql4K8gN18GXkXoYf8NTKOl5EUmzodZPOFepDIg9yj2--Au1O5ouUZevHOFmp-uid-EuLQzHF4jZh8tOVF00WC2iFNN9OSDaZ_aYTUyp1ojaBYnRUdBHquY8ZzaxOoqXnWVq3l59hU6WHfA4S7T3XAiHNtiHYYIU3XiLwBVIbyRKPILjTxbiSuYBD6ias_Z3HzwiZZybOjOvo8pBKr4yVvWEeUci5UfFMheQ087CRUbWRCXWITf1vJKEzvp3VW3hNHnycXwb8tvYiQeNMRWddViZkhsv-zuZJ045ZL76mmP2JXYpIwa6oycwdvBqMaUAfq4mdl8ba6PVEh21MVGPEOhDUIRHVxSB_q4LzSjdHQIzbDvXa=w712-h632-no";
                        video_path = "https://media.giphy.com/media/4NvfWAwJOKO31HviTb/giphy.gif";
                        description = "-Banco de 45º\n-Extensión parcial del brazo (bajada)\n-Codo y hombro estático\n-No balanceo\n-Espalda recta, piernas semiflexionadas";
                        muscle_zone = "biceps";
                        break;
                    case 2:
                        name = "Curl Con Giro";
                        photo_path = "https://lh3.googleusercontent.com/9dX8q0rdbHl06S0zybhrOHjLBKqcQUSX9WhsulQwYXj67ZBi4Y28XEaP3UWvBjXt8fJu61ghRRYwO0i71bvzbNvc8j8RJ4B8dK2iXnddoyXOg0-hrG86i-TPSzbDS1TIwKyV4nMcMg9uDADyRYA5eRoko3ZyxZP2zB7rGJrxlKw-dVgevkmNSU23l_nGYXgIbOlwVh9qif-Fbugslj6Ueezq4FnpPTBwN12e8nFLjjlnvz0km681FY8iRRZ8tq41buxY5HWirmkaq6iA5nkiuCzAWcYb-9hywHRJpbgzdpzSoajYMQ9JQHSdFl35v-Z7a7rGbD5uiT11XFVWTqr0IxLET3zyI7v9bEp5CdGuS3QePSNn4cnmykqnNyPPPP_YYtCXX06i5qhkN6yqA-Eb6ItMGQetWIVxtfxBnGiKkdKC4i4mxKg-MMzbpT67RFlNtx6CJssLx9AktH8y1OWpsJWizX_8hAhCa79ym9zbWe7frrZptGBnPMg9ZMFZSGMWUl1E4fJ_yg4I8zypV6AifPdVl1haNPDEPuZNL5Dg4cEhPY2WiA6yPMg_vGHVzAPb6SgcvzLbTElY5x5QEv-9p6DVv8fF2jCQXpKnVk3pPcbGxWBW8syFeWmx1ctjTVfc9qfHWgcSmUnGaFJxGE_OFCRLaFOpOLW-JY8Gmacp-Vy0ML_MAURzuLAR=w711-h632-no";
                        video_path = "https://media.giphy.com/media/SKOXeutd8KJNiXTyEd/giphy.gif";
                        description = "-Palma mira cadera luego hombro/pecho\n-Alternar der-izq\n-Codo y hombro estático\n-No balanceo\n-Espalda recta, piernas semiflexionadas";
                        muscle_zone = "biceps";
                        break;
                    case 3:
                        name = "Curl Concentrado";
                        photo_path = "https://lh3.googleusercontent.com/lzAS7j1jzb76P1iit8soZ3jkC8aM3CBlfspwBmRKLTXyfDM4iAUB0Ex3He67u99cPKhc-zx04xbdahxGcoWQOXTckfVBoKYCrvXGj_6y8SykG4mnnIn76qqlZTh5Dpo_cGG5aKWKtxkiIMEy7fyfUnJs8yAXi9Dpgh7ILLRqzGFSFUq_UKsPECmvxTsGqBgsEFzXE99J5lEJEd0Wf8E9yo8GteNSS4A0CC7ihh-cfNhKswTLlFilxyNkdIxdUFLeGt9wKY5LgYGf4WNoFjNuFklJirSTNynjFwGcxVOrAH1sf2rYg7Pcye3plGKAixTC8bM6zv2wnWRVkD2xzNnFy4Y2dMmvJiWfSPVgU2L010KOH4ij6lUsVzIuuPrkC4agB43Kq9c4CtYVLZdYHzZDKl1PCkgSoxuVsitaWpul47gy736LNqVWtshk6Dvy6LeP7MyHJzUAJeenDuk_J3nVdte3Igf0TRh8C91egYhsgB0kFViSgg5CYvLX4TSenV_vtm140wjrcqHFYwumOLmccnf1Cp-QEYJrf3_txpGk5o9Mxo0ggEoCByMMukqE43_RmWl73fgF0MRTKPeRWNnCExlRzOMNchof70Wod-_fjTG6XWrx21_tXXV85u6D3q6WnEWlLCutYb3-m5FCP5Wum-usW6R2hszQ5y5VtMpSRBBxLUrzGDp9Gzz5=w713-h632-no";
                        video_path = "https://media.giphy.com/media/piPn7NTBIV1QEmmnbW/giphy.gif";
                        description = "-Espalda inclinada pero recta\n-Codo estático en rodilla\n-Extensión parcial del brazo (bajada)\n-Mano sube apuntando la otra rodilla";
                        muscle_zone = "biceps";
                        break;
                    case 4:
                        name = "Curl Martillo";
                        photo_path = "https://lh3.googleusercontent.com/-GhEB-qYcj_5hNPnDJDE2yd5gssUYbj8PzRp6IvkYEesl65qepfNTQnXTDwH_wJpXzCbis-1IIfSw_Sd3OvTkaVMYLtSpm0s7p_JTbLu1f2RmKv_myRPTI3qHlVfr6TAv5hCJxDTPBbzB3fDUKSyySTcAn_9ceyLMk1MWRY9hzhWbsfNipsQYI4CnPgOvuXUqnxWwR3vr6UjtWHrgYnc_DeJoM1uvyaEPqxa4G7PJbH3ih8GfW3RrO1Mw6PDlzP_Scinm0pZXnVBAXrvEaI6D0T3h5jg7VKvD-tUIhtQW4K-UYh70uYEmt0Q-DWxsnTQUUtq3d1y2NtpY8FDDNmrp1xm1FCYciqfdeBqdPuBYZRNfrX_NNX_D6R2HmTV-cDn5CmcLlcJbxJAdFKKLn2rZWC5TpcjDp6sZebgDvgg96rrjXXnEqazMK21FuhjGMYTLiH3kaSXF77csKpyh0_1YvcKzjwEtkageXrqtiz9xzVzIWdIeEZb0VxIOcXtVtbixOzDUu3sIJ_bGPwXYVtRlaHSHXtqWBoO3RjSAJF8_qBK5AMyl1DiaCAgpUKeHuKhwh67sCtcdN0DbrsQk0R5pc_FPSNTdhqtaQtTQbbD321jnjSnaL2_KXf2WBkLE53w04-LAXUhOvm9VVlOoZs4__eDcStt1ekbpCnYVquRRI9T0pu8keQcfC91=w711-h632-no";
                        video_path = "https://media.giphy.com/media/4PUq7Z1xwozF0FuLb1/giphy.gif";
                        description = "-La palma mira al interior\n-Espalda recta, piernas semiflexionadas\n-Hombro y codo estáticos\n-No balanceo";
                        muscle_zone = "biceps";
                        break;
                    case 5:
                        name = "Dominada Supina";
                        photo_path = "https://lh3.googleusercontent.com/VBU6-xhVL5LwQTp7U8Iaj6ompCpwtub35k_NEoirLFny7JxAD1y3wYcXREE_Dh0EGtGIPE6VFoXZe_r4e--0XM57AgxgC1Lv6L-C-NPoMhMc6W4Aln5ozgI_VvGcjXVrwACQRLyEA-_FNjHvW1CxKrwYGCVmEcfZFXN_xPMIJU1DekGUELWNu7KUa3Py17CZ_yaO-1nI5gWUY1F5Am0Kb57FxR5gxVPZxp_RBGLVKS4HKQIPySZC17B0X5xmJPUagdoovZbZySpf9fjXtVMzU1rTP9DMJLJXResKJ_n_2fdYU_M6MReRmkG9Yfd-7Q0_5tnnwnqJavhQGcRXm26N5NuZGUc8KaW8-ymVGBvmHBLybmuI0-nBRRhp9nCV-cHw8KaDeInVyC00M8t3UjpIfYB2i9kVaqQJocUmXB72s__m0SndwYW21DBzX-bAjBcuf34yB58omUmEjG_Uc62Q2VIi-cXBdWaOGzNgtP4lFQij3uZfBWpaOM93P2vA2cZ_vsUtWqIbxVmk8Hn9v_ipORkSfB69enGhquArBtfFr3COw1doJsgWXkoHI2UDuqL_78If5P0zudI6gJWbn8DLM5_8xMB1X5ZH3QsY47Xl7AcsSppUiCxdS3s2FaXKtd0IVqp2ZKKTRntjWX1CXMpUqV5-Yt0K1rFUCs6ayPDY9DXXEumfLoqzU6By=w713-h632-no";
                        video_path = "https://media.giphy.com/media/jxa5Kc03BqSQZwy3cD/giphy.gif";
                        description = "-Agarre palma mira hacia atrás\n-Subida con flexión de brazos\n-No balanceo\n-Peso lastrado o mancuerna entre piernas";
                        muscle_zone = "biceps";
                        break;
                    case 6:
                        name = "Dominada Agarre Paralelo";
                        photo_path = "https://lh3.googleusercontent.com/-qwHc8VuzGsK9YYRg3FZvspbA3YaWg6oLF2x7VRu3L0nSQJ6w7WQZmXHx6nnnbfmm9TkB0G6wGMeSL_C1X_9jX-n8rNO9bGQIONsz2RJErp23Sr7AVLKcK5LLcQ70mng7IAJ_wVydDqOvkl3zuZ2pvIwPBFkLBAIoOQMxsLmHD5aGOn5WcGRrpbFoFUc7TPjjN-mqbg95NkI8-s9WsiTo5oeoqyFjCt6j0DXhMN5f4R_F_AnlQ8YcT7cGj9dEcs1VZwkNNWGScxykqHEazxlx8aHbPaxWwQ7jhgQ0HuIXZ8itIEHW8RPkoKO5VaMR6m1d6r9GHFNeonKTaPCIJuxmSuZQzjiD4MK5CJpeE-5ao3E78Bc1qHCr1XJSKeCe_bM6DxBo--AxaudK9Le-s6niqS152ELc8GIoqd7xNF7tZHbrVgRPPau1IYyXCuantoed--llzUau2uwgglv6mRNbwtvoWjaQJ_iqekr849PCYBUIzoh9QYI1ReYQGDrMsS2eui0pqd-n9CE_W30e1urgEMdlL00_MhEG6YoR_X3RHRcW3qUZ12pVSQLZL68f9mQiI-0esKrcL-WEDpRd5HjkCOgWRk2gAT2ERqK_Cm5RRxPgi5ibAMQf7oIydW2s2Cu2ISpOGjvVCzeTmLlqqmwBBRdPg1B2OJoCv1dg8r47eZvka_YZRtbmCgy=w711-h632-no";
                        video_path = "https://media.giphy.com/media/9DjRZ2TELxSmpeytEu/giphy.gif";
                        description = "-Agarre palma mira hacia adentro\n-Subir con flexión de brazos\n-No balanceo\n-Peso lastrado o mancuerna entre piernas";
                        muscle_zone = "biceps";
                        break;
                    case 7:
                        name = "Curl Con Barra";
                        photo_path = "https://lh3.googleusercontent.com/41LuhekQGImC8YVf8WC8s4Agh_PQcTX7o8t_sLcqEfCdi9ntADTl3zpgHX61D0WKfzjz9mHXkieCqU5fn7LIxd1Dt-k6rS_d_s2yTGo0YACD774ixYjHH02pR7T2iHQZkJpUX2OyDi6dbalpQVR6ojukcv9IvMj9CHBLFvYodax2EIhrd-0W-BeWnf3oDo-qHACa8MAqNDLD38fBT94YA0PtqwOsh38dAC9d_on7YbQTjXqgE-bbYVT8xLOx__ua82NCQg_x3Wls8dz9x3zk1SHsB3QZJfXaUfsn40RQMVAbQn4l2oDKfcHBMRlZ621DFvg53dgASK6m8XB7N4UU2CnnD7TmgOnwzAWgw1tFkRSHeUVKhP79o93mW7lUYyWuEH9SIJj7sZQBk1aSwNjafhlo_IZelwGWA4jZ_z9EZgC6TZSMkSZEykZhIXPrtN69-gRVcwFkbsI0XG_ohEzmGYJm45_hDioiSDUPdBhz1EanZ31dQfLARav9JhqV_tXzAp9j-ur2KbsndtywSbR4bdkcJ1H3vnlhD9O9znO7n2kGUSDCV1U75Y93g9J697K7JZMtB8Qo72iYVJX0gpAEtGqIuCG-VYF6VDyo8JbT96Thrp0svF9YdNtFbc6fpUXagLJB6061RVQGCQV_GCdMoAPfl3tlhac7rc3FOfUuLm6Ec_f66dpPn3SS=w713-h632-no";
                        video_path = "https://media.giphy.com/media/1pJ7pWHYBQM55tBume/giphy.gif";
                        description = "-Barra paralela al suelo\n-No balanceo\n-Piernas semiflexionadas\n-Codos junto al cuerpo\n-Hombros estáticos\n-Agarre palma arriba separación como codos";
                        muscle_zone = "biceps";
                        break;
                    case 8:
                        name = "Kettlebell al hombro";
                        photo_path = "https://lh3.googleusercontent.com/gLHzktKF3T_FBBAC4iaelB6m9gQuC1Bjat6WRHXo1tbCgBTwwuuHpglud8PmVlGNMkmIHWj7Bqu1dgI3Q3dWeWJfOhNFDP9l4mG-hiUpqBcJNuJ3gy1ZYoF0Is1AHi1ku0XaNTw95_9M5zN3SsaiaiJDTyty4D9VqBUjL1I1CR7bzZ43qYQX4_yPWxpo-r5ovgN1tpgRhJnRBcatKSGxebXNZ7QK0cgv-B1HVQGwHIGWP6zKKgRlT_BY5XsKGPtrwSK69dc0HWJvM7nqVe_qVz_4XBpMwZNhwKR09D79pElkO9AiKQch4zDLoMd7KmtX0_I4OO8S6p47tdu3LY3zCgkXA77M8_9MkEprQROc3M3eBE2QU6HDnWixdMTDNptREbD4WFpUnFPk5tltXdgBp6tM10I1Yy67LBYhHJiY2sbeECOZYcF-OlaiWhvUwNBq0AvclLZmAb2HXkmGDL_iwK4msUXJGmvhJaujTBc5qdcAkzHdbOK6mpWAlHboqwJUBY-jwqXz1bFkqyKnjFzCso15QNOHe9suO0nhGOQM5pmCpu7I_G4b7Umb8H83SJ8IEpCr4FuYjX8kzV795XbBt7xutGyTzqROjoJy43q0I-CbCNsGgQKN9Wec9XhkHgDaDggPcQez-Riksz2qTm_AJAO19Ilcuf6H1_ZdchwHa-T9HUT1vd3_GdPG=w713-h632-no";
                        video_path = "https://media.giphy.com/media/1dIXM606KyXUJSvQLl/giphy.gif";
                        description = "-Codo estático junto al cuerpo\n-Llevar peso al hombro contrario\n-Espalda recta, piernas semiflexionadas\n-No balanceo";
                        muscle_zone = "biceps";
                        break;
                    case 9:
                        name = "Curl Cuerda Polea";
                        photo_path = "https://lh3.googleusercontent.com/QvXpMXs0NjtRIiXZnwU35dbf7uSugN_slFO9g75y0CsolA7GwZLd8LO-J5s-Jbvx3uqFF5YX7pxLzYBnQw_KtgcryLoVWWLXcCXNmRdLTj4RvWVPZmxfmD0BXlyD2mW2WNKGDATEzHGDoF6T8_cSFs5t2Chvqs6N_sHCfTxnixmEQjL8r89HPvbSFuz9QVvuyk8IQssufJew5aaL2k0L90mCQpPi82DnlMjuY46xAbGd70bTBMSmoqnbvYYXuX9UBV79JCviVznxo8eSTj7XGKTuI32lCF5Rdcp_Q7y5R7SxfduUhN8YoDjVcOC0MaFGWMWSUsXy5HXG_sBbUuDb3TvaygetDMjMIf4ovMpTTVFcICqGJmoqL_4Epy7jhWONYtKXxD_0Var_d3lb1SkgYj6JmU9CzvVIM09hLjWiUIF-pyg3hxs5s6pvgW0Q3lGem3FjQYj00rd9WBTbu_Fv2N91YMPLwuULlxBXm54bghfGTG8jpbEKrQBvqIjAU0Yoq6NmyZnbPYusEb7jDZsLf_8sZPbejFaFSdWAwxlvMru-MNg6Hfs_cbogZuQ0PBb9YELR5VITTLIbNPdFEgdr0_DjdNaejuFZnVh7OaOhMCXgmMffh8DZWAsDarNN28_pfgrbhcRqR9p2PWiuV3iWsDB_3JCAQk0LYl_ZAdcL5tYXkH1vvazEL8FE=w713-h632-no";
                        video_path = "https://media.giphy.com/media/euPUdV2YcfdRTET7pg/giphy.gif";
                        description = "-Espalda recta, piernas semiflexionadas\n-No balanceo\n-Codos junto al cuerpo\n-Cuerda en polea";
                        muscle_zone = "biceps";
                        break;
                    case 10:
                        name = "Barra Z Banco Scott";
                        photo_path = "https://lh3.googleusercontent.com/f8hV7BI_uAXfds2Pcsga-OoVT1Lv2acCSq7QTTigFf1YtXYu74PXunXisCWD81TRc7heC2RNqdFmC93TyDhcx4ba38iVOK-srSZgBWjBCCcGuLqZejntDiBfh0y-uq1wNet3iCkZCZhACufPyx1iAqoaFQihI5dRlYk17K48FFlr2vDSKb5w6WW-JVxUTbpGR1i4OPudManX3IIzY13qxaThv7BX9tFNw1bUzSy0P7ac2BUB_c0tnO78-acBo4dD3GIqk8bN23gFk27QA2cQqD4NmWGohAxnVRxrxOWpXE8YmUsA8lvR3JVxEAdxZXtm2m3_SceNDxL0kZ7-lL3M5DF50M31b8wJ-PI8tQt9atPQLFfbf_wBZInh9CXKr1OFLT6tUsgjN8t_SYkPR8O604SIOuKc3_fg80hhLGmG4fwzhigl1_3mbxYMYk7tG8VmZ2jStZvwfWNS8DvsDqhmb6PgY-TAXdfdhVfIPxBS0pxv168LuG7_8r7psozlh5fj8Dp2cmdoH4Oz7Hakb80LXSGiaYyfTxBtfauNVJSje9ytnpDmdVZcT-25IEAbnne62RpFxt7BYOItsu4SABkyhn5IZ2TgeTt5LUXHiLVxlAbFw-CF8yR9-aqjdNOwCww-PwKnMvixLmNolhVQRYxPG8dzKqlV8Tp3a4kdPlH3NGckaLXXrIn74J3l=w713-h632-no";
                        video_path = "https://media.giphy.com/media/9DyQyftsliy0uhIE8i/giphy.gif";
                        description = "-Extensión parcial brazo (bajada)\n-Espalda recta, posición cómoda\n-Ajustar altura del asiento\n-Banco Scott";
                        muscle_zone = "biceps";
                        break;
                    case 11:
                        name = "Curl Barra Z";
                        photo_path = "https://lh3.googleusercontent.com/V1ArPQSqL0JYNoa7VSVytEuIqXETCcsHLjPiPB0hWL__0C9Q3OCq7HGKyjI5FrxtUcfGVW168EMIeJvRkv4ZDrut3F18l_7iq06zdcthAPGSpCQ4MHQA-CJkjZ-QT88EWndmYJOBjKI0QzurE_akbYbM6o18-3HTF0JNKXgGPDBzfr-B4Z5wNAv3FCWYErCzi_ZMbSRtNj_te2yrpohkxtDCayPz0nmI6j_vrWpK4RDBESC34XaetpPoNrf37ELMaL0AzD--8vJghgLWTzsUiGwS5l7gWj9-Z6VrZNFAQO1lCl6wvLsPoJPExv70JoJp2FrCNelXpgHdBKEE1HBeRNrN7mB6Pd_NEvP_3JWA-2Xb7BJqIkGcKtIXT9SlgmZVkHH3oqf1N94S3oW0ibhMJKBnDs6sT70nU5icrA6WgECSTcVjOCkh2B4FYo7TdYQDOU7efnJ4z2VwMMxNwu5x1dyKdmvcYR38UKlyNaa0etL6iLrgrphNMGJ9-fi_IUAiTithpZT5M8nDRVgi9QiRNWWd7McUBJWIHke_r0mJTZF6O4JFBvmd0-kQ1vsT0a-iYlk4560661oCROgPAa0YFowcYQJOxZ7pIob3X9IcCS3uBNc5qwPjhoTesh7u4nW-k2kmImijtrlPdpl-EIfxdY-yoNhVHMgbOHvkDdnXnfePWyQYSi0K1Mj1=w713-h632-no";
                        video_path = "https://media.giphy.com/media/lq9qvKmuXqiy8SsO8W/giphy.gif";
                        description = "-Barra paralela al suelo\n-No balanceo\n-Piernas semiflexionadas\n-Codos junto al cuerpo\n-Hombros estáticos\n-Agarre mitad barra Z, palmas arriba";
                        muscle_zone = "biceps";
                        break;
                    case 12:
                        name = "Escalar La Cuerda";
                        photo_path = "https://lh3.googleusercontent.com/3ykxf62mb7cQDO4i57Oo_5lmP_RJ__iyn_It8HabSgmEZqs-eoDIDTmDSt04ZZwWxo5iWExl80nLPN2e2xN5ICoJBejQt1b5MEVMeHXdehiMKGF_pWqv0bAMQf0WjcJkPcuc80npyAdrLygpB0CRhqDS4a5jSIkxg05aA_DHz6xMGTcTC1ZQ1OqyBzdgEN5qeBvR0bzLyIOFXINFYNW0ZVpAzQ85rc8m44jlLNYrDkl_IgxQ0VYb-HUaLtIz44I0mFKs3NXT-QG7_Sc1ZPX7bXeqAcUnnxz3eGDZ4bT1bk8d_VrWsxB56SpF1Uxbwk7vK6evjL2Zt8V_MkahkZv7IAwpmE1wZaZbGgK7OzpYG96teBJZknu_9lr8MxVJl0orZZL55OJff4wq4kvJNQ-M_Hs0_i2TPVq_QA6oLPAt0-XU53_gMfZhRDmK7eercw1yjlg7JY7YNVHhg3vjcTr9rTPOP4vjdy5l08F0_R2oRvAQtTNyb9Bx_TqjgqwCW2nijjjYVKi4sE5uVRDc4WM_hBf6t72GwZORe0C474JDCfU0GtJ7yTIc71QU5gLxr-9dPK1hgTfGwH54iDsI5Fyiai3JLzgZJfJkb2O4WqelVwJOia7tarkPCaaPXP5GYmkZSOEa_eHZRcWluu1SSIHJovZ7he_TSd8up_X8Tp5vy8CPmN9OkdxEhxpx=w713-h632-no";
                        video_path = "https://media.giphy.com/media/3LdSdt3op4tw9XyhKa/giphy.gif";
                        description = "-Subida de brazos\n-Evitar balanceo\n-Piernas cruzadas\n-Espalda recta";
                        muscle_zone = "biceps";
                        break;
                    case 13:
                        name = "Rope Training";
                        photo_path = "https://lh3.googleusercontent.com/yNPYE11qCiF1WW_0rJdZBPKDhywQlv5akHCkMPfqK82-CjcwyNCRHiDKnSwXRryqtCJhIh2snZcP36GwPnZenuuQ09So_4YjJZ99jwUb9hqLEdPFhdgyPu2ljtzo8Mk1S_5V6OKYvscjXENPrZjPQDNiX9f-uxWGdMxnVKMrnjDG_SRDMNCFBG1na9aus7gVyfkbiK6qjocNWacz8Zk1b4Hz02U6rerOY3Ch7Zstv8cJ8mFxKNbvhFWQM0T-6PGsJcpgLpXMgqbHHWgYT9ltFyvmoUVTaWZ7NpZeEv6SEKl19kxPZvqePi4AsZumS_X6jPfW4BYRp6l0O38DD3rLf-xhZjlO_osgZXOG2kVYsGLjpnGzIS0_K1griJ0jUGWAO8WulmKo_TBSeHbQFt_1U6D0bewwWeRSmZoKiHls6HfQ25sTUiZr2Enf9722SPjyLr15Z8cHPBA2TAles6juGUujhz3rRT_0o88lHOkdmtC8YOXTKNnjzGELQCeMMz63g3OQMU93EIxP6T6Z37dCpXfeGBzRakIXSIEaAvMQykFFxbgKylhrsUouqIUgDkfOrHMsvjnI7VIvhQgiXzWDRSbdM_CVoNonOxWjU9vPJKS-ZEvaBsjHcvy3yLW0cxkFYnGkgpy_Aj5iFa_B1QUnNCMV6eBPxTZ_d3jDUJ_nTlrrzJEeuv6YGI_S=w713-h632-no";
                        video_path = "https://media.giphy.com/media/9xyHLjv1hu4QtmIWjy/giphy.gif";
                        description = "-Piernas flexionadas\n-Espalda recta\n-Crear olas con la cuerda\n-Brazos altura hombros\n-Movimiento de brazos amplio";
                        muscle_zone = "biceps";
                        break;
                    case 14:
                        name = "Superabdominales";
                        photo_path = "https://lh3.googleusercontent.com/kwL5-slwlAxzy8KgsjntM-ai2F8bChUj0dMd4SsuoEBkwIHoiE8VKY_GqKMn3unxUcv2hQS1nEoFYsX27CPVO_5YoxJZoexKqf2OUW35F2yZmaDN9KTiOC7qKQ_zyttMBLh4COF_y_x3oiKKOLZTTYcXuYdKt8NsKBZPRg-UyRz8bLTqAnpKDCPIRnq15ibRyyDZo3ZEAasVXKvVmqOFG50ATRCP9qwEiutXmDvqm6iEEdwGV6NxD0NBR7RJFgr4iWDbzdO3yCqRNKlRISeCSU5QZZyUwjSN2xY2U5zmNhRzqxSzHjbeloDk1lpf5r08m_-adHudzGDeItqEmWIGGP1WlPBtjjjNwMX9yHNNyjIr7ZQiwoor6SQ0eKIE-d3XTz_dB0kyPyVfKammtIug0oaFvPJFHtV_mdt6G6ZRbqlyqOYEn6VgXTo7ttAg9tOsg8QHjo6hoUpyUxhVKp845-gXsqTVZVooxMzd0r4RW4unW7uF0p4zCTIsCp2WhF6HAqJa9KqN21sR7QplB9XaZCwnjX2k7Wf5uhB7Q6w34QSRxQy9elcmHVSyU5ombfU4xRlJ_Ray1C_DgcsseBLTmPpdI9L-OHldA_q5CFWuv96Aun422WMBEmttz0AtSZbl5oU676tDyrGKdkbKiZGGAkwMyFkjdpfML2VZ0QDHGdfqVPODm7uZ7NBC=w713-h632-no";
                        video_path = "https://media.giphy.com/media/3kJX141BbOd3xTl4Sv/giphy.gif";
                        description = "-Alternar abdominal de torso (AT) o cadera\n-Marcar la posición V intermedia\n-Parte no flexionada estática\n-Barbilla al pecho (AT)";
                        muscle_zone = "abs";
                        break;
                    case 15:
                        name = "Crunch";
                        photo_path = "https://lh3.googleusercontent.com/5cG7Lb3XI_wR6HGdvjBeGlYosgqLmmxwO6exv-SNm8uCsYenQVeZJDhv_8cBfd5sstWsvL5GhCXPSIihQUkVNVDyDZv3nEhb1Zkb4ciafJIvApdyFu9ZOooal7Q1k-IFe8_MD-o1jSLpdhYEyUp4vEG3FSPnuRvj78JTrx_SJvDBx9TRmgTdA_VvJh46uJ9IoLbGXZCbcjDNu-_3LN5KhSrj8DnqB6cD3nlKzWLw8WjL6mtggXu4fnFGiI8ANNJxZkst6BVBGx-B0ZzHTrT-F6bICqgSz68eIty1S2SB_HNnuZFFZVLyuzKI8krP-7e5EoXt2E2f9-ocwwU4VHD7gvssU3s08IBANd13QAPdzppX87NYtZzZH7ozlM3sCdoSI35hFaSg_2W2glq1oqOC2rQJpT-PGa2lc8iDJLwN2MUIzAnQu4FmqAh5GRbG0M8-2WiL9I7nrhk167LHHnpCOe5Af7MMn2avS9KQXOms0gAy86A6fbn_wzfoJ6kA6vPQ1zobcz3DEbidEj7j5gJ8xggDI5eFf9fZaDiaaxFPTM-QwEgJCMNzz1Y3hb96xAL6kDiJqKVnt_dJZBCN9BWgFBPNxfDQKQ79vB-2YsODSs4XgIZvVIXQeGjERLbSk5MksK18tTRJxMlhT6wIuTGRBSWeKLPVq5lC1DdPqbxv_V73JnQKTSbYJimw=w713-h632-no";
                        video_path = "https://media.giphy.com/media/BM0iusUpGKKFZeVann/giphy.gif";
                        description = "-Piernas en V tocando el suelo\n-barbilla cerca del pecho\n-Peso en el pecho\n-Subida hasta los 45º\n-No doblar lumbar";
                        muscle_zone = "abs";
                        break;
                    case 16:
                        name = "Crunch Lateral";
                        photo_path = "https://lh3.googleusercontent.com/BLhQ6d-NXC0uR0_aB7vJPFZ04iDBFlL91rP9ujFpTGXbkDUU3FxukLtaJoYsU69zxZPXAtf6Jq8MCciJ6CQh4Gt0PVJ9NVa3dDu-vmemQbFFO0ow65u6kFrBNLmYdkmS6KZCoXO2O8j9klmsIDLapnIAi_NBXL_ftgDal0ZU_Kqae_BPCqwznUtDvhEWKrHOnWxEk9lqAxEcAVS0PT2bP1wuDBQ6w-rLQC6CzW0dxxTZme4jqsU6xxMZqaI0wCb82rvzz9IWaC8LrOw4i1lR0NHwGl9XJBjKGnNKRZIPiZQp_SY7Ii-OWxhtG4tqNgO3F4Mnqqzu2098kSfsGceD9KKjhQ5wlxLAAonStQVdqNM9R5s46YvQKj8Wxqi7qlFxtCFn4UFazT1phXyakW_51DBRNSLtcgmQqg4v57VypJ9Ir7XcFRbxVi_g3mCpd3N2__s3tBC3m9w9UfppwSRpghH5mxXqWxWlio6EjFiepgqU-eDp8ID8Uw8Ah3iZzMPcMo8sWLKFd0RUDDWiVQmq0LUEKnAw1YGAGn8Ne1e0_lZCE4G97Y2foPSTRXQwPUHboKDACEV-ztyd3iaq1YHIw8dst4Z5Eo8dcPGrDAQBKIeDEIfv4kABI4tl8WwpaulAeG5FmXHezctps0g85F4U7GZ57lVPkSvHY3lQ0kUAnqz5HbZEu5hfWxZl=w711-h632-no";
                        video_path = "https://media.giphy.com/media/xV8qT1Fvmv9mP8fCwL/giphy.gif";
                        description = "-Tumbado boca arriba\n-Piernas al lado en V\n-Subida hombro diagonal \n-Peso en lado de pecho exterior al movimiento";
                        muscle_zone = "abs";
                        break;
                    case 17:
                        name = "Bodysaw";
                        photo_path = "https://lh3.googleusercontent.com/vqmFto7WWxVWbDfWyndORuFiunN4TwGf6uEoaxmV-6zmCVGATNEHsR3vLemyUlOygCcFz_xPBbQRWMEBUCalrPOh7V3hREsY2hTPhYQudHnUjrBDe8j-6K_dmXN5FOAya6r-Dm28wyvgRLzR0SXIpHMaBW8H8PUhr9yn9uYgjfvPUpgj-6QzsR4OA6-yXTYN06FNMh6R7r7Gd2C01cKRuBaJ1Ge90BeLvukPWPgziEj6yZ5mxuQN_m3rtg_HZSmQGU87bhPXqHIhAKYEkLy9ORICjKRDYLNMNjRiQvhET_pX79lU6AU5t5M_9lfjdVOhCsKEa-OWjiEHIMNqN6gLMs26ltIC8p-osh1wq79FbyTNCn2PG2A9XBgd4rHxPuuHn9NvPkB-hkwDsHvcK47ojzYcesu7l61JmcNPgRCuzci2TViMpomKGcbXZ8YnxsK3acm9xGu8GK3-TYrxYz7ToVIV8X9HsaIQtQ-ZSSjP8dOwm0FL9_VTbkSKm5pGfvGv0gNtS57bwaRKnu66uXGNUTdjJJ6KIIVqSBxSvsZnR8UNktw__7JCdGyXLXWQtaWoJhAOIpYVBpUVeLl1YmYU6KqsC3mlyRoY0N-keXjWbNChO9xv1Adj7u3CmU0QYG3F-KsgqMgnWnMncEUZXjrFrbiyAXivf2DZ6yXm-iW7JfHeX23B0lWeXY7S=w711-h632-no";
                        video_path = "https://media.giphy.com/media/13PE2r4iPbJFgZ4uk3/giphy.gif";
                        description = "-Plancha\n-Tronco y piernas firmes\n-Algo para deslizar (pies)\n-Movimiento adelante-atrás\n-Brazos mueven al cuerpo bloqueado";
                        muscle_zone = "abs";
                        break;
                    case 18:
                        name = "Plancha Lateral";
                        photo_path = "https://lh3.googleusercontent.com/chEHIxmGJAoekfd8cHs2d__Qb_cvUQtd3eP_Oq4JjzGMaFlLcGeML6pRr1h0g-KUwt63EmlbPxSUjp7S90gYqn8v3l_qs4BUJEeuBvzWnM-NUWOO_VO99cc7U-k8cpJWQVMeYRC-YWf7oYVg5oTCM6FxEb3nfg09ec1HrXg4kyZY1yKFODtZEjjTxtSJDYcg3WF72YgqxionKcJlJYU47jAg7u8L716qOVbeIyaFAzT7XPGZxvKj8SFnQFVc0E4g2xMpgC-9QX25jm1SYRXj3egEmaqjghKlmwJfQYDBHM9ePXGkz2qQDe-VzwDBHm-kbL-RjwkBR_eD1UkKVfjE98Tuk0m6OhRgJ6sWY2fz9G4IjgAhrMxWfCT8u6_UKrb2EvA0EgW_L2NO2weptUmIlczU_sXZiq1OX2NYup_AMT0iOrYufYpHs5iFmsWQ2Piltw0e_-FyddmmoKw_thGphpNF4PuB1mwPTYtRZWPqfdaUyHOTSqUAq_M9sT4CMUo76uiPTHrL-tuKb7Jh4nRhodMVDR8z6KmHQJuL--LNiSA0PQRYBXay-rVThDY81XFxhxBpaD34HOOxbnqOeUG4EK8hywBIsuywq04s39N5PP2XpC0I40vrvFzrB6ni2P06Y6LUfwaJE_fJmalMGUXDuNzErTxqGR6wcs36S-_bGSGBNXwYiMmOm8EW=w711-h632-no";
                        video_path = "https://media.giphy.com/media/5QLNmNzzO7Y0I47mJ3/giphy.gif";
                        description = "-No bajar cadera\n-Cuerpo bloqueado\n-Peso en la cadera\n-No hay movimiento, va por tiempo";
                        muscle_zone = "abs";
                        break;
                    case 19:
                        name = "Crunch Brazos Estirados";
                        photo_path = "https://lh3.googleusercontent.com/dtRpwCvFwnphzwOwBBwPR6LOIQQeE56cdGv_DN0KQ-LRZumnGcN0g43UU5fj9sWOyWh00nZfNIO4C5pKnamNur7Ui9zxQYRiMSBpQTgRibJYMWGvXtvnsRkZLuYmAy5N3JuLlB4GyXX63DVpt4sOVEPU_E_-ayz2L2oURmriC1Ms-GFs-09SLnrMjLHx8LvwVvKppCf66u7Pr8QKpzl3t-grDsNV6omatEXmvCp3a2a91M_PlldT9Fdv01VUj4B7cPVMEsFrpmuJJD4N0mLoCOEH56_-4CxQFWGD6rB-CXQdiqe0QnoAKCtMDnnb7r-kb4qMdyPEC9iIwwUYEy7q-OSe-algH3LCq-z7WNguC1v0Au0FB8ghA4JNx9fEL6BzkMa107qP9BkSbsQRL013ELAbk-dxUSruE2lek21Xm_71cpPgVRkFI0WkG9A_hVnt5-CoGGuc2t6mC8rsYNpPwvTCiZ6wnQ_8joV2By-Co7HqekdjcsdbpIiQ4FMve2j4aVogZpg2LUwPE7m2VRdAHiijvxvSrpYpmF54G9BE6zAIxhyh53UXAPt0kxnjrUu8DB569yDBUmlSMdc4sv69xyDgWoDlnFmVzAgQYtlC-prA2r5YOJ294_auE6urcRv87Yo20ZAmCpPlJeXSVaKmOvb0x6nR28F4TnqjfgSq0AKQfX8ZnNmghNR8=w713-h632-no";
                        video_path = "https://media.giphy.com/media/5R1ErA7RqF7HUMTIov/giphy.gif";
                        description = "-Piernas estáticas dobladas sobre cuerpo\n-Brazos estirados con peso\n-Brazos alineados con tronco\n-Brazos no adelantan tronco (subida)\n-Crunch corto con tronco";
                        muscle_zone = "abs";
                        break;
                    case 20:
                        name = "Piernas Estiradas en Barra";
                        photo_path = "https://lh3.googleusercontent.com/p5XGJpgc8kmezFEDvhgAG_j8L4lXnhEZjibgCdAf9H5bZE5xQMK_IEO4-9D2dPW8M2UvUuauluIdwsnCUpXaOenFmz3qIMoP-reflbWu1a1pIGXlBEI00aeChT2Tneh6uRrb9KzxXafjrmrc9RMNcoPrNBLfmXweN5etj7C0fpdnzfswnuHIWuSRtvO2gRkH4g6KQN-g5NCeuHZjD7pq-ORSi1PEY3YcT_8-7tDJFDmpIMNUQGZyjJVZO9uELxxd6m9bCVemT2Q3dEK7_btdR31-9YPaHl2rPktiwu1es_xplisxk3N9FritUfxk4ormr6iBowXYuchQTw0qR6dEJ1j2mS2iY87-q_fefUzATXH-xJBEkNw0bOavOZR7Y-XeRIPIzsTX-4_MNeztcn0dbTr_ia9oxw3NLiscKPYip_7u7nRDI1Or7yKRXmVUBv5T5d0gzcnK1B9jknKiLv8z7x_vid9cc8_FAUpmkQZCK2m64mkNiL39G2GK58Kisez6viOv_uqArmS5dNPRk3JQFrR9CbRfnAI-U9mE7AYmaDVEFhFYt90vdhsAtEp1FpRI_M_sUHLR_VOj3YpYCgVtTCKGmXw06AV0KKHatD242stizYxzOmiUjeDoZ-TW7jVhjcDofC4UXSOtLuQJ6WowiKcdBNvcxYI95Z2Gz0v2285pVyBnxtezxG5T=w713-h632-no";
                        video_path = "https://media.giphy.com/media/QJHwM8DUV6nwM8Zivx/giphy.gif";
                        description = "-Agarrado brazos estirados en barra\n-Posición inicial piernas estiradas\n-Cadera sube moviendo el resto del cuerpo\n-Impulso de cadera, resto del cuerpo fijo";
                        muscle_zone = "abs";
                        break;
                    case 21:
                        name = "Sentado en Barra";
                        photo_path = "https://lh3.googleusercontent.com/zAwEJShLr0Ylh70mc_p_fYFyVGuuxjP4OISNm8udCl1WLWv1Nj_fn5O6cBUKJQ2wakH-mMrBTDMRlSZ3vsU89vV62R8-sg29LCKUN-Ln7gIX3Hb6Tdh6NY1_556U0irK5dGj8bzlEqZ7JkfeKp963AKv5FfChOH43bzQEhwQi1tmCRXdLUy-k_bU6P3y2DKJ2xqKYy2jIOqtIjvU9m5iFykNN1t4o_yj7sLLlIwM3n6UkO5qLiTz-93-Ld1FI69D-u80thHD4x3WTTSccA2SyhGrg-NgKKuMPLM_BogjB1CHRPFn4sEgMNocuAc1w58Aj06n-GS2ltjg-o71gK9Th7TS7RH9rhainycQe4bC4zRh2iwGPmpYrxnBAy7u99-T2pSx7xOTNi_hJMgogaHELI3v0Bj6sq6U476NvcwDkHdeLZUGpYB-1PwclqcVMVxpKGm8WhtGdG_Pp_EzuUFrOioup7_f0TKDKNc_Ds9FXAGHiaYicymzDoDV-h-WWYV_f3H2aQejSDzMrp71ELCfHDow316k6esyutMayRpTgeYa1zDOlHLlKqyffKVZB2ND6J6bTEJ1C7LMd4OhVf-uJkN2w9h8UYrY3vxEN6TGxW686Esy812OXD9iZpTrcGVsVKmmYv5Whq873ee67SUEh92PmhunEcvmSQr-ja3wEhXwYIkcpPefPFaa=w713-h632-no";
                        video_path = "https://media.giphy.com/media/1BcgDvfn1aT4l18LlT/giphy.gif";
                        description = "-Agarrado brazos estirados en barra\n-Posición inicial como sentado\n-Cadera sube mueve resto del cuerpo\n-Impulso de cadera, resto del cuerpo fijo";
                        muscle_zone = "abs";
                        break;
                    case 22:
                        name = "Crunch Corto";
                        photo_path = "https://lh3.googleusercontent.com/2LxKol4oLiM84S0jXQ-9SuqIwkWdi97QW7rLL0IAl3aKJpHkEOrcIllq6LDa2xJJpG3NWiScsHwCU6Fm8RKqZ6EOsqj1qtCoQS1qefoAu0vDlPnuWjdaHG3pCpEDaUrtIGDZtERRpeyFjfoo0ZJ_rOD4jYabvoykCXhRuuYgf7hT_S817z6Vpu-ZfNVjcLl53zydGQJS7AAK_Yi9U0A63wHC26X1bcgVKI6rB9jGL9btsTMu5uH0TAWWSOk1vdfejDOmERqRolurVBioYt3OAmvWD5PAPMs9wTYn8_QSnQAco8ayUZ_2qkXN7kg476xn2AV578A-psvalweeHv2zy9YTOdLkp2MVfbSbTKT7a7BUBQw1mQaqaBxPLTifqIG_rzVke_VcOO1IbZlG0npgHVWxJC66uC90WAieVQqYMKnmfHhi_Ywg462IsHq9CuvRMBsbdTYqKvNShBSEJVI7dI8Qv6td1IKKY9BidAVXH7etfsbDa4sQJ9YO0NqWh0beWZSgSJ6ZlVWENRrzusdSOHyOy4f7Eg-Sg7e6iknUmtvIytaybttBRf9I6RAn-z83Y2RRkPuVK2_KCd5-aR9mbuL9g2uDZ_bc-KhoIrCx71YieDjgCq_fMdPI-avWnSufIsMiEsmtPaJ-i06rlJKDRJPm5JjB6Cpx8dbn2Uh5Xb5ffm84tEGxS6Qn=w713-h632-no";
                        video_path = "https://media.giphy.com/media/1rOXZsMytyUeRi3DhR/giphy.gif";
                        description = "-Piernas estáticas dobladas sobre cuerpo\n-Crunch corto con tronco\n-Barbilla en el pecho (subida)";
                        muscle_zone = "abs";
                        break;
                    case 23:
                        name = "Bici";
                        photo_path = "https://lh3.googleusercontent.com/Ug04Mj3zxMe5hmY8QGyhsACJaTB-zbY4jUGiKSjcqj5_QL0bex1tjpbeQv_jOVzxWv93Ipnbix_0eztAfrTP-lhCfYALG3euMPLrQTUNvSCn_3xBPzua5nqQR1bCEy28rZVilBegbZGzS7un9lgnyY8b83xvynEkYQjqPu0AEYXrXasn9iXR4ord6RzaQi1bSd1-psVTFOzh2zsyGmyJLhHbZ2iMUk3n9cCI3L8Ujobdx7C9gNF-HvnDAmYVAgvP0htsjRez_pI3ZCFlDFuHilHQ17tt6mZzp_qViUo01FbCK92wVX9cJ_6JgQZE7r211UOwzQkEbB9MHBlrwV2zSSqDyg2SNsPVIqwO2lp3p0YDLT91QxqbVzHKX_CuNT2qWj8Cz-qMLQMZBzmbkt6pcAZGAbGwkv8y74ZwCgGBoD81Qm1UxhiJwzYjiGS2ns5ydqM8ZX9gSd7xBbOEW6s8JwQms6MbQuN3oUH22CD22YYHAVaIJl_ZBWpleYtTSQ_Tj4BZd3V1mlySQ5eahlywd8wN_Haql9tR4WC8WM3hvx13SYMNpHbhJcb93b4eV0T0MpEpOzAHiwvKCjgkyiQGH62W_12GIox2rRIicpCYY_ZrgPkPB262wa2yiEHsf9r6wobomrdCbi8yIiHGK9JrQWlf1vhoe7cneLBwOmecnHT3ophj2E2VHUSm=w713-h632-no";
                        video_path = "https://media.giphy.com/media/3kxqtvnl6ZtYGlZ507/giphy.gif";
                        description = "-Piernas dobladas encima del cuerpo\n-Estirar pierna y flexionar pierna contraria\n-Crunch lateral codo a tocar rodilla contraria\n-Alternando lados\n-Levanto tronco luego giro";
                        muscle_zone = "abs";
                        break;
                    case 24:
                        name = "Lateral Piernas Cruzadas";
                        photo_path = "https://lh3.googleusercontent.com/Dj5lrC7mXI3FKEelMvZ_U8yb01FXAXtIPZd_YgFugPgmQHlzpz20PpDZuN5ypZjzrtD_4icIA8aKWOSiGTyEwOOKBZc1WWo1Szc-KTpvr6-DpCUKTWfzaEz6KaZLuBQiNapvwif-G1YZYeOlOIekySo5YOhwHXyEn-3kfWwjH-cEh6Z7cKpYWrtQZKN7WjIByob916jfuG1CvGBNV7FGtgiKauGewaSsyhdMcUY04pgIhYtfG6QP-HMEyDzc64yPYlEvMRo8s2OBqwXgM6dCzhT2DIxR1-eOtoHE7c4rj8lnT31PsgfN30R7JJ003cSxiwghfPS2PnbC4nBdMc-WzSgHO185lWtj6fY6OO_mcfzyEXBN3GEoBoVS9UPF4Hj5n2Sv4NPjFgTX8NpVRP4PQRhPRVYhr8lr8w-phL8w8CodG9YQDjPzPOkfQLa4zAh_dz0RZCIf-pQmFSIcKJgS75wQAqwqSlMbBEeouhh8XBJ6xkdP-yWZ_p63RRz4WwrEIvfUoTnDilQ2UnSnTc-rlwOtEq6phFZ91elKZmrJSXWqzOs_kTl4TOx35Po9QjLtdLa5nOTA3VFgP7nMZGsXM-uG3OVLdyBNlrGDbrsxBabwGueRyOJmnyFXY_H26DoE0LZp2DfUMH40ELlR9tMvgdG1Rvss3zW5MnHPrz2hl8uolSBSagyIHXe5=w713-h632-no";
                        video_path = "https://media.giphy.com/media/w7vu3QLKvuS49d8nvF/giphy.gif";
                        description = "-Un pie encima de la otra rodilla\n-Crunch hombro dirección rodilla opuesta\n-Levanto tronco luego giro\n-No alterno lados";
                        muscle_zone = "abs";
                        break;
                    case 25:
                        name = "Plancha Frontal a Lateral";
                        photo_path = "https://lh3.googleusercontent.com/-PM1IBlAyGpVJrx0YChTLdJ-zzdKEWwT9DqrmW9suf6KJr0M-D1ZhdnQv81O9f8YdU2c9EhcBVvOUm9UePTdHDO74fdiHq5zAKcqv6yOcfzmcxvpai2W7_XW9vy-i6830phazM8R36PDYEJzhY4RvBpv5ZsSa_aFrEA9BaypXq3ylr-eUd2cztUW7qUmvILHrTEFoQjUOpxEW9osasXtazENhVQCjiAybu21cE80uLKtytStfIQHm-U9hhCCt-VSzQ-1JhYwLmBscZ7uLmBzxw8THWquxmmfIY3Zqy9fAoTlx8-wWS8-iWfqjYodo39fhub6H1gkkT_j1KeDoLd1KkUrVYomfZr11ZpHCt2PHLk9fYT6jR_3zyF2mHABUWDcEYtXeaSm88Z_w7XgvaloYXYan6z92vD2qpRMlqMXP03HeQzeEcVzW3YTfzmY4_6C4Cq3d6d5KDOkysubNhGXnalOWSLZtgiHO5_2KbWASfoLFo2Rd1uyQAWhku8k9rCig72HLaaZoHH3X0IyHzNFtNUphP8hMdXhdu5LAURlWW8Uf4OLUa72JPruktJEf2WhvwVqEbdPHoeQP1K4m9gvge4R5X9Lr8gTcbDYY9G-bemoSERqWxQDaW8R29j5kPoPfND6ZVRA2cxx6catwn4otyEUPxg_zIzbAcGhZLnVW78iTm5iPZk14HgO=w713-h632-no";
                        video_path = "https://media.giphy.com/media/t6J5AiLkWqOCiJEc2j/giphy.gif";
                        description = "-Pasar de plancha frontal a lateral\n-Marcar cada plancha\n-Subir brazo luego por dentro (lateral)\n-Abdominal bloqueado cadera no baja";
                        muscle_zone = "abs";
                        break;
                    case 26:
                        name = "V Fitball";
                        photo_path = "https://lh3.googleusercontent.com/zAgFxX3PZpiquZNF_a6ryCvT8LhsM1-E3vrWun1yYWlRM6hne6rf6lAqH8LCd4XAQNc-uQoj5IM0UqWbL6mTeebYIibaHM3PMuas2xY9eXgALZtdQXU7z8eRDj8zL4CWEUab9g7tTXglPQAd2d89-BWjuvewiC8oZoJgbIrVvJYmFDIsBtmkT0s5rcECrZClCYM8Z_QG__5MGuJbaTnvlYZCu7twY8-qa3H2eWJEgTqDdUdeW8Jp-iSt1QDMSbzGzavLSLqa0tOt97zxtoKnz1Lt8TsixF4vC-UDMvIEOcccu2Knx8NTX6jw2vji1vYYD-ys3BTE7857inN0xWnkFfBskj51tQGz-EH1xHYXOfTt9_kjAxoePDbutksNcmMwlemaGhWWaB_seLmrDUf-XG5BBpsE2Qow-nsw1Dq6Eh0YLOvLPhBanP4e4-iesmAVVrYA1ZQ6HYQtEqUPja6ySTvFJCzIXs-EW9RcFJNrU4LsbDl7VP_YUO58qGyeQs-rr55VHfrKKOlCNafPUMfcRVU6tgsP2Cjby4p8UiwDVbskW6YINSAgt_CfNWXrh3uosIhvhjdhEUbWFpjUz_-16uAa5NnFCOsk6AXlI-CTfwAZCDs9enJrrOx3bn5AQiBXSrPCF-3xLwpu5cB5VTudpo45LI1iD_bvkaIgnOvj0HhHh9IShZM4oOv-=w713-h632-no";
                        video_path = "https://media.giphy.com/media/SiJWH65nxaYZyIEniz/giphy.gif";
                        description = "-Hacer una V pies y brazos\n-Piernas y tronco bloqueados\n-Movimiento controlado\n-Fuerza abdominal";
                        muscle_zone = "abs";
                        break;
                    case 27:
                        name = "Pase de Fitball";
                        photo_path = "https://lh3.googleusercontent.com/RBjns6m3a2hzkrwf9rtO812jW1HhbVk_LWcPNx4BgE57pWAq0IPBVvH_RBzS7CN9wZJWDIOT_QICDks0ZqAK7XoDs8nn7AdPuj4w6kxHUPFA-dbfYGtCkhyBk-dPOx2SZVXypN_RzsQAJDfXTxRLfElXCBu8drIeR3W_wRX1ulzs-Uc6nFLH-1G5qgeYZc5Yr6UnuK9kH_QYm5iASH3DfJXAu7fK3Yqr04pC4RLEanzp9ZWEUBJg1cJBiZwvAYnMM1WZEBXCBNLH4cZVWkOXq39eUg2xGEDn_-t9JMll4cZXIedruY4W1HEy2HofNIAqkv7IW8zbOt7rH0LA5Yq1LwTQOfgBUMQM5zE5vtzUmYP8YITlJpHn4484zmY4DugAr--heHQdqzdYSA6j69B9Bu3FCtjVd12RdnPoodJKf4TrehYJgVUYLjU7hLuwuH2SA5uJMkmeS2yXTv2rErkHI3nG27zxNdMvcl3Um02klL97U3XjI2gDGo6KR1775XX61VmqFj8yWRkhPNzJ-OGT0CZ3Qol4Hllnp4NKaLiTkKwfbEuhNSvt1v-2Zg_GE7V-_39CjjggCleFmpoyag0ekO0w0OXFfj1v00_rYsp3eFCQockhyf-1zewR2sd1D9Sj1Tp2jn99IySu897RYuz2nV5qJHnaFrfbOkRNcih6tK8n6_7Ya0xuAW9u=w713-h632-no";
                        video_path = "https://media.giphy.com/media/8JTla6P0RPoMulqaPL/giphy.gif";
                        description = "-Marcar las posiciones\n-Piernas y tronco en V en el pase\n-Movimiento controlado\n-Pase ni muy adelante ni muy atrás\n-Espalda lo más recta posible";
                        muscle_zone = "abs";
                        break;
                    case 28:
                        name = "Crunch en Fitball";
                        photo_path = "https://lh3.googleusercontent.com/CkZ05emxQDFYZnjyNttyKcRf-SW_TNHkZm0JQun6rejnRtDbldz32IdPUlLKzaz9VvRg4IXCxg-9_hOGjzOG3ljdEdOqtUCEaOVp2SXBY92uXYb61TV5BoCpwww9b_sFTIrCo-Y0gtkk82UdQp5s3_RCQyWJjhpSsLOMNcDDH49KynFF7bqdw-4nsKzOsxdWn0Lgxqi_OL8UnQ7tRi4VpSj9p3Lchs-DfLn1dSusOKEqSAlZHIyvIIh3nAZggMUDI_HveUwFv3K2ogkeJzfdpGzJKA4i-sw7jp36gFCIpmTzuGSobiZtUvQomfFom1Ho0wL6jXcMGNV4x4jO9f3cSQdl9YMDJ2YbTcZvbCPQhBV6cpd2tlTJPD4dCK8CLVNKRHvXZQNXR31EbyH3HKIJjoVq3d5XE7O_kgjy8awcb7KZvmVc5TOgz3CAwTev-UNYRUURv8vDjMu_hTEoDn8AuBr2nLMZxbhGoIAAxWonNzzY1xKmAb3DFRI1ecQLMyzmGeZkxn0-E12iarB70i5_1YljZP5jkv4re8GGS4ywkmrPevJwgy3gXhroJOMLlHGAN51L1tHBFHOn4jqeiZkoiQC9HSFuUoxosjEPF2nCxdQrlUsfzQvOucRqS-hkHJma3HeqSVWslyl2xmeHUu8bpb1sy6lniXTAyEUY6wBFVtbg0ca6o61XC1AJ=w713-h632-no";
                        video_path = "https://media.giphy.com/media/5qFZtdbscqdzGztyqz/giphy.gif";
                        description = "-Piernas bloqueadas se mueve tronco\n-Lumbar apoyado\n-Movimiento controlado";
                        muscle_zone = "abs";
                        break;
                    case 29:
                        name = "Rueda Abdominal";
                        photo_path = "https://lh3.googleusercontent.com/cyplD3u0xmB75czTy3urhIREfBcH0Sb5c2f0sI-N05nEYrrmFdAM1rnPFJVOLnGOYHcls84zeQODcr08uU40SkosFfs2zaWcyDezLkJbazKNec99k-YiHac1pZGSoHzX4sNwFiyJMXx2z_OhCvXxg2myCQtqdvMsCJv9rzr18xyamTXLknLeeY293dCGfwAkPhXd303KYZ4TDREQGo33w1ZY1avuftnL1y_yIzdoiNF9CNR9UvHDhJrFLyiQGutLsp7JTbXWmieItCAYkCqNKEqTNfSOCk1KZ-7H_H5hNPFeHKdFewtCwUEloZ6ipLHS7MXc6Zf7IY8AmbxHw_5PWm_JAmgBmd07Fz4bwvAld2OJGjz0fT7NQK5WjUtuCXG-xnsTM_REcu5YxCY89l84PunapxJDRxer7nbEeJ_D9zMu05dFLzkcV9UKqwj24I1hcKA2la0ZP5M_k9Z1HrPwsNPa7FL3dpo2eW2qyoFbi7Q4fScNGCpshqxSxMFsywIqRwrY1RlJd4ibZeKyfwdqtJtndvELaw6rhkjOzgtOx2Xx0dLSZgeOAnSxROVuOg3UIEzGoRFUY3AyVUOjFI_z0aqQrgfdBlz5NG53s2A83oXlcr6gWKY_nUMu3JEdGuKihg0T4D9rptX3Cb7UO5609zcPfEj2Bmy7gVIv7e17TuxA9ZjFyCnBRRma=w713-h632-no";
                        video_path = "https://media.giphy.com/media/2wXzHKMYZ2iAapps0B/giphy.gif";
                        description = "-Abdominal bloqueado\n-Movimiento lento y marcado\n-Espalda recta\n-Bajar el máximo sin perder esta posición\n-Brazos rectos";
                        muscle_zone = "abs";
                        break;
                    case 30:
                        name = "Tornado Pulley Slam";
                        photo_path = "https://lh3.googleusercontent.com/JtaN_Wee_bpWShCv9xZz0f27joxmbSlUt1nf37lCPYV3zqEUke06c7SHhizT4Gq6HQWxO_CClW3ZCFNJUpmZZQoL-ZlrwSIKY0R10RML94CrbttLYtKuV8w2vkAqtaTNWv9d1wbOMQ5inmwNNiTZtv_5CDMosBqSj-WQQLxPmwNVvR2mZf1YyO83hfhJOXcEnlTkUSC19jEPsLQo4hlqyYu55Mb5JVoYcuhydYyGVjUFJ1DACNZZrmqIgCNMc1dvRMdJJIA6aX_NSn2idXXGQeSz08f-ADiyllJYM1KpVa1VlYqLMlNoZ6-WCiWKVNMP5X3FNRzkv1M7FhYuIMS1kdmZExaBLatwx-Zw4OLuUMWwi5xePzRxJRv5fqI08QmZq9PwkddZXhe8DJBNBDp0Bz1kpfBoDzQy2AjZiULshsNBa4WPuFS-UyPhxFLgePGrm4cppNgtW-2q9C1tWw3qVj0ceSt17fZ4i0Y6OqL8lCIdtX0dBO4AvYBEFvUh1MShTs-onZ_TGqjTR2O5gkEzGV6-aV_4VvlVjID-2eciu5IfCGsJnV6GPM5NWPGVZUWK259dA7w8t9F_zjMZzfpDZFXVOh7pJiEXDZSd91CDni5cGfSHfNtvtQj61PL7KURLKVBmlVREmFl8gMskULsPTVU_oM3KiMgxRvc2udWS78UYH-It2y7GfGGG=w592-h632-no";
                        video_path = "https://media.giphy.com/media/4ZpQKoVF689Rfz8pAz/giphy.gif";
                        description = "-Piernas semiflexionadas, espalda recta\n-Brazos estirados\n-Cadera y hombros acompañan el movimiento";
                        muscle_zone = "abs";
                        break;
                    case 31:
                        name = "Flexion de Muneca";
                        photo_path = "https://lh3.googleusercontent.com/fsoPalgmg97dXnDhDpkelSPlwOLygit1I7nJMf5wDqn1a5IoK1S3x9mckx_8ixrUxGoA72YgzuLr0fKzcDgZTXlDj2znyLVSHHc6hnoNIf2NmVQTAIg2gVdalo9S2Fx4Ej7Vx6HRnJkoC3URQQzYUcKYp0WpKHOSzDtI-LtD3SPUSJR4ncytXdcl_WM1e5F6rqzA8fjXyv3F5MvHYqklnY0mMCa6HCrQ5SKePtYL2BsOO_-LKEwyt5nBCcE80U-VkiS6gFKxbI-mXclPfvX3NCHiiGfw0eJKFfHEHnjx8EPMAn2_wlUsyTGdyfJcM5VHljyOakJlQN53ZGmJ85USFRiuslM487ySt1i3NGu84sEXk1g_XQbPPuGj07faL3mdhp9ZAmVrKaA6A2RKuKwtDOskV1aC_50RjgzktDvdcaCVrb4qCFJQpVRBQgwznx32boRwZbMR9xcrkrCCHBX6sP4yjnUKXqtPUo9W7KxBDeP8GtTUnHmT9xnICl_mcGo2yHn2EuxviXtXfc-Z_BwIa9GH-Cy8BoAgTWU8R1GAYTU2Zl5q_8lL6-jlXVODB_dkmmsbNhxYwKudfm7KTPBslXevpI9WOXwibpaiCHCVurFlWqLY1s9jTaciPxs2or63JWKNvHMdUsOzECGU3Lk-BYo_ux-wKgKTZIyf7B3Kj9mUUjix58s0btuh=w713-h632-no";
                        video_path = "https://media.giphy.com/media/1ZnBAWjjXlKWMF0FZw/giphy.gif";
                        description = "-Antebrazo bloqueado\n-Posición del cuerpo cómoda y natural\n-Se mueve la muñeca solo\n-Palma hacia arriba";
                        muscle_zone = "forearm";
                        break;
                    case 32:
                        name = "Extension de Muneca";
                        photo_path = "https://lh3.googleusercontent.com/VT6FusoC0wkdzGgADsh9VMjbmpVcyT0P-RxinlNMHrQpcg1dGjiIg6aOx4qLeIB1kfXXavTCp_N2hcfhxPrIlVBSwnB3oVSpBIfCnxkbB2i1odJKzTRYwKVb5jZAirztTbMLMGHJKqS_Xf1u8UtBhaSkRMkIeXtFjWdpkSMN9daB0y9L8RuimjwesIrij5FDv5E2w-knPgN6xBhcGuyy0cF8X6STtswOyvKM2U9jUyvwgxbbw1km1SO8X445cgHP-CETcYBxPVbyvYj-vs9udGH5d3tPQtHxZg8Bx7sGakHgkGFajrolwDhM5uLZj3gOzs394a7JjjlnWuZg6i1uRpgJyYUrdte6PtY7J3Um2Z1DMJbvRDoqGRU9AlkEiqoPVcyIDHHdTqa-LMHhkAmkAdSFP4kubpZkl10U2OokXHtZpsz94fpiIpw5sRn5cqMqoCFsJe-tfQ7mCXYqJEbIHyrqGee5M4zen32bXN7KiBsxG4vGV09RJvOIfQiuxPMhMTUtsRAFbP8tGiQmmV6ZC0BD0aICGnt844Hxc_oN0WHM3aXaARaKUx40NGsnTEVSqN4m_LuCibKpzNHBrS-j2FNfeXoS8qRIc74xbFn5YvuPVU7_gheyXQ8qQ1vI87lXhVJ3scUsapRV9XjcZ2bOhyCJ275dIzFZSvzkpfTYhh3OcTxV_8anW31T=w713-h632-no";
                        video_path = "https://media.giphy.com/media/tJYdAoXnHjilIWNZAl/giphy.gif";
                        description = "-Antebrazo bloqueado\n-Posición del cuerpo cómoda\n-Se mueve la muñeca solo\n-Palma hacia abajo";
                        muscle_zone = "forearm";
                        break;
                    case 33:
                        name = "Rotacion de Muneca";
                        photo_path = "https://lh3.googleusercontent.com/VT6FusoC0wkdzGgADsh9VMjbmpVcyT0P-RxinlNMHrQpcg1dGjiIg6aOx4qLeIB1kfXXavTCp_N2hcfhxPrIlVBSwnB3oVSpBIfCnxkbB2i1odJKzTRYwKVb5jZAirztTbMLMGHJKqS_Xf1u8UtBhaSkRMkIeXtFjWdpkSMN9daB0y9L8RuimjwesIrij5FDv5E2w-knPgN6xBhcGuyy0cF8X6STtswOyvKM2U9jUyvwgxbbw1km1SO8X445cgHP-CETcYBxPVbyvYj-vs9udGH5d3tPQtHxZg8Bx7sGakHgkGFajrolwDhM5uLZj3gOzs394a7JjjlnWuZg6i1uRpgJyYUrdte6PtY7J3Um2Z1DMJbvRDoqGRU9AlkEiqoPVcyIDHHdTqa-LMHhkAmkAdSFP4kubpZkl10U2OokXHtZpsz94fpiIpw5sRn5cqMqoCFsJe-tfQ7mCXYqJEbIHyrqGee5M4zen32bXN7KiBsxG4vGV09RJvOIfQiuxPMhMTUtsRAFbP8tGiQmmV6ZC0BD0aICGnt844Hxc_oN0WHM3aXaARaKUx40NGsnTEVSqN4m_LuCibKpzNHBrS-j2FNfeXoS8qRIc74xbFn5YvuPVU7_gheyXQ8qQ1vI87lXhVJ3scUsapRV9XjcZ2bOhyCJ275dIzFZSvzkpfTYhh3OcTxV_8anW31T=w713-h632-no";
                        video_path = "https://media.giphy.com/media/7OVQTNQbAjVeCFhmd4/giphy.gif";
                        description = "-Antebrazo bloqueado\n-Posición del cuerpo cómoda";
                        muscle_zone = "forearm";
                        break;
                    case 34:
                        name = "Flexion y Extension de Dedos";
                        photo_path = "https://lh3.googleusercontent.com/qBM6Nsyl1hQvlP3D8ccjCrhDsc-dG5D7SptavRH0jvLwiE1pNfg1xnFD4b6I1coPs15oxLWTvYZgk2EG0qpglRdRhhVYdsVu30Bei3TYJTyUeHf2y43RRoIBMMstqZ4IqjfDka_Ea_qou4sSHXr3Z1TqJ8UxHXp8XWNODdojRWBx7WZKHhEjYJsAdgyJVKypgGX5wS5QNVOr2QWyZyiIg9K7nyJXoiKru9bioKUlLVKVxCbKcqlwPPAIurnhK_yKczp1re093HzDlCjZGsTCAHTlFpTzGpLH_6_bzYWCMKs4m-4p1scgqgINH-XZ7LclnbwQ2gUV5qhaLUVaiTs6TeTAqU9gNFLfS2T-hCBPDTD8Dei4wvSn3nw7uPy8SCxJfHlrwvpWwRZ1lPE1oSmVLL2Np9ymdRA56n0WeFnJuXxVUyrCFN89wDtPbr2pCUv0PPKJvUTFdlAdRmlZHsF9thU7TKnyHs0k4ZU3YywbvPTpBes2jdS1eAUteNj0W8UdjwNS635mLYSUg6JEVbcqx8oKhlLbuU1l-OpQBo5yH7OQxH3xnU5IjwKf4iwGaFhrp_kwsikiOYCeLVmcdWM3lPKL5MriderpwsjcxgL7wf9vwJ8b7M9NMbdG9yw-H2qSN2eEoyM3vzEkO2z26Xv3GlkYd2qzrShGSM1ojpWJYeBcwPRAuQn3lO0J=w680-h632-no";
                        video_path = "https://media.giphy.com/media/oOBv4TkeywxU3sdMRT/giphy.gif";
                        description = "-Si falta material, botón de cambio de ejercicio\n-Apretar pelota estirar dedos\n-Con una pelota de espuma solo (flexión de dedos)";
                        muscle_zone = "forearm";
                        break;
                    case 35:
                        name = "Press Plano";
                        photo_path = "https://lh3.googleusercontent.com/OAsR0Y5CV4V9Re1vLvL26rJmx0rF8S-QW0ZEybFx54KQFIXMEt6D7op-P0pDVz10ndB7dp2HcHwejLaRIKXhEbBonGrh9rfBELJQr2muY5yRvhgmuNdhBjHeT7n6Nedthwl10ZHkaAPRQ5148ZgOpG5Nc4EW4UK4aBWA0YH9QlNXOZapa3VGSp9yok6_LuiKcbgGHM3-rnTT84hYnZyNGRA5QQfduM0G5JI4pYpr2LQ-uZ-9HUvnEIBZFY2Pr-axil5i7RT-GLsRknuBM2LuE_aqR7bGKkqsESk4F6grgzmCROw8uNmRcMyG9dCuhy9fuTEGl5lvtalPG3m8wMVbprHZXval47ma4MF-W2e1h_GYFLPKTWl7F7NjmN7JjwWg2zKnChoOlLQtrL7G5in9yHGC3dFN3EtbyfXLTzcRwK6GSguIA_RdnWR1pZ4I6jpjNaWSIF7Gr6Kzmdu2YfgqthpvscmbRLUbtxVz9cMASSYt5x405-1l_AEPgz5IiUmzX5BjG7Ry5hED-WGCGnI79Z5W2AXxGHc4wXocrTCBqHqq2LXKbZ-Khz9N9o72_naI2eG_oRoYySA19CDZvvfRZyGwadXPi2QhgUvg-UzoSWksGOF_VWifEQsjpeA7FkIV6VBZfRQSjm7fYqPrnlSb5f6FN22MVg1hJs0X_RoVvHmN_dLg--CGwUYU=w713-h632-no";
                        video_path = "https://media.giphy.com/media/6IwUAaNBgzpSk68EsD/giphy.gif";
                        description = "-Tumbado\n-Ángulo codo con tronco 90º\n-Codo baja un poco mas que el pecho\n-Subida hacia arriba no arriba-interior";
                        muscle_zone = "chest";
                        break;
                    case 36:
                        name = "Press 30º";
                        photo_path = "https://lh3.googleusercontent.com/xT8R3pxO365PVaQMy4wv6Z07EyE0kHuW4hEc_oSWLM_k7Z_uS2Mf0--cseIufgJlEABvDBxGusTH_ejt9I7rPg45ajU_Vip1UCOzoJ7Fi2_mnpw7ZJ3sVw7gBJserByzdkvW5xfqeXTh3zzMFU-T3Y4eWCfvY3ltrTJVaNtkONWLSl9uwuIk--LDZxa2eODzS_rtxMi_XGJv6do168FMwApczHKZkvuyYYvTS99EoDYBvXOd0WkzMTTWxlnHCA8EUv4lmaXvGle0V1lGsyuUPogIBPYiikK4UvotdSPosAH5VlzQEK5jQJzGNRSe8zkA8jfF9FLLfTFnKGJUh_I1kdU1oQyRSd118zhzreYLPbtZgHyl5P92qXhAXy9kQVVK6rBUJTRSfU_WJ-eLF2nqoZ7haCS7wZARetG76gnhm7sVi1lwAjRCmx7l5gtQSng0ZFxhCX5tABV1SSjFcTGLVF5YRAa9TATDycb6OZmcU_caYvbEIpIhKOIx9t6fdf77qf6_ujpq5nUSWhL6pGiI43t4ZwKSVKvD4qwfK2ZwZMQGcdioyQ0KaZGSND-a7dSlCJ4hRVNE7i72zT7M1cugqH0YwFuR-qgLPyCu_4ZDuCIqYfBfdrAMNCL0t4tnfpKqVEMiNLe6zDtd5moTf-gJIL9z_P7LWIcZSU1l0p91qLEzXUIWCHcwj_5E=w713-h632-no";
                        video_path = "https://media.giphy.com/media/uUTn9MknCgd4A8M5rL/giphy.gif";
                        description = "-Banco 30º inclinado\n-Ángulo codo con tronco 90º\n-Codos bajan mas abajo que pecho\n-Mancuernas suben rectas no diagonal interior";
                        muscle_zone = "chest";
                        break;
                    case 37:
                        name = "Press 45º Mancuernas Tocandose";
                        photo_path = "https://lh3.googleusercontent.com/TbaQW-bK4QhLx_7mAY7HtuprsjOcn2zPvoD-UHF0eVpprfYKZm3nsabVu65T6NtvQkxuSIbpUIEngx32HB_zRpfxpayBpb8LUYsWX_-u7BJFvkHhcU9CLehxU5PuFP0MMIhdqCvfC46nA0g_XlqjrrbJZWSB0Un-IR3_nmPplQWvEZDp_b4L6_VXagZn2MMjwwEKThRbZQn5a2nLIUebWFuVeK33fE8Ri9K-E5DcpvLlfUkXoroV4LN-xbqcc-D8XPzjokL25nFYyHS8Xb3MNkVr-oTq4m3KtE_xvp3uV7TEhuvIUlCOxSslBbcRDGziwqJpYDvgeCRUTINPAuEqNjScsPQ5xod9ybpUR3EGwtY2I6dUHW6ZLSFDtSXkpHO6Yc3-R2JX3SusRyJ0rWZl6VEslKSlhvBTBFtoGKGSo7J-sAWjEDCXavx6_v1iG22CNIxefQ0VQho4eNwWM34E900s1d2IshMVuyfB6LudMKFIvwfPkK7PrKPzuVuKlP0sdDgeOVV93GbBO0bu3vxKA3ASFjksCtE_Otke3O3Z-U_H3vTYjESkSG1iANIBpSk-HKLQDtwK9VbfcxuNsBwbb_kyWAUlpgIQUI1zQtAe6y2C1kOsMdJCKR-tirf17as-oEzpNBrGE8krghsP5eLNAiiXNWe_Lg24GahmVPzPF2Ha1DoORYF9SOA3=w713-h632-no";
                        video_path = "https://media.giphy.com/media/1zR9sWUTovqqrV2lGx/giphy.gif";
                        description = "Banco 45º inclinado\n-Mancuernas se tocan por los lados\n-Bajar hasta casi tocar el pecho\n-Codos cómodos al lado";
                        muscle_zone = "chest";
                        break;
                    case 38:
                        name = "Flexiones de Pecho";
                        photo_path = "https://lh3.googleusercontent.com/o8hx3aCFHAfKgM3H2cnXpie_0Y3YvPpO8OoTDUfiq7E29D1QMPeVU4luNJzDEa3FQKpCachrMViR3J3TNa3fyyj62qtB3cI7fkxCyXh1X3_AzPWetMnydD51Ura6L41o5ZlcHHJha8yVYOaspigCwDEOJC3GZXg1dzX7Uci3PCtwgSXWj8GDO54Y4gql6Ocw80Zy6rfrgC2YQlyNHDNpOWL8ecr6qB0wpHi8lTd6AYEhmKrDSKA-NCfreKO2YjjwD0CH-ZiOSA6psmI6pa-1MqJXm9d9iSR_nnvdsQI1U70ViyyBzjuhUO31vF8yAtv0MO5h4pGUQ6v6w0m-4K6jsZ2n6u2vkWP1zoyn-yfPoOmRmyvwSVwWly2L0jhJ_B5MQ6JVEuPRnpKaD_ktZWzwqTXMXStOZQfWIt0NjV8VQO1PA0Prwi3QkA4AcVmV7KvW-E6nOFgN1RT0BS34fPzL_F6URrQd1hBav523h3IGdLF1XFAFre8vQPRMpgV_3T1bJnmVc1xvdUPhUdMpezdcDo_WJIIZPzb1OIIPfzBEQ1UF6ntJzoU1PBlLWLuZvcsHCYkOzuleCIf8Fb7IVtuS2SBWHHAPcY3G4fop88Fmwj6cwg3EMtUSvDmY-qjRTkgFRKrd69aqA8h8l6suJh4n3D_MltAgpEkYrOCxZpjLESH8vn9Rc-F_5vao=w713-h632-no";
                        video_path = "https://media.giphy.com/media/2vr9OUgH61WJ0VXA5i/giphy.gif";
                        description = "-Ángulo codo con tronco un poco menos de 90º\n-Bajar hasta casi tocar suelo\n-Abdominal bloqueado cadera no baja (como plancha abd.)";
                        muscle_zone = "chest";
                        break;
                    case 39:
                        name = "Press en Polea Manos Interior";
                        photo_path = "https://lh3.googleusercontent.com/wG6geg2o8NhyJxHn5Q6hIPVcWJRPaXC_uzLPXcI31IiMV7dlCuM1CPt-0w-A0ORpE6EPD-Zj35-XyrXbFGvLWhQInHXtD-lxzRLGWeD-pyOFuK8wAfgZg1Ls2L70q0HQfuxuHORjN2KASKfPhqBuLQUNE9WhRVioNU_uMuK6u9KNJuEmJuvXdJBfGnslpgRJYVMn2pKrrLALa7lBGQd_EA6F0M32cTYUdk3K_WZFpWRtAKQIndqBDsC3b4crFjCN_A20BLBv8FOwkjurh1oz-e3EWBOAG0vJmNKEuEJGoTns3fmhw2fkaVRuY-fmjd9k8unRqyo8DFfrqd5bLOLEQjZtJTFbZ9cy3MUOnDXUNTl28Zsi57nNZamY9BXAGUTfSciY1iDJmaTvm2tSfURwshk55HobC_CRdXHfoh0FxyNaI-Po0O9ykzvOCxZmdkn-_E2pg4lkEsIrXidONlnU5yAueo42eU0gy-cuu0JqoTgHf-x9IgrlSH50Iq2I2P5gKurAOE0OdL7garWGJ-wX0X_XjV9BDQRSWxx_WmJ8VGI-YM9yJE7ROJpR9O_K7Zh9AO6saEVVq5k3wYeb12a3dYdTcg--bd8L9LbBVeXJWIgPJatgCVJdDF8fRuiadduO369-HxKxx7T2u964sKLGz9v2bvxhg5ZSrqCWoIYJVQTGDWNN7EjUH-hV=w713-h632-no";
                        video_path = "https://media.giphy.com/media/cO98Fsi81nrptiLMg1/giphy.gif";
                        description = "-Banco a 45º\n-Mano cerca/arriba del pecho\n-Mano sube vertical (o ligera diagonal interior-atrás)\n-Codo cómodo sin adelantarlo mucho\n-Notar la parte superior del pectoral";
                        muscle_zone = "chest";
                        break;
                    case 40:
                        name = "Maquina de Pecho con Codos";
                        photo_path = "https://lh3.googleusercontent.com/P5zpIRLvrhSQKAbP1aCHLsKaQjtR_oGR3D7N5Z462lJeRuP2M_1wNH3_vD3q7qg2rCfoANRZ8J3301K5fW19Z-pgovi7tfDdiz7fMP3JXCMdnxkOfyoOtoIyOvHrt-Cr5KA9drKukhk7WAEETFpQEqRzXEaCxKsNDX9hJlJu1zO9I0v-KziIx9Mi5GVoHPUCuwTYRn5fBG4zfN-G2hleEmRT6jCkbktjFj-xVi2k9MAKHVUAQd7c2s7t-DKwbOtSXL0qoEDR3AzW7PQoC6wRT-0cyymYVMVw9TlDqCFEdfIhsUsjhw5I094gReE7yBj82BjmJMlEbbzr5vJm_KTzKl30Buvz7rnmFSy3u2jBf8vh4c6EVBc1EdjqQ81Z2E2i9c-G1UyG0dluoSHMseR4adbGP72vLTnkqT95FwdFntUkMsYiOkuF5z5DFurCvBc_6w6ewDZhZrgHlL2MhZHUwHBAAVFpR56T0K3MwMcclnN4P5caASPkmzpzyBz4z62BxAmT7JrOE4J6y1a6IkDXRuuGuOVeaX9fjzQ3yKGrqeV9Nbjljzw8yk4fTyfNaF2aXnBCcYUKiS_KmG1OEJV61Rg8S0CG8IVuEdWihyXduHZfvCmDy_4JKYQtZYAu6_eW8BY2iK29-3HdSpKASw2ODqWXGafvwN8GlbpaeZ8z5t5ysp2vnd4CMRKN=w713-h632-no";
                        video_path = "https://media.giphy.com/media/lckzTgWUmCygx5AiDH/giphy.gif\n";
                        description = "-Repeticiones con un brazo luego el otro\n-Rango de movimiento completo\n-Espalda recta pies fijos\n-Controlar el movimiento";
                        muscle_zone = "chest";
                        break;
                    case 41:
                        name = "Cruces Polea Media Altura";
                        photo_path = "https://lh3.googleusercontent.com/XiOmV7qTmpy8P_yAmuPwIi_e37d_LWd-iRYnMRUjMQutyl3tLv01V17CIoJV1GKReuW0UsamSIQjvZiFeLApAN_J5Zgc-UKkVjj6gLuslUsYHQianMA8fLWnMAim2k9_bWm877HyUjI8kU_yuI4DFgmRDUsw2SDe6HoEOaZfoXrrfmlWjQqxMaNrOPirESH60Iv3X1qFlg0sMxNrPDIutIgYBiOSZLPuxELR58ptZ5Bqd6bdpPXFuTIqRs0QE8T-tyAvGSM5wCn9t8PwuhkSC9DHneQuGVtYMiemH_wZFQttvB8AaPZUANr_WUGE4vU3aQQPYqb2ri-a9OnOJtP41VgEd1xfjoEf50-ZcVvVM7DPnVkndQFZnivjoZWAj3rWKuqEJynLN4r3SrXx2eDhJ3UMvIO3Sb1BnCi3-K5CXAXlSO8WuvVsZ4Bjga_qPmLAXHoE1Apk_ajx8bwdQv5FaySj5_yayvR2hYomRtfcp_7g9p0sSVsnhMEWPXHYyJQhwdjiP7sBMvOPxW1tL3NOWk8_-oUo61AVaUcu3RPCHAGNYODOariDsL_BsXS1s7vyZ8j8BipB4FDZBYy1RDBrSGoKoxLFPYJQQ7yFe8bPoaDnYovfueXjJxj5VqQnB4wKBq0evQa5zZ7zaDtKNdZ408ojtXNL73WW76uEAx9tA5des7wPS8UZ5VQc=w713-h632-no";
                        video_path = "https://media.giphy.com/media/3XsYNpeIm2z9qcpmvn/giphy.gif";
                        description = "-Espalda recta un pie adelantado\n-Piernas semiflexionadas\n-Codo no se dobla, brazos fijos\n-Llegar a cruzar brazos al final";
                        muscle_zone = "chest";
                        break;
                    case 42:
                        name = "Maquina de Pecho con Manos";
                        photo_path = "https://lh3.googleusercontent.com/KrlzoYtbwtAAT39YF9gbm9YUZJnfv8ZOkjeELcKjrP99U0D9dIavLOYylx18ZpsVyWNI9Ir_97rqFHy7QZlOlM_kDzr14G8EXwhG8CdD6ySF99HKykSmVbV8QAn_RSAV1QnVPFe4xM08sNOJfK7Ro8k6q3rbAcb_x7v-c-yzK06G0Ev1wxNVihmYfH8VmDmCdSvbyPeVwvfbBPonPaGRLX7Q09_IjSIKmOFsEkWmvzKPhUNTDl3RmiUEQN_sQ6qqylzDN6pE8PQGfO9sF8vv_N1k-9ExKXgGr5MAIEXD6B_X2BS_ZJW1fejdEzRWoDp1-DUgO3nBwFP8ZC2YqBQQvJcKttcSriAWmpVdt191sDNmB5zafdFbYGm6pDPCYpKdLYHNo0Se6ouCtXhtAxLfMuHGaqU1TDWK6l7VWVRuRq1Ze-P1yrlR7_n8mjG5hPKpY2Ed2jjYXrTnqPkYwYpNtwsqbYhr_Wdm0B2gZThmvQJPv0c8aSKjr6RAMOodvfvnfVEL2cvTFpJnD2A3WG8GXJ-HPNGcQLz1z4I-VOmdLmFFGaxAeq_ChE5q1MJMAL4VcjWtpb7HMEvgQJSMv-bVhL4jSnnH4h78-nIVNifdY5JT06DNU7JX8msj_IS4mf0Ct74RBSmvPCqtbzmTFiIkzpP7uOslfx5hAZolLz5N2yXrt_clOmPemy0E=w713-h632-no";
                        video_path = "https://media.giphy.com/media/QOcdHH38L6p4XFeqCG/giphy.gif";
                        description = "-Ambos brazos a la vez\n-Rango de movimiento completo\n-Espalda recta pies fijos\n-Controlar el movimiento";
                        muscle_zone = "chest";
                        break;
                    case 43:
                        name = "Press Guillotina";
                        photo_path = "https://lh3.googleusercontent.com/H69ZWlr72fuRQ368wK5T7Fa4-aD2TzaiWeJkKU9HjwS_8aalNfk4oaJh7InzvbHkV_j0afjFrd1twmGgr3GAwaZmWsAP3yEEZhtji37teQl-1uw_66r00u-l2kaHhze25FeNwVWuniOBrBPG4sH2_gZSBoO1Yr52Jryx1GmTtA10QKqdlhflT2yGlZD6RUyhtX6ONWMP2b_1W7ex-NN47QkXv_Ec6NG71MPyqEbbS4TXV3Cgr_PGUZX0YY6FwZ0ag7X-upl-C_G56S1muDlhiI1FvVWYLXUqo1NVVQiBaQf569JZk_FeDkYdryLjoNEMAcU0DOzgqnmdBirAJHuzcE8Sy2la5IQFqIpQ1W8idtf9ykpVXRV_bDsxXwnh1fws8q208af4_tGwloSn1muSVyqNd98DhqFnT1ZbKr0bOGP98zSt0fIMNnfrlSHmOW4YZwSX-ZPFEl1i48dhOBfmfZoYh___zO7OLr3uqPjV2yWKyohnwr3PwGWPHzA0vJTNIXw--Ja016xwGhCdvTBIa-dKp58dmKH6lol8pTUAtNFqB78IUEwytv80Fdd9j-xyX-LKajJ1cUcP4CpM3Z99PEBSCy6tDdtMEKaLMJ2SnN8Iyo7exmVz3H6phD2iU5_jNTVZo6124adPXXoV9aaqH75KLhoEQ9EeQMiGFz6Omy4MQP_AwP4zEGNr=w713-h632-no";
                        video_path = "https://media.giphy.com/media/1yn2K3ajrcTo14Rr10/giphy.gif";
                        description = "-Barra casi en el cuello\n-Tumbado posición cómoda\n-Comprobar posición antes sin peso\n-Rango de movimiento completo\n-Subida de barra perpendicular la suelo, no oscilar";
                        muscle_zone = "chest";
                        break;
                    case 44:
                        name = "Press con Goma Elastica";
                        photo_path = "https://lh3.googleusercontent.com/nS9-psx7Id3yE7e5yp7FnFSADOZME0EaoRsa6xHuk4h5K2zisoZ4Iu2tL_nenCAF0N0hWoX20qwTEd5BrpTwSZQW-uBciR-Rjml-peqJZp1UikSDOTP-gzCvP0gbyr2FrM2egpG_CIfaxoMFDAxnQXdqAT-JfBSRHVT6YWy3zwan5c2OxvAO_UoW0LqBwhvuLcA8SxC06ltGUuAdevjXn4vfdcpggC7-MkbK3lko21ibKZllYh70p3i_cyPUtzNxvA-7A6DnvnWUHabiy5MwOnk7szX-SE0nJVY82kfAD7kzwA0vSz_79WCcNiBaOJC4X-_0ulsvd_pPtwRln-oxNKxf4sP_zBefOMLFEV0bm6krduCn304a9_0aTzW2DSX9tGbTqAy1toUhirMk_MbXw_kL4hykZ1B5u93Czpg24F2fdxckoq9ntSZ5dEMUNSSvCDIl9ugLEkCnKejmuhFHMtLyD7AOBxNowdSy1i2Z1DxP5CqvodyASwQj2m39RNz3Zf53CbltY16UUiAYqeCgyFAXKaiERkBXJIjEu02niDzMexHqLVvaAaMNqi1KKW8ZTE2AoeViUE1d3K57MXixHn5mXntCQaHkFC_KzTJWMiKu1-CpxGLNAj4b1ZhsVHx--p56a-v4ex7pTvvNPT4lRRP9S-GMjN5ZjY8XDy1T1ub_0xxZOScUmWJm=w713-h632-no";
                        video_path = "https://media.giphy.com/media/2Us45e5cTKSDNoZ4tf/giphy.gif";
                        description = "-Espalda recta un pie adelantado\n-La goma tiene que hacer tensión\n-Manos a la altura del pecho, codos posición cómoda\n-Movimiento de manos paralelo al suelo";
                        muscle_zone = "chest";
                        break;
                    case 45:
                        name = "Burpee";
                        photo_path = "https://lh3.googleusercontent.com/d8Fl6XMtyASFy0cWW8_JVGthiSJPbn-jQcxKphyDxTZVmjyfEw_vJAoGNU3UFKKksTm_i2A0bjtytYPc5o-p90WuZpNUWl0aGKjRmNZe9vuUAuF1Hb1dpxcFG30IeuJ6qEm4T7N9kfVBUJEK2Mo8bq5zPGJYAVI1E4bKybGpjezaNbRbx7xusCbs08c_0gIEXtB4peDVETki9tOVAI_KUGuuX91EmBSGDQzZ4hBPdiaU_pYgZVWisDYY5VzxtaedKcc0mFu4Wf2B2sEx24qDmJiVuEOkz1Hlrp6tDn2_tq-OQGuHj1D40Xqo5pbuj0GFsZh1FWmdd_I0SbGd6x5wzWH7Hia6BcLgVhQkUHlCiawjO1mr90XU6UAK8cqOO7KVkqGPMXmm8kWk9kfE0VhxmQvR8CYu69iymj_MbJT-Cf_mjWWKzgQYkj4KabDOfDdN17EX8FyCgdLvzTzS7cnWvCkl16DyNfPK9oiDB23ljdYAjYVxHzvaCz2RX9gY5v6hJ3NE5ANfAaVdItQMZx3PbclR-ev2Pab7cN9JZ8fkvjS8oYE_eUBBqsO48BS_PbikkNB2a5lr3GeYVCmlChDGA2DTv2aV9iCglEfnFk8nQDLPhQ43BC4Up6FmydM7KsGDqFaV95q9UiHeU-WXgZY906WNkHTvuTu69RyGHlmxJf25sn9oWLq07rLZ=w779-h632-no";
                        video_path = "https://media.giphy.com/media/kh6O1OU8Uuy9EwbTRO/giphy.gif";
                        description = "-Flexión de brazos\n-Salto horizontal adelante (junta pies y brazos)\n-Salto vertical alto\n-Salto horizontal atrás (vuelta pose flexiones)\n-Repetir";
                        muscle_zone = "chest";
                        break;
                    case 46:
                        name = "Elevacion Frontal de Mancuerna";
                        photo_path = "https://lh3.googleusercontent.com/ChuJha1AaU4qw5n3GICZnBXCk476NopfphD45EDOA2K0Q2zFLC7fYVj83cDlHpMqUpZZq2oGwdRMoZ57CKIEwnui5WJ7Shw2EOqLKT1ZjAdNaCpRbi3PWeUoebnM5FS61BvqFNg-sdDaQ58GYkerNm1LI1-coBkv2hZyFFuF6pm1WmkVnBAjFTfcgsTO0qEbW9avhpzczJpPOOL_4EKrlxTFDORwGsnYt0YzC1sW4aORNZo-RU6QBGBMSRI7yjWrxgKRRdvURuqs4iD1KmN__t0fmu1LOuxit3a_YUbhZkXEFgSbY8GYCS0rCGL_v6My7xyxGOIHXvc0z7wQFjycSZKao1Kh_dBAaaEdES0CTv5QMpdOnhgOe9o9IQXW0v67pA4WNF2_IHi1PaaxhsuzKW4eta8mKIcFPtWDBmpXbqI_ymtVSMVD2rnT8B6APE0lCR61h7iWKz_V2YmD3lwlLelOzpjBqVcR1HTNGmbFbpMgo8vegWBTAV6-znPrmfLYnObT3cqaaqSiuLtSDfFFDu-66uDN50b4caliQ6M__69fE06wOYoyHo7t1YRD76fZPV50IIksOBv0HEEPIhqOZUbfyTldDDSMewIygNSWJGBHUklrlqvloaOlEfbMQ8zI_OqSKzDCm-o1OeyD-hVP2LC-CAOKJzSHjz96oqmqo2EdbE3IwoXICK7a=w713-h632-no";
                        video_path = "https://media.giphy.com/media/vRMlxt9czytSmsEnn7/giphy.gif";
                        description = "-Espalda recta, piernas semiflexionadas\n-Brazos rectos fijos\n-Subir mancuerna (hasta posición cómoda)\n-No balancearse";
                        muscle_zone = "deltoid";
                        break;
                    case 47:
                        name = "Press Militar con Mancuernas";
                        photo_path = "https://lh3.googleusercontent.com/NPUEBPtpEfXtHismyFLJhDgBlMOiPagJ7kkHoMz0s6JD1b9ne7VvIvHXNnHueOW6h8hxlmDKnQisL7bvLUBmvUDuozZOdjpkTGrHjUKySumS3aUIa5vkuSC81odd7Dr3EFFAtdnM60nzZX3DEYh_CFwZyrFxSHyygqdNaE8n77xRssy1t4cOysMnEfAYm6AY4vFjwVwE6wQjpKLuTmduIahx5yDGNTltBJz-7qxRRHVl6eQ3ISrfIEkGDTMy-OOVIOcaSVetv_BL0nSCTXVtDLIU3F_CdPMP8BHx14xs3KQJ0rycdjxZpzsmoNSXit3BK13RFgUKiX-symObxer6UDFn58mzifrYaRDkLLhjjzqWKomEwnNBGF-didLVpYttSTK-L3nSAb557xE9_fjtryH-vKT8Rf_tmXK3SZq8nLmOIrarQMKogTVo1rSQwx0hXkqfNxCWbKH92HkhOj_b_wjTQzSfuItBHyjrOybCgAZiooTPLS0alH72_iJ-XETdIR63NZVKufMXWTXTYuFt_E_pzgR4ETUnX_l5ASLBgOexV84YUgQkyNiq6TAd-ZmjMK9ruf_lZahwUwynZavEV3vqC7Mjch_Gyo8J8N8mRB8J_HPXk71mXRB_wESqvNRlNQcSK7x3RRstNwyH8zu2KJ4jRozkNmcQSD-K8nHFLDkBhORPVVWBs59Z=w561-h632-no";
                        video_path = "https://media.giphy.com/media/1xNXuiKc1CNHzRJ8X8/giphy.gif";
                        description = "-Espalda recta, piernas semiflexionadas\n-Ángulos en codo y hombro de 90º\n-Posición cómoda sin forzar\n-Subida en diagonal a estirar brazos\n-No balanceo";
                        muscle_zone = "deltoid";
                        break;
                    case 48:
                        name = "Elevacion del Lado al Frente";
                        photo_path = "https://lh3.googleusercontent.com/7rwRjs-fzpNEKtkVf6FhXaWJfDLaRrzwMv2KhewmbzzV1P89-pFIC9Kt2B0_bCCFF0YYbpuw9UiYElQ2_FSVW5TkpVWdD4oPJRO_5RD8nRwVeedsv6ND1FLNXzsBy3ds1jHQBJHlRAJwWutK3f5ebkvE4ZKj0L1QPEQ42Xw9K21fkh1q9YH90ZK68AUlVWULz-47TTm-bxwLFLiapT7DUE7fqNdCxRwAEcf8vd-Tq5vxweOwlnXRJtaiULnLE5Yf0Vu7OG6rqB9IO92KOWpqi8zCNU5qgvzI7hGTm3eVdyBNbgweceYOU8kf-PTHnQO4uZE_P5gFkCqs_VJAt2f0xxG2wUf9kb-zp6eQPv87lsTQarUOEMYYtOiD61v4G6ZQ6yiZGPMuvFJn8gjYg2eulBfKGYjW9gJ2HUVWvVxhsprVheZYSSH1N2b1bDJimERLhxUTR3q8UQu7fdPUfo3dVTiWxpHlvClU7V4C_dLETp5N-2AvvNIDtGcKzRz-EDMJKZBW_-yAABJfIjwemvEefKDhZRKDUinoN05kgeYXgl47BeDqLmBsi91BJgk8hFFma9f-zqy-DanRUbDRCCyjVmidNPQCnzL0GR7xgejSUZsnKVafkOGkhBQrM3YVXFcUyh_alvg0IDJE8AM4pJGN5_iummOrWzwqY9lV--tAowdlRJloPS_Vpbv7=w713-h632-no";
                        video_path = "https://media.giphy.com/media/8rEV7amrTu3Qa0g0il/giphy.gif";
                        description = "-Espalda recta, piernas semiflexionadas\n-Brazos rectos fijos\n-Mancuernas al lado (inicio)\n-Mancuernas delante (final)\n-No balanceo";
                        muscle_zone = "deltoid";
                        break;
                    case 49:
                        name = "Kettlebell Push Press";
                        photo_path = "https://lh3.googleusercontent.com/GuLrkB8YXC1MEY7xWDEymgx7OuU2iBfNYbThHTLbjjK6yjqzP2bUuQghtNAFDjXpIhvPteXcwvJnvjMoBUix9rY4HMGndy29SoyOAsfj8Fa-FWUEzr12HFm0Z6_UhKlzLSSSG6ydTVCS3fU4adTpQruv17DCC0fnIojRKCZfcqeiH1G1XFnQ82X3y74sGh3MlHUTtnijwXKOrI83IhsgssWyVK3mHnJnHXliCxoeOXwM66fvyJWnrHkFzImjn9pEJpS_wosf3m-WNBMR3Vm233uUL1WnLKGuHJSRfL_EI8Qvo1J8hdE5Jf_WbIRKgp24VAVDSB4GPInc-DFw17xJ2jfDC2kYIv6RPwwzlgySqZv_kSSecDGzU56kNNbE9q9xKZTQ2PHAzzZZbQI6K8mjDkKgEjFL9HPmm_E0WpElp304IvUhgkyqmRDg6UZlC8RWMjEpS1rjDqN_39q8WHBtd1wYraSYtH2mCFbqKDMRW0sDAnctbQEyQG52hVmIazpq7b5uzDvxG4_zHnI3RNiR9IWs9ytqv11cxRXAQVLgVkil61FlgoFL-ST3huD4tHKdeLEZLY7nV11K14EjElbpn7NdmAVIGboeBweGWu4GyWn9BHiO2L7AAK9CmQ_6EuvWGPVQflpAJlFEQQ2s_6Yj5mu--swHVU9KV6pWsJMeSsB3AeqILIvkCcG1=w698-h632-no";
                        video_path = "https://media.giphy.com/media/1AIfHfxKGqCNWBPJnM/giphy.gif";
                        description = "-Espalda recta, piernas semiflexionadas\n-No balanceo\n-Kettlebell recostado en hombro (cómodo)\n-Subida en vertical";
                        muscle_zone = "deltoid";
                        break;
                    case 50:
                        name = "Remo Colgando";
                        photo_path = "https://lh3.googleusercontent.com/HqwTjUvthT-ULT7HVNZSlb7ZPn9LpcPBgCrFphL_KM6Cl4Clocjwi7np7j3q22Ds33toA58BZ6wB46Cbb-mpu0x0sX9V5r-uomi33PQe3d64lwhE4L8dIxmwrgO73Kppp752TtLLp1LIznaiCZgpz43gAeQbrJodzkskyzTcDzRjJ3CApCJPNcuS1CjA1d7bLlfoLCkf4N-ifuCHXCu_8RvuoGrtSquJwhWGOohJBIUUdTWNeeGyOhb1wt3xFVVhzy_6nzw9t2HgOQXtbYz-XGgcqKnJxRkFmcbOWcWxPr18hA8DRk9roxBG4oH7nsafV9DrwHbgnoyGClPx4zp-RCUYJTMIWatTm7Bdla_AhFhrOGBEqHmhhqPiVEjcQo5bSnVYi-5sjmqCxcF--0toyCfUkoBa0pbZ3gFyjtRXElGgHejWud_BKk3wNjiopAUDHoOoxNMBlJJ8XX1WgVlDKBbtSALgA_3KcjOApqZ4h0bi0FNuMgxhYnyqFLT-JXwlFcIUZKjPHqJLc-KIOaM6eY3D7w0B3JuHY5ZitulTwl58Zm4elq9GvRrC4XwyBt-pFAQi6iFOoa4g0_jZHNI4qF-XRf2DOGUsGUx-NMpFgey_wW5ULv1IBWuY9bZCk9bq22iQqaHDPVlIJztM7eeEkRbNXY5Pau047QSrIMLbYVPvDNYaT8ZNtqwJ=w713-h632-no";
                        video_path = "https://media.giphy.com/media/1sxVMlLwLi2O58000A/giphy.gif";
                        description = "-Flexiones al revés\n-Codos y hombro 90º aproximadamente (cómodo)\n-Espalda recta abdominal bloqueado\n-Piernas bloqueadas\n-Subida hasta casi tocar barra con pecho";
                        muscle_zone = "deltoid";
                        break;
                    case 51:
                        name = "Elevación Lateral en Polea";
                        photo_path = "https://lh3.googleusercontent.com/X_hAFBoGAHEUTAhtovzRBpzkxCgOyLeShLG5-Kv_lKlz7Qy2PnCiW6USZ3ol_aRdouUHdYqf8c-HFL7jgsp5qvoqfb84rhOYKQC-Ui_sy20miUZ8oPE8gg8aZWfaYjwkiYHbGKBoNUJuy_RSBTEcojQpda19t9tr2Qotu_ZKIjf_vAoqrExbx8YpUhXqnYZkfSVogAcWxXcI_u5YiVsXslaFkjrkdHkwIQ_nn6TtgqUISochid7qS6hDsywBwi5mnOA-t56fET2dc0o1b67utEDDQiFhkUwc4b41EYD5KwPs7p1dsXqckZGGo0A4AEV3300aXgGquRtdIf1OMey7xXknRORuslex3YTZeL1Vkz4zeb2FFGvRT2OwHpVluzbLSWjR3EhSQDpNVWEcWlyLPEdudo2vd_wKYvGm31nuxBlNEBJUk1B6y9JHKqJOzUW2e1H0Gdqu2EOmfYwndM6RpRhTrWKtywkktBl0M6iLWIUlAZiZcckNIJqhXsw24dFLJB7htRzQxYsAuuNz187FTa-2ruPIn_7ussgLTp6DSjfiaZjzP6nZENnP1iwKDbaZ5FUx8_q9m4TRfZsLeH3AMVOu_o0jFM_Yb-JQor7i-X4oz0q_HNRMa9ZzWvbPS7I4_xh3vdylRQrdiw69h55WaqIJw2m3zWSNt05FXJm7o4s-yOEMzL4XQ6xY=w713-h632-no";
                        video_path = "https://media.giphy.com/media/1itJhTMvLvL6OQQvxS/giphy.gif";
                        description = "Espalda recta, piernas semiflexionadas\n-Estirar brazo\n-Posición final cómoda\n-Tensión de todo el brazo";
                        muscle_zone = "deltoid";
                        break;
                    case 52:
                        name = "Maquina de Remo Codos Altos";
                        photo_path = "https://lh3.googleusercontent.com/RY4SwIbHZJgrOY6rQlRDJP4Yix7J9KAfumLegLbh3tq9LGKqkJthpaMx7Ek8QF8DOiqiX8o43jUUFklO1RFn3hOfDFvNhIXIJmMI0RTGneo4kSNpcdT22LQ_cRwRA2KHV1OFaT6l7Fy-FTwMdV9ItNREExUq2X56su7_ZD4zZjrHGOmPsRVC2pVy46-T6ByyfPWmWZr6Zklhhj8ApJn0E2ToGCMjQW8xKiArbtWMPcELUC2lW_mQWY7iyIUj7T6HsqJpnaYUg-fm7mcUR7onZkYi_NqdbBFXdEy586iOJSr3PEzK-WLqTee1EzxHYKTCbH3rJkOVyD0OocLt5c6wd_lrhMMZH9J1B44DLcTtXjt_eXO3BdF5iZOiIASaq0M0dnO6e2GWVC13Ia5EODdQtDjaB9eTzRXSLGuqvsBtW8-BDfvUHyfIOuAFLGfNFbCnXheNvuyPeVPwZUBETng98UeA2nXjUHzEH3qulK5oGPEUcyX8Ke10J5NcaP5NM7xVwVF2WSsdtTTFiyOSS06DIXobuee83Lc2DGgqCOzq5mocY_v_K8dDYA36ut-0pYlFJObF9_7POnfCsKzBAyCkpkObk6YLOEKsz2L_-jV-zcbtIkNCdf7RMniS-K86pca3e48ZCb3AmGYl76D1DuO1__ogSVHhpx1uMDz9Q0MRJXqz_BHt3KqxSlW6=w713-h632-no";
                        video_path = "https://media.giphy.com/media/dtdDalKlMY01KECU8Z/giphy.gif";
                        description = "-Sentado pies fijos, espalda recta\n-Silla lo más baja posible\n-Tronco no se mueve, se mueven los brazos\n-Mantener codos altos (sin forzar)";
                        muscle_zone = "deltoid";
                        break;
                    case 53:
                        name = "Maquina de hombros";
                        photo_path = "https://lh3.googleusercontent.com/6c9Ri3UMF15t0ZekyxT7tOwQWAzklHGAtPUVafauxJgTvQOOskliiZkf8XVt6Ekn0_KLaqC3_dIILYneLaxltRJN_LcULHtBCFtiSnHi8gnPCKy6uXsoXhfjX5VGVu190W7keyUzdWLOD9zIX0W2DqaPMgnHWiH_XP8L37kBJRmQ6-6sK25jTmxLPdNIx4327NNb96NKuZrgKqyyLBKn7yB2e3JW-Tu5cSpapRNYDd9pVhh0SuALzg0nSyYfadyVlrE0pCm5aCvw5ZBuhW49KwqHHoVXaWWfGHEmxcLoM8X8g00DicRzS0JJ2gkc7K1qWbebahKwXt65GG_qK9Lq-ZNpIx5o-n5pvilvjtf3XqhHAFRGRqpFGLFqkdr0MjJcIJOOHG6t-05fcHMreAt0UqzxdDenvlvaPcFb36Hu937zZxwEq81bPruFEl5EMamIVxiJmnulvNSTcRHkDTolpX9mfuukT4k8YLskvB5fC0GgAqYhSUO8GACtUkXvfaBpQkPE16l60DlQwTnzPm9a-XYvXOyE8O06NI3qGCp9GEWVVT8CyWLJLLMf3-UXiYmhuDrGHVF4Kl0txTY6GxW3fyBOHfOJnjRzLdN9ouCClYl348-36gXrR-vYArbNB1YJ_LC9LWkPjj8cgxIs7EcZ_yxivu8uV3Fe3wcm_aGh5A_l3eZ_N2Awwy1i=w713-h632-no";
                        video_path = "https://media.giphy.com/media/uADjhaAG1c0rzmuK9R/giphy.gif";
                        description = "Sentado pies fijos, espalda recta\n-Movimiento completo\n-Ajustar sillín (posición cómoda)";
                        muscle_zone = "deltoid";
                        break;
                    case 54:
                        name = "Linear Jammer con una Mano";
                        photo_path = "https://lh3.googleusercontent.com/M3kR8BatdEXkDnmL7n61-PDwjeWPHzr2fenrF0eqKT6HXrM6b7zyx-a77JVh6IR964iP6nmD_MHWxln6QcL3ShVJFB3PZYaskH6kZmPbTmdiU2lxuf02pFX20_ZYhA5wFKPuE9_r1a5w40sHn0LhSqDTyoW0Xnm682tjGY2eltGJ38aWsrjCfynTCpsyjeKAKsLhoaZdpnCDtBDylrf0aNClIGS_rNXiCRatCQJ0xiWWRSyicTvdFhbCcHbHKAq1jyXHQ9buDso3O1EsMM1LQ18ORLknhUWvGVXqILR_JEVKUqm5rflil7zbUyz-EiAtoxZQtqAzNpM8CkkHI8kdXNK97isTSrH06Ahv_IRn6le94EPe5s2vnC_uNpxHbWiSQfCmdQP_cA92BoE-_vSBJ0_n3LbM8sxbSTNU8J8MgANdMHJvZmXCrK5q-7xceMAztAg80xrtmudQ4YEuBIIfOR0NGFqDUk2IFWyEwaeQG8pNji-AhvXkqxsevjjzVQtB6pufWYw_ZubxwlLyNJ2aYZHVn0Bo7QnDZZvr5v4bBriN1u6x4i2lEikl19fKa-EchXitlQxluYKidP4-MyKCbhwg2ELtKXskN9jqrXrQGAwbZoLKN0sa4oCOUcOSo_phJHtbhEEUWWocNoz1BBNyd2SH30iMJaOtwUMDJY5cOpDnjiaAeLPoAS4B=w713-h632-no";
                        video_path = "https://media.giphy.com/media/4QF0Pjf1tWAhcZXwhf/giphy.gif";
                        description = "-Barra recostada en un disco (con soporte)\n-Espalda recta, piernas semiflexionadas\n-No balancearse\n-Movimiento de brazo solo";
                        muscle_zone = "deltoid";
                        break;
                    case 55:
                        name = "Goma Elastica a la Cara";
                        photo_path = "https://lh3.googleusercontent.com/QBOAt6NSWuTxnMyw9WZ5bPpAUMOzXxbYNTIM2LACcQTz0dWGFlaUUWg64Rq5gfs2AVFrhbIWcRNrcmuM9-R_8zB3kIN2XsU5rMvbxZlcg2CKQ_qWuhYsaVN42XRVMg3ugtam7JLyK31CD7C6fCsX_KRSXmzg_2rygwnblicRHkOoYYhALCkWwruKEv92Nq5ArxHwht5Nqp8-2gD9PMsstramqL_72jorT2AU6lrwh7tmmrLPftiLKTLBhDBfEeMd0nAoAOVRtPMdlfE1wwpLQMxGYSbK50NE7om4LZph2lQO9wGeO4rUX9KUk7XyBki6ig8QDVVckUwu2Su_7TR9FGZQMKE5CMs1SkoEnqOE7Hq-ZTYMxTbpg6BDJPcy1cMmZovsDeXPrSzACcGokCTJ7l9qUcm0TCtAzFge3JPmT-l6z5rB6LD9y1bZ3kjfUcmhCq56emmAOqjORbCT-gF0Ja1tyZVqthoKI4WVQyPFPC9hVj0O8mf3h1svabjMtzkAjosa8Lcf9qXLAiD5i--CYpv9ZkBBQlvpfLX9yaBWC-V_DJVkn0DwC_S-WeloAIgrpKfUYxgVd6v-UUQ41Zzwja5Gv2VQB8ycnC1c1ATSwZ5pXSUZV7CIxB9GC5VXVibB7-5w2Iud6mJqOFF11auVbOSIcnTLZVtO9btZTE470wWzJfUWvKO4JJHf=w713-h632-no";
                        video_path = "https://media.giphy.com/media/39zXHWOTg2JnW9RmOJ/giphy.gif";
                        description = "-Un pie adelantado, piernas semiflexionadas\n-Espalda recta\n-Se mueven brazos solo\n-No balancearse\n-Tiro hacia atrás ambos: codos y manos";
                        muscle_zone = "deltoid";
                        break;
                    case 56:
                        name = "Remo con Mancuernas Codos Altos";
                        photo_path = "https://lh3.googleusercontent.com/3Lnaws2ryuOUR-iJMnXX79FaPamJ6Rpy3aQdHt2r5JzyfT4OWS89txVDpfNuLkV7rhDrHOXqPEsMUvGIaAsMvih1Msz6JXM7iD__TCre0mz23wNmaNRU7s43eUf8p71slTFGmNpzgo3iKYET1407PljrnFWrly6aNkHMwILVpOgm-v46sgm5C1tCGsbYaHUU-mV3ASRxD-yD7dJTRbzqWDsaqb2Q13mSeg79z62QgptcvA66yzN7BnGP29-N0H0NHQwYQZj4V2TlVenESdPClcqE6PWZ1-u3-hinL6neTfomnGpYt8km4AmvJJPdIaTH7ut2n6sFPltGts9r_QBpAfiaugPNw4hFnBci8UbVGop19phZxcttY9wmlGB3FraUTNneYZX95vTK-8qSGwYJwoyqcJSVCknIHv0aZHsKd66Yl9QzpIxq3uaNyqJzNCpu2SnTqXNUldSh-aMNapFC3ns0RsbDuRtKYds2VnARwTvpPTuErS81HZT_W55fFZA8oDrcBSMPvnm4ilFvSAvsOwJXwFWZwVS-cs88DVFUOluMVzh8uZTBZTy_iUwAtA9PqtVJ9xmVHBRpc0tyfx5Dl3AAHzshXvcczWgSbw9ErxlbCR9A7pXWl5MnW7FJ6p_mrwLFMozDJ7t2WJn_eo0r8zl28ZiLMFAyVMKrZd6gmwjCCL25r3HzwcsX=w713-h632-no";
                        video_path = "https://media.giphy.com/media/ccVHpa23Z9moGNfeaD/giphy.gif";
                        description = "-Espalda recta, saco culo\n-Se mueve solo brazo\n-Subo codo vertical (90º codo-tronco)\n-Brazo estirado relajado (inicio)";
                        muscle_zone = "deltoid";
                        break;
                    case 57:
                        name = "Máquina de Gemelos";
                        photo_path = "https://lh3.googleusercontent.com/bBzhkNcZZZRGovI3-3EYOGKb2dmERmA5hDOyPzqcFxEFdgFSmmG5SaeJXIPsqP9z8sudAG1CyvRr0k7lOoN6ZxgNOEVm4Rd3huLws0eumKmRSP-HfNEyczIatyZMF49OrF9r22iIY9crDNeRhIbKpxxU0LBw5p6O73zDdl6H6lndDSxG4OdfMT_CZDPj_BMgbs4oOJA2SjhkocrFnIT4Wr3ipdAZCmwhaAMpgH8opx06YjFCEukBYlEBkG1D_Y7seER5s65iqlZpLkZBhFcO-zZVog13BJyTJ-zjzzqZvXv8pydz7So7IMszYjCLOoRlZY9w18-hNECg2VO0iFiKP97Mym9yolu-s9Gqxj4bWTRWhHgIfbeRFDk520mFDNPFQ5UWM3P3wPSgg4GUt40NvLQ8tt6HR32FBjzSaw8_fplWwTPwPT7m7s1PxKs8c8CeKQs2z14HB0wA71yOwY_9dl2AtiYqxpRZTGvkRQbyniAMh-lC5hZLbx1QPggvsxeTKD6L6bk5q5ydgGJ6EB0mgc7o4purFoE7q8UU66GFHYlLzRF859vvevBBGGK5UVFveGVPEhY8-9g-XrnWfJBYzWOLZeWa6WoszLxEhmg9P37c3Fd8DJ97V-ba1xIMM8L6ZWAK1xdGobR0P8DuJePKiOv8NSSTp--CC4641N9VgmMYk-f0NnUbin_S=w713-h632-no";
                        video_path = "https://media.giphy.com/media/3oqo0A0C4UPKknPQkc/giphy.gif";
                        description = "-Espalda recta\n-Probar sin peso primero\n-Amplitud de movimiento";
                        muscle_zone = "calf";
                        break;
                    case 58:
                        name = "Saltar Cuerda Pies Juntos";
                        photo_path = "https://lh3.googleusercontent.com/I7DPJwju-q-FjsFQxjBhnSrl0oc-TnEbhYbYFPOdEGl0W_-tcJU_Bc4PwRvhW9LMThd0-t1dVCxsvit08KO9S3bw1zQs0RJpo-Q5yRtoblPu7tNvQFssthqgd9pG2_xQgDRwB8wwkkmOV-NIDqxCJ1hRb5nqMHFd3fw1WKgxX7S3o4uFY_OCrWmmsaIvFcT9hxr9aK7d5LnSjeF-7h0XPFTBkldIFrcuOMLi4841DhIbnyZbu72KhSLJKRryIvAYdj0S6LCCpX0P_xQnSJ9NA6P0xNxfF9LLb3oj_OYTvpOvjmJQAkZVL0s7VMM2E-Lv2DoNL67dIeL1ei6uPBmOpwyQKjr0rUJTWEs1V3tb6cNMX8B0CQWBhKphxr3LggaA3AEF5G1xAForappuhlcNgmB4pygCaL5SC20sRSP2iHF2kRzShLz_2_4fBzd9VHkn9PnS0dV7r96AY-tYm6_YWmgbtxq72ADzPNdz8SC2sNg8xuz4W4JDLrhip8i--izmq7byCmMlRYtb0CCN9t4Ab_wOgx-Wk7yqsafanUKCCJcL4RHIKvBSHoVJZsF7y4RrZeZIs0FZbVBZdiXG18uV9U1FxmlVkjdzp0GUYXo0c3sRyrjOcUyn9uRr7-gMC7o73_jieNb5d_qllzpXkjSP9GQwYN5mZN-t0yM96N0xd5OCmuFx_puzcw-U=w713-h632-no";
                        video_path = "https://media.giphy.com/media/g0sEGJ1mlHWVVkXZtf/giphy.gif";
                        description = "-Saltar con pies juntos\n-Flexionar lo mínimo rodillas\n-Movimiento controlado, equilibrio";
                        muscle_zone = "calf";
                        break;
                    case 59:
                        name = "Maquina de Gluteo Sentado";
                        photo_path = "https://lh3.googleusercontent.com/4UVw5OZX2-8q6GoIujPyxcGVbV9pU6pQemaGHh_L84VVNBZrAvsIhBoJrk4k3_7vHBf_SJOa1mi3IITL1qkHBQqMTI2FPhKQe_EwetZqOsjbhe5SlaIszV-pJjGX1AzfzSW9ZhuOIahbO3LQamUD6k4eTvslwpgCN0Gb-Y0yS829xqVzEi2VAN-OpFW-lwWTGbtAD7I3uVUrzuztM0kCrF7NjGiXRpc2eDvTmQ4LMEERXs-W7bzisdw5JOyh-cXfQDRX9SdH7nMtlDpZEH2neiSJcBxc5uJ_J00FLNoDM68vc_fH4kUTAqLnSJY4tIZ3Hs5QF-1fwsl1E35cq-J9MjOM4Z4Ln0Q7PTrscnIr9rKYiGyDMzikhaiBeLAoBnTib9XP0Ig9Q8g8WX2JNBpTsx4Cxxgg5Y5ZOFHLVlSHPGfHzX01AxbgEifPq35ZtVYlyITKa3iUVnLrnZLDOKl1gx_ZnIkbnYFYg2kNaejMrc1HpJdN9nWNh-kpn1JboU80gOGr5jKR2tatC_lFXN8Pt4ZnQvdLMu80U274oz6_4IqjF4B6GHK_gEMJivNUTiyU7IgGJwLR9J_UgyOIrwKLDPnWEyq8BN0OhQ7TLFWRJLQX7UPCiEwQlewh_vOcaNxbcsKyZKirMBgTSdzPDwgEs0GfncEtW2Ji-8RjELYTr16c3Cmsm4VYyhmb=w713-h632-no";
                        video_path = "https://media.giphy.com/media/5bb7DtIqeDZzgW5pC8/giphy.gif";
                        description = "-Sentado cómodo\n-Amplitud de movimiento\n-Versión 2 (V2): culo aire me aguanto con las manos\n-V2: muslo paralelo suelo, mayor tensión glúteo";
                        muscle_zone = "glute";
                        break;
                    case 60:
                        name = "Rotacion con Banda Elastica";
                        photo_path = "https://lh3.googleusercontent.com/aym_LIz0ITRwJkqHYklsmTIwRp6Pi_ALjQnmY9P8oG4nr4lYZP0NVBOt9UwoQ1y26bu0u6sSl3YhZyOcMc0JFN9eE_2DeRA1o96rheM9aOhohO1AutHBwnLu6HYkkQyJl92vi9_TyaXLDe5xzVicy_Qmgaggw2FVyXpHFy8SQqu8eFS_t3RYCddTjf1sdUnT4r0mABWd_hRm67mNPjIxG858baR80LnUKQdVNrYfXJgppseLvh5VVC6uO_YvDjGyg8WIFSUlZ4BgRCWugGpsO2rgz-z2t8uFMoWXJdG7DUz1PJW4QFua-C7FUro50jx9GYiiqPR7CtGHfCbYlIlQ8quLeZzdW7DypTNP3iNblLKIZuFYJUCB7ob7h8E9OkwitAG29I-fx_jLTELiSzQzWhUH0TtMvm1cFwfjNvmxUFdBV0sBTvvDjzhROa-60HOHOjQcIqH0aAVWUKY0A7u8YeSsxuaX9Bc08mm-odeJ0jH7k1Ktg8WkjxPcNItvBUCRVhtwUkQjpp_DS9boj6Q4eJMCTtBvWEmZnX5sm1llKbFWg26b9pmr_MzSP23S5Lp5jPkiANfG2CPYDzsWg0HQu-Nq4zBFrVd1kDyMTW-ZrNCs05O_1dRm1KQbv3doqPHvSjix7kZx2BfLEx49mpbZD6NkSdfWa3-hNl6EqzJ-i1d_bpSC3pXHc4Ag=w713-h632-no";
                        video_path = "https://media.giphy.com/media/1lCGZxbOoKwOOZDCkj/giphy.gif";
                        description = "-Banda elástica en rodillas\n-Piernas en V\n-Movimiento de la pierna externa solo\n-Resto del cuerpo inmóvil\n-Rotación, amplitud de movimiento (natural)";
                        muscle_zone = "glute";
                        break;
                    case 61:
                        name = "Sentadilla";
                        photo_path = "https://lh3.googleusercontent.com/zYwnokeZwpfzDTV1NHJuIjIHXmyZEdr6dePmcY_rGp8l9sqZn2zENOUlbie4NNcDInAZdDvnOgjUfahsWkXT1BA8ojwFmyMimGk2kfTGnsdUbJf9fioepD7bznzAz0u2R4mj5YpLUn4o6TwApY-N8KwmjyfNo1ERvko9QFcLeTRkITMJgpGWNd6hDzH62jza-17FdBF4yRYMhRio7Lj-sA6Mm8PxFiMVJQTnq8KfMif0mYmmlChrpwfF3wOEiajy5Q257mmiy-Xm6X4wwwD895n5iTz-SAP0LB3klIKD0oqwEt1qWwB7dzgxJojh_HxgLbR_oOtamT9l_X8tkAZSsbZSNFtsLRQq2CBxJaxUXtxUQ2fuzsFF1HQlKJG9I7vTwvvmlSDlBHKRoHHFpFHAbMOhbgXplKcAmGYIB76Sr92ESsc5Le5J0-S-RkGGzv2cpPCF7LTvaxsi7xDvfPoAKCjapsKmGIAc3-40HeNw2KNBAsrD3FGtnj1ks-EO96tctkb0MWok9Wwrrzl_UzL8vxNCCZjj7KINhFIHSFAOHr4qZ-ciPjnx4JZiW727u5ymWpSIJUxNL1096tU_4sCZbLfM-P1kHlXW0cLASu7hex7rzRjKarQ1iGkweCdSMJBCD44FQgWxtciymJVcQi64QOt2de2ysh1EfXR6R-pT-yEZEEDuPQWgLjs1=w713-h632-no";
                        video_path = "https://media.giphy.com/media/oHxwFONw1bloV3POXf/giphy.gif";
                        description = "-Rodillas no sobrepasan la punta de los pies\n-Sacar pecho, espalda recta, culo hacia fuera\n-No perder el equilibrio\n-Bajada un poco más de 90º de rodilla";
                        muscle_zone = "glute";
                        break;
                    case 62:
                        name = "Jumping Jacks";
                        photo_path = "https://lh3.googleusercontent.com/Tb8ni0y3az1rJhZ-2S9DofuibTy_s2S1yjetsGaZMMdo1EfLC9cbbE8_q2ytLl1an-BzbZ17kawng-_SCG8a-RxSxK_OHItkIhH83jnf2C6ZXS12qLYAD6PGkAj0IEm8Q6o-B9IgzLzYBat0WJTuDHBskF7tNUoQqquJXpDZkgFuDmulvtxlhA2WC7G9am-Brl_5bCnXxsapiFqZakYydUDCRmvf74ielEIka82Fto9566lFR1u6RlSRoGvl41GljImXBeoLfERdlFk8Zn9GRiyCMk3s3zH6LS6V-tJIGMgbmArfjgI87xzHdotdnFnSm0dSUcB76g2FBz7iKg3dokY80MmTVf-JPc7ADkJ1WIBEkjDZ0-eXlRKgKY0YuH9GD1zIMfLyJZfvB5HcN5NIvFKdjxMixqPAqekewai9jIVFWmPUCONnFXWhgs2ryTLLmUONuUWlhysj1Ts7_w4SFjRAx1jHxWiWnM2TCpTFEWGWdSBNXYxLLBgkRIF_JBdCdYL-TC429CiDlhzV7s8BbXIoMhS7hHuRrBGesGLusFcwGnoi82d_4kmqe9Rgz--CO521-Xn_U17U0yGNhl9Nl_bk31pn_tm9xx249lohSrycVEAr2uMoKIWmbCsGS8cIOjwVdox9A2DR0TWSnMZLz3k7jA1HX5AbmkloxsEV_SBz2Rl753gebmDp=w713-h632-no";
                        video_path = "https://media.giphy.com/media/2fMaRH6Et6wqzsjSEv/giphy.gif";
                        description = "-Dinámico, explosivo\n-Amplitud de movimiento, marcar posiciones\n-Simultáneo abrir piernas subir brazos\n-Sin desplazarse";
                        muscle_zone = "glute";
                        break;
                    case 63:
                        name = "Elevacion Lateral de Pierna";
                        photo_path = "https://lh3.googleusercontent.com/AZ6BXfXF6sUoSvGfEvLt0uf5VnVoJsma0TX4dQ0A0yMH3TbA5WSiDp4nVFPGYAdkWcvcY2ojECfDb1oz43XCd1JhhxS50iBHRS48ospDmnD7AK0wHLpCUMP6Sl19CRbrePY0AVtJbZaBpbBLS7J4lodyYe9jcHdBGT2on5u44SSoXhpdJI22w21rqN8tO5vsb3Ja65Q0jK0LKklX_RjYX9vO9Ya5Qe6J7IokFKm4dKHnUtkhub60Gen2uELIzHFNAb3OHcSkZtoBQmXmvRtfL8SDROgZwFM7SusXjwuqGNzaZlP67Zy8TgzPvO_svmJVT221PnvTwitb-tchGY2lgDA0WUrTFbz45buPp48PNPUBryCMRTS7bCWdudoDTBC7Or7gxxkFhYbOznwoE5DP8DJIbrxJYlp9ciVuPx4VIAB6LanvCQeQlzhh7JLuijGzY_FJDcEcjj0v_TRjeFVhoHpxkgUp5udxTZdCMZd1UAkAJ_j8ftoYfA42D8ceLPKHEEFl7MdcPPLRo93_-odOpaGay-3JbgkKnRiJFR2lgRHArBQ-yur8fpyuohCaq-iQYZdNagx0X8kA9b71uvpyyl-apjLaVmD4JNeHz0UwIHTb9Mn7Jp-lj8uiPICjTA0ix4isluOQv6nq5fF1atgI93X_iH_qFn9MxZGsZzFVaZIpuM64TuVBUiop=w713-h632-no";
                        video_path = "https://media.giphy.com/media/8c0LsbyUfBa26i3eYG/giphy.gif";
                        description = "-No perder el equilibrio\n-Amplitud de movimiento\n-Una pierna fija la otra estira\n-Movimiento controlado, evitar mucho balanceo";
                        muscle_zone = "glute";
                        break;
                    case 64:
                        name = "Cable Kickback";
                        photo_path = "https://lh3.googleusercontent.com/UsxiAuqfTdLYtIYO2B4KuF18YO3tBEx4yg8eq0s5dziGbN7KWs96vNb4LXgCBbbCKnYoLU_TD8ihe8qe-P-z5beWF30XWyHzwWp0hc2nZAjwN8dEG4Zo-9kYaF1vtaQUUqXNvoYJTVpMyMlyl_VVLGb3GVJ21vC8n9MZtZ0zujCPA3VP4sZsQM29Ms9TdRU2a_nUbcm8mZjeJlcGX7Dbt_vm6m8c-hWhTWYcaJhBeU9ONi6u0Z0zWPqCuzTyb8Hsd4ez3mtrjr77FDAvyMenQnuILBwTI7wJaQ6cgOQBnkrTOvHiUsLBQPZRVv1sf2gjr7KraaczvAiSCzGL4QabdHEpU3msM2TYpwOCINCVGQ1EEcdpBuPVboEk-zE1Zj_QAi_Ayu_Z7eCdfVXr2kQk45jZeV72eVOqvMmSqqkGVjTZL60CsH2wTyvQ2fwmxOXOEuHVa3k2iRGx2G6uIUqLrq2uh6ds5mYTMu7UyLQrsGmcdkN3HwJeHrlUBfC6z8irxVkMfTeG1D5Ewvc7xuhsHYkbh8tNcFFe1E4wyLyj_JkkHMzdf-fHffak7PO2r31gtHNnTqSEnJgjmtKS0uydpkC2GELVVYautIlojlpIt0kPrw9JGM1aWOzcmBbc-dz4x9mY8F7rD4gRng1lXoo_Nj8zFk7Wx3JNj4oPp6V205qYOpWh6KDWnlNx=w713-h632-no";
                        video_path = "https://media.giphy.com/media/AFn9eQxtLAn3TyYs2D/giphy.gif";
                        description = "-De cara a la polea\n-Pierna estirada hacia atrás\n-La otra pierna y el cuerpo firmes de punto de apoyo\n-Subir la pierna lo que se pueda (sin dolor)";
                        muscle_zone = "glute";
                        break;
                    case 65:
                        name = "Pull Through";
                        photo_path = "https://lh3.googleusercontent.com/2tD2VETiA2DItuNi0vhgZfImDlWBdCfjLYMh7rQo5ADw3KB1zfEepd_TDKvgll84OHRXe1oryK1NlgTe60FopCHNR--C2gnowJDRUOqIYOB6wonzslI43JXJ19ymUfkNNDRKxxKqxunkokbW9fZAMTW2tcgLVY3XWAckYbou5dyDXSn9ghczksrUKkIBzSBlu7EaUvQeb5L5SujVKrtNAdrAuvtfJQldv37recEgReV6eu_7waKZOXxuyViwP31JJTV1bZHermyNqV8zX2agWdMIbpvpBfIRYCMaWrnDXL7yKmkgdl_EIfhxAFal6UX3GRfrAjPcxjeugLAz4iBGh1VK9TqQf08Bggh-jJPEWo9Tm92b_Y75hZ2O7GYPHoPM5M785Ic_aTUn6kPwHIdEwUrUD3H7iEH2FZlsq58NR8BfnP5ZAkNALUa5CChxjCNRQT7WUeNUeiM0D3q-IjfMollStztkPa187cJAoGnebbGSv2g1hryuFD8noeM73EZqRHSRM-OdOOrGKPN2RoVGHuTKxLmLG8DamAGpPgT7_2ukWcbVe2CP_ANR-ofEjlDwhDTgqRDye40wKfWDcJgaIfVoFuE6o_a4sdwIv14Pp0lhhl1c-qWf7CR02ZwoTJWcJbJfyc7g1ZBS3zbp0vCfkgE90RcZlqtyhFi2V4PzAG09p50bauVsKwl3=w713-h632-no";
                        video_path = "https://media.giphy.com/media/1zR9J5owQrRE7ILcpj/giphy.gif";
                        description = "-Piernas flexionadas espalda recta (inicio)\n-Desde esa posición subida a poner el cuerpo recto\n-Bajada controlada\n-Separación justa con la polea (tensión recorrido)";
                        muscle_zone = "glute";
                        break;
                    case 66:
                        name = "Maquina de Gluteos de Pie";
                        photo_path = "https://lh3.googleusercontent.com/nxCQEdYUpMlJS6tKp0NhtI7Zvz8EYQ685s8xk3Iw2mxju7dHSQgRUBZg1iPDBMm8fSnbHghkecHQ0PkDyKDkTgki8gu_5wq7NIeL4y_YOOx6-QN7sT4NZHrQLCSzQjk_ueur3B9QF7V0xwb8aC6PFxJyVMCYoD0tVQDSLGa-_a6XnqSDEoWyHEm1KtSKVoeHZR0mKMvR-Rwi3I9wTr4wlYmqnVKgguT-ya1WpJ7PFqvaDsJdcnEzMIbFRxE2t5zrbJzTz9q8agqv5DhIbpr12F3XnEffYSBmpy1TW6fvwjCkr7lrJygfDMO7nwdLpLNMqDzoQ1KrwXDFvZsbY41Es_-Pit_a2GweghFGyq-dquzcQZZrzZ1X8N5C-vgCPEGxcfS-L5DGx7alsV0Cj2-l-eWPErjiV9_WyDEojXn8A7qmW8C0mxZB7pnIGs6dBSMT7neScke5Mn3krPmP05zwYD4hrlB7dkOXLLP57bFp8JBFrWZgf4BF6iuCNx4gIIn3dtCm1mISq8tbx2ALOe-5fgaaStUMM_ruWtyMg7E681jiP1hRH-56lNJ21E4V1hRsoS3HbbRq3Z7R7i_NqVImtVad-aY9sloSMsvp8B1Nrqtw78-JXg8So-KA_PjMX7vcRml6uo-0LxnB-I1Rb-0r5NNmjyBkbvf8qamoBN_k_B464zaTzMcSyjnK=w713-h632-no";
                        video_path = "https://media.giphy.com/media/5vYnunLwmnPJAMFGwD/giphy.gif";
                        description = "-Amplitud de movimiento\n-Pierna estirada firme\n-La vuelta controlada\n-Sin balancearse, se mueve la pierna solo";
                        muscle_zone = "glute";
                        break;
                    case 67:
                        name = "Glute Bridge";
                        photo_path = "https://lh3.googleusercontent.com/_mmQkQgVeixqrX-M6RQ_DSZ4lPSns3-LcWlPC3RBjRoXZLbqo53b2jUpBtLx3qLvmEZdAjJZyLqtyaDOSMLXbuDQDzUVZb8bKYiP6ZeAb3M1FPTkedaDAEDBGAk_t7dYqd8dthI2mOYDpXgVC52vAOqZIQgW4xkv4mKWkM2B2bKPYShCegWuzEq5IrWKWZ1DFpV_suPgcdvdT73CSHqvhF5_AJJSOXKEhJulFCeLH7tXZuVIm090dQlyM2NZ5ZHVO04tf8lS1FMB31eDdZPHoGiZa6aKBvgCY7ra_Kgj8Q76BlRZsA3cvrorrXcX43H_RnhWv_VhzOneVE0Fs1nj1WzLFtjoRhS_5UWo3rGfgxgINJ6YiK6QxAXDYYxtbKb7zKU8MFvSnO_h8rXcsmGdU82yp8AD4D1K7wI5bstzJdb_CTSS9L2GgDmbCXsFvcvlng_3lufhegIu6PJgFiUBwGctzX84HmDM8if4Bxbwd2-UoL-k3q7Lt4UQWwSHcQmuEoUT89BZ8MvTBqHBPArW54qZWG0Rgg4ORt47iqLg2FVIULo7FvrmYRoLo6BBkiFFFP9dbo56mexpapoKBI2DbS2kuO9a31O3mwQ8gRjCLHv_dJB25RYKrc7I1uEodYvSmYs5IZeXMfCuVXZhiCN5u1gbrE7iGRc644_81lSFC2UJ8U84DhyfZLuT=w713-h632-no";
                        video_path = "https://media.giphy.com/media/7STqShwodzd1jGJD2w/giphy.gif\n";
                        description = "-Sentado suelo, espalda banco (coloco posición inicial)\n-Cabeza natural con el movimiento\n-Relajo en la bajada musculatura\n-Tenso musculatura en la subida\n-Marco las posiciones";
                        muscle_zone = "glute";
                        break;
                    case 68:
                        name = "Lunge con Pie Elevado";
                        photo_path = "https://lh3.googleusercontent.com/tCPjOq_6yOtez2rUZcJWz6qORzrkyqJfOyCR9MBnKySTzF1wj2Nf8a0V04pQUQGxB2LOmp6z5BTF141D7IFt2QmLMArU4iZPQmg24EX_oWUMfWTAWPxsMmsBRAK8AWmqo-YLuK7tyJFWEF8pjc2xPr2pCtugqYf0dBptUifm3EcSf4QKK2ezGIXTDIyDi1-zrxq3y_vmoZ9V4IN6MuQjNdWUZmXdlZZJTbH1HZ2XQ7DfId02g7JIz15Ny271tKU9xmvctVLwd6WYYbDu53jEc-Qsvh-LoiuK-Scpu3to0NpZ9eXBfOyKh9Oj8omfgGT4UXBWndO0IPlL6DAYHSVMrdnbJxaIv9udsQ9vOMaTint7IzRdfHXPWooPIALX8qI1tiGzIY3opRpSLdTVO77LgUqMgq_0Vqfs0vJQix0eVS7WmVyveMP9QCdNNfGD4k4N39e8impQYk7j9dzItgoOz9MOMI5gYxsbjRF4wmkaIXmyHuzQq4s9os0_8rZfTKdqyZhwagtwozawI1pAxWDx5OzoVuZcQLLTIsZqJIiqwE5uOmf5V4jkh1vTSNj9tprhy1d7AqSwJ1QIXajo0ESIEHjjpNO4h8-_kAg7dcwB7PPgZ9lh2ZlHYTrNlixq8doJRuAMFAIMr11RcwxHgxPngD5JpRhq8bnKqRg7_j0fAVLx3QHr5dxwHyZk=w713-h632-no";
                        video_path = "https://media.giphy.com/media/QK453tJLZ9DKgJPd2Y/giphy.gif";
                        description = "-Rodilla no adelanta punta de los pies\n-Rodilla de atrás casi a tocar el suelo\n-Cuerpo perpendicular al suelo\n-Espalda recta no balanceo";
                        muscle_zone = "glute";
                        break;
                    case 69:
                        name = "Floor Glute Bridge";
                        photo_path = "https://lh3.googleusercontent.com/TuiNKsgpG9dl-xwFC9IkMPDGsKkCO-6UXnfquLNBbNsxdUIAeu6Z5RlZZpqOLhi6GhQxcyjHaQyT0ln-jglztpGrCjG7hzYUlT4qT1dmM81sGfRxW9VPbkimif5JdJSvHD4qobXVDEw-jXcTFNpqfm7dgygUFPyDvOiKbMKY6xJALgKxlQFgEyV-7Ue_XsNPIf4n1Lfwe4SSvzpUDeii_IOQgi7s91Gycj7UkTnsJzHQKP2HwO5n54HVPjmEPLkHoEKBDIsPPwhFAlK3KUhFVObhFqTtbHut9ZAWf43hFb1uz9moxFn6woh4GCvOkGNgEglvOU5DnyeyJJOlgjz5DaEKWaiJJ3OgSRMsnfgIhFsqJtw0l5obLKRh75iUkFsSOuXnKT9BCbue8A8onQzTSqIrRAJYbiu5vjSys7RH58zQO4Vy1rwvX6Gq8MNwDcwHBDid2pOHznW6Hw-9EFZ1dWSRhCWj7xd5roZLHBuvWSS1WtrJFXIjv9VXn4BR0NPQsW5UTXX1wMutGxbLUX8SnTEB_kv30YxgF9FHtJKjA8PIFIMJ6QH_Am-OIwptMM6Usc0TN-eNIh4ufTHu_0vGcNzfcikUvPRYhcxYg9sEdIPNFo6Cp7xJf6ejWi5RLIMp-rYchJk5tsQDtMeg0pYvXNKUmlCQiTdUticzN-W5v-2JAQMTkS2lG8tT=w713-h632-no";
                        video_path = "https://media.giphy.com/media/5ndmzORKczTEPqlJ2V/giphy.gif";
                        description = "-Tenso músculos en la subida\n-Relajo músculos en la bajada\n-Marco las posiciones\n-Movimientos controlados";
                        muscle_zone = "glute";
                        break;
                    case 70:
                        name = "Lunge Lateral";
                        photo_path = "https://lh3.googleusercontent.com/sgf86-Shj4IYx_I75t1G_f_Sm0734D9Xrr9BIFbgYOYc2LySeblcSfQ2s7f5EOPTIS5Zw05WFP7lX_zXXehXU5t0rJ_t_Yi1-TnGuw2zcQV-AEGybVACiygi21jOpfqnxmcGJoH3LMTCihTEOxxsx_oRm0tMbneW8ONp18xJxzB9hkFgG3myjUboyGc2Y2h-wyWl-Q8hZAosyRCc0fgvqnIOeEASdoXAl1bC8MU5i3LV68rQljvnZbyYS8MeeIjKulH0DwSuu5C_vnTXH-vBOty3xPYGwuxzKwZ9vInphAnOEgfvZI7y1AzUSLQFOcOFTrAFyKcZgpI5_8AqcelPorTnvH-XK_DCmOCLdYPXIFeR9ejZHh1XkhyWBDAqvMj2HNQqnpDFr4-74eHAe7jQCQBpWR6TF7WI7PECMKTznYUyKxZR5-qIF0vj4U7GOKun_ZE7UKV8cT1QzIFa_yWN6xbElQZaLUP6HqYAudU2CXeSaVHDamTxgqZw_kOIVbfqf_24FkPzawOKKDkObAVrILkmjLjwWXjiU0Y3W9phEWUq7GGibZAJ-DREVMZsUGMLWT3kOSmoY8fQHIZTuHz8aqlSX6QnBHzLlsYXYBPAP3AZzDMQVIN1AHPQpk6aVcoVYqYTrGR-C8DWJlHjsHdqKLjn_PY_UL80Hp5CmZftW4NBbR9rRx5g0q6f=w713-h632-no";
                        video_path = "https://media.giphy.com/media/1oGrxLpPdqv2RNTCZM/giphy.gif";
                        description = "-Rodilla altura del pie (no sobrepasa)\n-Bajo cadera\n-Espalda recta, saco culo\n-Movimiento controlado, equilibrio\n-Pierna interior estirada";
                        muscle_zone = "glute";
                        break;
                    case 71:
                        name = "Lunge Diagonal";
                        photo_path = "https://lh3.googleusercontent.com/FJE5NZlz1ue9fVFUDtoGGNgRe14dxcG1OCiuzkHbrdiqHTwU6UiG5QybCvthvmItG8Wco-vwF-rRvdLEUEW_yY2q0jstapr7sSUnD0gpB85iKlLnXz-C40NNqbHMI7Y0--FxW1j8WJHPPyprsL5V8lR8w0JmGy8UjqcX0hBspnKvxWd7K9c1YWFL3K00BheQ22OtVxZ48G_YVmeqPtkCuuGrnnoYl7s73XFjV83NXZYDAW6LMGDxFoMKLRekOPHZDFrUJIxlY9cK_bMqtkTY-zuwROkobx8k9EJmVXStLzQIo_g5I5uT77mhDrGePcXgIawenxbcurgWk1nxMTV2BXOD7at2yrBgLI6CemqKvlLDW0hkZedNBfKw2UaLvl24jgN7xTL88x5Azc8AWDEVnNp2kARwKvX8XD6oyT4vytUNW0ZKbBZIeNng4RG_vPe1Z6l7YqL2bncnCO5Tp-AmQ11buOQjVRg6rU8dhn-9kYIWQK-PP0GoUFcQkjmCiaTLEWqQtwZOa5AGX5oKq5XmC9HSNhbIgJfJg742MFn5YYb3SM2zrlxfTiGShRcUXZD3LItdM5Dcyq36loHunhpO2FIRQqYFs_yHJQEcUT8aK6TGkncW3XoCLWuzbxeDDw73uvktibH4TFRq5pUI0Z5RsLK81-N0aJJUXcnZDmkUshOYoH5-ew0RtDgj=w713-h632-no";
                        video_path = "https://media.giphy.com/media/1eEDIJnt5Zt75dZEC4/giphy.gif";
                        description = "-Paso diagonal cruzado\n-Rodilla trasera casi toca suelo\n-Rodilla delantera no adelanta pie\n-Giro hacia exterior el tronco (acompañando)\n-Movimiento controlado";
                        muscle_zone = "glute";
                        break;
                    case 72:
                        name = "Dominada";
                        photo_path = "https://lh3.googleusercontent.com/ev-JmkK3SakIY0VPWxQs09b57Tg_Zu-6Dh1xvn2SUEHCbRWwkT8KkQGUXD5tnSDQh6WJLf4Qmrj5aHxer32ckgCcwGnwAAYv6pkFkWElqCeBzFxu_h_xJEXDr0W8E858yYNoNeWs05qfZVSvWxBlA9fgPw-h1_4R6j66vx9izQgB8dDSU1MqsEqN_lo5HtSe8e8lkWMxcuAwAR7RwEYEIfPd0EInpcNmkiYPnrEdpWPGNE1BML7IOOyf5sQGkOlQ09aA6C4p9JL0heIIhq2GvvP-fL21NQCCsQzV8d2XJ3kDDzWpzehUmfLIub0SxGmTiSW6Ig9_qXnHXCZTx6rejE6-ZX8xUme5JtIRHtvC_Lqs3BdkF8QlsvRZ0AMoCjbToY_kSVAqNkXJKsn0KWrwGTlkROrQ8snrUWGxrSmptGaKpQjY30ZryNDoQ_Ol26EvyRqXux-6R78gkfsIDcvSt0oyr2GqrBvBD2RkbH8U14ssXn7z8IlGEk_i3v4HDgraTlgOL4yrN32rHzTcz7HaiaEUDyz3nb8Q1-2uKPx_3Jrs3qBh7QBjiPM7881Wy3yRI5vGTCzsZuW1oWbD5UPfasGelaFQLTCOV2We2acRRltQViJKjPlAuyl695KJAqsCdnnDlLpBJKvjy_s24SNvYswgh-lpCg0SVv6UpYtBQK8zZST8KWmnDbZ2=w713-h632-no";
                        video_path = "https://media.giphy.com/media/1lDGaMvQePxyyNmBOZ/giphy.gif";
                        description = "-No balancearse\n-Agarre prono\n-Amplitud de agarre hombro 90º codo 90º (aprox.)\n-Subida pecho hasta casi tocar barra\n-Movimiento completo";
                        muscle_zone = "mid-back";
                        break;
                    case 73:
                        name = "Polea Trasnuca";
                        photo_path = "https://lh3.googleusercontent.com/6Ktr37JQ1QUw1MPxDDIhiH_L2uz_8E7ziYzUjoKhzgeeNv7PvtmevoXp-m1ANd0Phcv6cYj_Nk4MMoUdlpZZMObX-rfy39auFZaNiUjgCFVIUjcaP-w3PWT-IytzPqgShkZIj71YyAN30CBa596EBm6nZB_A_IXOM1Fz_gMf4ZS6h4Q1BOwcUsMjwyslLRVJ0o_s_Oda1_oOWYnaepHQrQm1_864W_Lw3tSxsY_L5D0xUm8CPazROMB5X2HnZv8GPB6vp3YwFE58ZIPt2aAaBfZuwu6bWHEjEFb460kFDDw23CWm30ddsL7mFWbeD7knCyYagK0MLACUiEnUY4N6994fJDy-TOzkHSa79C5ZJUlU4eb3kduWzrczFD31HDm-yZ_0Ou1HKsophdNd7PYKbExkPcceGkhoJgVAbZLhuCiCj4TdNomHBX_TmrNo6eI9KIBE6PNe5yIunpYWc0hfsXAkUmY06mim9mqu0mwvRhW95rryjaLRHGxDEQf0PW-6caxSSBez5MOORnetdLZBRC0_W8euBFObAj8sRz-rMRQyRJCWQhVrUsiEz86A3GdoFS1qn5jvY-srGkhEZKFYefPRmA2GZ_g-9HEwmY4zzp6j-p1B6xSavcdR-rZCO8hifVQQX2m4AGkzZV7zRbH9rVnjjakhYhhC4m41rtv1tfIy6dijndfEKXn3=w713-h632-no";
                        video_path = "https://media.giphy.com/media/14dYwJxgFhF3RyN4Yr/giphy.gif";
                        description = "-Espalda recta, pies fijos\n-Cabeza inclinada hacia delante\n-Bajada lo más cerca de la nuca posible\n-Si molestias de hombros cambiar de ejercicio";
                        muscle_zone = "mid-back";
                        break;
                    case 74:
                        name = "Remo en Polea";
                        photo_path = "https://lh3.googleusercontent.com/zHBfcDC0GazTt3fNb2Ll4oSJopg1usJsnipYNLV-GwjCeh1AeYj9ZvUbdFFaoUAsTE9i8g2R8lTTzeOpCwlniY9U2J31WUrVmOACxHscJkmDwo7ZCWGbptsLReyBhDbJKhyMBcjvu8Xw6roZMzgS6NaodauG96jiKC81-zal3Rg9I3soDNavt2EW0A71n-5NOPi9LXWiyWjodFVqfj3S4G8dbZ6HxD9RbnyyHx5Drw7-XBRS6wwF25jlytnFgN22cK75pEbbrczCD5Ss8u7q51gPvxVEoDIek1VK6pKsq4kFDEhtroFOQA-BoP_yy2fcQy3RH9wUYsza3qyTrV6hfbsOkWf0Qd64dlIsVbRPkJWSLIFkChOsjtA6BqI8X184hbdFvD0qAI1I8tO0PoBRMhTbtsUJkzVbj1djc7cjQ0Y1Z1qcPFG5NGFAZ4bv1NkIdLIdEy3XqSjpAqnOyN9no2dGIFEt1QhNRCvjue9-cS-qBQpoq3896ECTHqtpKbgrcJhdKj2k-2INwS8ouGh76FsXRoa9hmQh2dzACogW3L9lvcrgM8YLDMWa64kWfLIX-Uf5bErIK3pEixhEy7x0dFRI3pPqO8Nx8sRfouLGoZsY7kjatImU-4lD6qFPy2MitX9DQe0w6Ei9fx6vWFI6YaGEos1pDl-s_dfMmNaYCNSVc6DvMwvey9hV=w713-h632-no";
                        video_path = "https://media.giphy.com/media/g4G2FNwvCivbwQ05D4/giphy.gif";
                        description = "-Posición fija del cuerpo, espalda en diagonal pero recta\n-Se mueven solo los brazos\n-Codos junto al cuerpo\n-Amplitud de movimiento\n-Cuerpo rígido, no va adelante-atrás";
                        muscle_zone = "mid-back";
                        break;
                    case 75:
                        name = "V Bar Pulldown";
                        photo_path = "https://lh3.googleusercontent.com/jIhuOFymT9R7lMgWqStM1PZi3vl30BWi5Ud36HQDpUi8vMyeN9dxfx09_5nTzlsXAgi5VoGFA9M8IUcP6Vt8J07HXYIFVSfscZ5bA-riFoPX7AOJ5CdpQmepqayYrt4D9hoss8pK9OksSg0O-vhx8DkDDSSpyxQTSlSf1ccXHVfd7ZshxfP6SUcaZNt82q0qUWqIlZlZV35GFzJsrVdkAmUeE1poZiif9_ALjDenqmHtciO73_9cFcJhpEmcWLnzIuaxnaJmxrATmRNMrNVx1N8A1n29m5KJLpRbt01PGZvm37S-4xAtN0N_dtGbqqQ1jd1V3ymsI8FedjGfkENNmYZdYuOFzTEo4CyoS5Z_Q1F9wPmEMZSpmNIwFrhdeCK4yNKh6VM8geDRvwbBJIVVu9nYFkdxj9O_2SoYoP0XAGuvOhJbATSKVDhwLpPiI4l7fYSVQe5QRPXO_s8dGtDRgiqEPvZtDjpx7sNg-01lvqkftmukbqVWdtOvHND-4HTQlymES2Bs9dpeKIGtu9CGgvQkdV_gZLDMrQZN9qd_utkxMCX2OHtKAyxU-bptiE9mga2upmcG7mPDKZXsDj07TtzIgmnrsDymmrIo93cuLM_THKubYSjFjfw-6TVCk_Cpk7l5nZXtPSvtHs1GEaEcPZ28fIoR5D8Ioghl53UabLuXPk4-JWav_5M_=w713-h632-no";
                        video_path = "https://media.giphy.com/media/8UGF8X9kYZ30d34VQ9/giphy.gif";
                        description = "-Traer polea al pecho\n-Codos junto al cuerpo\n-Recorrido completo\n-Cuerpo fijo, no se balancea\n-Espalda recta (diagonal), pies fijos";
                        muscle_zone = "mid-back";
                        break;
                    case 76:
                        name = "Remo invertido";
                        photo_path = "https://lh3.googleusercontent.com/GLg2bmIZcYVrdoL_AqSXMtyxV9-xMYgSXfFDNs6zLrVAaTkd-IXHjOt583K2pfYsESOM75aEXCWK7b7Vm1PnVgp_0_Ls4AmuYYgCtrlS9OOgQ3SShHWRU649bo2aesyE75u1HGcRwxf1_p69ZXf7HJ6iAH5Xmz_ReSmqWOPWOeD-pnyZvzKH-2YzVPtSVik_hFz742LRPWikc-oeT6cOwM_wlENYcQn4fyLlS1D3Rx9stFaVxG9cVmHnpCDZNETLaH94J4h5wDKj-Q8rh2Giq1jFIfSVGxyQ-EspROed6FGE4tfbTeTFHTyLcBtCgtLNY7bRR0Xm4awc3GO69rMhLqjCy-HZRsBsVki-0_vkvE5fsYBhA5QEVfqfdabMeZBvlEmdvCayUlMKHGb8kBvvKoZJwy7ZHKnK9PSSkj0VLflrGJl7ENeUNjjzV8Qkfe7-4W8hlAqxfpeGgXYTrywufO2EDeJFrCVJCJpFlGm_qM9usF5TMtdUFHsP6iRFqb_omrhbEY6tInENr22yidP3_YTuJdRI_b0keaBOedS5MdmCgbHrXrq9ROxBQ4p5F44eKssZUHnpm8P6W24C7A3tHwwy6UXZYTiVK1SeqItLvT1ALbP7f-5J4nLop0Az4ZP-lQcmehTjgs5PFENTvfc72ibFcyAFIH6HHjvb9jKgkwq-A2AvS1zRBE16=w713-h632-no";
                        video_path = "https://media.giphy.com/media/4a3DNqo7CsUc63Arss/giphy.gif";
                        description = "-Agarre supino (al revés de la foto)\n-Codos junto al cuerpo, manos en la vertical\n-Espalda y pies rígidos\n-Fuerza viene de brazos solo\n-Amplitud de movimiento (sin forzar)";
                        muscle_zone = "mid-back";
                        break;
                    case 77:
                        name = "Row Machine";
                        photo_path = "https://lh3.googleusercontent.com/axK6489X0fY5I_gZY6kEon7lxXQrnvxP3qYFqCzeftgldesJljtJw6PcibZCWMfQyWTf-vJYidYOmedsfzA6nqGqCVdTs2bBfG-Jd9QosUZCV5sEYEDBeRiLP138V3QeoSry8wtL4VXUcuyGb1VJqpN1SPc2Tiflm-Ss7ynpYa03wn7WjQIw8zgujJBvwWO5P9vd_B_xw2sKSe20ytyH0JCfa2xBCewl0TUefPdd0QpVsD-dicoVrQT38hLKRUCSsqU5cmzQK8L7Q7rTh7GhQBL5S3ULpBotTCdSBWYFcdhRKi0zKXn3Q0md_8FAaei0Z5jp4BFAAxZ_aQqx7UxqrVzAHqTt7nk2Xbk5j7SlT1IybuUYL01UC0okYyhdRjiCNyUkuITl4L7obuReK4pngy2iYPvXvJI7BU1QIvYVRC8E1WfJBFOPg-HORnJ5CyG_0wwdqiXt6fcwEXMJpdSN_wqI2ttV51s-sWhXEAozxjeVXPG5OdxeHqG8NLjr9GYXsKI6G9WDHdAUwx-t5JAg3FXfydfHEysfxanxcBfNB_oUdht1d5RBkenZgJiB5xYN0uR6VURzmDgKpLoDyXHRptl1gThikK_v8DOn3LjNpfMOPM4gTK8g7jcvyRo2HtCGARk7HxfP_FpCVR4UBzFpQSe2XmxXYCAFpDXg_VAcB80rNtw79iDQjRk1=w713-h632-no";
                        video_path = "https://media.giphy.com/media/3b6qrDLve0XifFgU5H/giphy.gif";
                        description = "-Espalda recta, pies fijos\n-Sillín posición cómoda\n-Codos posición natural\n-Cuerpo rígido, se mueven brazos\n-Hacer el movimiento completo";
                        muscle_zone = "mid-back";
                        break;
                    case 78:
                        name = "Superman";
                        photo_path = "https://lh3.googleusercontent.com/5pHMWknNPCsT8VXxxt2lUagod-oyP2D1rqzIg_cxjSTObU6WTJziEqoxEBOmxG8pOrzGJfMtVQ6jCwsb2eJdWJOdX24LJkoXQfjCU1HftAYeeYDsJex5nnM5tLv5qwWH18IfCefoqIbSXW8QgbyZqlxb-HjjIJp9FdKE0UeRZOazVrE1VmUgR0SiCNMIm8Ix9DGp2W2nn-rj0GEwaPKBIzNihUGB96HTh1tUX2EaHrNKk3gJObrG72COjFfrHfqcxRPvvQOdfBS0wEHS71p3eJqq6Z_YeT2p6Sd_XkZST948utUddz2d5zo2q9dyGVib1Bry2QKEpsiP1L9dAGNCK6wREYndvVKeeEQKH15oOwOavKhtbf_HgD4kIlfwCBms_CBELnVZkny4Bcps3jPif_K3ovehMMKJ8UWxPXPFvvZHazYVCvrBX6XrWYC805dbwvVgEWjnFK2M4_ZnPVSL6IIc7n-i7DgNO_sXK_Jl863Mq4dGrCFQeBZuZvIexysdJzCsI2_roDuyTizaPxaB4QK84fzLM1y9Vz_FknUf1jiqgL_cJJTsdv2jvab88XuCeEsL9OfVQyvtOFBvWiBjtv6QVFJw_l7zRZWDcXHrt7-JCx_RuEbSrb6DT7gcthdsphspGOot32aFJ7tTXzY72di5nho0544MCQiTnsJF3TM0W52zs-8hAwwd=w698-h632-no";
                        video_path = "https://media.giphy.com/media/7zleKmCCBYdZ8xsMIg/giphy.gif";
                        description = "-Espalda recta\n-Movimiento controlado\n-Equilibrio\n-Sincronizado\n-Amplitud de movimiento(sin dolor)";
                        muscle_zone = "lumbar";
                        break;
                    case 79:
                        name = "Maquina Lumbar";
                        photo_path = "https://lh3.googleusercontent.com/Qs13vEIezR-Tqgih4aUJeqoRKZRCRQIP06LUCTf9VWPNRef_mfJNETMm-bG1dvk3RBx4m4FzpQsacv-9WsE9dfv_6LUzvGmPZMC2_B1jKWqSZrK1huOKCSs_gCj5PQA2Cxzch11PllL0nocPYKEym6_kpG03O_3VfgE_35cANKO3fiq7ygzUvwFsljXBZu1P6HMYOwG1CZMTYwYoDupsd2zsT2VQvjWeOpqKmfc2CojKRDSjDg7sj7AUCJDuKV_Kf7zjqdi6wk7QbrDgt4BLhmtXsEuNNKzn9Rz4s127FKrxChv48VOMkcXgqN944iRB2rD0fbWTRdd2jNJO9Huc05_DuY9zWbXpNrNVuAtgMw7NOiMgLYuLp1O8phcU-2Aig9XtMYwE88sbnZJ8ZC9kGEX_QJp7N7PD8WjYCE1TRi4hhrcDNv1YUuzQWvVbOQZqt7YBRGKzBw4m4Rz7Hq9UEjbLkOly7HSW7OOzD61oe7SStxt-Rg_Gy2yzGj5U5oCj5j9oS7X70YwQxFWLl0isUjXavtnRwosppy5gMY9rVxHDSp5mptBNLfWI32LI-gRNMR_hXZoEDyZQrj6t3rXnM_-SZBcAFPdioLFJbHsa4fu3ZTmFooDezJCGLIZI2nH7OhfZeW3hXioCdgLZ-r1B8IBU_WbAfbSobek6r9xR8c76cn1bhdIRNPAT=w713-h632-no";
                        video_path = "https://media.giphy.com/media/MuGiDdMwNggHrWh3I0/giphy.gif";
                        description = "-No sobrepasar los 180º\n-Curvatura progresiva espalda (desde abajo)\n-Piernas bloqueadas\n-Control de movimiento\n-Bloqueo progresivo de espalda (subida)";
                        muscle_zone = "lumbar";
                        break;
                    case 80:
                        name = "Maquina Lumbar Lateral";
                        photo_path = "https://lh3.googleusercontent.com/kLVGy2Or_3zm45d7NtzwESo4ikuOzhNuJk3TEJR06-vD_GRhx_u5a_qCGjrTclpAN0-5a9sgOapre4g0lj_z2xFajAERI4ypWyUnvjjrOAjnecG5evvNSOrK3lADFyxpvL3w3rHVC1UnlO0zUNfu0SSn-BTigW_GvZA8oVNa54qodGUR36Lsnhzy6fcnKcmf_4RBoLuoI665UN7O8j1-cPkQdhAznRJFMVylw338wrMgbbuYxxJL-GVieOKjeyGeyk0AGQeeXR1vb7-gJyqiauAbpKA70et9bjZzg_wUMPyZlwXjiytTmf718ESUb6a8xAT7eiVhn1jdphfUYCZ33Nq_0Y-AWxaz63MOGyAqLfQ1bMeiz8o_VOBASj8Pwbh0-pA0fnP8g2kRCw8reAm1hVrFLpKQ3SF1MRj93aTa_9F4CfKGjE51QKHKiV8WZIDMiW1C-2bB1XN_VLSC2opEsvDBrVT1XWZVzQFTfREAPhU3e2YnRJpYkrzc93k0X3v-7KT-flA7I7Qvurhog3upu4ALaGcjVWtqPdkOVcYyPIG3TbBerHzFbPrVxVrzwyEZfVzFF-NZ8okL3ObLRPNTRg4m5S3Hv8o6OH8A6IINQQkoG3MTSnpnwlbZGZ0YufZegMULJZRcYv8qzOjGey90xZ5W5m2o_TOmueEP8Js9-Uw8wdMATG07Nt6C=w713-h632-no";
                        video_path = "https://media.giphy.com/media/2kRwSf6F6iLIwBvSUX/giphy.gif";
                        description = "-Pie interior adelantado\n-Inicio a 180º\n-Movimiento controlado y progresivo\n-Piernas bloqueadas\n-Subida amplia sin forzar";
                        muscle_zone = "lumbar";
                        break;
                    case 81:
                        name = "Peso Muerto";
                        photo_path = "https://lh3.googleusercontent.com/uuzJKde-15HfNutvS4XLoB0mTva5botmAkZPwRgKKMuB98TqAxBOcBV-1lAfd-DB9DuTUQ5BAp8QZ8Fdm62jXPLs7GzSMxU8Ao9bjBN-9F1WmsxCUkuKjHjlvppTNSoTWkeJ_MGSVBVRpHbA8ybW6MhhCq3XBvMG2GXib94JoZa1ETYwmjjbRfgHfwm3-U_hvjzUFzgpaVOswlYbSnI-onCiKMrlsE0z_DCUsQ8clpvZtXHfI6ZhtgIkILCLQE9lZZ7h-y20UklLWE_cQAQWMidjsDMzwOAzDHayoLcAlvrga71xgKPC1F19eM3nY23nFS1AgdKogZAgfsNBAFRmkgHwperh4d9OWlSIsiFg8z3XIFyMdOBHanNuHABlc4Urx1w0Z1YtT5WiPl0ltAonscBRXtmDAX5fO8fxqPJuvMGE35GKpbxjnK5L49qXRDpeP6XBvbOo5KsXO5mtFBx2Suk-JZscKc0EguQxcQ3uHwkstb-BcrrM6idhG2TKFTsfLL2jOpYQPZH5kPfLcnB3DVliRfYvyyC61xcvnVRYXM-PEB_WZozuaHeHPPiRwMWCiG7xxJZ9UWDgDRELSn7LOrjT4Ly8CtPcSltz0EtGjJJR_NWPHoRpdDmDxS6ju9z4gj236OmIFW-OG2L2dj4qLwNFyHAw5T9NUHFCYzssjKfUb5tBMsVikhDC=w713-h632-no";
                        video_path = "https://media.giphy.com/media/25HwgnJ41KyOcmyRBC/giphy.gif";
                        description = "-Piernas a la altura de los hombros\n-Rodillas no adelantan a pies\n-Bajada flexionando levemente piernas\n-Espalda recta saco culo y pecho\n-Casi a tocar el suelo, controlado";
                        muscle_zone = "lumbar";
                        break;
                    case 82:
                        name = "Lumbares en Fitball";
                        photo_path = "https://lh3.googleusercontent.com/GkAyt3IGhDIZQGtGYGdMNU3K3YvcQA-1LUP63UcU5-wNjFKhDXPMVLqQULAR7iC4gPaeiwXdbScDGxSjq0EIb-eMwZ0jamZY_zdBU4FV3AZNxcEu2uwu3uagG-cBa7vJmD1KtbugwPyWa8HwXwtiQXf3tu2HkvAa5IyfSnHkMNyCvQ8-Z7UTA5rrRq7fjI7zUcHoGQn0CEm2v6R17USvIw23Yj5AhN9nVq_E9Fz7Sve3RkKWxd3AYEzdrjsb7c1Ja7q6d8b9Fl47mnwHvYNSpEiryeX4VpFUB4aQJ1cOCqssDWGYZ7nlDOPoqPLpS0GM3tFQLP90A26-oodH2o8XNHPM--ZCIFv70fQVvsItwyeCtnyVBAbMDJA48ZnDz6H5isBnUNRg4mS2zMRlGL0QeoIW0MCow5tg1Dekn43yB6YdFAcKbq-3UrX7RCwALhoW0lWaUSoI-0pjygn3GoCDXAoLlIlgB0n30pgYAdlzeTkJ_V0oswJe_yoc-0FbzbZe6HoMSEJ54VQf1ihNtaQ2kMu0KDjh6bcdVvn46rcQUyNvRC9eBDRPiLYuO9bf-x5hzV1vJoP6-JohI7vqYxdd6mJnygpiWiBOVOhxXLVZlMrzZSmkeN9Jv-AYuwAkvL5rlqKdxk--16yi5E8frNKmd5pj_ziaiVw9mqdpMm4NFkChrMC-S5PfCrK1=w713-h632-no";
                        video_path = "https://media.giphy.com/media/9VtKUOcglQisehyfuw/giphy.gif";
                        description = "-Cadera cómoda en fitball\n-Extensiones de espalda\n-Evitar balanceos y desequilibrios\n-Cuerpo de relajado a bloqueado";
                        muscle_zone = "lumbar";
                        break;
                    case 83:
                        name = "Rotaciones Polea Rodillas";
                        photo_path = "https://lh3.googleusercontent.com/S1uKOLs5BNZFdj1ROaLy6MajBPwT5OXgjJ0zs0Pqc8S9MfGqKUiX7N22MY2wNupX0oDUrrREd_Jp47T6p4PAqifhDCzOkav2tVE8pj8McuVc2NSXnWMzoSZdGAzxyT9QejXXovHM1Uocb0FZ7wHKOcAH0XNXEGt1dTxLGvz-N8mHLd3Jnt6I5RpKnxSTeKjXmEHzmLNo0dpsDZypRmhzqW6NIZKXonyCXoPZ_8vD8oIKDjy4Q7Ail4_25HD6uPMz6IJolWytYE6phWAin-j6S-B02xQhIbG9RG2YLKLUA7vLRY9hd3xbRYuZvM1C2ZRP90vj85lKzQ-ZzYzGQSB0z98o0gkyD-QEL9AD76uDzjVc0RzpyQPp4e209V-1BadY1yg8WcK8Wqe8uPWTgo3wbFeNYKrgTKdkAbsYgqRz15v6XM_2esZh4ZsRJNpP4irTcG_ggvAKiqFq9fycEqJMs2RhM_HeOokGovDWWza4uSnOzQYjeK2lyaWvWrWcAKCGw5-fdqtgFpYibit_L6f_koPM4Ccg9IjMdqpg50LA-Ey70yGU0noPoR1JdFU3I36X8Lw-ds7mDloYWahJE2gMB81fJB9qWR304H838a0p5UYuMmwqLvGNPMAyqaiu_ydH05fVbEb0Y7GaqWSwBCu-O5xVOf4avpxhXoevNFDI782PbBXlAHCk0qw-=w713-h632-no";
                        video_path = "https://media.giphy.com/media/25aD3zUdkM8ayNOECi/giphy.gif";
                        description = "-Brazos estirados bloqueados\n-Espalda recta firme\n-La fuerza viene desde abajo hasta arriba\n-Cuerpo acompaña el movimiento sin perder tensión\n-Bajada controlada";
                        muscle_zone = "lumbar";
                        break;
                    case 84:
                        name = "Maquina de Aductores";
                        photo_path = "https://lh3.googleusercontent.com/5_TQEcAB1W50KQs6XDoc7GhTZDZ0_ILTFF2pCJNJUJnTeuywlWf8h3nvCeboaN7GqkzwVnezYZ980UNZ9JbpvcKc7z7rk8FH5h_vJPYKAZlrBRqOPAoh0vWcTo8sXAVnBF0KeM3iDTbYKIpe5JE_JyAaT7gz0T5CCL-a9Q1lCshHqRDnSeyBcjXqlVmulVf1L0jugU9FlHkz7rxFxFZSc4crDnqNiya7Y2ukTHGy_cYMNVni87skNVd-mRuWU2XYl43fUd-DYeW7qi6CqDn8n0SbBsDLMcRHz148pBOiQ8OSmvLl_wBusYoY7rpCte7t5jUlOW0I53eO7y28ucw4LV4ikG84qEaw6NYuO18sdQfB2MxPGR4w4LECxFvPE2QpBdss60B1MCB6eutd3V2RmgKobTv8yJfLaPmijPPpswLAc9UgTPOJ2n2xFZ-Xjscmwj6bE30S316soVTUMLPR9DnI6Wic8-a4spMq6tG6orGG75dsIjQ86RXC9ARCe7r3wiSIp28G6nCGEpJA01ru7pUv3JDLkOWu7Jv1b9QPLoL5LqgmBcMza1evkML4w76lU1Ii8-E9OJOURHTnPowqSX4a22NCNoNPC8FXlbgOQ4iMr9hr5qU72uxVkx8ROk87T49kRQ738EDkGTJYPNP6XDt-U2H9n8gz-c5M0jZ8PIVV6I29jiR8GrYS=w713-h632-no";
                        video_path = "https://media.giphy.com/media/YlwnXWMvALBYgBe9eJ/giphy.gif";
                        description = "-Movimiento controlado\n-Fuerza de piernas solo, resto del cuerpo de soporte\n-Amplitud de movimiento\n-Ajustar sillín\n-La vuelta controlada";
                        muscle_zone = "thigh";
                        break;
                    case 85:
                        name = "Press de Piernas";
                        photo_path = "https://lh3.googleusercontent.com/uVyRLIpNvKnBr3kiCKYqjifr9oskEIQf4JDQTvBWdfTxLpwu8nPeZ3Fy_vDEbT5r9jjG07usRCgtD_1tN0fUj_ALuSknKIbZmmnVtRdmOjfg9BXMcInPwR0vsSK0AwpCzO8EXCqn4lZGEXT0e1TKgKDwZfHtN5HFB5HciPnFQtO-jPOVgKr2jTyvVxhFjhobAK78IVe4WnrQRH0r3pmiaew1fbPlUtycDioz3O692qHlmnbDM4oc8123K5tCOP-D5r7docl3qiTpNrppZr0riQ0cunkvWGgKZyu1EHGBzIpJbLF5a4T9CA9Ce5GrlB_B2aJEn-_jwnQ6RDVVpIcwNHLzLu4EfiFjd2TSoS4Ur0pgdlpLbeEGvA78LFYNzJUsrgHpBIoiqmuurM9ymhha2s7NNGddkoPdFxAJkhKDbz6OiEitdw2EIpxYGarYlIRPRMTK8DPtulBb6N4GTEUPwkLnorLWwyBbVl_42e_YdD2qXzUJZ732vdN4t-NLVjRKFIpuwTqvlCuOuo8wAJKZBqsyOM-sUpbwa8qikQo0dPHC_3fhuVT7J1mXvlgk-aLBKmbWL0q5KHmNMavx8c07poeXrfd9EIc08vR966tOBB4vmHQBwrdkRGOxbBCOOE4UL051VuKUWQDkkVi7z9jP24k_SmlPdieVE7lz10hEV3GXRrtm-J29p343=w713-h632-no";
                        video_path = "https://media.giphy.com/media/4Zqf41HGRZGH5zo1bL/giphy.gif";
                        description = "-Espalda bien apoyada\n-Piernas separación como hombros\n-Piernas posición a media altura (natural)\n-Bajar poco más de 90º de rodilla\n-Control de movimiento, sin tirones";
                        muscle_zone = "thigh";
                        break;
                    case 86:
                        name = "Sliding Harmstring Curl";
                        photo_path = "https://lh3.googleusercontent.com/IMlJnoXOPrRTKG3hahdnfZK1vZHSbOf8k1uVoa7BQGEcEekTHHs1HsoqJpYtvQnXEbkmMU4tiTn3-ed1vDdBoa1fL0tf4yUoEp2jJAa6L6FsbCWiDaM4eTVJOeZeZbq8jjJLCaXIYCLXR5QBAyOGcRk87yATWNMNX_o_VYRJXWtr8Ri_3F4IcI3LAwg5fDk0v9NeEljzMQQOU4cHXR6bzFWWk_eayf9Y08R6XTbd6Kpvmc-b0CcjCZ9KWLTFqQ0vf2B7hxwr4Pe4buJSK6-6lGHSXmRNREwnCxcSkmDnLTxEN11Es_JEyO5omx8fJKSSfGHe2dEY39frmryDHVMexl9c061MQN95noTdcdvjvAjE9T6ekti_REv2OYIhH1lWmZp865gBREa0W99PqFpoXo9L0Dr3TB7-Ftpr0nuF4XQcjEhAlme2t9pBdmP9d-l7jSwxrq_FEnNJNDsgP7NQFPg9Zf3OHyXr4-EbwLL8ho6nycshK6YABw5UQfwsbSWG_YH1tndteLKjtGIE3OoII7HyEXWx7YSFJZPhtweOAuT19t27vtpQVp_Nmn7mK33PwfjDM2Ww4QCGd9Lj5wnc0JJX4mD6ZDH70BABop_ILMco8ez0pEQevZzLvMrQLwYSXwefk0R1bVf5VCZm8RP89NOGg2b4lhUL0Ku_V3ANY7ZUU1dCisUjUbAZ=w698-h632-no";
                        video_path = "https://media.giphy.com/media/1d5NlpslbfhfhE8356/giphy.gif";
                        description = "-Peso sostenido entre rodillas o muslos\n-Cadera casi a tocar el suelo (bajada)\n-Algo deslizante en pies, bajada controlada\n-Movimiento lento y controlado; cuerpo tenso";
                        muscle_zone = "thigh";
                        break;
                    case 87:
                        name = "Lunge (Zancada)";
                        photo_path = "https://lh3.googleusercontent.com/EwDDNRI41LPb8a95kGwnxB756EW2t15iy3klFWIiLotlAvJ_L5WRC5DYgijubw7MouFMB59fFdzagXYlPi5ZoFIKa3YfLFCJau1RQL9odN6FyLwn4wcWJehixmDxaLHjhJ3NoZfKiyWkOAlAEaQC8SOwQW_z6wnQCwr_uxztaMUFhUlhHJXQwGL8IAigrsO4mPLlLhIeDXHwUQBKDc7nJT_74j9nnZ4db7MagVKSH4WJWLHzEPmcQlvDT_o9wa-5T0_I9rJWCQynLn9vIdtUoTdaQen8i4DMMHm5MYAD_Z3JsCYZ1Z5Gu5dCAtpsIcu-mzPzv4X-AcR-u_bS4ELz4nqUqXUH0-mCq1mCFAAShac_kPyqwxToRF53QyB5bXKK3H4ljgmA1-4euKSZSloI6ZbHCIdAx-kJcTrtQkGAAApIus9sJhLMlrMQIfL9Myr0wjDrQNUjUNObp-FqtmUFWXDh4pf37onJ2-D3K2_zdI5zCvic-qxpEWk3hzwjPd8I3llbWOnHBb-JxF84C7Ev6iGFK86mo0rpubmcog780lTDRks5Bd13rP__koPvsZ0t9Au-KOX8kuKFO7Y2BeVn7YlGXxHyE3WWJlwCM5zpRvvqHKdlPlck4QwDVu-o57euV_NSfUL7Ikzt2Y_Yfua8JKj4tDjrqMBVR1OatHUBt8HdeXtr-uL4orFj=w698-h632-no";
                        video_path = "https://media.giphy.com/media/p3ZPIbHhb0oMqtyCyX/giphy.gif";
                        description = "-Piernas altura hombros (posición inicial)\n-Rodilla de atrás casi a tocar suelo\n-Ángulos finales de rodillas 90º (aprox.)\n-Rodilla delantera no adelanta pie";
                        muscle_zone = "thigh";
                        break;
                    case 88:
                        name = "Maquina de Isquios";
                        photo_path = "https://lh3.googleusercontent.com/Y5C-kUn-T7wBF2M5awFfl9OgwDZgh5C15XsEbEAEyIVMeHs_XrFScIXhe7RD8w2LZmM0ixMZk7M3fW9JXQpO8KgixNhOIp9mpqaPrQdE2E4pU8mRQhxMuidwWC8TVe08XR3fuPLQl3hL6qDqyZRYXoLE5piCmc_YSnRnvTdpdHqhwFjdJM7AkSdQet6nm-SwgrvQXE3JURYOcpLaSxg2FE6hjDRjYHLiJEbUqV27VunuxRVKtOruemlcJmWWNxXx_Z78-Xa4o0ZicHw1JqJmq2jHxemSejsIzp-JcpuniVBJrY4EriGKXMHRAs87d-1JS4WWVna3lhbwWjB6sd9rBSKfX45tcBx57SVpQRqPmB141l7bs_O7ymKYXgFH8JDw49tRHUPk8MlxyxqkgTOva4nb1YknuxJZ4CDt5hTD9ARDF2OTZ8vIt42pIiuh2I-GaFebmrE8bYnkUIgLioJZUeSsHK3f4LdVnJ13bDBgrvgezAgNo1MPHVMGv57jg7qwuxvXCkZEEIB74Q68_HSJdQbL-Ym1SoMT9isrdVsPr1oV43SvnpgDdOTmA_UkhzS5BQJzRhudqyUF3XiWZQipcXedHQP-eEImtIklxjTW2UcTYRYwNuerExLPy_Y8jVKX1SmFMwnNFqUMBACIhEi7TG2doKDxDDTgXqS7hXUVyAAMbR5bDLquOE6o=w698-h632-no";
                        video_path = "https://media.giphy.com/media/8YTRGj9wuZ0lKHsD2W/giphy.gif";
                        description = "-Bajada controlada\n-Ajustar la máquina (posición natural)\n-Trabajo de piernas, resto del cuerpo bloqueado (de soporte)\n-Cabeza relajada";
                        muscle_zone = "thigh";
                        break;
                    case 89:
                        name = "Maquina de Aductores de Pie";
                        photo_path = "https://lh3.googleusercontent.com/VhrgQ_s9l2TyDWdJFvyJodFkBwHYs5INrEcp5n2mlFrcdRRcV3ePeKEySZzhUvsxAMeHHb6k0wO1Uw1hF3GbVW1vp5bnC2JilkapoU7oWOnmnHwHvLzdgiBNYwMY-dORuJMg5DVmMUv_U6LBRgoWuOUacSnuQ9bOhZKbIweg9C-eYE6CgOFK5xpWVcA3E0YjmnMOIV_hR4ScAqF7Ffj7in85biUjA_ZCdye5zbNFBv1KBGKi2t-gWlFHxBTKJ9ZESIursVzaKzOIUPwPRwXAn2OsuY-ZjOvzMc3eVtrJYaHCOUIJbduM43qDETKXkxBkuxFLzE6jzeovHA3FIK1QexgE0Bh5apweYUkDTJZkPLB_RO4lfQ11VUdC0COLvi5xmVu0awPcBGjyY6uqyw2VPGZoqZgPzzuUYGaurPFQcsUMirOeHLRUUKuYrEGFHjFCTypyIJcb-Y6bJtFa2oBT7hfOnkKB7d5dY_RPRMEbVkWuQjMZneyxp6wyk5nS-UUn_pgrwheY0NbgHXrKZlOnfOeLUjhkAAXfJfqvedZUMwL6liNTAE_FQxCpK0vpAb4mlUwSrdghDtIhwUugTG1leTaAv5NOw4j6ypd4L0hqoumRNnQrJOXl7YQiuU-RWx2_EWzjC7bjfenwZTnW_fX4lKqKeAwVBXDpg9PiyVUit0_caeJbRrrV8oAg=w713-h632-no";
                        video_path = "https://media.giphy.com/media/ipxyVwE01GL7ABO1jl/giphy.gif";
                        description = "-Vuelta controlada\n-Pierna del movimiento estirada firme\n-Resto del cuerpo bloqueado firme (de soporte)\n-Sin balanceos, movimiento de la pierna solo";
                        muscle_zone = "thigh";
                        break;
                    case 90:
                        name = "TRX Triceps";
                        photo_path = "https://lh3.googleusercontent.com/NIyS8bmXZdHDqebEt82N-BX7QOhZMCqK5kvS3gj_Hvjbt9bB1tTqYgtv8N6l9jYCHH_3JHXCCkyEOdCR_ot9_Vf4hsZGKLLBKlQ5YLj_hSgJfvO0mbhCsKM9enbl9fjJ_pwndztQhmg8g8k6BPiAhAbZcBOccHcGMkFOk4xdTb3XYMjOirjD9sx0Up38bkvxhtleMwsNloTqGstUx5s4i0FLN0BogQqeJobuoS7GSBgEbRfs_lDyR5cZt3kZDGVpYbIQNSoHAYdC6H9y-_p07kDJag3QrJp4cQdIuA9z8aSV31jwsqwww-mRbLH2zcxWvYq4aEIbfTqf303yRwglkZr9HxCRsNO8z9CQSNYdinQXVUCW2ODQ8rTt3VpIs-UMpcHbATmLOZ-TBiivIxIOKsri6uogmMCsVb2WrIyxHPnwvn_D_5iUeCe7A2lxtJ_uP4eZJ5oQarVmUVi8l6TEB-j19KOP4NHD8Y-JOmCwtgCKeqDAvQSQ3QAfDX0g0T6mt7PFtQ1RvkJdb3DG2teAQ1WjE-3oxYm5ev9Poc8FR9LiD2jHtfaNqQXRYjmXS8DPuD1ow-9ngVzOkKCQlwuM7ZkWa0SDAuv0gySEG66j55A1-mcPG4YFMzoppP4UhmCKkQNn6ayiHWGFCZl2LGqL-KjIZU2ATFTIgMhBsEtcFDCxp4ZQhs8p2-qV=w713-h632-no";
                        video_path = "https://media.giphy.com/media/26vy1pML95bVUxMRZt/giphy.gif";
                        description = "-Inclinado con brazos estirados en TRX creando tensión\n-Bajada por movimiento de antebrazos solo\n-Resto del cuerpo tenso\n-Codos altos manos a la cabeza (aprox.)\n-Controlado";
                        muscle_zone = "triceps";
                        break;
                    case 91:
                        name = "Dips Station";
                        photo_path = "https://lh3.googleusercontent.com/tU-Ir3GttLI-iqyBgNsyVQlhAgbs4rqS9w6SkdGhhwQhzJjfDnj6v_xYqsS2mcTorscjqtTYZOoXsrIOm4DF-MooMXWfMrOVbA8BQ0CRbDWreNJUAM8RJjcjX9tvffPOQOeGHYfj4b7Wvz0XKkreD-6vDsXCuvoMESzug-lZ7KbPibb5DDb-zZ18_skD3bSfzhgnlBCfGBMzBc6eA2hZ6ccWOefrWoIMaPRbcxHhIsdGl2WT_xzKrm857U71Pg10E78AmgkCuPJXd_Wkebvvcs-Kl-p7OxQwXqNI6Fz3sbhogNNMjf0P35mNxMkgrwU9yD3UZWWnbqKqtgBTgulgauGydY3zfzSiETLF9oxtWvV1ndb_HuGS_foRF0R_qesJWfs0KcR4AcDbvs123HoYqT8N5PK3TCGcVPrU4DyNmJdnOV06eVKM6FPlwfF4FNq8EdtqVG3VcDkiXfP4lkrcFzqZeElrRBgP4HpDdxxW2OoQfq2xcpa-5BVW8J6VORVXuBhfeVyDmHXhSp0lzw0-dR2ZJQQ7HqFht-yTFPlIj48nzQjU5Gt6UFGvPxXlmieztjYyQreMehm4Io8-hP4l3isasb7vZQn8teNJtKGbRAPeeakboZMjFAmNqsb53MFDMkeifxTxLkZF5vC5oMdChwba=w713-h632-no";
                        video_path = "https://media.giphy.com/media/1vZeeiFVQqa5Gc2KDp/giphy.gif";
                        description = "-Movimiento en vertical, sin balanceos ni adelante-atrás\n-Espalda recta baja tronco con brazos\n-Movimiento controlado";
                        muscle_zone = "triceps";
                        break;
                    case 92:
                        name = "Flexiones Codos Cerrados";
                        photo_path = "https://lh3.googleusercontent.com/MNOHVA0mxbEn0ulgAEeGZYanTX401y3u2ltMemRTPcYI7B_LKvB8FnrBW_r2wUaJrq0YgGbMlwsWwhTUXjqPs85pUYPCFJGq2mMi7ihsv5u4F4snnpPxcYCQ6lnnX-Eg7uhwmj4CfY6_gRK7WJHa2wC4UBaJt7_Q_IQuDnX3BbMopJkqSIiDvoHb5ZpjqFO6WxZ6T1mp_THBuhnOWTIQNxTrsHl-FR--x-bF-V6ZEBnuWNhjuSVWYkl3KcHHB9LHM-jSxcbFF_3Now0qelmrpZQGv_deTzAmdnysNCOfYbj9ryH-LrkmMw_v7m51XnpvdMvZQmTYmST1HAXF-KFiCF1sTQRjn1BiojfDs7OGawo78_ednYfv2Pi6LR9CYXQtTbdcQGm5vR22UlNWoldBuYPW8LPYP5MbWWwOrzYWzaVODDRQ8Pn_xb9uxk-ikIBgC1WmUuaXfgVqMAZSFo69dAJoF37_e-P1PKaqepGSr3UJNCNeD38e3heg0Mottdj2Csj3lz3d6HjlYzKDSq8hqDKh1VJlqIB-fDV5XRKh5pYIy2spzG4BvTPtlPFhHlHE-_TsSRv5T0LQkW0s8GFdFgSkLW28RcpImBCwqpbrsIqwdQryEwRaJJCwUpHunQKder1bL79554CRBTJuKrdEussQ6yrDWRzDiROUt0NhFDOwIZb_fjyvBTYs=w713-h632-no";
                        video_path = "https://media.giphy.com/media/65HKzH8AxXEwHK325v/giphy.gif";
                        description = "-Codos juntos al cuerpo\n-Manos un poco más abajo de hombros\n-Cuerpo bloqueado\n-Movimiento con brazos solo";
                        muscle_zone = "triceps";
                        break;
                    case 93:
                        name = "Flexiones Manos Juntas";
                        photo_path = "https://lh3.googleusercontent.com/MA5ABEQ961mYt8SzkA8Z3gx3LgvpzqB8qheaJtpgnlXyi8GuKgvUtY8KH8XydhfMdG2yWB4Qy46ieySxScut8t-7oYWNXfUTzMlIqVWOqNgWETuBkNSR67EU7XrG7ZA4cV9W379oGYsl7Z3F7cnX3LzRpzWkLgEX5u7O1ACMZoBNSQYdFXKk3B9qP-AE_F80Bt8EWbY_fNd8U2lQvgG5CHFe9K0ZciNry9CWGkFeFVNl6fy4emlraSiipL4zLY-t33XzCsjb_BXheXPNnsLrnqvG9j26pJPrZygp5rOva0t8UQ5t9gHWUNtj4wiqloJOoyMq75LyFdAVdtvoUTlMZbRggOqLkSlMStDzTJCXpsDJan0QgCJ24AeSRj7RMlOXWo49ID8ywpKGJFAyJBo08cFrd1LxBRK1ax4f6Ix8vHiqWuzBixbvq_N8UZHi6LNK3j64BN3eWUOjSjvxiAUwFovPSV0YLPC2WekBwhzLNr93ClEf3kqYSu1NoC9w3qmCqFFOnzRJo_wMhL0lOEduOi0m8cFki_zGqu0psDFqt9MpHSvp9-S4UqviVSrYAey1rREYl5eGZ8ZQBqZDrTPf5LhnU-bbQzB3iGsAK-vlszshDzAQxFOnRXp3vh9pLpy4L6q4mGk0VsZUJahUYgK5HFp9LNq-IxED56NrJbm2PN2kU2N5VXBBFPRL=w713-h632-no";
                        video_path = "https://media.giphy.com/media/1APhNvVCzK34T1MUj7/giphy.gif";
                        description = "-Manos a la altura del pecho juntas\n-Codos posición cómoda\n-Bajada lo máximo sin forzar ni tocar manos\n-Cuerpo bloqueado\n-Movimiento con brazos solo, equilibrio";
                        muscle_zone = "triceps";
                        break;
                    case 94:
                        name = "Extension Polea Sobre Cabeza";
                        photo_path = "https://lh3.googleusercontent.com/Yv-oKvjKbaOsRCmJAN2TjIleyakwGX1wrW6qNQt_-FAaWLcXopgtuUL6KkMwfYD4JmgcmWGrMwnrVNeKly6ACfDpuOtzXaFdS3SuJf6VDl5lqcatI_Zlerjf9gTglinGQvCNqqWLUjgT_LoGiVDMI7IVo_y2lVdsEyqIWKt1GAtpXFJaDBFYIJV0S_5Z-CiqAqm-rj4zaIAJXFaGF2SHC4GWIMYM-jLze0JgKMl9P6LsScP0SIkYmDr_WtPho-lUcIBwqb27n8we2WWmnWSB4d2ym6IBicSMnklm6OuR48fG7-WDJcfRoa-nL3vYvVStawYqFT-ysYvNQnzFcErJ0Lx1iJ9dqoegebdMyiYv2aYgjqJwyurT6Ub_5le5Kay6iCvSIP5dwXQKS2P1wl_s3_ZiB1VI8SXISzRm8ROHnquYeJ9CSmXzFkh0qzBhCbnpOJt7v-gausTpw0Aa9VZktTv8bNKyvPAZrty4UmrSwxuB8YaD2B6TX11_Ch6DFAqBUdIcWMe-sZyXtHiRjCZzm_MGKpIF4lWtPd_mTosMNP43nEJt7XdPnM6IEdp7n2B-BjQNQWUUYXdoU-IMGONOMce7IiLgo8HmbhF1WtU_7y5_QuXcgOuYEvw78GbiDoZmuW-mL6nhLCEraAGh2cRHXVOumurtQzVFyBLnw5IQuQw9qzOtgb7eJskW=w713-h632-no";
                        video_path = "https://media.giphy.com/media/4T3QGNq4wA4pnNRjIv/giphy.gif";
                        description = "-Piernas semiflexionadas espalda recta\n-Codos altos, se mueven antebrazos solo, resto firme\n-No dar tirones\n-Bajada controlada";
                        muscle_zone = "triceps";
                        break;
                    case 95:
                        name = "Extension Polea Manos Abiertas";
                        photo_path = "https://lh3.googleusercontent.com/yc5Cbn_RjVHo9x4U4cbCZcBZ_U4RDFAWGug4zvyCNlx_nuaHfCc5BadxaWK55h9ph9SlU-8yZnoBFuVl2N8OJFen5vQUjFZF90FG7hlT5o--S1rEuw4vA8hqQAvBjCq-GqOk-oYMuuX-v4q8fIAxyNYOLkvxYmjKoVzjVRsbEcgo5g5xxp9_8xn_EZVflDSWlSEidq25goAS6rpoLmJeW0z4M4hLXLkT5x_NajQFrbsxyUE0TQ9tNTgcIQnA6Svqk6-PcqE-Yzcl4l00zUkhCOw4Z1QVYNsGgKhKtAo4tF1UVNeNuWMmP8NRJyPH-_Vq713cchDarC4gK9mFMn4JAhZfM0cHUDvVJ9TN-fj-Y4OEqxiSHWTh5vrZu7ySn_a2EdgxoHcIRXolbWmP4_QfqSFaX8E2zYJCjdjxhGPNDnsvNQdYMF6pLPpbQb4FSHa4jmAMip47kWpd67xCr_R-XizCmVKywoN8D3QKUsaVu7zeAs9k3MppcijrFzKqC8jsHTvLAuT7B4iukcIeBMKb2ePWM3QCWZ74Yls6IGD3wi3ZIFuacu0Jm_fy8P23W6zzXUJLij6pX977As_ZgePY1Lay3uT3jEY3Yhqe2nixJXs5LtCasWdCDSN6cdw1CJYR5xZnvV-Kfb0cwFKstrNd8SJz2_WyqqDTgylWnhzLjhdjr6F-8EUWD8Uu=w713-h632-no";
                        video_path = "https://media.giphy.com/media/30pMgYTJWUImJK5ykv/giphy.gif";
                        description = "-Manos abiertas\n-Codos pegados\n-Espalda recta, piernas semiflexionadas\n-No balanceo\n-Movimiento controlado";
                        muscle_zone = "triceps";
                        break;
                    case 96:
                        name = "Extension Polea con Cuerda";
                        photo_path = "https://lh3.googleusercontent.com/HffjCqBt0kiYf_2NLOLrx5-IGMvK3lsA207ppkSjVuVNZ6y6xSWL6MFlQSBZHtkldTRDqIG6FgTsBGLBKsJfY6-0NGFqaX5_sb58fNwhDQwuxGznHKLnpBriy4-Lk3GKhDxOTVlrle1rdFBGE3sSPOhzncdOiH5XXzPnjTTWSiUihyKWyZsoeI6jtMfLKsBmq2pdvuK58aG8cvkBMJnU-JRZmF4kvRzGGlS0ENbs1OcI-oV8ujHD1w57R3rkF2XE4dnSlwCthIGmaIc23U39KgLhmWFzLSwnoLvvXMVFs7gmaHSVphoFLfCLB3mTEFzKkbDlNpK719AUC3wTTkUX8t6V3qwL4V4YGVA8h2Bu0MVHbkrYFzSSNs5kCDYMC90_v012zb-g3UbviY7Mdf7eijT507-QeZjlYVEL-rANkym_K82uWshW2Q7FvwXI4IK8_9hRHv-NL4RcQIUI5MqhApG5v6g-4ypZBHYaMeR2ZiUOHu6GT2xHC2Ni1rM4b_ckkDv4arNfRrwbjkABajUjGUd9AfosevVWL3cj7OrQePIjJuuODL3N52smIioEu7EcxNCFmblLahEwEGD2G2mLKcOA1l9jBnkVARTyQ-NikpRADqcFwGzOCYa_rhUIkrmn_X6F8daahE3lrO1JTB_ojQkHXuEARFgmqCMaZoJVBezHC3UddigD0R6N=w713-h632-no";
                        video_path = "https://media.giphy.com/media/1evEWqg2ryZyKK5WU8/giphy.gif";
                        description = "-Piernas semiflexionadas, espalda recta\n-No balanceo\n-Codos pegados al cuerpo, se mueven antebrazos solo\n-Movimiento controlado";
                        muscle_zone = "triceps";
                        break;
                    case 97:
                        name = "Subescapular con Mancuernas";
                        photo_path = "https://lh3.googleusercontent.com/g1AKein2o24zM9YFET_zxHXJBlsBl-osN0Jp4Unx7dHqkxfL-tcVi_I5xmoCqpLW22D2zOsvx-tHXIeYW7bm54dBkca57CjNexmZcMIuPs31wQK6U2djeg6b7a_m0-kEJNEGpUIUGr_UD6ZSMFFQT-DLY4F0rTwq184MbGiWDbTqAUOOoKYcZS5j0jDVIPgHIYU3iQf8feF4dVGdlsagCT-OhsBviC6tgUdAuIpK2gixk0tbLI-Wb20lxciFI3Sj57neP1oyQPXOb5V-Vmh2hMWgeu6PA_YC_6nOsvE0sdAn2AOzVWyS5RXENVOyXlQR0868a7OVPuaroB-fqcDfopp8nUfJm6UyIQuJS0N-rRJ8Q8MiXWLezkq2Lz3xWgZr7O_wX0G_u-zZI2QcZghShk-Mm-2YmReHJboQJooa4sg2SdqMN7X7LOMgRdgD4zz9GNrXwWCxZ4SqjYopNG4_h40TjRKATGgM9YHH7YWTSlo3KjXNk8OuI21HRM0OuTQTIEyuBBeTrrAwNy9vCHTdAhsDawSvzWobJBBn-Cx_PSrZtf2HRlcGFsVJFmX10nVoldXThABVOh9OzBbavdgacMd8I92iTFulew7jwo7cgzaDIGkVqCtiq-xSEytf9RYTOtgw5ZIYSWtgHENggQhYdXxjosS89Wo-O8Dg-2bHqvh2QkeRc8R4x-Xy=w713-h632-no";
                        video_path = "https://media.giphy.com/media/7AaBEKU1cl9afRe8Fu/giphy.gif";
                        description = "-Codo y hombro 90º (inicio)\n-Subida en la vertical del hombro, brazo estirado (final)\n-Movimiento progresivo\n-Cuerpo cómodo, de soporte\n-Movimiento controlado";
                        muscle_zone = "upper-back";
                        break;
                    case 98:
                        name = "Supraespinoso";
                        photo_path = "https://lh3.googleusercontent.com/l_SN2rNTRjb0NarWclH-JJf8Sn4I7mc8XvtgTvenQk3mGOZP3ywwxLvVwqsU50YHRvxnCrHK4iY_583DlX8wzLy2r8WLdhSIdqUUGg10k5I8fWC6hLN6UX2tow88af9JTrXbMnO9r6vnwHAyd_G-wnvde70X-p-gqkc18Ik_JWnhwJhcVaTsP_dNyA5cViGX0YSsCKJkQGuRiyFJXh5x3bZsNu0ERA53OuEwL_oQhPgNB6qf6oUeLOtHYv44fK0G1AcJHLg6VvoKcAAg9kcMQxAw6PIy76iIwLrx2tWLSo82buuZNqdm8EbnCjXlT8WUYOUtHkd5jDPLeOaBy2vmotgTbvGYqac1FExcZdaaY7ncdHWOdWoEWXFmhzeay0YvDaOrPXyDFjb1DPN7d4GSB0XNCoENJv8yuoDCT7mAnn9hC6U7qKzhvBRkp1BKZj7d2JUhnJfAtRspqOAlP40WnbSv6SclLGoBhxLFD4nahmonfGAvZqd7E1g0XH_4TJ1eV_u-1IdRHNYjGgj0QKW1dI_JcVmPzFOsK8sFtnJaC0i3I0WTN1drAgRNYMvCgulAGCN_vAJsesCWxXbU9xiqzNJnCM_IxP0Na9KKU-JenOsxKP8KenmSk_2XVx2ki_JO8t4fNb40RANgbOVrWb9Vq4Bum08Fisgi1dNvGtbEas-IZ3QnPdSS2yI_=w713-h632-no";
                        video_path = "https://media.giphy.com/media/QmDnjZzM5DDVj6zmlz/giphy.gif";
                        description = "-Subida hasta los 45º\n-Brazos estirados\n-Bajada controlada\n-Movimiento harmónico, sin tirones\n-Espalda recta, piernas semiflexionadas";
                        muscle_zone = "upper-back";
                        break;
                    case 99:
                        name = "Kettlebell High Pull";
                        photo_path = "https://lh3.googleusercontent.com/uKArmM218BJ8xmuEv1YSsk84uGrH28hEwz1II2K3SdUjR7nS2hrZc6Fp1D7ZLGbBYu05VVNISV-2aMz-isdoaIzzZjk5dn0KxkqSXsf9w9wV_eqVJLr-3X_hsAoatGXl0hzIAN-j2JeKXacEaQDk1QPch_OfzQ7708i0BoniZVSYvllkZ9Yr7KxHrZq3cO-nxQOaUfgEZmQViwerVcs9JhVp0hsF71YnlHiB3AkoUidS6_uDQVAbBM1ewMvtGwFn7TkcArBwMUdovneH6gqhL7ZitvHMoL0mO_KV51IZCmiAuV8KT1JRFLfugi5pRPAkZsU-nVimjl_1DB0B5YwemEOorcywIz0u9cGea5ZJh87J4lCe_EYBgup1W1IWvwIul5IBs7T3uUCjjQJMOi2higONhnz19XlHYtK4BfLtzo7WjFQY_k5OFMjDHtqjrfAlKAC9mX4DXjMzkYkVIyo57N5xXQ3M7Q13VGJx8xwWINwiAwqTgG1MPaB1-buFxJCnfzGRJko_ROOujOvbWk-DR2YjNnCHjhgly_Vm0l-e33021PTmBKFY_y_3lEmz3RoFqq1iTmOF-US5ZtxIyOu8jpSanafIMMkvsVH3hZGtW7PNQ2FyC1Wx7SQHjDwX1_R01fZs5LvScZWnAJteIlptt7D2PbGMz1veixgHb5wNZcqYxcaaIxHBDWLq=w713-h632-no";
                        video_path = "https://media.giphy.com/media/2fLcHUDvzGKNS0X8QD/giphy.gif";
                        description = "-Espalda recta, piernas semiflexionadas\n-Subida en vertical, codos suben hasta los 45º\n-No balancearse\n-Sin tirones, movimiento controlado";
                        muscle_zone = "upper-back";
                        break;
                    case 100:
                        name = "Infraespinoso con Mancuerna";
                        photo_path = "https://lh3.googleusercontent.com/kAWtAeZ_olI2cfdX6K1-MxoDSRP_tmSwOsgT7zyk7WEv_q-MlTdcW6VU1KiBh_i7nRciYO5SotT1sKIk0f62EU5totRA86rOSDxki6ButmSLFai_jh1fsD2tB50SThvPYDo8rRWhRNk8j6yo_gwEnTR7sbfXWOO4qv9enO0N7auhcE3JAyECMtetffiqA1NWmUCVzEo8rRtCRhwKH_GfzxE1L51NJg2351_n4AVpDDxrz_bUyqgHqd7lWt-Pcug6CFxD7SvGOshgRAojTZWLcTsRLjStdYCYR_Djv3mtTVxksgjabyPlMuqbv8N8wsgEhGcvsPJRE4iPc2oVXqTh6-49-oVIXOVxvgbkzV93uRiw-DxLLfP-y9pD7qdieu_coAtNoFP9_QCs6g_MofIVZcsWFiNpxxYw_ucf97zjSGVdmzIJ96V0vl9C18pJXXwvOuWx24j9B-EEJhB6BKKoKhvonP9iuVQe3mA7nqguQg1GUUHf21SuLyRFqWzVJYD17d8InBTz83g8xAbTFIlNQm8SrGj0pj56hWdP7JnhkVXvk80koC3ksYm8hBxawv0ZdgcDJjXL8-bZ9VHFYC3qvTEQ-el5NOWslDr-e3G6X5RAEtlQ-uuoKxEzMFZgj0tdxy6Kr1OL5FWhBoaNClCEODmPELtaH1vhJgDz0J7fSOYMOnKO0FuEVNXE=w713-h632-no";
                        video_path = "https://media.giphy.com/media/1gPyMEAWqjHXQ3siW6/giphy.gif";
                        description = "-Codo fijo, brazo-tronco 90º\n-Antebrazo sube a la vertical, sin perder los 90º de codo\n-Espalda recta, piernas semiflexionadas\n-No balancearse";
                        muscle_zone = "upper-back";
                        break;
                    case 101:
                        name = "V con Goma Elastica";
                        photo_path = "https://lh3.googleusercontent.com/6X_qX66o1yNI9Dv62rSvcw7E_xpbSlvLN_Z76OtMoYQZsj9j6cSaiU8S80mi62R9lqFMWOX7pCqxb4OxyX8g-UrpwWjmo4GJQkODYp5-UWL3estEyc7d9D_-fYNofJYVd5beaHg1nbKRLe28UvovKGq1RcMk4_HgmOPh3wUFd7DA_RaqiPCPoRKF6Sf2GyQhMiWoQTMcs2WnOwBioWa3L6OTVAGfTH_2L9ERFPmb2QP-YeVuQHkfibTZsQl3CF59-gHTL3Yns0P2Pzo0SnL69OlH3onqrDMb12ov37EtL-3LqzsXh3KkSK2817ibxhXbJFN7VdB22xVgSFy1TqiE6obZesWgAOqRcGqI9ygv2AM_-8tuuFGPLkqeiCmq0Ar9_6zypJdV2OyIRqPf2G8nDDx9UANy4WitYa0E_AeIJzNpzZyrOpYBPQURaKN2l6Zdh3xM34T-OIuEwIjp6QndJic4CJxNp24O9V7LBtwpJF58U_YNPnFCgZZVTpsafTrirsaSHkoeQRVvDRvXSbLeZ5huj56gTRZTd-ArazAFbTHZGqJU8b8Vif8-m0BZb2K4TmuENRA6Eia6oGF8WaelMdQTj6BaPzXChjHXbvgyFxZAmbMZqITkCFYoYRY5pXXPkZJC2_uzMwOFIMB_8wffn6e3z0fRvAZ3Or_wjsQsyumNwf7nZEj5_8b4=w713-h632-no";
                        video_path = "https://media.giphy.com/media/RKoK1LFOXbYZsM1MwH/giphy.gif";
                        description = "-Mantener ángulo de 45º en hombro\n-Codo ángulo de 90º\n-Antebrazo sube rotando brazo sin perder el ángulo del codo\n-Espalda recta, espalda semiflexionada, no balanceo\n-Bajada controlada";
                        muscle_zone = "upper-back";
                        break;
                    case 102:
                        name = "Infraespinoso Goma Elastica";
                        photo_path = "https://lh3.googleusercontent.com/hB4dHmYd3bj8S8GuArEWDQf3PeoQ0NHkEvsak0deFHGKQ0PPADgONFz1FPIau--wa36ktJlCB-M5rfvy230jbDlnScpnxUkQdZTDwRGUxHLQF2t0ww-eGlCBFAYOedA9TL0iHYT0ggsi4P0r_HzOwhm73YKdNpLyDGKU_-gR1uRp5THMif6XD_kKx2BHA4EMqo99u-M1IBCSw2WBEL4m3WFspVp7O8GmRrDmr9OKSfc8e4eKSq23YM2Bve2DNVCDPkEgN07d0SXp51fjWDHp-isaVxFJvYuDo-xjRQ47kRu4egEuUQVzdVnUNjboY6R2s1Bl5t-qNUyK_FR8SZ64E5fuBIRRZzGl8Kc8ACcqBnkf6qRDKrAHnCc6Q-Gyh0PHb6b4Qy9zLQcakPhzNTWl7u17KorkIigLzDN6BaxM42kzWpL7HlHagpOCSLKaDQAk8vCJLabWPSJW-s8uqIUcMRWQJJDWZgGKYUN4vRNm0-N0ryH27FwGn-oqEGl2GnV-IwPlY1X8W0YK8lA6aFerQL8BWnzWO_ILA2eiS0xIy0IzAwTrFruRIO-m4OZEvU-bns_6A_9n8YulCWpza-MZkttGZbgLjmKwmmDDgNUgyapXVcPfaI9Wq4AuIZJWW09fyHCI8xBWuiq2xXkEGXDZYQWF0WUoKjFCE4FaV-d0XCCeP078Fk5-g6NQ=w713-h632-no";
                        video_path = "https://media.giphy.com/media/1gSpNbE1v5ULkNNXwL/giphy.gif";
                        description = "-Codo junto al tronco, codo 90º\n-De lado a la goma, estirar goma hacia el exterior\n-Vuelta controlada\n-Sin tirones\n-Cuerpo de soporte, se mueve antebrazo solo";
                        muscle_zone = "upper-back";
                        break;
                    case 103:
                        name = "Subescapular con Goma Elastica";
                        photo_path = "https://lh3.googleusercontent.com/OUXLEojbdLdTYpozHqm9LKv6yptF1TttYX4MrQkuKRaSbUNH9B3uhSLFbTr5u8MhRMJ616GTb6ERAzFJyqUUHVVmwXuL0pygIAL4zzAZc3C4hVctX0juE7bXJQFAM6I5x4HRrirF-GcfGJrTw7rwac3WwSXSDEWBwzcGW3PTRMOgDzaINhr0iUjaKOuPlvwW9qtlWAx6p286pfvsgFfVeqvTsE5aXR5otUp8v89rfDJbn0dJSnwoAGoRj2PAduzwkBus5BVWtXsn4-Mqy5mb2GW2J3sL_7TbemyIIj3oiOWigpGiAQXj9ZZ99CvbAHIGqAD9gQ_BIsLt0xcvUMJ7KUDx3ZsAyzMfzl7BMkORFbgMJJLuZdT82moCfQ2VibgB_8jxQ1h7UJ7WvT86ODRTKwEugcywfuous52bIgKORaOi-6NyhTwBDb6TjJbzMU2XGAghBz25eoWBou6RIsuplMY4p1N0mpix2pIE7JoypaGSIIvmnhL5sgiqAAhMYOztsp674Hbmm7IIg6mreS7Ulv9YLyLRpNjH59etI559qu2gN71ypWLMIGi73m0LJgmLTbno4T4AZ3SgMnuIXkQiXZ3abuZqg8HZP9gRs1vWiTO9Qy3syOIArZ8dsPjvpv3pMlLrimJfPF32TYR_yjFDziLTMkvn5BoqnVFBWSUf95QWMqClX1U8JRLe=w713-h632-no";
                        video_path = "https://media.giphy.com/media/9A34Cep8gjmptKTkqf/giphy.gif";
                        description = "-Hombro 90º codo 90º (inicio)\n-Ir a tocar la cadera contraria\n-Movimiento progresivo, vuelta controlada\n-No balancearse\n-La goma tiene que hacer tensión desde el inicio ya";
                        muscle_zone = "upper-back";
                        break;

                }

                //insert in Exercises table
                db.execSQL("INSERT INTO Exercises (id, name, photo_path, video_path, description, muscle_zone) " +
                        "VALUES (" + id + ", '" + name + "', '" + photo_path + "', '" + video_path + "', '" + description + "', '" + muscle_zone + "')");
            }
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int idx, int i1) {

        db.execSQL("DROP TABLE IF EXISTS Exercises");
        db.execSQL(sqlCreate);

        //if db is opened correctly
        if (db != null) {
            //Insert 103 exercises
            for (int i = 1; i <= 103; i++) {
                //Create data
                int id = i;
                String name = "";
                String photo_path = "";
                String video_path = "";
                String description = "";
                String muscle_zone = "";

                switch (i) {
                    case 1:
                        name = "Curl Banco Scott";
                        photo_path = "https://lh3.googleusercontent.com/qXOn76A0V3vvjW_BNApwrN6UQ7wWtFhxTA_NAzC0b8EhA1QQBUMhlfwewS1jSm_u6MwmqRL72NgMcHmBSCgz36DndbTyjCuBHTLhxn_qT06yISnO0EKGxSukGNhcKiUkRJZokLuPIWDaeLuG-XiyWwXLabYxGrPMRs3EtzhNJc-vSiTwa9eWIDV0T7ocCcE91iHejJvspuqBCNMvBxPlEvu5HimGf8tW7I03KrhKOmVKU9P0xUl58TpMfUKfbXwtF1iHJ-Q5iuzbe-opm1fLJozz_zsfV5aOxJA70jNsL_N8CAO_2ldea_YUBoxsmAtjmjCe9mLEql4K8gN18GXkXoYf8NTKOl5EUmzodZPOFepDIg9yj2--Au1O5ouUZevHOFmp-uid-EuLQzHF4jZh8tOVF00WC2iFNN9OSDaZ_aYTUyp1ojaBYnRUdBHquY8ZzaxOoqXnWVq3l59hU6WHfA4S7T3XAiHNtiHYYIU3XiLwBVIbyRKPILjTxbiSuYBD6ias_Z3HzwiZZybOjOvo8pBKr4yVvWEeUci5UfFMheQ087CRUbWRCXWITf1vJKEzvp3VW3hNHnycXwb8tvYiQeNMRWddViZkhsv-zuZJ045ZL76mmP2JXYpIwa6oycwdvBqMaUAfq4mdl8ba6PVEh21MVGPEOhDUIRHVxSB_q4LzSjdHQIzbDvXa=w712-h632-no";
                        video_path = "https://media.giphy.com/media/4NvfWAwJOKO31HviTb/giphy.gif";
                        description = "-Banco de 45º\n-Extensión parcial del brazo (bajada)\n-Codo y hombro estático\n-No balanceo\n-Espalda recta, piernas semiflexionadas";
                        muscle_zone = "biceps";
                        break;
                    case 2:
                        name = "Curl Con Giro";
                        photo_path = "https://lh3.googleusercontent.com/9dX8q0rdbHl06S0zybhrOHjLBKqcQUSX9WhsulQwYXj67ZBi4Y28XEaP3UWvBjXt8fJu61ghRRYwO0i71bvzbNvc8j8RJ4B8dK2iXnddoyXOg0-hrG86i-TPSzbDS1TIwKyV4nMcMg9uDADyRYA5eRoko3ZyxZP2zB7rGJrxlKw-dVgevkmNSU23l_nGYXgIbOlwVh9qif-Fbugslj6Ueezq4FnpPTBwN12e8nFLjjlnvz0km681FY8iRRZ8tq41buxY5HWirmkaq6iA5nkiuCzAWcYb-9hywHRJpbgzdpzSoajYMQ9JQHSdFl35v-Z7a7rGbD5uiT11XFVWTqr0IxLET3zyI7v9bEp5CdGuS3QePSNn4cnmykqnNyPPPP_YYtCXX06i5qhkN6yqA-Eb6ItMGQetWIVxtfxBnGiKkdKC4i4mxKg-MMzbpT67RFlNtx6CJssLx9AktH8y1OWpsJWizX_8hAhCa79ym9zbWe7frrZptGBnPMg9ZMFZSGMWUl1E4fJ_yg4I8zypV6AifPdVl1haNPDEPuZNL5Dg4cEhPY2WiA6yPMg_vGHVzAPb6SgcvzLbTElY5x5QEv-9p6DVv8fF2jCQXpKnVk3pPcbGxWBW8syFeWmx1ctjTVfc9qfHWgcSmUnGaFJxGE_OFCRLaFOpOLW-JY8Gmacp-Vy0ML_MAURzuLAR=w711-h632-no";
                        video_path = "https://media.giphy.com/media/SKOXeutd8KJNiXTyEd/giphy.gif";
                        description = "-Palma mira cadera luego hombro/pecho\n-Alternar der-izq\n-Codo y hombro estático\n-No balanceo\n-Espalda recta, piernas semiflexionadas";
                        muscle_zone = "biceps";
                        break;
                    case 3:
                        name = "Curl Concentrado";
                        photo_path = "https://lh3.googleusercontent.com/lzAS7j1jzb76P1iit8soZ3jkC8aM3CBlfspwBmRKLTXyfDM4iAUB0Ex3He67u99cPKhc-zx04xbdahxGcoWQOXTckfVBoKYCrvXGj_6y8SykG4mnnIn76qqlZTh5Dpo_cGG5aKWKtxkiIMEy7fyfUnJs8yAXi9Dpgh7ILLRqzGFSFUq_UKsPECmvxTsGqBgsEFzXE99J5lEJEd0Wf8E9yo8GteNSS4A0CC7ihh-cfNhKswTLlFilxyNkdIxdUFLeGt9wKY5LgYGf4WNoFjNuFklJirSTNynjFwGcxVOrAH1sf2rYg7Pcye3plGKAixTC8bM6zv2wnWRVkD2xzNnFy4Y2dMmvJiWfSPVgU2L010KOH4ij6lUsVzIuuPrkC4agB43Kq9c4CtYVLZdYHzZDKl1PCkgSoxuVsitaWpul47gy736LNqVWtshk6Dvy6LeP7MyHJzUAJeenDuk_J3nVdte3Igf0TRh8C91egYhsgB0kFViSgg5CYvLX4TSenV_vtm140wjrcqHFYwumOLmccnf1Cp-QEYJrf3_txpGk5o9Mxo0ggEoCByMMukqE43_RmWl73fgF0MRTKPeRWNnCExlRzOMNchof70Wod-_fjTG6XWrx21_tXXV85u6D3q6WnEWlLCutYb3-m5FCP5Wum-usW6R2hszQ5y5VtMpSRBBxLUrzGDp9Gzz5=w713-h632-no";
                        video_path = "https://media.giphy.com/media/piPn7NTBIV1QEmmnbW/giphy.gif";
                        description = "-Espalda inclinada pero recta\n-Codo estático en rodilla\n-Extensión parcial del brazo (bajada)\n-Mano sube apuntando la otra rodilla";
                        muscle_zone = "biceps";
                        break;
                    case 4:
                        name = "Curl Martillo";
                        photo_path = "https://lh3.googleusercontent.com/-GhEB-qYcj_5hNPnDJDE2yd5gssUYbj8PzRp6IvkYEesl65qepfNTQnXTDwH_wJpXzCbis-1IIfSw_Sd3OvTkaVMYLtSpm0s7p_JTbLu1f2RmKv_myRPTI3qHlVfr6TAv5hCJxDTPBbzB3fDUKSyySTcAn_9ceyLMk1MWRY9hzhWbsfNipsQYI4CnPgOvuXUqnxWwR3vr6UjtWHrgYnc_DeJoM1uvyaEPqxa4G7PJbH3ih8GfW3RrO1Mw6PDlzP_Scinm0pZXnVBAXrvEaI6D0T3h5jg7VKvD-tUIhtQW4K-UYh70uYEmt0Q-DWxsnTQUUtq3d1y2NtpY8FDDNmrp1xm1FCYciqfdeBqdPuBYZRNfrX_NNX_D6R2HmTV-cDn5CmcLlcJbxJAdFKKLn2rZWC5TpcjDp6sZebgDvgg96rrjXXnEqazMK21FuhjGMYTLiH3kaSXF77csKpyh0_1YvcKzjwEtkageXrqtiz9xzVzIWdIeEZb0VxIOcXtVtbixOzDUu3sIJ_bGPwXYVtRlaHSHXtqWBoO3RjSAJF8_qBK5AMyl1DiaCAgpUKeHuKhwh67sCtcdN0DbrsQk0R5pc_FPSNTdhqtaQtTQbbD321jnjSnaL2_KXf2WBkLE53w04-LAXUhOvm9VVlOoZs4__eDcStt1ekbpCnYVquRRI9T0pu8keQcfC91=w711-h632-no";
                        video_path = "https://media.giphy.com/media/4PUq7Z1xwozF0FuLb1/giphy.gif";
                        description = "-La palma mira al interior\n-Espalda recta, piernas semiflexionadas\n-Hombro y codo estáticos\n-No balanceo";
                        muscle_zone = "biceps";
                        break;
                    case 5:
                        name = "Dominada Supina";
                        photo_path = "https://lh3.googleusercontent.com/VBU6-xhVL5LwQTp7U8Iaj6ompCpwtub35k_NEoirLFny7JxAD1y3wYcXREE_Dh0EGtGIPE6VFoXZe_r4e--0XM57AgxgC1Lv6L-C-NPoMhMc6W4Aln5ozgI_VvGcjXVrwACQRLyEA-_FNjHvW1CxKrwYGCVmEcfZFXN_xPMIJU1DekGUELWNu7KUa3Py17CZ_yaO-1nI5gWUY1F5Am0Kb57FxR5gxVPZxp_RBGLVKS4HKQIPySZC17B0X5xmJPUagdoovZbZySpf9fjXtVMzU1rTP9DMJLJXResKJ_n_2fdYU_M6MReRmkG9Yfd-7Q0_5tnnwnqJavhQGcRXm26N5NuZGUc8KaW8-ymVGBvmHBLybmuI0-nBRRhp9nCV-cHw8KaDeInVyC00M8t3UjpIfYB2i9kVaqQJocUmXB72s__m0SndwYW21DBzX-bAjBcuf34yB58omUmEjG_Uc62Q2VIi-cXBdWaOGzNgtP4lFQij3uZfBWpaOM93P2vA2cZ_vsUtWqIbxVmk8Hn9v_ipORkSfB69enGhquArBtfFr3COw1doJsgWXkoHI2UDuqL_78If5P0zudI6gJWbn8DLM5_8xMB1X5ZH3QsY47Xl7AcsSppUiCxdS3s2FaXKtd0IVqp2ZKKTRntjWX1CXMpUqV5-Yt0K1rFUCs6ayPDY9DXXEumfLoqzU6By=w713-h632-no";
                        video_path = "https://media.giphy.com/media/jxa5Kc03BqSQZwy3cD/giphy.gif";
                        description = "-Agarre palma mira hacia atrás\n-Subida con flexión de brazos\n-No balanceo\n-Peso lastrado o mancuerna entre piernas";
                        muscle_zone = "biceps";
                        break;
                    case 6:
                        name = "Dominada Agarre Paralelo";
                        photo_path = "https://lh3.googleusercontent.com/-qwHc8VuzGsK9YYRg3FZvspbA3YaWg6oLF2x7VRu3L0nSQJ6w7WQZmXHx6nnnbfmm9TkB0G6wGMeSL_C1X_9jX-n8rNO9bGQIONsz2RJErp23Sr7AVLKcK5LLcQ70mng7IAJ_wVydDqOvkl3zuZ2pvIwPBFkLBAIoOQMxsLmHD5aGOn5WcGRrpbFoFUc7TPjjN-mqbg95NkI8-s9WsiTo5oeoqyFjCt6j0DXhMN5f4R_F_AnlQ8YcT7cGj9dEcs1VZwkNNWGScxykqHEazxlx8aHbPaxWwQ7jhgQ0HuIXZ8itIEHW8RPkoKO5VaMR6m1d6r9GHFNeonKTaPCIJuxmSuZQzjiD4MK5CJpeE-5ao3E78Bc1qHCr1XJSKeCe_bM6DxBo--AxaudK9Le-s6niqS152ELc8GIoqd7xNF7tZHbrVgRPPau1IYyXCuantoed--llzUau2uwgglv6mRNbwtvoWjaQJ_iqekr849PCYBUIzoh9QYI1ReYQGDrMsS2eui0pqd-n9CE_W30e1urgEMdlL00_MhEG6YoR_X3RHRcW3qUZ12pVSQLZL68f9mQiI-0esKrcL-WEDpRd5HjkCOgWRk2gAT2ERqK_Cm5RRxPgi5ibAMQf7oIydW2s2Cu2ISpOGjvVCzeTmLlqqmwBBRdPg1B2OJoCv1dg8r47eZvka_YZRtbmCgy=w711-h632-no";
                        video_path = "https://media.giphy.com/media/9DjRZ2TELxSmpeytEu/giphy.gif";
                        description = "-Agarre palma mira hacia adentro\n-Subir con flexión de brazos\n-No balanceo\n-Peso lastrado o mancuerna entre piernas";
                        muscle_zone = "biceps";
                        break;
                    case 7:
                        name = "Curl Con Barra";
                        photo_path = "https://lh3.googleusercontent.com/41LuhekQGImC8YVf8WC8s4Agh_PQcTX7o8t_sLcqEfCdi9ntADTl3zpgHX61D0WKfzjz9mHXkieCqU5fn7LIxd1Dt-k6rS_d_s2yTGo0YACD774ixYjHH02pR7T2iHQZkJpUX2OyDi6dbalpQVR6ojukcv9IvMj9CHBLFvYodax2EIhrd-0W-BeWnf3oDo-qHACa8MAqNDLD38fBT94YA0PtqwOsh38dAC9d_on7YbQTjXqgE-bbYVT8xLOx__ua82NCQg_x3Wls8dz9x3zk1SHsB3QZJfXaUfsn40RQMVAbQn4l2oDKfcHBMRlZ621DFvg53dgASK6m8XB7N4UU2CnnD7TmgOnwzAWgw1tFkRSHeUVKhP79o93mW7lUYyWuEH9SIJj7sZQBk1aSwNjafhlo_IZelwGWA4jZ_z9EZgC6TZSMkSZEykZhIXPrtN69-gRVcwFkbsI0XG_ohEzmGYJm45_hDioiSDUPdBhz1EanZ31dQfLARav9JhqV_tXzAp9j-ur2KbsndtywSbR4bdkcJ1H3vnlhD9O9znO7n2kGUSDCV1U75Y93g9J697K7JZMtB8Qo72iYVJX0gpAEtGqIuCG-VYF6VDyo8JbT96Thrp0svF9YdNtFbc6fpUXagLJB6061RVQGCQV_GCdMoAPfl3tlhac7rc3FOfUuLm6Ec_f66dpPn3SS=w713-h632-no";
                        video_path = "https://media.giphy.com/media/1pJ7pWHYBQM55tBume/giphy.gif";
                        description = "-Barra paralela al suelo\n-No balanceo\n-Piernas semiflexionadas\n-Codos junto al cuerpo\n-Hombros estáticos\n-Agarre palma arriba separación como codos";
                        muscle_zone = "biceps";
                        break;
                    case 8:
                        name = "Kettlebell al hombro";
                        photo_path = "https://lh3.googleusercontent.com/gLHzktKF3T_FBBAC4iaelB6m9gQuC1Bjat6WRHXo1tbCgBTwwuuHpglud8PmVlGNMkmIHWj7Bqu1dgI3Q3dWeWJfOhNFDP9l4mG-hiUpqBcJNuJ3gy1ZYoF0Is1AHi1ku0XaNTw95_9M5zN3SsaiaiJDTyty4D9VqBUjL1I1CR7bzZ43qYQX4_yPWxpo-r5ovgN1tpgRhJnRBcatKSGxebXNZ7QK0cgv-B1HVQGwHIGWP6zKKgRlT_BY5XsKGPtrwSK69dc0HWJvM7nqVe_qVz_4XBpMwZNhwKR09D79pElkO9AiKQch4zDLoMd7KmtX0_I4OO8S6p47tdu3LY3zCgkXA77M8_9MkEprQROc3M3eBE2QU6HDnWixdMTDNptREbD4WFpUnFPk5tltXdgBp6tM10I1Yy67LBYhHJiY2sbeECOZYcF-OlaiWhvUwNBq0AvclLZmAb2HXkmGDL_iwK4msUXJGmvhJaujTBc5qdcAkzHdbOK6mpWAlHboqwJUBY-jwqXz1bFkqyKnjFzCso15QNOHe9suO0nhGOQM5pmCpu7I_G4b7Umb8H83SJ8IEpCr4FuYjX8kzV795XbBt7xutGyTzqROjoJy43q0I-CbCNsGgQKN9Wec9XhkHgDaDggPcQez-Riksz2qTm_AJAO19Ilcuf6H1_ZdchwHa-T9HUT1vd3_GdPG=w713-h632-no";
                        video_path = "https://media.giphy.com/media/1dIXM606KyXUJSvQLl/giphy.gif";
                        description = "-Codo estático junto al cuerpo\n-Llevar peso al hombro contrario\n-Espalda recta, piernas semiflexionadas\n-No balanceo";
                        muscle_zone = "biceps";
                        break;
                    case 9:
                        name = "Curl Cuerda Polea";
                        photo_path = "https://lh3.googleusercontent.com/QvXpMXs0NjtRIiXZnwU35dbf7uSugN_slFO9g75y0CsolA7GwZLd8LO-J5s-Jbvx3uqFF5YX7pxLzYBnQw_KtgcryLoVWWLXcCXNmRdLTj4RvWVPZmxfmD0BXlyD2mW2WNKGDATEzHGDoF6T8_cSFs5t2Chvqs6N_sHCfTxnixmEQjL8r89HPvbSFuz9QVvuyk8IQssufJew5aaL2k0L90mCQpPi82DnlMjuY46xAbGd70bTBMSmoqnbvYYXuX9UBV79JCviVznxo8eSTj7XGKTuI32lCF5Rdcp_Q7y5R7SxfduUhN8YoDjVcOC0MaFGWMWSUsXy5HXG_sBbUuDb3TvaygetDMjMIf4ovMpTTVFcICqGJmoqL_4Epy7jhWONYtKXxD_0Var_d3lb1SkgYj6JmU9CzvVIM09hLjWiUIF-pyg3hxs5s6pvgW0Q3lGem3FjQYj00rd9WBTbu_Fv2N91YMPLwuULlxBXm54bghfGTG8jpbEKrQBvqIjAU0Yoq6NmyZnbPYusEb7jDZsLf_8sZPbejFaFSdWAwxlvMru-MNg6Hfs_cbogZuQ0PBb9YELR5VITTLIbNPdFEgdr0_DjdNaejuFZnVh7OaOhMCXgmMffh8DZWAsDarNN28_pfgrbhcRqR9p2PWiuV3iWsDB_3JCAQk0LYl_ZAdcL5tYXkH1vvazEL8FE=w713-h632-no";
                        video_path = "https://media.giphy.com/media/euPUdV2YcfdRTET7pg/giphy.gif";
                        description = "-Espalda recta, piernas semiflexionadas\n-No balanceo\n-Codos junto al cuerpo\n-Cuerda en polea";
                        muscle_zone = "biceps";
                        break;
                    case 10:
                        name = "Barra Z Banco Scott";
                        photo_path = "https://lh3.googleusercontent.com/f8hV7BI_uAXfds2Pcsga-OoVT1Lv2acCSq7QTTigFf1YtXYu74PXunXisCWD81TRc7heC2RNqdFmC93TyDhcx4ba38iVOK-srSZgBWjBCCcGuLqZejntDiBfh0y-uq1wNet3iCkZCZhACufPyx1iAqoaFQihI5dRlYk17K48FFlr2vDSKb5w6WW-JVxUTbpGR1i4OPudManX3IIzY13qxaThv7BX9tFNw1bUzSy0P7ac2BUB_c0tnO78-acBo4dD3GIqk8bN23gFk27QA2cQqD4NmWGohAxnVRxrxOWpXE8YmUsA8lvR3JVxEAdxZXtm2m3_SceNDxL0kZ7-lL3M5DF50M31b8wJ-PI8tQt9atPQLFfbf_wBZInh9CXKr1OFLT6tUsgjN8t_SYkPR8O604SIOuKc3_fg80hhLGmG4fwzhigl1_3mbxYMYk7tG8VmZ2jStZvwfWNS8DvsDqhmb6PgY-TAXdfdhVfIPxBS0pxv168LuG7_8r7psozlh5fj8Dp2cmdoH4Oz7Hakb80LXSGiaYyfTxBtfauNVJSje9ytnpDmdVZcT-25IEAbnne62RpFxt7BYOItsu4SABkyhn5IZ2TgeTt5LUXHiLVxlAbFw-CF8yR9-aqjdNOwCww-PwKnMvixLmNolhVQRYxPG8dzKqlV8Tp3a4kdPlH3NGckaLXXrIn74J3l=w713-h632-no";
                        video_path = "https://media.giphy.com/media/9DyQyftsliy0uhIE8i/giphy.gif";
                        description = "-Extensión parcial brazo (bajada)\n-Espalda recta, posición cómoda\n-Ajustar altura del asiento\n-Banco Scott";
                        muscle_zone = "biceps";
                        break;
                    case 11:
                        name = "Curl Barra Z";
                        photo_path = "https://lh3.googleusercontent.com/V1ArPQSqL0JYNoa7VSVytEuIqXETCcsHLjPiPB0hWL__0C9Q3OCq7HGKyjI5FrxtUcfGVW168EMIeJvRkv4ZDrut3F18l_7iq06zdcthAPGSpCQ4MHQA-CJkjZ-QT88EWndmYJOBjKI0QzurE_akbYbM6o18-3HTF0JNKXgGPDBzfr-B4Z5wNAv3FCWYErCzi_ZMbSRtNj_te2yrpohkxtDCayPz0nmI6j_vrWpK4RDBESC34XaetpPoNrf37ELMaL0AzD--8vJghgLWTzsUiGwS5l7gWj9-Z6VrZNFAQO1lCl6wvLsPoJPExv70JoJp2FrCNelXpgHdBKEE1HBeRNrN7mB6Pd_NEvP_3JWA-2Xb7BJqIkGcKtIXT9SlgmZVkHH3oqf1N94S3oW0ibhMJKBnDs6sT70nU5icrA6WgECSTcVjOCkh2B4FYo7TdYQDOU7efnJ4z2VwMMxNwu5x1dyKdmvcYR38UKlyNaa0etL6iLrgrphNMGJ9-fi_IUAiTithpZT5M8nDRVgi9QiRNWWd7McUBJWIHke_r0mJTZF6O4JFBvmd0-kQ1vsT0a-iYlk4560661oCROgPAa0YFowcYQJOxZ7pIob3X9IcCS3uBNc5qwPjhoTesh7u4nW-k2kmImijtrlPdpl-EIfxdY-yoNhVHMgbOHvkDdnXnfePWyQYSi0K1Mj1=w713-h632-no";
                        video_path = "https://media.giphy.com/media/lq9qvKmuXqiy8SsO8W/giphy.gif";
                        description = "-Barra paralela al suelo\n-No balanceo\n-Piernas semiflexionadas\n-Codos junto al cuerpo\n-Hombros estáticos\n-Agarre mitad barra Z, palmas arriba";
                        muscle_zone = "biceps";
                        break;
                    case 12:
                        name = "Escalar La Cuerda";
                        photo_path = "https://lh3.googleusercontent.com/3ykxf62mb7cQDO4i57Oo_5lmP_RJ__iyn_It8HabSgmEZqs-eoDIDTmDSt04ZZwWxo5iWExl80nLPN2e2xN5ICoJBejQt1b5MEVMeHXdehiMKGF_pWqv0bAMQf0WjcJkPcuc80npyAdrLygpB0CRhqDS4a5jSIkxg05aA_DHz6xMGTcTC1ZQ1OqyBzdgEN5qeBvR0bzLyIOFXINFYNW0ZVpAzQ85rc8m44jlLNYrDkl_IgxQ0VYb-HUaLtIz44I0mFKs3NXT-QG7_Sc1ZPX7bXeqAcUnnxz3eGDZ4bT1bk8d_VrWsxB56SpF1Uxbwk7vK6evjL2Zt8V_MkahkZv7IAwpmE1wZaZbGgK7OzpYG96teBJZknu_9lr8MxVJl0orZZL55OJff4wq4kvJNQ-M_Hs0_i2TPVq_QA6oLPAt0-XU53_gMfZhRDmK7eercw1yjlg7JY7YNVHhg3vjcTr9rTPOP4vjdy5l08F0_R2oRvAQtTNyb9Bx_TqjgqwCW2nijjjYVKi4sE5uVRDc4WM_hBf6t72GwZORe0C474JDCfU0GtJ7yTIc71QU5gLxr-9dPK1hgTfGwH54iDsI5Fyiai3JLzgZJfJkb2O4WqelVwJOia7tarkPCaaPXP5GYmkZSOEa_eHZRcWluu1SSIHJovZ7he_TSd8up_X8Tp5vy8CPmN9OkdxEhxpx=w713-h632-no";
                        video_path = "https://media.giphy.com/media/3LdSdt3op4tw9XyhKa/giphy.gif";
                        description = "-Subida de brazos\n-Evitar balanceo\n-Piernas cruzadas\n-Espalda recta";
                        muscle_zone = "biceps";
                        break;
                    case 13:
                        name = "Rope Training";
                        photo_path = "https://lh3.googleusercontent.com/yNPYE11qCiF1WW_0rJdZBPKDhywQlv5akHCkMPfqK82-CjcwyNCRHiDKnSwXRryqtCJhIh2snZcP36GwPnZenuuQ09So_4YjJZ99jwUb9hqLEdPFhdgyPu2ljtzo8Mk1S_5V6OKYvscjXENPrZjPQDNiX9f-uxWGdMxnVKMrnjDG_SRDMNCFBG1na9aus7gVyfkbiK6qjocNWacz8Zk1b4Hz02U6rerOY3Ch7Zstv8cJ8mFxKNbvhFWQM0T-6PGsJcpgLpXMgqbHHWgYT9ltFyvmoUVTaWZ7NpZeEv6SEKl19kxPZvqePi4AsZumS_X6jPfW4BYRp6l0O38DD3rLf-xhZjlO_osgZXOG2kVYsGLjpnGzIS0_K1griJ0jUGWAO8WulmKo_TBSeHbQFt_1U6D0bewwWeRSmZoKiHls6HfQ25sTUiZr2Enf9722SPjyLr15Z8cHPBA2TAles6juGUujhz3rRT_0o88lHOkdmtC8YOXTKNnjzGELQCeMMz63g3OQMU93EIxP6T6Z37dCpXfeGBzRakIXSIEaAvMQykFFxbgKylhrsUouqIUgDkfOrHMsvjnI7VIvhQgiXzWDRSbdM_CVoNonOxWjU9vPJKS-ZEvaBsjHcvy3yLW0cxkFYnGkgpy_Aj5iFa_B1QUnNCMV6eBPxTZ_d3jDUJ_nTlrrzJEeuv6YGI_S=w713-h632-no";
                        video_path = "https://media.giphy.com/media/9xyHLjv1hu4QtmIWjy/giphy.gif";
                        description = "-Piernas flexionadas\n-Espalda recta\n-Crear olas con la cuerda\n-Brazos altura hombros\n-Movimiento de brazos amplio";
                        muscle_zone = "biceps";
                        break;
                    case 14:
                        name = "Superabdominales";
                        photo_path = "https://lh3.googleusercontent.com/kwL5-slwlAxzy8KgsjntM-ai2F8bChUj0dMd4SsuoEBkwIHoiE8VKY_GqKMn3unxUcv2hQS1nEoFYsX27CPVO_5YoxJZoexKqf2OUW35F2yZmaDN9KTiOC7qKQ_zyttMBLh4COF_y_x3oiKKOLZTTYcXuYdKt8NsKBZPRg-UyRz8bLTqAnpKDCPIRnq15ibRyyDZo3ZEAasVXKvVmqOFG50ATRCP9qwEiutXmDvqm6iEEdwGV6NxD0NBR7RJFgr4iWDbzdO3yCqRNKlRISeCSU5QZZyUwjSN2xY2U5zmNhRzqxSzHjbeloDk1lpf5r08m_-adHudzGDeItqEmWIGGP1WlPBtjjjNwMX9yHNNyjIr7ZQiwoor6SQ0eKIE-d3XTz_dB0kyPyVfKammtIug0oaFvPJFHtV_mdt6G6ZRbqlyqOYEn6VgXTo7ttAg9tOsg8QHjo6hoUpyUxhVKp845-gXsqTVZVooxMzd0r4RW4unW7uF0p4zCTIsCp2WhF6HAqJa9KqN21sR7QplB9XaZCwnjX2k7Wf5uhB7Q6w34QSRxQy9elcmHVSyU5ombfU4xRlJ_Ray1C_DgcsseBLTmPpdI9L-OHldA_q5CFWuv96Aun422WMBEmttz0AtSZbl5oU676tDyrGKdkbKiZGGAkwMyFkjdpfML2VZ0QDHGdfqVPODm7uZ7NBC=w713-h632-no";
                        video_path = "https://media.giphy.com/media/3kJX141BbOd3xTl4Sv/giphy.gif";
                        description = "-Alternar abdominal de torso (AT) o cadera\n-Marcar la posición V intermedia\n-Parte no flexionada estática\n-Barbilla al pecho (AT)";
                        muscle_zone = "abs";
                        break;
                    case 15:
                        name = "Crunch";
                        photo_path = "https://lh3.googleusercontent.com/5cG7Lb3XI_wR6HGdvjBeGlYosgqLmmxwO6exv-SNm8uCsYenQVeZJDhv_8cBfd5sstWsvL5GhCXPSIihQUkVNVDyDZv3nEhb1Zkb4ciafJIvApdyFu9ZOooal7Q1k-IFe8_MD-o1jSLpdhYEyUp4vEG3FSPnuRvj78JTrx_SJvDBx9TRmgTdA_VvJh46uJ9IoLbGXZCbcjDNu-_3LN5KhSrj8DnqB6cD3nlKzWLw8WjL6mtggXu4fnFGiI8ANNJxZkst6BVBGx-B0ZzHTrT-F6bICqgSz68eIty1S2SB_HNnuZFFZVLyuzKI8krP-7e5EoXt2E2f9-ocwwU4VHD7gvssU3s08IBANd13QAPdzppX87NYtZzZH7ozlM3sCdoSI35hFaSg_2W2glq1oqOC2rQJpT-PGa2lc8iDJLwN2MUIzAnQu4FmqAh5GRbG0M8-2WiL9I7nrhk167LHHnpCOe5Af7MMn2avS9KQXOms0gAy86A6fbn_wzfoJ6kA6vPQ1zobcz3DEbidEj7j5gJ8xggDI5eFf9fZaDiaaxFPTM-QwEgJCMNzz1Y3hb96xAL6kDiJqKVnt_dJZBCN9BWgFBPNxfDQKQ79vB-2YsODSs4XgIZvVIXQeGjERLbSk5MksK18tTRJxMlhT6wIuTGRBSWeKLPVq5lC1DdPqbxv_V73JnQKTSbYJimw=w713-h632-no";
                        video_path = "https://media.giphy.com/media/BM0iusUpGKKFZeVann/giphy.gif";
                        description = "-Piernas en V tocando el suelo\n-barbilla cerca del pecho\n-Peso en el pecho\n-Subida hasta los 45º\n-No doblar lumbar";
                        muscle_zone = "abs";
                        break;
                    case 16:
                        name = "Crunch Lateral";
                        photo_path = "https://lh3.googleusercontent.com/BLhQ6d-NXC0uR0_aB7vJPFZ04iDBFlL91rP9ujFpTGXbkDUU3FxukLtaJoYsU69zxZPXAtf6Jq8MCciJ6CQh4Gt0PVJ9NVa3dDu-vmemQbFFO0ow65u6kFrBNLmYdkmS6KZCoXO2O8j9klmsIDLapnIAi_NBXL_ftgDal0ZU_Kqae_BPCqwznUtDvhEWKrHOnWxEk9lqAxEcAVS0PT2bP1wuDBQ6w-rLQC6CzW0dxxTZme4jqsU6xxMZqaI0wCb82rvzz9IWaC8LrOw4i1lR0NHwGl9XJBjKGnNKRZIPiZQp_SY7Ii-OWxhtG4tqNgO3F4Mnqqzu2098kSfsGceD9KKjhQ5wlxLAAonStQVdqNM9R5s46YvQKj8Wxqi7qlFxtCFn4UFazT1phXyakW_51DBRNSLtcgmQqg4v57VypJ9Ir7XcFRbxVi_g3mCpd3N2__s3tBC3m9w9UfppwSRpghH5mxXqWxWlio6EjFiepgqU-eDp8ID8Uw8Ah3iZzMPcMo8sWLKFd0RUDDWiVQmq0LUEKnAw1YGAGn8Ne1e0_lZCE4G97Y2foPSTRXQwPUHboKDACEV-ztyd3iaq1YHIw8dst4Z5Eo8dcPGrDAQBKIeDEIfv4kABI4tl8WwpaulAeG5FmXHezctps0g85F4U7GZ57lVPkSvHY3lQ0kUAnqz5HbZEu5hfWxZl=w711-h632-no";
                        video_path = "https://media.giphy.com/media/xV8qT1Fvmv9mP8fCwL/giphy.gif";
                        description = "-Tumbado boca arriba\n-Piernas al lado en V\n-Subida hombro diagonal \n-Peso en lado de pecho exterior al movimiento";
                        muscle_zone = "abs";
                        break;
                    case 17:
                        name = "Bodysaw";
                        photo_path = "https://lh3.googleusercontent.com/vqmFto7WWxVWbDfWyndORuFiunN4TwGf6uEoaxmV-6zmCVGATNEHsR3vLemyUlOygCcFz_xPBbQRWMEBUCalrPOh7V3hREsY2hTPhYQudHnUjrBDe8j-6K_dmXN5FOAya6r-Dm28wyvgRLzR0SXIpHMaBW8H8PUhr9yn9uYgjfvPUpgj-6QzsR4OA6-yXTYN06FNMh6R7r7Gd2C01cKRuBaJ1Ge90BeLvukPWPgziEj6yZ5mxuQN_m3rtg_HZSmQGU87bhPXqHIhAKYEkLy9ORICjKRDYLNMNjRiQvhET_pX79lU6AU5t5M_9lfjdVOhCsKEa-OWjiEHIMNqN6gLMs26ltIC8p-osh1wq79FbyTNCn2PG2A9XBgd4rHxPuuHn9NvPkB-hkwDsHvcK47ojzYcesu7l61JmcNPgRCuzci2TViMpomKGcbXZ8YnxsK3acm9xGu8GK3-TYrxYz7ToVIV8X9HsaIQtQ-ZSSjP8dOwm0FL9_VTbkSKm5pGfvGv0gNtS57bwaRKnu66uXGNUTdjJJ6KIIVqSBxSvsZnR8UNktw__7JCdGyXLXWQtaWoJhAOIpYVBpUVeLl1YmYU6KqsC3mlyRoY0N-keXjWbNChO9xv1Adj7u3CmU0QYG3F-KsgqMgnWnMncEUZXjrFrbiyAXivf2DZ6yXm-iW7JfHeX23B0lWeXY7S=w711-h632-no";
                        video_path = "https://media.giphy.com/media/13PE2r4iPbJFgZ4uk3/giphy.gif";
                        description = "-Plancha\n-Tronco y piernas firmes\n-Algo para deslizar (pies)\n-Movimiento adelante-atrás\n-Brazos mueven al cuerpo bloqueado";
                        muscle_zone = "abs";
                        break;
                    case 18:
                        name = "Plancha Lateral";
                        photo_path = "https://lh3.googleusercontent.com/chEHIxmGJAoekfd8cHs2d__Qb_cvUQtd3eP_Oq4JjzGMaFlLcGeML6pRr1h0g-KUwt63EmlbPxSUjp7S90gYqn8v3l_qs4BUJEeuBvzWnM-NUWOO_VO99cc7U-k8cpJWQVMeYRC-YWf7oYVg5oTCM6FxEb3nfg09ec1HrXg4kyZY1yKFODtZEjjTxtSJDYcg3WF72YgqxionKcJlJYU47jAg7u8L716qOVbeIyaFAzT7XPGZxvKj8SFnQFVc0E4g2xMpgC-9QX25jm1SYRXj3egEmaqjghKlmwJfQYDBHM9ePXGkz2qQDe-VzwDBHm-kbL-RjwkBR_eD1UkKVfjE98Tuk0m6OhRgJ6sWY2fz9G4IjgAhrMxWfCT8u6_UKrb2EvA0EgW_L2NO2weptUmIlczU_sXZiq1OX2NYup_AMT0iOrYufYpHs5iFmsWQ2Piltw0e_-FyddmmoKw_thGphpNF4PuB1mwPTYtRZWPqfdaUyHOTSqUAq_M9sT4CMUo76uiPTHrL-tuKb7Jh4nRhodMVDR8z6KmHQJuL--LNiSA0PQRYBXay-rVThDY81XFxhxBpaD34HOOxbnqOeUG4EK8hywBIsuywq04s39N5PP2XpC0I40vrvFzrB6ni2P06Y6LUfwaJE_fJmalMGUXDuNzErTxqGR6wcs36S-_bGSGBNXwYiMmOm8EW=w711-h632-no";
                        video_path = "https://media.giphy.com/media/5QLNmNzzO7Y0I47mJ3/giphy.gif";
                        description = "-No bajar cadera\n-Cuerpo bloqueado\n-Peso en la cadera\n-No hay movimiento, va por tiempo";
                        muscle_zone = "abs";
                        break;
                    case 19:
                        name = "Crunch Brazos Estirados";
                        photo_path = "https://lh3.googleusercontent.com/dtRpwCvFwnphzwOwBBwPR6LOIQQeE56cdGv_DN0KQ-LRZumnGcN0g43UU5fj9sWOyWh00nZfNIO4C5pKnamNur7Ui9zxQYRiMSBpQTgRibJYMWGvXtvnsRkZLuYmAy5N3JuLlB4GyXX63DVpt4sOVEPU_E_-ayz2L2oURmriC1Ms-GFs-09SLnrMjLHx8LvwVvKppCf66u7Pr8QKpzl3t-grDsNV6omatEXmvCp3a2a91M_PlldT9Fdv01VUj4B7cPVMEsFrpmuJJD4N0mLoCOEH56_-4CxQFWGD6rB-CXQdiqe0QnoAKCtMDnnb7r-kb4qMdyPEC9iIwwUYEy7q-OSe-algH3LCq-z7WNguC1v0Au0FB8ghA4JNx9fEL6BzkMa107qP9BkSbsQRL013ELAbk-dxUSruE2lek21Xm_71cpPgVRkFI0WkG9A_hVnt5-CoGGuc2t6mC8rsYNpPwvTCiZ6wnQ_8joV2By-Co7HqekdjcsdbpIiQ4FMve2j4aVogZpg2LUwPE7m2VRdAHiijvxvSrpYpmF54G9BE6zAIxhyh53UXAPt0kxnjrUu8DB569yDBUmlSMdc4sv69xyDgWoDlnFmVzAgQYtlC-prA2r5YOJ294_auE6urcRv87Yo20ZAmCpPlJeXSVaKmOvb0x6nR28F4TnqjfgSq0AKQfX8ZnNmghNR8=w713-h632-no";
                        video_path = "https://media.giphy.com/media/5R1ErA7RqF7HUMTIov/giphy.gif";
                        description = "-Piernas estáticas dobladas sobre cuerpo\n-Brazos estirados con peso\n-Brazos alineados con tronco\n-Brazos no adelantan tronco (subida)\n-Crunch corto con tronco";
                        muscle_zone = "abs";
                        break;
                    case 20:
                        name = "Piernas Estiradas en Barra";
                        photo_path = "https://lh3.googleusercontent.com/p5XGJpgc8kmezFEDvhgAG_j8L4lXnhEZjibgCdAf9H5bZE5xQMK_IEO4-9D2dPW8M2UvUuauluIdwsnCUpXaOenFmz3qIMoP-reflbWu1a1pIGXlBEI00aeChT2Tneh6uRrb9KzxXafjrmrc9RMNcoPrNBLfmXweN5etj7C0fpdnzfswnuHIWuSRtvO2gRkH4g6KQN-g5NCeuHZjD7pq-ORSi1PEY3YcT_8-7tDJFDmpIMNUQGZyjJVZO9uELxxd6m9bCVemT2Q3dEK7_btdR31-9YPaHl2rPktiwu1es_xplisxk3N9FritUfxk4ormr6iBowXYuchQTw0qR6dEJ1j2mS2iY87-q_fefUzATXH-xJBEkNw0bOavOZR7Y-XeRIPIzsTX-4_MNeztcn0dbTr_ia9oxw3NLiscKPYip_7u7nRDI1Or7yKRXmVUBv5T5d0gzcnK1B9jknKiLv8z7x_vid9cc8_FAUpmkQZCK2m64mkNiL39G2GK58Kisez6viOv_uqArmS5dNPRk3JQFrR9CbRfnAI-U9mE7AYmaDVEFhFYt90vdhsAtEp1FpRI_M_sUHLR_VOj3YpYCgVtTCKGmXw06AV0KKHatD242stizYxzOmiUjeDoZ-TW7jVhjcDofC4UXSOtLuQJ6WowiKcdBNvcxYI95Z2Gz0v2285pVyBnxtezxG5T=w713-h632-no";
                        video_path = "https://media.giphy.com/media/QJHwM8DUV6nwM8Zivx/giphy.gif";
                        description = "-Agarrado brazos estirados en barra\n-Posición inicial piernas estiradas\n-Cadera sube moviendo el resto del cuerpo\n-Impulso de cadera, resto del cuerpo fijo";
                        muscle_zone = "abs";
                        break;
                    case 21:
                        name = "Sentado en Barra";
                        photo_path = "https://lh3.googleusercontent.com/zAwEJShLr0Ylh70mc_p_fYFyVGuuxjP4OISNm8udCl1WLWv1Nj_fn5O6cBUKJQ2wakH-mMrBTDMRlSZ3vsU89vV62R8-sg29LCKUN-Ln7gIX3Hb6Tdh6NY1_556U0irK5dGj8bzlEqZ7JkfeKp963AKv5FfChOH43bzQEhwQi1tmCRXdLUy-k_bU6P3y2DKJ2xqKYy2jIOqtIjvU9m5iFykNN1t4o_yj7sLLlIwM3n6UkO5qLiTz-93-Ld1FI69D-u80thHD4x3WTTSccA2SyhGrg-NgKKuMPLM_BogjB1CHRPFn4sEgMNocuAc1w58Aj06n-GS2ltjg-o71gK9Th7TS7RH9rhainycQe4bC4zRh2iwGPmpYrxnBAy7u99-T2pSx7xOTNi_hJMgogaHELI3v0Bj6sq6U476NvcwDkHdeLZUGpYB-1PwclqcVMVxpKGm8WhtGdG_Pp_EzuUFrOioup7_f0TKDKNc_Ds9FXAGHiaYicymzDoDV-h-WWYV_f3H2aQejSDzMrp71ELCfHDow316k6esyutMayRpTgeYa1zDOlHLlKqyffKVZB2ND6J6bTEJ1C7LMd4OhVf-uJkN2w9h8UYrY3vxEN6TGxW686Esy812OXD9iZpTrcGVsVKmmYv5Whq873ee67SUEh92PmhunEcvmSQr-ja3wEhXwYIkcpPefPFaa=w713-h632-no";
                        video_path = "https://media.giphy.com/media/1BcgDvfn1aT4l18LlT/giphy.gif";
                        description = "-Agarrado brazos estirados en barra\n-Posición inicial como sentado\n-Cadera sube mueve resto del cuerpo\n-Impulso de cadera, resto del cuerpo fijo";
                        muscle_zone = "abs";
                        break;
                    case 22:
                        name = "Crunch Corto";
                        photo_path = "https://lh3.googleusercontent.com/2LxKol4oLiM84S0jXQ-9SuqIwkWdi97QW7rLL0IAl3aKJpHkEOrcIllq6LDa2xJJpG3NWiScsHwCU6Fm8RKqZ6EOsqj1qtCoQS1qefoAu0vDlPnuWjdaHG3pCpEDaUrtIGDZtERRpeyFjfoo0ZJ_rOD4jYabvoykCXhRuuYgf7hT_S817z6Vpu-ZfNVjcLl53zydGQJS7AAK_Yi9U0A63wHC26X1bcgVKI6rB9jGL9btsTMu5uH0TAWWSOk1vdfejDOmERqRolurVBioYt3OAmvWD5PAPMs9wTYn8_QSnQAco8ayUZ_2qkXN7kg476xn2AV578A-psvalweeHv2zy9YTOdLkp2MVfbSbTKT7a7BUBQw1mQaqaBxPLTifqIG_rzVke_VcOO1IbZlG0npgHVWxJC66uC90WAieVQqYMKnmfHhi_Ywg462IsHq9CuvRMBsbdTYqKvNShBSEJVI7dI8Qv6td1IKKY9BidAVXH7etfsbDa4sQJ9YO0NqWh0beWZSgSJ6ZlVWENRrzusdSOHyOy4f7Eg-Sg7e6iknUmtvIytaybttBRf9I6RAn-z83Y2RRkPuVK2_KCd5-aR9mbuL9g2uDZ_bc-KhoIrCx71YieDjgCq_fMdPI-avWnSufIsMiEsmtPaJ-i06rlJKDRJPm5JjB6Cpx8dbn2Uh5Xb5ffm84tEGxS6Qn=w713-h632-no";
                        video_path = "https://media.giphy.com/media/1rOXZsMytyUeRi3DhR/giphy.gif";
                        description = "-Piernas estáticas dobladas sobre cuerpo\n-Crunch corto con tronco\n-Barbilla en el pecho (subida)";
                        muscle_zone = "abs";
                        break;
                    case 23:
                        name = "Bici";
                        photo_path = "https://lh3.googleusercontent.com/Ug04Mj3zxMe5hmY8QGyhsACJaTB-zbY4jUGiKSjcqj5_QL0bex1tjpbeQv_jOVzxWv93Ipnbix_0eztAfrTP-lhCfYALG3euMPLrQTUNvSCn_3xBPzua5nqQR1bCEy28rZVilBegbZGzS7un9lgnyY8b83xvynEkYQjqPu0AEYXrXasn9iXR4ord6RzaQi1bSd1-psVTFOzh2zsyGmyJLhHbZ2iMUk3n9cCI3L8Ujobdx7C9gNF-HvnDAmYVAgvP0htsjRez_pI3ZCFlDFuHilHQ17tt6mZzp_qViUo01FbCK92wVX9cJ_6JgQZE7r211UOwzQkEbB9MHBlrwV2zSSqDyg2SNsPVIqwO2lp3p0YDLT91QxqbVzHKX_CuNT2qWj8Cz-qMLQMZBzmbkt6pcAZGAbGwkv8y74ZwCgGBoD81Qm1UxhiJwzYjiGS2ns5ydqM8ZX9gSd7xBbOEW6s8JwQms6MbQuN3oUH22CD22YYHAVaIJl_ZBWpleYtTSQ_Tj4BZd3V1mlySQ5eahlywd8wN_Haql9tR4WC8WM3hvx13SYMNpHbhJcb93b4eV0T0MpEpOzAHiwvKCjgkyiQGH62W_12GIox2rRIicpCYY_ZrgPkPB262wa2yiEHsf9r6wobomrdCbi8yIiHGK9JrQWlf1vhoe7cneLBwOmecnHT3ophj2E2VHUSm=w713-h632-no";
                        video_path = "https://media.giphy.com/media/3kxqtvnl6ZtYGlZ507/giphy.gif";
                        description = "-Piernas dobladas encima del cuerpo\n-Estirar pierna y flexionar pierna contraria\n-Crunch lateral codo a tocar rodilla contraria\n-Alternando lados\n-Levanto tronco luego giro";
                        muscle_zone = "abs";
                        break;
                    case 24:
                        name = "Lateral Piernas Cruzadas";
                        photo_path = "https://lh3.googleusercontent.com/Dj5lrC7mXI3FKEelMvZ_U8yb01FXAXtIPZd_YgFugPgmQHlzpz20PpDZuN5ypZjzrtD_4icIA8aKWOSiGTyEwOOKBZc1WWo1Szc-KTpvr6-DpCUKTWfzaEz6KaZLuBQiNapvwif-G1YZYeOlOIekySo5YOhwHXyEn-3kfWwjH-cEh6Z7cKpYWrtQZKN7WjIByob916jfuG1CvGBNV7FGtgiKauGewaSsyhdMcUY04pgIhYtfG6QP-HMEyDzc64yPYlEvMRo8s2OBqwXgM6dCzhT2DIxR1-eOtoHE7c4rj8lnT31PsgfN30R7JJ003cSxiwghfPS2PnbC4nBdMc-WzSgHO185lWtj6fY6OO_mcfzyEXBN3GEoBoVS9UPF4Hj5n2Sv4NPjFgTX8NpVRP4PQRhPRVYhr8lr8w-phL8w8CodG9YQDjPzPOkfQLa4zAh_dz0RZCIf-pQmFSIcKJgS75wQAqwqSlMbBEeouhh8XBJ6xkdP-yWZ_p63RRz4WwrEIvfUoTnDilQ2UnSnTc-rlwOtEq6phFZ91elKZmrJSXWqzOs_kTl4TOx35Po9QjLtdLa5nOTA3VFgP7nMZGsXM-uG3OVLdyBNlrGDbrsxBabwGueRyOJmnyFXY_H26DoE0LZp2DfUMH40ELlR9tMvgdG1Rvss3zW5MnHPrz2hl8uolSBSagyIHXe5=w713-h632-no";
                        video_path = "https://media.giphy.com/media/w7vu3QLKvuS49d8nvF/giphy.gif";
                        description = "-Un pie encima de la otra rodilla\n-Crunch hombro dirección rodilla opuesta\n-Levanto tronco luego giro\n-No alterno lados";
                        muscle_zone = "abs";
                        break;
                    case 25:
                        name = "Plancha Frontal a Lateral";
                        photo_path = "https://lh3.googleusercontent.com/-PM1IBlAyGpVJrx0YChTLdJ-zzdKEWwT9DqrmW9suf6KJr0M-D1ZhdnQv81O9f8YdU2c9EhcBVvOUm9UePTdHDO74fdiHq5zAKcqv6yOcfzmcxvpai2W7_XW9vy-i6830phazM8R36PDYEJzhY4RvBpv5ZsSa_aFrEA9BaypXq3ylr-eUd2cztUW7qUmvILHrTEFoQjUOpxEW9osasXtazENhVQCjiAybu21cE80uLKtytStfIQHm-U9hhCCt-VSzQ-1JhYwLmBscZ7uLmBzxw8THWquxmmfIY3Zqy9fAoTlx8-wWS8-iWfqjYodo39fhub6H1gkkT_j1KeDoLd1KkUrVYomfZr11ZpHCt2PHLk9fYT6jR_3zyF2mHABUWDcEYtXeaSm88Z_w7XgvaloYXYan6z92vD2qpRMlqMXP03HeQzeEcVzW3YTfzmY4_6C4Cq3d6d5KDOkysubNhGXnalOWSLZtgiHO5_2KbWASfoLFo2Rd1uyQAWhku8k9rCig72HLaaZoHH3X0IyHzNFtNUphP8hMdXhdu5LAURlWW8Uf4OLUa72JPruktJEf2WhvwVqEbdPHoeQP1K4m9gvge4R5X9Lr8gTcbDYY9G-bemoSERqWxQDaW8R29j5kPoPfND6ZVRA2cxx6catwn4otyEUPxg_zIzbAcGhZLnVW78iTm5iPZk14HgO=w713-h632-no";
                        video_path = "https://media.giphy.com/media/t6J5AiLkWqOCiJEc2j/giphy.gif";
                        description = "-Pasar de plancha frontal a lateral\n-Marcar cada plancha\n-Subir brazo luego por dentro (lateral)\n-Abdominal bloqueado cadera no baja";
                        muscle_zone = "abs";
                        break;
                    case 26:
                        name = "V Fitball";
                        photo_path = "https://lh3.googleusercontent.com/zAgFxX3PZpiquZNF_a6ryCvT8LhsM1-E3vrWun1yYWlRM6hne6rf6lAqH8LCd4XAQNc-uQoj5IM0UqWbL6mTeebYIibaHM3PMuas2xY9eXgALZtdQXU7z8eRDj8zL4CWEUab9g7tTXglPQAd2d89-BWjuvewiC8oZoJgbIrVvJYmFDIsBtmkT0s5rcECrZClCYM8Z_QG__5MGuJbaTnvlYZCu7twY8-qa3H2eWJEgTqDdUdeW8Jp-iSt1QDMSbzGzavLSLqa0tOt97zxtoKnz1Lt8TsixF4vC-UDMvIEOcccu2Knx8NTX6jw2vji1vYYD-ys3BTE7857inN0xWnkFfBskj51tQGz-EH1xHYXOfTt9_kjAxoePDbutksNcmMwlemaGhWWaB_seLmrDUf-XG5BBpsE2Qow-nsw1Dq6Eh0YLOvLPhBanP4e4-iesmAVVrYA1ZQ6HYQtEqUPja6ySTvFJCzIXs-EW9RcFJNrU4LsbDl7VP_YUO58qGyeQs-rr55VHfrKKOlCNafPUMfcRVU6tgsP2Cjby4p8UiwDVbskW6YINSAgt_CfNWXrh3uosIhvhjdhEUbWFpjUz_-16uAa5NnFCOsk6AXlI-CTfwAZCDs9enJrrOx3bn5AQiBXSrPCF-3xLwpu5cB5VTudpo45LI1iD_bvkaIgnOvj0HhHh9IShZM4oOv-=w713-h632-no";
                        video_path = "https://media.giphy.com/media/SiJWH65nxaYZyIEniz/giphy.gif";
                        description = "-Hacer una V pies y brazos\n-Piernas y tronco bloqueados\n-Movimiento controlado\n-Fuerza abdominal";
                        muscle_zone = "abs";
                        break;
                    case 27:
                        name = "Pase de Fitball";
                        photo_path = "https://lh3.googleusercontent.com/RBjns6m3a2hzkrwf9rtO812jW1HhbVk_LWcPNx4BgE57pWAq0IPBVvH_RBzS7CN9wZJWDIOT_QICDks0ZqAK7XoDs8nn7AdPuj4w6kxHUPFA-dbfYGtCkhyBk-dPOx2SZVXypN_RzsQAJDfXTxRLfElXCBu8drIeR3W_wRX1ulzs-Uc6nFLH-1G5qgeYZc5Yr6UnuK9kH_QYm5iASH3DfJXAu7fK3Yqr04pC4RLEanzp9ZWEUBJg1cJBiZwvAYnMM1WZEBXCBNLH4cZVWkOXq39eUg2xGEDn_-t9JMll4cZXIedruY4W1HEy2HofNIAqkv7IW8zbOt7rH0LA5Yq1LwTQOfgBUMQM5zE5vtzUmYP8YITlJpHn4484zmY4DugAr--heHQdqzdYSA6j69B9Bu3FCtjVd12RdnPoodJKf4TrehYJgVUYLjU7hLuwuH2SA5uJMkmeS2yXTv2rErkHI3nG27zxNdMvcl3Um02klL97U3XjI2gDGo6KR1775XX61VmqFj8yWRkhPNzJ-OGT0CZ3Qol4Hllnp4NKaLiTkKwfbEuhNSvt1v-2Zg_GE7V-_39CjjggCleFmpoyag0ekO0w0OXFfj1v00_rYsp3eFCQockhyf-1zewR2sd1D9Sj1Tp2jn99IySu897RYuz2nV5qJHnaFrfbOkRNcih6tK8n6_7Ya0xuAW9u=w713-h632-no";
                        video_path = "https://media.giphy.com/media/8JTla6P0RPoMulqaPL/giphy.gif";
                        description = "-Marcar las posiciones\n-Piernas y tronco en V en el pase\n-Movimiento controlado\n-Pase ni muy adelante ni muy atrás\n-Espalda lo más recta posible";
                        muscle_zone = "abs";
                        break;
                    case 28:
                        name = "Crunch en Fitball";
                        photo_path = "https://lh3.googleusercontent.com/CkZ05emxQDFYZnjyNttyKcRf-SW_TNHkZm0JQun6rejnRtDbldz32IdPUlLKzaz9VvRg4IXCxg-9_hOGjzOG3ljdEdOqtUCEaOVp2SXBY92uXYb61TV5BoCpwww9b_sFTIrCo-Y0gtkk82UdQp5s3_RCQyWJjhpSsLOMNcDDH49KynFF7bqdw-4nsKzOsxdWn0Lgxqi_OL8UnQ7tRi4VpSj9p3Lchs-DfLn1dSusOKEqSAlZHIyvIIh3nAZggMUDI_HveUwFv3K2ogkeJzfdpGzJKA4i-sw7jp36gFCIpmTzuGSobiZtUvQomfFom1Ho0wL6jXcMGNV4x4jO9f3cSQdl9YMDJ2YbTcZvbCPQhBV6cpd2tlTJPD4dCK8CLVNKRHvXZQNXR31EbyH3HKIJjoVq3d5XE7O_kgjy8awcb7KZvmVc5TOgz3CAwTev-UNYRUURv8vDjMu_hTEoDn8AuBr2nLMZxbhGoIAAxWonNzzY1xKmAb3DFRI1ecQLMyzmGeZkxn0-E12iarB70i5_1YljZP5jkv4re8GGS4ywkmrPevJwgy3gXhroJOMLlHGAN51L1tHBFHOn4jqeiZkoiQC9HSFuUoxosjEPF2nCxdQrlUsfzQvOucRqS-hkHJma3HeqSVWslyl2xmeHUu8bpb1sy6lniXTAyEUY6wBFVtbg0ca6o61XC1AJ=w713-h632-no";
                        video_path = "https://media.giphy.com/media/5qFZtdbscqdzGztyqz/giphy.gif";
                        description = "-Piernas bloqueadas se mueve tronco\n-Lumbar apoyado\n-Movimiento controlado";
                        muscle_zone = "abs";
                        break;
                    case 29:
                        name = "Rueda Abdominal";
                        photo_path = "https://lh3.googleusercontent.com/cyplD3u0xmB75czTy3urhIREfBcH0Sb5c2f0sI-N05nEYrrmFdAM1rnPFJVOLnGOYHcls84zeQODcr08uU40SkosFfs2zaWcyDezLkJbazKNec99k-YiHac1pZGSoHzX4sNwFiyJMXx2z_OhCvXxg2myCQtqdvMsCJv9rzr18xyamTXLknLeeY293dCGfwAkPhXd303KYZ4TDREQGo33w1ZY1avuftnL1y_yIzdoiNF9CNR9UvHDhJrFLyiQGutLsp7JTbXWmieItCAYkCqNKEqTNfSOCk1KZ-7H_H5hNPFeHKdFewtCwUEloZ6ipLHS7MXc6Zf7IY8AmbxHw_5PWm_JAmgBmd07Fz4bwvAld2OJGjz0fT7NQK5WjUtuCXG-xnsTM_REcu5YxCY89l84PunapxJDRxer7nbEeJ_D9zMu05dFLzkcV9UKqwj24I1hcKA2la0ZP5M_k9Z1HrPwsNPa7FL3dpo2eW2qyoFbi7Q4fScNGCpshqxSxMFsywIqRwrY1RlJd4ibZeKyfwdqtJtndvELaw6rhkjOzgtOx2Xx0dLSZgeOAnSxROVuOg3UIEzGoRFUY3AyVUOjFI_z0aqQrgfdBlz5NG53s2A83oXlcr6gWKY_nUMu3JEdGuKihg0T4D9rptX3Cb7UO5609zcPfEj2Bmy7gVIv7e17TuxA9ZjFyCnBRRma=w713-h632-no";
                        video_path = "https://media.giphy.com/media/2wXzHKMYZ2iAapps0B/giphy.gif";
                        description = "-Abdominal bloqueado\n-Movimiento lento y marcado\n-Espalda recta\n-Bajar el máximo sin perder esta posición\n-Brazos rectos";
                        muscle_zone = "abs";
                        break;
                    case 30:
                        name = "Tornado Pulley Slam";
                        photo_path = "https://lh3.googleusercontent.com/JtaN_Wee_bpWShCv9xZz0f27joxmbSlUt1nf37lCPYV3zqEUke06c7SHhizT4Gq6HQWxO_CClW3ZCFNJUpmZZQoL-ZlrwSIKY0R10RML94CrbttLYtKuV8w2vkAqtaTNWv9d1wbOMQ5inmwNNiTZtv_5CDMosBqSj-WQQLxPmwNVvR2mZf1YyO83hfhJOXcEnlTkUSC19jEPsLQo4hlqyYu55Mb5JVoYcuhydYyGVjUFJ1DACNZZrmqIgCNMc1dvRMdJJIA6aX_NSn2idXXGQeSz08f-ADiyllJYM1KpVa1VlYqLMlNoZ6-WCiWKVNMP5X3FNRzkv1M7FhYuIMS1kdmZExaBLatwx-Zw4OLuUMWwi5xePzRxJRv5fqI08QmZq9PwkddZXhe8DJBNBDp0Bz1kpfBoDzQy2AjZiULshsNBa4WPuFS-UyPhxFLgePGrm4cppNgtW-2q9C1tWw3qVj0ceSt17fZ4i0Y6OqL8lCIdtX0dBO4AvYBEFvUh1MShTs-onZ_TGqjTR2O5gkEzGV6-aV_4VvlVjID-2eciu5IfCGsJnV6GPM5NWPGVZUWK259dA7w8t9F_zjMZzfpDZFXVOh7pJiEXDZSd91CDni5cGfSHfNtvtQj61PL7KURLKVBmlVREmFl8gMskULsPTVU_oM3KiMgxRvc2udWS78UYH-It2y7GfGGG=w592-h632-no";
                        video_path = "https://media.giphy.com/media/4ZpQKoVF689Rfz8pAz/giphy.gif";
                        description = "-Piernas semiflexionadas, espalda recta\n-Brazos estirados\n-Cadera y hombros acompañan el movimiento";
                        muscle_zone = "abs";
                        break;
                    case 31:
                        name = "Flexion de Muneca";
                        photo_path = "https://lh3.googleusercontent.com/fsoPalgmg97dXnDhDpkelSPlwOLygit1I7nJMf5wDqn1a5IoK1S3x9mckx_8ixrUxGoA72YgzuLr0fKzcDgZTXlDj2znyLVSHHc6hnoNIf2NmVQTAIg2gVdalo9S2Fx4Ej7Vx6HRnJkoC3URQQzYUcKYp0WpKHOSzDtI-LtD3SPUSJR4ncytXdcl_WM1e5F6rqzA8fjXyv3F5MvHYqklnY0mMCa6HCrQ5SKePtYL2BsOO_-LKEwyt5nBCcE80U-VkiS6gFKxbI-mXclPfvX3NCHiiGfw0eJKFfHEHnjx8EPMAn2_wlUsyTGdyfJcM5VHljyOakJlQN53ZGmJ85USFRiuslM487ySt1i3NGu84sEXk1g_XQbPPuGj07faL3mdhp9ZAmVrKaA6A2RKuKwtDOskV1aC_50RjgzktDvdcaCVrb4qCFJQpVRBQgwznx32boRwZbMR9xcrkrCCHBX6sP4yjnUKXqtPUo9W7KxBDeP8GtTUnHmT9xnICl_mcGo2yHn2EuxviXtXfc-Z_BwIa9GH-Cy8BoAgTWU8R1GAYTU2Zl5q_8lL6-jlXVODB_dkmmsbNhxYwKudfm7KTPBslXevpI9WOXwibpaiCHCVurFlWqLY1s9jTaciPxs2or63JWKNvHMdUsOzECGU3Lk-BYo_ux-wKgKTZIyf7B3Kj9mUUjix58s0btuh=w713-h632-no";
                        video_path = "https://media.giphy.com/media/1ZnBAWjjXlKWMF0FZw/giphy.gif";
                        description = "-Antebrazo bloqueado\n-Posición del cuerpo cómoda y natural\n-Se mueve la muñeca solo\n-Palma hacia arriba";
                        muscle_zone = "forearm";
                        break;
                    case 32:
                        name = "Extension de Muneca";
                        photo_path = "https://lh3.googleusercontent.com/VT6FusoC0wkdzGgADsh9VMjbmpVcyT0P-RxinlNMHrQpcg1dGjiIg6aOx4qLeIB1kfXXavTCp_N2hcfhxPrIlVBSwnB3oVSpBIfCnxkbB2i1odJKzTRYwKVb5jZAirztTbMLMGHJKqS_Xf1u8UtBhaSkRMkIeXtFjWdpkSMN9daB0y9L8RuimjwesIrij5FDv5E2w-knPgN6xBhcGuyy0cF8X6STtswOyvKM2U9jUyvwgxbbw1km1SO8X445cgHP-CETcYBxPVbyvYj-vs9udGH5d3tPQtHxZg8Bx7sGakHgkGFajrolwDhM5uLZj3gOzs394a7JjjlnWuZg6i1uRpgJyYUrdte6PtY7J3Um2Z1DMJbvRDoqGRU9AlkEiqoPVcyIDHHdTqa-LMHhkAmkAdSFP4kubpZkl10U2OokXHtZpsz94fpiIpw5sRn5cqMqoCFsJe-tfQ7mCXYqJEbIHyrqGee5M4zen32bXN7KiBsxG4vGV09RJvOIfQiuxPMhMTUtsRAFbP8tGiQmmV6ZC0BD0aICGnt844Hxc_oN0WHM3aXaARaKUx40NGsnTEVSqN4m_LuCibKpzNHBrS-j2FNfeXoS8qRIc74xbFn5YvuPVU7_gheyXQ8qQ1vI87lXhVJ3scUsapRV9XjcZ2bOhyCJ275dIzFZSvzkpfTYhh3OcTxV_8anW31T=w713-h632-no";
                        video_path = "https://media.giphy.com/media/tJYdAoXnHjilIWNZAl/giphy.gif";
                        description = "-Antebrazo bloqueado\n-Posición del cuerpo cómoda\n-Se mueve la muñeca solo\n-Palma hacia abajo";
                        muscle_zone = "forearm";
                        break;
                    case 33:
                        name = "Rotacion de Muneca";
                        photo_path = "https://lh3.googleusercontent.com/VT6FusoC0wkdzGgADsh9VMjbmpVcyT0P-RxinlNMHrQpcg1dGjiIg6aOx4qLeIB1kfXXavTCp_N2hcfhxPrIlVBSwnB3oVSpBIfCnxkbB2i1odJKzTRYwKVb5jZAirztTbMLMGHJKqS_Xf1u8UtBhaSkRMkIeXtFjWdpkSMN9daB0y9L8RuimjwesIrij5FDv5E2w-knPgN6xBhcGuyy0cF8X6STtswOyvKM2U9jUyvwgxbbw1km1SO8X445cgHP-CETcYBxPVbyvYj-vs9udGH5d3tPQtHxZg8Bx7sGakHgkGFajrolwDhM5uLZj3gOzs394a7JjjlnWuZg6i1uRpgJyYUrdte6PtY7J3Um2Z1DMJbvRDoqGRU9AlkEiqoPVcyIDHHdTqa-LMHhkAmkAdSFP4kubpZkl10U2OokXHtZpsz94fpiIpw5sRn5cqMqoCFsJe-tfQ7mCXYqJEbIHyrqGee5M4zen32bXN7KiBsxG4vGV09RJvOIfQiuxPMhMTUtsRAFbP8tGiQmmV6ZC0BD0aICGnt844Hxc_oN0WHM3aXaARaKUx40NGsnTEVSqN4m_LuCibKpzNHBrS-j2FNfeXoS8qRIc74xbFn5YvuPVU7_gheyXQ8qQ1vI87lXhVJ3scUsapRV9XjcZ2bOhyCJ275dIzFZSvzkpfTYhh3OcTxV_8anW31T=w713-h632-no";
                        video_path = "https://media.giphy.com/media/7OVQTNQbAjVeCFhmd4/giphy.gif";
                        description = "-Antebrazo bloqueado\n-Posición del cuerpo cómoda";
                        muscle_zone = "forearm";
                        break;
                    case 34:
                        name = "Flexion y Extension de Dedos";
                        photo_path = "https://lh3.googleusercontent.com/qBM6Nsyl1hQvlP3D8ccjCrhDsc-dG5D7SptavRH0jvLwiE1pNfg1xnFD4b6I1coPs15oxLWTvYZgk2EG0qpglRdRhhVYdsVu30Bei3TYJTyUeHf2y43RRoIBMMstqZ4IqjfDka_Ea_qou4sSHXr3Z1TqJ8UxHXp8XWNODdojRWBx7WZKHhEjYJsAdgyJVKypgGX5wS5QNVOr2QWyZyiIg9K7nyJXoiKru9bioKUlLVKVxCbKcqlwPPAIurnhK_yKczp1re093HzDlCjZGsTCAHTlFpTzGpLH_6_bzYWCMKs4m-4p1scgqgINH-XZ7LclnbwQ2gUV5qhaLUVaiTs6TeTAqU9gNFLfS2T-hCBPDTD8Dei4wvSn3nw7uPy8SCxJfHlrwvpWwRZ1lPE1oSmVLL2Np9ymdRA56n0WeFnJuXxVUyrCFN89wDtPbr2pCUv0PPKJvUTFdlAdRmlZHsF9thU7TKnyHs0k4ZU3YywbvPTpBes2jdS1eAUteNj0W8UdjwNS635mLYSUg6JEVbcqx8oKhlLbuU1l-OpQBo5yH7OQxH3xnU5IjwKf4iwGaFhrp_kwsikiOYCeLVmcdWM3lPKL5MriderpwsjcxgL7wf9vwJ8b7M9NMbdG9yw-H2qSN2eEoyM3vzEkO2z26Xv3GlkYd2qzrShGSM1ojpWJYeBcwPRAuQn3lO0J=w680-h632-no";
                        video_path = "https://media.giphy.com/media/oOBv4TkeywxU3sdMRT/giphy.gif";
                        description = "-Si falta material, botón de cambio de ejercicio\n-Apretar pelota estirar dedos\n-Con una pelota de espuma solo (flexión de dedos)";
                        muscle_zone = "forearm";
                        break;
                    case 35:
                        name = "Press Plano";
                        photo_path = "https://lh3.googleusercontent.com/OAsR0Y5CV4V9Re1vLvL26rJmx0rF8S-QW0ZEybFx54KQFIXMEt6D7op-P0pDVz10ndB7dp2HcHwejLaRIKXhEbBonGrh9rfBELJQr2muY5yRvhgmuNdhBjHeT7n6Nedthwl10ZHkaAPRQ5148ZgOpG5Nc4EW4UK4aBWA0YH9QlNXOZapa3VGSp9yok6_LuiKcbgGHM3-rnTT84hYnZyNGRA5QQfduM0G5JI4pYpr2LQ-uZ-9HUvnEIBZFY2Pr-axil5i7RT-GLsRknuBM2LuE_aqR7bGKkqsESk4F6grgzmCROw8uNmRcMyG9dCuhy9fuTEGl5lvtalPG3m8wMVbprHZXval47ma4MF-W2e1h_GYFLPKTWl7F7NjmN7JjwWg2zKnChoOlLQtrL7G5in9yHGC3dFN3EtbyfXLTzcRwK6GSguIA_RdnWR1pZ4I6jpjNaWSIF7Gr6Kzmdu2YfgqthpvscmbRLUbtxVz9cMASSYt5x405-1l_AEPgz5IiUmzX5BjG7Ry5hED-WGCGnI79Z5W2AXxGHc4wXocrTCBqHqq2LXKbZ-Khz9N9o72_naI2eG_oRoYySA19CDZvvfRZyGwadXPi2QhgUvg-UzoSWksGOF_VWifEQsjpeA7FkIV6VBZfRQSjm7fYqPrnlSb5f6FN22MVg1hJs0X_RoVvHmN_dLg--CGwUYU=w713-h632-no";
                        video_path = "https://media.giphy.com/media/6IwUAaNBgzpSk68EsD/giphy.gif";
                        description = "-Tumbado\n-Ángulo codo con tronco 90º\n-Codo baja un poco mas que el pecho\n-Subida hacia arriba no arriba-interior";
                        muscle_zone = "chest";
                        break;
                    case 36:
                        name = "Press 30º";
                        photo_path = "https://lh3.googleusercontent.com/xT8R3pxO365PVaQMy4wv6Z07EyE0kHuW4hEc_oSWLM_k7Z_uS2Mf0--cseIufgJlEABvDBxGusTH_ejt9I7rPg45ajU_Vip1UCOzoJ7Fi2_mnpw7ZJ3sVw7gBJserByzdkvW5xfqeXTh3zzMFU-T3Y4eWCfvY3ltrTJVaNtkONWLSl9uwuIk--LDZxa2eODzS_rtxMi_XGJv6do168FMwApczHKZkvuyYYvTS99EoDYBvXOd0WkzMTTWxlnHCA8EUv4lmaXvGle0V1lGsyuUPogIBPYiikK4UvotdSPosAH5VlzQEK5jQJzGNRSe8zkA8jfF9FLLfTFnKGJUh_I1kdU1oQyRSd118zhzreYLPbtZgHyl5P92qXhAXy9kQVVK6rBUJTRSfU_WJ-eLF2nqoZ7haCS7wZARetG76gnhm7sVi1lwAjRCmx7l5gtQSng0ZFxhCX5tABV1SSjFcTGLVF5YRAa9TATDycb6OZmcU_caYvbEIpIhKOIx9t6fdf77qf6_ujpq5nUSWhL6pGiI43t4ZwKSVKvD4qwfK2ZwZMQGcdioyQ0KaZGSND-a7dSlCJ4hRVNE7i72zT7M1cugqH0YwFuR-qgLPyCu_4ZDuCIqYfBfdrAMNCL0t4tnfpKqVEMiNLe6zDtd5moTf-gJIL9z_P7LWIcZSU1l0p91qLEzXUIWCHcwj_5E=w713-h632-no";
                        video_path = "https://media.giphy.com/media/uUTn9MknCgd4A8M5rL/giphy.gif";
                        description = "-Banco 30º inclinado\n-Ángulo codo con tronco 90º\n-Codos bajan mas abajo que pecho\n-Mancuernas suben rectas no diagonal interior";
                        muscle_zone = "chest";
                        break;
                    case 37:
                        name = "Press 45º Mancuernas Tocandose";
                        photo_path = "https://lh3.googleusercontent.com/TbaQW-bK4QhLx_7mAY7HtuprsjOcn2zPvoD-UHF0eVpprfYKZm3nsabVu65T6NtvQkxuSIbpUIEngx32HB_zRpfxpayBpb8LUYsWX_-u7BJFvkHhcU9CLehxU5PuFP0MMIhdqCvfC46nA0g_XlqjrrbJZWSB0Un-IR3_nmPplQWvEZDp_b4L6_VXagZn2MMjwwEKThRbZQn5a2nLIUebWFuVeK33fE8Ri9K-E5DcpvLlfUkXoroV4LN-xbqcc-D8XPzjokL25nFYyHS8Xb3MNkVr-oTq4m3KtE_xvp3uV7TEhuvIUlCOxSslBbcRDGziwqJpYDvgeCRUTINPAuEqNjScsPQ5xod9ybpUR3EGwtY2I6dUHW6ZLSFDtSXkpHO6Yc3-R2JX3SusRyJ0rWZl6VEslKSlhvBTBFtoGKGSo7J-sAWjEDCXavx6_v1iG22CNIxefQ0VQho4eNwWM34E900s1d2IshMVuyfB6LudMKFIvwfPkK7PrKPzuVuKlP0sdDgeOVV93GbBO0bu3vxKA3ASFjksCtE_Otke3O3Z-U_H3vTYjESkSG1iANIBpSk-HKLQDtwK9VbfcxuNsBwbb_kyWAUlpgIQUI1zQtAe6y2C1kOsMdJCKR-tirf17as-oEzpNBrGE8krghsP5eLNAiiXNWe_Lg24GahmVPzPF2Ha1DoORYF9SOA3=w713-h632-no";
                        video_path = "https://media.giphy.com/media/1zR9sWUTovqqrV2lGx/giphy.gif";
                        description = "Banco 45º inclinado\n-Mancuernas se tocan por los lados\n-Bajar hasta casi tocar el pecho\n-Codos cómodos al lado";
                        muscle_zone = "chest";
                        break;
                    case 38:
                        name = "Flexiones de Pecho";
                        photo_path = "https://lh3.googleusercontent.com/o8hx3aCFHAfKgM3H2cnXpie_0Y3YvPpO8OoTDUfiq7E29D1QMPeVU4luNJzDEa3FQKpCachrMViR3J3TNa3fyyj62qtB3cI7fkxCyXh1X3_AzPWetMnydD51Ura6L41o5ZlcHHJha8yVYOaspigCwDEOJC3GZXg1dzX7Uci3PCtwgSXWj8GDO54Y4gql6Ocw80Zy6rfrgC2YQlyNHDNpOWL8ecr6qB0wpHi8lTd6AYEhmKrDSKA-NCfreKO2YjjwD0CH-ZiOSA6psmI6pa-1MqJXm9d9iSR_nnvdsQI1U70ViyyBzjuhUO31vF8yAtv0MO5h4pGUQ6v6w0m-4K6jsZ2n6u2vkWP1zoyn-yfPoOmRmyvwSVwWly2L0jhJ_B5MQ6JVEuPRnpKaD_ktZWzwqTXMXStOZQfWIt0NjV8VQO1PA0Prwi3QkA4AcVmV7KvW-E6nOFgN1RT0BS34fPzL_F6URrQd1hBav523h3IGdLF1XFAFre8vQPRMpgV_3T1bJnmVc1xvdUPhUdMpezdcDo_WJIIZPzb1OIIPfzBEQ1UF6ntJzoU1PBlLWLuZvcsHCYkOzuleCIf8Fb7IVtuS2SBWHHAPcY3G4fop88Fmwj6cwg3EMtUSvDmY-qjRTkgFRKrd69aqA8h8l6suJh4n3D_MltAgpEkYrOCxZpjLESH8vn9Rc-F_5vao=w713-h632-no";
                        video_path = "https://media.giphy.com/media/2vr9OUgH61WJ0VXA5i/giphy.gif";
                        description = "-Ángulo codo con tronco un poco menos de 90º\n-Bajar hasta casi tocar suelo\n-Abdominal bloqueado cadera no baja (como plancha abd.)";
                        muscle_zone = "chest";
                        break;
                    case 39:
                        name = "Press en Polea Manos Interior";
                        photo_path = "https://lh3.googleusercontent.com/wG6geg2o8NhyJxHn5Q6hIPVcWJRPaXC_uzLPXcI31IiMV7dlCuM1CPt-0w-A0ORpE6EPD-Zj35-XyrXbFGvLWhQInHXtD-lxzRLGWeD-pyOFuK8wAfgZg1Ls2L70q0HQfuxuHORjN2KASKfPhqBuLQUNE9WhRVioNU_uMuK6u9KNJuEmJuvXdJBfGnslpgRJYVMn2pKrrLALa7lBGQd_EA6F0M32cTYUdk3K_WZFpWRtAKQIndqBDsC3b4crFjCN_A20BLBv8FOwkjurh1oz-e3EWBOAG0vJmNKEuEJGoTns3fmhw2fkaVRuY-fmjd9k8unRqyo8DFfrqd5bLOLEQjZtJTFbZ9cy3MUOnDXUNTl28Zsi57nNZamY9BXAGUTfSciY1iDJmaTvm2tSfURwshk55HobC_CRdXHfoh0FxyNaI-Po0O9ykzvOCxZmdkn-_E2pg4lkEsIrXidONlnU5yAueo42eU0gy-cuu0JqoTgHf-x9IgrlSH50Iq2I2P5gKurAOE0OdL7garWGJ-wX0X_XjV9BDQRSWxx_WmJ8VGI-YM9yJE7ROJpR9O_K7Zh9AO6saEVVq5k3wYeb12a3dYdTcg--bd8L9LbBVeXJWIgPJatgCVJdDF8fRuiadduO369-HxKxx7T2u964sKLGz9v2bvxhg5ZSrqCWoIYJVQTGDWNN7EjUH-hV=w713-h632-no";
                        video_path = "https://media.giphy.com/media/cO98Fsi81nrptiLMg1/giphy.gif";
                        description = "-Banco a 45º\n-Mano cerca/arriba del pecho\n-Mano sube vertical (o ligera diagonal interior-atrás)\n-Codo cómodo sin adelantarlo mucho\n-Notar la parte superior del pectoral";
                        muscle_zone = "chest";
                        break;
                    case 40:
                        name = "Maquina de Pecho con Codos";
                        photo_path = "https://lh3.googleusercontent.com/P5zpIRLvrhSQKAbP1aCHLsKaQjtR_oGR3D7N5Z462lJeRuP2M_1wNH3_vD3q7qg2rCfoANRZ8J3301K5fW19Z-pgovi7tfDdiz7fMP3JXCMdnxkOfyoOtoIyOvHrt-Cr5KA9drKukhk7WAEETFpQEqRzXEaCxKsNDX9hJlJu1zO9I0v-KziIx9Mi5GVoHPUCuwTYRn5fBG4zfN-G2hleEmRT6jCkbktjFj-xVi2k9MAKHVUAQd7c2s7t-DKwbOtSXL0qoEDR3AzW7PQoC6wRT-0cyymYVMVw9TlDqCFEdfIhsUsjhw5I094gReE7yBj82BjmJMlEbbzr5vJm_KTzKl30Buvz7rnmFSy3u2jBf8vh4c6EVBc1EdjqQ81Z2E2i9c-G1UyG0dluoSHMseR4adbGP72vLTnkqT95FwdFntUkMsYiOkuF5z5DFurCvBc_6w6ewDZhZrgHlL2MhZHUwHBAAVFpR56T0K3MwMcclnN4P5caASPkmzpzyBz4z62BxAmT7JrOE4J6y1a6IkDXRuuGuOVeaX9fjzQ3yKGrqeV9Nbjljzw8yk4fTyfNaF2aXnBCcYUKiS_KmG1OEJV61Rg8S0CG8IVuEdWihyXduHZfvCmDy_4JKYQtZYAu6_eW8BY2iK29-3HdSpKASw2ODqWXGafvwN8GlbpaeZ8z5t5ysp2vnd4CMRKN=w713-h632-no";
                        video_path = "https://media.giphy.com/media/lckzTgWUmCygx5AiDH/giphy.gif\n";
                        description = "-Repeticiones con un brazo luego el otro\n-Rango de movimiento completo\n-Espalda recta pies fijos\n-Controlar el movimiento";
                        muscle_zone = "chest";
                        break;
                    case 41:
                        name = "Cruces Polea Media Altura";
                        photo_path = "https://lh3.googleusercontent.com/XiOmV7qTmpy8P_yAmuPwIi_e37d_LWd-iRYnMRUjMQutyl3tLv01V17CIoJV1GKReuW0UsamSIQjvZiFeLApAN_J5Zgc-UKkVjj6gLuslUsYHQianMA8fLWnMAim2k9_bWm877HyUjI8kU_yuI4DFgmRDUsw2SDe6HoEOaZfoXrrfmlWjQqxMaNrOPirESH60Iv3X1qFlg0sMxNrPDIutIgYBiOSZLPuxELR58ptZ5Bqd6bdpPXFuTIqRs0QE8T-tyAvGSM5wCn9t8PwuhkSC9DHneQuGVtYMiemH_wZFQttvB8AaPZUANr_WUGE4vU3aQQPYqb2ri-a9OnOJtP41VgEd1xfjoEf50-ZcVvVM7DPnVkndQFZnivjoZWAj3rWKuqEJynLN4r3SrXx2eDhJ3UMvIO3Sb1BnCi3-K5CXAXlSO8WuvVsZ4Bjga_qPmLAXHoE1Apk_ajx8bwdQv5FaySj5_yayvR2hYomRtfcp_7g9p0sSVsnhMEWPXHYyJQhwdjiP7sBMvOPxW1tL3NOWk8_-oUo61AVaUcu3RPCHAGNYODOariDsL_BsXS1s7vyZ8j8BipB4FDZBYy1RDBrSGoKoxLFPYJQQ7yFe8bPoaDnYovfueXjJxj5VqQnB4wKBq0evQa5zZ7zaDtKNdZ408ojtXNL73WW76uEAx9tA5des7wPS8UZ5VQc=w713-h632-no";
                        video_path = "https://media.giphy.com/media/3XsYNpeIm2z9qcpmvn/giphy.gif";
                        description = "-Espalda recta un pie adelantado\n-Piernas semiflexionadas\n-Codo no se dobla, brazos fijos\n-Llegar a cruzar brazos al final";
                        muscle_zone = "chest";
                        break;
                    case 42:
                        name = "Maquina de Pecho con Manos";
                        photo_path = "https://lh3.googleusercontent.com/KrlzoYtbwtAAT39YF9gbm9YUZJnfv8ZOkjeELcKjrP99U0D9dIavLOYylx18ZpsVyWNI9Ir_97rqFHy7QZlOlM_kDzr14G8EXwhG8CdD6ySF99HKykSmVbV8QAn_RSAV1QnVPFe4xM08sNOJfK7Ro8k6q3rbAcb_x7v-c-yzK06G0Ev1wxNVihmYfH8VmDmCdSvbyPeVwvfbBPonPaGRLX7Q09_IjSIKmOFsEkWmvzKPhUNTDl3RmiUEQN_sQ6qqylzDN6pE8PQGfO9sF8vv_N1k-9ExKXgGr5MAIEXD6B_X2BS_ZJW1fejdEzRWoDp1-DUgO3nBwFP8ZC2YqBQQvJcKttcSriAWmpVdt191sDNmB5zafdFbYGm6pDPCYpKdLYHNo0Se6ouCtXhtAxLfMuHGaqU1TDWK6l7VWVRuRq1Ze-P1yrlR7_n8mjG5hPKpY2Ed2jjYXrTnqPkYwYpNtwsqbYhr_Wdm0B2gZThmvQJPv0c8aSKjr6RAMOodvfvnfVEL2cvTFpJnD2A3WG8GXJ-HPNGcQLz1z4I-VOmdLmFFGaxAeq_ChE5q1MJMAL4VcjWtpb7HMEvgQJSMv-bVhL4jSnnH4h78-nIVNifdY5JT06DNU7JX8msj_IS4mf0Ct74RBSmvPCqtbzmTFiIkzpP7uOslfx5hAZolLz5N2yXrt_clOmPemy0E=w713-h632-no";
                        video_path = "https://media.giphy.com/media/QOcdHH38L6p4XFeqCG/giphy.gif";
                        description = "-Ambos brazos a la vez\n-Rango de movimiento completo\n-Espalda recta pies fijos\n-Controlar el movimiento";
                        muscle_zone = "chest";
                        break;
                    case 43:
                        name = "Press Guillotina";
                        photo_path = "https://lh3.googleusercontent.com/H69ZWlr72fuRQ368wK5T7Fa4-aD2TzaiWeJkKU9HjwS_8aalNfk4oaJh7InzvbHkV_j0afjFrd1twmGgr3GAwaZmWsAP3yEEZhtji37teQl-1uw_66r00u-l2kaHhze25FeNwVWuniOBrBPG4sH2_gZSBoO1Yr52Jryx1GmTtA10QKqdlhflT2yGlZD6RUyhtX6ONWMP2b_1W7ex-NN47QkXv_Ec6NG71MPyqEbbS4TXV3Cgr_PGUZX0YY6FwZ0ag7X-upl-C_G56S1muDlhiI1FvVWYLXUqo1NVVQiBaQf569JZk_FeDkYdryLjoNEMAcU0DOzgqnmdBirAJHuzcE8Sy2la5IQFqIpQ1W8idtf9ykpVXRV_bDsxXwnh1fws8q208af4_tGwloSn1muSVyqNd98DhqFnT1ZbKr0bOGP98zSt0fIMNnfrlSHmOW4YZwSX-ZPFEl1i48dhOBfmfZoYh___zO7OLr3uqPjV2yWKyohnwr3PwGWPHzA0vJTNIXw--Ja016xwGhCdvTBIa-dKp58dmKH6lol8pTUAtNFqB78IUEwytv80Fdd9j-xyX-LKajJ1cUcP4CpM3Z99PEBSCy6tDdtMEKaLMJ2SnN8Iyo7exmVz3H6phD2iU5_jNTVZo6124adPXXoV9aaqH75KLhoEQ9EeQMiGFz6Omy4MQP_AwP4zEGNr=w713-h632-no";
                        video_path = "https://media.giphy.com/media/1yn2K3ajrcTo14Rr10/giphy.gif";
                        description = "-Barra casi en el cuello\n-Tumbado posición cómoda\n-Comprobar posición antes sin peso\n-Rango de movimiento completo\n-Subida de barra perpendicular la suelo, no oscilar";
                        muscle_zone = "chest";
                        break;
                    case 44:
                        name = "Press con Goma Elastica";
                        photo_path = "https://lh3.googleusercontent.com/nS9-psx7Id3yE7e5yp7FnFSADOZME0EaoRsa6xHuk4h5K2zisoZ4Iu2tL_nenCAF0N0hWoX20qwTEd5BrpTwSZQW-uBciR-Rjml-peqJZp1UikSDOTP-gzCvP0gbyr2FrM2egpG_CIfaxoMFDAxnQXdqAT-JfBSRHVT6YWy3zwan5c2OxvAO_UoW0LqBwhvuLcA8SxC06ltGUuAdevjXn4vfdcpggC7-MkbK3lko21ibKZllYh70p3i_cyPUtzNxvA-7A6DnvnWUHabiy5MwOnk7szX-SE0nJVY82kfAD7kzwA0vSz_79WCcNiBaOJC4X-_0ulsvd_pPtwRln-oxNKxf4sP_zBefOMLFEV0bm6krduCn304a9_0aTzW2DSX9tGbTqAy1toUhirMk_MbXw_kL4hykZ1B5u93Czpg24F2fdxckoq9ntSZ5dEMUNSSvCDIl9ugLEkCnKejmuhFHMtLyD7AOBxNowdSy1i2Z1DxP5CqvodyASwQj2m39RNz3Zf53CbltY16UUiAYqeCgyFAXKaiERkBXJIjEu02niDzMexHqLVvaAaMNqi1KKW8ZTE2AoeViUE1d3K57MXixHn5mXntCQaHkFC_KzTJWMiKu1-CpxGLNAj4b1ZhsVHx--p56a-v4ex7pTvvNPT4lRRP9S-GMjN5ZjY8XDy1T1ub_0xxZOScUmWJm=w713-h632-no";
                        video_path = "https://media.giphy.com/media/2Us45e5cTKSDNoZ4tf/giphy.gif";
                        description = "-Espalda recta un pie adelantado\n-La goma tiene que hacer tensión\n-Manos a la altura del pecho, codos posición cómoda\n-Movimiento de manos paralelo al suelo";
                        muscle_zone = "chest";
                        break;
                    case 45:
                        name = "Burpee";
                        photo_path = "https://lh3.googleusercontent.com/d8Fl6XMtyASFy0cWW8_JVGthiSJPbn-jQcxKphyDxTZVmjyfEw_vJAoGNU3UFKKksTm_i2A0bjtytYPc5o-p90WuZpNUWl0aGKjRmNZe9vuUAuF1Hb1dpxcFG30IeuJ6qEm4T7N9kfVBUJEK2Mo8bq5zPGJYAVI1E4bKybGpjezaNbRbx7xusCbs08c_0gIEXtB4peDVETki9tOVAI_KUGuuX91EmBSGDQzZ4hBPdiaU_pYgZVWisDYY5VzxtaedKcc0mFu4Wf2B2sEx24qDmJiVuEOkz1Hlrp6tDn2_tq-OQGuHj1D40Xqo5pbuj0GFsZh1FWmdd_I0SbGd6x5wzWH7Hia6BcLgVhQkUHlCiawjO1mr90XU6UAK8cqOO7KVkqGPMXmm8kWk9kfE0VhxmQvR8CYu69iymj_MbJT-Cf_mjWWKzgQYkj4KabDOfDdN17EX8FyCgdLvzTzS7cnWvCkl16DyNfPK9oiDB23ljdYAjYVxHzvaCz2RX9gY5v6hJ3NE5ANfAaVdItQMZx3PbclR-ev2Pab7cN9JZ8fkvjS8oYE_eUBBqsO48BS_PbikkNB2a5lr3GeYVCmlChDGA2DTv2aV9iCglEfnFk8nQDLPhQ43BC4Up6FmydM7KsGDqFaV95q9UiHeU-WXgZY906WNkHTvuTu69RyGHlmxJf25sn9oWLq07rLZ=w779-h632-no";
                        video_path = "https://media.giphy.com/media/kh6O1OU8Uuy9EwbTRO/giphy.gif";
                        description = "-Flexión de brazos\n-Salto horizontal adelante (junta pies y brazos)\n-Salto vertical alto\n-Salto horizontal atrás (vuelta pose flexiones)\n-Repetir";
                        muscle_zone = "chest";
                        break;
                    case 46:
                        name = "Elevacion Frontal de Mancuerna";
                        photo_path = "https://lh3.googleusercontent.com/ChuJha1AaU4qw5n3GICZnBXCk476NopfphD45EDOA2K0Q2zFLC7fYVj83cDlHpMqUpZZq2oGwdRMoZ57CKIEwnui5WJ7Shw2EOqLKT1ZjAdNaCpRbi3PWeUoebnM5FS61BvqFNg-sdDaQ58GYkerNm1LI1-coBkv2hZyFFuF6pm1WmkVnBAjFTfcgsTO0qEbW9avhpzczJpPOOL_4EKrlxTFDORwGsnYt0YzC1sW4aORNZo-RU6QBGBMSRI7yjWrxgKRRdvURuqs4iD1KmN__t0fmu1LOuxit3a_YUbhZkXEFgSbY8GYCS0rCGL_v6My7xyxGOIHXvc0z7wQFjycSZKao1Kh_dBAaaEdES0CTv5QMpdOnhgOe9o9IQXW0v67pA4WNF2_IHi1PaaxhsuzKW4eta8mKIcFPtWDBmpXbqI_ymtVSMVD2rnT8B6APE0lCR61h7iWKz_V2YmD3lwlLelOzpjBqVcR1HTNGmbFbpMgo8vegWBTAV6-znPrmfLYnObT3cqaaqSiuLtSDfFFDu-66uDN50b4caliQ6M__69fE06wOYoyHo7t1YRD76fZPV50IIksOBv0HEEPIhqOZUbfyTldDDSMewIygNSWJGBHUklrlqvloaOlEfbMQ8zI_OqSKzDCm-o1OeyD-hVP2LC-CAOKJzSHjz96oqmqo2EdbE3IwoXICK7a=w713-h632-no";
                        video_path = "https://media.giphy.com/media/vRMlxt9czytSmsEnn7/giphy.gif";
                        description = "-Espalda recta, piernas semiflexionadas\n-Brazos rectos fijos\n-Subir mancuerna (hasta posición cómoda)\n-No balancearse";
                        muscle_zone = "deltoid";
                        break;
                    case 47:
                        name = "Press Militar con Mancuernas";
                        photo_path = "https://lh3.googleusercontent.com/NPUEBPtpEfXtHismyFLJhDgBlMOiPagJ7kkHoMz0s6JD1b9ne7VvIvHXNnHueOW6h8hxlmDKnQisL7bvLUBmvUDuozZOdjpkTGrHjUKySumS3aUIa5vkuSC81odd7Dr3EFFAtdnM60nzZX3DEYh_CFwZyrFxSHyygqdNaE8n77xRssy1t4cOysMnEfAYm6AY4vFjwVwE6wQjpKLuTmduIahx5yDGNTltBJz-7qxRRHVl6eQ3ISrfIEkGDTMy-OOVIOcaSVetv_BL0nSCTXVtDLIU3F_CdPMP8BHx14xs3KQJ0rycdjxZpzsmoNSXit3BK13RFgUKiX-symObxer6UDFn58mzifrYaRDkLLhjjzqWKomEwnNBGF-didLVpYttSTK-L3nSAb557xE9_fjtryH-vKT8Rf_tmXK3SZq8nLmOIrarQMKogTVo1rSQwx0hXkqfNxCWbKH92HkhOj_b_wjTQzSfuItBHyjrOybCgAZiooTPLS0alH72_iJ-XETdIR63NZVKufMXWTXTYuFt_E_pzgR4ETUnX_l5ASLBgOexV84YUgQkyNiq6TAd-ZmjMK9ruf_lZahwUwynZavEV3vqC7Mjch_Gyo8J8N8mRB8J_HPXk71mXRB_wESqvNRlNQcSK7x3RRstNwyH8zu2KJ4jRozkNmcQSD-K8nHFLDkBhORPVVWBs59Z=w561-h632-no";
                        video_path = "https://media.giphy.com/media/1xNXuiKc1CNHzRJ8X8/giphy.gif";
                        description = "-Espalda recta, piernas semiflexionadas\n-Ángulos en codo y hombro de 90º\n-Posición cómoda sin forzar\n-Subida en diagonal a estirar brazos\n-No balanceo";
                        muscle_zone = "deltoid";
                        break;
                    case 48:
                        name = "Elevacion del Lado al Frente";
                        photo_path = "https://lh3.googleusercontent.com/7rwRjs-fzpNEKtkVf6FhXaWJfDLaRrzwMv2KhewmbzzV1P89-pFIC9Kt2B0_bCCFF0YYbpuw9UiYElQ2_FSVW5TkpVWdD4oPJRO_5RD8nRwVeedsv6ND1FLNXzsBy3ds1jHQBJHlRAJwWutK3f5ebkvE4ZKj0L1QPEQ42Xw9K21fkh1q9YH90ZK68AUlVWULz-47TTm-bxwLFLiapT7DUE7fqNdCxRwAEcf8vd-Tq5vxweOwlnXRJtaiULnLE5Yf0Vu7OG6rqB9IO92KOWpqi8zCNU5qgvzI7hGTm3eVdyBNbgweceYOU8kf-PTHnQO4uZE_P5gFkCqs_VJAt2f0xxG2wUf9kb-zp6eQPv87lsTQarUOEMYYtOiD61v4G6ZQ6yiZGPMuvFJn8gjYg2eulBfKGYjW9gJ2HUVWvVxhsprVheZYSSH1N2b1bDJimERLhxUTR3q8UQu7fdPUfo3dVTiWxpHlvClU7V4C_dLETp5N-2AvvNIDtGcKzRz-EDMJKZBW_-yAABJfIjwemvEefKDhZRKDUinoN05kgeYXgl47BeDqLmBsi91BJgk8hFFma9f-zqy-DanRUbDRCCyjVmidNPQCnzL0GR7xgejSUZsnKVafkOGkhBQrM3YVXFcUyh_alvg0IDJE8AM4pJGN5_iummOrWzwqY9lV--tAowdlRJloPS_Vpbv7=w713-h632-no";
                        video_path = "https://media.giphy.com/media/8rEV7amrTu3Qa0g0il/giphy.gif";
                        description = "-Espalda recta, piernas semiflexionadas\n-Brazos rectos fijos\n-Mancuernas al lado (inicio)\n-Mancuernas delante (final)\n-No balanceo";
                        muscle_zone = "deltoid";
                        break;
                    case 49:
                        name = "Kettlebell Push Press";
                        photo_path = "https://lh3.googleusercontent.com/GuLrkB8YXC1MEY7xWDEymgx7OuU2iBfNYbThHTLbjjK6yjqzP2bUuQghtNAFDjXpIhvPteXcwvJnvjMoBUix9rY4HMGndy29SoyOAsfj8Fa-FWUEzr12HFm0Z6_UhKlzLSSSG6ydTVCS3fU4adTpQruv17DCC0fnIojRKCZfcqeiH1G1XFnQ82X3y74sGh3MlHUTtnijwXKOrI83IhsgssWyVK3mHnJnHXliCxoeOXwM66fvyJWnrHkFzImjn9pEJpS_wosf3m-WNBMR3Vm233uUL1WnLKGuHJSRfL_EI8Qvo1J8hdE5Jf_WbIRKgp24VAVDSB4GPInc-DFw17xJ2jfDC2kYIv6RPwwzlgySqZv_kSSecDGzU56kNNbE9q9xKZTQ2PHAzzZZbQI6K8mjDkKgEjFL9HPmm_E0WpElp304IvUhgkyqmRDg6UZlC8RWMjEpS1rjDqN_39q8WHBtd1wYraSYtH2mCFbqKDMRW0sDAnctbQEyQG52hVmIazpq7b5uzDvxG4_zHnI3RNiR9IWs9ytqv11cxRXAQVLgVkil61FlgoFL-ST3huD4tHKdeLEZLY7nV11K14EjElbpn7NdmAVIGboeBweGWu4GyWn9BHiO2L7AAK9CmQ_6EuvWGPVQflpAJlFEQQ2s_6Yj5mu--swHVU9KV6pWsJMeSsB3AeqILIvkCcG1=w698-h632-no";
                        video_path = "https://media.giphy.com/media/1AIfHfxKGqCNWBPJnM/giphy.gif";
                        description = "-Espalda recta, piernas semiflexionadas\n-No balanceo\n-Kettlebell recostado en hombro (cómodo)\n-Subida en vertical";
                        muscle_zone = "deltoid";
                        break;
                    case 50:
                        name = "Remo Colgando";
                        photo_path = "https://lh3.googleusercontent.com/HqwTjUvthT-ULT7HVNZSlb7ZPn9LpcPBgCrFphL_KM6Cl4Clocjwi7np7j3q22Ds33toA58BZ6wB46Cbb-mpu0x0sX9V5r-uomi33PQe3d64lwhE4L8dIxmwrgO73Kppp752TtLLp1LIznaiCZgpz43gAeQbrJodzkskyzTcDzRjJ3CApCJPNcuS1CjA1d7bLlfoLCkf4N-ifuCHXCu_8RvuoGrtSquJwhWGOohJBIUUdTWNeeGyOhb1wt3xFVVhzy_6nzw9t2HgOQXtbYz-XGgcqKnJxRkFmcbOWcWxPr18hA8DRk9roxBG4oH7nsafV9DrwHbgnoyGClPx4zp-RCUYJTMIWatTm7Bdla_AhFhrOGBEqHmhhqPiVEjcQo5bSnVYi-5sjmqCxcF--0toyCfUkoBa0pbZ3gFyjtRXElGgHejWud_BKk3wNjiopAUDHoOoxNMBlJJ8XX1WgVlDKBbtSALgA_3KcjOApqZ4h0bi0FNuMgxhYnyqFLT-JXwlFcIUZKjPHqJLc-KIOaM6eY3D7w0B3JuHY5ZitulTwl58Zm4elq9GvRrC4XwyBt-pFAQi6iFOoa4g0_jZHNI4qF-XRf2DOGUsGUx-NMpFgey_wW5ULv1IBWuY9bZCk9bq22iQqaHDPVlIJztM7eeEkRbNXY5Pau047QSrIMLbYVPvDNYaT8ZNtqwJ=w713-h632-no";
                        video_path = "https://media.giphy.com/media/1sxVMlLwLi2O58000A/giphy.gif";
                        description = "-Flexiones al revés\n-Codos y hombro 90º aproximadamente (cómodo)\n-Espalda recta abdominal bloqueado\n-Piernas bloqueadas\n-Subida hasta casi tocar barra con pecho";
                        muscle_zone = "deltoid";
                        break;
                    case 51:
                        name = "Elevación Lateral en Polea";
                        photo_path = "https://lh3.googleusercontent.com/X_hAFBoGAHEUTAhtovzRBpzkxCgOyLeShLG5-Kv_lKlz7Qy2PnCiW6USZ3ol_aRdouUHdYqf8c-HFL7jgsp5qvoqfb84rhOYKQC-Ui_sy20miUZ8oPE8gg8aZWfaYjwkiYHbGKBoNUJuy_RSBTEcojQpda19t9tr2Qotu_ZKIjf_vAoqrExbx8YpUhXqnYZkfSVogAcWxXcI_u5YiVsXslaFkjrkdHkwIQ_nn6TtgqUISochid7qS6hDsywBwi5mnOA-t56fET2dc0o1b67utEDDQiFhkUwc4b41EYD5KwPs7p1dsXqckZGGo0A4AEV3300aXgGquRtdIf1OMey7xXknRORuslex3YTZeL1Vkz4zeb2FFGvRT2OwHpVluzbLSWjR3EhSQDpNVWEcWlyLPEdudo2vd_wKYvGm31nuxBlNEBJUk1B6y9JHKqJOzUW2e1H0Gdqu2EOmfYwndM6RpRhTrWKtywkktBl0M6iLWIUlAZiZcckNIJqhXsw24dFLJB7htRzQxYsAuuNz187FTa-2ruPIn_7ussgLTp6DSjfiaZjzP6nZENnP1iwKDbaZ5FUx8_q9m4TRfZsLeH3AMVOu_o0jFM_Yb-JQor7i-X4oz0q_HNRMa9ZzWvbPS7I4_xh3vdylRQrdiw69h55WaqIJw2m3zWSNt05FXJm7o4s-yOEMzL4XQ6xY=w713-h632-no";
                        video_path = "https://media.giphy.com/media/1itJhTMvLvL6OQQvxS/giphy.gif";
                        description = "Espalda recta, piernas semiflexionadas\n-Estirar brazo\n-Posición final cómoda\n-Tensión de todo el brazo";
                        muscle_zone = "deltoid";
                        break;
                    case 52:
                        name = "Maquina de Remo Codos Altos";
                        photo_path = "https://lh3.googleusercontent.com/RY4SwIbHZJgrOY6rQlRDJP4Yix7J9KAfumLegLbh3tq9LGKqkJthpaMx7Ek8QF8DOiqiX8o43jUUFklO1RFn3hOfDFvNhIXIJmMI0RTGneo4kSNpcdT22LQ_cRwRA2KHV1OFaT6l7Fy-FTwMdV9ItNREExUq2X56su7_ZD4zZjrHGOmPsRVC2pVy46-T6ByyfPWmWZr6Zklhhj8ApJn0E2ToGCMjQW8xKiArbtWMPcELUC2lW_mQWY7iyIUj7T6HsqJpnaYUg-fm7mcUR7onZkYi_NqdbBFXdEy586iOJSr3PEzK-WLqTee1EzxHYKTCbH3rJkOVyD0OocLt5c6wd_lrhMMZH9J1B44DLcTtXjt_eXO3BdF5iZOiIASaq0M0dnO6e2GWVC13Ia5EODdQtDjaB9eTzRXSLGuqvsBtW8-BDfvUHyfIOuAFLGfNFbCnXheNvuyPeVPwZUBETng98UeA2nXjUHzEH3qulK5oGPEUcyX8Ke10J5NcaP5NM7xVwVF2WSsdtTTFiyOSS06DIXobuee83Lc2DGgqCOzq5mocY_v_K8dDYA36ut-0pYlFJObF9_7POnfCsKzBAyCkpkObk6YLOEKsz2L_-jV-zcbtIkNCdf7RMniS-K86pca3e48ZCb3AmGYl76D1DuO1__ogSVHhpx1uMDz9Q0MRJXqz_BHt3KqxSlW6=w713-h632-no";
                        video_path = "https://media.giphy.com/media/dtdDalKlMY01KECU8Z/giphy.gif";
                        description = "-Sentado pies fijos, espalda recta\n-Silla lo más baja posible\n-Tronco no se mueve, se mueven los brazos\n-Mantener codos altos (sin forzar)";
                        muscle_zone = "deltoid";
                        break;
                    case 53:
                        name = "Maquina de hombros";
                        photo_path = "https://lh3.googleusercontent.com/6c9Ri3UMF15t0ZekyxT7tOwQWAzklHGAtPUVafauxJgTvQOOskliiZkf8XVt6Ekn0_KLaqC3_dIILYneLaxltRJN_LcULHtBCFtiSnHi8gnPCKy6uXsoXhfjX5VGVu190W7keyUzdWLOD9zIX0W2DqaPMgnHWiH_XP8L37kBJRmQ6-6sK25jTmxLPdNIx4327NNb96NKuZrgKqyyLBKn7yB2e3JW-Tu5cSpapRNYDd9pVhh0SuALzg0nSyYfadyVlrE0pCm5aCvw5ZBuhW49KwqHHoVXaWWfGHEmxcLoM8X8g00DicRzS0JJ2gkc7K1qWbebahKwXt65GG_qK9Lq-ZNpIx5o-n5pvilvjtf3XqhHAFRGRqpFGLFqkdr0MjJcIJOOHG6t-05fcHMreAt0UqzxdDenvlvaPcFb36Hu937zZxwEq81bPruFEl5EMamIVxiJmnulvNSTcRHkDTolpX9mfuukT4k8YLskvB5fC0GgAqYhSUO8GACtUkXvfaBpQkPE16l60DlQwTnzPm9a-XYvXOyE8O06NI3qGCp9GEWVVT8CyWLJLLMf3-UXiYmhuDrGHVF4Kl0txTY6GxW3fyBOHfOJnjRzLdN9ouCClYl348-36gXrR-vYArbNB1YJ_LC9LWkPjj8cgxIs7EcZ_yxivu8uV3Fe3wcm_aGh5A_l3eZ_N2Awwy1i=w713-h632-no";
                        video_path = "https://media.giphy.com/media/uADjhaAG1c0rzmuK9R/giphy.gif";
                        description = "Sentado pies fijos, espalda recta\n-Movimiento completo\n-Ajustar sillín (posición cómoda)";
                        muscle_zone = "deltoid";
                        break;
                    case 54:
                        name = "Linear Jammer con una Mano";
                        photo_path = "https://lh3.googleusercontent.com/M3kR8BatdEXkDnmL7n61-PDwjeWPHzr2fenrF0eqKT6HXrM6b7zyx-a77JVh6IR964iP6nmD_MHWxln6QcL3ShVJFB3PZYaskH6kZmPbTmdiU2lxuf02pFX20_ZYhA5wFKPuE9_r1a5w40sHn0LhSqDTyoW0Xnm682tjGY2eltGJ38aWsrjCfynTCpsyjeKAKsLhoaZdpnCDtBDylrf0aNClIGS_rNXiCRatCQJ0xiWWRSyicTvdFhbCcHbHKAq1jyXHQ9buDso3O1EsMM1LQ18ORLknhUWvGVXqILR_JEVKUqm5rflil7zbUyz-EiAtoxZQtqAzNpM8CkkHI8kdXNK97isTSrH06Ahv_IRn6le94EPe5s2vnC_uNpxHbWiSQfCmdQP_cA92BoE-_vSBJ0_n3LbM8sxbSTNU8J8MgANdMHJvZmXCrK5q-7xceMAztAg80xrtmudQ4YEuBIIfOR0NGFqDUk2IFWyEwaeQG8pNji-AhvXkqxsevjjzVQtB6pufWYw_ZubxwlLyNJ2aYZHVn0Bo7QnDZZvr5v4bBriN1u6x4i2lEikl19fKa-EchXitlQxluYKidP4-MyKCbhwg2ELtKXskN9jqrXrQGAwbZoLKN0sa4oCOUcOSo_phJHtbhEEUWWocNoz1BBNyd2SH30iMJaOtwUMDJY5cOpDnjiaAeLPoAS4B=w713-h632-no";
                        video_path = "https://media.giphy.com/media/4QF0Pjf1tWAhcZXwhf/giphy.gif";
                        description = "-Barra recostada en un disco (con soporte)\n-Espalda recta, piernas semiflexionadas\n-No balancearse\n-Movimiento de brazo solo";
                        muscle_zone = "deltoid";
                        break;
                    case 55:
                        name = "Goma Elastica a la Cara";
                        photo_path = "https://lh3.googleusercontent.com/QBOAt6NSWuTxnMyw9WZ5bPpAUMOzXxbYNTIM2LACcQTz0dWGFlaUUWg64Rq5gfs2AVFrhbIWcRNrcmuM9-R_8zB3kIN2XsU5rMvbxZlcg2CKQ_qWuhYsaVN42XRVMg3ugtam7JLyK31CD7C6fCsX_KRSXmzg_2rygwnblicRHkOoYYhALCkWwruKEv92Nq5ArxHwht5Nqp8-2gD9PMsstramqL_72jorT2AU6lrwh7tmmrLPftiLKTLBhDBfEeMd0nAoAOVRtPMdlfE1wwpLQMxGYSbK50NE7om4LZph2lQO9wGeO4rUX9KUk7XyBki6ig8QDVVckUwu2Su_7TR9FGZQMKE5CMs1SkoEnqOE7Hq-ZTYMxTbpg6BDJPcy1cMmZovsDeXPrSzACcGokCTJ7l9qUcm0TCtAzFge3JPmT-l6z5rB6LD9y1bZ3kjfUcmhCq56emmAOqjORbCT-gF0Ja1tyZVqthoKI4WVQyPFPC9hVj0O8mf3h1svabjMtzkAjosa8Lcf9qXLAiD5i--CYpv9ZkBBQlvpfLX9yaBWC-V_DJVkn0DwC_S-WeloAIgrpKfUYxgVd6v-UUQ41Zzwja5Gv2VQB8ycnC1c1ATSwZ5pXSUZV7CIxB9GC5VXVibB7-5w2Iud6mJqOFF11auVbOSIcnTLZVtO9btZTE470wWzJfUWvKO4JJHf=w713-h632-no";
                        video_path = "https://media.giphy.com/media/39zXHWOTg2JnW9RmOJ/giphy.gif";
                        description = "-Un pie adelantado, piernas semiflexionadas\n-Espalda recta\n-Se mueven brazos solo\n-No balancearse\n-Tiro hacia atrás ambos: codos y manos";
                        muscle_zone = "deltoid";
                        break;
                    case 56:
                        name = "Remo con Mancuernas Codos Altos";
                        photo_path = "https://lh3.googleusercontent.com/3Lnaws2ryuOUR-iJMnXX79FaPamJ6Rpy3aQdHt2r5JzyfT4OWS89txVDpfNuLkV7rhDrHOXqPEsMUvGIaAsMvih1Msz6JXM7iD__TCre0mz23wNmaNRU7s43eUf8p71slTFGmNpzgo3iKYET1407PljrnFWrly6aNkHMwILVpOgm-v46sgm5C1tCGsbYaHUU-mV3ASRxD-yD7dJTRbzqWDsaqb2Q13mSeg79z62QgptcvA66yzN7BnGP29-N0H0NHQwYQZj4V2TlVenESdPClcqE6PWZ1-u3-hinL6neTfomnGpYt8km4AmvJJPdIaTH7ut2n6sFPltGts9r_QBpAfiaugPNw4hFnBci8UbVGop19phZxcttY9wmlGB3FraUTNneYZX95vTK-8qSGwYJwoyqcJSVCknIHv0aZHsKd66Yl9QzpIxq3uaNyqJzNCpu2SnTqXNUldSh-aMNapFC3ns0RsbDuRtKYds2VnARwTvpPTuErS81HZT_W55fFZA8oDrcBSMPvnm4ilFvSAvsOwJXwFWZwVS-cs88DVFUOluMVzh8uZTBZTy_iUwAtA9PqtVJ9xmVHBRpc0tyfx5Dl3AAHzshXvcczWgSbw9ErxlbCR9A7pXWl5MnW7FJ6p_mrwLFMozDJ7t2WJn_eo0r8zl28ZiLMFAyVMKrZd6gmwjCCL25r3HzwcsX=w713-h632-no";
                        video_path = "https://media.giphy.com/media/ccVHpa23Z9moGNfeaD/giphy.gif";
                        description = "-Espalda recta, saco culo\n-Se mueve solo brazo\n-Subo codo vertical (90º codo-tronco)\n-Brazo estirado relajado (inicio)";
                        muscle_zone = "deltoid";
                        break;
                    case 57:
                        name = "Máquina de Gemelos";
                        photo_path = "https://lh3.googleusercontent.com/bBzhkNcZZZRGovI3-3EYOGKb2dmERmA5hDOyPzqcFxEFdgFSmmG5SaeJXIPsqP9z8sudAG1CyvRr0k7lOoN6ZxgNOEVm4Rd3huLws0eumKmRSP-HfNEyczIatyZMF49OrF9r22iIY9crDNeRhIbKpxxU0LBw5p6O73zDdl6H6lndDSxG4OdfMT_CZDPj_BMgbs4oOJA2SjhkocrFnIT4Wr3ipdAZCmwhaAMpgH8opx06YjFCEukBYlEBkG1D_Y7seER5s65iqlZpLkZBhFcO-zZVog13BJyTJ-zjzzqZvXv8pydz7So7IMszYjCLOoRlZY9w18-hNECg2VO0iFiKP97Mym9yolu-s9Gqxj4bWTRWhHgIfbeRFDk520mFDNPFQ5UWM3P3wPSgg4GUt40NvLQ8tt6HR32FBjzSaw8_fplWwTPwPT7m7s1PxKs8c8CeKQs2z14HB0wA71yOwY_9dl2AtiYqxpRZTGvkRQbyniAMh-lC5hZLbx1QPggvsxeTKD6L6bk5q5ydgGJ6EB0mgc7o4purFoE7q8UU66GFHYlLzRF859vvevBBGGK5UVFveGVPEhY8-9g-XrnWfJBYzWOLZeWa6WoszLxEhmg9P37c3Fd8DJ97V-ba1xIMM8L6ZWAK1xdGobR0P8DuJePKiOv8NSSTp--CC4641N9VgmMYk-f0NnUbin_S=w713-h632-no";
                        video_path = "https://media.giphy.com/media/3oqo0A0C4UPKknPQkc/giphy.gif";
                        description = "-Espalda recta\n-Probar sin peso primero\n-Amplitud de movimiento";
                        muscle_zone = "calf";
                        break;
                    case 58:
                        name = "Saltar Cuerda Pies Juntos";
                        photo_path = "https://lh3.googleusercontent.com/I7DPJwju-q-FjsFQxjBhnSrl0oc-TnEbhYbYFPOdEGl0W_-tcJU_Bc4PwRvhW9LMThd0-t1dVCxsvit08KO9S3bw1zQs0RJpo-Q5yRtoblPu7tNvQFssthqgd9pG2_xQgDRwB8wwkkmOV-NIDqxCJ1hRb5nqMHFd3fw1WKgxX7S3o4uFY_OCrWmmsaIvFcT9hxr9aK7d5LnSjeF-7h0XPFTBkldIFrcuOMLi4841DhIbnyZbu72KhSLJKRryIvAYdj0S6LCCpX0P_xQnSJ9NA6P0xNxfF9LLb3oj_OYTvpOvjmJQAkZVL0s7VMM2E-Lv2DoNL67dIeL1ei6uPBmOpwyQKjr0rUJTWEs1V3tb6cNMX8B0CQWBhKphxr3LggaA3AEF5G1xAForappuhlcNgmB4pygCaL5SC20sRSP2iHF2kRzShLz_2_4fBzd9VHkn9PnS0dV7r96AY-tYm6_YWmgbtxq72ADzPNdz8SC2sNg8xuz4W4JDLrhip8i--izmq7byCmMlRYtb0CCN9t4Ab_wOgx-Wk7yqsafanUKCCJcL4RHIKvBSHoVJZsF7y4RrZeZIs0FZbVBZdiXG18uV9U1FxmlVkjdzp0GUYXo0c3sRyrjOcUyn9uRr7-gMC7o73_jieNb5d_qllzpXkjSP9GQwYN5mZN-t0yM96N0xd5OCmuFx_puzcw-U=w713-h632-no";
                        video_path = "https://media.giphy.com/media/g0sEGJ1mlHWVVkXZtf/giphy.gif";
                        description = "-Saltar con pies juntos\n-Flexionar lo mínimo rodillas\n-Movimiento controlado, equilibrio";
                        muscle_zone = "calf";
                        break;
                    case 59:
                        name = "Maquina de Gluteo Sentado";
                        photo_path = "https://lh3.googleusercontent.com/4UVw5OZX2-8q6GoIujPyxcGVbV9pU6pQemaGHh_L84VVNBZrAvsIhBoJrk4k3_7vHBf_SJOa1mi3IITL1qkHBQqMTI2FPhKQe_EwetZqOsjbhe5SlaIszV-pJjGX1AzfzSW9ZhuOIahbO3LQamUD6k4eTvslwpgCN0Gb-Y0yS829xqVzEi2VAN-OpFW-lwWTGbtAD7I3uVUrzuztM0kCrF7NjGiXRpc2eDvTmQ4LMEERXs-W7bzisdw5JOyh-cXfQDRX9SdH7nMtlDpZEH2neiSJcBxc5uJ_J00FLNoDM68vc_fH4kUTAqLnSJY4tIZ3Hs5QF-1fwsl1E35cq-J9MjOM4Z4Ln0Q7PTrscnIr9rKYiGyDMzikhaiBeLAoBnTib9XP0Ig9Q8g8WX2JNBpTsx4Cxxgg5Y5ZOFHLVlSHPGfHzX01AxbgEifPq35ZtVYlyITKa3iUVnLrnZLDOKl1gx_ZnIkbnYFYg2kNaejMrc1HpJdN9nWNh-kpn1JboU80gOGr5jKR2tatC_lFXN8Pt4ZnQvdLMu80U274oz6_4IqjF4B6GHK_gEMJivNUTiyU7IgGJwLR9J_UgyOIrwKLDPnWEyq8BN0OhQ7TLFWRJLQX7UPCiEwQlewh_vOcaNxbcsKyZKirMBgTSdzPDwgEs0GfncEtW2Ji-8RjELYTr16c3Cmsm4VYyhmb=w713-h632-no";
                        video_path = "https://media.giphy.com/media/5bb7DtIqeDZzgW5pC8/giphy.gif";
                        description = "-Sentado cómodo\n-Amplitud de movimiento\n-Versión 2 (V2): culo aire me aguanto con las manos\n-V2: muslo paralelo suelo, mayor tensión glúteo";
                        muscle_zone = "glute";
                        break;
                    case 60:
                        name = "Rotacion con Banda Elastica";
                        photo_path = "https://lh3.googleusercontent.com/aym_LIz0ITRwJkqHYklsmTIwRp6Pi_ALjQnmY9P8oG4nr4lYZP0NVBOt9UwoQ1y26bu0u6sSl3YhZyOcMc0JFN9eE_2DeRA1o96rheM9aOhohO1AutHBwnLu6HYkkQyJl92vi9_TyaXLDe5xzVicy_Qmgaggw2FVyXpHFy8SQqu8eFS_t3RYCddTjf1sdUnT4r0mABWd_hRm67mNPjIxG858baR80LnUKQdVNrYfXJgppseLvh5VVC6uO_YvDjGyg8WIFSUlZ4BgRCWugGpsO2rgz-z2t8uFMoWXJdG7DUz1PJW4QFua-C7FUro50jx9GYiiqPR7CtGHfCbYlIlQ8quLeZzdW7DypTNP3iNblLKIZuFYJUCB7ob7h8E9OkwitAG29I-fx_jLTELiSzQzWhUH0TtMvm1cFwfjNvmxUFdBV0sBTvvDjzhROa-60HOHOjQcIqH0aAVWUKY0A7u8YeSsxuaX9Bc08mm-odeJ0jH7k1Ktg8WkjxPcNItvBUCRVhtwUkQjpp_DS9boj6Q4eJMCTtBvWEmZnX5sm1llKbFWg26b9pmr_MzSP23S5Lp5jPkiANfG2CPYDzsWg0HQu-Nq4zBFrVd1kDyMTW-ZrNCs05O_1dRm1KQbv3doqPHvSjix7kZx2BfLEx49mpbZD6NkSdfWa3-hNl6EqzJ-i1d_bpSC3pXHc4Ag=w713-h632-no";
                        video_path = "https://media.giphy.com/media/1lCGZxbOoKwOOZDCkj/giphy.gif";
                        description = "-Banda elástica en rodillas\n-Piernas en V\n-Movimiento de la pierna externa solo\n-Resto del cuerpo inmóvil\n-Rotación, amplitud de movimiento (natural)";
                        muscle_zone = "glute";
                        break;
                    case 61:
                        name = "Sentadilla";
                        photo_path = "https://lh3.googleusercontent.com/zYwnokeZwpfzDTV1NHJuIjIHXmyZEdr6dePmcY_rGp8l9sqZn2zENOUlbie4NNcDInAZdDvnOgjUfahsWkXT1BA8ojwFmyMimGk2kfTGnsdUbJf9fioepD7bznzAz0u2R4mj5YpLUn4o6TwApY-N8KwmjyfNo1ERvko9QFcLeTRkITMJgpGWNd6hDzH62jza-17FdBF4yRYMhRio7Lj-sA6Mm8PxFiMVJQTnq8KfMif0mYmmlChrpwfF3wOEiajy5Q257mmiy-Xm6X4wwwD895n5iTz-SAP0LB3klIKD0oqwEt1qWwB7dzgxJojh_HxgLbR_oOtamT9l_X8tkAZSsbZSNFtsLRQq2CBxJaxUXtxUQ2fuzsFF1HQlKJG9I7vTwvvmlSDlBHKRoHHFpFHAbMOhbgXplKcAmGYIB76Sr92ESsc5Le5J0-S-RkGGzv2cpPCF7LTvaxsi7xDvfPoAKCjapsKmGIAc3-40HeNw2KNBAsrD3FGtnj1ks-EO96tctkb0MWok9Wwrrzl_UzL8vxNCCZjj7KINhFIHSFAOHr4qZ-ciPjnx4JZiW727u5ymWpSIJUxNL1096tU_4sCZbLfM-P1kHlXW0cLASu7hex7rzRjKarQ1iGkweCdSMJBCD44FQgWxtciymJVcQi64QOt2de2ysh1EfXR6R-pT-yEZEEDuPQWgLjs1=w713-h632-no";
                        video_path = "https://media.giphy.com/media/oHxwFONw1bloV3POXf/giphy.gif";
                        description = "-Rodillas no sobrepasan la punta de los pies\n-Sacar pecho, espalda recta, culo hacia fuera\n-No perder el equilibrio\n-Bajada un poco más de 90º de rodilla";
                        muscle_zone = "glute";
                        break;
                    case 62:
                        name = "Jumping Jacks";
                        photo_path = "https://lh3.googleusercontent.com/Tb8ni0y3az1rJhZ-2S9DofuibTy_s2S1yjetsGaZMMdo1EfLC9cbbE8_q2ytLl1an-BzbZ17kawng-_SCG8a-RxSxK_OHItkIhH83jnf2C6ZXS12qLYAD6PGkAj0IEm8Q6o-B9IgzLzYBat0WJTuDHBskF7tNUoQqquJXpDZkgFuDmulvtxlhA2WC7G9am-Brl_5bCnXxsapiFqZakYydUDCRmvf74ielEIka82Fto9566lFR1u6RlSRoGvl41GljImXBeoLfERdlFk8Zn9GRiyCMk3s3zH6LS6V-tJIGMgbmArfjgI87xzHdotdnFnSm0dSUcB76g2FBz7iKg3dokY80MmTVf-JPc7ADkJ1WIBEkjDZ0-eXlRKgKY0YuH9GD1zIMfLyJZfvB5HcN5NIvFKdjxMixqPAqekewai9jIVFWmPUCONnFXWhgs2ryTLLmUONuUWlhysj1Ts7_w4SFjRAx1jHxWiWnM2TCpTFEWGWdSBNXYxLLBgkRIF_JBdCdYL-TC429CiDlhzV7s8BbXIoMhS7hHuRrBGesGLusFcwGnoi82d_4kmqe9Rgz--CO521-Xn_U17U0yGNhl9Nl_bk31pn_tm9xx249lohSrycVEAr2uMoKIWmbCsGS8cIOjwVdox9A2DR0TWSnMZLz3k7jA1HX5AbmkloxsEV_SBz2Rl753gebmDp=w713-h632-no";
                        video_path = "https://media.giphy.com/media/2fMaRH6Et6wqzsjSEv/giphy.gif";
                        description = "-Dinámico, explosivo\n-Amplitud de movimiento, marcar posiciones\n-Simultáneo abrir piernas subir brazos\n-Sin desplazarse";
                        muscle_zone = "glute";
                        break;
                    case 63:
                        name = "Elevacion Lateral de Pierna";
                        photo_path = "https://lh3.googleusercontent.com/AZ6BXfXF6sUoSvGfEvLt0uf5VnVoJsma0TX4dQ0A0yMH3TbA5WSiDp4nVFPGYAdkWcvcY2ojECfDb1oz43XCd1JhhxS50iBHRS48ospDmnD7AK0wHLpCUMP6Sl19CRbrePY0AVtJbZaBpbBLS7J4lodyYe9jcHdBGT2on5u44SSoXhpdJI22w21rqN8tO5vsb3Ja65Q0jK0LKklX_RjYX9vO9Ya5Qe6J7IokFKm4dKHnUtkhub60Gen2uELIzHFNAb3OHcSkZtoBQmXmvRtfL8SDROgZwFM7SusXjwuqGNzaZlP67Zy8TgzPvO_svmJVT221PnvTwitb-tchGY2lgDA0WUrTFbz45buPp48PNPUBryCMRTS7bCWdudoDTBC7Or7gxxkFhYbOznwoE5DP8DJIbrxJYlp9ciVuPx4VIAB6LanvCQeQlzhh7JLuijGzY_FJDcEcjj0v_TRjeFVhoHpxkgUp5udxTZdCMZd1UAkAJ_j8ftoYfA42D8ceLPKHEEFl7MdcPPLRo93_-odOpaGay-3JbgkKnRiJFR2lgRHArBQ-yur8fpyuohCaq-iQYZdNagx0X8kA9b71uvpyyl-apjLaVmD4JNeHz0UwIHTb9Mn7Jp-lj8uiPICjTA0ix4isluOQv6nq5fF1atgI93X_iH_qFn9MxZGsZzFVaZIpuM64TuVBUiop=w713-h632-no";
                        video_path = "https://media.giphy.com/media/8c0LsbyUfBa26i3eYG/giphy.gif";
                        description = "-No perder el equilibrio\n-Amplitud de movimiento\n-Una pierna fija la otra estira\n-Movimiento controlado, evitar mucho balanceo";
                        muscle_zone = "glute";
                        break;
                    case 64:
                        name = "Cable Kickback";
                        photo_path = "https://lh3.googleusercontent.com/UsxiAuqfTdLYtIYO2B4KuF18YO3tBEx4yg8eq0s5dziGbN7KWs96vNb4LXgCBbbCKnYoLU_TD8ihe8qe-P-z5beWF30XWyHzwWp0hc2nZAjwN8dEG4Zo-9kYaF1vtaQUUqXNvoYJTVpMyMlyl_VVLGb3GVJ21vC8n9MZtZ0zujCPA3VP4sZsQM29Ms9TdRU2a_nUbcm8mZjeJlcGX7Dbt_vm6m8c-hWhTWYcaJhBeU9ONi6u0Z0zWPqCuzTyb8Hsd4ez3mtrjr77FDAvyMenQnuILBwTI7wJaQ6cgOQBnkrTOvHiUsLBQPZRVv1sf2gjr7KraaczvAiSCzGL4QabdHEpU3msM2TYpwOCINCVGQ1EEcdpBuPVboEk-zE1Zj_QAi_Ayu_Z7eCdfVXr2kQk45jZeV72eVOqvMmSqqkGVjTZL60CsH2wTyvQ2fwmxOXOEuHVa3k2iRGx2G6uIUqLrq2uh6ds5mYTMu7UyLQrsGmcdkN3HwJeHrlUBfC6z8irxVkMfTeG1D5Ewvc7xuhsHYkbh8tNcFFe1E4wyLyj_JkkHMzdf-fHffak7PO2r31gtHNnTqSEnJgjmtKS0uydpkC2GELVVYautIlojlpIt0kPrw9JGM1aWOzcmBbc-dz4x9mY8F7rD4gRng1lXoo_Nj8zFk7Wx3JNj4oPp6V205qYOpWh6KDWnlNx=w713-h632-no";
                        video_path = "https://media.giphy.com/media/AFn9eQxtLAn3TyYs2D/giphy.gif";
                        description = "-De cara a la polea\n-Pierna estirada hacia atrás\n-La otra pierna y el cuerpo firmes de punto de apoyo\n-Subir la pierna lo que se pueda (sin dolor)";
                        muscle_zone = "glute";
                        break;
                    case 65:
                        name = "Pull Through";
                        photo_path = "https://lh3.googleusercontent.com/2tD2VETiA2DItuNi0vhgZfImDlWBdCfjLYMh7rQo5ADw3KB1zfEepd_TDKvgll84OHRXe1oryK1NlgTe60FopCHNR--C2gnowJDRUOqIYOB6wonzslI43JXJ19ymUfkNNDRKxxKqxunkokbW9fZAMTW2tcgLVY3XWAckYbou5dyDXSn9ghczksrUKkIBzSBlu7EaUvQeb5L5SujVKrtNAdrAuvtfJQldv37recEgReV6eu_7waKZOXxuyViwP31JJTV1bZHermyNqV8zX2agWdMIbpvpBfIRYCMaWrnDXL7yKmkgdl_EIfhxAFal6UX3GRfrAjPcxjeugLAz4iBGh1VK9TqQf08Bggh-jJPEWo9Tm92b_Y75hZ2O7GYPHoPM5M785Ic_aTUn6kPwHIdEwUrUD3H7iEH2FZlsq58NR8BfnP5ZAkNALUa5CChxjCNRQT7WUeNUeiM0D3q-IjfMollStztkPa187cJAoGnebbGSv2g1hryuFD8noeM73EZqRHSRM-OdOOrGKPN2RoVGHuTKxLmLG8DamAGpPgT7_2ukWcbVe2CP_ANR-ofEjlDwhDTgqRDye40wKfWDcJgaIfVoFuE6o_a4sdwIv14Pp0lhhl1c-qWf7CR02ZwoTJWcJbJfyc7g1ZBS3zbp0vCfkgE90RcZlqtyhFi2V4PzAG09p50bauVsKwl3=w713-h632-no";
                        video_path = "https://media.giphy.com/media/1zR9J5owQrRE7ILcpj/giphy.gif";
                        description = "-Piernas flexionadas espalda recta (inicio)\n-Desde esa posición subida a poner el cuerpo recto\n-Bajada controlada\n-Separación justa con la polea (tensión recorrido)";
                        muscle_zone = "glute";
                        break;
                    case 66:
                        name = "Maquina de Gluteos de Pie";
                        photo_path = "https://lh3.googleusercontent.com/nxCQEdYUpMlJS6tKp0NhtI7Zvz8EYQ685s8xk3Iw2mxju7dHSQgRUBZg1iPDBMm8fSnbHghkecHQ0PkDyKDkTgki8gu_5wq7NIeL4y_YOOx6-QN7sT4NZHrQLCSzQjk_ueur3B9QF7V0xwb8aC6PFxJyVMCYoD0tVQDSLGa-_a6XnqSDEoWyHEm1KtSKVoeHZR0mKMvR-Rwi3I9wTr4wlYmqnVKgguT-ya1WpJ7PFqvaDsJdcnEzMIbFRxE2t5zrbJzTz9q8agqv5DhIbpr12F3XnEffYSBmpy1TW6fvwjCkr7lrJygfDMO7nwdLpLNMqDzoQ1KrwXDFvZsbY41Es_-Pit_a2GweghFGyq-dquzcQZZrzZ1X8N5C-vgCPEGxcfS-L5DGx7alsV0Cj2-l-eWPErjiV9_WyDEojXn8A7qmW8C0mxZB7pnIGs6dBSMT7neScke5Mn3krPmP05zwYD4hrlB7dkOXLLP57bFp8JBFrWZgf4BF6iuCNx4gIIn3dtCm1mISq8tbx2ALOe-5fgaaStUMM_ruWtyMg7E681jiP1hRH-56lNJ21E4V1hRsoS3HbbRq3Z7R7i_NqVImtVad-aY9sloSMsvp8B1Nrqtw78-JXg8So-KA_PjMX7vcRml6uo-0LxnB-I1Rb-0r5NNmjyBkbvf8qamoBN_k_B464zaTzMcSyjnK=w713-h632-no";
                        video_path = "https://media.giphy.com/media/5vYnunLwmnPJAMFGwD/giphy.gif";
                        description = "-Amplitud de movimiento\n-Pierna estirada firme\n-La vuelta controlada\n-Sin balancearse, se mueve la pierna solo";
                        muscle_zone = "glute";
                        break;
                    case 67:
                        name = "Glute Bridge";
                        photo_path = "https://lh3.googleusercontent.com/_mmQkQgVeixqrX-M6RQ_DSZ4lPSns3-LcWlPC3RBjRoXZLbqo53b2jUpBtLx3qLvmEZdAjJZyLqtyaDOSMLXbuDQDzUVZb8bKYiP6ZeAb3M1FPTkedaDAEDBGAk_t7dYqd8dthI2mOYDpXgVC52vAOqZIQgW4xkv4mKWkM2B2bKPYShCegWuzEq5IrWKWZ1DFpV_suPgcdvdT73CSHqvhF5_AJJSOXKEhJulFCeLH7tXZuVIm090dQlyM2NZ5ZHVO04tf8lS1FMB31eDdZPHoGiZa6aKBvgCY7ra_Kgj8Q76BlRZsA3cvrorrXcX43H_RnhWv_VhzOneVE0Fs1nj1WzLFtjoRhS_5UWo3rGfgxgINJ6YiK6QxAXDYYxtbKb7zKU8MFvSnO_h8rXcsmGdU82yp8AD4D1K7wI5bstzJdb_CTSS9L2GgDmbCXsFvcvlng_3lufhegIu6PJgFiUBwGctzX84HmDM8if4Bxbwd2-UoL-k3q7Lt4UQWwSHcQmuEoUT89BZ8MvTBqHBPArW54qZWG0Rgg4ORt47iqLg2FVIULo7FvrmYRoLo6BBkiFFFP9dbo56mexpapoKBI2DbS2kuO9a31O3mwQ8gRjCLHv_dJB25RYKrc7I1uEodYvSmYs5IZeXMfCuVXZhiCN5u1gbrE7iGRc644_81lSFC2UJ8U84DhyfZLuT=w713-h632-no";
                        video_path = "https://media.giphy.com/media/7STqShwodzd1jGJD2w/giphy.gif\n";
                        description = "-Sentado suelo, espalda banco (coloco posición inicial)\n-Cabeza natural con el movimiento\n-Relajo en la bajada musculatura\n-Tenso musculatura en la subida\n-Marco las posiciones";
                        muscle_zone = "glute";
                        break;
                    case 68:
                        name = "Lunge con Pie Elevado";
                        photo_path = "https://lh3.googleusercontent.com/tCPjOq_6yOtez2rUZcJWz6qORzrkyqJfOyCR9MBnKySTzF1wj2Nf8a0V04pQUQGxB2LOmp6z5BTF141D7IFt2QmLMArU4iZPQmg24EX_oWUMfWTAWPxsMmsBRAK8AWmqo-YLuK7tyJFWEF8pjc2xPr2pCtugqYf0dBptUifm3EcSf4QKK2ezGIXTDIyDi1-zrxq3y_vmoZ9V4IN6MuQjNdWUZmXdlZZJTbH1HZ2XQ7DfId02g7JIz15Ny271tKU9xmvctVLwd6WYYbDu53jEc-Qsvh-LoiuK-Scpu3to0NpZ9eXBfOyKh9Oj8omfgGT4UXBWndO0IPlL6DAYHSVMrdnbJxaIv9udsQ9vOMaTint7IzRdfHXPWooPIALX8qI1tiGzIY3opRpSLdTVO77LgUqMgq_0Vqfs0vJQix0eVS7WmVyveMP9QCdNNfGD4k4N39e8impQYk7j9dzItgoOz9MOMI5gYxsbjRF4wmkaIXmyHuzQq4s9os0_8rZfTKdqyZhwagtwozawI1pAxWDx5OzoVuZcQLLTIsZqJIiqwE5uOmf5V4jkh1vTSNj9tprhy1d7AqSwJ1QIXajo0ESIEHjjpNO4h8-_kAg7dcwB7PPgZ9lh2ZlHYTrNlixq8doJRuAMFAIMr11RcwxHgxPngD5JpRhq8bnKqRg7_j0fAVLx3QHr5dxwHyZk=w713-h632-no";
                        video_path = "https://media.giphy.com/media/QK453tJLZ9DKgJPd2Y/giphy.gif";
                        description = "-Rodilla no adelanta punta de los pies\n-Rodilla de atrás casi a tocar el suelo\n-Cuerpo perpendicular al suelo\n-Espalda recta no balanceo";
                        muscle_zone = "glute";
                        break;
                    case 69:
                        name = "Floor Glute Bridge";
                        photo_path = "https://lh3.googleusercontent.com/TuiNKsgpG9dl-xwFC9IkMPDGsKkCO-6UXnfquLNBbNsxdUIAeu6Z5RlZZpqOLhi6GhQxcyjHaQyT0ln-jglztpGrCjG7hzYUlT4qT1dmM81sGfRxW9VPbkimif5JdJSvHD4qobXVDEw-jXcTFNpqfm7dgygUFPyDvOiKbMKY6xJALgKxlQFgEyV-7Ue_XsNPIf4n1Lfwe4SSvzpUDeii_IOQgi7s91Gycj7UkTnsJzHQKP2HwO5n54HVPjmEPLkHoEKBDIsPPwhFAlK3KUhFVObhFqTtbHut9ZAWf43hFb1uz9moxFn6woh4GCvOkGNgEglvOU5DnyeyJJOlgjz5DaEKWaiJJ3OgSRMsnfgIhFsqJtw0l5obLKRh75iUkFsSOuXnKT9BCbue8A8onQzTSqIrRAJYbiu5vjSys7RH58zQO4Vy1rwvX6Gq8MNwDcwHBDid2pOHznW6Hw-9EFZ1dWSRhCWj7xd5roZLHBuvWSS1WtrJFXIjv9VXn4BR0NPQsW5UTXX1wMutGxbLUX8SnTEB_kv30YxgF9FHtJKjA8PIFIMJ6QH_Am-OIwptMM6Usc0TN-eNIh4ufTHu_0vGcNzfcikUvPRYhcxYg9sEdIPNFo6Cp7xJf6ejWi5RLIMp-rYchJk5tsQDtMeg0pYvXNKUmlCQiTdUticzN-W5v-2JAQMTkS2lG8tT=w713-h632-no";
                        video_path = "https://media.giphy.com/media/5ndmzORKczTEPqlJ2V/giphy.gif";
                        description = "-Tenso músculos en la subida\n-Relajo músculos en la bajada\n-Marco las posiciones\n-Movimientos controlados";
                        muscle_zone = "glute";
                        break;
                    case 70:
                        name = "Lunge Lateral";
                        photo_path = "https://lh3.googleusercontent.com/sgf86-Shj4IYx_I75t1G_f_Sm0734D9Xrr9BIFbgYOYc2LySeblcSfQ2s7f5EOPTIS5Zw05WFP7lX_zXXehXU5t0rJ_t_Yi1-TnGuw2zcQV-AEGybVACiygi21jOpfqnxmcGJoH3LMTCihTEOxxsx_oRm0tMbneW8ONp18xJxzB9hkFgG3myjUboyGc2Y2h-wyWl-Q8hZAosyRCc0fgvqnIOeEASdoXAl1bC8MU5i3LV68rQljvnZbyYS8MeeIjKulH0DwSuu5C_vnTXH-vBOty3xPYGwuxzKwZ9vInphAnOEgfvZI7y1AzUSLQFOcOFTrAFyKcZgpI5_8AqcelPorTnvH-XK_DCmOCLdYPXIFeR9ejZHh1XkhyWBDAqvMj2HNQqnpDFr4-74eHAe7jQCQBpWR6TF7WI7PECMKTznYUyKxZR5-qIF0vj4U7GOKun_ZE7UKV8cT1QzIFa_yWN6xbElQZaLUP6HqYAudU2CXeSaVHDamTxgqZw_kOIVbfqf_24FkPzawOKKDkObAVrILkmjLjwWXjiU0Y3W9phEWUq7GGibZAJ-DREVMZsUGMLWT3kOSmoY8fQHIZTuHz8aqlSX6QnBHzLlsYXYBPAP3AZzDMQVIN1AHPQpk6aVcoVYqYTrGR-C8DWJlHjsHdqKLjn_PY_UL80Hp5CmZftW4NBbR9rRx5g0q6f=w713-h632-no";
                        video_path = "https://media.giphy.com/media/1oGrxLpPdqv2RNTCZM/giphy.gif";
                        description = "-Rodilla altura del pie (no sobrepasa)\n-Bajo cadera\n-Espalda recta, saco culo\n-Movimiento controlado, equilibrio\n-Pierna interior estirada";
                        muscle_zone = "glute";
                        break;
                    case 71:
                        name = "Lunge Diagonal";
                        photo_path = "https://lh3.googleusercontent.com/FJE5NZlz1ue9fVFUDtoGGNgRe14dxcG1OCiuzkHbrdiqHTwU6UiG5QybCvthvmItG8Wco-vwF-rRvdLEUEW_yY2q0jstapr7sSUnD0gpB85iKlLnXz-C40NNqbHMI7Y0--FxW1j8WJHPPyprsL5V8lR8w0JmGy8UjqcX0hBspnKvxWd7K9c1YWFL3K00BheQ22OtVxZ48G_YVmeqPtkCuuGrnnoYl7s73XFjV83NXZYDAW6LMGDxFoMKLRekOPHZDFrUJIxlY9cK_bMqtkTY-zuwROkobx8k9EJmVXStLzQIo_g5I5uT77mhDrGePcXgIawenxbcurgWk1nxMTV2BXOD7at2yrBgLI6CemqKvlLDW0hkZedNBfKw2UaLvl24jgN7xTL88x5Azc8AWDEVnNp2kARwKvX8XD6oyT4vytUNW0ZKbBZIeNng4RG_vPe1Z6l7YqL2bncnCO5Tp-AmQ11buOQjVRg6rU8dhn-9kYIWQK-PP0GoUFcQkjmCiaTLEWqQtwZOa5AGX5oKq5XmC9HSNhbIgJfJg742MFn5YYb3SM2zrlxfTiGShRcUXZD3LItdM5Dcyq36loHunhpO2FIRQqYFs_yHJQEcUT8aK6TGkncW3XoCLWuzbxeDDw73uvktibH4TFRq5pUI0Z5RsLK81-N0aJJUXcnZDmkUshOYoH5-ew0RtDgj=w713-h632-no";
                        video_path = "https://media.giphy.com/media/1eEDIJnt5Zt75dZEC4/giphy.gif";
                        description = "-Paso diagonal cruzado\n-Rodilla trasera casi toca suelo\n-Rodilla delantera no adelanta pie\n-Giro hacia exterior el tronco (acompañando)\n-Movimiento controlado";
                        muscle_zone = "glute";
                        break;
                    case 72:
                        name = "Dominada";
                        photo_path = "https://lh3.googleusercontent.com/ev-JmkK3SakIY0VPWxQs09b57Tg_Zu-6Dh1xvn2SUEHCbRWwkT8KkQGUXD5tnSDQh6WJLf4Qmrj5aHxer32ckgCcwGnwAAYv6pkFkWElqCeBzFxu_h_xJEXDr0W8E858yYNoNeWs05qfZVSvWxBlA9fgPw-h1_4R6j66vx9izQgB8dDSU1MqsEqN_lo5HtSe8e8lkWMxcuAwAR7RwEYEIfPd0EInpcNmkiYPnrEdpWPGNE1BML7IOOyf5sQGkOlQ09aA6C4p9JL0heIIhq2GvvP-fL21NQCCsQzV8d2XJ3kDDzWpzehUmfLIub0SxGmTiSW6Ig9_qXnHXCZTx6rejE6-ZX8xUme5JtIRHtvC_Lqs3BdkF8QlsvRZ0AMoCjbToY_kSVAqNkXJKsn0KWrwGTlkROrQ8snrUWGxrSmptGaKpQjY30ZryNDoQ_Ol26EvyRqXux-6R78gkfsIDcvSt0oyr2GqrBvBD2RkbH8U14ssXn7z8IlGEk_i3v4HDgraTlgOL4yrN32rHzTcz7HaiaEUDyz3nb8Q1-2uKPx_3Jrs3qBh7QBjiPM7881Wy3yRI5vGTCzsZuW1oWbD5UPfasGelaFQLTCOV2We2acRRltQViJKjPlAuyl695KJAqsCdnnDlLpBJKvjy_s24SNvYswgh-lpCg0SVv6UpYtBQK8zZST8KWmnDbZ2=w713-h632-no";
                        video_path = "https://media.giphy.com/media/1lDGaMvQePxyyNmBOZ/giphy.gif";
                        description = "-No balancearse\n-Agarre prono\n-Amplitud de agarre hombro 90º codo 90º (aprox.)\n-Subida pecho hasta casi tocar barra\n-Movimiento completo";
                        muscle_zone = "mid-back";
                        break;
                    case 73:
                        name = "Polea Trasnuca";
                        photo_path = "https://lh3.googleusercontent.com/6Ktr37JQ1QUw1MPxDDIhiH_L2uz_8E7ziYzUjoKhzgeeNv7PvtmevoXp-m1ANd0Phcv6cYj_Nk4MMoUdlpZZMObX-rfy39auFZaNiUjgCFVIUjcaP-w3PWT-IytzPqgShkZIj71YyAN30CBa596EBm6nZB_A_IXOM1Fz_gMf4ZS6h4Q1BOwcUsMjwyslLRVJ0o_s_Oda1_oOWYnaepHQrQm1_864W_Lw3tSxsY_L5D0xUm8CPazROMB5X2HnZv8GPB6vp3YwFE58ZIPt2aAaBfZuwu6bWHEjEFb460kFDDw23CWm30ddsL7mFWbeD7knCyYagK0MLACUiEnUY4N6994fJDy-TOzkHSa79C5ZJUlU4eb3kduWzrczFD31HDm-yZ_0Ou1HKsophdNd7PYKbExkPcceGkhoJgVAbZLhuCiCj4TdNomHBX_TmrNo6eI9KIBE6PNe5yIunpYWc0hfsXAkUmY06mim9mqu0mwvRhW95rryjaLRHGxDEQf0PW-6caxSSBez5MOORnetdLZBRC0_W8euBFObAj8sRz-rMRQyRJCWQhVrUsiEz86A3GdoFS1qn5jvY-srGkhEZKFYefPRmA2GZ_g-9HEwmY4zzp6j-p1B6xSavcdR-rZCO8hifVQQX2m4AGkzZV7zRbH9rVnjjakhYhhC4m41rtv1tfIy6dijndfEKXn3=w713-h632-no";
                        video_path = "https://media.giphy.com/media/14dYwJxgFhF3RyN4Yr/giphy.gif";
                        description = "-Espalda recta, pies fijos\n-Cabeza inclinada hacia delante\n-Bajada lo más cerca de la nuca posible\n-Si molestias de hombros cambiar de ejercicio";
                        muscle_zone = "mid-back";
                        break;
                    case 74:
                        name = "Remo en Polea";
                        photo_path = "https://lh3.googleusercontent.com/zHBfcDC0GazTt3fNb2Ll4oSJopg1usJsnipYNLV-GwjCeh1AeYj9ZvUbdFFaoUAsTE9i8g2R8lTTzeOpCwlniY9U2J31WUrVmOACxHscJkmDwo7ZCWGbptsLReyBhDbJKhyMBcjvu8Xw6roZMzgS6NaodauG96jiKC81-zal3Rg9I3soDNavt2EW0A71n-5NOPi9LXWiyWjodFVqfj3S4G8dbZ6HxD9RbnyyHx5Drw7-XBRS6wwF25jlytnFgN22cK75pEbbrczCD5Ss8u7q51gPvxVEoDIek1VK6pKsq4kFDEhtroFOQA-BoP_yy2fcQy3RH9wUYsza3qyTrV6hfbsOkWf0Qd64dlIsVbRPkJWSLIFkChOsjtA6BqI8X184hbdFvD0qAI1I8tO0PoBRMhTbtsUJkzVbj1djc7cjQ0Y1Z1qcPFG5NGFAZ4bv1NkIdLIdEy3XqSjpAqnOyN9no2dGIFEt1QhNRCvjue9-cS-qBQpoq3896ECTHqtpKbgrcJhdKj2k-2INwS8ouGh76FsXRoa9hmQh2dzACogW3L9lvcrgM8YLDMWa64kWfLIX-Uf5bErIK3pEixhEy7x0dFRI3pPqO8Nx8sRfouLGoZsY7kjatImU-4lD6qFPy2MitX9DQe0w6Ei9fx6vWFI6YaGEos1pDl-s_dfMmNaYCNSVc6DvMwvey9hV=w713-h632-no";
                        video_path = "https://media.giphy.com/media/g4G2FNwvCivbwQ05D4/giphy.gif";
                        description = "-Posición fija del cuerpo, espalda en diagonal pero recta\n-Se mueven solo los brazos\n-Codos junto al cuerpo\n-Amplitud de movimiento\n-Cuerpo rígido, no va adelante-atrás";
                        muscle_zone = "mid-back";
                        break;
                    case 75:
                        name = "V Bar Pulldown";
                        photo_path = "https://lh3.googleusercontent.com/jIhuOFymT9R7lMgWqStM1PZi3vl30BWi5Ud36HQDpUi8vMyeN9dxfx09_5nTzlsXAgi5VoGFA9M8IUcP6Vt8J07HXYIFVSfscZ5bA-riFoPX7AOJ5CdpQmepqayYrt4D9hoss8pK9OksSg0O-vhx8DkDDSSpyxQTSlSf1ccXHVfd7ZshxfP6SUcaZNt82q0qUWqIlZlZV35GFzJsrVdkAmUeE1poZiif9_ALjDenqmHtciO73_9cFcJhpEmcWLnzIuaxnaJmxrATmRNMrNVx1N8A1n29m5KJLpRbt01PGZvm37S-4xAtN0N_dtGbqqQ1jd1V3ymsI8FedjGfkENNmYZdYuOFzTEo4CyoS5Z_Q1F9wPmEMZSpmNIwFrhdeCK4yNKh6VM8geDRvwbBJIVVu9nYFkdxj9O_2SoYoP0XAGuvOhJbATSKVDhwLpPiI4l7fYSVQe5QRPXO_s8dGtDRgiqEPvZtDjpx7sNg-01lvqkftmukbqVWdtOvHND-4HTQlymES2Bs9dpeKIGtu9CGgvQkdV_gZLDMrQZN9qd_utkxMCX2OHtKAyxU-bptiE9mga2upmcG7mPDKZXsDj07TtzIgmnrsDymmrIo93cuLM_THKubYSjFjfw-6TVCk_Cpk7l5nZXtPSvtHs1GEaEcPZ28fIoR5D8Ioghl53UabLuXPk4-JWav_5M_=w713-h632-no";
                        video_path = "https://media.giphy.com/media/8UGF8X9kYZ30d34VQ9/giphy.gif";
                        description = "-Traer polea al pecho\n-Codos junto al cuerpo\n-Recorrido completo\n-Cuerpo fijo, no se balancea\n-Espalda recta (diagonal), pies fijos";
                        muscle_zone = "mid-back";
                        break;
                    case 76:
                        name = "Remo invertido";
                        photo_path = "https://lh3.googleusercontent.com/GLg2bmIZcYVrdoL_AqSXMtyxV9-xMYgSXfFDNs6zLrVAaTkd-IXHjOt583K2pfYsESOM75aEXCWK7b7Vm1PnVgp_0_Ls4AmuYYgCtrlS9OOgQ3SShHWRU649bo2aesyE75u1HGcRwxf1_p69ZXf7HJ6iAH5Xmz_ReSmqWOPWOeD-pnyZvzKH-2YzVPtSVik_hFz742LRPWikc-oeT6cOwM_wlENYcQn4fyLlS1D3Rx9stFaVxG9cVmHnpCDZNETLaH94J4h5wDKj-Q8rh2Giq1jFIfSVGxyQ-EspROed6FGE4tfbTeTFHTyLcBtCgtLNY7bRR0Xm4awc3GO69rMhLqjCy-HZRsBsVki-0_vkvE5fsYBhA5QEVfqfdabMeZBvlEmdvCayUlMKHGb8kBvvKoZJwy7ZHKnK9PSSkj0VLflrGJl7ENeUNjjzV8Qkfe7-4W8hlAqxfpeGgXYTrywufO2EDeJFrCVJCJpFlGm_qM9usF5TMtdUFHsP6iRFqb_omrhbEY6tInENr22yidP3_YTuJdRI_b0keaBOedS5MdmCgbHrXrq9ROxBQ4p5F44eKssZUHnpm8P6W24C7A3tHwwy6UXZYTiVK1SeqItLvT1ALbP7f-5J4nLop0Az4ZP-lQcmehTjgs5PFENTvfc72ibFcyAFIH6HHjvb9jKgkwq-A2AvS1zRBE16=w713-h632-no";
                        video_path = "https://media.giphy.com/media/4a3DNqo7CsUc63Arss/giphy.gif";
                        description = "-Agarre supino (al revés de la foto)\n-Codos junto al cuerpo, manos en la vertical\n-Espalda y pies rígidos\n-Fuerza viene de brazos solo\n-Amplitud de movimiento (sin forzar)";
                        muscle_zone = "mid-back";
                        break;
                    case 77:
                        name = "Row Machine";
                        photo_path = "https://lh3.googleusercontent.com/axK6489X0fY5I_gZY6kEon7lxXQrnvxP3qYFqCzeftgldesJljtJw6PcibZCWMfQyWTf-vJYidYOmedsfzA6nqGqCVdTs2bBfG-Jd9QosUZCV5sEYEDBeRiLP138V3QeoSry8wtL4VXUcuyGb1VJqpN1SPc2Tiflm-Ss7ynpYa03wn7WjQIw8zgujJBvwWO5P9vd_B_xw2sKSe20ytyH0JCfa2xBCewl0TUefPdd0QpVsD-dicoVrQT38hLKRUCSsqU5cmzQK8L7Q7rTh7GhQBL5S3ULpBotTCdSBWYFcdhRKi0zKXn3Q0md_8FAaei0Z5jp4BFAAxZ_aQqx7UxqrVzAHqTt7nk2Xbk5j7SlT1IybuUYL01UC0okYyhdRjiCNyUkuITl4L7obuReK4pngy2iYPvXvJI7BU1QIvYVRC8E1WfJBFOPg-HORnJ5CyG_0wwdqiXt6fcwEXMJpdSN_wqI2ttV51s-sWhXEAozxjeVXPG5OdxeHqG8NLjr9GYXsKI6G9WDHdAUwx-t5JAg3FXfydfHEysfxanxcBfNB_oUdht1d5RBkenZgJiB5xYN0uR6VURzmDgKpLoDyXHRptl1gThikK_v8DOn3LjNpfMOPM4gTK8g7jcvyRo2HtCGARk7HxfP_FpCVR4UBzFpQSe2XmxXYCAFpDXg_VAcB80rNtw79iDQjRk1=w713-h632-no";
                        video_path = "https://media.giphy.com/media/3b6qrDLve0XifFgU5H/giphy.gif";
                        description = "-Espalda recta, pies fijos\n-Sillín posición cómoda\n-Codos posición natural\n-Cuerpo rígido, se mueven brazos\n-Hacer el movimiento completo";
                        muscle_zone = "mid-back";
                        break;
                    case 78:
                        name = "Superman";
                        photo_path = "https://lh3.googleusercontent.com/5pHMWknNPCsT8VXxxt2lUagod-oyP2D1rqzIg_cxjSTObU6WTJziEqoxEBOmxG8pOrzGJfMtVQ6jCwsb2eJdWJOdX24LJkoXQfjCU1HftAYeeYDsJex5nnM5tLv5qwWH18IfCefoqIbSXW8QgbyZqlxb-HjjIJp9FdKE0UeRZOazVrE1VmUgR0SiCNMIm8Ix9DGp2W2nn-rj0GEwaPKBIzNihUGB96HTh1tUX2EaHrNKk3gJObrG72COjFfrHfqcxRPvvQOdfBS0wEHS71p3eJqq6Z_YeT2p6Sd_XkZST948utUddz2d5zo2q9dyGVib1Bry2QKEpsiP1L9dAGNCK6wREYndvVKeeEQKH15oOwOavKhtbf_HgD4kIlfwCBms_CBELnVZkny4Bcps3jPif_K3ovehMMKJ8UWxPXPFvvZHazYVCvrBX6XrWYC805dbwvVgEWjnFK2M4_ZnPVSL6IIc7n-i7DgNO_sXK_Jl863Mq4dGrCFQeBZuZvIexysdJzCsI2_roDuyTizaPxaB4QK84fzLM1y9Vz_FknUf1jiqgL_cJJTsdv2jvab88XuCeEsL9OfVQyvtOFBvWiBjtv6QVFJw_l7zRZWDcXHrt7-JCx_RuEbSrb6DT7gcthdsphspGOot32aFJ7tTXzY72di5nho0544MCQiTnsJF3TM0W52zs-8hAwwd=w698-h632-no";
                        video_path = "https://media.giphy.com/media/7zleKmCCBYdZ8xsMIg/giphy.gif";
                        description = "-Espalda recta\n-Movimiento controlado\n-Equilibrio\n-Sincronizado\n-Amplitud de movimiento(sin dolor)";
                        muscle_zone = "lumbar";
                        break;
                    case 79:
                        name = "Maquina Lumbar";
                        photo_path = "https://lh3.googleusercontent.com/Qs13vEIezR-Tqgih4aUJeqoRKZRCRQIP06LUCTf9VWPNRef_mfJNETMm-bG1dvk3RBx4m4FzpQsacv-9WsE9dfv_6LUzvGmPZMC2_B1jKWqSZrK1huOKCSs_gCj5PQA2Cxzch11PllL0nocPYKEym6_kpG03O_3VfgE_35cANKO3fiq7ygzUvwFsljXBZu1P6HMYOwG1CZMTYwYoDupsd2zsT2VQvjWeOpqKmfc2CojKRDSjDg7sj7AUCJDuKV_Kf7zjqdi6wk7QbrDgt4BLhmtXsEuNNKzn9Rz4s127FKrxChv48VOMkcXgqN944iRB2rD0fbWTRdd2jNJO9Huc05_DuY9zWbXpNrNVuAtgMw7NOiMgLYuLp1O8phcU-2Aig9XtMYwE88sbnZJ8ZC9kGEX_QJp7N7PD8WjYCE1TRi4hhrcDNv1YUuzQWvVbOQZqt7YBRGKzBw4m4Rz7Hq9UEjbLkOly7HSW7OOzD61oe7SStxt-Rg_Gy2yzGj5U5oCj5j9oS7X70YwQxFWLl0isUjXavtnRwosppy5gMY9rVxHDSp5mptBNLfWI32LI-gRNMR_hXZoEDyZQrj6t3rXnM_-SZBcAFPdioLFJbHsa4fu3ZTmFooDezJCGLIZI2nH7OhfZeW3hXioCdgLZ-r1B8IBU_WbAfbSobek6r9xR8c76cn1bhdIRNPAT=w713-h632-no";
                        video_path = "https://media.giphy.com/media/MuGiDdMwNggHrWh3I0/giphy.gif";
                        description = "-No sobrepasar los 180º\n-Curvatura progresiva espalda (desde abajo)\n-Piernas bloqueadas\n-Control de movimiento\n-Bloqueo progresivo de espalda (subida)";
                        muscle_zone = "lumbar";
                        break;
                    case 80:
                        name = "Maquina Lumbar Lateral";
                        photo_path = "https://lh3.googleusercontent.com/kLVGy2Or_3zm45d7NtzwESo4ikuOzhNuJk3TEJR06-vD_GRhx_u5a_qCGjrTclpAN0-5a9sgOapre4g0lj_z2xFajAERI4ypWyUnvjjrOAjnecG5evvNSOrK3lADFyxpvL3w3rHVC1UnlO0zUNfu0SSn-BTigW_GvZA8oVNa54qodGUR36Lsnhzy6fcnKcmf_4RBoLuoI665UN7O8j1-cPkQdhAznRJFMVylw338wrMgbbuYxxJL-GVieOKjeyGeyk0AGQeeXR1vb7-gJyqiauAbpKA70et9bjZzg_wUMPyZlwXjiytTmf718ESUb6a8xAT7eiVhn1jdphfUYCZ33Nq_0Y-AWxaz63MOGyAqLfQ1bMeiz8o_VOBASj8Pwbh0-pA0fnP8g2kRCw8reAm1hVrFLpKQ3SF1MRj93aTa_9F4CfKGjE51QKHKiV8WZIDMiW1C-2bB1XN_VLSC2opEsvDBrVT1XWZVzQFTfREAPhU3e2YnRJpYkrzc93k0X3v-7KT-flA7I7Qvurhog3upu4ALaGcjVWtqPdkOVcYyPIG3TbBerHzFbPrVxVrzwyEZfVzFF-NZ8okL3ObLRPNTRg4m5S3Hv8o6OH8A6IINQQkoG3MTSnpnwlbZGZ0YufZegMULJZRcYv8qzOjGey90xZ5W5m2o_TOmueEP8Js9-Uw8wdMATG07Nt6C=w713-h632-no";
                        video_path = "https://media.giphy.com/media/2kRwSf6F6iLIwBvSUX/giphy.gif";
                        description = "-Pie interior adelantado\n-Inicio a 180º\n-Movimiento controlado y progresivo\n-Piernas bloqueadas\n-Subida amplia sin forzar";
                        muscle_zone = "lumbar";
                        break;
                    case 81:
                        name = "Peso Muerto";
                        photo_path = "https://lh3.googleusercontent.com/uuzJKde-15HfNutvS4XLoB0mTva5botmAkZPwRgKKMuB98TqAxBOcBV-1lAfd-DB9DuTUQ5BAp8QZ8Fdm62jXPLs7GzSMxU8Ao9bjBN-9F1WmsxCUkuKjHjlvppTNSoTWkeJ_MGSVBVRpHbA8ybW6MhhCq3XBvMG2GXib94JoZa1ETYwmjjbRfgHfwm3-U_hvjzUFzgpaVOswlYbSnI-onCiKMrlsE0z_DCUsQ8clpvZtXHfI6ZhtgIkILCLQE9lZZ7h-y20UklLWE_cQAQWMidjsDMzwOAzDHayoLcAlvrga71xgKPC1F19eM3nY23nFS1AgdKogZAgfsNBAFRmkgHwperh4d9OWlSIsiFg8z3XIFyMdOBHanNuHABlc4Urx1w0Z1YtT5WiPl0ltAonscBRXtmDAX5fO8fxqPJuvMGE35GKpbxjnK5L49qXRDpeP6XBvbOo5KsXO5mtFBx2Suk-JZscKc0EguQxcQ3uHwkstb-BcrrM6idhG2TKFTsfLL2jOpYQPZH5kPfLcnB3DVliRfYvyyC61xcvnVRYXM-PEB_WZozuaHeHPPiRwMWCiG7xxJZ9UWDgDRELSn7LOrjT4Ly8CtPcSltz0EtGjJJR_NWPHoRpdDmDxS6ju9z4gj236OmIFW-OG2L2dj4qLwNFyHAw5T9NUHFCYzssjKfUb5tBMsVikhDC=w713-h632-no";
                        video_path = "https://media.giphy.com/media/25HwgnJ41KyOcmyRBC/giphy.gif";
                        description = "-Piernas a la altura de los hombros\n-Rodillas no adelantan a pies\n-Bajada flexionando levemente piernas\n-Espalda recta saco culo y pecho\n-Casi a tocar el suelo, controlado";
                        muscle_zone = "lumbar";
                        break;
                    case 82:
                        name = "Lumbares en Fitball";
                        photo_path = "https://lh3.googleusercontent.com/GkAyt3IGhDIZQGtGYGdMNU3K3YvcQA-1LUP63UcU5-wNjFKhDXPMVLqQULAR7iC4gPaeiwXdbScDGxSjq0EIb-eMwZ0jamZY_zdBU4FV3AZNxcEu2uwu3uagG-cBa7vJmD1KtbugwPyWa8HwXwtiQXf3tu2HkvAa5IyfSnHkMNyCvQ8-Z7UTA5rrRq7fjI7zUcHoGQn0CEm2v6R17USvIw23Yj5AhN9nVq_E9Fz7Sve3RkKWxd3AYEzdrjsb7c1Ja7q6d8b9Fl47mnwHvYNSpEiryeX4VpFUB4aQJ1cOCqssDWGYZ7nlDOPoqPLpS0GM3tFQLP90A26-oodH2o8XNHPM--ZCIFv70fQVvsItwyeCtnyVBAbMDJA48ZnDz6H5isBnUNRg4mS2zMRlGL0QeoIW0MCow5tg1Dekn43yB6YdFAcKbq-3UrX7RCwALhoW0lWaUSoI-0pjygn3GoCDXAoLlIlgB0n30pgYAdlzeTkJ_V0oswJe_yoc-0FbzbZe6HoMSEJ54VQf1ihNtaQ2kMu0KDjh6bcdVvn46rcQUyNvRC9eBDRPiLYuO9bf-x5hzV1vJoP6-JohI7vqYxdd6mJnygpiWiBOVOhxXLVZlMrzZSmkeN9Jv-AYuwAkvL5rlqKdxk--16yi5E8frNKmd5pj_ziaiVw9mqdpMm4NFkChrMC-S5PfCrK1=w713-h632-no";
                        video_path = "https://media.giphy.com/media/9VtKUOcglQisehyfuw/giphy.gif";
                        description = "-Cadera cómoda en fitball\n-Extensiones de espalda\n-Evitar balanceos y desequilibrios\n-Cuerpo de relajado a bloqueado";
                        muscle_zone = "lumbar";
                        break;
                    case 83:
                        name = "Rotaciones Polea Rodillas";
                        photo_path = "https://lh3.googleusercontent.com/S1uKOLs5BNZFdj1ROaLy6MajBPwT5OXgjJ0zs0Pqc8S9MfGqKUiX7N22MY2wNupX0oDUrrREd_Jp47T6p4PAqifhDCzOkav2tVE8pj8McuVc2NSXnWMzoSZdGAzxyT9QejXXovHM1Uocb0FZ7wHKOcAH0XNXEGt1dTxLGvz-N8mHLd3Jnt6I5RpKnxSTeKjXmEHzmLNo0dpsDZypRmhzqW6NIZKXonyCXoPZ_8vD8oIKDjy4Q7Ail4_25HD6uPMz6IJolWytYE6phWAin-j6S-B02xQhIbG9RG2YLKLUA7vLRY9hd3xbRYuZvM1C2ZRP90vj85lKzQ-ZzYzGQSB0z98o0gkyD-QEL9AD76uDzjVc0RzpyQPp4e209V-1BadY1yg8WcK8Wqe8uPWTgo3wbFeNYKrgTKdkAbsYgqRz15v6XM_2esZh4ZsRJNpP4irTcG_ggvAKiqFq9fycEqJMs2RhM_HeOokGovDWWza4uSnOzQYjeK2lyaWvWrWcAKCGw5-fdqtgFpYibit_L6f_koPM4Ccg9IjMdqpg50LA-Ey70yGU0noPoR1JdFU3I36X8Lw-ds7mDloYWahJE2gMB81fJB9qWR304H838a0p5UYuMmwqLvGNPMAyqaiu_ydH05fVbEb0Y7GaqWSwBCu-O5xVOf4avpxhXoevNFDI782PbBXlAHCk0qw-=w713-h632-no";
                        video_path = "https://media.giphy.com/media/25aD3zUdkM8ayNOECi/giphy.gif";
                        description = "-Brazos estirados bloqueados\n-Espalda recta firme\n-La fuerza viene desde abajo hasta arriba\n-Cuerpo acompaña el movimiento sin perder tensión\n-Bajada controlada";
                        muscle_zone = "lumbar";
                        break;
                    case 84:
                        name = "Maquina de Aductores";
                        photo_path = "https://lh3.googleusercontent.com/5_TQEcAB1W50KQs6XDoc7GhTZDZ0_ILTFF2pCJNJUJnTeuywlWf8h3nvCeboaN7GqkzwVnezYZ980UNZ9JbpvcKc7z7rk8FH5h_vJPYKAZlrBRqOPAoh0vWcTo8sXAVnBF0KeM3iDTbYKIpe5JE_JyAaT7gz0T5CCL-a9Q1lCshHqRDnSeyBcjXqlVmulVf1L0jugU9FlHkz7rxFxFZSc4crDnqNiya7Y2ukTHGy_cYMNVni87skNVd-mRuWU2XYl43fUd-DYeW7qi6CqDn8n0SbBsDLMcRHz148pBOiQ8OSmvLl_wBusYoY7rpCte7t5jUlOW0I53eO7y28ucw4LV4ikG84qEaw6NYuO18sdQfB2MxPGR4w4LECxFvPE2QpBdss60B1MCB6eutd3V2RmgKobTv8yJfLaPmijPPpswLAc9UgTPOJ2n2xFZ-Xjscmwj6bE30S316soVTUMLPR9DnI6Wic8-a4spMq6tG6orGG75dsIjQ86RXC9ARCe7r3wiSIp28G6nCGEpJA01ru7pUv3JDLkOWu7Jv1b9QPLoL5LqgmBcMza1evkML4w76lU1Ii8-E9OJOURHTnPowqSX4a22NCNoNPC8FXlbgOQ4iMr9hr5qU72uxVkx8ROk87T49kRQ738EDkGTJYPNP6XDt-U2H9n8gz-c5M0jZ8PIVV6I29jiR8GrYS=w713-h632-no";
                        video_path = "https://media.giphy.com/media/YlwnXWMvALBYgBe9eJ/giphy.gif";
                        description = "-Movimiento controlado\n-Fuerza de piernas solo, resto del cuerpo de soporte\n-Amplitud de movimiento\n-Ajustar sillín\n-La vuelta controlada";
                        muscle_zone = "thigh";
                        break;
                    case 85:
                        name = "Press de Piernas";
                        photo_path = "https://lh3.googleusercontent.com/uVyRLIpNvKnBr3kiCKYqjifr9oskEIQf4JDQTvBWdfTxLpwu8nPeZ3Fy_vDEbT5r9jjG07usRCgtD_1tN0fUj_ALuSknKIbZmmnVtRdmOjfg9BXMcInPwR0vsSK0AwpCzO8EXCqn4lZGEXT0e1TKgKDwZfHtN5HFB5HciPnFQtO-jPOVgKr2jTyvVxhFjhobAK78IVe4WnrQRH0r3pmiaew1fbPlUtycDioz3O692qHlmnbDM4oc8123K5tCOP-D5r7docl3qiTpNrppZr0riQ0cunkvWGgKZyu1EHGBzIpJbLF5a4T9CA9Ce5GrlB_B2aJEn-_jwnQ6RDVVpIcwNHLzLu4EfiFjd2TSoS4Ur0pgdlpLbeEGvA78LFYNzJUsrgHpBIoiqmuurM9ymhha2s7NNGddkoPdFxAJkhKDbz6OiEitdw2EIpxYGarYlIRPRMTK8DPtulBb6N4GTEUPwkLnorLWwyBbVl_42e_YdD2qXzUJZ732vdN4t-NLVjRKFIpuwTqvlCuOuo8wAJKZBqsyOM-sUpbwa8qikQo0dPHC_3fhuVT7J1mXvlgk-aLBKmbWL0q5KHmNMavx8c07poeXrfd9EIc08vR966tOBB4vmHQBwrdkRGOxbBCOOE4UL051VuKUWQDkkVi7z9jP24k_SmlPdieVE7lz10hEV3GXRrtm-J29p343=w713-h632-no";
                        video_path = "https://media.giphy.com/media/4Zqf41HGRZGH5zo1bL/giphy.gif";
                        description = "-Espalda bien apoyada\n-Piernas separación como hombros\n-Piernas posición a media altura (natural)\n-Bajar poco más de 90º de rodilla\n-Control de movimiento, sin tirones";
                        muscle_zone = "thigh";
                        break;
                    case 86:
                        name = "Sliding Harmstring Curl";
                        photo_path = "https://lh3.googleusercontent.com/IMlJnoXOPrRTKG3hahdnfZK1vZHSbOf8k1uVoa7BQGEcEekTHHs1HsoqJpYtvQnXEbkmMU4tiTn3-ed1vDdBoa1fL0tf4yUoEp2jJAa6L6FsbCWiDaM4eTVJOeZeZbq8jjJLCaXIYCLXR5QBAyOGcRk87yATWNMNX_o_VYRJXWtr8Ri_3F4IcI3LAwg5fDk0v9NeEljzMQQOU4cHXR6bzFWWk_eayf9Y08R6XTbd6Kpvmc-b0CcjCZ9KWLTFqQ0vf2B7hxwr4Pe4buJSK6-6lGHSXmRNREwnCxcSkmDnLTxEN11Es_JEyO5omx8fJKSSfGHe2dEY39frmryDHVMexl9c061MQN95noTdcdvjvAjE9T6ekti_REv2OYIhH1lWmZp865gBREa0W99PqFpoXo9L0Dr3TB7-Ftpr0nuF4XQcjEhAlme2t9pBdmP9d-l7jSwxrq_FEnNJNDsgP7NQFPg9Zf3OHyXr4-EbwLL8ho6nycshK6YABw5UQfwsbSWG_YH1tndteLKjtGIE3OoII7HyEXWx7YSFJZPhtweOAuT19t27vtpQVp_Nmn7mK33PwfjDM2Ww4QCGd9Lj5wnc0JJX4mD6ZDH70BABop_ILMco8ez0pEQevZzLvMrQLwYSXwefk0R1bVf5VCZm8RP89NOGg2b4lhUL0Ku_V3ANY7ZUU1dCisUjUbAZ=w698-h632-no";
                        video_path = "https://media.giphy.com/media/1d5NlpslbfhfhE8356/giphy.gif";
                        description = "-Peso sostenido entre rodillas o muslos\n-Cadera casi a tocar el suelo (bajada)\n-Algo deslizante en pies, bajada controlada\n-Movimiento lento y controlado; cuerpo tenso";
                        muscle_zone = "thigh";
                        break;
                    case 87:
                        name = "Lunge (Zancada)";
                        photo_path = "https://lh3.googleusercontent.com/EwDDNRI41LPb8a95kGwnxB756EW2t15iy3klFWIiLotlAvJ_L5WRC5DYgijubw7MouFMB59fFdzagXYlPi5ZoFIKa3YfLFCJau1RQL9odN6FyLwn4wcWJehixmDxaLHjhJ3NoZfKiyWkOAlAEaQC8SOwQW_z6wnQCwr_uxztaMUFhUlhHJXQwGL8IAigrsO4mPLlLhIeDXHwUQBKDc7nJT_74j9nnZ4db7MagVKSH4WJWLHzEPmcQlvDT_o9wa-5T0_I9rJWCQynLn9vIdtUoTdaQen8i4DMMHm5MYAD_Z3JsCYZ1Z5Gu5dCAtpsIcu-mzPzv4X-AcR-u_bS4ELz4nqUqXUH0-mCq1mCFAAShac_kPyqwxToRF53QyB5bXKK3H4ljgmA1-4euKSZSloI6ZbHCIdAx-kJcTrtQkGAAApIus9sJhLMlrMQIfL9Myr0wjDrQNUjUNObp-FqtmUFWXDh4pf37onJ2-D3K2_zdI5zCvic-qxpEWk3hzwjPd8I3llbWOnHBb-JxF84C7Ev6iGFK86mo0rpubmcog780lTDRks5Bd13rP__koPvsZ0t9Au-KOX8kuKFO7Y2BeVn7YlGXxHyE3WWJlwCM5zpRvvqHKdlPlck4QwDVu-o57euV_NSfUL7Ikzt2Y_Yfua8JKj4tDjrqMBVR1OatHUBt8HdeXtr-uL4orFj=w698-h632-no";
                        video_path = "https://media.giphy.com/media/p3ZPIbHhb0oMqtyCyX/giphy.gif";
                        description = "-Piernas altura hombros (posición inicial)\n-Rodilla de atrás casi a tocar suelo\n-Ángulos finales de rodillas 90º (aprox.)\n-Rodilla delantera no adelanta pie";
                        muscle_zone = "thigh";
                        break;
                    case 88:
                        name = "Maquina de Isquios";
                        photo_path = "https://lh3.googleusercontent.com/Y5C-kUn-T7wBF2M5awFfl9OgwDZgh5C15XsEbEAEyIVMeHs_XrFScIXhe7RD8w2LZmM0ixMZk7M3fW9JXQpO8KgixNhOIp9mpqaPrQdE2E4pU8mRQhxMuidwWC8TVe08XR3fuPLQl3hL6qDqyZRYXoLE5piCmc_YSnRnvTdpdHqhwFjdJM7AkSdQet6nm-SwgrvQXE3JURYOcpLaSxg2FE6hjDRjYHLiJEbUqV27VunuxRVKtOruemlcJmWWNxXx_Z78-Xa4o0ZicHw1JqJmq2jHxemSejsIzp-JcpuniVBJrY4EriGKXMHRAs87d-1JS4WWVna3lhbwWjB6sd9rBSKfX45tcBx57SVpQRqPmB141l7bs_O7ymKYXgFH8JDw49tRHUPk8MlxyxqkgTOva4nb1YknuxJZ4CDt5hTD9ARDF2OTZ8vIt42pIiuh2I-GaFebmrE8bYnkUIgLioJZUeSsHK3f4LdVnJ13bDBgrvgezAgNo1MPHVMGv57jg7qwuxvXCkZEEIB74Q68_HSJdQbL-Ym1SoMT9isrdVsPr1oV43SvnpgDdOTmA_UkhzS5BQJzRhudqyUF3XiWZQipcXedHQP-eEImtIklxjTW2UcTYRYwNuerExLPy_Y8jVKX1SmFMwnNFqUMBACIhEi7TG2doKDxDDTgXqS7hXUVyAAMbR5bDLquOE6o=w698-h632-no";
                        video_path = "https://media.giphy.com/media/8YTRGj9wuZ0lKHsD2W/giphy.gif";
                        description = "-Bajada controlada\n-Ajustar la máquina (posición natural)\n-Trabajo de piernas, resto del cuerpo bloqueado (de soporte)\n-Cabeza relajada";
                        muscle_zone = "thigh";
                        break;
                    case 89:
                        name = "Maquina de Aductores de Pie";
                        photo_path = "https://lh3.googleusercontent.com/VhrgQ_s9l2TyDWdJFvyJodFkBwHYs5INrEcp5n2mlFrcdRRcV3ePeKEySZzhUvsxAMeHHb6k0wO1Uw1hF3GbVW1vp5bnC2JilkapoU7oWOnmnHwHvLzdgiBNYwMY-dORuJMg5DVmMUv_U6LBRgoWuOUacSnuQ9bOhZKbIweg9C-eYE6CgOFK5xpWVcA3E0YjmnMOIV_hR4ScAqF7Ffj7in85biUjA_ZCdye5zbNFBv1KBGKi2t-gWlFHxBTKJ9ZESIursVzaKzOIUPwPRwXAn2OsuY-ZjOvzMc3eVtrJYaHCOUIJbduM43qDETKXkxBkuxFLzE6jzeovHA3FIK1QexgE0Bh5apweYUkDTJZkPLB_RO4lfQ11VUdC0COLvi5xmVu0awPcBGjyY6uqyw2VPGZoqZgPzzuUYGaurPFQcsUMirOeHLRUUKuYrEGFHjFCTypyIJcb-Y6bJtFa2oBT7hfOnkKB7d5dY_RPRMEbVkWuQjMZneyxp6wyk5nS-UUn_pgrwheY0NbgHXrKZlOnfOeLUjhkAAXfJfqvedZUMwL6liNTAE_FQxCpK0vpAb4mlUwSrdghDtIhwUugTG1leTaAv5NOw4j6ypd4L0hqoumRNnQrJOXl7YQiuU-RWx2_EWzjC7bjfenwZTnW_fX4lKqKeAwVBXDpg9PiyVUit0_caeJbRrrV8oAg=w713-h632-no";
                        video_path = "https://media.giphy.com/media/ipxyVwE01GL7ABO1jl/giphy.gif";
                        description = "-Vuelta controlada\n-Pierna del movimiento estirada firme\n-Resto del cuerpo bloqueado firme (de soporte)\n-Sin balanceos, movimiento de la pierna solo";
                        muscle_zone = "thigh";
                        break;
                    case 90:
                        name = "TRX Triceps";
                        photo_path = "https://lh3.googleusercontent.com/NIyS8bmXZdHDqebEt82N-BX7QOhZMCqK5kvS3gj_Hvjbt9bB1tTqYgtv8N6l9jYCHH_3JHXCCkyEOdCR_ot9_Vf4hsZGKLLBKlQ5YLj_hSgJfvO0mbhCsKM9enbl9fjJ_pwndztQhmg8g8k6BPiAhAbZcBOccHcGMkFOk4xdTb3XYMjOirjD9sx0Up38bkvxhtleMwsNloTqGstUx5s4i0FLN0BogQqeJobuoS7GSBgEbRfs_lDyR5cZt3kZDGVpYbIQNSoHAYdC6H9y-_p07kDJag3QrJp4cQdIuA9z8aSV31jwsqwww-mRbLH2zcxWvYq4aEIbfTqf303yRwglkZr9HxCRsNO8z9CQSNYdinQXVUCW2ODQ8rTt3VpIs-UMpcHbATmLOZ-TBiivIxIOKsri6uogmMCsVb2WrIyxHPnwvn_D_5iUeCe7A2lxtJ_uP4eZJ5oQarVmUVi8l6TEB-j19KOP4NHD8Y-JOmCwtgCKeqDAvQSQ3QAfDX0g0T6mt7PFtQ1RvkJdb3DG2teAQ1WjE-3oxYm5ev9Poc8FR9LiD2jHtfaNqQXRYjmXS8DPuD1ow-9ngVzOkKCQlwuM7ZkWa0SDAuv0gySEG66j55A1-mcPG4YFMzoppP4UhmCKkQNn6ayiHWGFCZl2LGqL-KjIZU2ATFTIgMhBsEtcFDCxp4ZQhs8p2-qV=w713-h632-no";
                        video_path = "https://media.giphy.com/media/26vy1pML95bVUxMRZt/giphy.gif";
                        description = "-Inclinado con brazos estirados en TRX creando tensión\n-Bajada por movimiento de antebrazos solo\n-Resto del cuerpo tenso\n-Codos altos manos a la cabeza (aprox.)\n-Controlado";
                        muscle_zone = "triceps";
                        break;
                    case 91:
                        name = "Dips Station";
                        photo_path = "https://lh3.googleusercontent.com/tU-Ir3GttLI-iqyBgNsyVQlhAgbs4rqS9w6SkdGhhwQhzJjfDnj6v_xYqsS2mcTorscjqtTYZOoXsrIOm4DF-MooMXWfMrOVbA8BQ0CRbDWreNJUAM8RJjcjX9tvffPOQOeGHYfj4b7Wvz0XKkreD-6vDsXCuvoMESzug-lZ7KbPibb5DDb-zZ18_skD3bSfzhgnlBCfGBMzBc6eA2hZ6ccWOefrWoIMaPRbcxHhIsdGl2WT_xzKrm857U71Pg10E78AmgkCuPJXd_Wkebvvcs-Kl-p7OxQwXqNI6Fz3sbhogNNMjf0P35mNxMkgrwU9yD3UZWWnbqKqtgBTgulgauGydY3zfzSiETLF9oxtWvV1ndb_HuGS_foRF0R_qesJWfs0KcR4AcDbvs123HoYqT8N5PK3TCGcVPrU4DyNmJdnOV06eVKM6FPlwfF4FNq8EdtqVG3VcDkiXfP4lkrcFzqZeElrRBgP4HpDdxxW2OoQfq2xcpa-5BVW8J6VORVXuBhfeVyDmHXhSp0lzw0-dR2ZJQQ7HqFht-yTFPlIj48nzQjU5Gt6UFGvPxXlmieztjYyQreMehm4Io8-hP4l3isasb7vZQn8teNJtKGbRAPeeakboZMjFAmNqsb53MFDMkeifxTxLkZF5vC5oMdChwba=w713-h632-no";
                        video_path = "https://media.giphy.com/media/1vZeeiFVQqa5Gc2KDp/giphy.gif";
                        description = "-Movimiento en vertical, sin balanceos ni adelante-atrás\n-Espalda recta baja tronco con brazos\n-Movimiento controlado";
                        muscle_zone = "triceps";
                        break;
                    case 92:
                        name = "Flexiones Codos Cerrados";
                        photo_path = "https://lh3.googleusercontent.com/MNOHVA0mxbEn0ulgAEeGZYanTX401y3u2ltMemRTPcYI7B_LKvB8FnrBW_r2wUaJrq0YgGbMlwsWwhTUXjqPs85pUYPCFJGq2mMi7ihsv5u4F4snnpPxcYCQ6lnnX-Eg7uhwmj4CfY6_gRK7WJHa2wC4UBaJt7_Q_IQuDnX3BbMopJkqSIiDvoHb5ZpjqFO6WxZ6T1mp_THBuhnOWTIQNxTrsHl-FR--x-bF-V6ZEBnuWNhjuSVWYkl3KcHHB9LHM-jSxcbFF_3Now0qelmrpZQGv_deTzAmdnysNCOfYbj9ryH-LrkmMw_v7m51XnpvdMvZQmTYmST1HAXF-KFiCF1sTQRjn1BiojfDs7OGawo78_ednYfv2Pi6LR9CYXQtTbdcQGm5vR22UlNWoldBuYPW8LPYP5MbWWwOrzYWzaVODDRQ8Pn_xb9uxk-ikIBgC1WmUuaXfgVqMAZSFo69dAJoF37_e-P1PKaqepGSr3UJNCNeD38e3heg0Mottdj2Csj3lz3d6HjlYzKDSq8hqDKh1VJlqIB-fDV5XRKh5pYIy2spzG4BvTPtlPFhHlHE-_TsSRv5T0LQkW0s8GFdFgSkLW28RcpImBCwqpbrsIqwdQryEwRaJJCwUpHunQKder1bL79554CRBTJuKrdEussQ6yrDWRzDiROUt0NhFDOwIZb_fjyvBTYs=w713-h632-no";
                        video_path = "https://media.giphy.com/media/65HKzH8AxXEwHK325v/giphy.gif";
                        description = "-Codos juntos al cuerpo\n-Manos un poco más abajo de hombros\n-Cuerpo bloqueado\n-Movimiento con brazos solo";
                        muscle_zone = "triceps";
                        break;
                    case 93:
                        name = "Flexiones Manos Juntas";
                        photo_path = "https://lh3.googleusercontent.com/MA5ABEQ961mYt8SzkA8Z3gx3LgvpzqB8qheaJtpgnlXyi8GuKgvUtY8KH8XydhfMdG2yWB4Qy46ieySxScut8t-7oYWNXfUTzMlIqVWOqNgWETuBkNSR67EU7XrG7ZA4cV9W379oGYsl7Z3F7cnX3LzRpzWkLgEX5u7O1ACMZoBNSQYdFXKk3B9qP-AE_F80Bt8EWbY_fNd8U2lQvgG5CHFe9K0ZciNry9CWGkFeFVNl6fy4emlraSiipL4zLY-t33XzCsjb_BXheXPNnsLrnqvG9j26pJPrZygp5rOva0t8UQ5t9gHWUNtj4wiqloJOoyMq75LyFdAVdtvoUTlMZbRggOqLkSlMStDzTJCXpsDJan0QgCJ24AeSRj7RMlOXWo49ID8ywpKGJFAyJBo08cFrd1LxBRK1ax4f6Ix8vHiqWuzBixbvq_N8UZHi6LNK3j64BN3eWUOjSjvxiAUwFovPSV0YLPC2WekBwhzLNr93ClEf3kqYSu1NoC9w3qmCqFFOnzRJo_wMhL0lOEduOi0m8cFki_zGqu0psDFqt9MpHSvp9-S4UqviVSrYAey1rREYl5eGZ8ZQBqZDrTPf5LhnU-bbQzB3iGsAK-vlszshDzAQxFOnRXp3vh9pLpy4L6q4mGk0VsZUJahUYgK5HFp9LNq-IxED56NrJbm2PN2kU2N5VXBBFPRL=w713-h632-no";
                        video_path = "https://media.giphy.com/media/1APhNvVCzK34T1MUj7/giphy.gif";
                        description = "-Manos a la altura del pecho juntas\n-Codos posición cómoda\n-Bajada lo máximo sin forzar ni tocar manos\n-Cuerpo bloqueado\n-Movimiento con brazos solo, equilibrio";
                        muscle_zone = "triceps";
                        break;
                    case 94:
                        name = "Extension Polea Sobre Cabeza";
                        photo_path = "https://lh3.googleusercontent.com/Yv-oKvjKbaOsRCmJAN2TjIleyakwGX1wrW6qNQt_-FAaWLcXopgtuUL6KkMwfYD4JmgcmWGrMwnrVNeKly6ACfDpuOtzXaFdS3SuJf6VDl5lqcatI_Zlerjf9gTglinGQvCNqqWLUjgT_LoGiVDMI7IVo_y2lVdsEyqIWKt1GAtpXFJaDBFYIJV0S_5Z-CiqAqm-rj4zaIAJXFaGF2SHC4GWIMYM-jLze0JgKMl9P6LsScP0SIkYmDr_WtPho-lUcIBwqb27n8we2WWmnWSB4d2ym6IBicSMnklm6OuR48fG7-WDJcfRoa-nL3vYvVStawYqFT-ysYvNQnzFcErJ0Lx1iJ9dqoegebdMyiYv2aYgjqJwyurT6Ub_5le5Kay6iCvSIP5dwXQKS2P1wl_s3_ZiB1VI8SXISzRm8ROHnquYeJ9CSmXzFkh0qzBhCbnpOJt7v-gausTpw0Aa9VZktTv8bNKyvPAZrty4UmrSwxuB8YaD2B6TX11_Ch6DFAqBUdIcWMe-sZyXtHiRjCZzm_MGKpIF4lWtPd_mTosMNP43nEJt7XdPnM6IEdp7n2B-BjQNQWUUYXdoU-IMGONOMce7IiLgo8HmbhF1WtU_7y5_QuXcgOuYEvw78GbiDoZmuW-mL6nhLCEraAGh2cRHXVOumurtQzVFyBLnw5IQuQw9qzOtgb7eJskW=w713-h632-no";
                        video_path = "https://media.giphy.com/media/4T3QGNq4wA4pnNRjIv/giphy.gif";
                        description = "-Piernas semiflexionadas espalda recta\n-Codos altos, se mueven antebrazos solo, resto firme\n-No dar tirones\n-Bajada controlada";
                        muscle_zone = "triceps";
                        break;
                    case 95:
                        name = "Extension Polea Manos Abiertas";
                        photo_path = "https://lh3.googleusercontent.com/yc5Cbn_RjVHo9x4U4cbCZcBZ_U4RDFAWGug4zvyCNlx_nuaHfCc5BadxaWK55h9ph9SlU-8yZnoBFuVl2N8OJFen5vQUjFZF90FG7hlT5o--S1rEuw4vA8hqQAvBjCq-GqOk-oYMuuX-v4q8fIAxyNYOLkvxYmjKoVzjVRsbEcgo5g5xxp9_8xn_EZVflDSWlSEidq25goAS6rpoLmJeW0z4M4hLXLkT5x_NajQFrbsxyUE0TQ9tNTgcIQnA6Svqk6-PcqE-Yzcl4l00zUkhCOw4Z1QVYNsGgKhKtAo4tF1UVNeNuWMmP8NRJyPH-_Vq713cchDarC4gK9mFMn4JAhZfM0cHUDvVJ9TN-fj-Y4OEqxiSHWTh5vrZu7ySn_a2EdgxoHcIRXolbWmP4_QfqSFaX8E2zYJCjdjxhGPNDnsvNQdYMF6pLPpbQb4FSHa4jmAMip47kWpd67xCr_R-XizCmVKywoN8D3QKUsaVu7zeAs9k3MppcijrFzKqC8jsHTvLAuT7B4iukcIeBMKb2ePWM3QCWZ74Yls6IGD3wi3ZIFuacu0Jm_fy8P23W6zzXUJLij6pX977As_ZgePY1Lay3uT3jEY3Yhqe2nixJXs5LtCasWdCDSN6cdw1CJYR5xZnvV-Kfb0cwFKstrNd8SJz2_WyqqDTgylWnhzLjhdjr6F-8EUWD8Uu=w713-h632-no";
                        video_path = "https://media.giphy.com/media/30pMgYTJWUImJK5ykv/giphy.gif";
                        description = "-Manos abiertas\n-Codos pegados\n-Espalda recta, piernas semiflexionadas\n-No balanceo\n-Movimiento controlado";
                        muscle_zone = "triceps";
                        break;
                    case 96:
                        name = "Extension Polea con Cuerda";
                        photo_path = "https://lh3.googleusercontent.com/HffjCqBt0kiYf_2NLOLrx5-IGMvK3lsA207ppkSjVuVNZ6y6xSWL6MFlQSBZHtkldTRDqIG6FgTsBGLBKsJfY6-0NGFqaX5_sb58fNwhDQwuxGznHKLnpBriy4-Lk3GKhDxOTVlrle1rdFBGE3sSPOhzncdOiH5XXzPnjTTWSiUihyKWyZsoeI6jtMfLKsBmq2pdvuK58aG8cvkBMJnU-JRZmF4kvRzGGlS0ENbs1OcI-oV8ujHD1w57R3rkF2XE4dnSlwCthIGmaIc23U39KgLhmWFzLSwnoLvvXMVFs7gmaHSVphoFLfCLB3mTEFzKkbDlNpK719AUC3wTTkUX8t6V3qwL4V4YGVA8h2Bu0MVHbkrYFzSSNs5kCDYMC90_v012zb-g3UbviY7Mdf7eijT507-QeZjlYVEL-rANkym_K82uWshW2Q7FvwXI4IK8_9hRHv-NL4RcQIUI5MqhApG5v6g-4ypZBHYaMeR2ZiUOHu6GT2xHC2Ni1rM4b_ckkDv4arNfRrwbjkABajUjGUd9AfosevVWL3cj7OrQePIjJuuODL3N52smIioEu7EcxNCFmblLahEwEGD2G2mLKcOA1l9jBnkVARTyQ-NikpRADqcFwGzOCYa_rhUIkrmn_X6F8daahE3lrO1JTB_ojQkHXuEARFgmqCMaZoJVBezHC3UddigD0R6N=w713-h632-no";
                        video_path = "https://media.giphy.com/media/1evEWqg2ryZyKK5WU8/giphy.gif";
                        description = "-Piernas semiflexionadas, espalda recta\n-No balanceo\n-Codos pegados al cuerpo, se mueven antebrazos solo\n-Movimiento controlado";
                        muscle_zone = "triceps";
                        break;
                    case 97:
                        name = "Subescapular con Mancuernas";
                        photo_path = "https://lh3.googleusercontent.com/g1AKein2o24zM9YFET_zxHXJBlsBl-osN0Jp4Unx7dHqkxfL-tcVi_I5xmoCqpLW22D2zOsvx-tHXIeYW7bm54dBkca57CjNexmZcMIuPs31wQK6U2djeg6b7a_m0-kEJNEGpUIUGr_UD6ZSMFFQT-DLY4F0rTwq184MbGiWDbTqAUOOoKYcZS5j0jDVIPgHIYU3iQf8feF4dVGdlsagCT-OhsBviC6tgUdAuIpK2gixk0tbLI-Wb20lxciFI3Sj57neP1oyQPXOb5V-Vmh2hMWgeu6PA_YC_6nOsvE0sdAn2AOzVWyS5RXENVOyXlQR0868a7OVPuaroB-fqcDfopp8nUfJm6UyIQuJS0N-rRJ8Q8MiXWLezkq2Lz3xWgZr7O_wX0G_u-zZI2QcZghShk-Mm-2YmReHJboQJooa4sg2SdqMN7X7LOMgRdgD4zz9GNrXwWCxZ4SqjYopNG4_h40TjRKATGgM9YHH7YWTSlo3KjXNk8OuI21HRM0OuTQTIEyuBBeTrrAwNy9vCHTdAhsDawSvzWobJBBn-Cx_PSrZtf2HRlcGFsVJFmX10nVoldXThABVOh9OzBbavdgacMd8I92iTFulew7jwo7cgzaDIGkVqCtiq-xSEytf9RYTOtgw5ZIYSWtgHENggQhYdXxjosS89Wo-O8Dg-2bHqvh2QkeRc8R4x-Xy=w713-h632-no";
                        video_path = "https://media.giphy.com/media/7AaBEKU1cl9afRe8Fu/giphy.gif";
                        description = "-Codo y hombro 90º (inicio)\n-Subida en la vertical del hombro, brazo estirado (final)\n-Movimiento progresivo\n-Cuerpo cómodo, de soporte\n-Movimiento controlado";
                        muscle_zone = "upper-back";
                        break;
                    case 98:
                        name = "Supraespinoso";
                        photo_path = "https://lh3.googleusercontent.com/l_SN2rNTRjb0NarWclH-JJf8Sn4I7mc8XvtgTvenQk3mGOZP3ywwxLvVwqsU50YHRvxnCrHK4iY_583DlX8wzLy2r8WLdhSIdqUUGg10k5I8fWC6hLN6UX2tow88af9JTrXbMnO9r6vnwHAyd_G-wnvde70X-p-gqkc18Ik_JWnhwJhcVaTsP_dNyA5cViGX0YSsCKJkQGuRiyFJXh5x3bZsNu0ERA53OuEwL_oQhPgNB6qf6oUeLOtHYv44fK0G1AcJHLg6VvoKcAAg9kcMQxAw6PIy76iIwLrx2tWLSo82buuZNqdm8EbnCjXlT8WUYOUtHkd5jDPLeOaBy2vmotgTbvGYqac1FExcZdaaY7ncdHWOdWoEWXFmhzeay0YvDaOrPXyDFjb1DPN7d4GSB0XNCoENJv8yuoDCT7mAnn9hC6U7qKzhvBRkp1BKZj7d2JUhnJfAtRspqOAlP40WnbSv6SclLGoBhxLFD4nahmonfGAvZqd7E1g0XH_4TJ1eV_u-1IdRHNYjGgj0QKW1dI_JcVmPzFOsK8sFtnJaC0i3I0WTN1drAgRNYMvCgulAGCN_vAJsesCWxXbU9xiqzNJnCM_IxP0Na9KKU-JenOsxKP8KenmSk_2XVx2ki_JO8t4fNb40RANgbOVrWb9Vq4Bum08Fisgi1dNvGtbEas-IZ3QnPdSS2yI_=w713-h632-no";
                        video_path = "https://media.giphy.com/media/QmDnjZzM5DDVj6zmlz/giphy.gif";
                        description = "-Subida hasta los 45º\n-Brazos estirados\n-Bajada controlada\n-Movimiento harmónico, sin tirones\n-Espalda recta, piernas semiflexionadas";
                        muscle_zone = "upper-back";
                        break;
                    case 99:
                        name = "Kettlebell High Pull";
                        photo_path = "https://lh3.googleusercontent.com/uKArmM218BJ8xmuEv1YSsk84uGrH28hEwz1II2K3SdUjR7nS2hrZc6Fp1D7ZLGbBYu05VVNISV-2aMz-isdoaIzzZjk5dn0KxkqSXsf9w9wV_eqVJLr-3X_hsAoatGXl0hzIAN-j2JeKXacEaQDk1QPch_OfzQ7708i0BoniZVSYvllkZ9Yr7KxHrZq3cO-nxQOaUfgEZmQViwerVcs9JhVp0hsF71YnlHiB3AkoUidS6_uDQVAbBM1ewMvtGwFn7TkcArBwMUdovneH6gqhL7ZitvHMoL0mO_KV51IZCmiAuV8KT1JRFLfugi5pRPAkZsU-nVimjl_1DB0B5YwemEOorcywIz0u9cGea5ZJh87J4lCe_EYBgup1W1IWvwIul5IBs7T3uUCjjQJMOi2higONhnz19XlHYtK4BfLtzo7WjFQY_k5OFMjDHtqjrfAlKAC9mX4DXjMzkYkVIyo57N5xXQ3M7Q13VGJx8xwWINwiAwqTgG1MPaB1-buFxJCnfzGRJko_ROOujOvbWk-DR2YjNnCHjhgly_Vm0l-e33021PTmBKFY_y_3lEmz3RoFqq1iTmOF-US5ZtxIyOu8jpSanafIMMkvsVH3hZGtW7PNQ2FyC1Wx7SQHjDwX1_R01fZs5LvScZWnAJteIlptt7D2PbGMz1veixgHb5wNZcqYxcaaIxHBDWLq=w713-h632-no";
                        video_path = "https://media.giphy.com/media/2fLcHUDvzGKNS0X8QD/giphy.gif";
                        description = "-Espalda recta, piernas semiflexionadas\n-Subida en vertical, codos suben hasta los 45º\n-No balancearse\n-Sin tirones, movimiento controlado";
                        muscle_zone = "upper-back";
                        break;
                    case 100:
                        name = "Infraespinoso con Mancuerna";
                        photo_path = "https://lh3.googleusercontent.com/kAWtAeZ_olI2cfdX6K1-MxoDSRP_tmSwOsgT7zyk7WEv_q-MlTdcW6VU1KiBh_i7nRciYO5SotT1sKIk0f62EU5totRA86rOSDxki6ButmSLFai_jh1fsD2tB50SThvPYDo8rRWhRNk8j6yo_gwEnTR7sbfXWOO4qv9enO0N7auhcE3JAyECMtetffiqA1NWmUCVzEo8rRtCRhwKH_GfzxE1L51NJg2351_n4AVpDDxrz_bUyqgHqd7lWt-Pcug6CFxD7SvGOshgRAojTZWLcTsRLjStdYCYR_Djv3mtTVxksgjabyPlMuqbv8N8wsgEhGcvsPJRE4iPc2oVXqTh6-49-oVIXOVxvgbkzV93uRiw-DxLLfP-y9pD7qdieu_coAtNoFP9_QCs6g_MofIVZcsWFiNpxxYw_ucf97zjSGVdmzIJ96V0vl9C18pJXXwvOuWx24j9B-EEJhB6BKKoKhvonP9iuVQe3mA7nqguQg1GUUHf21SuLyRFqWzVJYD17d8InBTz83g8xAbTFIlNQm8SrGj0pj56hWdP7JnhkVXvk80koC3ksYm8hBxawv0ZdgcDJjXL8-bZ9VHFYC3qvTEQ-el5NOWslDr-e3G6X5RAEtlQ-uuoKxEzMFZgj0tdxy6Kr1OL5FWhBoaNClCEODmPELtaH1vhJgDz0J7fSOYMOnKO0FuEVNXE=w713-h632-no";
                        video_path = "https://media.giphy.com/media/1gPyMEAWqjHXQ3siW6/giphy.gif";
                        description = "-Codo fijo, brazo-tronco 90º\n-Antebrazo sube a la vertical, sin perder los 90º de codo\n-Espalda recta, piernas semiflexionadas\n-No balancearse";
                        muscle_zone = "upper-back";
                        break;
                    case 101:
                        name = "V con Goma Elastica";
                        photo_path = "https://lh3.googleusercontent.com/6X_qX66o1yNI9Dv62rSvcw7E_xpbSlvLN_Z76OtMoYQZsj9j6cSaiU8S80mi62R9lqFMWOX7pCqxb4OxyX8g-UrpwWjmo4GJQkODYp5-UWL3estEyc7d9D_-fYNofJYVd5beaHg1nbKRLe28UvovKGq1RcMk4_HgmOPh3wUFd7DA_RaqiPCPoRKF6Sf2GyQhMiWoQTMcs2WnOwBioWa3L6OTVAGfTH_2L9ERFPmb2QP-YeVuQHkfibTZsQl3CF59-gHTL3Yns0P2Pzo0SnL69OlH3onqrDMb12ov37EtL-3LqzsXh3KkSK2817ibxhXbJFN7VdB22xVgSFy1TqiE6obZesWgAOqRcGqI9ygv2AM_-8tuuFGPLkqeiCmq0Ar9_6zypJdV2OyIRqPf2G8nDDx9UANy4WitYa0E_AeIJzNpzZyrOpYBPQURaKN2l6Zdh3xM34T-OIuEwIjp6QndJic4CJxNp24O9V7LBtwpJF58U_YNPnFCgZZVTpsafTrirsaSHkoeQRVvDRvXSbLeZ5huj56gTRZTd-ArazAFbTHZGqJU8b8Vif8-m0BZb2K4TmuENRA6Eia6oGF8WaelMdQTj6BaPzXChjHXbvgyFxZAmbMZqITkCFYoYRY5pXXPkZJC2_uzMwOFIMB_8wffn6e3z0fRvAZ3Or_wjsQsyumNwf7nZEj5_8b4=w713-h632-no";
                        video_path = "https://media.giphy.com/media/RKoK1LFOXbYZsM1MwH/giphy.gif";
                        description = "-Mantener ángulo de 45º en hombro\n-Codo ángulo de 90º\n-Antebrazo sube rotando brazo sin perder el ángulo del codo\n-Espalda recta, espalda semiflexionada, no balanceo\n-Bajada controlada";
                        muscle_zone = "upper-back";
                        break;
                    case 102:
                        name = "Infraespinoso Goma Elastica";
                        photo_path = "https://lh3.googleusercontent.com/hB4dHmYd3bj8S8GuArEWDQf3PeoQ0NHkEvsak0deFHGKQ0PPADgONFz1FPIau--wa36ktJlCB-M5rfvy230jbDlnScpnxUkQdZTDwRGUxHLQF2t0ww-eGlCBFAYOedA9TL0iHYT0ggsi4P0r_HzOwhm73YKdNpLyDGKU_-gR1uRp5THMif6XD_kKx2BHA4EMqo99u-M1IBCSw2WBEL4m3WFspVp7O8GmRrDmr9OKSfc8e4eKSq23YM2Bve2DNVCDPkEgN07d0SXp51fjWDHp-isaVxFJvYuDo-xjRQ47kRu4egEuUQVzdVnUNjboY6R2s1Bl5t-qNUyK_FR8SZ64E5fuBIRRZzGl8Kc8ACcqBnkf6qRDKrAHnCc6Q-Gyh0PHb6b4Qy9zLQcakPhzNTWl7u17KorkIigLzDN6BaxM42kzWpL7HlHagpOCSLKaDQAk8vCJLabWPSJW-s8uqIUcMRWQJJDWZgGKYUN4vRNm0-N0ryH27FwGn-oqEGl2GnV-IwPlY1X8W0YK8lA6aFerQL8BWnzWO_ILA2eiS0xIy0IzAwTrFruRIO-m4OZEvU-bns_6A_9n8YulCWpza-MZkttGZbgLjmKwmmDDgNUgyapXVcPfaI9Wq4AuIZJWW09fyHCI8xBWuiq2xXkEGXDZYQWF0WUoKjFCE4FaV-d0XCCeP078Fk5-g6NQ=w713-h632-no";
                        video_path = "https://media.giphy.com/media/1gSpNbE1v5ULkNNXwL/giphy.gif";
                        description = "-Codo junto al tronco, codo 90º\n-De lado a la goma, estirar goma hacia el exterior\n-Vuelta controlada\n-Sin tirones\n-Cuerpo de soporte, se mueve antebrazo solo";
                        muscle_zone = "upper-back";
                        break;
                    case 103:
                        name = "Subescapular con Goma Elastica";
                        photo_path = "https://lh3.googleusercontent.com/OUXLEojbdLdTYpozHqm9LKv6yptF1TttYX4MrQkuKRaSbUNH9B3uhSLFbTr5u8MhRMJ616GTb6ERAzFJyqUUHVVmwXuL0pygIAL4zzAZc3C4hVctX0juE7bXJQFAM6I5x4HRrirF-GcfGJrTw7rwac3WwSXSDEWBwzcGW3PTRMOgDzaINhr0iUjaKOuPlvwW9qtlWAx6p286pfvsgFfVeqvTsE5aXR5otUp8v89rfDJbn0dJSnwoAGoRj2PAduzwkBus5BVWtXsn4-Mqy5mb2GW2J3sL_7TbemyIIj3oiOWigpGiAQXj9ZZ99CvbAHIGqAD9gQ_BIsLt0xcvUMJ7KUDx3ZsAyzMfzl7BMkORFbgMJJLuZdT82moCfQ2VibgB_8jxQ1h7UJ7WvT86ODRTKwEugcywfuous52bIgKORaOi-6NyhTwBDb6TjJbzMU2XGAghBz25eoWBou6RIsuplMY4p1N0mpix2pIE7JoypaGSIIvmnhL5sgiqAAhMYOztsp674Hbmm7IIg6mreS7Ulv9YLyLRpNjH59etI559qu2gN71ypWLMIGi73m0LJgmLTbno4T4AZ3SgMnuIXkQiXZ3abuZqg8HZP9gRs1vWiTO9Qy3syOIArZ8dsPjvpv3pMlLrimJfPF32TYR_yjFDziLTMkvn5BoqnVFBWSUf95QWMqClX1U8JRLe=w713-h632-no";
                        video_path = "https://media.giphy.com/media/9A34Cep8gjmptKTkqf/giphy.gif";
                        description = "-Hombro 90º codo 90º (inicio)\n-Ir a tocar la cadera contraria\n-Movimiento progresivo, vuelta controlada\n-No balancearse\n-La goma tiene que hacer tensión desde el inicio ya";
                        muscle_zone = "upper-back";
                        break;

                }

                //insert in Exercises table
                db.execSQL("INSERT INTO Exercises (id, name, photo_path, video_path, description, muscle_zone) " +
                        "VALUES (" + id + ", '" + name + "', '" + photo_path + "', '" + video_path + "', '" + description + "', '" + muscle_zone + "')");
            }
        }

    }
}
package deploy.android.lozanofit.es.lozanofitroutinemixer.sqlite;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteDatabase.CursorFactory;

public class ExercisesDB extends SQLiteOpenHelper {

    //create database SQL sentence
    String sqlCreate = "CREATE TABLE Exercises (id INTEGER, name TEXT, photo_path TEXT, video_path TEXT, description TEXT, muscle_zone TEXT, level TEXT, subclasses TEXT, hip_weight TEXT, res_weight TEXT, vol_weight TEXT, reps_obj TEXT, series TEXT)";
    String sqlCreate2 = "CREATE TABLE Profile (id INTEGER, name TEXT, weekdays INTEGER, currentday INTEGER, dayminutes TEXT, strengthlevel TEXT, objective TEXT, method TEXT, def INTEGER, more TEXT)";
    String sqlCreate3 = "CREATE TABLE Calendar (id TEXT, profile_id INTEGER, profile_name TEXT, calendardate TEXT, profile_weekdays INTEGER, profile_currentday INTEGER, profile_dayminutes TEXT, profile_strengthlevel TEXT, profile_objective TEXT, profile_method TEXT, profile_more TEXT, more TEXT)";

    public ExercisesDB(Context context, String name, CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL("DROP TABLE IF EXISTS Exercises");
        db.execSQL("DROP TABLE IF EXISTS Profile");
        db.execSQL("DROP TABLE IF EXISTS Calendar");
        db.execSQL(sqlCreate);
        db.execSQL(sqlCreate2);
        db.execSQL(sqlCreate3);

        //default values for profile table
        db.execSQL("INSERT INTO Profile (id, name, weekdays, currentday, dayminutes, strengthlevel, objective, method, def, more) VALUES (1, 'perfil 1', null, null, null, null, null, null, 1, null)");
        db.execSQL("INSERT INTO Profile (id, name, weekdays, currentday, dayminutes, strengthlevel, objective, method, def, more) VALUES (2, 'perfil 2', null, null, null, null, null, null, 1, null)");
        db.execSQL("INSERT INTO Profile (id, name, weekdays, currentday, dayminutes, strengthlevel, objective, method, def, more) VALUES (3, 'perfil 3', null, null, null, null, null, null, 1, null)");
        db.execSQL("INSERT INTO Profile (id, name, weekdays, currentday, dayminutes, strengthlevel, objective, method, def, more) VALUES (4, 'perfil 4', null, null, null, null, null, null, 1, null)");

        //if db is opened correctly (COPIED FROM ONCREATE METHOD ABOVE MUST BE THE SAME!!!)
        if (db != null) {
            //Insert 103 exercises
            for (int i = 1; i <= 150; i++) {
                //Create data
                int id = i;
                String name = "";
                String photo_path = "";
                String video_path = "";
                String description = "";
                String muscle_zone = "";
                String level = "";
                String subclasses = "esp.med.";
                String hip_weight = "";
                String res_weight = "";
                String vol_weight = "";
                String reps_obj = "";
                reps_obj = "10-12 rep/16-20 rep/6-8 rep";
                String series = "1";


                switch (i) {
                    case 1:
                        name = "Curl Banco Scott";
                        photo_path = "https://lh3.googleusercontent.com/pRIE4QlR3Jqst687rvI1omr7prWibo4_yUh_w4z9LR3G9snwzr8NCXahxQbEN-uwToWv6n1FYVURja4JWpxHn2OjwyxybC1ty8n1hkMjByKTgL3-7Oenz9bFCl19PRSp5u6p-BKHAJHNflrqwb265vqDi4BD8oBWc5YYpw-yvLfnBVTm4A2592jJCAc54HMpwfmZq2MbS1VuOeM5-XD71EiplnhidfV5lmoMBQMLqzoq0pEoRVvYzEAq2IivbdLkLlZvXDuSAsqyrgfDjo2WCRMNrtiajG0mX4JuGYyI50tJgn-UBBx2r9MNkFWMmnkjgDgegY-7WSbPYlZ7W2kX8_oxWKTWDphwyx2Sn9evhclZpFgqMnlWd9A_3ZxR2mm-vzVhpMpClgh_aLYqhU3uo-A88Z7apu57Z002FPw84UWIoTeX9vSkpw0o4b7d_vYGogPU5KT7qpveQ_gYGcJDNf6LJcjYL26rtLEaxkTT4xtZdhodJu5h4K6Pa72JXpQrX7RMMN1W9E1T6XEc8WZD7nMvpBZEAXXq1CMNdnrDqq0VSYxSM9YB4QQdVQG67SZCbVIwouS-ocYxQq54VgWI5aqB3YX_UdZKEMwpHaTn4LgGGbvLpoVZ9_ygqS_O9DaToedTSEM6IRNaseGxz-EM0mEOLouTO3M3aHpkb3liwolhmKQ7OlRlD2E=w1062-h944-no";
                        video_path = "https://media.giphy.com/media/VhWJOdfeiwO523mqlg/giphy.gif";
                        description = "-Banco de 45º\n-Extensión parcial del brazo (bajada)\n-Codo y hombro estático\n-No balanceo\n-Espalda recta, piernas semiflex.";
                        muscle_zone = "biceps";
                        hip_weight = "6/10/14/16/20";
                        res_weight ="4/8/12/14/18";
                        vol_weight = "8/12/16/18/24";
                        subclasses = "c.larga";
                        break;
                    case 2:
                        name = "Curl Con Giro";
                        photo_path = "https://lh3.googleusercontent.com/ZO9glHJtn3KaTR9YtI-oaTQv3mrNt4LHnCEgP8HCI6hCFOcqzhSjNmnn3fmsz7j_3cjfHmfWv05vCsxZHVi7H7RL8QMzEEt4-AstdFQJ_gYLMGmRw0Ey-d4lX2MRVTWKzrfglvkVF9sZQJJ4HAZJxxHtUxic8pwN6albBsb0wGLRU1jVKzvm-2OXbo6ordPPdqPlor2VKUfGsbBlKNSAIQPFr5qfTztKcZX0-X7ZbIVdmagsywEAIG9AlVpDuEnhHO2Ue3UkvmRv93ZetNwMEJlGaO3y8t6kVwD_moW0U4yDJ8R9Lpfp1b5Qtk2wk46PYKziGU2nMT9dF-m9YZzN1RJ-Kq2Bt26SRKue8cqCTj40xt1KgAt0MRMZtx2MQY_jF0vO11ht4ZSrh9jh0Za012l47EoFAw1xycTWkLyqGGq_k8RIrgjAvs5Ok-c1R8V-kMy4oFXf1gUXYuq_Dn0mRmEywjyEvejwvPmnJq7JWRFdCSkZPYojFxtm2xUXOdv2SbWTQjgZLOViTr-oizmpROFfiUw16k1faEhlhZJZg5OR6EgH74zdLFOzLEG_DV4Bic82SZWnS_e9R-D7kQ2tx08W-5rSg7vaD81jfWRh5MAysZ0tq99G7CGWjbbP94YHTgQ216-xlABxpF3m6I73ZHIRPjiF6b3AgQ4eGMfc1dwRrhhV0oGZhBU=w1062-h944-no";
                        video_path = "https://media.giphy.com/media/fVsIvHObGjxNJiBXLA/giphy.gif";
                        description = "-Palma mira cadera luego atrás\n-Alternar der-izq\n-Codo y hombro estático\n-No balanceo\n-Espalda recta, piernas semiflex.";
                        muscle_zone = "biceps";
                        hip_weight = "6/10/14/16/20";
                        res_weight ="4/8/12/14/18";
                        vol_weight = "8/12/16/18/24";
                        subclasses = "c.corta";
                        break;
                    case 3:
                        name = "Curl Concentrado";
                        photo_path = "https://lh3.googleusercontent.com/lzAS7j1jzb76P1iit8soZ3jkC8aM3CBlfspwBmRKLTXyfDM4iAUB0Ex3He67u99cPKhc-zx04xbdahxGcoWQOXTckfVBoKYCrvXGj_6y8SykG4mnnIn76qqlZTh5Dpo_cGG5aKWKtxkiIMEy7fyfUnJs8yAXi9Dpgh7ILLRqzGFSFUq_UKsPECmvxTsGqBgsEFzXE99J5lEJEd0Wf8E9yo8GteNSS4A0CC7ihh-cfNhKswTLlFilxyNkdIxdUFLeGt9wKY5LgYGf4WNoFjNuFklJirSTNynjFwGcxVOrAH1sf2rYg7Pcye3plGKAixTC8bM6zv2wnWRVkD2xzNnFy4Y2dMmvJiWfSPVgU2L010KOH4ij6lUsVzIuuPrkC4agB43Kq9c4CtYVLZdYHzZDKl1PCkgSoxuVsitaWpul47gy736LNqVWtshk6Dvy6LeP7MyHJzUAJeenDuk_J3nVdte3Igf0TRh8C91egYhsgB0kFViSgg5CYvLX4TSenV_vtm140wjrcqHFYwumOLmccnf1Cp-QEYJrf3_txpGk5o9Mxo0ggEoCByMMukqE43_RmWl73fgF0MRTKPeRWNnCExlRzOMNchof70Wod-_fjTG6XWrx21_tXXV85u6D3q6WnEWlLCutYb3-m5FCP5Wum-usW6R2hszQ5y5VtMpSRBBxLUrzGDp9Gzz5=w713-h632-no";
                        video_path = "https://media.giphy.com/media/TF0SpPp6PfLtd4SqpR/giphy.gif";
                        description = "-Espalda inclinada pero recta\n-Codo estático en rodilla\n-Extensión parcial del brazo (bajada)\n-Mano sube apuntando la otra rodilla";
                        muscle_zone = "biceps";
                        hip_weight = "6/10/14/16/20";
                        res_weight ="4/8/12/14/18";
                        vol_weight = "8/12/16/18/24";
                        subclasses = "c.corta";
                        break;
                    case 4:
                        name = "Curl Martillo";
                        photo_path = "https://lh3.googleusercontent.com/oB-fC5yU5eLKXTypVoDnEh0Umhr4feC19A54N6PsVb4zyMl--yrGaiEDPC_0SAsDt0BAuXiQ6HkRlJWM-lLATiSXn2nvij9bPKzwHdnsj0fb-A4jb4nk5-dOgmp9rrxmyWJIDYhgu8XcsWa88tBrqyFGEEbFFSyqXyzROSjnWAL-REtuKv4nB99GFREfJRWsj4OgBMTOvA4c9paur5iShJf1PsHkZMrK_lCIBQT1CgGZl6lGoal0PbPgCftpwTKlpPW1MqMpzOKN5kUAaXfTBsByrTaVCxnEaMgw_9o9XZK4RIgKeW09hfHeflUs5qz5A6y4j3mKNyKAObJsahXvCuzpPOZMeAkcPFNPKJfmh4Xw7iSm07_9ORi1pBO4OaL_M0aVXb57BQmErkWfBdvNfkgP_kvvvILK1gMZ3y1Ey-sZuAoy4Dul0BX7EVCyte91p-hLxOEsf-unPyXxoKpDs7j2aZTpQXD5VzymcDY33adjBT6BI6ZQ6-9BMXdmGQDPt4zTg56AiQf_L5sPMzWlw_FfOChXDVHLmKYfu4vok17WVwKybxIQSB7HWniinL9mRgqzhqbozGaQkYPSSpi6WVvF_-0PvvduczfHLNiHrMTpZ3O2xx-oi5jyapDgtFTDaxEzKN1KNC07XWhbse4WQFHfWoplyBuZlmYjdP9OTMMUFJefJFSBxlE=w1062-h944-no";
                        video_path = "https://media.giphy.com/media/RkPvuo5P4IquqssAUP/giphy.gif";
                        description = "-La palma mira al interior\n-Espalda recta, piernas semiflex.\n-Hombro y codo estáticos\n-No balanceo";
                        muscle_zone = "biceps";
                        hip_weight = "6/10/14/16/20";
                        res_weight ="4/8/12/14/18";
                        vol_weight = "8/12/16/18/24";
                        subclasses = "braquial";
                        break;
                    case 5:
                        name = "Dominada Supina";
                        photo_path = "https://lh3.googleusercontent.com/WtLoEjfHN_gAwBwJq7oEZqtiKDtSxQ3maYEKHKqzDz4QNQMvfcgeQhiFhgSw1gQIRn2qv6Ci4ufFOgtfydXKSYJiaXdWA2bzYjAhMrcZ13BJtta63KdvclqgSuuM_dMbFbOYgEvmRSymQSj_iZdApTt2JaRYuiyh9OpGAuxY5msraLDRLUZXlGSJl_zrIEUGiN_MV8HRnH_3GX3tShFL-yCLSNzgmSCdWVBg8M8sMg8fhycH_hFhjhUUsLhmZpONSXMj1NMya1x3RsMX1kKBKahKsw0skwTPL4rVrPGSo3sLudSLLIzEFF8Yhsb4pqxbBpq6y8owBrzYabaviqogPfcvbAicr6E1SRECG8bUxWkC3dYblU6EoRCMrwWE4lftRyLbjaPSYkz4MnQErjug9-jEQ6v2IOkOv1PKCK3tIzy5kf8hkCRlKXzNFG97oTx1PZZmZebICyduFCEEuHsa9-gErxAkiNqjM7l4Kui7VgmzqFDGV4dlUgaREProz3-iB3WCEWkiYLhIxPc3K88MSmU4I0HFWIHTi9LAG15jG-PjM3GpcN2RXsB_JllRxNTraEPn3BeKY9ibZO6xUZkCrYQLKHSDS7QlT_PWI4rvuRyh6e2ELvndwbmvnyKCJyNy3F30HWeytsth1Q6nGkjloaMweb1PohsrjftGT9MAQ5V0-0A12COs3Zc=w1062-h944-no";
                        video_path = "https://media.giphy.com/media/d8JqSoAihwzAZAnnFC/giphy.gif";
                        description = "-Agarre palma mira hacia atrás\n-Subida con flexión de brazos\n-No balanceo\n-Peso con lastre";
                        muscle_zone = "biceps";
                        level = "hard";
                        hip_weight = "-/-/0/2/4";
                        res_weight ="-/-/-/-/-";
                        vol_weight = "-/-/2/4/6";
                        subclasses = "c.larga";
                        break;
                    case 6:
                        name = "Dominada Agarre Paralelo";
                        photo_path = "https://lh3.googleusercontent.com/57pXS2nesCpllUYFh4doGFErX504wZKppuOjubi2Ku5wRKS1iLd-h7cKCIG-t5iAIkY3ATFS7QHOcw8ozxHRhPX4BjluW_x5O2S29PEs-1Sk0Jf7YZXeKKiEMatMngNwJiMBOhRnb0bDvy_3Y8x2yZHNrLwSL5bj8YIeU1ehiT2IaNiF3KnsEed-qAzAIMKY8ev_xrXUI8YtT2MJbpB_7gb3QkSKydBK6pf06megBSHDaG05pItL3vmd4zlZWEHLTSbrqkPZxvCKD85hqckIlZSTBeI3rZE6H-tjPggVAwYeRxXXBRD0udp1qEG4Yr89GGx8p1H89GiS5oLxdMLnAtFRRwNE52cwXsbvM7vXMVBFd-5snN2QciFVgsCfg29hzGZW3BXeecmpOpEbJjDPMJVKMDgrioP4L4Wc3DfWT4kczNAT-BRFmMomDbJtRWfQbNFZ5YC-R4gpsyT7nlTzexPiXe0WNLk188iFXccyNeTuC8G0hNfD6DL1X6vCiB75_u7KOOVaLQSd3qejbp2USnenSFmLkB-RDCFSFcsfXMmtqIMOc9ehKYC4X6Tcu7fyqqkaIzBPoDqXeAJ6dxyBjEMXzSRwMJ6EEafZRC1bMS0kK8-N_iCYI-Bn2SSX5BuqjA6Dg5ztiXKxhGpELedCFn94rfrhruqb6h8cf3CpdKoRrSy21eTxEOQ=w1062-h944-no";
                        video_path = "https://media.giphy.com/media/Y4bYbN7V76r0BnwZpv/giphy.gif";
                        description = "-Agarre palma mira hacia adentro\n-Subir con flexión de brazos\n-No balanceo\n-Peso con lastre";
                        muscle_zone = "biceps";
                        level = "hard";
                        hip_weight = "-/-/0/2/4";
                        res_weight ="-/-/-/-/-";
                        vol_weight = "-/-/2/4/6";
                        subclasses = "braquial";
                        break;
                    case 7:
                        name = "Curl Con Barra";
                        photo_path = "https://lh3.googleusercontent.com/TbeiMrSWx5RMJ7Q1IpVH5OrznIrm2BZ8WFqGOy56gaXHfuASNFqsH4Pa6PA3TZkeC_yOI2kXO7I-vwqRVFVgt1bvI41wv1vccZ_f66E37wNsHgrpsJgeYafplZ3KPaN-kzuXRe0ierw8vURCFqqxbwZgFRn2beuEo2TnOsv4dbOr02UI2OuZ5_nVbuMovMstlVVR0tBsfL9xg7Jj97B4rSzmW4XvVWvfkddRIW2RQmQcnz5T4Hfui0IAlP7QRXn-IC-yJNoEtncUJFMERO6FlY5QKaAx1q5Dy_auCQbVEx0H6FMBKYGZKOk_T2EhJEaOGmFLITfnXX4LUQ8PVxl_VdN6tpF5yP7beR2ergThON4nKSgUlYBFb4FEJH6Az35zZhg5A5bzUFyKi2i_cWNjzs4ehvYG8-5chQdP2gyHqv_umJbS1hetCpysRDFsZt_dpB6TbbjGKs2ELXGAXGGVOacEiuZKmbLqQb7IF2aamzVwqIVY_gmHXQTb-Eyf2nYlA6Wl-ypBpd2fsubSGPc4vC_hyzs27QG2jJcVqGoP6XzSMn5-aYgA0H04d70pdRC88vvUF-UxBNc5CEi-MMKRRVOfYZmuktGsuaGAsFpQTNLxxsY5qalhsIQhCiqpCuSmiO41elYYq6gLcZJ8-GZnRlMb_qP4By9SwEGNAuZNRKqU_tFe5wFnHag=w1062-h944-no";
                        video_path = "https://media.giphy.com/media/JQAOx9yGh7c7Au38qv/giphy.gif";
                        description = "-Barra paralela al suelo\n-No balanceo, piernas semiflex.\n-Codos junto al cuerpo\n-Palma arriba, separación como codos\n-Peso no cuenta barra";
                        muscle_zone = "biceps";
                        hip_weight = "2.5/5/10/15/20";
                        res_weight ="0/2.5/5/10/15";
                        vol_weight = "5/10/15/20/25";
                        subclasses = "c.larga";
                        break;
                    case 8:
                        name = "Mancuerna al hombro";
                        photo_path = "https://lh3.googleusercontent.com/S2T7SvqirrAl9QudxD7VcB1FLB_Jj2fFWhqi_A5L8bBcni5x3A3KDwgh69IcJ84pOM9oYxhmQuECjLdkui80mtBK2rOGmIM5ZBTib-eSUsTO3ctSQnRbs1y-kds4IvCoaF0gMD-AaIXUPNFSmUNf4UAuly5NTczv7lURVcCPdUUdkPGmXMAxGT-KD9YNHTBAp5_qyJlxufElUtHF6YDiEzyiodYakWtplE1p1l8NSdrWsRcaUpqXdK4FPcn0LBidyQBgTrVSVDNKGV_W78dx5YE40daXrQCW4bkOJSnyB7wM0tamtOj6TdXKIg3GtJj8g6FvWdpp2bTC3YJZAPxSorRFnROW0AV_cSciXsHck2K3qBBuL0jCDQgmiG-tPzpbTXNirCNR8PpP1L8iF8OvSiE0aabeEMhqsCAmrpoJwYaBSmt7dMycByuDFxNWgVVxhSC59H-S66_jSn-ua84ay5pRcqCVpZ-es0mIlsN_TrChKmwt_xkV41P4JDfMaBsuIBuTEDPqn6uy70rECPFYFQ1A8HCoEkX3JCbXfRlzcvdKmJI2htY6XMQJi48tUcfPdLeEpkxhEFA55zrvRk76D714ljtEw1sseMShx5qm6Ggx6LLBS-hC5ELatPDTa2Rn2nyY9bCrK47DAj13EmByAu8ydijZ8Pcb3Uao4dx7lkBQs8InmS_WbJs=w1062-h944-no";
                        video_path = "https://media.giphy.com/media/RIq3EgNsfwcZxBFY3B/giphy.gif";
                        description = "-Codo estático junto al cuerpo\n-Llevar peso al hombro contrario\n-Espalda recta, piernas semiflex.\n-No balanceo";
                        muscle_zone = "biceps";
                        hip_weight = "6/8/10/12/16";
                        res_weight ="4/6/8/10/14";
                        vol_weight = "8/10/12/14/18";
                        subclasses = "c.corta";
                        break;
                    case 9:
                        name = "Curl Cuerda Polea";
                        photo_path = "https://lh3.googleusercontent.com/QvXpMXs0NjtRIiXZnwU35dbf7uSugN_slFO9g75y0CsolA7GwZLd8LO-J5s-Jbvx3uqFF5YX7pxLzYBnQw_KtgcryLoVWWLXcCXNmRdLTj4RvWVPZmxfmD0BXlyD2mW2WNKGDATEzHGDoF6T8_cSFs5t2Chvqs6N_sHCfTxnixmEQjL8r89HPvbSFuz9QVvuyk8IQssufJew5aaL2k0L90mCQpPi82DnlMjuY46xAbGd70bTBMSmoqnbvYYXuX9UBV79JCviVznxo8eSTj7XGKTuI32lCF5Rdcp_Q7y5R7SxfduUhN8YoDjVcOC0MaFGWMWSUsXy5HXG_sBbUuDb3TvaygetDMjMIf4ovMpTTVFcICqGJmoqL_4Epy7jhWONYtKXxD_0Var_d3lb1SkgYj6JmU9CzvVIM09hLjWiUIF-pyg3hxs5s6pvgW0Q3lGem3FjQYj00rd9WBTbu_Fv2N91YMPLwuULlxBXm54bghfGTG8jpbEKrQBvqIjAU0Yoq6NmyZnbPYusEb7jDZsLf_8sZPbejFaFSdWAwxlvMru-MNg6Hfs_cbogZuQ0PBb9YELR5VITTLIbNPdFEgdr0_DjdNaejuFZnVh7OaOhMCXgmMffh8DZWAsDarNN28_pfgrbhcRqR9p2PWiuV3iWsDB_3JCAQk0LYl_ZAdcL5tYXkH1vvazEL8FE=w713-h632-no";
                        video_path = "https://media.giphy.com/media/euPUdV2YcfdRTET7pg/giphy.gif";
                        description = "-Espalda recta, piernas semiflex.\n-No balanceo\n-Codos junto al cuerpo\n-Cuerda en polea";
                        muscle_zone = "biceps";
                        hip_weight = "15/20/25/30/35";
                        res_weight ="12.5/17.5/22.5/27.5/32.5";
                        vol_weight = "17.5/22.5/27.5/32.5/37.5";
                        subclasses = "braquial";
                        break;
                    case 10:
                        name = "Barra Z Banco Scott";
                        photo_path = "https://lh3.googleusercontent.com/f8hV7BI_uAXfds2Pcsga-OoVT1Lv2acCSq7QTTigFf1YtXYu74PXunXisCWD81TRc7heC2RNqdFmC93TyDhcx4ba38iVOK-srSZgBWjBCCcGuLqZejntDiBfh0y-uq1wNet3iCkZCZhACufPyx1iAqoaFQihI5dRlYk17K48FFlr2vDSKb5w6WW-JVxUTbpGR1i4OPudManX3IIzY13qxaThv7BX9tFNw1bUzSy0P7ac2BUB_c0tnO78-acBo4dD3GIqk8bN23gFk27QA2cQqD4NmWGohAxnVRxrxOWpXE8YmUsA8lvR3JVxEAdxZXtm2m3_SceNDxL0kZ7-lL3M5DF50M31b8wJ-PI8tQt9atPQLFfbf_wBZInh9CXKr1OFLT6tUsgjN8t_SYkPR8O604SIOuKc3_fg80hhLGmG4fwzhigl1_3mbxYMYk7tG8VmZ2jStZvwfWNS8DvsDqhmb6PgY-TAXdfdhVfIPxBS0pxv168LuG7_8r7psozlh5fj8Dp2cmdoH4Oz7Hakb80LXSGiaYyfTxBtfauNVJSje9ytnpDmdVZcT-25IEAbnne62RpFxt7BYOItsu4SABkyhn5IZ2TgeTt5LUXHiLVxlAbFw-CF8yR9-aqjdNOwCww-PwKnMvixLmNolhVQRYxPG8dzKqlV8Tp3a4kdPlH3NGckaLXXrIn74J3l=w713-h632-no";
                        video_path = "https://media.giphy.com/media/9DyQyftsliy0uhIE8i/giphy.gif";
                        description = "-Extensión parcial brazo (bajada)\n-Espalda recta, posición cómoda\n-Ajustar altura del asiento\n-Banco Scott\n-Peso no cuenta barra";
                        muscle_zone = "biceps";
                        hip_weight = "5/10/15/20/25";
                        res_weight ="0/5/10/15/20";
                        vol_weight = "10/15/20/25/30";
                        subclasses = "c.corta";
                        break;
                    case 11:
                        name = "Curl Barra Z";
                        photo_path = "https://lh3.googleusercontent.com/V1ArPQSqL0JYNoa7VSVytEuIqXETCcsHLjPiPB0hWL__0C9Q3OCq7HGKyjI5FrxtUcfGVW168EMIeJvRkv4ZDrut3F18l_7iq06zdcthAPGSpCQ4MHQA-CJkjZ-QT88EWndmYJOBjKI0QzurE_akbYbM6o18-3HTF0JNKXgGPDBzfr-B4Z5wNAv3FCWYErCzi_ZMbSRtNj_te2yrpohkxtDCayPz0nmI6j_vrWpK4RDBESC34XaetpPoNrf37ELMaL0AzD--8vJghgLWTzsUiGwS5l7gWj9-Z6VrZNFAQO1lCl6wvLsPoJPExv70JoJp2FrCNelXpgHdBKEE1HBeRNrN7mB6Pd_NEvP_3JWA-2Xb7BJqIkGcKtIXT9SlgmZVkHH3oqf1N94S3oW0ibhMJKBnDs6sT70nU5icrA6WgECSTcVjOCkh2B4FYo7TdYQDOU7efnJ4z2VwMMxNwu5x1dyKdmvcYR38UKlyNaa0etL6iLrgrphNMGJ9-fi_IUAiTithpZT5M8nDRVgi9QiRNWWd7McUBJWIHke_r0mJTZF6O4JFBvmd0-kQ1vsT0a-iYlk4560661oCROgPAa0YFowcYQJOxZ7pIob3X9IcCS3uBNc5qwPjhoTesh7u4nW-k2kmImijtrlPdpl-EIfxdY-yoNhVHMgbOHvkDdnXnfePWyQYSi0K1Mj1=w713-h632-no";
                        video_path = "https://media.giphy.com/media/lq9qvKmuXqiy8SsO8W/giphy.gif";
                        description = "-Barra paralela al suelo\n-No balanceo, piernas semiflex.\n-Codos junto al cuerpo\n-Hombros estáticos\n-Agarre mitad barra Z, palmas arriba";
                        muscle_zone = "biceps";
                        hip_weight = "2.5/5/10/15/20";
                        res_weight ="0/2.5/5/10/15";
                        vol_weight = "5/10/15/20/25";
                        subclasses = "c.corta";
                        break;
                    case 12:
                        name = "Escalar La Cuerda";
                        photo_path = "https://lh3.googleusercontent.com/3ykxf62mb7cQDO4i57Oo_5lmP_RJ__iyn_It8HabSgmEZqs-eoDIDTmDSt04ZZwWxo5iWExl80nLPN2e2xN5ICoJBejQt1b5MEVMeHXdehiMKGF_pWqv0bAMQf0WjcJkPcuc80npyAdrLygpB0CRhqDS4a5jSIkxg05aA_DHz6xMGTcTC1ZQ1OqyBzdgEN5qeBvR0bzLyIOFXINFYNW0ZVpAzQ85rc8m44jlLNYrDkl_IgxQ0VYb-HUaLtIz44I0mFKs3NXT-QG7_Sc1ZPX7bXeqAcUnnxz3eGDZ4bT1bk8d_VrWsxB56SpF1Uxbwk7vK6evjL2Zt8V_MkahkZv7IAwpmE1wZaZbGgK7OzpYG96teBJZknu_9lr8MxVJl0orZZL55OJff4wq4kvJNQ-M_Hs0_i2TPVq_QA6oLPAt0-XU53_gMfZhRDmK7eercw1yjlg7JY7YNVHhg3vjcTr9rTPOP4vjdy5l08F0_R2oRvAQtTNyb9Bx_TqjgqwCW2nijjjYVKi4sE5uVRDc4WM_hBf6t72GwZORe0C474JDCfU0GtJ7yTIc71QU5gLxr-9dPK1hgTfGwH54iDsI5Fyiai3JLzgZJfJkb2O4WqelVwJOia7tarkPCaaPXP5GYmkZSOEa_eHZRcWluu1SSIHJovZ7he_TSd8up_X8Tp5vy8CPmN9OkdxEhxpx=w713-h632-no";
                        video_path = "https://media.giphy.com/media/3LdSdt3op4tw9XyhKa/giphy.gif";
                        description = "-Subida de brazos\n-Evitar balanceo\n-Piernas cruzadas\n-Espalda recta\n-1 rep = subir + bajar";
                        muscle_zone = "biceps";
                        level = "hard";
                        hip_weight = "-/-/0/0/4";
                        res_weight ="-/-/0/0/0";
                        vol_weight = "-/-/0/4/";
                        reps_obj = "30 seg/45 seg/20 seg";
                        subclasses = "braquial";
                        break;
                    case 13:
                        name = "Rope Training";
                        photo_path = "https://lh3.googleusercontent.com/yNPYE11qCiF1WW_0rJdZBPKDhywQlv5akHCkMPfqK82-CjcwyNCRHiDKnSwXRryqtCJhIh2snZcP36GwPnZenuuQ09So_4YjJZ99jwUb9hqLEdPFhdgyPu2ljtzo8Mk1S_5V6OKYvscjXENPrZjPQDNiX9f-uxWGdMxnVKMrnjDG_SRDMNCFBG1na9aus7gVyfkbiK6qjocNWacz8Zk1b4Hz02U6rerOY3Ch7Zstv8cJ8mFxKNbvhFWQM0T-6PGsJcpgLpXMgqbHHWgYT9ltFyvmoUVTaWZ7NpZeEv6SEKl19kxPZvqePi4AsZumS_X6jPfW4BYRp6l0O38DD3rLf-xhZjlO_osgZXOG2kVYsGLjpnGzIS0_K1griJ0jUGWAO8WulmKo_TBSeHbQFt_1U6D0bewwWeRSmZoKiHls6HfQ25sTUiZr2Enf9722SPjyLr15Z8cHPBA2TAles6juGUujhz3rRT_0o88lHOkdmtC8YOXTKNnjzGELQCeMMz63g3OQMU93EIxP6T6Z37dCpXfeGBzRakIXSIEaAvMQykFFxbgKylhrsUouqIUgDkfOrHMsvjnI7VIvhQgiXzWDRSbdM_CVoNonOxWjU9vPJKS-ZEvaBsjHcvy3yLW0cxkFYnGkgpy_Aj5iFa_B1QUnNCMV6eBPxTZ_d3jDUJ_nTlrrzJEeuv6YGI_S=w713-h632-no";
                        video_path = "https://media.giphy.com/media/9xyHLjv1hu4QtmIWjy/giphy.gif";
                        description = "-Piernas flexionadas\n-Espalda recta\n-Crear olas con la cuerda\n-Brazos altura hombros\n-Movimiento de brazos amplio";
                        muscle_zone = "biceps";
                        hip_weight = "0/0/0/0/0";
                        res_weight ="0/0/0/0/0";
                        vol_weight = "0/0/0/0/0";
                        reps_obj = "45 seg/1 min/30 seg";
                        subclasses = "braquial";
                        break;
                    case 14:
                        name = "Superabdominales";
                        photo_path = "https://lh3.googleusercontent.com/kwL5-slwlAxzy8KgsjntM-ai2F8bChUj0dMd4SsuoEBkwIHoiE8VKY_GqKMn3unxUcv2hQS1nEoFYsX27CPVO_5YoxJZoexKqf2OUW35F2yZmaDN9KTiOC7qKQ_zyttMBLh4COF_y_x3oiKKOLZTTYcXuYdKt8NsKBZPRg-UyRz8bLTqAnpKDCPIRnq15ibRyyDZo3ZEAasVXKvVmqOFG50ATRCP9qwEiutXmDvqm6iEEdwGV6NxD0NBR7RJFgr4iWDbzdO3yCqRNKlRISeCSU5QZZyUwjSN2xY2U5zmNhRzqxSzHjbeloDk1lpf5r08m_-adHudzGDeItqEmWIGGP1WlPBtjjjNwMX9yHNNyjIr7ZQiwoor6SQ0eKIE-d3XTz_dB0kyPyVfKammtIug0oaFvPJFHtV_mdt6G6ZRbqlyqOYEn6VgXTo7ttAg9tOsg8QHjo6hoUpyUxhVKp845-gXsqTVZVooxMzd0r4RW4unW7uF0p4zCTIsCp2WhF6HAqJa9KqN21sR7QplB9XaZCwnjX2k7Wf5uhB7Q6w34QSRxQy9elcmHVSyU5ombfU4xRlJ_Ray1C_DgcsseBLTmPpdI9L-OHldA_q5CFWuv96Aun422WMBEmttz0AtSZbl5oU676tDyrGKdkbKiZGGAkwMyFkjdpfML2VZ0QDHGdfqVPODm7uZ7NBC=w713-h632-no";
                        video_path = "https://media.giphy.com/media/3kJX141BbOd3xTl4Sv/giphy.gif";
                        description = "-Alternar abd de torso (AT) o cadera\n-Marcar la posición V intermedia\n-Parte no flexionada estática\n-Barbilla al pecho (AT)\n-Peso: disco + lastre";
                        muscle_zone = "abs";
                        hip_weight = "0/2.5+2/5+4/5+4/10+6";
                        res_weight ="0/0/2.5+2/2.5+2/5+4";
                        vol_weight = "2.5+2/5+4/8+6/8+6/12+8";
                        reps_obj = "18 rep/24 rep/12 rep";
                        subclasses = "medio";
                        break;
                    case 15:
                        name = "Crunch";
                        photo_path = "https://lh3.googleusercontent.com/5cG7Lb3XI_wR6HGdvjBeGlYosgqLmmxwO6exv-SNm8uCsYenQVeZJDhv_8cBfd5sstWsvL5GhCXPSIihQUkVNVDyDZv3nEhb1Zkb4ciafJIvApdyFu9ZOooal7Q1k-IFe8_MD-o1jSLpdhYEyUp4vEG3FSPnuRvj78JTrx_SJvDBx9TRmgTdA_VvJh46uJ9IoLbGXZCbcjDNu-_3LN5KhSrj8DnqB6cD3nlKzWLw8WjL6mtggXu4fnFGiI8ANNJxZkst6BVBGx-B0ZzHTrT-F6bICqgSz68eIty1S2SB_HNnuZFFZVLyuzKI8krP-7e5EoXt2E2f9-ocwwU4VHD7gvssU3s08IBANd13QAPdzppX87NYtZzZH7ozlM3sCdoSI35hFaSg_2W2glq1oqOC2rQJpT-PGa2lc8iDJLwN2MUIzAnQu4FmqAh5GRbG0M8-2WiL9I7nrhk167LHHnpCOe5Af7MMn2avS9KQXOms0gAy86A6fbn_wzfoJ6kA6vPQ1zobcz3DEbidEj7j5gJ8xggDI5eFf9fZaDiaaxFPTM-QwEgJCMNzz1Y3hb96xAL6kDiJqKVnt_dJZBCN9BWgFBPNxfDQKQ79vB-2YsODSs4XgIZvVIXQeGjERLbSk5MksK18tTRJxMlhT6wIuTGRBSWeKLPVq5lC1DdPqbxv_V73JnQKTSbYJimw=w713-h632-no";
                        video_path = "https://media.giphy.com/media/dyocoboX3Ed5PyoE87/giphy.gif";
                        description = "-Piernas en V tocando el suelo\n-barbilla cerca del pecho\n-Peso en el pecho\n-Subida hasta los 45º\n-No doblar lumbar";
                        muscle_zone = "abs";
                        hip_weight = "0/2.5/5/10/15";
                        res_weight ="0/0/2.5/5/10";
                        vol_weight = "2.5/5/10/15/20";
                        reps_obj = "18 rep/24 rep/12 rep";
                        subclasses = "medio";
                        break;
                    case 16:
                        name = "Crunch Lateral";
                        photo_path = "https://lh3.googleusercontent.com/BLhQ6d-NXC0uR0_aB7vJPFZ04iDBFlL91rP9ujFpTGXbkDUU3FxukLtaJoYsU69zxZPXAtf6Jq8MCciJ6CQh4Gt0PVJ9NVa3dDu-vmemQbFFO0ow65u6kFrBNLmYdkmS6KZCoXO2O8j9klmsIDLapnIAi_NBXL_ftgDal0ZU_Kqae_BPCqwznUtDvhEWKrHOnWxEk9lqAxEcAVS0PT2bP1wuDBQ6w-rLQC6CzW0dxxTZme4jqsU6xxMZqaI0wCb82rvzz9IWaC8LrOw4i1lR0NHwGl9XJBjKGnNKRZIPiZQp_SY7Ii-OWxhtG4tqNgO3F4Mnqqzu2098kSfsGceD9KKjhQ5wlxLAAonStQVdqNM9R5s46YvQKj8Wxqi7qlFxtCFn4UFazT1phXyakW_51DBRNSLtcgmQqg4v57VypJ9Ir7XcFRbxVi_g3mCpd3N2__s3tBC3m9w9UfppwSRpghH5mxXqWxWlio6EjFiepgqU-eDp8ID8Uw8Ah3iZzMPcMo8sWLKFd0RUDDWiVQmq0LUEKnAw1YGAGn8Ne1e0_lZCE4G97Y2foPSTRXQwPUHboKDACEV-ztyd3iaq1YHIw8dst4Z5Eo8dcPGrDAQBKIeDEIfv4kABI4tl8WwpaulAeG5FmXHezctps0g85F4U7GZ57lVPkSvHY3lQ0kUAnqz5HbZEu5hfWxZl=w711-h632-no";
                        video_path = "https://media.giphy.com/media/ihwMY0HajbiJ4Kduj8/giphy.gif";
                        description = "-Tumbado boca arriba\n-Piernas al lado en V\n-Subida hombro diagonal \n-Peso en el pecho (lado exterior)";
                        muscle_zone = "abs";
                        hip_weight = "0/2.5/5/10/15";
                        res_weight ="0/0/2.5/5/10";
                        vol_weight = "2.5/5/10/15/20";
                        reps_obj = "18 rep/24 rep/12 rep";
                        subclasses = "oblicuos";
                        break;
                    case 17:
                        name = "Bodysaw";
                        photo_path = "https://lh3.googleusercontent.com/lQwHCHUKSwxVqUOqLo3aRxG5Ya0AI7evqEvjYGiV4f5J8-1yog2BdYAa8FqcQqJxfNpgQAuWVDYAyApuG8C0sRY1dvNvdljF0VVt_cGz3GcbFYogP6djj7o05P_YfdLNUyKdF33Les7RBjmT1s7xhV4rULoD_69bblyqI9A8wnFDLM5ytJHohsYA-Zxwy8lcfYIOoNWXq6Y2pxs2cxROUOPNDZ0iYLkIeQ2x6hUPIQQiiyWlvhvtbwuj8YQ3RDq5XvN2QprnugyVqZXQcdSmLCF4exkhKytVykQzu3hEQlh1NWXHhT49R4y7fDW5AoO8x7avQD7ChqCiOdKy8n4teDU-iHxuOKoRZaSHZpDO_PUwIxrTElWU6k14p1I6CIsmajA2WnOJIqexdwlYo3Cp5J0VMAf0ILPX741xj6K9oTvvfjyfPQQFppvMrdlXJp7bj3dWG_-ADu9-WzBVPUeXcbm6jEAnaQ9dYfOEHvMPgJ1w6r1sxBDYoaEva7iBAW_craA6EgWed7c2LxqsmxFWz1o5BOGv3u73UZy9yzPWBfiWZxRJR0V_rMPiXR_r67F4nYL3CHLAnqikHUjtyEZ-8izmH_NPxvbHQ4DPDs02N1L7bNd_H3wS5vg85mmQ9Pj7rjXw6M7ozJEdEbU9zvtkbFPEqrSxuKaTFysoCJqQKYKg_blCvGHzjdk=w1062-h944-no";
                        video_path = "https://media.giphy.com/media/jTNHnianHhuS7wblpV/giphy.gif";
                        description = "-Plancha\n-Tronco y piernas firmes\n-Algo para deslizar (pies)\n-Movimiento adelante-atrás\n-Brazos mueven al cuerpo bloqueado";
                        muscle_zone = "abs";
                        hip_weight = "0/0/2/4/8";
                        res_weight ="0/0/0/2/4";
                        vol_weight = "2/2/4/6/10";
                        reps_obj = "50 seg/1min 15s/30 seg";
                        subclasses = "isom.";
                        break;
                    case 18:
                        name = "Plancha Lateral";
                        photo_path = "https://lh3.googleusercontent.com/chEHIxmGJAoekfd8cHs2d__Qb_cvUQtd3eP_Oq4JjzGMaFlLcGeML6pRr1h0g-KUwt63EmlbPxSUjp7S90gYqn8v3l_qs4BUJEeuBvzWnM-NUWOO_VO99cc7U-k8cpJWQVMeYRC-YWf7oYVg5oTCM6FxEb3nfg09ec1HrXg4kyZY1yKFODtZEjjTxtSJDYcg3WF72YgqxionKcJlJYU47jAg7u8L716qOVbeIyaFAzT7XPGZxvKj8SFnQFVc0E4g2xMpgC-9QX25jm1SYRXj3egEmaqjghKlmwJfQYDBHM9ePXGkz2qQDe-VzwDBHm-kbL-RjwkBR_eD1UkKVfjE98Tuk0m6OhRgJ6sWY2fz9G4IjgAhrMxWfCT8u6_UKrb2EvA0EgW_L2NO2weptUmIlczU_sXZiq1OX2NYup_AMT0iOrYufYpHs5iFmsWQ2Piltw0e_-FyddmmoKw_thGphpNF4PuB1mwPTYtRZWPqfdaUyHOTSqUAq_M9sT4CMUo76uiPTHrL-tuKb7Jh4nRhodMVDR8z6KmHQJuL--LNiSA0PQRYBXay-rVThDY81XFxhxBpaD34HOOxbnqOeUG4EK8hywBIsuywq04s39N5PP2XpC0I40vrvFzrB6ni2P06Y6LUfwaJE_fJmalMGUXDuNzErTxqGR6wcs36S-_bGSGBNXwYiMmOm8EW=w711-h632-no";
                        video_path = "https://media.giphy.com/media/5QLNmNzzO7Y0I47mJ3/giphy.gif";
                        description = "-No bajar cadera\n-Cuerpo bloqueado\n-Peso en la cadera\n-No hay movimiento, va por tiempo";
                        muscle_zone = "abs";
                        hip_weight = "0/0/2/4/8";
                        res_weight ="0/0/0/2/4";
                        vol_weight = "2/2/4/6/10";
                        reps_obj = "45 seg/1 min/30 seg";
                        subclasses = "isom.lat.";
                        break;
                    case 19:
                        name = "Crunch Brazos Estirados";
                        photo_path = "https://lh3.googleusercontent.com/dtRpwCvFwnphzwOwBBwPR6LOIQQeE56cdGv_DN0KQ-LRZumnGcN0g43UU5fj9sWOyWh00nZfNIO4C5pKnamNur7Ui9zxQYRiMSBpQTgRibJYMWGvXtvnsRkZLuYmAy5N3JuLlB4GyXX63DVpt4sOVEPU_E_-ayz2L2oURmriC1Ms-GFs-09SLnrMjLHx8LvwVvKppCf66u7Pr8QKpzl3t-grDsNV6omatEXmvCp3a2a91M_PlldT9Fdv01VUj4B7cPVMEsFrpmuJJD4N0mLoCOEH56_-4CxQFWGD6rB-CXQdiqe0QnoAKCtMDnnb7r-kb4qMdyPEC9iIwwUYEy7q-OSe-algH3LCq-z7WNguC1v0Au0FB8ghA4JNx9fEL6BzkMa107qP9BkSbsQRL013ELAbk-dxUSruE2lek21Xm_71cpPgVRkFI0WkG9A_hVnt5-CoGGuc2t6mC8rsYNpPwvTCiZ6wnQ_8joV2By-Co7HqekdjcsdbpIiQ4FMve2j4aVogZpg2LUwPE7m2VRdAHiijvxvSrpYpmF54G9BE6zAIxhyh53UXAPt0kxnjrUu8DB569yDBUmlSMdc4sv69xyDgWoDlnFmVzAgQYtlC-prA2r5YOJ294_auE6urcRv87Yo20ZAmCpPlJeXSVaKmOvb0x6nR28F4TnqjfgSq0AKQfX8ZnNmghNR8=w713-h632-no";
                        video_path = "https://media.giphy.com/media/fq6pPYN8Dp74RynU1Z/giphy.gif";
                        description = "-Piernas fijas dobladas sobre cuerpo\n-Brazos estirados con peso\n-Brazos alineados con tronco\n-Brazos no adelantan tronco (subida)\n-Crunch corto con tronco";
                        muscle_zone = "abs";
                        hip_weight = "0/1/2.5/5/10";
                        res_weight ="0/0/0/2.5/5";
                        vol_weight = "1/2.5/5/10/15";
                        reps_obj = "18 rep/24 rep/12 rep";
                        subclasses = "superior";
                        break;
                    case 20:
                        name = "Pies a la Barra";
                        photo_path = "https://lh3.googleusercontent.com/WrDUMaomMIRl5eAiLxWzkL0IoY8U4_HJ5ZhS4c7LKIg7jcHt3mUHVkuAlWGsgRW_XML-3FwbdokGyg4vzTu-xY95yyhyokF52Lgo7O7CAmGwygrKNY8jpcPRFvmbMBbmXnsj69JeBwhyeXMWsafjFI21trZelSPlGXpSUI-YIC_SJ8w_PvIkSA2YxJcqibyhyzc820krjnGnFdv1_ZluodLEld2M1LyJQnZgohYVVs_SkS5BqsdqlipSGcpzlLIi1TamXlf_AvpANfux5dkdC8CxTd5pGnINSUJ2E2GTtcL372eUYU0R7uBiSmvPQGhjjwSQ0B5ESkVo2AUJwjFMdmjOQYpK7BWqU1d4pgm1AqcwwtP51hGqyDnOh-2lNlw11NgW4d80TLVBQbwtx6XL1bttPOHEw9oCiOQ2ciQBAowTJRJDYucViXem8HkzhirZNkz4iTU3PZ3UyqJJ__b_Nseabuxso3WUdPopB5RDJrVCaHA-EHziUsjuahDWRACpUzqL7jb0bGYLogU3dR_bUQOaP8g-byoRfYVZE0VjT7hgDuz9xnB3g7Mv2Rdr35m3Nw8ZrpGpfMpMGzOapsymDG2-GTrMr8dhzyHcGnQlCmLMjuC5DzH51htWQtg1Ti663wxkeBA0L6Ws-nLCGMiXuQIQ=w713-h632-no";
                        video_path = "https://media.giphy.com/media/oyiXMbtmK5PIecyd0a/giphy.gif";
                        description = "-La cadera lleva el movimiento\n-Mínimo balanceo\n-Bajada controlada\n-Pies hasta donde lleguen";
                        muscle_zone = "abs";
                        level = "hard";
                        hip_weight = "0/0/2/4/6";
                        res_weight ="0/0/0/2/4";
                        vol_weight = "0/2/4/6/8";
                        subclasses = "inferior";
                        break;
                    case 21:
                        name = "Sentado en Captain Chair";
                        photo_path = "https://lh3.googleusercontent.com/aVFNNzAkaw8M2j2fNjBAvONWxTVLwh_11r1n04F1Dbp3ZN5aKHj8TfJPwVC4tlYf9i4UhfDWnsPuKVE966gStFeno3FZw-Z53CN9uAaXEvlP-u1QPjoKZAkWIZsE6SNsLiaqs7CYsPpEB-TH1slpkzNMl9iUA2Xu7gMnikCeDOBhillo5N0pnc_j--YQYW1mY8mWBtCsgupajcbocrnAukEDZT4YTFR-OcVRx28dnCc3zEZfzUK6mJDvK1VD9hJDrUKRSO8oHvyqi0xUaK-gr2qU1NOvuEMDKOYdQcQLWr_ZnlCalr5u_RlTY1AjM0HXUUyxiG9r1-_jatlpgGuvzqXOa_g-OyNvswhY_K5aOLmh3kUNIP5KvyXdYwfBFKFw05nh2ucqEazWm49KgocKKNC8EAdr_WqCGp4uEOadl30O-bysERCjPtveU3_yBlnvx03Ffdrmw-CvoNXSq1guDNNCCY3eoZQAQhyPvZmHL8i3L8fnJZjKGFWDETSb2aGRyXBWuqLzMmLGDmZgPpvgO0_ochxIMkL8rxuI6eF5WLPofVQKUmjKGRrEPBPH98vIK-cBVrbiewWB0KTfA0RvmkCnDs8AvodnkUZXEUjfG8CxPkf3ZN3CaNdvCSaIfVjjW_wxs-f1iRzLs4omy65e0KQ3=w713-h632-no";
                        video_path = "https://media.giphy.com/media/9r8HDw7mVePKVERYe1/giphy.gif";
                        description = "-Inicio pose como sentado\n-Volver a esta pose siempre\n-Subida de cadera\n-Bajada controlada\n-Parte superior del cuerpo estable";
                        muscle_zone = "abs";
                        hip_weight = "0/0/2/4/6";
                        res_weight ="0/0/0/2/4";
                        vol_weight = "0/2/4/6/8";
                        reps_obj = "18 rep/24 rep/12 rep";
                        subclasses = "inferior";
                        break;
                    case 22:
                        name = "Crunch Corto";
                        photo_path = "https://lh3.googleusercontent.com/2LxKol4oLiM84S0jXQ-9SuqIwkWdi97QW7rLL0IAl3aKJpHkEOrcIllq6LDa2xJJpG3NWiScsHwCU6Fm8RKqZ6EOsqj1qtCoQS1qefoAu0vDlPnuWjdaHG3pCpEDaUrtIGDZtERRpeyFjfoo0ZJ_rOD4jYabvoykCXhRuuYgf7hT_S817z6Vpu-ZfNVjcLl53zydGQJS7AAK_Yi9U0A63wHC26X1bcgVKI6rB9jGL9btsTMu5uH0TAWWSOk1vdfejDOmERqRolurVBioYt3OAmvWD5PAPMs9wTYn8_QSnQAco8ayUZ_2qkXN7kg476xn2AV578A-psvalweeHv2zy9YTOdLkp2MVfbSbTKT7a7BUBQw1mQaqaBxPLTifqIG_rzVke_VcOO1IbZlG0npgHVWxJC66uC90WAieVQqYMKnmfHhi_Ywg462IsHq9CuvRMBsbdTYqKvNShBSEJVI7dI8Qv6td1IKKY9BidAVXH7etfsbDa4sQJ9YO0NqWh0beWZSgSJ6ZlVWENRrzusdSOHyOy4f7Eg-Sg7e6iknUmtvIytaybttBRf9I6RAn-z83Y2RRkPuVK2_KCd5-aR9mbuL9g2uDZ_bc-KhoIrCx71YieDjgCq_fMdPI-avWnSufIsMiEsmtPaJ-i06rlJKDRJPm5JjB6Cpx8dbn2Uh5Xb5ffm84tEGxS6Qn=w713-h632-no";
                        video_path = "https://media.giphy.com/media/gLKiKUHjU1ynAno8cr/giphy.gif";
                        description = "-Piernas fijas dobladas sobre cuerpo\n-Crunch corto con tronco\n-Barbilla en el pecho (subida)";
                        muscle_zone = "abs";
                        hip_weight = "0/2.5/5/10/15";
                        res_weight ="0/0/2.5/5/10";
                        vol_weight = "2.5/5/10/15/20";
                        reps_obj = "18 rep/24 rep/12 rep";
                        subclasses = "medio";
                        break;
                    case 23:
                        name = "Bici";
                        photo_path = "https://lh3.googleusercontent.com/Ug04Mj3zxMe5hmY8QGyhsACJaTB-zbY4jUGiKSjcqj5_QL0bex1tjpbeQv_jOVzxWv93Ipnbix_0eztAfrTP-lhCfYALG3euMPLrQTUNvSCn_3xBPzua5nqQR1bCEy28rZVilBegbZGzS7un9lgnyY8b83xvynEkYQjqPu0AEYXrXasn9iXR4ord6RzaQi1bSd1-psVTFOzh2zsyGmyJLhHbZ2iMUk3n9cCI3L8Ujobdx7C9gNF-HvnDAmYVAgvP0htsjRez_pI3ZCFlDFuHilHQ17tt6mZzp_qViUo01FbCK92wVX9cJ_6JgQZE7r211UOwzQkEbB9MHBlrwV2zSSqDyg2SNsPVIqwO2lp3p0YDLT91QxqbVzHKX_CuNT2qWj8Cz-qMLQMZBzmbkt6pcAZGAbGwkv8y74ZwCgGBoD81Qm1UxhiJwzYjiGS2ns5ydqM8ZX9gSd7xBbOEW6s8JwQms6MbQuN3oUH22CD22YYHAVaIJl_ZBWpleYtTSQ_Tj4BZd3V1mlySQ5eahlywd8wN_Haql9tR4WC8WM3hvx13SYMNpHbhJcb93b4eV0T0MpEpOzAHiwvKCjgkyiQGH62W_12GIox2rRIicpCYY_ZrgPkPB262wa2yiEHsf9r6wobomrdCbi8yIiHGK9JrQWlf1vhoe7cneLBwOmecnHT3ophj2E2VHUSm=w713-h632-no";
                        video_path = "https://media.giphy.com/media/kcNCK0k5RMcZrN8aKJ/giphy.gif";
                        description = "-Piernas dobladas sobre cuerpo\n-Una flexiona otra extiende\n-Codo a tocar rodilla contraria\n-Alternando lados\n-Levanto tronco luego giro";
                        muscle_zone = "abs";
                        hip_weight = "0/0/0/0/0";
                        res_weight ="0/0/0/0/0";
                        vol_weight = "0/0/0/0/0";
                        reps_obj = "18 rep/24 rep/12 rep";
                        subclasses = "oblicuos";
                        break;
                    case 24:
                        name = "Lateral Piernas Cruzadas";
                        photo_path = "https://lh3.googleusercontent.com/Dj5lrC7mXI3FKEelMvZ_U8yb01FXAXtIPZd_YgFugPgmQHlzpz20PpDZuN5ypZjzrtD_4icIA8aKWOSiGTyEwOOKBZc1WWo1Szc-KTpvr6-DpCUKTWfzaEz6KaZLuBQiNapvwif-G1YZYeOlOIekySo5YOhwHXyEn-3kfWwjH-cEh6Z7cKpYWrtQZKN7WjIByob916jfuG1CvGBNV7FGtgiKauGewaSsyhdMcUY04pgIhYtfG6QP-HMEyDzc64yPYlEvMRo8s2OBqwXgM6dCzhT2DIxR1-eOtoHE7c4rj8lnT31PsgfN30R7JJ003cSxiwghfPS2PnbC4nBdMc-WzSgHO185lWtj6fY6OO_mcfzyEXBN3GEoBoVS9UPF4Hj5n2Sv4NPjFgTX8NpVRP4PQRhPRVYhr8lr8w-phL8w8CodG9YQDjPzPOkfQLa4zAh_dz0RZCIf-pQmFSIcKJgS75wQAqwqSlMbBEeouhh8XBJ6xkdP-yWZ_p63RRz4WwrEIvfUoTnDilQ2UnSnTc-rlwOtEq6phFZ91elKZmrJSXWqzOs_kTl4TOx35Po9QjLtdLa5nOTA3VFgP7nMZGsXM-uG3OVLdyBNlrGDbrsxBabwGueRyOJmnyFXY_H26DoE0LZp2DfUMH40ELlR9tMvgdG1Rvss3zW5MnHPrz2hl8uolSBSagyIHXe5=w713-h632-no";
                        video_path = "https://media.giphy.com/media/gEXp2cCPS7FBrSibCf/giphy.gif";
                        description = "-Un pie encima de la otra rodilla\n-Hombro dirección rodilla opuesta\n-Levanto tronco luego giro\n-No alterno lados\n-Puedo apoyar brazo en suelo";
                        muscle_zone = "abs";
                        hip_weight = "0/2.5/5/10/15";
                        res_weight ="0/0/2.5/5/10";
                        vol_weight = "2.5/5/10/15/20";
                        reps_obj = "18 rep/24 rep/12 rep";
                        subclasses = "oblicuos";
                        break;
                    case 25:
                        name = "Plancha Frontal a Lateral";
                        photo_path = "https://lh3.googleusercontent.com/-PM1IBlAyGpVJrx0YChTLdJ-zzdKEWwT9DqrmW9suf6KJr0M-D1ZhdnQv81O9f8YdU2c9EhcBVvOUm9UePTdHDO74fdiHq5zAKcqv6yOcfzmcxvpai2W7_XW9vy-i6830phazM8R36PDYEJzhY4RvBpv5ZsSa_aFrEA9BaypXq3ylr-eUd2cztUW7qUmvILHrTEFoQjUOpxEW9osasXtazENhVQCjiAybu21cE80uLKtytStfIQHm-U9hhCCt-VSzQ-1JhYwLmBscZ7uLmBzxw8THWquxmmfIY3Zqy9fAoTlx8-wWS8-iWfqjYodo39fhub6H1gkkT_j1KeDoLd1KkUrVYomfZr11ZpHCt2PHLk9fYT6jR_3zyF2mHABUWDcEYtXeaSm88Z_w7XgvaloYXYan6z92vD2qpRMlqMXP03HeQzeEcVzW3YTfzmY4_6C4Cq3d6d5KDOkysubNhGXnalOWSLZtgiHO5_2KbWASfoLFo2Rd1uyQAWhku8k9rCig72HLaaZoHH3X0IyHzNFtNUphP8hMdXhdu5LAURlWW8Uf4OLUa72JPruktJEf2WhvwVqEbdPHoeQP1K4m9gvge4R5X9Lr8gTcbDYY9G-bemoSERqWxQDaW8R29j5kPoPfND6ZVRA2cxx6catwn4otyEUPxg_zIzbAcGhZLnVW78iTm5iPZk14HgO=w713-h632-no";
                        video_path = "https://media.giphy.com/media/Q7LEuj87PmzoDJpXCs/giphy.gif";
                        description = "-Pasar de plancha frontal a lateral\n-Marcar cada plancha\n-Subir y bajar brazo (lateral)\n-Abdominal bloqueado cadera no baja";
                        muscle_zone = "abs";
                        hip_weight = "0/0/0/0/0";
                        res_weight ="0/0/0/0/0";
                        vol_weight = "0/0/0/0/0";
                        reps_obj = "50 seg/1min 15s/30 seg";
                        subclasses = "isom.lat.";
                        break;
                    case 26:
                        name = "V Fitball";
                        photo_path = "https://lh3.googleusercontent.com/zAgFxX3PZpiquZNF_a6ryCvT8LhsM1-E3vrWun1yYWlRM6hne6rf6lAqH8LCd4XAQNc-uQoj5IM0UqWbL6mTeebYIibaHM3PMuas2xY9eXgALZtdQXU7z8eRDj8zL4CWEUab9g7tTXglPQAd2d89-BWjuvewiC8oZoJgbIrVvJYmFDIsBtmkT0s5rcECrZClCYM8Z_QG__5MGuJbaTnvlYZCu7twY8-qa3H2eWJEgTqDdUdeW8Jp-iSt1QDMSbzGzavLSLqa0tOt97zxtoKnz1Lt8TsixF4vC-UDMvIEOcccu2Knx8NTX6jw2vji1vYYD-ys3BTE7857inN0xWnkFfBskj51tQGz-EH1xHYXOfTt9_kjAxoePDbutksNcmMwlemaGhWWaB_seLmrDUf-XG5BBpsE2Qow-nsw1Dq6Eh0YLOvLPhBanP4e4-iesmAVVrYA1ZQ6HYQtEqUPja6ySTvFJCzIXs-EW9RcFJNrU4LsbDl7VP_YUO58qGyeQs-rr55VHfrKKOlCNafPUMfcRVU6tgsP2Cjby4p8UiwDVbskW6YINSAgt_CfNWXrh3uosIhvhjdhEUbWFpjUz_-16uAa5NnFCOsk6AXlI-CTfwAZCDs9enJrrOx3bn5AQiBXSrPCF-3xLwpu5cB5VTudpo45LI1iD_bvkaIgnOvj0HhHh9IShZM4oOv-=w713-h632-no";
                        video_path = "https://media.giphy.com/media/SiJWH65nxaYZyIEniz/giphy.gif";
                        description = "-Hacer una V pies y brazos\n-Piernas y tronco bloqueados\n-Movimiento controlado\n-Fuerza abdominal";
                        muscle_zone = "abs";
                        hip_weight = "0/0/0/0/0";
                        res_weight ="0/0/0/0/0";
                        vol_weight = "0/0/0/0/0";
                        reps_obj = "18 rep/24 rep/12 rep";
                        subclasses = "medio";
                        break;
                    case 27:
                        name = "Pase de Fitball";
                        photo_path = "https://lh3.googleusercontent.com/RBjns6m3a2hzkrwf9rtO812jW1HhbVk_LWcPNx4BgE57pWAq0IPBVvH_RBzS7CN9wZJWDIOT_QICDks0ZqAK7XoDs8nn7AdPuj4w6kxHUPFA-dbfYGtCkhyBk-dPOx2SZVXypN_RzsQAJDfXTxRLfElXCBu8drIeR3W_wRX1ulzs-Uc6nFLH-1G5qgeYZc5Yr6UnuK9kH_QYm5iASH3DfJXAu7fK3Yqr04pC4RLEanzp9ZWEUBJg1cJBiZwvAYnMM1WZEBXCBNLH4cZVWkOXq39eUg2xGEDn_-t9JMll4cZXIedruY4W1HEy2HofNIAqkv7IW8zbOt7rH0LA5Yq1LwTQOfgBUMQM5zE5vtzUmYP8YITlJpHn4484zmY4DugAr--heHQdqzdYSA6j69B9Bu3FCtjVd12RdnPoodJKf4TrehYJgVUYLjU7hLuwuH2SA5uJMkmeS2yXTv2rErkHI3nG27zxNdMvcl3Um02klL97U3XjI2gDGo6KR1775XX61VmqFj8yWRkhPNzJ-OGT0CZ3Qol4Hllnp4NKaLiTkKwfbEuhNSvt1v-2Zg_GE7V-_39CjjggCleFmpoyag0ekO0w0OXFfj1v00_rYsp3eFCQockhyf-1zewR2sd1D9Sj1Tp2jn99IySu897RYuz2nV5qJHnaFrfbOkRNcih6tK8n6_7Ya0xuAW9u=w713-h632-no";
                        video_path = "https://media.giphy.com/media/8JTla6P0RPoMulqaPL/giphy.gif";
                        description = "-Marcar las posiciones\n-Piernas y tronco en V en el pase\n-Movimiento controlado\n-Pase ni muy adelante ni muy atrás\n-Espalda lo más recta posible";
                        muscle_zone = "abs";
                        hip_weight = "0/0/0/0/0";
                        res_weight ="0/0/0/0/0";
                        vol_weight = "0/0/0/0/0";
                        reps_obj = "18 rep/24 rep/12 rep";
                        subclasses = "medio";
                        break;
                    case 28:
                        name = "Crunch en Fitball";
                        photo_path = "https://lh3.googleusercontent.com/CkZ05emxQDFYZnjyNttyKcRf-SW_TNHkZm0JQun6rejnRtDbldz32IdPUlLKzaz9VvRg4IXCxg-9_hOGjzOG3ljdEdOqtUCEaOVp2SXBY92uXYb61TV5BoCpwww9b_sFTIrCo-Y0gtkk82UdQp5s3_RCQyWJjhpSsLOMNcDDH49KynFF7bqdw-4nsKzOsxdWn0Lgxqi_OL8UnQ7tRi4VpSj9p3Lchs-DfLn1dSusOKEqSAlZHIyvIIh3nAZggMUDI_HveUwFv3K2ogkeJzfdpGzJKA4i-sw7jp36gFCIpmTzuGSobiZtUvQomfFom1Ho0wL6jXcMGNV4x4jO9f3cSQdl9YMDJ2YbTcZvbCPQhBV6cpd2tlTJPD4dCK8CLVNKRHvXZQNXR31EbyH3HKIJjoVq3d5XE7O_kgjy8awcb7KZvmVc5TOgz3CAwTev-UNYRUURv8vDjMu_hTEoDn8AuBr2nLMZxbhGoIAAxWonNzzY1xKmAb3DFRI1ecQLMyzmGeZkxn0-E12iarB70i5_1YljZP5jkv4re8GGS4ywkmrPevJwgy3gXhroJOMLlHGAN51L1tHBFHOn4jqeiZkoiQC9HSFuUoxosjEPF2nCxdQrlUsfzQvOucRqS-hkHJma3HeqSVWslyl2xmeHUu8bpb1sy6lniXTAyEUY6wBFVtbg0ca6o61XC1AJ=w713-h632-no";
                        video_path = "https://media.giphy.com/media/5qFZtdbscqdzGztyqz/giphy.gif";
                        description = "-Piernas bloqueadas se mueve tronco\n-Lumbar apoyado\n-Movimiento controlado";
                        muscle_zone = "abs";
                        hip_weight = "0/2.5/5/10/15";
                        res_weight ="0/0/2.5/5/10";
                        vol_weight = "2.5/5/10/15/20";
                        reps_obj = "18 rep/24 rep/12 rep";
                        subclasses = "medio";
                        break;
                    case 29:
                        name = "Rueda Abdominal";
                        photo_path = "https://lh3.googleusercontent.com/cyplD3u0xmB75czTy3urhIREfBcH0Sb5c2f0sI-N05nEYrrmFdAM1rnPFJVOLnGOYHcls84zeQODcr08uU40SkosFfs2zaWcyDezLkJbazKNec99k-YiHac1pZGSoHzX4sNwFiyJMXx2z_OhCvXxg2myCQtqdvMsCJv9rzr18xyamTXLknLeeY293dCGfwAkPhXd303KYZ4TDREQGo33w1ZY1avuftnL1y_yIzdoiNF9CNR9UvHDhJrFLyiQGutLsp7JTbXWmieItCAYkCqNKEqTNfSOCk1KZ-7H_H5hNPFeHKdFewtCwUEloZ6ipLHS7MXc6Zf7IY8AmbxHw_5PWm_JAmgBmd07Fz4bwvAld2OJGjz0fT7NQK5WjUtuCXG-xnsTM_REcu5YxCY89l84PunapxJDRxer7nbEeJ_D9zMu05dFLzkcV9UKqwj24I1hcKA2la0ZP5M_k9Z1HrPwsNPa7FL3dpo2eW2qyoFbi7Q4fScNGCpshqxSxMFsywIqRwrY1RlJd4ibZeKyfwdqtJtndvELaw6rhkjOzgtOx2Xx0dLSZgeOAnSxROVuOg3UIEzGoRFUY3AyVUOjFI_z0aqQrgfdBlz5NG53s2A83oXlcr6gWKY_nUMu3JEdGuKihg0T4D9rptX3Cb7UO5609zcPfEj2Bmy7gVIv7e17TuxA9ZjFyCnBRRma=w713-h632-no";
                        video_path = "https://media.giphy.com/media/2wXzHKMYZ2iAapps0B/giphy.gif";
                        description = "-Abdominal bloqueado\n-Movimiento lento y marcado\n-Espalda recta\n-Bajar el máximo manteniendo posición\n-Brazos rectos";
                        muscle_zone = "abs";
                        hip_weight = "0/0/0/0/0";
                        res_weight ="0/0/0/0/0";
                        vol_weight = "0/0/0/0/0";
                        subclasses = "isom.";
                        reps_obj = "50 seg/1min 15s/30 seg";
                        break;
                    case 30:
                        name = "Tornado Pulley Slam";
                        photo_path = "https://lh3.googleusercontent.com/JtaN_Wee_bpWShCv9xZz0f27joxmbSlUt1nf37lCPYV3zqEUke06c7SHhizT4Gq6HQWxO_CClW3ZCFNJUpmZZQoL-ZlrwSIKY0R10RML94CrbttLYtKuV8w2vkAqtaTNWv9d1wbOMQ5inmwNNiTZtv_5CDMosBqSj-WQQLxPmwNVvR2mZf1YyO83hfhJOXcEnlTkUSC19jEPsLQo4hlqyYu55Mb5JVoYcuhydYyGVjUFJ1DACNZZrmqIgCNMc1dvRMdJJIA6aX_NSn2idXXGQeSz08f-ADiyllJYM1KpVa1VlYqLMlNoZ6-WCiWKVNMP5X3FNRzkv1M7FhYuIMS1kdmZExaBLatwx-Zw4OLuUMWwi5xePzRxJRv5fqI08QmZq9PwkddZXhe8DJBNBDp0Bz1kpfBoDzQy2AjZiULshsNBa4WPuFS-UyPhxFLgePGrm4cppNgtW-2q9C1tWw3qVj0ceSt17fZ4i0Y6OqL8lCIdtX0dBO4AvYBEFvUh1MShTs-onZ_TGqjTR2O5gkEzGV6-aV_4VvlVjID-2eciu5IfCGsJnV6GPM5NWPGVZUWK259dA7w8t9F_zjMZzfpDZFXVOh7pJiEXDZSd91CDni5cGfSHfNtvtQj61PL7KURLKVBmlVREmFl8gMskULsPTVU_oM3KiMgxRvc2udWS78UYH-It2y7GfGGG=w592-h632-no";
                        video_path = "https://media.giphy.com/media/4ZpQKoVF689Rfz8pAz/giphy.gif";
                        description = "-Piernas semiflex., espalda recta\n-Brazos estirados\n-Cadera y hombros acompañan";
                        muscle_zone = "abs";
                        hip_weight = "15/20/22.5/25/30";
                        res_weight ="12.5/17.5/20/22.5/25";
                        vol_weight = "17.5/22.5/25/27.5/35";
                        reps_obj = "18 rep/24 rep/12 rep";
                        subclasses = "oblicuos";
                        break;
                    case 31:
                        name = "Movimientos del Carpo";
                        photo_path = "https://lh3.googleusercontent.com/OHn2C_HZWXN0JEFohaF6S1SFXEOVBNGvYqVnZl6w6ccmQLgB5SOSlRfZ1N2xQxaZKlm6BPocdvCWiDtJsO_T6pzBRogUBShLIDeAVuOPoCj38S4zJZnt9WDNDabPOnNn-2GrUlPfTIgkiwLmdeUbm99UppBmd6uJSJ-J8DZGyI3r96Hm9UCcGNhAqmDtUy4vIHBmqBHBbpBYfboAQoAfDH_O0rppv454NFtpIdwDos6neLfpnW87gXDW27nxj5yF04X2aVWwXYIu2eiYAiYq2Khc67_qskOlI7u3xNYfkgWPMmPFs5vcQrvYpgELCwRePzOMwCPpJZJwqXKpNWPRjupn79Osbhjk3GGWgA2YQobKCXokvtM8pyXnRe-prYdVijhzsPm6eWkKDzp4xeljHKOoCL0FjqI9nNtDjbnwH-GDhRXw0BYAexNdlI1uWXAxral2zIeiVWUwQ2-4yB-3HwwOkPz17IhR6ps8RMy8Z9UBE2ZPlFC5jVSHupVhL-7XGZIZhJG-6Uon_vY0kKQJIA6s0SywLfVkR8JtW2I6kurqKJrP0wWSI1mqxmbmQ8nwvBMwDCF4fjjvvH-Ug0bxEdIIu7-QrzYHR0sFlnIf-wVHJWBqV3zZj31o6yIwg-QiL--qRA13vVF_1gr-Xwtxi7Wo=w713-h632-no";
                        video_path = "https://media.giphy.com/media/WQxCH3vMeVwHCjvZxv/giphy.gif";
                        description = "-Son 3 ejercicios diferentes\n-Flexión de muñeca, Extensión, Rotación\n-Hacer por separado\n-Se mueve la muñeca solo, cuerpo cómodo";
                        muscle_zone = "forearm";
                        hip_weight = "6/8/10/12/16";
                        res_weight ="4/6/8/10/14";
                        vol_weight = "8/10/12/14/18";
                        subclasses = "carpo";
                        break;
                    case 32:
                        name = "Flexion y Extension de Dedos";
                        photo_path = "https://lh3.googleusercontent.com/qBM6Nsyl1hQvlP3D8ccjCrhDsc-dG5D7SptavRH0jvLwiE1pNfg1xnFD4b6I1coPs15oxLWTvYZgk2EG0qpglRdRhhVYdsVu30Bei3TYJTyUeHf2y43RRoIBMMstqZ4IqjfDka_Ea_qou4sSHXr3Z1TqJ8UxHXp8XWNODdojRWBx7WZKHhEjYJsAdgyJVKypgGX5wS5QNVOr2QWyZyiIg9K7nyJXoiKru9bioKUlLVKVxCbKcqlwPPAIurnhK_yKczp1re093HzDlCjZGsTCAHTlFpTzGpLH_6_bzYWCMKs4m-4p1scgqgINH-XZ7LclnbwQ2gUV5qhaLUVaiTs6TeTAqU9gNFLfS2T-hCBPDTD8Dei4wvSn3nw7uPy8SCxJfHlrwvpWwRZ1lPE1oSmVLL2Np9ymdRA56n0WeFnJuXxVUyrCFN89wDtPbr2pCUv0PPKJvUTFdlAdRmlZHsF9thU7TKnyHs0k4ZU3YywbvPTpBes2jdS1eAUteNj0W8UdjwNS635mLYSUg6JEVbcqx8oKhlLbuU1l-OpQBo5yH7OQxH3xnU5IjwKf4iwGaFhrp_kwsikiOYCeLVmcdWM3lPKL5MriderpwsjcxgL7wf9vwJ8b7M9NMbdG9yw-H2qSN2eEoyM3vzEkO2z26Xv3GlkYd2qzrShGSM1ojpWJYeBcwPRAuQn3lO0J=w680-h632-no";
                        video_path = "https://media.giphy.com/media/oOBv4TkeywxU3sdMRT/giphy.gif";
                        description = "-Si falta material, cambio ejercicio\n-Apretar pelota, estirar dedos\n-Producto: handmaster, powerweb";
                        muscle_zone = "forearm";
                        hip_weight = "0/0/0/0/0";
                        res_weight ="0/0/0/0/0";
                        vol_weight = "0/0/0/0/0";
                        subclasses = "dedos";
                        break;
                    case 33:
                        name = "Press Declinado";
                        photo_path = "https://lh3.googleusercontent.com/nTarKZ7nwyXa1kQTDmvK10Z2sK5SDUzIZdISi5gEoqfWYJfWDd_2lDcGssmbq0hPTSWH0zPT7rZNeorqRTsWzeu7NMJFJVGX8_mH9h1ufWANdmSG1weUpO68u4LV74O6M38zIdyNZTEZhPbB2-8lhzS1DI0hkuKb76ro_2HUEYwJU4WukHYXZNf7fjj6JyVxsQlqMjy8UeUKRIEFhbnNeLa5xCkL27qoyqeJ0ugL9N1AFOurI704NcFKOoHWU3PFM5C6bJj7ZLWk028Ic_2sUrzHye6bL-SmqkVwiYZNw3fDHj-3JFOyzd8tq5ag-IzSFWFXRh7_twSNnwuj6_AxfaFPAel-IZn4i6tVklmpRUBB-7HzVESpnouRi3-HplHo_C2h5JlSpu3UNu2XGHTT1bS0VDf5Zi56uqpQUmQjFEz9E8bQ8qXJnS3f6GP_GbRWxnr968EPK-fGcV5-lrsMSTUU0uvQWq_bqkw0BVQMEHGX4QuGfVYZWYAr1rfcmCQaG4VxepD8fVAEkf8DE1JGhhqNsl6DDxWzpvMGzBdCniQvX57lr50gxcpBIi-0St4jp7LoV2IxVYGxzX4FKqI0wfkJSUoBvh37QvaJGh3zHFpoRMMgpsyl-hTt-Cf43pAvLBX7ewnO4-QymKO2BodM1ddx=w713-h632-no";
                        video_path = "https://media.giphy.com/media/Lp4c1Ofp6QAaIk1TMF/giphy.gif";
                        description = "-En banco declinado\n-Bajada casi a tocar el pecho\n-Movimiento completo\n-Peso sin contar barra\n-Subida rápida, bajada más lenta";
                        muscle_zone = "chest";
                        hip_weight = "15/30/40/50/60";
                        res_weight ="10/20/30/40/50";
                        vol_weight = "20/40/50/60/70";
                        subclasses = "med.-inf.";
                        break;
                    case 34:
                        name = "Fly en Polea Tumbado";
                        photo_path = "https://lh3.googleusercontent.com/jh4CMol2iGtE9mf4cloL3A41l42EYqDy1oFIRSOgGwmwfwD41y89ywppmQX0mQXF6x3PN5_O-iSpryo8GJJIiBxCKz3EnWQnlsgIRw31bL9VdNc-__jKblO_hX9Su0SWAHaP_YJE3Tvzf1zbXwYoyivjHW5mY9MljHIBOdqxThNvvH5Sw1zFUi1ndqkkHGfn2fimEo5ZK9gEFiNoYopd83n9jPZtCm7iv4Ezb0Qu0jIShZxIu_pNxYpVSs1vJyBfAmezYJZWPdxfrNTeyCdPlDN3_ZxzIp8GT8ufg_K41K389HXb8xI1KhjQYN2zKGYx4I_dsSwXTtTnooEBm3HqwemfiXo9R6KCLVBsplyPpt4gSsoq1Av_T3g2EYq0y2DUhtGOh0kWOKAWQC022Zsg_K6wmvwBSc-AoZSjN0jMMpXJriFanVx1hvI6A6OVBt8G0GnhZPhwS17XCBdwjIgWBRlChfNzd77mOr16875m9dhUHnYVZqEz0xutE5gRwE1MpaP6FTIpodALxwacsAcELRtnsEyxCpbcEnzoSr2nr2K9CduLP7SQH5TsGwDFD7_FUs0n6ASpVUyNndMhNsga4WbWCoOwxlIui9WfxmUhICpNz0wCJrClnXKJjdZZuyA_C86Al6LXOgPvvDWeLioRXxgU=w713-h632-no";
                        video_path = "https://media.giphy.com/media/khNNuK9Xo1CtBMHopU/giphy.gif";
                        description = "-Brazos rígidos en el movimiento\n-No se va doblando más el codo\n-LLegar hasta cruce de brazos\n-Cuerpo cómodo\n-Bajada controlada";
                        muscle_zone = "chest";
                        hip_weight = "10/12.5/17.5/20/25";
                        res_weight ="7.5/10/15/17.5/22.5";
                        vol_weight = "12.5/15/20/22.5/27.5";
                        subclasses = "med.-inf.";
                        break;
                    case 35:
                        name = "Press Plano";
                        photo_path = "https://lh3.googleusercontent.com/9UArQbU31L4aCQf_iivR1fdaiK3nu4JstLZFYQx0lL8WS26QFjMGPKALQV4-_Hk7f1qHvpdkNdjuZlYifYiJbvJhAG5SZiKF2zmQhXS0DjjF05k1RVPRrF5PiadHYkBlnyR_yONNB6spEIKyjMRkEddtVhP9PSWeQjKaFV_Bh6o9aA1kMDzPd8J2AzLtFCLt5pM2Z__oqGH4lxz-5NQBJQI9rQbkXVGDupOswYvlalIh1_Zt1lm65W5JkRVtQTuDwN2zX0jAYZbaGFOV4MYSLfMPAs7X5ivk_WN0FOtWEDMCxfwpWnT7zvi7xcfUOyNGyfgMsKdoYh3mfXT4B3LTmOvNkMI3UrwkRVu4krQ9Wq7X5Z8qNcUQEhd9ay0znkyTj4y7e30jEwJCvPv1fYIcJCvq2us61q_mcZXyrtY52VG7J00IcqvSKpZgAcxzGYVRnAvy2XkfbEJch8ovNE7NyWPVPJq-qS0Kku-tZNvSRvq7vtMsiGLZq3T4JGv4zAgIUWW9lrYz-Qxpu26uhEr87mYICaZyW4zP-oMDXhHqVemDjCQaevq_T-bAWsCNPN61xOyGWt3fzqEw5a4UUrAU4CXDRCSBWzhcyVLTgnoqhMnOJTDGkjwZxs-Zjl3tgoRoeXvQ_lELRTbi8cZKWA0yV3aPVx7F2RWFo065ofJkjbhCVuxN-nXeGt0=w1062-h944-no";
                        video_path = "https://media.giphy.com/media/YrNy2LmzNOGsWBXCUG/giphy.gif";
                        description = "-Tumbado\n-Ángulo codo con tronco 90º\n-Codo baja un poco mas que el pecho\n-Subida hacia arriba, no diagonal";
                        muscle_zone = "chest";
                        hip_weight = "10/14/18/22/26";
                        res_weight ="6/10/14/18/22";
                        vol_weight = "12/16/20/24/28";
                        subclasses = "med.-inf.";
                        break;
                    case 36:
                        name = "Press 30º";
                        photo_path = "https://lh3.googleusercontent.com/dFMVLqYBzh_7OCfdzKh55AcEfQ0CX6esWztw1qEb3SZ2xl11u-s56pW4_FFh4SzqGAoEoQwifiHLTPUzJc27oWNG3rzXLcf4dwsOgIp40HgsKCIcWhz-XeNGuyFAujTOcxI5xQMqsuTCmJAPgpexG-u0BktCkvG25EWOGURy_jiF9kuwqlVFebAHPPcBriDC8LkE6ykowV9MgxtajBeKpttLihRmFngAkd44z1-8vlOCJ9JtYv9Ke-nTJWGDswtVAAtqIA1VTIhK_ILPxmbWYWbYjHDdo3o3gvkTp3eJuFZwrwBdI96pd70WtTfpPdHE1eggVGw1ReQlh0NbCfsc2tzkbvh1Jr-vrEwwVnrISi2xwbYN6_fQmNncTlqxj2YpQDMR_ZjsIdY0YA49K0wgV7QgG81n8T_2NeAwJ72NnKpbfxCroIM1JYruauYhjnEbHcv0zqEwWGYUySLwsek_c4VES0egzCWqOj07tOBAv3DQ_EGYieUZPgY0dUyGks63y_djdLPT6rPkrZh3d5pD0QvqRWbz4D4Q7No0ivLOB6XtjHVrRdmXbynmViOQZhP66ysTyuRMrouq_FMnYz5-kxZOYIH5UkqNmcND1McNbjQSjQ7_5tj9ADWhib6fvuCOwAnMesKw9A3DyvjUJaIHIc3sqjNrHIOisSUfh_rNWONm8NBZ9ME27kc=w1062-h944-no";
                        video_path = "https://media.giphy.com/media/KDPE8fHLRTAgY0aiBg/giphy.gif";
                        description = "-Banco 30º inclinado\n-Ángulo codo con tronco 90º\n-Codos bajan mas abajo que pecho\n-Mancuernas suben rectas, no diagonal";
                        muscle_zone = "chest";
                        hip_weight = "10/14/18/22/26";
                        res_weight ="6/10/14/18/22";
                        vol_weight = "12/16/20/24/28";
                        subclasses = "med.-inf.";
                        break;
                    case 37:
                        name = "Press 45º Mancuernas Juntas";
                        photo_path = "https://lh3.googleusercontent.com/hOpPk5xg3m_9JeohQbS5NtJJxadb4KsPc0bsM5Tl2TooawGUeS0kseNPoz_qPolQ_ggYU_wvqPo2XucJN2WzctEJrZqApiEmChBPXhGmQwuNX0vgstL_lbEWkTG0aAZkAMIyciTHP4H1wYHviizr3ygOt6vjZ_2MWn1DzVjVg4MN908uRhusxTHg8K82Lqbc2l-6VFjVRZf8eMEE57Fxa5NVc-vMI4VcYYkVtarlOy55q26RNzL62PYCvtBikUBlgvnVPEpSVlqkUySKL6a9Zcr4ccKkNXtrIT8yp6lWErtEBNrL5oxMQy2lYQZDJh_9Cv8jJjYB3s2ZtrdPpkStmkqGVcQJrpzhkdQICoAQuw3PW7qWUY3wcfifGNklqf6Vhbzrr6c1fUB3QO2pFb9MAM1skdtO9SJgNK1nczJ-xi0XBGqSivDIiXX1ts4qaR3MX7_2MGwfCUQkzyIFnydFF_yv1Ry_UuoBQeujsFhLtu-CqBKrbP9m0r9-r2fLO2rawOC8WT2CukgPQl0NL7hDyioRPV2h0ekV01PxoMkclTS_fZCkiTQvtECfRnABpJmAHZGtPvLkj581qgO773H0L8zNvnwpXkt3t-vK8nkBiwnLBTQ28KoSUHe8G6I7yK5-zM4TuxnTuwxWjYAxQF6TE-1OpQTvA4gkK38Ltwk3B2EPLU7vctimNWY=w1062-h944-no";
                        video_path = "https://media.giphy.com/media/RkEA44dsJXzVpd2LJo/giphy.gif";
                        description = "-Banco 45º inclinado\n-Mancuernas se tocan por los lados\n-Bajar hasta casi tocar el pecho\n-Codos cómodos al lado";
                        muscle_zone = "chest";
                        hip_weight = "10/14/18/22/26";
                        res_weight ="6/10/14/18/22";
                        vol_weight = "12/16/20/24/28";
                        subclasses = "superior";
                        break;
                    case 38:
                        name = "Flexiones de Pecho";
                        photo_path = "https://lh3.googleusercontent.com/HBWh3ji61nLyNh4dwMQSPu5SJLBAXING6vsWp3K-0HLkNydflqFRHDJHltufAtixc46Ca-GsjMAoYV2wa5w46dwJcIJ5qV4irZpbXRWPhoq8XrQn7Mh6zuzfyJGbVGa4mxkDhK8L23d-W0w8CMOkHYM87YIWxI7RwYHJPqMt999wv6MNSwW_1VKJPbMWZGSv5L2J2F83t8Mgw9gT0SO8KQJDAyPl3G92_qfHLEnyhd7Ya8sjbNd_prLXdBjFuMdynTWIez8ZcK6eAwcRgGv6FVFHd-SVJksKa3CEmSTw74zkgmmM8LvyuUK8WDh2V_UgIKRv_otiCBzjsXzq6E_Hpc17qzwVVoTkAW1Y1Qnl8qvTq7UzobCx_Q725h1vlihAUfKgje2CVbQvxn_0hvklsnivE4K9PEciRROMQzndU6HUgFhOWPXNcyBn4wDvZUHcnl7o4MEZ_0HjEDiiv8XCIGO16hchO3e4NHtzLYyTb4-L5YZ8Iq8Y4wVh6CdoweOkmX3ebEinZZ_03xrNwQc8vtoU1Ny_XRre2HU8tT5Ffka1seL9X40pRAvmJurcVfByxUBA04aJaTZ7xniMGvyWUqljtYk5WoczgnBBauGE6I5lGW9cYiRhYMHuX04eNx5ZCW3IjQgAOx_Yd8rkyL2-ahCDiUNQyfcTvnSW2y2fxT6Bqu9WH0dHi3I=w1062-h944-no";
                        video_path = "https://media.giphy.com/media/IcoHAVoMgwH1MjyHZ5/giphy.gif";
                        description = "-Brazos-tronco un poco menos de 90º\n-Bajar hasta casi tocar suelo\n-Abdominal bloqueado cadera no baja\n-Rodillas suelo si no puedo";
                        muscle_zone = "chest";
                        hip_weight = "0/0/5/10/15";
                        res_weight ="0/0/0/5/10";
                        vol_weight = "0/5/10/15/20";
                        subclasses = "med.-inf.";
                        break;
                    case 39:
                        name = "Press en Polea Manos Interior";
                        photo_path = "https://lh3.googleusercontent.com/wG6geg2o8NhyJxHn5Q6hIPVcWJRPaXC_uzLPXcI31IiMV7dlCuM1CPt-0w-A0ORpE6EPD-Zj35-XyrXbFGvLWhQInHXtD-lxzRLGWeD-pyOFuK8wAfgZg1Ls2L70q0HQfuxuHORjN2KASKfPhqBuLQUNE9WhRVioNU_uMuK6u9KNJuEmJuvXdJBfGnslpgRJYVMn2pKrrLALa7lBGQd_EA6F0M32cTYUdk3K_WZFpWRtAKQIndqBDsC3b4crFjCN_A20BLBv8FOwkjurh1oz-e3EWBOAG0vJmNKEuEJGoTns3fmhw2fkaVRuY-fmjd9k8unRqyo8DFfrqd5bLOLEQjZtJTFbZ9cy3MUOnDXUNTl28Zsi57nNZamY9BXAGUTfSciY1iDJmaTvm2tSfURwshk55HobC_CRdXHfoh0FxyNaI-Po0O9ykzvOCxZmdkn-_E2pg4lkEsIrXidONlnU5yAueo42eU0gy-cuu0JqoTgHf-x9IgrlSH50Iq2I2P5gKurAOE0OdL7garWGJ-wX0X_XjV9BDQRSWxx_WmJ8VGI-YM9yJE7ROJpR9O_K7Zh9AO6saEVVq5k3wYeb12a3dYdTcg--bd8L9LbBVeXJWIgPJatgCVJdDF8fRuiadduO369-HxKxx7T2u964sKLGz9v2bvxhg5ZSrqCWoIYJVQTGDWNN7EjUH-hV=w713-h632-no";
                        video_path = "https://media.giphy.com/media/cO98Fsi81nrptiLMg1/giphy.gif";
                        description = "-Banco a 45º\n-Mano cerca/arriba del pecho\n-Mano sube vertical (o ligera diagonal)\n-Codo cómodo sin adelantarlo mucho\n-Notar la parte superior del pectoral";
                        muscle_zone = "chest";
                        hip_weight = "15/20/25/30/35";
                        res_weight ="12.5/17.5/22.5/27.5/32.5";
                        vol_weight = "17.5/22.5/27.5/32.5/37.5";
                        subclasses = "superior";
                        break;
                    case 40:
                        name = "Maquina de Pecho con Codos";
                        photo_path = "https://lh3.googleusercontent.com/P5zpIRLvrhSQKAbP1aCHLsKaQjtR_oGR3D7N5Z462lJeRuP2M_1wNH3_vD3q7qg2rCfoANRZ8J3301K5fW19Z-pgovi7tfDdiz7fMP3JXCMdnxkOfyoOtoIyOvHrt-Cr5KA9drKukhk7WAEETFpQEqRzXEaCxKsNDX9hJlJu1zO9I0v-KziIx9Mi5GVoHPUCuwTYRn5fBG4zfN-G2hleEmRT6jCkbktjFj-xVi2k9MAKHVUAQd7c2s7t-DKwbOtSXL0qoEDR3AzW7PQoC6wRT-0cyymYVMVw9TlDqCFEdfIhsUsjhw5I094gReE7yBj82BjmJMlEbbzr5vJm_KTzKl30Buvz7rnmFSy3u2jBf8vh4c6EVBc1EdjqQ81Z2E2i9c-G1UyG0dluoSHMseR4adbGP72vLTnkqT95FwdFntUkMsYiOkuF5z5DFurCvBc_6w6ewDZhZrgHlL2MhZHUwHBAAVFpR56T0K3MwMcclnN4P5caASPkmzpzyBz4z62BxAmT7JrOE4J6y1a6IkDXRuuGuOVeaX9fjzQ3yKGrqeV9Nbjljzw8yk4fTyfNaF2aXnBCcYUKiS_KmG1OEJV61Rg8S0CG8IVuEdWihyXduHZfvCmDy_4JKYQtZYAu6_eW8BY2iK29-3HdSpKASw2ODqWXGafvwN8GlbpaeZ8z5t5ysp2vnd4CMRKN=w713-h632-no";
                        video_path = "https://media.giphy.com/media/lckzTgWUmCygx5AiDH/giphy.gif";
                        description = "-Con un brazo solo (luego cambio)\n-Rango de movimiento completo\n-Espalda recta pies fijos\n-Controlar el movimiento";
                        muscle_zone = "chest";
                        hip_weight = "45/55/65/70/80";
                        res_weight ="40/50/60/65/75";
                        vol_weight = "50/60/70/75/85";
                        subclasses = "med.-inf.";
                        break;
                    case 41:
                        name = "Cruces Polea Media Altura";
                        photo_path = "https://lh3.googleusercontent.com/XiOmV7qTmpy8P_yAmuPwIi_e37d_LWd-iRYnMRUjMQutyl3tLv01V17CIoJV1GKReuW0UsamSIQjvZiFeLApAN_J5Zgc-UKkVjj6gLuslUsYHQianMA8fLWnMAim2k9_bWm877HyUjI8kU_yuI4DFgmRDUsw2SDe6HoEOaZfoXrrfmlWjQqxMaNrOPirESH60Iv3X1qFlg0sMxNrPDIutIgYBiOSZLPuxELR58ptZ5Bqd6bdpPXFuTIqRs0QE8T-tyAvGSM5wCn9t8PwuhkSC9DHneQuGVtYMiemH_wZFQttvB8AaPZUANr_WUGE4vU3aQQPYqb2ri-a9OnOJtP41VgEd1xfjoEf50-ZcVvVM7DPnVkndQFZnivjoZWAj3rWKuqEJynLN4r3SrXx2eDhJ3UMvIO3Sb1BnCi3-K5CXAXlSO8WuvVsZ4Bjga_qPmLAXHoE1Apk_ajx8bwdQv5FaySj5_yayvR2hYomRtfcp_7g9p0sSVsnhMEWPXHYyJQhwdjiP7sBMvOPxW1tL3NOWk8_-oUo61AVaUcu3RPCHAGNYODOariDsL_BsXS1s7vyZ8j8BipB4FDZBYy1RDBrSGoKoxLFPYJQQ7yFe8bPoaDnYovfueXjJxj5VqQnB4wKBq0evQa5zZ7zaDtKNdZ408ojtXNL73WW76uEAx9tA5des7wPS8UZ5VQc=w713-h632-no";
                        video_path = "https://media.giphy.com/media/3XsYNpeIm2z9qcpmvn/giphy.gif";
                        description = "-Espalda recta un pie adelantado\n-Piernas semiflexionadas\n-Codo no se dobla, brazos fijos\n-Llegar a cruzar brazos al final";
                        muscle_zone = "chest";
                        hip_weight = "12.5/15/20/22.5/27.5";
                        res_weight ="10/12.5/17.5/20/25";
                        vol_weight = "15/17.5/22.5/25/30";
                        subclasses = "med.-inf.";
                        break;
                    case 42:
                        name = "Maquina de Pecho con Manos";
                        photo_path = "https://lh3.googleusercontent.com/KrlzoYtbwtAAT39YF9gbm9YUZJnfv8ZOkjeELcKjrP99U0D9dIavLOYylx18ZpsVyWNI9Ir_97rqFHy7QZlOlM_kDzr14G8EXwhG8CdD6ySF99HKykSmVbV8QAn_RSAV1QnVPFe4xM08sNOJfK7Ro8k6q3rbAcb_x7v-c-yzK06G0Ev1wxNVihmYfH8VmDmCdSvbyPeVwvfbBPonPaGRLX7Q09_IjSIKmOFsEkWmvzKPhUNTDl3RmiUEQN_sQ6qqylzDN6pE8PQGfO9sF8vv_N1k-9ExKXgGr5MAIEXD6B_X2BS_ZJW1fejdEzRWoDp1-DUgO3nBwFP8ZC2YqBQQvJcKttcSriAWmpVdt191sDNmB5zafdFbYGm6pDPCYpKdLYHNo0Se6ouCtXhtAxLfMuHGaqU1TDWK6l7VWVRuRq1Ze-P1yrlR7_n8mjG5hPKpY2Ed2jjYXrTnqPkYwYpNtwsqbYhr_Wdm0B2gZThmvQJPv0c8aSKjr6RAMOodvfvnfVEL2cvTFpJnD2A3WG8GXJ-HPNGcQLz1z4I-VOmdLmFFGaxAeq_ChE5q1MJMAL4VcjWtpb7HMEvgQJSMv-bVhL4jSnnH4h78-nIVNifdY5JT06DNU7JX8msj_IS4mf0Ct74RBSmvPCqtbzmTFiIkzpP7uOslfx5hAZolLz5N2yXrt_clOmPemy0E=w713-h632-no";
                        video_path = "https://media.giphy.com/media/QOcdHH38L6p4XFeqCG/giphy.gif";
                        description = "-Ambos brazos a la vez\n-Rango de movimiento completo\n-Espalda recta pies fijos\n-Controlar el movimiento";
                        muscle_zone = "chest";
                        hip_weight = "35/45/55/60/70";
                        res_weight ="30/40/50/55/65";
                        vol_weight = "40/50/60/65/75";
                        subclasses = "med.-inf.";
                        break;
                    case 43:
                        name = "Press Guillotina";
                        photo_path = "https://lh3.googleusercontent.com/H69ZWlr72fuRQ368wK5T7Fa4-aD2TzaiWeJkKU9HjwS_8aalNfk4oaJh7InzvbHkV_j0afjFrd1twmGgr3GAwaZmWsAP3yEEZhtji37teQl-1uw_66r00u-l2kaHhze25FeNwVWuniOBrBPG4sH2_gZSBoO1Yr52Jryx1GmTtA10QKqdlhflT2yGlZD6RUyhtX6ONWMP2b_1W7ex-NN47QkXv_Ec6NG71MPyqEbbS4TXV3Cgr_PGUZX0YY6FwZ0ag7X-upl-C_G56S1muDlhiI1FvVWYLXUqo1NVVQiBaQf569JZk_FeDkYdryLjoNEMAcU0DOzgqnmdBirAJHuzcE8Sy2la5IQFqIpQ1W8idtf9ykpVXRV_bDsxXwnh1fws8q208af4_tGwloSn1muSVyqNd98DhqFnT1ZbKr0bOGP98zSt0fIMNnfrlSHmOW4YZwSX-ZPFEl1i48dhOBfmfZoYh___zO7OLr3uqPjV2yWKyohnwr3PwGWPHzA0vJTNIXw--Ja016xwGhCdvTBIa-dKp58dmKH6lol8pTUAtNFqB78IUEwytv80Fdd9j-xyX-LKajJ1cUcP4CpM3Z99PEBSCy6tDdtMEKaLMJ2SnN8Iyo7exmVz3H6phD2iU5_jNTVZo6124adPXXoV9aaqH75KLhoEQ9EeQMiGFz6Omy4MQP_AwP4zEGNr=w713-h632-no";
                        video_path = "https://media.giphy.com/media/1yn2K3ajrcTo14Rr10/giphy.gif";
                        description = "-Barra casi en el cuello\n-Tumbado posición cómoda\n-Comprobar posición antes sin peso\n-Rango de movimiento completo\n-Peso no cuenta barra";
                        muscle_zone = "chest";
                        hip_weight = "15/20/30/40/50";
                        res_weight ="10/15/20/30/40";
                        vol_weight = "20/25/40/50/60";
                        subclasses = "med.-inf.";
                        break;
                    case 44:
                        name = "Press con Goma Elastica";
                        photo_path = "https://lh3.googleusercontent.com/nS9-psx7Id3yE7e5yp7FnFSADOZME0EaoRsa6xHuk4h5K2zisoZ4Iu2tL_nenCAF0N0hWoX20qwTEd5BrpTwSZQW-uBciR-Rjml-peqJZp1UikSDOTP-gzCvP0gbyr2FrM2egpG_CIfaxoMFDAxnQXdqAT-JfBSRHVT6YWy3zwan5c2OxvAO_UoW0LqBwhvuLcA8SxC06ltGUuAdevjXn4vfdcpggC7-MkbK3lko21ibKZllYh70p3i_cyPUtzNxvA-7A6DnvnWUHabiy5MwOnk7szX-SE0nJVY82kfAD7kzwA0vSz_79WCcNiBaOJC4X-_0ulsvd_pPtwRln-oxNKxf4sP_zBefOMLFEV0bm6krduCn304a9_0aTzW2DSX9tGbTqAy1toUhirMk_MbXw_kL4hykZ1B5u93Czpg24F2fdxckoq9ntSZ5dEMUNSSvCDIl9ugLEkCnKejmuhFHMtLyD7AOBxNowdSy1i2Z1DxP5CqvodyASwQj2m39RNz3Zf53CbltY16UUiAYqeCgyFAXKaiERkBXJIjEu02niDzMexHqLVvaAaMNqi1KKW8ZTE2AoeViUE1d3K57MXixHn5mXntCQaHkFC_KzTJWMiKu1-CpxGLNAj4b1ZhsVHx--p56a-v4ex7pTvvNPT4lRRP9S-GMjN5ZjY8XDy1T1ub_0xxZOScUmWJm=w713-h632-no";
                        video_path = "https://media.giphy.com/media/2Us45e5cTKSDNoZ4tf/giphy.gif";
                        description = "-Espalda recta un pie adelantado\n-Goma tensión inicial\n-Manos altura pecho, codos pose cómoda\n-Movimiento de manos paralelo al suelo\n-Nivel alto: +separación y goma +dura";
                        muscle_zone = "chest";
                        hip_weight = "0/0/0/0/0";
                        res_weight ="0/0/0/0/0";
                        vol_weight = "0/0/0/0/0";
                        subclasses = "med.-inf.";
                        break;
                    case 45:
                        name = "Burpee";
                        photo_path = "https://lh3.googleusercontent.com/wrXn5eR8QTD3EiaBTLjB_JITA1iuIwLu7Dpvrrr1uYVZotyCN2m1WCU-oRhEPQhtOJDYymr1GdeuHJKGEEN2vli1Aet12nZ7_znYwW3RF9aVOgtmQK2ZepwMMnmjOXmj1KexaJePkiN0NMPkHJbvy4roPY8x_l9IFMo4Dgpo0sR0CUqvUAPvVjfIbFyffSZaUIsNddhdXbDzHtHI4E_pDhcombJ92TJHG5VjUrbdnfbxRhICKAp3GfGj1bq7yeWD3iJGdKKFQnQvGHh3TawOU463RpQInKnXqfk9awCKf4_W-CazwxJMstdlN6hluyyycod3fFGb_7lC4jFQgsZO0VCUEZkgFjnbiE_jNrfdmqCBedzT9g-ZkVc9dWEfwCKD6g0G18nPK4SJqcPnZEUbwiBa3BgzcZBWba7Fqu83YRNvp0ViZUnf9o2XvlT4iPHISNKXyDxhOut6TF364Rf3GuVf5lXflUNsiFgwybQer4pBemHNYuQSxb8riQ3MgqXBZcfQYUnV572w9KrqJZaemXl1IhrbFLJ5BBUttkjpA4uaTh95YvfJz4RHDPtK9vmZEcIytff_RuRWCvdauDK5FJIVPlvSCHPGNrSEwKHCmPxZ3hJK4sF1WoNq-MqphbW6C3AQyGgO_Rcjf4-UhILcNoJOuUsEViQYpFzpySbXuNZwdkg-CbLZUDo=w1062-h944-no";
                        video_path = "https://media.giphy.com/media/USUUDZmy3VjqfuDeeJ/giphy.gif";
                        description = "-Flexión de brazos\n-Salto adelante junta pies-brazos\n-Salto vertical alto\n-Salto atrás vuelve a inicio\n-Repetir";
                        muscle_zone = "chest";
                        hip_weight = "0/0/0/0/0";
                        res_weight ="0/0/0/0/0";
                        vol_weight = "0/0/0/0/0";
                        subclasses = "med.-inf.";
                        break;
                    case 46:
                        name = "Mancuerna Elevacion Frontal";
                        photo_path = "https://lh3.googleusercontent.com/ChuJha1AaU4qw5n3GICZnBXCk476NopfphD45EDOA2K0Q2zFLC7fYVj83cDlHpMqUpZZq2oGwdRMoZ57CKIEwnui5WJ7Shw2EOqLKT1ZjAdNaCpRbi3PWeUoebnM5FS61BvqFNg-sdDaQ58GYkerNm1LI1-coBkv2hZyFFuF6pm1WmkVnBAjFTfcgsTO0qEbW9avhpzczJpPOOL_4EKrlxTFDORwGsnYt0YzC1sW4aORNZo-RU6QBGBMSRI7yjWrxgKRRdvURuqs4iD1KmN__t0fmu1LOuxit3a_YUbhZkXEFgSbY8GYCS0rCGL_v6My7xyxGOIHXvc0z7wQFjycSZKao1Kh_dBAaaEdES0CTv5QMpdOnhgOe9o9IQXW0v67pA4WNF2_IHi1PaaxhsuzKW4eta8mKIcFPtWDBmpXbqI_ymtVSMVD2rnT8B6APE0lCR61h7iWKz_V2YmD3lwlLelOzpjBqVcR1HTNGmbFbpMgo8vegWBTAV6-znPrmfLYnObT3cqaaqSiuLtSDfFFDu-66uDN50b4caliQ6M__69fE06wOYoyHo7t1YRD76fZPV50IIksOBv0HEEPIhqOZUbfyTldDDSMewIygNSWJGBHUklrlqvloaOlEfbMQ8zI_OqSKzDCm-o1OeyD-hVP2LC-CAOKJzSHjz96oqmqo2EdbE3IwoXICK7a=w713-h632-no";
                        video_path = "https://media.giphy.com/media/vRMlxt9czytSmsEnn7/giphy.gif";
                        description = "-Espalda recta, piernas semiflex.\n-Brazos rectos fijos\n-Subir mancuerna (límite sin forzar)\n-No balancearse";
                        muscle_zone = "deltoid";
                        hip_weight = "8/10/12/14/18";
                        res_weight ="6/8/10/12/16";
                        vol_weight = "10/12/14/16/20";
                        subclasses = "anterior";
                        break;
                    case 47:
                        name = "Press Militar con Mancuernas";
                        photo_path = "https://lh3.googleusercontent.com/kVJF7_wvEXQ-KMXvoU0AEQpvkbsL23k06jK0LhbqLl8oiHHB40ZzTivhRtlKBgT1IiL08eV6k3cqKRvRosmnV0xBbvfUwltg9d702Gx9gzol9zLfNepFszy3KNB5cEps6W6zeGMkh9kxGQlMaCsSYLyV2GeY8wNj2Bu576V-3I2Ja-oWSmWtsgH1-u66Rd8cYOeZNy0AENLnKfNFp-gGVEYr5IvGz0rBUyEnGrp1vvyN4Q5DLAk0-XubCVAd3exFVFaTB61fDuUjAz1lQqNIwpv6kZ5KFm2u5POP3E4Z4oL2m0N4VgAkzIuMwVTXkpioH31rS1RvriREHZZDh6e5OGJcYHyKfWYgxlEO2dfQr_--5lWKqylqXq94CPT3QRJj5xwMnyRxKlJ7co5MK9mR8eMZ5SHX3mAB8FmTQ3kyePZoQDaWwpc9V17hdVtJBs_sBAEv2NzJXnN6z7YU1AnsZ81vGkqxFgb1Oj0KG979CZzxA6XY9BB7zRECgxhAz2QMe1H-AUZ-ryBUn9kg_a-nC3CNsK5g5E-BJ9BAbpDM6QTqG4WFFndt3eiFomwQatNuxEjNdOropxTEkv6W1cbS-nji9hn7hkta-rwnc4QBRTitraFXyPkjqHeylpXn3psn4YWZC-wVN93O2MWkzbWevl-KzPOWxIvVog1wi1yarc7mqg4EEmZt2W8=w1062-h944-no";
                        video_path = "https://media.giphy.com/media/hoxVs7xJTliPD070wk/giphy.gif";
                        description = "-Espalda recta, piernas semiflex.\n-Ángulos en codo y hombro de 90º\n-Posición cómoda sin forzar\n-Subida en diagonal a estirar brazos\n-No balanceo";
                        muscle_zone = "deltoid";
                        hip_weight = "6/8/10/12/16";
                        res_weight ="4/6/8/10/14";
                        vol_weight = "8/10/12/14/18";
                        subclasses = "medio";
                        break;
                    case 48:
                        name = "Elevacion del Lado al Frente";
                        photo_path = "https://lh3.googleusercontent.com/7rwRjs-fzpNEKtkVf6FhXaWJfDLaRrzwMv2KhewmbzzV1P89-pFIC9Kt2B0_bCCFF0YYbpuw9UiYElQ2_FSVW5TkpVWdD4oPJRO_5RD8nRwVeedsv6ND1FLNXzsBy3ds1jHQBJHlRAJwWutK3f5ebkvE4ZKj0L1QPEQ42Xw9K21fkh1q9YH90ZK68AUlVWULz-47TTm-bxwLFLiapT7DUE7fqNdCxRwAEcf8vd-Tq5vxweOwlnXRJtaiULnLE5Yf0Vu7OG6rqB9IO92KOWpqi8zCNU5qgvzI7hGTm3eVdyBNbgweceYOU8kf-PTHnQO4uZE_P5gFkCqs_VJAt2f0xxG2wUf9kb-zp6eQPv87lsTQarUOEMYYtOiD61v4G6ZQ6yiZGPMuvFJn8gjYg2eulBfKGYjW9gJ2HUVWvVxhsprVheZYSSH1N2b1bDJimERLhxUTR3q8UQu7fdPUfo3dVTiWxpHlvClU7V4C_dLETp5N-2AvvNIDtGcKzRz-EDMJKZBW_-yAABJfIjwemvEefKDhZRKDUinoN05kgeYXgl47BeDqLmBsi91BJgk8hFFma9f-zqy-DanRUbDRCCyjVmidNPQCnzL0GR7xgejSUZsnKVafkOGkhBQrM3YVXFcUyh_alvg0IDJE8AM4pJGN5_iummOrWzwqY9lV--tAowdlRJloPS_Vpbv7=w713-h632-no";
                        video_path = "https://media.giphy.com/media/8rEV7amrTu3Qa0g0il/giphy.gif";
                        description = "-Espalda recta, piernas semiflex.\n-Brazos rectos fijos\n-Mancuernas al lado (inicio)\n-Mancuernas delante (final)\n-No balanceo";
                        muscle_zone = "deltoid";
                        hip_weight = "6/6/8/8/12";
                        res_weight ="4/4/6/6/10";
                        vol_weight = "8/8/6/6/10";
                        subclasses = "anterior";
                        break;
                    case 49:
                        name = "Polea a la cara";
                        photo_path = "https://lh3.googleusercontent.com/5mevVmwn8Vo77PFyjCF042lx55TkL8dx2dCukINLsl5ho1KSmgYB_wWR1ilpCaIodSS1eEWR_mtWDuM9E-GH2CxCaxzggzmwSEGRHUW8y4TWm8bcoyEvT-1PCHSuEg4AX4W5-yPsqFJs6oNZbVnurIEJq7AvulJztGiPsY1b1yZBToVvPGjiTwrVl3GFztqEXZ8R9Lnf-vaubmnJcwELG0Ov0oVc5uleLZGT_1wAebrAy4obnOZEyYkeaM1bxEtqtlpZK2LL_wbavjpz1UmAPYO5CsDLyODvXXt1BcZ4A960LbBNPbkPv9wF4GuX2lLa1FDpOWVMD-a7rOBjN4rTDRJxoXWwOxORYwDsQ39QEy0qNN06h8AGFx1W7CuCcVzVZQUU5GfSIgWJfTUqqYvlzvgyBzNijL9-pLMqb0cNoBUETEdTDENS2GYJpraHR-b9WSJWPIBKowUyeRm6W4xYhoarQnrpqLpUdPtmRQQOgW1po3QjjoYl5uXWk2hRA2Cq6SGNiSEsYdNGmy8kLbOzStWaNLbi8_cJ3jrAHtP9188Do3Of6P5YeXBaZoFKnJVkQGHCcYmLPu_0VT_HO_jS_kdtq25lCBT6t35T2xiI7LwPWcn2iIUCRl8052qB3S9o92NqdjLWgeAG5AQ4D1gHAlViXxb04AMipF91N8NV82cgBknPtuG3V_o=w1062-h944-no";
                        video_path = "https://media.giphy.com/media/MaxxmOKT5h1aiLZVRG/giphy.gif";
                        description = "-Espalda recta\n-Controlo la vuelta\n-Sin balanceos\n-Movimiento natural\n-No bajo codos";
                        muscle_zone = "deltoid";
                        hip_weight = "5/10/15/20/30";
                        res_weight ="2.5/5/10/15/25";
                        vol_weight = "7.5/12.5/20/25/35";
                        subclasses = "posterior";
                        break;
                    case 50:
                        name = "Remo Colgando";
                        photo_path = "https://lh3.googleusercontent.com/HqwTjUvthT-ULT7HVNZSlb7ZPn9LpcPBgCrFphL_KM6Cl4Clocjwi7np7j3q22Ds33toA58BZ6wB46Cbb-mpu0x0sX9V5r-uomi33PQe3d64lwhE4L8dIxmwrgO73Kppp752TtLLp1LIznaiCZgpz43gAeQbrJodzkskyzTcDzRjJ3CApCJPNcuS1CjA1d7bLlfoLCkf4N-ifuCHXCu_8RvuoGrtSquJwhWGOohJBIUUdTWNeeGyOhb1wt3xFVVhzy_6nzw9t2HgOQXtbYz-XGgcqKnJxRkFmcbOWcWxPr18hA8DRk9roxBG4oH7nsafV9DrwHbgnoyGClPx4zp-RCUYJTMIWatTm7Bdla_AhFhrOGBEqHmhhqPiVEjcQo5bSnVYi-5sjmqCxcF--0toyCfUkoBa0pbZ3gFyjtRXElGgHejWud_BKk3wNjiopAUDHoOoxNMBlJJ8XX1WgVlDKBbtSALgA_3KcjOApqZ4h0bi0FNuMgxhYnyqFLT-JXwlFcIUZKjPHqJLc-KIOaM6eY3D7w0B3JuHY5ZitulTwl58Zm4elq9GvRrC4XwyBt-pFAQi6iFOoa4g0_jZHNI4qF-XRf2DOGUsGUx-NMpFgey_wW5ULv1IBWuY9bZCk9bq22iQqaHDPVlIJztM7eeEkRbNXY5Pau047QSrIMLbYVPvDNYaT8ZNtqwJ=w713-h632-no";
                        video_path = "https://media.giphy.com/media/1sxVMlLwLi2O58000A/giphy.gif";
                        description = "-Flexiones al revés\n-Codos y hombro 90º aprox.\n-Cuerpo bloqueado\n-Subida casi a tocar barra-pecho\n-Peso: disco en pecho";
                        muscle_zone = "deltoid";
                        level = "hard";
                        hip_weight = "0/0/0/0/5";
                        res_weight ="0/0/0/0/0";
                        vol_weight = "0/0/0/5/10";
                        subclasses = "posterior";
                        break;
                    case 51:
                        name = "Elevacion Lateral en Polea";
                        photo_path = "https://lh3.googleusercontent.com/X_hAFBoGAHEUTAhtovzRBpzkxCgOyLeShLG5-Kv_lKlz7Qy2PnCiW6USZ3ol_aRdouUHdYqf8c-HFL7jgsp5qvoqfb84rhOYKQC-Ui_sy20miUZ8oPE8gg8aZWfaYjwkiYHbGKBoNUJuy_RSBTEcojQpda19t9tr2Qotu_ZKIjf_vAoqrExbx8YpUhXqnYZkfSVogAcWxXcI_u5YiVsXslaFkjrkdHkwIQ_nn6TtgqUISochid7qS6hDsywBwi5mnOA-t56fET2dc0o1b67utEDDQiFhkUwc4b41EYD5KwPs7p1dsXqckZGGo0A4AEV3300aXgGquRtdIf1OMey7xXknRORuslex3YTZeL1Vkz4zeb2FFGvRT2OwHpVluzbLSWjR3EhSQDpNVWEcWlyLPEdudo2vd_wKYvGm31nuxBlNEBJUk1B6y9JHKqJOzUW2e1H0Gdqu2EOmfYwndM6RpRhTrWKtywkktBl0M6iLWIUlAZiZcckNIJqhXsw24dFLJB7htRzQxYsAuuNz187FTa-2ruPIn_7ussgLTp6DSjfiaZjzP6nZENnP1iwKDbaZ5FUx8_q9m4TRfZsLeH3AMVOu_o0jFM_Yb-JQor7i-X4oz0q_HNRMa9ZzWvbPS7I4_xh3vdylRQrdiw69h55WaqIJw2m3zWSNt05FXJm7o4s-yOEMzL4XQ6xY=w713-h632-no";
                        video_path = "https://media.giphy.com/media/1itJhTMvLvL6OQQvxS/giphy.gif";
                        description = "Espalda recta, piernas semiflex.\n-Estirar brazo\n-Posición final cómoda\n-Tensión de todo el brazo";
                        muscle_zone = "deltoid";
                        hip_weight = "7.5/10/12.5/15/20";
                        res_weight ="5/7.5/10/12.5/17.5";
                        vol_weight = "10/12.5/15/17.5/22.5";
                        subclasses = "medio";
                        break;
                    case 52:
                        name = "Maquina de Remo Codos Altos";
                        photo_path = "https://lh3.googleusercontent.com/RY4SwIbHZJgrOY6rQlRDJP4Yix7J9KAfumLegLbh3tq9LGKqkJthpaMx7Ek8QF8DOiqiX8o43jUUFklO1RFn3hOfDFvNhIXIJmMI0RTGneo4kSNpcdT22LQ_cRwRA2KHV1OFaT6l7Fy-FTwMdV9ItNREExUq2X56su7_ZD4zZjrHGOmPsRVC2pVy46-T6ByyfPWmWZr6Zklhhj8ApJn0E2ToGCMjQW8xKiArbtWMPcELUC2lW_mQWY7iyIUj7T6HsqJpnaYUg-fm7mcUR7onZkYi_NqdbBFXdEy586iOJSr3PEzK-WLqTee1EzxHYKTCbH3rJkOVyD0OocLt5c6wd_lrhMMZH9J1B44DLcTtXjt_eXO3BdF5iZOiIASaq0M0dnO6e2GWVC13Ia5EODdQtDjaB9eTzRXSLGuqvsBtW8-BDfvUHyfIOuAFLGfNFbCnXheNvuyPeVPwZUBETng98UeA2nXjUHzEH3qulK5oGPEUcyX8Ke10J5NcaP5NM7xVwVF2WSsdtTTFiyOSS06DIXobuee83Lc2DGgqCOzq5mocY_v_K8dDYA36ut-0pYlFJObF9_7POnfCsKzBAyCkpkObk6YLOEKsz2L_-jV-zcbtIkNCdf7RMniS-K86pca3e48ZCb3AmGYl76D1DuO1__ogSVHhpx1uMDz9Q0MRJXqz_BHt3KqxSlW6=w713-h632-no";
                        video_path = "https://media.giphy.com/media/dtdDalKlMY01KECU8Z/giphy.gif";
                        description = "-Sentado pies fijos, espalda recta\n-Silla lo más baja posible\n-Tronco rígido, se mueven brazos\n-Mantener codos altos (sin forzar)";
                        muscle_zone = "deltoid";
                        hip_weight = "45/55/60/65/75";
                        res_weight ="40/50/55/60/70";
                        vol_weight = "50/60/65/70/80";
                        subclasses = "posterior";
                        break;
                    case 53:
                        name = "Maquina de hombros";
                        photo_path = "https://lh3.googleusercontent.com/6c9Ri3UMF15t0ZekyxT7tOwQWAzklHGAtPUVafauxJgTvQOOskliiZkf8XVt6Ekn0_KLaqC3_dIILYneLaxltRJN_LcULHtBCFtiSnHi8gnPCKy6uXsoXhfjX5VGVu190W7keyUzdWLOD9zIX0W2DqaPMgnHWiH_XP8L37kBJRmQ6-6sK25jTmxLPdNIx4327NNb96NKuZrgKqyyLBKn7yB2e3JW-Tu5cSpapRNYDd9pVhh0SuALzg0nSyYfadyVlrE0pCm5aCvw5ZBuhW49KwqHHoVXaWWfGHEmxcLoM8X8g00DicRzS0JJ2gkc7K1qWbebahKwXt65GG_qK9Lq-ZNpIx5o-n5pvilvjtf3XqhHAFRGRqpFGLFqkdr0MjJcIJOOHG6t-05fcHMreAt0UqzxdDenvlvaPcFb36Hu937zZxwEq81bPruFEl5EMamIVxiJmnulvNSTcRHkDTolpX9mfuukT4k8YLskvB5fC0GgAqYhSUO8GACtUkXvfaBpQkPE16l60DlQwTnzPm9a-XYvXOyE8O06NI3qGCp9GEWVVT8CyWLJLLMf3-UXiYmhuDrGHVF4Kl0txTY6GxW3fyBOHfOJnjRzLdN9ouCClYl348-36gXrR-vYArbNB1YJ_LC9LWkPjj8cgxIs7EcZ_yxivu8uV3Fe3wcm_aGh5A_l3eZ_N2Awwy1i=w713-h632-no";
                        video_path = "https://media.giphy.com/media/uADjhaAG1c0rzmuK9R/giphy.gif";
                        description = "-Sentado pies fijos, espalda recta\n-Movimiento completo\n-Ajustar sillín (posición cómoda)";
                        muscle_zone = "deltoid";
                        hip_weight = "45/55/60/65/75";
                        res_weight ="40/50/55/60/70";
                        vol_weight = "50/60/65/70/80";
                        subclasses = "medio";
                        break;
                    case 54:
                        name = "Linear Jammer con una Mano";
                        photo_path = "https://lh3.googleusercontent.com/M3kR8BatdEXkDnmL7n61-PDwjeWPHzr2fenrF0eqKT6HXrM6b7zyx-a77JVh6IR964iP6nmD_MHWxln6QcL3ShVJFB3PZYaskH6kZmPbTmdiU2lxuf02pFX20_ZYhA5wFKPuE9_r1a5w40sHn0LhSqDTyoW0Xnm682tjGY2eltGJ38aWsrjCfynTCpsyjeKAKsLhoaZdpnCDtBDylrf0aNClIGS_rNXiCRatCQJ0xiWWRSyicTvdFhbCcHbHKAq1jyXHQ9buDso3O1EsMM1LQ18ORLknhUWvGVXqILR_JEVKUqm5rflil7zbUyz-EiAtoxZQtqAzNpM8CkkHI8kdXNK97isTSrH06Ahv_IRn6le94EPe5s2vnC_uNpxHbWiSQfCmdQP_cA92BoE-_vSBJ0_n3LbM8sxbSTNU8J8MgANdMHJvZmXCrK5q-7xceMAztAg80xrtmudQ4YEuBIIfOR0NGFqDUk2IFWyEwaeQG8pNji-AhvXkqxsevjjzVQtB6pufWYw_ZubxwlLyNJ2aYZHVn0Bo7QnDZZvr5v4bBriN1u6x4i2lEikl19fKa-EchXitlQxluYKidP4-MyKCbhwg2ELtKXskN9jqrXrQGAwbZoLKN0sa4oCOUcOSo_phJHtbhEEUWWocNoz1BBNyd2SH30iMJaOtwUMDJY5cOpDnjiaAeLPoAS4B=w713-h632-no";
                        video_path = "https://media.giphy.com/media/4QF0Pjf1tWAhcZXwhf/giphy.gif";
                        description = "-Barra apoyada en disco (con soporte)\n-Espalda recta, piernas semiflex.\n-No balancearse\n-Movimiento de brazo solo\n-Peso barra no cuenta";
                        muscle_zone = "deltoid";
                        hip_weight = "10/10/20/20/30";
                        res_weight ="5/5/15/15/25";
                        vol_weight = "15/15/25/25/35";
                        subclasses = "anterior";
                        break;
                    case 55:
                        name = "Goma Elastica a la Cara";
                        photo_path = "https://lh3.googleusercontent.com/QBOAt6NSWuTxnMyw9WZ5bPpAUMOzXxbYNTIM2LACcQTz0dWGFlaUUWg64Rq5gfs2AVFrhbIWcRNrcmuM9-R_8zB3kIN2XsU5rMvbxZlcg2CKQ_qWuhYsaVN42XRVMg3ugtam7JLyK31CD7C6fCsX_KRSXmzg_2rygwnblicRHkOoYYhALCkWwruKEv92Nq5ArxHwht5Nqp8-2gD9PMsstramqL_72jorT2AU6lrwh7tmmrLPftiLKTLBhDBfEeMd0nAoAOVRtPMdlfE1wwpLQMxGYSbK50NE7om4LZph2lQO9wGeO4rUX9KUk7XyBki6ig8QDVVckUwu2Su_7TR9FGZQMKE5CMs1SkoEnqOE7Hq-ZTYMxTbpg6BDJPcy1cMmZovsDeXPrSzACcGokCTJ7l9qUcm0TCtAzFge3JPmT-l6z5rB6LD9y1bZ3kjfUcmhCq56emmAOqjORbCT-gF0Ja1tyZVqthoKI4WVQyPFPC9hVj0O8mf3h1svabjMtzkAjosa8Lcf9qXLAiD5i--CYpv9ZkBBQlvpfLX9yaBWC-V_DJVkn0DwC_S-WeloAIgrpKfUYxgVd6v-UUQ41Zzwja5Gv2VQB8ycnC1c1ATSwZ5pXSUZV7CIxB9GC5VXVibB7-5w2Iud6mJqOFF11auVbOSIcnTLZVtO9btZTE470wWzJfUWvKO4JJHf=w713-h632-no";
                        video_path = "https://media.giphy.com/media/39zXHWOTg2JnW9RmOJ/giphy.gif";
                        description = "-Un pie adelantado, piernas semiflex.\n-Espalda recta\n-Se mueven brazos solo\n-No balancearse\n-Tiro atrás ambos: codos y manos\n-Nivel alto: +separación y goma +dura";
                        muscle_zone = "deltoid";
                        hip_weight = "0/0/0/0/0";
                        res_weight ="0/0/0/0/0";
                        vol_weight = "0/0/0/0/0";
                        subclasses = "posterior";
                        break;
                    case 56:
                        name = "Remo Mancuernas Codos Altos";
                        photo_path = "https://lh3.googleusercontent.com/3Lnaws2ryuOUR-iJMnXX79FaPamJ6Rpy3aQdHt2r5JzyfT4OWS89txVDpfNuLkV7rhDrHOXqPEsMUvGIaAsMvih1Msz6JXM7iD__TCre0mz23wNmaNRU7s43eUf8p71slTFGmNpzgo3iKYET1407PljrnFWrly6aNkHMwILVpOgm-v46sgm5C1tCGsbYaHUU-mV3ASRxD-yD7dJTRbzqWDsaqb2Q13mSeg79z62QgptcvA66yzN7BnGP29-N0H0NHQwYQZj4V2TlVenESdPClcqE6PWZ1-u3-hinL6neTfomnGpYt8km4AmvJJPdIaTH7ut2n6sFPltGts9r_QBpAfiaugPNw4hFnBci8UbVGop19phZxcttY9wmlGB3FraUTNneYZX95vTK-8qSGwYJwoyqcJSVCknIHv0aZHsKd66Yl9QzpIxq3uaNyqJzNCpu2SnTqXNUldSh-aMNapFC3ns0RsbDuRtKYds2VnARwTvpPTuErS81HZT_W55fFZA8oDrcBSMPvnm4ilFvSAvsOwJXwFWZwVS-cs88DVFUOluMVzh8uZTBZTy_iUwAtA9PqtVJ9xmVHBRpc0tyfx5Dl3AAHzshXvcczWgSbw9ErxlbCR9A7pXWl5MnW7FJ6p_mrwLFMozDJ7t2WJn_eo0r8zl28ZiLMFAyVMKrZd6gmwjCCL25r3HzwcsX=w713-h632-no";
                        video_path = "https://media.giphy.com/media/ccVHpa23Z9moGNfeaD/giphy.gif";
                        description = "-Espalda recta, saco culo\n-Se mueve solo brazo\n-Subo codo vertical (90º codo-tronco)\n-Brazo estirado relajado (inicio)";
                        muscle_zone = "deltoid";
                        hip_weight = "8/10/12/14/18";
                        res_weight ="6/8/10/12/16";
                        vol_weight = "10/12/14/16/20";
                        subclasses = "posterior";
                        break;
                    case 57:
                        name = "Maquina de Gemelos";
                        photo_path = "https://lh3.googleusercontent.com/bBzhkNcZZZRGovI3-3EYOGKb2dmERmA5hDOyPzqcFxEFdgFSmmG5SaeJXIPsqP9z8sudAG1CyvRr0k7lOoN6ZxgNOEVm4Rd3huLws0eumKmRSP-HfNEyczIatyZMF49OrF9r22iIY9crDNeRhIbKpxxU0LBw5p6O73zDdl6H6lndDSxG4OdfMT_CZDPj_BMgbs4oOJA2SjhkocrFnIT4Wr3ipdAZCmwhaAMpgH8opx06YjFCEukBYlEBkG1D_Y7seER5s65iqlZpLkZBhFcO-zZVog13BJyTJ-zjzzqZvXv8pydz7So7IMszYjCLOoRlZY9w18-hNECg2VO0iFiKP97Mym9yolu-s9Gqxj4bWTRWhHgIfbeRFDk520mFDNPFQ5UWM3P3wPSgg4GUt40NvLQ8tt6HR32FBjzSaw8_fplWwTPwPT7m7s1PxKs8c8CeKQs2z14HB0wA71yOwY_9dl2AtiYqxpRZTGvkRQbyniAMh-lC5hZLbx1QPggvsxeTKD6L6bk5q5ydgGJ6EB0mgc7o4purFoE7q8UU66GFHYlLzRF859vvevBBGGK5UVFveGVPEhY8-9g-XrnWfJBYzWOLZeWa6WoszLxEhmg9P37c3Fd8DJ97V-ba1xIMM8L6ZWAK1xdGobR0P8DuJePKiOv8NSSTp--CC4641N9VgmMYk-f0NnUbin_S=w713-h632-no";
                        video_path = "https://media.giphy.com/media/3oqo0A0C4UPKknPQkc/giphy.gif";
                        description = "-Espalda recta\n-Probar sin peso primero\n-Amplitud de movimiento";
                        muscle_zone = "calf";
                        hip_weight = "25/35/40/45/55";
                        res_weight ="20/30/35/40/50";
                        vol_weight = "30/40/45/50/60";
                        subclasses = "soleo";
                        break;
                    case 58:
                        name = "Saltar Cuerda Pies Juntos";
                        photo_path = "https://lh3.googleusercontent.com/I7DPJwju-q-FjsFQxjBhnSrl0oc-TnEbhYbYFPOdEGl0W_-tcJU_Bc4PwRvhW9LMThd0-t1dVCxsvit08KO9S3bw1zQs0RJpo-Q5yRtoblPu7tNvQFssthqgd9pG2_xQgDRwB8wwkkmOV-NIDqxCJ1hRb5nqMHFd3fw1WKgxX7S3o4uFY_OCrWmmsaIvFcT9hxr9aK7d5LnSjeF-7h0XPFTBkldIFrcuOMLi4841DhIbnyZbu72KhSLJKRryIvAYdj0S6LCCpX0P_xQnSJ9NA6P0xNxfF9LLb3oj_OYTvpOvjmJQAkZVL0s7VMM2E-Lv2DoNL67dIeL1ei6uPBmOpwyQKjr0rUJTWEs1V3tb6cNMX8B0CQWBhKphxr3LggaA3AEF5G1xAForappuhlcNgmB4pygCaL5SC20sRSP2iHF2kRzShLz_2_4fBzd9VHkn9PnS0dV7r96AY-tYm6_YWmgbtxq72ADzPNdz8SC2sNg8xuz4W4JDLrhip8i--izmq7byCmMlRYtb0CCN9t4Ab_wOgx-Wk7yqsafanUKCCJcL4RHIKvBSHoVJZsF7y4RrZeZIs0FZbVBZdiXG18uV9U1FxmlVkjdzp0GUYXo0c3sRyrjOcUyn9uRr7-gMC7o73_jieNb5d_qllzpXkjSP9GQwYN5mZN-t0yM96N0xd5OCmuFx_puzcw-U=w713-h632-no";
                        video_path = "https://media.giphy.com/media/g0sEGJ1mlHWVVkXZtf/giphy.gif";
                        description = "-Saltar con pies juntos\n-Flexionar lo mínimo rodillas\n-Movimiento controlado, equilibrio";
                        muscle_zone = "calf";
                        hip_weight = "0/0/0/0/0";
                        res_weight ="0/0/0/0/0";
                        vol_weight = "0/0/0/0/0";
                        reps_obj = "1 min/1m 30s/45 seg";
                        subclasses = "gemelo";
                        break;
                    case 59:
                        name = "Maquina de Gluteo Sentado";
                        photo_path = "https://lh3.googleusercontent.com/eYYwE44PbfNEtWznEIhyN2BBGQQr07dje1zivG2M03yxSLKNeZnCQYp88yUld2FCg1aHS9D8BjW3EqjY0vcTD3Iaz4maBIrh1HFSWkH69O_6XDMbklLWYjt8YIoR102WKEZctS-eMFGSxipwMQNBTqLK11Oyk_NpSr0U9F07v82Yf4yrWxRWh9ZerkfKVEqAmPPNuCuwzculE0pIA1T8drjo7ISOkX02_x83Al3qAv72rt14Zv_WmWLjskJV1WYzCfK-JXKglfQHjuF5tzdb4EZYz-4nw7aXOChmPY4Pt3j0myRB1juup26-mAeI8fekRDW8JJU4YFKfLcfilqgAoXY0aJpbHWw7nQA1yVRwuPfqPZ3ybQdohqN7dw6J6xY0uS1tdScGXLucRYfk6Tj-6RtQjkEkLxBd_hrMkdTgkgWsoG10C07DsD5MQOCMGw1rq3q9BgPQ-DUkRU_qMJJHwF1nVqJWitZxCmPDDC2LGTGFmsrnhCk9AckQemP-SE0VSY0UYBwq0DHD3Lx41zM8sOE4Rqpzmdw1m824JEsOPuSUUibSB33z4UTqkv8Eixmrr0NuVW0kS5Om4EXqh_LTyy0uRZiix0SsyKvyIpmiNmbGt_V6FwWJ1C9HS_caihTg6Lo2X2-93u4aOjOEGs6MsVbu7OBQhecQPw9ihw_-K1Ih_XaodhAsf40=w1062-h944-no";
                        video_path = "https://media.giphy.com/media/jRfbFtoWENAz6q5Pb7/giphy.gif";
                        description = "-Sentado cómodo\n-Amplitud de movimiento";
                        muscle_zone = "glute";
                        hip_weight = "40/50/60/80/90";
                        res_weight ="35/45/50/70/80";
                        vol_weight = "50/60/70/90/100";
                        subclasses = "menor";
                        break;
                    case 60:
                        name = "Rotacion con Banda Elastica";
                        photo_path = "https://lh3.googleusercontent.com/aym_LIz0ITRwJkqHYklsmTIwRp6Pi_ALjQnmY9P8oG4nr4lYZP0NVBOt9UwoQ1y26bu0u6sSl3YhZyOcMc0JFN9eE_2DeRA1o96rheM9aOhohO1AutHBwnLu6HYkkQyJl92vi9_TyaXLDe5xzVicy_Qmgaggw2FVyXpHFy8SQqu8eFS_t3RYCddTjf1sdUnT4r0mABWd_hRm67mNPjIxG858baR80LnUKQdVNrYfXJgppseLvh5VVC6uO_YvDjGyg8WIFSUlZ4BgRCWugGpsO2rgz-z2t8uFMoWXJdG7DUz1PJW4QFua-C7FUro50jx9GYiiqPR7CtGHfCbYlIlQ8quLeZzdW7DypTNP3iNblLKIZuFYJUCB7ob7h8E9OkwitAG29I-fx_jLTELiSzQzWhUH0TtMvm1cFwfjNvmxUFdBV0sBTvvDjzhROa-60HOHOjQcIqH0aAVWUKY0A7u8YeSsxuaX9Bc08mm-odeJ0jH7k1Ktg8WkjxPcNItvBUCRVhtwUkQjpp_DS9boj6Q4eJMCTtBvWEmZnX5sm1llKbFWg26b9pmr_MzSP23S5Lp5jPkiANfG2CPYDzsWg0HQu-Nq4zBFrVd1kDyMTW-ZrNCs05O_1dRm1KQbv3doqPHvSjix7kZx2BfLEx49mpbZD6NkSdfWa3-hNl6EqzJ-i1d_bpSC3pXHc4Ag=w713-h632-no";
                        video_path = "https://media.giphy.com/media/huVbtq44V78loMJ6Am/giphy.gif";
                        description = "-Banda elástica en rodillas\n-Piernas en V\n-Movimiento de la pierna externa solo\n-Rotación, amplitud de movimiento\n-Peso/Nivel: color de banda (elegir)";
                        muscle_zone = "glute";
                        hip_weight = "0/0/0/0/0";
                        res_weight ="0/0/0/0/0";
                        vol_weight = "0/0/0/0/0";
                        subclasses = "menor";
                        break;
                    case 61:
                        name = "Sentadilla";
                        photo_path = "https://lh3.googleusercontent.com/zYwnokeZwpfzDTV1NHJuIjIHXmyZEdr6dePmcY_rGp8l9sqZn2zENOUlbie4NNcDInAZdDvnOgjUfahsWkXT1BA8ojwFmyMimGk2kfTGnsdUbJf9fioepD7bznzAz0u2R4mj5YpLUn4o6TwApY-N8KwmjyfNo1ERvko9QFcLeTRkITMJgpGWNd6hDzH62jza-17FdBF4yRYMhRio7Lj-sA6Mm8PxFiMVJQTnq8KfMif0mYmmlChrpwfF3wOEiajy5Q257mmiy-Xm6X4wwwD895n5iTz-SAP0LB3klIKD0oqwEt1qWwB7dzgxJojh_HxgLbR_oOtamT9l_X8tkAZSsbZSNFtsLRQq2CBxJaxUXtxUQ2fuzsFF1HQlKJG9I7vTwvvmlSDlBHKRoHHFpFHAbMOhbgXplKcAmGYIB76Sr92ESsc5Le5J0-S-RkGGzv2cpPCF7LTvaxsi7xDvfPoAKCjapsKmGIAc3-40HeNw2KNBAsrD3FGtnj1ks-EO96tctkb0MWok9Wwrrzl_UzL8vxNCCZjj7KINhFIHSFAOHr4qZ-ciPjnx4JZiW727u5ymWpSIJUxNL1096tU_4sCZbLfM-P1kHlXW0cLASu7hex7rzRjKarQ1iGkweCdSMJBCD44FQgWxtciymJVcQi64QOt2de2ysh1EfXR6R-pT-yEZEEDuPQWgLjs1=w713-h632-no";
                        video_path = "https://media.giphy.com/media/oHxwFONw1bloV3POXf/giphy.gif";
                        description = "-Rodillas no sobrepasan punta de pies\n-Sacar pecho, espalda recta\n-Culo hacia fuera, equilibrio\n-Bajada poco más de 90º de rodilla";
                        muscle_zone = "glute";
                        hip_weight = "12/20/24/28/36";
                        res_weight ="8/16/20/24/32";
                        vol_weight = "16/24/28/32/40";
                        subclasses = "mayor";
                        break;
                    case 62:
                        name = "Jumping Jacks";
                        photo_path = "https://lh3.googleusercontent.com/OJI8E6_hbp8CP1iApL_YwCBbT5gD-7X2wz1eorsIjnwClAd8yHDv1ANb6x8-0dJzFVTvU2ydCPdPvoJSbP3I_nTnngMsgcOcREl4S_nwivR-Me_2pAkjNrndSV6b7bKbAKI_EmU9pNtZwQwcNnnzHhBKT0nMHtUmn7Dqiyt5FA1hnRVONudTNtWGv1pqTIV1yrtsi13UAJsuSqbvzaKHHgZUK469xdH688LU6o6CBTdW1tHgh63KSjFlIvc7erYaSJKG2_EE2UW7IWFdkvHT3CDrfkhVHEqthCUglkb0sdcHFs57f_2DAfBFFl-S__cKEYGqno_ImdPik0meScw0h5DDjChf6mInDbS205gx-yhYBN8ZiFbvbW8QtfyRtJNyBouFE-Bj1iSJOtD7EEzR8psvtPN1rJ0indnCv3NaAIMiX8_HoYGtV00543goH39xE5Nn9BYgRllXcILRXFxrz-NPFBsrsjHEA28TP5Lxl5egPc_iI5WaHVBdDN8xxBS6ctAgyf8xYmOdYyz17pNl2tz9v_W0fOdspCdBF2BDVh3E1aXBea0shGjyHK-YfTHDcAzl2WtFP1pvAl487vt1U3SGVZ8NI3LO_lgkDtOCKhUfWYCZaGly6R8i8KOcmxRTM5FxGz9gviZT_9gpFgSm_8uz1CLdQ9M-ZDWSBgtVbpwEsVER8szjl3o=w1062-h944-no";
                        video_path = "https://media.giphy.com/media/WRFdqgtQmtbloEkSdS/giphy.gif";
                        description = "-Dinámico, explosivo\n-Amplitud de movimiento\n-Marcar posiciones, sin desplazarse\n-Simultáneo abrir piernas subir brazos\n-Peso/Nivel: color de banda (elegir)";
                        muscle_zone = "glute";
                        hip_weight = "0/0/0/0/0";
                        res_weight ="0/0/0/0/0";
                        vol_weight = "0/0/0/0/0";
                        subclasses = "medio";
                        break;
                    case 63:
                        name = "Elevacion Lateral de Pierna";
                        photo_path = "https://lh3.googleusercontent.com/AZ6BXfXF6sUoSvGfEvLt0uf5VnVoJsma0TX4dQ0A0yMH3TbA5WSiDp4nVFPGYAdkWcvcY2ojECfDb1oz43XCd1JhhxS50iBHRS48ospDmnD7AK0wHLpCUMP6Sl19CRbrePY0AVtJbZaBpbBLS7J4lodyYe9jcHdBGT2on5u44SSoXhpdJI22w21rqN8tO5vsb3Ja65Q0jK0LKklX_RjYX9vO9Ya5Qe6J7IokFKm4dKHnUtkhub60Gen2uELIzHFNAb3OHcSkZtoBQmXmvRtfL8SDROgZwFM7SusXjwuqGNzaZlP67Zy8TgzPvO_svmJVT221PnvTwitb-tchGY2lgDA0WUrTFbz45buPp48PNPUBryCMRTS7bCWdudoDTBC7Or7gxxkFhYbOznwoE5DP8DJIbrxJYlp9ciVuPx4VIAB6LanvCQeQlzhh7JLuijGzY_FJDcEcjj0v_TRjeFVhoHpxkgUp5udxTZdCMZd1UAkAJ_j8ftoYfA42D8ceLPKHEEFl7MdcPPLRo93_-odOpaGay-3JbgkKnRiJFR2lgRHArBQ-yur8fpyuohCaq-iQYZdNagx0X8kA9b71uvpyyl-apjLaVmD4JNeHz0UwIHTb9Mn7Jp-lj8uiPICjTA0ix4isluOQv6nq5fF1atgI93X_iH_qFn9MxZGsZzFVaZIpuM64TuVBUiop=w713-h632-no";
                        video_path = "https://media.giphy.com/media/8c0LsbyUfBa26i3eYG/giphy.gif";
                        description = "-Equilibrio, evitar balanceo\n-Amplitud de movimiento\n-Una pierna fija la otra estira\n-Movimiento controlado\n-Peso/Nivel: color de banda (elegir)";
                        muscle_zone = "glute";
                        hip_weight = "0/0/0/0/0";
                        res_weight ="0/0/0/0/0";
                        vol_weight = "0/0/0/0/0";
                        subclasses = "medio";
                        break;
                    case 64:
                        name = "Cable Kickback";
                        photo_path = "https://lh3.googleusercontent.com/UsxiAuqfTdLYtIYO2B4KuF18YO3tBEx4yg8eq0s5dziGbN7KWs96vNb4LXgCBbbCKnYoLU_TD8ihe8qe-P-z5beWF30XWyHzwWp0hc2nZAjwN8dEG4Zo-9kYaF1vtaQUUqXNvoYJTVpMyMlyl_VVLGb3GVJ21vC8n9MZtZ0zujCPA3VP4sZsQM29Ms9TdRU2a_nUbcm8mZjeJlcGX7Dbt_vm6m8c-hWhTWYcaJhBeU9ONi6u0Z0zWPqCuzTyb8Hsd4ez3mtrjr77FDAvyMenQnuILBwTI7wJaQ6cgOQBnkrTOvHiUsLBQPZRVv1sf2gjr7KraaczvAiSCzGL4QabdHEpU3msM2TYpwOCINCVGQ1EEcdpBuPVboEk-zE1Zj_QAi_Ayu_Z7eCdfVXr2kQk45jZeV72eVOqvMmSqqkGVjTZL60CsH2wTyvQ2fwmxOXOEuHVa3k2iRGx2G6uIUqLrq2uh6ds5mYTMu7UyLQrsGmcdkN3HwJeHrlUBfC6z8irxVkMfTeG1D5Ewvc7xuhsHYkbh8tNcFFe1E4wyLyj_JkkHMzdf-fHffak7PO2r31gtHNnTqSEnJgjmtKS0uydpkC2GELVVYautIlojlpIt0kPrw9JGM1aWOzcmBbc-dz4x9mY8F7rD4gRng1lXoo_Nj8zFk7Wx3JNj4oPp6V205qYOpWh6KDWnlNx=w713-h632-no";
                        video_path = "https://media.giphy.com/media/AFn9eQxtLAn3TyYs2D/giphy.gif";
                        description = "-De cara a la polea\n-Pierna estirada hacia atrás\n-La otra pierna y el cuerpo firmes\n-Subir la pierna el máximo (sin dolor)";
                        muscle_zone = "glute";
                        hip_weight = "17.5/22.5/25/27.5/32.5";
                        res_weight ="15/20/22.5/25/30";
                        vol_weight = "20/25/27.5/30/35";
                        subclasses = "mayor";
                        break;
                    case 65:
                        name = "Pull Through";
                        photo_path = "https://lh3.googleusercontent.com/2tD2VETiA2DItuNi0vhgZfImDlWBdCfjLYMh7rQo5ADw3KB1zfEepd_TDKvgll84OHRXe1oryK1NlgTe60FopCHNR--C2gnowJDRUOqIYOB6wonzslI43JXJ19ymUfkNNDRKxxKqxunkokbW9fZAMTW2tcgLVY3XWAckYbou5dyDXSn9ghczksrUKkIBzSBlu7EaUvQeb5L5SujVKrtNAdrAuvtfJQldv37recEgReV6eu_7waKZOXxuyViwP31JJTV1bZHermyNqV8zX2agWdMIbpvpBfIRYCMaWrnDXL7yKmkgdl_EIfhxAFal6UX3GRfrAjPcxjeugLAz4iBGh1VK9TqQf08Bggh-jJPEWo9Tm92b_Y75hZ2O7GYPHoPM5M785Ic_aTUn6kPwHIdEwUrUD3H7iEH2FZlsq58NR8BfnP5ZAkNALUa5CChxjCNRQT7WUeNUeiM0D3q-IjfMollStztkPa187cJAoGnebbGSv2g1hryuFD8noeM73EZqRHSRM-OdOOrGKPN2RoVGHuTKxLmLG8DamAGpPgT7_2ukWcbVe2CP_ANR-ofEjlDwhDTgqRDye40wKfWDcJgaIfVoFuE6o_a4sdwIv14Pp0lhhl1c-qWf7CR02ZwoTJWcJbJfyc7g1ZBS3zbp0vCfkgE90RcZlqtyhFi2V4PzAG09p50bauVsKwl3=w713-h632-no";
                        video_path = "https://media.giphy.com/media/1zR9J5owQrRE7ILcpj/giphy.gif";
                        description = "-Piernas flex. espalda recta (inicio)\n-Subida a poner el cuerpo recto\n-Bajada controlada\n-Separación justa con la polea (inicio)";
                        muscle_zone = "glute";
                        hip_weight = "30/32.5/35/40/45";
                        res_weight ="27.5/30/32.5/35/40";
                        vol_weight = "32.5/35/40/45/50";
                        subclasses = "mayor";
                        break;
                    case 66:
                        name = "Maquina de Gluteos de Pie";
                        photo_path = "https://lh3.googleusercontent.com/nxCQEdYUpMlJS6tKp0NhtI7Zvz8EYQ685s8xk3Iw2mxju7dHSQgRUBZg1iPDBMm8fSnbHghkecHQ0PkDyKDkTgki8gu_5wq7NIeL4y_YOOx6-QN7sT4NZHrQLCSzQjk_ueur3B9QF7V0xwb8aC6PFxJyVMCYoD0tVQDSLGa-_a6XnqSDEoWyHEm1KtSKVoeHZR0mKMvR-Rwi3I9wTr4wlYmqnVKgguT-ya1WpJ7PFqvaDsJdcnEzMIbFRxE2t5zrbJzTz9q8agqv5DhIbpr12F3XnEffYSBmpy1TW6fvwjCkr7lrJygfDMO7nwdLpLNMqDzoQ1KrwXDFvZsbY41Es_-Pit_a2GweghFGyq-dquzcQZZrzZ1X8N5C-vgCPEGxcfS-L5DGx7alsV0Cj2-l-eWPErjiV9_WyDEojXn8A7qmW8C0mxZB7pnIGs6dBSMT7neScke5Mn3krPmP05zwYD4hrlB7dkOXLLP57bFp8JBFrWZgf4BF6iuCNx4gIIn3dtCm1mISq8tbx2ALOe-5fgaaStUMM_ruWtyMg7E681jiP1hRH-56lNJ21E4V1hRsoS3HbbRq3Z7R7i_NqVImtVad-aY9sloSMsvp8B1Nrqtw78-JXg8So-KA_PjMX7vcRml6uo-0LxnB-I1Rb-0r5NNmjyBkbvf8qamoBN_k_B464zaTzMcSyjnK=w713-h632-no";
                        video_path = "https://media.giphy.com/media/5vYnunLwmnPJAMFGwD/giphy.gif";
                        description = "-Amplitud de movimiento\n-Pierna estirada firme\n-La vuelta controlada\n-Sin balancearse\n-Se mueve la pierna solo";
                        muscle_zone = "glute";
                        hip_weight = "40/60/80/90/100";
                        res_weight ="30/40/60/80/90";
                        vol_weight = "50/70/90/100/120";
                        subclasses = "medio";
                        break;
                    case 67:
                        name = "Glute Bridge";
                        photo_path = "https://lh3.googleusercontent.com/_mmQkQgVeixqrX-M6RQ_DSZ4lPSns3-LcWlPC3RBjRoXZLbqo53b2jUpBtLx3qLvmEZdAjJZyLqtyaDOSMLXbuDQDzUVZb8bKYiP6ZeAb3M1FPTkedaDAEDBGAk_t7dYqd8dthI2mOYDpXgVC52vAOqZIQgW4xkv4mKWkM2B2bKPYShCegWuzEq5IrWKWZ1DFpV_suPgcdvdT73CSHqvhF5_AJJSOXKEhJulFCeLH7tXZuVIm090dQlyM2NZ5ZHVO04tf8lS1FMB31eDdZPHoGiZa6aKBvgCY7ra_Kgj8Q76BlRZsA3cvrorrXcX43H_RnhWv_VhzOneVE0Fs1nj1WzLFtjoRhS_5UWo3rGfgxgINJ6YiK6QxAXDYYxtbKb7zKU8MFvSnO_h8rXcsmGdU82yp8AD4D1K7wI5bstzJdb_CTSS9L2GgDmbCXsFvcvlng_3lufhegIu6PJgFiUBwGctzX84HmDM8if4Bxbwd2-UoL-k3q7Lt4UQWwSHcQmuEoUT89BZ8MvTBqHBPArW54qZWG0Rgg4ORt47iqLg2FVIULo7FvrmYRoLo6BBkiFFFP9dbo56mexpapoKBI2DbS2kuO9a31O3mwQ8gRjCLHv_dJB25RYKrc7I1uEodYvSmYs5IZeXMfCuVXZhiCN5u1gbrE7iGRc644_81lSFC2UJ8U84DhyfZLuT=w713-h632-no";
                        video_path = "https://media.giphy.com/media/7STqShwodzd1jGJD2w/giphy.gif";
                        description = "-Sentado suelo, espalda banco (coloco posición inicial)\n-Relajo en la bajada musculatura\n-Tenso musculatura en la subida\n-Marco las posiciones";
                        muscle_zone = "glute";
                        hip_weight = "10/20/30/40/50";
                        res_weight ="0/10/20/30/40";
                        vol_weight = "20/30/40/50/60";
                        subclasses = "mayor";
                        break;
                    case 68:
                        name = "Lunge con Pie Elevado";
                        photo_path = "https://lh3.googleusercontent.com/tCPjOq_6yOtez2rUZcJWz6qORzrkyqJfOyCR9MBnKySTzF1wj2Nf8a0V04pQUQGxB2LOmp6z5BTF141D7IFt2QmLMArU4iZPQmg24EX_oWUMfWTAWPxsMmsBRAK8AWmqo-YLuK7tyJFWEF8pjc2xPr2pCtugqYf0dBptUifm3EcSf4QKK2ezGIXTDIyDi1-zrxq3y_vmoZ9V4IN6MuQjNdWUZmXdlZZJTbH1HZ2XQ7DfId02g7JIz15Ny271tKU9xmvctVLwd6WYYbDu53jEc-Qsvh-LoiuK-Scpu3to0NpZ9eXBfOyKh9Oj8omfgGT4UXBWndO0IPlL6DAYHSVMrdnbJxaIv9udsQ9vOMaTint7IzRdfHXPWooPIALX8qI1tiGzIY3opRpSLdTVO77LgUqMgq_0Vqfs0vJQix0eVS7WmVyveMP9QCdNNfGD4k4N39e8impQYk7j9dzItgoOz9MOMI5gYxsbjRF4wmkaIXmyHuzQq4s9os0_8rZfTKdqyZhwagtwozawI1pAxWDx5OzoVuZcQLLTIsZqJIiqwE5uOmf5V4jkh1vTSNj9tprhy1d7AqSwJ1QIXajo0ESIEHjjpNO4h8-_kAg7dcwB7PPgZ9lh2ZlHYTrNlixq8doJRuAMFAIMr11RcwxHgxPngD5JpRhq8bnKqRg7_j0fAVLx3QHr5dxwHyZk=w713-h632-no";
                        video_path = "https://media.giphy.com/media/QK453tJLZ9DKgJPd2Y/giphy.gif";
                        description = "-Rodilla no adelanta punta de pies\n-Rodilla de atrás casi a tocar el suelo\n-Cuerpo perpendicular al suelo\n-Espalda recta no balanceo";
                        muscle_zone = "glute";
                        hip_weight = "12/16/20/24/32";
                        res_weight ="8/12/16/20/28";
                        vol_weight = "16/20/24/28/36";
                        subclasses = "mayor";
                        break;
                    case 69:
                        name = "Floor Glute Bridge";
                        photo_path = "https://lh3.googleusercontent.com/TuiNKsgpG9dl-xwFC9IkMPDGsKkCO-6UXnfquLNBbNsxdUIAeu6Z5RlZZpqOLhi6GhQxcyjHaQyT0ln-jglztpGrCjG7hzYUlT4qT1dmM81sGfRxW9VPbkimif5JdJSvHD4qobXVDEw-jXcTFNpqfm7dgygUFPyDvOiKbMKY6xJALgKxlQFgEyV-7Ue_XsNPIf4n1Lfwe4SSvzpUDeii_IOQgi7s91Gycj7UkTnsJzHQKP2HwO5n54HVPjmEPLkHoEKBDIsPPwhFAlK3KUhFVObhFqTtbHut9ZAWf43hFb1uz9moxFn6woh4GCvOkGNgEglvOU5DnyeyJJOlgjz5DaEKWaiJJ3OgSRMsnfgIhFsqJtw0l5obLKRh75iUkFsSOuXnKT9BCbue8A8onQzTSqIrRAJYbiu5vjSys7RH58zQO4Vy1rwvX6Gq8MNwDcwHBDid2pOHznW6Hw-9EFZ1dWSRhCWj7xd5roZLHBuvWSS1WtrJFXIjv9VXn4BR0NPQsW5UTXX1wMutGxbLUX8SnTEB_kv30YxgF9FHtJKjA8PIFIMJ6QH_Am-OIwptMM6Usc0TN-eNIh4ufTHu_0vGcNzfcikUvPRYhcxYg9sEdIPNFo6Cp7xJf6ejWi5RLIMp-rYchJk5tsQDtMeg0pYvXNKUmlCQiTdUticzN-W5v-2JAQMTkS2lG8tT=w713-h632-no";
                        video_path = "https://media.giphy.com/media/5ndmzORKczTEPqlJ2V/giphy.gif";
                        description = "-Tenso músculos en la subida\n-Relajo músculos en la bajada\n-Marco las posiciones\n-Movimientos controlados";
                        muscle_zone = "glute";
                        hip_weight = "5/10/20/30/40";
                        res_weight ="0/5/10/20/30";
                        vol_weight = "10/20/30/40/50";
                        subclasses = "mayor";
                        break;
                    case 70:
                        name = "Lunge Lateral";
                        photo_path = "https://lh3.googleusercontent.com/dG0Jn_viCiEpk3Z0G3BdxbIYBPmDhof12Q2Va_lPW4JF45y9FwN_JrDzxph7SXmnl82_qflILb5VeogMdUw2BETC2Nm4ObJSxjthj37gLy3QRCjBJ_LpeZrxVM7stgjHC5wLO5X0fvaOVqKJT6eFA3XSnkHFopsqcVNlS_r1OseNDGev_McWLa0HpWrWyCAGIXEMUwMcr2d7gDrBjyUUiL9--te1tCdxeg5Yyf5vRi51rIwzyb2LWHiS6HdIj5AA5i7pXsvr6hqejhdGPVQgaPPiEYfAUANcP3f0R3__MLhZg2ADX7gxWTSB2bwnv5rsRIiEC_fZFHTluFppUSP67lgBCaA0d2sv0i6y3EOJESQhWzmSvFac7GpB8QUg66Nlq4fwhQbGrjE3esU3elEWWOC0Deaf76_XUY3yLuxaAsr2KVsrf8xjNyGK0Tjf4Iw7haccTAyQ-a5TwPJoI_KRPCbicQ0E_m0DUeWQuy6yqTk6zm-0ubFhyw05N6zI_datvR6mcsbgtoEXqthRjJht7JU8s3GRaRJmKY2ZbTTVpDJ2u9QTBHxsKOHqmeLUWa4R_v08n4Pc08UKIq31M3SP-uJ3EwqOwT6sGY5Hb534KF_ldCdNqkfAuBOwlaIYJm--qKj4nazU9X0U5YofwF9Vr5L03GLRTOUtrZORQMs2CybzyVoPboKd890=w1062-h944-no";
                        video_path = "https://media.giphy.com/media/RN31a6hZh0WD5GpQzf/giphy.gif";
                        description = "-Rodilla altura del pie (no sobrepasa)\n-Bajo cadera\n-Espalda recta, saco culo\n-Movimiento controlado, equilibrio\n-Pierna interior estirada";
                        muscle_zone = "glute";
                        hip_weight = "8/10/12/14/18";
                        res_weight ="6/8/10/12/16";
                        vol_weight = "10/12/14/16/20";
                        subclasses = "medio";
                        break;
                    case 71:
                        name = "Lunge Diagonal";
                        photo_path = "https://lh3.googleusercontent.com/7YpFnWIAcqybHsFzyJ8FB2opFaPdXc9kSCw4M8mOw6ttKbsgSj0vYremRd-MokKSy8X1tLdVHizj_lX7fS915myoPWjx1kpMZLGYbFq8TMzwNTGdvtn_JVRHEknw_CJIRZoK_n3au1tlh4a73HUXpLMQH5_dGJb_DRdk-NMrT5oHgapQe2KNMHaLxGbR3HPgAoQkmQNTFGOrkR32Ty3I5-lilD664qqbv8u2p_kv2q7oClstQi03fILhp1xj32SFmAjrBeRwxGnUG7clZq8LEcxyE83KfbuI8rFhP7SmMsPvGYayQnF5tyxjeOgUcpcFzLsm9ikZORYK7zMuCaO-MkKkVriirB3eIbZY31uoDz3b1jUHG_B03stRa8rLaIGMcAVy3Ldl1WLG3c7hCRZlKxCE6IXrOEVTxxaaQ2sFupmeq0CNrTS-dlWbwsyhAu50PLfquT_c7B61zslOcWsSit_NOuLkjwZNdABr5DwZAQDSK9IerBqkiPsdG9KDqSiDxDBnlIDQPoYPfzxMejMzH60l7ePHmqXEeum3MPOFrtuhAHv3Vg6JRnEldtxN8KLrK0tinyQCj2F6qfhGXOQZttzBtdr3qdaHH50DAZHmXivjoyLN4fBRtX478rVITbntsGaeETYTCkqEU0ZrlMiN6fl-f1eBPqg8W0YmeJ09Y-encjXxrfYZj9o=w1062-h944-no";
                        video_path = "https://media.giphy.com/media/S590pg58gwRuNNyj2C/giphy.gif";
                        description = "-Paso diagonal cruzado\n-Rodilla trasera casi toca suelo\n-Rodilla delantera no adelanta pie\n-Giro hacia exterior el tronco\n-Movimiento controlado";
                        muscle_zone = "glute";
                        hip_weight = "8/10/12/14/18";
                        res_weight ="6/8/10/12/16";
                        vol_weight = "10/12/14/16/20";
                        subclasses = "menor";
                        break;
                    case 72:
                        name = "Dominada";
                        photo_path = "https://lh3.googleusercontent.com/J0Pqg-Q8nwTDsH9F8G_hOgbJDwwyTATEL5eJjaCq-CZ61vSoUTkayXnYmYgrswq01fycKpHlae_WKckKMtv2R0DBSn8AU-tr89FE33hPjVI0avfk2ZvNUsClYlzEvque2i6VB1ZL4mhe1PkEKUAV_fwHoVslXWQ0FN5z0dSgnJX5S5BboEfp-0yfwK_gufVGZX0rrAaaVTAYBKDLdCl4RANVEMTANYUS2Qu-4BgUR2GBm7yBKpMB17vQgOfeWNDF4rMyC0uKLBinP2IbmWobqj8ttpPSM0-SPLcxcJ3bEBUT9ado4AZKf_O1W_uW2J0m2vGjkdfT-pD_QIsq8EQEjaLH_XfvFCiH5mVKZIS5aM9ipaV9p5t_dXjELnIAFk7MGVjbrac5lVDMZwkNfPjrW1H_x2JllhR_9FbF5CiRfX9-Q02E9qOAQ5__ik_aBrbrk53VmekDtpt6Ro0toJA5214WsU7JfKuCs_r_LHnzNo7mdTH4-Gr3tmyXYQWi-F-fwPY4xXorGRajVYZbrXMi7AWNM7U2eAl9cqWWX7f6CvDviIbpjZkFODyKM_Jiymk0UIYHCv4ssnT0Qo7HK6VjyZTBKEaOE6DOk2HJgKeN5Hs36hYn1mxx5NlYllc0nwx764fizhcxnIbBrrpvO914F2JdJalRsqxvg05bChfkTaEjMX2EcPsvPC0=w1062-h944-no";
                        video_path = "https://media.giphy.com/media/Yochk6afxtXIRqeJzg/giphy.gif";
                        description = "-Movimiento completo, no balancearse\n-Agarre prono\n-Hombro 90º codo 90º (aprox.)\n-Subida pecho hasta casi tocar barra\n-Peso con lastre";
                        muscle_zone = "mid-back";
                        level = "hard";
                        hip_weight = "-/-/0/2/4";
                        res_weight ="-/-/-/-/-";
                        vol_weight = "-/-/2/4/6";
                        break;
                    case 73:
                        name = "Polea Trasnuca";
                        photo_path = "https://lh3.googleusercontent.com/6Ktr37JQ1QUw1MPxDDIhiH_L2uz_8E7ziYzUjoKhzgeeNv7PvtmevoXp-m1ANd0Phcv6cYj_Nk4MMoUdlpZZMObX-rfy39auFZaNiUjgCFVIUjcaP-w3PWT-IytzPqgShkZIj71YyAN30CBa596EBm6nZB_A_IXOM1Fz_gMf4ZS6h4Q1BOwcUsMjwyslLRVJ0o_s_Oda1_oOWYnaepHQrQm1_864W_Lw3tSxsY_L5D0xUm8CPazROMB5X2HnZv8GPB6vp3YwFE58ZIPt2aAaBfZuwu6bWHEjEFb460kFDDw23CWm30ddsL7mFWbeD7knCyYagK0MLACUiEnUY4N6994fJDy-TOzkHSa79C5ZJUlU4eb3kduWzrczFD31HDm-yZ_0Ou1HKsophdNd7PYKbExkPcceGkhoJgVAbZLhuCiCj4TdNomHBX_TmrNo6eI9KIBE6PNe5yIunpYWc0hfsXAkUmY06mim9mqu0mwvRhW95rryjaLRHGxDEQf0PW-6caxSSBez5MOORnetdLZBRC0_W8euBFObAj8sRz-rMRQyRJCWQhVrUsiEz86A3GdoFS1qn5jvY-srGkhEZKFYefPRmA2GZ_g-9HEwmY4zzp6j-p1B6xSavcdR-rZCO8hifVQQX2m4AGkzZV7zRbH9rVnjjakhYhhC4m41rtv1tfIy6dijndfEKXn3=w713-h632-no";
                        video_path = "https://media.giphy.com/media/14dYwJxgFhF3RyN4Yr/giphy.gif";
                        description = "-Espalda recta, pies fijos\n-Cabeza inclinada hacia delante\n-Bajada lo más cerca de la nuca posible\n-Si dolor de hombros cambio ejercicio";
                        muscle_zone = "mid-back";
                        hip_weight = "30/35/40/45/50";
                        res_weight ="25/30/35/40/45";
                        vol_weight = "35/40/45/50/55";
                        break;
                    case 74:
                        name = "Remo en Polea";
                        photo_path = "https://lh3.googleusercontent.com/zHBfcDC0GazTt3fNb2Ll4oSJopg1usJsnipYNLV-GwjCeh1AeYj9ZvUbdFFaoUAsTE9i8g2R8lTTzeOpCwlniY9U2J31WUrVmOACxHscJkmDwo7ZCWGbptsLReyBhDbJKhyMBcjvu8Xw6roZMzgS6NaodauG96jiKC81-zal3Rg9I3soDNavt2EW0A71n-5NOPi9LXWiyWjodFVqfj3S4G8dbZ6HxD9RbnyyHx5Drw7-XBRS6wwF25jlytnFgN22cK75pEbbrczCD5Ss8u7q51gPvxVEoDIek1VK6pKsq4kFDEhtroFOQA-BoP_yy2fcQy3RH9wUYsza3qyTrV6hfbsOkWf0Qd64dlIsVbRPkJWSLIFkChOsjtA6BqI8X184hbdFvD0qAI1I8tO0PoBRMhTbtsUJkzVbj1djc7cjQ0Y1Z1qcPFG5NGFAZ4bv1NkIdLIdEy3XqSjpAqnOyN9no2dGIFEt1QhNRCvjue9-cS-qBQpoq3896ECTHqtpKbgrcJhdKj2k-2INwS8ouGh76FsXRoa9hmQh2dzACogW3L9lvcrgM8YLDMWa64kWfLIX-Uf5bErIK3pEixhEy7x0dFRI3pPqO8Nx8sRfouLGoZsY7kjatImU-4lD6qFPy2MitX9DQe0w6Ei9fx6vWFI6YaGEos1pDl-s_dfMmNaYCNSVc6DvMwvey9hV=w713-h632-no";
                        video_path = "https://media.giphy.com/media/g4G2FNwvCivbwQ05D4/giphy.gif";
                        description = "-Cuerpo fijo, espalda diagonal recta\n-Se mueven solo los brazos\n-Codos junto al cuerpo\n-Amplitud de movimiento\n-Cuerpo rígido, no va adelante-atrás";
                        muscle_zone = "mid-back";
                        hip_weight = "30/35/40/45/50";
                        res_weight ="25/30/35/40/45";
                        vol_weight = "35/40/45/50/55";
                        break;
                    case 75:
                        name = "V Bar Pulldown";
                        photo_path = "https://lh3.googleusercontent.com/jIhuOFymT9R7lMgWqStM1PZi3vl30BWi5Ud36HQDpUi8vMyeN9dxfx09_5nTzlsXAgi5VoGFA9M8IUcP6Vt8J07HXYIFVSfscZ5bA-riFoPX7AOJ5CdpQmepqayYrt4D9hoss8pK9OksSg0O-vhx8DkDDSSpyxQTSlSf1ccXHVfd7ZshxfP6SUcaZNt82q0qUWqIlZlZV35GFzJsrVdkAmUeE1poZiif9_ALjDenqmHtciO73_9cFcJhpEmcWLnzIuaxnaJmxrATmRNMrNVx1N8A1n29m5KJLpRbt01PGZvm37S-4xAtN0N_dtGbqqQ1jd1V3ymsI8FedjGfkENNmYZdYuOFzTEo4CyoS5Z_Q1F9wPmEMZSpmNIwFrhdeCK4yNKh6VM8geDRvwbBJIVVu9nYFkdxj9O_2SoYoP0XAGuvOhJbATSKVDhwLpPiI4l7fYSVQe5QRPXO_s8dGtDRgiqEPvZtDjpx7sNg-01lvqkftmukbqVWdtOvHND-4HTQlymES2Bs9dpeKIGtu9CGgvQkdV_gZLDMrQZN9qd_utkxMCX2OHtKAyxU-bptiE9mga2upmcG7mPDKZXsDj07TtzIgmnrsDymmrIo93cuLM_THKubYSjFjfw-6TVCk_Cpk7l5nZXtPSvtHs1GEaEcPZ28fIoR5D8Ioghl53UabLuXPk4-JWav_5M_=w713-h632-no";
                        video_path = "https://media.giphy.com/media/8UGF8X9kYZ30d34VQ9/giphy.gif";
                        description = "-Traer polea al pecho\n-Codos junto al cuerpo\n-Recorrido completo\n-Cuerpo fijo, no se balancea\n-Espalda recta (diagonal), pies fijos";
                        muscle_zone = "mid-back";
                        hip_weight = "30/35/40/45/50";
                        res_weight ="25/30/35/40/45";
                        vol_weight = "35/40/45/50/55";
                        break;
                    case 76:
                        name = "Remo invertido";
                        photo_path = "https://lh3.googleusercontent.com/2EtJUuPGRhc2sMDk2bJSiFMA0Ynb3y_jBMak7qLhzg9UNb81MywePcTFdlc3eTtkmkum_UgfED1ELz2Iaf8nQNxRfzdePLHfoMGp5LC30EqvJft3b7LGn-51-LtU-ogCIfmuqOeAdrtCFlXDv236smEz8gc5c51XuDQDjSdAt9Dd_XDVgdsTDysYMWXTmpgSgVyuGGW51H-67zdNHbxwmVh2XxVJRGmuHlQ1_94qYKeKsG3fACRV0QZbCsKpIUF6nLNCTnrR20NzlwiqE0MVLGCDM_XCsNYV6HRb0Kx9u4zB8mpFDCehUwl4StYCRbrp1Cn_KQ38LAUj8PF6yIFYrSiwaS5FDGOWaia-LVKifDsHvXpGfGSeoiZTL--qxW1H2Wn26V9yUEfm7zxu5S5OXeC4-0AhmBn0tL-f6ZRj8Ue2m5psN0mx1TKWcVe-aWiFWY3-oMrKPOvrn2103xmLTQUaxQAE-LVEZot7x7NR_2hwrsnh2t5Vlynu8cYkKCLaSoTty6V-20KvJSdqT1fV67o71IA5tkzyhRevmyp-VqTy9MDnWjWxuiY1mi7pqGw-mw8pCd1UDEJtkKi4fqmW13vDfa48jJRDWUl07AQH1YHAxj7jeU1lIDV20wPAoR3tODPMpjrKTDgTiX_oflwfSw87PAgDSdoki1O0p6IgUUUJsUzg50zabtI=w1062-h944-no";
                        video_path = "https://media.giphy.com/media/VaqDvJN3csUrlzgJqy/giphy.gif";
                        description = "-Agarre supino (al revés de la foto)\n-Codos junto cuerpo, manos en línea\n-Cuerpo bloqueado, fuerza de brazos\n-Amplitud de movimiento (sin forzar)\n-Peso: disco en pecho";
                        muscle_zone = "mid-back";
                        level = "hard";
                        hip_weight = "0/0/0/0/5";
                        res_weight ="0/0/0/0/0";
                        vol_weight = "0/0/0/5/10";
                        break;
                    case 77:
                        name = "Maquina de remo";
                        photo_path = "https://lh3.googleusercontent.com/Lz8EF9TMHtpX0JjN8qxVUClUeT54WkE-a_RQz9AkwbM5lvXIEUx-i0iFa6FvTn9vXeLp6e4HCYxqkGGTvBVzRTZ9LqxLy8yhleuW7IkZBvybkwZxdFrf3vnVYihnoqfQD1FqyViJT2bf6z0TMjWcShYJEkmJwI_YOz6FEML5h_l8hd3-qzr9y0ISvsJ7lz-YnQPJuZGO3PYgdEAxWmvGSA393KQkr334WEZReG1N2Im2JGJa70Rj94aItzt9mEgU59O5Fr3tJUU53yE03KxJeq5cRlnQnqtxzFuntdtTbzc1xCJgP82WQjY6H75Xja3QrQTOdrO-aqlD6im_sBQrKLJQcbLG-NrQcbZUkuwKIx_R37hpymZ8jdjwZ1jwwgbp2l7T314NvzpGwXHMrSDsEfGcIwvj4ry-CUPfpkeQXyKezmnMpYQjYI4JbCR11EFR1cGpbD8FfwA7IUIjDcNhzI_DsAcLuDoKp_g5t3IPbPaxjT_QaT3ua5YmehDKe8tD039ir9zu15bvRY7U21OwSO_tH_WrQtF0mGI_r7iHRuO42LHj3PL-JPo2cmrL0-2dexkQWuav0Dqp8NLiLTbFgSUt-8F4ASi3OgJX8MIDQ0gbanVbHerDF52OZEwQDojp9Mx1RMoak85q31Tl_6iSrqB9Crc9zFmXpK-4uh5sfZ0DWG_Ke69tLR0=w1062-h944-no";
                        video_path = "https://media.giphy.com/media/fr4HoxDhvjaif4oRKg/giphy.gif";
                        description = "-Espalda recta, pies fijos\n-Sillín posición cómoda\n-Codos posición natural\n-Cuerpo rígido, se mueven brazos\n-Hacer el movimiento completo";
                        muscle_zone = "mid-back";
                        hip_weight = "45/55/60/65/75";
                        res_weight ="40/50/55/60/70";
                        vol_weight = "50/60/65/70/80";
                        break;
                    case 78:
                        name = "Superman";
                        photo_path = "https://lh3.googleusercontent.com/5pHMWknNPCsT8VXxxt2lUagod-oyP2D1rqzIg_cxjSTObU6WTJziEqoxEBOmxG8pOrzGJfMtVQ6jCwsb2eJdWJOdX24LJkoXQfjCU1HftAYeeYDsJex5nnM5tLv5qwWH18IfCefoqIbSXW8QgbyZqlxb-HjjIJp9FdKE0UeRZOazVrE1VmUgR0SiCNMIm8Ix9DGp2W2nn-rj0GEwaPKBIzNihUGB96HTh1tUX2EaHrNKk3gJObrG72COjFfrHfqcxRPvvQOdfBS0wEHS71p3eJqq6Z_YeT2p6Sd_XkZST948utUddz2d5zo2q9dyGVib1Bry2QKEpsiP1L9dAGNCK6wREYndvVKeeEQKH15oOwOavKhtbf_HgD4kIlfwCBms_CBELnVZkny4Bcps3jPif_K3ovehMMKJ8UWxPXPFvvZHazYVCvrBX6XrWYC805dbwvVgEWjnFK2M4_ZnPVSL6IIc7n-i7DgNO_sXK_Jl863Mq4dGrCFQeBZuZvIexysdJzCsI2_roDuyTizaPxaB4QK84fzLM1y9Vz_FknUf1jiqgL_cJJTsdv2jvab88XuCeEsL9OfVQyvtOFBvWiBjtv6QVFJw_l7zRZWDcXHrt7-JCx_RuEbSrb6DT7gcthdsphspGOot32aFJ7tTXzY72di5nho0544MCQiTnsJF3TM0W52zs-8hAwwd=w698-h632-no";
                        video_path = "https://media.giphy.com/media/7zleKmCCBYdZ8xsMIg/giphy.gif";
                        description = "-Espalda recta\n-Movimiento controlado\n-Equilibrio, sincronizado\n-Amplitud de movimiento(sin dolor)\n-Peso: mancuerna/disco + lastre";
                        muscle_zone = "lumbar";
                        hip_weight = "0/2.5+1/5+2/6+3/8+4";
                        res_weight ="0/0/2.5+1/5+2/6+3";
                        vol_weight = "2.5+1/5+2/6+3/8+4/10+6";
                        subclasses = "normal";
                        break;
                    case 79:
                        name = "Maquina Lumbar";
                        photo_path = "https://lh3.googleusercontent.com/Qs13vEIezR-Tqgih4aUJeqoRKZRCRQIP06LUCTf9VWPNRef_mfJNETMm-bG1dvk3RBx4m4FzpQsacv-9WsE9dfv_6LUzvGmPZMC2_B1jKWqSZrK1huOKCSs_gCj5PQA2Cxzch11PllL0nocPYKEym6_kpG03O_3VfgE_35cANKO3fiq7ygzUvwFsljXBZu1P6HMYOwG1CZMTYwYoDupsd2zsT2VQvjWeOpqKmfc2CojKRDSjDg7sj7AUCJDuKV_Kf7zjqdi6wk7QbrDgt4BLhmtXsEuNNKzn9Rz4s127FKrxChv48VOMkcXgqN944iRB2rD0fbWTRdd2jNJO9Huc05_DuY9zWbXpNrNVuAtgMw7NOiMgLYuLp1O8phcU-2Aig9XtMYwE88sbnZJ8ZC9kGEX_QJp7N7PD8WjYCE1TRi4hhrcDNv1YUuzQWvVbOQZqt7YBRGKzBw4m4Rz7Hq9UEjbLkOly7HSW7OOzD61oe7SStxt-Rg_Gy2yzGj5U5oCj5j9oS7X70YwQxFWLl0isUjXavtnRwosppy5gMY9rVxHDSp5mptBNLfWI32LI-gRNMR_hXZoEDyZQrj6t3rXnM_-SZBcAFPdioLFJbHsa4fu3ZTmFooDezJCGLIZI2nH7OhfZeW3hXioCdgLZ-r1B8IBU_WbAfbSobek6r9xR8c76cn1bhdIRNPAT=w713-h632-no";
                        video_path = "https://media.giphy.com/media/MuGiDdMwNggHrWh3I0/giphy.gif";
                        description = "-No sobrepasar los 180º\n-Piernas bloqueadas\n-Control de movimiento\n-Bloqueo progresivo espalda (subida)\n-Relajación progresiva espalda (bajada)";
                        muscle_zone = "lumbar";
                        hip_weight = "5/10/15/20/25";
                        res_weight ="0/5/10/15/20";
                        vol_weight = "10/15/20/25/30";
                        subclasses = "normal";
                        break;
                    case 80:
                        name = "Maquina Lumbar Lateral";
                        photo_path = "https://lh3.googleusercontent.com/x67KcJCT_2BUbxA7IZ-aqrH_QaDfXfGZBuBLdxlcbQIiE_HUFD2XKDnGScwXo3EL8isJQElCu2vkmfz49_dDvfrhdrIk7aILCTYotiWadjMtQt7fUha3yT-mkgpBZURh1-aQ8MpYaa1ycu3PVezfawTjx3Tnfbjq_n3jF9LYsFPDMc2f6Zd0Ovo14CcdG-wrNC6FJocB56Lmp2oGPvqZTZJqAcCFCPnj_o--JZpXje9VlrGx1MlHsWclUonE4TatgX7WQFbynp07T-W0_5FVdcFbDFQ0W0u0Qgi-Of4FUfCb5W1fShJjYW3RKnKvRTMYB0pw9OVBlE54SMz8WZGiZ02Ygj-Lurz2ixYTSVMG8dzJRUVzh8RWQJz9H4DTs7ZKEFPoPGF6gIB6sePrPxPoiw_svFB_2WXcP-F8jkboYFLYNtYm9Cv-4jfkvPBQnK6f40jw0IggJ7Sl8fU6FhkcOahgQ2qtwD_K9QTgmslc8gMFaJGORnGJ0p-Tk2O-jvSSWHRMNA_177CydIhH7vi3UcJX8N6bYofWki-7b9m1ULHO6kRmO5rPpmY961j-kAgzj1ODtut7z8WTu4CjGXxgeU_eSruUMOe8Z4pRVK7CcSIM0VRmUdyF8IZeetug3GG3S7eEa84syoYnoYYrp_Ev_g7e34cDpEf_pCvqYVP_fG5dhwbtmvGUkZg=w1062-h944-no";
                        video_path = "https://media.giphy.com/media/ZeLmHoN21qk8epHyjj/giphy.gif";
                        description = "-Pie interior adelantado\n-Inicio a 180º\n-Movimiento controlado y progresivo\n-Piernas bloqueadas\n-Subida amplia sin forzar";
                        muscle_zone = "lumbar";
                        hip_weight = "2.5/5/10/15/20";
                        res_weight ="0/2.5/5/10/15";
                        vol_weight = "5/10/15/20/25";
                        subclasses = "lateral";
                        break;
                    case 81:
                        name = "Peso Muerto";
                        photo_path = "https://lh3.googleusercontent.com/uuzJKde-15HfNutvS4XLoB0mTva5botmAkZPwRgKKMuB98TqAxBOcBV-1lAfd-DB9DuTUQ5BAp8QZ8Fdm62jXPLs7GzSMxU8Ao9bjBN-9F1WmsxCUkuKjHjlvppTNSoTWkeJ_MGSVBVRpHbA8ybW6MhhCq3XBvMG2GXib94JoZa1ETYwmjjbRfgHfwm3-U_hvjzUFzgpaVOswlYbSnI-onCiKMrlsE0z_DCUsQ8clpvZtXHfI6ZhtgIkILCLQE9lZZ7h-y20UklLWE_cQAQWMidjsDMzwOAzDHayoLcAlvrga71xgKPC1F19eM3nY23nFS1AgdKogZAgfsNBAFRmkgHwperh4d9OWlSIsiFg8z3XIFyMdOBHanNuHABlc4Urx1w0Z1YtT5WiPl0ltAonscBRXtmDAX5fO8fxqPJuvMGE35GKpbxjnK5L49qXRDpeP6XBvbOo5KsXO5mtFBx2Suk-JZscKc0EguQxcQ3uHwkstb-BcrrM6idhG2TKFTsfLL2jOpYQPZH5kPfLcnB3DVliRfYvyyC61xcvnVRYXM-PEB_WZozuaHeHPPiRwMWCiG7xxJZ9UWDgDRELSn7LOrjT4Ly8CtPcSltz0EtGjJJR_NWPHoRpdDmDxS6ju9z4gj236OmIFW-OG2L2dj4qLwNFyHAw5T9NUHFCYzssjKfUb5tBMsVikhDC=w713-h632-no";
                        video_path = "https://media.giphy.com/media/25HwgnJ41KyOcmyRBC/giphy.gif";
                        description = "-Piernas a la altura de los hombros\n-Rodillas no adelantan a pies\n-Bajada flexionando levemente piernas\n-Espalda recta saco culo y pecho\n-Casi a tocar el suelo, controlado";
                        muscle_zone = "lumbar";
                        hip_weight = "22/28/32.5/37.5/42.5";
                        res_weight ="18/24/28/32.5/37.5";
                        vol_weight = "24/32.5/37.5/42.5/47.5";
                        subclasses = "normal";
                        break;
                    case 82:
                        name = "Lumbares en Fitball";
                        photo_path = "https://lh3.googleusercontent.com/GkAyt3IGhDIZQGtGYGdMNU3K3YvcQA-1LUP63UcU5-wNjFKhDXPMVLqQULAR7iC4gPaeiwXdbScDGxSjq0EIb-eMwZ0jamZY_zdBU4FV3AZNxcEu2uwu3uagG-cBa7vJmD1KtbugwPyWa8HwXwtiQXf3tu2HkvAa5IyfSnHkMNyCvQ8-Z7UTA5rrRq7fjI7zUcHoGQn0CEm2v6R17USvIw23Yj5AhN9nVq_E9Fz7Sve3RkKWxd3AYEzdrjsb7c1Ja7q6d8b9Fl47mnwHvYNSpEiryeX4VpFUB4aQJ1cOCqssDWGYZ7nlDOPoqPLpS0GM3tFQLP90A26-oodH2o8XNHPM--ZCIFv70fQVvsItwyeCtnyVBAbMDJA48ZnDz6H5isBnUNRg4mS2zMRlGL0QeoIW0MCow5tg1Dekn43yB6YdFAcKbq-3UrX7RCwALhoW0lWaUSoI-0pjygn3GoCDXAoLlIlgB0n30pgYAdlzeTkJ_V0oswJe_yoc-0FbzbZe6HoMSEJ54VQf1ihNtaQ2kMu0KDjh6bcdVvn46rcQUyNvRC9eBDRPiLYuO9bf-x5hzV1vJoP6-JohI7vqYxdd6mJnygpiWiBOVOhxXLVZlMrzZSmkeN9Jv-AYuwAkvL5rlqKdxk--16yi5E8frNKmd5pj_ziaiVw9mqdpMm4NFkChrMC-S5PfCrK1=w713-h632-no";
                        video_path = "https://media.giphy.com/media/9VtKUOcglQisehyfuw/giphy.gif";
                        description = "-Cadera cómoda en fitball\n-Extensiones de espalda\n-Evitar balanceos y desequilibrios\n-Cuerpo de relajado a bloqueado\n-Peso corebag, apoyo pies espaldera";
                        muscle_zone = "lumbar";
                        hip_weight = "3/5/10/15/20";
                        res_weight ="0/3/5/10/15";
                        vol_weight = "5/10/15/20/25";
                        subclasses = "normal";
                        break;
                    case 83:
                        name = "Rotaciones Polea Rodillas";
                        photo_path = "https://lh3.googleusercontent.com/S1uKOLs5BNZFdj1ROaLy6MajBPwT5OXgjJ0zs0Pqc8S9MfGqKUiX7N22MY2wNupX0oDUrrREd_Jp47T6p4PAqifhDCzOkav2tVE8pj8McuVc2NSXnWMzoSZdGAzxyT9QejXXovHM1Uocb0FZ7wHKOcAH0XNXEGt1dTxLGvz-N8mHLd3Jnt6I5RpKnxSTeKjXmEHzmLNo0dpsDZypRmhzqW6NIZKXonyCXoPZ_8vD8oIKDjy4Q7Ail4_25HD6uPMz6IJolWytYE6phWAin-j6S-B02xQhIbG9RG2YLKLUA7vLRY9hd3xbRYuZvM1C2ZRP90vj85lKzQ-ZzYzGQSB0z98o0gkyD-QEL9AD76uDzjVc0RzpyQPp4e209V-1BadY1yg8WcK8Wqe8uPWTgo3wbFeNYKrgTKdkAbsYgqRz15v6XM_2esZh4ZsRJNpP4irTcG_ggvAKiqFq9fycEqJMs2RhM_HeOokGovDWWza4uSnOzQYjeK2lyaWvWrWcAKCGw5-fdqtgFpYibit_L6f_koPM4Ccg9IjMdqpg50LA-Ey70yGU0noPoR1JdFU3I36X8Lw-ds7mDloYWahJE2gMB81fJB9qWR304H838a0p5UYuMmwqLvGNPMAyqaiu_ydH05fVbEb0Y7GaqWSwBCu-O5xVOf4avpxhXoevNFDI782PbBXlAHCk0qw-=w713-h632-no";
                        video_path = "https://media.giphy.com/media/25aD3zUdkM8ayNOECi/giphy.gif";
                        description = "-Brazos estirados bloqueados\n-Espalda recta firme\n-Fuerza viene de abajo a arriba\n-Cuerpo acompaña el movimiento (tenso)\n-Bajada controlada";
                        muscle_zone = "lumbar";
                        hip_weight = "12.5/15/17.5/20/25";
                        res_weight ="10/12.5/15/17.5/20";
                        vol_weight = "15/17.5/20/25/30";
                        subclasses = "lateral";
                        break;
                    case 84:
                        name = "Maquina de Aductores";
                        photo_path = "https://lh3.googleusercontent.com/5_TQEcAB1W50KQs6XDoc7GhTZDZ0_ILTFF2pCJNJUJnTeuywlWf8h3nvCeboaN7GqkzwVnezYZ980UNZ9JbpvcKc7z7rk8FH5h_vJPYKAZlrBRqOPAoh0vWcTo8sXAVnBF0KeM3iDTbYKIpe5JE_JyAaT7gz0T5CCL-a9Q1lCshHqRDnSeyBcjXqlVmulVf1L0jugU9FlHkz7rxFxFZSc4crDnqNiya7Y2ukTHGy_cYMNVni87skNVd-mRuWU2XYl43fUd-DYeW7qi6CqDn8n0SbBsDLMcRHz148pBOiQ8OSmvLl_wBusYoY7rpCte7t5jUlOW0I53eO7y28ucw4LV4ikG84qEaw6NYuO18sdQfB2MxPGR4w4LECxFvPE2QpBdss60B1MCB6eutd3V2RmgKobTv8yJfLaPmijPPpswLAc9UgTPOJ2n2xFZ-Xjscmwj6bE30S316soVTUMLPR9DnI6Wic8-a4spMq6tG6orGG75dsIjQ86RXC9ARCe7r3wiSIp28G6nCGEpJA01ru7pUv3JDLkOWu7Jv1b9QPLoL5LqgmBcMza1evkML4w76lU1Ii8-E9OJOURHTnPowqSX4a22NCNoNPC8FXlbgOQ4iMr9hr5qU72uxVkx8ROk87T49kRQ738EDkGTJYPNP6XDt-U2H9n8gz-c5M0jZ8PIVV6I29jiR8GrYS=w713-h632-no";
                        video_path = "https://media.giphy.com/media/YlwnXWMvALBYgBe9eJ/giphy.gif";
                        description = "-Movimiento controlado\n-Movimiento piernas, cuerpo de soporte\n-Amplitud de movimiento\n-Ajustar sillín\n-La vuelta controlada";
                        muscle_zone = "thigh";
                        hip_weight = "40/50/55/60/70";
                        res_weight ="35/45/50/55/65";
                        vol_weight = "45/55/60/65/75";
                        subclasses = "local";
                        break;
                    case 85:
                        name = "Press de Piernas";
                        photo_path = "https://lh3.googleusercontent.com/1qru1ov82MrESffx2Nl3BmJYSOQxInZMDrNdPfLO4aGXty_9mvWdEc4SAUjaww5zhLAe-ppzt7R3uv6zs4aZ13uKbyphO_qGvh6USuxkOA0a0g5G5MAa59D0OjPvr16XYG94Dm0gveiXQaeArOBfgJdSqplpEXaGR3_HkferL1vPMWg51UimX1j63bMQEe2uXB5qPDnYFitIf13HbffQleIuScWlTzCul5o0t9U3Kb7Y712IOlHnzOucPlTIIsQzBeZT7LMPAJDuVjlsVia0dEuRsaQSQdcMWMr7tCe-AGmp4o8mhm-l2rDlagVUj5xhgztNrvOQ50CFnf8QY4f8HrcBddZ2uj7o0p2n6qtiBxM1jdFJwDhEry_0Uto3eELgNcv76sl5_mzidiBX20n2zRHCYIgZOmIoEzxFpLVQIkxXVSRE5tK8NG8wakLbHUA7y4PjkVTeKSwjE_mQmSYHb4zm1GnB088WpCLuH5g_eRP6SHU7pIYfFeG3Wx0utvfLJbbSqwWubAMurHYRb3zTy4WlpA1hIKwZqzhhorzouzOMfRCGrL16hZ_7fzn9Qo7psCjXe770MTiOp6_eCepgLZ5Lux28YMdA5IElq2IsWzHhHgS8FP6vxFO9UsxQgcuqznWgrBPI8WiIrwgMgQsbY-eSC4ExtE_OU78LjdIVrLHHZZYNehD09o8=w1062-h944-no";
                        video_path = "https://media.giphy.com/media/McDszitQHwpR7vKOtg/giphy.gif";
                        description = "-Espalda bien apoyada\n-Piernas separación como hombros\n-Piernas posición a media altura\n-Bajar poco más de 90º de rodilla\n-Control de movimiento, sin tirones";
                        muscle_zone = "thigh";
                        hip_weight = "100/140/160/180/200";
                        res_weight ="80/120/140/160/180";
                        vol_weight = "120/160/180/200/220";
                        subclasses = "global";
                        break;
                    case 86:
                        name = "Abs con giro y balon med.";
                        photo_path = "https://lh3.googleusercontent.com/dqBFCKkZtyaGGSKTw_go57HhwAXicl_F7CA2S875oZUz0qoqR-szAVe2fw-SJopIxW1YrdjVQT6JL_EO_QKNDtpyo6rMTXF_irozcJj0mbkXnjVnYL9Jr6sm1IE8ZN2PFLiIlQb4_X0LM4Qr6-_b8uDCGz7kJWNXbLXsKsS6xrBl4uxjTeSfgZ74yygILmun6Wbp5cI5QtzLHVrmr0TG1C1ecK2zQwHapZeczwx2xIirWgIxRsqmlR4LyCeM0BDpMVXL3EwLl5Pvt0vL2-VQz71KzOeeE6yQ5l66iBCeLjrACTmQaFDPm0WxHNHZfay01vZmILUv_BbRNGCvuYNKzWogMOKbqVeh70hYJKK4A8od_4FDPWR_9F6sg0gFCst2Z-WTteMMdQyCOf_NDYM_99ZXzafNYoSKS7-EnndLm1QWzJ989ncECVF31sEXxsDuQjava2p1yccPeHNAyz95fg-zVtaTlW9tl-CzB_W6YSmJntjG4IxTHjMDIYFz3SQ4rN_UzY15uC2AATVTXi8U9-AatnfHvAj2YnmmzkabDSbKjmhLn0MzEQe-UoLmufRIGUajH8JHGfbt97mgxW_yDdowwP6uqsoJwgKB-kYEF3gB3Zd7Mag4B4gOhUbZbyTL7wGSxttyhAE6ljouc9W9GL41wdLSZJ0vGQACDRas9b9XSeeBCmHgp9A=w1062-h944-no";
                        video_path = "https://media.giphy.com/media/VgNRdxs4TWrdfUzVNA/giphy.gif";
                        description = "-1º subo normal\n-2º giro arriba\n-Lumbar recta\n-Hombro busca exterior\n-Movimiento natural";
                        muscle_zone = "abs";
                        hip_weight = "0/2/3/5/10";
                        res_weight ="0/0/2/3/5";
                        vol_weight = "2/5/5/10/15";
                        subclasses = "oblicuos";
                        break;
                    case 87:
                        name = "Lunge (Zancada)";
                        photo_path = "https://lh3.googleusercontent.com/EwDDNRI41LPb8a95kGwnxB756EW2t15iy3klFWIiLotlAvJ_L5WRC5DYgijubw7MouFMB59fFdzagXYlPi5ZoFIKa3YfLFCJau1RQL9odN6FyLwn4wcWJehixmDxaLHjhJ3NoZfKiyWkOAlAEaQC8SOwQW_z6wnQCwr_uxztaMUFhUlhHJXQwGL8IAigrsO4mPLlLhIeDXHwUQBKDc7nJT_74j9nnZ4db7MagVKSH4WJWLHzEPmcQlvDT_o9wa-5T0_I9rJWCQynLn9vIdtUoTdaQen8i4DMMHm5MYAD_Z3JsCYZ1Z5Gu5dCAtpsIcu-mzPzv4X-AcR-u_bS4ELz4nqUqXUH0-mCq1mCFAAShac_kPyqwxToRF53QyB5bXKK3H4ljgmA1-4euKSZSloI6ZbHCIdAx-kJcTrtQkGAAApIus9sJhLMlrMQIfL9Myr0wjDrQNUjUNObp-FqtmUFWXDh4pf37onJ2-D3K2_zdI5zCvic-qxpEWk3hzwjPd8I3llbWOnHBb-JxF84C7Ev6iGFK86mo0rpubmcog780lTDRks5Bd13rP__koPvsZ0t9Au-KOX8kuKFO7Y2BeVn7YlGXxHyE3WWJlwCM5zpRvvqHKdlPlck4QwDVu-o57euV_NSfUL7Ikzt2Y_Yfua8JKj4tDjrqMBVR1OatHUBt8HdeXtr-uL4orFj=w698-h632-no";
                        video_path = "https://media.giphy.com/media/p3ZPIbHhb0oMqtyCyX/giphy.gif";
                        description = "-Piernas altura hombros (inicio)\n-Rodilla de atrás casi a tocar suelo\n-Final rodillas 90º (aprox.)\n-Rodilla delantera no adelanta pie\n-Peso: dos mancuernas";
                        muscle_zone = "thigh";
                        hip_weight = "12/20/24/28/36";
                        res_weight ="8/16/20/24/32";
                        vol_weight = "16/24/28/32/40";
                        subclasses = "global";
                        break;
                    case 88:
                        name = "Maquina de Isquios";
                        photo_path = "https://lh3.googleusercontent.com/Y5C-kUn-T7wBF2M5awFfl9OgwDZgh5C15XsEbEAEyIVMeHs_XrFScIXhe7RD8w2LZmM0ixMZk7M3fW9JXQpO8KgixNhOIp9mpqaPrQdE2E4pU8mRQhxMuidwWC8TVe08XR3fuPLQl3hL6qDqyZRYXoLE5piCmc_YSnRnvTdpdHqhwFjdJM7AkSdQet6nm-SwgrvQXE3JURYOcpLaSxg2FE6hjDRjYHLiJEbUqV27VunuxRVKtOruemlcJmWWNxXx_Z78-Xa4o0ZicHw1JqJmq2jHxemSejsIzp-JcpuniVBJrY4EriGKXMHRAs87d-1JS4WWVna3lhbwWjB6sd9rBSKfX45tcBx57SVpQRqPmB141l7bs_O7ymKYXgFH8JDw49tRHUPk8MlxyxqkgTOva4nb1YknuxJZ4CDt5hTD9ARDF2OTZ8vIt42pIiuh2I-GaFebmrE8bYnkUIgLioJZUeSsHK3f4LdVnJ13bDBgrvgezAgNo1MPHVMGv57jg7qwuxvXCkZEEIB74Q68_HSJdQbL-Ym1SoMT9isrdVsPr1oV43SvnpgDdOTmA_UkhzS5BQJzRhudqyUF3XiWZQipcXedHQP-eEImtIklxjTW2UcTYRYwNuerExLPy_Y8jVKX1SmFMwnNFqUMBACIhEi7TG2doKDxDDTgXqS7hXUVyAAMbR5bDLquOE6o=w698-h632-no";
                        video_path = "https://media.giphy.com/media/8YTRGj9wuZ0lKHsD2W/giphy.gif";
                        description = "-Bajada controlada\n-Ajustar la máquina (posición natural)\n-Trabajo de piernas, resto del cuerpo bloqueado\n-Cabeza relajada";
                        muscle_zone = "thigh";
                        hip_weight = "25/35/40/45/55";
                        res_weight ="20/30/35/40/50";
                        vol_weight = "30/40/45/50/60";
                        subclasses = "local";
                        break;
                    case 89:
                        name = "Maquina de Aductores de Pie";
                        photo_path = "https://lh3.googleusercontent.com/VhrgQ_s9l2TyDWdJFvyJodFkBwHYs5INrEcp5n2mlFrcdRRcV3ePeKEySZzhUvsxAMeHHb6k0wO1Uw1hF3GbVW1vp5bnC2JilkapoU7oWOnmnHwHvLzdgiBNYwMY-dORuJMg5DVmMUv_U6LBRgoWuOUacSnuQ9bOhZKbIweg9C-eYE6CgOFK5xpWVcA3E0YjmnMOIV_hR4ScAqF7Ffj7in85biUjA_ZCdye5zbNFBv1KBGKi2t-gWlFHxBTKJ9ZESIursVzaKzOIUPwPRwXAn2OsuY-ZjOvzMc3eVtrJYaHCOUIJbduM43qDETKXkxBkuxFLzE6jzeovHA3FIK1QexgE0Bh5apweYUkDTJZkPLB_RO4lfQ11VUdC0COLvi5xmVu0awPcBGjyY6uqyw2VPGZoqZgPzzuUYGaurPFQcsUMirOeHLRUUKuYrEGFHjFCTypyIJcb-Y6bJtFa2oBT7hfOnkKB7d5dY_RPRMEbVkWuQjMZneyxp6wyk5nS-UUn_pgrwheY0NbgHXrKZlOnfOeLUjhkAAXfJfqvedZUMwL6liNTAE_FQxCpK0vpAb4mlUwSrdghDtIhwUugTG1leTaAv5NOw4j6ypd4L0hqoumRNnQrJOXl7YQiuU-RWx2_EWzjC7bjfenwZTnW_fX4lKqKeAwVBXDpg9PiyVUit0_caeJbRrrV8oAg=w713-h632-no";
                        video_path = "https://media.giphy.com/media/ipxyVwE01GL7ABO1jl/giphy.gif";
                        description = "-Vuelta controlada\n-Pierna del movimiento estirada firme\n-Resto del cuerpo bloqueado\n-Sin balanceos\n-Movimiento de la pierna solo";
                        muscle_zone = "thigh";
                        hip_weight = "40/50/60/65/75";
                        res_weight ="35/45/50/55/65";
                        vol_weight = "45/55/65/70/80";
                        subclasses = "local";
                        break;
                    case 90:
                        name = "TRX Triceps";
                        photo_path = "https://lh3.googleusercontent.com/-D-PHgMFub7yUrOyEOqmHH5FnoZzPN8_6eybB8i2Pn0zu0lQ3oQuzbJPK7qT1hWtItFHZJabZ5PhFlwnHnU2dHkOEWmbIYEpiXP5glXthSOS62Uz1O0rsIkTW4HRBglXMSqD7wKWK0gNjCJsUnuwWkX2OQI503Bc_YhqZeA1UKPD_pcFRygyiXvNE_I5j5JDPefSvF7uzsUFhXVocdgbeZC8Oea5dCzmvafFOZm42k5W4baO5PlbM2HYr6gB0NSf8uFoEDf-MWzVfTVBNPJXHlusj-RFM7tA05WUOhpa60gWDAGI60Fbk3j6LtI7LMuRDmneLy3b5VdhFTasa7WDEuBAE_3fEf8gVqtWmOTBbim2bW6C_OQUFkDgOSb5O7Ns7qP4qSwf3AKZUtqwwJ3d-CeFgs-Uv5J3SZn6Huj57TvlWoEk1Ms301UfO1TVO-C-LSGlspiPJDmNlZM-QhC8QTCbu4xYZl0FWkryQNw5fs8iU5T7WxUVpaF-JO_isQidVPeokGrSLCNHw9USpCqEq_97hXh-fqpQCqrUBA6trwL3Vc7s4GtAAai5Nj0zu4zF8_kmPXMkas1sobQuSBSLV_kpqKUtASyw9t5IQrOT4elv2lFTw0vOqyzVHgdlMgyBD2Ha_HAAokfCm02MWAY_m1wMmO5PMCbXeSFsTgI4A3tXTWNTbCO3i-k=w1062-h944-no";
                        video_path = "https://media.giphy.com/media/PiWcqg2hGrQQqd7nQ1/giphy.gif";
                        description = "-Inclinado brazos estirados en TRX\n-Bajada por movimiento de antebrazos\n-Cuerpo bloqueado, bajada controlada\n-Codos altos manos a la cabeza (aprox.)\n-Nivel/peso: la inclinación inicial";
                        muscle_zone = "triceps";
                        hip_weight = "0/0/0/0/0";
                        res_weight ="0/0/0/0/0";
                        vol_weight = "0/0/0/0/0";
                        subclasses = "c.larga";
                        break;
                    case 91:
                        name = "Dips Station";
                        photo_path = "https://lh3.googleusercontent.com/P5erqIUoCPptgaUNsLSuuZevUKrG1QSrHJYJX1lJxEuNZjcjajQLSJa2hD0F5Cxdl901kf6PIvvfFbrLMUPpCTMbrpxdaLgBHrB-LtM_116W64afxnsZkmDBuR9Ywl_zRIAx6gY52HxcDtZfnIatE6WiZPtIMNqK0nSSCXKyu9Rh7Z-w_O4hvOqs-qEt-QT3nHFJHA2_KiPRwd_Tay-tbIQB-wjPJTvnp6ObDEiXlxk3EUeBE4HUUceqA83WSziBhbNslj-x0ENM4abaUQEJHJHncn69yNZQkZtxqFSM4kMaazNIGkHGogvvvpOcp1p-uV02ZcY-6OvMNM42XUvWt-YHMPKHa-D-258ZtSknTxdebnUI9copGLohyAP90dULaKboVm1NVv64Yd5CAE_AvXuVtHBZ0zT-r55gDHZIToWMFHwn_j8Z5lfisjI9FBowlMV1jEAeAOyawOFJHyUS5LV0ZSxKaSXE2ptnT-c1SmzgsLfdG3Z7wDXpT06Km_ur1AtYXU-6e7WXDmBgsIdWkZdg3wRYGfPmq3x6fRPNPLHrif_3eOkRC6JxxOSiwDdng5XQXji2MY8GEVZQoRtdQRXdRzdKNJNUnk2P2XOZuoqUlbYw0pLjhmxNNVwGp4e0Y4Td6Y5BtnuqmFOEdKZ9Ey7RRqCGGGSE-1AfXcW1-VeIF99NPuEpdU8=w1062-h944-no";
                        video_path = "https://media.giphy.com/media/lMlSrn0IVCQtBA3b9n/giphy.gif";
                        description = "-Movimiento vertical\n-Sin balanceos adelante-atrás\n-Espalda recta, tronco baja con brazos\n-Movimiento controlado\n-Si no puedo: ayuda gomas, o máquina";
                        muscle_zone = "triceps";
                        hip_weight = "0/0/0/4/6";
                        res_weight ="0/0/0/0/4";
                        vol_weight = "0/2/4/6/8";
                        subclasses = "c.larga";
                        break;
                    case 92:
                        name = "Flexiones Codos Cerrados";
                        photo_path = "https://lh3.googleusercontent.com/MNOHVA0mxbEn0ulgAEeGZYanTX401y3u2ltMemRTPcYI7B_LKvB8FnrBW_r2wUaJrq0YgGbMlwsWwhTUXjqPs85pUYPCFJGq2mMi7ihsv5u4F4snnpPxcYCQ6lnnX-Eg7uhwmj4CfY6_gRK7WJHa2wC4UBaJt7_Q_IQuDnX3BbMopJkqSIiDvoHb5ZpjqFO6WxZ6T1mp_THBuhnOWTIQNxTrsHl-FR--x-bF-V6ZEBnuWNhjuSVWYkl3KcHHB9LHM-jSxcbFF_3Now0qelmrpZQGv_deTzAmdnysNCOfYbj9ryH-LrkmMw_v7m51XnpvdMvZQmTYmST1HAXF-KFiCF1sTQRjn1BiojfDs7OGawo78_ednYfv2Pi6LR9CYXQtTbdcQGm5vR22UlNWoldBuYPW8LPYP5MbWWwOrzYWzaVODDRQ8Pn_xb9uxk-ikIBgC1WmUuaXfgVqMAZSFo69dAJoF37_e-P1PKaqepGSr3UJNCNeD38e3heg0Mottdj2Csj3lz3d6HjlYzKDSq8hqDKh1VJlqIB-fDV5XRKh5pYIy2spzG4BvTPtlPFhHlHE-_TsSRv5T0LQkW0s8GFdFgSkLW28RcpImBCwqpbrsIqwdQryEwRaJJCwUpHunQKder1bL79554CRBTJuKrdEussQ6yrDWRzDiROUt0NhFDOwIZb_fjyvBTYs=w713-h632-no";
                        video_path = "https://media.giphy.com/media/65HKzH8AxXEwHK325v/giphy.gif";
                        description = "-Codos juntos al cuerpo\n-Manos un poco más abajo de hombros\n-Cuerpo bloqueado\n-Movimiento con brazos solo";
                        muscle_zone = "triceps";
                        hip_weight = "0/0/5/10/15";
                        res_weight ="0/0/0/5/10";
                        vol_weight = "0/5/10/15/20";
                        subclasses = "c.lateral";
                        break;
                    case 93:
                        name = "Flexiones Manos Juntas";
                        photo_path = "https://lh3.googleusercontent.com/PqOj4cTuF7KuaY1ifd8X-JlXFbpA0nravxsE0JwJQPpveKezS9Fe_Aip2_N2i2siNHR3vhKYEFesy1MGa2SBoIMHe-Pmystzv68ChbikFx_ss0XTwwnC8zDgtOE8c4YWXEFwuvl9YwxFcZnYnWPgUEIksIOcp62ksItwTNrvYM5le_aQ6GjWythRZ-V0o_Z9f9iBtS_sTnpa9JiQH_DlRMnLMjBbDAJoxwduUsd2Q-0cHVUIH--L7kB0YEhbtTXM7Q8lo5KHl9Tu0EeRq-aaqxyq5XXE1d6KZ87lVXXDusACSWrt-r0QYmdI-Z2hDc8nxPcGUvOdazTUb8vxcbM3VLSCcGrN4g4sFZiTboaDsOcHGKLaDXLVpxn0QF-tpbaE5ibY6kU-TndHF6WNj8MIfUJh7ew70hehr7lnEWBX7wvHCQnwrk-juB1VUr4obBIBDdSMO881I7Q6hRaLDPt1yFRPvK_m-S4vQLNzj_zMl-O36AQPFZ-y1ESQpFm2ER004iosuEzFPnE4ehVUPBvfynAGqnDGSY-6CvMKEwk3vWXb_tQmd5RN3u_8kiF19lcDQYmMigj-M4L-zdkCdtDL8T6kot31vBBBFTZY_1x6Z4p7YKxHUNGmKFN4mHyWZRbErQvqP04dlz6S4O5JIV-3ZsrdAZD83ypvqz1KldaRlqUOXqBVWq4t7yA=w1062-h944-no";
                        video_path = "https://media.giphy.com/media/lOZSUY5YNIQmZLkXyD/giphy.gif";
                        description = "-Manos a la altura del pecho juntas\n-Codos posición cómoda\n-Bajo lo máximo sin tocar manos\n-Cuerpo bloqueado\n-Movimiento con brazos, equilibrio";
                        muscle_zone = "triceps";
                        hip_weight = "0/0/5/10/15";
                        res_weight ="0/0/0/5/10";
                        vol_weight = "0/5/10/15/20";
                        subclasses = "c.lateral";
                        break;
                    case 94:
                        name = "Extension Polea Sobre Cabeza";
                        photo_path = "https://lh3.googleusercontent.com/Yv-oKvjKbaOsRCmJAN2TjIleyakwGX1wrW6qNQt_-FAaWLcXopgtuUL6KkMwfYD4JmgcmWGrMwnrVNeKly6ACfDpuOtzXaFdS3SuJf6VDl5lqcatI_Zlerjf9gTglinGQvCNqqWLUjgT_LoGiVDMI7IVo_y2lVdsEyqIWKt1GAtpXFJaDBFYIJV0S_5Z-CiqAqm-rj4zaIAJXFaGF2SHC4GWIMYM-jLze0JgKMl9P6LsScP0SIkYmDr_WtPho-lUcIBwqb27n8we2WWmnWSB4d2ym6IBicSMnklm6OuR48fG7-WDJcfRoa-nL3vYvVStawYqFT-ysYvNQnzFcErJ0Lx1iJ9dqoegebdMyiYv2aYgjqJwyurT6Ub_5le5Kay6iCvSIP5dwXQKS2P1wl_s3_ZiB1VI8SXISzRm8ROHnquYeJ9CSmXzFkh0qzBhCbnpOJt7v-gausTpw0Aa9VZktTv8bNKyvPAZrty4UmrSwxuB8YaD2B6TX11_Ch6DFAqBUdIcWMe-sZyXtHiRjCZzm_MGKpIF4lWtPd_mTosMNP43nEJt7XdPnM6IEdp7n2B-BjQNQWUUYXdoU-IMGONOMce7IiLgo8HmbhF1WtU_7y5_QuXcgOuYEvw78GbiDoZmuW-mL6nhLCEraAGh2cRHXVOumurtQzVFyBLnw5IQuQw9qzOtgb7eJskW=w713-h632-no";
                        video_path = "https://media.giphy.com/media/4T3QGNq4wA4pnNRjIv/giphy.gif";
                        description = "-Piernas semiflex., espalda recta\n-Codos altos, se mueven antebrazos solo, resto firme\n-No dar tirones\n-Bajada controlada";
                        muscle_zone = "triceps";
                        hip_weight = "15/20/22.5/25/30";
                        res_weight ="12.5/17.5/20/22.5/27.5";
                        vol_weight = "17.5/22.5/25/27.5/32.5";
                        subclasses = "c.larga";
                        break;
                    case 95:
                        name = "Ext. Polea Manos Abiertas";
                        photo_path = "https://lh3.googleusercontent.com/yc5Cbn_RjVHo9x4U4cbCZcBZ_U4RDFAWGug4zvyCNlx_nuaHfCc5BadxaWK55h9ph9SlU-8yZnoBFuVl2N8OJFen5vQUjFZF90FG7hlT5o--S1rEuw4vA8hqQAvBjCq-GqOk-oYMuuX-v4q8fIAxyNYOLkvxYmjKoVzjVRsbEcgo5g5xxp9_8xn_EZVflDSWlSEidq25goAS6rpoLmJeW0z4M4hLXLkT5x_NajQFrbsxyUE0TQ9tNTgcIQnA6Svqk6-PcqE-Yzcl4l00zUkhCOw4Z1QVYNsGgKhKtAo4tF1UVNeNuWMmP8NRJyPH-_Vq713cchDarC4gK9mFMn4JAhZfM0cHUDvVJ9TN-fj-Y4OEqxiSHWTh5vrZu7ySn_a2EdgxoHcIRXolbWmP4_QfqSFaX8E2zYJCjdjxhGPNDnsvNQdYMF6pLPpbQb4FSHa4jmAMip47kWpd67xCr_R-XizCmVKywoN8D3QKUsaVu7zeAs9k3MppcijrFzKqC8jsHTvLAuT7B4iukcIeBMKb2ePWM3QCWZ74Yls6IGD3wi3ZIFuacu0Jm_fy8P23W6zzXUJLij6pX977As_ZgePY1Lay3uT3jEY3Yhqe2nixJXs5LtCasWdCDSN6cdw1CJYR5xZnvV-Kfb0cwFKstrNd8SJz2_WyqqDTgylWnhzLjhdjr6F-8EUWD8Uu=w713-h632-no";
                        video_path = "https://media.giphy.com/media/30pMgYTJWUImJK5ykv/giphy.gif";
                        description = "-Manos abiertas\n-Codos pegados\n-Espalda recta, piernas semiflexionadas\n-No balanceo\n-Movimiento controlado";
                        muscle_zone = "triceps";
                        hip_weight = "15/20/22.5/25/30";
                        res_weight ="12.5/17.5/20/22.5/27.5";
                        vol_weight = "17.5/22.5/25/27.5/32.5";
                        subclasses = "c.lateral";
                        break;
                    case 96:
                        name = "Extension Polea con Cuerda";
                        photo_path = "https://lh3.googleusercontent.com/HffjCqBt0kiYf_2NLOLrx5-IGMvK3lsA207ppkSjVuVNZ6y6xSWL6MFlQSBZHtkldTRDqIG6FgTsBGLBKsJfY6-0NGFqaX5_sb58fNwhDQwuxGznHKLnpBriy4-Lk3GKhDxOTVlrle1rdFBGE3sSPOhzncdOiH5XXzPnjTTWSiUihyKWyZsoeI6jtMfLKsBmq2pdvuK58aG8cvkBMJnU-JRZmF4kvRzGGlS0ENbs1OcI-oV8ujHD1w57R3rkF2XE4dnSlwCthIGmaIc23U39KgLhmWFzLSwnoLvvXMVFs7gmaHSVphoFLfCLB3mTEFzKkbDlNpK719AUC3wTTkUX8t6V3qwL4V4YGVA8h2Bu0MVHbkrYFzSSNs5kCDYMC90_v012zb-g3UbviY7Mdf7eijT507-QeZjlYVEL-rANkym_K82uWshW2Q7FvwXI4IK8_9hRHv-NL4RcQIUI5MqhApG5v6g-4ypZBHYaMeR2ZiUOHu6GT2xHC2Ni1rM4b_ckkDv4arNfRrwbjkABajUjGUd9AfosevVWL3cj7OrQePIjJuuODL3N52smIioEu7EcxNCFmblLahEwEGD2G2mLKcOA1l9jBnkVARTyQ-NikpRADqcFwGzOCYa_rhUIkrmn_X6F8daahE3lrO1JTB_ojQkHXuEARFgmqCMaZoJVBezHC3UddigD0R6N=w713-h632-no";
                        video_path = "https://media.giphy.com/media/1evEWqg2ryZyKK5WU8/giphy.gif";
                        description = "-Piernas semiflex., espalda recta\n-No balanceo\n-Codos pegados al cuerpo, se mueven antebrazos solo\n-Movimiento controlado";
                        muscle_zone = "triceps";
                        hip_weight = "20/25/27.5/30/35";
                        res_weight ="17.5/22.5/25/27.5/30";
                        vol_weight = "22.5/27.5/30/32.5/37.5";
                        subclasses = "c.lateral";
                        break;
                    case 97:
                        name = "Subescapular con Mancuernas";
                        photo_path = "https://lh3.googleusercontent.com/g1AKein2o24zM9YFET_zxHXJBlsBl-osN0Jp4Unx7dHqkxfL-tcVi_I5xmoCqpLW22D2zOsvx-tHXIeYW7bm54dBkca57CjNexmZcMIuPs31wQK6U2djeg6b7a_m0-kEJNEGpUIUGr_UD6ZSMFFQT-DLY4F0rTwq184MbGiWDbTqAUOOoKYcZS5j0jDVIPgHIYU3iQf8feF4dVGdlsagCT-OhsBviC6tgUdAuIpK2gixk0tbLI-Wb20lxciFI3Sj57neP1oyQPXOb5V-Vmh2hMWgeu6PA_YC_6nOsvE0sdAn2AOzVWyS5RXENVOyXlQR0868a7OVPuaroB-fqcDfopp8nUfJm6UyIQuJS0N-rRJ8Q8MiXWLezkq2Lz3xWgZr7O_wX0G_u-zZI2QcZghShk-Mm-2YmReHJboQJooa4sg2SdqMN7X7LOMgRdgD4zz9GNrXwWCxZ4SqjYopNG4_h40TjRKATGgM9YHH7YWTSlo3KjXNk8OuI21HRM0OuTQTIEyuBBeTrrAwNy9vCHTdAhsDawSvzWobJBBn-Cx_PSrZtf2HRlcGFsVJFmX10nVoldXThABVOh9OzBbavdgacMd8I92iTFulew7jwo7cgzaDIGkVqCtiq-xSEytf9RYTOtgw5ZIYSWtgHENggQhYdXxjosS89Wo-O8Dg-2bHqvh2QkeRc8R4x-Xy=w713-h632-no";
                        video_path = "https://media.giphy.com/media/7AaBEKU1cl9afRe8Fu/giphy.gif";
                        description = "-Codo y hombro 90º (inicio)\n-Subida en la vertical del hombro, brazo estirado (final)\n-Cuerpo cómodo, de soporte\n-Movimiento controlado";
                        muscle_zone = "upper-back";
                        hip_weight = "6/8/10/12/16";
                        res_weight ="4/6/8/10/14";
                        vol_weight = "8/10/12/14/18";
                        subclasses = "rot.int.";
                        break;
                    case 98:
                        name = "Supraespinoso";
                        photo_path = "https://lh3.googleusercontent.com/l_SN2rNTRjb0NarWclH-JJf8Sn4I7mc8XvtgTvenQk3mGOZP3ywwxLvVwqsU50YHRvxnCrHK4iY_583DlX8wzLy2r8WLdhSIdqUUGg10k5I8fWC6hLN6UX2tow88af9JTrXbMnO9r6vnwHAyd_G-wnvde70X-p-gqkc18Ik_JWnhwJhcVaTsP_dNyA5cViGX0YSsCKJkQGuRiyFJXh5x3bZsNu0ERA53OuEwL_oQhPgNB6qf6oUeLOtHYv44fK0G1AcJHLg6VvoKcAAg9kcMQxAw6PIy76iIwLrx2tWLSo82buuZNqdm8EbnCjXlT8WUYOUtHkd5jDPLeOaBy2vmotgTbvGYqac1FExcZdaaY7ncdHWOdWoEWXFmhzeay0YvDaOrPXyDFjb1DPN7d4GSB0XNCoENJv8yuoDCT7mAnn9hC6U7qKzhvBRkp1BKZj7d2JUhnJfAtRspqOAlP40WnbSv6SclLGoBhxLFD4nahmonfGAvZqd7E1g0XH_4TJ1eV_u-1IdRHNYjGgj0QKW1dI_JcVmPzFOsK8sFtnJaC0i3I0WTN1drAgRNYMvCgulAGCN_vAJsesCWxXbU9xiqzNJnCM_IxP0Na9KKU-JenOsxKP8KenmSk_2XVx2ki_JO8t4fNb40RANgbOVrWb9Vq4Bum08Fisgi1dNvGtbEas-IZ3QnPdSS2yI_=w713-h632-no";
                        video_path = "https://media.giphy.com/media/QmDnjZzM5DDVj6zmlz/giphy.gif";
                        description = "-Subida hasta los 45º\n-Brazos estirados\n-Bajada controlada\n-Movimiento harmónico, sin tirones\n-Espalda recta, piernas semiflexionadas";
                        muscle_zone = "upper-back";
                        hip_weight = "8/10/12/14/18";
                        res_weight ="6/8/10/12/16";
                        vol_weight = "10/12/14/16/20";
                        subclasses = "supraesp.";
                        break;
                    case 99:
                        name = "Kettlebell High Pull";
                        photo_path = "https://lh3.googleusercontent.com/uKArmM218BJ8xmuEv1YSsk84uGrH28hEwz1II2K3SdUjR7nS2hrZc6Fp1D7ZLGbBYu05VVNISV-2aMz-isdoaIzzZjk5dn0KxkqSXsf9w9wV_eqVJLr-3X_hsAoatGXl0hzIAN-j2JeKXacEaQDk1QPch_OfzQ7708i0BoniZVSYvllkZ9Yr7KxHrZq3cO-nxQOaUfgEZmQViwerVcs9JhVp0hsF71YnlHiB3AkoUidS6_uDQVAbBM1ewMvtGwFn7TkcArBwMUdovneH6gqhL7ZitvHMoL0mO_KV51IZCmiAuV8KT1JRFLfugi5pRPAkZsU-nVimjl_1DB0B5YwemEOorcywIz0u9cGea5ZJh87J4lCe_EYBgup1W1IWvwIul5IBs7T3uUCjjQJMOi2higONhnz19XlHYtK4BfLtzo7WjFQY_k5OFMjDHtqjrfAlKAC9mX4DXjMzkYkVIyo57N5xXQ3M7Q13VGJx8xwWINwiAwqTgG1MPaB1-buFxJCnfzGRJko_ROOujOvbWk-DR2YjNnCHjhgly_Vm0l-e33021PTmBKFY_y_3lEmz3RoFqq1iTmOF-US5ZtxIyOu8jpSanafIMMkvsVH3hZGtW7PNQ2FyC1Wx7SQHjDwX1_R01fZs5LvScZWnAJteIlptt7D2PbGMz1veixgHb5wNZcqYxcaaIxHBDWLq=w713-h632-no";
                        video_path = "https://media.giphy.com/media/2fLcHUDvzGKNS0X8QD/giphy.gif";
                        description = "-Espalda recta, piernas semiflex.\n-Subida en vertical, codos suben hasta los 45º\n-No balancearse\n-Sin tirones, movimiento controlado";
                        muscle_zone = "upper-back";
                        hip_weight = "8/10/12/14/18";
                        res_weight ="6/8/10/12/16";
                        vol_weight = "10/12/14/16/20";
                        subclasses = "trapecio";
                        break;
                    case 100:
                        name = "Infraespinoso con Mancuerna";
                        photo_path = "https://lh3.googleusercontent.com/kAWtAeZ_olI2cfdX6K1-MxoDSRP_tmSwOsgT7zyk7WEv_q-MlTdcW6VU1KiBh_i7nRciYO5SotT1sKIk0f62EU5totRA86rOSDxki6ButmSLFai_jh1fsD2tB50SThvPYDo8rRWhRNk8j6yo_gwEnTR7sbfXWOO4qv9enO0N7auhcE3JAyECMtetffiqA1NWmUCVzEo8rRtCRhwKH_GfzxE1L51NJg2351_n4AVpDDxrz_bUyqgHqd7lWt-Pcug6CFxD7SvGOshgRAojTZWLcTsRLjStdYCYR_Djv3mtTVxksgjabyPlMuqbv8N8wsgEhGcvsPJRE4iPc2oVXqTh6-49-oVIXOVxvgbkzV93uRiw-DxLLfP-y9pD7qdieu_coAtNoFP9_QCs6g_MofIVZcsWFiNpxxYw_ucf97zjSGVdmzIJ96V0vl9C18pJXXwvOuWx24j9B-EEJhB6BKKoKhvonP9iuVQe3mA7nqguQg1GUUHf21SuLyRFqWzVJYD17d8InBTz83g8xAbTFIlNQm8SrGj0pj56hWdP7JnhkVXvk80koC3ksYm8hBxawv0ZdgcDJjXL8-bZ9VHFYC3qvTEQ-el5NOWslDr-e3G6X5RAEtlQ-uuoKxEzMFZgj0tdxy6Kr1OL5FWhBoaNClCEODmPELtaH1vhJgDz0J7fSOYMOnKO0FuEVNXE=w713-h632-no";
                        video_path = "https://media.giphy.com/media/1gPyMEAWqjHXQ3siW6/giphy.gif";
                        description = "-Codo fijo, brazo-tronco 90º\n-Antebrazo sube a la vertical, sin perder los 90º de codo\n-Espalda recta, piernas semiflex.\n-No balancearse";
                        muscle_zone = "upper-back";
                        hip_weight = "4/6/8/10/14";
                        res_weight ="2/4/6/8/12";
                        vol_weight = "6/8/10/12/16";
                        subclasses = "rot.ext.";
                        break;
                    case 101:
                        name = "V con Goma Elastica";
                        photo_path = "https://lh3.googleusercontent.com/6X_qX66o1yNI9Dv62rSvcw7E_xpbSlvLN_Z76OtMoYQZsj9j6cSaiU8S80mi62R9lqFMWOX7pCqxb4OxyX8g-UrpwWjmo4GJQkODYp5-UWL3estEyc7d9D_-fYNofJYVd5beaHg1nbKRLe28UvovKGq1RcMk4_HgmOPh3wUFd7DA_RaqiPCPoRKF6Sf2GyQhMiWoQTMcs2WnOwBioWa3L6OTVAGfTH_2L9ERFPmb2QP-YeVuQHkfibTZsQl3CF59-gHTL3Yns0P2Pzo0SnL69OlH3onqrDMb12ov37EtL-3LqzsXh3KkSK2817ibxhXbJFN7VdB22xVgSFy1TqiE6obZesWgAOqRcGqI9ygv2AM_-8tuuFGPLkqeiCmq0Ar9_6zypJdV2OyIRqPf2G8nDDx9UANy4WitYa0E_AeIJzNpzZyrOpYBPQURaKN2l6Zdh3xM34T-OIuEwIjp6QndJic4CJxNp24O9V7LBtwpJF58U_YNPnFCgZZVTpsafTrirsaSHkoeQRVvDRvXSbLeZ5huj56gTRZTd-ArazAFbTHZGqJU8b8Vif8-m0BZb2K4TmuENRA6Eia6oGF8WaelMdQTj6BaPzXChjHXbvgyFxZAmbMZqITkCFYoYRY5pXXPkZJC2_uzMwOFIMB_8wffn6e3z0fRvAZ3Or_wjsQsyumNwf7nZEj5_8b4=w713-h632-no";
                        video_path = "https://media.giphy.com/media/RKoK1LFOXbYZsM1MwH/giphy.gif";
                        description = "-Siempre: hombro 45º, codo 90º\n-Antebrazo sube rotando\n-Espalda recta, piernas semiflex.\n-No balanceo, bajada controlada\n-Peso/Nivel: color goma (elegir)";
                        muscle_zone = "upper-back";
                        hip_weight = "0/0/0/0/0";
                        res_weight ="0/0/0/0/0";
                        vol_weight = "0/0/0/0/0";
                        subclasses = "rot.ext.";
                        break;
                    case 102:
                        name = "Infraespinoso Goma Elastica";
                        photo_path = "https://lh3.googleusercontent.com/hB4dHmYd3bj8S8GuArEWDQf3PeoQ0NHkEvsak0deFHGKQ0PPADgONFz1FPIau--wa36ktJlCB-M5rfvy230jbDlnScpnxUkQdZTDwRGUxHLQF2t0ww-eGlCBFAYOedA9TL0iHYT0ggsi4P0r_HzOwhm73YKdNpLyDGKU_-gR1uRp5THMif6XD_kKx2BHA4EMqo99u-M1IBCSw2WBEL4m3WFspVp7O8GmRrDmr9OKSfc8e4eKSq23YM2Bve2DNVCDPkEgN07d0SXp51fjWDHp-isaVxFJvYuDo-xjRQ47kRu4egEuUQVzdVnUNjboY6R2s1Bl5t-qNUyK_FR8SZ64E5fuBIRRZzGl8Kc8ACcqBnkf6qRDKrAHnCc6Q-Gyh0PHb6b4Qy9zLQcakPhzNTWl7u17KorkIigLzDN6BaxM42kzWpL7HlHagpOCSLKaDQAk8vCJLabWPSJW-s8uqIUcMRWQJJDWZgGKYUN4vRNm0-N0ryH27FwGn-oqEGl2GnV-IwPlY1X8W0YK8lA6aFerQL8BWnzWO_ILA2eiS0xIy0IzAwTrFruRIO-m4OZEvU-bns_6A_9n8YulCWpza-MZkttGZbgLjmKwmmDDgNUgyapXVcPfaI9Wq4AuIZJWW09fyHCI8xBWuiq2xXkEGXDZYQWF0WUoKjFCE4FaV-d0XCCeP078Fk5-g6NQ=w713-h632-no";
                        video_path = "https://media.giphy.com/media/1gSpNbE1v5ULkNNXwL/giphy.gif";
                        description = "-Codo junto al tronco, codo 90º\n-De lado a la goma, estirar goma hacia el exterior\n-Vuelta controlada, sin tirones\n-Se mueve antebrazo, cuerpo firme\n-Nivel alto: +separación y goma +dura";
                        muscle_zone = "upper-back";
                        hip_weight = "0/0/0/0/0";
                        res_weight ="0/0/0/0/0";
                        vol_weight = "0/0/0/0/0";
                        subclasses = "rot.ext.";
                        break;
                    case 103:
                        name = "Subescapular Goma Elastica";
                        photo_path = "https://lh3.googleusercontent.com/OUXLEojbdLdTYpozHqm9LKv6yptF1TttYX4MrQkuKRaSbUNH9B3uhSLFbTr5u8MhRMJ616GTb6ERAzFJyqUUHVVmwXuL0pygIAL4zzAZc3C4hVctX0juE7bXJQFAM6I5x4HRrirF-GcfGJrTw7rwac3WwSXSDEWBwzcGW3PTRMOgDzaINhr0iUjaKOuPlvwW9qtlWAx6p286pfvsgFfVeqvTsE5aXR5otUp8v89rfDJbn0dJSnwoAGoRj2PAduzwkBus5BVWtXsn4-Mqy5mb2GW2J3sL_7TbemyIIj3oiOWigpGiAQXj9ZZ99CvbAHIGqAD9gQ_BIsLt0xcvUMJ7KUDx3ZsAyzMfzl7BMkORFbgMJJLuZdT82moCfQ2VibgB_8jxQ1h7UJ7WvT86ODRTKwEugcywfuous52bIgKORaOi-6NyhTwBDb6TjJbzMU2XGAghBz25eoWBou6RIsuplMY4p1N0mpix2pIE7JoypaGSIIvmnhL5sgiqAAhMYOztsp674Hbmm7IIg6mreS7Ulv9YLyLRpNjH59etI559qu2gN71ypWLMIGi73m0LJgmLTbno4T4AZ3SgMnuIXkQiXZ3abuZqg8HZP9gRs1vWiTO9Qy3syOIArZ8dsPjvpv3pMlLrimJfPF32TYR_yjFDziLTMkvn5BoqnVFBWSUf95QWMqClX1U8JRLe=w713-h632-no";
                        video_path = "https://media.giphy.com/media/9A34Cep8gjmptKTkqf/giphy.gif";
                        description = "-Hombro 90º codo 90º (inicio)\n-Ir a tocar la cadera contraria\n-Progresivo, vuelta controlada\n-Tensión inicial de goma, no balanceo\n-Nivel alto: +separación y goma +dura";
                        muscle_zone = "upper-back";
                        hip_weight = "0/0/0/0/0";
                        res_weight ="0/0/0/0/0";
                        vol_weight = "0/0/0/0/0";
                        subclasses = "rot.int.";
                        break;
                    case 104:
                        name = "Biceps TRX";
                        photo_path = "https://lh3.googleusercontent.com/hOoYRUW3TXgwrWKgtU0CWfcESQEkg__lowshrqX-OusGeyrDB2Wo_8RGF9nOKpiHeuE16DFoPPtApmAnx95VXhHL-dxpeVCNHrFMtP17Eq_EpYFwBN_-1u98rx4AoMDQMnko14AbdgpUG4e62yqEBn7DAKJQuxB5rKrD5k4WQYaaPqyFbtUZ-T-EWCcyDoaNO_EQS1D-EdcRO14NnWYeW7UFk1fLvnA_IfUMlIOpaTtoCMxncXEaiMxEtb5GloCSQHz5ziwtMueiIxkeeK4cX2vNb7hJ25O8892DVzMklZnzoNY8m_iVkpqm2-jVf7ObtAa_BxkCsizZNSIQ1RPh2zDrMo2eLJNIGAuhMC9fZC1XNFFNW0WYmWEhRZMcrn2nQAZtfh3ix2YRYMa57mpdVkjZAFWD8Zn_Huvul17CF4frgV1ktxLFophG86Heqrp88A95uVkvUrrsSYRazzDIQNcO8OdCXqNjSStlbOQg5lmGdFwNxYeOevsFeTvVGpXCypOFpVj61IANMPW5M4gcXAderwUW8snpcC9FGf3oVrj7uzyQRbKPbQOdiVz922zQ1pQ46NpZVJD2pDoOC7kEjaEkO5aL8FK1uZDt_eu44KiQ9K4FXpiFzjpathtZPcsR1rgqi3LGRejxE-v1EGNgZ0IR=w713-h632-no";
                        video_path = "https://media.giphy.com/media/mxw6MEQJ6gymq6A3gW/giphy.gif";
                        description = "-Mayor inclinación, mayor dificultad\n-Cuerpo bloqueado, rígido\n-Movimiento por flexión de codo solo\n-Manos a la cabeza, no bajar codo";
                        muscle_zone = "biceps";
                        hip_weight = "0/0/0/0/0";
                        res_weight ="0/0/0/0/0";
                        vol_weight = "0/0/0/0/0";
                        subclasses = "c.larga";
                        break;
                    case 105:
                        name = "Curl Concentrado Polea Alta";
                        photo_path = "https://lh3.googleusercontent.com/QvgZl-B8OV0NfBOtNne-SzeAvORfE2dNROVFdfOODhWDHDRwYXAS1NVOATPAtARZJJdkJMn3vLryPvqqqZ9NhH_sP-IThcIEmB7ak8iQdy1dKxgoU4H5nM8FCy4yBSeO8OjHh3VJOqVPZhB1QjT8dR5ISk0UspLWR3ID92PGbeN_sOC0s9AWi9uZM248c_y6i673CwZ1IdRiHqxbznR9Fc63w7CQj9nZDoan4SES2M5YdsH0v_4qI2nsSohKssERwvFUWHVWUuGSq4PR_85wKSgr0CsV1x1ATjR2tz7wIi8wvhYsxXGs1_aiEo4idkZE2uKVvTsxx9fkAG-UmrClLDKojJRGug9eX_dHiDGIFFNKeuJGGa_UJPLGff39vtn8fB7k-55-xyRSU9Wg-mIIrcT4eTHJRNuPx4SYDS-1PFILxhr7vnZZOtKElEW8yPzGptTqH84K4miG_Q_a8y5CetObsD4cBdJA5d7CpaiIaiDeMI858O8uIr2b80pWDl-AYWTHWDbqPSVZZpiZ3oxRe1L8vCW0Q9wrtrtVo-bN9tt6mt0St9cv88DXza37IlKKff0hJ9IMXzVll8LTPPKyi-gw3blDMVEyrmfxhp_zhUFI59VqdX4xs5iZtW4ckx2yvCXTFdTpMC1JGjan04yAlwvd=w713-h632-no";
                        video_path = "https://media.giphy.com/media/8FJsTdcvExMqCaBT0E/giphy.gif";
                        description = "-Piernas semiflex. o pie avanzado\n-Movimiento por flexión de codo solo\n-No bajar codo\n-Cuerpo rígido, evitar balanceos\n-Flexión más rápida, vuelta controlada";
                        muscle_zone = "biceps";
                        hip_weight = "15/20/25/30/35";
                        res_weight ="10/15/20/25/30";
                        vol_weight = "20/25/30/35/40";
                        subclasses = "c.corta";
                        break;
                    case 106:
                        name = "Biceps Curl Polea Barra";
                        photo_path = "https://lh3.googleusercontent.com/JyqeadFjt7hGejFSsx1fsPAvU6tPTEEkWVnu6pzmO5kkF3HWFrS7Vga9B1_bHhVxi3r2D3Xyl4mONFRooPD74kO28FpCvlu7QAXlZJXbUmdtWNvhds7VvsP9DoVMz6lmfUPXJ74W1AsbrV0VSJj63Xry-cZlMbAS31nAH274H8gDwc3RrzKa0dtGjEFuWHNDGSKBtuq6b_SA-eLtXKYe4cO1vpmM7Qi3NFs_lIcncZMcFYb1OmJ5Htmmjbddia2QekEXkRv-9gM1e7tq_jD8S8yGsbQeldxwjXfCOhNZGXReEfubrdVciuA-tdjqdblRMcrjcrfKdoUiXTkeIh35jM1tcLOzD6DdSlr0eHcS2KvLJPZx9r66HidXvwStaoJZSXdMkAl6MHdPROy5Omlj02K09fBRajdCW38eV_aRONMz2_WvokSWdD_jX3eJqA-aoSK4hy8ZUr5fEbXrE-Di0XzdWsvOuvVTkCwi8qc3qj0nLxKXSjkhOA8bf1PKmkJeen_aeKAogpR509y2Kr4g_GfjuVZTfBdkMHB5b9wFlgI2Et6RG5Kj2Ly8TeWShInqGI0HJKZxNrsww8jsLxEKQZFXuLF3jyolMX5lKd6dDq8tHXlG5_QPF5bA-claj9s-AYgPxGQDk9X-bxlnACLTU39f=w713-h632-no";
                        video_path = "https://media.giphy.com/media/fWgdQFSFuU3JZm75jF/giphy.gif";
                        description = "-Piernas semiflex.\n-Espalda recta, evito balanceos\n-Codo fijo\n-Movimiento completo, bajada controlada";
                        muscle_zone = "biceps";
                        hip_weight = "15/20/25/30/35";
                        res_weight ="10/15/20/25/30";
                        vol_weight = "20/25/30/35/40";
                        subclasses = "c.larga";
                        break;
                    case 107:
                        name = "Biceps Curl Inclinado";
                        photo_path = "https://lh3.googleusercontent.com/sVgVoAAVBorz5w0koJCIwaHtVsZRbx6uhm2hDz7WXKg23GKiO21eKn11OFmd2fmOJ0S3aT-8VB3f0GKM25D5t2QY3CC8AuKFkpqNNwhmgncbgJ84QohNRdO3FATQEYAIJy4s4G0ovB7xdcClIg7_Fm-hTNi3-3qmDcSRQQRMrkYu4MIj_ESsA_XmA9b8qbC4wHU5VAyRT1kIPZpR7ChTGrpNMk_UyaUw2acmk0id1hUG7OWS7JD-_4ZjTNWJmu_7r0HDr5CwWP9xkiP01kxwcG7ERWszhfiek8hDjGJXdBoAtuChSC30lIHp8GlVbPKuYPJac_G0jc4D6LZ_nP15SQHn-yRwcccyLn4Cmk7y1jZbnG2GxMX2RkPF6d3LQnn6UKkA8VPQ5YoqZeBK8Y8HvAKiOlAKy5WR77-gjaBxFbPQvLkIzH-jv1pdwaf90DTh9Z5z3WAZTOv-Xzt121Mpqyjxx6v_pIvRp3uTYnEraxqu-StbZUkpXFHGw_8sq280PFy4MEMnnZoKgOGAzGtcR9jPIssbSbEmooe9Pq4Khh3HpA9nzDVE1VErTkWBdlR8ZjwXkk1TGg8Xehsig9sQ7yQTFiiR-wdNZQXLI1hKvsZZAmXW05DkXKw9jOX37sj-PdfTPb9T4fHA6I2W0qpgW-L7ncnADH20X5t8GxXPafg4V7jlxXieYhA=w713-h632-no";
                        video_path = "https://media.giphy.com/media/Zv9uPsqqBpYdzHDBWV/giphy.gif";
                        description = "-Banco inclinado 45º\n-Agarre supino\n-Cuerpo posición cómoda\n-Codo fijo\n-Bajada controlada";
                        muscle_zone = "biceps";
                        hip_weight = "6/8/12/14/18";
                        res_weight ="4/6/10/12/16";
                        vol_weight = "8/10/14/16/20";
                        subclasses = "c.larga";
                        break;
                    case 108:
                        name = "Abs Declinado";
                        photo_path = "https://lh3.googleusercontent.com/xIVXCHXw5jP9EVbjN6GQPZsQlowTO0ovms6ZcFVL8NsxU-vkKt3ZTHSMJbX3hEVE2UiLUPGuh2NDdN8wwr-PcwmhcJQsL7jkbelhfbWwSXGQwJs_q02jJW2ElQidvtvmhIOpBuW5_r8i2bGZibzEUxcV-2nB4vAscflOHDywiP9_hBKjAGFBro8e1td7_yT3ET--N_AgT03OREdhwTShJKrjQYJEmWcSWrRzXMYCHXGjWBGr17idk3QQYQ0c1kR0ElRAygidujbWkRl97FGp0IVojl7iohCP56AHglxMIca2SeZarl9V5lrWxR9M288zO4K5fk2CGhvITtUi5jnCP4PCxzv_wmLDNuD1lTdPmBQ3FLzQAlQYbthe_zwjDNlbdW5FnwxW0bQLMt9KM7dhrQ-9UK2L9j7_asLZcd4rvGdPnmERAU0uscxBNXqFpW1wzKXsT8kYNPgV4DwBiOT2GJm-m_FO1uba_g5QzQlN2pqMDf2PvFpnAa7NvAAILnOKL4tuEW8TimDExcxUiPZGSu7bQyHkg-pVRIlQQ-YfA00vDWqEId-sXQ_E3HqcC33wIn4896CVxJne2bcufo91fWNlrEbMIQE6Qre0ByBZo9WIKZc9Kgfe-KrVIMy_4g7zIBpRKux2BpWjOOEXPfXwnZ0o=w713-h632-no";
                        video_path = "https://media.giphy.com/media/2A60mcadGXJKxaMGZq/giphy.gif";
                        description = "-Peso en pecho\n-Espalda recta\n-No doblo hacia fuera lumbar\n-Bajada controlada\n-Barbilla hacia pecho (ligeramente)";
                        muscle_zone = "abs";
                        hip_weight = "0/2.5/5/10/15";
                        res_weight ="0/0/2.5/5/10";
                        vol_weight = "2.5/5/10/15/20";
                        reps_obj = "18 rep/24 rep/12 rep";
                        subclasses = "superior";
                        break;
                    case 109:
                        name = "Abs Declinado con Giro";
                        photo_path = "https://lh3.googleusercontent.com/yE5LmY-4GPa4HfOCThApecdt3p3gh49dQCMBoeb28ac5sANpM7vmudhVVFuP_qmZQ39SStMZ_IhK7PFFAmwFSTbR8LF7gjZw7m9-yNH1IsHZdaHjDwpkwhLFv6lQr9sMUd8p-zii2zphspNbag4QnoFkBi3TdTXnYxDzWifcuYLujChyYjALMXyfieJb4teXHTYE_BhKzus7dfLiWTQbkSrcdB74RQxsCPFWcT1hNkKQO0p27TnjyRAxwBW89chjNcYGu77-1c_vWjiAA1uY57HKd8yzeNw7DQuzxFoPy_uxnjiTxh_ICViTfYyV-yqMQYSMsbGrNFwRFVYJNX6NrHHsaGBIdD7x9H4irVQxuMpzLF7QIlp3T5PRKGbtVm0NP4OL6nQSY7IHVfuggmhR6O563V_-xtQ4fSh_U9IC47OOXEO0uu0zdgO-N56mGIgNxMh_ZwI7IZS23DtQp3m4769F9DBy_IurhbrUl3NZ_Ofez8ZqHaHMByMDMR0WMAjjOzD72Sm4ReBmy-COj-_1XdH7Q__XAmsZO3rYNAwJXWLs6LvaDYgqanivte-L60B0zlOyss85Y2R-B-CK7qYfK1WVEm6xdcbADCi6CQLAxQMgPaSDH3NhtdC3k2ez4m3kexbykFCgU7j3md0pf81y9LbA=w713-h632-no";
                        video_path = "https://media.giphy.com/media/9DrmXHaTo0ahiG1Mo5/giphy.gif";
                        description = "-Espalda recta, doblo al final solo\n-Voy alternando lados\n-Barbilla hacia pecho (ligeramente)\n-Bajada controlada";
                        muscle_zone = "abs";
                        hip_weight = "1.25/1.25/2.5/5/10";
                        res_weight ="1/1/1.25/2.5/5";
                        vol_weight = "2.5/2.5/5/10/15";
                        reps_obj = "18 rep/24 rep/12 rep";
                        subclasses = "oblicuos";
                        break;
                    case 110:
                        name = "Abs Invertidas Banco Declinado";
                        photo_path = "https://lh3.googleusercontent.com/hrWKlidGfvXA2nd5cDRTwIQNjfEJ18v-JJYzTqgY3jYnoFHvheZLIl0fHU144KYiBnR5Mp_rg7ldcl0Os3UZ-AUazhDP-KMeQfrJM7Cu7IiPEU6H7ShfEHdL9AbXM9mOi2N6_fUujO3VoHJOlB-lhGeN1OorPmF7Qf-wkzFZnFgtnedt2LgjH1mRMm9q9jQNqtAvA9rsIlDp8BNINxO-IlCcTYcjbH38gDGtRM4sb7YIgoPfYUXnRfikJLPLA1TzpLXkEKzRdQlhHA9ejXICGe1J0lPHeZqc9HtI2FkrZ2Jo0pwTkiTsd0K3x7BtxHLfy_jpBPfTofz8c7V2dJXyQ8JxxxO6CxoJDbPD3tepu5LsdvjOIgkPitJKgXcl7ywAYYmDImDvWG_rLyyBfD3LS7UVjHDDdXoOo8d7LvS8syaI978gLv0zPRsaEpRfcvyfJm50VqOyev3CXX49DEgQUwki5G1JOm9ljZuwTEd1ipFv1Oap4GM5QIlIDPrRquRmDJdEVJSP9HziFIxAxlmO307BoFNHwLrdUxuQTs63snBw3ge6qKKpEpR1XST8wJJIbjIPhogiAUg39O3gqmwLcj9x7WS0R_9VpS0fT_Mls2WvIdic7ftV2R4nvaq_xXnSE-RqA7Rhza_lhrHXVdwD4II3=w713-h632-no";
                        video_path = "https://media.giphy.com/media/PP3sY8NqawBgQuaT7l/giphy.gif";
                        description = "-Subida de cadera\n-Pies acompañan solo\n-Bajada controlada\n-Flexión progresiva (de abajo arriba)\n-Vuelta progresiva (de arriba abajo)";
                        muscle_zone = "abs";
                        hip_weight = "0/0/2/4/6";
                        res_weight ="0/0/0/2/4";
                        vol_weight = "2/2/4/6/8";
                        reps_obj = "18 rep/24 rep/12 rep";
                        subclasses = "inferior";
                        break;
                    case 111:
                        name = "Giro Bola";
                        photo_path = "https://lh3.googleusercontent.com/N_kAexHmDeMtuuNkVlekXlPGvPbUh-MJSXyvmmXSvheOT1jMC5QnjOhuxONo9KY2hKjT2W7QPNnLPcoMki3w-gjwZCtcUFC-7BblfOJRBhSpVvKzL_Mukbk1rkUcbAlgsJAcxqVB8p_wer_gCdsUUwSBSOntImJMywo39Gb3LEc5OAXcvGXW58_hnPxX4W1NWuVYZGncSEWYehUXQmf3EbmTPGU5ZXC8Ki_rNxQEb3sFnYI0G42MEo3m5PGGuomTzo1Lfs-Zd8a6ladjpIn3VZF1w-PlEeRwr_BhX8W73YUqZLrNy2I-ZxQXcFADnnBj0cZCJ5BvfvZHc05ndc5bPiR0cW7b3forz3gi-4m8G8ihSzAeZBBP4rnQRa_J0-Gc4G0mxbx7SmVcx_0mgaOTQw6_OojvixdQCMWn1zauCVvE9OobKrDs4U89e2tWDG7LJnN2AZpEgRVPUJVryBqgDV38FwmLtJBem-BxW7B0P5PHr7FT3mBc43ZoP4y7Ddh4uHHC3E6vyjh-Z9lhDcor4oYgpnIpvI0arxi2puKKw1wIgoZUtKsI8nyHkN6PeHcg2BvwtD-zGXZmcCOWgHRB5Lbi1cecFknO2Lk5rXJHyENK3Zv3eJPJ7CGJZxCS0Osy8UJBYWOLXxnq9AJZc3cjEkxw=w713-h632-no";
                        video_path = "https://media.giphy.com/media/61VQ740tYI7DcZ28F6/giphy.gif";
                        description = "-Tronco muslo en V (pose fija)\n-No saco lumbar hacia fuera\n-Rotación de tronco (superior)\n-A tocar suelo con pelota\n-Movimiento controlado";
                        muscle_zone = "abs";
                        hip_weight = "3/3/5/5/10";
                        res_weight ="1.25/1.25/3/3/5";
                        vol_weight = "5/5/10/10/15";
                        reps_obj = "50 seg/1min 15s/30 seg";
                        subclasses = "isom.lat.";
                        break;
                    case 112:
                        name = "Abs Peso Sobre Cabeza";
                        photo_path = "https://lh3.googleusercontent.com/trbtH5qqnZ7F-VCDDXZyvds55LrHfVL94xTeff58WsNfi-bm9EsrJwouEVHtwmpQaKyYbPExU5ho2cMTx9F_EtR8bdS4dmIs9VTZfGLVXiF-elBUYBXdkTZK6Lad13Vb-ze0qDoFbQJxL55OByG3mdad5ZaAgqnzTc9a-AzKoAhNG_EOI9SZ7Hp8U6aV5jXmTHyBRdEr8gv1thVWm0ze-yRe1N6RFjqEEgbLqIyD67-u4JpFKuG8hCSgnurOr2z8q_lDFEwBhME2Wu7QQ0Oepi0adMVtCu05Ft9I1l5gKm2Ue-u0DDxVmYYacQEMxAmtiSYF0NrfAFuL0-UXzbNe1UBzMJ0bI7Qrw9T7IwpbP-IDZzBfynlTI5UHqflWb9hxX1ydC60ZlVUBe3zTYl58oJ6aahTkr4F3ja_zswyeKEO3NnZvrQ6JmkhdyJujwDZ9PNugiWS1h3FCXGT6erK751TW_CRMyc0ebfL46pH7bwwwGH0r7cXS7H54WUHS_Ulz6iw_toqLMlQTlhqFaQ15oRSmF-bCeWkEjBHTJbR6iyCnfcWCNJ27wjyBRI-2o27ePHPDnUGUXk-fzeKIF-eSpK5Et7mzPw9B7ipSMpKNKDrry-VYkypfmO-3nHx2pbjRy4I-k4Qg6gkZMmFrI1RGfcOf=w713-h632-no";
                        video_path = "https://media.giphy.com/media/fteghURwSXnjqj9ZoG/giphy.gif";
                        description = "-Pelota en la frente\n-La subo-bajo arriba\n-Estiro-acorto brazos tumbado también\n-Espalda recta, no saco lumbar";
                        muscle_zone = "abs";
                        hip_weight = "3/3/5/5/10";
                        res_weight ="1.25/1.25/3/3/5";
                        vol_weight = "5/5/10/10/15";
                        reps_obj = "18 rep/24 rep/12 rep";
                        subclasses = "superior";
                        break;
                    case 113:
                        name = "Cruces Polea Baja";
                        photo_path = "https://lh3.googleusercontent.com/WdM0d0FzUuGPzpnxCu7ZiQwDqIdO4r3hBWzMyy5dwnIOaNsUq-wi2Q_wKyPEf17zXjrur69ExoQIKuTxQ0jrw9wYLtaDEZPK808RcJI_gAbu9ofo7VEuGNJ3ESuCDSawrUapaWBbawbRMQD81101APgOzqCQRu6u6yeI-yfelO0oO-s_lLHXo-SivMIJG4qb1UN5nA9bR2JNGR9K75fVcgd4SWcM4bqoXqvt_uYaU5ZYrjY4U6ZM6jxIYifoLmxOuecm3_IZmQHh4RJMAEmCBn_WO7VnIaQfwN3WbEN5c-7YgwpyfSZMsU545cgIncYEZ4r18K8jydqmKKJiOioZTxym2a1KSwQZyTYrcvwa8dG8bHq9LeZXmbuD3cYiZ5X2d58eeyezzwuGs2iE8zcU_rwP3gB4fDtwiaW54XcqGKbCNVlgSrhebz2jODTpwDwpvMPiVrur5WunhDPwhWIcfd5hSzLraNpB8d9Fj1KeEU8o7mSAKSypWo8wK4BrTFxKcgdgAKVAsaF8uX8gggvZ88f4eLV25fL0Ezb2HAAqzyFIiQsJAfyKw4fXnt3e1lQziPl-0h4L4Hct50O9FWERxBBvAPO4VaHN4cU3juQqD8dFfCPwzuvkZnT0myr9B2sUsoJE0spsb9pqg0AKaiVItUB1=w713-h632-no";
                        video_path = "https://media.giphy.com/media/7E2rsOxLJ3K9zo5qMV/giphy.gif";
                        description = "-No doblo codos\n-Pie adelantado o piernas semiflex.\n-Evito balanceos\n-Llego al cruce de brazos\n-Bajada controlada";
                        muscle_zone = "chest";
                        hip_weight = "10/12.5/15/17.5/22.5";
                        res_weight ="7.5/10/12.5/15/20";
                        vol_weight = "12.5/15/17.5/20/25";
                        subclasses = "superior";
                        break;
                    case 114:
                        name = "Maquina Pectoral Superior";
                        photo_path = "https://lh3.googleusercontent.com/iEGQvYIpKb0o-TnM9NRxCk07661dqgyie_uRYhu65i1ZdXBqYcdoWS9iyh-G4MMEObjyr-scXrrcSyVV4hccQYYHpJr4UEYNBJDvgHwji8znqJFRDHTqDDAuMbKthmYiQdKSZ2Rc4X813Mw5mRCjg6misRei-Th1HAuDC020XTOBZsnHD5-Ls8dqy_kBvMNyTfX6-nm589W7ds1PIRgN7pKB-GHrLzCNEi-87pEbG4wgyz7XsEnnBPFhIUu8m7Zbz_YgULt50hJ6zRE3dPE-ZbfdcDDUq7W6QgDXpLgsZ1FWR-o99CHact6FfTPMC1BzEEs30XXkpIeAdF74rctvc_RQHSnP8bOUlWCWGwAAYqmiA7Q2UUpTf0mPF8UkNYQN3oyy_MATwExhty3fdh4kxXfWQuC9wi_5D35SUFQ7cnYFeGlM4Gf7x81Z5iovbyHbyk9VwH105YnS8SHcel3-uhKv2RZRjAJZS2PFnafVsKclXLwBADKP1LzqNnD5_R_uCg_7npvqwTTE8rKjlQoSFS4PRVJaiciDOgcrWC7GWmLV1XjVEgQgdcZQnibS1e9aVBTH0xQzOdlyEN89TQGzSZ459REB1fHgtD2-4dD0udbmxQG7O2jKulwR4ztcVhpvrY41p0ICNhQdO5blfGelXW5D=w713-h632-no";
                        video_path = "https://media.giphy.com/media/TgIYDZOBGtrwAzBsFx/giphy.gif";
                        description = "-Hago el movimiento completo\n-Ajustar máquina, posición cómoda\n-Subida rápida, bajada controlada";
                        muscle_zone = "chest";
                        hip_weight = "40/50/70/80/90";
                        res_weight ="30/40/60/70/80";
                        vol_weight = "50/60/80/90/100";
                        subclasses = "superior";
                        break;
                    case 115:
                        name = "Flexiones TRX";
                        photo_path = "https://lh3.googleusercontent.com/Vqkrw4zP3upLa7BB__vTI4s1t2H1pR5X6pyXXxb4pznEwcHRtdg4Rk86GJog8_d5hV1gWlmsbfEIkoSH2SjzAQsS-Ue50pR9knQ7q8R078LQUZUskdB3lUrMzb4t1I_hDsgzVX_xsjv6BCJiTfepeKTjI7t6IUDzCVKAicIm8zdj9OKLvt6ITbABvyIyKkKjELMzqmGpMIxl0NvX-n7ll9Ye9tTW5X2D8SjzH8E83xZZ18DEU3Fb_x_vVUIfiWhPNJP4bBRy8_8DGE6z0X9lTJTQ94zpXdvW4TbrMYhfCpdOVSifNDEkoLyJ2-T06JoyRHtTMWULgW1Z1P_T9VQ64TjJmNog7ArAM4bimowENQULj3LaL-xz3-uD5_s01DS4reOtdQzUK0kkYZtQNsJm-XjQR9ZyDKWdj3XbxrF31QGB1sdXzImfDUzdDJTMTWKFpHLsAOOVndYUV3fBszJFNPOjWD9JYSNvNL6yUTKUndY0fxqm4ruwnleiOHecrpa2yL3Pofi8-RxWAlWb4rRgkRWz_uH-srvDbR3eiSMaJznStKstoHE61SbplX41MS-WbheF5uePGqEzZ1qPvlPh0HQHz_MwBRRjG2JHWbPR_sPI4y4fq6GJ_jX69xsXUxYWl7ZbtX0xA-PQzTSRYMqUAwOv=w713-h632-no";
                        video_path = "https://media.giphy.com/media/oxYnbMISU4JiLFxuDq/giphy.gif";
                        description = "-";
                        muscle_zone = "chest";
                        level = "hard";
                        hip_weight = "0/0/5/5/10";
                        res_weight ="0/0/2.5/2.5/5";
                        vol_weight = "5/5/10/10/15";
                        subclasses = "med.-inf.";
                        break;
                    case 116:
                        name = "Press 45º Mancuernas";
                        photo_path = "https://lh3.googleusercontent.com/jKub1XesxZ9SDX05yHDurq3MQSnrJk5eS2RPtr4j1zLxaqHqHYcUFUZd_SbQ2-IiTowWTACvoo1bfJvyMzyDUShheODev46HH4YeT51DGbQjIAzFHmtqm8gxZLQLUscZRoc1ADl6i5BoYgqVX1tUyryofgICBgSJgyXNYLXAPU4yiiaWHSyw_x4yNPN6GWMUJtqTFwrNd1TupV6ZEwamAtx9YLT5pkT-MPaxgbQlVuqJY_eBW1dLp0nySAI2uG2fQ31iEDpryU7v2dIrEL5u1wu2ARoEjXSAHxsSHgqRuHha8vuVgpJ8Uq3x65p8ij0dFLH-oYhiw7Qywl2yI7VVdDvJtbjyRwEq5EMAKHCAwYRypxBRjTyG_SqIMgvVgsBBr6ichq1kWDmmxhUh_AJultPTSYfp4vkjUKfAghDewFwL1X81qj_cURmOP8eT_KmjrUGM4bWPxAPNUAwqHk_1_6EtPnxhMXoB8Rxvqt-Q_FkULUI6C4YRPUTshETndQv_cCsCuXAdg1Y68zLgMsul4wSH5StwSjrHfZUPdvrlRVVHgrfwxlT8K9Jr52prIVVMDcL1BziVcyAQGb7lfUhgu1XRalb2VLdkP0wX3pd5sXSf5W682Hqt1VqmD9I92ZNzf26BbZkX1KH_O9bTrhDX59v2=w713-h632-no";
                        video_path = "https://media.giphy.com/media/V9QhTjEQbBySzbJQ6w/giphy.gif";
                        description = "-Banco 45º\n-Mancuernas a la altura del pecho\n-Codos cómodos al lado (inicio)\n-Subida perpendicular al suelo\n-Movimiento completo";
                        muscle_zone = "chest";
                        hip_weight = "10/14/16/18/22";
                        res_weight ="8/12/14/16/18";
                        vol_weight = "12/16/18/20/26";
                        subclasses = "superior";
                        break;
                    case 117:
                        name = "Maquina Hombros con Codos";
                        photo_path = "https://lh3.googleusercontent.com/-_GTiHZEoQ9sYwdmeksfjBsoBivKtR1Hnc07j0OXXrGYzjhtdiR7mfiFMHPA0dgtxHHcqKTQTewvqaMylmYFE4hG_YD3A9kNL4SavaUdKEsITwuXpx4wlt366DljAra_4MNYvAapR9eq3kybtRwmtpvoZZGFK_RLFXDoimi4dalyfbHvab0n_6gbX9630uTlyTc49l8C5IULMnUjp74R6b5eeON9Wvl-hqXeOIxfOUZPK1Pk3x2PwH12tEyGebrVJ2jGeCBt5FkflBrtpiqMPxQhAggVBE67c4h5Ystfu7-SIxnYp7tadhJyM51usaF6x8ME1bu3eblaId6UEXkguQqAt6iWpRAe4F82CTaiJy0DxrwqmA1zJ6wk2WBiy00l2GrS4odJ81Bi65r3xftYqyBioZDIoydTK4VTRpSsT2Dq0ASZHhoMaeVDLUuMst3xl5VNm7-dTObfBqmGUGG91uFoi-ooDusO58h1oWlMHRtowxLBoq71edeviF-hAfYP1v7qopivKTTUo9qt0tgcpQhhA0VcwbrFBcNsiBAqKvUT3cyF7tX9JSOKTPXZXaGJ_znphfrUFcV_cJgnT4k1n5D5paKYVXbLiPPNtez8uFq-dFN7jvJSCAs_NjiUbFp5WP0x9dGBi0NG41ZJ2nyLAotY=w713-h632-no";
                        video_path = "https://media.giphy.com/media/2bWSeoXmRSUwxjw00z/giphy.gif";
                        description = "-Ajustar máquina, posición cómoda\n-Movimiento completo, sin forzar\n-Subida más rápida, bajada controlada\n-Brazos sincronizados";
                        muscle_zone = "deltoid";
                        hip_weight = "20/25/35/40/45";
                        res_weight ="15/20/30/35/40";
                        vol_weight = "25/30/40/45/50";
                        subclasses = "medio";
                        break;
                    case 118:
                        name = "Fly Reverso Inclinado";
                        photo_path = "https://lh3.googleusercontent.com/1GpPkX7HeZfdoxFrXRxPIc1ORBJsV028uEV1vBYrSU1EMAEpWVDTYbuJGrmxgGY6SYPq-tHXkrmkost51Hkgqb6Ce8HTHAeYHfETiPCDtclsAX5eGf8auLqZUl3tiJXr188-ZQDBbwsem3lXFWU50ZUJmIZYylzXyqmzcu6KGAZY0T39Ay8-el01PjEMm3SzLxE8dh2dF5oRNEhRTwznwGKuLrJjKmpCI0DkTRT--F6J1awb_NiJJR9IuxOhsbnagC2nx1_w88FWEviA5s9rBv3PVEt5Zvp1O8GpOuW7vvn-bQmjP6gDXPSUueWT6bSunZcU61b_W8vNmAHMpsDHXiOpPu3Ewx2g59Z31VyA3Yx5sPcqvIvyLE5YTXIvyYlX5JCApSok0kdZgyToj4whG3oboUlMzWgOPIEheO3q_5gJiCO_k1dVjPAXlTco5JhRiPtCkYkU4GbqpH2laItO2ntTNfSy-G9AIjyhydWFYyfPfXTbFMXYPHdEuAUf3Q28K_m92UBXgr_9Z1PKUDPMTfKcCqpwMXKIMk2P9VUrENXFyBCh2-cXjhn3SeixDOWeKv64aN7LMPTbj0W6K1-TOJ_NSQrmDmMBb_XA76_g6q59gjk6AWgKwK5LOkMk1lM3dbE3ZSjCfZW__rDX2nzUdUSm=w713-h632-no";
                        video_path = "https://media.giphy.com/media/5vUSFFWKQA3j5hSAF5/giphy.gif";
                        description = "-Banco inclinado 45º aprox.\n-Posición cómoda sobre este\n-No doblar más codo en el movimiento\n-Amplitud de movimiento, sin forzar\n-El peso es de una mancuerna";
                        muscle_zone = "deltoid";
                        hip_weight = "4/6/8/10/14";
                        res_weight ="3/4/6/8/12";
                        vol_weight = "6/8/10/12/16";
                        subclasses = "posterior";
                        break;
                    case 119:
                        name = "Press Militar Barra Sentado";
                        photo_path = "https://lh3.googleusercontent.com/vJMENReIm3Ym0iOUK5HutTctyH9chKJZr-aXOD0QhEfbQCqBzZVEoV3DJYWC95yVzXD7cy8E3N6-GhARJLVvYDCusYKveqMvsfkiPpQjHXuUqWVTgVsMVyHHft_s0YqwOSJ0XyIckjDXgzMdBMZW35HLGxNZ-a92xGDEaH20CzAOpg63Eh7nGSr7nY4XdWSCeCAD_BZBGhfUTb3e7fD6fHiunG9vlz8nVeIrHKcyyHAOZUHM6ybFme1dOKP6vTSPqno6mB1i1BceXl6cNehDoGZkZ2j_ivmR8T9Ikieap6zmYuQU-6YxB9YZuynoGxRBXYJ-pAgoAbijmoxnHI5tPFTcM4NWso7rXdjGrDtc3xYxf243TdY1PjllPyJRRrf0xyWTIZtLe_Vj5-Jjz2PTzz-lVocektLYnigealcbJAFcdeFnmh8ex2y-sQ_k_pEh_9lVWZSFaItLRR4WLkljHnW2ssQPs_jwcuCE8cfNlm7LUtaZGSfT0Ll9-97lJcx40pITBRmZwtFIGZqrFmGUf12eiv2dQk-2g4r8HBJUKbTyRXeVHCAEXQd74objlGf3kG5KJTHptG5xE5v91is7FqjcSlWBJJiisLMGLXWE8hhoJpL898nfeWoBxdlTZzKgil_l9litrAX_lZ16ekWERo3l=w713-h632-no";
                        video_path = "https://media.giphy.com/media/xFkh0qh9GjLnaxg2Oh/giphy.gif";
                        description = "-Banco para posición de sentado\n-Barra casi sobre pecho sube vertical\n-Pasa cerca de la cabeza, sin tocar\n-Evitar retracciones de cabeza\n-El peso son los discos";
                        muscle_zone = "deltoid";
                        hip_weight = "10/15/25/30/40";
                        res_weight ="5/10/20/25/35";
                        vol_weight = "15/20/30/35/45";
                        subclasses = "anterior";
                        break;
                    case 120:
                        name = "Push Press con Mancuernas";
                        photo_path = "https://lh3.googleusercontent.com/z16H2L-tUv8sMTRr2xikCHiUltWcdv-LpwM058v6XB5mQ_RYGrmgUj7odwBL8OE5rDF1ZvBI4G4Dk2_78Pu9mS67Eg7thpipZ0UhhbU4-cpOAe1Ty1Oulcj0pDadBLby4Yqp_Jb3S7ZC-mfFdFhiXmWHN97To0970rfpJb0uQ_u1h9Z1PLZe_k0CeCZTe0Y_F6oYDj-cXhyM8tnqGp3agDzvcy9qkb1vtylgPn3496Pt0R_C_4xn9omzSLhcMeuGBiaPW4KisY0luL-bxQEyu1610Hpi80MCWNmnjD-xQRwyniONEm_5gIDiL88ochX1BB-3bSaZHQZ4LUk14wjc-gReTc83JG-fWr98D3Stc-MNGQkazo7Pt722fnbb3ymrnTA9XLh8iT0X3lluYzczBcVqb5j4uOIo-y1NQYaVVPN5QyxKgOFRHf2U8BYjkpk1bzgp8APO_Cr3YUO1-BHtMOgl2ytNOUWqn6EJ4csSLhCzBlWJjritH2QdVrtFDdpcciiXvM0sF_2NzYOb6F1t2E85p-QWDhLzOuWHGgUsaujJEWIuym3-NKte4FcTbbWex98sJtjLOSpAhbVWf66Au4KXyLOcM31JVgpsvIg92oZBAJmTp3dL6jJO4VF512_MgBr8fu6VyLj2F9lL47mSnWu2=w713-h632-no";
                        video_path = "https://media.giphy.com/media/BpDPkqQDNz8xB8l3AI/giphy.gif";
                        description = "-Piernas semiflex. o pie adelantado\n-Espalda recta, evito balanceo\n-Mancuerna a la altura del hombro\n-Subida vertical\n-Amplitud de movimiento";
                        muscle_zone = "deltoid";
                        hip_weight = "6/8/12/14/18";
                        res_weight ="4/6/10/12/16";
                        vol_weight = "8/10/14/16/20";
                        subclasses = "anterior";
                        break;
                    case 121:
                        name = "Elevacion de punteras ";
                        photo_path = "https://lh3.googleusercontent.com/bKR4aVEBg6-698SCpYedqqX8lW15QFyqCNg9s98i3AKjcYP4K0rnaPV2whhkcrpQAuoqreDWKEgLivibkA3bjGPlpeMB7kD1UNkHKGZmDOtxRgls0dQBRfzcJyhj7wjy2lrtyZzTjFEpkIrW30tM6pbwU7349SRdWwCjaWIzSkOp2o7CdlUaxA_7ps7J_BsrqnMQ6DjdXvQNBxJliYij0mAgBRo5Yi1g6X54NdsbBdd9pNaN3Dh_8JKGPgmuIIJbdYRl1I26kq1zbOOsS4S5iXMEhQarvx_6mSsZzzv5HyIcKzuR4S2Vura9kQABwYdefEw0dR0cfyndBjH7gSO438rpPgeCMoMr6u-BD0eRJljamt9hgn2mtjQxaCmKR0gD0SrYB8HYziFIlQgROIkg80p06RPAC04UTRfALs3nlpprWfELQaPdfelD34UUVDICXuqyIpporf_KFOlHHSMtFDS4hl8LG27sPlAleqgx7TvfBOrum4NIUpC-5OyC1sBsKgE2v5762YCgR1UKU4tB5GPnP8vZyuKSvSQyAjvNgk_oPiQtuUDKcMKDZSOspikMnzPY1kyKonfglNT61EnhHS7uEjTKpI0A-p7HsjjSgKQNFpvYE0XI28sw6tlp_pwRMpXTVeVMeRy8Vpl5rNkrsT4D=w713-h632-no";
                        video_path = "https://media.giphy.com/media/igGDYnbdf590kutIgk/giphy.gif";
                        description = "-Punteras encima de un disco\n-Talones no tocan al suelo\n-No doblo rodillas, espalda recta\n-Amplitud y control de movimiento\n-Usar acolchado en barra";
                        muscle_zone = "calf";
                        hip_weight = "30/40/50/60/70";
                        res_weight ="20/30/40/50/60";
                        vol_weight = "40/50/60/70/80";
                        subclasses = "gemelo";
                        break;
                    case 122:
                        name = "Box Jump";
                        photo_path = "https://lh3.googleusercontent.com/tv_cTmPlVWga08kBmdjiRrLoOe0Ktvms828GRX88BXntNbhzrEo-EC3iVil-U6Hd8MVdHaOk8Ez7fwidjMy2uuO7DHpROTzg6bQFkHhtb2Bp7vx5jfprWBGpaX8Qh6R5oZjGn5LjP7LxDTsAJVTAl7iP5rq_JLz8FJTQh9CmBCStT3_72OIhCuuncuSBGvIdurKhhg5MSw_xOJjp75t3u2gMc74C-qlzuhhnn2eziKHE44mzBEHbj1dhERNx6en5mnpqnNnolYOjBjbdTjrjX6ZTRJ3uwcM13J-CJGC89cUFjd2vMU6_7LARm4XIwngwfRB0Wzj5h6rAeYvS-wS46V2krm8Rq_N6irarjgasbL1qmjMkrfF2pTOheycWxh2CgJKlxPkEWRwD8IExeUGKNj8n2KWyIEVILxeBEq07WmAAXgYT-bgneqrI3lx-LE8HD_J12VDDw75m6b6h7CD9PxL2-iaAlWtQAKr6h7MEIJSey2JyvTbE5su-2IGjd_QX95bq5-GB3kO8FCdBPBfrS1E3ucjVbOPc2-cCZdltkbFb-g-gCPxe--rnZmoN1RJZFJ4ZSmwmWcE7jcD6Bzdq0-seDEHltOwVTGnveUjDiML3HmF5nHk5bWxhYfGEid-wekMv-j2JxGsNJA6SlhdQ1Yr6=w713-h632-no";
                        video_path = "https://media.giphy.com/media/3ohbdTPkVZ6rNwU3eA/giphy.gif";
                        description = "-Salto encima\n-Vuelvo por salto atrás (no caída)\n-Peso=suma de lastre en pies\n-No desplazo caja\n-Jugar con la altura (más dificultad)";
                        muscle_zone = "calf";
                        hip_weight = "0/0/2/2/4";
                        res_weight ="0/0/0/0/2";
                        vol_weight = "2/2/4/4/6";
                        subclasses = "soleo";
                        break;
                    case 123:
                        name = "Maq. Press Ext. Gemelo";
                        photo_path = "https://lh3.googleusercontent.com/tG1uBjqWcKOQOR7HSE00D-vpZeQSYMyTbyMb5ibV2fKyL7HgX7WDLRRxrRwQs_lu74yjXrnYhMb9BVRYPuBEu4hoZqn7sdKPL9qVuiMWDIH1_h5MnbrCUrnTMYPbdeqOoMsXNAcNUk8P9LHjTfrDUbFlj8xzqEygFnRs1FJ7lFekFu1IEBTaIDRb-ZXp4Ux_9RNaqu0wJfrkoq5tf7fJcl7WyKzFshA8HFlHxz2QSIbfbPVZy9N8DRl5fF6PaNqKY23TfOd2MtmzS3NEJg_EBVoudtWq52Ly-ab0zzjWvXv8ifVGKtPN0OaVGjofslFPafddFAOM8ukseM19iQUnRa9hGPaGeIw1IPFfB_0G73b604rARD_r6hlHkk5QApbNl6AL-vK2LZqIMYdmnJiRYoSMnhcUvicJJ8GOUbDdGvsp1BFf0Npyewe0O81TNC8lFv3cH0Gbrp2DOqc5c_jXzzYG6IuCbRB0wr-BKPws0ER-GLl53jcWUhEFE_cu-kZEnvu6IFoux6ObbpxELXgWThemNP4ecIYgTH_AJhb6-oky_D9HwBY3Uj0uE8atv-o9ga2X71sDlaSCgj4VJN1Irat3CWj4lETKOguzWXgw20O8HQGqhDIzUcEsg0vtjTTEgAPA3fX67KzV1YoVqHcoKXC5=w713-h632-no";
                        video_path = "https://media.giphy.com/media/cY4J3pKEhTnzHm6V5Q/giphy.gif";
                        description = "-Máquina press de piernas\n-Apoyo punteras\n-No doblo rodillas\n-Amplitud y control de movimiento\n-Ajustar máquina (cómodo y natural)";
                        muscle_zone = "calf";
                        hip_weight = "80/100/120/140/160";
                        res_weight ="60/80/100/120/140";
                        vol_weight = "100/120/140/160/180";
                        subclasses = "gemelo";
                        break;
                    case 124:
                        name = "Maq. Press Ext. Soleo";
                        photo_path = "https://lh3.googleusercontent.com/KbjLyJNvMpzqa9o_7-RbEc_CFCDLxfSyTB8bl8d12lG4Nmr0bWhiexCUfpZXv-R82HkM8e4Q-vM4S1h0HjGCk_XdFOw9BSoDSj_zdHr9LyL8d7GQB_Mz9pDlQeWNfH8AuZbH6iH1qPJzOy23SZYNRnWMnjHfMXDWxUNRuirCXTZO_GReePfEm7fDGoQv474AjiwVGa-1mbn5ZStRnlY9ziWBxq0Qdg_dsRcayS6ST6Ew4CbMY0282u7BixjLmrS3rYqa9KRB74gZ5ELKqFHdk_UF2KxgOWbQwatK3JJnz1Y_EAUp04MdHrPAKMpYv5sTocLyrxpO5z_YqpEUw4byRCme8EQNoLFmi6Zd5jpRwWCIkOfIilEKNMmydmAKuqbcjuf0EojPOK5lbvsn1VOpHq8_IBqUkBQsjqEYpI7ascgresW984PCw-MpKz3yDIH_Ha1vKStNlkSaRg3WuZpvgxWl2-sjg5Ktyr6nysJ40OBewMtUixwxJ-PyzFno-11ouUQUeTGJefKPJEzVlZV5gWnjhlB0o2RKyxmkpa-3bipvMTaARnmztQOPUB1Nni0QnOd-Idq6LpWKHd4rZ9-114HAD7Ghb9Z85JnwKvQh2Q1JpuPpOXFRSQEAK-qJyui_fSqsa22ZmiQaRqA45YXBjqpW=w713-h632-no";
                        video_path = "https://media.giphy.com/media/1XhrlvfIGmtM3oY4ZD/giphy.gif";
                        description = "-Máquina press de piernas\n-Rodillas semiflexionadas, mantengo esa flexión todo el rato\n-Movimiento de talón solo\n-Ajustar máquina, posición cómoda";
                        muscle_zone = "calf";
                        hip_weight = "60/80/100/120/140";
                        res_weight ="40/60/80/100/120";
                        vol_weight = "80/100/120/140/160";
                        subclasses = "soleo";
                        break;
                    case 125:
                        name = "Paso con Elevacion de Pierna";
                        photo_path = "https://lh3.googleusercontent.com/Q9Z6t_WLU7dCowJT5RpDxct0dVe675DaJvIjINQBIKMGT1N-SdWAOmwlcrbSeuNl2pZmT-UlMLWiSdRgLcc9MCubWBl0o2VSNVLgCQNtEZ9H1uLi96lie-j-6vOAYfcX7uzcXKhtCOaoIv_Wa6MlDlrhwZpqU1XnZecJIBtQpStALPtGidJlM6q1cOwcFFHHJct1Q1qDp-9ypp6-M_B0a3OS2dt5Tw3WQJ-UsjtwZN2VJvWQG5WXb2O4A-VBZuU15AOPKoTDf5iIxm33IIp_nVQlqFoMww-CbvguqxfllZblr5CZt9l9Oq21A3j4da-im3PB65gHrS3SpkZfym8Gd1SQHsafp2hFxo0eeFGL2jKDcczF8bqyC0iO4MB5-kwC3UWNWceeJm3bqQMvHHQ6QMUgYEWu2pxmsGBi-OaRe3KlsaqaDXb7NxeRtVmCw0gZuKM2kf6Iv0erEiSdpFnUmNjWVjP-Ucz3Sv0wc-MOdWaptwe9_SCImYJkLlIuwhupzkSM2gJya9WZlFV14faZoTkEwyMAtlKlW3Bu-MGnko7h3WuhW4PfuJsdEdAXyCya1Qxr181ckBfyQLmiD6D9i6LqDlawRfVi2OvFQcKrTZjr5gVlFQ5KOuTs60jli893Qo-HKYlhTeotorTeB1dC8Zl9=w713-h632-no";
                        video_path = "https://media.giphy.com/media/oxZBPjDe1Y8L1AIeIx/giphy.gif";
                        description = "-Movimiento natural\n-Brazos acompañan\n-Peso = suma de lastre en pies\n-Subo rodilla al final";
                        muscle_zone = "glute";
                        hip_weight = "2/2/4/4/6";
                        res_weight ="0/0/2/2/4";
                        vol_weight = "4/4/6/6/8";
                        subclasses = "mayor";
                        break;
                    case 126:
                        name = "Peso Muerto Sumo";
                        photo_path = "https://lh3.googleusercontent.com/wiotV69miQ0FvqcWJrYlhbtipsdca1z_Z5nI8EFWsYX2MW1uoPkaqsSktOFk9m38o5JiEHnDR3aRmhkeEnWgFZcp38MrWNzjaX9ok3VxxxeTKz4AEuqz8yP_cPkI4hkenUja2uB4LQhvyDyJPrhF_Onhzh0t_JGWuI8TtwigDSEmrfS741mFooHqej-Z-mGCbXzKXe3UPKCVRXTbq4jUSyeWe6svVBRo-ZJsNscC6FsHaTU1E1Vv_PIEp77CyKGIT63coYSnotvsxFHP2P8f1kY83991_SC71wL4ciSb4AGMXSbUuSQJw0Iow-avydWvF73T_HMLtO8wyIEn3vjIlA4uV2yOj1OZB3_nbNLWPS7O0n5q1kxqvOONeQqmaKPVsT5mOZ4d8zkC_HkSKwCB7zW9xDfkZnldfvRAhLL1ypSRwo5NaVjB5eesUoEO0bX0ndcoUX-7WBFf30EM-HVy51XK6n0X2RkNDvxBxoiGYYDDd1tEHNOj73za-7bX-P18TGuYAcatqfYn6tK-mjcVPAAFiT3cr7FKjqbggHc5i3m5U6Ex9Eg_q1d0qU88Zem_c-az8ewbZHn1XICMM7EAanqSXHokgMnnHTxjJdv4c7kqLeU1NQhphCGm1FQ9FogYznyT8yy67a46Pm7JCbGTvb-W=w713-h632-no";
                        video_path = "https://media.giphy.com/media/jVc6rROm00jQiDLNWd/giphy.gif";
                        description = "-Piernas abiertas, agarre interior\n-Rodillas no adelantan punta de pies\n-Espalda recta, saco culo y pecho\n-Movimiento controlado\n-Amplitud de movimiento sin forzar";
                        muscle_zone = "glute";
                        hip_weight = "20/30/40/45/50";
                        res_weight ="15/25/35/40/45";
                        vol_weight = "25/35/45/50/55";
                        subclasses = "mayor";
                        break;
                    case 127:
                        name = "Glute Bridge 1 Pierna";
                        photo_path = "https://lh3.googleusercontent.com/zecrFhyPXaqQEv4s_7jXUpndJTQ8OjER1EEx84sf2JRtAO_pd2aneN17KwGg72DVYhPK8aPUpww7qZyZPo3CA0O3VICo41EWuImCPZUZz7TjfoJKHwZtsFOWJ9z3xd16edei-wjR_WsvZZcyweHoa5-c6bf_Q6X0_bGwqA2b2T8LIQmwTD36RhHaVL4JT4TzXVXnSURJ5Ip2uj4FMYPzb6rlJwIkEpDtS45GvZCbwy2BfT_mfH4sX3lEn9erLtfE4jTLJbPNZW_QPP_8zb7b74-xBYSKEVGrk5zAHboKnRf3Kv5QT-UGBBOZgy_arvmR-tXg-WOBucop4tkyWQP9V2OlCW9oeezmNqLFYxQwxTruuhYDQvJ9DP2g1Pz_ltUV1lu0rz9WUD6atPOlg7qKZgReaqT_-1-hs1sgbJ0-deX-mXeuMBXIjSQtq0B7EWisfgn--Cjt8nrYZzU9DqvUAtxhoHvOFTGl1DyKDbrssoN9c8e8-XJiYwUCuvzRoWE9hYy1RnKKQ06HRey8e3mTcGBrvTTUiACcGwvJXTvFihnUAqnsWOT-9NQRarStUJEjXH9TY1nb3sJM-QwQTz4kjp8HAJCunBC-m_CY5_dQ2jby5OeGN6uXi9zK-mY7T3vun408ibOBz7tXhGDW_F2TglEP=w713-h632-no";
                        video_path = "https://media.giphy.com/media/l76Ix9dqzxUYteNfqD/giphy.gif";
                        description = "-Espalda en banco\n-Inicio cadera 180º rodilla 90º (aprox.)\n-Relajo cadera, vuelvo a inicio\n-No hacer retracción de cabeza\n-Un pie apoyado el otro libre";
                        muscle_zone = "glute";
                        hip_weight = "5/10/15/20/25";
                        res_weight ="3/5/10/15/20";
                        vol_weight = "10/15/20/25/30";
                        subclasses = "mayor";
                        break;
                    case 128:
                        name = "Flutter Kicks";
                        photo_path = "https://lh3.googleusercontent.com/9HejaUy__qfCNTcUfYnhAVvVrMc8FyYPglnUCkSEVm_AlO2dfO5_9JXSyIaCNnvAaK3UUnU7D6VlDKe9o0bdE0pZeJ8u7QkxU5k4uxjO6UEEjM7xgkjzvo3GxccUK4qhOgYsc04bZkmv2NZnaaUHe7Mp5L47Fo_wAfyFEwHaB6L1rTMyGqt-7D_rJXVU3e8Me9zbOTBqWZNz-QCs_eErewf-hIWorCOXChO4xUMNVHI9blIDjcqHxaC2zY96OWJK-JNjY1wETIVPN-jfy02ozPZAxejthyUXFeDpIH84q8FWzJYkYACZTlZpzP11_LvImbRlsNgnDtFEGNwDPhqY0pl2A2I7hLmwTtIqcKIaanmANRFqP82hp4OkbkjCeeB-faJFZBl-RiY0MFORfJWp4zESovJaPpPDNnevT3nPW3QrVnncevuw9vk-HEIY8-bgZUKfQ5OFi4Q4Z_OAbv1OehM8cdKjnf10uNHycRDCCLftHZXq7v4Jwg1AxZ5PbFbu2_hCR3BvD4Ufvghiv6ocgGqVsNF6CNBFxwYUti6bKz297m8VY2bB-7OWiaT3WNIQzlCpKublezYyrXqF4gFXVusv6f7NhPaU381m0fF869GbxtnRfYN3QMeIvXEmSHw34_hBEZOB--eGC5sFa666-gpz=w713-h632-no";
                        video_path = "https://media.giphy.com/media/5toEg8oq3Octu5yTCX/giphy.gif";
                        description = "-Tumbado cadera suelta\n-Piernas estiradas, suben y bajan\n-Movimientos amplios sin forzar\n-Alternando piernas\n-Cuerpo firme, me agarro banco";
                        muscle_zone = "glute";
                        hip_weight = "2/4/6/6/8";
                        res_weight ="0/2/4/4/6";
                        vol_weight = "4/6/8/8/10";
                        subclasses = "mayor";
                        break;
                    case 129:
                        name = "Bajada de Cuerda en Polea";
                        photo_path = "https://lh3.googleusercontent.com/Vu3FznNEsG0KFaoNseI_hGEJfLuvzrTntQtdP15br3NB8-_E-FIaVY11eeJw6qXzD-q528aGZOEWIUAOnwFueYnmeEEJblpX5DCq-KBPbwfIEWeEF3UPIsqOqx256wnO0WjLDgAzU7WllB1j59eVxumnYCgfs-pps4KI3TscI2ZqUDb_m3tmiq_Gmy4viwrh5oJyDeKR2hxGMFa_LDK-yp6zjqDylEhGZwxy53SfLr2TaMJ6N4N8wF4Tn0A8wmS02lG-rlztOi1t-GUN1CUTZa68O1NhZD6oI-_iMIYaV6mhgkt3neG3MIhE2iqN94Bt6o7zKz5VpkfFHxokkuddDcsHOqpgvW0j7XTh99FLFInLkvB99vsXhq1qaLK5o0JCrKs8qBJUkJ73-REOhg_N7BIj07zzbE_bsyHVetC9iM3LYN9vG9wW6CQCiYzeIpGJrA_eGaiYpcv5MQZUOv42P-iuXudu6ApyvIcUdv9dU_0qKkVIx2UShSSKwJEpXk65vtbrykc76L4y_PGzrphbNHg7mkW3apMNOarZrefz2ZarV7PwdyfDHOxuBvOA3qCd7IkXKZmYfzNfH4csPXecOTIOXZaCcdEr2kZusuiOsSG1b4Mji4JiCIMHyvGiaQSXutDiAm2g5ZiPRKC5wis2QWMr=w713-h632-no";
                        video_path = "https://media.giphy.com/media/1gUW7Ljv2Qi9MmmQyN/giphy.gif";
                        description = "-Brazos estirados, no los doblo\n-Piernas semiflex.\n-Espalda recta, saco culo ligeramente\n-Evito balanceos\n-Amplitud y control de movimiento";
                        muscle_zone = "mid-back";
                        hip_weight = "10/12.5/17.5/20/25";
                        res_weight ="7.5/10/15/17.5/22.5";
                        vol_weight = "12.5/15/20/22.5/27.5";
                        break;
                    case 130:
                        name = "Remo T-Bar";
                        photo_path = "https://lh3.googleusercontent.com/5MDzFRzmf0jdbHc3Ezn3rn8rKFvY3CxKrrHLub7zPxT1kchMduhgn8AduDBa2Rp_dxk37AUzblBRcQzhk_REIhRvMjmG45cWUIfFcUTiYUI2UhXvz28DA5KBm_L2HZMWKZXIvYTOEns-HyZ-mNQttj_2jhT7KjS5lYPFUv898TiHD-Hfvc9RhZpQtZeRuH2KFR00HV-8uymzQcA5CjLArdV1MZgHbeF9JZ6bDnIyZuT4HT9YTtrB9ksXOmJFAWflhGWR_NBDRhyvqgMsBmFMrVmI3hEHjxD6SkI415pK5rq7-GBLauFQKSSUXHxcYF5hB4Rd3OH9jqrDHNGCX8GiO5w84TBeQFCksQXFOGwjYMG6yCmdT_1vrYoxHJnbmkxn6gwqZvk4Lrk6iJAziNpdfj-nR6e0_Y65IvzkP9nAod6xexx1OYbVNL7IoprqsPQL6pQRal4lqP1QzgSqtVIdO5U0VKGF2yNvt946hcZ_ejKQW2j73HAw-SIiTZcrmUlnMAtxYo9zWUnaDAEjlkDyq__HsPp81Y8Sh8xsI3loF7Sl07qjTFflc-BgHK9xTxSaqV2ouYbp78JwVSfVdR7cQWOjYOT4FQ0yCXvfFFF1suzxuNqa_s7jROWMNPKKdUppxg-Eh36-t74KhY0zNhS178y_=w713-h632-no";
                        video_path = "https://media.giphy.com/media/1gUWdeaxbnV5eo5voP/giphy.gif";
                        description = "-Piernas flexionadas\n-Espalda recta, inclinada\n-Saco culo y pecho\n-Subida llevando codos a tronco";
                        muscle_zone = "mid-back";
                        hip_weight = "20/30/40/45/50";
                        res_weight ="10/20/30/40/45";
                        vol_weight = "30/40/45/50/55";
                        break;
                    case 131:
                        name = "Remo TRX Invertido";
                        photo_path = "https://lh3.googleusercontent.com/wNIOCBudZE7mzDa07nGXE4rfY1MZ3rzCMVX-RugqEelwVFWInLnmhziLDiAqND9BKrAR3ovq4DEiBJTYjghG2nWVOgLKFuRQsnJTKMMs7yltPVoYbBUZxnntNCgCDQyLxwCTcuM5ljnephqYpcQgWT_jI8pBRAVEdCHmM5LAXCVXtj-0eqo7fZovc_pSJ0JtWxZA1VmgRG8GOeiTAi_rws_bZAsonAegPvj9Vg741jmbA_4xy3VUp2fvEUJDbvb6kIRoLGjsfJfUsF7B_rcJSJjIvpN4SvvCg_ySCd-rLPcGLZmFFo5mXDW3y7bipa3_FZOz8aamq-JMAwWMzOeL_UM4QEpJBPISzgtfyc5V22lELpsl9CBUhyc57CGN2mUpECrffC0avZso-oRVnSV0Nu7nlLNueCKjnK0SULX4-RuT3aSFk4zwi9cJbNcqfHsq9zIN_Xl94PZoAeFv6hJUlHrfPi8k1oWAZXQlqgpiDcwHaDQL6_cUNDS7JSJzB_6ct7KCHNxG_uKrmyS3LoX8uJCJjzoDeOdH-Ry4rM0eDBr9--AQ5xJujt1dENVeQnPaeRhB9eXcmLT4OCCeMoXj9pVz3fwtFnU-I2WExR_ixsm6LQNphYejOyr-wV8hmVsOLW48LY4-zH1-Y84YGgJTAyo5=w713-h632-no";
                        video_path = "https://media.giphy.com/media/8Zef9CMPBlRiFqySOG/giphy.gif";
                        description = "-Cuerpo bloqueado, no lo doblo\n-Subida llevando codos a tronco\n-Movimiento controlado\n-Pies elevados";
                        muscle_zone = "mid-back";
                        level = "hard";
                        hip_weight = "0/0/5/5/10";
                        res_weight ="0/0/0/0/5";
                        vol_weight = "5/5/10/10/15";
                        break;
                    case 132:
                        name = "Remo Mancuernas";
                        photo_path = "https://lh3.googleusercontent.com/K6U3Z2OGZNMfr3aNt-mVpYNNo4-FH6t2LMhRD8aCKUfrt84Ni6z859yXYS15oFn4XiD5xiiHsZMF_hIjvCWCzIR8JRONFTiCWdExHrMt5fqwVSbvBAia2J0fQ_qVWleIB0PfFrWYopN-WT0IbtfCt1mbfi7jIJg7UZatWezHXzpgQ7cSfvH0o2hew-b3SfFwiFMv4yrkcp5nO3An596cT43WOZT6_vEBkXx2S2x6cyD6BQIRW-bKzoigByy35xYOwZMH9fomLcGOuySXk80Pvee7j-GXjT8inCQfZZcNQhfjiISVASd_2fUva09u5e9IYXmiPu3T0wzUAwiXyUnyQjAwjOi74lMdKTpHI0lzohXBo08c7nDXaFvzcvQGnbBLEbQEqzQFIka0x_IOB41prWbx3FVhErP1moU_l6qDf1DOJnBaoF_IRiuEJfH7MKCj9TEX8qO8lDhqYC3VdCip8BL-QYrlzp7fjwpmTghWcNrv9ZrC2CVSqmtkNR3T4mBaesjl-dSmcYJWTmqDjhco4KZCdGQveEZNqjdgwUmgUOTNXnVckO0VZ3tgziTYq17qvHs485FrJOUoLZYUJ3JErG7fxGT031aE20dfjHo823Wumtm2C2B5pJUNk88l-A-U5xDPK_8AGyD-J7g-eltvg7mZ=w713-h632-no";
                        video_path = "https://media.giphy.com/media/2mEfe8ryXe5vv2FYd3/giphy.gif";
                        description = "-Subida llevando codo a tronco\n-Espalda recta, saco culo\n-Posición cómoda";
                        muscle_zone = "mid-back";
                        hip_weight = "10/14/18/20/24";
                        res_weight ="8/12/16/18/22";
                        vol_weight = "12/16/20/22/26";
                        break;
                    case 133:
                        name = "Maquina Lumbar Girando";
                        photo_path = "https://lh3.googleusercontent.com/lhbTLaITXokzxm9Fy6IBe2Fmk8R8mYplbZO6TNlBv-ZHOGVHjpI6GEja6jPeOPY5ToHPngWq6tX0Lg3cLAg_Y2JqifVUng5Nip0grUqJBWNioS5G9-gMmKkxkZbKQXUbrzfZhOsMQIvIV6uzwWjn5MBXCYAQBvaYxC2EoUOYpYng6hG2JEHhr7E3Un1ljetpHd0ZjAWTLLJolP3CDLCNqQtcQkP4pe7aYyaDnw7F3w4JEe5H94k07lAbxFKeDOsEpMVJMhsz2xBs5qBZyNAUf_RlH7_wp1g27LePH-bq69IQ-bXFkZjo-CqetYcVJU__a7E_ZuVPaz-NO0fywjYs85zrL5Yd5kFDLJ0XN3VeMOHCl6N90B-Vbi0TvONKG137O_RGBj6hrb7AajzWtIS2Ax7e69tJmksZxhsjbFkt2qxiaCHpqHHP1s_wc5G_XpnxD7m8Xvw12g-odpngepjxi-Bh6vsDT0QbBrsy0mhEiN8TBnIsx1ZW0IXVqLgmfxFAAvp0mE_QPYHS__nnlWMSxCsHS1IyJVJRMErJze6wmt0Dz8bngfl1RUZBrOs9i6idNROp8s0Rze_45_RZiku119VkYvA6kshWdk_PptKUhTK2YprBVJXdgarzgCzFUardQzARpogpSkAoK6Jkw-pViiwZ=w713-h632-no";
                        video_path = "https://media.giphy.com/media/12PUH4DfqiyDZgb5Ip/giphy.gif";
                        description = "-Rodillas dobladas en la subida\n-Giro hacia un lado en la subida\n-Alterno lados\n-Movimiento controlado, sin forzar";
                        muscle_zone = "lumbar";
                        level = "hard";
                        hip_weight = "0/5/10/15/20";
                        res_weight ="0/0/5/10/15";
                        vol_weight = "5/10/15/20/25";
                        subclasses = "lateral";
                        break;
                    case 134:
                        name = "Lumbar TRX Isometrico";
                        photo_path = "https://lh3.googleusercontent.com/raGQIUCI-WeparnwM12NPHF_IxuwH9NIpLqE9Klx9wBDqAOqRjtnp1M9TFCc52RTbE5nMNyNBj-gE6YYHqq-1qClwidOoTWJt5Oz1uGCJ9V0UtHp7QRosyWc18_O9uBRF2q-ynyzP6T-nac5d7cgogRUp2XvwhjQDhRYGDL0aynV3Ftp3E9zlGA7UioaKx2FoVeF2KtCniWlZuFlX86ZppIBhMHRPelWcJ_bG-nUGeFgsC4ZUiXrtpEH5ABXfvHTWBCR7B4fylgHsg1V3i2hngyWgy5AWzUdPcoChLi4wUzs_EhZXT_G5XoMVpsL0tRtPGe0AzkJz-alh9_xF6BFHoNTJoZl_9cJ1Btt6kRRObqCYJyA1bxxaqwpPhF4cHEG0wFyHA8y-KrDPHWRzJ0nCNJ8DOIgK-WMGuB8_EdnfEE7EST8cv8qXwcsqh7XEJdRV0bmjB_y94Ye-42wssbFsfbDACZUQsyv2C-szVxUauPvOK1LhggQE9vyZf8jcZlciP57PD74fo4s-Wxf2iNCoP1VBi15FoDjZhhllrHCYbuPO0EB6qTg0jFR-AcQgh_4-DVF2mQef_Jc9SndkWw8hBBXDwCovs0Lf-2WqdIJRV-3yUhF6I2WLEZ_dcrSTW5fP-00i60Tb_N-FKiNZgyVQYnW=w713-h632-no";
                        video_path = "https://lh3.googleusercontent.com/raGQIUCI-WeparnwM12NPHF_IxuwH9NIpLqE9Klx9wBDqAOqRjtnp1M9TFCc52RTbE5nMNyNBj-gE6YYHqq-1qClwidOoTWJt5Oz1uGCJ9V0UtHp7QRosyWc18_O9uBRF2q-ynyzP6T-nac5d7cgogRUp2XvwhjQDhRYGDL0aynV3Ftp3E9zlGA7UioaKx2FoVeF2KtCniWlZuFlX86ZppIBhMHRPelWcJ_bG-nUGeFgsC4ZUiXrtpEH5ABXfvHTWBCR7B4fylgHsg1V3i2hngyWgy5AWzUdPcoChLi4wUzs_EhZXT_G5XoMVpsL0tRtPGe0AzkJz-alh9_xF6BFHoNTJoZl_9cJ1Btt6kRRObqCYJyA1bxxaqwpPhF4cHEG0wFyHA8y-KrDPHWRzJ0nCNJ8DOIgK-WMGuB8_EdnfEE7EST8cv8qXwcsqh7XEJdRV0bmjB_y94Ye-42wssbFsfbDACZUQsyv2C-szVxUauPvOK1LhggQE9vyZf8jcZlciP57PD74fo4s-Wxf2iNCoP1VBi15FoDjZhhllrHCYbuPO0EB6qTg0jFR-AcQgh_4-DVF2mQef_Jc9SndkWw8hBBXDwCovs0Lf-2WqdIJRV-3yUhF6I2WLEZ_dcrSTW5fP-00i60Tb_N-FKiNZgyVQYnW=w713-h632-no";
                        description = "-Pies en TRX\n-Subo cadera\n-Cuerpo bloqueado\n-Peso: disco o lastre en cadera";
                        muscle_zone = "lumbar";
                        hip_weight = "0/0/5/5/10";
                        res_weight ="0/0/0/0/5";
                        vol_weight = "5/5/10/10/15";
                        subclasses = "normal";
                        reps_obj = "50 seg/1 min/1 min 15s";
                        break;
                    case 135:
                        name = "Peso Muerto con Barra";
                        photo_path = "https://lh3.googleusercontent.com/EdXCvslIWlI7K6zckPUtmHQuW5f4Dc2Qhs6ajgyi0RAOdzn2LdiKfyiCciH_tX-zCZ5XXJrQPxxoUCzc2iz4UZ_G8J7aKUvUeTLSzuNQtpfged9pjEH9PWxWdtiZqghZD5548CBAeEHbeII9Im2dGhb94Xs6V8Cawr0LzwR19HLH1QHBacvYGcnubDxL4qDMBHRtmtUKzLvpCU7eRI3QjbUnPaQf71iURKkxX6v1XH1jcn-xZZ_lzaO4ubivoiu_ygMhX4ydTmcZYRKqclhT5RL8CJoxxofYbTQoMiAFDAEGuX0KYR-c4RFzNICzFkSdYNqFYvCTib4_SQ9iosbmUEacJGgi45FUAUqeBGVSZkTvWwXuNtqG7cF6JZTJd6s0I81EfAcSuBzCqMEU92cb6wngKLV1XTenuVb9g0R3-8l7tHIHU1PeIEL56rZ6Zk60PvyoTUYZfTSvDSTfCJfh9GstuQAnufhxNAv3nYqKwI99aIH6wmdQ3BWoPFjyWuyg_68BBx6NYGqFgHk5_GuRDjoWWEq8sdOp3THYt6KKPh28USQB1y8K8vSz-u56XHWue9QRXJ9Dulypbp4EZtOk98vXgGprqLZ1RBchAu72wqeCi-tP1mTfI7TSwG7T_oFNqe_qI8guz-dYM4ibJHU9Ofry=w713-h632-no";
                        video_path = "https://media.giphy.com/media/yMzm6l8tID8C74uhwn/giphy.gif";
                        description = "-Bajo con ligera flexión de rodillas\n-Bajo inclinando tronco\n-Espalda recta, saco culo y pecho\n-Movimiento controlado\n-Rodillas no adelantan punta pies";
                        muscle_zone = "lumbar";
                        hip_weight = "30/40/50/60/70";
                        res_weight ="20/30/40/50/60";
                        vol_weight = "40/50/60/70/80";
                        subclasses = "normal";
                        break;
                    case 136:
                        name = "Extension Lumbar en Suelo";
                        photo_path = "https://lh3.googleusercontent.com/J6Ko7uJl08srwjSpdxV_-oYHlHf0dyojBoIFTJVsXGA5tlS4e4T98x_jHnLbzh0sm7TYlWLBzRLW08GpWNNXVx2pNraOkssMpzAyOYhJfoZ7fqp67sIRVvpMibgxRNUj6lAFrfxDf77_xLPk-spGdutH3qj5p154gruCcMzGqHGjJQtMdNS4rtoUzm6Dlj-qpR4ARygDBaTgmDVSxIGfNwMVkWHSlFIq4-VMdP6gGyXDx8o1PxfIVs8qbLsCQRy5iZ3wfaHc91z93CFyWm0FMhjY4iO_kGNqmppExb6B2Ny-tvrm8uiF1D14nRCT3zgIYYHEWtctGlPkOv8dvugawNW6TXE78ztLvjkvoEDHIMmXosSQ8EBT9BPbCEjRHwiJgUyTa4AsTzq3_pAq1LA8cBmtEYZIN3FQ2LE0DGLDel5EBBzjQPydnSRIVRVhjHJtu7IaMUeH4O0Vo-HV5Ph8k4UoXS9F1qE2KVsyQjKamP_756P8sEqmNAu37LE5Vn3wRTX6RggaRKhpaM6tEyfk32twRRFy980ccW3UFONKysDfJLcVJRvkQzKWBU6xmZVXUdg6UgnwNwD9Z0mosEr9E_h7n3CKu6BzCtAvvLlduyNttkClp5NIqTpude2h-QsJQhbrjJiFuWnXQsgakjAeYUMG=w713-h632-no";
                        video_path = "https://media.giphy.com/media/vRHPj45jrIIBBVHHz9/giphy.gif";
                        description = "-Inicio tumbado boca abajo\n-Flexión lumbar, subo brazos-espalda y piernas\n-Movimiento amplio, sin forzar\n-Controlo lo que pueda el movimiento";
                        muscle_zone = "lumbar";
                        hip_weight = "0/0/2.5+2/2.5+2/5+4";
                        res_weight ="0/0/0/0/2.5+2";
                        vol_weight = "2.5+2/2.5+2/5+4/5+4/10+6";
                        subclasses = "normal";
                        break;
                    case 137:
                        name = "Aductores en Polea";
                        photo_path = "https://lh3.googleusercontent.com/i9d-sXKz48w3muDl81fvLm5-zW4iAAfjO7dVoV3tHRHXe92MUuN_Swy4AJJCIiXMxxEywih-ey2ZAYAK58SjA8jViaVqsTPUBDwZ_se06glw1UhqbFz2t1J6ckHrXeSpDNsK1fiUAfLMLezzqdIlRc0niUX6k97LEkiY52-0A1aB5mFFIJ2J2MkYc2Da-XpUlwEatbpTGScIhOFdkfHWQHlIPZCidqLD-kyQImDoYoc4ODo3CjyLTRgkvXbK2G65ocwee8VmEsGPLDDDjxpNmbxAf2VvUsAEzwApC8aa_0y-8p6ws0MpGWUhZ1vZB3i77h6FBsZIh7wWQKwLn72CH-TMM5RGrDacUKrKgawH4RPqvuzVdedUkCLAWeVQfwe2aaUagjiNzJa_ZnKHBwC28d1uk7WcPsXocwH16STKQfuEdWoNhCXAsdGVdZFEu5JYsa_pe7RpCFKxPssGhlplJ7Rx_9bRSHs7o2McwD5sr1aoOPoq6OjaGQ4d9BQ4fPabSArbLepnV7aL0GcYtpV39jNAPZPyEW5hARZPU9gRcJWahxc5XRxFJ3bxiVX8ppqCC05P0wjkdi_tgo3ztj24l-tbb8Bni1BwbSCul1sOwxLEvBm-MNYZJWTzndluN7_l60SNd-cNQa95Bdi9kcyt3doU=w713-h632-no";
                        video_path = "https://media.giphy.com/media/2zdVi3zVbjIiOvyY5L/giphy.gif";
                        description = "-Pie estirado, no lo doblo\n-Patada lateral interior\n-Vuelta controlada\n-Resto del cuerpo pose cómoda";
                        muscle_zone = "thigh";
                        hip_weight = "10/12.5/17.5/20/25";
                        res_weight ="7.5/10/15/17.5/22.5";
                        vol_weight = "12.5/15/20/22.5/27.5";
                        subclasses = "local";
                        break;
                    case 138:
                        name = "Abductores en Polea";
                        photo_path = "https://lh3.googleusercontent.com/Z-A4oOO7xZwWQO1uicZBXMoPVx4J_EfmQLQxQJ9mwqhv5is6IumzPo52Dyg_gHXUUm5lLv4xnmtpoJbcI7cnOLpgUgWpymGn0FlLCVhUYfjG3bQEsfuNUThQvWLGA8c-pl1RF2EqBXNuPl0K66IfDHDu3wgWD3GSZ7WsuDklr3VGJ_8gc4E_AnqzVYqmLXE3IkGQzW6pU3-NlJfxqP71bZvOB5lYHvJSS71EWy2PYBtjg__L9uAjftCJx-7K0nSisGvaTemQYnMpPJaMWG2tv-ONZFAUFFifLmOzQniEE4nm4IU6dByh17M5EGsOKJKO1OmnNvOev02j258Hww_wGRQdY6sNUiggXCvGeSg-IgJMtPeEZdlb5J4HlupjRVCocy75lA7KnUok_ch3gEjvb6hUDJ16s1ar8HguvOXz5nJGV1YSqcXeMXyfhGRAvK5ZhzgdyueAcSPbkksQnukYMu_Ecfq37xiOCuBO3KGXU1ybU3drzb7uHsAtIaZhpZ-_FDwE7LSzbynwATIyW0l_UnuvpTU6vub-9tVUD49sKqJ9Tf5EOYYxvbVZ46zpQvk8pmYR_FL2Lk1oVBwZSYWEy2H-8l2EAZbs2oDYy8pgi78KBN7BY_x6JvxY8555fyTmLN7GsJ5a4iUUPBJ06kFraH7W=w713-h632-no";
                        video_path = "https://media.giphy.com/media/NPHjDsNIFje7CdO6pi/giphy.gif";
                        description = "-Pie estirado, no lo doblo\n-Abro pierna lateral exterior\n-Vuelta controlada\n-Resto del cuerpo pose cómoda";
                        muscle_zone = "thigh";
                        hip_weight = "12.5/17.5/22.5/25/30";
                        res_weight ="10/15/20/22.5/25";
                        vol_weight = "15/20/25/27.5/35";
                        subclasses = "local";
                        break;
                    case 139:
                        name = "Maquina de Cuadriceps";
                        photo_path = "https://lh3.googleusercontent.com/jbgEm1o5fKY035i69XBZjlN-6sDcS6JPKbFsDlrS-pxefTLN83YdxUhfg2FbQB3V_EcKiCRqztxBV0GK08yJSQ9m5c6ymGwpFIWjc834xDtm9f3oSxsVh8bCPIhTJpm2VhS8y8v2AE-R8kG2uex9n4AFEy-VpeU6zUze36O-g2IkRVu4tzX8bhn28LnDkYNLn4PjV66rAbnOGiBlwOBKqItRmo06YVZBpoIKnQq3szLlpf75nSI9B3uaKtl897rJUsVoRKxque2eyF-_9q3y8u7n_ny6hrjiy6yVL0rFOAYUJ0el1ZcH3Wd-u4hPAx4lonsl6tyzqMP7O71EMzIshKrv5nEhl2aKzV_N0PFcoydfZyY0Fk38SoX7cAIt0VTvlU9HCVORUpzUOKrw8WuTkMx_LVfEKTtlfJ03-mgzLwrV2C71Pa7Y1RQ0A0gMWQTR1_4icIFQWAPXBbNdzrjvh2DUD6QA5tROPL7iuDMaoilm_uoe-GUTDGMjxKtVN8Vz2ohhI5f7LkERZwo4Ow7yizczL5WI6Ngx0C_pSGdooNh5s9db402BelTKKvFk1bcvhw89tMiy0CVfEgR6XgWIEaCubrKzKdNkJyfWMZyWy8PLCEHG0uZMvui12Xy4NJTAm9If72R1xf9sZ7ITxNu6wywv=w713-h632-no";
                        video_path = "https://media.giphy.com/media/5zw8PEt9LisjDkBsrS/giphy.gif";
                        description = "-Sentado posición cómoda\n-Extensión de rodilla solo\n-Movimiento controlado, sin tirones\n-Subida más rápida, bajada más lenta";
                        muscle_zone = "thigh";
                        hip_weight = "20/30/40/45/55";
                        res_weight ="15/25/35/40/50";
                        vol_weight = "25/35/45/50/60";
                        subclasses = "local";
                        break;
                    case 140:
                        name = "Squat en Fitball";
                        photo_path = "https://lh3.googleusercontent.com/MKm9RY7zZ_4zPsdcBa848pJexKBsQMAWzhVbm2-0hL0MII4zSHaM36iVe3wJuDa5Jcxwonl45jxedYHrtHup_pbndDL-ke6suV4ciEyY9C0MrPWDLXaU-SmNjTzYJqZkqMoc83qYP4m1yecz4yvGzZcyUBJgf2jPhqQDLYQv2srA9QTBwvMs2U8AXFSpuAhorBbExWIQlNhyXR8XY-HdY1_bR0UFByw9xmMyR1hHywOZWjU4q1mf4zSXnqtIJcglykHcDy72f8uwAGh4Y32xt7Q-7ujG3PFmNrCVsoWuZ64flpD8A3qBtUAxtYJQAMwx2tZ6S85OVliQ4dwLQimjjffFiPabj_tQlrCxlyt9QgcxMMH_toUPSq8Th8xt63dsd3FgOhblOhGvuDsKChDWfSQlKVFOskZEraDKF-EFpiU-A980FpHWkGxWhG5mCbsZybozNKsMPiLfF-ik7uh1d24SFyxfNZXlN0szax2QFjKQbFpTi2B_Qyxo6m6OZSh4JoACWXDAfk2dBLnv2m58HeMdKUOKymFp6R8W_fm8RHwGd6TDPmTn30hr5IGThS4hZ8nrF0ymsiU13lu1oh89D8Zohd9AYC1jrkmeZw9m5zMHWuMRmYcquFE5OMZi7gj5H0lG3QlUj3eQzs6Dx0-0Mx9q=w713-h632-no";
                        video_path = "https://media.giphy.com/media/X9i2BF4fJ3kD77ImLb/giphy.gif";
                        description = "-No adelanto mucho rodillas\n-Espalda recta, saco culo y pecho\n-Equilibrio, control de movimiento\n-Bajo lo que pueda\n-Si caigo, vuelvo";
                        muscle_zone = "thigh";
                        hip_weight = "6/8/12/14/18";
                        res_weight ="4/6/10/12/16";
                        vol_weight = "8/10/14/16/20";
                        subclasses = "global";
                        break;
                    case 141:
                        name = "Fitball Squat 1 Pierna";
                        photo_path = "https://lh3.googleusercontent.com/dk4bUOC5nub1aVra4HC6vP-cKYhpFbP2fmCKFDFF4EJdqjVu6GrUpWsnRjn-DSGVY5D0hnp-LsQ-OrsM0UpPYgkIFgjtu7yXbU7VVBRrv8CRgffW0HHI5zb3dwcTM5beyMY1uPlfzkS976bhY8R83_sHoHi-pbz9fKjI9e-l6gkSYJaxO6fjssc51c1UiSXMerpZAGMFuT2dq9bQt1dCAEtd6ziAALbTcvSeyyt3UFhYDUwmzbmKf16qbvd1QSXBqc8M2bF-XyskVnJEnSr1KmDpCNM0rlZhivt8B1VjOMKkMZZb3eM8_pPmS5AGzIav1FEG1z5INBZuxMxZQ9_n7wr9dzeP_skxJPV8lf5It3Q5llMfAmO5vMSxB46464eeXuDawxgNmCQOITXWCBcjiqsyGaqyanoXnyPT9WvBs7T5b1AZ3xtKglc8vkZM19zxkzHvgS30jTQ28kM3XmHqjFNYBNwHVnvLrcDY38DufOB8WJF15sbS9KTnzyMWelANAi7U4IIVGTkxh-uIelc6U9zUjFRE_gKee9FqkGPILSoDxXHc8eVzOmMXUs6_WY15t9twRkyA8segfbE5yPSQ6SFwsBKYsrDl1_d6y8IIF1VNTBLRiQpTpPqOnRBvwPfT46SXJ42DZaSMUcpqyydJLdZn=w713-h632-no";
                        video_path = "https://media.giphy.com/media/9J8XZah8QEbUOButZo/giphy.gif";
                        description = "-Bajo lo que pueda\n-Intento no perder el equilibrio\n-Espalda recta, saco culo y pecho\n-No adelanto mucho rodilla\n-Si caigo, vuelvo";
                        muscle_zone = "thigh";
                        hip_weight = "0/4/8/10/12";
                        res_weight ="0/0/4/8/10";
                        vol_weight = "4/8/10/12/14";
                        subclasses = "global";
                        break;
                    case 142:
                        name = "Extension Barra EZ Declinado";
                        photo_path = "https://lh3.googleusercontent.com/q3ZH0Wsa7-DNsoARcgNWJpes4854HIahnidXOXfJA2TAm2IueMr-q3RoAPlVon9CVuqvZuAdZuCNz69F6XcZtAmDzR3lo-MNE_C1x711zOMsTIzAn8kPUAymOe2RSVs5TKM1VG8hDqDnejDxGSg7WYzDufYAR6oQHY5aQiJy5WCp7KTQezGoVP7tTGFLTaMZc3XNkt7u3mdRx2G9Q2noHppFRHK4TalG0mLQndXB_1I9nMvs-Sl9WdyI9R0B8PIIa6JcXCysacCmCmNaBHsWYisoWFiCHZbLwXsQnEl2ZKM50wXNrAezLr289mv87y4vi7zD5gHOONqu9zLwro7k_DmiVWITbjccRNmNXbNOvZFP7fHU0N9B6QIj0zPOKmwYn9wVp6WTkdQCF1l2-c2vO9NJyV3Y5T9bWf4jdy0y-MY7yKjIAilcQ-W-UwggeMCeAl3i0ZDV3IijqkYxwWeCcBVeh-bTyIRhUPEgLdBuZZWs-ZrlcFRVI7bcaZPipJofleAbo0dsdOvA9o1txWAWMB6iA7vc_RxbQylwcx26J6C8_Ql5iuW795W4YM2qNBtKCBeQHIiQSRri3QJqvL7DrQlHU5zmmQrPX02O8O5_5dXwVl7ZDsVv5E_PsxRQQK7-t6T2mMhg-VG6XUbrLNMLou7i=w713-h632-no";
                        video_path = "https://media.giphy.com/media/7Tl49qaA5QoO9YCP7x/giphy.gif";
                        description = "-Banco declinado\n-Codo perpendicular al suelo, rígido\n-Manos cerca de la cabeza\n-Extensión de codo, sin movimientos adicionales";
                        muscle_zone = "triceps";
                        hip_weight = "2.5/5/10/20/25";
                        res_weight ="0/0/0/0/0";
                        vol_weight = "0/0/0/0/0";
                        subclasses = "c.larga";
                        break;
                    case 143:
                        name = "Press Triceps";
                        photo_path = "https://lh3.googleusercontent.com/XjoUIqWC0i2wyUWUJHEduqnN8CfND-C5h6Ghh136A2sLsAsld7jTh4pwxnazMVmfT6zoNzShh5HF0jgPx6sHqtEBRFxNdow5uZSLsYF47y-t_dz1_KhSgtxXVmZMusXmDWmTeVMMOG1IPtsU0Xm6ioW-NJQ6mBeUxFXIDxZOCQoimYkz_CGuJn5p4e4Q4LeXmJ5meSqpanDOAYWJpv5X8qCnLRV7vpSuPhjCKXFQYhNfW17NDstuAvqgD8ZZjJgERqQz0Nzi1Yfxi5f8mHfT7PydjtBOaYHznNU4s8Yhe5qltcB2L6NNf5n5XiEQuxjZIotcoPySeuYFs_X3Ca3eIIlQcFuQKgHAXFnTcuw0EwSwpn3k_J7Rx0PLe-LQYhbspO1xap2a84ik5IX4FqNns4ir4HJDJUp6oeTTUsju90TP329F50g2FCGROg5uIXuhwkXIuWEX1JKg5SCehGVah_3ATIXQ1mRYLS0092l7ez7tbUFHQ_Z_45XvnerK90Ect6vaKUQcOOh4Gucrb1cQSWxDxtvRz087Ejo7BbRmb1k8C9fz6ZlD2tujewOkBlKrGCmNsqqppklp67lZ975bit7Ex8wRB1Xo8MM35Q9N011iLN8D0kriKoO65QH6DysI4B09hhQ_gqVpG3TA2ZTtYkDR=w713-h632-no";
                        video_path = "https://media.giphy.com/media/uU8UjZMmcJDQv8gEqx/giphy.gif";
                        description = "-Agarre cerrado prono, sin forzar, manos ligeramente separadas\n-Barra casi a tocar el pecho\n-Movimiento completo\n-Subida más rápida, bajada controlada";
                        muscle_zone = "triceps";
                        hip_weight = "10/20/25/30/40";
                        res_weight ="5/10/20/25/35";
                        vol_weight = "15/25/30/35/45";
                        subclasses = "c.lateral";
                        break;
                    case 144:
                        name = "Triceps Polea Barra Supino";
                        photo_path = "https://lh3.googleusercontent.com/ov_OVt4hUp1BN0Z5JB99AwPmlkovFAbf2FSyjDGDmPtIi8wIPAa5rpQF9aU6RASn5XahUnHQgESw1o9F2mkx9vDLzTUENfN1V8mT44zjyEq1ZmMy9IXzjOAHkSU5LBBGLydgd1fDc-blvjtY8lMmv_pu2jacAJD5LLGQZRVOwFaEr-tkACpfEw6oYpJslH8a-_xUV-wDqJL2fbKWSVmYCZ4yseWm4ERB5gE5E9LV0WF485Gg62UzMgZdrMkt9Fp8lBrhFSett0HWQ9xdij-EARZ6UEWB5978sTjlD540ELAlimERQzJTuZbXB4MDw3fC1JXPDaubFQrTpusSSxjkGQAZ_QijMr6xhaNZSWqKA-DA9QP8bbM65kwb2FIiCOiPxF7ga1roCbJ7pwBCS4D-Mgtg_blcv8CzrgtC7Lhm67AMiPJukRes2SR6byvyBEQNW1_ZvNT2zhqmtSFOZwJKwh2sG74lGfTRqzf__e8bPgWvZd8jZ-7qpXx7KUF4SM_8BM7fvva3WMd87BgO7RaVeFdZD1_dEnVSExGW4ojWn9Yuce_DQimpMTFwqZRBj6e4mRDpzAiGQYX1oVmthZCp8-CWkTD1ULMyeRMEksnF4yBBlQKePHYnuQ10wdigNrmPmnzJFFrETTnQ8gk6mBn-xda9=w713-h632-no";
                        video_path = "https://media.giphy.com/media/8lPMWahnH18U4pLcJv/giphy.gif";
                        description = "-Piernas semiflex., espalda recta\n-Codo rígido\n-Agarre supino, barra\n-Extensión de codo solo\n-Evito balanceo";
                        muscle_zone = "triceps";
                        hip_weight = "12.5/15/20/22.5/27.5";
                        res_weight ="10/12.5/17.5/20/25";
                        vol_weight = "15/17.5/22.5/25/30";
                        subclasses = "c.media";
                        break;
                    case 145:
                        name = "Dips con Banco";
                        photo_path = "https://lh3.googleusercontent.com/2FMIZudtWeGicUbOtFbZ66X6WBL0MFLJkN7_PqmUJMdtel0-6XXI1SOdeSEBRT9QNRZ8SnBpPwNwBlRqKmJPn0jI4pa9qJv3P2nChSFVr2KxfPCjzEdHq8CZEOhLD0CiBMiZjyIUbITIGbM2mc497zV4YtulEDRp43t6zncvjqT5jFxFN9c44DZkDK5aLzaS3e-rzAjRfHEvpx2UMGZAW_DjJ8cvxKSnB8R3FqBjJSyN7FRyK8-kjVFFfK8duvfYzd71h9qlh_vkOSrCenT-nuON4L5qnvjEMk3d32lM7QAzRkTfEHmu60e2BRj-Pfifx0g07QnpvNzn6qtTUPZb_1SqF_HMF7UQyiZpHJiNDuj4GtEva_pK1qGoVdYyE5R_Kzyiie0RCQT_69XevGrZNXML-RBPFq6eqULmrr0WvcGqe-MqQMzE7dpaZUVNjVhB4ZXs4huMXl9rg4Elco7O1eYB-F-zbxW8VyYuFmaSEQLl5PGfcT6I4Nv4wpJSCccqs5aE0ilIL0Pv9c7MRnD1dI2eVThWVdasqPBLHU0yS-MguDEkT6UV1QWxyXtvbWfulXMUSaP7kqQBdJc3D7je1PtKI7ePxR2HKZLOg5UAjiTEm3LhCParlHkOQAoOUlDOKUZRFU3kNP8XOB84v3gOWwgU=w713-h632-no";
                        video_path = "https://media.giphy.com/media/2yxNfyGU8qeQBaTnkt/giphy.gif";
                        description = "-Corebag en cadera\n-Movimiento vertical, espalda recta\n-Sin balanceos adelante-atrás\n-Tronco baja con brazos\n-Piernas acompañan, fuerza de brazos";
                        muscle_zone = "triceps";
                        hip_weight = "5/10/20/25/30";
                        res_weight ="3/5/10/20/25";
                        vol_weight = "10/20/25/30/40";
                        subclasses = "c.larga";
                        break;
                    case 146:
                        name = "Ext. Sobre Cabeza Mancuernas";
                        photo_path = "https://lh3.googleusercontent.com/g07X-yvmKrklroLfTJ4L7xgKNVqf80W-RCQmWFiET85cnlail4CtZOw25koMT9qGwxtseMoF71M37KLOW8PxvFSYnyTJKG8SbrH7rw7pWzmqOGHrPY4ka18VGZf5sjwL2zPhKggzFQrSbnlGyrsO_Ho06B3suDoTefIc_68BWgazHpQGcw1aK1aZEp3IHEu1SD0oG5STKCf2meeROydk-G1EvaT2ENWEEynQEqsziX4VXx9wuWhE94naZTbTHc7j3yHdP_Mxcf3YV04Z3Rx-g7iMAaV7pU5DtgrnKhqzzR1rXvzafWXrai1qwrnd0ppJjqzhOFdfgtyhzBsBFYwmF11NKmSm0atsVT0wuU_9DfaJeUOT93ia43xY9wsBHpW0ZJ2SviS2JQqPj4D--c5YDsujXw7pcWLItgIbDqSK9Fma0iCjYChfd1qI2rLTYvOflxnbfUgEbD-K_OScDFeeBxsuBmrQF2YKAlumb4eV9Q1e_D539t94bRjeS8ZZG_1dw2calIC3KMTkMxSuWsgztxdVDTXlEc2cnsz58nyi1sRTw3goR0mUQ8dj5KIflJtWS-4hBMGV9WMOZq78jyJNdVjVc5zji7fIID4MjMk1qGNlkoV0CXVM0xlOyhNvK21aHhgOMr1JppMSsVlOej1ejnWP=w713-h632-no";
                        video_path = "https://media.giphy.com/media/2zoCeuXwuprH9zzPhP/giphy.gif";
                        description = "-Codo fijo en la vertical\n-Extensión de codo solo\n-Movimiento amplio pero cómodo\n-Espalda recta";
                        muscle_zone = "triceps";
                        hip_weight = "4/6/10/12/14";
                        res_weight ="2/4/8/10/12";
                        vol_weight = "6/8/12/14/16";
                        subclasses = "c.larga";
                        break;
                    case 147:
                        name = "Triceps Press Agarre Supino";
                        photo_path = "https://lh3.googleusercontent.com/7ufNJO2D1-aMH-61pZXBLNW0RMytmJta86wLBr7Ju8jwJ3CQTOzFZE3Xhn-lBwS9iAAbZu9jn5VUh76U_t9nHDmpQwatKiuV1BWPmdqVJ8adFqmm_3-HouSHufYu3EXdL_VoQUr5m-prkwhUOOUdJtgEKxaaCtQDmn0Sa5KBRyW67lYgrUjWidUn4IBMp79yofn9UTnAfd37xtuPOHqvPY9DEtSyZCrw-RhjYHWFxWaSL6Psfn3SqRZMTnnHjYJNT1Ll1v5TiI2JXwZpSWUQsALM_xecmZ7k0MGNQ6sPbxDxiJ5KlGdfdxRiqp8hM5xoCgIepgh8-_lnTmRvV2vRyno-zCQkiUaSChd1ANlK_eP2xLUsfZjU_Yd5YCWnysdjTPA2dyzxMJUU490uo7xB7D_qvd7_S4jIKTldRg6gjvMXJ0n7Tjzl5sfzt1vgCyNsZI0x6sflF_aGx7a1Mpqwd2sTg1aj81m244cDE6TEFghDIvXTGv0yFzmFoGaO6s2LcVRgP1N7b5TbbOLefiS1RvK1DyQJl7jJxuYX-C0zfCk7QEzGcvJZkaNXqJXjw1PVsAKXF1dwo0PMagq3ypPYHUdzpUPTEaT9Cj17Znkk3M5fGAVZDFnZh6UXNddZWc41tbz7WVF48Yp1vrVQv78OsRJQ=w713-h632-no";
                        video_path = "https://media.giphy.com/media/7FgWqCdOBfXk6tiHBv/giphy.gif";
                        description = "-Agarre supino\n-Codos al lado del tronco\n-Extiendo brazos\n-Movimiento controlado, cómodo\n-Cuerpo relajado";
                        muscle_zone = "triceps";
                        hip_weight = "8/10/14/16/20";
                        res_weight ="6/8/12/14/18";
                        vol_weight = "10/12/16/18/22";
                        subclasses = "c.media";
                        break;
                    case 148:
                        name = "Rotadores Internos Polea";
                        photo_path = "https://lh3.googleusercontent.com/2PxZaqKfqUg9mtl_oMD88mawm84FR2f-njRoneNIHwL4chyFDZB2UAqaxny5HCw6jyF4IMQDvZb9PLZdl9rvWMb0jeKrbzQlwEI_LHO-Gpu-3e_sPE1tvucYsvQq36GdVRWqwIrXSzFTN0WYoG_r831Y7Q8GZ84Yy5aR9kx6KFdgSgaa57jT0c_h-DVqhr1H-T8ZD2WTJVHO2D7TwGLTDFNnGsYF-ORRsNpVo7HEBrR6nU0NnU8V_JJYi8yk851aCYIhsGANDsgrEYWWQIGc8XMB8akjMysPbkXRx9u8mHDkF9Q93fnBvofLt2bMKVN6uI-RsjLQG_Kh3VvPo5kYoGI-bLYi-KLDVCEHv-XsrHf1UzatOyKjhZiaIIvGPaN-jremDqhnQ4mxbFEAHakHvtoPepO4rFHGYfozac6n4B7RrVLfRyDg1rGbuv7xQLJ5ujmgFJmmrHcadi8bOo5--0T1E1b3oRaF2T82PT4Bl_EyywQuWpzs6MJdinWjVYlY6YZ3NOwm4nBDWyuenYTlrp9S8v5u-XV1oXyMtbPd3lmAPzbL2x4aC62MZIjB0ywgRIezO6L__7W0dhFJo2msABma5w8xlsIq1pANwH8lLto83dHxXEhsc44IDofzGBae8xX_E8Xz7CNdkah8BOo-X30w=w713-h632-no";
                        video_path = "https://media.giphy.com/media/3xfoP4uynxy2uIDiej/giphy.gif";
                        description = "-Codo junto al tronco, codo 90º\n-Se mueve antebrazo solo\n-Estirar la polea hacia el interior\n-Vuelta controlada\n-Piernas semiflex., espalda recta";
                        muscle_zone = "upper-back";
                        hip_weight = "10/12.5/17.5/20/25";
                        res_weight ="7.5/10/15/17.5/22.5";
                        vol_weight = "12.5/15/20/22.5/27.5";
                        subclasses = "rot.int.";
                        break;
                    case 149:
                        name = "Rotadores Externos Polea";
                        photo_path = "https://lh3.googleusercontent.com/iFmDu70rEx7SWl_OqCXPjnWawHaDp7hGZPSEwksvO4DS4QS8t0fLDrSbeHsAeq-nlDknHRgnyhFvMHHArTHwrvbZ_jvhKq5oXIXngfsYDiNWXbaxEDAwlcyMoHO926WbBaNzenWDA59gyDb0eUakwFhfBaLubnZy-wZ4l2TWVHBFDdYceuc0nHFSxvWKuwHiYq2TGy4HLXnLEbUV3Yq7JpXU98j-M3NniZC6Yrtm4HgvlrsL5wemzf-vynFg7ToRDKNpwpK7-4A5dW7HL5yIbR5Pe3xjhSXpsyGqJFodV_VcMgxfrRxNLyMFMcmULDmcJTMRrlmqllnx8tWaOejEqy3RyYxqxOFXEWypeA9wK5yrQQtAUoHS9-xgFg7u-gL99caBUNdu6XvuyUrzVDdJUUIYbmcOKuM7yEDNIk-WsZXnkrekIGBTZ1Me9yySEiyLfMB4A-XlDL_D7GSmXVt3CbnkXtNUX5bbUIUqAKe7uaxSWX9c3z419PDfGSaqU5yYiuHld2DDfADAlvWCbdmmM8bSI6FGAB8Z8iaTuJzS5C7YgB6aM7EXNnLFFoFYH7T84vCNwxAoM6QNN2y2OT-wALeaLcP7HxEJHNCp6lo8c5Qksh-d7RzyM0wydO44oBk8aA_Ya-yGfSJ1_HaJbLDufeA8=w713-h632-no";
                        video_path = "https://media.giphy.com/media/j0NIgyrhWndODoblPI/giphy.gif";
                        description = "-Codo junto al tronco, codo 90º\n-Se mueve antebrazo solo\n-Estirar la polea hacia el exterior\n-Vuelta controlada\n-Piernas semiflex., espalda recta";
                        muscle_zone = "upper-back";
                        hip_weight = "7.5/10/15/17.5/22.5";
                        res_weight ="5/7.5/12.5/15/20";
                        vol_weight = "10/12.5/17.5/20/25";
                        subclasses = "rot.ext.";
                        break;
                    case 150:
                        name = "Supraespinoso Polea";
                        photo_path = "https://lh3.googleusercontent.com/SH181_V1CE9Ma2Wx6CmdBJUFvuuTdzLaJh45gUZzLnUXxznoYEqvNFWxHuhCsEkjZzPK9fsY78Ivv8Lw7sX2fU45EOWTRBjMTsoC-5Kc-knkpZuHvhXFaMOpK1fN6ovfVaYPIJDUcSCjUZxz_bQhzBCs0WQpp-WOmxmQlI-0RqCzq441As8F4w1e8eKeUy_KlGoYHF4phWIBEtmxnPMbiZaotRcxTugxXpl5fzWllaRsgdVmwZfCoL2t658BgRTCrWj_FJKUYeelXHl_koakgf5nohPBOAkaRmg04N4sKYBod43HH0Y08gOq9F0OyBqht_1Ec7Mp3cOyTogAwZ6h2IZT4e4mXrRDGmAVi3J6fqP8oHgtrr2p__ZwhsdC-gZrOHNHsMglwqHZN26cjLeUh8ke83KiVy_H4CYKVyan-_NtEDf6w4bBhH_R_Y034TGsflMRn9KVLjvz5fOTvsjJmlZOcQSdrC23Zq-tC6OdFEM3Qawt48hFNNLzjYzNgIZC9cSph5fa6E6hk0aGHxphWqtXZsJjr7wyyB0EVKubfxgJCgrWSXw6F1z8rPLaDpZX43SHiTlDra6z9Gl6_tkoNJVdpzh3Mwlt_X8uxLwX2YJFrRnewvm9KHe_KQvmk8Qb5vf1_pviNmHA3r_WwxBn4aDP=w713-h632-no";
                        video_path = "https://media.giphy.com/media/X8JjbYywM6iHynvnpW/giphy.gif";
                        description = "-Subida hasta los 45º\n-Brazos estirados\n-Bajada controlada\n-Movimiento harmónico, sin tirones\n-Espalda recta, piernas semiflex.";
                        muscle_zone = "upper-back";
                        hip_weight = "5/7.5/12.5/15/20";
                        res_weight ="2.5/5/10/12.5/17.5";
                        vol_weight = "7.5/10/15/17.5/22.5";
                        subclasses = "supraesp.";
                        break;


                }

                //insert in Exercises table
                db.execSQL("INSERT INTO Exercises (id, name, photo_path, video_path, description, muscle_zone, level, subclasses, hip_weight, res_weight, vol_weight, reps_obj, series) " +
                        "VALUES (" + id + ", '" + name + "', '" + photo_path + "', '" + video_path + "', '" + description + "', '" + muscle_zone + "', '" + level + "', '" + subclasses + "', '" + hip_weight + "', '" + res_weight + "', '" + vol_weight + "', '" + reps_obj + "', '"+series+"')");





            }
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int idx, int i1) {

        db.execSQL("DROP TABLE IF EXISTS Exercises");
        db.execSQL("DROP TABLE IF EXISTS Profile");
        db.execSQL("DROP TABLE IF EXISTS Calendar");
        db.execSQL(sqlCreate);
        db.execSQL(sqlCreate2);
        db.execSQL(sqlCreate3);

        //default values for profile table
        db.execSQL("INSERT INTO Profile (id, name, weekdays, currentday, dayminutes, strengthlevel, objective, method, def, more) VALUES (1, 'perfil 1', null, null, null, null, null, null, 1, null)");
        db.execSQL("INSERT INTO Profile (id, name, weekdays, currentday, dayminutes, strengthlevel, objective, method, def, more) VALUES (2, 'perfil 2', null, null, null, null, null, null, 1, null)");
        db.execSQL("INSERT INTO Profile (id, name, weekdays, currentday, dayminutes, strengthlevel, objective, method, def, more) VALUES (3, 'perfil 3', null, null, null, null, null, null, 1, null)");
        db.execSQL("INSERT INTO Profile (id, name, weekdays, currentday, dayminutes, strengthlevel, objective, method, def, more) VALUES (4, 'perfil 4', null, null, null, null, null, null, 1, null)");

        //if db is opened correctly
        if (db != null) {
            //Insert 103 exercises
            for (int i = 1; i <= 150; i++) {
                //Create data
                int id = i;
                String name = "";
                String photo_path = "";
                String video_path = "";
                String description = "";
                String muscle_zone = "";
                String level = "";
                String subclasses = "esp.med.";
                String hip_weight = "";
                String res_weight = "";
                String vol_weight = "";
                String reps_obj = "";
                reps_obj = "10-12 rep/16-20 rep/6-8 rep";
                String series = "1";


                switch (i) {
                    case 1:
                        name = "Curl Banco Scott";
                        photo_path = "https://lh3.googleusercontent.com/pRIE4QlR3Jqst687rvI1omr7prWibo4_yUh_w4z9LR3G9snwzr8NCXahxQbEN-uwToWv6n1FYVURja4JWpxHn2OjwyxybC1ty8n1hkMjByKTgL3-7Oenz9bFCl19PRSp5u6p-BKHAJHNflrqwb265vqDi4BD8oBWc5YYpw-yvLfnBVTm4A2592jJCAc54HMpwfmZq2MbS1VuOeM5-XD71EiplnhidfV5lmoMBQMLqzoq0pEoRVvYzEAq2IivbdLkLlZvXDuSAsqyrgfDjo2WCRMNrtiajG0mX4JuGYyI50tJgn-UBBx2r9MNkFWMmnkjgDgegY-7WSbPYlZ7W2kX8_oxWKTWDphwyx2Sn9evhclZpFgqMnlWd9A_3ZxR2mm-vzVhpMpClgh_aLYqhU3uo-A88Z7apu57Z002FPw84UWIoTeX9vSkpw0o4b7d_vYGogPU5KT7qpveQ_gYGcJDNf6LJcjYL26rtLEaxkTT4xtZdhodJu5h4K6Pa72JXpQrX7RMMN1W9E1T6XEc8WZD7nMvpBZEAXXq1CMNdnrDqq0VSYxSM9YB4QQdVQG67SZCbVIwouS-ocYxQq54VgWI5aqB3YX_UdZKEMwpHaTn4LgGGbvLpoVZ9_ygqS_O9DaToedTSEM6IRNaseGxz-EM0mEOLouTO3M3aHpkb3liwolhmKQ7OlRlD2E=w1062-h944-no";
                        video_path = "https://media.giphy.com/media/VhWJOdfeiwO523mqlg/giphy.gif";
                        description = "-Banco de 45º\n-Extensión parcial del brazo (bajada)\n-Codo y hombro estático\n-No balanceo\n-Espalda recta, piernas semiflex.";
                        muscle_zone = "biceps";
                        hip_weight = "6/10/14/16/20";
                        res_weight ="4/8/12/14/18";
                        vol_weight = "8/12/16/18/24";
                        subclasses = "c.larga";
                        break;
                    case 2:
                        name = "Curl Con Giro";
                        photo_path = "https://lh3.googleusercontent.com/ZO9glHJtn3KaTR9YtI-oaTQv3mrNt4LHnCEgP8HCI6hCFOcqzhSjNmnn3fmsz7j_3cjfHmfWv05vCsxZHVi7H7RL8QMzEEt4-AstdFQJ_gYLMGmRw0Ey-d4lX2MRVTWKzrfglvkVF9sZQJJ4HAZJxxHtUxic8pwN6albBsb0wGLRU1jVKzvm-2OXbo6ordPPdqPlor2VKUfGsbBlKNSAIQPFr5qfTztKcZX0-X7ZbIVdmagsywEAIG9AlVpDuEnhHO2Ue3UkvmRv93ZetNwMEJlGaO3y8t6kVwD_moW0U4yDJ8R9Lpfp1b5Qtk2wk46PYKziGU2nMT9dF-m9YZzN1RJ-Kq2Bt26SRKue8cqCTj40xt1KgAt0MRMZtx2MQY_jF0vO11ht4ZSrh9jh0Za012l47EoFAw1xycTWkLyqGGq_k8RIrgjAvs5Ok-c1R8V-kMy4oFXf1gUXYuq_Dn0mRmEywjyEvejwvPmnJq7JWRFdCSkZPYojFxtm2xUXOdv2SbWTQjgZLOViTr-oizmpROFfiUw16k1faEhlhZJZg5OR6EgH74zdLFOzLEG_DV4Bic82SZWnS_e9R-D7kQ2tx08W-5rSg7vaD81jfWRh5MAysZ0tq99G7CGWjbbP94YHTgQ216-xlABxpF3m6I73ZHIRPjiF6b3AgQ4eGMfc1dwRrhhV0oGZhBU=w1062-h944-no";
                        video_path = "https://media.giphy.com/media/fVsIvHObGjxNJiBXLA/giphy.gif";
                        description = "-Palma mira cadera luego atrás\n-Alternar der-izq\n-Codo y hombro estático\n-No balanceo\n-Espalda recta, piernas semiflex.";
                        muscle_zone = "biceps";
                        hip_weight = "6/10/14/16/20";
                        res_weight ="4/8/12/14/18";
                        vol_weight = "8/12/16/18/24";
                        subclasses = "c.corta";
                        break;
                    case 3:
                        name = "Curl Concentrado";
                        photo_path = "https://lh3.googleusercontent.com/lzAS7j1jzb76P1iit8soZ3jkC8aM3CBlfspwBmRKLTXyfDM4iAUB0Ex3He67u99cPKhc-zx04xbdahxGcoWQOXTckfVBoKYCrvXGj_6y8SykG4mnnIn76qqlZTh5Dpo_cGG5aKWKtxkiIMEy7fyfUnJs8yAXi9Dpgh7ILLRqzGFSFUq_UKsPECmvxTsGqBgsEFzXE99J5lEJEd0Wf8E9yo8GteNSS4A0CC7ihh-cfNhKswTLlFilxyNkdIxdUFLeGt9wKY5LgYGf4WNoFjNuFklJirSTNynjFwGcxVOrAH1sf2rYg7Pcye3plGKAixTC8bM6zv2wnWRVkD2xzNnFy4Y2dMmvJiWfSPVgU2L010KOH4ij6lUsVzIuuPrkC4agB43Kq9c4CtYVLZdYHzZDKl1PCkgSoxuVsitaWpul47gy736LNqVWtshk6Dvy6LeP7MyHJzUAJeenDuk_J3nVdte3Igf0TRh8C91egYhsgB0kFViSgg5CYvLX4TSenV_vtm140wjrcqHFYwumOLmccnf1Cp-QEYJrf3_txpGk5o9Mxo0ggEoCByMMukqE43_RmWl73fgF0MRTKPeRWNnCExlRzOMNchof70Wod-_fjTG6XWrx21_tXXV85u6D3q6WnEWlLCutYb3-m5FCP5Wum-usW6R2hszQ5y5VtMpSRBBxLUrzGDp9Gzz5=w713-h632-no";
                        video_path = "https://media.giphy.com/media/TF0SpPp6PfLtd4SqpR/giphy.gif";
                        description = "-Espalda inclinada pero recta\n-Codo estático en rodilla\n-Extensión parcial del brazo (bajada)\n-Mano sube apuntando la otra rodilla";
                        muscle_zone = "biceps";
                        hip_weight = "6/10/14/16/20";
                        res_weight ="4/8/12/14/18";
                        vol_weight = "8/12/16/18/24";
                        subclasses = "c.corta";
                        break;
                    case 4:
                        name = "Curl Martillo";
                        photo_path = "https://lh3.googleusercontent.com/oB-fC5yU5eLKXTypVoDnEh0Umhr4feC19A54N6PsVb4zyMl--yrGaiEDPC_0SAsDt0BAuXiQ6HkRlJWM-lLATiSXn2nvij9bPKzwHdnsj0fb-A4jb4nk5-dOgmp9rrxmyWJIDYhgu8XcsWa88tBrqyFGEEbFFSyqXyzROSjnWAL-REtuKv4nB99GFREfJRWsj4OgBMTOvA4c9paur5iShJf1PsHkZMrK_lCIBQT1CgGZl6lGoal0PbPgCftpwTKlpPW1MqMpzOKN5kUAaXfTBsByrTaVCxnEaMgw_9o9XZK4RIgKeW09hfHeflUs5qz5A6y4j3mKNyKAObJsahXvCuzpPOZMeAkcPFNPKJfmh4Xw7iSm07_9ORi1pBO4OaL_M0aVXb57BQmErkWfBdvNfkgP_kvvvILK1gMZ3y1Ey-sZuAoy4Dul0BX7EVCyte91p-hLxOEsf-unPyXxoKpDs7j2aZTpQXD5VzymcDY33adjBT6BI6ZQ6-9BMXdmGQDPt4zTg56AiQf_L5sPMzWlw_FfOChXDVHLmKYfu4vok17WVwKybxIQSB7HWniinL9mRgqzhqbozGaQkYPSSpi6WVvF_-0PvvduczfHLNiHrMTpZ3O2xx-oi5jyapDgtFTDaxEzKN1KNC07XWhbse4WQFHfWoplyBuZlmYjdP9OTMMUFJefJFSBxlE=w1062-h944-no";
                        video_path = "https://media.giphy.com/media/RkPvuo5P4IquqssAUP/giphy.gif";
                        description = "-La palma mira al interior\n-Espalda recta, piernas semiflex.\n-Hombro y codo estáticos\n-No balanceo";
                        muscle_zone = "biceps";
                        hip_weight = "6/10/14/16/20";
                        res_weight ="4/8/12/14/18";
                        vol_weight = "8/12/16/18/24";
                        subclasses = "braquial";
                        break;
                    case 5:
                        name = "Dominada Supina";
                        photo_path = "https://lh3.googleusercontent.com/WtLoEjfHN_gAwBwJq7oEZqtiKDtSxQ3maYEKHKqzDz4QNQMvfcgeQhiFhgSw1gQIRn2qv6Ci4ufFOgtfydXKSYJiaXdWA2bzYjAhMrcZ13BJtta63KdvclqgSuuM_dMbFbOYgEvmRSymQSj_iZdApTt2JaRYuiyh9OpGAuxY5msraLDRLUZXlGSJl_zrIEUGiN_MV8HRnH_3GX3tShFL-yCLSNzgmSCdWVBg8M8sMg8fhycH_hFhjhUUsLhmZpONSXMj1NMya1x3RsMX1kKBKahKsw0skwTPL4rVrPGSo3sLudSLLIzEFF8Yhsb4pqxbBpq6y8owBrzYabaviqogPfcvbAicr6E1SRECG8bUxWkC3dYblU6EoRCMrwWE4lftRyLbjaPSYkz4MnQErjug9-jEQ6v2IOkOv1PKCK3tIzy5kf8hkCRlKXzNFG97oTx1PZZmZebICyduFCEEuHsa9-gErxAkiNqjM7l4Kui7VgmzqFDGV4dlUgaREProz3-iB3WCEWkiYLhIxPc3K88MSmU4I0HFWIHTi9LAG15jG-PjM3GpcN2RXsB_JllRxNTraEPn3BeKY9ibZO6xUZkCrYQLKHSDS7QlT_PWI4rvuRyh6e2ELvndwbmvnyKCJyNy3F30HWeytsth1Q6nGkjloaMweb1PohsrjftGT9MAQ5V0-0A12COs3Zc=w1062-h944-no";
                        video_path = "https://media.giphy.com/media/d8JqSoAihwzAZAnnFC/giphy.gif";
                        description = "-Agarre palma mira hacia atrás\n-Subida con flexión de brazos\n-No balanceo\n-Peso con lastre";
                        muscle_zone = "biceps";
                        level = "hard";
                        hip_weight = "-/-/0/2/4";
                        res_weight ="-/-/-/-/-";
                        vol_weight = "-/-/2/4/6";
                        subclasses = "c.larga";
                        break;
                    case 6:
                        name = "Dominada Agarre Paralelo";
                        photo_path = "https://lh3.googleusercontent.com/57pXS2nesCpllUYFh4doGFErX504wZKppuOjubi2Ku5wRKS1iLd-h7cKCIG-t5iAIkY3ATFS7QHOcw8ozxHRhPX4BjluW_x5O2S29PEs-1Sk0Jf7YZXeKKiEMatMngNwJiMBOhRnb0bDvy_3Y8x2yZHNrLwSL5bj8YIeU1ehiT2IaNiF3KnsEed-qAzAIMKY8ev_xrXUI8YtT2MJbpB_7gb3QkSKydBK6pf06megBSHDaG05pItL3vmd4zlZWEHLTSbrqkPZxvCKD85hqckIlZSTBeI3rZE6H-tjPggVAwYeRxXXBRD0udp1qEG4Yr89GGx8p1H89GiS5oLxdMLnAtFRRwNE52cwXsbvM7vXMVBFd-5snN2QciFVgsCfg29hzGZW3BXeecmpOpEbJjDPMJVKMDgrioP4L4Wc3DfWT4kczNAT-BRFmMomDbJtRWfQbNFZ5YC-R4gpsyT7nlTzexPiXe0WNLk188iFXccyNeTuC8G0hNfD6DL1X6vCiB75_u7KOOVaLQSd3qejbp2USnenSFmLkB-RDCFSFcsfXMmtqIMOc9ehKYC4X6Tcu7fyqqkaIzBPoDqXeAJ6dxyBjEMXzSRwMJ6EEafZRC1bMS0kK8-N_iCYI-Bn2SSX5BuqjA6Dg5ztiXKxhGpELedCFn94rfrhruqb6h8cf3CpdKoRrSy21eTxEOQ=w1062-h944-no";
                        video_path = "https://media.giphy.com/media/Y4bYbN7V76r0BnwZpv/giphy.gif";
                        description = "-Agarre palma mira hacia adentro\n-Subir con flexión de brazos\n-No balanceo\n-Peso con lastre";
                        muscle_zone = "biceps";
                        level = "hard";
                        hip_weight = "-/-/0/2/4";
                        res_weight ="-/-/-/-/-";
                        vol_weight = "-/-/2/4/6";
                        subclasses = "braquial";
                        break;
                    case 7:
                        name = "Curl Con Barra";
                        photo_path = "https://lh3.googleusercontent.com/TbeiMrSWx5RMJ7Q1IpVH5OrznIrm2BZ8WFqGOy56gaXHfuASNFqsH4Pa6PA3TZkeC_yOI2kXO7I-vwqRVFVgt1bvI41wv1vccZ_f66E37wNsHgrpsJgeYafplZ3KPaN-kzuXRe0ierw8vURCFqqxbwZgFRn2beuEo2TnOsv4dbOr02UI2OuZ5_nVbuMovMstlVVR0tBsfL9xg7Jj97B4rSzmW4XvVWvfkddRIW2RQmQcnz5T4Hfui0IAlP7QRXn-IC-yJNoEtncUJFMERO6FlY5QKaAx1q5Dy_auCQbVEx0H6FMBKYGZKOk_T2EhJEaOGmFLITfnXX4LUQ8PVxl_VdN6tpF5yP7beR2ergThON4nKSgUlYBFb4FEJH6Az35zZhg5A5bzUFyKi2i_cWNjzs4ehvYG8-5chQdP2gyHqv_umJbS1hetCpysRDFsZt_dpB6TbbjGKs2ELXGAXGGVOacEiuZKmbLqQb7IF2aamzVwqIVY_gmHXQTb-Eyf2nYlA6Wl-ypBpd2fsubSGPc4vC_hyzs27QG2jJcVqGoP6XzSMn5-aYgA0H04d70pdRC88vvUF-UxBNc5CEi-MMKRRVOfYZmuktGsuaGAsFpQTNLxxsY5qalhsIQhCiqpCuSmiO41elYYq6gLcZJ8-GZnRlMb_qP4By9SwEGNAuZNRKqU_tFe5wFnHag=w1062-h944-no";
                        video_path = "https://media.giphy.com/media/JQAOx9yGh7c7Au38qv/giphy.gif";
                        description = "-Barra paralela al suelo\n-No balanceo, piernas semiflex.\n-Codos junto al cuerpo\n-Palma arriba, separación como codos\n-Peso no cuenta barra";
                        muscle_zone = "biceps";
                        hip_weight = "2.5/5/10/15/20";
                        res_weight ="0/2.5/5/10/15";
                        vol_weight = "5/10/15/20/25";
                        subclasses = "c.larga";
                        break;
                    case 8:
                        name = "Mancuerna al hombro";
                        photo_path = "https://lh3.googleusercontent.com/S2T7SvqirrAl9QudxD7VcB1FLB_Jj2fFWhqi_A5L8bBcni5x3A3KDwgh69IcJ84pOM9oYxhmQuECjLdkui80mtBK2rOGmIM5ZBTib-eSUsTO3ctSQnRbs1y-kds4IvCoaF0gMD-AaIXUPNFSmUNf4UAuly5NTczv7lURVcCPdUUdkPGmXMAxGT-KD9YNHTBAp5_qyJlxufElUtHF6YDiEzyiodYakWtplE1p1l8NSdrWsRcaUpqXdK4FPcn0LBidyQBgTrVSVDNKGV_W78dx5YE40daXrQCW4bkOJSnyB7wM0tamtOj6TdXKIg3GtJj8g6FvWdpp2bTC3YJZAPxSorRFnROW0AV_cSciXsHck2K3qBBuL0jCDQgmiG-tPzpbTXNirCNR8PpP1L8iF8OvSiE0aabeEMhqsCAmrpoJwYaBSmt7dMycByuDFxNWgVVxhSC59H-S66_jSn-ua84ay5pRcqCVpZ-es0mIlsN_TrChKmwt_xkV41P4JDfMaBsuIBuTEDPqn6uy70rECPFYFQ1A8HCoEkX3JCbXfRlzcvdKmJI2htY6XMQJi48tUcfPdLeEpkxhEFA55zrvRk76D714ljtEw1sseMShx5qm6Ggx6LLBS-hC5ELatPDTa2Rn2nyY9bCrK47DAj13EmByAu8ydijZ8Pcb3Uao4dx7lkBQs8InmS_WbJs=w1062-h944-no";
                        video_path = "https://media.giphy.com/media/RIq3EgNsfwcZxBFY3B/giphy.gif";
                        description = "-Codo estático junto al cuerpo\n-Llevar peso al hombro contrario\n-Espalda recta, piernas semiflex.\n-No balanceo";
                        muscle_zone = "biceps";
                        hip_weight = "6/8/10/12/16";
                        res_weight ="4/6/8/10/14";
                        vol_weight = "8/10/12/14/18";
                        subclasses = "c.corta";
                        break;
                    case 9:
                        name = "Curl Cuerda Polea";
                        photo_path = "https://lh3.googleusercontent.com/QvXpMXs0NjtRIiXZnwU35dbf7uSugN_slFO9g75y0CsolA7GwZLd8LO-J5s-Jbvx3uqFF5YX7pxLzYBnQw_KtgcryLoVWWLXcCXNmRdLTj4RvWVPZmxfmD0BXlyD2mW2WNKGDATEzHGDoF6T8_cSFs5t2Chvqs6N_sHCfTxnixmEQjL8r89HPvbSFuz9QVvuyk8IQssufJew5aaL2k0L90mCQpPi82DnlMjuY46xAbGd70bTBMSmoqnbvYYXuX9UBV79JCviVznxo8eSTj7XGKTuI32lCF5Rdcp_Q7y5R7SxfduUhN8YoDjVcOC0MaFGWMWSUsXy5HXG_sBbUuDb3TvaygetDMjMIf4ovMpTTVFcICqGJmoqL_4Epy7jhWONYtKXxD_0Var_d3lb1SkgYj6JmU9CzvVIM09hLjWiUIF-pyg3hxs5s6pvgW0Q3lGem3FjQYj00rd9WBTbu_Fv2N91YMPLwuULlxBXm54bghfGTG8jpbEKrQBvqIjAU0Yoq6NmyZnbPYusEb7jDZsLf_8sZPbejFaFSdWAwxlvMru-MNg6Hfs_cbogZuQ0PBb9YELR5VITTLIbNPdFEgdr0_DjdNaejuFZnVh7OaOhMCXgmMffh8DZWAsDarNN28_pfgrbhcRqR9p2PWiuV3iWsDB_3JCAQk0LYl_ZAdcL5tYXkH1vvazEL8FE=w713-h632-no";
                        video_path = "https://media.giphy.com/media/euPUdV2YcfdRTET7pg/giphy.gif";
                        description = "-Espalda recta, piernas semiflex.\n-No balanceo\n-Codos junto al cuerpo\n-Cuerda en polea";
                        muscle_zone = "biceps";
                        hip_weight = "15/20/25/30/35";
                        res_weight ="12.5/17.5/22.5/27.5/32.5";
                        vol_weight = "17.5/22.5/27.5/32.5/37.5";
                        subclasses = "braquial";
                        break;
                    case 10:
                        name = "Barra Z Banco Scott";
                        photo_path = "https://lh3.googleusercontent.com/f8hV7BI_uAXfds2Pcsga-OoVT1Lv2acCSq7QTTigFf1YtXYu74PXunXisCWD81TRc7heC2RNqdFmC93TyDhcx4ba38iVOK-srSZgBWjBCCcGuLqZejntDiBfh0y-uq1wNet3iCkZCZhACufPyx1iAqoaFQihI5dRlYk17K48FFlr2vDSKb5w6WW-JVxUTbpGR1i4OPudManX3IIzY13qxaThv7BX9tFNw1bUzSy0P7ac2BUB_c0tnO78-acBo4dD3GIqk8bN23gFk27QA2cQqD4NmWGohAxnVRxrxOWpXE8YmUsA8lvR3JVxEAdxZXtm2m3_SceNDxL0kZ7-lL3M5DF50M31b8wJ-PI8tQt9atPQLFfbf_wBZInh9CXKr1OFLT6tUsgjN8t_SYkPR8O604SIOuKc3_fg80hhLGmG4fwzhigl1_3mbxYMYk7tG8VmZ2jStZvwfWNS8DvsDqhmb6PgY-TAXdfdhVfIPxBS0pxv168LuG7_8r7psozlh5fj8Dp2cmdoH4Oz7Hakb80LXSGiaYyfTxBtfauNVJSje9ytnpDmdVZcT-25IEAbnne62RpFxt7BYOItsu4SABkyhn5IZ2TgeTt5LUXHiLVxlAbFw-CF8yR9-aqjdNOwCww-PwKnMvixLmNolhVQRYxPG8dzKqlV8Tp3a4kdPlH3NGckaLXXrIn74J3l=w713-h632-no";
                        video_path = "https://media.giphy.com/media/9DyQyftsliy0uhIE8i/giphy.gif";
                        description = "-Extensión parcial brazo (bajada)\n-Espalda recta, posición cómoda\n-Ajustar altura del asiento\n-Banco Scott\n-Peso no cuenta barra";
                        muscle_zone = "biceps";
                        hip_weight = "5/10/15/20/25";
                        res_weight ="0/5/10/15/20";
                        vol_weight = "10/15/20/25/30";
                        subclasses = "c.corta";
                        break;
                    case 11:
                        name = "Curl Barra Z";
                        photo_path = "https://lh3.googleusercontent.com/V1ArPQSqL0JYNoa7VSVytEuIqXETCcsHLjPiPB0hWL__0C9Q3OCq7HGKyjI5FrxtUcfGVW168EMIeJvRkv4ZDrut3F18l_7iq06zdcthAPGSpCQ4MHQA-CJkjZ-QT88EWndmYJOBjKI0QzurE_akbYbM6o18-3HTF0JNKXgGPDBzfr-B4Z5wNAv3FCWYErCzi_ZMbSRtNj_te2yrpohkxtDCayPz0nmI6j_vrWpK4RDBESC34XaetpPoNrf37ELMaL0AzD--8vJghgLWTzsUiGwS5l7gWj9-Z6VrZNFAQO1lCl6wvLsPoJPExv70JoJp2FrCNelXpgHdBKEE1HBeRNrN7mB6Pd_NEvP_3JWA-2Xb7BJqIkGcKtIXT9SlgmZVkHH3oqf1N94S3oW0ibhMJKBnDs6sT70nU5icrA6WgECSTcVjOCkh2B4FYo7TdYQDOU7efnJ4z2VwMMxNwu5x1dyKdmvcYR38UKlyNaa0etL6iLrgrphNMGJ9-fi_IUAiTithpZT5M8nDRVgi9QiRNWWd7McUBJWIHke_r0mJTZF6O4JFBvmd0-kQ1vsT0a-iYlk4560661oCROgPAa0YFowcYQJOxZ7pIob3X9IcCS3uBNc5qwPjhoTesh7u4nW-k2kmImijtrlPdpl-EIfxdY-yoNhVHMgbOHvkDdnXnfePWyQYSi0K1Mj1=w713-h632-no";
                        video_path = "https://media.giphy.com/media/lq9qvKmuXqiy8SsO8W/giphy.gif";
                        description = "-Barra paralela al suelo\n-No balanceo, piernas semiflex.\n-Codos junto al cuerpo\n-Hombros estáticos\n-Agarre mitad barra Z, palmas arriba";
                        muscle_zone = "biceps";
                        hip_weight = "2.5/5/10/15/20";
                        res_weight ="0/2.5/5/10/15";
                        vol_weight = "5/10/15/20/25";
                        subclasses = "c.corta";
                        break;
                    case 12:
                        name = "Escalar La Cuerda";
                        photo_path = "https://lh3.googleusercontent.com/3ykxf62mb7cQDO4i57Oo_5lmP_RJ__iyn_It8HabSgmEZqs-eoDIDTmDSt04ZZwWxo5iWExl80nLPN2e2xN5ICoJBejQt1b5MEVMeHXdehiMKGF_pWqv0bAMQf0WjcJkPcuc80npyAdrLygpB0CRhqDS4a5jSIkxg05aA_DHz6xMGTcTC1ZQ1OqyBzdgEN5qeBvR0bzLyIOFXINFYNW0ZVpAzQ85rc8m44jlLNYrDkl_IgxQ0VYb-HUaLtIz44I0mFKs3NXT-QG7_Sc1ZPX7bXeqAcUnnxz3eGDZ4bT1bk8d_VrWsxB56SpF1Uxbwk7vK6evjL2Zt8V_MkahkZv7IAwpmE1wZaZbGgK7OzpYG96teBJZknu_9lr8MxVJl0orZZL55OJff4wq4kvJNQ-M_Hs0_i2TPVq_QA6oLPAt0-XU53_gMfZhRDmK7eercw1yjlg7JY7YNVHhg3vjcTr9rTPOP4vjdy5l08F0_R2oRvAQtTNyb9Bx_TqjgqwCW2nijjjYVKi4sE5uVRDc4WM_hBf6t72GwZORe0C474JDCfU0GtJ7yTIc71QU5gLxr-9dPK1hgTfGwH54iDsI5Fyiai3JLzgZJfJkb2O4WqelVwJOia7tarkPCaaPXP5GYmkZSOEa_eHZRcWluu1SSIHJovZ7he_TSd8up_X8Tp5vy8CPmN9OkdxEhxpx=w713-h632-no";
                        video_path = "https://media.giphy.com/media/3LdSdt3op4tw9XyhKa/giphy.gif";
                        description = "-Subida de brazos\n-Evitar balanceo\n-Piernas cruzadas\n-Espalda recta\n-1 rep = subir + bajar";
                        muscle_zone = "biceps";
                        level = "hard";
                        hip_weight = "-/-/0/0/4";
                        res_weight ="-/-/0/0/0";
                        vol_weight = "-/-/0/4/";
                        reps_obj = "30 seg/45 seg/20 seg";
                        subclasses = "braquial";
                        break;
                    case 13:
                        name = "Rope Training";
                        photo_path = "https://lh3.googleusercontent.com/yNPYE11qCiF1WW_0rJdZBPKDhywQlv5akHCkMPfqK82-CjcwyNCRHiDKnSwXRryqtCJhIh2snZcP36GwPnZenuuQ09So_4YjJZ99jwUb9hqLEdPFhdgyPu2ljtzo8Mk1S_5V6OKYvscjXENPrZjPQDNiX9f-uxWGdMxnVKMrnjDG_SRDMNCFBG1na9aus7gVyfkbiK6qjocNWacz8Zk1b4Hz02U6rerOY3Ch7Zstv8cJ8mFxKNbvhFWQM0T-6PGsJcpgLpXMgqbHHWgYT9ltFyvmoUVTaWZ7NpZeEv6SEKl19kxPZvqePi4AsZumS_X6jPfW4BYRp6l0O38DD3rLf-xhZjlO_osgZXOG2kVYsGLjpnGzIS0_K1griJ0jUGWAO8WulmKo_TBSeHbQFt_1U6D0bewwWeRSmZoKiHls6HfQ25sTUiZr2Enf9722SPjyLr15Z8cHPBA2TAles6juGUujhz3rRT_0o88lHOkdmtC8YOXTKNnjzGELQCeMMz63g3OQMU93EIxP6T6Z37dCpXfeGBzRakIXSIEaAvMQykFFxbgKylhrsUouqIUgDkfOrHMsvjnI7VIvhQgiXzWDRSbdM_CVoNonOxWjU9vPJKS-ZEvaBsjHcvy3yLW0cxkFYnGkgpy_Aj5iFa_B1QUnNCMV6eBPxTZ_d3jDUJ_nTlrrzJEeuv6YGI_S=w713-h632-no";
                        video_path = "https://media.giphy.com/media/9xyHLjv1hu4QtmIWjy/giphy.gif";
                        description = "-Piernas flexionadas\n-Espalda recta\n-Crear olas con la cuerda\n-Brazos altura hombros\n-Movimiento de brazos amplio";
                        muscle_zone = "biceps";
                        hip_weight = "0/0/0/0/0";
                        res_weight ="0/0/0/0/0";
                        vol_weight = "0/0/0/0/0";
                        reps_obj = "45 seg/1 min/30 seg";
                        subclasses = "braquial";
                        break;
                    case 14:
                        name = "Superabdominales";
                        photo_path = "https://lh3.googleusercontent.com/kwL5-slwlAxzy8KgsjntM-ai2F8bChUj0dMd4SsuoEBkwIHoiE8VKY_GqKMn3unxUcv2hQS1nEoFYsX27CPVO_5YoxJZoexKqf2OUW35F2yZmaDN9KTiOC7qKQ_zyttMBLh4COF_y_x3oiKKOLZTTYcXuYdKt8NsKBZPRg-UyRz8bLTqAnpKDCPIRnq15ibRyyDZo3ZEAasVXKvVmqOFG50ATRCP9qwEiutXmDvqm6iEEdwGV6NxD0NBR7RJFgr4iWDbzdO3yCqRNKlRISeCSU5QZZyUwjSN2xY2U5zmNhRzqxSzHjbeloDk1lpf5r08m_-adHudzGDeItqEmWIGGP1WlPBtjjjNwMX9yHNNyjIr7ZQiwoor6SQ0eKIE-d3XTz_dB0kyPyVfKammtIug0oaFvPJFHtV_mdt6G6ZRbqlyqOYEn6VgXTo7ttAg9tOsg8QHjo6hoUpyUxhVKp845-gXsqTVZVooxMzd0r4RW4unW7uF0p4zCTIsCp2WhF6HAqJa9KqN21sR7QplB9XaZCwnjX2k7Wf5uhB7Q6w34QSRxQy9elcmHVSyU5ombfU4xRlJ_Ray1C_DgcsseBLTmPpdI9L-OHldA_q5CFWuv96Aun422WMBEmttz0AtSZbl5oU676tDyrGKdkbKiZGGAkwMyFkjdpfML2VZ0QDHGdfqVPODm7uZ7NBC=w713-h632-no";
                        video_path = "https://media.giphy.com/media/3kJX141BbOd3xTl4Sv/giphy.gif";
                        description = "-Alternar abd de torso (AT) o cadera\n-Marcar la posición V intermedia\n-Parte no flexionada estática\n-Barbilla al pecho (AT)\n-Peso: disco + lastre";
                        muscle_zone = "abs";
                        hip_weight = "0/2.5+2/5+4/5+4/10+6";
                        res_weight ="0/0/2.5+2/2.5+2/5+4";
                        vol_weight = "2.5+2/5+4/8+6/8+6/12+8";
                        reps_obj = "18 rep/24 rep/12 rep";
                        subclasses = "medio";
                        break;
                    case 15:
                        name = "Crunch";
                        photo_path = "https://lh3.googleusercontent.com/5cG7Lb3XI_wR6HGdvjBeGlYosgqLmmxwO6exv-SNm8uCsYenQVeZJDhv_8cBfd5sstWsvL5GhCXPSIihQUkVNVDyDZv3nEhb1Zkb4ciafJIvApdyFu9ZOooal7Q1k-IFe8_MD-o1jSLpdhYEyUp4vEG3FSPnuRvj78JTrx_SJvDBx9TRmgTdA_VvJh46uJ9IoLbGXZCbcjDNu-_3LN5KhSrj8DnqB6cD3nlKzWLw8WjL6mtggXu4fnFGiI8ANNJxZkst6BVBGx-B0ZzHTrT-F6bICqgSz68eIty1S2SB_HNnuZFFZVLyuzKI8krP-7e5EoXt2E2f9-ocwwU4VHD7gvssU3s08IBANd13QAPdzppX87NYtZzZH7ozlM3sCdoSI35hFaSg_2W2glq1oqOC2rQJpT-PGa2lc8iDJLwN2MUIzAnQu4FmqAh5GRbG0M8-2WiL9I7nrhk167LHHnpCOe5Af7MMn2avS9KQXOms0gAy86A6fbn_wzfoJ6kA6vPQ1zobcz3DEbidEj7j5gJ8xggDI5eFf9fZaDiaaxFPTM-QwEgJCMNzz1Y3hb96xAL6kDiJqKVnt_dJZBCN9BWgFBPNxfDQKQ79vB-2YsODSs4XgIZvVIXQeGjERLbSk5MksK18tTRJxMlhT6wIuTGRBSWeKLPVq5lC1DdPqbxv_V73JnQKTSbYJimw=w713-h632-no";
                        video_path = "https://media.giphy.com/media/dyocoboX3Ed5PyoE87/giphy.gif";
                        description = "-Piernas en V tocando el suelo\n-barbilla cerca del pecho\n-Peso en el pecho\n-Subida hasta los 45º\n-No doblar lumbar";
                        muscle_zone = "abs";
                        hip_weight = "0/2.5/5/10/15";
                        res_weight ="0/0/2.5/5/10";
                        vol_weight = "2.5/5/10/15/20";
                        reps_obj = "18 rep/24 rep/12 rep";
                        subclasses = "medio";
                        break;
                    case 16:
                        name = "Crunch Lateral";
                        photo_path = "https://lh3.googleusercontent.com/BLhQ6d-NXC0uR0_aB7vJPFZ04iDBFlL91rP9ujFpTGXbkDUU3FxukLtaJoYsU69zxZPXAtf6Jq8MCciJ6CQh4Gt0PVJ9NVa3dDu-vmemQbFFO0ow65u6kFrBNLmYdkmS6KZCoXO2O8j9klmsIDLapnIAi_NBXL_ftgDal0ZU_Kqae_BPCqwznUtDvhEWKrHOnWxEk9lqAxEcAVS0PT2bP1wuDBQ6w-rLQC6CzW0dxxTZme4jqsU6xxMZqaI0wCb82rvzz9IWaC8LrOw4i1lR0NHwGl9XJBjKGnNKRZIPiZQp_SY7Ii-OWxhtG4tqNgO3F4Mnqqzu2098kSfsGceD9KKjhQ5wlxLAAonStQVdqNM9R5s46YvQKj8Wxqi7qlFxtCFn4UFazT1phXyakW_51DBRNSLtcgmQqg4v57VypJ9Ir7XcFRbxVi_g3mCpd3N2__s3tBC3m9w9UfppwSRpghH5mxXqWxWlio6EjFiepgqU-eDp8ID8Uw8Ah3iZzMPcMo8sWLKFd0RUDDWiVQmq0LUEKnAw1YGAGn8Ne1e0_lZCE4G97Y2foPSTRXQwPUHboKDACEV-ztyd3iaq1YHIw8dst4Z5Eo8dcPGrDAQBKIeDEIfv4kABI4tl8WwpaulAeG5FmXHezctps0g85F4U7GZ57lVPkSvHY3lQ0kUAnqz5HbZEu5hfWxZl=w711-h632-no";
                        video_path = "https://media.giphy.com/media/ihwMY0HajbiJ4Kduj8/giphy.gif";
                        description = "-Tumbado boca arriba\n-Piernas al lado en V\n-Subida hombro diagonal \n-Peso en el pecho (lado exterior)";
                        muscle_zone = "abs";
                        hip_weight = "0/2.5/5/10/15";
                        res_weight ="0/0/2.5/5/10";
                        vol_weight = "2.5/5/10/15/20";
                        reps_obj = "18 rep/24 rep/12 rep";
                        subclasses = "oblicuos";
                        break;
                    case 17:
                        name = "Bodysaw";
                        photo_path = "https://lh3.googleusercontent.com/lQwHCHUKSwxVqUOqLo3aRxG5Ya0AI7evqEvjYGiV4f5J8-1yog2BdYAa8FqcQqJxfNpgQAuWVDYAyApuG8C0sRY1dvNvdljF0VVt_cGz3GcbFYogP6djj7o05P_YfdLNUyKdF33Les7RBjmT1s7xhV4rULoD_69bblyqI9A8wnFDLM5ytJHohsYA-Zxwy8lcfYIOoNWXq6Y2pxs2cxROUOPNDZ0iYLkIeQ2x6hUPIQQiiyWlvhvtbwuj8YQ3RDq5XvN2QprnugyVqZXQcdSmLCF4exkhKytVykQzu3hEQlh1NWXHhT49R4y7fDW5AoO8x7avQD7ChqCiOdKy8n4teDU-iHxuOKoRZaSHZpDO_PUwIxrTElWU6k14p1I6CIsmajA2WnOJIqexdwlYo3Cp5J0VMAf0ILPX741xj6K9oTvvfjyfPQQFppvMrdlXJp7bj3dWG_-ADu9-WzBVPUeXcbm6jEAnaQ9dYfOEHvMPgJ1w6r1sxBDYoaEva7iBAW_craA6EgWed7c2LxqsmxFWz1o5BOGv3u73UZy9yzPWBfiWZxRJR0V_rMPiXR_r67F4nYL3CHLAnqikHUjtyEZ-8izmH_NPxvbHQ4DPDs02N1L7bNd_H3wS5vg85mmQ9Pj7rjXw6M7ozJEdEbU9zvtkbFPEqrSxuKaTFysoCJqQKYKg_blCvGHzjdk=w1062-h944-no";
                        video_path = "https://media.giphy.com/media/jTNHnianHhuS7wblpV/giphy.gif";
                        description = "-Plancha\n-Tronco y piernas firmes\n-Algo para deslizar (pies)\n-Movimiento adelante-atrás\n-Brazos mueven al cuerpo bloqueado";
                        muscle_zone = "abs";
                        hip_weight = "0/0/2/4/8";
                        res_weight ="0/0/0/2/4";
                        vol_weight = "2/2/4/6/10";
                        reps_obj = "50 seg/1min 15s/30 seg";
                        subclasses = "isom.";
                        break;
                    case 18:
                        name = "Plancha Lateral";
                        photo_path = "https://lh3.googleusercontent.com/chEHIxmGJAoekfd8cHs2d__Qb_cvUQtd3eP_Oq4JjzGMaFlLcGeML6pRr1h0g-KUwt63EmlbPxSUjp7S90gYqn8v3l_qs4BUJEeuBvzWnM-NUWOO_VO99cc7U-k8cpJWQVMeYRC-YWf7oYVg5oTCM6FxEb3nfg09ec1HrXg4kyZY1yKFODtZEjjTxtSJDYcg3WF72YgqxionKcJlJYU47jAg7u8L716qOVbeIyaFAzT7XPGZxvKj8SFnQFVc0E4g2xMpgC-9QX25jm1SYRXj3egEmaqjghKlmwJfQYDBHM9ePXGkz2qQDe-VzwDBHm-kbL-RjwkBR_eD1UkKVfjE98Tuk0m6OhRgJ6sWY2fz9G4IjgAhrMxWfCT8u6_UKrb2EvA0EgW_L2NO2weptUmIlczU_sXZiq1OX2NYup_AMT0iOrYufYpHs5iFmsWQ2Piltw0e_-FyddmmoKw_thGphpNF4PuB1mwPTYtRZWPqfdaUyHOTSqUAq_M9sT4CMUo76uiPTHrL-tuKb7Jh4nRhodMVDR8z6KmHQJuL--LNiSA0PQRYBXay-rVThDY81XFxhxBpaD34HOOxbnqOeUG4EK8hywBIsuywq04s39N5PP2XpC0I40vrvFzrB6ni2P06Y6LUfwaJE_fJmalMGUXDuNzErTxqGR6wcs36S-_bGSGBNXwYiMmOm8EW=w711-h632-no";
                        video_path = "https://media.giphy.com/media/5QLNmNzzO7Y0I47mJ3/giphy.gif";
                        description = "-No bajar cadera\n-Cuerpo bloqueado\n-Peso en la cadera\n-No hay movimiento, va por tiempo";
                        muscle_zone = "abs";
                        hip_weight = "0/0/2/4/8";
                        res_weight ="0/0/0/2/4";
                        vol_weight = "2/2/4/6/10";
                        reps_obj = "45 seg/1 min/30 seg";
                        subclasses = "isom.lat.";
                        break;
                    case 19:
                        name = "Crunch Brazos Estirados";
                        photo_path = "https://lh3.googleusercontent.com/dtRpwCvFwnphzwOwBBwPR6LOIQQeE56cdGv_DN0KQ-LRZumnGcN0g43UU5fj9sWOyWh00nZfNIO4C5pKnamNur7Ui9zxQYRiMSBpQTgRibJYMWGvXtvnsRkZLuYmAy5N3JuLlB4GyXX63DVpt4sOVEPU_E_-ayz2L2oURmriC1Ms-GFs-09SLnrMjLHx8LvwVvKppCf66u7Pr8QKpzl3t-grDsNV6omatEXmvCp3a2a91M_PlldT9Fdv01VUj4B7cPVMEsFrpmuJJD4N0mLoCOEH56_-4CxQFWGD6rB-CXQdiqe0QnoAKCtMDnnb7r-kb4qMdyPEC9iIwwUYEy7q-OSe-algH3LCq-z7WNguC1v0Au0FB8ghA4JNx9fEL6BzkMa107qP9BkSbsQRL013ELAbk-dxUSruE2lek21Xm_71cpPgVRkFI0WkG9A_hVnt5-CoGGuc2t6mC8rsYNpPwvTCiZ6wnQ_8joV2By-Co7HqekdjcsdbpIiQ4FMve2j4aVogZpg2LUwPE7m2VRdAHiijvxvSrpYpmF54G9BE6zAIxhyh53UXAPt0kxnjrUu8DB569yDBUmlSMdc4sv69xyDgWoDlnFmVzAgQYtlC-prA2r5YOJ294_auE6urcRv87Yo20ZAmCpPlJeXSVaKmOvb0x6nR28F4TnqjfgSq0AKQfX8ZnNmghNR8=w713-h632-no";
                        video_path = "https://media.giphy.com/media/fq6pPYN8Dp74RynU1Z/giphy.gif";
                        description = "-Piernas fijas dobladas sobre cuerpo\n-Brazos estirados con peso\n-Brazos alineados con tronco\n-Brazos no adelantan tronco (subida)\n-Crunch corto con tronco";
                        muscle_zone = "abs";
                        hip_weight = "0/1/2.5/5/10";
                        res_weight ="0/0/0/2.5/5";
                        vol_weight = "1/2.5/5/10/15";
                        reps_obj = "18 rep/24 rep/12 rep";
                        subclasses = "superior";
                        break;
                    case 20:
                        name = "Pies a la Barra";
                        photo_path = "https://lh3.googleusercontent.com/WrDUMaomMIRl5eAiLxWzkL0IoY8U4_HJ5ZhS4c7LKIg7jcHt3mUHVkuAlWGsgRW_XML-3FwbdokGyg4vzTu-xY95yyhyokF52Lgo7O7CAmGwygrKNY8jpcPRFvmbMBbmXnsj69JeBwhyeXMWsafjFI21trZelSPlGXpSUI-YIC_SJ8w_PvIkSA2YxJcqibyhyzc820krjnGnFdv1_ZluodLEld2M1LyJQnZgohYVVs_SkS5BqsdqlipSGcpzlLIi1TamXlf_AvpANfux5dkdC8CxTd5pGnINSUJ2E2GTtcL372eUYU0R7uBiSmvPQGhjjwSQ0B5ESkVo2AUJwjFMdmjOQYpK7BWqU1d4pgm1AqcwwtP51hGqyDnOh-2lNlw11NgW4d80TLVBQbwtx6XL1bttPOHEw9oCiOQ2ciQBAowTJRJDYucViXem8HkzhirZNkz4iTU3PZ3UyqJJ__b_Nseabuxso3WUdPopB5RDJrVCaHA-EHziUsjuahDWRACpUzqL7jb0bGYLogU3dR_bUQOaP8g-byoRfYVZE0VjT7hgDuz9xnB3g7Mv2Rdr35m3Nw8ZrpGpfMpMGzOapsymDG2-GTrMr8dhzyHcGnQlCmLMjuC5DzH51htWQtg1Ti663wxkeBA0L6Ws-nLCGMiXuQIQ=w713-h632-no";
                        video_path = "https://media.giphy.com/media/oyiXMbtmK5PIecyd0a/giphy.gif";
                        description = "-La cadera lleva el movimiento\n-Mínimo balanceo\n-Bajada controlada\n-Pies hasta donde lleguen";
                        muscle_zone = "abs";
                        level = "hard";
                        hip_weight = "0/0/2/4/6";
                        res_weight ="0/0/0/2/4";
                        vol_weight = "0/2/4/6/8";
                        subclasses = "inferior";
                        break;
                    case 21:
                        name = "Sentado en Captain Chair";
                        photo_path = "https://lh3.googleusercontent.com/aVFNNzAkaw8M2j2fNjBAvONWxTVLwh_11r1n04F1Dbp3ZN5aKHj8TfJPwVC4tlYf9i4UhfDWnsPuKVE966gStFeno3FZw-Z53CN9uAaXEvlP-u1QPjoKZAkWIZsE6SNsLiaqs7CYsPpEB-TH1slpkzNMl9iUA2Xu7gMnikCeDOBhillo5N0pnc_j--YQYW1mY8mWBtCsgupajcbocrnAukEDZT4YTFR-OcVRx28dnCc3zEZfzUK6mJDvK1VD9hJDrUKRSO8oHvyqi0xUaK-gr2qU1NOvuEMDKOYdQcQLWr_ZnlCalr5u_RlTY1AjM0HXUUyxiG9r1-_jatlpgGuvzqXOa_g-OyNvswhY_K5aOLmh3kUNIP5KvyXdYwfBFKFw05nh2ucqEazWm49KgocKKNC8EAdr_WqCGp4uEOadl30O-bysERCjPtveU3_yBlnvx03Ffdrmw-CvoNXSq1guDNNCCY3eoZQAQhyPvZmHL8i3L8fnJZjKGFWDETSb2aGRyXBWuqLzMmLGDmZgPpvgO0_ochxIMkL8rxuI6eF5WLPofVQKUmjKGRrEPBPH98vIK-cBVrbiewWB0KTfA0RvmkCnDs8AvodnkUZXEUjfG8CxPkf3ZN3CaNdvCSaIfVjjW_wxs-f1iRzLs4omy65e0KQ3=w713-h632-no";
                        video_path = "https://media.giphy.com/media/9r8HDw7mVePKVERYe1/giphy.gif";
                        description = "-Inicio pose como sentado\n-Volver a esta pose siempre\n-Subida de cadera\n-Bajada controlada\n-Parte superior del cuerpo estable";
                        muscle_zone = "abs";
                        hip_weight = "0/0/2/4/6";
                        res_weight ="0/0/0/2/4";
                        vol_weight = "0/2/4/6/8";
                        reps_obj = "18 rep/24 rep/12 rep";
                        subclasses = "inferior";
                        break;
                    case 22:
                        name = "Crunch Corto";
                        photo_path = "https://lh3.googleusercontent.com/2LxKol4oLiM84S0jXQ-9SuqIwkWdi97QW7rLL0IAl3aKJpHkEOrcIllq6LDa2xJJpG3NWiScsHwCU6Fm8RKqZ6EOsqj1qtCoQS1qefoAu0vDlPnuWjdaHG3pCpEDaUrtIGDZtERRpeyFjfoo0ZJ_rOD4jYabvoykCXhRuuYgf7hT_S817z6Vpu-ZfNVjcLl53zydGQJS7AAK_Yi9U0A63wHC26X1bcgVKI6rB9jGL9btsTMu5uH0TAWWSOk1vdfejDOmERqRolurVBioYt3OAmvWD5PAPMs9wTYn8_QSnQAco8ayUZ_2qkXN7kg476xn2AV578A-psvalweeHv2zy9YTOdLkp2MVfbSbTKT7a7BUBQw1mQaqaBxPLTifqIG_rzVke_VcOO1IbZlG0npgHVWxJC66uC90WAieVQqYMKnmfHhi_Ywg462IsHq9CuvRMBsbdTYqKvNShBSEJVI7dI8Qv6td1IKKY9BidAVXH7etfsbDa4sQJ9YO0NqWh0beWZSgSJ6ZlVWENRrzusdSOHyOy4f7Eg-Sg7e6iknUmtvIytaybttBRf9I6RAn-z83Y2RRkPuVK2_KCd5-aR9mbuL9g2uDZ_bc-KhoIrCx71YieDjgCq_fMdPI-avWnSufIsMiEsmtPaJ-i06rlJKDRJPm5JjB6Cpx8dbn2Uh5Xb5ffm84tEGxS6Qn=w713-h632-no";
                        video_path = "https://media.giphy.com/media/gLKiKUHjU1ynAno8cr/giphy.gif";
                        description = "-Piernas fijas dobladas sobre cuerpo\n-Crunch corto con tronco\n-Barbilla en el pecho (subida)";
                        muscle_zone = "abs";
                        hip_weight = "0/2.5/5/10/15";
                        res_weight ="0/0/2.5/5/10";
                        vol_weight = "2.5/5/10/15/20";
                        reps_obj = "18 rep/24 rep/12 rep";
                        subclasses = "medio";
                        break;
                    case 23:
                        name = "Bici";
                        photo_path = "https://lh3.googleusercontent.com/Ug04Mj3zxMe5hmY8QGyhsACJaTB-zbY4jUGiKSjcqj5_QL0bex1tjpbeQv_jOVzxWv93Ipnbix_0eztAfrTP-lhCfYALG3euMPLrQTUNvSCn_3xBPzua5nqQR1bCEy28rZVilBegbZGzS7un9lgnyY8b83xvynEkYQjqPu0AEYXrXasn9iXR4ord6RzaQi1bSd1-psVTFOzh2zsyGmyJLhHbZ2iMUk3n9cCI3L8Ujobdx7C9gNF-HvnDAmYVAgvP0htsjRez_pI3ZCFlDFuHilHQ17tt6mZzp_qViUo01FbCK92wVX9cJ_6JgQZE7r211UOwzQkEbB9MHBlrwV2zSSqDyg2SNsPVIqwO2lp3p0YDLT91QxqbVzHKX_CuNT2qWj8Cz-qMLQMZBzmbkt6pcAZGAbGwkv8y74ZwCgGBoD81Qm1UxhiJwzYjiGS2ns5ydqM8ZX9gSd7xBbOEW6s8JwQms6MbQuN3oUH22CD22YYHAVaIJl_ZBWpleYtTSQ_Tj4BZd3V1mlySQ5eahlywd8wN_Haql9tR4WC8WM3hvx13SYMNpHbhJcb93b4eV0T0MpEpOzAHiwvKCjgkyiQGH62W_12GIox2rRIicpCYY_ZrgPkPB262wa2yiEHsf9r6wobomrdCbi8yIiHGK9JrQWlf1vhoe7cneLBwOmecnHT3ophj2E2VHUSm=w713-h632-no";
                        video_path = "https://media.giphy.com/media/kcNCK0k5RMcZrN8aKJ/giphy.gif";
                        description = "-Piernas dobladas sobre cuerpo\n-Una flexiona otra extiende\n-Codo a tocar rodilla contraria\n-Alternando lados\n-Levanto tronco luego giro";
                        muscle_zone = "abs";
                        hip_weight = "0/0/0/0/0";
                        res_weight ="0/0/0/0/0";
                        vol_weight = "0/0/0/0/0";
                        reps_obj = "18 rep/24 rep/12 rep";
                        subclasses = "oblicuos";
                        break;
                    case 24:
                        name = "Lateral Piernas Cruzadas";
                        photo_path = "https://lh3.googleusercontent.com/Dj5lrC7mXI3FKEelMvZ_U8yb01FXAXtIPZd_YgFugPgmQHlzpz20PpDZuN5ypZjzrtD_4icIA8aKWOSiGTyEwOOKBZc1WWo1Szc-KTpvr6-DpCUKTWfzaEz6KaZLuBQiNapvwif-G1YZYeOlOIekySo5YOhwHXyEn-3kfWwjH-cEh6Z7cKpYWrtQZKN7WjIByob916jfuG1CvGBNV7FGtgiKauGewaSsyhdMcUY04pgIhYtfG6QP-HMEyDzc64yPYlEvMRo8s2OBqwXgM6dCzhT2DIxR1-eOtoHE7c4rj8lnT31PsgfN30R7JJ003cSxiwghfPS2PnbC4nBdMc-WzSgHO185lWtj6fY6OO_mcfzyEXBN3GEoBoVS9UPF4Hj5n2Sv4NPjFgTX8NpVRP4PQRhPRVYhr8lr8w-phL8w8CodG9YQDjPzPOkfQLa4zAh_dz0RZCIf-pQmFSIcKJgS75wQAqwqSlMbBEeouhh8XBJ6xkdP-yWZ_p63RRz4WwrEIvfUoTnDilQ2UnSnTc-rlwOtEq6phFZ91elKZmrJSXWqzOs_kTl4TOx35Po9QjLtdLa5nOTA3VFgP7nMZGsXM-uG3OVLdyBNlrGDbrsxBabwGueRyOJmnyFXY_H26DoE0LZp2DfUMH40ELlR9tMvgdG1Rvss3zW5MnHPrz2hl8uolSBSagyIHXe5=w713-h632-no";
                        video_path = "https://media.giphy.com/media/gEXp2cCPS7FBrSibCf/giphy.gif";
                        description = "-Un pie encima de la otra rodilla\n-Hombro dirección rodilla opuesta\n-Levanto tronco luego giro\n-No alterno lados\n-Puedo apoyar brazo en suelo";
                        muscle_zone = "abs";
                        hip_weight = "0/2.5/5/10/15";
                        res_weight ="0/0/2.5/5/10";
                        vol_weight = "2.5/5/10/15/20";
                        reps_obj = "18 rep/24 rep/12 rep";
                        subclasses = "oblicuos";
                        break;
                    case 25:
                        name = "Plancha Frontal a Lateral";
                        photo_path = "https://lh3.googleusercontent.com/-PM1IBlAyGpVJrx0YChTLdJ-zzdKEWwT9DqrmW9suf6KJr0M-D1ZhdnQv81O9f8YdU2c9EhcBVvOUm9UePTdHDO74fdiHq5zAKcqv6yOcfzmcxvpai2W7_XW9vy-i6830phazM8R36PDYEJzhY4RvBpv5ZsSa_aFrEA9BaypXq3ylr-eUd2cztUW7qUmvILHrTEFoQjUOpxEW9osasXtazENhVQCjiAybu21cE80uLKtytStfIQHm-U9hhCCt-VSzQ-1JhYwLmBscZ7uLmBzxw8THWquxmmfIY3Zqy9fAoTlx8-wWS8-iWfqjYodo39fhub6H1gkkT_j1KeDoLd1KkUrVYomfZr11ZpHCt2PHLk9fYT6jR_3zyF2mHABUWDcEYtXeaSm88Z_w7XgvaloYXYan6z92vD2qpRMlqMXP03HeQzeEcVzW3YTfzmY4_6C4Cq3d6d5KDOkysubNhGXnalOWSLZtgiHO5_2KbWASfoLFo2Rd1uyQAWhku8k9rCig72HLaaZoHH3X0IyHzNFtNUphP8hMdXhdu5LAURlWW8Uf4OLUa72JPruktJEf2WhvwVqEbdPHoeQP1K4m9gvge4R5X9Lr8gTcbDYY9G-bemoSERqWxQDaW8R29j5kPoPfND6ZVRA2cxx6catwn4otyEUPxg_zIzbAcGhZLnVW78iTm5iPZk14HgO=w713-h632-no";
                        video_path = "https://media.giphy.com/media/Q7LEuj87PmzoDJpXCs/giphy.gif";
                        description = "-Pasar de plancha frontal a lateral\n-Marcar cada plancha\n-Subir y bajar brazo (lateral)\n-Abdominal bloqueado cadera no baja";
                        muscle_zone = "abs";
                        hip_weight = "0/0/0/0/0";
                        res_weight ="0/0/0/0/0";
                        vol_weight = "0/0/0/0/0";
                        reps_obj = "50 seg/1min 15s/30 seg";
                        subclasses = "isom.lat.";
                        break;
                    case 26:
                        name = "V Fitball";
                        photo_path = "https://lh3.googleusercontent.com/zAgFxX3PZpiquZNF_a6ryCvT8LhsM1-E3vrWun1yYWlRM6hne6rf6lAqH8LCd4XAQNc-uQoj5IM0UqWbL6mTeebYIibaHM3PMuas2xY9eXgALZtdQXU7z8eRDj8zL4CWEUab9g7tTXglPQAd2d89-BWjuvewiC8oZoJgbIrVvJYmFDIsBtmkT0s5rcECrZClCYM8Z_QG__5MGuJbaTnvlYZCu7twY8-qa3H2eWJEgTqDdUdeW8Jp-iSt1QDMSbzGzavLSLqa0tOt97zxtoKnz1Lt8TsixF4vC-UDMvIEOcccu2Knx8NTX6jw2vji1vYYD-ys3BTE7857inN0xWnkFfBskj51tQGz-EH1xHYXOfTt9_kjAxoePDbutksNcmMwlemaGhWWaB_seLmrDUf-XG5BBpsE2Qow-nsw1Dq6Eh0YLOvLPhBanP4e4-iesmAVVrYA1ZQ6HYQtEqUPja6ySTvFJCzIXs-EW9RcFJNrU4LsbDl7VP_YUO58qGyeQs-rr55VHfrKKOlCNafPUMfcRVU6tgsP2Cjby4p8UiwDVbskW6YINSAgt_CfNWXrh3uosIhvhjdhEUbWFpjUz_-16uAa5NnFCOsk6AXlI-CTfwAZCDs9enJrrOx3bn5AQiBXSrPCF-3xLwpu5cB5VTudpo45LI1iD_bvkaIgnOvj0HhHh9IShZM4oOv-=w713-h632-no";
                        video_path = "https://media.giphy.com/media/SiJWH65nxaYZyIEniz/giphy.gif";
                        description = "-Hacer una V pies y brazos\n-Piernas y tronco bloqueados\n-Movimiento controlado\n-Fuerza abdominal";
                        muscle_zone = "abs";
                        hip_weight = "0/0/0/0/0";
                        res_weight ="0/0/0/0/0";
                        vol_weight = "0/0/0/0/0";
                        reps_obj = "18 rep/24 rep/12 rep";
                        subclasses = "medio";
                        break;
                    case 27:
                        name = "Pase de Fitball";
                        photo_path = "https://lh3.googleusercontent.com/RBjns6m3a2hzkrwf9rtO812jW1HhbVk_LWcPNx4BgE57pWAq0IPBVvH_RBzS7CN9wZJWDIOT_QICDks0ZqAK7XoDs8nn7AdPuj4w6kxHUPFA-dbfYGtCkhyBk-dPOx2SZVXypN_RzsQAJDfXTxRLfElXCBu8drIeR3W_wRX1ulzs-Uc6nFLH-1G5qgeYZc5Yr6UnuK9kH_QYm5iASH3DfJXAu7fK3Yqr04pC4RLEanzp9ZWEUBJg1cJBiZwvAYnMM1WZEBXCBNLH4cZVWkOXq39eUg2xGEDn_-t9JMll4cZXIedruY4W1HEy2HofNIAqkv7IW8zbOt7rH0LA5Yq1LwTQOfgBUMQM5zE5vtzUmYP8YITlJpHn4484zmY4DugAr--heHQdqzdYSA6j69B9Bu3FCtjVd12RdnPoodJKf4TrehYJgVUYLjU7hLuwuH2SA5uJMkmeS2yXTv2rErkHI3nG27zxNdMvcl3Um02klL97U3XjI2gDGo6KR1775XX61VmqFj8yWRkhPNzJ-OGT0CZ3Qol4Hllnp4NKaLiTkKwfbEuhNSvt1v-2Zg_GE7V-_39CjjggCleFmpoyag0ekO0w0OXFfj1v00_rYsp3eFCQockhyf-1zewR2sd1D9Sj1Tp2jn99IySu897RYuz2nV5qJHnaFrfbOkRNcih6tK8n6_7Ya0xuAW9u=w713-h632-no";
                        video_path = "https://media.giphy.com/media/8JTla6P0RPoMulqaPL/giphy.gif";
                        description = "-Marcar las posiciones\n-Piernas y tronco en V en el pase\n-Movimiento controlado\n-Pase ni muy adelante ni muy atrás\n-Espalda lo más recta posible";
                        muscle_zone = "abs";
                        hip_weight = "0/0/0/0/0";
                        res_weight ="0/0/0/0/0";
                        vol_weight = "0/0/0/0/0";
                        reps_obj = "18 rep/24 rep/12 rep";
                        subclasses = "medio";
                        break;
                    case 28:
                        name = "Crunch en Fitball";
                        photo_path = "https://lh3.googleusercontent.com/CkZ05emxQDFYZnjyNttyKcRf-SW_TNHkZm0JQun6rejnRtDbldz32IdPUlLKzaz9VvRg4IXCxg-9_hOGjzOG3ljdEdOqtUCEaOVp2SXBY92uXYb61TV5BoCpwww9b_sFTIrCo-Y0gtkk82UdQp5s3_RCQyWJjhpSsLOMNcDDH49KynFF7bqdw-4nsKzOsxdWn0Lgxqi_OL8UnQ7tRi4VpSj9p3Lchs-DfLn1dSusOKEqSAlZHIyvIIh3nAZggMUDI_HveUwFv3K2ogkeJzfdpGzJKA4i-sw7jp36gFCIpmTzuGSobiZtUvQomfFom1Ho0wL6jXcMGNV4x4jO9f3cSQdl9YMDJ2YbTcZvbCPQhBV6cpd2tlTJPD4dCK8CLVNKRHvXZQNXR31EbyH3HKIJjoVq3d5XE7O_kgjy8awcb7KZvmVc5TOgz3CAwTev-UNYRUURv8vDjMu_hTEoDn8AuBr2nLMZxbhGoIAAxWonNzzY1xKmAb3DFRI1ecQLMyzmGeZkxn0-E12iarB70i5_1YljZP5jkv4re8GGS4ywkmrPevJwgy3gXhroJOMLlHGAN51L1tHBFHOn4jqeiZkoiQC9HSFuUoxosjEPF2nCxdQrlUsfzQvOucRqS-hkHJma3HeqSVWslyl2xmeHUu8bpb1sy6lniXTAyEUY6wBFVtbg0ca6o61XC1AJ=w713-h632-no";
                        video_path = "https://media.giphy.com/media/5qFZtdbscqdzGztyqz/giphy.gif";
                        description = "-Piernas bloqueadas se mueve tronco\n-Lumbar apoyado\n-Movimiento controlado";
                        muscle_zone = "abs";
                        hip_weight = "0/2.5/5/10/15";
                        res_weight ="0/0/2.5/5/10";
                        vol_weight = "2.5/5/10/15/20";
                        reps_obj = "18 rep/24 rep/12 rep";
                        subclasses = "medio";
                        break;
                    case 29:
                        name = "Rueda Abdominal";
                        photo_path = "https://lh3.googleusercontent.com/cyplD3u0xmB75czTy3urhIREfBcH0Sb5c2f0sI-N05nEYrrmFdAM1rnPFJVOLnGOYHcls84zeQODcr08uU40SkosFfs2zaWcyDezLkJbazKNec99k-YiHac1pZGSoHzX4sNwFiyJMXx2z_OhCvXxg2myCQtqdvMsCJv9rzr18xyamTXLknLeeY293dCGfwAkPhXd303KYZ4TDREQGo33w1ZY1avuftnL1y_yIzdoiNF9CNR9UvHDhJrFLyiQGutLsp7JTbXWmieItCAYkCqNKEqTNfSOCk1KZ-7H_H5hNPFeHKdFewtCwUEloZ6ipLHS7MXc6Zf7IY8AmbxHw_5PWm_JAmgBmd07Fz4bwvAld2OJGjz0fT7NQK5WjUtuCXG-xnsTM_REcu5YxCY89l84PunapxJDRxer7nbEeJ_D9zMu05dFLzkcV9UKqwj24I1hcKA2la0ZP5M_k9Z1HrPwsNPa7FL3dpo2eW2qyoFbi7Q4fScNGCpshqxSxMFsywIqRwrY1RlJd4ibZeKyfwdqtJtndvELaw6rhkjOzgtOx2Xx0dLSZgeOAnSxROVuOg3UIEzGoRFUY3AyVUOjFI_z0aqQrgfdBlz5NG53s2A83oXlcr6gWKY_nUMu3JEdGuKihg0T4D9rptX3Cb7UO5609zcPfEj2Bmy7gVIv7e17TuxA9ZjFyCnBRRma=w713-h632-no";
                        video_path = "https://media.giphy.com/media/2wXzHKMYZ2iAapps0B/giphy.gif";
                        description = "-Abdominal bloqueado\n-Movimiento lento y marcado\n-Espalda recta\n-Bajar el máximo manteniendo posición\n-Brazos rectos";
                        muscle_zone = "abs";
                        hip_weight = "0/0/0/0/0";
                        res_weight ="0/0/0/0/0";
                        vol_weight = "0/0/0/0/0";
                        subclasses = "isom.";
                        reps_obj = "50 seg/1min 15s/30 seg";
                        break;
                    case 30:
                        name = "Tornado Pulley Slam";
                        photo_path = "https://lh3.googleusercontent.com/JtaN_Wee_bpWShCv9xZz0f27joxmbSlUt1nf37lCPYV3zqEUke06c7SHhizT4Gq6HQWxO_CClW3ZCFNJUpmZZQoL-ZlrwSIKY0R10RML94CrbttLYtKuV8w2vkAqtaTNWv9d1wbOMQ5inmwNNiTZtv_5CDMosBqSj-WQQLxPmwNVvR2mZf1YyO83hfhJOXcEnlTkUSC19jEPsLQo4hlqyYu55Mb5JVoYcuhydYyGVjUFJ1DACNZZrmqIgCNMc1dvRMdJJIA6aX_NSn2idXXGQeSz08f-ADiyllJYM1KpVa1VlYqLMlNoZ6-WCiWKVNMP5X3FNRzkv1M7FhYuIMS1kdmZExaBLatwx-Zw4OLuUMWwi5xePzRxJRv5fqI08QmZq9PwkddZXhe8DJBNBDp0Bz1kpfBoDzQy2AjZiULshsNBa4WPuFS-UyPhxFLgePGrm4cppNgtW-2q9C1tWw3qVj0ceSt17fZ4i0Y6OqL8lCIdtX0dBO4AvYBEFvUh1MShTs-onZ_TGqjTR2O5gkEzGV6-aV_4VvlVjID-2eciu5IfCGsJnV6GPM5NWPGVZUWK259dA7w8t9F_zjMZzfpDZFXVOh7pJiEXDZSd91CDni5cGfSHfNtvtQj61PL7KURLKVBmlVREmFl8gMskULsPTVU_oM3KiMgxRvc2udWS78UYH-It2y7GfGGG=w592-h632-no";
                        video_path = "https://media.giphy.com/media/4ZpQKoVF689Rfz8pAz/giphy.gif";
                        description = "-Piernas semiflex., espalda recta\n-Brazos estirados\n-Cadera y hombros acompañan";
                        muscle_zone = "abs";
                        hip_weight = "15/20/22.5/25/30";
                        res_weight ="12.5/17.5/20/22.5/25";
                        vol_weight = "17.5/22.5/25/27.5/35";
                        reps_obj = "18 rep/24 rep/12 rep";
                        subclasses = "oblicuos";
                        break;
                    case 31:
                        name = "Movimientos del Carpo";
                        photo_path = "https://lh3.googleusercontent.com/OHn2C_HZWXN0JEFohaF6S1SFXEOVBNGvYqVnZl6w6ccmQLgB5SOSlRfZ1N2xQxaZKlm6BPocdvCWiDtJsO_T6pzBRogUBShLIDeAVuOPoCj38S4zJZnt9WDNDabPOnNn-2GrUlPfTIgkiwLmdeUbm99UppBmd6uJSJ-J8DZGyI3r96Hm9UCcGNhAqmDtUy4vIHBmqBHBbpBYfboAQoAfDH_O0rppv454NFtpIdwDos6neLfpnW87gXDW27nxj5yF04X2aVWwXYIu2eiYAiYq2Khc67_qskOlI7u3xNYfkgWPMmPFs5vcQrvYpgELCwRePzOMwCPpJZJwqXKpNWPRjupn79Osbhjk3GGWgA2YQobKCXokvtM8pyXnRe-prYdVijhzsPm6eWkKDzp4xeljHKOoCL0FjqI9nNtDjbnwH-GDhRXw0BYAexNdlI1uWXAxral2zIeiVWUwQ2-4yB-3HwwOkPz17IhR6ps8RMy8Z9UBE2ZPlFC5jVSHupVhL-7XGZIZhJG-6Uon_vY0kKQJIA6s0SywLfVkR8JtW2I6kurqKJrP0wWSI1mqxmbmQ8nwvBMwDCF4fjjvvH-Ug0bxEdIIu7-QrzYHR0sFlnIf-wVHJWBqV3zZj31o6yIwg-QiL--qRA13vVF_1gr-Xwtxi7Wo=w713-h632-no";
                        video_path = "https://media.giphy.com/media/WQxCH3vMeVwHCjvZxv/giphy.gif";
                        description = "-Son 3 ejercicios diferentes\n-Flexión de muñeca, Extensión, Rotación\n-Hacer por separado\n-Se mueve la muñeca solo, cuerpo cómodo";
                        muscle_zone = "forearm";
                        hip_weight = "6/8/10/12/16";
                        res_weight ="4/6/8/10/14";
                        vol_weight = "8/10/12/14/18";
                        subclasses = "carpo";
                        break;
                    case 32:
                        name = "Flexion y Extension de Dedos";
                        photo_path = "https://lh3.googleusercontent.com/qBM6Nsyl1hQvlP3D8ccjCrhDsc-dG5D7SptavRH0jvLwiE1pNfg1xnFD4b6I1coPs15oxLWTvYZgk2EG0qpglRdRhhVYdsVu30Bei3TYJTyUeHf2y43RRoIBMMstqZ4IqjfDka_Ea_qou4sSHXr3Z1TqJ8UxHXp8XWNODdojRWBx7WZKHhEjYJsAdgyJVKypgGX5wS5QNVOr2QWyZyiIg9K7nyJXoiKru9bioKUlLVKVxCbKcqlwPPAIurnhK_yKczp1re093HzDlCjZGsTCAHTlFpTzGpLH_6_bzYWCMKs4m-4p1scgqgINH-XZ7LclnbwQ2gUV5qhaLUVaiTs6TeTAqU9gNFLfS2T-hCBPDTD8Dei4wvSn3nw7uPy8SCxJfHlrwvpWwRZ1lPE1oSmVLL2Np9ymdRA56n0WeFnJuXxVUyrCFN89wDtPbr2pCUv0PPKJvUTFdlAdRmlZHsF9thU7TKnyHs0k4ZU3YywbvPTpBes2jdS1eAUteNj0W8UdjwNS635mLYSUg6JEVbcqx8oKhlLbuU1l-OpQBo5yH7OQxH3xnU5IjwKf4iwGaFhrp_kwsikiOYCeLVmcdWM3lPKL5MriderpwsjcxgL7wf9vwJ8b7M9NMbdG9yw-H2qSN2eEoyM3vzEkO2z26Xv3GlkYd2qzrShGSM1ojpWJYeBcwPRAuQn3lO0J=w680-h632-no";
                        video_path = "https://media.giphy.com/media/oOBv4TkeywxU3sdMRT/giphy.gif";
                        description = "-Si falta material, cambio ejercicio\n-Apretar pelota, estirar dedos\n-Producto: handmaster, powerweb";
                        muscle_zone = "forearm";
                        hip_weight = "0/0/0/0/0";
                        res_weight ="0/0/0/0/0";
                        vol_weight = "0/0/0/0/0";
                        subclasses = "dedos";
                        break;
                    case 33:
                        name = "Press Declinado";
                        photo_path = "https://lh3.googleusercontent.com/nTarKZ7nwyXa1kQTDmvK10Z2sK5SDUzIZdISi5gEoqfWYJfWDd_2lDcGssmbq0hPTSWH0zPT7rZNeorqRTsWzeu7NMJFJVGX8_mH9h1ufWANdmSG1weUpO68u4LV74O6M38zIdyNZTEZhPbB2-8lhzS1DI0hkuKb76ro_2HUEYwJU4WukHYXZNf7fjj6JyVxsQlqMjy8UeUKRIEFhbnNeLa5xCkL27qoyqeJ0ugL9N1AFOurI704NcFKOoHWU3PFM5C6bJj7ZLWk028Ic_2sUrzHye6bL-SmqkVwiYZNw3fDHj-3JFOyzd8tq5ag-IzSFWFXRh7_twSNnwuj6_AxfaFPAel-IZn4i6tVklmpRUBB-7HzVESpnouRi3-HplHo_C2h5JlSpu3UNu2XGHTT1bS0VDf5Zi56uqpQUmQjFEz9E8bQ8qXJnS3f6GP_GbRWxnr968EPK-fGcV5-lrsMSTUU0uvQWq_bqkw0BVQMEHGX4QuGfVYZWYAr1rfcmCQaG4VxepD8fVAEkf8DE1JGhhqNsl6DDxWzpvMGzBdCniQvX57lr50gxcpBIi-0St4jp7LoV2IxVYGxzX4FKqI0wfkJSUoBvh37QvaJGh3zHFpoRMMgpsyl-hTt-Cf43pAvLBX7ewnO4-QymKO2BodM1ddx=w713-h632-no";
                        video_path = "https://media.giphy.com/media/Lp4c1Ofp6QAaIk1TMF/giphy.gif";
                        description = "-En banco declinado\n-Bajada casi a tocar el pecho\n-Movimiento completo\n-Peso sin contar barra\n-Subida rápida, bajada más lenta";
                        muscle_zone = "chest";
                        hip_weight = "15/30/40/50/60";
                        res_weight ="10/20/30/40/50";
                        vol_weight = "20/40/50/60/70";
                        subclasses = "med.-inf.";
                        break;
                    case 34:
                        name = "Fly en Polea Tumbado";
                        photo_path = "https://lh3.googleusercontent.com/jh4CMol2iGtE9mf4cloL3A41l42EYqDy1oFIRSOgGwmwfwD41y89ywppmQX0mQXF6x3PN5_O-iSpryo8GJJIiBxCKz3EnWQnlsgIRw31bL9VdNc-__jKblO_hX9Su0SWAHaP_YJE3Tvzf1zbXwYoyivjHW5mY9MljHIBOdqxThNvvH5Sw1zFUi1ndqkkHGfn2fimEo5ZK9gEFiNoYopd83n9jPZtCm7iv4Ezb0Qu0jIShZxIu_pNxYpVSs1vJyBfAmezYJZWPdxfrNTeyCdPlDN3_ZxzIp8GT8ufg_K41K389HXb8xI1KhjQYN2zKGYx4I_dsSwXTtTnooEBm3HqwemfiXo9R6KCLVBsplyPpt4gSsoq1Av_T3g2EYq0y2DUhtGOh0kWOKAWQC022Zsg_K6wmvwBSc-AoZSjN0jMMpXJriFanVx1hvI6A6OVBt8G0GnhZPhwS17XCBdwjIgWBRlChfNzd77mOr16875m9dhUHnYVZqEz0xutE5gRwE1MpaP6FTIpodALxwacsAcELRtnsEyxCpbcEnzoSr2nr2K9CduLP7SQH5TsGwDFD7_FUs0n6ASpVUyNndMhNsga4WbWCoOwxlIui9WfxmUhICpNz0wCJrClnXKJjdZZuyA_C86Al6LXOgPvvDWeLioRXxgU=w713-h632-no";
                        video_path = "https://media.giphy.com/media/khNNuK9Xo1CtBMHopU/giphy.gif";
                        description = "-Brazos rígidos en el movimiento\n-No se va doblando más el codo\n-LLegar hasta cruce de brazos\n-Cuerpo cómodo\n-Bajada controlada";
                        muscle_zone = "chest";
                        hip_weight = "10/12.5/17.5/20/25";
                        res_weight ="7.5/10/15/17.5/22.5";
                        vol_weight = "12.5/15/20/22.5/27.5";
                        subclasses = "med.-inf.";
                        break;
                    case 35:
                        name = "Press Plano";
                        photo_path = "https://lh3.googleusercontent.com/9UArQbU31L4aCQf_iivR1fdaiK3nu4JstLZFYQx0lL8WS26QFjMGPKALQV4-_Hk7f1qHvpdkNdjuZlYifYiJbvJhAG5SZiKF2zmQhXS0DjjF05k1RVPRrF5PiadHYkBlnyR_yONNB6spEIKyjMRkEddtVhP9PSWeQjKaFV_Bh6o9aA1kMDzPd8J2AzLtFCLt5pM2Z__oqGH4lxz-5NQBJQI9rQbkXVGDupOswYvlalIh1_Zt1lm65W5JkRVtQTuDwN2zX0jAYZbaGFOV4MYSLfMPAs7X5ivk_WN0FOtWEDMCxfwpWnT7zvi7xcfUOyNGyfgMsKdoYh3mfXT4B3LTmOvNkMI3UrwkRVu4krQ9Wq7X5Z8qNcUQEhd9ay0znkyTj4y7e30jEwJCvPv1fYIcJCvq2us61q_mcZXyrtY52VG7J00IcqvSKpZgAcxzGYVRnAvy2XkfbEJch8ovNE7NyWPVPJq-qS0Kku-tZNvSRvq7vtMsiGLZq3T4JGv4zAgIUWW9lrYz-Qxpu26uhEr87mYICaZyW4zP-oMDXhHqVemDjCQaevq_T-bAWsCNPN61xOyGWt3fzqEw5a4UUrAU4CXDRCSBWzhcyVLTgnoqhMnOJTDGkjwZxs-Zjl3tgoRoeXvQ_lELRTbi8cZKWA0yV3aPVx7F2RWFo065ofJkjbhCVuxN-nXeGt0=w1062-h944-no";
                        video_path = "https://media.giphy.com/media/YrNy2LmzNOGsWBXCUG/giphy.gif";
                        description = "-Tumbado\n-Ángulo codo con tronco 90º\n-Codo baja un poco mas que el pecho\n-Subida hacia arriba, no diagonal";
                        muscle_zone = "chest";
                        hip_weight = "10/14/18/22/26";
                        res_weight ="6/10/14/18/22";
                        vol_weight = "12/16/20/24/28";
                        subclasses = "med.-inf.";
                        break;
                    case 36:
                        name = "Press 30º";
                        photo_path = "https://lh3.googleusercontent.com/dFMVLqYBzh_7OCfdzKh55AcEfQ0CX6esWztw1qEb3SZ2xl11u-s56pW4_FFh4SzqGAoEoQwifiHLTPUzJc27oWNG3rzXLcf4dwsOgIp40HgsKCIcWhz-XeNGuyFAujTOcxI5xQMqsuTCmJAPgpexG-u0BktCkvG25EWOGURy_jiF9kuwqlVFebAHPPcBriDC8LkE6ykowV9MgxtajBeKpttLihRmFngAkd44z1-8vlOCJ9JtYv9Ke-nTJWGDswtVAAtqIA1VTIhK_ILPxmbWYWbYjHDdo3o3gvkTp3eJuFZwrwBdI96pd70WtTfpPdHE1eggVGw1ReQlh0NbCfsc2tzkbvh1Jr-vrEwwVnrISi2xwbYN6_fQmNncTlqxj2YpQDMR_ZjsIdY0YA49K0wgV7QgG81n8T_2NeAwJ72NnKpbfxCroIM1JYruauYhjnEbHcv0zqEwWGYUySLwsek_c4VES0egzCWqOj07tOBAv3DQ_EGYieUZPgY0dUyGks63y_djdLPT6rPkrZh3d5pD0QvqRWbz4D4Q7No0ivLOB6XtjHVrRdmXbynmViOQZhP66ysTyuRMrouq_FMnYz5-kxZOYIH5UkqNmcND1McNbjQSjQ7_5tj9ADWhib6fvuCOwAnMesKw9A3DyvjUJaIHIc3sqjNrHIOisSUfh_rNWONm8NBZ9ME27kc=w1062-h944-no";
                        video_path = "https://media.giphy.com/media/KDPE8fHLRTAgY0aiBg/giphy.gif";
                        description = "-Banco 30º inclinado\n-Ángulo codo con tronco 90º\n-Codos bajan mas abajo que pecho\n-Mancuernas suben rectas, no diagonal";
                        muscle_zone = "chest";
                        hip_weight = "10/14/18/22/26";
                        res_weight ="6/10/14/18/22";
                        vol_weight = "12/16/20/24/28";
                        subclasses = "med.-inf.";
                        break;
                    case 37:
                        name = "Press 45º Mancuernas Juntas";
                        photo_path = "https://lh3.googleusercontent.com/hOpPk5xg3m_9JeohQbS5NtJJxadb4KsPc0bsM5Tl2TooawGUeS0kseNPoz_qPolQ_ggYU_wvqPo2XucJN2WzctEJrZqApiEmChBPXhGmQwuNX0vgstL_lbEWkTG0aAZkAMIyciTHP4H1wYHviizr3ygOt6vjZ_2MWn1DzVjVg4MN908uRhusxTHg8K82Lqbc2l-6VFjVRZf8eMEE57Fxa5NVc-vMI4VcYYkVtarlOy55q26RNzL62PYCvtBikUBlgvnVPEpSVlqkUySKL6a9Zcr4ccKkNXtrIT8yp6lWErtEBNrL5oxMQy2lYQZDJh_9Cv8jJjYB3s2ZtrdPpkStmkqGVcQJrpzhkdQICoAQuw3PW7qWUY3wcfifGNklqf6Vhbzrr6c1fUB3QO2pFb9MAM1skdtO9SJgNK1nczJ-xi0XBGqSivDIiXX1ts4qaR3MX7_2MGwfCUQkzyIFnydFF_yv1Ry_UuoBQeujsFhLtu-CqBKrbP9m0r9-r2fLO2rawOC8WT2CukgPQl0NL7hDyioRPV2h0ekV01PxoMkclTS_fZCkiTQvtECfRnABpJmAHZGtPvLkj581qgO773H0L8zNvnwpXkt3t-vK8nkBiwnLBTQ28KoSUHe8G6I7yK5-zM4TuxnTuwxWjYAxQF6TE-1OpQTvA4gkK38Ltwk3B2EPLU7vctimNWY=w1062-h944-no";
                        video_path = "https://media.giphy.com/media/RkEA44dsJXzVpd2LJo/giphy.gif";
                        description = "-Banco 45º inclinado\n-Mancuernas se tocan por los lados\n-Bajar hasta casi tocar el pecho\n-Codos cómodos al lado";
                        muscle_zone = "chest";
                        hip_weight = "10/14/18/22/26";
                        res_weight ="6/10/14/18/22";
                        vol_weight = "12/16/20/24/28";
                        subclasses = "superior";
                        break;
                    case 38:
                        name = "Flexiones de Pecho";
                        photo_path = "https://lh3.googleusercontent.com/HBWh3ji61nLyNh4dwMQSPu5SJLBAXING6vsWp3K-0HLkNydflqFRHDJHltufAtixc46Ca-GsjMAoYV2wa5w46dwJcIJ5qV4irZpbXRWPhoq8XrQn7Mh6zuzfyJGbVGa4mxkDhK8L23d-W0w8CMOkHYM87YIWxI7RwYHJPqMt999wv6MNSwW_1VKJPbMWZGSv5L2J2F83t8Mgw9gT0SO8KQJDAyPl3G92_qfHLEnyhd7Ya8sjbNd_prLXdBjFuMdynTWIez8ZcK6eAwcRgGv6FVFHd-SVJksKa3CEmSTw74zkgmmM8LvyuUK8WDh2V_UgIKRv_otiCBzjsXzq6E_Hpc17qzwVVoTkAW1Y1Qnl8qvTq7UzobCx_Q725h1vlihAUfKgje2CVbQvxn_0hvklsnivE4K9PEciRROMQzndU6HUgFhOWPXNcyBn4wDvZUHcnl7o4MEZ_0HjEDiiv8XCIGO16hchO3e4NHtzLYyTb4-L5YZ8Iq8Y4wVh6CdoweOkmX3ebEinZZ_03xrNwQc8vtoU1Ny_XRre2HU8tT5Ffka1seL9X40pRAvmJurcVfByxUBA04aJaTZ7xniMGvyWUqljtYk5WoczgnBBauGE6I5lGW9cYiRhYMHuX04eNx5ZCW3IjQgAOx_Yd8rkyL2-ahCDiUNQyfcTvnSW2y2fxT6Bqu9WH0dHi3I=w1062-h944-no";
                        video_path = "https://media.giphy.com/media/IcoHAVoMgwH1MjyHZ5/giphy.gif";
                        description = "-Brazos-tronco un poco menos de 90º\n-Bajar hasta casi tocar suelo\n-Abdominal bloqueado cadera no baja\n-Rodillas suelo si no puedo";
                        muscle_zone = "chest";
                        hip_weight = "0/0/5/10/15";
                        res_weight ="0/0/0/5/10";
                        vol_weight = "0/5/10/15/20";
                        subclasses = "med.-inf.";
                        break;
                    case 39:
                        name = "Press en Polea Manos Interior";
                        photo_path = "https://lh3.googleusercontent.com/wG6geg2o8NhyJxHn5Q6hIPVcWJRPaXC_uzLPXcI31IiMV7dlCuM1CPt-0w-A0ORpE6EPD-Zj35-XyrXbFGvLWhQInHXtD-lxzRLGWeD-pyOFuK8wAfgZg1Ls2L70q0HQfuxuHORjN2KASKfPhqBuLQUNE9WhRVioNU_uMuK6u9KNJuEmJuvXdJBfGnslpgRJYVMn2pKrrLALa7lBGQd_EA6F0M32cTYUdk3K_WZFpWRtAKQIndqBDsC3b4crFjCN_A20BLBv8FOwkjurh1oz-e3EWBOAG0vJmNKEuEJGoTns3fmhw2fkaVRuY-fmjd9k8unRqyo8DFfrqd5bLOLEQjZtJTFbZ9cy3MUOnDXUNTl28Zsi57nNZamY9BXAGUTfSciY1iDJmaTvm2tSfURwshk55HobC_CRdXHfoh0FxyNaI-Po0O9ykzvOCxZmdkn-_E2pg4lkEsIrXidONlnU5yAueo42eU0gy-cuu0JqoTgHf-x9IgrlSH50Iq2I2P5gKurAOE0OdL7garWGJ-wX0X_XjV9BDQRSWxx_WmJ8VGI-YM9yJE7ROJpR9O_K7Zh9AO6saEVVq5k3wYeb12a3dYdTcg--bd8L9LbBVeXJWIgPJatgCVJdDF8fRuiadduO369-HxKxx7T2u964sKLGz9v2bvxhg5ZSrqCWoIYJVQTGDWNN7EjUH-hV=w713-h632-no";
                        video_path = "https://media.giphy.com/media/cO98Fsi81nrptiLMg1/giphy.gif";
                        description = "-Banco a 45º\n-Mano cerca/arriba del pecho\n-Mano sube vertical (o ligera diagonal)\n-Codo cómodo sin adelantarlo mucho\n-Notar la parte superior del pectoral";
                        muscle_zone = "chest";
                        hip_weight = "15/20/25/30/35";
                        res_weight ="12.5/17.5/22.5/27.5/32.5";
                        vol_weight = "17.5/22.5/27.5/32.5/37.5";
                        subclasses = "superior";
                        break;
                    case 40:
                        name = "Maquina de Pecho con Codos";
                        photo_path = "https://lh3.googleusercontent.com/P5zpIRLvrhSQKAbP1aCHLsKaQjtR_oGR3D7N5Z462lJeRuP2M_1wNH3_vD3q7qg2rCfoANRZ8J3301K5fW19Z-pgovi7tfDdiz7fMP3JXCMdnxkOfyoOtoIyOvHrt-Cr5KA9drKukhk7WAEETFpQEqRzXEaCxKsNDX9hJlJu1zO9I0v-KziIx9Mi5GVoHPUCuwTYRn5fBG4zfN-G2hleEmRT6jCkbktjFj-xVi2k9MAKHVUAQd7c2s7t-DKwbOtSXL0qoEDR3AzW7PQoC6wRT-0cyymYVMVw9TlDqCFEdfIhsUsjhw5I094gReE7yBj82BjmJMlEbbzr5vJm_KTzKl30Buvz7rnmFSy3u2jBf8vh4c6EVBc1EdjqQ81Z2E2i9c-G1UyG0dluoSHMseR4adbGP72vLTnkqT95FwdFntUkMsYiOkuF5z5DFurCvBc_6w6ewDZhZrgHlL2MhZHUwHBAAVFpR56T0K3MwMcclnN4P5caASPkmzpzyBz4z62BxAmT7JrOE4J6y1a6IkDXRuuGuOVeaX9fjzQ3yKGrqeV9Nbjljzw8yk4fTyfNaF2aXnBCcYUKiS_KmG1OEJV61Rg8S0CG8IVuEdWihyXduHZfvCmDy_4JKYQtZYAu6_eW8BY2iK29-3HdSpKASw2ODqWXGafvwN8GlbpaeZ8z5t5ysp2vnd4CMRKN=w713-h632-no";
                        video_path = "https://media.giphy.com/media/lckzTgWUmCygx5AiDH/giphy.gif";
                        description = "-Con un brazo solo (luego cambio)\n-Rango de movimiento completo\n-Espalda recta pies fijos\n-Controlar el movimiento";
                        muscle_zone = "chest";
                        hip_weight = "45/55/65/70/80";
                        res_weight ="40/50/60/65/75";
                        vol_weight = "50/60/70/75/85";
                        subclasses = "med.-inf.";
                        break;
                    case 41:
                        name = "Cruces Polea Media Altura";
                        photo_path = "https://lh3.googleusercontent.com/XiOmV7qTmpy8P_yAmuPwIi_e37d_LWd-iRYnMRUjMQutyl3tLv01V17CIoJV1GKReuW0UsamSIQjvZiFeLApAN_J5Zgc-UKkVjj6gLuslUsYHQianMA8fLWnMAim2k9_bWm877HyUjI8kU_yuI4DFgmRDUsw2SDe6HoEOaZfoXrrfmlWjQqxMaNrOPirESH60Iv3X1qFlg0sMxNrPDIutIgYBiOSZLPuxELR58ptZ5Bqd6bdpPXFuTIqRs0QE8T-tyAvGSM5wCn9t8PwuhkSC9DHneQuGVtYMiemH_wZFQttvB8AaPZUANr_WUGE4vU3aQQPYqb2ri-a9OnOJtP41VgEd1xfjoEf50-ZcVvVM7DPnVkndQFZnivjoZWAj3rWKuqEJynLN4r3SrXx2eDhJ3UMvIO3Sb1BnCi3-K5CXAXlSO8WuvVsZ4Bjga_qPmLAXHoE1Apk_ajx8bwdQv5FaySj5_yayvR2hYomRtfcp_7g9p0sSVsnhMEWPXHYyJQhwdjiP7sBMvOPxW1tL3NOWk8_-oUo61AVaUcu3RPCHAGNYODOariDsL_BsXS1s7vyZ8j8BipB4FDZBYy1RDBrSGoKoxLFPYJQQ7yFe8bPoaDnYovfueXjJxj5VqQnB4wKBq0evQa5zZ7zaDtKNdZ408ojtXNL73WW76uEAx9tA5des7wPS8UZ5VQc=w713-h632-no";
                        video_path = "https://media.giphy.com/media/3XsYNpeIm2z9qcpmvn/giphy.gif";
                        description = "-Espalda recta un pie adelantado\n-Piernas semiflexionadas\n-Codo no se dobla, brazos fijos\n-Llegar a cruzar brazos al final";
                        muscle_zone = "chest";
                        hip_weight = "12.5/15/20/22.5/27.5";
                        res_weight ="10/12.5/17.5/20/25";
                        vol_weight = "15/17.5/22.5/25/30";
                        subclasses = "med.-inf.";
                        break;
                    case 42:
                        name = "Maquina de Pecho con Manos";
                        photo_path = "https://lh3.googleusercontent.com/KrlzoYtbwtAAT39YF9gbm9YUZJnfv8ZOkjeELcKjrP99U0D9dIavLOYylx18ZpsVyWNI9Ir_97rqFHy7QZlOlM_kDzr14G8EXwhG8CdD6ySF99HKykSmVbV8QAn_RSAV1QnVPFe4xM08sNOJfK7Ro8k6q3rbAcb_x7v-c-yzK06G0Ev1wxNVihmYfH8VmDmCdSvbyPeVwvfbBPonPaGRLX7Q09_IjSIKmOFsEkWmvzKPhUNTDl3RmiUEQN_sQ6qqylzDN6pE8PQGfO9sF8vv_N1k-9ExKXgGr5MAIEXD6B_X2BS_ZJW1fejdEzRWoDp1-DUgO3nBwFP8ZC2YqBQQvJcKttcSriAWmpVdt191sDNmB5zafdFbYGm6pDPCYpKdLYHNo0Se6ouCtXhtAxLfMuHGaqU1TDWK6l7VWVRuRq1Ze-P1yrlR7_n8mjG5hPKpY2Ed2jjYXrTnqPkYwYpNtwsqbYhr_Wdm0B2gZThmvQJPv0c8aSKjr6RAMOodvfvnfVEL2cvTFpJnD2A3WG8GXJ-HPNGcQLz1z4I-VOmdLmFFGaxAeq_ChE5q1MJMAL4VcjWtpb7HMEvgQJSMv-bVhL4jSnnH4h78-nIVNifdY5JT06DNU7JX8msj_IS4mf0Ct74RBSmvPCqtbzmTFiIkzpP7uOslfx5hAZolLz5N2yXrt_clOmPemy0E=w713-h632-no";
                        video_path = "https://media.giphy.com/media/QOcdHH38L6p4XFeqCG/giphy.gif";
                        description = "-Ambos brazos a la vez\n-Rango de movimiento completo\n-Espalda recta pies fijos\n-Controlar el movimiento";
                        muscle_zone = "chest";
                        hip_weight = "35/45/55/60/70";
                        res_weight ="30/40/50/55/65";
                        vol_weight = "40/50/60/65/75";
                        subclasses = "med.-inf.";
                        break;
                    case 43:
                        name = "Press Guillotina";
                        photo_path = "https://lh3.googleusercontent.com/H69ZWlr72fuRQ368wK5T7Fa4-aD2TzaiWeJkKU9HjwS_8aalNfk4oaJh7InzvbHkV_j0afjFrd1twmGgr3GAwaZmWsAP3yEEZhtji37teQl-1uw_66r00u-l2kaHhze25FeNwVWuniOBrBPG4sH2_gZSBoO1Yr52Jryx1GmTtA10QKqdlhflT2yGlZD6RUyhtX6ONWMP2b_1W7ex-NN47QkXv_Ec6NG71MPyqEbbS4TXV3Cgr_PGUZX0YY6FwZ0ag7X-upl-C_G56S1muDlhiI1FvVWYLXUqo1NVVQiBaQf569JZk_FeDkYdryLjoNEMAcU0DOzgqnmdBirAJHuzcE8Sy2la5IQFqIpQ1W8idtf9ykpVXRV_bDsxXwnh1fws8q208af4_tGwloSn1muSVyqNd98DhqFnT1ZbKr0bOGP98zSt0fIMNnfrlSHmOW4YZwSX-ZPFEl1i48dhOBfmfZoYh___zO7OLr3uqPjV2yWKyohnwr3PwGWPHzA0vJTNIXw--Ja016xwGhCdvTBIa-dKp58dmKH6lol8pTUAtNFqB78IUEwytv80Fdd9j-xyX-LKajJ1cUcP4CpM3Z99PEBSCy6tDdtMEKaLMJ2SnN8Iyo7exmVz3H6phD2iU5_jNTVZo6124adPXXoV9aaqH75KLhoEQ9EeQMiGFz6Omy4MQP_AwP4zEGNr=w713-h632-no";
                        video_path = "https://media.giphy.com/media/1yn2K3ajrcTo14Rr10/giphy.gif";
                        description = "-Barra casi en el cuello\n-Tumbado posición cómoda\n-Comprobar posición antes sin peso\n-Rango de movimiento completo\n-Peso no cuenta barra";
                        muscle_zone = "chest";
                        hip_weight = "15/20/30/40/50";
                        res_weight ="10/15/20/30/40";
                        vol_weight = "20/25/40/50/60";
                        subclasses = "med.-inf.";
                        break;
                    case 44:
                        name = "Press con Goma Elastica";
                        photo_path = "https://lh3.googleusercontent.com/nS9-psx7Id3yE7e5yp7FnFSADOZME0EaoRsa6xHuk4h5K2zisoZ4Iu2tL_nenCAF0N0hWoX20qwTEd5BrpTwSZQW-uBciR-Rjml-peqJZp1UikSDOTP-gzCvP0gbyr2FrM2egpG_CIfaxoMFDAxnQXdqAT-JfBSRHVT6YWy3zwan5c2OxvAO_UoW0LqBwhvuLcA8SxC06ltGUuAdevjXn4vfdcpggC7-MkbK3lko21ibKZllYh70p3i_cyPUtzNxvA-7A6DnvnWUHabiy5MwOnk7szX-SE0nJVY82kfAD7kzwA0vSz_79WCcNiBaOJC4X-_0ulsvd_pPtwRln-oxNKxf4sP_zBefOMLFEV0bm6krduCn304a9_0aTzW2DSX9tGbTqAy1toUhirMk_MbXw_kL4hykZ1B5u93Czpg24F2fdxckoq9ntSZ5dEMUNSSvCDIl9ugLEkCnKejmuhFHMtLyD7AOBxNowdSy1i2Z1DxP5CqvodyASwQj2m39RNz3Zf53CbltY16UUiAYqeCgyFAXKaiERkBXJIjEu02niDzMexHqLVvaAaMNqi1KKW8ZTE2AoeViUE1d3K57MXixHn5mXntCQaHkFC_KzTJWMiKu1-CpxGLNAj4b1ZhsVHx--p56a-v4ex7pTvvNPT4lRRP9S-GMjN5ZjY8XDy1T1ub_0xxZOScUmWJm=w713-h632-no";
                        video_path = "https://media.giphy.com/media/2Us45e5cTKSDNoZ4tf/giphy.gif";
                        description = "-Espalda recta un pie adelantado\n-Goma tensión inicial\n-Manos altura pecho, codos pose cómoda\n-Movimiento de manos paralelo al suelo\n-Nivel alto: +separación y goma +dura";
                        muscle_zone = "chest";
                        hip_weight = "0/0/0/0/0";
                        res_weight ="0/0/0/0/0";
                        vol_weight = "0/0/0/0/0";
                        subclasses = "med.-inf.";
                        break;
                    case 45:
                        name = "Burpee";
                        photo_path = "https://lh3.googleusercontent.com/wrXn5eR8QTD3EiaBTLjB_JITA1iuIwLu7Dpvrrr1uYVZotyCN2m1WCU-oRhEPQhtOJDYymr1GdeuHJKGEEN2vli1Aet12nZ7_znYwW3RF9aVOgtmQK2ZepwMMnmjOXmj1KexaJePkiN0NMPkHJbvy4roPY8x_l9IFMo4Dgpo0sR0CUqvUAPvVjfIbFyffSZaUIsNddhdXbDzHtHI4E_pDhcombJ92TJHG5VjUrbdnfbxRhICKAp3GfGj1bq7yeWD3iJGdKKFQnQvGHh3TawOU463RpQInKnXqfk9awCKf4_W-CazwxJMstdlN6hluyyycod3fFGb_7lC4jFQgsZO0VCUEZkgFjnbiE_jNrfdmqCBedzT9g-ZkVc9dWEfwCKD6g0G18nPK4SJqcPnZEUbwiBa3BgzcZBWba7Fqu83YRNvp0ViZUnf9o2XvlT4iPHISNKXyDxhOut6TF364Rf3GuVf5lXflUNsiFgwybQer4pBemHNYuQSxb8riQ3MgqXBZcfQYUnV572w9KrqJZaemXl1IhrbFLJ5BBUttkjpA4uaTh95YvfJz4RHDPtK9vmZEcIytff_RuRWCvdauDK5FJIVPlvSCHPGNrSEwKHCmPxZ3hJK4sF1WoNq-MqphbW6C3AQyGgO_Rcjf4-UhILcNoJOuUsEViQYpFzpySbXuNZwdkg-CbLZUDo=w1062-h944-no";
                        video_path = "https://media.giphy.com/media/USUUDZmy3VjqfuDeeJ/giphy.gif";
                        description = "-Flexión de brazos\n-Salto adelante junta pies-brazos\n-Salto vertical alto\n-Salto atrás vuelve a inicio\n-Repetir";
                        muscle_zone = "chest";
                        hip_weight = "0/0/0/0/0";
                        res_weight ="0/0/0/0/0";
                        vol_weight = "0/0/0/0/0";
                        subclasses = "med.-inf.";
                        break;
                    case 46:
                        name = "Mancuerna Elevacion Frontal";
                        photo_path = "https://lh3.googleusercontent.com/ChuJha1AaU4qw5n3GICZnBXCk476NopfphD45EDOA2K0Q2zFLC7fYVj83cDlHpMqUpZZq2oGwdRMoZ57CKIEwnui5WJ7Shw2EOqLKT1ZjAdNaCpRbi3PWeUoebnM5FS61BvqFNg-sdDaQ58GYkerNm1LI1-coBkv2hZyFFuF6pm1WmkVnBAjFTfcgsTO0qEbW9avhpzczJpPOOL_4EKrlxTFDORwGsnYt0YzC1sW4aORNZo-RU6QBGBMSRI7yjWrxgKRRdvURuqs4iD1KmN__t0fmu1LOuxit3a_YUbhZkXEFgSbY8GYCS0rCGL_v6My7xyxGOIHXvc0z7wQFjycSZKao1Kh_dBAaaEdES0CTv5QMpdOnhgOe9o9IQXW0v67pA4WNF2_IHi1PaaxhsuzKW4eta8mKIcFPtWDBmpXbqI_ymtVSMVD2rnT8B6APE0lCR61h7iWKz_V2YmD3lwlLelOzpjBqVcR1HTNGmbFbpMgo8vegWBTAV6-znPrmfLYnObT3cqaaqSiuLtSDfFFDu-66uDN50b4caliQ6M__69fE06wOYoyHo7t1YRD76fZPV50IIksOBv0HEEPIhqOZUbfyTldDDSMewIygNSWJGBHUklrlqvloaOlEfbMQ8zI_OqSKzDCm-o1OeyD-hVP2LC-CAOKJzSHjz96oqmqo2EdbE3IwoXICK7a=w713-h632-no";
                        video_path = "https://media.giphy.com/media/vRMlxt9czytSmsEnn7/giphy.gif";
                        description = "-Espalda recta, piernas semiflex.\n-Brazos rectos fijos\n-Subir mancuerna (límite sin forzar)\n-No balancearse";
                        muscle_zone = "deltoid";
                        hip_weight = "8/10/12/14/18";
                        res_weight ="6/8/10/12/16";
                        vol_weight = "10/12/14/16/20";
                        subclasses = "anterior";
                        break;
                    case 47:
                        name = "Press Militar con Mancuernas";
                        photo_path = "https://lh3.googleusercontent.com/kVJF7_wvEXQ-KMXvoU0AEQpvkbsL23k06jK0LhbqLl8oiHHB40ZzTivhRtlKBgT1IiL08eV6k3cqKRvRosmnV0xBbvfUwltg9d702Gx9gzol9zLfNepFszy3KNB5cEps6W6zeGMkh9kxGQlMaCsSYLyV2GeY8wNj2Bu576V-3I2Ja-oWSmWtsgH1-u66Rd8cYOeZNy0AENLnKfNFp-gGVEYr5IvGz0rBUyEnGrp1vvyN4Q5DLAk0-XubCVAd3exFVFaTB61fDuUjAz1lQqNIwpv6kZ5KFm2u5POP3E4Z4oL2m0N4VgAkzIuMwVTXkpioH31rS1RvriREHZZDh6e5OGJcYHyKfWYgxlEO2dfQr_--5lWKqylqXq94CPT3QRJj5xwMnyRxKlJ7co5MK9mR8eMZ5SHX3mAB8FmTQ3kyePZoQDaWwpc9V17hdVtJBs_sBAEv2NzJXnN6z7YU1AnsZ81vGkqxFgb1Oj0KG979CZzxA6XY9BB7zRECgxhAz2QMe1H-AUZ-ryBUn9kg_a-nC3CNsK5g5E-BJ9BAbpDM6QTqG4WFFndt3eiFomwQatNuxEjNdOropxTEkv6W1cbS-nji9hn7hkta-rwnc4QBRTitraFXyPkjqHeylpXn3psn4YWZC-wVN93O2MWkzbWevl-KzPOWxIvVog1wi1yarc7mqg4EEmZt2W8=w1062-h944-no";
                        video_path = "https://media.giphy.com/media/hoxVs7xJTliPD070wk/giphy.gif";
                        description = "-Espalda recta, piernas semiflex.\n-Ángulos en codo y hombro de 90º\n-Posición cómoda sin forzar\n-Subida en diagonal a estirar brazos\n-No balanceo";
                        muscle_zone = "deltoid";
                        hip_weight = "6/8/10/12/16";
                        res_weight ="4/6/8/10/14";
                        vol_weight = "8/10/12/14/18";
                        subclasses = "medio";
                        break;
                    case 48:
                        name = "Elevacion del Lado al Frente";
                        photo_path = "https://lh3.googleusercontent.com/7rwRjs-fzpNEKtkVf6FhXaWJfDLaRrzwMv2KhewmbzzV1P89-pFIC9Kt2B0_bCCFF0YYbpuw9UiYElQ2_FSVW5TkpVWdD4oPJRO_5RD8nRwVeedsv6ND1FLNXzsBy3ds1jHQBJHlRAJwWutK3f5ebkvE4ZKj0L1QPEQ42Xw9K21fkh1q9YH90ZK68AUlVWULz-47TTm-bxwLFLiapT7DUE7fqNdCxRwAEcf8vd-Tq5vxweOwlnXRJtaiULnLE5Yf0Vu7OG6rqB9IO92KOWpqi8zCNU5qgvzI7hGTm3eVdyBNbgweceYOU8kf-PTHnQO4uZE_P5gFkCqs_VJAt2f0xxG2wUf9kb-zp6eQPv87lsTQarUOEMYYtOiD61v4G6ZQ6yiZGPMuvFJn8gjYg2eulBfKGYjW9gJ2HUVWvVxhsprVheZYSSH1N2b1bDJimERLhxUTR3q8UQu7fdPUfo3dVTiWxpHlvClU7V4C_dLETp5N-2AvvNIDtGcKzRz-EDMJKZBW_-yAABJfIjwemvEefKDhZRKDUinoN05kgeYXgl47BeDqLmBsi91BJgk8hFFma9f-zqy-DanRUbDRCCyjVmidNPQCnzL0GR7xgejSUZsnKVafkOGkhBQrM3YVXFcUyh_alvg0IDJE8AM4pJGN5_iummOrWzwqY9lV--tAowdlRJloPS_Vpbv7=w713-h632-no";
                        video_path = "https://media.giphy.com/media/8rEV7amrTu3Qa0g0il/giphy.gif";
                        description = "-Espalda recta, piernas semiflex.\n-Brazos rectos fijos\n-Mancuernas al lado (inicio)\n-Mancuernas delante (final)\n-No balanceo";
                        muscle_zone = "deltoid";
                        hip_weight = "6/6/8/8/12";
                        res_weight ="4/4/6/6/10";
                        vol_weight = "8/8/6/6/10";
                        subclasses = "anterior";
                        break;
                    case 49:
                        name = "Polea a la cara";
                        photo_path = "https://lh3.googleusercontent.com/5mevVmwn8Vo77PFyjCF042lx55TkL8dx2dCukINLsl5ho1KSmgYB_wWR1ilpCaIodSS1eEWR_mtWDuM9E-GH2CxCaxzggzmwSEGRHUW8y4TWm8bcoyEvT-1PCHSuEg4AX4W5-yPsqFJs6oNZbVnurIEJq7AvulJztGiPsY1b1yZBToVvPGjiTwrVl3GFztqEXZ8R9Lnf-vaubmnJcwELG0Ov0oVc5uleLZGT_1wAebrAy4obnOZEyYkeaM1bxEtqtlpZK2LL_wbavjpz1UmAPYO5CsDLyODvXXt1BcZ4A960LbBNPbkPv9wF4GuX2lLa1FDpOWVMD-a7rOBjN4rTDRJxoXWwOxORYwDsQ39QEy0qNN06h8AGFx1W7CuCcVzVZQUU5GfSIgWJfTUqqYvlzvgyBzNijL9-pLMqb0cNoBUETEdTDENS2GYJpraHR-b9WSJWPIBKowUyeRm6W4xYhoarQnrpqLpUdPtmRQQOgW1po3QjjoYl5uXWk2hRA2Cq6SGNiSEsYdNGmy8kLbOzStWaNLbi8_cJ3jrAHtP9188Do3Of6P5YeXBaZoFKnJVkQGHCcYmLPu_0VT_HO_jS_kdtq25lCBT6t35T2xiI7LwPWcn2iIUCRl8052qB3S9o92NqdjLWgeAG5AQ4D1gHAlViXxb04AMipF91N8NV82cgBknPtuG3V_o=w1062-h944-no";
                        video_path = "https://media.giphy.com/media/MaxxmOKT5h1aiLZVRG/giphy.gif";
                        description = "-Espalda recta\n-Controlo la vuelta\n-Sin balanceos\n-Movimiento natural\n-No bajo codos";
                        muscle_zone = "deltoid";
                        hip_weight = "5/10/15/20/30";
                        res_weight ="2.5/5/10/15/25";
                        vol_weight = "7.5/12.5/20/25/35";
                        subclasses = "posterior";
                        break;
                    case 50:
                        name = "Remo Colgando";
                        photo_path = "https://lh3.googleusercontent.com/HqwTjUvthT-ULT7HVNZSlb7ZPn9LpcPBgCrFphL_KM6Cl4Clocjwi7np7j3q22Ds33toA58BZ6wB46Cbb-mpu0x0sX9V5r-uomi33PQe3d64lwhE4L8dIxmwrgO73Kppp752TtLLp1LIznaiCZgpz43gAeQbrJodzkskyzTcDzRjJ3CApCJPNcuS1CjA1d7bLlfoLCkf4N-ifuCHXCu_8RvuoGrtSquJwhWGOohJBIUUdTWNeeGyOhb1wt3xFVVhzy_6nzw9t2HgOQXtbYz-XGgcqKnJxRkFmcbOWcWxPr18hA8DRk9roxBG4oH7nsafV9DrwHbgnoyGClPx4zp-RCUYJTMIWatTm7Bdla_AhFhrOGBEqHmhhqPiVEjcQo5bSnVYi-5sjmqCxcF--0toyCfUkoBa0pbZ3gFyjtRXElGgHejWud_BKk3wNjiopAUDHoOoxNMBlJJ8XX1WgVlDKBbtSALgA_3KcjOApqZ4h0bi0FNuMgxhYnyqFLT-JXwlFcIUZKjPHqJLc-KIOaM6eY3D7w0B3JuHY5ZitulTwl58Zm4elq9GvRrC4XwyBt-pFAQi6iFOoa4g0_jZHNI4qF-XRf2DOGUsGUx-NMpFgey_wW5ULv1IBWuY9bZCk9bq22iQqaHDPVlIJztM7eeEkRbNXY5Pau047QSrIMLbYVPvDNYaT8ZNtqwJ=w713-h632-no";
                        video_path = "https://media.giphy.com/media/1sxVMlLwLi2O58000A/giphy.gif";
                        description = "-Flexiones al revés\n-Codos y hombro 90º aprox.\n-Cuerpo bloqueado\n-Subida casi a tocar barra-pecho\n-Peso: disco en pecho";
                        muscle_zone = "deltoid";
                        level = "hard";
                        hip_weight = "0/0/0/0/5";
                        res_weight ="0/0/0/0/0";
                        vol_weight = "0/0/0/5/10";
                        subclasses = "posterior";
                        break;
                    case 51:
                        name = "Elevacion Lateral en Polea";
                        photo_path = "https://lh3.googleusercontent.com/X_hAFBoGAHEUTAhtovzRBpzkxCgOyLeShLG5-Kv_lKlz7Qy2PnCiW6USZ3ol_aRdouUHdYqf8c-HFL7jgsp5qvoqfb84rhOYKQC-Ui_sy20miUZ8oPE8gg8aZWfaYjwkiYHbGKBoNUJuy_RSBTEcojQpda19t9tr2Qotu_ZKIjf_vAoqrExbx8YpUhXqnYZkfSVogAcWxXcI_u5YiVsXslaFkjrkdHkwIQ_nn6TtgqUISochid7qS6hDsywBwi5mnOA-t56fET2dc0o1b67utEDDQiFhkUwc4b41EYD5KwPs7p1dsXqckZGGo0A4AEV3300aXgGquRtdIf1OMey7xXknRORuslex3YTZeL1Vkz4zeb2FFGvRT2OwHpVluzbLSWjR3EhSQDpNVWEcWlyLPEdudo2vd_wKYvGm31nuxBlNEBJUk1B6y9JHKqJOzUW2e1H0Gdqu2EOmfYwndM6RpRhTrWKtywkktBl0M6iLWIUlAZiZcckNIJqhXsw24dFLJB7htRzQxYsAuuNz187FTa-2ruPIn_7ussgLTp6DSjfiaZjzP6nZENnP1iwKDbaZ5FUx8_q9m4TRfZsLeH3AMVOu_o0jFM_Yb-JQor7i-X4oz0q_HNRMa9ZzWvbPS7I4_xh3vdylRQrdiw69h55WaqIJw2m3zWSNt05FXJm7o4s-yOEMzL4XQ6xY=w713-h632-no";
                        video_path = "https://media.giphy.com/media/1itJhTMvLvL6OQQvxS/giphy.gif";
                        description = "Espalda recta, piernas semiflex.\n-Estirar brazo\n-Posición final cómoda\n-Tensión de todo el brazo";
                        muscle_zone = "deltoid";
                        hip_weight = "7.5/10/12.5/15/20";
                        res_weight ="5/7.5/10/12.5/17.5";
                        vol_weight = "10/12.5/15/17.5/22.5";
                        subclasses = "medio";
                        break;
                    case 52:
                        name = "Maquina de Remo Codos Altos";
                        photo_path = "https://lh3.googleusercontent.com/RY4SwIbHZJgrOY6rQlRDJP4Yix7J9KAfumLegLbh3tq9LGKqkJthpaMx7Ek8QF8DOiqiX8o43jUUFklO1RFn3hOfDFvNhIXIJmMI0RTGneo4kSNpcdT22LQ_cRwRA2KHV1OFaT6l7Fy-FTwMdV9ItNREExUq2X56su7_ZD4zZjrHGOmPsRVC2pVy46-T6ByyfPWmWZr6Zklhhj8ApJn0E2ToGCMjQW8xKiArbtWMPcELUC2lW_mQWY7iyIUj7T6HsqJpnaYUg-fm7mcUR7onZkYi_NqdbBFXdEy586iOJSr3PEzK-WLqTee1EzxHYKTCbH3rJkOVyD0OocLt5c6wd_lrhMMZH9J1B44DLcTtXjt_eXO3BdF5iZOiIASaq0M0dnO6e2GWVC13Ia5EODdQtDjaB9eTzRXSLGuqvsBtW8-BDfvUHyfIOuAFLGfNFbCnXheNvuyPeVPwZUBETng98UeA2nXjUHzEH3qulK5oGPEUcyX8Ke10J5NcaP5NM7xVwVF2WSsdtTTFiyOSS06DIXobuee83Lc2DGgqCOzq5mocY_v_K8dDYA36ut-0pYlFJObF9_7POnfCsKzBAyCkpkObk6YLOEKsz2L_-jV-zcbtIkNCdf7RMniS-K86pca3e48ZCb3AmGYl76D1DuO1__ogSVHhpx1uMDz9Q0MRJXqz_BHt3KqxSlW6=w713-h632-no";
                        video_path = "https://media.giphy.com/media/dtdDalKlMY01KECU8Z/giphy.gif";
                        description = "-Sentado pies fijos, espalda recta\n-Silla lo más baja posible\n-Tronco rígido, se mueven brazos\n-Mantener codos altos (sin forzar)";
                        muscle_zone = "deltoid";
                        hip_weight = "45/55/60/65/75";
                        res_weight ="40/50/55/60/70";
                        vol_weight = "50/60/65/70/80";
                        subclasses = "posterior";
                        break;
                    case 53:
                        name = "Maquina de hombros";
                        photo_path = "https://lh3.googleusercontent.com/6c9Ri3UMF15t0ZekyxT7tOwQWAzklHGAtPUVafauxJgTvQOOskliiZkf8XVt6Ekn0_KLaqC3_dIILYneLaxltRJN_LcULHtBCFtiSnHi8gnPCKy6uXsoXhfjX5VGVu190W7keyUzdWLOD9zIX0W2DqaPMgnHWiH_XP8L37kBJRmQ6-6sK25jTmxLPdNIx4327NNb96NKuZrgKqyyLBKn7yB2e3JW-Tu5cSpapRNYDd9pVhh0SuALzg0nSyYfadyVlrE0pCm5aCvw5ZBuhW49KwqHHoVXaWWfGHEmxcLoM8X8g00DicRzS0JJ2gkc7K1qWbebahKwXt65GG_qK9Lq-ZNpIx5o-n5pvilvjtf3XqhHAFRGRqpFGLFqkdr0MjJcIJOOHG6t-05fcHMreAt0UqzxdDenvlvaPcFb36Hu937zZxwEq81bPruFEl5EMamIVxiJmnulvNSTcRHkDTolpX9mfuukT4k8YLskvB5fC0GgAqYhSUO8GACtUkXvfaBpQkPE16l60DlQwTnzPm9a-XYvXOyE8O06NI3qGCp9GEWVVT8CyWLJLLMf3-UXiYmhuDrGHVF4Kl0txTY6GxW3fyBOHfOJnjRzLdN9ouCClYl348-36gXrR-vYArbNB1YJ_LC9LWkPjj8cgxIs7EcZ_yxivu8uV3Fe3wcm_aGh5A_l3eZ_N2Awwy1i=w713-h632-no";
                        video_path = "https://media.giphy.com/media/uADjhaAG1c0rzmuK9R/giphy.gif";
                        description = "-Sentado pies fijos, espalda recta\n-Movimiento completo\n-Ajustar sillín (posición cómoda)";
                        muscle_zone = "deltoid";
                        hip_weight = "45/55/60/65/75";
                        res_weight ="40/50/55/60/70";
                        vol_weight = "50/60/65/70/80";
                        subclasses = "medio";
                        break;
                    case 54:
                        name = "Linear Jammer con una Mano";
                        photo_path = "https://lh3.googleusercontent.com/M3kR8BatdEXkDnmL7n61-PDwjeWPHzr2fenrF0eqKT6HXrM6b7zyx-a77JVh6IR964iP6nmD_MHWxln6QcL3ShVJFB3PZYaskH6kZmPbTmdiU2lxuf02pFX20_ZYhA5wFKPuE9_r1a5w40sHn0LhSqDTyoW0Xnm682tjGY2eltGJ38aWsrjCfynTCpsyjeKAKsLhoaZdpnCDtBDylrf0aNClIGS_rNXiCRatCQJ0xiWWRSyicTvdFhbCcHbHKAq1jyXHQ9buDso3O1EsMM1LQ18ORLknhUWvGVXqILR_JEVKUqm5rflil7zbUyz-EiAtoxZQtqAzNpM8CkkHI8kdXNK97isTSrH06Ahv_IRn6le94EPe5s2vnC_uNpxHbWiSQfCmdQP_cA92BoE-_vSBJ0_n3LbM8sxbSTNU8J8MgANdMHJvZmXCrK5q-7xceMAztAg80xrtmudQ4YEuBIIfOR0NGFqDUk2IFWyEwaeQG8pNji-AhvXkqxsevjjzVQtB6pufWYw_ZubxwlLyNJ2aYZHVn0Bo7QnDZZvr5v4bBriN1u6x4i2lEikl19fKa-EchXitlQxluYKidP4-MyKCbhwg2ELtKXskN9jqrXrQGAwbZoLKN0sa4oCOUcOSo_phJHtbhEEUWWocNoz1BBNyd2SH30iMJaOtwUMDJY5cOpDnjiaAeLPoAS4B=w713-h632-no";
                        video_path = "https://media.giphy.com/media/4QF0Pjf1tWAhcZXwhf/giphy.gif";
                        description = "-Barra apoyada en disco (con soporte)\n-Espalda recta, piernas semiflex.\n-No balancearse\n-Movimiento de brazo solo\n-Peso barra no cuenta";
                        muscle_zone = "deltoid";
                        hip_weight = "10/10/20/20/30";
                        res_weight ="5/5/15/15/25";
                        vol_weight = "15/15/25/25/35";
                        subclasses = "anterior";
                        break;
                    case 55:
                        name = "Goma Elastica a la Cara";
                        photo_path = "https://lh3.googleusercontent.com/QBOAt6NSWuTxnMyw9WZ5bPpAUMOzXxbYNTIM2LACcQTz0dWGFlaUUWg64Rq5gfs2AVFrhbIWcRNrcmuM9-R_8zB3kIN2XsU5rMvbxZlcg2CKQ_qWuhYsaVN42XRVMg3ugtam7JLyK31CD7C6fCsX_KRSXmzg_2rygwnblicRHkOoYYhALCkWwruKEv92Nq5ArxHwht5Nqp8-2gD9PMsstramqL_72jorT2AU6lrwh7tmmrLPftiLKTLBhDBfEeMd0nAoAOVRtPMdlfE1wwpLQMxGYSbK50NE7om4LZph2lQO9wGeO4rUX9KUk7XyBki6ig8QDVVckUwu2Su_7TR9FGZQMKE5CMs1SkoEnqOE7Hq-ZTYMxTbpg6BDJPcy1cMmZovsDeXPrSzACcGokCTJ7l9qUcm0TCtAzFge3JPmT-l6z5rB6LD9y1bZ3kjfUcmhCq56emmAOqjORbCT-gF0Ja1tyZVqthoKI4WVQyPFPC9hVj0O8mf3h1svabjMtzkAjosa8Lcf9qXLAiD5i--CYpv9ZkBBQlvpfLX9yaBWC-V_DJVkn0DwC_S-WeloAIgrpKfUYxgVd6v-UUQ41Zzwja5Gv2VQB8ycnC1c1ATSwZ5pXSUZV7CIxB9GC5VXVibB7-5w2Iud6mJqOFF11auVbOSIcnTLZVtO9btZTE470wWzJfUWvKO4JJHf=w713-h632-no";
                        video_path = "https://media.giphy.com/media/39zXHWOTg2JnW9RmOJ/giphy.gif";
                        description = "-Un pie adelantado, piernas semiflex.\n-Espalda recta\n-Se mueven brazos solo\n-No balancearse\n-Tiro atrás ambos: codos y manos\n-Nivel alto: +separación y goma +dura";
                        muscle_zone = "deltoid";
                        hip_weight = "0/0/0/0/0";
                        res_weight ="0/0/0/0/0";
                        vol_weight = "0/0/0/0/0";
                        subclasses = "posterior";
                        break;
                    case 56:
                        name = "Remo Mancuernas Codos Altos";
                        photo_path = "https://lh3.googleusercontent.com/3Lnaws2ryuOUR-iJMnXX79FaPamJ6Rpy3aQdHt2r5JzyfT4OWS89txVDpfNuLkV7rhDrHOXqPEsMUvGIaAsMvih1Msz6JXM7iD__TCre0mz23wNmaNRU7s43eUf8p71slTFGmNpzgo3iKYET1407PljrnFWrly6aNkHMwILVpOgm-v46sgm5C1tCGsbYaHUU-mV3ASRxD-yD7dJTRbzqWDsaqb2Q13mSeg79z62QgptcvA66yzN7BnGP29-N0H0NHQwYQZj4V2TlVenESdPClcqE6PWZ1-u3-hinL6neTfomnGpYt8km4AmvJJPdIaTH7ut2n6sFPltGts9r_QBpAfiaugPNw4hFnBci8UbVGop19phZxcttY9wmlGB3FraUTNneYZX95vTK-8qSGwYJwoyqcJSVCknIHv0aZHsKd66Yl9QzpIxq3uaNyqJzNCpu2SnTqXNUldSh-aMNapFC3ns0RsbDuRtKYds2VnARwTvpPTuErS81HZT_W55fFZA8oDrcBSMPvnm4ilFvSAvsOwJXwFWZwVS-cs88DVFUOluMVzh8uZTBZTy_iUwAtA9PqtVJ9xmVHBRpc0tyfx5Dl3AAHzshXvcczWgSbw9ErxlbCR9A7pXWl5MnW7FJ6p_mrwLFMozDJ7t2WJn_eo0r8zl28ZiLMFAyVMKrZd6gmwjCCL25r3HzwcsX=w713-h632-no";
                        video_path = "https://media.giphy.com/media/ccVHpa23Z9moGNfeaD/giphy.gif";
                        description = "-Espalda recta, saco culo\n-Se mueve solo brazo\n-Subo codo vertical (90º codo-tronco)\n-Brazo estirado relajado (inicio)";
                        muscle_zone = "deltoid";
                        hip_weight = "8/10/12/14/18";
                        res_weight ="6/8/10/12/16";
                        vol_weight = "10/12/14/16/20";
                        subclasses = "posterior";
                        break;
                    case 57:
                        name = "Maquina de Gemelos";
                        photo_path = "https://lh3.googleusercontent.com/bBzhkNcZZZRGovI3-3EYOGKb2dmERmA5hDOyPzqcFxEFdgFSmmG5SaeJXIPsqP9z8sudAG1CyvRr0k7lOoN6ZxgNOEVm4Rd3huLws0eumKmRSP-HfNEyczIatyZMF49OrF9r22iIY9crDNeRhIbKpxxU0LBw5p6O73zDdl6H6lndDSxG4OdfMT_CZDPj_BMgbs4oOJA2SjhkocrFnIT4Wr3ipdAZCmwhaAMpgH8opx06YjFCEukBYlEBkG1D_Y7seER5s65iqlZpLkZBhFcO-zZVog13BJyTJ-zjzzqZvXv8pydz7So7IMszYjCLOoRlZY9w18-hNECg2VO0iFiKP97Mym9yolu-s9Gqxj4bWTRWhHgIfbeRFDk520mFDNPFQ5UWM3P3wPSgg4GUt40NvLQ8tt6HR32FBjzSaw8_fplWwTPwPT7m7s1PxKs8c8CeKQs2z14HB0wA71yOwY_9dl2AtiYqxpRZTGvkRQbyniAMh-lC5hZLbx1QPggvsxeTKD6L6bk5q5ydgGJ6EB0mgc7o4purFoE7q8UU66GFHYlLzRF859vvevBBGGK5UVFveGVPEhY8-9g-XrnWfJBYzWOLZeWa6WoszLxEhmg9P37c3Fd8DJ97V-ba1xIMM8L6ZWAK1xdGobR0P8DuJePKiOv8NSSTp--CC4641N9VgmMYk-f0NnUbin_S=w713-h632-no";
                        video_path = "https://media.giphy.com/media/3oqo0A0C4UPKknPQkc/giphy.gif";
                        description = "-Espalda recta\n-Probar sin peso primero\n-Amplitud de movimiento";
                        muscle_zone = "calf";
                        hip_weight = "25/35/40/45/55";
                        res_weight ="20/30/35/40/50";
                        vol_weight = "30/40/45/50/60";
                        subclasses = "soleo";
                        break;
                    case 58:
                        name = "Saltar Cuerda Pies Juntos";
                        photo_path = "https://lh3.googleusercontent.com/I7DPJwju-q-FjsFQxjBhnSrl0oc-TnEbhYbYFPOdEGl0W_-tcJU_Bc4PwRvhW9LMThd0-t1dVCxsvit08KO9S3bw1zQs0RJpo-Q5yRtoblPu7tNvQFssthqgd9pG2_xQgDRwB8wwkkmOV-NIDqxCJ1hRb5nqMHFd3fw1WKgxX7S3o4uFY_OCrWmmsaIvFcT9hxr9aK7d5LnSjeF-7h0XPFTBkldIFrcuOMLi4841DhIbnyZbu72KhSLJKRryIvAYdj0S6LCCpX0P_xQnSJ9NA6P0xNxfF9LLb3oj_OYTvpOvjmJQAkZVL0s7VMM2E-Lv2DoNL67dIeL1ei6uPBmOpwyQKjr0rUJTWEs1V3tb6cNMX8B0CQWBhKphxr3LggaA3AEF5G1xAForappuhlcNgmB4pygCaL5SC20sRSP2iHF2kRzShLz_2_4fBzd9VHkn9PnS0dV7r96AY-tYm6_YWmgbtxq72ADzPNdz8SC2sNg8xuz4W4JDLrhip8i--izmq7byCmMlRYtb0CCN9t4Ab_wOgx-Wk7yqsafanUKCCJcL4RHIKvBSHoVJZsF7y4RrZeZIs0FZbVBZdiXG18uV9U1FxmlVkjdzp0GUYXo0c3sRyrjOcUyn9uRr7-gMC7o73_jieNb5d_qllzpXkjSP9GQwYN5mZN-t0yM96N0xd5OCmuFx_puzcw-U=w713-h632-no";
                        video_path = "https://media.giphy.com/media/g0sEGJ1mlHWVVkXZtf/giphy.gif";
                        description = "-Saltar con pies juntos\n-Flexionar lo mínimo rodillas\n-Movimiento controlado, equilibrio";
                        muscle_zone = "calf";
                        hip_weight = "0/0/0/0/0";
                        res_weight ="0/0/0/0/0";
                        vol_weight = "0/0/0/0/0";
                        reps_obj = "1 min/1m 30s/45 seg";
                        subclasses = "gemelo";
                        break;
                    case 59:
                        name = "Maquina de Gluteo Sentado";
                        photo_path = "https://lh3.googleusercontent.com/eYYwE44PbfNEtWznEIhyN2BBGQQr07dje1zivG2M03yxSLKNeZnCQYp88yUld2FCg1aHS9D8BjW3EqjY0vcTD3Iaz4maBIrh1HFSWkH69O_6XDMbklLWYjt8YIoR102WKEZctS-eMFGSxipwMQNBTqLK11Oyk_NpSr0U9F07v82Yf4yrWxRWh9ZerkfKVEqAmPPNuCuwzculE0pIA1T8drjo7ISOkX02_x83Al3qAv72rt14Zv_WmWLjskJV1WYzCfK-JXKglfQHjuF5tzdb4EZYz-4nw7aXOChmPY4Pt3j0myRB1juup26-mAeI8fekRDW8JJU4YFKfLcfilqgAoXY0aJpbHWw7nQA1yVRwuPfqPZ3ybQdohqN7dw6J6xY0uS1tdScGXLucRYfk6Tj-6RtQjkEkLxBd_hrMkdTgkgWsoG10C07DsD5MQOCMGw1rq3q9BgPQ-DUkRU_qMJJHwF1nVqJWitZxCmPDDC2LGTGFmsrnhCk9AckQemP-SE0VSY0UYBwq0DHD3Lx41zM8sOE4Rqpzmdw1m824JEsOPuSUUibSB33z4UTqkv8Eixmrr0NuVW0kS5Om4EXqh_LTyy0uRZiix0SsyKvyIpmiNmbGt_V6FwWJ1C9HS_caihTg6Lo2X2-93u4aOjOEGs6MsVbu7OBQhecQPw9ihw_-K1Ih_XaodhAsf40=w1062-h944-no";
                        video_path = "https://media.giphy.com/media/jRfbFtoWENAz6q5Pb7/giphy.gif";
                        description = "-Sentado cómodo\n-Amplitud de movimiento";
                        muscle_zone = "glute";
                        hip_weight = "40/50/60/80/90";
                        res_weight ="35/45/50/70/80";
                        vol_weight = "50/60/70/90/100";
                        subclasses = "menor";
                        break;
                    case 60:
                        name = "Rotacion con Banda Elastica";
                        photo_path = "https://lh3.googleusercontent.com/aym_LIz0ITRwJkqHYklsmTIwRp6Pi_ALjQnmY9P8oG4nr4lYZP0NVBOt9UwoQ1y26bu0u6sSl3YhZyOcMc0JFN9eE_2DeRA1o96rheM9aOhohO1AutHBwnLu6HYkkQyJl92vi9_TyaXLDe5xzVicy_Qmgaggw2FVyXpHFy8SQqu8eFS_t3RYCddTjf1sdUnT4r0mABWd_hRm67mNPjIxG858baR80LnUKQdVNrYfXJgppseLvh5VVC6uO_YvDjGyg8WIFSUlZ4BgRCWugGpsO2rgz-z2t8uFMoWXJdG7DUz1PJW4QFua-C7FUro50jx9GYiiqPR7CtGHfCbYlIlQ8quLeZzdW7DypTNP3iNblLKIZuFYJUCB7ob7h8E9OkwitAG29I-fx_jLTELiSzQzWhUH0TtMvm1cFwfjNvmxUFdBV0sBTvvDjzhROa-60HOHOjQcIqH0aAVWUKY0A7u8YeSsxuaX9Bc08mm-odeJ0jH7k1Ktg8WkjxPcNItvBUCRVhtwUkQjpp_DS9boj6Q4eJMCTtBvWEmZnX5sm1llKbFWg26b9pmr_MzSP23S5Lp5jPkiANfG2CPYDzsWg0HQu-Nq4zBFrVd1kDyMTW-ZrNCs05O_1dRm1KQbv3doqPHvSjix7kZx2BfLEx49mpbZD6NkSdfWa3-hNl6EqzJ-i1d_bpSC3pXHc4Ag=w713-h632-no";
                        video_path = "https://media.giphy.com/media/huVbtq44V78loMJ6Am/giphy.gif";
                        description = "-Banda elástica en rodillas\n-Piernas en V\n-Movimiento de la pierna externa solo\n-Rotación, amplitud de movimiento\n-Peso/Nivel: color de banda (elegir)";
                        muscle_zone = "glute";
                        hip_weight = "0/0/0/0/0";
                        res_weight ="0/0/0/0/0";
                        vol_weight = "0/0/0/0/0";
                        subclasses = "menor";
                        break;
                    case 61:
                        name = "Sentadilla";
                        photo_path = "https://lh3.googleusercontent.com/zYwnokeZwpfzDTV1NHJuIjIHXmyZEdr6dePmcY_rGp8l9sqZn2zENOUlbie4NNcDInAZdDvnOgjUfahsWkXT1BA8ojwFmyMimGk2kfTGnsdUbJf9fioepD7bznzAz0u2R4mj5YpLUn4o6TwApY-N8KwmjyfNo1ERvko9QFcLeTRkITMJgpGWNd6hDzH62jza-17FdBF4yRYMhRio7Lj-sA6Mm8PxFiMVJQTnq8KfMif0mYmmlChrpwfF3wOEiajy5Q257mmiy-Xm6X4wwwD895n5iTz-SAP0LB3klIKD0oqwEt1qWwB7dzgxJojh_HxgLbR_oOtamT9l_X8tkAZSsbZSNFtsLRQq2CBxJaxUXtxUQ2fuzsFF1HQlKJG9I7vTwvvmlSDlBHKRoHHFpFHAbMOhbgXplKcAmGYIB76Sr92ESsc5Le5J0-S-RkGGzv2cpPCF7LTvaxsi7xDvfPoAKCjapsKmGIAc3-40HeNw2KNBAsrD3FGtnj1ks-EO96tctkb0MWok9Wwrrzl_UzL8vxNCCZjj7KINhFIHSFAOHr4qZ-ciPjnx4JZiW727u5ymWpSIJUxNL1096tU_4sCZbLfM-P1kHlXW0cLASu7hex7rzRjKarQ1iGkweCdSMJBCD44FQgWxtciymJVcQi64QOt2de2ysh1EfXR6R-pT-yEZEEDuPQWgLjs1=w713-h632-no";
                        video_path = "https://media.giphy.com/media/oHxwFONw1bloV3POXf/giphy.gif";
                        description = "-Rodillas no sobrepasan punta de pies\n-Sacar pecho, espalda recta\n-Culo hacia fuera, equilibrio\n-Bajada poco más de 90º de rodilla";
                        muscle_zone = "glute";
                        hip_weight = "12/20/24/28/36";
                        res_weight ="8/16/20/24/32";
                        vol_weight = "16/24/28/32/40";
                        subclasses = "mayor";
                        break;
                    case 62:
                        name = "Jumping Jacks";
                        photo_path = "https://lh3.googleusercontent.com/OJI8E6_hbp8CP1iApL_YwCBbT5gD-7X2wz1eorsIjnwClAd8yHDv1ANb6x8-0dJzFVTvU2ydCPdPvoJSbP3I_nTnngMsgcOcREl4S_nwivR-Me_2pAkjNrndSV6b7bKbAKI_EmU9pNtZwQwcNnnzHhBKT0nMHtUmn7Dqiyt5FA1hnRVONudTNtWGv1pqTIV1yrtsi13UAJsuSqbvzaKHHgZUK469xdH688LU6o6CBTdW1tHgh63KSjFlIvc7erYaSJKG2_EE2UW7IWFdkvHT3CDrfkhVHEqthCUglkb0sdcHFs57f_2DAfBFFl-S__cKEYGqno_ImdPik0meScw0h5DDjChf6mInDbS205gx-yhYBN8ZiFbvbW8QtfyRtJNyBouFE-Bj1iSJOtD7EEzR8psvtPN1rJ0indnCv3NaAIMiX8_HoYGtV00543goH39xE5Nn9BYgRllXcILRXFxrz-NPFBsrsjHEA28TP5Lxl5egPc_iI5WaHVBdDN8xxBS6ctAgyf8xYmOdYyz17pNl2tz9v_W0fOdspCdBF2BDVh3E1aXBea0shGjyHK-YfTHDcAzl2WtFP1pvAl487vt1U3SGVZ8NI3LO_lgkDtOCKhUfWYCZaGly6R8i8KOcmxRTM5FxGz9gviZT_9gpFgSm_8uz1CLdQ9M-ZDWSBgtVbpwEsVER8szjl3o=w1062-h944-no";
                        video_path = "https://media.giphy.com/media/WRFdqgtQmtbloEkSdS/giphy.gif";
                        description = "-Dinámico, explosivo\n-Amplitud de movimiento\n-Marcar posiciones, sin desplazarse\n-Simultáneo abrir piernas subir brazos\n-Peso/Nivel: color de banda (elegir)";
                        muscle_zone = "glute";
                        hip_weight = "0/0/0/0/0";
                        res_weight ="0/0/0/0/0";
                        vol_weight = "0/0/0/0/0";
                        subclasses = "medio";
                        break;
                    case 63:
                        name = "Elevacion Lateral de Pierna";
                        photo_path = "https://lh3.googleusercontent.com/AZ6BXfXF6sUoSvGfEvLt0uf5VnVoJsma0TX4dQ0A0yMH3TbA5WSiDp4nVFPGYAdkWcvcY2ojECfDb1oz43XCd1JhhxS50iBHRS48ospDmnD7AK0wHLpCUMP6Sl19CRbrePY0AVtJbZaBpbBLS7J4lodyYe9jcHdBGT2on5u44SSoXhpdJI22w21rqN8tO5vsb3Ja65Q0jK0LKklX_RjYX9vO9Ya5Qe6J7IokFKm4dKHnUtkhub60Gen2uELIzHFNAb3OHcSkZtoBQmXmvRtfL8SDROgZwFM7SusXjwuqGNzaZlP67Zy8TgzPvO_svmJVT221PnvTwitb-tchGY2lgDA0WUrTFbz45buPp48PNPUBryCMRTS7bCWdudoDTBC7Or7gxxkFhYbOznwoE5DP8DJIbrxJYlp9ciVuPx4VIAB6LanvCQeQlzhh7JLuijGzY_FJDcEcjj0v_TRjeFVhoHpxkgUp5udxTZdCMZd1UAkAJ_j8ftoYfA42D8ceLPKHEEFl7MdcPPLRo93_-odOpaGay-3JbgkKnRiJFR2lgRHArBQ-yur8fpyuohCaq-iQYZdNagx0X8kA9b71uvpyyl-apjLaVmD4JNeHz0UwIHTb9Mn7Jp-lj8uiPICjTA0ix4isluOQv6nq5fF1atgI93X_iH_qFn9MxZGsZzFVaZIpuM64TuVBUiop=w713-h632-no";
                        video_path = "https://media.giphy.com/media/8c0LsbyUfBa26i3eYG/giphy.gif";
                        description = "-Equilibrio, evitar balanceo\n-Amplitud de movimiento\n-Una pierna fija la otra estira\n-Movimiento controlado\n-Peso/Nivel: color de banda (elegir)";
                        muscle_zone = "glute";
                        hip_weight = "0/0/0/0/0";
                        res_weight ="0/0/0/0/0";
                        vol_weight = "0/0/0/0/0";
                        subclasses = "medio";
                        break;
                    case 64:
                        name = "Cable Kickback";
                        photo_path = "https://lh3.googleusercontent.com/UsxiAuqfTdLYtIYO2B4KuF18YO3tBEx4yg8eq0s5dziGbN7KWs96vNb4LXgCBbbCKnYoLU_TD8ihe8qe-P-z5beWF30XWyHzwWp0hc2nZAjwN8dEG4Zo-9kYaF1vtaQUUqXNvoYJTVpMyMlyl_VVLGb3GVJ21vC8n9MZtZ0zujCPA3VP4sZsQM29Ms9TdRU2a_nUbcm8mZjeJlcGX7Dbt_vm6m8c-hWhTWYcaJhBeU9ONi6u0Z0zWPqCuzTyb8Hsd4ez3mtrjr77FDAvyMenQnuILBwTI7wJaQ6cgOQBnkrTOvHiUsLBQPZRVv1sf2gjr7KraaczvAiSCzGL4QabdHEpU3msM2TYpwOCINCVGQ1EEcdpBuPVboEk-zE1Zj_QAi_Ayu_Z7eCdfVXr2kQk45jZeV72eVOqvMmSqqkGVjTZL60CsH2wTyvQ2fwmxOXOEuHVa3k2iRGx2G6uIUqLrq2uh6ds5mYTMu7UyLQrsGmcdkN3HwJeHrlUBfC6z8irxVkMfTeG1D5Ewvc7xuhsHYkbh8tNcFFe1E4wyLyj_JkkHMzdf-fHffak7PO2r31gtHNnTqSEnJgjmtKS0uydpkC2GELVVYautIlojlpIt0kPrw9JGM1aWOzcmBbc-dz4x9mY8F7rD4gRng1lXoo_Nj8zFk7Wx3JNj4oPp6V205qYOpWh6KDWnlNx=w713-h632-no";
                        video_path = "https://media.giphy.com/media/AFn9eQxtLAn3TyYs2D/giphy.gif";
                        description = "-De cara a la polea\n-Pierna estirada hacia atrás\n-La otra pierna y el cuerpo firmes\n-Subir la pierna el máximo (sin dolor)";
                        muscle_zone = "glute";
                        hip_weight = "17.5/22.5/25/27.5/32.5";
                        res_weight ="15/20/22.5/25/30";
                        vol_weight = "20/25/27.5/30/35";
                        subclasses = "mayor";
                        break;
                    case 65:
                        name = "Pull Through";
                        photo_path = "https://lh3.googleusercontent.com/2tD2VETiA2DItuNi0vhgZfImDlWBdCfjLYMh7rQo5ADw3KB1zfEepd_TDKvgll84OHRXe1oryK1NlgTe60FopCHNR--C2gnowJDRUOqIYOB6wonzslI43JXJ19ymUfkNNDRKxxKqxunkokbW9fZAMTW2tcgLVY3XWAckYbou5dyDXSn9ghczksrUKkIBzSBlu7EaUvQeb5L5SujVKrtNAdrAuvtfJQldv37recEgReV6eu_7waKZOXxuyViwP31JJTV1bZHermyNqV8zX2agWdMIbpvpBfIRYCMaWrnDXL7yKmkgdl_EIfhxAFal6UX3GRfrAjPcxjeugLAz4iBGh1VK9TqQf08Bggh-jJPEWo9Tm92b_Y75hZ2O7GYPHoPM5M785Ic_aTUn6kPwHIdEwUrUD3H7iEH2FZlsq58NR8BfnP5ZAkNALUa5CChxjCNRQT7WUeNUeiM0D3q-IjfMollStztkPa187cJAoGnebbGSv2g1hryuFD8noeM73EZqRHSRM-OdOOrGKPN2RoVGHuTKxLmLG8DamAGpPgT7_2ukWcbVe2CP_ANR-ofEjlDwhDTgqRDye40wKfWDcJgaIfVoFuE6o_a4sdwIv14Pp0lhhl1c-qWf7CR02ZwoTJWcJbJfyc7g1ZBS3zbp0vCfkgE90RcZlqtyhFi2V4PzAG09p50bauVsKwl3=w713-h632-no";
                        video_path = "https://media.giphy.com/media/1zR9J5owQrRE7ILcpj/giphy.gif";
                        description = "-Piernas flex. espalda recta (inicio)\n-Subida a poner el cuerpo recto\n-Bajada controlada\n-Separación justa con la polea (inicio)";
                        muscle_zone = "glute";
                        hip_weight = "30/32.5/35/40/45";
                        res_weight ="27.5/30/32.5/35/40";
                        vol_weight = "32.5/35/40/45/50";
                        subclasses = "mayor";
                        break;
                    case 66:
                        name = "Maquina de Gluteos de Pie";
                        photo_path = "https://lh3.googleusercontent.com/nxCQEdYUpMlJS6tKp0NhtI7Zvz8EYQ685s8xk3Iw2mxju7dHSQgRUBZg1iPDBMm8fSnbHghkecHQ0PkDyKDkTgki8gu_5wq7NIeL4y_YOOx6-QN7sT4NZHrQLCSzQjk_ueur3B9QF7V0xwb8aC6PFxJyVMCYoD0tVQDSLGa-_a6XnqSDEoWyHEm1KtSKVoeHZR0mKMvR-Rwi3I9wTr4wlYmqnVKgguT-ya1WpJ7PFqvaDsJdcnEzMIbFRxE2t5zrbJzTz9q8agqv5DhIbpr12F3XnEffYSBmpy1TW6fvwjCkr7lrJygfDMO7nwdLpLNMqDzoQ1KrwXDFvZsbY41Es_-Pit_a2GweghFGyq-dquzcQZZrzZ1X8N5C-vgCPEGxcfS-L5DGx7alsV0Cj2-l-eWPErjiV9_WyDEojXn8A7qmW8C0mxZB7pnIGs6dBSMT7neScke5Mn3krPmP05zwYD4hrlB7dkOXLLP57bFp8JBFrWZgf4BF6iuCNx4gIIn3dtCm1mISq8tbx2ALOe-5fgaaStUMM_ruWtyMg7E681jiP1hRH-56lNJ21E4V1hRsoS3HbbRq3Z7R7i_NqVImtVad-aY9sloSMsvp8B1Nrqtw78-JXg8So-KA_PjMX7vcRml6uo-0LxnB-I1Rb-0r5NNmjyBkbvf8qamoBN_k_B464zaTzMcSyjnK=w713-h632-no";
                        video_path = "https://media.giphy.com/media/5vYnunLwmnPJAMFGwD/giphy.gif";
                        description = "-Amplitud de movimiento\n-Pierna estirada firme\n-La vuelta controlada\n-Sin balancearse\n-Se mueve la pierna solo";
                        muscle_zone = "glute";
                        hip_weight = "40/60/80/90/100";
                        res_weight ="30/40/60/80/90";
                        vol_weight = "50/70/90/100/120";
                        subclasses = "medio";
                        break;
                    case 67:
                        name = "Glute Bridge";
                        photo_path = "https://lh3.googleusercontent.com/_mmQkQgVeixqrX-M6RQ_DSZ4lPSns3-LcWlPC3RBjRoXZLbqo53b2jUpBtLx3qLvmEZdAjJZyLqtyaDOSMLXbuDQDzUVZb8bKYiP6ZeAb3M1FPTkedaDAEDBGAk_t7dYqd8dthI2mOYDpXgVC52vAOqZIQgW4xkv4mKWkM2B2bKPYShCegWuzEq5IrWKWZ1DFpV_suPgcdvdT73CSHqvhF5_AJJSOXKEhJulFCeLH7tXZuVIm090dQlyM2NZ5ZHVO04tf8lS1FMB31eDdZPHoGiZa6aKBvgCY7ra_Kgj8Q76BlRZsA3cvrorrXcX43H_RnhWv_VhzOneVE0Fs1nj1WzLFtjoRhS_5UWo3rGfgxgINJ6YiK6QxAXDYYxtbKb7zKU8MFvSnO_h8rXcsmGdU82yp8AD4D1K7wI5bstzJdb_CTSS9L2GgDmbCXsFvcvlng_3lufhegIu6PJgFiUBwGctzX84HmDM8if4Bxbwd2-UoL-k3q7Lt4UQWwSHcQmuEoUT89BZ8MvTBqHBPArW54qZWG0Rgg4ORt47iqLg2FVIULo7FvrmYRoLo6BBkiFFFP9dbo56mexpapoKBI2DbS2kuO9a31O3mwQ8gRjCLHv_dJB25RYKrc7I1uEodYvSmYs5IZeXMfCuVXZhiCN5u1gbrE7iGRc644_81lSFC2UJ8U84DhyfZLuT=w713-h632-no";
                        video_path = "https://media.giphy.com/media/7STqShwodzd1jGJD2w/giphy.gif";
                        description = "-Sentado suelo, espalda banco (coloco posición inicial)\n-Relajo en la bajada musculatura\n-Tenso musculatura en la subida\n-Marco las posiciones";
                        muscle_zone = "glute";
                        hip_weight = "10/20/30/40/50";
                        res_weight ="0/10/20/30/40";
                        vol_weight = "20/30/40/50/60";
                        subclasses = "mayor";
                        break;
                    case 68:
                        name = "Lunge con Pie Elevado";
                        photo_path = "https://lh3.googleusercontent.com/tCPjOq_6yOtez2rUZcJWz6qORzrkyqJfOyCR9MBnKySTzF1wj2Nf8a0V04pQUQGxB2LOmp6z5BTF141D7IFt2QmLMArU4iZPQmg24EX_oWUMfWTAWPxsMmsBRAK8AWmqo-YLuK7tyJFWEF8pjc2xPr2pCtugqYf0dBptUifm3EcSf4QKK2ezGIXTDIyDi1-zrxq3y_vmoZ9V4IN6MuQjNdWUZmXdlZZJTbH1HZ2XQ7DfId02g7JIz15Ny271tKU9xmvctVLwd6WYYbDu53jEc-Qsvh-LoiuK-Scpu3to0NpZ9eXBfOyKh9Oj8omfgGT4UXBWndO0IPlL6DAYHSVMrdnbJxaIv9udsQ9vOMaTint7IzRdfHXPWooPIALX8qI1tiGzIY3opRpSLdTVO77LgUqMgq_0Vqfs0vJQix0eVS7WmVyveMP9QCdNNfGD4k4N39e8impQYk7j9dzItgoOz9MOMI5gYxsbjRF4wmkaIXmyHuzQq4s9os0_8rZfTKdqyZhwagtwozawI1pAxWDx5OzoVuZcQLLTIsZqJIiqwE5uOmf5V4jkh1vTSNj9tprhy1d7AqSwJ1QIXajo0ESIEHjjpNO4h8-_kAg7dcwB7PPgZ9lh2ZlHYTrNlixq8doJRuAMFAIMr11RcwxHgxPngD5JpRhq8bnKqRg7_j0fAVLx3QHr5dxwHyZk=w713-h632-no";
                        video_path = "https://media.giphy.com/media/QK453tJLZ9DKgJPd2Y/giphy.gif";
                        description = "-Rodilla no adelanta punta de pies\n-Rodilla de atrás casi a tocar el suelo\n-Cuerpo perpendicular al suelo\n-Espalda recta no balanceo";
                        muscle_zone = "glute";
                        hip_weight = "12/16/20/24/32";
                        res_weight ="8/12/16/20/28";
                        vol_weight = "16/20/24/28/36";
                        subclasses = "mayor";
                        break;
                    case 69:
                        name = "Floor Glute Bridge";
                        photo_path = "https://lh3.googleusercontent.com/TuiNKsgpG9dl-xwFC9IkMPDGsKkCO-6UXnfquLNBbNsxdUIAeu6Z5RlZZpqOLhi6GhQxcyjHaQyT0ln-jglztpGrCjG7hzYUlT4qT1dmM81sGfRxW9VPbkimif5JdJSvHD4qobXVDEw-jXcTFNpqfm7dgygUFPyDvOiKbMKY6xJALgKxlQFgEyV-7Ue_XsNPIf4n1Lfwe4SSvzpUDeii_IOQgi7s91Gycj7UkTnsJzHQKP2HwO5n54HVPjmEPLkHoEKBDIsPPwhFAlK3KUhFVObhFqTtbHut9ZAWf43hFb1uz9moxFn6woh4GCvOkGNgEglvOU5DnyeyJJOlgjz5DaEKWaiJJ3OgSRMsnfgIhFsqJtw0l5obLKRh75iUkFsSOuXnKT9BCbue8A8onQzTSqIrRAJYbiu5vjSys7RH58zQO4Vy1rwvX6Gq8MNwDcwHBDid2pOHznW6Hw-9EFZ1dWSRhCWj7xd5roZLHBuvWSS1WtrJFXIjv9VXn4BR0NPQsW5UTXX1wMutGxbLUX8SnTEB_kv30YxgF9FHtJKjA8PIFIMJ6QH_Am-OIwptMM6Usc0TN-eNIh4ufTHu_0vGcNzfcikUvPRYhcxYg9sEdIPNFo6Cp7xJf6ejWi5RLIMp-rYchJk5tsQDtMeg0pYvXNKUmlCQiTdUticzN-W5v-2JAQMTkS2lG8tT=w713-h632-no";
                        video_path = "https://media.giphy.com/media/5ndmzORKczTEPqlJ2V/giphy.gif";
                        description = "-Tenso músculos en la subida\n-Relajo músculos en la bajada\n-Marco las posiciones\n-Movimientos controlados";
                        muscle_zone = "glute";
                        hip_weight = "5/10/20/30/40";
                        res_weight ="0/5/10/20/30";
                        vol_weight = "10/20/30/40/50";
                        subclasses = "mayor";
                        break;
                    case 70:
                        name = "Lunge Lateral";
                        photo_path = "https://lh3.googleusercontent.com/dG0Jn_viCiEpk3Z0G3BdxbIYBPmDhof12Q2Va_lPW4JF45y9FwN_JrDzxph7SXmnl82_qflILb5VeogMdUw2BETC2Nm4ObJSxjthj37gLy3QRCjBJ_LpeZrxVM7stgjHC5wLO5X0fvaOVqKJT6eFA3XSnkHFopsqcVNlS_r1OseNDGev_McWLa0HpWrWyCAGIXEMUwMcr2d7gDrBjyUUiL9--te1tCdxeg5Yyf5vRi51rIwzyb2LWHiS6HdIj5AA5i7pXsvr6hqejhdGPVQgaPPiEYfAUANcP3f0R3__MLhZg2ADX7gxWTSB2bwnv5rsRIiEC_fZFHTluFppUSP67lgBCaA0d2sv0i6y3EOJESQhWzmSvFac7GpB8QUg66Nlq4fwhQbGrjE3esU3elEWWOC0Deaf76_XUY3yLuxaAsr2KVsrf8xjNyGK0Tjf4Iw7haccTAyQ-a5TwPJoI_KRPCbicQ0E_m0DUeWQuy6yqTk6zm-0ubFhyw05N6zI_datvR6mcsbgtoEXqthRjJht7JU8s3GRaRJmKY2ZbTTVpDJ2u9QTBHxsKOHqmeLUWa4R_v08n4Pc08UKIq31M3SP-uJ3EwqOwT6sGY5Hb534KF_ldCdNqkfAuBOwlaIYJm--qKj4nazU9X0U5YofwF9Vr5L03GLRTOUtrZORQMs2CybzyVoPboKd890=w1062-h944-no";
                        video_path = "https://media.giphy.com/media/RN31a6hZh0WD5GpQzf/giphy.gif";
                        description = "-Rodilla altura del pie (no sobrepasa)\n-Bajo cadera\n-Espalda recta, saco culo\n-Movimiento controlado, equilibrio\n-Pierna interior estirada";
                        muscle_zone = "glute";
                        hip_weight = "8/10/12/14/18";
                        res_weight ="6/8/10/12/16";
                        vol_weight = "10/12/14/16/20";
                        subclasses = "medio";
                        break;
                    case 71:
                        name = "Lunge Diagonal";
                        photo_path = "https://lh3.googleusercontent.com/7YpFnWIAcqybHsFzyJ8FB2opFaPdXc9kSCw4M8mOw6ttKbsgSj0vYremRd-MokKSy8X1tLdVHizj_lX7fS915myoPWjx1kpMZLGYbFq8TMzwNTGdvtn_JVRHEknw_CJIRZoK_n3au1tlh4a73HUXpLMQH5_dGJb_DRdk-NMrT5oHgapQe2KNMHaLxGbR3HPgAoQkmQNTFGOrkR32Ty3I5-lilD664qqbv8u2p_kv2q7oClstQi03fILhp1xj32SFmAjrBeRwxGnUG7clZq8LEcxyE83KfbuI8rFhP7SmMsPvGYayQnF5tyxjeOgUcpcFzLsm9ikZORYK7zMuCaO-MkKkVriirB3eIbZY31uoDz3b1jUHG_B03stRa8rLaIGMcAVy3Ldl1WLG3c7hCRZlKxCE6IXrOEVTxxaaQ2sFupmeq0CNrTS-dlWbwsyhAu50PLfquT_c7B61zslOcWsSit_NOuLkjwZNdABr5DwZAQDSK9IerBqkiPsdG9KDqSiDxDBnlIDQPoYPfzxMejMzH60l7ePHmqXEeum3MPOFrtuhAHv3Vg6JRnEldtxN8KLrK0tinyQCj2F6qfhGXOQZttzBtdr3qdaHH50DAZHmXivjoyLN4fBRtX478rVITbntsGaeETYTCkqEU0ZrlMiN6fl-f1eBPqg8W0YmeJ09Y-encjXxrfYZj9o=w1062-h944-no";
                        video_path = "https://media.giphy.com/media/S590pg58gwRuNNyj2C/giphy.gif";
                        description = "-Paso diagonal cruzado\n-Rodilla trasera casi toca suelo\n-Rodilla delantera no adelanta pie\n-Giro hacia exterior el tronco\n-Movimiento controlado";
                        muscle_zone = "glute";
                        hip_weight = "8/10/12/14/18";
                        res_weight ="6/8/10/12/16";
                        vol_weight = "10/12/14/16/20";
                        subclasses = "menor";
                        break;
                    case 72:
                        name = "Dominada";
                        photo_path = "https://lh3.googleusercontent.com/J0Pqg-Q8nwTDsH9F8G_hOgbJDwwyTATEL5eJjaCq-CZ61vSoUTkayXnYmYgrswq01fycKpHlae_WKckKMtv2R0DBSn8AU-tr89FE33hPjVI0avfk2ZvNUsClYlzEvque2i6VB1ZL4mhe1PkEKUAV_fwHoVslXWQ0FN5z0dSgnJX5S5BboEfp-0yfwK_gufVGZX0rrAaaVTAYBKDLdCl4RANVEMTANYUS2Qu-4BgUR2GBm7yBKpMB17vQgOfeWNDF4rMyC0uKLBinP2IbmWobqj8ttpPSM0-SPLcxcJ3bEBUT9ado4AZKf_O1W_uW2J0m2vGjkdfT-pD_QIsq8EQEjaLH_XfvFCiH5mVKZIS5aM9ipaV9p5t_dXjELnIAFk7MGVjbrac5lVDMZwkNfPjrW1H_x2JllhR_9FbF5CiRfX9-Q02E9qOAQ5__ik_aBrbrk53VmekDtpt6Ro0toJA5214WsU7JfKuCs_r_LHnzNo7mdTH4-Gr3tmyXYQWi-F-fwPY4xXorGRajVYZbrXMi7AWNM7U2eAl9cqWWX7f6CvDviIbpjZkFODyKM_Jiymk0UIYHCv4ssnT0Qo7HK6VjyZTBKEaOE6DOk2HJgKeN5Hs36hYn1mxx5NlYllc0nwx764fizhcxnIbBrrpvO914F2JdJalRsqxvg05bChfkTaEjMX2EcPsvPC0=w1062-h944-no";
                        video_path = "https://media.giphy.com/media/Yochk6afxtXIRqeJzg/giphy.gif";
                        description = "-Movimiento completo, no balancearse\n-Agarre prono\n-Hombro 90º codo 90º (aprox.)\n-Subida pecho hasta casi tocar barra\n-Peso con lastre";
                        muscle_zone = "mid-back";
                        level = "hard";
                        hip_weight = "-/-/0/2/4";
                        res_weight ="-/-/-/-/-";
                        vol_weight = "-/-/2/4/6";
                        break;
                    case 73:
                        name = "Polea Trasnuca";
                        photo_path = "https://lh3.googleusercontent.com/6Ktr37JQ1QUw1MPxDDIhiH_L2uz_8E7ziYzUjoKhzgeeNv7PvtmevoXp-m1ANd0Phcv6cYj_Nk4MMoUdlpZZMObX-rfy39auFZaNiUjgCFVIUjcaP-w3PWT-IytzPqgShkZIj71YyAN30CBa596EBm6nZB_A_IXOM1Fz_gMf4ZS6h4Q1BOwcUsMjwyslLRVJ0o_s_Oda1_oOWYnaepHQrQm1_864W_Lw3tSxsY_L5D0xUm8CPazROMB5X2HnZv8GPB6vp3YwFE58ZIPt2aAaBfZuwu6bWHEjEFb460kFDDw23CWm30ddsL7mFWbeD7knCyYagK0MLACUiEnUY4N6994fJDy-TOzkHSa79C5ZJUlU4eb3kduWzrczFD31HDm-yZ_0Ou1HKsophdNd7PYKbExkPcceGkhoJgVAbZLhuCiCj4TdNomHBX_TmrNo6eI9KIBE6PNe5yIunpYWc0hfsXAkUmY06mim9mqu0mwvRhW95rryjaLRHGxDEQf0PW-6caxSSBez5MOORnetdLZBRC0_W8euBFObAj8sRz-rMRQyRJCWQhVrUsiEz86A3GdoFS1qn5jvY-srGkhEZKFYefPRmA2GZ_g-9HEwmY4zzp6j-p1B6xSavcdR-rZCO8hifVQQX2m4AGkzZV7zRbH9rVnjjakhYhhC4m41rtv1tfIy6dijndfEKXn3=w713-h632-no";
                        video_path = "https://media.giphy.com/media/14dYwJxgFhF3RyN4Yr/giphy.gif";
                        description = "-Espalda recta, pies fijos\n-Cabeza inclinada hacia delante\n-Bajada lo más cerca de la nuca posible\n-Si dolor de hombros cambio ejercicio";
                        muscle_zone = "mid-back";
                        hip_weight = "30/35/40/45/50";
                        res_weight ="25/30/35/40/45";
                        vol_weight = "35/40/45/50/55";
                        break;
                    case 74:
                        name = "Remo en Polea";
                        photo_path = "https://lh3.googleusercontent.com/zHBfcDC0GazTt3fNb2Ll4oSJopg1usJsnipYNLV-GwjCeh1AeYj9ZvUbdFFaoUAsTE9i8g2R8lTTzeOpCwlniY9U2J31WUrVmOACxHscJkmDwo7ZCWGbptsLReyBhDbJKhyMBcjvu8Xw6roZMzgS6NaodauG96jiKC81-zal3Rg9I3soDNavt2EW0A71n-5NOPi9LXWiyWjodFVqfj3S4G8dbZ6HxD9RbnyyHx5Drw7-XBRS6wwF25jlytnFgN22cK75pEbbrczCD5Ss8u7q51gPvxVEoDIek1VK6pKsq4kFDEhtroFOQA-BoP_yy2fcQy3RH9wUYsza3qyTrV6hfbsOkWf0Qd64dlIsVbRPkJWSLIFkChOsjtA6BqI8X184hbdFvD0qAI1I8tO0PoBRMhTbtsUJkzVbj1djc7cjQ0Y1Z1qcPFG5NGFAZ4bv1NkIdLIdEy3XqSjpAqnOyN9no2dGIFEt1QhNRCvjue9-cS-qBQpoq3896ECTHqtpKbgrcJhdKj2k-2INwS8ouGh76FsXRoa9hmQh2dzACogW3L9lvcrgM8YLDMWa64kWfLIX-Uf5bErIK3pEixhEy7x0dFRI3pPqO8Nx8sRfouLGoZsY7kjatImU-4lD6qFPy2MitX9DQe0w6Ei9fx6vWFI6YaGEos1pDl-s_dfMmNaYCNSVc6DvMwvey9hV=w713-h632-no";
                        video_path = "https://media.giphy.com/media/g4G2FNwvCivbwQ05D4/giphy.gif";
                        description = "-Cuerpo fijo, espalda diagonal recta\n-Se mueven solo los brazos\n-Codos junto al cuerpo\n-Amplitud de movimiento\n-Cuerpo rígido, no va adelante-atrás";
                        muscle_zone = "mid-back";
                        hip_weight = "30/35/40/45/50";
                        res_weight ="25/30/35/40/45";
                        vol_weight = "35/40/45/50/55";
                        break;
                    case 75:
                        name = "V Bar Pulldown";
                        photo_path = "https://lh3.googleusercontent.com/jIhuOFymT9R7lMgWqStM1PZi3vl30BWi5Ud36HQDpUi8vMyeN9dxfx09_5nTzlsXAgi5VoGFA9M8IUcP6Vt8J07HXYIFVSfscZ5bA-riFoPX7AOJ5CdpQmepqayYrt4D9hoss8pK9OksSg0O-vhx8DkDDSSpyxQTSlSf1ccXHVfd7ZshxfP6SUcaZNt82q0qUWqIlZlZV35GFzJsrVdkAmUeE1poZiif9_ALjDenqmHtciO73_9cFcJhpEmcWLnzIuaxnaJmxrATmRNMrNVx1N8A1n29m5KJLpRbt01PGZvm37S-4xAtN0N_dtGbqqQ1jd1V3ymsI8FedjGfkENNmYZdYuOFzTEo4CyoS5Z_Q1F9wPmEMZSpmNIwFrhdeCK4yNKh6VM8geDRvwbBJIVVu9nYFkdxj9O_2SoYoP0XAGuvOhJbATSKVDhwLpPiI4l7fYSVQe5QRPXO_s8dGtDRgiqEPvZtDjpx7sNg-01lvqkftmukbqVWdtOvHND-4HTQlymES2Bs9dpeKIGtu9CGgvQkdV_gZLDMrQZN9qd_utkxMCX2OHtKAyxU-bptiE9mga2upmcG7mPDKZXsDj07TtzIgmnrsDymmrIo93cuLM_THKubYSjFjfw-6TVCk_Cpk7l5nZXtPSvtHs1GEaEcPZ28fIoR5D8Ioghl53UabLuXPk4-JWav_5M_=w713-h632-no";
                        video_path = "https://media.giphy.com/media/8UGF8X9kYZ30d34VQ9/giphy.gif";
                        description = "-Traer polea al pecho\n-Codos junto al cuerpo\n-Recorrido completo\n-Cuerpo fijo, no se balancea\n-Espalda recta (diagonal), pies fijos";
                        muscle_zone = "mid-back";
                        hip_weight = "30/35/40/45/50";
                        res_weight ="25/30/35/40/45";
                        vol_weight = "35/40/45/50/55";
                        break;
                    case 76:
                        name = "Remo invertido";
                        photo_path = "https://lh3.googleusercontent.com/2EtJUuPGRhc2sMDk2bJSiFMA0Ynb3y_jBMak7qLhzg9UNb81MywePcTFdlc3eTtkmkum_UgfED1ELz2Iaf8nQNxRfzdePLHfoMGp5LC30EqvJft3b7LGn-51-LtU-ogCIfmuqOeAdrtCFlXDv236smEz8gc5c51XuDQDjSdAt9Dd_XDVgdsTDysYMWXTmpgSgVyuGGW51H-67zdNHbxwmVh2XxVJRGmuHlQ1_94qYKeKsG3fACRV0QZbCsKpIUF6nLNCTnrR20NzlwiqE0MVLGCDM_XCsNYV6HRb0Kx9u4zB8mpFDCehUwl4StYCRbrp1Cn_KQ38LAUj8PF6yIFYrSiwaS5FDGOWaia-LVKifDsHvXpGfGSeoiZTL--qxW1H2Wn26V9yUEfm7zxu5S5OXeC4-0AhmBn0tL-f6ZRj8Ue2m5psN0mx1TKWcVe-aWiFWY3-oMrKPOvrn2103xmLTQUaxQAE-LVEZot7x7NR_2hwrsnh2t5Vlynu8cYkKCLaSoTty6V-20KvJSdqT1fV67o71IA5tkzyhRevmyp-VqTy9MDnWjWxuiY1mi7pqGw-mw8pCd1UDEJtkKi4fqmW13vDfa48jJRDWUl07AQH1YHAxj7jeU1lIDV20wPAoR3tODPMpjrKTDgTiX_oflwfSw87PAgDSdoki1O0p6IgUUUJsUzg50zabtI=w1062-h944-no";
                        video_path = "https://media.giphy.com/media/VaqDvJN3csUrlzgJqy/giphy.gif";
                        description = "-Agarre supino (al revés de la foto)\n-Codos junto cuerpo, manos en línea\n-Cuerpo bloqueado, fuerza de brazos\n-Amplitud de movimiento (sin forzar)\n-Peso: disco en pecho";
                        muscle_zone = "mid-back";
                        level = "hard";
                        hip_weight = "0/0/0/0/5";
                        res_weight ="0/0/0/0/0";
                        vol_weight = "0/0/0/5/10";
                        break;
                    case 77:
                        name = "Maquina de remo";
                        photo_path = "https://lh3.googleusercontent.com/Lz8EF9TMHtpX0JjN8qxVUClUeT54WkE-a_RQz9AkwbM5lvXIEUx-i0iFa6FvTn9vXeLp6e4HCYxqkGGTvBVzRTZ9LqxLy8yhleuW7IkZBvybkwZxdFrf3vnVYihnoqfQD1FqyViJT2bf6z0TMjWcShYJEkmJwI_YOz6FEML5h_l8hd3-qzr9y0ISvsJ7lz-YnQPJuZGO3PYgdEAxWmvGSA393KQkr334WEZReG1N2Im2JGJa70Rj94aItzt9mEgU59O5Fr3tJUU53yE03KxJeq5cRlnQnqtxzFuntdtTbzc1xCJgP82WQjY6H75Xja3QrQTOdrO-aqlD6im_sBQrKLJQcbLG-NrQcbZUkuwKIx_R37hpymZ8jdjwZ1jwwgbp2l7T314NvzpGwXHMrSDsEfGcIwvj4ry-CUPfpkeQXyKezmnMpYQjYI4JbCR11EFR1cGpbD8FfwA7IUIjDcNhzI_DsAcLuDoKp_g5t3IPbPaxjT_QaT3ua5YmehDKe8tD039ir9zu15bvRY7U21OwSO_tH_WrQtF0mGI_r7iHRuO42LHj3PL-JPo2cmrL0-2dexkQWuav0Dqp8NLiLTbFgSUt-8F4ASi3OgJX8MIDQ0gbanVbHerDF52OZEwQDojp9Mx1RMoak85q31Tl_6iSrqB9Crc9zFmXpK-4uh5sfZ0DWG_Ke69tLR0=w1062-h944-no";
                        video_path = "https://media.giphy.com/media/fr4HoxDhvjaif4oRKg/giphy.gif";
                        description = "-Espalda recta, pies fijos\n-Sillín posición cómoda\n-Codos posición natural\n-Cuerpo rígido, se mueven brazos\n-Hacer el movimiento completo";
                        muscle_zone = "mid-back";
                        hip_weight = "45/55/60/65/75";
                        res_weight ="40/50/55/60/70";
                        vol_weight = "50/60/65/70/80";
                        break;
                    case 78:
                        name = "Superman";
                        photo_path = "https://lh3.googleusercontent.com/5pHMWknNPCsT8VXxxt2lUagod-oyP2D1rqzIg_cxjSTObU6WTJziEqoxEBOmxG8pOrzGJfMtVQ6jCwsb2eJdWJOdX24LJkoXQfjCU1HftAYeeYDsJex5nnM5tLv5qwWH18IfCefoqIbSXW8QgbyZqlxb-HjjIJp9FdKE0UeRZOazVrE1VmUgR0SiCNMIm8Ix9DGp2W2nn-rj0GEwaPKBIzNihUGB96HTh1tUX2EaHrNKk3gJObrG72COjFfrHfqcxRPvvQOdfBS0wEHS71p3eJqq6Z_YeT2p6Sd_XkZST948utUddz2d5zo2q9dyGVib1Bry2QKEpsiP1L9dAGNCK6wREYndvVKeeEQKH15oOwOavKhtbf_HgD4kIlfwCBms_CBELnVZkny4Bcps3jPif_K3ovehMMKJ8UWxPXPFvvZHazYVCvrBX6XrWYC805dbwvVgEWjnFK2M4_ZnPVSL6IIc7n-i7DgNO_sXK_Jl863Mq4dGrCFQeBZuZvIexysdJzCsI2_roDuyTizaPxaB4QK84fzLM1y9Vz_FknUf1jiqgL_cJJTsdv2jvab88XuCeEsL9OfVQyvtOFBvWiBjtv6QVFJw_l7zRZWDcXHrt7-JCx_RuEbSrb6DT7gcthdsphspGOot32aFJ7tTXzY72di5nho0544MCQiTnsJF3TM0W52zs-8hAwwd=w698-h632-no";
                        video_path = "https://media.giphy.com/media/7zleKmCCBYdZ8xsMIg/giphy.gif";
                        description = "-Espalda recta\n-Movimiento controlado\n-Equilibrio, sincronizado\n-Amplitud de movimiento(sin dolor)\n-Peso: mancuerna/disco + lastre";
                        muscle_zone = "lumbar";
                        hip_weight = "0/2.5+1/5+2/6+3/8+4";
                        res_weight ="0/0/2.5+1/5+2/6+3";
                        vol_weight = "2.5+1/5+2/6+3/8+4/10+6";
                        subclasses = "normal";
                        break;
                    case 79:
                        name = "Maquina Lumbar";
                        photo_path = "https://lh3.googleusercontent.com/Qs13vEIezR-Tqgih4aUJeqoRKZRCRQIP06LUCTf9VWPNRef_mfJNETMm-bG1dvk3RBx4m4FzpQsacv-9WsE9dfv_6LUzvGmPZMC2_B1jKWqSZrK1huOKCSs_gCj5PQA2Cxzch11PllL0nocPYKEym6_kpG03O_3VfgE_35cANKO3fiq7ygzUvwFsljXBZu1P6HMYOwG1CZMTYwYoDupsd2zsT2VQvjWeOpqKmfc2CojKRDSjDg7sj7AUCJDuKV_Kf7zjqdi6wk7QbrDgt4BLhmtXsEuNNKzn9Rz4s127FKrxChv48VOMkcXgqN944iRB2rD0fbWTRdd2jNJO9Huc05_DuY9zWbXpNrNVuAtgMw7NOiMgLYuLp1O8phcU-2Aig9XtMYwE88sbnZJ8ZC9kGEX_QJp7N7PD8WjYCE1TRi4hhrcDNv1YUuzQWvVbOQZqt7YBRGKzBw4m4Rz7Hq9UEjbLkOly7HSW7OOzD61oe7SStxt-Rg_Gy2yzGj5U5oCj5j9oS7X70YwQxFWLl0isUjXavtnRwosppy5gMY9rVxHDSp5mptBNLfWI32LI-gRNMR_hXZoEDyZQrj6t3rXnM_-SZBcAFPdioLFJbHsa4fu3ZTmFooDezJCGLIZI2nH7OhfZeW3hXioCdgLZ-r1B8IBU_WbAfbSobek6r9xR8c76cn1bhdIRNPAT=w713-h632-no";
                        video_path = "https://media.giphy.com/media/MuGiDdMwNggHrWh3I0/giphy.gif";
                        description = "-No sobrepasar los 180º\n-Piernas bloqueadas\n-Control de movimiento\n-Bloqueo progresivo espalda (subida)\n-Relajación progresiva espalda (bajada)";
                        muscle_zone = "lumbar";
                        hip_weight = "5/10/15/20/25";
                        res_weight ="0/5/10/15/20";
                        vol_weight = "10/15/20/25/30";
                        subclasses = "normal";
                        break;
                    case 80:
                        name = "Maquina Lumbar Lateral";
                        photo_path = "https://lh3.googleusercontent.com/x67KcJCT_2BUbxA7IZ-aqrH_QaDfXfGZBuBLdxlcbQIiE_HUFD2XKDnGScwXo3EL8isJQElCu2vkmfz49_dDvfrhdrIk7aILCTYotiWadjMtQt7fUha3yT-mkgpBZURh1-aQ8MpYaa1ycu3PVezfawTjx3Tnfbjq_n3jF9LYsFPDMc2f6Zd0Ovo14CcdG-wrNC6FJocB56Lmp2oGPvqZTZJqAcCFCPnj_o--JZpXje9VlrGx1MlHsWclUonE4TatgX7WQFbynp07T-W0_5FVdcFbDFQ0W0u0Qgi-Of4FUfCb5W1fShJjYW3RKnKvRTMYB0pw9OVBlE54SMz8WZGiZ02Ygj-Lurz2ixYTSVMG8dzJRUVzh8RWQJz9H4DTs7ZKEFPoPGF6gIB6sePrPxPoiw_svFB_2WXcP-F8jkboYFLYNtYm9Cv-4jfkvPBQnK6f40jw0IggJ7Sl8fU6FhkcOahgQ2qtwD_K9QTgmslc8gMFaJGORnGJ0p-Tk2O-jvSSWHRMNA_177CydIhH7vi3UcJX8N6bYofWki-7b9m1ULHO6kRmO5rPpmY961j-kAgzj1ODtut7z8WTu4CjGXxgeU_eSruUMOe8Z4pRVK7CcSIM0VRmUdyF8IZeetug3GG3S7eEa84syoYnoYYrp_Ev_g7e34cDpEf_pCvqYVP_fG5dhwbtmvGUkZg=w1062-h944-no";
                        video_path = "https://media.giphy.com/media/ZeLmHoN21qk8epHyjj/giphy.gif";
                        description = "-Pie interior adelantado\n-Inicio a 180º\n-Movimiento controlado y progresivo\n-Piernas bloqueadas\n-Subida amplia sin forzar";
                        muscle_zone = "lumbar";
                        hip_weight = "2.5/5/10/15/20";
                        res_weight ="0/2.5/5/10/15";
                        vol_weight = "5/10/15/20/25";
                        subclasses = "lateral";
                        break;
                    case 81:
                        name = "Peso Muerto";
                        photo_path = "https://lh3.googleusercontent.com/uuzJKde-15HfNutvS4XLoB0mTva5botmAkZPwRgKKMuB98TqAxBOcBV-1lAfd-DB9DuTUQ5BAp8QZ8Fdm62jXPLs7GzSMxU8Ao9bjBN-9F1WmsxCUkuKjHjlvppTNSoTWkeJ_MGSVBVRpHbA8ybW6MhhCq3XBvMG2GXib94JoZa1ETYwmjjbRfgHfwm3-U_hvjzUFzgpaVOswlYbSnI-onCiKMrlsE0z_DCUsQ8clpvZtXHfI6ZhtgIkILCLQE9lZZ7h-y20UklLWE_cQAQWMidjsDMzwOAzDHayoLcAlvrga71xgKPC1F19eM3nY23nFS1AgdKogZAgfsNBAFRmkgHwperh4d9OWlSIsiFg8z3XIFyMdOBHanNuHABlc4Urx1w0Z1YtT5WiPl0ltAonscBRXtmDAX5fO8fxqPJuvMGE35GKpbxjnK5L49qXRDpeP6XBvbOo5KsXO5mtFBx2Suk-JZscKc0EguQxcQ3uHwkstb-BcrrM6idhG2TKFTsfLL2jOpYQPZH5kPfLcnB3DVliRfYvyyC61xcvnVRYXM-PEB_WZozuaHeHPPiRwMWCiG7xxJZ9UWDgDRELSn7LOrjT4Ly8CtPcSltz0EtGjJJR_NWPHoRpdDmDxS6ju9z4gj236OmIFW-OG2L2dj4qLwNFyHAw5T9NUHFCYzssjKfUb5tBMsVikhDC=w713-h632-no";
                        video_path = "https://media.giphy.com/media/25HwgnJ41KyOcmyRBC/giphy.gif";
                        description = "-Piernas a la altura de los hombros\n-Rodillas no adelantan a pies\n-Bajada flexionando levemente piernas\n-Espalda recta saco culo y pecho\n-Casi a tocar el suelo, controlado";
                        muscle_zone = "lumbar";
                        hip_weight = "22/28/32.5/37.5/42.5";
                        res_weight ="18/24/28/32.5/37.5";
                        vol_weight = "24/32.5/37.5/42.5/47.5";
                        subclasses = "normal";
                        break;
                    case 82:
                        name = "Lumbares en Fitball";
                        photo_path = "https://lh3.googleusercontent.com/GkAyt3IGhDIZQGtGYGdMNU3K3YvcQA-1LUP63UcU5-wNjFKhDXPMVLqQULAR7iC4gPaeiwXdbScDGxSjq0EIb-eMwZ0jamZY_zdBU4FV3AZNxcEu2uwu3uagG-cBa7vJmD1KtbugwPyWa8HwXwtiQXf3tu2HkvAa5IyfSnHkMNyCvQ8-Z7UTA5rrRq7fjI7zUcHoGQn0CEm2v6R17USvIw23Yj5AhN9nVq_E9Fz7Sve3RkKWxd3AYEzdrjsb7c1Ja7q6d8b9Fl47mnwHvYNSpEiryeX4VpFUB4aQJ1cOCqssDWGYZ7nlDOPoqPLpS0GM3tFQLP90A26-oodH2o8XNHPM--ZCIFv70fQVvsItwyeCtnyVBAbMDJA48ZnDz6H5isBnUNRg4mS2zMRlGL0QeoIW0MCow5tg1Dekn43yB6YdFAcKbq-3UrX7RCwALhoW0lWaUSoI-0pjygn3GoCDXAoLlIlgB0n30pgYAdlzeTkJ_V0oswJe_yoc-0FbzbZe6HoMSEJ54VQf1ihNtaQ2kMu0KDjh6bcdVvn46rcQUyNvRC9eBDRPiLYuO9bf-x5hzV1vJoP6-JohI7vqYxdd6mJnygpiWiBOVOhxXLVZlMrzZSmkeN9Jv-AYuwAkvL5rlqKdxk--16yi5E8frNKmd5pj_ziaiVw9mqdpMm4NFkChrMC-S5PfCrK1=w713-h632-no";
                        video_path = "https://media.giphy.com/media/9VtKUOcglQisehyfuw/giphy.gif";
                        description = "-Cadera cómoda en fitball\n-Extensiones de espalda\n-Evitar balanceos y desequilibrios\n-Cuerpo de relajado a bloqueado\n-Peso corebag, apoyo pies espaldera";
                        muscle_zone = "lumbar";
                        hip_weight = "3/5/10/15/20";
                        res_weight ="0/3/5/10/15";
                        vol_weight = "5/10/15/20/25";
                        subclasses = "normal";
                        break;
                    case 83:
                        name = "Rotaciones Polea Rodillas";
                        photo_path = "https://lh3.googleusercontent.com/S1uKOLs5BNZFdj1ROaLy6MajBPwT5OXgjJ0zs0Pqc8S9MfGqKUiX7N22MY2wNupX0oDUrrREd_Jp47T6p4PAqifhDCzOkav2tVE8pj8McuVc2NSXnWMzoSZdGAzxyT9QejXXovHM1Uocb0FZ7wHKOcAH0XNXEGt1dTxLGvz-N8mHLd3Jnt6I5RpKnxSTeKjXmEHzmLNo0dpsDZypRmhzqW6NIZKXonyCXoPZ_8vD8oIKDjy4Q7Ail4_25HD6uPMz6IJolWytYE6phWAin-j6S-B02xQhIbG9RG2YLKLUA7vLRY9hd3xbRYuZvM1C2ZRP90vj85lKzQ-ZzYzGQSB0z98o0gkyD-QEL9AD76uDzjVc0RzpyQPp4e209V-1BadY1yg8WcK8Wqe8uPWTgo3wbFeNYKrgTKdkAbsYgqRz15v6XM_2esZh4ZsRJNpP4irTcG_ggvAKiqFq9fycEqJMs2RhM_HeOokGovDWWza4uSnOzQYjeK2lyaWvWrWcAKCGw5-fdqtgFpYibit_L6f_koPM4Ccg9IjMdqpg50LA-Ey70yGU0noPoR1JdFU3I36X8Lw-ds7mDloYWahJE2gMB81fJB9qWR304H838a0p5UYuMmwqLvGNPMAyqaiu_ydH05fVbEb0Y7GaqWSwBCu-O5xVOf4avpxhXoevNFDI782PbBXlAHCk0qw-=w713-h632-no";
                        video_path = "https://media.giphy.com/media/25aD3zUdkM8ayNOECi/giphy.gif";
                        description = "-Brazos estirados bloqueados\n-Espalda recta firme\n-Fuerza viene de abajo a arriba\n-Cuerpo acompaña el movimiento (tenso)\n-Bajada controlada";
                        muscle_zone = "lumbar";
                        hip_weight = "12.5/15/17.5/20/25";
                        res_weight ="10/12.5/15/17.5/20";
                        vol_weight = "15/17.5/20/25/30";
                        subclasses = "lateral";
                        break;
                    case 84:
                        name = "Maquina de Aductores";
                        photo_path = "https://lh3.googleusercontent.com/5_TQEcAB1W50KQs6XDoc7GhTZDZ0_ILTFF2pCJNJUJnTeuywlWf8h3nvCeboaN7GqkzwVnezYZ980UNZ9JbpvcKc7z7rk8FH5h_vJPYKAZlrBRqOPAoh0vWcTo8sXAVnBF0KeM3iDTbYKIpe5JE_JyAaT7gz0T5CCL-a9Q1lCshHqRDnSeyBcjXqlVmulVf1L0jugU9FlHkz7rxFxFZSc4crDnqNiya7Y2ukTHGy_cYMNVni87skNVd-mRuWU2XYl43fUd-DYeW7qi6CqDn8n0SbBsDLMcRHz148pBOiQ8OSmvLl_wBusYoY7rpCte7t5jUlOW0I53eO7y28ucw4LV4ikG84qEaw6NYuO18sdQfB2MxPGR4w4LECxFvPE2QpBdss60B1MCB6eutd3V2RmgKobTv8yJfLaPmijPPpswLAc9UgTPOJ2n2xFZ-Xjscmwj6bE30S316soVTUMLPR9DnI6Wic8-a4spMq6tG6orGG75dsIjQ86RXC9ARCe7r3wiSIp28G6nCGEpJA01ru7pUv3JDLkOWu7Jv1b9QPLoL5LqgmBcMza1evkML4w76lU1Ii8-E9OJOURHTnPowqSX4a22NCNoNPC8FXlbgOQ4iMr9hr5qU72uxVkx8ROk87T49kRQ738EDkGTJYPNP6XDt-U2H9n8gz-c5M0jZ8PIVV6I29jiR8GrYS=w713-h632-no";
                        video_path = "https://media.giphy.com/media/YlwnXWMvALBYgBe9eJ/giphy.gif";
                        description = "-Movimiento controlado\n-Movimiento piernas, cuerpo de soporte\n-Amplitud de movimiento\n-Ajustar sillín\n-La vuelta controlada";
                        muscle_zone = "thigh";
                        hip_weight = "40/50/55/60/70";
                        res_weight ="35/45/50/55/65";
                        vol_weight = "45/55/60/65/75";
                        subclasses = "local";
                        break;
                    case 85:
                        name = "Press de Piernas";
                        photo_path = "https://lh3.googleusercontent.com/1qru1ov82MrESffx2Nl3BmJYSOQxInZMDrNdPfLO4aGXty_9mvWdEc4SAUjaww5zhLAe-ppzt7R3uv6zs4aZ13uKbyphO_qGvh6USuxkOA0a0g5G5MAa59D0OjPvr16XYG94Dm0gveiXQaeArOBfgJdSqplpEXaGR3_HkferL1vPMWg51UimX1j63bMQEe2uXB5qPDnYFitIf13HbffQleIuScWlTzCul5o0t9U3Kb7Y712IOlHnzOucPlTIIsQzBeZT7LMPAJDuVjlsVia0dEuRsaQSQdcMWMr7tCe-AGmp4o8mhm-l2rDlagVUj5xhgztNrvOQ50CFnf8QY4f8HrcBddZ2uj7o0p2n6qtiBxM1jdFJwDhEry_0Uto3eELgNcv76sl5_mzidiBX20n2zRHCYIgZOmIoEzxFpLVQIkxXVSRE5tK8NG8wakLbHUA7y4PjkVTeKSwjE_mQmSYHb4zm1GnB088WpCLuH5g_eRP6SHU7pIYfFeG3Wx0utvfLJbbSqwWubAMurHYRb3zTy4WlpA1hIKwZqzhhorzouzOMfRCGrL16hZ_7fzn9Qo7psCjXe770MTiOp6_eCepgLZ5Lux28YMdA5IElq2IsWzHhHgS8FP6vxFO9UsxQgcuqznWgrBPI8WiIrwgMgQsbY-eSC4ExtE_OU78LjdIVrLHHZZYNehD09o8=w1062-h944-no";
                        video_path = "https://media.giphy.com/media/McDszitQHwpR7vKOtg/giphy.gif";
                        description = "-Espalda bien apoyada\n-Piernas separación como hombros\n-Piernas posición a media altura\n-Bajar poco más de 90º de rodilla\n-Control de movimiento, sin tirones";
                        muscle_zone = "thigh";
                        hip_weight = "100/140/160/180/200";
                        res_weight ="80/120/140/160/180";
                        vol_weight = "120/160/180/200/220";
                        subclasses = "global";
                        break;
                    case 86:
                        name = "Abs con giro y balon med.";
                        photo_path = "https://lh3.googleusercontent.com/dqBFCKkZtyaGGSKTw_go57HhwAXicl_F7CA2S875oZUz0qoqR-szAVe2fw-SJopIxW1YrdjVQT6JL_EO_QKNDtpyo6rMTXF_irozcJj0mbkXnjVnYL9Jr6sm1IE8ZN2PFLiIlQb4_X0LM4Qr6-_b8uDCGz7kJWNXbLXsKsS6xrBl4uxjTeSfgZ74yygILmun6Wbp5cI5QtzLHVrmr0TG1C1ecK2zQwHapZeczwx2xIirWgIxRsqmlR4LyCeM0BDpMVXL3EwLl5Pvt0vL2-VQz71KzOeeE6yQ5l66iBCeLjrACTmQaFDPm0WxHNHZfay01vZmILUv_BbRNGCvuYNKzWogMOKbqVeh70hYJKK4A8od_4FDPWR_9F6sg0gFCst2Z-WTteMMdQyCOf_NDYM_99ZXzafNYoSKS7-EnndLm1QWzJ989ncECVF31sEXxsDuQjava2p1yccPeHNAyz95fg-zVtaTlW9tl-CzB_W6YSmJntjG4IxTHjMDIYFz3SQ4rN_UzY15uC2AATVTXi8U9-AatnfHvAj2YnmmzkabDSbKjmhLn0MzEQe-UoLmufRIGUajH8JHGfbt97mgxW_yDdowwP6uqsoJwgKB-kYEF3gB3Zd7Mag4B4gOhUbZbyTL7wGSxttyhAE6ljouc9W9GL41wdLSZJ0vGQACDRas9b9XSeeBCmHgp9A=w1062-h944-no";
                        video_path = "https://media.giphy.com/media/VgNRdxs4TWrdfUzVNA/giphy.gif";
                        description = "-1º subo normal\n-2º giro arriba\n-Lumbar recta\n-Hombro busca exterior\n-Movimiento natural";
                        muscle_zone = "abs";
                        hip_weight = "0/2/3/5/10";
                        res_weight ="0/0/2/3/5";
                        vol_weight = "2/5/5/10/15";
                        subclasses = "oblicuos";
                        break;
                    case 87:
                        name = "Lunge (Zancada)";
                        photo_path = "https://lh3.googleusercontent.com/EwDDNRI41LPb8a95kGwnxB756EW2t15iy3klFWIiLotlAvJ_L5WRC5DYgijubw7MouFMB59fFdzagXYlPi5ZoFIKa3YfLFCJau1RQL9odN6FyLwn4wcWJehixmDxaLHjhJ3NoZfKiyWkOAlAEaQC8SOwQW_z6wnQCwr_uxztaMUFhUlhHJXQwGL8IAigrsO4mPLlLhIeDXHwUQBKDc7nJT_74j9nnZ4db7MagVKSH4WJWLHzEPmcQlvDT_o9wa-5T0_I9rJWCQynLn9vIdtUoTdaQen8i4DMMHm5MYAD_Z3JsCYZ1Z5Gu5dCAtpsIcu-mzPzv4X-AcR-u_bS4ELz4nqUqXUH0-mCq1mCFAAShac_kPyqwxToRF53QyB5bXKK3H4ljgmA1-4euKSZSloI6ZbHCIdAx-kJcTrtQkGAAApIus9sJhLMlrMQIfL9Myr0wjDrQNUjUNObp-FqtmUFWXDh4pf37onJ2-D3K2_zdI5zCvic-qxpEWk3hzwjPd8I3llbWOnHBb-JxF84C7Ev6iGFK86mo0rpubmcog780lTDRks5Bd13rP__koPvsZ0t9Au-KOX8kuKFO7Y2BeVn7YlGXxHyE3WWJlwCM5zpRvvqHKdlPlck4QwDVu-o57euV_NSfUL7Ikzt2Y_Yfua8JKj4tDjrqMBVR1OatHUBt8HdeXtr-uL4orFj=w698-h632-no";
                        video_path = "https://media.giphy.com/media/p3ZPIbHhb0oMqtyCyX/giphy.gif";
                        description = "-Piernas altura hombros (inicio)\n-Rodilla de atrás casi a tocar suelo\n-Final rodillas 90º (aprox.)\n-Rodilla delantera no adelanta pie\n-Peso: dos mancuernas";
                        muscle_zone = "thigh";
                        hip_weight = "12/20/24/28/36";
                        res_weight ="8/16/20/24/32";
                        vol_weight = "16/24/28/32/40";
                        subclasses = "global";
                        break;
                    case 88:
                        name = "Maquina de Isquios";
                        photo_path = "https://lh3.googleusercontent.com/Y5C-kUn-T7wBF2M5awFfl9OgwDZgh5C15XsEbEAEyIVMeHs_XrFScIXhe7RD8w2LZmM0ixMZk7M3fW9JXQpO8KgixNhOIp9mpqaPrQdE2E4pU8mRQhxMuidwWC8TVe08XR3fuPLQl3hL6qDqyZRYXoLE5piCmc_YSnRnvTdpdHqhwFjdJM7AkSdQet6nm-SwgrvQXE3JURYOcpLaSxg2FE6hjDRjYHLiJEbUqV27VunuxRVKtOruemlcJmWWNxXx_Z78-Xa4o0ZicHw1JqJmq2jHxemSejsIzp-JcpuniVBJrY4EriGKXMHRAs87d-1JS4WWVna3lhbwWjB6sd9rBSKfX45tcBx57SVpQRqPmB141l7bs_O7ymKYXgFH8JDw49tRHUPk8MlxyxqkgTOva4nb1YknuxJZ4CDt5hTD9ARDF2OTZ8vIt42pIiuh2I-GaFebmrE8bYnkUIgLioJZUeSsHK3f4LdVnJ13bDBgrvgezAgNo1MPHVMGv57jg7qwuxvXCkZEEIB74Q68_HSJdQbL-Ym1SoMT9isrdVsPr1oV43SvnpgDdOTmA_UkhzS5BQJzRhudqyUF3XiWZQipcXedHQP-eEImtIklxjTW2UcTYRYwNuerExLPy_Y8jVKX1SmFMwnNFqUMBACIhEi7TG2doKDxDDTgXqS7hXUVyAAMbR5bDLquOE6o=w698-h632-no";
                        video_path = "https://media.giphy.com/media/8YTRGj9wuZ0lKHsD2W/giphy.gif";
                        description = "-Bajada controlada\n-Ajustar la máquina (posición natural)\n-Trabajo de piernas, resto del cuerpo bloqueado\n-Cabeza relajada";
                        muscle_zone = "thigh";
                        hip_weight = "25/35/40/45/55";
                        res_weight ="20/30/35/40/50";
                        vol_weight = "30/40/45/50/60";
                        subclasses = "local";
                        break;
                    case 89:
                        name = "Maquina de Aductores de Pie";
                        photo_path = "https://lh3.googleusercontent.com/VhrgQ_s9l2TyDWdJFvyJodFkBwHYs5INrEcp5n2mlFrcdRRcV3ePeKEySZzhUvsxAMeHHb6k0wO1Uw1hF3GbVW1vp5bnC2JilkapoU7oWOnmnHwHvLzdgiBNYwMY-dORuJMg5DVmMUv_U6LBRgoWuOUacSnuQ9bOhZKbIweg9C-eYE6CgOFK5xpWVcA3E0YjmnMOIV_hR4ScAqF7Ffj7in85biUjA_ZCdye5zbNFBv1KBGKi2t-gWlFHxBTKJ9ZESIursVzaKzOIUPwPRwXAn2OsuY-ZjOvzMc3eVtrJYaHCOUIJbduM43qDETKXkxBkuxFLzE6jzeovHA3FIK1QexgE0Bh5apweYUkDTJZkPLB_RO4lfQ11VUdC0COLvi5xmVu0awPcBGjyY6uqyw2VPGZoqZgPzzuUYGaurPFQcsUMirOeHLRUUKuYrEGFHjFCTypyIJcb-Y6bJtFa2oBT7hfOnkKB7d5dY_RPRMEbVkWuQjMZneyxp6wyk5nS-UUn_pgrwheY0NbgHXrKZlOnfOeLUjhkAAXfJfqvedZUMwL6liNTAE_FQxCpK0vpAb4mlUwSrdghDtIhwUugTG1leTaAv5NOw4j6ypd4L0hqoumRNnQrJOXl7YQiuU-RWx2_EWzjC7bjfenwZTnW_fX4lKqKeAwVBXDpg9PiyVUit0_caeJbRrrV8oAg=w713-h632-no";
                        video_path = "https://media.giphy.com/media/ipxyVwE01GL7ABO1jl/giphy.gif";
                        description = "-Vuelta controlada\n-Pierna del movimiento estirada firme\n-Resto del cuerpo bloqueado\n-Sin balanceos\n-Movimiento de la pierna solo";
                        muscle_zone = "thigh";
                        hip_weight = "40/50/60/65/75";
                        res_weight ="35/45/50/55/65";
                        vol_weight = "45/55/65/70/80";
                        subclasses = "local";
                        break;
                    case 90:
                        name = "TRX Triceps";
                        photo_path = "https://lh3.googleusercontent.com/-D-PHgMFub7yUrOyEOqmHH5FnoZzPN8_6eybB8i2Pn0zu0lQ3oQuzbJPK7qT1hWtItFHZJabZ5PhFlwnHnU2dHkOEWmbIYEpiXP5glXthSOS62Uz1O0rsIkTW4HRBglXMSqD7wKWK0gNjCJsUnuwWkX2OQI503Bc_YhqZeA1UKPD_pcFRygyiXvNE_I5j5JDPefSvF7uzsUFhXVocdgbeZC8Oea5dCzmvafFOZm42k5W4baO5PlbM2HYr6gB0NSf8uFoEDf-MWzVfTVBNPJXHlusj-RFM7tA05WUOhpa60gWDAGI60Fbk3j6LtI7LMuRDmneLy3b5VdhFTasa7WDEuBAE_3fEf8gVqtWmOTBbim2bW6C_OQUFkDgOSb5O7Ns7qP4qSwf3AKZUtqwwJ3d-CeFgs-Uv5J3SZn6Huj57TvlWoEk1Ms301UfO1TVO-C-LSGlspiPJDmNlZM-QhC8QTCbu4xYZl0FWkryQNw5fs8iU5T7WxUVpaF-JO_isQidVPeokGrSLCNHw9USpCqEq_97hXh-fqpQCqrUBA6trwL3Vc7s4GtAAai5Nj0zu4zF8_kmPXMkas1sobQuSBSLV_kpqKUtASyw9t5IQrOT4elv2lFTw0vOqyzVHgdlMgyBD2Ha_HAAokfCm02MWAY_m1wMmO5PMCbXeSFsTgI4A3tXTWNTbCO3i-k=w1062-h944-no";
                        video_path = "https://media.giphy.com/media/PiWcqg2hGrQQqd7nQ1/giphy.gif";
                        description = "-Inclinado brazos estirados en TRX\n-Bajada por movimiento de antebrazos\n-Cuerpo bloqueado, bajada controlada\n-Codos altos manos a la cabeza (aprox.)\n-Nivel/peso: la inclinación inicial";
                        muscle_zone = "triceps";
                        hip_weight = "0/0/0/0/0";
                        res_weight ="0/0/0/0/0";
                        vol_weight = "0/0/0/0/0";
                        subclasses = "c.larga";
                        break;
                    case 91:
                        name = "Dips Station";
                        photo_path = "https://lh3.googleusercontent.com/P5erqIUoCPptgaUNsLSuuZevUKrG1QSrHJYJX1lJxEuNZjcjajQLSJa2hD0F5Cxdl901kf6PIvvfFbrLMUPpCTMbrpxdaLgBHrB-LtM_116W64afxnsZkmDBuR9Ywl_zRIAx6gY52HxcDtZfnIatE6WiZPtIMNqK0nSSCXKyu9Rh7Z-w_O4hvOqs-qEt-QT3nHFJHA2_KiPRwd_Tay-tbIQB-wjPJTvnp6ObDEiXlxk3EUeBE4HUUceqA83WSziBhbNslj-x0ENM4abaUQEJHJHncn69yNZQkZtxqFSM4kMaazNIGkHGogvvvpOcp1p-uV02ZcY-6OvMNM42XUvWt-YHMPKHa-D-258ZtSknTxdebnUI9copGLohyAP90dULaKboVm1NVv64Yd5CAE_AvXuVtHBZ0zT-r55gDHZIToWMFHwn_j8Z5lfisjI9FBowlMV1jEAeAOyawOFJHyUS5LV0ZSxKaSXE2ptnT-c1SmzgsLfdG3Z7wDXpT06Km_ur1AtYXU-6e7WXDmBgsIdWkZdg3wRYGfPmq3x6fRPNPLHrif_3eOkRC6JxxOSiwDdng5XQXji2MY8GEVZQoRtdQRXdRzdKNJNUnk2P2XOZuoqUlbYw0pLjhmxNNVwGp4e0Y4Td6Y5BtnuqmFOEdKZ9Ey7RRqCGGGSE-1AfXcW1-VeIF99NPuEpdU8=w1062-h944-no";
                        video_path = "https://media.giphy.com/media/lMlSrn0IVCQtBA3b9n/giphy.gif";
                        description = "-Movimiento vertical\n-Sin balanceos adelante-atrás\n-Espalda recta, tronco baja con brazos\n-Movimiento controlado\n-Si no puedo: ayuda gomas, o máquina";
                        muscle_zone = "triceps";
                        hip_weight = "0/0/0/4/6";
                        res_weight ="0/0/0/0/4";
                        vol_weight = "0/2/4/6/8";
                        subclasses = "c.larga";
                        break;
                    case 92:
                        name = "Flexiones Codos Cerrados";
                        photo_path = "https://lh3.googleusercontent.com/MNOHVA0mxbEn0ulgAEeGZYanTX401y3u2ltMemRTPcYI7B_LKvB8FnrBW_r2wUaJrq0YgGbMlwsWwhTUXjqPs85pUYPCFJGq2mMi7ihsv5u4F4snnpPxcYCQ6lnnX-Eg7uhwmj4CfY6_gRK7WJHa2wC4UBaJt7_Q_IQuDnX3BbMopJkqSIiDvoHb5ZpjqFO6WxZ6T1mp_THBuhnOWTIQNxTrsHl-FR--x-bF-V6ZEBnuWNhjuSVWYkl3KcHHB9LHM-jSxcbFF_3Now0qelmrpZQGv_deTzAmdnysNCOfYbj9ryH-LrkmMw_v7m51XnpvdMvZQmTYmST1HAXF-KFiCF1sTQRjn1BiojfDs7OGawo78_ednYfv2Pi6LR9CYXQtTbdcQGm5vR22UlNWoldBuYPW8LPYP5MbWWwOrzYWzaVODDRQ8Pn_xb9uxk-ikIBgC1WmUuaXfgVqMAZSFo69dAJoF37_e-P1PKaqepGSr3UJNCNeD38e3heg0Mottdj2Csj3lz3d6HjlYzKDSq8hqDKh1VJlqIB-fDV5XRKh5pYIy2spzG4BvTPtlPFhHlHE-_TsSRv5T0LQkW0s8GFdFgSkLW28RcpImBCwqpbrsIqwdQryEwRaJJCwUpHunQKder1bL79554CRBTJuKrdEussQ6yrDWRzDiROUt0NhFDOwIZb_fjyvBTYs=w713-h632-no";
                        video_path = "https://media.giphy.com/media/65HKzH8AxXEwHK325v/giphy.gif";
                        description = "-Codos juntos al cuerpo\n-Manos un poco más abajo de hombros\n-Cuerpo bloqueado\n-Movimiento con brazos solo";
                        muscle_zone = "triceps";
                        hip_weight = "0/0/5/10/15";
                        res_weight ="0/0/0/5/10";
                        vol_weight = "0/5/10/15/20";
                        subclasses = "c.lateral";
                        break;
                    case 93:
                        name = "Flexiones Manos Juntas";
                        photo_path = "https://lh3.googleusercontent.com/PqOj4cTuF7KuaY1ifd8X-JlXFbpA0nravxsE0JwJQPpveKezS9Fe_Aip2_N2i2siNHR3vhKYEFesy1MGa2SBoIMHe-Pmystzv68ChbikFx_ss0XTwwnC8zDgtOE8c4YWXEFwuvl9YwxFcZnYnWPgUEIksIOcp62ksItwTNrvYM5le_aQ6GjWythRZ-V0o_Z9f9iBtS_sTnpa9JiQH_DlRMnLMjBbDAJoxwduUsd2Q-0cHVUIH--L7kB0YEhbtTXM7Q8lo5KHl9Tu0EeRq-aaqxyq5XXE1d6KZ87lVXXDusACSWrt-r0QYmdI-Z2hDc8nxPcGUvOdazTUb8vxcbM3VLSCcGrN4g4sFZiTboaDsOcHGKLaDXLVpxn0QF-tpbaE5ibY6kU-TndHF6WNj8MIfUJh7ew70hehr7lnEWBX7wvHCQnwrk-juB1VUr4obBIBDdSMO881I7Q6hRaLDPt1yFRPvK_m-S4vQLNzj_zMl-O36AQPFZ-y1ESQpFm2ER004iosuEzFPnE4ehVUPBvfynAGqnDGSY-6CvMKEwk3vWXb_tQmd5RN3u_8kiF19lcDQYmMigj-M4L-zdkCdtDL8T6kot31vBBBFTZY_1x6Z4p7YKxHUNGmKFN4mHyWZRbErQvqP04dlz6S4O5JIV-3ZsrdAZD83ypvqz1KldaRlqUOXqBVWq4t7yA=w1062-h944-no";
                        video_path = "https://media.giphy.com/media/lOZSUY5YNIQmZLkXyD/giphy.gif";
                        description = "-Manos a la altura del pecho juntas\n-Codos posición cómoda\n-Bajo lo máximo sin tocar manos\n-Cuerpo bloqueado\n-Movimiento con brazos, equilibrio";
                        muscle_zone = "triceps";
                        hip_weight = "0/0/5/10/15";
                        res_weight ="0/0/0/5/10";
                        vol_weight = "0/5/10/15/20";
                        subclasses = "c.lateral";
                        break;
                    case 94:
                        name = "Extension Polea Sobre Cabeza";
                        photo_path = "https://lh3.googleusercontent.com/Yv-oKvjKbaOsRCmJAN2TjIleyakwGX1wrW6qNQt_-FAaWLcXopgtuUL6KkMwfYD4JmgcmWGrMwnrVNeKly6ACfDpuOtzXaFdS3SuJf6VDl5lqcatI_Zlerjf9gTglinGQvCNqqWLUjgT_LoGiVDMI7IVo_y2lVdsEyqIWKt1GAtpXFJaDBFYIJV0S_5Z-CiqAqm-rj4zaIAJXFaGF2SHC4GWIMYM-jLze0JgKMl9P6LsScP0SIkYmDr_WtPho-lUcIBwqb27n8we2WWmnWSB4d2ym6IBicSMnklm6OuR48fG7-WDJcfRoa-nL3vYvVStawYqFT-ysYvNQnzFcErJ0Lx1iJ9dqoegebdMyiYv2aYgjqJwyurT6Ub_5le5Kay6iCvSIP5dwXQKS2P1wl_s3_ZiB1VI8SXISzRm8ROHnquYeJ9CSmXzFkh0qzBhCbnpOJt7v-gausTpw0Aa9VZktTv8bNKyvPAZrty4UmrSwxuB8YaD2B6TX11_Ch6DFAqBUdIcWMe-sZyXtHiRjCZzm_MGKpIF4lWtPd_mTosMNP43nEJt7XdPnM6IEdp7n2B-BjQNQWUUYXdoU-IMGONOMce7IiLgo8HmbhF1WtU_7y5_QuXcgOuYEvw78GbiDoZmuW-mL6nhLCEraAGh2cRHXVOumurtQzVFyBLnw5IQuQw9qzOtgb7eJskW=w713-h632-no";
                        video_path = "https://media.giphy.com/media/4T3QGNq4wA4pnNRjIv/giphy.gif";
                        description = "-Piernas semiflex., espalda recta\n-Codos altos, se mueven antebrazos solo, resto firme\n-No dar tirones\n-Bajada controlada";
                        muscle_zone = "triceps";
                        hip_weight = "15/20/22.5/25/30";
                        res_weight ="12.5/17.5/20/22.5/27.5";
                        vol_weight = "17.5/22.5/25/27.5/32.5";
                        subclasses = "c.larga";
                        break;
                    case 95:
                        name = "Ext. Polea Manos Abiertas";
                        photo_path = "https://lh3.googleusercontent.com/yc5Cbn_RjVHo9x4U4cbCZcBZ_U4RDFAWGug4zvyCNlx_nuaHfCc5BadxaWK55h9ph9SlU-8yZnoBFuVl2N8OJFen5vQUjFZF90FG7hlT5o--S1rEuw4vA8hqQAvBjCq-GqOk-oYMuuX-v4q8fIAxyNYOLkvxYmjKoVzjVRsbEcgo5g5xxp9_8xn_EZVflDSWlSEidq25goAS6rpoLmJeW0z4M4hLXLkT5x_NajQFrbsxyUE0TQ9tNTgcIQnA6Svqk6-PcqE-Yzcl4l00zUkhCOw4Z1QVYNsGgKhKtAo4tF1UVNeNuWMmP8NRJyPH-_Vq713cchDarC4gK9mFMn4JAhZfM0cHUDvVJ9TN-fj-Y4OEqxiSHWTh5vrZu7ySn_a2EdgxoHcIRXolbWmP4_QfqSFaX8E2zYJCjdjxhGPNDnsvNQdYMF6pLPpbQb4FSHa4jmAMip47kWpd67xCr_R-XizCmVKywoN8D3QKUsaVu7zeAs9k3MppcijrFzKqC8jsHTvLAuT7B4iukcIeBMKb2ePWM3QCWZ74Yls6IGD3wi3ZIFuacu0Jm_fy8P23W6zzXUJLij6pX977As_ZgePY1Lay3uT3jEY3Yhqe2nixJXs5LtCasWdCDSN6cdw1CJYR5xZnvV-Kfb0cwFKstrNd8SJz2_WyqqDTgylWnhzLjhdjr6F-8EUWD8Uu=w713-h632-no";
                        video_path = "https://media.giphy.com/media/30pMgYTJWUImJK5ykv/giphy.gif";
                        description = "-Manos abiertas\n-Codos pegados\n-Espalda recta, piernas semiflexionadas\n-No balanceo\n-Movimiento controlado";
                        muscle_zone = "triceps";
                        hip_weight = "15/20/22.5/25/30";
                        res_weight ="12.5/17.5/20/22.5/27.5";
                        vol_weight = "17.5/22.5/25/27.5/32.5";
                        subclasses = "c.lateral";
                        break;
                    case 96:
                        name = "Extension Polea con Cuerda";
                        photo_path = "https://lh3.googleusercontent.com/HffjCqBt0kiYf_2NLOLrx5-IGMvK3lsA207ppkSjVuVNZ6y6xSWL6MFlQSBZHtkldTRDqIG6FgTsBGLBKsJfY6-0NGFqaX5_sb58fNwhDQwuxGznHKLnpBriy4-Lk3GKhDxOTVlrle1rdFBGE3sSPOhzncdOiH5XXzPnjTTWSiUihyKWyZsoeI6jtMfLKsBmq2pdvuK58aG8cvkBMJnU-JRZmF4kvRzGGlS0ENbs1OcI-oV8ujHD1w57R3rkF2XE4dnSlwCthIGmaIc23U39KgLhmWFzLSwnoLvvXMVFs7gmaHSVphoFLfCLB3mTEFzKkbDlNpK719AUC3wTTkUX8t6V3qwL4V4YGVA8h2Bu0MVHbkrYFzSSNs5kCDYMC90_v012zb-g3UbviY7Mdf7eijT507-QeZjlYVEL-rANkym_K82uWshW2Q7FvwXI4IK8_9hRHv-NL4RcQIUI5MqhApG5v6g-4ypZBHYaMeR2ZiUOHu6GT2xHC2Ni1rM4b_ckkDv4arNfRrwbjkABajUjGUd9AfosevVWL3cj7OrQePIjJuuODL3N52smIioEu7EcxNCFmblLahEwEGD2G2mLKcOA1l9jBnkVARTyQ-NikpRADqcFwGzOCYa_rhUIkrmn_X6F8daahE3lrO1JTB_ojQkHXuEARFgmqCMaZoJVBezHC3UddigD0R6N=w713-h632-no";
                        video_path = "https://media.giphy.com/media/1evEWqg2ryZyKK5WU8/giphy.gif";
                        description = "-Piernas semiflex., espalda recta\n-No balanceo\n-Codos pegados al cuerpo, se mueven antebrazos solo\n-Movimiento controlado";
                        muscle_zone = "triceps";
                        hip_weight = "20/25/27.5/30/35";
                        res_weight ="17.5/22.5/25/27.5/30";
                        vol_weight = "22.5/27.5/30/32.5/37.5";
                        subclasses = "c.lateral";
                        break;
                    case 97:
                        name = "Subescapular con Mancuernas";
                        photo_path = "https://lh3.googleusercontent.com/g1AKein2o24zM9YFET_zxHXJBlsBl-osN0Jp4Unx7dHqkxfL-tcVi_I5xmoCqpLW22D2zOsvx-tHXIeYW7bm54dBkca57CjNexmZcMIuPs31wQK6U2djeg6b7a_m0-kEJNEGpUIUGr_UD6ZSMFFQT-DLY4F0rTwq184MbGiWDbTqAUOOoKYcZS5j0jDVIPgHIYU3iQf8feF4dVGdlsagCT-OhsBviC6tgUdAuIpK2gixk0tbLI-Wb20lxciFI3Sj57neP1oyQPXOb5V-Vmh2hMWgeu6PA_YC_6nOsvE0sdAn2AOzVWyS5RXENVOyXlQR0868a7OVPuaroB-fqcDfopp8nUfJm6UyIQuJS0N-rRJ8Q8MiXWLezkq2Lz3xWgZr7O_wX0G_u-zZI2QcZghShk-Mm-2YmReHJboQJooa4sg2SdqMN7X7LOMgRdgD4zz9GNrXwWCxZ4SqjYopNG4_h40TjRKATGgM9YHH7YWTSlo3KjXNk8OuI21HRM0OuTQTIEyuBBeTrrAwNy9vCHTdAhsDawSvzWobJBBn-Cx_PSrZtf2HRlcGFsVJFmX10nVoldXThABVOh9OzBbavdgacMd8I92iTFulew7jwo7cgzaDIGkVqCtiq-xSEytf9RYTOtgw5ZIYSWtgHENggQhYdXxjosS89Wo-O8Dg-2bHqvh2QkeRc8R4x-Xy=w713-h632-no";
                        video_path = "https://media.giphy.com/media/7AaBEKU1cl9afRe8Fu/giphy.gif";
                        description = "-Codo y hombro 90º (inicio)\n-Subida en la vertical del hombro, brazo estirado (final)\n-Cuerpo cómodo, de soporte\n-Movimiento controlado";
                        muscle_zone = "upper-back";
                        hip_weight = "6/8/10/12/16";
                        res_weight ="4/6/8/10/14";
                        vol_weight = "8/10/12/14/18";
                        subclasses = "rot.int.";
                        break;
                    case 98:
                        name = "Supraespinoso";
                        photo_path = "https://lh3.googleusercontent.com/l_SN2rNTRjb0NarWclH-JJf8Sn4I7mc8XvtgTvenQk3mGOZP3ywwxLvVwqsU50YHRvxnCrHK4iY_583DlX8wzLy2r8WLdhSIdqUUGg10k5I8fWC6hLN6UX2tow88af9JTrXbMnO9r6vnwHAyd_G-wnvde70X-p-gqkc18Ik_JWnhwJhcVaTsP_dNyA5cViGX0YSsCKJkQGuRiyFJXh5x3bZsNu0ERA53OuEwL_oQhPgNB6qf6oUeLOtHYv44fK0G1AcJHLg6VvoKcAAg9kcMQxAw6PIy76iIwLrx2tWLSo82buuZNqdm8EbnCjXlT8WUYOUtHkd5jDPLeOaBy2vmotgTbvGYqac1FExcZdaaY7ncdHWOdWoEWXFmhzeay0YvDaOrPXyDFjb1DPN7d4GSB0XNCoENJv8yuoDCT7mAnn9hC6U7qKzhvBRkp1BKZj7d2JUhnJfAtRspqOAlP40WnbSv6SclLGoBhxLFD4nahmonfGAvZqd7E1g0XH_4TJ1eV_u-1IdRHNYjGgj0QKW1dI_JcVmPzFOsK8sFtnJaC0i3I0WTN1drAgRNYMvCgulAGCN_vAJsesCWxXbU9xiqzNJnCM_IxP0Na9KKU-JenOsxKP8KenmSk_2XVx2ki_JO8t4fNb40RANgbOVrWb9Vq4Bum08Fisgi1dNvGtbEas-IZ3QnPdSS2yI_=w713-h632-no";
                        video_path = "https://media.giphy.com/media/QmDnjZzM5DDVj6zmlz/giphy.gif";
                        description = "-Subida hasta los 45º\n-Brazos estirados\n-Bajada controlada\n-Movimiento harmónico, sin tirones\n-Espalda recta, piernas semiflexionadas";
                        muscle_zone = "upper-back";
                        hip_weight = "8/10/12/14/18";
                        res_weight ="6/8/10/12/16";
                        vol_weight = "10/12/14/16/20";
                        subclasses = "supraesp.";
                        break;
                    case 99:
                        name = "Kettlebell High Pull";
                        photo_path = "https://lh3.googleusercontent.com/uKArmM218BJ8xmuEv1YSsk84uGrH28hEwz1II2K3SdUjR7nS2hrZc6Fp1D7ZLGbBYu05VVNISV-2aMz-isdoaIzzZjk5dn0KxkqSXsf9w9wV_eqVJLr-3X_hsAoatGXl0hzIAN-j2JeKXacEaQDk1QPch_OfzQ7708i0BoniZVSYvllkZ9Yr7KxHrZq3cO-nxQOaUfgEZmQViwerVcs9JhVp0hsF71YnlHiB3AkoUidS6_uDQVAbBM1ewMvtGwFn7TkcArBwMUdovneH6gqhL7ZitvHMoL0mO_KV51IZCmiAuV8KT1JRFLfugi5pRPAkZsU-nVimjl_1DB0B5YwemEOorcywIz0u9cGea5ZJh87J4lCe_EYBgup1W1IWvwIul5IBs7T3uUCjjQJMOi2higONhnz19XlHYtK4BfLtzo7WjFQY_k5OFMjDHtqjrfAlKAC9mX4DXjMzkYkVIyo57N5xXQ3M7Q13VGJx8xwWINwiAwqTgG1MPaB1-buFxJCnfzGRJko_ROOujOvbWk-DR2YjNnCHjhgly_Vm0l-e33021PTmBKFY_y_3lEmz3RoFqq1iTmOF-US5ZtxIyOu8jpSanafIMMkvsVH3hZGtW7PNQ2FyC1Wx7SQHjDwX1_R01fZs5LvScZWnAJteIlptt7D2PbGMz1veixgHb5wNZcqYxcaaIxHBDWLq=w713-h632-no";
                        video_path = "https://media.giphy.com/media/2fLcHUDvzGKNS0X8QD/giphy.gif";
                        description = "-Espalda recta, piernas semiflex.\n-Subida en vertical, codos suben hasta los 45º\n-No balancearse\n-Sin tirones, movimiento controlado";
                        muscle_zone = "upper-back";
                        hip_weight = "8/10/12/14/18";
                        res_weight ="6/8/10/12/16";
                        vol_weight = "10/12/14/16/20";
                        subclasses = "trapecio";
                        break;
                    case 100:
                        name = "Infraespinoso con Mancuerna";
                        photo_path = "https://lh3.googleusercontent.com/kAWtAeZ_olI2cfdX6K1-MxoDSRP_tmSwOsgT7zyk7WEv_q-MlTdcW6VU1KiBh_i7nRciYO5SotT1sKIk0f62EU5totRA86rOSDxki6ButmSLFai_jh1fsD2tB50SThvPYDo8rRWhRNk8j6yo_gwEnTR7sbfXWOO4qv9enO0N7auhcE3JAyECMtetffiqA1NWmUCVzEo8rRtCRhwKH_GfzxE1L51NJg2351_n4AVpDDxrz_bUyqgHqd7lWt-Pcug6CFxD7SvGOshgRAojTZWLcTsRLjStdYCYR_Djv3mtTVxksgjabyPlMuqbv8N8wsgEhGcvsPJRE4iPc2oVXqTh6-49-oVIXOVxvgbkzV93uRiw-DxLLfP-y9pD7qdieu_coAtNoFP9_QCs6g_MofIVZcsWFiNpxxYw_ucf97zjSGVdmzIJ96V0vl9C18pJXXwvOuWx24j9B-EEJhB6BKKoKhvonP9iuVQe3mA7nqguQg1GUUHf21SuLyRFqWzVJYD17d8InBTz83g8xAbTFIlNQm8SrGj0pj56hWdP7JnhkVXvk80koC3ksYm8hBxawv0ZdgcDJjXL8-bZ9VHFYC3qvTEQ-el5NOWslDr-e3G6X5RAEtlQ-uuoKxEzMFZgj0tdxy6Kr1OL5FWhBoaNClCEODmPELtaH1vhJgDz0J7fSOYMOnKO0FuEVNXE=w713-h632-no";
                        video_path = "https://media.giphy.com/media/1gPyMEAWqjHXQ3siW6/giphy.gif";
                        description = "-Codo fijo, brazo-tronco 90º\n-Antebrazo sube a la vertical, sin perder los 90º de codo\n-Espalda recta, piernas semiflex.\n-No balancearse";
                        muscle_zone = "upper-back";
                        hip_weight = "4/6/8/10/14";
                        res_weight ="2/4/6/8/12";
                        vol_weight = "6/8/10/12/16";
                        subclasses = "rot.ext.";
                        break;
                    case 101:
                        name = "V con Goma Elastica";
                        photo_path = "https://lh3.googleusercontent.com/6X_qX66o1yNI9Dv62rSvcw7E_xpbSlvLN_Z76OtMoYQZsj9j6cSaiU8S80mi62R9lqFMWOX7pCqxb4OxyX8g-UrpwWjmo4GJQkODYp5-UWL3estEyc7d9D_-fYNofJYVd5beaHg1nbKRLe28UvovKGq1RcMk4_HgmOPh3wUFd7DA_RaqiPCPoRKF6Sf2GyQhMiWoQTMcs2WnOwBioWa3L6OTVAGfTH_2L9ERFPmb2QP-YeVuQHkfibTZsQl3CF59-gHTL3Yns0P2Pzo0SnL69OlH3onqrDMb12ov37EtL-3LqzsXh3KkSK2817ibxhXbJFN7VdB22xVgSFy1TqiE6obZesWgAOqRcGqI9ygv2AM_-8tuuFGPLkqeiCmq0Ar9_6zypJdV2OyIRqPf2G8nDDx9UANy4WitYa0E_AeIJzNpzZyrOpYBPQURaKN2l6Zdh3xM34T-OIuEwIjp6QndJic4CJxNp24O9V7LBtwpJF58U_YNPnFCgZZVTpsafTrirsaSHkoeQRVvDRvXSbLeZ5huj56gTRZTd-ArazAFbTHZGqJU8b8Vif8-m0BZb2K4TmuENRA6Eia6oGF8WaelMdQTj6BaPzXChjHXbvgyFxZAmbMZqITkCFYoYRY5pXXPkZJC2_uzMwOFIMB_8wffn6e3z0fRvAZ3Or_wjsQsyumNwf7nZEj5_8b4=w713-h632-no";
                        video_path = "https://media.giphy.com/media/RKoK1LFOXbYZsM1MwH/giphy.gif";
                        description = "-Siempre: hombro 45º, codo 90º\n-Antebrazo sube rotando\n-Espalda recta, piernas semiflex.\n-No balanceo, bajada controlada\n-Peso/Nivel: color goma (elegir)";
                        muscle_zone = "upper-back";
                        hip_weight = "0/0/0/0/0";
                        res_weight ="0/0/0/0/0";
                        vol_weight = "0/0/0/0/0";
                        subclasses = "rot.ext.";
                        break;
                    case 102:
                        name = "Infraespinoso Goma Elastica";
                        photo_path = "https://lh3.googleusercontent.com/hB4dHmYd3bj8S8GuArEWDQf3PeoQ0NHkEvsak0deFHGKQ0PPADgONFz1FPIau--wa36ktJlCB-M5rfvy230jbDlnScpnxUkQdZTDwRGUxHLQF2t0ww-eGlCBFAYOedA9TL0iHYT0ggsi4P0r_HzOwhm73YKdNpLyDGKU_-gR1uRp5THMif6XD_kKx2BHA4EMqo99u-M1IBCSw2WBEL4m3WFspVp7O8GmRrDmr9OKSfc8e4eKSq23YM2Bve2DNVCDPkEgN07d0SXp51fjWDHp-isaVxFJvYuDo-xjRQ47kRu4egEuUQVzdVnUNjboY6R2s1Bl5t-qNUyK_FR8SZ64E5fuBIRRZzGl8Kc8ACcqBnkf6qRDKrAHnCc6Q-Gyh0PHb6b4Qy9zLQcakPhzNTWl7u17KorkIigLzDN6BaxM42kzWpL7HlHagpOCSLKaDQAk8vCJLabWPSJW-s8uqIUcMRWQJJDWZgGKYUN4vRNm0-N0ryH27FwGn-oqEGl2GnV-IwPlY1X8W0YK8lA6aFerQL8BWnzWO_ILA2eiS0xIy0IzAwTrFruRIO-m4OZEvU-bns_6A_9n8YulCWpza-MZkttGZbgLjmKwmmDDgNUgyapXVcPfaI9Wq4AuIZJWW09fyHCI8xBWuiq2xXkEGXDZYQWF0WUoKjFCE4FaV-d0XCCeP078Fk5-g6NQ=w713-h632-no";
                        video_path = "https://media.giphy.com/media/1gSpNbE1v5ULkNNXwL/giphy.gif";
                        description = "-Codo junto al tronco, codo 90º\n-De lado a la goma, estirar goma hacia el exterior\n-Vuelta controlada, sin tirones\n-Se mueve antebrazo, cuerpo firme\n-Nivel alto: +separación y goma +dura";
                        muscle_zone = "upper-back";
                        hip_weight = "0/0/0/0/0";
                        res_weight ="0/0/0/0/0";
                        vol_weight = "0/0/0/0/0";
                        subclasses = "rot.ext.";
                        break;
                    case 103:
                        name = "Subescapular Goma Elastica";
                        photo_path = "https://lh3.googleusercontent.com/OUXLEojbdLdTYpozHqm9LKv6yptF1TttYX4MrQkuKRaSbUNH9B3uhSLFbTr5u8MhRMJ616GTb6ERAzFJyqUUHVVmwXuL0pygIAL4zzAZc3C4hVctX0juE7bXJQFAM6I5x4HRrirF-GcfGJrTw7rwac3WwSXSDEWBwzcGW3PTRMOgDzaINhr0iUjaKOuPlvwW9qtlWAx6p286pfvsgFfVeqvTsE5aXR5otUp8v89rfDJbn0dJSnwoAGoRj2PAduzwkBus5BVWtXsn4-Mqy5mb2GW2J3sL_7TbemyIIj3oiOWigpGiAQXj9ZZ99CvbAHIGqAD9gQ_BIsLt0xcvUMJ7KUDx3ZsAyzMfzl7BMkORFbgMJJLuZdT82moCfQ2VibgB_8jxQ1h7UJ7WvT86ODRTKwEugcywfuous52bIgKORaOi-6NyhTwBDb6TjJbzMU2XGAghBz25eoWBou6RIsuplMY4p1N0mpix2pIE7JoypaGSIIvmnhL5sgiqAAhMYOztsp674Hbmm7IIg6mreS7Ulv9YLyLRpNjH59etI559qu2gN71ypWLMIGi73m0LJgmLTbno4T4AZ3SgMnuIXkQiXZ3abuZqg8HZP9gRs1vWiTO9Qy3syOIArZ8dsPjvpv3pMlLrimJfPF32TYR_yjFDziLTMkvn5BoqnVFBWSUf95QWMqClX1U8JRLe=w713-h632-no";
                        video_path = "https://media.giphy.com/media/9A34Cep8gjmptKTkqf/giphy.gif";
                        description = "-Hombro 90º codo 90º (inicio)\n-Ir a tocar la cadera contraria\n-Progresivo, vuelta controlada\n-Tensión inicial de goma, no balanceo\n-Nivel alto: +separación y goma +dura";
                        muscle_zone = "upper-back";
                        hip_weight = "0/0/0/0/0";
                        res_weight ="0/0/0/0/0";
                        vol_weight = "0/0/0/0/0";
                        subclasses = "rot.int.";
                        break;
                    case 104:
                        name = "Biceps TRX";
                        photo_path = "https://lh3.googleusercontent.com/hOoYRUW3TXgwrWKgtU0CWfcESQEkg__lowshrqX-OusGeyrDB2Wo_8RGF9nOKpiHeuE16DFoPPtApmAnx95VXhHL-dxpeVCNHrFMtP17Eq_EpYFwBN_-1u98rx4AoMDQMnko14AbdgpUG4e62yqEBn7DAKJQuxB5rKrD5k4WQYaaPqyFbtUZ-T-EWCcyDoaNO_EQS1D-EdcRO14NnWYeW7UFk1fLvnA_IfUMlIOpaTtoCMxncXEaiMxEtb5GloCSQHz5ziwtMueiIxkeeK4cX2vNb7hJ25O8892DVzMklZnzoNY8m_iVkpqm2-jVf7ObtAa_BxkCsizZNSIQ1RPh2zDrMo2eLJNIGAuhMC9fZC1XNFFNW0WYmWEhRZMcrn2nQAZtfh3ix2YRYMa57mpdVkjZAFWD8Zn_Huvul17CF4frgV1ktxLFophG86Heqrp88A95uVkvUrrsSYRazzDIQNcO8OdCXqNjSStlbOQg5lmGdFwNxYeOevsFeTvVGpXCypOFpVj61IANMPW5M4gcXAderwUW8snpcC9FGf3oVrj7uzyQRbKPbQOdiVz922zQ1pQ46NpZVJD2pDoOC7kEjaEkO5aL8FK1uZDt_eu44KiQ9K4FXpiFzjpathtZPcsR1rgqi3LGRejxE-v1EGNgZ0IR=w713-h632-no";
                        video_path = "https://media.giphy.com/media/mxw6MEQJ6gymq6A3gW/giphy.gif";
                        description = "-Mayor inclinación, mayor dificultad\n-Cuerpo bloqueado, rígido\n-Movimiento por flexión de codo solo\n-Manos a la cabeza, no bajar codo";
                        muscle_zone = "biceps";
                        hip_weight = "0/0/0/0/0";
                        res_weight ="0/0/0/0/0";
                        vol_weight = "0/0/0/0/0";
                        subclasses = "c.larga";
                        break;
                    case 105:
                        name = "Curl Concentrado Polea Alta";
                        photo_path = "https://lh3.googleusercontent.com/QvgZl-B8OV0NfBOtNne-SzeAvORfE2dNROVFdfOODhWDHDRwYXAS1NVOATPAtARZJJdkJMn3vLryPvqqqZ9NhH_sP-IThcIEmB7ak8iQdy1dKxgoU4H5nM8FCy4yBSeO8OjHh3VJOqVPZhB1QjT8dR5ISk0UspLWR3ID92PGbeN_sOC0s9AWi9uZM248c_y6i673CwZ1IdRiHqxbznR9Fc63w7CQj9nZDoan4SES2M5YdsH0v_4qI2nsSohKssERwvFUWHVWUuGSq4PR_85wKSgr0CsV1x1ATjR2tz7wIi8wvhYsxXGs1_aiEo4idkZE2uKVvTsxx9fkAG-UmrClLDKojJRGug9eX_dHiDGIFFNKeuJGGa_UJPLGff39vtn8fB7k-55-xyRSU9Wg-mIIrcT4eTHJRNuPx4SYDS-1PFILxhr7vnZZOtKElEW8yPzGptTqH84K4miG_Q_a8y5CetObsD4cBdJA5d7CpaiIaiDeMI858O8uIr2b80pWDl-AYWTHWDbqPSVZZpiZ3oxRe1L8vCW0Q9wrtrtVo-bN9tt6mt0St9cv88DXza37IlKKff0hJ9IMXzVll8LTPPKyi-gw3blDMVEyrmfxhp_zhUFI59VqdX4xs5iZtW4ckx2yvCXTFdTpMC1JGjan04yAlwvd=w713-h632-no";
                        video_path = "https://media.giphy.com/media/8FJsTdcvExMqCaBT0E/giphy.gif";
                        description = "-Piernas semiflex. o pie avanzado\n-Movimiento por flexión de codo solo\n-No bajar codo\n-Cuerpo rígido, evitar balanceos\n-Flexión más rápida, vuelta controlada";
                        muscle_zone = "biceps";
                        hip_weight = "15/20/25/30/35";
                        res_weight ="10/15/20/25/30";
                        vol_weight = "20/25/30/35/40";
                        subclasses = "c.corta";
                        break;
                    case 106:
                        name = "Biceps Curl Polea Barra";
                        photo_path = "https://lh3.googleusercontent.com/JyqeadFjt7hGejFSsx1fsPAvU6tPTEEkWVnu6pzmO5kkF3HWFrS7Vga9B1_bHhVxi3r2D3Xyl4mONFRooPD74kO28FpCvlu7QAXlZJXbUmdtWNvhds7VvsP9DoVMz6lmfUPXJ74W1AsbrV0VSJj63Xry-cZlMbAS31nAH274H8gDwc3RrzKa0dtGjEFuWHNDGSKBtuq6b_SA-eLtXKYe4cO1vpmM7Qi3NFs_lIcncZMcFYb1OmJ5Htmmjbddia2QekEXkRv-9gM1e7tq_jD8S8yGsbQeldxwjXfCOhNZGXReEfubrdVciuA-tdjqdblRMcrjcrfKdoUiXTkeIh35jM1tcLOzD6DdSlr0eHcS2KvLJPZx9r66HidXvwStaoJZSXdMkAl6MHdPROy5Omlj02K09fBRajdCW38eV_aRONMz2_WvokSWdD_jX3eJqA-aoSK4hy8ZUr5fEbXrE-Di0XzdWsvOuvVTkCwi8qc3qj0nLxKXSjkhOA8bf1PKmkJeen_aeKAogpR509y2Kr4g_GfjuVZTfBdkMHB5b9wFlgI2Et6RG5Kj2Ly8TeWShInqGI0HJKZxNrsww8jsLxEKQZFXuLF3jyolMX5lKd6dDq8tHXlG5_QPF5bA-claj9s-AYgPxGQDk9X-bxlnACLTU39f=w713-h632-no";
                        video_path = "https://media.giphy.com/media/fWgdQFSFuU3JZm75jF/giphy.gif";
                        description = "-Piernas semiflex.\n-Espalda recta, evito balanceos\n-Codo fijo\n-Movimiento completo, bajada controlada";
                        muscle_zone = "biceps";
                        hip_weight = "15/20/25/30/35";
                        res_weight ="10/15/20/25/30";
                        vol_weight = "20/25/30/35/40";
                        subclasses = "c.larga";
                        break;
                    case 107:
                        name = "Biceps Curl Inclinado";
                        photo_path = "https://lh3.googleusercontent.com/sVgVoAAVBorz5w0koJCIwaHtVsZRbx6uhm2hDz7WXKg23GKiO21eKn11OFmd2fmOJ0S3aT-8VB3f0GKM25D5t2QY3CC8AuKFkpqNNwhmgncbgJ84QohNRdO3FATQEYAIJy4s4G0ovB7xdcClIg7_Fm-hTNi3-3qmDcSRQQRMrkYu4MIj_ESsA_XmA9b8qbC4wHU5VAyRT1kIPZpR7ChTGrpNMk_UyaUw2acmk0id1hUG7OWS7JD-_4ZjTNWJmu_7r0HDr5CwWP9xkiP01kxwcG7ERWszhfiek8hDjGJXdBoAtuChSC30lIHp8GlVbPKuYPJac_G0jc4D6LZ_nP15SQHn-yRwcccyLn4Cmk7y1jZbnG2GxMX2RkPF6d3LQnn6UKkA8VPQ5YoqZeBK8Y8HvAKiOlAKy5WR77-gjaBxFbPQvLkIzH-jv1pdwaf90DTh9Z5z3WAZTOv-Xzt121Mpqyjxx6v_pIvRp3uTYnEraxqu-StbZUkpXFHGw_8sq280PFy4MEMnnZoKgOGAzGtcR9jPIssbSbEmooe9Pq4Khh3HpA9nzDVE1VErTkWBdlR8ZjwXkk1TGg8Xehsig9sQ7yQTFiiR-wdNZQXLI1hKvsZZAmXW05DkXKw9jOX37sj-PdfTPb9T4fHA6I2W0qpgW-L7ncnADH20X5t8GxXPafg4V7jlxXieYhA=w713-h632-no";
                        video_path = "https://media.giphy.com/media/Zv9uPsqqBpYdzHDBWV/giphy.gif";
                        description = "-Banco inclinado 45º\n-Agarre supino\n-Cuerpo posición cómoda\n-Codo fijo\n-Bajada controlada";
                        muscle_zone = "biceps";
                        hip_weight = "6/8/12/14/18";
                        res_weight ="4/6/10/12/16";
                        vol_weight = "8/10/14/16/20";
                        subclasses = "c.larga";
                        break;
                    case 108:
                        name = "Abs Declinado";
                        photo_path = "https://lh3.googleusercontent.com/xIVXCHXw5jP9EVbjN6GQPZsQlowTO0ovms6ZcFVL8NsxU-vkKt3ZTHSMJbX3hEVE2UiLUPGuh2NDdN8wwr-PcwmhcJQsL7jkbelhfbWwSXGQwJs_q02jJW2ElQidvtvmhIOpBuW5_r8i2bGZibzEUxcV-2nB4vAscflOHDywiP9_hBKjAGFBro8e1td7_yT3ET--N_AgT03OREdhwTShJKrjQYJEmWcSWrRzXMYCHXGjWBGr17idk3QQYQ0c1kR0ElRAygidujbWkRl97FGp0IVojl7iohCP56AHglxMIca2SeZarl9V5lrWxR9M288zO4K5fk2CGhvITtUi5jnCP4PCxzv_wmLDNuD1lTdPmBQ3FLzQAlQYbthe_zwjDNlbdW5FnwxW0bQLMt9KM7dhrQ-9UK2L9j7_asLZcd4rvGdPnmERAU0uscxBNXqFpW1wzKXsT8kYNPgV4DwBiOT2GJm-m_FO1uba_g5QzQlN2pqMDf2PvFpnAa7NvAAILnOKL4tuEW8TimDExcxUiPZGSu7bQyHkg-pVRIlQQ-YfA00vDWqEId-sXQ_E3HqcC33wIn4896CVxJne2bcufo91fWNlrEbMIQE6Qre0ByBZo9WIKZc9Kgfe-KrVIMy_4g7zIBpRKux2BpWjOOEXPfXwnZ0o=w713-h632-no";
                        video_path = "https://media.giphy.com/media/2A60mcadGXJKxaMGZq/giphy.gif";
                        description = "-Peso en pecho\n-Espalda recta\n-No doblo hacia fuera lumbar\n-Bajada controlada\n-Barbilla hacia pecho (ligeramente)";
                        muscle_zone = "abs";
                        hip_weight = "0/2.5/5/10/15";
                        res_weight ="0/0/2.5/5/10";
                        vol_weight = "2.5/5/10/15/20";
                        reps_obj = "18 rep/24 rep/12 rep";
                        subclasses = "superior";
                        break;
                    case 109:
                        name = "Abs Declinado con Giro";
                        photo_path = "https://lh3.googleusercontent.com/yE5LmY-4GPa4HfOCThApecdt3p3gh49dQCMBoeb28ac5sANpM7vmudhVVFuP_qmZQ39SStMZ_IhK7PFFAmwFSTbR8LF7gjZw7m9-yNH1IsHZdaHjDwpkwhLFv6lQr9sMUd8p-zii2zphspNbag4QnoFkBi3TdTXnYxDzWifcuYLujChyYjALMXyfieJb4teXHTYE_BhKzus7dfLiWTQbkSrcdB74RQxsCPFWcT1hNkKQO0p27TnjyRAxwBW89chjNcYGu77-1c_vWjiAA1uY57HKd8yzeNw7DQuzxFoPy_uxnjiTxh_ICViTfYyV-yqMQYSMsbGrNFwRFVYJNX6NrHHsaGBIdD7x9H4irVQxuMpzLF7QIlp3T5PRKGbtVm0NP4OL6nQSY7IHVfuggmhR6O563V_-xtQ4fSh_U9IC47OOXEO0uu0zdgO-N56mGIgNxMh_ZwI7IZS23DtQp3m4769F9DBy_IurhbrUl3NZ_Ofez8ZqHaHMByMDMR0WMAjjOzD72Sm4ReBmy-COj-_1XdH7Q__XAmsZO3rYNAwJXWLs6LvaDYgqanivte-L60B0zlOyss85Y2R-B-CK7qYfK1WVEm6xdcbADCi6CQLAxQMgPaSDH3NhtdC3k2ez4m3kexbykFCgU7j3md0pf81y9LbA=w713-h632-no";
                        video_path = "https://media.giphy.com/media/9DrmXHaTo0ahiG1Mo5/giphy.gif";
                        description = "-Espalda recta, doblo al final solo\n-Voy alternando lados\n-Barbilla hacia pecho (ligeramente)\n-Bajada controlada";
                        muscle_zone = "abs";
                        hip_weight = "1.25/1.25/2.5/5/10";
                        res_weight ="1/1/1.25/2.5/5";
                        vol_weight = "2.5/2.5/5/10/15";
                        reps_obj = "18 rep/24 rep/12 rep";
                        subclasses = "oblicuos";
                        break;
                    case 110:
                        name = "Abs Invertidas Banco Declinado";
                        photo_path = "https://lh3.googleusercontent.com/hrWKlidGfvXA2nd5cDRTwIQNjfEJ18v-JJYzTqgY3jYnoFHvheZLIl0fHU144KYiBnR5Mp_rg7ldcl0Os3UZ-AUazhDP-KMeQfrJM7Cu7IiPEU6H7ShfEHdL9AbXM9mOi2N6_fUujO3VoHJOlB-lhGeN1OorPmF7Qf-wkzFZnFgtnedt2LgjH1mRMm9q9jQNqtAvA9rsIlDp8BNINxO-IlCcTYcjbH38gDGtRM4sb7YIgoPfYUXnRfikJLPLA1TzpLXkEKzRdQlhHA9ejXICGe1J0lPHeZqc9HtI2FkrZ2Jo0pwTkiTsd0K3x7BtxHLfy_jpBPfTofz8c7V2dJXyQ8JxxxO6CxoJDbPD3tepu5LsdvjOIgkPitJKgXcl7ywAYYmDImDvWG_rLyyBfD3LS7UVjHDDdXoOo8d7LvS8syaI978gLv0zPRsaEpRfcvyfJm50VqOyev3CXX49DEgQUwki5G1JOm9ljZuwTEd1ipFv1Oap4GM5QIlIDPrRquRmDJdEVJSP9HziFIxAxlmO307BoFNHwLrdUxuQTs63snBw3ge6qKKpEpR1XST8wJJIbjIPhogiAUg39O3gqmwLcj9x7WS0R_9VpS0fT_Mls2WvIdic7ftV2R4nvaq_xXnSE-RqA7Rhza_lhrHXVdwD4II3=w713-h632-no";
                        video_path = "https://media.giphy.com/media/PP3sY8NqawBgQuaT7l/giphy.gif";
                        description = "-Subida de cadera\n-Pies acompañan solo\n-Bajada controlada\n-Flexión progresiva (de abajo arriba)\n-Vuelta progresiva (de arriba abajo)";
                        muscle_zone = "abs";
                        hip_weight = "0/0/2/4/6";
                        res_weight ="0/0/0/2/4";
                        vol_weight = "2/2/4/6/8";
                        reps_obj = "18 rep/24 rep/12 rep";
                        subclasses = "inferior";
                        break;
                    case 111:
                        name = "Giro Bola";
                        photo_path = "https://lh3.googleusercontent.com/N_kAexHmDeMtuuNkVlekXlPGvPbUh-MJSXyvmmXSvheOT1jMC5QnjOhuxONo9KY2hKjT2W7QPNnLPcoMki3w-gjwZCtcUFC-7BblfOJRBhSpVvKzL_Mukbk1rkUcbAlgsJAcxqVB8p_wer_gCdsUUwSBSOntImJMywo39Gb3LEc5OAXcvGXW58_hnPxX4W1NWuVYZGncSEWYehUXQmf3EbmTPGU5ZXC8Ki_rNxQEb3sFnYI0G42MEo3m5PGGuomTzo1Lfs-Zd8a6ladjpIn3VZF1w-PlEeRwr_BhX8W73YUqZLrNy2I-ZxQXcFADnnBj0cZCJ5BvfvZHc05ndc5bPiR0cW7b3forz3gi-4m8G8ihSzAeZBBP4rnQRa_J0-Gc4G0mxbx7SmVcx_0mgaOTQw6_OojvixdQCMWn1zauCVvE9OobKrDs4U89e2tWDG7LJnN2AZpEgRVPUJVryBqgDV38FwmLtJBem-BxW7B0P5PHr7FT3mBc43ZoP4y7Ddh4uHHC3E6vyjh-Z9lhDcor4oYgpnIpvI0arxi2puKKw1wIgoZUtKsI8nyHkN6PeHcg2BvwtD-zGXZmcCOWgHRB5Lbi1cecFknO2Lk5rXJHyENK3Zv3eJPJ7CGJZxCS0Osy8UJBYWOLXxnq9AJZc3cjEkxw=w713-h632-no";
                        video_path = "https://media.giphy.com/media/61VQ740tYI7DcZ28F6/giphy.gif";
                        description = "-Tronco muslo en V (pose fija)\n-No saco lumbar hacia fuera\n-Rotación de tronco (superior)\n-A tocar suelo con pelota\n-Movimiento controlado";
                        muscle_zone = "abs";
                        hip_weight = "3/3/5/5/10";
                        res_weight ="1.25/1.25/3/3/5";
                        vol_weight = "5/5/10/10/15";
                        reps_obj = "50 seg/1min 15s/30 seg";
                        subclasses = "isom.lat.";
                        break;
                    case 112:
                        name = "Abs Peso Sobre Cabeza";
                        photo_path = "https://lh3.googleusercontent.com/trbtH5qqnZ7F-VCDDXZyvds55LrHfVL94xTeff58WsNfi-bm9EsrJwouEVHtwmpQaKyYbPExU5ho2cMTx9F_EtR8bdS4dmIs9VTZfGLVXiF-elBUYBXdkTZK6Lad13Vb-ze0qDoFbQJxL55OByG3mdad5ZaAgqnzTc9a-AzKoAhNG_EOI9SZ7Hp8U6aV5jXmTHyBRdEr8gv1thVWm0ze-yRe1N6RFjqEEgbLqIyD67-u4JpFKuG8hCSgnurOr2z8q_lDFEwBhME2Wu7QQ0Oepi0adMVtCu05Ft9I1l5gKm2Ue-u0DDxVmYYacQEMxAmtiSYF0NrfAFuL0-UXzbNe1UBzMJ0bI7Qrw9T7IwpbP-IDZzBfynlTI5UHqflWb9hxX1ydC60ZlVUBe3zTYl58oJ6aahTkr4F3ja_zswyeKEO3NnZvrQ6JmkhdyJujwDZ9PNugiWS1h3FCXGT6erK751TW_CRMyc0ebfL46pH7bwwwGH0r7cXS7H54WUHS_Ulz6iw_toqLMlQTlhqFaQ15oRSmF-bCeWkEjBHTJbR6iyCnfcWCNJ27wjyBRI-2o27ePHPDnUGUXk-fzeKIF-eSpK5Et7mzPw9B7ipSMpKNKDrry-VYkypfmO-3nHx2pbjRy4I-k4Qg6gkZMmFrI1RGfcOf=w713-h632-no";
                        video_path = "https://media.giphy.com/media/fteghURwSXnjqj9ZoG/giphy.gif";
                        description = "-Pelota en la frente\n-La subo-bajo arriba\n-Estiro-acorto brazos tumbado también\n-Espalda recta, no saco lumbar";
                        muscle_zone = "abs";
                        hip_weight = "3/3/5/5/10";
                        res_weight ="1.25/1.25/3/3/5";
                        vol_weight = "5/5/10/10/15";
                        reps_obj = "18 rep/24 rep/12 rep";
                        subclasses = "superior";
                        break;
                    case 113:
                        name = "Cruces Polea Baja";
                        photo_path = "https://lh3.googleusercontent.com/WdM0d0FzUuGPzpnxCu7ZiQwDqIdO4r3hBWzMyy5dwnIOaNsUq-wi2Q_wKyPEf17zXjrur69ExoQIKuTxQ0jrw9wYLtaDEZPK808RcJI_gAbu9ofo7VEuGNJ3ESuCDSawrUapaWBbawbRMQD81101APgOzqCQRu6u6yeI-yfelO0oO-s_lLHXo-SivMIJG4qb1UN5nA9bR2JNGR9K75fVcgd4SWcM4bqoXqvt_uYaU5ZYrjY4U6ZM6jxIYifoLmxOuecm3_IZmQHh4RJMAEmCBn_WO7VnIaQfwN3WbEN5c-7YgwpyfSZMsU545cgIncYEZ4r18K8jydqmKKJiOioZTxym2a1KSwQZyTYrcvwa8dG8bHq9LeZXmbuD3cYiZ5X2d58eeyezzwuGs2iE8zcU_rwP3gB4fDtwiaW54XcqGKbCNVlgSrhebz2jODTpwDwpvMPiVrur5WunhDPwhWIcfd5hSzLraNpB8d9Fj1KeEU8o7mSAKSypWo8wK4BrTFxKcgdgAKVAsaF8uX8gggvZ88f4eLV25fL0Ezb2HAAqzyFIiQsJAfyKw4fXnt3e1lQziPl-0h4L4Hct50O9FWERxBBvAPO4VaHN4cU3juQqD8dFfCPwzuvkZnT0myr9B2sUsoJE0spsb9pqg0AKaiVItUB1=w713-h632-no";
                        video_path = "https://media.giphy.com/media/7E2rsOxLJ3K9zo5qMV/giphy.gif";
                        description = "-No doblo codos\n-Pie adelantado o piernas semiflex.\n-Evito balanceos\n-Llego al cruce de brazos\n-Bajada controlada";
                        muscle_zone = "chest";
                        hip_weight = "10/12.5/15/17.5/22.5";
                        res_weight ="7.5/10/12.5/15/20";
                        vol_weight = "12.5/15/17.5/20/25";
                        subclasses = "superior";
                        break;
                    case 114:
                        name = "Maquina Pectoral Superior";
                        photo_path = "https://lh3.googleusercontent.com/iEGQvYIpKb0o-TnM9NRxCk07661dqgyie_uRYhu65i1ZdXBqYcdoWS9iyh-G4MMEObjyr-scXrrcSyVV4hccQYYHpJr4UEYNBJDvgHwji8znqJFRDHTqDDAuMbKthmYiQdKSZ2Rc4X813Mw5mRCjg6misRei-Th1HAuDC020XTOBZsnHD5-Ls8dqy_kBvMNyTfX6-nm589W7ds1PIRgN7pKB-GHrLzCNEi-87pEbG4wgyz7XsEnnBPFhIUu8m7Zbz_YgULt50hJ6zRE3dPE-ZbfdcDDUq7W6QgDXpLgsZ1FWR-o99CHact6FfTPMC1BzEEs30XXkpIeAdF74rctvc_RQHSnP8bOUlWCWGwAAYqmiA7Q2UUpTf0mPF8UkNYQN3oyy_MATwExhty3fdh4kxXfWQuC9wi_5D35SUFQ7cnYFeGlM4Gf7x81Z5iovbyHbyk9VwH105YnS8SHcel3-uhKv2RZRjAJZS2PFnafVsKclXLwBADKP1LzqNnD5_R_uCg_7npvqwTTE8rKjlQoSFS4PRVJaiciDOgcrWC7GWmLV1XjVEgQgdcZQnibS1e9aVBTH0xQzOdlyEN89TQGzSZ459REB1fHgtD2-4dD0udbmxQG7O2jKulwR4ztcVhpvrY41p0ICNhQdO5blfGelXW5D=w713-h632-no";
                        video_path = "https://media.giphy.com/media/TgIYDZOBGtrwAzBsFx/giphy.gif";
                        description = "-Hago el movimiento completo\n-Ajustar máquina, posición cómoda\n-Subida rápida, bajada controlada";
                        muscle_zone = "chest";
                        hip_weight = "40/50/70/80/90";
                        res_weight ="30/40/60/70/80";
                        vol_weight = "50/60/80/90/100";
                        subclasses = "superior";
                        break;
                    case 115:
                        name = "Flexiones TRX";
                        photo_path = "https://lh3.googleusercontent.com/Vqkrw4zP3upLa7BB__vTI4s1t2H1pR5X6pyXXxb4pznEwcHRtdg4Rk86GJog8_d5hV1gWlmsbfEIkoSH2SjzAQsS-Ue50pR9knQ7q8R078LQUZUskdB3lUrMzb4t1I_hDsgzVX_xsjv6BCJiTfepeKTjI7t6IUDzCVKAicIm8zdj9OKLvt6ITbABvyIyKkKjELMzqmGpMIxl0NvX-n7ll9Ye9tTW5X2D8SjzH8E83xZZ18DEU3Fb_x_vVUIfiWhPNJP4bBRy8_8DGE6z0X9lTJTQ94zpXdvW4TbrMYhfCpdOVSifNDEkoLyJ2-T06JoyRHtTMWULgW1Z1P_T9VQ64TjJmNog7ArAM4bimowENQULj3LaL-xz3-uD5_s01DS4reOtdQzUK0kkYZtQNsJm-XjQR9ZyDKWdj3XbxrF31QGB1sdXzImfDUzdDJTMTWKFpHLsAOOVndYUV3fBszJFNPOjWD9JYSNvNL6yUTKUndY0fxqm4ruwnleiOHecrpa2yL3Pofi8-RxWAlWb4rRgkRWz_uH-srvDbR3eiSMaJznStKstoHE61SbplX41MS-WbheF5uePGqEzZ1qPvlPh0HQHz_MwBRRjG2JHWbPR_sPI4y4fq6GJ_jX69xsXUxYWl7ZbtX0xA-PQzTSRYMqUAwOv=w713-h632-no";
                        video_path = "https://media.giphy.com/media/oxYnbMISU4JiLFxuDq/giphy.gif";
                        description = "-";
                        muscle_zone = "chest";
                        level = "hard";
                        hip_weight = "0/0/5/5/10";
                        res_weight ="0/0/2.5/2.5/5";
                        vol_weight = "5/5/10/10/15";
                        subclasses = "med.-inf.";
                        break;
                    case 116:
                        name = "Press 45º Mancuernas";
                        photo_path = "https://lh3.googleusercontent.com/jKub1XesxZ9SDX05yHDurq3MQSnrJk5eS2RPtr4j1zLxaqHqHYcUFUZd_SbQ2-IiTowWTACvoo1bfJvyMzyDUShheODev46HH4YeT51DGbQjIAzFHmtqm8gxZLQLUscZRoc1ADl6i5BoYgqVX1tUyryofgICBgSJgyXNYLXAPU4yiiaWHSyw_x4yNPN6GWMUJtqTFwrNd1TupV6ZEwamAtx9YLT5pkT-MPaxgbQlVuqJY_eBW1dLp0nySAI2uG2fQ31iEDpryU7v2dIrEL5u1wu2ARoEjXSAHxsSHgqRuHha8vuVgpJ8Uq3x65p8ij0dFLH-oYhiw7Qywl2yI7VVdDvJtbjyRwEq5EMAKHCAwYRypxBRjTyG_SqIMgvVgsBBr6ichq1kWDmmxhUh_AJultPTSYfp4vkjUKfAghDewFwL1X81qj_cURmOP8eT_KmjrUGM4bWPxAPNUAwqHk_1_6EtPnxhMXoB8Rxvqt-Q_FkULUI6C4YRPUTshETndQv_cCsCuXAdg1Y68zLgMsul4wSH5StwSjrHfZUPdvrlRVVHgrfwxlT8K9Jr52prIVVMDcL1BziVcyAQGb7lfUhgu1XRalb2VLdkP0wX3pd5sXSf5W682Hqt1VqmD9I92ZNzf26BbZkX1KH_O9bTrhDX59v2=w713-h632-no";
                        video_path = "https://media.giphy.com/media/V9QhTjEQbBySzbJQ6w/giphy.gif";
                        description = "-Banco 45º\n-Mancuernas a la altura del pecho\n-Codos cómodos al lado (inicio)\n-Subida perpendicular al suelo\n-Movimiento completo";
                        muscle_zone = "chest";
                        hip_weight = "10/14/16/18/22";
                        res_weight ="8/12/14/16/18";
                        vol_weight = "12/16/18/20/26";
                        subclasses = "superior";
                        break;
                    case 117:
                        name = "Maquina Hombros con Codos";
                        photo_path = "https://lh3.googleusercontent.com/-_GTiHZEoQ9sYwdmeksfjBsoBivKtR1Hnc07j0OXXrGYzjhtdiR7mfiFMHPA0dgtxHHcqKTQTewvqaMylmYFE4hG_YD3A9kNL4SavaUdKEsITwuXpx4wlt366DljAra_4MNYvAapR9eq3kybtRwmtpvoZZGFK_RLFXDoimi4dalyfbHvab0n_6gbX9630uTlyTc49l8C5IULMnUjp74R6b5eeON9Wvl-hqXeOIxfOUZPK1Pk3x2PwH12tEyGebrVJ2jGeCBt5FkflBrtpiqMPxQhAggVBE67c4h5Ystfu7-SIxnYp7tadhJyM51usaF6x8ME1bu3eblaId6UEXkguQqAt6iWpRAe4F82CTaiJy0DxrwqmA1zJ6wk2WBiy00l2GrS4odJ81Bi65r3xftYqyBioZDIoydTK4VTRpSsT2Dq0ASZHhoMaeVDLUuMst3xl5VNm7-dTObfBqmGUGG91uFoi-ooDusO58h1oWlMHRtowxLBoq71edeviF-hAfYP1v7qopivKTTUo9qt0tgcpQhhA0VcwbrFBcNsiBAqKvUT3cyF7tX9JSOKTPXZXaGJ_znphfrUFcV_cJgnT4k1n5D5paKYVXbLiPPNtez8uFq-dFN7jvJSCAs_NjiUbFp5WP0x9dGBi0NG41ZJ2nyLAotY=w713-h632-no";
                        video_path = "https://media.giphy.com/media/2bWSeoXmRSUwxjw00z/giphy.gif";
                        description = "-Ajustar máquina, posición cómoda\n-Movimiento completo, sin forzar\n-Subida más rápida, bajada controlada\n-Brazos sincronizados";
                        muscle_zone = "deltoid";
                        hip_weight = "20/25/35/40/45";
                        res_weight ="15/20/30/35/40";
                        vol_weight = "25/30/40/45/50";
                        subclasses = "medio";
                        break;
                    case 118:
                        name = "Fly Reverso Inclinado";
                        photo_path = "https://lh3.googleusercontent.com/1GpPkX7HeZfdoxFrXRxPIc1ORBJsV028uEV1vBYrSU1EMAEpWVDTYbuJGrmxgGY6SYPq-tHXkrmkost51Hkgqb6Ce8HTHAeYHfETiPCDtclsAX5eGf8auLqZUl3tiJXr188-ZQDBbwsem3lXFWU50ZUJmIZYylzXyqmzcu6KGAZY0T39Ay8-el01PjEMm3SzLxE8dh2dF5oRNEhRTwznwGKuLrJjKmpCI0DkTRT--F6J1awb_NiJJR9IuxOhsbnagC2nx1_w88FWEviA5s9rBv3PVEt5Zvp1O8GpOuW7vvn-bQmjP6gDXPSUueWT6bSunZcU61b_W8vNmAHMpsDHXiOpPu3Ewx2g59Z31VyA3Yx5sPcqvIvyLE5YTXIvyYlX5JCApSok0kdZgyToj4whG3oboUlMzWgOPIEheO3q_5gJiCO_k1dVjPAXlTco5JhRiPtCkYkU4GbqpH2laItO2ntTNfSy-G9AIjyhydWFYyfPfXTbFMXYPHdEuAUf3Q28K_m92UBXgr_9Z1PKUDPMTfKcCqpwMXKIMk2P9VUrENXFyBCh2-cXjhn3SeixDOWeKv64aN7LMPTbj0W6K1-TOJ_NSQrmDmMBb_XA76_g6q59gjk6AWgKwK5LOkMk1lM3dbE3ZSjCfZW__rDX2nzUdUSm=w713-h632-no";
                        video_path = "https://media.giphy.com/media/5vUSFFWKQA3j5hSAF5/giphy.gif";
                        description = "-Banco inclinado 45º aprox.\n-Posición cómoda sobre este\n-No doblar más codo en el movimiento\n-Amplitud de movimiento, sin forzar\n-El peso es de una mancuerna";
                        muscle_zone = "deltoid";
                        hip_weight = "4/6/8/10/14";
                        res_weight ="3/4/6/8/12";
                        vol_weight = "6/8/10/12/16";
                        subclasses = "posterior";
                        break;
                    case 119:
                        name = "Press Militar Barra Sentado";
                        photo_path = "https://lh3.googleusercontent.com/vJMENReIm3Ym0iOUK5HutTctyH9chKJZr-aXOD0QhEfbQCqBzZVEoV3DJYWC95yVzXD7cy8E3N6-GhARJLVvYDCusYKveqMvsfkiPpQjHXuUqWVTgVsMVyHHft_s0YqwOSJ0XyIckjDXgzMdBMZW35HLGxNZ-a92xGDEaH20CzAOpg63Eh7nGSr7nY4XdWSCeCAD_BZBGhfUTb3e7fD6fHiunG9vlz8nVeIrHKcyyHAOZUHM6ybFme1dOKP6vTSPqno6mB1i1BceXl6cNehDoGZkZ2j_ivmR8T9Ikieap6zmYuQU-6YxB9YZuynoGxRBXYJ-pAgoAbijmoxnHI5tPFTcM4NWso7rXdjGrDtc3xYxf243TdY1PjllPyJRRrf0xyWTIZtLe_Vj5-Jjz2PTzz-lVocektLYnigealcbJAFcdeFnmh8ex2y-sQ_k_pEh_9lVWZSFaItLRR4WLkljHnW2ssQPs_jwcuCE8cfNlm7LUtaZGSfT0Ll9-97lJcx40pITBRmZwtFIGZqrFmGUf12eiv2dQk-2g4r8HBJUKbTyRXeVHCAEXQd74objlGf3kG5KJTHptG5xE5v91is7FqjcSlWBJJiisLMGLXWE8hhoJpL898nfeWoBxdlTZzKgil_l9litrAX_lZ16ekWERo3l=w713-h632-no";
                        video_path = "https://media.giphy.com/media/xFkh0qh9GjLnaxg2Oh/giphy.gif";
                        description = "-Banco para posición de sentado\n-Barra casi sobre pecho sube vertical\n-Pasa cerca de la cabeza, sin tocar\n-Evitar retracciones de cabeza\n-El peso son los discos";
                        muscle_zone = "deltoid";
                        hip_weight = "10/15/25/30/40";
                        res_weight ="5/10/20/25/35";
                        vol_weight = "15/20/30/35/45";
                        subclasses = "anterior";
                        break;
                    case 120:
                        name = "Push Press con Mancuernas";
                        photo_path = "https://lh3.googleusercontent.com/z16H2L-tUv8sMTRr2xikCHiUltWcdv-LpwM058v6XB5mQ_RYGrmgUj7odwBL8OE5rDF1ZvBI4G4Dk2_78Pu9mS67Eg7thpipZ0UhhbU4-cpOAe1Ty1Oulcj0pDadBLby4Yqp_Jb3S7ZC-mfFdFhiXmWHN97To0970rfpJb0uQ_u1h9Z1PLZe_k0CeCZTe0Y_F6oYDj-cXhyM8tnqGp3agDzvcy9qkb1vtylgPn3496Pt0R_C_4xn9omzSLhcMeuGBiaPW4KisY0luL-bxQEyu1610Hpi80MCWNmnjD-xQRwyniONEm_5gIDiL88ochX1BB-3bSaZHQZ4LUk14wjc-gReTc83JG-fWr98D3Stc-MNGQkazo7Pt722fnbb3ymrnTA9XLh8iT0X3lluYzczBcVqb5j4uOIo-y1NQYaVVPN5QyxKgOFRHf2U8BYjkpk1bzgp8APO_Cr3YUO1-BHtMOgl2ytNOUWqn6EJ4csSLhCzBlWJjritH2QdVrtFDdpcciiXvM0sF_2NzYOb6F1t2E85p-QWDhLzOuWHGgUsaujJEWIuym3-NKte4FcTbbWex98sJtjLOSpAhbVWf66Au4KXyLOcM31JVgpsvIg92oZBAJmTp3dL6jJO4VF512_MgBr8fu6VyLj2F9lL47mSnWu2=w713-h632-no";
                        video_path = "https://media.giphy.com/media/BpDPkqQDNz8xB8l3AI/giphy.gif";
                        description = "-Piernas semiflex. o pie adelantado\n-Espalda recta, evito balanceo\n-Mancuerna a la altura del hombro\n-Subida vertical\n-Amplitud de movimiento";
                        muscle_zone = "deltoid";
                        hip_weight = "6/8/12/14/18";
                        res_weight ="4/6/10/12/16";
                        vol_weight = "8/10/14/16/20";
                        subclasses = "anterior";
                        break;
                    case 121:
                        name = "Elevacion de punteras ";
                        photo_path = "https://lh3.googleusercontent.com/bKR4aVEBg6-698SCpYedqqX8lW15QFyqCNg9s98i3AKjcYP4K0rnaPV2whhkcrpQAuoqreDWKEgLivibkA3bjGPlpeMB7kD1UNkHKGZmDOtxRgls0dQBRfzcJyhj7wjy2lrtyZzTjFEpkIrW30tM6pbwU7349SRdWwCjaWIzSkOp2o7CdlUaxA_7ps7J_BsrqnMQ6DjdXvQNBxJliYij0mAgBRo5Yi1g6X54NdsbBdd9pNaN3Dh_8JKGPgmuIIJbdYRl1I26kq1zbOOsS4S5iXMEhQarvx_6mSsZzzv5HyIcKzuR4S2Vura9kQABwYdefEw0dR0cfyndBjH7gSO438rpPgeCMoMr6u-BD0eRJljamt9hgn2mtjQxaCmKR0gD0SrYB8HYziFIlQgROIkg80p06RPAC04UTRfALs3nlpprWfELQaPdfelD34UUVDICXuqyIpporf_KFOlHHSMtFDS4hl8LG27sPlAleqgx7TvfBOrum4NIUpC-5OyC1sBsKgE2v5762YCgR1UKU4tB5GPnP8vZyuKSvSQyAjvNgk_oPiQtuUDKcMKDZSOspikMnzPY1kyKonfglNT61EnhHS7uEjTKpI0A-p7HsjjSgKQNFpvYE0XI28sw6tlp_pwRMpXTVeVMeRy8Vpl5rNkrsT4D=w713-h632-no";
                        video_path = "https://media.giphy.com/media/igGDYnbdf590kutIgk/giphy.gif";
                        description = "-Punteras encima de un disco\n-Talones no tocan al suelo\n-No doblo rodillas, espalda recta\n-Amplitud y control de movimiento\n-Usar acolchado en barra";
                        muscle_zone = "calf";
                        hip_weight = "30/40/50/60/70";
                        res_weight ="20/30/40/50/60";
                        vol_weight = "40/50/60/70/80";
                        subclasses = "gemelo";
                        break;
                    case 122:
                        name = "Box Jump";
                        photo_path = "https://lh3.googleusercontent.com/tv_cTmPlVWga08kBmdjiRrLoOe0Ktvms828GRX88BXntNbhzrEo-EC3iVil-U6Hd8MVdHaOk8Ez7fwidjMy2uuO7DHpROTzg6bQFkHhtb2Bp7vx5jfprWBGpaX8Qh6R5oZjGn5LjP7LxDTsAJVTAl7iP5rq_JLz8FJTQh9CmBCStT3_72OIhCuuncuSBGvIdurKhhg5MSw_xOJjp75t3u2gMc74C-qlzuhhnn2eziKHE44mzBEHbj1dhERNx6en5mnpqnNnolYOjBjbdTjrjX6ZTRJ3uwcM13J-CJGC89cUFjd2vMU6_7LARm4XIwngwfRB0Wzj5h6rAeYvS-wS46V2krm8Rq_N6irarjgasbL1qmjMkrfF2pTOheycWxh2CgJKlxPkEWRwD8IExeUGKNj8n2KWyIEVILxeBEq07WmAAXgYT-bgneqrI3lx-LE8HD_J12VDDw75m6b6h7CD9PxL2-iaAlWtQAKr6h7MEIJSey2JyvTbE5su-2IGjd_QX95bq5-GB3kO8FCdBPBfrS1E3ucjVbOPc2-cCZdltkbFb-g-gCPxe--rnZmoN1RJZFJ4ZSmwmWcE7jcD6Bzdq0-seDEHltOwVTGnveUjDiML3HmF5nHk5bWxhYfGEid-wekMv-j2JxGsNJA6SlhdQ1Yr6=w713-h632-no";
                        video_path = "https://media.giphy.com/media/3ohbdTPkVZ6rNwU3eA/giphy.gif";
                        description = "-Salto encima\n-Vuelvo por salto atrás (no caída)\n-Peso=suma de lastre en pies\n-No desplazo caja\n-Jugar con la altura (más dificultad)";
                        muscle_zone = "calf";
                        hip_weight = "0/0/2/2/4";
                        res_weight ="0/0/0/0/2";
                        vol_weight = "2/2/4/4/6";
                        subclasses = "soleo";
                        break;
                    case 123:
                        name = "Maq. Press Ext. Gemelo";
                        photo_path = "https://lh3.googleusercontent.com/tG1uBjqWcKOQOR7HSE00D-vpZeQSYMyTbyMb5ibV2fKyL7HgX7WDLRRxrRwQs_lu74yjXrnYhMb9BVRYPuBEu4hoZqn7sdKPL9qVuiMWDIH1_h5MnbrCUrnTMYPbdeqOoMsXNAcNUk8P9LHjTfrDUbFlj8xzqEygFnRs1FJ7lFekFu1IEBTaIDRb-ZXp4Ux_9RNaqu0wJfrkoq5tf7fJcl7WyKzFshA8HFlHxz2QSIbfbPVZy9N8DRl5fF6PaNqKY23TfOd2MtmzS3NEJg_EBVoudtWq52Ly-ab0zzjWvXv8ifVGKtPN0OaVGjofslFPafddFAOM8ukseM19iQUnRa9hGPaGeIw1IPFfB_0G73b604rARD_r6hlHkk5QApbNl6AL-vK2LZqIMYdmnJiRYoSMnhcUvicJJ8GOUbDdGvsp1BFf0Npyewe0O81TNC8lFv3cH0Gbrp2DOqc5c_jXzzYG6IuCbRB0wr-BKPws0ER-GLl53jcWUhEFE_cu-kZEnvu6IFoux6ObbpxELXgWThemNP4ecIYgTH_AJhb6-oky_D9HwBY3Uj0uE8atv-o9ga2X71sDlaSCgj4VJN1Irat3CWj4lETKOguzWXgw20O8HQGqhDIzUcEsg0vtjTTEgAPA3fX67KzV1YoVqHcoKXC5=w713-h632-no";
                        video_path = "https://media.giphy.com/media/cY4J3pKEhTnzHm6V5Q/giphy.gif";
                        description = "-Máquina press de piernas\n-Apoyo punteras\n-No doblo rodillas\n-Amplitud y control de movimiento\n-Ajustar máquina (cómodo y natural)";
                        muscle_zone = "calf";
                        hip_weight = "80/100/120/140/160";
                        res_weight ="60/80/100/120/140";
                        vol_weight = "100/120/140/160/180";
                        subclasses = "gemelo";
                        break;
                    case 124:
                        name = "Maq. Press Ext. Soleo";
                        photo_path = "https://lh3.googleusercontent.com/KbjLyJNvMpzqa9o_7-RbEc_CFCDLxfSyTB8bl8d12lG4Nmr0bWhiexCUfpZXv-R82HkM8e4Q-vM4S1h0HjGCk_XdFOw9BSoDSj_zdHr9LyL8d7GQB_Mz9pDlQeWNfH8AuZbH6iH1qPJzOy23SZYNRnWMnjHfMXDWxUNRuirCXTZO_GReePfEm7fDGoQv474AjiwVGa-1mbn5ZStRnlY9ziWBxq0Qdg_dsRcayS6ST6Ew4CbMY0282u7BixjLmrS3rYqa9KRB74gZ5ELKqFHdk_UF2KxgOWbQwatK3JJnz1Y_EAUp04MdHrPAKMpYv5sTocLyrxpO5z_YqpEUw4byRCme8EQNoLFmi6Zd5jpRwWCIkOfIilEKNMmydmAKuqbcjuf0EojPOK5lbvsn1VOpHq8_IBqUkBQsjqEYpI7ascgresW984PCw-MpKz3yDIH_Ha1vKStNlkSaRg3WuZpvgxWl2-sjg5Ktyr6nysJ40OBewMtUixwxJ-PyzFno-11ouUQUeTGJefKPJEzVlZV5gWnjhlB0o2RKyxmkpa-3bipvMTaARnmztQOPUB1Nni0QnOd-Idq6LpWKHd4rZ9-114HAD7Ghb9Z85JnwKvQh2Q1JpuPpOXFRSQEAK-qJyui_fSqsa22ZmiQaRqA45YXBjqpW=w713-h632-no";
                        video_path = "https://media.giphy.com/media/1XhrlvfIGmtM3oY4ZD/giphy.gif";
                        description = "-Máquina press de piernas\n-Rodillas semiflexionadas, mantengo esa flexión todo el rato\n-Movimiento de talón solo\n-Ajustar máquina, posición cómoda";
                        muscle_zone = "calf";
                        hip_weight = "60/80/100/120/140";
                        res_weight ="40/60/80/100/120";
                        vol_weight = "80/100/120/140/160";
                        subclasses = "soleo";
                        break;
                    case 125:
                        name = "Paso con Elevacion de Pierna";
                        photo_path = "https://lh3.googleusercontent.com/Q9Z6t_WLU7dCowJT5RpDxct0dVe675DaJvIjINQBIKMGT1N-SdWAOmwlcrbSeuNl2pZmT-UlMLWiSdRgLcc9MCubWBl0o2VSNVLgCQNtEZ9H1uLi96lie-j-6vOAYfcX7uzcXKhtCOaoIv_Wa6MlDlrhwZpqU1XnZecJIBtQpStALPtGidJlM6q1cOwcFFHHJct1Q1qDp-9ypp6-M_B0a3OS2dt5Tw3WQJ-UsjtwZN2VJvWQG5WXb2O4A-VBZuU15AOPKoTDf5iIxm33IIp_nVQlqFoMww-CbvguqxfllZblr5CZt9l9Oq21A3j4da-im3PB65gHrS3SpkZfym8Gd1SQHsafp2hFxo0eeFGL2jKDcczF8bqyC0iO4MB5-kwC3UWNWceeJm3bqQMvHHQ6QMUgYEWu2pxmsGBi-OaRe3KlsaqaDXb7NxeRtVmCw0gZuKM2kf6Iv0erEiSdpFnUmNjWVjP-Ucz3Sv0wc-MOdWaptwe9_SCImYJkLlIuwhupzkSM2gJya9WZlFV14faZoTkEwyMAtlKlW3Bu-MGnko7h3WuhW4PfuJsdEdAXyCya1Qxr181ckBfyQLmiD6D9i6LqDlawRfVi2OvFQcKrTZjr5gVlFQ5KOuTs60jli893Qo-HKYlhTeotorTeB1dC8Zl9=w713-h632-no";
                        video_path = "https://media.giphy.com/media/oxZBPjDe1Y8L1AIeIx/giphy.gif";
                        description = "-Movimiento natural\n-Brazos acompañan\n-Peso = suma de lastre en pies\n-Subo rodilla al final";
                        muscle_zone = "glute";
                        hip_weight = "2/2/4/4/6";
                        res_weight ="0/0/2/2/4";
                        vol_weight = "4/4/6/6/8";
                        subclasses = "mayor";
                        break;
                    case 126:
                        name = "Peso Muerto Sumo";
                        photo_path = "https://lh3.googleusercontent.com/wiotV69miQ0FvqcWJrYlhbtipsdca1z_Z5nI8EFWsYX2MW1uoPkaqsSktOFk9m38o5JiEHnDR3aRmhkeEnWgFZcp38MrWNzjaX9ok3VxxxeTKz4AEuqz8yP_cPkI4hkenUja2uB4LQhvyDyJPrhF_Onhzh0t_JGWuI8TtwigDSEmrfS741mFooHqej-Z-mGCbXzKXe3UPKCVRXTbq4jUSyeWe6svVBRo-ZJsNscC6FsHaTU1E1Vv_PIEp77CyKGIT63coYSnotvsxFHP2P8f1kY83991_SC71wL4ciSb4AGMXSbUuSQJw0Iow-avydWvF73T_HMLtO8wyIEn3vjIlA4uV2yOj1OZB3_nbNLWPS7O0n5q1kxqvOONeQqmaKPVsT5mOZ4d8zkC_HkSKwCB7zW9xDfkZnldfvRAhLL1ypSRwo5NaVjB5eesUoEO0bX0ndcoUX-7WBFf30EM-HVy51XK6n0X2RkNDvxBxoiGYYDDd1tEHNOj73za-7bX-P18TGuYAcatqfYn6tK-mjcVPAAFiT3cr7FKjqbggHc5i3m5U6Ex9Eg_q1d0qU88Zem_c-az8ewbZHn1XICMM7EAanqSXHokgMnnHTxjJdv4c7kqLeU1NQhphCGm1FQ9FogYznyT8yy67a46Pm7JCbGTvb-W=w713-h632-no";
                        video_path = "https://media.giphy.com/media/jVc6rROm00jQiDLNWd/giphy.gif";
                        description = "-Piernas abiertas, agarre interior\n-Rodillas no adelantan punta de pies\n-Espalda recta, saco culo y pecho\n-Movimiento controlado\n-Amplitud de movimiento sin forzar";
                        muscle_zone = "glute";
                        hip_weight = "20/30/40/45/50";
                        res_weight ="15/25/35/40/45";
                        vol_weight = "25/35/45/50/55";
                        subclasses = "mayor";
                        break;
                    case 127:
                        name = "Glute Bridge 1 Pierna";
                        photo_path = "https://lh3.googleusercontent.com/zecrFhyPXaqQEv4s_7jXUpndJTQ8OjER1EEx84sf2JRtAO_pd2aneN17KwGg72DVYhPK8aPUpww7qZyZPo3CA0O3VICo41EWuImCPZUZz7TjfoJKHwZtsFOWJ9z3xd16edei-wjR_WsvZZcyweHoa5-c6bf_Q6X0_bGwqA2b2T8LIQmwTD36RhHaVL4JT4TzXVXnSURJ5Ip2uj4FMYPzb6rlJwIkEpDtS45GvZCbwy2BfT_mfH4sX3lEn9erLtfE4jTLJbPNZW_QPP_8zb7b74-xBYSKEVGrk5zAHboKnRf3Kv5QT-UGBBOZgy_arvmR-tXg-WOBucop4tkyWQP9V2OlCW9oeezmNqLFYxQwxTruuhYDQvJ9DP2g1Pz_ltUV1lu0rz9WUD6atPOlg7qKZgReaqT_-1-hs1sgbJ0-deX-mXeuMBXIjSQtq0B7EWisfgn--Cjt8nrYZzU9DqvUAtxhoHvOFTGl1DyKDbrssoN9c8e8-XJiYwUCuvzRoWE9hYy1RnKKQ06HRey8e3mTcGBrvTTUiACcGwvJXTvFihnUAqnsWOT-9NQRarStUJEjXH9TY1nb3sJM-QwQTz4kjp8HAJCunBC-m_CY5_dQ2jby5OeGN6uXi9zK-mY7T3vun408ibOBz7tXhGDW_F2TglEP=w713-h632-no";
                        video_path = "https://media.giphy.com/media/l76Ix9dqzxUYteNfqD/giphy.gif";
                        description = "-Espalda en banco\n-Inicio cadera 180º rodilla 90º (aprox.)\n-Relajo cadera, vuelvo a inicio\n-No hacer retracción de cabeza\n-Un pie apoyado el otro libre";
                        muscle_zone = "glute";
                        hip_weight = "5/10/15/20/25";
                        res_weight ="3/5/10/15/20";
                        vol_weight = "10/15/20/25/30";
                        subclasses = "mayor";
                        break;
                    case 128:
                        name = "Flutter Kicks";
                        photo_path = "https://lh3.googleusercontent.com/9HejaUy__qfCNTcUfYnhAVvVrMc8FyYPglnUCkSEVm_AlO2dfO5_9JXSyIaCNnvAaK3UUnU7D6VlDKe9o0bdE0pZeJ8u7QkxU5k4uxjO6UEEjM7xgkjzvo3GxccUK4qhOgYsc04bZkmv2NZnaaUHe7Mp5L47Fo_wAfyFEwHaB6L1rTMyGqt-7D_rJXVU3e8Me9zbOTBqWZNz-QCs_eErewf-hIWorCOXChO4xUMNVHI9blIDjcqHxaC2zY96OWJK-JNjY1wETIVPN-jfy02ozPZAxejthyUXFeDpIH84q8FWzJYkYACZTlZpzP11_LvImbRlsNgnDtFEGNwDPhqY0pl2A2I7hLmwTtIqcKIaanmANRFqP82hp4OkbkjCeeB-faJFZBl-RiY0MFORfJWp4zESovJaPpPDNnevT3nPW3QrVnncevuw9vk-HEIY8-bgZUKfQ5OFi4Q4Z_OAbv1OehM8cdKjnf10uNHycRDCCLftHZXq7v4Jwg1AxZ5PbFbu2_hCR3BvD4Ufvghiv6ocgGqVsNF6CNBFxwYUti6bKz297m8VY2bB-7OWiaT3WNIQzlCpKublezYyrXqF4gFXVusv6f7NhPaU381m0fF869GbxtnRfYN3QMeIvXEmSHw34_hBEZOB--eGC5sFa666-gpz=w713-h632-no";
                        video_path = "https://media.giphy.com/media/5toEg8oq3Octu5yTCX/giphy.gif";
                        description = "-Tumbado cadera suelta\n-Piernas estiradas, suben y bajan\n-Movimientos amplios sin forzar\n-Alternando piernas\n-Cuerpo firme, me agarro banco";
                        muscle_zone = "glute";
                        hip_weight = "2/4/6/6/8";
                        res_weight ="0/2/4/4/6";
                        vol_weight = "4/6/8/8/10";
                        subclasses = "mayor";
                        break;
                    case 129:
                        name = "Bajada de Cuerda en Polea";
                        photo_path = "https://lh3.googleusercontent.com/Vu3FznNEsG0KFaoNseI_hGEJfLuvzrTntQtdP15br3NB8-_E-FIaVY11eeJw6qXzD-q528aGZOEWIUAOnwFueYnmeEEJblpX5DCq-KBPbwfIEWeEF3UPIsqOqx256wnO0WjLDgAzU7WllB1j59eVxumnYCgfs-pps4KI3TscI2ZqUDb_m3tmiq_Gmy4viwrh5oJyDeKR2hxGMFa_LDK-yp6zjqDylEhGZwxy53SfLr2TaMJ6N4N8wF4Tn0A8wmS02lG-rlztOi1t-GUN1CUTZa68O1NhZD6oI-_iMIYaV6mhgkt3neG3MIhE2iqN94Bt6o7zKz5VpkfFHxokkuddDcsHOqpgvW0j7XTh99FLFInLkvB99vsXhq1qaLK5o0JCrKs8qBJUkJ73-REOhg_N7BIj07zzbE_bsyHVetC9iM3LYN9vG9wW6CQCiYzeIpGJrA_eGaiYpcv5MQZUOv42P-iuXudu6ApyvIcUdv9dU_0qKkVIx2UShSSKwJEpXk65vtbrykc76L4y_PGzrphbNHg7mkW3apMNOarZrefz2ZarV7PwdyfDHOxuBvOA3qCd7IkXKZmYfzNfH4csPXecOTIOXZaCcdEr2kZusuiOsSG1b4Mji4JiCIMHyvGiaQSXutDiAm2g5ZiPRKC5wis2QWMr=w713-h632-no";
                        video_path = "https://media.giphy.com/media/1gUW7Ljv2Qi9MmmQyN/giphy.gif";
                        description = "-Brazos estirados, no los doblo\n-Piernas semiflex.\n-Espalda recta, saco culo ligeramente\n-Evito balanceos\n-Amplitud y control de movimiento";
                        muscle_zone = "mid-back";
                        hip_weight = "10/12.5/17.5/20/25";
                        res_weight ="7.5/10/15/17.5/22.5";
                        vol_weight = "12.5/15/20/22.5/27.5";
                        break;
                    case 130:
                        name = "Remo T-Bar";
                        photo_path = "https://lh3.googleusercontent.com/5MDzFRzmf0jdbHc3Ezn3rn8rKFvY3CxKrrHLub7zPxT1kchMduhgn8AduDBa2Rp_dxk37AUzblBRcQzhk_REIhRvMjmG45cWUIfFcUTiYUI2UhXvz28DA5KBm_L2HZMWKZXIvYTOEns-HyZ-mNQttj_2jhT7KjS5lYPFUv898TiHD-Hfvc9RhZpQtZeRuH2KFR00HV-8uymzQcA5CjLArdV1MZgHbeF9JZ6bDnIyZuT4HT9YTtrB9ksXOmJFAWflhGWR_NBDRhyvqgMsBmFMrVmI3hEHjxD6SkI415pK5rq7-GBLauFQKSSUXHxcYF5hB4Rd3OH9jqrDHNGCX8GiO5w84TBeQFCksQXFOGwjYMG6yCmdT_1vrYoxHJnbmkxn6gwqZvk4Lrk6iJAziNpdfj-nR6e0_Y65IvzkP9nAod6xexx1OYbVNL7IoprqsPQL6pQRal4lqP1QzgSqtVIdO5U0VKGF2yNvt946hcZ_ejKQW2j73HAw-SIiTZcrmUlnMAtxYo9zWUnaDAEjlkDyq__HsPp81Y8Sh8xsI3loF7Sl07qjTFflc-BgHK9xTxSaqV2ouYbp78JwVSfVdR7cQWOjYOT4FQ0yCXvfFFF1suzxuNqa_s7jROWMNPKKdUppxg-Eh36-t74KhY0zNhS178y_=w713-h632-no";
                        video_path = "https://media.giphy.com/media/1gUWdeaxbnV5eo5voP/giphy.gif";
                        description = "-Piernas flexionadas\n-Espalda recta, inclinada\n-Saco culo y pecho\n-Subida llevando codos a tronco";
                        muscle_zone = "mid-back";
                        hip_weight = "20/30/40/45/50";
                        res_weight ="10/20/30/40/45";
                        vol_weight = "30/40/45/50/55";
                        break;
                    case 131:
                        name = "Remo TRX Invertido";
                        photo_path = "https://lh3.googleusercontent.com/wNIOCBudZE7mzDa07nGXE4rfY1MZ3rzCMVX-RugqEelwVFWInLnmhziLDiAqND9BKrAR3ovq4DEiBJTYjghG2nWVOgLKFuRQsnJTKMMs7yltPVoYbBUZxnntNCgCDQyLxwCTcuM5ljnephqYpcQgWT_jI8pBRAVEdCHmM5LAXCVXtj-0eqo7fZovc_pSJ0JtWxZA1VmgRG8GOeiTAi_rws_bZAsonAegPvj9Vg741jmbA_4xy3VUp2fvEUJDbvb6kIRoLGjsfJfUsF7B_rcJSJjIvpN4SvvCg_ySCd-rLPcGLZmFFo5mXDW3y7bipa3_FZOz8aamq-JMAwWMzOeL_UM4QEpJBPISzgtfyc5V22lELpsl9CBUhyc57CGN2mUpECrffC0avZso-oRVnSV0Nu7nlLNueCKjnK0SULX4-RuT3aSFk4zwi9cJbNcqfHsq9zIN_Xl94PZoAeFv6hJUlHrfPi8k1oWAZXQlqgpiDcwHaDQL6_cUNDS7JSJzB_6ct7KCHNxG_uKrmyS3LoX8uJCJjzoDeOdH-Ry4rM0eDBr9--AQ5xJujt1dENVeQnPaeRhB9eXcmLT4OCCeMoXj9pVz3fwtFnU-I2WExR_ixsm6LQNphYejOyr-wV8hmVsOLW48LY4-zH1-Y84YGgJTAyo5=w713-h632-no";
                        video_path = "https://media.giphy.com/media/8Zef9CMPBlRiFqySOG/giphy.gif";
                        description = "-Cuerpo bloqueado, no lo doblo\n-Subida llevando codos a tronco\n-Movimiento controlado\n-Pies elevados";
                        muscle_zone = "mid-back";
                        level = "hard";
                        hip_weight = "0/0/5/5/10";
                        res_weight ="0/0/0/0/5";
                        vol_weight = "5/5/10/10/15";
                        break;
                    case 132:
                        name = "Remo Mancuernas";
                        photo_path = "https://lh3.googleusercontent.com/K6U3Z2OGZNMfr3aNt-mVpYNNo4-FH6t2LMhRD8aCKUfrt84Ni6z859yXYS15oFn4XiD5xiiHsZMF_hIjvCWCzIR8JRONFTiCWdExHrMt5fqwVSbvBAia2J0fQ_qVWleIB0PfFrWYopN-WT0IbtfCt1mbfi7jIJg7UZatWezHXzpgQ7cSfvH0o2hew-b3SfFwiFMv4yrkcp5nO3An596cT43WOZT6_vEBkXx2S2x6cyD6BQIRW-bKzoigByy35xYOwZMH9fomLcGOuySXk80Pvee7j-GXjT8inCQfZZcNQhfjiISVASd_2fUva09u5e9IYXmiPu3T0wzUAwiXyUnyQjAwjOi74lMdKTpHI0lzohXBo08c7nDXaFvzcvQGnbBLEbQEqzQFIka0x_IOB41prWbx3FVhErP1moU_l6qDf1DOJnBaoF_IRiuEJfH7MKCj9TEX8qO8lDhqYC3VdCip8BL-QYrlzp7fjwpmTghWcNrv9ZrC2CVSqmtkNR3T4mBaesjl-dSmcYJWTmqDjhco4KZCdGQveEZNqjdgwUmgUOTNXnVckO0VZ3tgziTYq17qvHs485FrJOUoLZYUJ3JErG7fxGT031aE20dfjHo823Wumtm2C2B5pJUNk88l-A-U5xDPK_8AGyD-J7g-eltvg7mZ=w713-h632-no";
                        video_path = "https://media.giphy.com/media/2mEfe8ryXe5vv2FYd3/giphy.gif";
                        description = "-Subida llevando codo a tronco\n-Espalda recta, saco culo\n-Posición cómoda";
                        muscle_zone = "mid-back";
                        hip_weight = "10/14/18/20/24";
                        res_weight ="8/12/16/18/22";
                        vol_weight = "12/16/20/22/26";
                        break;
                    case 133:
                        name = "Maquina Lumbar Girando";
                        photo_path = "https://lh3.googleusercontent.com/lhbTLaITXokzxm9Fy6IBe2Fmk8R8mYplbZO6TNlBv-ZHOGVHjpI6GEja6jPeOPY5ToHPngWq6tX0Lg3cLAg_Y2JqifVUng5Nip0grUqJBWNioS5G9-gMmKkxkZbKQXUbrzfZhOsMQIvIV6uzwWjn5MBXCYAQBvaYxC2EoUOYpYng6hG2JEHhr7E3Un1ljetpHd0ZjAWTLLJolP3CDLCNqQtcQkP4pe7aYyaDnw7F3w4JEe5H94k07lAbxFKeDOsEpMVJMhsz2xBs5qBZyNAUf_RlH7_wp1g27LePH-bq69IQ-bXFkZjo-CqetYcVJU__a7E_ZuVPaz-NO0fywjYs85zrL5Yd5kFDLJ0XN3VeMOHCl6N90B-Vbi0TvONKG137O_RGBj6hrb7AajzWtIS2Ax7e69tJmksZxhsjbFkt2qxiaCHpqHHP1s_wc5G_XpnxD7m8Xvw12g-odpngepjxi-Bh6vsDT0QbBrsy0mhEiN8TBnIsx1ZW0IXVqLgmfxFAAvp0mE_QPYHS__nnlWMSxCsHS1IyJVJRMErJze6wmt0Dz8bngfl1RUZBrOs9i6idNROp8s0Rze_45_RZiku119VkYvA6kshWdk_PptKUhTK2YprBVJXdgarzgCzFUardQzARpogpSkAoK6Jkw-pViiwZ=w713-h632-no";
                        video_path = "https://media.giphy.com/media/12PUH4DfqiyDZgb5Ip/giphy.gif";
                        description = "-Rodillas dobladas en la subida\n-Giro hacia un lado en la subida\n-Alterno lados\n-Movimiento controlado, sin forzar";
                        muscle_zone = "lumbar";
                        level = "hard";
                        hip_weight = "0/5/10/15/20";
                        res_weight ="0/0/5/10/15";
                        vol_weight = "5/10/15/20/25";
                        subclasses = "lateral";
                        break;
                    case 134:
                        name = "Lumbar TRX Isometrico";
                        photo_path = "https://lh3.googleusercontent.com/raGQIUCI-WeparnwM12NPHF_IxuwH9NIpLqE9Klx9wBDqAOqRjtnp1M9TFCc52RTbE5nMNyNBj-gE6YYHqq-1qClwidOoTWJt5Oz1uGCJ9V0UtHp7QRosyWc18_O9uBRF2q-ynyzP6T-nac5d7cgogRUp2XvwhjQDhRYGDL0aynV3Ftp3E9zlGA7UioaKx2FoVeF2KtCniWlZuFlX86ZppIBhMHRPelWcJ_bG-nUGeFgsC4ZUiXrtpEH5ABXfvHTWBCR7B4fylgHsg1V3i2hngyWgy5AWzUdPcoChLi4wUzs_EhZXT_G5XoMVpsL0tRtPGe0AzkJz-alh9_xF6BFHoNTJoZl_9cJ1Btt6kRRObqCYJyA1bxxaqwpPhF4cHEG0wFyHA8y-KrDPHWRzJ0nCNJ8DOIgK-WMGuB8_EdnfEE7EST8cv8qXwcsqh7XEJdRV0bmjB_y94Ye-42wssbFsfbDACZUQsyv2C-szVxUauPvOK1LhggQE9vyZf8jcZlciP57PD74fo4s-Wxf2iNCoP1VBi15FoDjZhhllrHCYbuPO0EB6qTg0jFR-AcQgh_4-DVF2mQef_Jc9SndkWw8hBBXDwCovs0Lf-2WqdIJRV-3yUhF6I2WLEZ_dcrSTW5fP-00i60Tb_N-FKiNZgyVQYnW=w713-h632-no";
                        video_path = "https://lh3.googleusercontent.com/raGQIUCI-WeparnwM12NPHF_IxuwH9NIpLqE9Klx9wBDqAOqRjtnp1M9TFCc52RTbE5nMNyNBj-gE6YYHqq-1qClwidOoTWJt5Oz1uGCJ9V0UtHp7QRosyWc18_O9uBRF2q-ynyzP6T-nac5d7cgogRUp2XvwhjQDhRYGDL0aynV3Ftp3E9zlGA7UioaKx2FoVeF2KtCniWlZuFlX86ZppIBhMHRPelWcJ_bG-nUGeFgsC4ZUiXrtpEH5ABXfvHTWBCR7B4fylgHsg1V3i2hngyWgy5AWzUdPcoChLi4wUzs_EhZXT_G5XoMVpsL0tRtPGe0AzkJz-alh9_xF6BFHoNTJoZl_9cJ1Btt6kRRObqCYJyA1bxxaqwpPhF4cHEG0wFyHA8y-KrDPHWRzJ0nCNJ8DOIgK-WMGuB8_EdnfEE7EST8cv8qXwcsqh7XEJdRV0bmjB_y94Ye-42wssbFsfbDACZUQsyv2C-szVxUauPvOK1LhggQE9vyZf8jcZlciP57PD74fo4s-Wxf2iNCoP1VBi15FoDjZhhllrHCYbuPO0EB6qTg0jFR-AcQgh_4-DVF2mQef_Jc9SndkWw8hBBXDwCovs0Lf-2WqdIJRV-3yUhF6I2WLEZ_dcrSTW5fP-00i60Tb_N-FKiNZgyVQYnW=w713-h632-no";
                        description = "-Pies en TRX\n-Subo cadera\n-Cuerpo bloqueado\n-Peso: disco o lastre en cadera";
                        muscle_zone = "lumbar";
                        hip_weight = "0/0/5/5/10";
                        res_weight ="0/0/0/0/5";
                        vol_weight = "5/5/10/10/15";
                        subclasses = "normal";
                        reps_obj = "50 seg/1 min/1 min 15s";
                        break;
                    case 135:
                        name = "Peso Muerto con Barra";
                        photo_path = "https://lh3.googleusercontent.com/EdXCvslIWlI7K6zckPUtmHQuW5f4Dc2Qhs6ajgyi0RAOdzn2LdiKfyiCciH_tX-zCZ5XXJrQPxxoUCzc2iz4UZ_G8J7aKUvUeTLSzuNQtpfged9pjEH9PWxWdtiZqghZD5548CBAeEHbeII9Im2dGhb94Xs6V8Cawr0LzwR19HLH1QHBacvYGcnubDxL4qDMBHRtmtUKzLvpCU7eRI3QjbUnPaQf71iURKkxX6v1XH1jcn-xZZ_lzaO4ubivoiu_ygMhX4ydTmcZYRKqclhT5RL8CJoxxofYbTQoMiAFDAEGuX0KYR-c4RFzNICzFkSdYNqFYvCTib4_SQ9iosbmUEacJGgi45FUAUqeBGVSZkTvWwXuNtqG7cF6JZTJd6s0I81EfAcSuBzCqMEU92cb6wngKLV1XTenuVb9g0R3-8l7tHIHU1PeIEL56rZ6Zk60PvyoTUYZfTSvDSTfCJfh9GstuQAnufhxNAv3nYqKwI99aIH6wmdQ3BWoPFjyWuyg_68BBx6NYGqFgHk5_GuRDjoWWEq8sdOp3THYt6KKPh28USQB1y8K8vSz-u56XHWue9QRXJ9Dulypbp4EZtOk98vXgGprqLZ1RBchAu72wqeCi-tP1mTfI7TSwG7T_oFNqe_qI8guz-dYM4ibJHU9Ofry=w713-h632-no";
                        video_path = "https://media.giphy.com/media/yMzm6l8tID8C74uhwn/giphy.gif";
                        description = "-Bajo con ligera flexión de rodillas\n-Bajo inclinando tronco\n-Espalda recta, saco culo y pecho\n-Movimiento controlado\n-Rodillas no adelantan punta pies";
                        muscle_zone = "lumbar";
                        hip_weight = "30/40/50/60/70";
                        res_weight ="20/30/40/50/60";
                        vol_weight = "40/50/60/70/80";
                        subclasses = "normal";
                        break;
                    case 136:
                        name = "Extension Lumbar en Suelo";
                        photo_path = "https://lh3.googleusercontent.com/J6Ko7uJl08srwjSpdxV_-oYHlHf0dyojBoIFTJVsXGA5tlS4e4T98x_jHnLbzh0sm7TYlWLBzRLW08GpWNNXVx2pNraOkssMpzAyOYhJfoZ7fqp67sIRVvpMibgxRNUj6lAFrfxDf77_xLPk-spGdutH3qj5p154gruCcMzGqHGjJQtMdNS4rtoUzm6Dlj-qpR4ARygDBaTgmDVSxIGfNwMVkWHSlFIq4-VMdP6gGyXDx8o1PxfIVs8qbLsCQRy5iZ3wfaHc91z93CFyWm0FMhjY4iO_kGNqmppExb6B2Ny-tvrm8uiF1D14nRCT3zgIYYHEWtctGlPkOv8dvugawNW6TXE78ztLvjkvoEDHIMmXosSQ8EBT9BPbCEjRHwiJgUyTa4AsTzq3_pAq1LA8cBmtEYZIN3FQ2LE0DGLDel5EBBzjQPydnSRIVRVhjHJtu7IaMUeH4O0Vo-HV5Ph8k4UoXS9F1qE2KVsyQjKamP_756P8sEqmNAu37LE5Vn3wRTX6RggaRKhpaM6tEyfk32twRRFy980ccW3UFONKysDfJLcVJRvkQzKWBU6xmZVXUdg6UgnwNwD9Z0mosEr9E_h7n3CKu6BzCtAvvLlduyNttkClp5NIqTpude2h-QsJQhbrjJiFuWnXQsgakjAeYUMG=w713-h632-no";
                        video_path = "https://media.giphy.com/media/vRHPj45jrIIBBVHHz9/giphy.gif";
                        description = "-Inicio tumbado boca abajo\n-Flexión lumbar, subo brazos-espalda y piernas\n-Movimiento amplio, sin forzar\n-Controlo lo que pueda el movimiento";
                        muscle_zone = "lumbar";
                        hip_weight = "0/0/2.5+2/2.5+2/5+4";
                        res_weight ="0/0/0/0/2.5+2";
                        vol_weight = "2.5+2/2.5+2/5+4/5+4/10+6";
                        subclasses = "normal";
                        break;
                    case 137:
                        name = "Aductores en Polea";
                        photo_path = "https://lh3.googleusercontent.com/i9d-sXKz48w3muDl81fvLm5-zW4iAAfjO7dVoV3tHRHXe92MUuN_Swy4AJJCIiXMxxEywih-ey2ZAYAK58SjA8jViaVqsTPUBDwZ_se06glw1UhqbFz2t1J6ckHrXeSpDNsK1fiUAfLMLezzqdIlRc0niUX6k97LEkiY52-0A1aB5mFFIJ2J2MkYc2Da-XpUlwEatbpTGScIhOFdkfHWQHlIPZCidqLD-kyQImDoYoc4ODo3CjyLTRgkvXbK2G65ocwee8VmEsGPLDDDjxpNmbxAf2VvUsAEzwApC8aa_0y-8p6ws0MpGWUhZ1vZB3i77h6FBsZIh7wWQKwLn72CH-TMM5RGrDacUKrKgawH4RPqvuzVdedUkCLAWeVQfwe2aaUagjiNzJa_ZnKHBwC28d1uk7WcPsXocwH16STKQfuEdWoNhCXAsdGVdZFEu5JYsa_pe7RpCFKxPssGhlplJ7Rx_9bRSHs7o2McwD5sr1aoOPoq6OjaGQ4d9BQ4fPabSArbLepnV7aL0GcYtpV39jNAPZPyEW5hARZPU9gRcJWahxc5XRxFJ3bxiVX8ppqCC05P0wjkdi_tgo3ztj24l-tbb8Bni1BwbSCul1sOwxLEvBm-MNYZJWTzndluN7_l60SNd-cNQa95Bdi9kcyt3doU=w713-h632-no";
                        video_path = "https://media.giphy.com/media/2zdVi3zVbjIiOvyY5L/giphy.gif";
                        description = "-Pie estirado, no lo doblo\n-Patada lateral interior\n-Vuelta controlada\n-Resto del cuerpo pose cómoda";
                        muscle_zone = "thigh";
                        hip_weight = "10/12.5/17.5/20/25";
                        res_weight ="7.5/10/15/17.5/22.5";
                        vol_weight = "12.5/15/20/22.5/27.5";
                        subclasses = "local";
                        break;
                    case 138:
                        name = "Abductores en Polea";
                        photo_path = "https://lh3.googleusercontent.com/Z-A4oOO7xZwWQO1uicZBXMoPVx4J_EfmQLQxQJ9mwqhv5is6IumzPo52Dyg_gHXUUm5lLv4xnmtpoJbcI7cnOLpgUgWpymGn0FlLCVhUYfjG3bQEsfuNUThQvWLGA8c-pl1RF2EqBXNuPl0K66IfDHDu3wgWD3GSZ7WsuDklr3VGJ_8gc4E_AnqzVYqmLXE3IkGQzW6pU3-NlJfxqP71bZvOB5lYHvJSS71EWy2PYBtjg__L9uAjftCJx-7K0nSisGvaTemQYnMpPJaMWG2tv-ONZFAUFFifLmOzQniEE4nm4IU6dByh17M5EGsOKJKO1OmnNvOev02j258Hww_wGRQdY6sNUiggXCvGeSg-IgJMtPeEZdlb5J4HlupjRVCocy75lA7KnUok_ch3gEjvb6hUDJ16s1ar8HguvOXz5nJGV1YSqcXeMXyfhGRAvK5ZhzgdyueAcSPbkksQnukYMu_Ecfq37xiOCuBO3KGXU1ybU3drzb7uHsAtIaZhpZ-_FDwE7LSzbynwATIyW0l_UnuvpTU6vub-9tVUD49sKqJ9Tf5EOYYxvbVZ46zpQvk8pmYR_FL2Lk1oVBwZSYWEy2H-8l2EAZbs2oDYy8pgi78KBN7BY_x6JvxY8555fyTmLN7GsJ5a4iUUPBJ06kFraH7W=w713-h632-no";
                        video_path = "https://media.giphy.com/media/NPHjDsNIFje7CdO6pi/giphy.gif";
                        description = "-Pie estirado, no lo doblo\n-Abro pierna lateral exterior\n-Vuelta controlada\n-Resto del cuerpo pose cómoda";
                        muscle_zone = "thigh";
                        hip_weight = "12.5/17.5/22.5/25/30";
                        res_weight ="10/15/20/22.5/25";
                        vol_weight = "15/20/25/27.5/35";
                        subclasses = "local";
                        break;
                    case 139:
                        name = "Maquina de Cuadriceps";
                        photo_path = "https://lh3.googleusercontent.com/jbgEm1o5fKY035i69XBZjlN-6sDcS6JPKbFsDlrS-pxefTLN83YdxUhfg2FbQB3V_EcKiCRqztxBV0GK08yJSQ9m5c6ymGwpFIWjc834xDtm9f3oSxsVh8bCPIhTJpm2VhS8y8v2AE-R8kG2uex9n4AFEy-VpeU6zUze36O-g2IkRVu4tzX8bhn28LnDkYNLn4PjV66rAbnOGiBlwOBKqItRmo06YVZBpoIKnQq3szLlpf75nSI9B3uaKtl897rJUsVoRKxque2eyF-_9q3y8u7n_ny6hrjiy6yVL0rFOAYUJ0el1ZcH3Wd-u4hPAx4lonsl6tyzqMP7O71EMzIshKrv5nEhl2aKzV_N0PFcoydfZyY0Fk38SoX7cAIt0VTvlU9HCVORUpzUOKrw8WuTkMx_LVfEKTtlfJ03-mgzLwrV2C71Pa7Y1RQ0A0gMWQTR1_4icIFQWAPXBbNdzrjvh2DUD6QA5tROPL7iuDMaoilm_uoe-GUTDGMjxKtVN8Vz2ohhI5f7LkERZwo4Ow7yizczL5WI6Ngx0C_pSGdooNh5s9db402BelTKKvFk1bcvhw89tMiy0CVfEgR6XgWIEaCubrKzKdNkJyfWMZyWy8PLCEHG0uZMvui12Xy4NJTAm9If72R1xf9sZ7ITxNu6wywv=w713-h632-no";
                        video_path = "https://media.giphy.com/media/5zw8PEt9LisjDkBsrS/giphy.gif";
                        description = "-Sentado posición cómoda\n-Extensión de rodilla solo\n-Movimiento controlado, sin tirones\n-Subida más rápida, bajada más lenta";
                        muscle_zone = "thigh";
                        hip_weight = "20/30/40/45/55";
                        res_weight ="15/25/35/40/50";
                        vol_weight = "25/35/45/50/60";
                        subclasses = "local";
                        break;
                    case 140:
                        name = "Squat en Fitball";
                        photo_path = "https://lh3.googleusercontent.com/MKm9RY7zZ_4zPsdcBa848pJexKBsQMAWzhVbm2-0hL0MII4zSHaM36iVe3wJuDa5Jcxwonl45jxedYHrtHup_pbndDL-ke6suV4ciEyY9C0MrPWDLXaU-SmNjTzYJqZkqMoc83qYP4m1yecz4yvGzZcyUBJgf2jPhqQDLYQv2srA9QTBwvMs2U8AXFSpuAhorBbExWIQlNhyXR8XY-HdY1_bR0UFByw9xmMyR1hHywOZWjU4q1mf4zSXnqtIJcglykHcDy72f8uwAGh4Y32xt7Q-7ujG3PFmNrCVsoWuZ64flpD8A3qBtUAxtYJQAMwx2tZ6S85OVliQ4dwLQimjjffFiPabj_tQlrCxlyt9QgcxMMH_toUPSq8Th8xt63dsd3FgOhblOhGvuDsKChDWfSQlKVFOskZEraDKF-EFpiU-A980FpHWkGxWhG5mCbsZybozNKsMPiLfF-ik7uh1d24SFyxfNZXlN0szax2QFjKQbFpTi2B_Qyxo6m6OZSh4JoACWXDAfk2dBLnv2m58HeMdKUOKymFp6R8W_fm8RHwGd6TDPmTn30hr5IGThS4hZ8nrF0ymsiU13lu1oh89D8Zohd9AYC1jrkmeZw9m5zMHWuMRmYcquFE5OMZi7gj5H0lG3QlUj3eQzs6Dx0-0Mx9q=w713-h632-no";
                        video_path = "https://media.giphy.com/media/X9i2BF4fJ3kD77ImLb/giphy.gif";
                        description = "-No adelanto mucho rodillas\n-Espalda recta, saco culo y pecho\n-Equilibrio, control de movimiento\n-Bajo lo que pueda\n-Si caigo, vuelvo";
                        muscle_zone = "thigh";
                        hip_weight = "6/8/12/14/18";
                        res_weight ="4/6/10/12/16";
                        vol_weight = "8/10/14/16/20";
                        subclasses = "global";
                        break;
                    case 141:
                        name = "Fitball Squat 1 Pierna";
                        photo_path = "https://lh3.googleusercontent.com/dk4bUOC5nub1aVra4HC6vP-cKYhpFbP2fmCKFDFF4EJdqjVu6GrUpWsnRjn-DSGVY5D0hnp-LsQ-OrsM0UpPYgkIFgjtu7yXbU7VVBRrv8CRgffW0HHI5zb3dwcTM5beyMY1uPlfzkS976bhY8R83_sHoHi-pbz9fKjI9e-l6gkSYJaxO6fjssc51c1UiSXMerpZAGMFuT2dq9bQt1dCAEtd6ziAALbTcvSeyyt3UFhYDUwmzbmKf16qbvd1QSXBqc8M2bF-XyskVnJEnSr1KmDpCNM0rlZhivt8B1VjOMKkMZZb3eM8_pPmS5AGzIav1FEG1z5INBZuxMxZQ9_n7wr9dzeP_skxJPV8lf5It3Q5llMfAmO5vMSxB46464eeXuDawxgNmCQOITXWCBcjiqsyGaqyanoXnyPT9WvBs7T5b1AZ3xtKglc8vkZM19zxkzHvgS30jTQ28kM3XmHqjFNYBNwHVnvLrcDY38DufOB8WJF15sbS9KTnzyMWelANAi7U4IIVGTkxh-uIelc6U9zUjFRE_gKee9FqkGPILSoDxXHc8eVzOmMXUs6_WY15t9twRkyA8segfbE5yPSQ6SFwsBKYsrDl1_d6y8IIF1VNTBLRiQpTpPqOnRBvwPfT46SXJ42DZaSMUcpqyydJLdZn=w713-h632-no";
                        video_path = "https://media.giphy.com/media/9J8XZah8QEbUOButZo/giphy.gif";
                        description = "-Bajo lo que pueda\n-Intento no perder el equilibrio\n-Espalda recta, saco culo y pecho\n-No adelanto mucho rodilla\n-Si caigo, vuelvo";
                        muscle_zone = "thigh";
                        hip_weight = "0/4/8/10/12";
                        res_weight ="0/0/4/8/10";
                        vol_weight = "4/8/10/12/14";
                        subclasses = "global";
                        break;
                    case 142:
                        name = "Extension Barra EZ Declinado";
                        photo_path = "https://lh3.googleusercontent.com/q3ZH0Wsa7-DNsoARcgNWJpes4854HIahnidXOXfJA2TAm2IueMr-q3RoAPlVon9CVuqvZuAdZuCNz69F6XcZtAmDzR3lo-MNE_C1x711zOMsTIzAn8kPUAymOe2RSVs5TKM1VG8hDqDnejDxGSg7WYzDufYAR6oQHY5aQiJy5WCp7KTQezGoVP7tTGFLTaMZc3XNkt7u3mdRx2G9Q2noHppFRHK4TalG0mLQndXB_1I9nMvs-Sl9WdyI9R0B8PIIa6JcXCysacCmCmNaBHsWYisoWFiCHZbLwXsQnEl2ZKM50wXNrAezLr289mv87y4vi7zD5gHOONqu9zLwro7k_DmiVWITbjccRNmNXbNOvZFP7fHU0N9B6QIj0zPOKmwYn9wVp6WTkdQCF1l2-c2vO9NJyV3Y5T9bWf4jdy0y-MY7yKjIAilcQ-W-UwggeMCeAl3i0ZDV3IijqkYxwWeCcBVeh-bTyIRhUPEgLdBuZZWs-ZrlcFRVI7bcaZPipJofleAbo0dsdOvA9o1txWAWMB6iA7vc_RxbQylwcx26J6C8_Ql5iuW795W4YM2qNBtKCBeQHIiQSRri3QJqvL7DrQlHU5zmmQrPX02O8O5_5dXwVl7ZDsVv5E_PsxRQQK7-t6T2mMhg-VG6XUbrLNMLou7i=w713-h632-no";
                        video_path = "https://media.giphy.com/media/7Tl49qaA5QoO9YCP7x/giphy.gif";
                        description = "-Banco declinado\n-Codo perpendicular al suelo, rígido\n-Manos cerca de la cabeza\n-Extensión de codo, sin movimientos adicionales";
                        muscle_zone = "triceps";
                        hip_weight = "2.5/5/10/20/25";
                        res_weight ="0/0/0/0/0";
                        vol_weight = "0/0/0/0/0";
                        subclasses = "c.larga";
                        break;
                    case 143:
                        name = "Press Triceps";
                        photo_path = "https://lh3.googleusercontent.com/XjoUIqWC0i2wyUWUJHEduqnN8CfND-C5h6Ghh136A2sLsAsld7jTh4pwxnazMVmfT6zoNzShh5HF0jgPx6sHqtEBRFxNdow5uZSLsYF47y-t_dz1_KhSgtxXVmZMusXmDWmTeVMMOG1IPtsU0Xm6ioW-NJQ6mBeUxFXIDxZOCQoimYkz_CGuJn5p4e4Q4LeXmJ5meSqpanDOAYWJpv5X8qCnLRV7vpSuPhjCKXFQYhNfW17NDstuAvqgD8ZZjJgERqQz0Nzi1Yfxi5f8mHfT7PydjtBOaYHznNU4s8Yhe5qltcB2L6NNf5n5XiEQuxjZIotcoPySeuYFs_X3Ca3eIIlQcFuQKgHAXFnTcuw0EwSwpn3k_J7Rx0PLe-LQYhbspO1xap2a84ik5IX4FqNns4ir4HJDJUp6oeTTUsju90TP329F50g2FCGROg5uIXuhwkXIuWEX1JKg5SCehGVah_3ATIXQ1mRYLS0092l7ez7tbUFHQ_Z_45XvnerK90Ect6vaKUQcOOh4Gucrb1cQSWxDxtvRz087Ejo7BbRmb1k8C9fz6ZlD2tujewOkBlKrGCmNsqqppklp67lZ975bit7Ex8wRB1Xo8MM35Q9N011iLN8D0kriKoO65QH6DysI4B09hhQ_gqVpG3TA2ZTtYkDR=w713-h632-no";
                        video_path = "https://media.giphy.com/media/uU8UjZMmcJDQv8gEqx/giphy.gif";
                        description = "-Agarre cerrado prono, sin forzar, manos ligeramente separadas\n-Barra casi a tocar el pecho\n-Movimiento completo\n-Subida más rápida, bajada controlada";
                        muscle_zone = "triceps";
                        hip_weight = "10/20/25/30/40";
                        res_weight ="5/10/20/25/35";
                        vol_weight = "15/25/30/35/45";
                        subclasses = "c.lateral";
                        break;
                    case 144:
                        name = "Triceps Polea Barra Supino";
                        photo_path = "https://lh3.googleusercontent.com/ov_OVt4hUp1BN0Z5JB99AwPmlkovFAbf2FSyjDGDmPtIi8wIPAa5rpQF9aU6RASn5XahUnHQgESw1o9F2mkx9vDLzTUENfN1V8mT44zjyEq1ZmMy9IXzjOAHkSU5LBBGLydgd1fDc-blvjtY8lMmv_pu2jacAJD5LLGQZRVOwFaEr-tkACpfEw6oYpJslH8a-_xUV-wDqJL2fbKWSVmYCZ4yseWm4ERB5gE5E9LV0WF485Gg62UzMgZdrMkt9Fp8lBrhFSett0HWQ9xdij-EARZ6UEWB5978sTjlD540ELAlimERQzJTuZbXB4MDw3fC1JXPDaubFQrTpusSSxjkGQAZ_QijMr6xhaNZSWqKA-DA9QP8bbM65kwb2FIiCOiPxF7ga1roCbJ7pwBCS4D-Mgtg_blcv8CzrgtC7Lhm67AMiPJukRes2SR6byvyBEQNW1_ZvNT2zhqmtSFOZwJKwh2sG74lGfTRqzf__e8bPgWvZd8jZ-7qpXx7KUF4SM_8BM7fvva3WMd87BgO7RaVeFdZD1_dEnVSExGW4ojWn9Yuce_DQimpMTFwqZRBj6e4mRDpzAiGQYX1oVmthZCp8-CWkTD1ULMyeRMEksnF4yBBlQKePHYnuQ10wdigNrmPmnzJFFrETTnQ8gk6mBn-xda9=w713-h632-no";
                        video_path = "https://media.giphy.com/media/8lPMWahnH18U4pLcJv/giphy.gif";
                        description = "-Piernas semiflex., espalda recta\n-Codo rígido\n-Agarre supino, barra\n-Extensión de codo solo\n-Evito balanceo";
                        muscle_zone = "triceps";
                        hip_weight = "12.5/15/20/22.5/27.5";
                        res_weight ="10/12.5/17.5/20/25";
                        vol_weight = "15/17.5/22.5/25/30";
                        subclasses = "c.media";
                        break;
                    case 145:
                        name = "Dips con Banco";
                        photo_path = "https://lh3.googleusercontent.com/2FMIZudtWeGicUbOtFbZ66X6WBL0MFLJkN7_PqmUJMdtel0-6XXI1SOdeSEBRT9QNRZ8SnBpPwNwBlRqKmJPn0jI4pa9qJv3P2nChSFVr2KxfPCjzEdHq8CZEOhLD0CiBMiZjyIUbITIGbM2mc497zV4YtulEDRp43t6zncvjqT5jFxFN9c44DZkDK5aLzaS3e-rzAjRfHEvpx2UMGZAW_DjJ8cvxKSnB8R3FqBjJSyN7FRyK8-kjVFFfK8duvfYzd71h9qlh_vkOSrCenT-nuON4L5qnvjEMk3d32lM7QAzRkTfEHmu60e2BRj-Pfifx0g07QnpvNzn6qtTUPZb_1SqF_HMF7UQyiZpHJiNDuj4GtEva_pK1qGoVdYyE5R_Kzyiie0RCQT_69XevGrZNXML-RBPFq6eqULmrr0WvcGqe-MqQMzE7dpaZUVNjVhB4ZXs4huMXl9rg4Elco7O1eYB-F-zbxW8VyYuFmaSEQLl5PGfcT6I4Nv4wpJSCccqs5aE0ilIL0Pv9c7MRnD1dI2eVThWVdasqPBLHU0yS-MguDEkT6UV1QWxyXtvbWfulXMUSaP7kqQBdJc3D7je1PtKI7ePxR2HKZLOg5UAjiTEm3LhCParlHkOQAoOUlDOKUZRFU3kNP8XOB84v3gOWwgU=w713-h632-no";
                        video_path = "https://media.giphy.com/media/2yxNfyGU8qeQBaTnkt/giphy.gif";
                        description = "-Corebag en cadera\n-Movimiento vertical, espalda recta\n-Sin balanceos adelante-atrás\n-Tronco baja con brazos\n-Piernas acompañan, fuerza de brazos";
                        muscle_zone = "triceps";
                        hip_weight = "5/10/20/25/30";
                        res_weight ="3/5/10/20/25";
                        vol_weight = "10/20/25/30/40";
                        subclasses = "c.larga";
                        break;
                    case 146:
                        name = "Ext. Sobre Cabeza Mancuernas";
                        photo_path = "https://lh3.googleusercontent.com/g07X-yvmKrklroLfTJ4L7xgKNVqf80W-RCQmWFiET85cnlail4CtZOw25koMT9qGwxtseMoF71M37KLOW8PxvFSYnyTJKG8SbrH7rw7pWzmqOGHrPY4ka18VGZf5sjwL2zPhKggzFQrSbnlGyrsO_Ho06B3suDoTefIc_68BWgazHpQGcw1aK1aZEp3IHEu1SD0oG5STKCf2meeROydk-G1EvaT2ENWEEynQEqsziX4VXx9wuWhE94naZTbTHc7j3yHdP_Mxcf3YV04Z3Rx-g7iMAaV7pU5DtgrnKhqzzR1rXvzafWXrai1qwrnd0ppJjqzhOFdfgtyhzBsBFYwmF11NKmSm0atsVT0wuU_9DfaJeUOT93ia43xY9wsBHpW0ZJ2SviS2JQqPj4D--c5YDsujXw7pcWLItgIbDqSK9Fma0iCjYChfd1qI2rLTYvOflxnbfUgEbD-K_OScDFeeBxsuBmrQF2YKAlumb4eV9Q1e_D539t94bRjeS8ZZG_1dw2calIC3KMTkMxSuWsgztxdVDTXlEc2cnsz58nyi1sRTw3goR0mUQ8dj5KIflJtWS-4hBMGV9WMOZq78jyJNdVjVc5zji7fIID4MjMk1qGNlkoV0CXVM0xlOyhNvK21aHhgOMr1JppMSsVlOej1ejnWP=w713-h632-no";
                        video_path = "https://media.giphy.com/media/2zoCeuXwuprH9zzPhP/giphy.gif";
                        description = "-Codo fijo en la vertical\n-Extensión de codo solo\n-Movimiento amplio pero cómodo\n-Espalda recta";
                        muscle_zone = "triceps";
                        hip_weight = "4/6/10/12/14";
                        res_weight ="2/4/8/10/12";
                        vol_weight = "6/8/12/14/16";
                        subclasses = "c.larga";
                        break;
                    case 147:
                        name = "Triceps Press Agarre Supino";
                        photo_path = "https://lh3.googleusercontent.com/7ufNJO2D1-aMH-61pZXBLNW0RMytmJta86wLBr7Ju8jwJ3CQTOzFZE3Xhn-lBwS9iAAbZu9jn5VUh76U_t9nHDmpQwatKiuV1BWPmdqVJ8adFqmm_3-HouSHufYu3EXdL_VoQUr5m-prkwhUOOUdJtgEKxaaCtQDmn0Sa5KBRyW67lYgrUjWidUn4IBMp79yofn9UTnAfd37xtuPOHqvPY9DEtSyZCrw-RhjYHWFxWaSL6Psfn3SqRZMTnnHjYJNT1Ll1v5TiI2JXwZpSWUQsALM_xecmZ7k0MGNQ6sPbxDxiJ5KlGdfdxRiqp8hM5xoCgIepgh8-_lnTmRvV2vRyno-zCQkiUaSChd1ANlK_eP2xLUsfZjU_Yd5YCWnysdjTPA2dyzxMJUU490uo7xB7D_qvd7_S4jIKTldRg6gjvMXJ0n7Tjzl5sfzt1vgCyNsZI0x6sflF_aGx7a1Mpqwd2sTg1aj81m244cDE6TEFghDIvXTGv0yFzmFoGaO6s2LcVRgP1N7b5TbbOLefiS1RvK1DyQJl7jJxuYX-C0zfCk7QEzGcvJZkaNXqJXjw1PVsAKXF1dwo0PMagq3ypPYHUdzpUPTEaT9Cj17Znkk3M5fGAVZDFnZh6UXNddZWc41tbz7WVF48Yp1vrVQv78OsRJQ=w713-h632-no";
                        video_path = "https://media.giphy.com/media/7FgWqCdOBfXk6tiHBv/giphy.gif";
                        description = "-Agarre supino\n-Codos al lado del tronco\n-Extiendo brazos\n-Movimiento controlado, cómodo\n-Cuerpo relajado";
                        muscle_zone = "triceps";
                        hip_weight = "8/10/14/16/20";
                        res_weight ="6/8/12/14/18";
                        vol_weight = "10/12/16/18/22";
                        subclasses = "c.media";
                        break;
                    case 148:
                        name = "Rotadores Internos Polea";
                        photo_path = "https://lh3.googleusercontent.com/2PxZaqKfqUg9mtl_oMD88mawm84FR2f-njRoneNIHwL4chyFDZB2UAqaxny5HCw6jyF4IMQDvZb9PLZdl9rvWMb0jeKrbzQlwEI_LHO-Gpu-3e_sPE1tvucYsvQq36GdVRWqwIrXSzFTN0WYoG_r831Y7Q8GZ84Yy5aR9kx6KFdgSgaa57jT0c_h-DVqhr1H-T8ZD2WTJVHO2D7TwGLTDFNnGsYF-ORRsNpVo7HEBrR6nU0NnU8V_JJYi8yk851aCYIhsGANDsgrEYWWQIGc8XMB8akjMysPbkXRx9u8mHDkF9Q93fnBvofLt2bMKVN6uI-RsjLQG_Kh3VvPo5kYoGI-bLYi-KLDVCEHv-XsrHf1UzatOyKjhZiaIIvGPaN-jremDqhnQ4mxbFEAHakHvtoPepO4rFHGYfozac6n4B7RrVLfRyDg1rGbuv7xQLJ5ujmgFJmmrHcadi8bOo5--0T1E1b3oRaF2T82PT4Bl_EyywQuWpzs6MJdinWjVYlY6YZ3NOwm4nBDWyuenYTlrp9S8v5u-XV1oXyMtbPd3lmAPzbL2x4aC62MZIjB0ywgRIezO6L__7W0dhFJo2msABma5w8xlsIq1pANwH8lLto83dHxXEhsc44IDofzGBae8xX_E8Xz7CNdkah8BOo-X30w=w713-h632-no";
                        video_path = "https://media.giphy.com/media/3xfoP4uynxy2uIDiej/giphy.gif";
                        description = "-Codo junto al tronco, codo 90º\n-Se mueve antebrazo solo\n-Estirar la polea hacia el interior\n-Vuelta controlada\n-Piernas semiflex., espalda recta";
                        muscle_zone = "upper-back";
                        hip_weight = "10/12.5/17.5/20/25";
                        res_weight ="7.5/10/15/17.5/22.5";
                        vol_weight = "12.5/15/20/22.5/27.5";
                        subclasses = "rot.int.";
                        break;
                    case 149:
                        name = "Rotadores Externos Polea";
                        photo_path = "https://lh3.googleusercontent.com/iFmDu70rEx7SWl_OqCXPjnWawHaDp7hGZPSEwksvO4DS4QS8t0fLDrSbeHsAeq-nlDknHRgnyhFvMHHArTHwrvbZ_jvhKq5oXIXngfsYDiNWXbaxEDAwlcyMoHO926WbBaNzenWDA59gyDb0eUakwFhfBaLubnZy-wZ4l2TWVHBFDdYceuc0nHFSxvWKuwHiYq2TGy4HLXnLEbUV3Yq7JpXU98j-M3NniZC6Yrtm4HgvlrsL5wemzf-vynFg7ToRDKNpwpK7-4A5dW7HL5yIbR5Pe3xjhSXpsyGqJFodV_VcMgxfrRxNLyMFMcmULDmcJTMRrlmqllnx8tWaOejEqy3RyYxqxOFXEWypeA9wK5yrQQtAUoHS9-xgFg7u-gL99caBUNdu6XvuyUrzVDdJUUIYbmcOKuM7yEDNIk-WsZXnkrekIGBTZ1Me9yySEiyLfMB4A-XlDL_D7GSmXVt3CbnkXtNUX5bbUIUqAKe7uaxSWX9c3z419PDfGSaqU5yYiuHld2DDfADAlvWCbdmmM8bSI6FGAB8Z8iaTuJzS5C7YgB6aM7EXNnLFFoFYH7T84vCNwxAoM6QNN2y2OT-wALeaLcP7HxEJHNCp6lo8c5Qksh-d7RzyM0wydO44oBk8aA_Ya-yGfSJ1_HaJbLDufeA8=w713-h632-no";
                        video_path = "https://media.giphy.com/media/j0NIgyrhWndODoblPI/giphy.gif";
                        description = "-Codo junto al tronco, codo 90º\n-Se mueve antebrazo solo\n-Estirar la polea hacia el exterior\n-Vuelta controlada\n-Piernas semiflex., espalda recta";
                        muscle_zone = "upper-back";
                        hip_weight = "7.5/10/15/17.5/22.5";
                        res_weight ="5/7.5/12.5/15/20";
                        vol_weight = "10/12.5/17.5/20/25";
                        subclasses = "rot.ext.";
                        break;
                    case 150:
                        name = "Supraespinoso Polea";
                        photo_path = "https://lh3.googleusercontent.com/SH181_V1CE9Ma2Wx6CmdBJUFvuuTdzLaJh45gUZzLnUXxznoYEqvNFWxHuhCsEkjZzPK9fsY78Ivv8Lw7sX2fU45EOWTRBjMTsoC-5Kc-knkpZuHvhXFaMOpK1fN6ovfVaYPIJDUcSCjUZxz_bQhzBCs0WQpp-WOmxmQlI-0RqCzq441As8F4w1e8eKeUy_KlGoYHF4phWIBEtmxnPMbiZaotRcxTugxXpl5fzWllaRsgdVmwZfCoL2t658BgRTCrWj_FJKUYeelXHl_koakgf5nohPBOAkaRmg04N4sKYBod43HH0Y08gOq9F0OyBqht_1Ec7Mp3cOyTogAwZ6h2IZT4e4mXrRDGmAVi3J6fqP8oHgtrr2p__ZwhsdC-gZrOHNHsMglwqHZN26cjLeUh8ke83KiVy_H4CYKVyan-_NtEDf6w4bBhH_R_Y034TGsflMRn9KVLjvz5fOTvsjJmlZOcQSdrC23Zq-tC6OdFEM3Qawt48hFNNLzjYzNgIZC9cSph5fa6E6hk0aGHxphWqtXZsJjr7wyyB0EVKubfxgJCgrWSXw6F1z8rPLaDpZX43SHiTlDra6z9Gl6_tkoNJVdpzh3Mwlt_X8uxLwX2YJFrRnewvm9KHe_KQvmk8Qb5vf1_pviNmHA3r_WwxBn4aDP=w713-h632-no";
                        video_path = "https://media.giphy.com/media/X8JjbYywM6iHynvnpW/giphy.gif";
                        description = "-Subida hasta los 45º\n-Brazos estirados\n-Bajada controlada\n-Movimiento harmónico, sin tirones\n-Espalda recta, piernas semiflex.";
                        muscle_zone = "upper-back";
                        hip_weight = "5/7.5/12.5/15/20";
                        res_weight ="2.5/5/10/12.5/17.5";
                        vol_weight = "7.5/10/15/17.5/22.5";
                        subclasses = "supraesp.";
                        break;

                }

                //insert in Exercises table
                db.execSQL("INSERT INTO Exercises (id, name, photo_path, video_path, description, muscle_zone, level, subclasses, hip_weight, res_weight, vol_weight, reps_obj, series) " +
                        "VALUES (" + id + ", '" + name + "', '" + photo_path + "', '" + video_path + "', '" + description + "', '" + muscle_zone + "', '" + level + "', '" + subclasses + "', '" + hip_weight + "', '" + res_weight + "', '" + vol_weight + "', '" + reps_obj + "','"+series+"')");



            }
        }

    }
}
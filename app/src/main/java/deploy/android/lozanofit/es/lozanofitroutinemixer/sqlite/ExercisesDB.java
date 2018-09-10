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

        //if db is opened correctly
        if(db != null)
        {
            //Insert 13 exercises
            for(int i=1; i<=13; i++)
            {
                //Create data
                int id = i;
                String name ="";
                String photo_path="";
                String video_path="";
                String description="";
                String muscle_zone="";

                switch(i) {
                    case 1 :
                        name = "Scott Dumbbell Curl";
                        photo_path = "https://lh3.googleusercontent.com/ahXRXJx0q7sVYKN4mTecvr1odkRjNhDI4PT9VUOHpMbo9Zpm6L_X_juYRxcyoaWU1J7kMKUh3-gT5X3c3Y6g_EKDx3I8y3tHtvcXjrPgptYUTiSBxk0V6FR_iiOiYNOcQYu0NemOx2lcq8EVBT5wryhwhowLBgN3g1IawBkVfSLDAyj_e1G0UnkZmRiuG3Dhp0Ien6O0lCt06w3WFXTiVFQwISLpjRsHYJWUvrK0QjZp0qQF8Tg6g0cjtagNk5kHjUWRGjjd9PUN3VqKHgTzDoMfm4x8Jruw9ut5xBIiYTmtCbE16U6zHI794-5DKsTVx7-whmidPGVfN03AaNY_91_yLY7-veXl7JgeII4RS8KvprJ__2Hyu2UdeUrFU-f6baLQ0XQoypz1Ktckl2tDRDKxnMLEcvSXMZxU_QzsULeMh0h5eip1LVy5aCSFusdPLVJcsKdKllolStCgDwiVjQ2OUT_GAKTiOwJ7FlV0DFBR0v3CQTrfIOK_Q7-kOZWAjklWBWmLJH54EIsTQrAPcj9eFStVvLUYwAwTb_T-yriuLDAalkk66WkNkICmMwKY-OjElwYyuHsmQR6p2Ke4-InR9WDiEaOEQffpBvUuVSFb3feccrm5OYqwtugLKUFSeIN7dftjLis1TUDn3U_jvZtgcxKO_hm1jP0dB-MxTZHDAkOsSvMxVH5X=w712-h632-no";
                        video_path = "https://res.cloudinary.com/dlc3xhhq5/video/upload/v1536586694/videoGeneral.mp4";
                        description = "Apoyar el codo en una superfície 90º inclinada, el brazo no baja hasta el final baja un poco menos, no mover hombros y espalda recta";
                        muscle_zone = "biceps";
                        break;
                    case 2 :
                        name = "Curl";
                        photo_path = "https://lh3.googleusercontent.com/9dX8q0rdbHl06S0zybhrOHjLBKqcQUSX9WhsulQwYXj67ZBi4Y28XEaP3UWvBjXt8fJu61ghRRYwO0i71bvzbNvc8j8RJ4B8dK2iXnddoyXOg0-hrG86i-TPSzbDS1TIwKyV4nMcMg9uDADyRYA5eRoko3ZyxZP2zB7rGJrxlKw-dVgevkmNSU23l_nGYXgIbOlwVh9qif-Fbugslj6Ueezq4FnpPTBwN12e8nFLjjlnvz0km681FY8iRRZ8tq41buxY5HWirmkaq6iA5nkiuCzAWcYb-9hywHRJpbgzdpzSoajYMQ9JQHSdFl35v-Z7a7rGbD5uiT11XFVWTqr0IxLET3zyI7v9bEp5CdGuS3QePSNn4cnmykqnNyPPPP_YYtCXX06i5qhkN6yqA-Eb6ItMGQetWIVxtfxBnGiKkdKC4i4mxKg-MMzbpT67RFlNtx6CJssLx9AktH8y1OWpsJWizX_8hAhCa79ym9zbWe7frrZptGBnPMg9ZMFZSGMWUl1E4fJ_yg4I8zypV6AifPdVl1haNPDEPuZNL5Dg4cEhPY2WiA6yPMg_vGHVzAPb6SgcvzLbTElY5x5QEv-9p6DVv8fF2jCQXpKnVk3pPcbGxWBW8syFeWmx1ctjTVfc9qfHWgcSmUnGaFJxGE_OFCRLaFOpOLW-JY8Gmacp-Vy0ML_MAURzuLAR=w711-h632-no";
                        video_path = "https://res.cloudinary.com/dlc3xhhq5/video/upload/v1536586694/videoGeneral.mp4";
                        description = "Palma mira al interior gira y mira arriba al final, espalda recta no mover hombro";
                        muscle_zone = "biceps";
                        break;
                    case 3 :
                        name = "Concentration Curl";
                        photo_path = "https://lh3.googleusercontent.com/lzAS7j1jzb76P1iit8soZ3jkC8aM3CBlfspwBmRKLTXyfDM4iAUB0Ex3He67u99cPKhc-zx04xbdahxGcoWQOXTckfVBoKYCrvXGj_6y8SykG4mnnIn76qqlZTh5Dpo_cGG5aKWKtxkiIMEy7fyfUnJs8yAXi9Dpgh7ILLRqzGFSFUq_UKsPECmvxTsGqBgsEFzXE99J5lEJEd0Wf8E9yo8GteNSS4A0CC7ihh-cfNhKswTLlFilxyNkdIxdUFLeGt9wKY5LgYGf4WNoFjNuFklJirSTNynjFwGcxVOrAH1sf2rYg7Pcye3plGKAixTC8bM6zv2wnWRVkD2xzNnFy4Y2dMmvJiWfSPVgU2L010KOH4ij6lUsVzIuuPrkC4agB43Kq9c4CtYVLZdYHzZDKl1PCkgSoxuVsitaWpul47gy736LNqVWtshk6Dvy6LeP7MyHJzUAJeenDuk_J3nVdte3Igf0TRh8C91egYhsgB0kFViSgg5CYvLX4TSenV_vtm140wjrcqHFYwumOLmccnf1Cp-QEYJrf3_txpGk5o9Mxo0ggEoCByMMukqE43_RmWl73fgF0MRTKPeRWNnCExlRzOMNchof70Wod-_fjTG6XWrx21_tXXV85u6D3q6WnEWlLCutYb3-m5FCP5Wum-usW6R2hszQ5y5VtMpSRBBxLUrzGDp9Gzz5=w713-h632-no";
                        video_path = "https://res.cloudinary.com/dlc3xhhq5/video/upload/v1536586694/videoGeneral.mp4";
                        description = "Codo apoyado en rodilla, espalda recta no mover hombro, brazo baja casi hasta abajo un poco menos";
                        muscle_zone = "biceps";
                        break;
                    case 4 :
                        name = "Hammer Curl";
                        photo_path = "https://lh3.googleusercontent.com/-GhEB-qYcj_5hNPnDJDE2yd5gssUYbj8PzRp6IvkYEesl65qepfNTQnXTDwH_wJpXzCbis-1IIfSw_Sd3OvTkaVMYLtSpm0s7p_JTbLu1f2RmKv_myRPTI3qHlVfr6TAv5hCJxDTPBbzB3fDUKSyySTcAn_9ceyLMk1MWRY9hzhWbsfNipsQYI4CnPgOvuXUqnxWwR3vr6UjtWHrgYnc_DeJoM1uvyaEPqxa4G7PJbH3ih8GfW3RrO1Mw6PDlzP_Scinm0pZXnVBAXrvEaI6D0T3h5jg7VKvD-tUIhtQW4K-UYh70uYEmt0Q-DWxsnTQUUtq3d1y2NtpY8FDDNmrp1xm1FCYciqfdeBqdPuBYZRNfrX_NNX_D6R2HmTV-cDn5CmcLlcJbxJAdFKKLn2rZWC5TpcjDp6sZebgDvgg96rrjXXnEqazMK21FuhjGMYTLiH3kaSXF77csKpyh0_1YvcKzjwEtkageXrqtiz9xzVzIWdIeEZb0VxIOcXtVtbixOzDUu3sIJ_bGPwXYVtRlaHSHXtqWBoO3RjSAJF8_qBK5AMyl1DiaCAgpUKeHuKhwh67sCtcdN0DbrsQk0R5pc_FPSNTdhqtaQtTQbbD321jnjSnaL2_KXf2WBkLE53w04-LAXUhOvm9VVlOoZs4__eDcStt1ekbpCnYVquRRI9T0pu8keQcfC91=w711-h632-no";
                        video_path = "https://res.cloudinary.com/dlc3xhhq5/video/upload/v1536586694/videoGeneral.mp4";
                        description = "La palma mira al interior, espalda recta piernas semiflexionadas no mover hombro";
                        muscle_zone = "biceps";
                        break;
                    case 5 :
                        name = "Dumbbell Press";
                        photo_path = "https://lh3.googleusercontent.com/OAsR0Y5CV4V9Re1vLvL26rJmx0rF8S-QW0ZEybFx54KQFIXMEt6D7op-P0pDVz10ndB7dp2HcHwejLaRIKXhEbBonGrh9rfBELJQr2muY5yRvhgmuNdhBjHeT7n6Nedthwl10ZHkaAPRQ5148ZgOpG5Nc4EW4UK4aBWA0YH9QlNXOZapa3VGSp9yok6_LuiKcbgGHM3-rnTT84hYnZyNGRA5QQfduM0G5JI4pYpr2LQ-uZ-9HUvnEIBZFY2Pr-axil5i7RT-GLsRknuBM2LuE_aqR7bGKkqsESk4F6grgzmCROw8uNmRcMyG9dCuhy9fuTEGl5lvtalPG3m8wMVbprHZXval47ma4MF-W2e1h_GYFLPKTWl7F7NjmN7JjwWg2zKnChoOlLQtrL7G5in9yHGC3dFN3EtbyfXLTzcRwK6GSguIA_RdnWR1pZ4I6jpjNaWSIF7Gr6Kzmdu2YfgqthpvscmbRLUbtxVz9cMASSYt5x405-1l_AEPgz5IiUmzX5BjG7Ry5hED-WGCGnI79Z5W2AXxGHc4wXocrTCBqHqq2LXKbZ-Khz9N9o72_naI2eG_oRoYySA19CDZvvfRZyGwadXPi2QhgUvg-UzoSWksGOF_VWifEQsjpeA7FkIV6VBZfRQSjm7fYqPrnlSb5f6FN22MVg1hJs0X_RoVvHmN_dLg--CGwUYU=w713-h632-no";
                        video_path = "https://res.cloudinary.com/dlc3xhhq5/video/upload/v1536586694/videoGeneral.mp4";
                        description = "Tumbado, codo-tronco 90 grados, codo baja un poco mas que el pecho, subida hacia arriba no arriba-interior";
                        muscle_zone = "chest";
                        break;
                    case 6 :
                        name = "Dumbbell Press 30º";
                        photo_path = "https://lh3.googleusercontent.com/xT8R3pxO365PVaQMy4wv6Z07EyE0kHuW4hEc_oSWLM_k7Z_uS2Mf0--cseIufgJlEABvDBxGusTH_ejt9I7rPg45ajU_Vip1UCOzoJ7Fi2_mnpw7ZJ3sVw7gBJserByzdkvW5xfqeXTh3zzMFU-T3Y4eWCfvY3ltrTJVaNtkONWLSl9uwuIk--LDZxa2eODzS_rtxMi_XGJv6do168FMwApczHKZkvuyYYvTS99EoDYBvXOd0WkzMTTWxlnHCA8EUv4lmaXvGle0V1lGsyuUPogIBPYiikK4UvotdSPosAH5VlzQEK5jQJzGNRSe8zkA8jfF9FLLfTFnKGJUh_I1kdU1oQyRSd118zhzreYLPbtZgHyl5P92qXhAXy9kQVVK6rBUJTRSfU_WJ-eLF2nqoZ7haCS7wZARetG76gnhm7sVi1lwAjRCmx7l5gtQSng0ZFxhCX5tABV1SSjFcTGLVF5YRAa9TATDycb6OZmcU_caYvbEIpIhKOIx9t6fdf77qf6_ujpq5nUSWhL6pGiI43t4ZwKSVKvD4qwfK2ZwZMQGcdioyQ0KaZGSND-a7dSlCJ4hRVNE7i72zT7M1cugqH0YwFuR-qgLPyCu_4ZDuCIqYfBfdrAMNCL0t4tnfpKqVEMiNLe6zDtd5moTf-gJIL9z_P7LWIcZSU1l0p91qLEzXUIWCHcwj_5E=w713-h632-no";
                        video_path = "https://res.cloudinary.com/dlc3xhhq5/video/upload/v1536586694/videoGeneral.mp4";
                        description = "Bank 30º inclination, codo-tronco 90º, codos bajan mas abajao que pecho, mancuernas suben rectas no diagonal interior";
                        muscle_zone = "chest";
                        break;
                    case 7 :
                        name = "Dumbbells Together Press 45º";
                        photo_path = "https://lh3.googleusercontent.com/TbaQW-bK4QhLx_7mAY7HtuprsjOcn2zPvoD-UHF0eVpprfYKZm3nsabVu65T6NtvQkxuSIbpUIEngx32HB_zRpfxpayBpb8LUYsWX_-u7BJFvkHhcU9CLehxU5PuFP0MMIhdqCvfC46nA0g_XlqjrrbJZWSB0Un-IR3_nmPplQWvEZDp_b4L6_VXagZn2MMjwwEKThRbZQn5a2nLIUebWFuVeK33fE8Ri9K-E5DcpvLlfUkXoroV4LN-xbqcc-D8XPzjokL25nFYyHS8Xb3MNkVr-oTq4m3KtE_xvp3uV7TEhuvIUlCOxSslBbcRDGziwqJpYDvgeCRUTINPAuEqNjScsPQ5xod9ybpUR3EGwtY2I6dUHW6ZLSFDtSXkpHO6Yc3-R2JX3SusRyJ0rWZl6VEslKSlhvBTBFtoGKGSo7J-sAWjEDCXavx6_v1iG22CNIxefQ0VQho4eNwWM34E900s1d2IshMVuyfB6LudMKFIvwfPkK7PrKPzuVuKlP0sdDgeOVV93GbBO0bu3vxKA3ASFjksCtE_Otke3O3Z-U_H3vTYjESkSG1iANIBpSk-HKLQDtwK9VbfcxuNsBwbb_kyWAUlpgIQUI1zQtAe6y2C1kOsMdJCKR-tirf17as-oEzpNBrGE8krghsP5eLNAiiXNWe_Lg24GahmVPzPF2Ha1DoORYF9SOA3=w713-h632-no";
                        video_path = "https://res.cloudinary.com/dlc3xhhq5/video/upload/v1536586694/videoGeneral.mp4";
                        description = "Banco 45º inclinado, mancuernas se tocan por los lados, bajar hasta casi tocar el pecho, codos comodos al lado";
                        muscle_zone = "chest";
                        break;
                    case 8 :
                        name = "Chest Push-up";
                        photo_path = "https://lh3.googleusercontent.com/o8hx3aCFHAfKgM3H2cnXpie_0Y3YvPpO8OoTDUfiq7E29D1QMPeVU4luNJzDEa3FQKpCachrMViR3J3TNa3fyyj62qtB3cI7fkxCyXh1X3_AzPWetMnydD51Ura6L41o5ZlcHHJha8yVYOaspigCwDEOJC3GZXg1dzX7Uci3PCtwgSXWj8GDO54Y4gql6Ocw80Zy6rfrgC2YQlyNHDNpOWL8ecr6qB0wpHi8lTd6AYEhmKrDSKA-NCfreKO2YjjwD0CH-ZiOSA6psmI6pa-1MqJXm9d9iSR_nnvdsQI1U70ViyyBzjuhUO31vF8yAtv0MO5h4pGUQ6v6w0m-4K6jsZ2n6u2vkWP1zoyn-yfPoOmRmyvwSVwWly2L0jhJ_B5MQ6JVEuPRnpKaD_ktZWzwqTXMXStOZQfWIt0NjV8VQO1PA0Prwi3QkA4AcVmV7KvW-E6nOFgN1RT0BS34fPzL_F6URrQd1hBav523h3IGdLF1XFAFre8vQPRMpgV_3T1bJnmVc1xvdUPhUdMpezdcDo_WJIIZPzb1OIIPfzBEQ1UF6ntJzoU1PBlLWLuZvcsHCYkOzuleCIf8Fb7IVtuS2SBWHHAPcY3G4fop88Fmwj6cwg3EMtUSvDmY-qjRTkgFRKrd69aqA8h8l6suJh4n3D_MltAgpEkYrOCxZpjLESH8vn9Rc-F_5vao=w713-h632-no";
                        video_path = "https://res.cloudinary.com/dlc3xhhq5/video/upload/v1536586694/videoGeneral.mp4";
                        description = "codo-tronco un poco menos de 90º, bajar hasta casi tocar suelo, espalda recta abdominal bloqueado como si fuese una plancha todo el rato";
                        muscle_zone = "chest";
                        break;
                    case 9 :
                        name = "Superabs";
                        photo_path = "https://lh3.googleusercontent.com/kwL5-slwlAxzy8KgsjntM-ai2F8bChUj0dMd4SsuoEBkwIHoiE8VKY_GqKMn3unxUcv2hQS1nEoFYsX27CPVO_5YoxJZoexKqf2OUW35F2yZmaDN9KTiOC7qKQ_zyttMBLh4COF_y_x3oiKKOLZTTYcXuYdKt8NsKBZPRg-UyRz8bLTqAnpKDCPIRnq15ibRyyDZo3ZEAasVXKvVmqOFG50ATRCP9qwEiutXmDvqm6iEEdwGV6NxD0NBR7RJFgr4iWDbzdO3yCqRNKlRISeCSU5QZZyUwjSN2xY2U5zmNhRzqxSzHjbeloDk1lpf5r08m_-adHudzGDeItqEmWIGGP1WlPBtjjjNwMX9yHNNyjIr7ZQiwoor6SQ0eKIE-d3XTz_dB0kyPyVfKammtIug0oaFvPJFHtV_mdt6G6ZRbqlyqOYEn6VgXTo7ttAg9tOsg8QHjo6hoUpyUxhVKp845-gXsqTVZVooxMzd0r4RW4unW7uF0p4zCTIsCp2WhF6HAqJa9KqN21sR7QplB9XaZCwnjX2k7Wf5uhB7Q6w34QSRxQy9elcmHVSyU5ombfU4xRlJ_Ray1C_DgcsseBLTmPpdI9L-OHldA_q5CFWuv96Aun422WMBEmttz0AtSZbl5oU676tDyrGKdkbKiZGGAkwMyFkjdpfML2VZ0QDHGdfqVPODm7uZ7NBC=w713-h632-no";
                        video_path = "https://res.cloudinary.com/dlc3xhhq5/video/upload/v1536586694/videoGeneral.mp4";
                        description = "Espalda en el suelo pies y brazos estirados formando una V, abdominal de espalda (piernas bloqueadas), vuelta a la posicion inicial, abdominal de cadera, vuelta a la posicion inicial";
                        muscle_zone = "abs";
                        break;
                    case 10 :
                        name = "Crunch";
                        photo_path = "https://lh3.googleusercontent.com/5cG7Lb3XI_wR6HGdvjBeGlYosgqLmmxwO6exv-SNm8uCsYenQVeZJDhv_8cBfd5sstWsvL5GhCXPSIihQUkVNVDyDZv3nEhb1Zkb4ciafJIvApdyFu9ZOooal7Q1k-IFe8_MD-o1jSLpdhYEyUp4vEG3FSPnuRvj78JTrx_SJvDBx9TRmgTdA_VvJh46uJ9IoLbGXZCbcjDNu-_3LN5KhSrj8DnqB6cD3nlKzWLw8WjL6mtggXu4fnFGiI8ANNJxZkst6BVBGx-B0ZzHTrT-F6bICqgSz68eIty1S2SB_HNnuZFFZVLyuzKI8krP-7e5EoXt2E2f9-ocwwU4VHD7gvssU3s08IBANd13QAPdzppX87NYtZzZH7ozlM3sCdoSI35hFaSg_2W2glq1oqOC2rQJpT-PGa2lc8iDJLwN2MUIzAnQu4FmqAh5GRbG0M8-2WiL9I7nrhk167LHHnpCOe5Af7MMn2avS9KQXOms0gAy86A6fbn_wzfoJ6kA6vPQ1zobcz3DEbidEj7j5gJ8xggDI5eFf9fZaDiaaxFPTM-QwEgJCMNzz1Y3hb96xAL6kDiJqKVnt_dJZBCN9BWgFBPNxfDQKQ79vB-2YsODSs4XgIZvVIXQeGjERLbSk5MksK18tTRJxMlhT6wIuTGRBSWeKLPVq5lC1DdPqbxv_V73JnQKTSbYJimw=w713-h632-no";
                        video_path = "https://res.cloudinary.com/dlc3xhhq5/video/upload/v1536586694/videoGeneral.mp4";
                        description = "Piernas en V tocando el suelo, barbilla cerca del pecho, peso en el pecho, subida hasta los 45º";
                        muscle_zone = "abs";
                        break;
                    case 11 :
                        name = "Lateral crunch";
                        photo_path = "https://lh3.googleusercontent.com/BLhQ6d-NXC0uR0_aB7vJPFZ04iDBFlL91rP9ujFpTGXbkDUU3FxukLtaJoYsU69zxZPXAtf6Jq8MCciJ6CQh4Gt0PVJ9NVa3dDu-vmemQbFFO0ow65u6kFrBNLmYdkmS6KZCoXO2O8j9klmsIDLapnIAi_NBXL_ftgDal0ZU_Kqae_BPCqwznUtDvhEWKrHOnWxEk9lqAxEcAVS0PT2bP1wuDBQ6w-rLQC6CzW0dxxTZme4jqsU6xxMZqaI0wCb82rvzz9IWaC8LrOw4i1lR0NHwGl9XJBjKGnNKRZIPiZQp_SY7Ii-OWxhtG4tqNgO3F4Mnqqzu2098kSfsGceD9KKjhQ5wlxLAAonStQVdqNM9R5s46YvQKj8Wxqi7qlFxtCFn4UFazT1phXyakW_51DBRNSLtcgmQqg4v57VypJ9Ir7XcFRbxVi_g3mCpd3N2__s3tBC3m9w9UfppwSRpghH5mxXqWxWlio6EjFiepgqU-eDp8ID8Uw8Ah3iZzMPcMo8sWLKFd0RUDDWiVQmq0LUEKnAw1YGAGn8Ne1e0_lZCE4G97Y2foPSTRXQwPUHboKDACEV-ztyd3iaq1YHIw8dst4Z5Eo8dcPGrDAQBKIeDEIfv4kABI4tl8WwpaulAeG5FmXHezctps0g85F4U7GZ57lVPkSvHY3lQ0kUAnqz5HbZEu5hfWxZl=w711-h632-no";
                        video_path = "https://res.cloudinary.com/dlc3xhhq5/video/upload/v1536586694/videoGeneral.mp4";
                        description = "Tumbado supino piernas hacia un costado en V, abdominal con hombro que se dirige hacia arriba y interior, como si te levantaras, peso en un costado del pecho (lado exterior al movimiento)";
                        muscle_zone = "abs";
                        break;
                    case 12 :
                        name = "Bodysaw";
                        photo_path = "https://lh3.googleusercontent.com/vqmFto7WWxVWbDfWyndORuFiunN4TwGf6uEoaxmV-6zmCVGATNEHsR3vLemyUlOygCcFz_xPBbQRWMEBUCalrPOh7V3hREsY2hTPhYQudHnUjrBDe8j-6K_dmXN5FOAya6r-Dm28wyvgRLzR0SXIpHMaBW8H8PUhr9yn9uYgjfvPUpgj-6QzsR4OA6-yXTYN06FNMh6R7r7Gd2C01cKRuBaJ1Ge90BeLvukPWPgziEj6yZ5mxuQN_m3rtg_HZSmQGU87bhPXqHIhAKYEkLy9ORICjKRDYLNMNjRiQvhET_pX79lU6AU5t5M_9lfjdVOhCsKEa-OWjiEHIMNqN6gLMs26ltIC8p-osh1wq79FbyTNCn2PG2A9XBgd4rHxPuuHn9NvPkB-hkwDsHvcK47ojzYcesu7l61JmcNPgRCuzci2TViMpomKGcbXZ8YnxsK3acm9xGu8GK3-TYrxYz7ToVIV8X9HsaIQtQ-ZSSjP8dOwm0FL9_VTbkSKm5pGfvGv0gNtS57bwaRKnu66uXGNUTdjJJ6KIIVqSBxSvsZnR8UNktw__7JCdGyXLXWQtaWoJhAOIpYVBpUVeLl1YmYU6KqsC3mlyRoY0N-keXjWbNChO9xv1Adj7u3CmU0QYG3F-KsgqMgnWnMncEUZXjrFrbiyAXivf2DZ6yXm-iW7JfHeX23B0lWeXY7S=w711-h632-no";
                        video_path = "https://res.cloudinary.com/dlc3xhhq5/video/upload/v1536586694/videoGeneral.mp4";
                        description = "Plancha, abdominal-lumbares-piernas bloqueados, glidings o algo para deslizar en los pies, movimiento hacia delante-atras, los brazos mueven el cuerpo bloqueado";
                        muscle_zone = "abs";
                        break;
                    case 13 :
                        name = "Lateral Plank";
                        photo_path = "https://lh3.googleusercontent.com/chEHIxmGJAoekfd8cHs2d__Qb_cvUQtd3eP_Oq4JjzGMaFlLcGeML6pRr1h0g-KUwt63EmlbPxSUjp7S90gYqn8v3l_qs4BUJEeuBvzWnM-NUWOO_VO99cc7U-k8cpJWQVMeYRC-YWf7oYVg5oTCM6FxEb3nfg09ec1HrXg4kyZY1yKFODtZEjjTxtSJDYcg3WF72YgqxionKcJlJYU47jAg7u8L716qOVbeIyaFAzT7XPGZxvKj8SFnQFVc0E4g2xMpgC-9QX25jm1SYRXj3egEmaqjghKlmwJfQYDBHM9ePXGkz2qQDe-VzwDBHm-kbL-RjwkBR_eD1UkKVfjE98Tuk0m6OhRgJ6sWY2fz9G4IjgAhrMxWfCT8u6_UKrb2EvA0EgW_L2NO2weptUmIlczU_sXZiq1OX2NYup_AMT0iOrYufYpHs5iFmsWQ2Piltw0e_-FyddmmoKw_thGphpNF4PuB1mwPTYtRZWPqfdaUyHOTSqUAq_M9sT4CMUo76uiPTHrL-tuKb7Jh4nRhodMVDR8z6KmHQJuL--LNiSA0PQRYBXay-rVThDY81XFxhxBpaD34HOOxbnqOeUG4EK8hywBIsuywq04s39N5PP2XpC0I40vrvFzrB6ni2P06Y6LUfwaJE_fJmalMGUXDuNzErTxqGR6wcs36S-_bGSGBNXwYiMmOm8EW=w711-h632-no";
                        video_path = "https://res.cloudinary.com/dlc3xhhq5/video/upload/v1536586694/videoGeneral.mp4";
                        description = "Plancha lateral, no bajar cadera, cuerpo bloqueado";
                        muscle_zone = "abs";
                        break;
                }

                //insert in Exercises table
                db.execSQL("INSERT INTO Exercises (id, name, photo_path, video_path, description, muscle_zone) " +
                        "VALUES (" + id + ", '" + name +"', '"+ photo_path +"', '"+ video_path +"', '"+ description +"', '"+ muscle_zone +"')");
            }
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int idx, int i1) {

        db.execSQL("DROP TABLE IF EXISTS Exercises");
        db.execSQL(sqlCreate);

        //if db is opened correctly (COPIED FROM onCreate method above!!)
        if(db != null)
        {
            //Insert 13 exercises
            for(int i=1; i<=13; i++)
            {
                //Create data
                int id = i;
                String name ="";
                String photo_path="";
                String video_path="";
                String description="";
                String muscle_zone="";

                switch(i) {
                    case 1 :
                        name = "Scott Dumbbell Curl";
                        photo_path = "https://lh3.googleusercontent.com/ahXRXJx0q7sVYKN4mTecvr1odkRjNhDI4PT9VUOHpMbo9Zpm6L_X_juYRxcyoaWU1J7kMKUh3-gT5X3c3Y6g_EKDx3I8y3tHtvcXjrPgptYUTiSBxk0V6FR_iiOiYNOcQYu0NemOx2lcq8EVBT5wryhwhowLBgN3g1IawBkVfSLDAyj_e1G0UnkZmRiuG3Dhp0Ien6O0lCt06w3WFXTiVFQwISLpjRsHYJWUvrK0QjZp0qQF8Tg6g0cjtagNk5kHjUWRGjjd9PUN3VqKHgTzDoMfm4x8Jruw9ut5xBIiYTmtCbE16U6zHI794-5DKsTVx7-whmidPGVfN03AaNY_91_yLY7-veXl7JgeII4RS8KvprJ__2Hyu2UdeUrFU-f6baLQ0XQoypz1Ktckl2tDRDKxnMLEcvSXMZxU_QzsULeMh0h5eip1LVy5aCSFusdPLVJcsKdKllolStCgDwiVjQ2OUT_GAKTiOwJ7FlV0DFBR0v3CQTrfIOK_Q7-kOZWAjklWBWmLJH54EIsTQrAPcj9eFStVvLUYwAwTb_T-yriuLDAalkk66WkNkICmMwKY-OjElwYyuHsmQR6p2Ke4-InR9WDiEaOEQffpBvUuVSFb3feccrm5OYqwtugLKUFSeIN7dftjLis1TUDn3U_jvZtgcxKO_hm1jP0dB-MxTZHDAkOsSvMxVH5X=w712-h632-no";
                        video_path = "https://res.cloudinary.com/dlc3xhhq5/video/upload/v1536586694/videoGeneral.mp4";
                        description = "Apoyar el codo en una superfície 90º inclinada, el brazo no baja hasta el final baja un poco menos, no mover hombros y espalda recta";
                        muscle_zone = "biceps";
                        break;
                    case 2 :
                        name = "Curl";
                        photo_path = "https://lh3.googleusercontent.com/9dX8q0rdbHl06S0zybhrOHjLBKqcQUSX9WhsulQwYXj67ZBi4Y28XEaP3UWvBjXt8fJu61ghRRYwO0i71bvzbNvc8j8RJ4B8dK2iXnddoyXOg0-hrG86i-TPSzbDS1TIwKyV4nMcMg9uDADyRYA5eRoko3ZyxZP2zB7rGJrxlKw-dVgevkmNSU23l_nGYXgIbOlwVh9qif-Fbugslj6Ueezq4FnpPTBwN12e8nFLjjlnvz0km681FY8iRRZ8tq41buxY5HWirmkaq6iA5nkiuCzAWcYb-9hywHRJpbgzdpzSoajYMQ9JQHSdFl35v-Z7a7rGbD5uiT11XFVWTqr0IxLET3zyI7v9bEp5CdGuS3QePSNn4cnmykqnNyPPPP_YYtCXX06i5qhkN6yqA-Eb6ItMGQetWIVxtfxBnGiKkdKC4i4mxKg-MMzbpT67RFlNtx6CJssLx9AktH8y1OWpsJWizX_8hAhCa79ym9zbWe7frrZptGBnPMg9ZMFZSGMWUl1E4fJ_yg4I8zypV6AifPdVl1haNPDEPuZNL5Dg4cEhPY2WiA6yPMg_vGHVzAPb6SgcvzLbTElY5x5QEv-9p6DVv8fF2jCQXpKnVk3pPcbGxWBW8syFeWmx1ctjTVfc9qfHWgcSmUnGaFJxGE_OFCRLaFOpOLW-JY8Gmacp-Vy0ML_MAURzuLAR=w711-h632-no";
                        video_path = "https://res.cloudinary.com/dlc3xhhq5/video/upload/v1536586694/videoGeneral.mp4";
                        description = "Palma mira al interior gira y mira arriba al final, espalda recta no mover hombro";
                        muscle_zone = "biceps";
                        break;
                    case 3 :
                        name = "Concentration Curl";
                        photo_path = "https://lh3.googleusercontent.com/lzAS7j1jzb76P1iit8soZ3jkC8aM3CBlfspwBmRKLTXyfDM4iAUB0Ex3He67u99cPKhc-zx04xbdahxGcoWQOXTckfVBoKYCrvXGj_6y8SykG4mnnIn76qqlZTh5Dpo_cGG5aKWKtxkiIMEy7fyfUnJs8yAXi9Dpgh7ILLRqzGFSFUq_UKsPECmvxTsGqBgsEFzXE99J5lEJEd0Wf8E9yo8GteNSS4A0CC7ihh-cfNhKswTLlFilxyNkdIxdUFLeGt9wKY5LgYGf4WNoFjNuFklJirSTNynjFwGcxVOrAH1sf2rYg7Pcye3plGKAixTC8bM6zv2wnWRVkD2xzNnFy4Y2dMmvJiWfSPVgU2L010KOH4ij6lUsVzIuuPrkC4agB43Kq9c4CtYVLZdYHzZDKl1PCkgSoxuVsitaWpul47gy736LNqVWtshk6Dvy6LeP7MyHJzUAJeenDuk_J3nVdte3Igf0TRh8C91egYhsgB0kFViSgg5CYvLX4TSenV_vtm140wjrcqHFYwumOLmccnf1Cp-QEYJrf3_txpGk5o9Mxo0ggEoCByMMukqE43_RmWl73fgF0MRTKPeRWNnCExlRzOMNchof70Wod-_fjTG6XWrx21_tXXV85u6D3q6WnEWlLCutYb3-m5FCP5Wum-usW6R2hszQ5y5VtMpSRBBxLUrzGDp9Gzz5=w713-h632-no";
                        video_path = "https://res.cloudinary.com/dlc3xhhq5/video/upload/v1536586694/videoGeneral.mp4";
                        description = "Codo apoyado en rodilla, espalda recta no mover hombro, brazo baja casi hasta abajo un poco menos";
                        muscle_zone = "biceps";
                        break;
                    case 4 :
                        name = "Hammer Curl";
                        photo_path = "https://lh3.googleusercontent.com/-GhEB-qYcj_5hNPnDJDE2yd5gssUYbj8PzRp6IvkYEesl65qepfNTQnXTDwH_wJpXzCbis-1IIfSw_Sd3OvTkaVMYLtSpm0s7p_JTbLu1f2RmKv_myRPTI3qHlVfr6TAv5hCJxDTPBbzB3fDUKSyySTcAn_9ceyLMk1MWRY9hzhWbsfNipsQYI4CnPgOvuXUqnxWwR3vr6UjtWHrgYnc_DeJoM1uvyaEPqxa4G7PJbH3ih8GfW3RrO1Mw6PDlzP_Scinm0pZXnVBAXrvEaI6D0T3h5jg7VKvD-tUIhtQW4K-UYh70uYEmt0Q-DWxsnTQUUtq3d1y2NtpY8FDDNmrp1xm1FCYciqfdeBqdPuBYZRNfrX_NNX_D6R2HmTV-cDn5CmcLlcJbxJAdFKKLn2rZWC5TpcjDp6sZebgDvgg96rrjXXnEqazMK21FuhjGMYTLiH3kaSXF77csKpyh0_1YvcKzjwEtkageXrqtiz9xzVzIWdIeEZb0VxIOcXtVtbixOzDUu3sIJ_bGPwXYVtRlaHSHXtqWBoO3RjSAJF8_qBK5AMyl1DiaCAgpUKeHuKhwh67sCtcdN0DbrsQk0R5pc_FPSNTdhqtaQtTQbbD321jnjSnaL2_KXf2WBkLE53w04-LAXUhOvm9VVlOoZs4__eDcStt1ekbpCnYVquRRI9T0pu8keQcfC91=w711-h632-no";
                        video_path = "https://res.cloudinary.com/dlc3xhhq5/video/upload/v1536586694/videoGeneral.mp4";
                        description = "La palma mira al interior, espalda recta piernas semiflexionadas no mover hombro";
                        muscle_zone = "biceps";
                        break;
                    case 5 :
                        name = "Dumbbell Press";
                        photo_path = "https://lh3.googleusercontent.com/OAsR0Y5CV4V9Re1vLvL26rJmx0rF8S-QW0ZEybFx54KQFIXMEt6D7op-P0pDVz10ndB7dp2HcHwejLaRIKXhEbBonGrh9rfBELJQr2muY5yRvhgmuNdhBjHeT7n6Nedthwl10ZHkaAPRQ5148ZgOpG5Nc4EW4UK4aBWA0YH9QlNXOZapa3VGSp9yok6_LuiKcbgGHM3-rnTT84hYnZyNGRA5QQfduM0G5JI4pYpr2LQ-uZ-9HUvnEIBZFY2Pr-axil5i7RT-GLsRknuBM2LuE_aqR7bGKkqsESk4F6grgzmCROw8uNmRcMyG9dCuhy9fuTEGl5lvtalPG3m8wMVbprHZXval47ma4MF-W2e1h_GYFLPKTWl7F7NjmN7JjwWg2zKnChoOlLQtrL7G5in9yHGC3dFN3EtbyfXLTzcRwK6GSguIA_RdnWR1pZ4I6jpjNaWSIF7Gr6Kzmdu2YfgqthpvscmbRLUbtxVz9cMASSYt5x405-1l_AEPgz5IiUmzX5BjG7Ry5hED-WGCGnI79Z5W2AXxGHc4wXocrTCBqHqq2LXKbZ-Khz9N9o72_naI2eG_oRoYySA19CDZvvfRZyGwadXPi2QhgUvg-UzoSWksGOF_VWifEQsjpeA7FkIV6VBZfRQSjm7fYqPrnlSb5f6FN22MVg1hJs0X_RoVvHmN_dLg--CGwUYU=w713-h632-no";
                        video_path = "https://res.cloudinary.com/dlc3xhhq5/video/upload/v1536586694/videoGeneral.mp4";
                        description = "Tumbado, codo-tronco 90 grados, codo baja un poco mas que el pecho, subida hacia arriba no arriba-interior";
                        muscle_zone = "chest";
                        break;
                    case 6 :
                        name = "Dumbbell Press 30º";
                        photo_path = "https://lh3.googleusercontent.com/xT8R3pxO365PVaQMy4wv6Z07EyE0kHuW4hEc_oSWLM_k7Z_uS2Mf0--cseIufgJlEABvDBxGusTH_ejt9I7rPg45ajU_Vip1UCOzoJ7Fi2_mnpw7ZJ3sVw7gBJserByzdkvW5xfqeXTh3zzMFU-T3Y4eWCfvY3ltrTJVaNtkONWLSl9uwuIk--LDZxa2eODzS_rtxMi_XGJv6do168FMwApczHKZkvuyYYvTS99EoDYBvXOd0WkzMTTWxlnHCA8EUv4lmaXvGle0V1lGsyuUPogIBPYiikK4UvotdSPosAH5VlzQEK5jQJzGNRSe8zkA8jfF9FLLfTFnKGJUh_I1kdU1oQyRSd118zhzreYLPbtZgHyl5P92qXhAXy9kQVVK6rBUJTRSfU_WJ-eLF2nqoZ7haCS7wZARetG76gnhm7sVi1lwAjRCmx7l5gtQSng0ZFxhCX5tABV1SSjFcTGLVF5YRAa9TATDycb6OZmcU_caYvbEIpIhKOIx9t6fdf77qf6_ujpq5nUSWhL6pGiI43t4ZwKSVKvD4qwfK2ZwZMQGcdioyQ0KaZGSND-a7dSlCJ4hRVNE7i72zT7M1cugqH0YwFuR-qgLPyCu_4ZDuCIqYfBfdrAMNCL0t4tnfpKqVEMiNLe6zDtd5moTf-gJIL9z_P7LWIcZSU1l0p91qLEzXUIWCHcwj_5E=w713-h632-no";
                        video_path = "https://res.cloudinary.com/dlc3xhhq5/video/upload/v1536586694/videoGeneral.mp4";
                        description = "Bank 30º inclination, codo-tronco 90º, codos bajan mas abajao que pecho, mancuernas suben rectas no diagonal interior";
                        muscle_zone = "chest";
                        break;
                    case 7 :
                        name = "Dumbbells Together Press 45º";
                        photo_path = "https://lh3.googleusercontent.com/TbaQW-bK4QhLx_7mAY7HtuprsjOcn2zPvoD-UHF0eVpprfYKZm3nsabVu65T6NtvQkxuSIbpUIEngx32HB_zRpfxpayBpb8LUYsWX_-u7BJFvkHhcU9CLehxU5PuFP0MMIhdqCvfC46nA0g_XlqjrrbJZWSB0Un-IR3_nmPplQWvEZDp_b4L6_VXagZn2MMjwwEKThRbZQn5a2nLIUebWFuVeK33fE8Ri9K-E5DcpvLlfUkXoroV4LN-xbqcc-D8XPzjokL25nFYyHS8Xb3MNkVr-oTq4m3KtE_xvp3uV7TEhuvIUlCOxSslBbcRDGziwqJpYDvgeCRUTINPAuEqNjScsPQ5xod9ybpUR3EGwtY2I6dUHW6ZLSFDtSXkpHO6Yc3-R2JX3SusRyJ0rWZl6VEslKSlhvBTBFtoGKGSo7J-sAWjEDCXavx6_v1iG22CNIxefQ0VQho4eNwWM34E900s1d2IshMVuyfB6LudMKFIvwfPkK7PrKPzuVuKlP0sdDgeOVV93GbBO0bu3vxKA3ASFjksCtE_Otke3O3Z-U_H3vTYjESkSG1iANIBpSk-HKLQDtwK9VbfcxuNsBwbb_kyWAUlpgIQUI1zQtAe6y2C1kOsMdJCKR-tirf17as-oEzpNBrGE8krghsP5eLNAiiXNWe_Lg24GahmVPzPF2Ha1DoORYF9SOA3=w713-h632-no";
                        video_path = "https://res.cloudinary.com/dlc3xhhq5/video/upload/v1536586694/videoGeneral.mp4";
                        description = "Banco 45º inclinado, mancuernas se tocan por los lados, bajar hasta casi tocar el pecho, codos comodos al lado";
                        muscle_zone = "chest";
                        break;
                    case 8 :
                        name = "Chest Push-up";
                        photo_path = "https://lh3.googleusercontent.com/o8hx3aCFHAfKgM3H2cnXpie_0Y3YvPpO8OoTDUfiq7E29D1QMPeVU4luNJzDEa3FQKpCachrMViR3J3TNa3fyyj62qtB3cI7fkxCyXh1X3_AzPWetMnydD51Ura6L41o5ZlcHHJha8yVYOaspigCwDEOJC3GZXg1dzX7Uci3PCtwgSXWj8GDO54Y4gql6Ocw80Zy6rfrgC2YQlyNHDNpOWL8ecr6qB0wpHi8lTd6AYEhmKrDSKA-NCfreKO2YjjwD0CH-ZiOSA6psmI6pa-1MqJXm9d9iSR_nnvdsQI1U70ViyyBzjuhUO31vF8yAtv0MO5h4pGUQ6v6w0m-4K6jsZ2n6u2vkWP1zoyn-yfPoOmRmyvwSVwWly2L0jhJ_B5MQ6JVEuPRnpKaD_ktZWzwqTXMXStOZQfWIt0NjV8VQO1PA0Prwi3QkA4AcVmV7KvW-E6nOFgN1RT0BS34fPzL_F6URrQd1hBav523h3IGdLF1XFAFre8vQPRMpgV_3T1bJnmVc1xvdUPhUdMpezdcDo_WJIIZPzb1OIIPfzBEQ1UF6ntJzoU1PBlLWLuZvcsHCYkOzuleCIf8Fb7IVtuS2SBWHHAPcY3G4fop88Fmwj6cwg3EMtUSvDmY-qjRTkgFRKrd69aqA8h8l6suJh4n3D_MltAgpEkYrOCxZpjLESH8vn9Rc-F_5vao=w713-h632-no";
                        video_path = "https://res.cloudinary.com/dlc3xhhq5/video/upload/v1536586694/videoGeneral.mp4";
                        description = "codo-tronco un poco menos de 90º, bajar hasta casi tocar suelo, espalda recta abdominal bloqueado como si fuese una plancha todo el rato";
                        muscle_zone = "chest";
                        break;
                    case 9 :
                        name = "Superabs";
                        photo_path = "https://lh3.googleusercontent.com/kwL5-slwlAxzy8KgsjntM-ai2F8bChUj0dMd4SsuoEBkwIHoiE8VKY_GqKMn3unxUcv2hQS1nEoFYsX27CPVO_5YoxJZoexKqf2OUW35F2yZmaDN9KTiOC7qKQ_zyttMBLh4COF_y_x3oiKKOLZTTYcXuYdKt8NsKBZPRg-UyRz8bLTqAnpKDCPIRnq15ibRyyDZo3ZEAasVXKvVmqOFG50ATRCP9qwEiutXmDvqm6iEEdwGV6NxD0NBR7RJFgr4iWDbzdO3yCqRNKlRISeCSU5QZZyUwjSN2xY2U5zmNhRzqxSzHjbeloDk1lpf5r08m_-adHudzGDeItqEmWIGGP1WlPBtjjjNwMX9yHNNyjIr7ZQiwoor6SQ0eKIE-d3XTz_dB0kyPyVfKammtIug0oaFvPJFHtV_mdt6G6ZRbqlyqOYEn6VgXTo7ttAg9tOsg8QHjo6hoUpyUxhVKp845-gXsqTVZVooxMzd0r4RW4unW7uF0p4zCTIsCp2WhF6HAqJa9KqN21sR7QplB9XaZCwnjX2k7Wf5uhB7Q6w34QSRxQy9elcmHVSyU5ombfU4xRlJ_Ray1C_DgcsseBLTmPpdI9L-OHldA_q5CFWuv96Aun422WMBEmttz0AtSZbl5oU676tDyrGKdkbKiZGGAkwMyFkjdpfML2VZ0QDHGdfqVPODm7uZ7NBC=w713-h632-no";
                        video_path = "https://res.cloudinary.com/dlc3xhhq5/video/upload/v1536586694/videoGeneral.mp4";
                        description = "Espalda en el suelo pies y brazos estirados formando una V, abdominal de espalda (piernas bloqueadas), vuelta a la posicion inicial, abdominal de cadera, vuelta a la posicion inicial";
                        muscle_zone = "abs";
                        break;
                    case 10 :
                        name = "Crunch";
                        photo_path = "https://lh3.googleusercontent.com/5cG7Lb3XI_wR6HGdvjBeGlYosgqLmmxwO6exv-SNm8uCsYenQVeZJDhv_8cBfd5sstWsvL5GhCXPSIihQUkVNVDyDZv3nEhb1Zkb4ciafJIvApdyFu9ZOooal7Q1k-IFe8_MD-o1jSLpdhYEyUp4vEG3FSPnuRvj78JTrx_SJvDBx9TRmgTdA_VvJh46uJ9IoLbGXZCbcjDNu-_3LN5KhSrj8DnqB6cD3nlKzWLw8WjL6mtggXu4fnFGiI8ANNJxZkst6BVBGx-B0ZzHTrT-F6bICqgSz68eIty1S2SB_HNnuZFFZVLyuzKI8krP-7e5EoXt2E2f9-ocwwU4VHD7gvssU3s08IBANd13QAPdzppX87NYtZzZH7ozlM3sCdoSI35hFaSg_2W2glq1oqOC2rQJpT-PGa2lc8iDJLwN2MUIzAnQu4FmqAh5GRbG0M8-2WiL9I7nrhk167LHHnpCOe5Af7MMn2avS9KQXOms0gAy86A6fbn_wzfoJ6kA6vPQ1zobcz3DEbidEj7j5gJ8xggDI5eFf9fZaDiaaxFPTM-QwEgJCMNzz1Y3hb96xAL6kDiJqKVnt_dJZBCN9BWgFBPNxfDQKQ79vB-2YsODSs4XgIZvVIXQeGjERLbSk5MksK18tTRJxMlhT6wIuTGRBSWeKLPVq5lC1DdPqbxv_V73JnQKTSbYJimw=w713-h632-no";
                        video_path = "https://res.cloudinary.com/dlc3xhhq5/video/upload/v1536586694/videoGeneral.mp4";
                        description = "Piernas en V tocando el suelo, barbilla cerca del pecho, peso en el pecho, subida hasta los 45º";
                        muscle_zone = "abs";
                        break;
                    case 11 :
                        name = "Lateral crunch";
                        photo_path = "https://lh3.googleusercontent.com/BLhQ6d-NXC0uR0_aB7vJPFZ04iDBFlL91rP9ujFpTGXbkDUU3FxukLtaJoYsU69zxZPXAtf6Jq8MCciJ6CQh4Gt0PVJ9NVa3dDu-vmemQbFFO0ow65u6kFrBNLmYdkmS6KZCoXO2O8j9klmsIDLapnIAi_NBXL_ftgDal0ZU_Kqae_BPCqwznUtDvhEWKrHOnWxEk9lqAxEcAVS0PT2bP1wuDBQ6w-rLQC6CzW0dxxTZme4jqsU6xxMZqaI0wCb82rvzz9IWaC8LrOw4i1lR0NHwGl9XJBjKGnNKRZIPiZQp_SY7Ii-OWxhtG4tqNgO3F4Mnqqzu2098kSfsGceD9KKjhQ5wlxLAAonStQVdqNM9R5s46YvQKj8Wxqi7qlFxtCFn4UFazT1phXyakW_51DBRNSLtcgmQqg4v57VypJ9Ir7XcFRbxVi_g3mCpd3N2__s3tBC3m9w9UfppwSRpghH5mxXqWxWlio6EjFiepgqU-eDp8ID8Uw8Ah3iZzMPcMo8sWLKFd0RUDDWiVQmq0LUEKnAw1YGAGn8Ne1e0_lZCE4G97Y2foPSTRXQwPUHboKDACEV-ztyd3iaq1YHIw8dst4Z5Eo8dcPGrDAQBKIeDEIfv4kABI4tl8WwpaulAeG5FmXHezctps0g85F4U7GZ57lVPkSvHY3lQ0kUAnqz5HbZEu5hfWxZl=w711-h632-no";
                        video_path = "https://res.cloudinary.com/dlc3xhhq5/video/upload/v1536586694/videoGeneral.mp4";
                        description = "Tumbado supino piernas hacia un costado en V, abdominal con hombro que se dirige hacia arriba y interior, como si te levantaras, peso en un costado del pecho (lado exterior al movimiento)";
                        muscle_zone = "abs";
                        break;
                    case 12 :
                        name = "Bodysaw";
                        photo_path = "https://lh3.googleusercontent.com/vqmFto7WWxVWbDfWyndORuFiunN4TwGf6uEoaxmV-6zmCVGATNEHsR3vLemyUlOygCcFz_xPBbQRWMEBUCalrPOh7V3hREsY2hTPhYQudHnUjrBDe8j-6K_dmXN5FOAya6r-Dm28wyvgRLzR0SXIpHMaBW8H8PUhr9yn9uYgjfvPUpgj-6QzsR4OA6-yXTYN06FNMh6R7r7Gd2C01cKRuBaJ1Ge90BeLvukPWPgziEj6yZ5mxuQN_m3rtg_HZSmQGU87bhPXqHIhAKYEkLy9ORICjKRDYLNMNjRiQvhET_pX79lU6AU5t5M_9lfjdVOhCsKEa-OWjiEHIMNqN6gLMs26ltIC8p-osh1wq79FbyTNCn2PG2A9XBgd4rHxPuuHn9NvPkB-hkwDsHvcK47ojzYcesu7l61JmcNPgRCuzci2TViMpomKGcbXZ8YnxsK3acm9xGu8GK3-TYrxYz7ToVIV8X9HsaIQtQ-ZSSjP8dOwm0FL9_VTbkSKm5pGfvGv0gNtS57bwaRKnu66uXGNUTdjJJ6KIIVqSBxSvsZnR8UNktw__7JCdGyXLXWQtaWoJhAOIpYVBpUVeLl1YmYU6KqsC3mlyRoY0N-keXjWbNChO9xv1Adj7u3CmU0QYG3F-KsgqMgnWnMncEUZXjrFrbiyAXivf2DZ6yXm-iW7JfHeX23B0lWeXY7S=w711-h632-no";
                        video_path = "https://res.cloudinary.com/dlc3xhhq5/video/upload/v1536586694/videoGeneral.mp4";
                        description = "Plancha, abdominal-lumbares-piernas bloqueados, glidings o algo para deslizar en los pies, movimiento hacia delante-atras, los brazos mueven el cuerpo bloqueado";
                        muscle_zone = "abs";
                        break;
                    case 13 :
                        name = "Lateral Plank";
                        photo_path = "https://lh3.googleusercontent.com/chEHIxmGJAoekfd8cHs2d__Qb_cvUQtd3eP_Oq4JjzGMaFlLcGeML6pRr1h0g-KUwt63EmlbPxSUjp7S90gYqn8v3l_qs4BUJEeuBvzWnM-NUWOO_VO99cc7U-k8cpJWQVMeYRC-YWf7oYVg5oTCM6FxEb3nfg09ec1HrXg4kyZY1yKFODtZEjjTxtSJDYcg3WF72YgqxionKcJlJYU47jAg7u8L716qOVbeIyaFAzT7XPGZxvKj8SFnQFVc0E4g2xMpgC-9QX25jm1SYRXj3egEmaqjghKlmwJfQYDBHM9ePXGkz2qQDe-VzwDBHm-kbL-RjwkBR_eD1UkKVfjE98Tuk0m6OhRgJ6sWY2fz9G4IjgAhrMxWfCT8u6_UKrb2EvA0EgW_L2NO2weptUmIlczU_sXZiq1OX2NYup_AMT0iOrYufYpHs5iFmsWQ2Piltw0e_-FyddmmoKw_thGphpNF4PuB1mwPTYtRZWPqfdaUyHOTSqUAq_M9sT4CMUo76uiPTHrL-tuKb7Jh4nRhodMVDR8z6KmHQJuL--LNiSA0PQRYBXay-rVThDY81XFxhxBpaD34HOOxbnqOeUG4EK8hywBIsuywq04s39N5PP2XpC0I40vrvFzrB6ni2P06Y6LUfwaJE_fJmalMGUXDuNzErTxqGR6wcs36S-_bGSGBNXwYiMmOm8EW=w711-h632-no";
                        video_path = "https://res.cloudinary.com/dlc3xhhq5/video/upload/v1536586694/videoGeneral.mp4";
                        description = "Plancha lateral, no bajar cadera, cuerpo bloqueado";
                        muscle_zone = "abs";
                        break;
                }

                //insert in Exercises table
                db.execSQL("INSERT INTO Exercises (id, name, photo_path, video_path, description, muscle_zone) " +
                        "VALUES (" + id + ", '" + name +"', '"+ photo_path +"', '"+ video_path +"', '"+ description +"', '"+ muscle_zone +"')");
            }
        }

    }
}

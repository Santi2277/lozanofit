package deploy.android.lozanofit.es.lozanofitroutinemixer.classes;

import android.os.Parcel;
import android.os.Parcelable;
import android.support.annotation.NonNull;

import java.io.Serializable;

public class Exercise implements Parcelable, Comparable {

    private int id;
    private String name;
    private String photo_path;
    private String video_path;
    private String description;
    private String muscle_zone;

    private String level;
    private String subclasses;
    private String hip_weight;
    private String res_weight;
    private String vol_weight;

    private String reps_obj;

    private int done;



    public Exercise(int id2, String name2, String photo_path2, String video_path2, String description2, String muscle_zone2, String level2, String subclasses2, String hip_weight2, String res_weight2, String vol_weight2, String reps_obj2) {
        id = id2;
        name = name2;
        photo_path = photo_path2;
        video_path = video_path2;
        description = description2;
        muscle_zone = muscle_zone2;
        level = level2;
        subclasses = subclasses2;
        hip_weight = hip_weight2;
        res_weight = res_weight2;
        vol_weight = vol_weight2;
        reps_obj = reps_obj2;
        done = 0;
    }

    public Exercise(Parcel source) {
        id = source.readInt();
        name = source.readString();
        photo_path = source.readString();
        video_path = source.readString();
        description = source.readString();
        muscle_zone = source.readString();
        level = source.readString();
        subclasses = source.readString();
        hip_weight = source.readString();
        res_weight = source.readString();
        vol_weight = source.readString();
        reps_obj = source.readString();
        done = source.readInt();
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoto_path() {
        return photo_path;
    }

    public void setPhoto_path(String photo_path) {
        this.photo_path = photo_path;
    }

    public String getVideo_path() {
        return video_path;
    }

    public void setVideo_path(String video_path) {
        this.video_path = video_path;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getMuscle_zone() {
        return muscle_zone;
    }

    public void setMuscle_zone(String muscle_zone) {
        this.muscle_zone = muscle_zone;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getSubclasses() {
        return subclasses;
    }

    public void setSubclasses(String subclasses) {
        this.subclasses = subclasses;
    }

    public String getHip_weight() {
        return hip_weight;
    }

    public void setHip_weight(String hip_weight) {
        this.hip_weight = hip_weight;
    }

    public String getRes_weight() {
        return res_weight;
    }

    public void setRes_weight(String res_weight) {
        this.res_weight = res_weight;
    }

    public String getVol_weight() {
        return vol_weight;
    }

    public void setVol_weight(String vol_weight) {
        this.vol_weight = vol_weight;
    }


    public int getDone() {
        return done;
    }

    public void setDone(int done) {
        this.done = done;
    }

    public String getReps_obj() {
        return reps_obj;
    }

    public void setReps_obj(String reps_obj) {
        this.reps_obj = reps_obj;
    }


    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(id);
        dest.writeString(name);
        dest.writeString(photo_path);
        dest.writeString(video_path);
        dest.writeString(description);
        dest.writeString(muscle_zone);
        dest.writeString(level);
        dest.writeString(subclasses);
        dest.writeString(hip_weight);
        dest.writeString(res_weight);
        dest.writeString(vol_weight);
        dest.writeString(reps_obj);
        dest.writeInt(done);
    }

    @Override
    public int describeContents() {
        return this.hashCode();
    }


    public static final Parcelable.Creator CREATOR
            = new Parcelable.Creator() {
        public Exercise createFromParcel(Parcel in) {
            return new Exercise(in);
        }

        public Exercise[] newArray(int size) {
            return new Exercise[size];
        }
    };


    @Override
    public int compareTo(@NonNull Object o) {
        int thisorder = 0;
        int compareorder = 0;
        switch (this.getMuscle_zone()) {
            case "biceps":
                thisorder = 1;
                break;
            case "chest":
                thisorder = 2;
                break;
            case "mid-back":
                thisorder = 3;
                break;
            case "deltoid":
                thisorder = 4;
                break;
            case "upper-back":
                thisorder = 5;
                break;
            case "triceps":
                thisorder = 6;
                break;
            case "forearm":
                thisorder = 7;
                break;
            case "lumbar":
                thisorder = 8;
                break;
            case "abs":
                thisorder = 9;
                break;
            case "glute":
                thisorder = 10;
                break;
            case "thigh":
                thisorder = 11;
                break;
            case "calf":
                thisorder = 12;
                break;
        }
        switch (((Exercise)o).getMuscle_zone()) {
            case "biceps":
                compareorder = 1;
                break;
            case "chest":
                compareorder = 2;
                break;
            case "mid-back":
                compareorder = 3;
                break;
            case "deltoid":
                compareorder = 4;
                break;
            case "upper-back":
                compareorder = 5;
                break;
            case "triceps":
                compareorder = 6;
                break;
            case "forearm":
                compareorder = 7;
                break;
            case "lumbar":
                compareorder = 8;
                break;
            case "abs":
                compareorder = 9;
                break;
            case "glute":
                compareorder = 10;
                break;
            case "thigh":
                compareorder = 11;
                break;
            case "calf":
                compareorder = 12;
                break;
        }
        return thisorder-compareorder;
    }



}

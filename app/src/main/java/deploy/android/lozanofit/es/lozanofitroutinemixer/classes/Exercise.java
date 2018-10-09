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
    private int done;

    public int getDone() {
        return done;
    }

    public void setDone(int done) {
        this.done = done;
    }

    public Exercise(int id2, String name2, String photo_path2, String video_path2, String description2, String muscle_zone2) {
        id = id2;
        name = name2;
        photo_path = photo_path2;
        video_path = video_path2;
        description = description2;
        muscle_zone = muscle_zone2;
        done = 0;
    }

    public Exercise(Parcel source) {
        id = source.readInt();
        name = source.readString();
        photo_path = source.readString();
        video_path = source.readString();
        description = source.readString();
        muscle_zone = source.readString();
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

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(id);
        dest.writeString(name);
        dest.writeString(photo_path);
        dest.writeString(video_path);
        dest.writeString(description);
        dest.writeString(muscle_zone);
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
            case "forearm":
                thisorder = 6;
                break;
            case "triceps":
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
            case "forearm":
                compareorder = 6;
                break;
            case "triceps":
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

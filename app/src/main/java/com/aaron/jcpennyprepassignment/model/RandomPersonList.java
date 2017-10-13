
package com.aaron.jcpennyprepassignment.model;

import java.io.Serializable;
import java.util.List;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class RandomPersonList implements Serializable, Parcelable
{

    @SerializedName("results")
    @Expose
    private List<Result> results = null;
    @SerializedName("info")
    @Expose
    private Info info;
    public final static Creator<RandomPersonList> CREATOR = new Creator<RandomPersonList>() {


        @SuppressWarnings({
            "unchecked"
        })
        public RandomPersonList createFromParcel(Parcel in) {
            return new RandomPersonList(in);
        }

        public RandomPersonList[] newArray(int size) {
            return (new RandomPersonList[size]);
        }

    }
    ;
    private final static long serialVersionUID = -5236842641849766560L;

    protected RandomPersonList(Parcel in) {
        in.readList(this.results, (com.aaron.jcpennyprepassignment.model.Result.class.getClassLoader()));
        this.info = ((Info) in.readValue((Info.class.getClassLoader())));
    }

    public RandomPersonList() {
    }

    public List<Result> getResults() {
        return results;
    }

    public void setResults(List<Result> results) {
        this.results = results;
    }

    public Info getInfo() {
        return info;
    }

    public void setInfo(Info info) {
        this.info = info;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeList(results);
        dest.writeValue(info);
    }

    public int describeContents() {
        return  0;
    }

}

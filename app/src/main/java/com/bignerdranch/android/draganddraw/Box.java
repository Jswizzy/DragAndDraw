package com.bignerdranch.android.draganddraw;


import android.graphics.PointF;
import android.os.Parcel;
import android.os.Parcelable;

public class Box implements Parcelable{
    private PointF mOrigin;
    private PointF mCurrent;

    private double [] points = new double[4];

    public Box(PointF origin) {
        this.mOrigin = origin;
        this.mCurrent = origin;
        points[0]=mOrigin.x;
        points[1]=mOrigin.y;
    }

    public void setCurrent(PointF mCurrent) {
        this.mCurrent = mCurrent;
        points[2] = mCurrent.x;
        points[3] = mCurrent.y;
    }

    public PointF getOrigin() {
        return mOrigin;
    }

    public PointF getCurrent() {
        return mCurrent;
    }

    /**
     * Actual de-serialization happends here. It puts together all the data back.
     * @param in
     */
    protected Box(Parcel in) {
        in.readDoubleArray(points);
        mOrigin = new PointF((float) points[0], (float) points[1]);
        mCurrent = new PointF((float) points[2], (float) points[3]);
    }

    /**
     *  It will be required un-marshalling data stored in a Parcel
     *
     */
    public static final Creator<Box> CREATOR = new Creator<Box>() {
        @Override
        public Box createFromParcel(Parcel in) {
            return new Box(in);
        }

        @Override
        public Box[] newArray(int size) {
            return new Box[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    /**
     *  Actual Serialization/flattening happends here. You need to individually Parcel each element
     *  of the object.
     **/
    @Override
    public void writeToParcel(Parcel out, int flags) {
        out.writeDoubleArray(points);
    }
}
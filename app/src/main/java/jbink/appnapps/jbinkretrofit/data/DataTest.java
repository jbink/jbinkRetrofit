package jbink.appnapps.jbinkretrofit.data;


import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;
import java.util.List;

public class DataTest implements Parcelable {
    /**
     * success : 1
     * message : Test
     * list : [{"name":"가가가","value":100,"grade":"A"},{"name":"나나나","value":70,"grade":"C"},{"name":"다다다","value":0,"grade":"F"}]
     */
    private int success;
    private String message;
    /**
     * name : 가가가
     * value : 100
     * grade : A
     */
    private List<Student> list;

    public int getSuccess() { return success;  }
    public void setSuccess(int success) {
        this.success = success;
    }

    public String getMessage() { return message; }
    public void setMessage(String message) {
        this.message = message;
    }

    public List<Student> getList() {return list; }
    public void setList(List<Student> list) {
        this.list = list;
    }

    public static class Student {
        private String name;
        private int value;
        private String grade;

        public String getName() { return name; }
        public void setName(String name) {
            this.name = name;
        }

        public int getValue() { return value; }
        public void setValue(int value) {
            this.value = value;
        }

        public String getGrade() { return grade; }
        public void setGrade(String grade) {
            this.grade = grade;
        }
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.success);
        dest.writeString(this.message);
        dest.writeList(this.list);
    }

    public DataTest() {
    }

    protected DataTest(Parcel in) {
        this.success = in.readInt();
        this.message = in.readString();
        this.list = new ArrayList<Student>();
        in.readList(this.list, Student.class.getClassLoader());
    }

    public static final Creator<DataTest> CREATOR = new Creator<DataTest>() {
        @Override
        public DataTest createFromParcel(Parcel source) {
            return new DataTest(source);
        }

        @Override
        public DataTest[] newArray(int size) {
            return new DataTest[size];
        }
    };
}














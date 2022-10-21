package ru.otus.a220903newtestmodel.pojo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class MannequinResponse {
    @SerializedName("id")
    @Expose
    private int id;
    @SerializedName("photo_200")
    @Expose
    private String photo_200;
    @SerializedName("track_code")
    @Expose
    private String trackCode;
    @SerializedName("photo_100")
    @Expose
    private String photo100;
    @SerializedName("deactivated")
    @Expose
    private String deactivated;
    @SerializedName("first_name")
    @Expose
    private String firstName;
    @SerializedName("last_name")
    @Expose
    private String lastName;
    @SerializedName("city")
    @Expose
    private City city;
    @SerializedName("can_access_closed")
    @Expose
    private boolean canAccessClosed;
    @SerializedName("is_closed")
    @Expose
    private boolean isClosed;
    @SerializedName("bdate")
    @Expose
    private String bdate;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPhoto_200() {
        return photo_200;
    }

    public void setPhoto400Orig(String photo_200) {
        this.photo_200 = photo_200;
    }

    public String getTrackCode() {
        return trackCode;
    }

    public void setTrackCode(String trackCode) {
        this.trackCode = trackCode;
    }

    public String getPhoto100() {
        return photo100;
    }

    public void setPhoto100(String photo100) {
        this.photo100 = photo100;
    }

    public String getDeactivated() {
        return deactivated;
    }

    public void setDeactivated(String deactivated) {
        this.deactivated = deactivated;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    public boolean isCanAccessClosed() {
        return canAccessClosed;
    }

    public void setCanAccessClosed(boolean canAccessClosed) {
        this.canAccessClosed = canAccessClosed;
    }

    public boolean isIsClosed() {
        return isClosed;
    }

    public void setIsClosed(boolean isClosed) {
        this.isClosed = isClosed;
    }

    public String getBdate() {
        return bdate;
    }

    public void setBdate(String bdate) {
        this.bdate = bdate;
    }

}

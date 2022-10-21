package ru.otus.a220903newtestmodel.pojo;
import java.util.List;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class GlobalResponse {

    @SerializedName("response")
    @Expose
    private ResponseFriends responseFriends;

    public ResponseFriends getResponse() {
        return responseFriends;
    }

    public void setResponse(ResponseFriends responseFriends) {
        this.responseFriends = responseFriends;
    }
}
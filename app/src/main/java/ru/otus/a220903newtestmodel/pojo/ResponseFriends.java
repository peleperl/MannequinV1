package ru.otus.a220903newtestmodel.pojo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ResponseFriends {

        @SerializedName("count")
        @Expose
        private int count;
        @SerializedName("items")
        @Expose
        private List<MannequinResponse> mannequinResponse = null;

        public int getCount() {
            return count;
        }

        public void setCount(int count) {
            this.count = count;
        }

        public List<MannequinResponse> getItems() {
            return mannequinResponse;
        }

        public void setItems(List<MannequinResponse> mannequinResponse) {
            this.mannequinResponse = mannequinResponse;
        }
}

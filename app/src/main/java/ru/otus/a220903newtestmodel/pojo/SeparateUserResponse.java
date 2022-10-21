package ru.otus.a220903newtestmodel.pojo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class SeparateUserResponse {

        @SerializedName("response")
        @Expose
        private List<MannequinResponse> mannequinResponse = null;

        public List<MannequinResponse> getSeparateResponse() {
            return mannequinResponse;
        }

        public void setSeparateResponse(List<MannequinResponse> mannequinResponse) {
            this.mannequinResponse = mannequinResponse;
        }

    }

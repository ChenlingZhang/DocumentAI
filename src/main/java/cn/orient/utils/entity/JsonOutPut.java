package cn.orient.utils.entity;

import com.google.gson.annotations.SerializedName;
import lombok.Getter;

/**
 * @author 2na1ve
 */
public class JsonOutPut {
    @Getter
    @SerializedName("output")
    public JsonResponse output;
}

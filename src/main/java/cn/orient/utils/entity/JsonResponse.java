package cn.orient.utils.entity;

import com.google.gson.annotations.SerializedName;
import lombok.Data;
import lombok.Getter;

/**
 * @author 2na1ve
 */
@Data
public class JsonResponse {

    @Getter
    @SerializedName("text")
    private String text;

    @Getter
    @SerializedName("finish_reason")
    private String finishingReason;
}

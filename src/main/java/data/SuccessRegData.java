package data;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

@Getter
public class SuccessRegData
{
    private int id;
    private String token;

    public SuccessRegData() {
    }

    public SuccessRegData(
            @JsonProperty("id") Integer id,
            @JsonProperty("token") String token) {
        this.id = id;
        this.token = token;
    }

}

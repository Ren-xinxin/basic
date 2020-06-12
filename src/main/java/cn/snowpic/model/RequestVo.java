package cn.snowpic.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Builder
public class RequestVo {
    private String name;

    private int age;

    private String[] hobbies;
}

package top.yxf.redis.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class User implements Serializable {

    private Integer userId;

    private String userName;

    private Integer userSex;

    private Date createTime;

    private Date updateTime;

}

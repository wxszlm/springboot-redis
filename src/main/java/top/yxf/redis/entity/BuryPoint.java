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
public class BuryPoint implements Serializable {

    private Integer buryPointId;

    private String userUnionid;

    private Integer status;

    private Date createTime;

    private Date updateTime;

}

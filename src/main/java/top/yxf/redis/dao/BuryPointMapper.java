package top.yxf.redis.dao;

import org.apache.ibatis.annotations.Mapper;
import top.yxf.redis.entity.BuryPoint;

import java.util.List;

/**
 * @author DELL
 */
@Mapper
public interface BuryPointMapper {

    List<BuryPoint> list();

    void save(BuryPoint buryPoint);
}

package top.yxf.redis.service;

import top.yxf.redis.entity.BuryPoint;

import java.util.List;

/**
 * @author DELL
 */
public interface BuryPointService {

    List<BuryPoint> list();

    void save(BuryPoint buryPoint);

}

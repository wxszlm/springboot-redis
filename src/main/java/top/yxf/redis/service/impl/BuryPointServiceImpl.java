package top.yxf.redis.service.impl;


import org.springframework.stereotype.Service;
import top.yxf.redis.dao.BuryPointMapper;
import top.yxf.redis.entity.BuryPoint;
import top.yxf.redis.service.BuryPointService;

import javax.annotation.Resource;
import java.util.List;

@Service
public class BuryPointServiceImpl implements BuryPointService {

    @Resource
    private BuryPointMapper buryPointMapper;

    @Override
    public void save(BuryPoint buryPoint) {

        buryPointMapper.save(buryPoint);

    }

    @Override
    public List<BuryPoint> list() {
        return buryPointMapper.list();
    }
}

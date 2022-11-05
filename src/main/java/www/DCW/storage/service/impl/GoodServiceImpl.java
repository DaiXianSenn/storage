package www.DCW.storage.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import www.DCW.storage.entity.Goods;
import www.DCW.storage.mapper.GoodsMapper;
import www.DCW.storage.service.GoodsService;

/**
 * Author: JhonDai
 * Date: 2022/11/05/16:00
 * Version: 1.0
 * Description:
 */
@Service
public class GoodServiceImpl extends ServiceImpl<GoodsMapper, Goods> implements GoodsService {
}

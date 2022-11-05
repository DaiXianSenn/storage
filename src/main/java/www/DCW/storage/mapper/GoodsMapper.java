package www.DCW.storage.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import www.DCW.storage.entity.Goods;

import java.util.List;

/**
 * Author: JhonDai
 * Date: 2022/11/05/15:57
 * Version: 1.0
 * Description:
 */
@Mapper
public interface GoodsMapper extends BaseMapper<Goods> {


    
}

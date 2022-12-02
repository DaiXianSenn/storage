package www.DCW.storage.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

import www.DCW.storage.entity.Goods;
import www.DCW.storage.pojo.dto.GoodsIdWithNameDto;

import java.util.List;
import java.util.Map;


/**
 * Author: JhonDai
 * Date: 2022/11/05/15:57
 * Version: 1.0
 * Description:
 */
@Mapper
public interface GoodsMapper extends BaseMapper<Goods> {
    Map<String,Object> getAll(Map<String,Object> param);

    String getGoodsIdByGoodsName(String goodName);

    List<GoodsIdWithNameDto> getIdAndName();
}

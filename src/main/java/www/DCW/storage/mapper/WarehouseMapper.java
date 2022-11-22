package www.DCW.storage.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

import www.DCW.storage.entity.Warehouse;

import java.util.List;

/**
 * Author: JhonDai
 * Date: 2022/11/12/9:36
 * Version: 1.0
 * Description:
 */
@Mapper
public interface WarehouseMapper extends BaseMapper<Warehouse> {


    List<Warehouse> getAll();
}

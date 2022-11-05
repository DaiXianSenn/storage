package www.DCW.storage.service;

import com.baomidou.mybatisplus.extension.service.IService;
import org.springframework.stereotype.Service;
import www.DCW.storage.entity.Goods;

import java.util.List;

/**
 * Author: JhonDai
 * Date: 2022/11/05/16:00
 * Version: 1.0
 * Description:
 */

public interface GoodsService extends IService<Goods> {


    public List<Goods> getAll();
}

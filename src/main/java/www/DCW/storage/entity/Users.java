package www.DCW.storage.entity;

import lombok.Data;

/**
 * Author: JhonDai
 * Date: 2022/10/24/22:19
 * Version: 1.0
 * Description:
 */
@Data
public class Users {
    private static final long serialVersionUID = 1L;

    private int id;
    private String username;
    private String userpwd;
    private String flag;

}

package www.DCW.storage.entity;


import lombok.Data;

/**
 * Author: JhonDai
 * Date: 2022/10/24/22:19
 * Version: 1.0
 * Description:
 */
@Data
public class User {

	private String userId; //用户id

	private String password;  //密码

	private String name;  //姓名

	private String gender;   //性别

	private String birthday;  //出生日期

	private String ID_number;  //身份证号

	private String native_place;  //籍贯

	private String address;  //家庭住址

	private String phone;   //联系电话

	private String remarks; //备注

}

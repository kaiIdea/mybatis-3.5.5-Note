package org.apache.ibatis.modle;

import org.apache.ibatis.annotations.Param;

/**
 * @Auther: GEEX1428
 * @Date: 2021/11/18 16:12
 * @Description: TODO
 */
public interface UserMapper {

  int selectCount(@Param("id")Integer id,String userName);
}

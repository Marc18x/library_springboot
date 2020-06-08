package com.marc.library.mapper;

import com.marc.library.model.Admin;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface AdminMapper {
    /**
     * 搜索管理员信息
     * @param username 登录名
     * @param password 登录账号
     * @return
     */
    public Admin queryForAdmin(@Param("username")String username,
                               @Param("password")String password);

}

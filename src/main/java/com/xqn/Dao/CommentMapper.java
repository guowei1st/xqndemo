package com.xqn.Dao;

import com.xqn.Dto.FindComment;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface CommentMapper {

    @Select("select `comment`,relation,a.date from t_comment as a,t_user as b " +
            "WHERE a.username = b.username  and b.childid=(select childid FROM t_user WHERE username=#{username})")
    FindComment[] findCommentByChild(String username);

    @Select("select `comment`,relation,a.date from t_comment as a,t_user as b WHERE a.username = b.username  and a.username=#{username}")
    FindComment[] findCommentByUsername(String username);

    @Insert("insert into t_comment(username,comment,date) values( #{username}, #{comment}, #{date})")
    Integer upLoadComment(String username,String comment,String data);


}

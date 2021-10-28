package com.xqn.Dao;

import com.xqn.Dto.FindRankAndScore;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface RankMapper {


    @Select("select name,sum(score) as score from t_rank,t_child where  t_rank.childid=t_child.childid GROUP BY name ORDER BY sum(score) desc")
    FindRankAndScore[] findRank();

    @Select("select name,sum(score) as score from t_rank,t_child where createtime >= #{starttime}  and createtime <= #{endtime}" +
            " and t_rank.childid=t_child.childid GROUP BY name ORDER BY sum(score) desc")
    FindRankAndScore[] findrankallbytime(String starttime,String endtime);

    @Select( "select name,sum(score) as score from t_rank,t_child where  createtime = #{day}  and t_rank.childid=" +
            "t_child.childid GROUP BY name ORDER BY sum(score) desc")
    FindRankAndScore[] findRankByDay(String day);

    @Insert("insert into t_rank(childid, type, score, content, createuser, createtime)" +
            " values(#{childid},#{type},#{score},#{content},#{username},#{date})")
    Integer upLoadRank(String childid,String type,String score,String content,String username,String date);
}

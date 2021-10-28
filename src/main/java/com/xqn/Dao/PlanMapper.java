package com.xqn.Dao;

import com.xqn.Dto.FindPlanDto;
import org.apache.ibatis.annotations.*;

@Mapper
public interface PlanMapper {

    @Select("select * from t_plan where username=#{username}")
    @Results({
            @Result(column="id",property = "planid")
    })
    FindPlanDto[] findplan(String username);





    @Insert("insert into t_plan(username,content,startdate,excu,createtime,old,kind) values(#{username}" +
            ",#{content},#{starttime},-1,#{date},#{old},'推荐')")
    Integer insertPlanTj(String username,String content,String starttime,String date,String old);

    @Insert("insert into t_plan(username,content,startdate,excu,createtime,old,kind,award) values(#{username}" +
            ",#{content},#{starttime},-1,#{date},#{old},'自定义',#{award})")
    Integer insertPlanDiy(String username,String content,String starttime,String date,String old,String award);
}

package com.xqn.Dao;



import com.xqn.Dto.GetContent;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface MyControllerMapper {



    @Select("select id,content from t_plan where username= #{username}  and excu!= #{i} ")
    public GetContent[] getContent(String username, String i);

    @Select("select content from t_plan where username= #{username}  and excu= #{i} ")
    public String getWeekiContent(String username, String i);

    @Select("select content from t_target where username= #{username}  and excu=1 ")
    public String  getTarget(String username);

    @Select("select award from t_target where username= #{username}  and excu=1 ")
    public String  getAward(String username);

    @Select("select comment from t_comment where username= #{username}  and excu=1 ")
    public String  getCommnet(String username);

    @Update("update  t_plan set excu=#{i} where username= #{username} and id=#{planid}")
    public Integer updatePlan(String username, String i,String planid);

    @Update("update  t_plan set excu=-1 where username= #{username} and excu=#{i}")
    public Integer updatePlanPre(String username, String i);


}
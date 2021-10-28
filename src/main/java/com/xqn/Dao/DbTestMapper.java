package com.xqn.Dao;

import com.xqn.Dto.Dbtest2Dto;
import com.xqn.Dto.DbtestDto;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface DbTestMapper {

    @Select("SELECT name,a.studentId,a.subjectId,termId,a.score from t_remark_score as a,t_students_attend_class as b,t_student as c where a.studentId=c.studentId and a.studentId=b.studentId and a.termId=2 and subjectId=4419002080 and b.classId in(select classId FROM t_students_attend_class where studentId=\"00007e7b-1f30-4a41-b1a5-0a798aa747f4\") ")
    DbtestDto[] test1();

    @Select("SELECT name,a.studentId,a.subjectId,a.newScore,termId,a.site,a.siteRank from qcpj_remark_score as a,qcpj_student_attend_class as b," +
            "qcpj_student as c where a.studentId=c.studentId and a.studentId=b.studentId and b.classId=" +
            "#{classId} and a.termId=#{termId} and subjectId=#{subjectId}")
    Dbtest2Dto[] test2(String classId, String termId, String subjectId);

    @Update("update qcpj_remark_score set siteRank=#{siteRank}, " +
            "site=#{site} where termId=#{termId} and studentId=#{studentId}" +
            " and subjectId=#{subjectId} and newScore=#{newScore}")
    int test3(String siteRank, String site, String termId,String studentId,String subjectId,String newScore);

}

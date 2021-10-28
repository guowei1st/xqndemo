package com.xqn.controller;

import com.xqn.Dao.DbTestMapper;
import com.xqn.Dto.Dbtest2Dto;
import com.xqn.Dto.DbtestDto;
import com.xqn.Dto.ReturnDto;
import io.swagger.annotations.ApiOperation;
import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.DataOutput;
import java.io.File;
import java.io.IOException;
import java.util.*;


@Controller
public class dbTestController {

    @Autowired
    DbTestMapper dbTestMapper;


    @ApiOperation("测试")
    @ResponseBody
    @PostMapping("/dbtest")
    public ReturnDto dbtest(@RequestParam("classId") String classid)  {
        DbtestDto[] dbtestDtos=dbTestMapper.test1();
        HashMap hashMap=new HashMap();
        List<String> simple1 = new ArrayList<String>();
        List<String> simple2 = new ArrayList<String>();
        File f = new File("D:\\data.xls");
        String s = null;
        try {
            Workbook book = Workbook.getWorkbook(f);//
            Sheet sheet = book.getSheet(0); //获得第一个工作表对象
            for (int i = 1; i < sheet.getRows() - 1; i++) {
                Cell cell = sheet.getCell(0, i); //获得单元格
                s = cell.getContents() + " " + i + " " + sheet.getRows();
                simple1.add(cell.getContents());
            }
        } catch (BiffException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            Workbook book = Workbook.getWorkbook(f);//
            Sheet sheet = book.getSheet(0); //获得第一个工作表对象
            for (int i = 1; i < sheet.getRows() - 1; i++) {
                Cell cell = sheet.getCell(5, i); //获得单元格
                s = cell.getContents() + " " + i + " " + sheet.getRows();
                simple2.add(cell.getContents());
            }
        } catch (BiffException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(simple1);
        System.out.println(simple2);
        for(int i=0;i<simple1.size();i++){
            hashMap.put(simple1.get(i),simple2.get(i));
        }
        //转化成绩
        for (DbtestDto db:dbtestDtos
        ) {
            if (hashMap.get(db.getScore())!=null){
                db.setNewScore((String)hashMap.get(db.getScore()));
            }
        }

        List<Object[]> list=new ArrayList<Object[]>();
        for (DbtestDto db:dbtestDtos
        ) {
            Object[] objects=new Object[8];
            objects[0]=db.getStudentId();
            objects[1]=db.getSubjectId();
            objects[2]=db.getScore();
            objects[3]=db.getNewScore();
            objects[4]=db.getWeek();
            objects[5]=db.getTermId();
            list.add(objects);
        }
        boolean Flag=CreateCsvFile.createCsvFile(list,"D:\\","csvFile");
        return new ReturnDto(200,dbtestDtos,"dbtest");
    }


    @ApiOperation("测试2")
    @ResponseBody
    @PostMapping("/dbtest2")
    public ReturnDto dbtest2(@RequestParam("classId") String classid,
        @RequestParam("termId") String termId,
        @RequestParam("subjectId") String subjectId) {

        Dbtest2Dto[] dbtestDtos = dbTestMapper.test2(classid, termId, subjectId);


        for (Dbtest2Dto dbtest:dbtestDtos
        ) {
            if(dbtest.getSite().equals("")){

                int max=Integer.parseInt(dbtestDtos[0].getNewScore());
                int min=Integer.parseInt(dbtestDtos[0].getNewScore());
                int sum=0,num=0;

                for (Dbtest2Dto db:dbtestDtos
                ) {

                    if(Integer.parseInt(db.getNewScore())>max){
                        max=Integer.parseInt(db.getNewScore());
                    }
                    if(Integer.parseInt(db.getNewScore())<min){
                        min=Integer.parseInt(db.getNewScore());
                    }
                    sum+=Integer.parseInt(db.getNewScore());
                    num++;
                }
                double avg=sum*1.0/num;
                for (Dbtest2Dto db:dbtestDtos
                ) {
                    double siteRank=(Integer.parseInt(db.getNewScore())-avg)/(max-min);
                    db.setSiteRank( String.format("%.2f", siteRank));
                }
                for (Dbtest2Dto db:dbtestDtos
                ) {
                    int s=1;//默认排名1  排序
                    for (Dbtest2Dto db2:dbtestDtos
                    ) {
                        if(Double.parseDouble(db2.getSiteRank())>Double.parseDouble(db.getSiteRank())){
                            s++;
                        }
                    }
                    db.setSite(s+"");
                    int a=dbTestMapper.test3(db.getSiteRank(), db.getSite(), db.getTermId(),db.getStudentId(),db.getSubjectId(),db.getNewScore());
                }
            }

        }


        return new ReturnDto(200,dbtestDtos,"dbtest");
    }




}

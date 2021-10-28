package com.xqn.entities;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("互动版数据")
public class syDto {

        @ApiModelProperty("周一选定的计划")
        public String MonPlan;
        @ApiModelProperty("周二选定的计划")
        public String TuesPlan;
        @ApiModelProperty("周三选定的计划")
        public String WenPlan;
        @ApiModelProperty("周四选定的计划")
        public String ThurPlan;
        @ApiModelProperty("周五选定的计划")
        public String FriPlan;
        @ApiModelProperty("周六选定的计划")
        public String SatPlan;
        @ApiModelProperty("周日选定的计划")
        public String SunPlan;

        @ApiModelProperty("目标")
        public String target;

        @ApiModelProperty("奖励和惩罚")
        public String award;
        @ApiModelProperty("留言")
        public String message;


        public String getTarget() {
            return target;
        }

        public void setTarget(String target) {
            this.target = target;
        }

        public String getAward() {
            return award;
        }

        public void setAward(String award) {
            this.award = award;
        }

        public String getMessage() {
            return message;
        }

        public void setMessage(String message) {
            this.message = message;
        }

        public syDto(String monPlan, String tuesPlan, String wenPlan, String thurPlan, String friPlan, String satPlan, String sunPlan, String target, String award, String message) {
            this.MonPlan = monPlan;
            this.TuesPlan = tuesPlan;
            this.WenPlan = wenPlan;
            this.ThurPlan = thurPlan;
            this.FriPlan = friPlan;
            this.SatPlan = satPlan;
            this.SunPlan = sunPlan;
            this.target = target;
            this.award = award;
            this.message = message;
        }
    }



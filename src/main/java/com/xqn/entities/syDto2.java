package com.xqn.entities;

public class syDto2 {

        public String MonPlan;
        public String TuesPlan;
        public String WenPlan;
        public String ThurPlan;
        public String FriPlan;
        public String SatPlan;
        public String SunPlan;
        public String target;
        public String award;





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



        public syDto2(String monPlan, String tuesPlan, String wenPlan, String thurPlan, String friPlan, String satPlan, String sunPlan, String target, String award) {
            this.MonPlan = monPlan;
            this.TuesPlan = tuesPlan;
            this.WenPlan = wenPlan;
            this.ThurPlan = thurPlan;
            this.FriPlan = friPlan;
            this.SatPlan = satPlan;
            this.SunPlan = sunPlan;
            this.target = target;
            this.award = award;

        }
    }



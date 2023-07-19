package com.example.my_food_recipe_app_project_design;

import java.io.Serializable;

public class RecipeModel implements Serializable {

        private String rId;
        private String rName;
        private String rImage;
        private String rIngredients;
        private String rInstruction;
        private String cId;

        public String getRid() {
            return rId;
        }

        public void setRid(String rId) {
            this.rId = rId;
        }

        public String getRname() {
            return rName;
        }

        public void setRname(String rName) {
            this.rName = rName;
        }

        public String getRimage() {
            return rImage;
        }

        public void setRimage(String rImage) {
            this.rImage = rImage;
        }

        public String getRingredients() {
            return rIngredients;
        }

        public void setRingredients(String rIngredients) {
            this.rIngredients = rIngredients;
        }

        public String getRinstruction() {
            return rInstruction;
        }

        public void setRinstruction(String rInstruction) {
            this.rInstruction = rInstruction;
        }

        public String getCid() {
            return cId;
        }

        public void setCid(String cId) {
            this.cId = cId;
        }

        public String toString() {
            return "RecipeModel{" +
                    "rId=" + rId +
                    ", rName='" + rName + '\'' +
                    ", rImage='" + rImage + '\'' +
                    ", rIngredients='" + rIngredients + '\'' +
                    ", rInstruction='" + rInstruction + '\'' +
                    '}';
        }
}
package ToolsQA.Algo_part_3_lab1.model;

public class Stadium {
    
        private int countOfSpectators;

        private String name;

        private int lightingPowerInLux;

        public int getCountOfSpectators() {
            return countOfSpectators;
        }

        public void setCountOfSpectators(int countOfSpectators) {
            this.countOfSpectators = countOfSpectators;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getLightingPowerInLux() {
            return lightingPowerInLux;
        }

        public void setLightingPowerInLux(int lightingPowerInLux) {
            this.lightingPowerInLux = lightingPowerInLux;
        }
        
        public Stadium() { 
        }
        
        public Stadium(int countOfSpectators, String name, int lightingPowerInLux) {
            this.countOfSpectators = countOfSpectators;
            this.name = name;
            this.lightingPowerInLux = lightingPowerInLux;
        }
        
        public String toString() {
            return "Stadium [countOfSpectators = " + countOfSpectators + ", name = " + name + ", lightingPowerInLux = "
                    + lightingPowerInLux + "]";
        }

    }

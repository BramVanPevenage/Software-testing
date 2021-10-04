package com.openclassroom.testing.model;


    /**
     * A model to represent a two argument integer calculation
     * which needs to be performed
     */
    public class CalculationModel {
        public static final String SEPARATOR = " ";
        private Integer leftArgument;
        private Integer rightArgument;
        private CalculationType type;
        private double solution;

        public static CalculationModel fromText(String calculation) {
            CalculationModel model = new CalculationModel();
            String[] parts = calculation.split(SEPARATOR);

            model.setLeftArgument(Integer.parseInt(parts[0]));
            model.setRightArgument(Integer.parseInt(parts[2]));
            String operation = parts[1];
            model.setType( CalculationType.fromSymbol(operation) );
            return model;
        }

        public Integer getLeftArgument() {
            return leftArgument;
        }

        public void setLeftArgument(Integer leftArgument) {
            this.leftArgument = leftArgument;
        }

        public Integer getRightArgument() {
            return rightArgument;
        }

        public void setRightArgument(Integer rightArgument) {
            this.rightArgument = rightArgument;
        }

        public CalculationType getType() {
            return type;
        }

        public void setType(CalculationType type) {
            this.type = type;
        }

        public double getSolution() {
            return solution;
        }

        public void setSolution(double solution) {
            this.solution = solution;
        }
    }


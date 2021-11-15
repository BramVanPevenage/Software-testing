using System;

namespace Calculator.Domain
{
    public class Calculatoor
    {
        private int _firstNumber;
        private int _secondNumber;

        public int SecondNumber
        {
            get { return _secondNumber; }
            set { _secondNumber = value; }
        }


        public int FirstNumber
        {
            get { return _firstNumber; }
            set { _firstNumber = value; }
        }

        public int Add()
        {
            return _firstNumber + _secondNumber;
        }


    }
}

using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Calculator.Domain
{
    public class Result
    {
        public OperationType Operation { get; set; }
        public double ResultOfOperation { get; set; }
        public int[] NumbersInOperation { get; set; }

        public Result(OperationType type, double result, int[]numbers)
        {
            Operation = type;
            ResultOfOperation = result;
            NumbersInOperation = numbers;
        }
    }
}

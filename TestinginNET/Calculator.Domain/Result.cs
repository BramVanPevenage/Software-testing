using System;
using System.Collections.Generic;
using System.ComponentModel.DataAnnotations;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Calculator.Domain
{
    public class Result
    {
        public OperationType Operation { get; set; }
        public double ResultOfOperation { get; set; }
        public String NumbersInOperation { get; set; }
        [Key]
        public int Id { get; set; }

        internal Result()
        {

        }
        public Result(OperationType type, double result, String numbers)
        {
            Operation = type;
            ResultOfOperation = result;
            NumbersInOperation = numbers;
        }
    }
}

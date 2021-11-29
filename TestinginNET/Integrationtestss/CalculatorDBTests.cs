using Calculator.Domain;
using Microsoft.EntityFrameworkCore;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using WebCalculator.Data;
using Xunit;

namespace Integrationtestss
{
    public class CalculatorDBTests : TestDBBaseClass //using base class for doing the configurations
    {
     

        [Fact(DisplayName = "Counting the rows we retrieve from the database to check that ervery result is there")]
        public void ShouldReturnAllResult()
        {

            List<Result> result;

            using (_context)
            {
                result = _context.Results.ToList();
            }

            Assert.Equal(3, result.Count);
        }
        [Fact(DisplayName ="Retrieving every result with outcome of 10, should be 1 row with Outcome = '10.0'")]
        public void ShouldReturnResult10()
        {

            Result result;

            using (_context)
            {
                result = _context.Results.Where(x => x.ResultOfOperation == 20.0).SingleOrDefault();
            }

            Assert.Equal(20.0, result.ResultOfOperation);
        }

        [Fact(DisplayName = "Retrieving every result with an Operation type of Sum, should be 1 row with OperationType = 'Sum'")]
        public void ShouldReturnOperationTypeSul10()
        {

            Result result;

            using (_context)
            {
                result = _context.Results.Where(x => x.Operation == OperationType.Sum).SingleOrDefault();
            }

            Assert.Equal(OperationType.Sum, result.Operation);
        }

        //private void Seed(ApplicationDbContext context)
        //{
        //    var result = new[]
        //    {
        //        new Result(OperationType.Sum, 20, "10,10"),
        //        new Result(OperationType.Subtraction, 30, "20,10"),
        //        new Result(OperationType.Subtraction, 40, "30,10"),
        //    };

        //    context.Results.AddRange(result);
        //    context.SaveChanges();
        //}


    }
}

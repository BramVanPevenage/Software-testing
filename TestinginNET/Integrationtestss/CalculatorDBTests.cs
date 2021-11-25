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
    public class CalculatorDBTests
    {
        [Fact]
        public void ShouldReturnAllResult()
        {
            var options = new DbContextOptionsBuilder<ApplicationDbContext>().UseInMemoryDatabase(databaseName: "CalculatorTesting").Options;

            var context = new ApplicationDbContext(options);

            Seed(context);
        }

        private void Seed(ApplicationDbContext context)
        {
            var result = new[]
            {
                new Result(OperationType.Subtraction, 20, new int[]{ 10,10}),
                new Result(OperationType.Subtraction, 30, new int[]{ 20,10}),
                new Result(OperationType.Subtraction, 40, new int[]{ 30,10}),
            };

            context.Add(result);
            context.SaveChanges();
        }
    }
}

using Calculator.Domain;
using Microsoft.EntityFrameworkCore;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using WebCalculator.Data;

namespace Integrationtestss
{
    public class TestDBBaseClass : IDisposable
    {
        protected readonly ApplicationDbContext _context;

        public TestDBBaseClass()
        {
            var options = new DbContextOptionsBuilder<ApplicationDbContext>().UseInMemoryDatabase(databaseName: Guid.NewGuid().ToString()).Options;

            _context = new ApplicationDbContext(options);
            //For cleanup matters
            _context.Database.EnsureCreated();
            Seed(_context);
        }

        public void Dispose()
        {
            //For no usless database in memory
            _context.Database.EnsureDeleted();
            _context.Dispose();
        }

        private void Seed(ApplicationDbContext context)
        {
            var result = new[]
            {
                new Result(OperationType.Sum, 20, "10,10"),
                new Result(OperationType.Subtraction, 30, "20,10"),
                new Result(OperationType.Subtraction, 40, "30,10"),
            };

            context.Results.AddRange(result);
            context.SaveChanges();
        }
    }
}

using Calculator.Domain;
using Microsoft.EntityFrameworkCore;

namespace WebCalculator.Data
{
    public class ApplicationDbContext : DbContext
    {
        public ApplicationDbContext(DbContextOptions<ApplicationDbContext> options)
            : base(options)
        {
        }

        public DbSet<Result> Results { get; set; }

    }
}

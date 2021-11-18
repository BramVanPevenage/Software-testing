using Microsoft.AspNetCore.Mvc;
using System.Threading.Tasks;

namespace WebCalculator.Controllers
{
    public class CalculatorController : Controller
    {
        public IActionResult Sum(int x, int y)
        {
            CalculatorViewModel viewModel = new CalculatorViewModel(x, y);
            return View(viewModel);
        }


    }
    [Route("[controller]")]
    [ApiController]
    public class CalculatorApiController : ControllerBase
    {
        [HttpGet]
        public ActionResult<int> Sum(int x, int y)
        {
            CalculatorViewModel viewModel = new CalculatorViewModel(x, y);
            return viewModel.Sum;
        }
    }

    public class CalculatorViewModel
    {
        public int X { get; set; }
        public int Y { get; set; }
        public int Sum { get; set; }

        public CalculatorViewModel(int x, int y)
        {
            X = x;
            Y = y;
            Sum = x+y;
        }
    }
}

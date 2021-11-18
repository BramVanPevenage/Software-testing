using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using WebCalculator.Business;
using Xunit;

namespace IntegrationTests
{
    public class WebCaculatorTests
    {
        [Fact]
        public async void Test_WebCalculatorSum()
        {
            var context = new TestContext();

            using (var client = context.Client)
            {
                var response = await client.GetAsync("CalculatorApi?x=5&y=4");

                Assert.True(response.IsSuccessStatusCode);

                var content = await response.Content.ReadAsStringAsync();

                Assert.Equal("9", content);
            }
        }
        [Fact]
        public async void Test_WebCalculatorSumNegativeNumbers()
        {
            var context = new TestContext();

            using (var client = context.Client)
            {
                var response = await client.GetAsync("CalculatorApi?x=-5&y=-4");

                Assert.True(response.IsSuccessStatusCode);

                var content = await response.Content.ReadAsStringAsync();

                Assert.Equal("-9", content);
            }
        }
        [Fact]
        public async void Test_WebCalculatorSumOneNegativeNumber()
        {
            var context = new TestContext();

            using (var client = context.Client)
            {
                var response = await client.GetAsync("CalculatorApi?x=5&y=-4");

                Assert.True(response.IsSuccessStatusCode);

                var content = await response.Content.ReadAsStringAsync();

                Assert.Equal("1", content);
            }
        }
    }
}

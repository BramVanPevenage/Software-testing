using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
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
                var response = await client.GetAsync("/api/calculator/sum?x=1&y=2");

                Assert.True(response.IsSuccessStatusCode);

                var content = await response.Content.ReadAsStringAsync();

                Assert.Equal("3.0", content);
            }
        }
        [Fact]
        public void test()
        {
            Assert.Equal("3", "3");
        }
    }
}

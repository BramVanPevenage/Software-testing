using Moq;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading;
using System.Threading.Tasks;
using TestinginNET;
using Xunit;

namespace TestingInDotNEt
{
    public class CalculatorTests
    {

        Calculator calculator = new Calculator();

        #region Multiply
        [Fact(DisplayName = "Multiplying 2 positive numbers '5' and '5', should return '25'")]
        [Trait("Category", "Multiply Numbers")]

        public void MutiplyTestPositiveNumbers()
        {
            // expected & actual comparing to each other
            Assert.Equal(25, calculator.Multiply(5, 5));
        }

        [Fact(Timeout = 150, DisplayName = "Multipying 2 negative numbers '-5' & '-5', should return '25'")]
        [Trait("Category", "Multiply Numbers")]
        public async void MutiplyTestNegetaiveNumbers()
        {
            //geeft error want duurt telang
            //await Task.Delay(200);

            //werkt wel
            await Task.Delay(100);
            // expected & actual comparing to each other
            Assert.Equal(25, calculator.Multiply(-5, -5));

        }

        //skipping the test
        [Fact /*(Skip = "true")*/ (DisplayName = "Multiplying one positive & one negative number,  '5' & '-5', should return '-25'")]
        [Trait("Category", "Multiply Numbers")]
        public void MutiplyTestOneNegetaiveNumbers()
        {
            // expected & actual comparing to each other
            Assert.Equal(-25, calculator.Multiply(5, -5));
        }
        #endregion

        #region Sum
        [Fact(DisplayName = "Adding 2 positive numbers '5' and '5', should return '10'")]
        [Trait("Category", "Adding Numbers")]
        public void SumTestPositiveNumbers()
        {
            // expected & actual comparing to each other
            Assert.Equal(10, calculator.Sum(5, 5));
        }

        [Fact(DisplayName = "Adding 2 negative numbers '-5' and '-5', should return '-10'")]
        [Trait("Category", "Adding Numbers")]
        public void SumTestNegativeNumbers()
        {
            // expected & actual comparing to each other
            Assert.Equal(-10, calculator.Sum(-5, -5));
        }

        [Fact(DisplayName = "Adding one negative and one positive number '5' and '-5', should return '0'")]
        [Trait("Category", "Adding Numbers")]
        public void SumTestOneNegativeNumbers()
        {
            // expected & actual comparing to each other
            Assert.Equal(0, calculator.Sum(5, -5));
        }
        #endregion


        #region Divide
        [Fact(DisplayName = "Dividing 2 positive numbers '5' and '5', should return '1'")]
        [Trait("Category", "Dividing Numbers")]
        public void DivideTestPositiveNumbers()
        {
            // expected & actual comparing to each other
            Assert.Equal(1, calculator.Divide(5, 5));
        }

        [Fact(DisplayName = "Dividing 2 negative numbers '-5' and '-5', should return '-1'")]
        [Trait("Category", "Dividing Numbers")]
        public void DivideTestNegativeNumbers()
        {
            // expected & actual comparing to each other
            Assert.Equal(1, calculator.Divide(-5, -5));
        }

        [Fact(DisplayName = "Dividing one negative and one positive number '5' and '-5', should return '-1'")]
        [Trait("Category", "Dividing Numbers")]
        public void DivideTestOneNegativeNumbers()
        {
            // expected & actual comparing to each other
            Assert.Equal(-1, calculator.Divide(5, -5));
        }
        [Fact(DisplayName = "Dividing by zero, '5' and '0', should return DivideByZeroException")]
        [Trait("Category", "Dividing Numbers")]
        public void DivideByZero()
        {
            // expected & actual comparing to each other
            Assert.Throws<DivideByZeroException>(() =>
            {
                Assert.Equal(0, calculator.Divide(5, 0));
            });
        }
        #endregion

        #region MockTests
        [Fact(DisplayName = "Mocking a fake calculator and testing an self written setup.")]
        [Trait("Category", "Mocking")]
        public void EasyMockTest()
        {
            //done for database retrieval to make it go faster. so done for time intensive tasks.
            var fCalculator = new Mock<ICalculator>();
            fCalculator.Setup(x => x.Add(2, 2)).Returns(4);
            Assert.Equal(4, fCalculator.Object.Add(2, 2));
        }
        [Fact(DisplayName = "Mocking an date and testing an self written setup.")]
        [Trait("Category", "Mocking")]
        public void EasyMockDateTest()
        {
            //dmocking the get now data to a 2100 1 1 date
            var mockDateTime = new Moq.Mock<IDateTimeProvider>();
            mockDateTime.Setup(mock => mock.GetNow()).Returns(() => new DateTime(2100, 1, 1, 0, 0, 0));
            //checking of the mocks works
            Assert.Equal(new DateTime(2100,1,1), mockDateTime.Object.GetNow());
        }
        #endregion

    }
}

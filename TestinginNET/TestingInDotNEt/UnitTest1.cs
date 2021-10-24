using System;
using System.Collections.Generic;
using Xunit;

namespace TestingInDotNEt
{
    public class UnitTest1
    {
        [Fact]
        public void Test1()
        {
            Test.DoubleOfNumber(5);
            //expected = 10 
            Assert.Equal(10, Test.DoubleOfNumber(5));
        }
        [Fact]
        public void testAllAsserts()
        {
            Assert.False(4 == 5);
            Assert.True(4 == 4);
            //zelfde resultaat
            Assert.Equal(10, Test.DoubleOfNumber(5));
            Assert.NotEqual(10, Test.DoubleOfNumber(10));
            Assert.Contains("am", "tram");
            Assert.DoesNotContain("am", "regenpijp");
            //kijkt of een collectie leeg is
            Assert.Empty(new List<int>());
            // inverse
            Assert.NotEmpty(new List<int>() { 5, 6, 7, 5 });
            //Verifies that all items in the collection pass when executed against action.
            List<int> list = new List<int>() { 5, 6, 7, 5 };
            Assert.All(list, listItem => Assert.InRange(listItem, 2, 9));
            //kijkt of een string voldoet aan een regular expression patroon
            Assert.DoesNotMatch(@"\b[M]\w+", "LMother");
            Assert.Matches(@"\b[B]\w+", "Brother");
            //vergelijkt het einde van een string
            Assert.EndsWith("6", "12345 6");
            //vergelijk het begin van een string
            Assert.StartsWith("12", "12 34 56");
            //bekijkt of waarde tussen een bepaald bereik zich bevindt
            Assert.InRange(2, 0, 5);
            Assert.InRange("b", "a", "u");
            //Verifies that an object is of the given type or a derived type.
            Assert.IsAssignableFrom(new Test().GetType(), new TestChild());
            //bekijkt of een variabele al dan niet van hetzefde type is
            Assert.IsNotType(new Test().GetType(), new Object());
            Assert.IsType(new Test().GetType(), new Test());
            //kijkt of 2 objecten het zelfde zijn of niet
            Assert.NotSame(new Object(), new Object());
            object o = new Object();
            Assert.Same(o, o);
            //kijken of een object null is of niet
            object o2 = null;
            Assert.Null(o2);
            o2 = new Object();
            Assert.NotNull(o2);
            //Verifies that two objects are strictly not equal, using the type's default comparer.
            Assert.NotStrictEqual(o, o2);
            //kijkt of er een exception wordt opgesteld, je kan meeggeven welke expection als je dat wilt anders is elke exceptie aanvaard
            Assert.Throws(new DivideByZeroException().GetType(), delegate { throw new DivideByZeroException(); });
            //Assert.Throws<DivideByZeroException>();
            //kijkt of een list één element heeft van een bepaald type
            Assert.Single(new List<int>() { 5 });


        }
    }
}

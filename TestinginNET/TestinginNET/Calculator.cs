using System;
using System.Collections.Generic;
using System.IO;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace TestinginNET
{
    public class Calculator
    {
        #region Fields & Properties

        #endregion Fields & Properties

        #region Constructors

        public Calculator()
        {

        }

        #endregion Constructors

        #region Methods
        /// <summary>
        /// Multiplying 2 numbers and returning the result
        /// </summary>
        /// <param name="v1">First number</param>
        /// <param name="v2">Second number</param>
        /// <returns>Returting the result of the multiplication</returns>
        public int Multiply(int v1, int v2)
        {
            return v1* v2;
        }
        /// <summary>
        /// Adding two numbers and returning the result
        /// </summary>
        /// <param name="v1">First number</param>
        /// <param name="v2">Second number</param>
        /// <returns>The result of the adding/returns>
        public int Sum(int v1, int v2)
        {
            return v1 + v2;
        }
        /// <summary>
        /// Dividing one number by another and returning the result
        /// </summary>
        /// <param name="v1">The number that will be divided</param>
        /// <param name="v2">The dividor</param>
        /// <returns>The result of the dividing</returns>
        public double Divide(int v1, int v2)
        {
            return v1 / v2;
        }
        #endregion Methods

        #region Interfaces


        #endregion Interfaces
    }
}

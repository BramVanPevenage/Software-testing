using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace TestinginNET
{
    class Program
    {
        static void Main(string[] args)
        {
        }


    }
}
public class Test
{
    public static int DoubleOfNumber(int x)
    {
        return x*2;
    }
}

public class TestChild : Test
{
    public static int QuadoubleOfNumber(int x)
    {
        return x * 4;
    }
}

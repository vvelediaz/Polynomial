import javax.swing.*;

public class Term implements Comparable<Term>, Cloneable
{
    private int coefficient, exponent;
    public Term next;

    public Term(int coefficient, int exponent)
    {
        this.coefficient = coefficient;
        this.exponent = exponent;
    }
    public Term()
    {
        setAll(1, 1);
    }

    public Term(Term t)
    {
        this.exponent = t.getExponent();
        this.coefficient = t.getCoefficient();
    }

    public Term(String t)
    {
        String c = "";
        String e = "";

        char[] termArray = t.toCharArray();

        for(int i = 1; true; i++ )
        {
            try
            {
                int x = Integer.valueOf(termArray[i] + "");
                c = c + termArray[i];
            }
            catch(Exception ex)
            {
                break;
            }
        }
        if(c.isEmpty())
        {
            if(termArray[0] == '-')
            {
                coefficient = -1;
            }
            else
            {
                coefficient = 1;
            }
        }
        else
        {
            if(termArray[0] == '-')
            {
                coefficient = Integer.valueOf("-" + c);
            }
            else if(termArray[0] == '+')
            {
                coefficient = Integer.valueOf(c);
            }
        }

        exponent = 0;
        for(int i = 0; i < termArray.length; i++)
        {
            if(termArray[i] == 'x')
            {
                try
                {
                    char x = termArray[i+1];
                }
                catch(Exception ex)
                {
                    exponent = 1;
                    break;
                }
                exponent = Integer.valueOf(t.substring(i + 2));
            }

        }
    }

    @Override
    public int compareTo(Term o)
    {
        if(this.getExponent() == o.getExponent())
        {
            return 0;
        }
        else if(this.getExponent() > o.getExponent())
        {
            return 1;
        }
        else
        {
            return -1;
        }
    }

    @Override
    public boolean equals(Object o)
    {
        if (o == null)
        {
            return false;
        }

        if (this.getClass() != o.getClass())
        {
            return false;
        }

        if((this.exponent == ((Term)o).getExponent()) && (this.coefficient == ((Term)o).getCoefficient()))
        {
            return true;
        }
        else
        {
            return false;
        }
    }

    protected Object clone()
    {
        return new Term(this.coefficient, this.exponent);
    }

    public String toString()
    {
        String term = "";
        String stringCoefficient = "";
        String stringExponent = "";

        if(coefficient > 0)
        {
            stringCoefficient = "+" + coefficient;
        }
        else if(coefficient < 0)
        {
            stringCoefficient = "" + coefficient;
        }

        if(exponent > 0)
        {
            stringExponent = "" + exponent;
        }
        else if(exponent < 0)
        {
            stringExponent = "" + exponent;
        }

        if(exponent == 0)
        {
            return stringCoefficient + "";
        }
        if(coefficient == 0)
        {
            return "";
        }
        if(coefficient == 1)
        {
            term = term + "+x";
        }
        else if(coefficient == -1)
        {
            term = term + "-x";
        }
        else
        {
            term = stringCoefficient + "x";
        }
        if(exponent == 1)
        {
            return term;
        }
        else
        {
            return term + "^" + stringExponent;
        }
    }

    public int getExponent()
    {
        return exponent;
    }
    public int getCoefficient()
    {
        return coefficient;
    }
    public void setCoefficient(int coefficient)
    {
        this.coefficient = coefficient;
    }
    public void setExponent(int exponent)
    {
        this.exponent = exponent;
    }
    public void setAll(int coefficient, int exponent)
    {
        this.exponent = exponent;
        this.coefficient = coefficient;
    }
}

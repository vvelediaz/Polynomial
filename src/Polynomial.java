import java.util.LinkedList;
import java.util.StringTokenizer;

public class Polynomial
{
    private LinkedList<Term> terms = new LinkedList<Term>();

    public Polynomial(){}
    public Polynomial(Polynomial p)
    {
        for(int i = 0; i < p.getNumTerms(); i++)
        {
            addTerm(new Term(p.getTerm(i)));
        }
    }

    public Polynomial(String polyString)
    {
        polyString = polyString.replaceAll(" ", "");
        StringTokenizer plusTokens = new StringTokenizer(polyString, "+");

        while(plusTokens.hasMoreTokens())
        {
            StringTokenizer minusTokens = new StringTokenizer(plusTokens.nextToken(), "-");
            addTerm(new Term("+" + minusTokens.nextToken()));
            while(minusTokens.hasMoreTokens())
                addTerm(new Term("-" + minusTokens.nextToken()));
        }
    }

    public void addTerm(Term term)
    {
        for(int i = 0; i < terms.size(); i++)
        {
            if(terms.get(i).getExponent() == term.getExponent())
            {
                terms.get(i).setCoefficient(terms.get(i).getCoefficient() + term.getCoefficient());
                return;
            }
            if(terms.get(i).getExponent() < term.getExponent())
            {
                terms.add(i, term);
                return;
            }
        }
        terms.add(term);
    }

    public void add(Polynomial p)
    {
        for(int i = 0; i < p.getNumTerms(); i++)
        {
            this.addTerm(p.getTerm(i));
        }

        for(int i = 0; i < this.getNumTerms(); i++)
        {
            if(this.getTerm(i).getCoefficient() == 0)
            {
                this.terms.remove(i);
            }
        }
    }

    public int getNumTerms()
    {
        return terms.size();
    }

    public Term getTerm(int i)
    {
        return terms.get(i);
    }

    public void clear()
    {
        terms.clear();
    }

    public String toString()
    {
        String polynomial = "";

        for(Term value: terms)
        {
            polynomial += value.toString();
        }

        if (polynomial.isEmpty())
        {
            return "0";
        }
        else
        {
            polynomial = polynomial.substring(1);
            return polynomial;
        }
    }
}

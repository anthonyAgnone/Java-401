public class Fraction
{
	private int numer;
	private int denom;
	public int getNumer()
	{
		return numer;
	}
	public int getDenom()
	{
		return denom;
	}
	public String toString()
	{
		return numer + "/" + denom;
	}
	public void setNumer( int n )
	{
		numer = n;
	}
	public void setDenom( int d )
	{
		if (d!=0)
			denom=d;
		else
		{
			System.out.println("Denominator must not be zero (0).");
		}
	}
	public Fraction(  )
	{
		this( 0, 1 );
	}
	public Fraction( int n )
	{
		this( n, 1 );
	}
	public Fraction( int n, int d )
	{
		int gcd = gcd(n,d); 
		setNumer(n/gcd); 		
		setDenom(d/gcd);
	}
	public Fraction( Fraction other )
	{
		this( other.numer, other.denom );
	}
	public Fraction add(Fraction other) {
		return new Fraction (this.getNumer() * other.getDenom() + this.getDenom() * other.getNumer(),this.getDenom() * other.getDenom());
	}
	public Fraction subtract(Fraction other) {
		return new Fraction (this.getNumer() * other.getDenom() - this.getDenom() * other.getNumer(),this.getDenom() * other.getDenom());
	}
	public Fraction multiply(Fraction other) {
		return new Fraction (this.getNumer()* other.getNumer(), this.getDenom()*other.getDenom());
	}
	public Fraction divide(Fraction other) {
		return new Fraction (this.getNumer()* other.getDenom(), this.getDenom()*other.getNumer());
	}
	public Fraction reciprocal() {
			return new Fraction(this.getDenom(), this.getNumer());
	}
    private int gcd(int n, int d) {
		while (n != d) {
			if (n > d) {
				n = n - d;
			} else {
             d = d - n;
			}
		}
		return n;
	}
}

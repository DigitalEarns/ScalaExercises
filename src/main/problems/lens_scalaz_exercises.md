# An intro to scalaz lens functionality in basic scala code.

To play with immutability we end up having redundant and exhausting lines of code as part of 
instantiating new objects, classes now and then.

Many times, programmers end up having wrong designs and weird code bases once they bring in immutability.
The famous-infamous scalaz provides a solution to this to a very great extent.
(Although, there is no good documentation yet)

Requirement of any functional program is, 
we always have to have a new "version" of the same object even if its a change in only some "part" of it.
(foundation of immutability). How can we do this efficiently?

### Example: 
We have a customer case class

`Customer(name: String, age: Int, job: String, place: String)`

We have one customer

`Customer1: Customer("sujesh", 30, "IT", "India")`

And need the same customer with his age incremented by 1. With immutability in place, and if its a one time process, 
we end up writing.

`Customer1-version1.1: Customer("sujesh", 31, "IT", "India")`

Is this a good approach? (You could also use copy method of case class).
There is nothing wrong with this until and unless you have to deal with more complex
use-cases and repeated definition of the same object, that involve a change in 
only a particular part of it (here it is age of customer1)

So conceptually, the solution here is we should be able to "focus" on a few parts of an object. As you know, we always 
focus on things using "Lens" and hence scalaz has named this particular class  as "Lens" that can focus
on any part of your object and play with them. 

Now its time for you to go and explore Lens and implement below use case.

### Problem:

`case class Customer(name: String, age: Int)` <br />
`case class Stock(name: String, price: Int)` <br />
`case class StockPortFolio(stocks: Map[String, Stock], customer: Customer)` <br />

`val afsal        = Customer("Afsal", 30)` <br />
`val sampleStock1 = Stock("Customer1", 500)` <br />
`val sampleStock2 = Stock("Customer2", 500)` <br />

`val portFolio = StockPortFolio( stocks = Map("Sample1" -> sampleStock1, "Sample2" -> sampleStock2), customer = afsal )`

1. Change the price of the stock “Sample1”  in portfolio from 500 to 9999 ?  Consider type safety and human errors.
2. Define 100 customers whose age increments by 1 (name remains the same). 
3. Or, define 100 StockPortfolios with change in only stock value of Sample1. 

PS: You can try to implement this yourself, and then you can move on to scalaz Lens. Please note that Lens is not the only
solution, as core-scala is powerful enough. This is to bring in the idea of Lens for us to use it in a more complex world.
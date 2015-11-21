# Getting a sense of basic scalaz, its type classes that brings in type safety

Context
Scalaz consist of type classes, which is quite simple to use. 
These are classes that consist of a set of operations that will be accessible 
to other types, which belongs to this type class. 

Eg: `Show` is a type class in scalaz whose functions are available for types such as Int.

### Problems

* **Use case**: Get a proper value for the final comparison <br />
//HINT: Equal type class in scalaz

`val int = 1` <br />
`val string = "1"` <br />
`int == string` <br />

Try out some of operations (available in a typeclass) in scalaz, so that we get a compilation error while 
executing the above use case. The intention is to have a type safe code.

* **Use case**: Re-implement the below code with type safety

`java.lang.Thread() == java.lang.Thread()`

Understand how scalaz operator works for Int, and using the same operator try and compare two 
`java.lang.Thread` instances in a type safe way. You may have to do something more here to make it work without compilation errors

* **Use case**: Bring in compilation error for the below code and avoid uncertainities in your code.<br />
//HINT: Order type class in scalaz.

` if (1 > 2.0) `

* **Use case**: Bring in compilation error while trying to execute the below code base <br />
//HINT: Show type class in scalaz.

`println(new Thread)`

Many times, we end up seeing the classname@some_weird_value while logging your results, and how can we avoid this in your code ?

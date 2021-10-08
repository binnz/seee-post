# Good Stuff

## 1. design-patterns

> Design patterns are typical solutions to common problems in software design. Each pattern is like a blueprint that you can customize to solve a particular design problem in your code.

References:

- [design patterns](https://refactoring.guru/design-patterns)
- [模板方法模式](https://juejin.cn/post/6844903729192255502)
- [Pipeline 设计模式，确定不了解一下？](https://juejin.cn/post/6872493469529538567)

## 2. Go IO

Doing many small writes can hurt performance. Each write is ultimately a syscall and if doing frequently can put burden on the CPU. Devices like disks work better dealing with block-aligned data. To avoid the overhead of many small write operations Golang is shipped with bufio.Writer. Data, instead of going straight to destination (implementing io.Writer interface) are first accumulated inside the buffer and send out when buffer is full.

### io.Reader: Represents an entity from which you can read a stream of bytes( I'm a source you can read sth)

Streaming data directly from a reader is easy. Method Read is designed to be called within a loop where, with each iteration, it reads a chunk of data from the source and places it into buffer p. This loop will continue until the method returns an io.EOF error.

> - When a Read() exhausts available data, a reader may return a non-zero n and err=io.EOF. However, depending on implementation, a reader may choose to return a non-zero n and err = nil at the end of stream. In that case, any subsequent reads must return n=0, err=io.EOF
> - Lastly, a call to Read() that returns n=0 and err=nil does not mean EOF as the next call to Read() may return more data

### io.Writer: Represents an entity to which you can write a stream of bytes (I'm a target you can write sth to)

> - Function io.Copy() makes it easy to stream data from a source reader to a target writer
> - io.Pipe

References:

- [Streaming IO in Go](https://medium.com/learning-the-go-programming-language/streaming-io-in-go-d93507931185)
- [Introduction to bufio package in Golang](https://medium.com/golangspec/introduction-to-bufio-package-in-golang-ad7d1877f762)

## 3.Difference Of os.Exit() and panic() in GO

> - When panic is called, including implicitly for run-time errors such as indexing a slice out of bounds or failing a type assertion, it immediately stops execution of the current function and begins unwinding the stack of the goroutine, running any deferred functions along the way. If that unwinding reaches the top of the goroutine's stack, the program dies.
> - os.Exit is used when you need to abort the program immediately, with no possibility of recovery or running a deferred clean-up statement, and also return an error code

> - Most of the time you won't use panic (you should return an error instead), and you almost never need os.Exit outside of some cases in tests and for quick program termination.

References:

- [https://stackoverflow.com/questions/28472922/when-to-use-os-exit-and-panic](https://stackoverflow.com/questions/28472922/when-to-use-os-exit-and-panic)

## 4. Direct Memory Access

> - Direct memory access (DMA) is a feature of computer systems that allows certain hardware subsystems to access main system memory (random-access memory) independent of the central processing unit (CPU).
> - Direct Memory Access (DMA) transfers the block of data between the memory and peripheral devices of the system, without the participation of the processor. The unit that controls the activity of accessing memory directly is called a DMA controller.

## 5. Sequential Supervised Learning

> [Hidden Markov Model and Naive Bayes relationship](http://www.davidsbatista.net/blog/2017/11/11/HHM_and_Naive_Bayes/)

## 6. Fisher-Yates shuffle algorithm

> [Randomness is hard](https://medium.com/@oldwestaction/randomness-is-hard-e085decbcbb2)

## 7. 从根上理解高性能、高并发

> [从根上理解高性能、高并发](http://www.52im.net/thread-3272-1-1.html)

## 8. KMP

> [KMP Algorithm (String Matching)](https://binary-baba.medium.com/string-matching-kmp-algorithm-27c182efa387)

## 9. Understanding Tensorflow

> [Understanding Tensorflow](https://jacobbuckman.com/2018-06-25-tensorflow-the-confusing-parts-1/#understanding-tensorflow)

## 10. Graph

> [A Gentle Introduction To Graph Theory](https://medium.com/basecs/a-gentle-introduction-to-graph-theory-77969829ead8)

> [From Theory To Practice: Representing Graphs](https://medium.com/basecs/from-theory-to-practice-representing-graphs-cfd782c5be38)

> [Spinning Around In Cycles With Directed Acyclic Graphs](https://medium.com/basecs/spinning-around-in-cycles-with-directed-acyclic-graphs-a233496d4688)

> [Finding The Shortest Path, With A Little Help From Dijkstra](https://medium.com/basecs/finding-the-shortest-path-with-a-little-help-from-dijkstra-613149fbdc8e)

## 11.Encode

> [What Every Programmer Absolutely, Positively Needs To Know About Encodings And Character Sets To Work With Text](https://kunststube.net/encoding/)

## 12.Go routines

In Golang, unlike normal functions, the control does not wait for the Goroutine to finish executing. The Control immediately returns to the next line of the code after a Goroutine call. The main Goroutine (main function is also a Goroutine) should be running for any other Goroutines to run. If the main Goroutine terminates, the program will be terminated and no other Goroutine will run.

The switch between Goroutines happen only at well defined points — when an explicit call is made to the Goruntime scheduler. And those well defined points are:

- Channels send and receive operations, if those operations would block.
- The Go statement, although there is no guarantee that the new Goroutine will be scheduled immediately.
- Blocking syscalls like file and network operations.
- After being stopped for a garbage collection cycle.

Go uses three entities to explain the Goroutine scheduling:

- Processor (P)
- OSThread (M)
- Goroutines (G)

the number of Processor available for Goroutines to run is equal to the GOMAXPROCS, which by default is equal to the number of cores available for that application. The runtime system will create N Processor at the start of the program and stored in an array.

The setmaxthreads function in runtime / debug sets the maximum number of M. If an M is blocked, a new m will be created.

Concurrency is about dealing with lots of things at once. Parallelism is about doing lots of things at once.

> [A complete journey with Goroutines](https://riteeksrivastava.medium.com/a-complete-journey-with-goroutines-8472630c7f5c)

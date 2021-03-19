# seee-design-patterns

## Design patterns are typical solutions to common problems in software design. Each pattern is like a blueprint that you can customize to solve a particular design problem in your code.

## Classification of patterns

## References

https://refactoring.guru/design-patterns

# Post

## 1.Go IO

Doing many small writes can hurt performance. Each write is ultimately a syscall and if doing frequently can put burden on the CPU. Devices like disks work better dealing with block-aligned data. To avoid the overhead of many small write operations Golang is shipped with bufio.Writer. Data, instead of going straight to destination (implementing io.Writer interface) are first accumulated inside the buffer and send out when buffer is full.

### io.Reader: Represents an entity from which you can read a stream of bytes( I'm a source you can read sth)

Streaming data directly from a reader is easy. Method Read is designed to be called within a loop where, with each iteration, it reads a chunk of data from the source and places it into buffer p. This loop will continue until the method returns an io.EOF error.

> - When a Read() exhausts available data, a reader may return a non-zero n and err=io.EOF. However, depending on implementation, a reader may choose to return a non-zero n and err = nil at the end of stream. In that case, any subsequent reads must return n=0, err=io.EOF
> - Lastly, a call to Read() that returns n=0 and err=nil does not mean EOF as the next call to Read() may return more data

### io.Writer: Represents an entity to which you can write a stream of bytes (I'm a target you can write sth to)

> - Function io.Copy() makes it easy to stream data from a source reader to a target writer
> - io.Pipe

### References

[Streaming IO in Go](https://medium.com/learning-the-go-programming-language/streaming-io-in-go-d93507931185)
[Introduction to bufio package in Golang](https://medium.com/golangspec/introduction-to-bufio-package-in-golang-ad7d1877f762)

## 2.Difference Of os.Exit() and panic() in GO

> - When panic is called, including implicitly for run-time errors such as indexing a slice out of bounds or failing a type assertion, it immediately stops execution of the current function and begins unwinding the stack of the goroutine, running any deferred functions along the way. If that unwinding reaches the top of the goroutine's stack, the program dies.
> - os.Exit is used when you need to abort the program immediately, with no possibility of recovery or running a deferred clean-up statement, and also return an error code

> - Most of the time you won't use panic (you should return an error instead), and you almost never need os.Exit outside of some cases in tests and for quick program termination.

### References

[https://stackoverflow.com/questions/28472922/when-to-use-os-exit-and-panic](https://stackoverflow.com/questions/28472922/when-to-use-os-exit-and-panic)

## 3. Direct Memory Access

> - Direct memory access (DMA) is a feature of computer systems that allows certain hardware subsystems to access main system memory (random-access memory) independent of the central processing unit (CPU).
> - Direct Memory Access (DMA) transfers the block of data between the memory and peripheral devices of the system, without the participation of the processor. The unit that controls the activity of accessing memory directly is called a DMA controller.

## Sequential Supervised Learning

> [Hidden Markov Model and Naive Bayes relationship](http://www.davidsbatista.net/blog/2017/11/11/HHM_and_Naive_Bayes/)

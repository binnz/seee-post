# seee-design-patterns

## Design patterns are typical solutions to common problems in software design. Each pattern is like a blueprint that you can customize to solve a particular design problem in your code.

## Classification of patterns

## References

https://refactoring.guru/design-patterns

# Post

## [Go Bufferio](https://medium.com/golangspec/introduction-to-bufio-package-in-golang-ad7d1877f762)

Doing many small writes can hurt performance. Each write is ultimately a syscall and if doing frequently can put burden on the CPU. Devices like disks work better dealing with block-aligned data. To avoid the overhead of many small write operations Golang is shipped with bufio.Writer. Data, instead of going straight to destination (implementing io.Writer interface) are first accumulated inside the buffer and send out when buffer is full.

### io.Reader: Represents an entity from which you can read a stream of bytes( I'm a source you can read sth)

Streaming data directly from a reader is easy. Method Read is designed to be called within a loop where, with each iteration, it reads a chunk of data from the source and places it into buffer p. This loop will continue until the method returns an io.EOF error.

> When a Read() exhausts available data, a reader may return a non-zero n and err=io.EOF. However, depending on implementation, a reader may choose to return a non-zero n and err = nil at the end of stream. In that case, any subsequent reads must return n=0, err=io.EOF
> Lastly, a call to Read() that returns n=0 and err=nil does not mean EOF as the next call to Read() may return more data

### io.Writer: Represents an entity to which you can write a stream of bytes (I'm a target you can write sth to)

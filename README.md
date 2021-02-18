

# seee-design-patterns

## Design patterns are typical solutions to common problems in software design. Each pattern is like a blueprint that you can customize to solve a particular design problem in your code.

## Classification of patterns

# References

https://refactoring.guru/design-patterns

# Post

## [Go Bufferio](https://medium.com/golangspec/introduction-to-bufio-package-in-golang-ad7d1877f762)

Doing many small writes can hurt performance. Each write is ultimately a syscall and if doing frequently can put burden on the CPU. Devices like disks work better dealing with block-aligned data. To avoid the overhead of many small write operations Golang is shipped with bufio.Writer. Data, instead of going straight to destination (implementing io.Writer interface) are first accumulated inside the buffer and send out when buffer is full.

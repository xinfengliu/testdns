FROM 1.18-alpine3.15 AS builder
WORKDIR /
COPY lookup-host.go /
RUN go build -o /testdns /lookup-host.go

FROM alpine:3.15
WORKDIR /
COPY --from=builder /testdns /
ENTRYPOINT ["/testdns"]
CMD ["bing.com"]

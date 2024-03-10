# spring-boot-caffeine-cache-example

## Caffeine Cache with Spring Boot

Caffeine is an open-source, high-performance Java caching library providing high hit rates and excellent concurrency.
This Spring boot tutorial will teach us to configure and work
with [Caffeine cache](https://github.com/ben-manes/caffeine) with simple examples.

### Introduction to Caffeine

Caffeine is the Java 8 successor to ConcurrentLinkedHashMap and Guava’s cache. Caffeine Cache is similar to JDK
ConcurrentMap except that it can be configured to evict entries automatically to constrain its memory footprint.

A cache’s eviction policy tries to predict which entries are most likely to be used again in the near future, thereby
maximizing the hit ratio. Caffeine uses the Window TinyLfu eviction policy.

Caffeine has three strategies for value eviction:

* Size-based: Eviction occurs when the configured size limit of the cache is exceeded. The cache will try to evict
  entries that have not been used recently or very often.
* Time-based: Caffeine provides three approaches to timed eviction

  * Expire After Access: Expires the entry after the specified duration is passed since the last read or write occurs
  * Expire After Write: Expires the entry after the specified duration is passed since the write occurs
  * Expire After: Custom expiry for each entry based on Expiry implementation.

* Reference-based: Caffeine allows to set up the cache to allow the garbage collection of entries, by using weak
  references for keys or values, and soft references for values.

### Difference between @Cacheable and @CachePut

The @Cacheable will be executed only once for the given cache key, and subsequent requests won’t execute the method
until the cache expires or gets flushed.

The @CachePut, on the other hand, does not cause the advised method to be skipped. Rather, it always causes the method
to be invoked and its result to be stored in the associated cache if the condition() and unless() expressions match
accordingly.

### Things todo list

1. Clone this repository: `git clone https://github.com/hendisantika/spring-boot-caffeine-cache-example.git`
2. Navigate to the folder: `cd spring-boot-caffeine-cache-example`
3. Run application: `mvn clean spring-boot:run`

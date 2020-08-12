# Pricing Engine module to calculate price of a cycle

Steps to run the application:
1. Run /pricing-engine/src/main/java/com/pricing/pricingengine/PricingEngineApplication.java as a Java Application, which will start the server of the SpringBoot Application.
2. Run /pricing-engine/src/main/resources/cyclePart.sql in MySQL to create database with dummy values.
3. Hit the URL : http://localhost:9091/calculatePrice from PostMan, along with the request body with below JSON:

{
     "parts" : [
                {
                    "name" : "Saddle",
                    "count" : 4
                },
                {
                    "name" : "Tube",
                    "count" : 4
                },
                {
                    "name" : "Tyre",
                    "count" : 2
                }
            ],
    "dateOfPricing" : "2020-09-04"
}

4. Output will be a Map object containing prices.


# Calculating pricing for 1000 cycles using multithreading and blocking queue using a maximum of 10 threads.

BlockingQueue represents a queue which is thread safe to put elements into, and take elements out of from. In other words, multiple threads can be inserting and taking elements concurrently from a BlockingQueue, without any concurrency issues arising.

A blocking queue blocks when you try to dequeue from it and the queue is empty, or if you try to enqueue items to it and the queue is already full. A thread trying to dequeue from an empty queue is blocked until some other thread inserts an item into the queue. A thread trying to enqueue an item in a full queue is blocked until some other thread makes space in the queue, either by dequeuing one or more items or clearing the queue completely.
The term blocking queue comes from the fact that the BlockingQueue is capable of blocking the threads that try to insert or take elements from the queue.

So, if we get 1000 requests for calculating price of cycles, we can use a blocking queue of size 10 (depending on number of threads), so that, at a particular time, only 10 requests are present in the queue, to be picked up by the threads. Since size of blocking queue is 10, no more requests will be allowed to enter into the queue. Once the requests already present in the queue are picked up, more requests from the pending number of requests can be pushed to the queue.



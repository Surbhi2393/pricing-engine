# Pricing Engine module to calculate price of a cycle

Steps to run the application:
1. Run /pricing-engine/src/main/java/com/pricing/pricingengine/PricingEngineApplication.java as a Java Application, which will start the server of the SpringBoot Application.
2. Hit the URL : http://localhost:9091/calculatePrice from PostMan, along with the request body with below JSON:

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

3. Output will be a Map object containing prices.

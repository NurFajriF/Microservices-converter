# <span style="font-size: 2em;">🌐 Simple Microservices Orchestration System</span>

This project demonstrates a **microservices orchestration system** for temperature and length conversions using **Spring Boot**, **Eureka Service Discovery**, and **LoadBalancerClient**.

---

## ✨ **Features**
- 🌡️ **Temperature Conversion**: Convert between **Celsius**, **Fahrenheit**, and **Kelvin**.
- 📏 **Length Conversion**: Convert between **meters**, **kilometers**, and **centimeters**.
- 🔍 **Service Discovery**: Dynamically discover and load balance between service instances using Eureka.

---

## 🚀 **How to Run the Project**

### **Prerequisites**
1. Install **Java 17** or higher.
2. Install **Maven**.
3. Ensure **Postman** or a similar tool is available for testing.

---

### **Steps to Run**
<ol>
  <li>Clone the repository:
    <pre><code>git clone https://github.com/your-repo/microservices-orchestration.git
cd microservices-orchestration
    </code></pre>
  </li>
  <li>Start the <strong>Discovery Service</strong>:
    <pre><code>cd discovery-service
mvn spring-boot:run
    </code></pre>
  </li>
  <li>Start the <strong>TemperatureService</strong> (two instances on different ports):
    <pre><code>cd temperature-service
mvn spring-boot:run -Dspring-boot.run.arguments=--server.port=8081
mvn spring-boot:run -Dspring-boot.run.arguments=--server.port=8083
    </code></pre>
  </li>
  <li>Start the <strong>LengthService</strong> (two instances on different ports):
    <pre><code>cd length-service
mvn spring-boot:run -Dspring-boot.run.arguments=--server.port=8082
mvn spring-boot:run -Dspring-boot.run.arguments=--server.port=8084
    </code></pre>
  </li>
  <li>Start the <strong>OrchestratorService</strong>:
    <pre><code>cd orchestrator-service
mvn spring-boot:run
    </code></pre>
  </li>
</ol>

---

## 🧪 **Testing the System**
1. Open **Postman** and test the OrchestratorService endpoints:
   - **Temperature Conversion**:
     - **POST**: `http://localhost:8080/converter/convert`
     - **Body**:
       ```json
       {
         "value": 100,
         "fromUnit": "Celsius",
         "toUnit": "Fahrenheit"
       }
       ```

   - **Length Conversion**:
     - **POST**: `http://localhost:8080/converter/convert`
     - **Body**:
       ```json
       {
         "value": 1000,
         "fromUnit": "Meter",
         "toUnit": "Kilometer"
       }
       ```

---

## 📋 **Notes**
- Make sure all services are running and registered in Eureka before testing.
- You can scale services by starting additional instances on different ports.

---

## 🛠️ **Technologies Used**
- **Spring Boot**: Backend framework.
- **Spring Cloud Netflix Eureka**: Service discovery.
- **LoadBalancerClient**: For load balancing between instances.
- **RestTemplate**: For inter-service communication.

---

## 🎯 **Project Structure**
```plaintext
microservices-orchestration/
├── discovery-service/       # Eureka Discovery Service
├── orchestrator-service/    # Orchestrator Service
├── temperature-service/     # Temperature Conversion Service
└── length-service/          # Length Conversion Service

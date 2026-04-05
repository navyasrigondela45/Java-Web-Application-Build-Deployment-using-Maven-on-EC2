# ⚙️ Implementation Guide - Java Maven Project Deployment on EC2

---
## A simple web-based home page that displays a styled, clickable link to my GitHub profile.

## 🖥️ Step 1: Launch EC2 Instance
- Create an EC2 instance (Amazon Linux)
- Connect via Putty/SSH:


---

## 📦 Step 2: Install Required Tools

### Install Java
```
sudo yum install java-17-amazon-corretto -y
```

### Install Maven
```
sudo yum install maven -y
```

### Verify Installation
```
java -version
mvn -v
```

---

## 📁 Step 3: Create Project Directory
```
mkdir proj1
cd proj1
```

---

## 🧱 Step 4: Create Maven Project Structure
```
mkdir -p src/main/java
```

---

## 📄 Step 5: Create Java File
```
cd src/main/java
vi GitHubServer.java
```
- Add Java code for HTTP server

---

## 🔙 Step 6: Navigate to Project Root
```
cd ~/proj1
```

---

## 📄 Step 7: Create pom.xml
```
vi pom.xml
```
- Add Maven configuration with:
  - Compiler plugin
  - JAR plugin (mainClass defined)

---

## 🔨 Step 8: Build Project
```
mvn clean package
```
- Generates JAR file inside `target/`

---

## 🔍 Step 9: Verify JAR Contents
```
jar tf target/github-server-1.0.jar
```
- Ensure `.class` file exists

---

## ▶️ Step 10: Run Application
```
java -jar target/github-server-1.0.jar
```

---

## 🌐 Step 11: Access Application
Open browser:
```
http://<EC2-PUBLIC-IP>:8080
```

---

## 🔓 Step 12: Configure Security Group
- Allow inbound rule:
  - Type: Custom TCP
  - Port: 8080
  - Source: 0.0.0.0/0

---

## 🔄 Step 13: Run in Background
```
nohup java -jar target/github-server-1.0.jar &
```

---

## 📜 Step 14: Check Logs
```
tail -f nohup.out
```

---

## 🛑 Step 15: Stop Application
```
ps -ef | grep java
kill <PID>
```

---

## ✅ Final Output
- Application runs on EC2  
- Accessible via public IP and port  
- Displays UI with GitHub link  

package com.thanmayee.joblisting;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;

import com.thanmayee.joblisting.model.Post;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class SampleDataTest {

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void createSamplePosts() {
        String baseUrl = "http://localhost:" + port + "/post";

        // // Java Developer Position
        // Post javaDev = new Post();
        // javaDev.setProfile("Senior Java Developer");
        // javaDev.setDescription("Looking for an experienced Java developer with strong Spring Boot knowledge");
        // javaDev.setExperience(5);
        // javaDev.setTechnologies(new String[]{"Java", "Spring Boot", "MongoDB", "Docker"});
        // restTemplate.postForObject(baseUrl, javaDev, Post.class);
    
    //     // Frontend Developer Position
    //     Post frontendDev = new Post();
    //     frontendDev.setProfile("Frontend Developer");
    //     frontendDev.setDescription("Seeking a creative frontend developer with React expertise");
    //     frontendDev.setExperience(3);
    //     frontendDev.setTechnologies(new String[]{"React", "JavaScript", "HTML", "CSS", "TypeScript"});
    //     restTemplate.postForObject(baseUrl, frontendDev, Post.class);

    //     // DevOps Engineer Position
    //     Post devOps = new Post();
    //     devOps.setProfile("DevOps Engineer");
    //     devOps.setDescription("Looking for a DevOps engineer with strong cloud experience");
    //     devOps.setExperience(4);
    //     devOps.setTechnologies(new String[]{"AWS", "Docker", "Kubernetes", "Jenkins", "Terraform"});
    //     restTemplate.postForObject(baseUrl, devOps, Post.class);

    //     // Full Stack Developer Position
    //     Post fullStack = new Post();
    //     fullStack.setProfile("Full Stack Developer");
    //     fullStack.setDescription("Seeking a full stack developer with MERN stack experience");
    //     fullStack.setExperience(3);
    //     fullStack.setTechnologies(new String[]{"React", "Node.js", "MongoDB", "Express.js", "JavaScript"});
    //     restTemplate.postForObject(baseUrl, fullStack, Post.class);

    //     // New positions...
    //     createAndPostJob(baseUrl, "Data Scientist",
    //         "Looking for a data scientist with strong ML experience",
    //         4, new String[]{"Python", "TensorFlow", "PyTorch", "SQL", "Pandas"});

    //     createAndPostJob(baseUrl, "Cloud Architect",
    //         "Seeking an experienced cloud architect for multi-cloud solutions",
    //         6, new String[]{"AWS", "Azure", "GCP", "Terraform", "Kubernetes"});

    //     createAndPostJob(baseUrl, "Mobile Developer",
    //         "iOS/Android developer needed for fintech app development",
    //         3, new String[]{"Swift", "Kotlin", "Flutter", "React Native"});

    //     createAndPostJob(baseUrl, "Security Engineer",
    //         "Cybersecurity expert needed for enterprise security",
    //         5, new String[]{"Security+", "CISSP", "Python", "Network Security"});

    //     createAndPostJob(baseUrl, "UI/UX Designer",
    //         "Creative designer needed for web and mobile applications",
    //         2, new String[]{"Figma", "Adobe XD", "Sketch", "InVision"});

    //     createAndPostJob(baseUrl, "Backend Developer",
    //         "Python backend developer with FastAPI experience",
    //         3, new String[]{"Python", "FastAPI", "PostgreSQL", "Redis"});

    //     createAndPostJob(baseUrl, "ML Engineer",
    //         "Machine learning engineer for NLP projects",
    //         4, new String[]{"Python", "BERT", "Transformers", "PyTorch"});

    //     createAndPostJob(baseUrl, "Site Reliability Engineer",
    //         "SRE needed for maintaining high-availability systems",
    //         5, new String[]{"Linux", "Python", "Prometheus", "Grafana"});

    //     createAndPostJob(baseUrl, "Quality Assurance Engineer",
    //         "QA engineer with automation experience",
    //         3, new String[]{"Selenium", "Jest", "Cypress", "JUnit"});

    //     createAndPostJob(baseUrl, "Data Engineer",
    //         "Data engineer for big data pipeline development",
    //         4, new String[]{"Spark", "Hadoop", "Python", "Airflow"});

    //     createAndPostJob(baseUrl, "Blockchain Developer",
    //         "Blockchain developer for DeFi platform",
    //         3, new String[]{"Solidity", "Web3.js", "Ethereum", "Smart Contracts"});

    //     createAndPostJob(baseUrl, "Technical Lead",
    //         "Tech lead for e-commerce platform development",
    //         6, new String[]{"Java", "Spring", "Architecture", "Team Leadership"});

    //     createAndPostJob(baseUrl, "Systems Administrator",
    //         "Linux systems administrator for cloud infrastructure",
    //         4, new String[]{"Linux", "Shell Scripting", "AWS", "Networking"});

    //     createAndPostJob(baseUrl, "Database Administrator",
    //         "Senior DBA for managing large-scale databases",
    //         5, new String[]{"PostgreSQL", "MongoDB", "Redis", "Database Design"});

    //     createAndPostJob(baseUrl, "Product Manager",
    //         "Technical product manager for AI products",
    //         5, new String[]{"Agile", "JIRA", "Product Development", "AI/ML"});

    //     createAndPostJob(baseUrl, "AR/VR Developer",
    //         "Developer for immersive AR/VR experiences",
    //         3, new String[]{"Unity", "C#", "ARKit", "VR Development"});

    //     createAndPostJob(baseUrl, "Embedded Systems Engineer",
    //         "Developer for IoT devices and firmware",
    //         4, new String[]{"C", "C++", "ARM", "RTOS"});

    //     createAndPostJob(baseUrl, "Network Engineer",
    //         "Network engineer for global infrastructure",
    //         5, new String[]{"CCNA", "CCNP", "Network Security", "SDN"});

    //     createAndPostJob(baseUrl, "Game Developer",
    //         "Game developer for mobile gaming studio",
    //         3, new String[]{"Unity", "C#", "3D Graphics", "Game Design"});

    //     createAndPostJob(baseUrl, "Integration Specialist",
    //         "Integration specialist for enterprise systems",
    //         4, new String[]{"API Design", "REST", "GraphQL", "Microservices"});
    }

    private void createAndPostJob(String baseUrl, String profile, String description, 
                                int experience, String[] technologies) {
        Post post = new Post();
        post.setProfile(profile);
        post.setDescription(description);
        post.setExperience(experience);
        post.setTechnologies(technologies);
        restTemplate.postForObject(baseUrl, post, Post.class);
    }
} 
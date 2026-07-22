-- Create the database if it doesn't already exist
CREATE DATABASE IF NOT EXISTS recruitment;

-- Switch to the recruitment database
USE recruitment;

-- Create the candidates table
CREATE TABLE IF NOT EXISTS candidates (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    email VARCHAR(100) UNIQUE NOT NULL,
    skills TEXT,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

-- Create the jobs table
CREATE TABLE IF NOT EXISTS jobs (
    id INT AUTO_INCREMENT PRIMARY KEY,
    title VARCHAR(100) NOT NULL,
    description TEXT,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

-- Insert sample candidates
INSERT INTO candidates (name, email, skills) VALUES 
('Alice Johnson', 'alice@example.com', 'Python, SQL, Flask, Docker'),
('Bob Smith', 'bob@example.com', 'Java, Spring Boot, Hibernate, MySQL'),
('Carol White', 'carol@example.com', 'JavaScript, React, Node.js, MongoDB'),
('David Brown', 'david@example.com', 'DevOps, AWS, Kubernetes, Terraform');

-- Insert sample job postings
INSERT INTO jobs (title, description) VALUES 
('Software Engineer', 'Develop and maintain microservices using Python and Flask. Experience with Docker and CI/CD pipelines is a plus.'),
('Java Developer', 'Design and build enterprise applications with Spring Boot. Strong knowledge of Hibernate and REST APIs required.'),
('DevOps Engineer', 'Manage cloud infrastructure on AWS, automate deployments with Kubernetes, and improve CI/CD workflows.'),
('Frontend Developer', 'Create responsive web applications using React and Redux. Collaborate with backend teams to integrate APIs.');
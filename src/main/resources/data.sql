# IF U deleted table then application shows Sql error table not exist. So comment this file and run then execute this file

-- Dummy User data
INSERT INTO user (id, name, email) VALUES (1, 'Alice Johnson', 'alice@example.com');
INSERT INTO user (id, name, email) VALUES (2, 'Bob Smith', 'bob@example.com');
INSERT INTO user (id, name, email) VALUES (3, 'Charlie Brown', 'charlie@example.com');
INSERT INTO user (id, name, email) VALUES (4, 'Diana Prince', 'diana@example.com');
INSERT INTO user (id, name, email) VALUES (5, 'Ethan Hunt', 'ethan@example.com');

-- Dummy Employer data
INSERT INTO employer (id, company_name, email) VALUES (1, 'TechCorp Solutions', 'hr@techcorp.com');
INSERT INTO employer (id, company_name, email) VALUES (2, 'FinEdge Inc', 'jobs@finedge.com');
INSERT INTO employer (id, company_name, email) VALUES (3, 'CodeBrew', 'careers@codebrew.com');
INSERT INTO employer (id, company_name, email) VALUES (4, 'HealthPlus Systems', 'info@healthplus.com');
INSERT INTO employer (id, company_name, email) VALUES (5, 'EduTech Labs', 'hr@edutech.com');

-- Dummy Job data
INSERT INTO job (id, title, description, location, type, employer_id)
VALUES (1, 'Java Developer', 'Backend developer using Java and Spring Boot.', 'New York', 'Full-time', 1);

INSERT INTO job (id, title, description, location, type, employer_id)
VALUES (2, 'Frontend Engineer', 'Develop UI with React and Tailwind.', 'San Francisco', 'Part-time', 2);

INSERT INTO job (id, title, description, location, type, employer_id)
VALUES (3, 'Data Analyst', 'Analyze trends and visualize data.', 'Chicago', 'Contract', 3);

INSERT INTO job (id, title, description, location, type, employer_id)
VALUES (4, 'DevOps Engineer', 'Setup CI/CD pipelines and infrastructure.', 'Seattle', 'Full-time', 4);

INSERT INTO job (id, title, description, location, type, employer_id)
VALUES (5, 'QA Tester', 'Test applications and write automation scripts.', 'Austin', 'Internship', 5);

-- Dummy Application data
INSERT INTO application (id, applied_date, user_id, job_id) VALUES (1, '2024-10-01', 1, 1);
INSERT INTO application (id, applied_date, user_id, job_id) VALUES (2, '2024-10-02', 2, 1);
INSERT INTO application (id, applied_date, user_id, job_id) VALUES (3, '2024-10-03', 3, 2);
INSERT INTO application (id, applied_date, user_id, job_id) VALUES (4, '2024-10-04', 4, 3);
INSERT INTO application (id, applied_date, user_id, job_id) VALUES (5, '2024-10-05', 5, 4);

select * from user;
select * from employer;
select * from job;
select * from application;
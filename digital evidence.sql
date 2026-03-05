CREATE DATABASE digital_evidence;
USE digital_evidence;
CREATE TABLE evidence (
	evidence_id INT PRIMARY KEY AUTO_INCREMENT,
       case_id VARCHAR(50),
         evidence_name VARCHAR(100),
         description TEXT,
         collected_by VARCHAR(100),
         date_collected DATE,
         status VARCHAR(50)
     );
     desc evidence;
     
     
SELECT * FROM evidence;

SELECT * FROM evidence;
USE digital_evidence;
CREATE TABLE users (
    user_id INT PRIMARY KEY AUTO_INCREMENT,
    username VARCHAR(50) UNIQUE NOT NULL,
    password VARCHAR(100) NOT NULL,
    role VARCHAR(20) NOT NULL
);
INSERT INTO users (username, password, role)
VALUES ('admin', 'admin123', 'ADMIN');
INSERT INTO users (username, password, role)
VALUES ('officer1', 'officer123', 'OFFICER');
INSERT INTO users (username, password, role)
VALUES ('meena', 'meena123', 'OFFICER');
INSERT INTO users (username, password, role)
VALUES ('arjun', 'arjun123', 'OFFICER');
INSERT INTO users (username, password, role)
VALUES ('kiran', 'kiran123', 'OFFICER');
INSERT INTO users (username, password, role)
VALUES ('manswini', 'manswini123', 'OFFICER');
INSERT INTO users (username, password, role)
VALUES ('dev', 'dev123', 'OFFICER');
INSERT INTO users (username, password, role)
VALUES ('sneha', 'sneha123', 'OFFICER');
INSERT INTO users (username, password, role)
VALUES ('ajay', 'ajay123', 'OFFICER');
INSERT INTO users (username, password, role)
VALUES ('kavya', 'kavya123', 'OFFICER');
INSERT INTO users (username, password, role)
VALUES ('rohit', 'rohit123', 'OFFICER');
INSERT INTO users (username, password, role)
VALUES ('pooja', 'pooja123', 'OFFICER');
SELECT * FROM users;
SELECT evidence_id, collected_by FROM evidence;
UPDATE evidence 
SET collected_by = LOWER(TRIM(REPLACE(collected_by,'Officer ','')))
WHERE evidence_id > 0;
SELECT evidence_id, collected_by FROM evidence;
DROP TABLE IF EXISTS evidence;
DROP TABLE IF EXISTS users;
CREATE TABLE users (
    user_id INT PRIMARY KEY AUTO_INCREMENT,
    username VARCHAR(50) UNIQUE NOT NULL,
    password VARCHAR(100) NOT NULL,
    role VARCHAR(20) NOT NULL
);
CREATE TABLE evidence (
    evidence_id INT PRIMARY KEY AUTO_INCREMENT,
    case_id VARCHAR(50) NOT NULL,
    evidence_name VARCHAR(100) NOT NULL,
    description TEXT NOT NULL,
    collected_by VARCHAR(50) NOT NULL,
    date_collected DATE NOT NULL,
    status VARCHAR(50) NOT NULL,
    FOREIGN KEY (collected_by) REFERENCES users(username)
);
DROP TABLE IF EXISTS evidence;
DROP TABLE IF EXISTS users;
CREATE DATABASE digital_evidence;
USE digital_evidence;
CREATE TABLE users (
    user_id INT PRIMARY KEY AUTO_INCREMENT,
    username VARCHAR(50) UNIQUE NOT NULL,
    password VARCHAR(100) NOT NULL,
    role VARCHAR(20) NOT NULL
);
INSERT INTO users (username, password, role) VALUES
('admin', 'admin123', 'ADMIN'),
('meena', 'meena123', 'OFFICER'),
('arjun', 'arjun123', 'OFFICER'),
('kiran', 'kiran123', 'OFFICER'),
('manswini', 'manswini123', 'OFFICER'),
('dev', 'dev123', 'OFFICER'),
('sneha', 'sneha123', 'OFFICER'),
('ajay', 'ajay123', 'OFFICER'),
('kavya', 'kavya123', 'OFFICER'),
('rohit', 'rohit123', 'OFFICER'),
('pooja', 'pooja123', 'OFFICER');
CREATE TABLE evidence (
    evidence_id INT PRIMARY KEY AUTO_INCREMENT,
    case_id VARCHAR(50) NOT NULL,
    evidence_name VARCHAR(100) NOT NULL,
    description TEXT NOT NULL,
    collected_by VARCHAR(50) NOT NULL,
    date_collected DATE NOT NULL,
    status VARCHAR(50) NOT NULL,
    FOREIGN KEY (collected_by) REFERENCES users(username)
);
INSERT INTO evidence (case_id, evidence_name, description, collected_by, date_collected, status) VALUES
('CASE101', 'Fingerprint Sample', 'Fingerprint collected from crime scene door', 'meena', '2026-03-01', 'Collected'),
('CASE102', 'CCTV Footage', 'CCTV footage from bank entrance', 'meena', '2026-03-02', 'Under Investigation'),
('CASE101', 'Blood Sample', 'Blood stain found near window', 'arjun', '2026-03-03', 'Sent to Lab'),
('CASE200', 'Mobile Phone', 'Suspect mobile phone seized from location', 'kiran', '2026-03-04', 'Seized'),
('CASE300', 'Laptop Hard Disk', 'Hard disk sent for forensic data recovery', 'manswini', '2026-03-05', 'Forensic Analysis'),
('CASE400', 'Audio Recording', 'Recorded phone conversation evidence', 'dev', '2026-03-06', 'Reviewed'),
('CASE500', 'Knife', 'Knife recovered from suspect vehicle', 'sneha', '2026-03-07', 'Seized'),
('CASE501', 'USB Drive', 'USB drive containing confidential files', 'ajay', '2026-03-08', 'Under Investigation'),
('CASE502', 'Passport Copy', 'Photocopy of passport found at scene', 'kavya', '2026-03-09', 'Verified'),
('CASE503', 'Gun Powder Residue', 'Residue collected from suspect hands', 'rohit', '2026-03-10', 'Sent to Lab'),
('CASE508', 'DNA Sample', 'DNA sample collected from hair strand', 'pooja', '2026-03-15', 'Sent to Lab');
select * from evidence;

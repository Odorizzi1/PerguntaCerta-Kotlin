CREATE TABLE user_info (
    id INT AUTO_INCREMENT PRIMARY KEY,
    firstName VARCHAR(255) NOT NULL,
    lastName VARCHAR(255) NOT NULL,
    userId INT,
    FOREIGN KEY (userId) REFERENCES user(id)
);
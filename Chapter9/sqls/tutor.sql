CREATE TABLE `Parents` (
  `parent_id` int PRIMARY KEY AUTO_INCREMENT,
  `name_student` varchar(50) NOT NULL,
  `address_parent` varchar(200) NOT NULL,
  `subject` varchar(50) NOT NULL,
  `class` varchar(20) NOT NULL,
  `teaching_time` varchar(50) NOT NULL,
  `school` varchar(100) NOT NULL,
  `phone_parent` varchar(15) UNIQUE NOT NULL,
  `number_lessons_per_week` int NOT NULL COMMENT 'Must be between 1 and 5.',
  `tuition_per_month` int NOT NULL COMMENT 'Must be at least 700000.',
  `commission` int,
  `request_more` varchar(200)
);

CREATE TABLE `tutors` (
  `tutor_id` int PRIMARY KEY AUTO_INCREMENT,
  `name_tutor` varchar(50) NOT NULL,
  `phone_tutor` varchar(15) UNIQUE NOT NULL,
  `email` varchar(100) UNIQUE NOT NULL,
  `address_tutor` varchar(200) NOT NULL,
  `school` varchar(100) NOT NULL,
  `desired_salary_per_lesson` int NOT NULL,
  `status_teacher` tinyint(1) DEFAULT 0,
  `experience` varchar(100)
);

CREATE TABLE `tutor_student` (
  `tutor_id` int,
  `parent_id` int,
  `time_study` timestamp
);

ALTER TABLE `tutors` ADD FOREIGN KEY (`tutor_id`) REFERENCES `tutor_student` (`tutor_id`);

ALTER TABLE `Parents` ADD FOREIGN KEY (`parent_id`) REFERENCES `tutor_student` (`parent_id`);
